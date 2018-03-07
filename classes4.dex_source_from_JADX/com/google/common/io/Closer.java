package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import javax.annotation.Nullable;

@Beta
/* compiled from: foreground_location_location_failure */
public final class Closer implements Closeable {
    private static final Suppressor f11457b = ((SuppressingSuppressor.f11462b != null ? 1 : null) != null ? SuppressingSuppressor.f11461a : LoggingSuppressor.a);
    @VisibleForTesting
    final Suppressor f11458a;
    private final Deque<Closeable> f11459c = new ArrayDeque(4);
    private Throwable f11460d;

    @VisibleForTesting
    /* compiled from: foreground_location_location_failure */
    public final class SuppressingSuppressor implements Suppressor {
        static final SuppressingSuppressor f11461a = new SuppressingSuppressor();
        public static final Method f11462b = m11945b();

        SuppressingSuppressor() {
        }

        private static Method m11945b() {
            try {
                return Throwable.class.getMethod("addSuppressed", new Class[]{Throwable.class});
            } catch (Throwable th) {
                return null;
            }
        }

        public final void mo848a(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    f11462b.invoke(th, new Object[]{th2});
                } catch (Throwable th3) {
                    LoggingSuppressor.a.a(closeable, th, th2);
                }
            }
        }
    }

    @VisibleForTesting
    /* compiled from: foreground_location_location_failure */
    interface Suppressor {
        void mo848a(Closeable closeable, Throwable th, Throwable th2);
    }

    public static Closer m11942a() {
        return new Closer(f11457b);
    }

    @VisibleForTesting
    private Closer(Suppressor suppressor) {
        this.f11458a = (Suppressor) Preconditions.checkNotNull(suppressor);
    }

    public final <C extends Closeable> C m11943a(@Nullable C c) {
        if (c != null) {
            this.f11459c.addFirst(c);
        }
        return c;
    }

    public final RuntimeException m11944a(Throwable th) {
        Preconditions.checkNotNull(th);
        this.f11460d = th;
        Throwables.propagateIfPossible(th, IOException.class);
        throw new RuntimeException(th);
    }

    public final void close() {
        Throwable th = this.f11460d;
        while (!this.f11459c.isEmpty()) {
            Closeable closeable = (Closeable) this.f11459c.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.f11458a.mo848a(closeable, th, th2);
                }
            }
        }
        if (this.f11460d == null && th != null) {
            Throwables.propagateIfPossible(th, IOException.class);
            throw new AssertionError(th);
        }
    }
}
