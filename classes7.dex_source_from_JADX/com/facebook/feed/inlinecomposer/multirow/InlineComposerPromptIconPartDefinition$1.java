package com.facebook.feed.inlinecomposer.multirow;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.feed.inlinecomposer.multirow.InlineComposerPromptIconPartDefinition.State;
import javax.annotation.Nullable;

/* compiled from: android_groups_new_member_exp_cta_click */
class InlineComposerPromptIconPartDefinition$1 extends BaseControllerListener {
    final /* synthetic */ State f19247a;
    final /* synthetic */ InlineComposerPromptIconPartDefinition f19248b;

    InlineComposerPromptIconPartDefinition$1(InlineComposerPromptIconPartDefinition inlineComposerPromptIconPartDefinition, State state) {
        this.f19248b = inlineComposerPromptIconPartDefinition;
        this.f19247a = state;
    }

    public final void m22755a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        if (this.f19247a.f != null) {
            this.f19247a.f.c();
        }
    }
}
