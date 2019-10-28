package com.caidt

/** 用于定时判断 */
object Tick

/** 通用返回消息ok */
object OkResponse

data class UP(val playerId: PlayerId)

data class Disconnect(val playerId: PlayerId)