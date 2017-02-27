package za.co.dvt.jhb.vertxsockjs

import io.vertx.core.Vertx
import io.vertx.core.eventbus.Message

class VertxSockJsServer {
    static void main(args) {

        def v = Vertx.vertx()
        v.deployVerticle new RandomNumberPusherVerticle(), {
            println "Deployed"
        }

        v.setPeriodic 1000, { id ->
            v.eventBus().publish "randomnumber", new Random().nextInt()
        }

        v.eventBus().consumer "randomnumber", { Message<Integer> s ->
            println "Next number ${s.body()}"
        }
    }
}
