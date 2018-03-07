package com.facebook.feedplugins.egolistview.views;

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

/* compiled from: gravity_search_null_state_vpv */
public class GroupsYouShouldJoinPageView extends PagerItemWrapperLayout implements RecyclableView {
    public boolean f12096a;
    private FbDraweeView f12097b;
    private FbDraweeView f12098c;
    private FbDraweeView f12099d;
    private FbDraweeView f12100e;
    public TextView f12101f;
    public TextView f12102g;
    private TextView f12103h;
    public ImageButton f12104i;
    private ImageView f12105j;
    private View f12106k;
    public View f12107l;

    public GroupsYouShouldJoinPageView(Context context) {
        this(context, null);
    }

    private GroupsYouShouldJoinPageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904748);
        this.f12097b = (FbDraweeView) c(2131562829);
        this.f12098c = (FbDraweeView) c(2131562830);
        this.f12099d = (FbDraweeView) c(2131562831);
        this.f12100e = (FbDraweeView) c(2131562832);
        this.f12107l = c(2131562828);
        this.f12101f = (TextView) c(2131562835);
        this.f12102g = (TextView) c(2131562836);
        this.f12103h = (TextView) c(2131562837);
        this.f12104i = (ImageButton) c(2131562839);
        this.f12105j = (ImageView) c(2131562833);
        this.f12106k = c(2131562834);
    }

    public void setNameClickListener(OnClickListener onClickListener) {
        this.f12106k.setOnClickListener(onClickListener);
    }

    public void setMemberCount(int i) {
        this.f12103h.setText(getResources().getQuantityString(2131689702, i, new Object[]{Integer.valueOf(i)}));
    }

    public void setGroupJoiningButtonClickedListener(OnClickListener onClickListener) {
        this.f12104i.setOnClickListener(onClickListener);
    }

    public void setOnBlacklistIconClickedListener(OnClickListener onClickListener) {
        this.f12105j.setOnClickListener(onClickListener);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1219162881);
        super.onAttachedToWindow();
        this.f12096a = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -858425010, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 555235969);
        super.onDetachedFromWindow();
        this.f12096a = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 954786522, a);
    }

    public final boolean m14113a() {
        return this.f12096a;
    }

    public final void m14111a(Uri uri, CallerContext callerContext) {
        this.f12100e.a(uri, callerContext);
        this.f12100e.setVisibility(0);
        this.f12099d.setVisibility(8);
        this.f12098c.setVisibility(8);
        this.f12097b.setVisibility(8);
    }

    public final void m14112a(List<Uri> list, CallerContext callerContext) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            if (size >= 3) {
                this.f12099d.a((Uri) list.get(2), callerContext);
            }
            if (size >= 2) {
                this.f12098c.a((Uri) list.get(1), callerContext);
            }
            if (size > 0) {
                this.f12097b.a((Uri) list.get(0), callerContext);
            }
            this.f12099d.setVisibility(0);
            this.f12098c.setVisibility(0);
            this.f12097b.setVisibility(0);
            this.f12100e.setVisibility(8);
        }
    }
}
