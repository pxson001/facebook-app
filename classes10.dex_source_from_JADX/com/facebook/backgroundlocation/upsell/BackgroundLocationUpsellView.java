package com.facebook.backgroundlocation.upsell;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: dialog_loaded */
public class BackgroundLocationUpsellView extends CustomFrameLayout {
    public int f15069a;
    @Nullable
    public ButtonListener f15070b;
    private final OnClickListener f15071c = new C20931(this);

    /* compiled from: dialog_loaded */
    public interface ButtonListener {
        void mo750a(BackgroundLocationUpsellView backgroundLocationUpsellView);
    }

    /* compiled from: dialog_loaded */
    class C20931 implements OnClickListener {
        final /* synthetic */ BackgroundLocationUpsellView f15068a;

        C20931(BackgroundLocationUpsellView backgroundLocationUpsellView) {
            this.f15068a = backgroundLocationUpsellView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1565233934);
            Preconditions.checkNotNull(this.f15068a.f15070b);
            this.f15068a.f15070b.mo750a(this.f15068a);
            Logger.a(2, EntryType.UI_INPUT_END, 1140006166, a);
        }
    }

    public BackgroundLocationUpsellView(Context context) {
        super(context);
    }

    public BackgroundLocationUpsellView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BackgroundLocationUpsellView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m15573a(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList, @Nullable ButtonListener buttonListener) {
        this.f15069a = i;
        this.f15070b = buttonListener;
        OnClickListener onClickListener = buttonListener == null ? null : this.f15071c;
        if (i <= 1) {
            BackgroundLocationUpsellNoFriendsSharingView noFriendsSharingChild = getNoFriendsSharingChild();
            noFriendsSharingChild.f15062a.setVisibility(onClickListener == null ? 8 : 0);
            noFriendsSharingChild.f15062a.setOnClickListener(onClickListener);
            return;
        }
        BackgroundLocationUpsellFriendsSharingView friendsSharingChild = getFriendsSharingChild();
        BackgroundLocationUpsellFacepileUtil.m15556a(friendsSharingChild.f15059b, immutableList);
        friendsSharingChild.f15060c.setText(friendsSharingChild.f15058a.m15569a(i, (ImmutableList) immutableList));
        friendsSharingChild.f15061d.setVisibility(onClickListener == null ? 8 : 0);
        friendsSharingChild.f15061d.setOnClickListener(onClickListener);
    }

    public String getDesignName() {
        return ((BackgroundLocationUpsell) getChildAt(0)).getDesignName();
    }

    public int getTotalFriendsSharing() {
        return this.f15069a;
    }

    private BackgroundLocationUpsellNoFriendsSharingView getNoFriendsSharingChild() {
        View childAt = getChildAt(0);
        if (childAt instanceof BackgroundLocationUpsellNoFriendsSharingView) {
            return (BackgroundLocationUpsellNoFriendsSharingView) childAt;
        }
        BackgroundLocationUpsellNoFriendsSharingView backgroundLocationUpsellNoFriendsSharingView = new BackgroundLocationUpsellNoFriendsSharingView(getContext());
        removeAllViews();
        addView(backgroundLocationUpsellNoFriendsSharingView);
        return backgroundLocationUpsellNoFriendsSharingView;
    }

    private BackgroundLocationUpsellFriendsSharingView getFriendsSharingChild() {
        View childAt = getChildAt(0);
        if (childAt instanceof BackgroundLocationUpsellFriendsSharingView) {
            return (BackgroundLocationUpsellFriendsSharingView) childAt;
        }
        BackgroundLocationUpsellFriendsSharingView backgroundLocationUpsellFriendsSharingView = new BackgroundLocationUpsellFriendsSharingView(getContext());
        removeAllViews();
        addView(backgroundLocationUpsellFriendsSharingView);
        return backgroundLocationUpsellFriendsSharingView;
    }
}
