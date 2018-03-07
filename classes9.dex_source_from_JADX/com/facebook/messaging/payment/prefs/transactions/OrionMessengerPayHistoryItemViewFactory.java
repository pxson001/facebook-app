package com.facebook.messaging.payment.prefs.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import javax.inject.Inject;

/* compiled from: fromModule */
public class OrionMessengerPayHistoryItemViewFactory implements MessengerPayHistoryItemViewFactory {
    private final LayoutInflater f14389a;
    private final OrionMessengerPayHistoryItemViewParamsFactory f14390b;

    @Inject
    public OrionMessengerPayHistoryItemViewFactory(LayoutInflater layoutInflater, OrionMessengerPayHistoryItemViewParamsFactory orionMessengerPayHistoryItemViewParamsFactory) {
        this.f14389a = layoutInflater;
        this.f14390b = orionMessengerPayHistoryItemViewParamsFactory;
    }

    public final MessengerPayHistoryItemView mo562a(Object obj, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null || !(view instanceof UserMessengerPayHistoryItemView)) {
            inflate = this.f14389a.inflate(2130907625, viewGroup, false);
        } else {
            inflate = view;
        }
        MessengerPayHistoryItemView messengerPayHistoryItemView = (MessengerPayHistoryItemView) inflate;
        messengerPayHistoryItemView.setMessengerPayHistoryItemViewParams(this.f14390b.m14779a(obj));
        return messengerPayHistoryItemView;
    }
}
