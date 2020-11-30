package dev.kord.core.entity

import dev.kord.core.supplier.EntitySupplier
import dev.kord.core.supplier.EntitySupplyStrategy

/**
 * A class that will defer the requesting of [Entities][Entity] to a [supplier].
 * Copies of this class with a different [supplier] can be made through [withStrategy].
 *
 * Unless stated otherwise, all members that fetch [Entities][Entity] will delegate to the [supplier].
 */
interface Strategizable {

    /**
     * The supplier used to request entities.
     */
    val supplier: EntitySupplier


    /**
     * Returns a copy of this class with a new [supplier] provided by the [strategy].
     */
    fun withStrategy(strategy: EntitySupplyStrategy<*>) : Strategizable

}