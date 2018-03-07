package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: bug_report_in_progress */
public final class Tables {
    private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> f7575a = new C08531();

    /* compiled from: bug_report_in_progress */
    final class C08531 implements Function<Map<Object, Object>, Map<Object, Object>> {
        C08531() {
        }

        public final Object apply(Object obj) {
            return Collections.unmodifiableMap((Map) obj);
        }
    }

    /* compiled from: bug_report_in_progress */
    public abstract class AbstractCell<R, C, V> {
        @Nullable
        public abstract R mo1002a();

        @Nullable
        public abstract C mo1003b();

        @Nullable
        public abstract V mo1004c();

        AbstractCell() {
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbstractCell)) {
                return false;
            }
            AbstractCell abstractCell = (AbstractCell) obj;
            if (Objects.equal(mo1002a(), abstractCell.mo1002a()) && Objects.equal(mo1003b(), abstractCell.mo1003b()) && Objects.equal(mo1004c(), abstractCell.mo1004c())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(new Object[]{mo1002a(), mo1003b(), mo1004c()});
        }

        public String toString() {
            return "(" + mo1002a() + "," + mo1003b() + ")=" + mo1004c();
        }
    }

    /* compiled from: bug_report_in_progress */
    public final class ImmutableCell<R, C, V> extends AbstractCell<R, C, V> implements Serializable {
        private final C columnKey;
        private final R rowKey;
        private final V value;

        public ImmutableCell(@Nullable R r, @Nullable C c, @Nullable V v) {
            this.rowKey = r;
            this.columnKey = c;
            this.value = v;
        }

        public final R mo1002a() {
            return this.rowKey;
        }

        public final C mo1003b() {
            return this.columnKey;
        }

        public final V mo1004c() {
            return this.value;
        }
    }

    private Tables() {
    }

    static boolean m13704a(Table<?, ?, ?> table, @Nullable Object obj) {
        if (obj == table) {
            return true;
        }
        if (!(obj instanceof Table)) {
            return false;
        }
        return table.b().equals(((Table) obj).b());
    }
}
