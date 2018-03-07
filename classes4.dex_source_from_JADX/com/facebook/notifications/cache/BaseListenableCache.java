package com.facebook.notifications.cache;

import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: mms_media_count */
public abstract class BaseListenableCache<K, V> extends BaseCache<K, V> {
    private final DefaultAndroidThreadUtil f7619a;
    public volatile boolean f7620b = true;
    @GuardedBy("this")
    private final Set<OnChangeListener> f7621c = Sets.a();

    /* compiled from: mms_media_count */
    public interface OnChangeListener<V> {
        void mo910a(Collection<V> collection);
    }

    public BaseListenableCache(@Nullable Comparator<V> comparator, AndroidThreadUtil androidThreadUtil) {
        super(comparator);
        this.f7619a = (DefaultAndroidThreadUtil) Preconditions.checkNotNull(androidThreadUtil);
    }

    public final void m7945a(boolean z) {
        this.f7620b = z;
    }

    public final synchronized void m7944a(OnChangeListener onChangeListener) {
        Preconditions.checkNotNull(onChangeListener);
        this.f7621c.add(onChangeListener);
    }

    public final synchronized void m7946b(OnChangeListener onChangeListener) {
        Preconditions.checkNotNull(onChangeListener);
        this.f7621c.remove(onChangeListener);
        if (this.f7621c.isEmpty()) {
            getClass();
            m7958d();
        }
    }

    private synchronized Set<OnChangeListener> mo620g() {
        return ImmutableSet.copyOf(this.f7621c);
    }

    public final void m7948f() {
        final Collection b = m7953b();
        final Iterable g = mo620g();
        this.f7619a.a(new Runnable(this) {
            final /* synthetic */ BaseListenableCache f12787c;

            public void run() {
                for (OnChangeListener a : g) {
                    a.mo910a(b);
                }
            }
        });
    }

    protected void mo619e() {
        super.mo619e();
        if (this.f7620b) {
            m7948f();
        }
    }
}
