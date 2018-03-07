package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: button_element_end */
public class EventPermalinkTabsBarAdapter extends FbBaseAdapter {
    private final Context f18251a;

    /* compiled from: button_element_end */
    enum ViewType {
        EVENT_PERMALINK_GAP_VIEW,
        TAB_BAR
    }

    public EventPermalinkTabsBarAdapter(Context context) {
        this.f18251a = context;
    }

    public final View m18618a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f18251a).inflate(ViewType.values()[i] == ViewType.TAB_BAR ? 2130904087 : 2130904074, viewGroup, false);
    }

    public final void m18619a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }

    public int getItemViewType(int i) {
        return i == 0 ? ViewType.TAB_BAR.ordinal() : ViewType.EVENT_PERMALINK_GAP_VIEW.ordinal();
    }

    public int getViewTypeCount() {
        return ViewType.values().length;
    }

    public int getCount() {
        return 2;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }
}
