package com.facebook.redspace.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsTitleView.OnEditModeSwitchListener;

/* compiled from: RCTAxialGradientView */
public class RedSpaceFriendsAdapterList extends RedSpaceFriendsAdapter {
    public RedSpaceFriendsAdapterList(RedSpaceFriendsSection redSpaceFriendsSection, boolean z, RedSpaceFriendsCollection redSpaceFriendsCollection, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, OnLongClickListener onLongClickListener, OnEditModeSwitchListener onEditModeSwitchListener) {
        super(redSpaceFriendsSection, z, redSpaceFriendsCollection, onClickListener, onClickListener2, onClickListener3, onLongClickListener, onEditModeSwitchListener);
    }

    public final View mo326a(int i, ViewGroup viewGroup) {
        int i2;
        switch (i) {
            case 2:
                i2 = 2130906765;
                break;
            case 3:
                i2 = 2130906770;
                break;
            default:
                return super.mo326a(i, viewGroup);
        }
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
    }
}
