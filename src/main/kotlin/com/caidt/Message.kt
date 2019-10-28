package com.caidt

/** 用于定时判断 */
object Tick

/** 通用返回消息ok */
object OkResponse

open class PlayerMessage {
    open var playerId: PlayerId = 0
}

data class UP(override var playerId: PlayerId) : PlayerMessage()

data class Disconnect(override var playerId: PlayerId) : PlayerMessage()