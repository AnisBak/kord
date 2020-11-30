package dev.kord.core.entity

import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.KordObject
import dev.kord.core.cache.data.ReactionData
import dev.kord.core.toSnowflakeOrNull

/**
 * An instance of a [Discord Reaction](https://discord.com/developers/docs/resources/channel#reaction-object).
 */
class Reaction(val data: ReactionData, override val kord: Kord) : KordObject {

    val id: Snowflake? get() = data.emojiId

    /**
     * The amount of users that reacted this emoji to the message.
     */
    val count: Int get() = data.count

    /**
     * Whether the current user reacted to the message with this emoji.
     */
    val selfReacted: Boolean get() = data.me

    /**
     * The emoji of this reaction.
     */
    val emoji: ReactionEmoji
        get() = when (data.emojiId) {
            null -> ReactionEmoji.Unicode(data.emojiName!!)
            else -> ReactionEmoji.Custom(data.emojiId, data.emojiName ?: "", data.emojiAnimated)
        }

    /**
     * Whether the emoji is animated.
     */
    val isAnimated: Boolean get() = data.emojiAnimated

    override fun toString(): String {
        return "Reaction(data=$data, kord=$kord)"
    }

}