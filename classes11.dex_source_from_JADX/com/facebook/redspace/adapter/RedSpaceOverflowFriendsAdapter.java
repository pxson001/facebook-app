package com.facebook.redspace.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceOverflowFriendsItemView;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: RADIAL */
public class RedSpaceOverflowFriendsAdapter extends FbBaseAdapter {
    private RedSpaceFriendsCollection f11731a;
    private RedSpaceFriendsSection f11732b;

    public RedSpaceOverflowFriendsAdapter(RedSpaceFriendsCollection redSpaceFriendsCollection, RedSpaceFriendsSection redSpaceFriendsSection) {
        this.f11731a = redSpaceFriendsCollection;
        this.f11732b = redSpaceFriendsSection;
    }

    public final View m12159a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130906768, viewGroup, false);
    }

    public final void m12160a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((RedSpaceOverflowFriendsItemView) view).m12771a(this.f11732b, (RedSpaceFeedProfileFragmentModel) obj);
    }

    public int getCount() {
        return this.f11731a.m12222d();
    }

    public Object getItem(int i) {
        return this.f11731a.m12213a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
