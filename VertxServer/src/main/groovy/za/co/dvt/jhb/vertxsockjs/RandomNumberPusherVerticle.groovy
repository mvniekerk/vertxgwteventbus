package za.co.dvt.jhb.vertxsockjs

import io.vertx.core.AbstractVerticle
import io.vertx.ext.web.Router
import io.vertx.ext.web.handler.sockjs.BridgeOptions
import io.vertx.ext.web.handler.sockjs.PermittedOptions
import io.vertx.ext.web.handler.sockjs.SockJSHandler

class RandomNumberPusherVerticle extends AbstractVerticle {
    @Override
    void start() throws Exception {
        def router = Router.router vertx
        def sjs = SockJSHandler.create vertx bridge withBridge, {event ->
            event.complete true
        }
        sjs.socketHandler { ev ->
            ev.headers().add("Access-Control-Allow-Origin", "*")
        }
        router.route "/randomnumber/*" handler sjs

        def port = 9999
        println "Binding to port $port"
        vertx.createHttpServer().requestHandler router.&accept listen port
    }

    static getWithBridge() {
        new BridgeOptions()
            .addOutboundPermitted(new PermittedOptions(address: "randomnumber"))
    }
}
