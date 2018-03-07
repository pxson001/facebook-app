package com.facebook.imagepipeline.animated.base;

/* compiled from: TREEHOUSE_GROUP_INFO */
public class AnimatedDrawableFrameInfo {
    public final int f13598a;
    public final int f13599b;
    public final int f13600c;
    public final int f13601d;
    public final int f13602e;
    public final boolean f13603f;
    public final DisposalMethod f13604g;

    /* compiled from: TREEHOUSE_GROUP_INFO */
    public enum DisposalMethod {
        DISPOSE_DO_NOT,
        DISPOSE_TO_BACKGROUND,
        DISPOSE_TO_PREVIOUS
    }

    public AnimatedDrawableFrameInfo(int i, int i2, int i3, int i4, int i5, boolean z, DisposalMethod disposalMethod) {
        this.f13598a = i;
        this.f13599b = i2;
        this.f13600c = i3;
        this.f13601d = i4;
        this.f13602e = i5;
        this.f13603f = z;
        this.f13604g = disposalMethod;
    }
}
