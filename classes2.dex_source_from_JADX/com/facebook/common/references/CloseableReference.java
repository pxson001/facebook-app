package com.facebook.common.references;

import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.Preconditions;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: page/<p$1> */
public final class CloseableReference<T> implements Closeable, Cloneable {
    private static Class<CloseableReference> f10555a = CloseableReference.class;
    private static final ResourceReleaser<Closeable> f10556b = new C06251();
    @GuardedBy("this")
    private boolean f10557c = false;
    private final SharedReference<T> f10558d;

    /* compiled from: page/<p$1> */
    final class C06251 implements ResourceReleaser<Closeable> {
        C06251() {
        }

        public final void mo2019a(Object obj) {
            try {
                Closeables.a((Closeable) obj, true);
            } catch (IOException e) {
            }
        }
    }

    public final /* synthetic */ Object clone() {
        return m15683b();
    }

    private CloseableReference(SharedReference<T> sharedReference) {
        this.f10558d = (SharedReference) Preconditions.a(sharedReference);
        sharedReference.m24535b();
    }

    private CloseableReference(T t, ResourceReleaser<T> resourceReleaser) {
        this.f10558d = new SharedReference(t, resourceReleaser);
    }

    @Nullable
    public static <T extends Closeable> CloseableReference<T> m15675a(@Nullable T t) {
        if (t == null) {
            return null;
        }
        return new CloseableReference(t, f10556b);
    }

    @Nullable
    public static <T> CloseableReference<T> m15676a(@Nullable T t, ResourceReleaser<T> resourceReleaser) {
        if (t == null) {
            return null;
        }
        return new CloseableReference(t, resourceReleaser);
    }

    public final void close() {
        synchronized (this) {
            if (this.f10557c) {
                return;
            }
            this.f10557c = true;
            this.f10558d.m24536c();
        }
    }

    public final synchronized T m15682a() {
        Preconditions.b(!this.f10557c);
        return this.f10558d.m24534a();
    }

    public final synchronized CloseableReference<T> m15683b() {
        Preconditions.b(m15685d());
        return new CloseableReference(this.f10558d);
    }

    public final synchronized CloseableReference<T> m15684c() {
        return m15685d() ? new CloseableReference(this.f10558d) : null;
    }

    public final synchronized boolean m15685d() {
        return !this.f10557c;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final void finalize() {
        /*
        r5 = this;
        monitor-enter(r5);	 Catch:{ all -> 0x0048 }
        r0 = r5.f10557c;	 Catch:{ all -> 0x0045 }
        if (r0 == 0) goto L_0x000a;
    L_0x0005:
        monitor-exit(r5);	 Catch:{ all -> 0x0045 }
        super.finalize();
    L_0x0009:
        return;
    L_0x000a:
        monitor-exit(r5);	 Catch:{  }
        r0 = f10555a;	 Catch:{  }
        r1 = "Finalized without closing: %x %x (type = %s)";
        r2 = 3;
        r2 = new java.lang.Object[r2];	 Catch:{  }
        r3 = 0;
        r4 = java.lang.System.identityHashCode(r5);	 Catch:{  }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{  }
        r2[r3] = r4;	 Catch:{  }
        r3 = 1;
        r4 = r5.f10558d;	 Catch:{  }
        r4 = java.lang.System.identityHashCode(r4);	 Catch:{  }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{  }
        r2[r3] = r4;	 Catch:{  }
        r3 = 2;
        r4 = r5.f10558d;	 Catch:{  }
        r4 = r4.m24534a();	 Catch:{  }
        r4 = r4.getClass();	 Catch:{  }
        r4 = r4.getSimpleName();	 Catch:{  }
        r2[r3] = r4;	 Catch:{  }
        com.facebook.common.logging.FLog.a(r0, r1, r2);	 Catch:{  }
        r5.close();	 Catch:{  }
        super.finalize();
        goto L_0x0009;
    L_0x0045:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0048:
        r0 = move-exception;
        super.finalize();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.references.CloseableReference.finalize():void");
    }

    public final synchronized int m15686e() {
        return m15685d() ? System.identityHashCode(this.f10558d.m24534a()) : 0;
    }

    public static boolean m15679a(@Nullable CloseableReference<?> closeableReference) {
        return closeableReference != null && closeableReference.m15685d();
    }

    @Nullable
    public static <T> CloseableReference<T> m15680b(@Nullable CloseableReference<T> closeableReference) {
        return closeableReference != null ? closeableReference.m15684c() : null;
    }

    public static <T> List<CloseableReference<T>> m15677a(Collection<CloseableReference<T>> collection) {
        if (collection == null) {
            return null;
        }
        List<CloseableReference<T>> arrayList = new ArrayList(collection.size());
        for (CloseableReference b : collection) {
            arrayList.add(m15680b(b));
        }
        return arrayList;
    }

    public static void m15681c(@Nullable CloseableReference<?> closeableReference) {
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public static void m15678a(@Nullable Iterable<? extends CloseableReference<?>> iterable) {
        if (iterable != null) {
            for (CloseableReference c : iterable) {
                m15681c(c);
            }
        }
    }
}
