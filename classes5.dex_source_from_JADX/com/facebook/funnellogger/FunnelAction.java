package com.facebook.funnellogger;

import javax.annotation.Nullable;

/* compiled from: WWW_LOCAL_SERP */
public class FunnelAction {
    public final String f12318a;
    @Nullable
    public final String f12319b;
    @Nullable
    public final PayloadBundle f12320c;
    public final int f12321d;

    FunnelAction(String str, int i, @Nullable String str2) {
        this.f12318a = str;
        this.f12321d = i;
        this.f12319b = str2;
        this.f12320c = null;
    }

    FunnelAction(String str, int i, @Nullable String str2, @Nullable PayloadBundle payloadBundle) {
        this.f12318a = str;
        this.f12321d = i;
        this.f12319b = str2;
        this.f12320c = payloadBundle;
    }
}
