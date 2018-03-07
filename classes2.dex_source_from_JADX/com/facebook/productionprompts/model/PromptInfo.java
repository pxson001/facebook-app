package com.facebook.productionprompts.model;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: marauder_tier is null or empty */
public final class PromptInfo {
    public static final PromptInfo f15097a = new PromptInfo(null, null, 0.0d, null);
    @Nullable
    public final String f15098b;
    @Nullable
    public final String f15099c;
    public final double f15100d;
    public final String f15101e;

    public static PromptInfo m21642a(String str, String str2, double d, String str3) {
        return new PromptInfo(str, str2, d, str3);
    }

    private PromptInfo(String str, String str2, double d, String str3) {
        this.f15098b = str;
        this.f15099c = str2;
        this.f15100d = d;
        this.f15101e = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromptInfo)) {
            return false;
        }
        PromptInfo promptInfo = (PromptInfo) obj;
        boolean equals = this.f15098b == null ? promptInfo.f15098b == null : this.f15098b.equals(promptInfo.f15098b);
        boolean equals2 = this.f15099c == null ? promptInfo.f15099c == null : this.f15099c.equals(promptInfo.f15099c);
        boolean equals3 = this.f15101e == null ? promptInfo.f15101e == null : this.f15101e.equals(promptInfo.f15101e);
        if (Double.compare(promptInfo.f15100d, this.f15100d) == 0 && r0 && r3 && r4) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.f15098b == null ? 0 : this.f15098b.hashCode()) * 31;
        if (this.f15099c != null) {
            i = this.f15099c.hashCode();
        }
        hashCode += i;
        long doubleToLongBits = Double.doubleToLongBits(this.f15100d);
        return (hashCode * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)));
    }
}
