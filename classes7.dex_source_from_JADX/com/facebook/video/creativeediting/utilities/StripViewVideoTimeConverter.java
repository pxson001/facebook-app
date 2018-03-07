package com.facebook.video.creativeediting.utilities;

import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: doodle_reset_count */
public class StripViewVideoTimeConverter {
    private final ZoomPositionConverter f15648a;
    public int f15649b = 1;
    public int f15650c = 1;
    public int f15651d = 0;

    @Inject
    public StripViewVideoTimeConverter(@Assisted ZoomPositionConverter zoomPositionConverter) {
        this.f15648a = zoomPositionConverter;
    }

    public final int m19603a(int i) {
        Preconditions.checkState(this.f15649b != 0);
        return ((this.f15650c * i) / this.f15649b) + this.f15651d;
    }

    public final int m19604a(int i, boolean z) {
        Preconditions.checkState(this.f15650c != 0);
        if (z) {
            i = this.f15648a.m19615a(i);
        }
        return ((i - this.f15651d) * this.f15649b) / this.f15650c;
    }

    public final int m19605a(boolean z, int i, int i2) {
        return m19604a(i2, z) - m19604a(i, z);
    }
}
