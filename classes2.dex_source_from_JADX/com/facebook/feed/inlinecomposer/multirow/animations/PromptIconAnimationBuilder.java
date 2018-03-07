package com.facebook.feed.inlinecomposer.multirow.animations;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper.CanHideShowPromptOnClickListener;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptIcon;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: message_push_data */
public class PromptIconAnimationBuilder<V extends View & HasPromptIcon> implements AnimationBuilder<PromptViewState$Visibility, V> {
    private final DefaultAnimationPartFactory f14322a;
    public final CanHideShowPromptOnClickListener f14323b;

    public final void mo2759a(List list, Object obj, Object obj2, View view) {
        PromptViewState$Visibility promptViewState$Visibility = (PromptViewState$Visibility) obj;
        PromptViewState$Visibility promptViewState$Visibility2 = (PromptViewState$Visibility) obj2;
        if (promptViewState$Visibility != promptViewState$Visibility2) {
            if (promptViewState$Visibility == PromptViewState$Visibility.MAXIMIZED) {
                m20693b(list, ((HasPromptIcon) view).getIconView());
            }
            if (promptViewState$Visibility2 == PromptViewState$Visibility.MAXIMIZED) {
                m20692a(list, ((HasPromptIcon) view).getIconView());
            }
        }
    }

    public PromptIconAnimationBuilder(DefaultAnimationPartFactory defaultAnimationPartFactory, CanHideShowPromptOnClickListener canHideShowPromptOnClickListener) {
        this.f14322a = defaultAnimationPartFactory;
        this.f14323b = canHideShowPromptOnClickListener;
    }

    @Nullable
    public final Runnable mo2758a(Object obj, Object obj2, View view) {
        return new 1(this, view);
    }

    private void m20692a(List<PersistentAnimation> list, FbDraweeView fbDraweeView) {
        list.add(m20691a(fbDraweeView, false));
    }

    private void m20693b(List<PersistentAnimation> list, FbDraweeView fbDraweeView) {
        list.add(this.f14322a.m19390a(200, null));
        list.add(m20691a(fbDraweeView, true));
    }

    private PersistentAnimation m20691a(FbDraweeView fbDraweeView, boolean z) {
        float f = 0.8f;
        DefaultAnimationPartFactory defaultAnimationPartFactory = this.f14322a;
        float f2 = z ? 1.0f : 0.8f;
        if (!z) {
            f = 1.0f;
        }
        PersistentAnimation a = defaultAnimationPartFactory.m19393a((Object) fbDraweeView, 150, f2, f, null);
        defaultAnimationPartFactory = this.f14322a;
        Object colorSaturationAnimatorUpdateListener = new ColorSaturationAnimatorUpdateListener(fbDraweeView);
        if (z) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        return this.f14322a.m19392a(ImmutableList.of(a, defaultAnimationPartFactory.m19393a(colorSaturationAnimatorUpdateListener, 150, f2, z ? 0.0f : 1.0f, null)), 150, null);
    }
}
