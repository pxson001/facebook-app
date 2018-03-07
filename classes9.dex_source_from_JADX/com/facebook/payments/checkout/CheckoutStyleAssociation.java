package com.facebook.payments.checkout;

import com.facebook.inject.Lazy;
import com.facebook.payments.checkout.recyclerview.CheckoutRowViewHolderFactory;
import com.facebook.payments.checkout.recyclerview.CheckoutRowsGenerator;
import com.facebook.payments.checkout.recyclerview.CheckoutSubScreenParamsGenerator;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineHandler;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineOrganizer;
import com.google.common.base.Preconditions;

/* compiled from: ephemeral_dialog */
public class CheckoutStyleAssociation<DATA_LOADER extends CheckoutDataLoader, DATA_MUTATOR extends CheckoutDataMutator, ON_ACTIVITY_RESULT_HANDLER extends CheckoutOnActivityResultHandler, SUB_SCREEN_PARAMS_GENERATOR extends CheckoutSubScreenParamsGenerator, ROWS_GENERATOR extends CheckoutRowsGenerator, SENDER extends CheckoutSender, STATE_MACHINE_ORGANIZER extends CheckoutStateMachineOrganizer, STATE_MACHINE_HANDLER extends CheckoutStateMachineHandler, STYLE_RENDERER extends CheckoutStyleRenderer, ROW_VIEW_HOLDER_FACTORY extends CheckoutRowViewHolderFactory> {
    public final CheckoutStyle f15723a;
    public final Lazy<DATA_LOADER> f15724b;
    public final Lazy<DATA_MUTATOR> f15725c;
    public final Lazy<ON_ACTIVITY_RESULT_HANDLER> f15726d;
    public final Lazy<SUB_SCREEN_PARAMS_GENERATOR> f15727e;
    public final Lazy<ROWS_GENERATOR> f15728f;
    public final Lazy<SENDER> f15729g;
    public final Lazy<STATE_MACHINE_ORGANIZER> f15730h;
    public final Lazy<STATE_MACHINE_HANDLER> f15731i;
    public final Lazy<STYLE_RENDERER> f15732j;
    public final Lazy<ROW_VIEW_HOLDER_FACTORY> f15733k;

    public CheckoutStyleAssociation(CheckoutStyle checkoutStyle, Lazy<DATA_LOADER> lazy, Lazy<DATA_MUTATOR> lazy2, Lazy<ON_ACTIVITY_RESULT_HANDLER> lazy3, Lazy<SUB_SCREEN_PARAMS_GENERATOR> lazy4, Lazy<ROWS_GENERATOR> lazy5, Lazy<SENDER> lazy6, Lazy<STATE_MACHINE_ORGANIZER> lazy7, Lazy<STATE_MACHINE_HANDLER> lazy8, Lazy<STYLE_RENDERER> lazy9, Lazy<ROW_VIEW_HOLDER_FACTORY> lazy10) {
        this.f15723a = (CheckoutStyle) Preconditions.checkNotNull(checkoutStyle);
        this.f15724b = lazy;
        this.f15725c = lazy2;
        this.f15726d = lazy3;
        this.f15727e = lazy4;
        this.f15728f = lazy5;
        this.f15729g = lazy6;
        this.f15730h = lazy7;
        this.f15731i = lazy8;
        this.f15732j = lazy9;
        this.f15733k = lazy10;
    }
}
