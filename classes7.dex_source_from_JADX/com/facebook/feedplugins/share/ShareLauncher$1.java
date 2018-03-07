package com.facebook.feedplugins.share;

import android.view.View;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.share.ShareMenuPopoverFactory.WritePostOnClickCallback;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.ipc.composer.model.ComposerSourceType;

/* compiled from: remoteModuleConfig */
class ShareLauncher$1 implements WritePostOnClickCallback {
    final /* synthetic */ FeedProps f5282a;
    final /* synthetic */ View f5283b;
    final /* synthetic */ ComposerSourceType f5284c;
    final /* synthetic */ Surface f5285d;
    final /* synthetic */ ShareLauncher f5286e;

    ShareLauncher$1(ShareLauncher shareLauncher, FeedProps feedProps, View view, ComposerSourceType composerSourceType, Surface surface) {
        this.f5286e = shareLauncher;
        this.f5282a = feedProps;
        this.f5283b = view;
        this.f5284c = composerSourceType;
        this.f5285d = surface;
    }

    public final void mo282a(String str) {
        ShareLauncher.a(this.f5286e, this.f5282a, this.f5283b, this.f5284c, this.f5285d, str);
    }
}
