package com.caidt

import akka.actor.ActorSystem
import org.hibernate.SessionFactory

enum class Role {
    gate,
    home,
    world,
    ;
}

abstract class GameServer(val port: Long) {

    abstract val role: Role

    lateinit var sessionFactory: SessionFactory
        private set

    lateinit var actorSystem: ActorSystem
        private set

    fun startSessionFactory() {
        sessionFactory = createSessionFactory()
    }

}
