package com.facebook.components;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.components.fb.logger.QPLComponentsLogger;
import com.facebook.proxygen.HTTPTransportCallback;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: generated_rootmodule. */
public class ComponentTree {
    private static final String f22669b = ComponentTree.class.getSimpleName();
    private static final AtomicInteger f22670c = new AtomicInteger(0);
    private static final Handler f22671d = new ComponentMainThreadHandler();
    @GuardedBy("ComponentTree.class")
    private static volatile Looper f22672e;
    protected final int f22673a = f22670c.getAndIncrement();
    private final Runnable f22674f = new C09251(this);
    private final ComponentContext f22675g;
    public boolean f22676h;
    private boolean f22677i;
    public boolean f22678j;
    private boolean f22679k;
    private boolean f22680l;
    public ComponentView f22681m;
    private Handler f22682n;
    public QPLComponentsLogger f22683o;
    public String f22684p;
    private Rect f22685q;
    @GuardedBy("this")
    private boolean f22686r;
    @GuardedBy("this")
    private Component<?> f22687s;
    @GuardedBy("this")
    private int f22688t = -1;
    @GuardedBy("this")
    private int f22689u = -1;
    private LayoutState f22690v;
    @GuardedBy("this")
    private LayoutState f22691w;
    private Object f22692x;

    /* compiled from: generated_rootmodule. */
    public class Builder {
        public ComponentContext f22734a;
        public Component<?> f22735b;
        public boolean f22736c;
        public boolean f22737d;
        public boolean f22738e = true;
        public Handler f22739f;
        public Object f22740g;
        public QPLComponentsLogger f22741h;
        public String f22742i;

        protected Builder() {
        }

        public final Builder m30700a(boolean z) {
            this.f22736c = z;
            return this;
        }

        public final Builder m30702c(boolean z) {
            this.f22738e = z;
            return this;
        }

        public final Builder m30699a(Looper looper) {
            if (looper != null) {
                this.f22739f = new Handler(looper);
            }
            return this;
        }

        public final ComponentTree m30701b() {
            m30698j(this);
            ComponentTree componentTree = new ComponentTree(this);
            this.f22734a = null;
            this.f22735b = null;
            this.f22736c = false;
            this.f22737d = false;
            this.f22738e = true;
            this.f22739f = null;
            this.f22740g = null;
            this.f22741h = null;
            this.f22742i = null;
            ComponentsPools.f22602l.mo741a(this);
            return componentTree;
        }

        private static void m30698j(Builder builder) {
            if (builder.f22741h != null && builder.f22742i == null) {
                throw new IllegalStateException("When a ComponentsLogger is set, a LogTag must be set");
            } else if (builder.f22736c && builder.f22738e) {
                throw new IllegalStateException("IncrementalMount and mountDiffing can't be enabled at the same time just yet.");
            }
        }
    }

    /* compiled from: generated_rootmodule. */
    class ComponentMainThreadHandler extends Handler {
        public ComponentMainThreadHandler() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    ComponentTree.m30626n((ComponentTree) message.obj);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    /* compiled from: generated_rootmodule. */
    class C09251 implements Runnable {
        final /* synthetic */ ComponentTree f22743a;

        C09251(ComponentTree componentTree) {
            this.f22743a = componentTree;
        }

        public void run() {
            ComponentTree.m30620a(this.f22743a, null);
        }
    }

    protected ComponentTree(Builder builder) {
        this.f22675g = builder.f22734a;
        this.f22687s = builder.f22735b;
        this.f22677i = builder.f22736c;
        this.f22678j = builder.f22738e;
        this.f22679k = builder.f22737d;
        this.f22682n = builder.f22739f;
        this.f22692x = builder.f22740g;
        this.f22683o = builder.f22741h;
        this.f22684p = builder.f22742i;
        if (this.f22677i) {
            this.f22685q = new Rect();
        }
        if (this.f22682n == null) {
            this.f22682n = new Handler(m30631s());
        }
    }

    private LayoutState m30625m() {
        if (Thread.holdsLock(this)) {
            Object obj;
            if (m30621a(this.f22690v) || (!m30622a(this.f22691w, this.f22688t, this.f22689u) && m30622a(this.f22690v, this.f22688t, this.f22689u))) {
                obj = 1;
            } else {
                obj = null;
            }
            LayoutState layoutState;
            if (obj != null) {
                layoutState = this.f22691w;
                this.f22691w = null;
                return layoutState;
            }
            if (this.f22681m != null) {
                this.f22681m.m30433k();
            }
            layoutState = this.f22690v;
            this.f22690v = this.f22691w;
            this.f22691w = null;
            return layoutState;
        }
        throw new IllegalStateException("this method should be called while holding the lock");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m30626n(com.facebook.components.ComponentTree r6) {
        /*
        r0 = 1;
        r1 = 0;
        com.facebook.components.ThreadUtils.m30579b();
        r2 = r6.f22680l;
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        monitor-enter(r6);
        r2 = r6.f22687s;	 Catch:{ all -> 0x0011 }
        if (r2 != 0) goto L_0x0014;
    L_0x000f:
        monitor-exit(r6);	 Catch:{ all -> 0x0011 }
        goto L_0x0009;
    L_0x0011:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0011 }
        throw r0;
    L_0x0014:
        r2 = r6.f22690v;	 Catch:{  }
        r3 = r6.m30625m();	 Catch:{  }
        r4 = r6.f22690v;	 Catch:{  }
        if (r4 == r2) goto L_0x004d;
    L_0x001e:
        r2 = r0;
    L_0x001f:
        r4 = r6.f22687s;	 Catch:{  }
        r4 = r4.m30508b();	 Catch:{  }
        monitor-exit(r6);	 Catch:{  }
        if (r3 == 0) goto L_0x002b;
    L_0x0028:
        r3.m30606f();
    L_0x002b:
        if (r2 == 0) goto L_0x0009;
    L_0x002d:
        r2 = r6.f22681m;
        r2 = r2.getMeasuredWidth();
        r3 = r6.f22681m;
        r3 = r3.getMeasuredHeight();
        if (r2 == 0) goto L_0x0009;
    L_0x003b:
        if (r3 == 0) goto L_0x0009;
    L_0x003d:
        r5 = r6.f22690v;
        r2 = m30624b(r5, r4, r2, r3);
        if (r2 != 0) goto L_0x004f;
    L_0x0045:
        if (r0 == 0) goto L_0x0051;
    L_0x0047:
        r0 = r6.f22681m;
        r0.requestLayout();
        goto L_0x0009;
    L_0x004d:
        r2 = r1;
        goto L_0x001f;
    L_0x004f:
        r0 = r1;
        goto L_0x0045;
    L_0x0051:
        r6.m30627o();
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.ComponentTree.n(com.facebook.components.ComponentTree):void");
    }

    final void m30632a() {
        Object obj = 1;
        ThreadUtils.m30579b();
        if (this.f22681m == null) {
            throw new IllegalStateException("Trying to attach a ComponentTree without a set View");
        }
        if (this.f22677i) {
            this.f22685q.setEmpty();
        }
        synchronized (this) {
            this.f22680l = true;
            LayoutState m = m30625m();
            int b = this.f22687s.m30508b();
        }
        if (m != null) {
            m.m30606f();
        }
        int measuredWidth = this.f22681m.getMeasuredWidth();
        int measuredHeight = this.f22681m.getMeasuredHeight();
        if (measuredWidth != 0 && measuredHeight != 0) {
            if (m30624b(this.f22690v, b, measuredWidth, measuredHeight)) {
                obj = null;
            }
            if (obj != null || this.f22681m.m30434l()) {
                this.f22681m.requestLayout();
            } else {
                this.f22681m.m30429e();
            }
        }
    }

    public static Context m30616a(Context context) {
        Context context2 = context;
        while (context2 instanceof ContextWrapper) {
            context2 = ((ContextWrapper) context2).getBaseContext();
        }
        return context2;
    }

    private boolean m30627o() {
        if (!this.f22681m.m30434l()) {
            return false;
        }
        m30641e();
        return true;
    }

    final void m30641e() {
        if (!this.f22677i) {
            m30636a(null);
        } else if (this.f22681m.getLocalVisibleRect(this.f22685q)) {
            m30636a(this.f22685q);
        }
    }

    final void m30636a(Rect rect) {
        ThreadUtils.m30579b();
        this.f22676h = true;
        ComponentView componentView = this.f22681m;
        componentView.f22535b.m30496a(this.f22690v, rect, this.f22678j);
        this.f22676h = false;
    }

    final void m30642f() {
        ThreadUtils.m30579b();
        synchronized (this) {
            this.f22680l = false;
            this.f22686r = false;
        }
    }

    final void m30638a(@NonNull ComponentView componentView) {
        Object obj;
        ThreadUtils.m30579b();
        if (this.f22680l) {
            if (this.f22681m != null) {
                this.f22681m.setComponent(null);
            } else {
                m30642f();
            }
        } else if (this.f22681m != null) {
            this.f22681m.m30431g();
        }
        if (m30616a(componentView.getContext()) == m30616a(this.f22675g)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new IllegalArgumentException("Base view context differs, view context is: " + componentView.getContext() + ", ComponentTree context is: " + this.f22675g);
        }
        if (componentView.getContext() != this.f22675g) {
            Log.w(f22669b, "View context differs from that used to construct the component");
        }
        this.f22681m = componentView;
    }

    final void m30643g() {
        ThreadUtils.m30579b();
        if (this.f22680l) {
            throw new IllegalStateException("Clearing the ComponentView while the ComponentTree is attached");
        }
        this.f22681m = null;
    }

    final void m30635a(int i, int i2, int[] iArr) {
        Component component;
        ThreadUtils.m30579b();
        synchronized (this) {
            this.f22688t = i;
            this.f22689u = i2;
            this.f22686r = true;
            LayoutState m = m30625m();
            if (m30621a(this.f22690v)) {
                component = null;
            } else {
                component = this.f22687s.m30509c();
            }
        }
        if (m != null) {
            m.m30606f();
        }
        if (component != null) {
            if (this.f22690v != null) {
                synchronized (this) {
                    m = this.f22690v;
                    this.f22690v = null;
                }
                m.m30606f();
            }
            m = m30617a(this.f22692x, this.f22675g, component, i, i2, this.f22679k, null, this.f22684p, this.f22683o);
            synchronized (this) {
                this.f22690v = m;
            }
            this.f22681m.m30433k();
        }
        iArr[0] = this.f22690v.m30603c();
        iArr[1] = this.f22690v.m30604d();
    }

    final boolean m30644h() {
        ThreadUtils.m30579b();
        return m30627o();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m30645i() {
        /*
        r3 = this;
        r0 = r3.f22677i;
        if (r0 != 0) goto L_0x0015;
    L_0x0004:
        r0 = r3.f22681m;
        if (r0 == 0) goto L_0x0017;
    L_0x0008:
        r0 = r3.f22681m;
        r1 = r0.f22535b;
        r2 = r1.f22577e;
        if (r2 <= 0) goto L_0x0019;
    L_0x0010:
        r2 = 1;
    L_0x0011:
        r1 = r2;
        r0 = r1;
        if (r0 == 0) goto L_0x0017;
    L_0x0015:
        r0 = 1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = 0;
        goto L_0x0016;
    L_0x0019:
        r2 = 0;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.ComponentTree.i():boolean");
    }

    public final void m30633a(int i, int i2) {
        m30634a(i, i2, null);
    }

    public final void m30634a(int i, int i2, Size size) {
        m30619a(null, i, i2, false, size);
    }

    public final void m30639b(int i, int i2) {
        m30619a(null, i, i2, true, null);
    }

    public final void m30637a(Component<?> component, int i, int i2) {
        if (component == null) {
            throw new IllegalArgumentException("Root component can't be null");
        }
        m30619a(component, i, i2, true, null);
    }

    public final void m30640b(Component<?> component, int i, int i2) {
        if (component == null) {
            throw new IllegalArgumentException("Root component can't be null");
        }
        m30619a(component, i, i2, false, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m30619a(com.facebook.components.Component<?> r9, int r10, int r11, boolean r12, com.facebook.components.Size r13) {
        /*
        r8 = this;
        r2 = -1;
        r1 = 1;
        r0 = 0;
        monitor-enter(r8);
        if (r9 == 0) goto L_0x0015;
    L_0x0006:
        r6 = r1;
    L_0x0007:
        if (r10 == r2) goto L_0x0017;
    L_0x0009:
        r5 = r1;
    L_0x000a:
        if (r11 == r2) goto L_0x0019;
    L_0x000c:
        r4 = r1;
    L_0x000d:
        r2 = r8.f22686r;	 Catch:{ all -> 0x0038 }
        if (r2 == 0) goto L_0x001b;
    L_0x0011:
        if (r6 != 0) goto L_0x001b;
    L_0x0013:
        monitor-exit(r8);	 Catch:{ all -> 0x0038 }
    L_0x0014:
        return;
    L_0x0015:
        r6 = r0;
        goto L_0x0007;
    L_0x0017:
        r5 = r0;
        goto L_0x000a;
    L_0x0019:
        r4 = r0;
        goto L_0x000d;
    L_0x001b:
        if (r5 == 0) goto L_0x0021;
    L_0x001d:
        r2 = r8.f22688t;	 Catch:{ all -> 0x0038 }
        if (r10 != r2) goto L_0x003b;
    L_0x0021:
        r3 = r1;
    L_0x0022:
        if (r4 == 0) goto L_0x0028;
    L_0x0024:
        r2 = r8.f22689u;	 Catch:{ all -> 0x0038 }
        if (r11 != r2) goto L_0x003d;
    L_0x0028:
        r2 = r1;
    L_0x0029:
        if (r6 == 0) goto L_0x002f;
    L_0x002b:
        r7 = r8.f22687s;	 Catch:{ all -> 0x0038 }
        if (r9 != r7) goto L_0x0030;
    L_0x002f:
        r0 = r1;
    L_0x0030:
        if (r3 == 0) goto L_0x003f;
    L_0x0032:
        if (r2 == 0) goto L_0x003f;
    L_0x0034:
        if (r0 == 0) goto L_0x003f;
    L_0x0036:
        monitor-exit(r8);	 Catch:{ all -> 0x0038 }
        goto L_0x0014;
    L_0x0038:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0038 }
        throw r0;
    L_0x003b:
        r3 = r0;
        goto L_0x0022;
    L_0x003d:
        r2 = r0;
        goto L_0x0029;
    L_0x003f:
        if (r5 == 0) goto L_0x0043;
    L_0x0041:
        r8.f22688t = r10;	 Catch:{  }
    L_0x0043:
        if (r4 == 0) goto L_0x0047;
    L_0x0045:
        r8.f22689u = r11;	 Catch:{  }
    L_0x0047:
        if (r6 == 0) goto L_0x004b;
    L_0x0049:
        r8.f22687s = r9;	 Catch:{  }
    L_0x004b:
        monitor-exit(r8);	 Catch:{  }
        if (r12 == 0) goto L_0x0058;
    L_0x004e:
        if (r13 == 0) goto L_0x0058;
    L_0x0050:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "The layout can't be calculated asynchronously if we need the Size back";
        r0.<init>(r1);
        throw r0;
    L_0x0058:
        if (r12 == 0) goto L_0x0065;
    L_0x005a:
        r0 = r8.f22682n;
        r1 = r8.f22674f;
        r2 = -265266943; // 0xfffffffff0305901 float:-2.1830784E29 double:NaN;
        com.facebook.tools.dextr.runtime.detour.HandlerDetour.a(r0, r1, r2);
        goto L_0x0014;
    L_0x0065:
        m30620a(r8, r13);
        goto L_0x0014;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.ComponentTree.a(com.facebook.components.Component, int, int, boolean, com.facebook.components.Size):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m30620a(com.facebook.components.ComponentTree r11, com.facebook.components.Size r12) {
        /*
        r7 = 0;
        r0 = r11.f22682n;
        r0.removeCallbacksAndMessages(r7);
        monitor-enter(r11);
        r0 = r11.m30630r();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x0011;
    L_0x000d:
        r0 = r11.f22687s;	 Catch:{ all -> 0x001b }
        if (r0 != 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r11);	 Catch:{ all -> 0x001b }
    L_0x0012:
        return;
    L_0x0013:
        r0 = r11.m30629q();	 Catch:{ all -> 0x001b }
        if (r0 == 0) goto L_0x001e;
    L_0x0019:
        monitor-exit(r11);	 Catch:{ all -> 0x001b }
        goto L_0x0012;
    L_0x001b:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x001b }
        throw r0;
    L_0x001e:
        r4 = r11.f22688t;	 Catch:{  }
        r5 = r11.f22689u;	 Catch:{  }
        r0 = r11.f22687s;	 Catch:{  }
        r3 = r0.m30509c();	 Catch:{  }
        r0 = r11.f22690v;	 Catch:{  }
        if (r0 == 0) goto L_0x008a;
    L_0x002c:
        r0 = r11.f22690v;	 Catch:{  }
        r0 = r0.m30607g();	 Catch:{  }
        r10 = r0;
    L_0x0033:
        monitor-exit(r11);	 Catch:{  }
        r11.m30618a(r3);
        r1 = r11.f22692x;
        r2 = r11.f22675g;
        r6 = r11.f22679k;
        if (r10 == 0) goto L_0x0043;
    L_0x003f:
        r7 = r10.m30601b();
    L_0x0043:
        r8 = r11.f22684p;
        r9 = r11.f22683o;
        r0 = r11;
        r2 = r0.m30617a(r1, r2, r3, r4, r5, r6, r7, r8, r9);
        if (r12 == 0) goto L_0x005a;
    L_0x004e:
        r0 = r2.m30603c();
        r12.f22987a = r0;
        r0 = r2.m30604d();
        r12.f22988b = r0;
    L_0x005a:
        if (r10 == 0) goto L_0x005f;
    L_0x005c:
        r10.m30606f();
    L_0x005f:
        r0 = 0;
        monitor-enter(r11);
        r1 = r11.m30629q();	 Catch:{ all -> 0x0085 }
        if (r1 != 0) goto L_0x0088;
    L_0x0067:
        r1 = r11.f22688t;	 Catch:{ all -> 0x0085 }
        r4 = r11.f22689u;	 Catch:{ all -> 0x0085 }
        r1 = m30622a(r2, r1, r4);	 Catch:{ all -> 0x0085 }
        if (r1 == 0) goto L_0x0088;
    L_0x0071:
        r1 = r11.f22691w;	 Catch:{ all -> 0x0085 }
        r11.f22691w = r2;	 Catch:{ all -> 0x0085 }
        r0 = 1;
    L_0x0076:
        monitor-exit(r11);	 Catch:{ all -> 0x0085 }
        if (r1 == 0) goto L_0x007c;
    L_0x0079:
        r1.m30606f();
    L_0x007c:
        if (r0 == 0) goto L_0x0081;
    L_0x007e:
        r11.m30628p();
    L_0x0081:
        r11.m30623b(r3);
        goto L_0x0012;
    L_0x0085:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{  }
        throw r0;
    L_0x0088:
        r1 = r2;
        goto L_0x0076;
    L_0x008a:
        r10 = r7;
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.components.ComponentTree.a(com.facebook.components.ComponentTree, com.facebook.components.Size):void");
    }

    private void m30618a(Component<?> component) {
        if (this.f22683o != null) {
            this.f22683o.m30614a(3, component, "log_tag", this.f22684p);
            this.f22683o.m30615b(3, component, "tree_diff_enabled", String.valueOf(this.f22679k));
            this.f22683o.m30615b(3, component, "is_async_layout", String.valueOf(!ThreadUtils.m30578a()));
        }
    }

    private void m30623b(Component<?> component) {
        if (this.f22683o != null) {
            this.f22683o.m30613a(3, component, 16);
        }
    }

    private void m30628p() {
        if (ThreadUtils.m30578a()) {
            m30626n(this);
        } else {
            f22671d.obtainMessage(1, this).sendToTarget();
        }
    }

    public final void m30646l() {
        synchronized (this) {
            Component component = this.f22687s;
            this.f22687s = null;
            LayoutState layoutState = this.f22690v;
            this.f22690v = null;
            LayoutState layoutState2 = this.f22691w;
            this.f22691w = null;
        }
        if (component != null) {
            component.m30510d();
        }
        if (layoutState != null) {
            layoutState.m30606f();
        }
        if (layoutState2 != null) {
            layoutState2.m30606f();
        }
    }

    private boolean m30621a(LayoutState layoutState) {
        if (Thread.holdsLock(this)) {
            if (this.f22687s != null) {
                Object obj;
                int i = this.f22687s.f22588b;
                int i2 = this.f22688t;
                int i3 = this.f22689u;
                if (layoutState != null) {
                    Object obj2 = (layoutState.f22647b.f22588b == i && layoutState.m30600a(i2, i3)) ? 1 : null;
                    if (obj2 != null) {
                        obj = 1;
                        if (obj != null) {
                            return true;
                        }
                    }
                }
                obj = null;
                if (obj != null) {
                    return true;
                }
            }
            return false;
        }
        throw new IllegalStateException("this method should be called while holding the lock");
    }

    private boolean m30629q() {
        if (Thread.holdsLock(this)) {
            return m30621a(this.f22690v) || m30621a(this.f22691w);
        } else {
            throw new IllegalStateException("this method should be called while holding the lock");
        }
    }

    private boolean m30630r() {
        if (Thread.holdsLock(this)) {
            return (this.f22688t == -1 || this.f22689u == -1) ? false : true;
        } else {
            throw new IllegalStateException("this method should be called while holding the lock");
        }
    }

    private static synchronized Looper m30631s() {
        Looper looper;
        synchronized (ComponentTree.class) {
            if (f22672e == null) {
                HandlerThread handlerThread = new HandlerThread("ComponentLayoutThread", 10);
                handlerThread.start();
                f22672e = handlerThread.getLooper();
            }
            looper = f22672e;
        }
        return looper;
    }

    private static boolean m30622a(LayoutState layoutState, int i, int i2) {
        return layoutState != null && layoutState.m30600a(i, i2);
    }

    private static boolean m30624b(LayoutState layoutState, int i, int i2, int i3) {
        if (layoutState != null) {
            if ((layoutState.f22647b.f22588b == i ? 1 : null) != null) {
                Object obj = (layoutState.f22656k == i2 && layoutState.f22657l == i3) ? 1 : null;
                if (obj != null) {
                    return true;
                }
            }
        }
        return false;
    }

    private LayoutState m30617a(@Nullable Object obj, ComponentContext componentContext, Component<?> component, int i, int i2, boolean z, @Nullable DiffNode diffNode, String str, ComponentsLogger componentsLogger) {
        if (obj != null) {
            LayoutState a;
            synchronized (obj) {
                a = LayoutState.m30587a(componentContext, component, this.f22673a, i, i2, z, diffNode, str, componentsLogger);
            }
            return a;
        }
        return LayoutState.m30587a(componentContext, component, this.f22673a, i, i2, z, diffNode, str, componentsLogger);
    }
}
