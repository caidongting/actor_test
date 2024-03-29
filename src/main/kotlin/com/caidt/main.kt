package com.caidt

import akka.actor.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory


class MyActor : AbstractActor() {

    /** 不使用akka actor自带日志系统，使用slf4j */
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    companion object {
        @JvmStatic
        fun props(): Props {
            return Props.create(MyActor::class.java, ::MyActor)
                .withDispatcher("my-dispatcher")
        }
    }

    /**
     * 新的版本后使用[AbstractActor]，原来的[UntypedActor]被废弃，过渡阶段可以使用[UntypedAbstractActor]，
     * [AbstractActor]使用[AbstractActor.createReceive]来处理消息，原来的[UntypedActor.onReceive]不再使用。
     * ps: 新的方法对于java来更容易使用，但对于kotlin来说，无法使用更优雅的when来处理，反而麻烦不少
     */
    override fun createReceive(): Receive {
        return receiveBuilder()
            .match(String::class.java) {
                handle(it)
            }
            .match(Int::class.java) {
                handle(it)
            }
            .build()
    }

    private fun handle(msg: Any) {
        logger.debug("receive msg: $msg")
    }

}

fun main() {
    val actorSystem = ActorSystem.create()
    val actorRef = actorSystem.actorOf(MyActor.props())
    actorRef.tell("test", ActorRef.noSender())
}
