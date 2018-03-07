package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: time_between_updates_ms */
public final class Objects {

    /* compiled from: time_between_updates_ms */
    public final class ToStringHelper {
        private final String f14188a;
        private ValueHolder f14189b = new ValueHolder();
        private ValueHolder f14190c = this.f14189b;
        private boolean f14191d = false;

        public ToStringHelper(String str) {
            this.f14188a = (String) Preconditions.a(str);
        }

        public final ToStringHelper m20544a(String str, @Nullable Object obj) {
            return m20541b(str, obj);
        }

        public final ToStringHelper m20545a(String str, boolean z) {
            return m20541b(str, String.valueOf(z));
        }

        public final ToStringHelper m20543a(String str, int i) {
            return m20541b(str, String.valueOf(i));
        }

        public final ToStringHelper m20542a(@Nullable Object obj) {
            return m20540b(obj);
        }

        public final String toString() {
            boolean z = this.f14191d;
            StringBuilder append = new StringBuilder(32).append(this.f14188a).append('{');
            String str = "";
            ValueHolder valueHolder = this.f14189b.c;
            while (valueHolder != null) {
                if (!z || valueHolder.b != null) {
                    append.append(str);
                    str = ", ";
                    if (valueHolder.a != null) {
                        append.append(valueHolder.a).append('=');
                    }
                    append.append(valueHolder.b);
                }
                valueHolder = valueHolder.c;
            }
            return append.append('}').toString();
        }

        private ValueHolder m20539a() {
            ValueHolder valueHolder = new ValueHolder();
            this.f14190c.c = valueHolder;
            this.f14190c = valueHolder;
            return valueHolder;
        }

        private ToStringHelper m20540b(@Nullable Object obj) {
            m20539a().b = obj;
            return this;
        }

        private ToStringHelper m20541b(String str, @Nullable Object obj) {
            ValueHolder a = m20539a();
            a.b = obj;
            a.a = (String) Preconditions.a(str);
            return this;
        }
    }

    private Objects() {
    }

    @CheckReturnValue
    public static boolean m20538a(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int m20536a(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper m20537a(Object obj) {
        String replaceAll = obj.getClass().getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return new ToStringHelper(replaceAll.substring(lastIndexOf + 1));
    }
}
