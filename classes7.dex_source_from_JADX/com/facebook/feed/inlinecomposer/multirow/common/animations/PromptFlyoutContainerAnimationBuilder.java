package com.facebook.feed.inlinecomposer.multirow.common.animations;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.productionprompts.model.PromptViewState.Visibility;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import java.util.List;

/* compiled from: android.media.MediaRouteProviderService */
public class PromptFlyoutContainerAnimationBuilder<V extends View & HasPromptFlyout> implements AnimationBuilder<Visibility, V> {
    private final Context f19306a;
    private final DefaultAnimationPartFactory f19307b;

    public final void m22781a(List list, Object obj, Object obj2, View view) {
        Visibility visibility = (Visibility) obj;
        Visibility visibility2 = (Visibility) obj2;
        if (visibility != visibility2) {
            if (visibility == Visibility.MAXIMIZED) {
                list.add(this.f19307b.a(200, null));
                list.add(m22779b(view));
            }
            if (visibility2 == Visibility.MAXIMIZED) {
                list.add(m22777a(view));
            }
        }
    }

    public PromptFlyoutContainerAnimationBuilder(Context context, DefaultAnimationPartFactory defaultAnimationPartFactory) {
        this.f19306a = context;
        this.f19307b = defaultAnimationPartFactory;
    }

    @Nullable
    public final Runnable m22780a(Object obj, Object obj2, View view) {
        return null;
    }

    private PersistentAnimation m22777a(V v) {
        return this.f19307b.a(v, 200, 0, m22778b() + ((HasPromptFlyout) v).getExpandedFlyoutHeight(), m22776a(v, true));
    }

    private PersistentAnimation m22779b(V v) {
        return this.f19307b.a(v, 200, m22778b() + ((HasPromptFlyout) v).getExpandedFlyoutHeight(), 0, m22776a(v, false));
    }

    private int m22778b() {
        return this.f19306a.getResources().getDimensionPixelSize(2131430478) + this.f19306a.getResources().getDimensionPixelSize(2131430477);
    }

    private AnimatorListener m22776a(final V v, final boolean z) {
        return new AnimatorListener(this) {
            final /* synthetic */ PromptFlyoutContainerAnimationBuilder f19305c;

            public void onAnimationStart(Animator animator) {
                if (z) {
                    v.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }
        };
    }
}
