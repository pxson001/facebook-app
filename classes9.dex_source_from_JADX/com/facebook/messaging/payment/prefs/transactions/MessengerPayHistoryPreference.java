package com.facebook.messaging.payment.prefs.transactions;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.FbInjector;

/* compiled from: from_user_id */
public class MessengerPayHistoryPreference extends Preference {
    public final Object f14375a;
    public CompositeMessengerPayHistoryItemViewFactory f14376b;

    public static void m14773a(Object obj, Context context) {
        ((MessengerPayHistoryPreference) obj).f14376b = CompositeMessengerPayHistoryItemViewFactory.m14724b(FbInjector.get(context));
    }

    public MessengerPayHistoryPreference(Context context, Object obj) {
        super(context);
        this.f14375a = obj;
        Class cls = MessengerPayHistoryPreference.class;
        m14773a(this, getContext());
    }

    public View getView(View view, ViewGroup viewGroup) {
        return (View) this.f14376b.mo562a(this.f14375a, view, viewGroup);
    }
}
