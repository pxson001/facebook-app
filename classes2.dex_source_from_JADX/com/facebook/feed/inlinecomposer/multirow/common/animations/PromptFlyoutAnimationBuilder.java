package com.facebook.feed.inlinecomposer.multirow.common.animations;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.inlinecomposer.v2attachment.V2Attachment;
import com.facebook.feed.rows.animations.AnimationBuilder;
import com.facebook.productionprompts.model.PromptViewState$Visibility;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: instant_shopping_catalog/?catalog_id={%s -1}&catalog_view={%s -1}&product_id={%s -1}&product_view={%s -1} */
public class PromptFlyoutAnimationBuilder<V extends View & HasPromptFlyout> implements AnimationBuilder<PromptViewState$Visibility, V> {
    private final Context f19763a;
    private final DefaultAnimationPartFactory f19764b;
    private final V2Attachment f19765c;
    public final OnClickListener f19766d;

    public final void mo2759a(List list, Object obj, Object obj2, View view) {
        PromptViewState$Visibility promptViewState$Visibility = (PromptViewState$Visibility) obj;
        PromptViewState$Visibility promptViewState$Visibility2 = (PromptViewState$Visibility) obj2;
        if (promptViewState$Visibility != promptViewState$Visibility2) {
            if (promptViewState$Visibility == PromptViewState$Visibility.MAXIMIZED) {
                list.add(m27445c(view));
            }
            if (promptViewState$Visibility2 == PromptViewState$Visibility.MAXIMIZED) {
                list.add(this.f19764b.m19390a(200, null));
                list.add(m27444b(view));
            }
        }
    }

    public PromptFlyoutAnimationBuilder(Context context, DefaultAnimationPartFactory defaultAnimationPartFactory, V2Attachment v2Attachment, OnClickListener onClickListener) {
        this.f19763a = context;
        this.f19764b = defaultAnimationPartFactory;
        this.f19765c = v2Attachment;
        this.f19766d = onClickListener;
    }

    @Nullable
    public final Runnable mo2758a(Object obj, Object obj2, View view) {
        return new 1(this, view);
    }

    private PersistentAnimation m27444b(V v) {
        return this.f19764b.m19392a(ImmutableList.of(this.f19764b.m19391a(((HasPromptFlyout) v).getFlyoutView(), 200, 0, ((HasPromptFlyout) v).getExpandedFlyoutHeight(), null), this.f19764b.m19393a(((HasPromptFlyout) v).getFlyoutView(), 200, 0.2f, 1.0f, null)), 200, new FlyoutAnimatorListener(v, true, m27443a(), this.f19765c));
    }

    private PersistentAnimation m27445c(V v) {
        return this.f19764b.m19392a(ImmutableList.of(this.f19764b.m19391a(((HasPromptFlyout) v).getFlyoutView(), 200, ((HasPromptFlyout) v).getExpandedFlyoutHeight(), 0, null), this.f19764b.m19393a(((HasPromptFlyout) v).getFlyoutView(), 200, 1.0f, 0.2f, null)), 200, new FlyoutAnimatorListener(v, false, m27443a(), this.f19765c));
    }

    @TargetApi(17)
    private float m27443a() {
        return (VERSION.SDK_INT < 17 || this.f19763a.getResources().getConfiguration().getLayoutDirection() != 1) ? 0.9f : 0.1f;
    }
}
