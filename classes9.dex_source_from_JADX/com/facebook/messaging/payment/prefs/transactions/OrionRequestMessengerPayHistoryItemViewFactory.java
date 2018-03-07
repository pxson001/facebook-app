package com.facebook.messaging.payment.prefs.transactions;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: friends_who_used */
public class OrionRequestMessengerPayHistoryItemViewFactory implements MessengerPayHistoryItemViewFactory {
    private final LayoutInflater f14397a;
    private final OrionRequestMessengerPayHistoryItemViewParamsFactory f14398b;

    public static OrionRequestMessengerPayHistoryItemViewFactory m14780b(InjectorLike injectorLike) {
        return new OrionRequestMessengerPayHistoryItemViewFactory(LayoutInflaterMethodAutoProvider.b(injectorLike), new OrionRequestMessengerPayHistoryItemViewParamsFactory(IdBasedProvider.a(injectorLike, 3596), ResourcesMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)));
    }

    @Inject
    public OrionRequestMessengerPayHistoryItemViewFactory(LayoutInflater layoutInflater, OrionRequestMessengerPayHistoryItemViewParamsFactory orionRequestMessengerPayHistoryItemViewParamsFactory) {
        this.f14397a = layoutInflater;
        this.f14398b = orionRequestMessengerPayHistoryItemViewParamsFactory;
    }

    public final MessengerPayHistoryItemView mo562a(Object obj, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null || !(view instanceof UserMessengerPayHistoryItemView)) {
            inflate = this.f14397a.inflate(2130907625, viewGroup, false);
        } else {
            inflate = view;
        }
        MessengerPayHistoryItemView messengerPayHistoryItemView = (MessengerPayHistoryItemView) inflate;
        messengerPayHistoryItemView.setMessengerPayHistoryItemViewParams(this.f14398b.m14786a(obj));
        return messengerPayHistoryItemView;
    }
}
