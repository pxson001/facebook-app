package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: PRIVACY_CHECKUP_INTRO_STEP_CONTINUE */
public class RedSpaceFriendsOverflowViewGrid extends CustomLinearLayout implements RedSpaceFriendsOverflowView {
    private RedSpaceFriendsSection f12484a;
    private RedSpaceFriendsOverflowImageView f12485b;

    public RedSpaceFriendsOverflowViewGrid(Context context) {
        super(context);
    }

    public RedSpaceFriendsOverflowViewGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedSpaceFriendsOverflowViewGrid(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1820944691);
        super.onFinishInflate();
        this.f12485b = (RedSpaceFriendsOverflowImageView) a(2131566855);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -449532823, a);
    }

    public final void mo357a(OverflowFriendsModel overflowFriendsModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        this.f12484a = redSpaceFriendsSection;
        this.f12485b.m12890a(overflowFriendsModel);
    }

    public RedSpaceFriendsSection getSection() {
        return this.f12484a;
    }
}
