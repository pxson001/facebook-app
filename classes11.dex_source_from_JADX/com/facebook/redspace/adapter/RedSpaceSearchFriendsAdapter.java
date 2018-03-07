package com.facebook.redspace.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.redspace.data.RedSpaceFriendsSearchCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceSearchFriendsItemView;
import com.facebook.widget.listview.FbBaseAdapter;

/* compiled from: QuicksilverAndroid */
public class RedSpaceSearchFriendsAdapter extends FbBaseAdapter {
    private RedSpaceFriendsSearchCollection f11733a;
    public OnClickListener f11734b;
    public OnClickListener f11735c;

    public RedSpaceSearchFriendsAdapter(RedSpaceFriendsSearchCollection redSpaceFriendsSearchCollection) {
        this.f11733a = redSpaceFriendsSearchCollection;
    }

    public final View m12161a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130906771, viewGroup, false);
    }

    public final void m12162a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        RedSpaceFriendsSection redSpaceFriendsSection;
        RedSpaceSearchFriendsItemView redSpaceSearchFriendsItemView = (RedSpaceSearchFriendsItemView) view;
        RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = (RedSpaceFeedProfileFragmentModel) obj;
        if (this.f11733a.f11805d.contains(redSpaceFeedProfileFragmentModel.k())) {
            redSpaceFriendsSection = RedSpaceFriendsSection.TOP;
        } else {
            redSpaceFriendsSection = RedSpaceFriendsSection.OTHERS;
        }
        if (this.f11733a.f11806e.contains(redSpaceFeedProfileFragmentModel.k())) {
            redSpaceFriendsSection = redSpaceFriendsSection.getOverflowVariant();
        }
        redSpaceSearchFriendsItemView.m12800a(redSpaceFriendsSection, this.f11733a.m12243i(redSpaceFeedProfileFragmentModel), redSpaceFeedProfileFragmentModel);
        redSpaceSearchFriendsItemView.setOnClickListener(this.f11734b);
        redSpaceSearchFriendsItemView.setActionButtonOnClickListener(this.f11735c);
    }

    public int getCount() {
        return this.f11733a.m12222d();
    }

    public Object getItem(int i) {
        return this.f11733a.m12213a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
