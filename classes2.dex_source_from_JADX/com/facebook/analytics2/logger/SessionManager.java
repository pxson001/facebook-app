package com.facebook.analytics2.logger;

import android.database.Observable;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: teak_profiling */
public abstract class SessionManager {
    private final SessionManagerCallbackObservable f3145a = new SessionManagerCallbackObservable();
    @GuardedBy("this")
    @Nullable
    private String f3146b;
    @GuardedBy("this")
    private boolean f3147c;

    /* compiled from: teak_profiling */
    class SessionManagerCallbackObservable extends Observable<SessionManagerCallback> {
        public final void m5304a() {
            synchronized (this.mObservers) {
                int size = this.mObservers.size();
                for (int i = 0; i < size; i++) {
                    ((SessionDelegate) this.mObservers.get(i)).m5579a();
                }
            }
        }

        public final void m5306b() {
            synchronized (this.mObservers) {
                int size = this.mObservers.size();
                for (int i = 0; i < size; i++) {
                    ((SessionDelegate) this.mObservers.get(i)).m5581b();
                }
            }
        }

        public final void m5305a(String str) {
            synchronized (this.mObservers) {
                int size = this.mObservers.size();
                for (int i = 0; i < size; i++) {
                    ((SessionDelegate) this.mObservers.get(i)).m5580a(str);
                }
            }
        }

        public final void m5307c() {
            synchronized (this.mObservers) {
                int size = this.mObservers.size();
                for (int i = 0; i < size; i++) {
                    ((SessionDelegate) this.mObservers.get(i)).m5582c();
                }
            }
        }
    }

    protected abstract String mo734e();

    protected SessionManager() {
    }

    public final synchronized void m5297a() {
        this.f3145a.m5307c();
    }

    public final synchronized void m5300b() {
        this.f3145a.m5306b();
    }

    public final synchronized void m5299a(String str) {
        this.f3147c = true;
        this.f3146b = str;
        this.f3145a.m5305a(str);
    }

    public final synchronized void m5301c() {
        this.f3145a.m5304a();
    }

    final void m5298a(SessionDelegate sessionDelegate) {
        this.f3145a.registerObserver(sessionDelegate);
    }

    final synchronized String m5302d() {
        if (!this.f3147c) {
            this.f3146b = mo734e();
            this.f3147c = true;
        }
        return this.f3146b;
    }
}
