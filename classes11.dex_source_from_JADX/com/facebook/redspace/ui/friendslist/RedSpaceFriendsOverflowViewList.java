package com.facebook.redspace.ui.friendslist;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.redspace.data.RedSpaceFriendsSection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFriendsOverflowCountQueryModel.RedspaceModel.OverflowFriendsModel;
import com.facebook.redspace.ui.animation.RedSpaceFadeAnimationHelper;

/* compiled from: PRIVACY_CHECKUP_INTRO_STEP_CLOSE */
public class RedSpaceFriendsOverflowViewList extends ContentView implements RedSpaceAnimationSupportedView, RedSpaceFriendsOverflowView {
    private RedSpaceFriendsSection f12486h;
    private RedSpaceFriendsOverflowImageView f12487i;
    private boolean f12488j;

    public RedSpaceFriendsOverflowViewList(Context context) {
        super(context);
    }

    public RedSpaceFriendsOverflowViewList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RedSpaceFriendsOverflowViewList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 112883393);
        super.onFinishInflate();
        this.f12487i = (RedSpaceFriendsOverflowImageView) getView(2131566855);
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -777213449, a);
    }

    public final void mo357a(OverflowFriendsModel overflowFriendsModel, RedSpaceFriendsSection redSpaceFriendsSection) {
        this.f12486h = redSpaceFriendsSection;
        this.f12487i.m12890a(overflowFriendsModel);
    }

    public RedSpaceFriendsSection getSection() {
        return this.f12486h;
    }

    public void setEnabled(boolean z) {
        if (isEnabled() != z) {
            super.setEnabled(z);
            float f = z ? 1.0f : 0.2f;
            RedSpaceFadeAnimationHelper.m12838a(getTitleView(), this.f12488j, f);
            RedSpaceFadeAnimationHelper.m12838a(this.f, this.f12488j, f);
            this.f12488j = false;
        }
    }

    public final void mo356a() {
        this.f12488j = true;
    }
}
