package com.google.common.base;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.IOException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_rating2/clearable/default_optin/terms_and_conditions_text_key */
public class Joiner {
    public final String separator;

    /* compiled from: zero_rating2/clearable/default_optin/terms_and_conditions_text_key */
    public final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        public MapJoiner(Joiner joiner, String str) {
            this.joiner = joiner;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(str);
        }

        @CheckReturnValue
        public final String join(Map<?, ?> map) {
            return appendTo(new StringBuilder(), map.entrySet().iterator()).toString();
        }

        @Beta
        public final <A extends Appendable> A appendTo(A a, Iterator<? extends Entry<?, ?>> it) {
            Preconditions.checkNotNull(a);
            if (it.hasNext()) {
                Entry entry = (Entry) it.next();
                a.append(this.joiner.toString(entry.getKey()));
                a.append(this.keyValueSeparator);
                a.append(this.joiner.toString(entry.getValue()));
                while (it.hasNext()) {
                    a.append(this.joiner.separator);
                    entry = (Entry) it.next();
                    a.append(this.joiner.toString(entry.getKey()));
                    a.append(this.keyValueSeparator);
                    a.append(this.joiner.toString(entry.getValue()));
                }
            }
            return a;
        }

        @Beta
        public final StringBuilder appendTo(StringBuilder stringBuilder, Iterator<? extends Entry<?, ?>> it) {
            try {
                appendTo((Appendable) stringBuilder, (Iterator) it);
                return stringBuilder;
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* compiled from: zero_rating2/clearable/default_optin/terms_and_conditions_text_key */
    public final class C07133 extends AbstractList<Object> {
        final /* synthetic */ Object val$first;
        final /* synthetic */ Object[] val$rest;
        final /* synthetic */ Object val$second;

        public C07133(Object[] objArr, Object obj, Object obj2) {
            this.val$rest = objArr;
            this.val$first = obj;
            this.val$second = obj2;
        }

        public final int size() {
            return this.val$rest.length + 2;
        }

        public final Object get(int i) {
            switch (i) {
                case 0:
                    return this.val$first;
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    return this.val$second;
                default:
                    return this.val$rest[i - 2];
            }
        }
    }

    @CheckReturnValue
    public static Joiner on(String str) {
        return new Joiner(str);
    }

    @CheckReturnValue
    public static Joiner on(char c) {
        return new Joiner(String.valueOf(c));
    }

    private Joiner(String str) {
        this.separator = (String) Preconditions.checkNotNull(str);
    }

    public Joiner(Joiner joiner) {
        this.separator = joiner.separator;
    }

    public <A extends Appendable> A appendTo(A a, Iterator<?> it) {
        Preconditions.checkNotNull(a);
        if (it.hasNext()) {
            a.append(toString(it.next()));
            while (it.hasNext()) {
                a.append(this.separator);
                a.append(toString(it.next()));
            }
        }
        return a;
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterable<?> iterable) {
        return appendTo(stringBuilder, iterable.iterator());
    }

    public final StringBuilder appendTo(StringBuilder stringBuilder, Iterator<?> it) {
        try {
            appendTo((Appendable) stringBuilder, (Iterator) it);
            return stringBuilder;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    @CheckReturnValue
    public final String join(Iterable<?> iterable) {
        return appendTo(new StringBuilder(), iterable.iterator()).toString();
    }

    @CheckReturnValue
    public final String join(Object[] objArr) {
        return join(Arrays.asList(objArr));
    }

    @CheckReturnValue
    public Joiner useForNull(final String str) {
        Preconditions.checkNotNull(str);
        return new Joiner(this) {
            CharSequence toString(@Nullable Object obj) {
                return obj == null ? str : Joiner.this.toString(obj);
            }

            public Joiner useForNull(String str) {
                throw new UnsupportedOperationException("already specified useForNull");
            }

            public Joiner skipNulls() {
                throw new UnsupportedOperationException("already specified useForNull");
            }
        };
    }

    @CheckReturnValue
    public Joiner skipNulls() {
        return new 2(this, this);
    }

    @CheckReturnValue
    public MapJoiner withKeyValueSeparator(String str) {
        return new MapJoiner(this, str);
    }

    CharSequence toString(Object obj) {
        Preconditions.checkNotNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    @CheckReturnValue
    public final String join(@Nullable Object obj, @Nullable Object obj2, Object... objArr) {
        Preconditions.checkNotNull(objArr);
        return join((Iterable) new C07133(objArr, obj, obj2));
    }
}
