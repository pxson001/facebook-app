package com.facebook.widget.animatablelistview;

import com.facebook.widget.animatablelistview.custom.AnimatingListViewCustomAnimation;
import com.google.common.base.Supplier;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.os.SystemProperties */
public class AnimatingListMutation<T> {
    public final MutationType f20485a;
    public final List<? extends T> f20486b;
    public final Supplier<AnimatingListViewCustomAnimation> f20487c;
    public final int f20488d;

    /* compiled from: android.os.SystemProperties */
    public enum MutationType {
        ADD,
        ADD_WITH_ANIMATION_UP,
        ADD_WITH_ANIMATION_DOWN,
        REMOVE,
        REMOVE_WITH_ANIMATION_UP,
        REMOVE_WITH_ANIMATION_DOWN,
        FADE_IN,
        FADE_OUT,
        REPLACE,
        MARKED_FOR_REPLACE,
        CUSTOM
    }

    public AnimatingListMutation(List<? extends T> list, MutationType mutationType, int i) {
        this.f20486b = list;
        this.f20485a = mutationType;
        this.f20487c = null;
        this.f20488d = i;
    }

    AnimatingListMutation(Supplier<AnimatingListViewCustomAnimation> supplier) {
        this.f20486b = null;
        this.f20485a = MutationType.CUSTOM;
        this.f20487c = supplier;
        this.f20488d = -1;
    }

    public final int m20045c() {
        return this.f20486b != null ? this.f20486b.size() : 0;
    }
}
