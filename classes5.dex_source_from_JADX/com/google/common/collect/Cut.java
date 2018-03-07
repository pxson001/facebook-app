package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: calling accept() on FakeSocketImpl */
public abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    final C endpoint;

    /* compiled from: calling accept() on FakeSocketImpl */
    public final class AboveAll extends Cut<Comparable<?>> {
        public static final AboveAll f7294a = new AboveAll();

        public final /* synthetic */ int compareTo(Object obj) {
            return mo914a((Cut) obj);
        }

        private AboveAll() {
            super(null);
        }

        final Comparable<?> mo920c() {
            throw new IllegalStateException("range unbounded on this side");
        }

        final boolean mo917a(Comparable<?> comparable) {
            return false;
        }

        final BoundType mo915a() {
            throw new AssertionError("this statement should be unreachable");
        }

        final BoundType mo918b() {
            throw new IllegalStateException();
        }

        final void mo916a(StringBuilder stringBuilder) {
            throw new AssertionError();
        }

        final void mo919b(StringBuilder stringBuilder) {
            stringBuilder.append("+∞)");
        }

        public final int mo914a(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        public final String toString() {
            return "+∞";
        }

        private Object readResolve() {
            return f7294a;
        }
    }

    /* compiled from: calling accept() on FakeSocketImpl */
    final class AboveValue<C extends Comparable> extends Cut<C> {
        public final /* synthetic */ int compareTo(Object obj) {
            return super.mo914a((Cut) obj);
        }

        AboveValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        final boolean mo917a(C c) {
            return Range.m13609c(this.endpoint, c) < 0;
        }

        final BoundType mo915a() {
            return BoundType.OPEN;
        }

        final BoundType mo918b() {
            return BoundType.CLOSED;
        }

        final void mo916a(StringBuilder stringBuilder) {
            stringBuilder.append('(').append(this.endpoint);
        }

        final void mo919b(StringBuilder stringBuilder) {
            stringBuilder.append(this.endpoint).append(']');
        }

        public final int hashCode() {
            return this.endpoint.hashCode() ^ -1;
        }

        public final String toString() {
            return "/" + this.endpoint + "\\";
        }
    }

    /* compiled from: calling accept() on FakeSocketImpl */
    public final class BelowAll extends Cut<Comparable<?>> {
        public static final BelowAll f7295a = new BelowAll();

        public final /* synthetic */ int compareTo(Object obj) {
            return mo914a((Cut) obj);
        }

        private BelowAll() {
            super(null);
        }

        final Comparable<?> mo920c() {
            throw new IllegalStateException("range unbounded on this side");
        }

        final boolean mo917a(Comparable<?> comparable) {
            return true;
        }

        final BoundType mo915a() {
            throw new IllegalStateException();
        }

        final BoundType mo918b() {
            throw new AssertionError("this statement should be unreachable");
        }

        final void mo916a(StringBuilder stringBuilder) {
            stringBuilder.append("(-∞");
        }

        final void mo919b(StringBuilder stringBuilder) {
            throw new AssertionError();
        }

        public final int mo914a(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        public final String toString() {
            return "-∞";
        }

        private Object readResolve() {
            return f7295a;
        }
    }

    /* compiled from: calling accept() on FakeSocketImpl */
    final class BelowValue<C extends Comparable> extends Cut<C> {
        public final /* synthetic */ int compareTo(Object obj) {
            return super.mo914a((Cut) obj);
        }

        BelowValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        final boolean mo917a(C c) {
            return Range.m13609c(this.endpoint, c) <= 0;
        }

        final BoundType mo915a() {
            return BoundType.CLOSED;
        }

        final BoundType mo918b() {
            return BoundType.OPEN;
        }

        final void mo916a(StringBuilder stringBuilder) {
            stringBuilder.append('[').append(this.endpoint);
        }

        final void mo919b(StringBuilder stringBuilder) {
            stringBuilder.append(this.endpoint).append(')');
        }

        public final int hashCode() {
            return this.endpoint.hashCode();
        }

        public final String toString() {
            return "\\" + this.endpoint + "/";
        }
    }

    public abstract BoundType mo915a();

    abstract void mo916a(StringBuilder stringBuilder);

    abstract boolean mo917a(C c);

    public abstract BoundType mo918b();

    abstract void mo919b(StringBuilder stringBuilder);

    public /* synthetic */ int compareTo(Object obj) {
        return mo914a((Cut) obj);
    }

    Cut(@Nullable C c) {
        this.endpoint = c;
    }

    public int mo914a(Cut<C> cut) {
        if (cut == BelowAll.f7295a) {
            return 1;
        }
        if (cut == AboveAll.f7294a) {
            return -1;
        }
        int c = Range.m13609c(this.endpoint, cut.endpoint);
        if (c != 0) {
            return c;
        }
        boolean z = this instanceof AboveValue;
        int i = z == (cut instanceof AboveValue) ? 0 : z ? 1 : -1;
        return i;
    }

    C mo920c() {
        return this.endpoint;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            if (mo914a((Cut) obj) == 0) {
                return true;
            }
            return false;
        } catch (ClassCastException e) {
            return false;
        }
    }

    public static <C extends Comparable> Cut<C> m13293b(C c) {
        return new BelowValue(c);
    }

    public static <C extends Comparable> Cut<C> m13294c(C c) {
        return new AboveValue(c);
    }
}
