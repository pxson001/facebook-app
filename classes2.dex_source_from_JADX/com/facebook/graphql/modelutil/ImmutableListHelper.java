package com.facebook.graphql.modelutil;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: mark_full_contact_sync_required */
public final class ImmutableListHelper {
    private static final ImmutableList f15084a = RegularImmutableList.f535a;

    @Nullable
    public static <T> ImmutableList<T> m21625a(@Nullable Collection<T> collection) {
        return collection == null ? null : ImmutableList.copyOf((Collection) collection);
    }

    @Nullable
    public static <T> ImmutableList<T> m21626a(@Nullable Iterator<T> it) {
        return it == null ? f15084a : ImmutableList.copyOf((Iterator) it);
    }
}
