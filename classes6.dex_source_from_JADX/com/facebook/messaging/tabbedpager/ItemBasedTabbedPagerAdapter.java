package com.facebook.messaging.tabbedpager;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import javax.annotation.Nullable;

/* compiled from: is_callable_mobile */
public interface ItemBasedTabbedPagerAdapter<T> {
    int mo1276a();

    ViewHolder mo1277a(ViewGroup viewGroup, int i);

    View mo1278a(T t, @Nullable View view, ViewGroup viewGroup, boolean z);

    String mo1279a(T t);

    void mo1280a(ViewHolder viewHolder, T t);

    int mo1281b(T t);

    int mo1282c(T t);

    void mo1283d(T t);

    boolean mo1284e(T t);
}
