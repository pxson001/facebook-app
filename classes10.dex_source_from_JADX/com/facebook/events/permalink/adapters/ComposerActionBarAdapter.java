package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.actionbar.ActionItemPost;
import com.facebook.events.permalink.composeractionbar.EventComposerActionBar;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: c13af363c7644914c43c3e899471d6c8 */
public class ComposerActionBarAdapter extends FbBaseAdapter {
    private final Context f18138a;
    private final ActionItemPost f18139b;
    public Event f18140c;

    public ComposerActionBarAdapter(Context context, ActionItemPost actionItemPost) {
        this.f18138a = context;
        this.f18139b = actionItemPost;
    }

    public final View m18512a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f18138a).inflate(2130904063, viewGroup, false);
    }

    public final void m18513a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((EventComposerActionBar) view).f18315c = this.f18139b;
    }

    public int getCount() {
        return this.f18140c == null ? 0 : 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }
}
