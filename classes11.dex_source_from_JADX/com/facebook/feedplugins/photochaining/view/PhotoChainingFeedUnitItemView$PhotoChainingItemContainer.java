package com.facebook.feedplugins.photochaining.view;

import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;

/* compiled from: collections_section */
public class PhotoChainingFeedUnitItemView$PhotoChainingItemContainer {
    public final FbDraweeView f8601a;
    public FbTextView f8602b;
    public FbTextView f8603c;
    final /* synthetic */ PhotoChainingFeedUnitItemView f8604d;

    public PhotoChainingFeedUnitItemView$PhotoChainingItemContainer(PhotoChainingFeedUnitItemView photoChainingFeedUnitItemView) {
        this.f8604d = photoChainingFeedUnitItemView;
        this.f8601a = (FbDraweeView) photoChainingFeedUnitItemView.c(2131565877);
        this.f8602b = (FbTextView) photoChainingFeedUnitItemView.c(2131565878);
        this.f8603c = (FbTextView) photoChainingFeedUnitItemView.c(2131565879);
        TrackingNodes.a(this.f8601a, TrackingNode.PHOTO);
    }
}
