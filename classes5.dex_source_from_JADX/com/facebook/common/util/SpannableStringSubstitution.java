package com.facebook.common.util;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: sgny */
public class SpannableStringSubstitution {
    public final Object f2784a;
    public final int f2785b;
    @Nullable
    public final Object f2786c;
    public final int f2787d;

    public SpannableStringSubstitution(Object obj) {
        this(obj, 0, null, 0);
    }

    public SpannableStringSubstitution(Object obj, Object obj2, int i) {
        this(obj, 0, obj2, i);
    }

    public SpannableStringSubstitution(int i, Object obj, int i2) {
        this(null, i, obj, i2);
    }

    private SpannableStringSubstitution(Object obj, int i, Object obj2, int i2) {
        boolean z = (obj == null && i == 0) ? false : true;
        Preconditions.checkArgument(z);
        this.f2784a = obj;
        this.f2785b = i;
        this.f2786c = obj2;
        this.f2787d = i2;
    }
}
