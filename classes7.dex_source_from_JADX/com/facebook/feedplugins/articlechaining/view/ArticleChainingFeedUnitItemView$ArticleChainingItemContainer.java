package com.facebook.feedplugins.articlechaining.view;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: TOPIC_COMPOSER_NUX */
public class ArticleChainingFeedUnitItemView$ArticleChainingItemContainer {
    public final View f22541a;
    public final FbDraweeView f22542b;
    public final TextView f22543c;
    public final TextView f22544d;
    public final /* synthetic */ ArticleChainingFeedUnitItemView f22545e;
    public final ViewStub f22546f;
    private final View f22547g;
    public View f22548h;

    public ArticleChainingFeedUnitItemView$ArticleChainingItemContainer(ArticleChainingFeedUnitItemView articleChainingFeedUnitItemView) {
        this.f22545e = articleChainingFeedUnitItemView;
        this.f22541a = articleChainingFeedUnitItemView.c(2131559702);
        this.f22542b = (FbDraweeView) articleChainingFeedUnitItemView.c(2131559703);
        this.f22543c = (TextView) articleChainingFeedUnitItemView.c(2131559705);
        this.f22544d = (TextView) articleChainingFeedUnitItemView.c(2131559706);
        this.f22546f = (ViewStub) articleChainingFeedUnitItemView.c(2131559707);
        this.f22547g = articleChainingFeedUnitItemView.c(2131559704);
        this.f22543c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f22544d.setMovementMethod(LinkMovementMethod.getInstance());
        TrackingNodes.a(this.f22543c, TrackingNode.TITLE);
        TrackingNodes.a(this.f22544d, TrackingNode.SUBTITLE);
    }

    public final void m25254a(boolean z) {
        this.f22547g.setVisibility(z ? 0 : 8);
    }
}
