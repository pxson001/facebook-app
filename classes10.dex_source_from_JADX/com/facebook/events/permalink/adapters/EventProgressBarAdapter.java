package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: button_color */
public class EventProgressBarAdapter extends FbBaseAdapter {
    private final Context f18253a;
    public boolean f18254b = true;
    public boolean f18255c;

    /* compiled from: button_color */
    enum ViewType {
        PROGRESS_BAR,
        END_MARKER
    }

    public EventProgressBarAdapter(Context context) {
        this.f18253a = context;
    }

    public int getCount() {
        return (this.f18254b || this.f18255c) ? 1 : 0;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public final View m18620a(int i, ViewGroup viewGroup) {
        ViewType viewType = ViewType.values()[i];
        switch (viewType) {
            case PROGRESS_BAR:
                return LayoutInflater.from(this.f18253a).inflate(2130904083, viewGroup, false);
            case END_MARKER:
                return LayoutInflater.from(this.f18253a).inflate(2130904053, viewGroup, false);
            default:
                throw new IllegalArgumentException("Unknown viewType " + viewType);
        }
    }

    public final void m18621a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }

    public int getItemViewType(int i) {
        return this.f18254b ? ViewType.PROGRESS_BAR.ordinal() : ViewType.END_MARKER.ordinal();
    }
}
