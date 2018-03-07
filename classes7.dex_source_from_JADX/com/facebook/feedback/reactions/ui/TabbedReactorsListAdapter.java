package com.facebook.feedback.reactions.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: setting value */
public class TabbedReactorsListAdapter extends FbBaseAdapter {
    private final AppendOnlyGraphQLObjectCollection<ActorReactionPair> f3939a;
    private final boolean f3940b;

    public TabbedReactorsListAdapter(AppendOnlyGraphQLObjectCollection<ActorReactionPair> appendOnlyGraphQLObjectCollection, boolean z) {
        this.f3939a = appendOnlyGraphQLObjectCollection;
        this.f3940b = z;
    }

    public int getCount() {
        return this.f3939a.c();
    }

    public Object getItem(int i) {
        return this.f3939a.a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m4572a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130906729, viewGroup, false);
    }

    public final void m4573a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((ReactorsRowView) view).m4571a((ActorReactionPair) obj, this.f3940b);
    }
}
