package com.facebook.feed.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: network_info_latency_quality */
public class PaddingAdapter extends FbBaseAdapter {
    public static PaddingAdapter m18640a(InjectorLike injectorLike) {
        return new PaddingAdapter();
    }

    public final View mo1985a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130905951, viewGroup, false);
    }

    public final void mo1986a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getCount() {
        return 1;
    }
}
