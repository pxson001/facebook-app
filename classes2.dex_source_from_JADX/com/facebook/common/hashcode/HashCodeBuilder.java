package com.facebook.common.hashcode;

import com.facebook.common.preconditions.Preconditions;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: messenger_custom_nicknames */
public class HashCodeBuilder {
    private int f14114a = 1;

    private HashCodeBuilder() {
    }

    public static HashCodeBuilder m20428a() {
        return new HashCodeBuilder();
    }

    public final HashCodeBuilder m20429a(int i) {
        this.f14114a = (this.f14114a * 31) + i;
        return this;
    }

    public final HashCodeBuilder m20430a(Object obj) {
        boolean z;
        int i = 0;
        if (obj == null || !obj.getClass().isArray()) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.m2016a(z);
        if (obj != null) {
            i = obj.hashCode();
        }
        return m20429a(i);
    }

    public int hashCode() {
        return this.f14114a;
    }
}
