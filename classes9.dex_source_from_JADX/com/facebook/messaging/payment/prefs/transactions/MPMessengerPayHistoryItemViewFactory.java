package com.facebook.messaging.payment.prefs.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.util.date.MessagingDateUtil;
import javax.inject.Inject;

/* compiled from: gametime_match_data_update_subscribe */
public class MPMessengerPayHistoryItemViewFactory implements MessengerPayHistoryItemViewFactory {
    private final LayoutInflater f14317a;
    private final MPMessengerPayHistoryItemViewParamsFactory f14318b;

    public static MPMessengerPayHistoryItemViewFactory m14726b(InjectorLike injectorLike) {
        return new MPMessengerPayHistoryItemViewFactory(LayoutInflaterMethodAutoProvider.b(injectorLike), new MPMessengerPayHistoryItemViewParamsFactory(ResourcesMethodAutoProvider.a(injectorLike), MessagingDateUtil.a(injectorLike), PaymentTransactionUtil.m15519a(injectorLike)));
    }

    @Inject
    public MPMessengerPayHistoryItemViewFactory(LayoutInflater layoutInflater, MPMessengerPayHistoryItemViewParamsFactory mPMessengerPayHistoryItemViewParamsFactory) {
        this.f14317a = layoutInflater;
        this.f14318b = mPMessengerPayHistoryItemViewParamsFactory;
    }

    public final MessengerPayHistoryItemView mo562a(Object obj, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null || !(view instanceof ProductMessengerPayHistoryItemView)) {
            inflate = this.f14317a.inflate(2130906422, viewGroup, false);
        } else {
            inflate = view;
        }
        MessengerPayHistoryItemView messengerPayHistoryItemView = (MessengerPayHistoryItemView) inflate;
        messengerPayHistoryItemView.setMessengerPayHistoryItemViewParams(this.f14318b.m14728a(obj));
        return messengerPayHistoryItemView;
    }
}
