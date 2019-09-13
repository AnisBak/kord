package com.gitlab.kordlib.core.event

import com.gitlab.kordlib.core.Kord
import com.gitlab.kordlib.core.entity.VoiceState

class VoiceStateUpdateEvent(
        val old: VoiceState?,
        val state: VoiceState
) : Event {
    override val kord: Kord get() = state.kord
}