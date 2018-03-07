package com.facebook.video.creativeediting.utilities;

import com.facebook.inject.InjectorLike;
import com.facebook.video.creativeediting.VideoTrimmingController.C11792;
import com.google.common.base.Preconditions;

/* compiled from: dont_load_templates */
public class ZoomPositionConverter {
    public int f15654a;
    public int f15655b;
    public int f15656c;
    public C11792 f15657d;

    public static ZoomPositionConverter m19614a(InjectorLike injectorLike) {
        return new ZoomPositionConverter();
    }

    public final int m19615a(int i) {
        Preconditions.checkState(this.f15654a != 0);
        return ((((i - this.f15657d.m19503a()) - this.f15656c) * this.f15655b) / this.f15654a) + this.f15656c;
    }

    public final int m19616b(int i) {
        Preconditions.checkState(this.f15655b != 0);
        return ((((i - this.f15656c) * this.f15654a) / this.f15655b) + this.f15657d.m19503a()) + this.f15656c;
    }
}
