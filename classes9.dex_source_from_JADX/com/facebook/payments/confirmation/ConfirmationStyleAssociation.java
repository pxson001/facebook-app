package com.facebook.payments.confirmation;

import com.facebook.inject.Lazy;
import com.google.common.base.Preconditions;

/* compiled from: en-US */
public class ConfirmationStyleAssociation<POST_PURCHASE_ACTION_HANDLER extends PostPurchaseActionHandler, ON_ACTIVITY_RESULT_HANDLER extends ConfirmationOnActivityResultHandler, ROW_VIEW_HOLDER_FACTORY extends ConfirmationRowViewHolderFactory, ROWS_GENERATOR extends ConfirmationRowsGenerator> {
    public final ConfirmationStyle f15793a;
    public final Lazy<POST_PURCHASE_ACTION_HANDLER> f15794b;
    public final Lazy<ON_ACTIVITY_RESULT_HANDLER> f15795c;
    public final Lazy<ROW_VIEW_HOLDER_FACTORY> f15796d;
    public final Lazy<ROWS_GENERATOR> f15797e;

    public ConfirmationStyleAssociation(ConfirmationStyle confirmationStyle, Lazy<POST_PURCHASE_ACTION_HANDLER> lazy, Lazy<ON_ACTIVITY_RESULT_HANDLER> lazy2, Lazy<ROW_VIEW_HOLDER_FACTORY> lazy3, Lazy<ROWS_GENERATOR> lazy4) {
        this.f15793a = (ConfirmationStyle) Preconditions.checkNotNull(confirmationStyle);
        this.f15794b = lazy;
        this.f15795c = lazy2;
        this.f15796d = lazy3;
        this.f15797e = lazy4;
    }
}
