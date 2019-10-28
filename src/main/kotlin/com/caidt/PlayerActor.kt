package com.caidt

import akka.actor.UntypedAbstractActor
import com.caidt.entity.PlayerAccountEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.Instant


class PlayerActor : UntypedAbstractActor() {

    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    enum class State {
        INIT,
        UP,
        LOADING,
        DOWN,
    }

    val playerId: PlayerId get() = playerAccount.playerId

    private var state: State = State.INIT

    private lateinit var playerAccount: PlayerAccountEntity


    override fun onReceive(message: Any?) {
        when (state) {
            State.INIT -> handleOnInit(message)
            State.UP -> handleOnUp(message)
            State.LOADING -> {
            }
            State.DOWN -> {
            }
        }
    }

    private fun handleOnInit(message: Any?) {
        when (message) {
            is UP -> {
                state = State.LOADING
                load(message.playerId)
                state = State.UP
            }
        }
    }

    /** 启动加载 */
    private fun load(playerId: PlayerId) {
        //TODO()
        logger.info("player: $playerId is up")
    }

    private fun handleOnUp(message: Any?) {
        when (message) {
            Tick -> commonTick(Instant.now())
        }
    }

    /** 处理player常规定时任务 */
    private fun commonTick(now: Instant) {
        //
    }

}
