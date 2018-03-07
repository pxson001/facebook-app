package com.facebook.payments.confirmation;

import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: cachekey */
public class SimpleConfirmationStyleAssociation extends ConfirmationStyleAssociation<SimplePostPurchaseActionHandler, SimpleConfirmationOnActivityResultHandler, SimpleConfirmationRowViewHolderFactory, SimpleConfirmationRowsGenerator> {
    @Inject
    public SimpleConfirmationStyleAssociation(Lazy<SimplePostPurchaseActionHandler> lazy, Lazy<SimpleConfirmationOnActivityResultHandler> lazy2, Lazy<SimpleConfirmationRowViewHolderFactory> lazy3, Lazy<SimpleConfirmationRowsGenerator> lazy4) {
        super(ConfirmationStyle.SIMPLE, lazy, lazy2, lazy3, lazy4);
    }
}
