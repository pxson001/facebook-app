package com.facebook.widget.animatablelistview;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: android.intent.extra.INSTALLER_PACKAGE_NAME */
public interface ItemBasedListAdapter<T> {
    int m20061a(T t);

    View m20062a(T t, View view, ViewGroup viewGroup);

    boolean areAllItemsEnabled();

    long m20063b(T t);

    boolean m20064c(T t);

    int getViewTypeCount();
}
