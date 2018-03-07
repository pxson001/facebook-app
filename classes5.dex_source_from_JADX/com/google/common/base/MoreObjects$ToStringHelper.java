package com.google.common.base;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: canHandleSentryWarning */
public final class MoreObjects$ToStringHelper {
    private final String className;
    private ValueHolder holderHead = new ValueHolder();
    private ValueHolder holderTail = this.holderHead;
    private boolean omitNullValues = false;

    /* compiled from: canHandleSentryWarning */
    final class ValueHolder {
        String name;
        ValueHolder next;
        Object value;
    }

    public MoreObjects$ToStringHelper(String str) {
        this.className = (String) Preconditions.checkNotNull(str);
    }

    public final MoreObjects$ToStringHelper add(String str, @Nullable Object obj) {
        return addHolder(str, obj);
    }

    public final MoreObjects$ToStringHelper add(String str, boolean z) {
        return addHolder(str, String.valueOf(z));
    }

    public final MoreObjects$ToStringHelper add(String str, float f) {
        return addHolder(str, String.valueOf(f));
    }

    public final MoreObjects$ToStringHelper add(String str, int i) {
        return addHolder(str, String.valueOf(i));
    }

    public final MoreObjects$ToStringHelper add(String str, long j) {
        return addHolder(str, String.valueOf(j));
    }

    public final MoreObjects$ToStringHelper addValue(@Nullable Object obj) {
        return addHolder(obj);
    }

    @CheckReturnValue
    public final String toString() {
        boolean z = this.omitNullValues;
        StringBuilder append = new StringBuilder(32).append(this.className).append('{');
        String str = "";
        for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
            Object obj = valueHolder.value;
            if (!z || obj != null) {
                append.append(str);
                str = ", ";
                if (valueHolder.name != null) {
                    append.append(valueHolder.name).append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    append.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    append.append(deepToString.substring(1, deepToString.length() - 1));
                }
            }
        }
        return append.append('}').toString();
    }

    private ValueHolder addHolder() {
        ValueHolder valueHolder = new ValueHolder();
        this.holderTail.next = valueHolder;
        this.holderTail = valueHolder;
        return valueHolder;
    }

    private MoreObjects$ToStringHelper addHolder(@Nullable Object obj) {
        addHolder().value = obj;
        return this;
    }

    private MoreObjects$ToStringHelper addHolder(String str, @Nullable Object obj) {
        ValueHolder addHolder = addHolder();
        addHolder.value = obj;
        addHolder.name = (String) Preconditions.checkNotNull(str);
        return this;
    }
}
