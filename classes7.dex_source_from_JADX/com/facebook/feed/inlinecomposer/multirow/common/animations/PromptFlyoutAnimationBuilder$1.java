package com.facebook.feed.inlinecomposer.multirow.common.animations;

import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;

/* compiled from: android.media.VOLUME_CHANGED_ACTION */
class PromptFlyoutAnimationBuilder$1 implements Runnable {
    final /* synthetic */ View f19301a;
    final /* synthetic */ PromptFlyoutAnimationBuilder f19302b;

    PromptFlyoutAnimationBuilder$1(PromptFlyoutAnimationBuilder promptFlyoutAnimationBuilder, View view) {
        this.f19302b = promptFlyoutAnimationBuilder;
        this.f19301a = view;
    }

    public void run() {
        ((HasPromptFlyout) this.f19301a).getFlyoutXoutButton().setOnClickListener(this.f19302b.d);
    }
}
