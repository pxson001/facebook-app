package com.facebook.crudolib.params;

import com.facebook.crudolib.appstrictmode.CloseGuard;
import com.facebook.infer.annotation.Assertions;
import java.io.Writer;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: tap_360_photo_feed_to_fullscreen */
public abstract class ParamsCollection {
    @Nullable
    public SimpleIntArrayMap<Class<? extends ParamsEncoder>> f3274a;
    private boolean f3275b;
    private boolean f3276c = false;
    public AtomicInteger f3277d = new AtomicInteger(0);
    @Nullable
    private CloseGuard f3278e;
    @Nullable
    public ParamsCollectionPool f3279f;
    @Nullable
    private ParamsEncoder f3280g;
    @Nullable
    public ParamsCollection f3281h;

    public abstract void mo742a(int i);

    protected abstract void mo743d();

    protected abstract void mo744e();

    public abstract void mo745h();

    ParamsCollection() {
    }

    final void m5437a(ParamsCollectionPool paramsCollectionPool) {
        int incrementAndGet = this.f3277d.incrementAndGet();
        if (incrementAndGet != 1) {
            throw new IllegalStateException("Acquired object with non-zero initial refCount current = " + incrementAndGet);
        }
        this.f3279f = paramsCollectionPool;
        this.f3278e = CloseGuard.m5451a(this.f3278e, "release");
        mo1635l();
    }

    public final void m5434a() {
        int decrementAndGet = this.f3277d.decrementAndGet();
        if (decrementAndGet != 1) {
            if (decrementAndGet < 0) {
                throw new IllegalStateException("release() has been called with refCount == 0");
            } else if (this.f3281h != null) {
                throw new IllegalStateException("Trying to release, when added to " + this.f3281h);
            } else {
                mo1634k();
            }
        }
    }

    protected final void m5443b() {
        int decrementAndGet = this.f3277d.decrementAndGet();
        if (decrementAndGet == 1) {
            this.f3276c = true;
            this.f3281h = null;
            this.f3274a = null;
        } else if (decrementAndGet < 0) {
            throw new IllegalStateException("releaseFromParent() has been called with refCount == 0");
        } else {
            mo1634k();
        }
    }

    private void mo1634k() {
        if (this.f3277d.get() != 0) {
            throw new IllegalStateException("Releasing object with non-zero refCount.");
        }
        mo743d();
        if (this.f3279f != null) {
            mo742a(this.f3279f.f3238d);
        }
        mo745h();
        m5447f();
        this.f3276c = false;
        this.f3280g = null;
        this.f3281h = null;
        this.f3274a = null;
        if (this.f3279f != null) {
            CloseGuard.m5452a(this.f3278e);
            mo744e();
        }
    }

    public final void m5444c() {
        if (this.f3276c) {
            throw new IllegalStateException("Attempting to re-attach a detached ParamsCollection");
        } else if (this.f3281h != null) {
            throw new IllegalStateException("Already added to " + this.f3281h);
        }
    }

    final void m5436a(ParamsCollection paramsCollection) {
        m5444c();
        this.f3281h = paramsCollection;
    }

    public final void m5447f() {
        this.f3275b = false;
    }

    private void mo1635l() {
        m5433m();
        this.f3275b = true;
    }

    protected final void m5448g() {
        if (!this.f3275b) {
            throw new IllegalStateException("Expected object to be mutable");
        }
    }

    private void m5433m() {
        if (this.f3275b) {
            throw new IllegalStateException("Internal bug, expected object to be immutable");
        }
    }

    public final void m5438a(ParamsEncoder paramsEncoder) {
        Assertions.m5468a((Object) paramsEncoder, "encoder cannot be null!");
        this.f3280g = paramsEncoder;
    }

    final ParamsEncoder m5442b(ParamsEncoder paramsEncoder) {
        return this.f3280g != null ? this.f3280g : paramsEncoder;
    }

    final int m5441b(Class<? extends ParamsEncoder> cls, int i) {
        if (this.f3274a != null) {
            return this.f3274a.b(cls, i);
        }
        return i;
    }

    public final void m5439a(Writer writer) {
        Assertions.m5468a((Object) writer, "Writer is null!");
        Assertions.m5468a(this.f3280g, "No encoder set, please call setEncoder() first!");
        this.f3280g.mo746a(writer, this);
    }

    final void m5440a(Writer writer, ParamsEncoder paramsEncoder) {
        Object obj;
        Assertions.m5468a((Object) writer, "Writer is null!");
        if (this.f3280g != null) {
            obj = this.f3280g;
        }
        Assertions.m5468a(obj, "No encoder available");
        obj.mo746a(writer, this);
    }

    @Nonnull
    protected final ParamsCollectionPool m5450i() {
        return this.f3279f;
    }
}
