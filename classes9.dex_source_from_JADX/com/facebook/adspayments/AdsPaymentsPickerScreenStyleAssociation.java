package com.facebook.adspayments;

import com.facebook.inject.Lazy;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsPickerScreenStyleRenderer;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleAssociation;
import javax.inject.Inject;

/* compiled from: Unable to retrieve the object file. */
public class AdsPaymentsPickerScreenStyleAssociation extends PickerScreenStyleAssociation<PaymentMethodsPickerScreenStyleRenderer, AdsPaymentsPickerScreenDataFetcher, AdsPaymentsSectionOrganizer, AdsPaymentsSimpleRowItemsGenerator, AdsPaymentsPickerScreenOnActivityResultHandler, AdsPaymentsPickerScreenDataMutator, AdsPaymentsPickerScreenSubScreenParamsGenerator, AdsPaymentsRowItemViewFactory> {
    @Inject
    public AdsPaymentsPickerScreenStyleAssociation(Lazy<PaymentMethodsPickerScreenStyleRenderer> lazy, Lazy<AdsPaymentsPickerScreenDataFetcher> lazy2, Lazy<AdsPaymentsSectionOrganizer> lazy3, Lazy<AdsPaymentsSimpleRowItemsGenerator> lazy4, Lazy<AdsPaymentsPickerScreenOnActivityResultHandler> lazy5, Lazy<AdsPaymentsPickerScreenDataMutator> lazy6, Lazy<AdsPaymentsPickerScreenSubScreenParamsGenerator> lazy7, Lazy<AdsPaymentsRowItemViewFactory> lazy8) {
        super(PickerScreenStyle.ADS_PAYMENTS, lazy, lazy2, lazy3, lazy4, lazy5, lazy6, lazy7, lazy8);
    }
}
