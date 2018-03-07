package com.facebook.messaging.payment.value.input.pagescommerce;

import com.facebook.inject.Lazy;
import com.facebook.payments.confirmation.ConfirmationStyle;
import com.facebook.payments.confirmation.ConfirmationStyleAssociation;
import com.facebook.payments.confirmation.SimpleConfirmationOnActivityResultHandler;
import com.facebook.payments.confirmation.SimpleConfirmationRowViewHolderFactory;
import com.facebook.payments.confirmation.SimpleConfirmationRowsGenerator;
import javax.inject.Inject;

/* compiled from: empty thread */
public class PagesCommerceConfirmationStyleAssociation extends ConfirmationStyleAssociation<PagesCommercePostPurchaseActionHandler, SimpleConfirmationOnActivityResultHandler, SimpleConfirmationRowViewHolderFactory, SimpleConfirmationRowsGenerator> {
    @Inject
    public PagesCommerceConfirmationStyleAssociation(Lazy<PagesCommercePostPurchaseActionHandler> lazy, Lazy<SimpleConfirmationOnActivityResultHandler> lazy2, Lazy<SimpleConfirmationRowViewHolderFactory> lazy3, Lazy<SimpleConfirmationRowsGenerator> lazy4) {
        super(ConfirmationStyle.PAGES_COMMERCE, lazy, lazy2, lazy3, lazy4);
    }
}
