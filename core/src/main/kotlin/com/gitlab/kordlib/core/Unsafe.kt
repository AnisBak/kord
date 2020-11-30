package dev.kord.core

import dev.kord.common.annotation.KordExperimental
import dev.kord.common.annotation.KordUnsafe

import dev.kord.common.entity.Snowflake
import dev.kord.core.behavior.*
import dev.kord.core.behavior.channel.*

/**
 * A class that exposes the creation of `{Entity}Behavior` classes.
 *
 * All functionality in this class *assumes* correct data is being passed along
 * and omits any requirements or checks. This makes using behaviors created by this
 * class inherently unsafe.
 *
 * If the user is not sure of the correctness of the data being passed along, it is advised
 * to use [Entities][dev.kord.core.entity.Entity] generated by [Kord] or other Entities instead.
 */
@KordUnsafe
@KordExperimental
@Suppress("EXPERIMENTAL_API_USAGE")
class Unsafe(private val kord: Kord) {

    fun message(channelId: Snowflake, messageId: Snowflake): MessageBehavior =
            MessageBehavior(channelId = channelId, messageId = messageId, kord = kord)

    fun channel(id: Snowflake): ChannelBehavior =
            ChannelBehavior(id, kord)

    fun messageChannel(id: Snowflake): MessageChannelBehavior =
            MessageChannelBehavior(id, kord)

    fun guildChannel(guildId: Snowflake, id: Snowflake): GuildChannelBehavior =
            GuildChannelBehavior(guildId = guildId, id = id, kord = kord)

    fun guildMessageChannel(guildId: Snowflake, id: Snowflake): GuildMessageChannelBehavior =
            GuildMessageChannelBehavior(guildId = guildId, id = id, kord = kord)

    fun newsChannel(guildId: Snowflake, id: Snowflake): NewsChannelBehavior =
            NewsChannelBehavior(guildId = guildId, id = id, kord = kord)

    fun textChannel(guildId: Snowflake, id: Snowflake): TextChannelBehavior =
            TextChannelBehavior(guildId = guildId, id = id, kord = kord)

    fun voiceChannel(guildId: Snowflake, id: Snowflake): VoiceChannelBehavior =
            VoiceChannelBehavior(guildId = guildId, id = id, kord = kord)

    fun storeChannel(guildId: Snowflake, id: Snowflake): StoreChannelBehavior =
            StoreChannelBehavior(guildId = guildId, id = id, kord = kord)

    fun guild(id: Snowflake): GuildBehavior =
            GuildBehavior(id, kord)

    fun guildEmoji(guildId: Snowflake, id: Snowflake, kord: Kord): GuildEmojiBehavior =
            GuildEmojiBehavior(guildId = guildId, id = id, kord = kord)

    fun role(guildId: Snowflake, id: Snowflake): RoleBehavior =
            RoleBehavior(guildId = guildId, id = id, kord = kord)

    fun user(id: Snowflake): UserBehavior =
            UserBehavior(id, kord)

    fun member(guildId: Snowflake, id: Snowflake): MemberBehavior =
            MemberBehavior(guildId = guildId, id = id, kord = kord)

    fun webhook(id: Snowflake): WebhookBehavior =
            WebhookBehavior(id, kord)

    override fun toString(): String {
        return "Unsafe"
    }

}