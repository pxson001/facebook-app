package com.facebook.events.permalink.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: button_border_transparent */
public class PostingStoryProgressBarAdapter extends FbBaseAdapter {
    private final Context f18256a;
    public boolean f18257b;

    public PostingStoryProgressBarAdapter(Context context) {
        this.f18256a = context;
    }

    public int getCount() {
        return this.f18257b ? 1 : 0;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final View m18622a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f18256a).inflate(2130904082, viewGroup, false);
    }

    public final void m18623a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }
}
