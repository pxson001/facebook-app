package com.facebook.common.util;

import java.util.Collection;
import javax.annotation.Nullable;

/* compiled from: groups/create */
public class CollectionUtil {
    public static <T> boolean m29342a(Collection<T> collection) {
        return collection == null || collection.isEmpty();
    }

    public static <T> boolean m29343b(@Nullable Collection<T> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }
}
