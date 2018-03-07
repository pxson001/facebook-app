package com.facebook.tablet.sideshow.example;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;

/* compiled from: onRefresh */
public class ExampleSideshowUnit implements SideshowUnit {
    public final View m5869a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(2130907094, viewGroup);
    }

    public final void m5870a() {
    }

    public final void m5872b() {
    }

    public final void m5873c() {
    }

    public final void m5871a(Context context, 1 1) {
        1.a(LoadResult.SUCCESS);
    }

    public final String m5874d() {
        return "example";
    }
}
