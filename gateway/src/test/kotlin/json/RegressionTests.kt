package json

import dev.kord.gateway.Event
import dev.kord.gateway.HeartbeatACK
import dev.kord.gateway.Reconnect
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test

private fun file(name: String): String {
    val loader = SerializationTest::class.java.classLoader
    return loader.getResource("json/regression/$name.json").readText()
}

class RegressionTests {
    @Test
    fun `Resume command serialization`() {
        val event = Json.decodeFromString(Event.Companion, file("eventWithDataThatShouldNotHaveData"))
        event shouldBe Reconnect
    }

}