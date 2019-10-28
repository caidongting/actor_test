package com.caidt

import org.hibernate.Session
import org.hibernate.SessionFactory
import java.io.Serializable

interface IEntity {
    fun primaryKey(): Serializable
}


class Session(val sessionFactory: SessionFactory) {

    fun exec(task: (session: Session) -> Any?): Any? {
        val session = sessionFactory.openSession()
        val transaction = session.beginTransaction()
        try {
            val result = task(session)
            transaction.commit()
            return result
        } catch (e: Exception) {
            transaction.rollback()
            throw RuntimeException(e)
        } finally {
            session.close()
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : IEntity> read(clazz: Class<T>, ID: Serializable): T? {
        val x = this.exec { session ->
            session.get(clazz, ID)
        }
        return x as T?
    }
}

