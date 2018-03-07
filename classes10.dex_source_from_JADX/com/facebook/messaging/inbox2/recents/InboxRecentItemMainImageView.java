package com.facebook.messaging.inbox2.recents;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.inbox2.recents.ExpandableItemContainer.ExpandableItemView;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;

/* compiled from: sendInviteMethodParams */
public class InboxRecentItemMainImageView extends FbDraweeView implements ExpandableItemView {
    private static final CallerContext f2868c = CallerContext.a(InboxRecentItemMainImageView.class);
    @Nullable
    private InboxRecentItem f2869d;
    public ExpandableItemContainer f2870e;
    @Nullable
    public OnClickListener f2871f;

    /* compiled from: sendInviteMethodParams */
    class C04681 implements OnClickListener {
        final /* synthetic */ InboxRecentItemMainImageView f2867a;

        C04681(InboxRecentItemMainImageView inboxRecentItemMainImageView) {
            this.f2867a = inboxRecentItemMainImageView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -815958503);
            if (!this.f2867a.f2870e.m2824e()) {
                this.f2867a.f2870e.m2821a();
            } else if (this.f2867a.f2871f != null) {
                this.f2867a.f2871f.onClick(view);
            }
            LogUtils.a(743714972, a);
        }
    }

    public InboxRecentItemMainImageView(Context context) {
        super(context);
        m2834c();
    }

    public InboxRecentItemMainImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2834c();
    }

    public InboxRecentItemMainImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2834c();
    }

    private void m2834c() {
        ((GenericDraweeHierarchy) getHierarchy()).a(new PointF(0.5f, 0.0f));
        super.setOnClickListener(new C04681(this));
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f2871f = onClickListener;
    }

    public void setInboxItem(InboxRecentItem inboxRecentItem) {
        this.f2869d = inboxRecentItem;
        a(inboxRecentItem == null ? null : inboxRecentItem.mc_(), f2868c);
    }

    public void setExpandableItemContainer(ExpandableItemContainer expandableItemContainer) {
        this.f2870e = expandableItemContainer;
    }

    public InboxRecentItem getInboxItem() {
        return this.f2869d;
    }

    public final void lX_() {
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void lY_() {
        setFocusableInTouchMode(false);
    }
}
