package dev.kord.core.cache.data

import dev.kord.common.entity.*
import dev.kord.common.entity.optional.OptionalBoolean
import kotlinx.serialization.Serializable

@Serializable
data class IntegrationData(
        val id: Snowflake,
        val guildId: Snowflake,
        val name: String,
        val type: String,
        val enabled: Boolean,
        val syncing: Boolean,
        val roleId: Snowflake,
        val enableEmoticons: OptionalBoolean = OptionalBoolean.Missing,
        val expireBehavior: IntegrationExpireBehavior,
        val expireGracePeriod: Int,
        val user: DiscordUser,
        val account: IntegrationsAccountData,
        val syncedAt: String,
        val subscriberCount: Int,
        val revoked: Boolean,
        val application: IntegrationApplication,
) {

    companion object {

        fun from(guildId: Snowflake, response: DiscordIntegration) = with(response) {
            IntegrationData(
                    id,
                    guildId,
                    name,
                    type,
                    enabled,
                    syncing,
                    roleId,
                    enableEmoticons,
                    expireBehavior,
                    expireGracePeriod,
                    user,
                    IntegrationsAccountData.from(account),
                    syncedAt,
                    subscriberCount,
                    revoked,
                    application
            )

        }

    }

}