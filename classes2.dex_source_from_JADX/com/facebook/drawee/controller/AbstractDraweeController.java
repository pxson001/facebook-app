package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DeferredReleaser.Releasable;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.DraweeEventTracker.Event;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: message_attachment_size_control */
public abstract class AbstractDraweeController<T, INFO> implements Releasable {
    private static final Class<?> f14360a = AbstractDraweeController.class;
    private final DraweeEventTracker f14361b = new DraweeEventTracker();
    private final DeferredReleaser f14362c;
    private final Executor f14363d;
    @Nullable
    public RetryManager f14364e;
    @Nullable
    public GestureDetector f14365f;
    @Nullable
    public ControllerListener<INFO> f14366g;
    @Nullable
    private SettableDraweeHierarchy f14367h;
    @Nullable
    private Drawable f14368i;
    public String f14369j;
    private Object f14370k;
    private boolean f14371l;
    private boolean f14372m;
    private boolean f14373n;
    public boolean f14374o;
    @Nullable
    private DataSource<T> f14375p;
    @Nullable
    private T f14376q;
    @Nullable
    private Drawable f14377r;

    /* compiled from: message_attachment_size_control */
    public class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
    }

    protected abstract Drawable mo2761a(T t);

    @Nullable
    protected abstract INFO mo2767b(T t);

    protected abstract void mo2768b(@Nullable Drawable drawable);

    protected abstract void mo2770d(@Nullable T t);

    protected abstract DataSource<T> mo2766n();

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.f14362c = deferredReleaser;
        this.f14363d = executor;
        m20733a(str, obj, true);
    }

    protected final void m20743a(String str, Object obj) {
        m20733a(str, obj, false);
    }

    private void m20733a(String str, Object obj, boolean z) {
        this.f14361b.m20546a(Event.ON_INIT_CONTROLLER);
        if (!(z || this.f14362c == null)) {
            this.f14362c.m20762b(this);
        }
        this.f14371l = false;
        m20728a();
        this.f14374o = false;
        if (this.f14364e != null) {
            this.f14364e.m29793b();
        }
        if (this.f14365f != null) {
            this.f14365f.m29795a();
            this.f14365f.f22013a = this;
        }
        if (this.f14366g instanceof InternalForwardingListener) {
            ((InternalForwardingListener) this.f14366g).m21585a();
        } else {
            this.f14366g = null;
        }
        if (this.f14367h != null) {
            this.f14367h.mo2737b();
            this.f14367h.mo2734a(null);
            this.f14367h = null;
        }
        this.f14368i = null;
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        this.f14369j = str;
        this.f14370k = obj;
    }

    public final void m20746b() {
        this.f14361b.m20546a(Event.ON_RELEASE_CONTROLLER);
        if (this.f14364e != null) {
            this.f14364e.m29794c();
        }
        if (this.f14365f != null) {
            this.f14365f.m29796b();
        }
        if (this.f14367h != null) {
            this.f14367h.mo2737b();
        }
        m20728a();
    }

    private void m20728a() {
        boolean z = this.f14372m;
        this.f14372m = false;
        this.f14373n = false;
        if (this.f14375p != null) {
            this.f14375p.mo2782g();
            this.f14375p = null;
        }
        if (this.f14377r != null) {
            mo2768b(this.f14377r);
        }
        this.f14377r = null;
        if (this.f14376q != null) {
            m20736b("release", this.f14376q);
            mo2770d(this.f14376q);
            this.f14376q = null;
        }
        if (z) {
            m20737o().mo2604a(this.f14369j);
        }
    }

    public Object mo2764i() {
        return this.f14370k;
    }

    public final void m20741a(ControllerListener<? super INFO> controllerListener) {
        Preconditions.a(controllerListener);
        if (this.f14366g instanceof InternalForwardingListener) {
            ((InternalForwardingListener) this.f14366g).m21586a((ControllerListener) controllerListener);
        } else if (this.f14366g != null) {
            ControllerListener controllerListener2 = this.f14366g;
            ForwardingControllerListener internalForwardingListener = new InternalForwardingListener();
            internalForwardingListener.m21586a(controllerListener2);
            internalForwardingListener.m21586a((ControllerListener) controllerListener);
            this.f14366g = internalForwardingListener;
        } else {
            this.f14366g = controllerListener;
        }
    }

    private ControllerListener<INFO> m20737o() {
        if (this.f14366g == null) {
            return BaseControllerListener.f13226a;
        }
        return this.f14366g;
    }

    @Nullable
    public final DraweeHierarchy m20750d() {
        return this.f14367h;
    }

    public final void m20742a(@Nullable DraweeHierarchy draweeHierarchy) {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        this.f14361b.m20546a(draweeHierarchy != null ? Event.ON_SET_HIERARCHY : Event.ON_CLEAR_HIERARCHY);
        if (this.f14372m) {
            this.f14362c.m20762b(this);
            m20746b();
        }
        if (this.f14367h != null) {
            this.f14367h.mo2734a(null);
            this.f14367h = null;
        }
        if (draweeHierarchy != null) {
            Preconditions.a(draweeHierarchy instanceof SettableDraweeHierarchy);
            this.f14367h = (SettableDraweeHierarchy) draweeHierarchy;
            this.f14367h.mo2734a(this.f14368i);
        }
    }

    protected void mo2762a(@Nullable Drawable drawable) {
        this.f14368i = drawable;
        if (this.f14367h != null) {
            this.f14367h.mo2734a(this.f14368i);
        }
    }

    public void m20752e() {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        this.f14361b.m20546a(Event.ON_ATTACH_CONTROLLER);
        Preconditions.a(this.f14367h);
        this.f14362c.m20762b(this);
        this.f14371l = true;
        if (!this.f14372m) {
            m20757m();
        }
    }

    public void m20753f() {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        this.f14361b.m20546a(Event.ON_DETACH_CONTROLLER);
        this.f14371l = false;
        DeferredReleaser deferredReleaser = this.f14362c;
        DeferredReleaser.m20761c();
        if (deferredReleaser.f14380b.add(this) && deferredReleaser.f14380b.size() == 1) {
            HandlerDetour.a(deferredReleaser.f14381c, deferredReleaser.f14382d, -218929422);
        }
    }

    public final boolean m20744a(MotionEvent motionEvent) {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        if (this.f14365f == null) {
            return false;
        }
        if (!this.f14365f.f22015c && !mo2765l()) {
            return false;
        }
        GestureDetector gestureDetector = this.f14365f;
        switch (motionEvent.getAction()) {
            case 0:
                gestureDetector.f22015c = true;
                gestureDetector.f22016d = true;
                gestureDetector.f22017e = motionEvent.getEventTime();
                gestureDetector.f22018f = motionEvent.getX();
                gestureDetector.f22019g = motionEvent.getY();
                break;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                gestureDetector.f22015c = false;
                if (Math.abs(motionEvent.getX() - gestureDetector.f22018f) > gestureDetector.f22014b || Math.abs(motionEvent.getY() - gestureDetector.f22019g) > gestureDetector.f22014b) {
                    gestureDetector.f22016d = false;
                }
                if (gestureDetector.f22016d && motionEvent.getEventTime() - gestureDetector.f22017e <= ((long) ViewConfiguration.getLongPressTimeout()) && gestureDetector.f22013a != null) {
                    gestureDetector.f22013a.mo2763c();
                    break;
                }
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (Math.abs(motionEvent.getX() - gestureDetector.f22018f) > gestureDetector.f22014b || Math.abs(motionEvent.getY() - gestureDetector.f22019g) > gestureDetector.f22014b) {
                    gestureDetector.f22016d = false;
                    break;
                }
            case 3:
                gestureDetector.f22015c = false;
                break;
        }
        gestureDetector.f22016d = false;
        return true;
    }

    protected boolean mo2765l() {
        return m20738p();
    }

    private boolean m20738p() {
        if (this.f14373n && this.f14364e != null) {
            RetryManager retryManager = this.f14364e;
            Object obj = (!retryManager.f22010a || retryManager.f22012c >= retryManager.f22011b) ? null : 1;
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public boolean mo2763c() {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
        if (!m20738p()) {
            return false;
        }
        RetryManager retryManager = this.f14364e;
        retryManager.f22012c++;
        this.f14367h.mo2737b();
        m20757m();
        return true;
    }

    protected final void m20757m() {
        this.f14361b.m20546a(Event.ON_DATASOURCE_SUBMIT);
        m20737o().mo2605a(this.f14369j, this.f14370k);
        this.f14367h.mo2733a(0.0f, true);
        this.f14372m = true;
        this.f14373n = false;
        this.f14375p = mo2766n();
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
            Integer.valueOf(System.identityHashCode(this.f14375p));
        }
        final String str = this.f14369j;
        final boolean c = this.f14375p.mo2785c();
        this.f14375p.mo2783a(new BaseDataSubscriber<T>(this) {
            final /* synthetic */ AbstractDraweeController f14539c;

            public final void mo2803e(DataSource<T> dataSource) {
                boolean b = dataSource.mo2784b();
                float f = dataSource.mo2787f();
                Object d = dataSource.mo2781d();
                if (d != null) {
                    this.f14539c.m20732a(str, dataSource, d, f, b, c);
                } else if (b) {
                    AbstractDraweeController.m20731a(this.f14539c, str, (DataSource) dataSource, new NullPointerException(), true);
                }
            }

            public final void mo2804f(DataSource<T> dataSource) {
                AbstractDraweeController.m20731a(this.f14539c, str, (DataSource) dataSource, dataSource.mo2786e(), true);
            }

            public final void mo2802d(DataSource<T> dataSource) {
                boolean b = dataSource.mo2784b();
                AbstractDraweeController.m20729a(this.f14539c, str, (DataSource) dataSource, dataSource.mo2787f(), b);
            }
        }, this.f14363d);
    }

    private void m20732a(String str, DataSource<T> dataSource, @Nullable T t, float f, boolean z, boolean z2) {
        if (m20735a(str, (DataSource) dataSource)) {
            this.f14361b.m20546a(z ? Event.ON_DATASOURCE_RESULT : Event.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable a = mo2761a((Object) t);
                T t2 = this.f14376q;
                Drawable drawable = this.f14377r;
                this.f14376q = t;
                this.f14377r = a;
                if (z) {
                    try {
                        m20736b("set_final_result @ onNewResult", t);
                        this.f14375p = null;
                        this.f14367h.mo2735a(a, 1.0f, z2);
                        m20737o().mo2603a(str, mo2767b((Object) t), m20754g());
                    } catch (Throwable th) {
                        if (!(drawable == null || drawable == a)) {
                            mo2768b(drawable);
                        }
                        if (!(t2 == null || t2 == t)) {
                            m20736b("release_previous_result @ onNewResult", t2);
                            mo2770d(t2);
                        }
                    }
                } else {
                    m20736b("set_intermediate_result @ onNewResult", t);
                    this.f14367h.mo2735a(a, f, z2);
                    m20737o().mo2607b(str, mo2767b((Object) t));
                }
                if (!(drawable == null || drawable == a)) {
                    mo2768b(drawable);
                }
                if (t2 != null && t2 != t) {
                    m20736b("release_previous_result @ onNewResult", t2);
                    mo2770d(t2);
                    return;
                }
                return;
            } catch (Throwable e) {
                m20736b("drawable_failed @ onNewResult", t);
                mo2770d(t);
                m20731a(this, str, (DataSource) dataSource, e, z);
                return;
            }
        }
        m20736b("ignore_old_datasource @ onNewResult", t);
        mo2770d(t);
        dataSource.mo2782g();
    }

    public static void m20731a(AbstractDraweeController abstractDraweeController, String str, DataSource dataSource, Throwable th, boolean z) {
        if (abstractDraweeController.m20735a(str, dataSource)) {
            abstractDraweeController.f14361b.m20546a(z ? Event.ON_DATASOURCE_FAILURE : Event.ON_DATASOURCE_FAILURE_INT);
            if (z) {
                abstractDraweeController.m20734a("final_failed @ onFailure", th);
                abstractDraweeController.f14375p = null;
                abstractDraweeController.f14373n = true;
                if (abstractDraweeController.f14374o && abstractDraweeController.f14377r != null) {
                    abstractDraweeController.f14367h.mo2735a(abstractDraweeController.f14377r, 1.0f, true);
                } else if (abstractDraweeController.m20738p()) {
                    abstractDraweeController.f14367h.mo2738b(th);
                } else {
                    abstractDraweeController.f14367h.mo2736a(th);
                }
                abstractDraweeController.m20737o().mo2608b(abstractDraweeController.f14369j, th);
                return;
            }
            abstractDraweeController.m20734a("intermediate_failed @ onFailure", th);
            abstractDraweeController.m20737o().mo2606a(abstractDraweeController.f14369j, th);
            return;
        }
        abstractDraweeController.m20734a("ignore_old_datasource @ onFailure", th);
        dataSource.mo2782g();
    }

    public static void m20729a(AbstractDraweeController abstractDraweeController, String str, DataSource dataSource, float f, boolean z) {
        if (!abstractDraweeController.m20735a(str, dataSource)) {
            abstractDraweeController.m20734a("ignore_old_datasource @ onProgress", null);
            dataSource.mo2782g();
        } else if (!z) {
            abstractDraweeController.f14367h.mo2733a(f, false);
        }
    }

    private boolean m20735a(String str, DataSource<T> dataSource) {
        return str.equals(this.f14369j) && dataSource == this.f14375p && this.f14372m;
    }

    private void m20736b(String str, T t) {
        if (FLog.a(2)) {
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(System.identityHashCode(this));
            objArr[1] = this.f14369j;
            objArr[2] = str;
            objArr[3] = t != null ? t.getClass().getSimpleName() : "<null>";
            objArr[4] = Integer.valueOf(mo2769c(t));
        }
    }

    private void m20734a(String str, Throwable th) {
        if (FLog.a(2)) {
            Integer.valueOf(System.identityHashCode(this));
        }
    }

    @Nullable
    public final Animatable m20754g() {
        return this.f14377r instanceof Animatable ? (Animatable) this.f14377r : null;
    }

    protected int mo2769c(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return Objects.m20537a((Object) this).m20545a("isAttached", this.f14371l).m20545a("isRequestSubmitted", this.f14372m).m20545a("hasFetchFailed", this.f14373n).m20543a("fetchedImage", mo2769c(this.f14376q)).m20544a("events", this.f14361b.toString()).toString();
    }
}
