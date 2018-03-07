package com.facebook.redspace.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.redspace.abtest.RedSpaceFriendsLayout;
import com.facebook.redspace.data.RedSpaceFriendsCollection;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsItemView;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsOverflowView;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsTitleView;
import com.facebook.redspace.ui.friendslist.RedSpaceFriendsTitleView.OnEditModeSwitchListener;
import com.facebook.widget.listview.FbBaseAdapter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: RCTImageView */
public class RedSpaceFriendsAdapter extends FbBaseAdapter {
    protected final RedSpaceFriendsCollection f11717a;
    protected final RedSpaceFriendsSection f11718b;
    private final OnClickListener f11719c;
    private final OnClickListener f11720d;
    private final OnClickListener f11721e;
    private final OnLongClickListener f11722f;
    private final OnEditModeSwitchListener f11723g;
    private boolean f11724h;
    public boolean f11725i;
    public boolean f11726j;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: RCTImageView */
    public @interface ItemType {
    }

    public RedSpaceFriendsAdapter(RedSpaceFriendsSection redSpaceFriendsSection, boolean z, RedSpaceFriendsCollection redSpaceFriendsCollection, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, OnLongClickListener onLongClickListener, OnEditModeSwitchListener onEditModeSwitchListener) {
        this.f11717a = redSpaceFriendsCollection;
        this.f11718b = redSpaceFriendsSection;
        this.f11724h = z;
        this.f11719c = onClickListener;
        this.f11720d = onClickListener2;
        this.f11721e = onClickListener3;
        this.f11722f = onLongClickListener;
        this.f11723g = onEditModeSwitchListener;
    }

    public static RedSpaceFriendsAdapter m12151a(RedSpaceFriendsSection redSpaceFriendsSection, boolean z, RedSpaceFriendsCollection redSpaceFriendsCollection, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, OnLongClickListener onLongClickListener, OnEditModeSwitchListener onEditModeSwitchListener, RedSpaceFriendsLayout redSpaceFriendsLayout) {
        return redSpaceFriendsLayout == RedSpaceFriendsLayout.GRID ? new RedSpaceFriendsAdapterGrid(redSpaceFriendsSection, z, redSpaceFriendsCollection, onClickListener, onClickListener2, onClickListener3, onLongClickListener, onEditModeSwitchListener) : new RedSpaceFriendsAdapterList(redSpaceFriendsSection, z, redSpaceFriendsCollection, onClickListener, onClickListener2, onClickListener3, onLongClickListener, onEditModeSwitchListener);
    }

    public int getCount() {
        int i;
        int i2;
        int i3 = 1;
        int d = this.f11717a.m12222d();
        int i4 = this.f11717a.m12223e() ? 1 : 0;
        if (d + i4 == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (d + i4 == 0) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (!(this.f11724h && i2 == 1)) {
            i3 = 0;
        }
        return (((i2 + i3) + d) + i4) + i;
    }

    public Object getItem(int i) {
        int itemViewType = getItemViewType(i);
        int i2 = 1;
        if (this.f11724h) {
            i2 = 2;
        }
        switch (itemViewType) {
            case 0:
            case 1:
            case 4:
                return null;
            case 2:
                return this.f11717a.m12213a(i - i2);
            case 3:
                return this.f11717a.f11774a;
            default:
                throw new IllegalArgumentException("Unknown type " + itemViewType);
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        return m12152a(i);
    }

    public int getViewTypeCount() {
        return 5;
    }

    public View mo326a(int i, ViewGroup viewGroup) {
        int i2;
        switch (i) {
            case 0:
                i2 = 2130906774;
                break;
            case 1:
                i2 = 2130906773;
                break;
            case 4:
                i2 = 2130906755;
                break;
            default:
                throw new IllegalStateException("Unexpected ViewType");
        }
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
    }

    public final void m12154a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        boolean z = true;
        switch (i2) {
            case 0:
                RedSpaceFriendsTitleView redSpaceFriendsTitleView = (RedSpaceFriendsTitleView) view;
                redSpaceFriendsTitleView.m12905a(this.f11718b, this.f11725i, this.f11726j);
                redSpaceFriendsTitleView.f12493j = this.f11723g;
                return;
            case 1:
                boolean z2;
                view.setOnClickListener(this.f11721e);
                if (this.f11726j) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                view.setEnabled(z2);
                return;
            case 2:
                RedSpaceFriendsItemView redSpaceFriendsItemView = (RedSpaceFriendsItemView) view;
                redSpaceFriendsItemView.mo353a(this.f11718b, (RedSpaceFeedProfileFragmentModel) obj, this.f11726j);
                redSpaceFriendsItemView.setOnProfileClickListener(this.f11719c);
                redSpaceFriendsItemView.setOnProfileLongClickListener(this.f11722f);
                return;
            case 3:
                RedSpaceFriendsOverflowView redSpaceFriendsOverflowView = (RedSpaceFriendsOverflowView) view;
                redSpaceFriendsOverflowView.mo357a((OverflowFriendsModel) obj, this.f11718b);
                redSpaceFriendsOverflowView.setOnClickListener(this.f11720d);
                if (this.f11726j) {
                    z = false;
                }
                view.setEnabled(z);
                return;
            case 4:
                return;
            default:
                throw new IllegalArgumentException("Unexpected itemViewType");
        }
    }

    public final int m12152a(int i) {
        if (i == getCount() - 1) {
            return 4;
        }
        if (i == 0) {
            return 0;
        }
        if (this.f11724h && i == 1) {
            return 1;
        }
        if (this.f11717a.m12223e() && i == getCount() - 2) {
            return 3;
        }
        return 2;
    }
}
