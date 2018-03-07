package com.facebook.feed.rows.animations;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.ui.animations.persistent.PersistentAnimation;
import java.util.List;

/* compiled from: message_images */
public interface AnimationBuilder<D, V extends View> {
    @Nullable
    Runnable mo2758a(D d, D d2, V v);

    void mo2759a(List<PersistentAnimation> list, D d, D d2, V v);
}
