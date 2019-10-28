package com.caidt

interface ChangeEvent


data class PowerChangeEvent(val power: Long) : ChangeEvent

@AllOpen
@NoArg
class PlayerEvent(
    val playerId: PlayerId,
    val playerLevel: Int,
    val playerExp: Long,
    val playerVip: Int
)