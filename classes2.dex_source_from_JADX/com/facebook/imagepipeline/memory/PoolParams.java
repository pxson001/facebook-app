package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

/* compiled from: page_admin_panel_imp */
public class PoolParams {
    public final int f10497a;
    public final int f10498b;
    public final SparseIntArray f10499c;
    public final int f10500d;
    public final int f10501e;
    public final int f10502f;

    public PoolParams(int i, int i2, @Nullable SparseIntArray sparseIntArray) {
        this(i, i2, sparseIntArray, 0, Integer.MAX_VALUE, -1);
    }

    public PoolParams(int i, int i2, @Nullable SparseIntArray sparseIntArray, int i3, int i4, int i5) {
        boolean z = i >= 0 && i2 >= i;
        Preconditions.b(z);
        this.f10498b = i;
        this.f10497a = i2;
        this.f10499c = sparseIntArray;
        this.f10500d = i3;
        this.f10501e = i4;
        this.f10502f = i5;
    }
}
