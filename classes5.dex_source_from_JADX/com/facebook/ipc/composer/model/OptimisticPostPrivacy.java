package com.facebook.ipc.composer.model;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;

/* compiled from: TIMELINE_FRIENDS_PAGELET */
public final class OptimisticPostPrivacy {
    public static final OptimisticPostPrivacy f14002a = new OptimisticPostPrivacy("custom", "");
    public static final OptimisticPostPrivacy f14003b = new OptimisticPostPrivacy("everyone", "");
    @Nonnull
    public final String f14004c;
    @Nonnull
    public final String f14005d;

    public OptimisticPostPrivacy(String str, String str2) {
        this.f14004c = (String) Preconditions.checkNotNull(str);
        this.f14005d = Strings.nullToEmpty(str2);
    }
}
