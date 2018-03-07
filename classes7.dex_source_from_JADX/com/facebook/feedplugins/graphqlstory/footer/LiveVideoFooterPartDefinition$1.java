package com.facebook.feedplugins.graphqlstory.footer;

import android.view.View;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.ui.Footer.ButtonClickedListener;
import com.facebook.feedplugins.base.footer.ui.Footer.FooterButtonId;

/* compiled from: Skipped pssh atom (failed to extract uuid) */
public class LiveVideoFooterPartDefinition$1 implements ButtonClickedListener {
    final /* synthetic */ FeedProps f23256a;
    final /* synthetic */ CanFeedback f23257b;
    final /* synthetic */ LiveVideoFooterPartDefinition f23258c;

    public LiveVideoFooterPartDefinition$1(LiveVideoFooterPartDefinition liveVideoFooterPartDefinition, FeedProps feedProps, CanFeedback canFeedback) {
        this.f23258c = liveVideoFooterPartDefinition;
        this.f23256a = feedProps;
        this.f23257b = canFeedback;
    }

    public final void m25630a(View view, FooterButtonId footerButtonId) {
        LiveVideoFooterPartDefinition.a(this.f23258c, this.f23256a, view, this.f23257b, footerButtonId);
    }
}
