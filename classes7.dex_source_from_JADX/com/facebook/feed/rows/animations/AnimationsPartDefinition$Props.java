package com.facebook.feed.rows.animations;

import android.view.View;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import javax.annotation.Nullable;

/* compiled from: simplepicker_camera_button */
public final class AnimationsPartDefinition$Props<D, V extends View> {
    public final String f3692a;
    public final CacheableEntity f3693b;
    public final D f3694c;
    @Nullable
    public final D f3695d;
    public final AnimationBuilder<D, V> f3696e;

    public AnimationsPartDefinition$Props(D d, String str, CacheableEntity cacheableEntity, AnimationBuilder<D, V> animationBuilder, @Nullable D d2) {
        this.f3692a = str;
        this.f3694c = d;
        this.f3696e = animationBuilder;
        this.f3693b = cacheableEntity;
        this.f3695d = d2;
    }
}
