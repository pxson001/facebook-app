package com.facebook.remoteasset;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import javax.annotation.Nullable;

/* compiled from: pulseContextFooterButtons */
public class RemoteAsset {
    public String f4881a;
    public String f4882b;
    public String f4883c;
    private ImmutableMap<Integer, String> f4884d;

    /* compiled from: pulseContextFooterButtons */
    public final class Builder {
        public String f4877a;
        public String f4878b;
        public String f4879c;
        public com.google.common.collect.ImmutableMap.Builder f4880d;

        public final RemoteAsset m4791a() {
            return new RemoteAsset(this);
        }
    }

    public RemoteAsset(Builder builder) {
        this.f4881a = builder.f4877a;
        this.f4882b = builder.f4878b;
        this.f4883c = builder.f4879c;
        if (builder.f4880d != null) {
            this.f4884d = builder.f4880d.b();
        } else {
            this.f4884d = RegularImmutableBiMap.a;
        }
    }

    @Nullable
    public final String m4792a(Integer num) {
        if (this.f4884d == null || !this.f4884d.containsKey(num)) {
            return null;
        }
        return (String) this.f4884d.get(num);
    }
}
