package com.facebook.feed.inlinecomposer.multirow.animations;

import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptIcon;

/* compiled from: android.settings.LOCATION_SOURCE_SETTINGS */
class PromptIconAnimationBuilder$1 implements Runnable {
    final /* synthetic */ View f19256a;
    final /* synthetic */ PromptIconAnimationBuilder f19257b;

    PromptIconAnimationBuilder$1(PromptIconAnimationBuilder promptIconAnimationBuilder, View view) {
        this.f19257b = promptIconAnimationBuilder;
        this.f19256a = view;
    }

    public void run() {
        ((HasPromptIcon) this.f19256a).getIconView().setOnClickListener(this.f19257b.b);
    }
}
