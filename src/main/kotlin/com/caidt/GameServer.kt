package com.caidt

import akka.actor.ActorSystem
import org.slf4j.Logger
import org.slf4j.LoggerFactory

enum class Role {
    gate,
    home,
    world,
    data,
    ;
}

abstract class GameServer(port: Int) {

    abstract val role: Role

    val logger: Logger = LoggerFactory.getLogger(javaClass)

    /** hibernate */
    lateinit var session: Session
        private set

    /** actor system */
    lateinit var actorSystem: ActorSystem
        private set

    /** netty actor session*/
    private val netty: NettyTcpServer = NettyTcpServer(port = port)


    fun startSessionFactory() {
        val sessionFactory = createSessionFactory()
        session = Session(sessionFactory)
    }

    fun startActorSystem() {

    }

    fun startNetwork() {
        netty.init()
    }
}
