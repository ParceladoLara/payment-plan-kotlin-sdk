package com.parceladolara.paymentplan

// Import the generated uniffi bindings
// Note: You need to ensure the generated Kotlin files are in the classpath
// The uniffi-bindgen generates the files in sdks/kotlin/_internal/uniffi/payment_plan_uniffi/
import com.parceladolara.paymentplan.internal.NativeLibraryLoader
import com.parceladolara.paymentplan.internal.payment_plan_uniffi.calculateDownPaymentPlan as internalCalculateDownPaymentPlan
import com.parceladolara.paymentplan.internal.payment_plan_uniffi.calculatePaymentPlan as internalCalculatePaymentPlan
import com.parceladolara.paymentplan.internal.payment_plan_uniffi.disbursementDateRange as internalDisbursementDateRange
import com.parceladolara.paymentplan.internal.payment_plan_uniffi.getNonBusinessDaysBetween as internalGetNonBusinessDaysBetween
import com.parceladolara.paymentplan.internal.payment_plan_uniffi.nextDisbursementDate as internalNextDisbursementDate
import java.time.Instant

/** Re-exported classes for public API */

/** Represents an invoice with payment details and due date information. */
data class Invoice(
        val accumulatedDays: Long,
        val factor: Double,
        val accumulatedFactor: Double,
        val dueDate: Instant
) {
    companion object {
        internal fun fromInternal(
                internal: com.parceladolara.paymentplan.internal.payment_plan_uniffi.Invoice
        ): Invoice {
            return Invoice(
                    accumulatedDays = internal.accumulatedDays,
                    factor = internal.factor,
                    accumulatedFactor = internal.accumulatedFactor,
                    dueDate = internal.dueDate
            )
        }
    }

    internal fun toInternal(): com.parceladolara.paymentplan.internal.payment_plan_uniffi.Invoice {
        return com.parceladolara.paymentplan.internal.payment_plan_uniffi.Invoice(
                accumulatedDays = this.accumulatedDays,
                factor = this.factor,
                accumulatedFactor = this.accumulatedFactor,
                dueDate = this.dueDate
        )
    }
}

/** Parameters for calculating payment plans. */
data class Params(
        val requestedAmount: Double,
        val firstPaymentDate: Instant,
        val disbursementDate: Instant,
        val installments: UInt,
        val debitServicePercentage: UShort,
        val mdr: Double,
        val tacPercentage: Double,
        val iofOverall: Double,
        val iofPercentage: Double,
        val interestRate: Double,
        val minInstallmentAmount: Double,
        val maxTotalAmount: Double,
        val disbursementOnlyOnBusinessDays: Boolean
) {
    companion object {
        internal fun fromInternal(
                internal: com.parceladolara.paymentplan.internal.payment_plan_uniffi.Params
        ): Params {
            return Params(
                    requestedAmount = internal.requestedAmount,
                    firstPaymentDate = internal.firstPaymentDate,
                    disbursementDate = internal.disbursementDate,
                    installments = internal.installments,
                    debitServicePercentage = internal.debitServicePercentage,
                    mdr = internal.mdr,
                    tacPercentage = internal.tacPercentage,
                    iofOverall = internal.iofOverall,
                    iofPercentage = internal.iofPercentage,
                    interestRate = internal.interestRate,
                    minInstallmentAmount = internal.minInstallmentAmount,
                    maxTotalAmount = internal.maxTotalAmount,
                    disbursementOnlyOnBusinessDays = internal.disbursementOnlyOnBusinessDays
            )
        }
    }

    internal fun toInternal(): com.parceladolara.paymentplan.internal.payment_plan_uniffi.Params {
        return com.parceladolara.paymentplan.internal.payment_plan_uniffi.Params(
                requestedAmount = this.requestedAmount,
                firstPaymentDate = this.firstPaymentDate,
                disbursementDate = this.disbursementDate,
                installments = this.installments,
                debitServicePercentage = this.debitServicePercentage,
                mdr = this.mdr,
                tacPercentage = this.tacPercentage,
                iofOverall = this.iofOverall,
                iofPercentage = this.iofPercentage,
                interestRate = this.interestRate,
                minInstallmentAmount = this.minInstallmentAmount,
                maxTotalAmount = this.maxTotalAmount,
                disbursementOnlyOnBusinessDays = this.disbursementOnlyOnBusinessDays
        )
    }
}

/** Represents a payment plan response with detailed calculation results. */
data class Response(
        val installment: UInt,
        val dueDate: Instant,
        val disbursementDate: Instant,
        val accumulatedDays: Long,
        val daysIndex: Double,
        val accumulatedDaysIndex: Double,
        val interestRate: Double,
        val installmentAmount: Double,
        val installmentAmountWithoutTac: Double,
        val totalAmount: Double,
        val debitService: Double,
        val customerDebitServiceAmount: Double,
        val customerAmount: Double,
        val calculationBasisForEffectiveInterestRate: Double,
        val merchantDebitServiceAmount: Double,
        val merchantTotalAmount: Double,
        val settledToMerchant: Double,
        val mdrAmount: Double,
        val effectiveInterestRate: Double,
        val totalEffectiveCost: Double,
        val eirYearly: Double,
        val tecYearly: Double,
        val eirMonthly: Double,
        val tecMonthly: Double,
        val totalIof: Double,
        val contractAmount: Double,
        val contractAmountWithoutTac: Double,
        val tacAmount: Double,
        val iofPercentage: Double,
        val overallIof: Double,
        val preDisbursementAmount: Double,
        val paidTotalIof: Double,
        val paidContractAmount: Double,
        val invoices: List<Invoice>
) {
    companion object {
        internal fun fromInternal(
                internal: com.parceladolara.paymentplan.internal.payment_plan_uniffi.Response
        ): Response {
            return Response(
                    installment = internal.installment,
                    dueDate = internal.dueDate,
                    disbursementDate = internal.disbursementDate,
                    accumulatedDays = internal.accumulatedDays,
                    daysIndex = internal.daysIndex,
                    accumulatedDaysIndex = internal.accumulatedDaysIndex,
                    interestRate = internal.interestRate,
                    installmentAmount = internal.installmentAmount,
                    installmentAmountWithoutTac = internal.installmentAmountWithoutTac,
                    totalAmount = internal.totalAmount,
                    debitService = internal.debitService,
                    customerDebitServiceAmount = internal.customerDebitServiceAmount,
                    customerAmount = internal.customerAmount,
                    calculationBasisForEffectiveInterestRate =
                            internal.calculationBasisForEffectiveInterestRate,
                    merchantDebitServiceAmount = internal.merchantDebitServiceAmount,
                    merchantTotalAmount = internal.merchantTotalAmount,
                    settledToMerchant = internal.settledToMerchant,
                    mdrAmount = internal.mdrAmount,
                    effectiveInterestRate = internal.effectiveInterestRate,
                    totalEffectiveCost = internal.totalEffectiveCost,
                    eirYearly = internal.eirYearly,
                    tecYearly = internal.tecYearly,
                    eirMonthly = internal.eirMonthly,
                    tecMonthly = internal.tecMonthly,
                    totalIof = internal.totalIof,
                    contractAmount = internal.contractAmount,
                    contractAmountWithoutTac = internal.contractAmountWithoutTac,
                    tacAmount = internal.tacAmount,
                    iofPercentage = internal.iofPercentage,
                    overallIof = internal.overallIof,
                    preDisbursementAmount = internal.preDisbursementAmount,
                    paidTotalIof = internal.paidTotalIof,
                    paidContractAmount = internal.paidContractAmount,
                    invoices = internal.invoices.map { Invoice.fromInternal(it) }
            )
        }
    }

    internal fun toInternal(): com.parceladolara.paymentplan.internal.payment_plan_uniffi.Response {
        return com.parceladolara.paymentplan.internal.payment_plan_uniffi.Response(
                installment = this.installment,
                dueDate = this.dueDate,
                disbursementDate = this.disbursementDate,
                accumulatedDays = this.accumulatedDays,
                daysIndex = this.daysIndex,
                accumulatedDaysIndex = this.accumulatedDaysIndex,
                interestRate = this.interestRate,
                installmentAmount = this.installmentAmount,
                installmentAmountWithoutTac = this.installmentAmountWithoutTac,
                totalAmount = this.totalAmount,
                debitService = this.debitService,
                customerDebitServiceAmount = this.customerDebitServiceAmount,
                customerAmount = this.customerAmount,
                calculationBasisForEffectiveInterestRate =
                        this.calculationBasisForEffectiveInterestRate,
                merchantDebitServiceAmount = this.merchantDebitServiceAmount,
                merchantTotalAmount = this.merchantTotalAmount,
                settledToMerchant = this.settledToMerchant,
                mdrAmount = this.mdrAmount,
                effectiveInterestRate = this.effectiveInterestRate,
                totalEffectiveCost = this.totalEffectiveCost,
                eirYearly = this.eirYearly,
                tecYearly = this.tecYearly,
                eirMonthly = this.eirMonthly,
                tecMonthly = this.tecMonthly,
                totalIof = this.totalIof,
                contractAmount = this.contractAmount,
                contractAmountWithoutTac = this.contractAmountWithoutTac,
                tacAmount = this.tacAmount,
                iofPercentage = this.iofPercentage,
                overallIof = this.overallIof,
                preDisbursementAmount = this.preDisbursementAmount,
                paidTotalIof = this.paidTotalIof,
                paidContractAmount = this.paidContractAmount,
                invoices = this.invoices.map { it.toInternal() }
        )
    }
}

/** Parameters for calculating down payment plans. */
data class DownPaymentParams(
        val params: Params,
        val requestedAmount: Double,
        val minInstallmentAmount: Double,
        val firstPaymentDate: Instant,
        val installments: UInt
) {
    companion object {
        internal fun fromInternal(
                internal:
                        com.parceladolara.paymentplan.internal.payment_plan_uniffi.DownPaymentParams
        ): DownPaymentParams {
            return DownPaymentParams(
                    params = Params.fromInternal(internal.params),
                    requestedAmount = internal.requestedAmount,
                    minInstallmentAmount = internal.minInstallmentAmount,
                    firstPaymentDate = internal.firstPaymentDate,
                    installments = internal.installments
            )
        }
    }

    internal fun toInternal():
            com.parceladolara.paymentplan.internal.payment_plan_uniffi.DownPaymentParams {
        return com.parceladolara.paymentplan.internal.payment_plan_uniffi.DownPaymentParams(
                params = this.params.toInternal(),
                requestedAmount = this.requestedAmount,
                minInstallmentAmount = this.minInstallmentAmount,
                firstPaymentDate = this.firstPaymentDate,
                installments = this.installments
        )
    }
}

/** Response for down payment plan calculations. */
data class DownPaymentResponse(
        val installmentAmount: Double,
        val totalAmount: Double,
        val installmentQuantity: UInt,
        val firstPaymentDate: Instant,
        val plans: List<Response>
) {
    companion object {
        internal fun fromInternal(
                internal:
                        com.parceladolara.paymentplan.internal.payment_plan_uniffi.DownPaymentResponse
        ): DownPaymentResponse {
            return DownPaymentResponse(
                    installmentAmount = internal.installmentAmount,
                    totalAmount = internal.totalAmount,
                    installmentQuantity = internal.installmentQuantity,
                    firstPaymentDate = internal.firstPaymentDate,
                    plans = internal.plans.map { Response.fromInternal(it) }
            )
        }
    }

    internal fun toInternal():
            com.parceladolara.paymentplan.internal.payment_plan_uniffi.DownPaymentResponse {
        return com.parceladolara.paymentplan.internal.payment_plan_uniffi.DownPaymentResponse(
                installmentAmount = this.installmentAmount,
                totalAmount = this.totalAmount,
                installmentQuantity = this.installmentQuantity,
                firstPaymentDate = this.firstPaymentDate,
                plans = this.plans.map { it.toInternal() }
        )
    }
}

/** Exceptions that can be thrown by the payment plan calculations. */
sealed class PaymentPlanException : Exception() {

    /** Thrown when invalid parameters are provided to the calculation functions. */
    class InvalidParams(message: String = "Invalid parameters provided") : PaymentPlanException() {
        override val message: String = message
    }

    /** Thrown when an error occurs during payment plan calculation. */
    class CalculationException(message: String = "Error occurred during calculation") :
            PaymentPlanException() {
        override val message: String = message
    }

    companion object {
        internal fun fromInternal(
                internal: com.parceladolara.paymentplan.internal.payment_plan_uniffi.Exception
        ): PaymentPlanException {
            return when (internal) {
                is com.parceladolara.paymentplan.internal.payment_plan_uniffi.Exception.InvalidParams ->
                        InvalidParams(internal.message.ifEmpty { "Invalid parameters provided" })
                is com.parceladolara.paymentplan.internal.payment_plan_uniffi.Exception.CalculationException ->
                        CalculationException(
                                internal.message.ifEmpty { "Error occurred during calculation" }
                        )
            }
        }
    }
}

/**
 * PaymentPlan SDK for Kotlin
 *
 * This SDK provides a wrapper around the payment plan calculation engine. It exposes five main
 * methods for calculating payment plans and working with disbursement dates.
 */
object PaymentPlan {

    init {

        // Load the native library when the object is first accessed
        try {
            NativeLibraryLoader.loadLibrary()
        } catch (e: Exception) {
            throw RuntimeException("Failed to initialize PaymentPlan SDK: ${e.message}", e)
        }
    }

    /**
     * Calculates a payment plan based on the provided parameters.
     *
     * @param params The parameters for calculating the payment plan
     * @return A list of Response objects representing the payment plan
     * @throws PaymentPlanException if the calculation fails
     */
    @JvmStatic
    @Throws(PaymentPlanException::class)
    fun calculatePaymentPlan(params: Params): List<Response> {
        return try {
            val internalResult = internalCalculatePaymentPlan(params.toInternal())
            internalResult.map { Response.fromInternal(it) }
        } catch (e: com.parceladolara.paymentplan.internal.payment_plan_uniffi.Exception) {
            throw PaymentPlanException.fromInternal(e)
        }
    }

    /**
     * Calculates a down payment plan based on the provided parameters.
     *
     * @param params The parameters for calculating the down payment plan
     * @return A list of DownPaymentResponse objects representing the down payment plan
     * @throws PaymentPlanException if the calculation fails
     */
    @JvmStatic
    @Throws(PaymentPlanException::class)
    fun calculateDownPaymentPlan(params: DownPaymentParams): List<DownPaymentResponse> {
        return try {
            val internalResult = internalCalculateDownPaymentPlan(params.toInternal())
            internalResult.map { DownPaymentResponse.fromInternal(it) }
        } catch (e: com.parceladolara.paymentplan.internal.payment_plan_uniffi.Exception) {
            throw PaymentPlanException.fromInternal(e)
        }
    }

    /**
     * Calculates the next disbursement date based on the given base date.
     *
     * This function assumes disbursement dates on business days only. This function also assumes
     * that the disbursement day can't occur on the same day as the system date, so in this case +1
     * day is added no matter what. Base dates in the past are allowed, for debugging purposes, but
     * keep the rule of not being the same day in mind.
     *
     * @param baseDate The base date to calculate the next disbursement date
     * @return The next disbursement date
     */
    @JvmStatic
    fun nextDisbursementDate(baseDate: Instant): Instant {
        return internalNextDisbursementDate(baseDate)
    }

    /**
     * Calculates and returns (start, end) disbursement dates based on the given base date and
     * number of days.
     *
     * The start date is the next disbursement date and the end date is the end of a range that fits
     * the number of business days. For example:
     * ```
     *     baseDate = "2025-04-03"
     *     days = 5
     *     start = "2025-04-03" (assuming that the call was not made on "2025-04-03")
     *     end = "2025-04-09"
     * ```
     * This range fits 5 business days: 2025-04-03, 2025-04-04, 2025-04-07, 2025-04-08, and
     * 2025-04-09.
     *
     * This function assumes disbursement dates on business days only. This function also assumes
     * that the disbursement day can't occur on the same day as the system date, so in this case +1
     * day is added no matter what. Base dates in the past are allowed, for debugging purposes, but
     * keep the rule of not being the same day in mind.
     *
     * @param baseDate The base date to calculate the disbursement date range
     * @param days The number of business days in the range
     * @return A Pair containing the start and end disbursement dates
     */
    @JvmStatic
    fun disbursementDateRange(baseDate: Instant, days: UInt): Pair<Instant, Instant> {
        val result = internalDisbursementDateRange(baseDate, days)
        return Pair(result[0], result[1])
    }

    /**
     * Returns a list of non-business days between the given start and end dates.
     *
     * Both start and end dates are inclusive.
     *
     * This function assumes disbursement dates on business days only.
     *
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A list of non-business days within the range
     */
    @JvmStatic
    fun getNonBusinessDaysBetween(startDate: Instant, endDate: Instant): List<Instant> {
        return internalGetNonBusinessDaysBetween(startDate, endDate)
    }
}
