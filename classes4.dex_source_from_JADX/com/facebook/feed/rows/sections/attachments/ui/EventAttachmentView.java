package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontexttagger.AnalyticsTagger;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.events.widget.eventcard.EventsCardView;
import com.facebook.inject.FbInjector;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.text.BetterTextView;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: orca_muted_until_ms */
public class EventAttachmentView extends EventsCardView implements AttachmentHasLargeImage {
    public static final ViewType f5979a = new C02601();
    @Inject
    public AnalyticsTagger f5980b;
    private Context f5981c;

    /* compiled from: orca_muted_until_ms */
    final class C02601 extends ViewType {
        C02601() {
        }

        public final View m6452a(Context context) {
            return new EventAttachmentView(context);
        }
    }

    private static <T extends View> void m6436a(Class<T> cls, T t) {
        m6437a((Object) t, t.getContext());
    }

    private static void m6437a(Object obj, Context context) {
        ((EventAttachmentView) obj).f5980b = AnalyticsTagger.a(FbInjector.get(context));
    }

    public EventAttachmentView(Context context) {
        super(context);
        m6434a(context);
    }

    public EventAttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6434a(context);
    }

    public EventAttachmentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6434a(context);
    }

    private void m6434a(Context context) {
        m6436a(EventAttachmentView.class, (View) this);
        this.f5981c = context;
        this.f5980b.a(this, "newsfeed_angora_attachment_view", getClass());
        TrackingNodes.a(this, TrackingNode.ATTACHMENT);
        TrackingNodes.a(this.f5984c, TrackingNode.TITLE);
        TrackingNodes.a(this.f5987f, TrackingNode.SOCIAL_CONTEXT);
    }

    @VisibleForTesting
    EventAttachmentView(Context context, BetterTextView betterTextView, BetterTextView betterTextView2, BetterTextView betterTextView3) {
        super(context);
        this.f5984c = betterTextView;
        this.f5987f = betterTextView2;
        this.f5986e = betterTextView3;
    }

    public void setLargeImageAspectRatio(float f) {
        super.setCoverPhotoAspectRatio(f);
    }

    public void setLargeImageController(@Nullable DraweeController draweeController) {
        super.setCoverPhotoController(draweeController);
    }

    public final void mo543a() {
        this.f5982a.setPadding(this.f5981c.getResources().getDimensionPixelOffset(2131427381), 0, this.f5981c.getResources().getDimensionPixelOffset(2131427381), 0);
    }

    private void m6435a(AnalyticsTagger analyticsTagger) {
        this.f5980b = analyticsTagger;
    }
}
