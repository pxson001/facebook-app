package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.google.common.base.Optional;

/* compiled from: VBRI */
public class SubStoryItemView extends PagerItemWrapperLayout implements RecyclableView {
    private final FbDraweeView f21097a = ((FbDraweeView) c(2131562969));
    private final DefaultFooterView f21098b;
    public Optional<TextView> f21099c;
    public boolean f21100d;

    public SubStoryItemView(Context context, int i) {
        super(context);
        setContentView(i);
        setBackgroundResource(2130840170);
        ((GenericDraweeHierarchy) this.f21097a.getHierarchy()).b(2131362786);
        this.f21098b = (DefaultFooterView) c(2131562973);
        this.f21099c = d(2131567738);
        if (this.f21099c.isPresent()) {
            ((TextView) this.f21099c.get()).setText(context.getString(2131233386));
        }
        Optional d = d(2131567737);
        if (d.isPresent()) {
            TrackingNodes.a((View) d.get(), TrackingNode.SUB_ATTACHMENT);
        }
        TrackingNodes.a(this, TrackingNode.SUBSTORY);
    }

    public void setSideImageController(DraweeController draweeController) {
        FbDraweeView fbDraweeView = this.f21097a;
        fbDraweeView.setVisibility(draweeController != null ? 0 : 8);
        fbDraweeView.setController(draweeController);
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 742097494);
        super.onAttachedToWindow();
        this.f21100d = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1463653091, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1445109357);
        super.onDetachedFromWindow();
        this.f21100d = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 2012647285, a);
    }

    public final boolean m23976a() {
        return this.f21100d;
    }

    public DefaultFooterView getFooter() {
        return this.f21098b;
    }
}
