package com.facebook.feedplugins.multishare.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.attachments.angora.InstantArticleIconView;
import com.facebook.attachments.videos.ui.VideoPlayerAttachment;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feedplugins.multishare.MultiShareInlineVideoView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.RichVideoPlayerParams;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: density */
public class MultiShareProductItemView extends MultiSharePagerItemView implements AttachmentHasButton, VideoPlayerAttachment {
    @VisibleForTesting
    public FbDraweeView f13990a = ((FbDraweeView) c(2131564024));
    @VisibleForTesting
    public MultiShareInlineVideoView f13991b = ((MultiShareInlineVideoView) c(2131564023));
    public boolean f13992c;
    private final InstantArticleIconView f13993d = ((InstantArticleIconView) c(2131559577));
    public TextView f13994e = ((TextView) c(2131564026));
    public TextView f13995f = ((TextView) c(2131564027));
    private FbDraweeView f13996g = this.f13991b.getCoverImage();
    private View f13997h = c(2131564025);
    @Inject
    public QeAccessor f13998i;

    public static void m14784a(Object obj, Context context) {
        ((MultiShareProductItemView) obj).f13998i = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public MultiShareProductItemView(Context context) {
        super(context);
        Class cls = MultiShareProductItemView.class;
        m14784a((Object) this, getContext());
        setContentView(2130905362);
        if (this.f13998i.a(ExperimentsForMultiShareModule.f14173a, false)) {
            this.f13990a.setHierarchy(new GenericDraweeHierarchyBuilder(getResources()).e(ScaleType.g).u());
        }
    }

    public void setDescriptionTextVisibility(int i) {
        this.f13995f.setVisibility(i);
    }

    public final void m14789b() {
        this.f13991b.setOnClickListener(null);
        this.f13991b.setClickable(false);
    }

    public void setInlineVideoViewVisibility(boolean z) {
        this.f13991b.setVisibility(z ? 0 : 8);
    }

    public void setFlashIconVisibility(boolean z) {
        this.f13993d.setVisibility(z ? 0 : 8);
    }

    public void setItemImageViewVisibility(boolean z) {
        this.f13990a.setVisibility(z ? 0 : 8);
    }

    public void setItemFooterViewVisibility(boolean z) {
        this.f13997h.setVisibility(z ? 0 : 8);
    }

    public final void m14787a(RichVideoPlayerParams richVideoPlayerParams) {
        this.f13991b.m14821a(richVideoPlayerParams);
    }

    public final void m14786a(int i, EventTriggerType eventTriggerType) {
        this.f13991b.m14817a(i, eventTriggerType);
        this.f13991b.m14818a(eventTriggerType);
    }

    public final void m14791e() {
        if (this.f13991b.m14847m()) {
            this.f13991b.m14832b(EventTriggerType.BY_AUTOPLAY);
        }
    }

    public MultiShareInlineVideoView getInlineVideoView() {
        return this.f13991b;
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1560450636);
        super.onAttachedToWindow();
        this.f13992c = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 354351777, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1108521748);
        super.onDetachedFromWindow();
        this.f13992c = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 207112319, a);
    }

    public final boolean mo569a() {
        return this.f13992c;
    }

    public final void mo1001a(int i, int i2) {
        LayoutParams layoutParams = this.f13991b.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(i, i2);
        }
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f13991b.setLayoutParams(layoutParams);
        if (this.f13996g != null) {
            layoutParams = this.f13996g.getLayoutParams();
            layoutParams.height = i2;
            layoutParams.width = i;
            this.f13996g.setLayoutParams(layoutParams);
        }
    }

    public final void mo1002b(int i, int i2) {
    }

    public DraweeController getCoverController() {
        return this.f13996g != null ? this.f13996g.getController() : null;
    }

    public void setCoverController(DraweeController draweeController) {
        if (this.f13996g != null) {
            this.f13996g.setController(draweeController);
        }
    }
}
