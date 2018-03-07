package com.facebook.drawee.callercontext;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.internal.Objects;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: message_capping_android */
public class FbDraweeCallerContext {
    public static final FbDraweeCallerContext f14345a = new FbDraweeCallerContext(CallerContext.f5180a, false);
    public final CallerContext f14346b;
    public final boolean f14347c;

    public FbDraweeCallerContext(CallerContext callerContext, boolean z) {
        this.f14346b = callerContext;
        this.f14347c = z;
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20542a(this.f14346b.toString()).m20545a("Is TTL Enabled", this.f14347c).toString();
    }

    public int hashCode() {
        return Objects.m20536a(this.f14346b, Boolean.valueOf(this.f14347c));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FbDraweeCallerContext)) {
            return false;
        }
        FbDraweeCallerContext fbDraweeCallerContext = (FbDraweeCallerContext) obj;
        if (this.f14346b.equals(fbDraweeCallerContext.f14346b) && this.f14347c == fbDraweeCallerContext.f14347c) {
            return true;
        }
        return false;
    }
}
