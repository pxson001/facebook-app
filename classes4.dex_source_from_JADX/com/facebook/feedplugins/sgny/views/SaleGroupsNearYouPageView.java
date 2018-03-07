package com.facebook.feedplugins.sgny.views;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import java.util.List;

/* compiled from: notification_scroll_depth_v2 */
public class SaleGroupsNearYouPageView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f6801a;
    private FbDraweeView f6802b;
    private FbDraweeView f6803c;
    private FbDraweeView f6804d;
    private FbDraweeView f6805e;
    public TextView f6806f;
    public TextView f6807g;
    private TextView f6808h;
    public ImageButton f6809i;
    private ImageView f6810j;
    private View f6811k;
    public View f6812l;

    public SaleGroupsNearYouPageView(Context context) {
        this(context, null);
    }

    private SaleGroupsNearYouPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904748);
        this.f6802b = (FbDraweeView) c(2131562829);
        this.f6803c = (FbDraweeView) c(2131562830);
        this.f6804d = (FbDraweeView) c(2131562831);
        this.f6805e = (FbDraweeView) c(2131562832);
        this.f6812l = c(2131562828);
        this.f6806f = (TextView) c(2131562835);
        this.f6807g = (TextView) c(2131562836);
        this.f6808h = (TextView) c(2131562837);
        this.f6809i = (ImageButton) c(2131562839);
        this.f6810j = (ImageView) c(2131562833);
        this.f6811k = c(2131562834);
    }

    public void setNameClickListener(OnClickListener onClickListener) {
        this.f6811k.setOnClickListener(onClickListener);
    }

    public void setMemberCount(int i) {
        this.f6808h.setText(getResources().getQuantityString(2131689702, i, new Object[]{Integer.valueOf(i)}));
    }

    public void setGroupJoiningButtonClickedListener(OnClickListener onClickListener) {
        this.f6809i.setOnClickListener(onClickListener);
    }

    public void setOnBlacklistIconClickedListener(OnClickListener onClickListener) {
        this.f6810j.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -554624542);
        super.onAttachedToWindow();
        this.f6801a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1585989985, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -309214816);
        super.onDetachedFromWindow();
        this.f6801a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1681582572, a);
    }

    public final boolean mo569a() {
        return this.f6801a;
    }

    public final void m7164a(Uri uri, CallerContext callerContext) {
        this.f6805e.a(uri, callerContext);
        this.f6805e.setVisibility(0);
        this.f6804d.setVisibility(8);
        this.f6803c.setVisibility(8);
        this.f6802b.setVisibility(8);
    }

    public final void m7165a(List<Uri> list, CallerContext callerContext) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            if (size >= 3) {
                this.f6804d.a((Uri) list.get(2), callerContext);
            }
            if (size >= 2) {
                this.f6803c.a((Uri) list.get(1), callerContext);
            }
            if (size > 0) {
                this.f6802b.a((Uri) list.get(0), callerContext);
            }
            this.f6804d.setVisibility(0);
            this.f6803c.setVisibility(0);
            this.f6802b.setVisibility(0);
            this.f6805e.setVisibility(8);
        }
    }
}
