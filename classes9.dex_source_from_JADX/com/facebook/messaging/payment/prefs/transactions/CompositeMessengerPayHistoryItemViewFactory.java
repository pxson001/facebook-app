package com.facebook.messaging.payment.prefs.transactions;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLModels.PaymentRequestModel;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.util.date.MessagingDateUtil;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: gametime_match_entry */
public class CompositeMessengerPayHistoryItemViewFactory implements MessengerPayHistoryItemViewFactory {
    public final OrionMessengerPayHistoryItemViewFactory f14313a;
    public final OrionRequestMessengerPayHistoryItemViewFactory f14314b;
    public final MPMessengerPayHistoryItemViewFactory f14315c;
    public MessengerPayHistoryItemViewFactory f14316d;

    public static CompositeMessengerPayHistoryItemViewFactory m14724b(InjectorLike injectorLike) {
        return new CompositeMessengerPayHistoryItemViewFactory(new OrionMessengerPayHistoryItemViewFactory(LayoutInflaterMethodAutoProvider.b(injectorLike), new OrionMessengerPayHistoryItemViewParamsFactory(ResourcesMethodAutoProvider.a(injectorLike), MessagingDateUtil.a(injectorLike), PaymentTransactionUtil.m15519a(injectorLike))), OrionRequestMessengerPayHistoryItemViewFactory.m14780b(injectorLike), MPMessengerPayHistoryItemViewFactory.m14726b(injectorLike));
    }

    @Inject
    public CompositeMessengerPayHistoryItemViewFactory(OrionMessengerPayHistoryItemViewFactory orionMessengerPayHistoryItemViewFactory, OrionRequestMessengerPayHistoryItemViewFactory orionRequestMessengerPayHistoryItemViewFactory, MPMessengerPayHistoryItemViewFactory mPMessengerPayHistoryItemViewFactory) {
        this.f14313a = orionMessengerPayHistoryItemViewFactory;
        this.f14314b = orionRequestMessengerPayHistoryItemViewFactory;
        this.f14315c = mPMessengerPayHistoryItemViewFactory;
    }

    public final MessengerPayHistoryItemView mo562a(Object obj, View view, ViewGroup viewGroup) {
        boolean z = false;
        boolean z2 = (obj instanceof PaymentTransaction) || (obj instanceof PaymentRequestModel);
        Preconditions.checkArgument(z2);
        if ((obj instanceof PaymentTransaction) && ((PaymentTransaction) obj).f13241n != null) {
            this.f14316d = this.f14315c;
        } else if (obj instanceof PaymentRequestModel) {
            this.f14316d = this.f14314b;
        } else {
            this.f14316d = this.f14313a;
        }
        MessengerPayHistoryItemView a = this.f14316d.mo562a(obj, view, viewGroup);
        if ((a instanceof UserMessengerPayHistoryItemView) || (a instanceof ProductMessengerPayHistoryItemView)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        return a;
    }
}
