package com.gitlab.kordlib.core.cache.data

import com.gitlab.kordlib.cache.api.data.description
import com.gitlab.kordlib.common.entity.VoiceState
import kotlinx.serialization.Serializable

val VoiceStateData.id get() = "$userId$channelId$guildId"

@Serializable
data class VoiceStateData(
        val guildId: String,
        val channelId: String?,
        val userId: String,
        val sessionId: String,
        val mute: Boolean,
        val deaf: Boolean,
        val selfMute: Boolean,
        val selfDeaf: Boolean,
        val suppress: Boolean
) {

    companion object {
        val description = description(VoiceStateData::id)

        fun from(entity: VoiceState) = with(entity) {
            VoiceStateData(
                    guildId!!,
                    channelId,
                    userId,
                    sessionId,
                    mute,
                    deaf,
                    selfMute,
                    selfDeaf,
                    suppress
            )
        }
    }


}