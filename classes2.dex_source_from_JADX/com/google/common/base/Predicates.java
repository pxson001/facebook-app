package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible
@CheckReturnValue
/* compiled from: work_empty_feed_find_groups */
public final class Predicates {
    public static final Joiner COMMA_JOINER = Joiner.on(',');

    /* compiled from: work_empty_feed_find_groups */
    class InPredicate<T> implements Predicate<T>, Serializable {
        private final Collection<?> target;

        public InPredicate(Collection<?> collection) {
            this.target = (Collection) Preconditions.checkNotNull(collection);
        }

        public boolean apply(@Nullable T t) {
            boolean z = false;
            try {
                z = this.target.contains(t);
            } catch (NullPointerException e) {
            } catch (ClassCastException e2) {
            }
            return z;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof InPredicate)) {
                return false;
            }
            return this.target.equals(((InPredicate) obj).target);
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }
    }

    /* compiled from: work_empty_feed_find_groups */
    class NotPredicate<T> implements Predicate<T>, Serializable {
        final Predicate<T> predicate;

        NotPredicate(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        public boolean apply(@Nullable T t) {
            return !this.predicate.apply(t);
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof NotPredicate)) {
                return false;
            }
            return this.predicate.equals(((NotPredicate) obj).predicate);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    /* compiled from: work_empty_feed_find_groups */
    public enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE {
            public final boolean apply(@Nullable Object obj) {
                return true;
            }

            public final String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public final boolean apply(@Nullable Object obj) {
                return false;
            }

            public final String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public final boolean apply(@Nullable Object obj) {
                return obj == null;
            }

            public final String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public final boolean apply(@Nullable Object obj) {
                return obj != null;
            }

            public final String toString() {
                return "Predicates.notNull()";
            }
        };

        public <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    private Predicates() {
    }

    @GwtCompatible
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        Predicate predicate3 = (Predicate) Preconditions.checkNotNull(predicate);
        Predicate predicate4 = (Predicate) Preconditions.checkNotNull(predicate2);
        return new AndPredicate(Arrays.asList(new Predicate[]{predicate3, predicate4}));
    }

    public static <T> Predicate<T> equalTo(@Nullable T t) {
        return t == null ? ObjectPredicate.IS_NULL.withNarrowedType() : new IsEqualToPredicate(t);
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }
}
