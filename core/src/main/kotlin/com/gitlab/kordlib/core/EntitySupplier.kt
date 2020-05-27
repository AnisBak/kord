package com.gitlab.kordlib.core

import com.gitlab.kordlib.common.entity.Snowflake
import com.gitlab.kordlib.core.entity.*
import com.gitlab.kordlib.core.entity.channel.Channel
import com.gitlab.kordlib.core.entity.channel.GuildChannel
import kotlinx.coroutines.flow.Flow

interface EntitySupplier {
    val guilds: Flow<Guild>

    val regions: Flow<Region>


    suspend fun getGuild(id: Snowflake): Guild?

    suspend fun getChannel(id: Snowflake): Channel?

    fun getGuildChannels(guildId: Snowflake): Flow<GuildChannel>

    fun getChannelPins(channelId: Snowflake): Flow<Message>

    suspend fun getMember(guildId: Snowflake, userId: Snowflake): Member?

    suspend fun getMessage(channelId: Snowflake, messageId: Snowflake): Message?

    fun getMessagesAfter(messageId: Snowflake, channelId: Snowflake, limit: Int = Int.MAX_VALUE): Flow<Message>

    fun getMessagesBefore(messageId: Snowflake, channelId: Snowflake, limit: Int = Int.MAX_VALUE): Flow<Message>

    fun getMessagesAround(messageId: Snowflake, channelId: Snowflake, limit: Int = Int.MAX_VALUE): Flow<Message>

    suspend fun getSelf(): User?

    suspend fun getUser(id: Snowflake): User?

    suspend fun getCurrentUser(): User?

    suspend fun getRole(guildId: Snowflake, roleId: Snowflake): Role?

    fun getGuildRoles(guildId: Snowflake): Flow<Role>

    suspend fun getGuildBan(guildId: Snowflake, userId: Snowflake): Ban?

    fun getGuildBans(guildId: Snowflake): Flow<Ban>

    fun getGuildMembers(guildId: Snowflake, limit: Int = 1): Flow<Member>

     fun getGuildVoiceRegions(guildId: Snowflake): Flow<Region>

    suspend fun getEmoji(guildId: Snowflake, emojiId: Snowflake): GuildEmoji?

    fun getEmojis(guildId: Snowflake): Flow<GuildEmoji>

    fun getCurrentUserGuilds(limit: Int = Int.MAX_VALUE): Flow<Guild>

    fun getChannelWebhooks(channelId: Snowflake): Flow<Webhook>

    fun getGuildWebhooks(guildId: Snowflake): Flow<Webhook>

    suspend fun getWebhook(webhookId: Snowflake): Webhook?

    suspend fun getWebhookWithToken(webhookId: Snowflake, token: String): Webhook?
}

@Suppress("EXTENSION_SHADOWED_BY_MEMBER")
suspend inline fun <reified T : Channel> EntitySupplier.getChannel(id: Snowflake) = getChannel(id) as? T
