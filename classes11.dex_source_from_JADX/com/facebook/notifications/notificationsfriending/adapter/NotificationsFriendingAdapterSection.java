package com.facebook.notifications.notificationsfriending.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.notifications.notificationsfriending.NotificationsFriendingAdapter.ViewTypes;

/* compiled from: tileJson */
public interface NotificationsFriendingAdapterSection<T> {
    View mo14a(int i, View view, ViewGroup viewGroup);

    ViewTypes mo15a(int i);

    T mo16b(int i);

    String mo17c();

    boolean mo18d();

    String mo19e();

    OnClickListener mo20f();

    int mo21g();

    boolean mo22h();

    boolean mo23i();

    ViewTypes mo24j();

    OnClickListener mo25k();
}
