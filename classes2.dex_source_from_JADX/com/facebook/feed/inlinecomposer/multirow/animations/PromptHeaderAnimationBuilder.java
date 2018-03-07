package com.facebook.feed.inlinecomposer.multirow.animations;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import java.util.List;

/* compiled from: integration_point */
public class PromptHeaderAnimationBuilder<V extends View & HasPromptFlyout> implements AnimationBuilder<PromptViewState$Visibility, V> {
    public final DefaultAnimationPartFactory f19754a;

    public final void mo2759a(List list, Object obj, Object obj2, View view) {
        PromptViewState$Visibility promptViewState$Visibility = (PromptViewState$Visibility) obj;
        PromptViewState$Visibility promptViewState$Visibility2 = (PromptViewState$Visibility) obj2;
        if (promptViewState$Visibility != promptViewState$Visibility2) {
            if (promptViewState$Visibility == PromptViewState$Visibility.MAXIMIZED) {
                list.add(this.f19754a.m19390a(200, null));
                list.add(this.f19754a.m19391a(view, 200, ((HasPromptFlyout) view).getCollapsedHeight() + ((HasPromptFlyout) view).getExpandedFlyoutHeight(), ((HasPromptFlyout) view).getCollapsedHeight(), null));
            }
            if (promptViewState$Visibility2 == PromptViewState$Visibility.MAXIMIZED) {
                list.add(m27439a(view));
            }
        }
    }

    public PromptHeaderAnimationBuilder(DefaultAnimationPartFactory defaultAnimationPartFactory) {
        this.f19754a = defaultAnimationPartFactory;
    }

    @Nullable
    public final Runnable mo2758a(Object obj, Object obj2, View view) {
        return null;
    }

    private PersistentAnimation m27439a(V v) {
        int collapsedHeight = ((HasPromptFlyout) v).getCollapsedHeight();
        return this.f19754a.m19391a((View) v, 200, collapsedHeight, collapsedHeight + ((HasPromptFlyout) v).getExpandedFlyoutHeight(), null);
    }
}
