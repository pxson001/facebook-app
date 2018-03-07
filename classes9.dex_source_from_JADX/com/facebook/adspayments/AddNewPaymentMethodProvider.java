package com.facebook.adspayments;

import android.support.v4.app.FragmentManager;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: Unexpected exception thrown by generated accessor method. */
public class AddNewPaymentMethodProvider extends AbstractAssistedProvider<AddNewPaymentMethod> {
    public final AddNewPaymentMethod m25337a(FragmentManager fragmentManager) {
        return new AddNewPaymentMethod(fragmentManager, GraphQLQueryExecutor.a(this), PaymentsLogger.m3873a((InjectorLike) this));
    }
}
