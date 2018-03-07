package com.facebook.backstage.consumption;

import com.facebook.backstage.data.BackstageProfile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.HashSet;
import java.util.Set;

/* compiled from: sdkInitialize */
public class AudienceControlOptimisticStore {
    private final Set<String> f4483a = new HashSet();

    public final Builder m4453a(Builder<BackstageProfile> builder) {
        if (this.f4483a.isEmpty()) {
            return builder;
        }
        Builder<BackstageProfile> builder2 = ImmutableList.builder();
        ImmutableList b = builder.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            BackstageProfile backstageProfile = (BackstageProfile) b.get(i);
            if (!this.f4483a.contains(backstageProfile.f5112a)) {
                builder2.c(backstageProfile);
            }
        }
        return builder2;
    }
}
