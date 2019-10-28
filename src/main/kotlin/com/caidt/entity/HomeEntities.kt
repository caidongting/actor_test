@file:Suppress("JpaObjectClassSignatureInspection")

package com.caidt.entity

import com.caidt.IEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

interface PlayerEntity : IEntity {
    val playerId: Long
}


@Entity
@Table(name = "player_account")
data class PlayerAccountEntity(
    @Id
    @Column(name = "player_id")
    override var playerId: Long,

    @Column(name = "name")
    var name: String
) : PlayerEntity {
    override fun primaryKey(): Any {
        return this.playerId
    }
}
