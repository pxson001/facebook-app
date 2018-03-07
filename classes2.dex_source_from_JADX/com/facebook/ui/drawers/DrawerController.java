package com.facebook.ui.drawers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.drawers.OneSidedDrawerAnimationStateListener.SingleDrawerState;
import com.facebook.virtuallifecycle.LifecycleReporterFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: question_id */
public class DrawerController {
    public static final Class<?> f8392a = DrawerController.class;
    private static DrawerController f8393s;
    private static final Object f8394t = new Object();
    public DefaultAndroidThreadUtil f8395b;
    public InputMethodManager f8396c;
    private AnalyticsLogger f8397d;
    public Activity f8398e = null;
    public FrameLayout f8399f = null;
    public DrawerDraggableContentLayout f8400g = null;
    public BackgroundStrategy f8401h;
    public DrawerContent f8402i = null;
    public DrawerContent f8403j = null;
    public DrawerLifecycleListener f8404k = null;
    public LifecycleReporterFragment f8405l = null;
    public Set<Object> f8406m = Sets.m1313a();
    public Set<DrawerAnimationStateListener> f8407n = Sets.m1313a();
    private StateChangeFuture f8408o = null;
    public DrawerState f8409p = DrawerState.CLOSED;
    public boolean f8410q = false;
    public boolean f8411r = false;

    private static DrawerController m12930b(InjectorLike injectorLike) {
        return new DrawerController(ActivityMethodAutoProvider.m6475b(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), InputMethodManagerMethodAutoProvider.m12957b(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike));
    }

    public static DrawerController m12924a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DrawerController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f8394t) {
                DrawerController drawerController;
                if (a2 != null) {
                    drawerController = (DrawerController) a2.mo818a(f8394t);
                } else {
                    drawerController = f8393s;
                }
                if (drawerController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m12930b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f8394t, b3);
                        } else {
                            f8393s = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = drawerController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DrawerController(Activity activity, DefaultAndroidThreadUtil defaultAndroidThreadUtil, InputMethodManager inputMethodManager, AnalyticsLogger analyticsLogger) {
        this.f8395b = defaultAndroidThreadUtil;
        this.f8396c = inputMethodManager;
        this.f8397d = analyticsLogger;
        if (activity instanceof FragmentManagerHost) {
            this.f8398e = activity;
        } else if (activity != null) {
            BLog.b(f8392a, "DrawerController created with unknown activity type: " + activity.toString());
        }
    }

    public final void m12946a() {
        m12928a(BackgroundStrategy.ENSURE_BACKGROUND);
    }

    private void m12928a(BackgroundStrategy backgroundStrategy) {
        if (m12952b()) {
            throw new IllegalStateException("This DrawerController is already attached to an activity.");
        } else if (this.f8398e == null) {
            throw new IllegalStateException("This DrawerController was injected without an Activity Context. So it cannot be attached.");
        } else {
            Preconditions.checkNotNull(backgroundStrategy, "BackgroundStrategy cannot be null");
            ViewGroup viewGroup = (ViewGroup) FbRootViewUtil.m13815a(this.f8398e);
            Preconditions.checkArgument(viewGroup.getChildCount() > 0, "Called DrawerController.attachToActivity before Activity.setContentView");
            this.f8400g = new DrawerDraggableContentLayout(this.f8398e);
            this.f8400g.setId(2131558750);
            this.f8400g.i.add(this);
            while (viewGroup.getChildCount() > 0) {
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeView(childAt);
                this.f8400g.addView(childAt);
            }
            this.f8401h = backgroundStrategy;
            if (viewGroup instanceof FrameLayout) {
                this.f8399f = (FrameLayout) viewGroup;
            } else {
                this.f8399f = new FrameLayout(this.f8398e);
                this.f8399f.setId(2131558747);
                viewGroup.addView(this.f8399f);
                HoneyClientEventFast a = this.f8397d.mo535a("unknown_activity_root", true);
                if (a.m17388a()) {
                    a.m17379a("drawer_controller");
                    a.m17385a("activity_root_view_type", viewGroup.toString());
                    a.m17390b();
                }
            }
            this.f8399f.addView(this.f8400g);
            if (m12952b()) {
                if (this.f8404k == null) {
                    this.f8404k = new DrawerLifecycleListener(this);
                }
                this.f8405l = LifecycleReporterFragment.a(m12953d(), this.f8404k, "drawers:fragment:lifecycle");
            }
            new StringBuilder("attached to activity ").append(this.f8398e.toString());
        }
    }

    public final boolean m12952b() {
        return (this.f8399f == null || this.f8400g == null) ? false : true;
    }

    @TargetApi(16)
    public static void m12929a(DrawerController drawerController, View view, @Nullable View view2, Integer num) {
        if (view2.getBackground() != null || view.getBackground() != null) {
            return;
        }
        if (num != null) {
            view.setBackgroundResource(num.intValue());
            return;
        }
        TypedArray obtainStyledAttributes = drawerController.f8398e.getTheme().obtainStyledAttributes(new int[]{16842836});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (drawable == null) {
            view.setBackgroundResource(2131363503);
        } else if (VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public final void m12948a(DrawerInterceptor drawerInterceptor) {
        if (m12952b()) {
            this.f8400g.k.add(drawerInterceptor);
            return;
        }
        throw new IllegalStateException("Can't add a drawer interceptor until after the DrawerController has been attached.");
    }

    public final void m12950b(DrawerInterceptor drawerInterceptor) {
        if (m12952b()) {
            this.f8400g.k.remove(drawerInterceptor);
            return;
        }
        throw new IllegalStateException("Can't remove a drawer interceptor until after the DrawerController has been attached.");
    }

    public final FragmentManager m12953d() {
        return ((FragmentManagerHost) this.f8398e).kO_();
    }

    public final void m12947a(Drawer drawer, BaseDrawerContentController baseDrawerContentController) {
        boolean z = true;
        if (m12952b()) {
            Preconditions.checkNotNull(baseDrawerContentController, "Cannot attach a null DrawerContentController to DrawerController");
            switch (1.a[drawer.ordinal()]) {
                case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                    if (this.f8402i != null) {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "A left content controller is already attached to the DrawerController");
                    this.f8402i = new DrawerContent(this, drawer, baseDrawerContentController);
                    break;
                case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                    if (this.f8403j != null) {
                        z = false;
                    }
                    Preconditions.checkArgument(z, "A right content controller is already attached to the DrawerController");
                    this.f8403j = new DrawerContent(this, drawer, baseDrawerContentController);
                    break;
            }
            baseDrawerContentController.mo1733a(this);
            if (drawer == Drawer.LEFT && this.f8409p != DrawerState.SHOWING_LEFT) {
                return;
            }
            if (drawer != Drawer.RIGHT || this.f8409p == DrawerState.SHOWING_RIGHT) {
                DrawerContent drawerContent;
                switch (1.a[drawer.ordinal()]) {
                    case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                        drawerContent = this.f8402i;
                        break;
                    case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                        drawerContent = this.f8403j;
                        break;
                    default:
                        drawerContent = null;
                        break;
                }
                DrawerContent drawerContent2 = drawerContent;
                if (drawerContent2 != null) {
                    drawerContent2.b();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Must attach DrawerController to an Activity before attaching content controllers");
    }

    private void m12927a(BaseDrawerContentController baseDrawerContentController) {
        DrawerContent drawerContent;
        if (this.f8402i != null && this.f8402i.a(baseDrawerContentController)) {
            if (m12940l()) {
                m12945a(false);
            }
            this.f8400g.setLeftDrawerWidth(0);
            drawerContent = this.f8402i;
            this.f8402i = null;
        } else if (this.f8403j == null || !this.f8403j.a(baseDrawerContentController)) {
            drawerContent = null;
        } else {
            if (m12941m()) {
                m12945a(false);
            }
            this.f8400g.setRightDrawerWidth(0);
            drawerContent = this.f8403j;
            this.f8403j = null;
        }
        if (drawerContent != null) {
            DrawerContent.a(drawerContent.c);
            DrawerContent.a(drawerContent.g);
            drawerContent.c = null;
            drawerContent.g = null;
            drawerContent.d = null;
            drawerContent.e = -1;
            drawerContent.h = false;
            baseDrawerContentController.mo1736b(this);
        }
    }

    public final void m12954e() {
        if (this.f8402i != null) {
            m12927a(this.f8402i.d);
        }
        if (this.f8403j != null) {
            m12927a(this.f8403j.d);
        }
    }

    private ListenableFuture<Void> m12925a(Drawer drawer, boolean z) {
        DrawerState drawerState = null;
        switch (1.a[drawer.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (this.f8402i != null) {
                    drawerState = DrawerState.SHOWING_LEFT;
                    break;
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (this.f8403j != null) {
                    drawerState = DrawerState.SHOWING_RIGHT;
                    break;
                }
                break;
        }
        if (drawerState == null) {
            throw new RuntimeException("Tried to open an invalid drawer.");
        }
        m12932b(true);
        return m12926a(drawerState, z);
    }

    public final ListenableFuture<Void> m12944a(DrawerContentController drawerContentController, boolean z) {
        if (this.f8402i != null && this.f8402i.a(drawerContentController)) {
            return m12925a(Drawer.LEFT, z);
        }
        if (this.f8403j != null && this.f8403j.a(drawerContentController)) {
            return m12925a(Drawer.RIGHT, z);
        }
        throw new IllegalArgumentException("Unknown drawer content controller");
    }

    public final ListenableFuture<Void> m12945a(boolean z) {
        return m12926a(DrawerState.CLOSED, z);
    }

    private ListenableFuture<Void> m12926a(DrawerState drawerState, boolean z) {
        if (this.f8408o != null && this.f8408o.a == drawerState) {
            return this.f8408o.b;
        }
        if (m12935d(drawerState) && !this.f8410q) {
            return Futures.m2452a(null);
        }
        if (this.f8408o != null) {
            this.f8408o.c();
            this.f8408o = null;
        }
        StateChangeFuture stateChangeFuture = new StateChangeFuture(drawerState);
        this.f8408o = stateChangeFuture;
        this.f8400g.a(drawerState, z);
        if (!(this.f8405l == null || this.f8404k == null)) {
            Object obj;
            if (this.f8405l == null || !this.f8405l.f137y) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                DrawerLifecycleListener.a(this.f8404k, drawerState);
            }
        }
        return stateChangeFuture.b;
    }

    private boolean m12940l() {
        return m12935d(DrawerState.SHOWING_LEFT);
    }

    private boolean m12941m() {
        return m12935d(DrawerState.SHOWING_RIGHT);
    }

    public final boolean m12955g() {
        return m12935d(DrawerState.CLOSED);
    }

    private boolean m12935d(DrawerState drawerState) {
        return this.f8409p == drawerState;
    }

    private void m12931b(DrawerState drawerState, boolean z) {
        Object obj = 1;
        DrawerState drawerState2 = this.f8409p;
        boolean z2 = this.f8410q;
        Object obj2 = drawerState2 != drawerState ? 1 : null;
        if (z2 == z) {
            obj = null;
        }
        if (obj2 != null) {
            this.f8409p = drawerState;
        }
        if (obj != null) {
            this.f8410q = z;
            if (z) {
                if (m12952b()) {
                    this.f8396c.hideSoftInputFromWindow(this.f8398e.getWindow().getDecorView().getWindowToken(), 0);
                }
                for (OneSidedDrawerAnimationStateListener oneSidedDrawerAnimationStateListener : this.f8407n) {
                    DrawerState drawerState3 = this.f8409p;
                    if (!(drawerState2 == oneSidedDrawerAnimationStateListener.f8416c || drawerState3 == oneSidedDrawerAnimationStateListener.f8416c)) {
                        oneSidedDrawerAnimationStateListener.f8417d = true;
                        oneSidedDrawerAnimationStateListener.mo1744a(OneSidedDrawerAnimationStateListener.m12961c(drawerState2));
                    }
                }
                return;
            }
            m12942p();
        } else if (obj2 == null) {
        } else {
            if (z) {
                m12937f(drawerState2);
            } else {
                m12939g(drawerState2);
            }
        }
    }

    private void m12942p() {
        for (OneSidedDrawerAnimationStateListener oneSidedDrawerAnimationStateListener : this.f8407n) {
            DrawerState drawerState = this.f8409p;
            if (drawerState != oneSidedDrawerAnimationStateListener.f8416c && oneSidedDrawerAnimationStateListener.f8417d) {
                oneSidedDrawerAnimationStateListener.f8417d = false;
                oneSidedDrawerAnimationStateListener.mo1745b(OneSidedDrawerAnimationStateListener.m12961c(drawerState));
            }
        }
    }

    private void m12937f(DrawerState drawerState) {
        for (OneSidedDrawerAnimationStateListener oneSidedDrawerAnimationStateListener : this.f8407n) {
            DrawerState drawerState2 = this.f8409p;
            if (oneSidedDrawerAnimationStateListener.f8417d && drawerState2 == oneSidedDrawerAnimationStateListener.f8416c) {
                oneSidedDrawerAnimationStateListener.f8417d = false;
                oneSidedDrawerAnimationStateListener.mo1745b(SingleDrawerState.CLOSED);
            } else if (!oneSidedDrawerAnimationStateListener.f8417d && drawerState2 == oneSidedDrawerAnimationStateListener.f8415b) {
                oneSidedDrawerAnimationStateListener.f8417d = true;
                oneSidedDrawerAnimationStateListener.mo1744a(SingleDrawerState.CLOSED);
            }
        }
    }

    private void m12939g(DrawerState drawerState) {
        for (OneSidedDrawerAnimationStateListener oneSidedDrawerAnimationStateListener : this.f8407n) {
            DrawerState drawerState2 = this.f8409p;
            oneSidedDrawerAnimationStateListener.f8417d = false;
            if (!(drawerState == oneSidedDrawerAnimationStateListener.f8416c || drawerState2 == oneSidedDrawerAnimationStateListener.f8416c)) {
                oneSidedDrawerAnimationStateListener.mo1746c(OneSidedDrawerAnimationStateListener.m12961c(drawerState2));
            }
        }
    }

    public final void m12949a(DrawerState drawerState) {
        m12931b(drawerState, false);
        switch (1.b[drawerState.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m12936e(true);
                m12938f(false);
                m12933c(true);
                m12934d(false);
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m12936e(false);
                m12938f(true);
                m12933c(false);
                m12934d(true);
                break;
            case 3:
                m12936e(false);
                m12938f(false);
                m12933c(false);
                m12934d(false);
                if (this.f8401h == BackgroundStrategy.ENSURE_BACKGROUND) {
                    View childAt = this.f8400g.getChildAt(0);
                    if (childAt.getBackground() == null) {
                        childAt.setBackgroundResource(0);
                        break;
                    }
                }
                break;
        }
        if (this.f8408o != null) {
            StateChangeFuture stateChangeFuture = this.f8408o;
            if (stateChangeFuture.a == drawerState) {
                FutureDetour.a(stateChangeFuture.b, null, -2061058443);
            } else {
                stateChangeFuture.c();
            }
            this.f8408o = null;
        }
    }

    public final void m12951b(DrawerState drawerState) {
        m12931b(drawerState, true);
        m12936e(false);
        m12938f(false);
        switch (1.b[drawerState.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                m12933c(true);
                m12934d(false);
                return;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                m12933c(false);
                m12934d(true);
                return;
            case 3:
                m12933c(false);
                m12934d(false);
                return;
            default:
                return;
        }
    }

    public static void m12943q(DrawerController drawerController) {
        drawerController.m12932b(false);
    }

    private void m12932b(boolean z) {
        if (m12952b()) {
            if (this.f8402i != null && (z || this.f8409p == DrawerState.SHOWING_LEFT)) {
                this.f8402i.b();
            }
            if (this.f8403j == null) {
                return;
            }
            if (z || this.f8409p == DrawerState.SHOWING_RIGHT) {
                this.f8403j.b();
            }
        }
    }

    private void m12933c(boolean z) {
        if (this.f8402i != null) {
            this.f8402i.a(z);
        }
    }

    private void m12934d(boolean z) {
        if (this.f8403j != null) {
            this.f8403j.a(z);
        }
    }

    private void m12936e(boolean z) {
        if (this.f8402i != null) {
            this.f8402i.b(z);
        }
    }

    private void m12938f(boolean z) {
        if (this.f8403j != null) {
            this.f8403j.b(z);
        }
    }
}
