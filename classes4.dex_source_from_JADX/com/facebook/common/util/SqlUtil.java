package com.facebook.common.util;

import android.database.DatabaseUtils;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import javax.annotation.Nullable;

@Deprecated
/* compiled from: edges */
public class SqlUtil {

    /* compiled from: edges */
    public final class C06351 implements Function<Object, String> {
        public final Object apply(@Nullable Object obj) {
            return DatabaseUtils.sqlEscapeString(obj == null ? "null" : obj.toString());
        }
    }

    public static String m14313a(Iterable<?> iterable) {
        return "(" + Joiner.on(',').join(Iterables.a(iterable, new C06351())) + ")";
    }
}
