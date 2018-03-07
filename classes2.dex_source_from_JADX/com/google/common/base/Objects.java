package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: time_between_updates_ms */
public final class Objects {

    @Deprecated
    /* compiled from: time_between_updates_ms */
    public final class ToStringHelper {
        private final String className;
        private ValueHolder holderHead = new ValueHolder();
        public ValueHolder holderTail = this.holderHead;
        private boolean omitNullValues = false;

        /* compiled from: time_between_updates_ms */
        public final class ValueHolder {
            String name;
            public ValueHolder next;
            Object value;
        }

        public ToStringHelper(String str) {
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public final ToStringHelper add(String str, @Nullable Object obj) {
            return addHolder(str, obj);
        }

        public final ToStringHelper add(String str, boolean z) {
            return addHolder(str, String.valueOf(z));
        }

        public final ToStringHelper add(String str, double d) {
            return addHolder(str, String.valueOf(d));
        }

        public final ToStringHelper add(String str, float f) {
            return addHolder(str, String.valueOf(f));
        }

        public final ToStringHelper add(String str, int i) {
            return addHolder(str, String.valueOf(i));
        }

        public final ToStringHelper add(String str, long j) {
            return addHolder(str, String.valueOf(j));
        }

        public final String toString() {
            boolean z = this.omitNullValues;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            ValueHolder valueHolder = this.holderHead.next;
            while (valueHolder != null) {
                if (!z || valueHolder.value != null) {
                    append.append(str);
                    str = ", ";
                    if (valueHolder.name != null) {
                        append.append(valueHolder.name).append('=');
                    }
                    append.append(valueHolder.value);
                }
                valueHolder = valueHolder.next;
            }
            return append.append('}').toString();
        }

        private ToStringHelper addHolder(String str, @Nullable Object obj) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            ValueHolder valueHolder2 = valueHolder;
            valueHolder2.value = obj;
            valueHolder2.name = (String) Preconditions.checkNotNull(str);
            return this;
        }
    }

    private Objects() {
    }

    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    @CheckReturnValue
    public static int hashCode(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    @CheckReturnValue
    @Deprecated
    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    @CheckReturnValue
    @Deprecated
    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }
}
