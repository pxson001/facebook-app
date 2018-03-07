package com.facebook.feedplugins.pyml.views;

import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;

/* compiled from: android-%s */
public class EgoProfileSwipeUnitItemView$EgoItemContainer {
    public final View f19891a;
    public final FbDraweeView f19892b;
    public final TextView f19893c;
    public final TextView f19894d;
    public final TextView f19895e;
    public final GlyphView f19896f;
    public final ViewStub f19897g;
    public View f19898h;
    final /* synthetic */ EgoProfileSwipeUnitItemView f19899i;

    public EgoProfileSwipeUnitItemView$EgoItemContainer(EgoProfileSwipeUnitItemView egoProfileSwipeUnitItemView) {
        this.f19899i = egoProfileSwipeUnitItemView;
        this.f19891a = egoProfileSwipeUnitItemView.c(2131561158);
        this.f19892b = (FbDraweeView) egoProfileSwipeUnitItemView.c(2131561159);
        this.f19893c = (TextView) egoProfileSwipeUnitItemView.c(2131561160);
        this.f19894d = (TextView) egoProfileSwipeUnitItemView.c(2131561162);
        this.f19895e = (TextView) egoProfileSwipeUnitItemView.c(2131561163);
        this.f19896f = (GlyphView) egoProfileSwipeUnitItemView.c(2131561164);
        this.f19897g = (ViewStub) egoProfileSwipeUnitItemView.c(2131561157);
        this.f19893c.setMovementMethod(LinkMovementMethod.getInstance());
        this.f19894d.setMovementMethod(LinkMovementMethod.getInstance());
        this.f19895e.setMovementMethod(LinkMovementMethod.getInstance());
        TrackingNodes.a(this.f19893c, TrackingNode.TITLE);
        TrackingNodes.a(this.f19894d, TrackingNode.SUBTITLE);
        TrackingNodes.a(this.f19895e, TrackingNode.DESCRIPTION);
        TrackingNodes.a(this.f19896f, TrackingNode.ACTION_ICON);
    }
}
