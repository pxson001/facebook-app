package com.facebook.divebar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.facebook.common.activitylistener.ListenableActivity;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.divebar.DivebarController.DivebarState;
import com.facebook.divebar.DivebarController.DivebarType;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.drawers.BaseDrawerContentController;
import com.facebook.ui.drawers.Drawer;
import com.facebook.ui.drawers.DrawerContentFragment;
import com.facebook.ui.drawers.DrawerController;
import com.facebook.ui.drawers.DrawerController.1;
import com.facebook.ui.drawers.DrawerFragmentContentController;
import com.facebook.ui.drawers.DrawerFragmentContentController.LoadStrategy;
import com.facebook.ui.drawers.OneSidedDrawerAnimationStateListener;
import com.facebook.ui.drawers.OneSidedDrawerAnimationStateListener.SingleDrawerState;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: queue_size */
public class DrawerBasedDivebarControllerImpl extends DrawerFragmentContentController {
    private static final Drawer f8368g = Drawer.RIGHT;
    private static DrawerBasedDivebarControllerImpl f8369p;
    private static final Object f8370q = new Object();
    public final Lazy<DivebarControllerDelegate> f8371h;
    private final DrawerController f8372i;
    public DivebarStateListenerWrapper f8373j = null;
    public DivebarController$DivebarAnimationListener f8374k = null;
    public DisableSwipeToOpenDrawerInterceptor f8375l = null;
    private DrawerContentFragment f8376m;
    public Intent f8377n;
    private final OneSidedDrawerAnimationStateListener f8378o = new OneSidedDrawerAnimationStateListener(this, f8368g) {
        final /* synthetic */ DrawerBasedDivebarControllerImpl f8413a;

        public final void mo1744a(SingleDrawerState singleDrawerState) {
            if (this.f8413a.f8374k != null) {
                this.f8413a.f8374k.mo1747a(DrawerBasedDivebarControllerImpl.m12884b(singleDrawerState));
            }
            ((DivebarControllerDelegate) this.f8413a.f8371h.get()).a(DivebarState.ANIMATING);
        }

        public final void mo1745b(SingleDrawerState singleDrawerState) {
            ((DivebarControllerDelegate) this.f8413a.f8371h.get()).a(singleDrawerState == SingleDrawerState.OPENED);
            DivebarState b = DrawerBasedDivebarControllerImpl.m12884b(singleDrawerState);
            if (this.f8413a.f8374k != null) {
                this.f8413a.f8374k.mo1748b(b);
            }
            if (!(this.f8413a.f8373j == null || this.f8413a.f8373j.a == null)) {
                this.f8413a.f8373j.a.a(DrawerBasedDivebarControllerImpl.m12884b(singleDrawerState));
            }
            ((DivebarControllerDelegate) this.f8413a.f8371h.get()).a(b);
        }

        public final void mo1746c(SingleDrawerState singleDrawerState) {
            ((DivebarControllerDelegate) this.f8413a.f8371h.get()).a(DrawerBasedDivebarControllerImpl.m12884b(singleDrawerState));
        }
    };

    private static DrawerBasedDivebarControllerImpl m12885b(InjectorLike injectorLike) {
        return new DrawerBasedDivebarControllerImpl(DefaultAndroidThreadUtil.m1646b(injectorLike), IdBasedLazy.m1808a(injectorLike, 5503), DrawerController.m12924a(injectorLike));
    }

    public static DivebarState m12884b(SingleDrawerState singleDrawerState) {
        switch (2.a[singleDrawerState.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return DivebarState.OPENED;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return DivebarState.CLOSED;
            default:
                return null;
        }
    }

    public static DrawerBasedDivebarControllerImpl m12883a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DrawerBasedDivebarControllerImpl b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f8370q) {
                DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl;
                if (a2 != null) {
                    drawerBasedDivebarControllerImpl = (DrawerBasedDivebarControllerImpl) a2.mo818a(f8370q);
                } else {
                    drawerBasedDivebarControllerImpl = f8369p;
                }
                if (drawerBasedDivebarControllerImpl == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m12885b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f8370q, b3);
                        } else {
                            f8369p = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = drawerBasedDivebarControllerImpl;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public DrawerBasedDivebarControllerImpl(AndroidThreadUtil androidThreadUtil, Lazy<DivebarControllerDelegate> lazy, DrawerController drawerController) {
        super(androidThreadUtil);
        this.f8371h = lazy;
        this.f8372i = drawerController;
        LoadStrategy loadStrategy = LoadStrategy.LOAD_WHEN_FOCUSED;
        Preconditions.checkNotNull(loadStrategy);
        this.f8380h = loadStrategy;
    }

    public final int mo1737j() {
        return 2131564830;
    }

    @Nullable
    public final View mo1735b(Context context) {
        Resources resources = context.getResources();
        EmptyListViewItem emptyListViewItem = new EmptyListViewItem(context);
        emptyListViewItem.setBackgroundDrawable(new ColorDrawable(resources.getColor(2131362256)));
        emptyListViewItem.setTextColor(resources.getColor(2131362257));
        emptyListViewItem.a(true);
        emptyListViewItem.setMessage(2131230739);
        return emptyListViewItem;
    }

    public final boolean kX_() {
        return this.f8386a;
    }

    public final DrawerContentFragment mo1738k() {
        return ((DivebarControllerDelegate) this.f8371h.get()).a(this.f8388c);
    }

    public final void mo1732a(DrawerContentFragment drawerContentFragment) {
        this.f8376m = drawerContentFragment;
    }

    public final int mo1731a(Context context, int i) {
        return ((DivebarControllerDelegate) this.f8371h.get()).a(context, Math.min(context.getResources().getDimensionPixelSize(2131427816), i));
    }

    public final void mo1733a(DrawerController drawerController) {
        super.mo1733a(drawerController);
        drawerController.f8407n.add(this.f8378o);
    }

    public final void mo1736b(DrawerController drawerController) {
        boolean remove = drawerController.f8407n.remove(this.f8378o);
        super.mo1736b(drawerController);
    }

    public final void mo1734a(boolean z) {
        super.mo1734a(z);
        if (this.f8376m == null) {
            return;
        }
        if (z) {
            this.f8376m.ar();
        } else {
            this.f8376m.as();
        }
    }

    public final void m12888a(Intent intent) {
        this.f8377n = intent;
    }

    public final void m12887a(Activity activity) {
        TracerDetour.a("DrawerBasedDiverbarControllerImpl.attachToActivity", 620247415);
        try {
            if (m12922e() || m12923f()) {
                TracerDetour.a(2021673886);
                return;
            }
            if (!this.f8372i.m12952b()) {
                this.f8372i.m12946a();
            }
            this.f8372i.m12947a(f8368g, (BaseDrawerContentController) this);
            if (activity instanceof ListenableActivity) {
                ((DivebarControllerDelegate) this.f8371h.get()).a((ListenableActivity) activity, this);
            }
            TracerDetour.a(1681720723);
        } catch (Throwable th) {
            TracerDetour.a(1878919493);
        }
    }

    public final boolean kY_() {
        if (this.f8376m != null && this.f8376m.aq()) {
            return true;
        }
        if (!m12922e()) {
            return false;
        }
        DrawerController drawerController = this.f8389d;
        boolean z = true;
        switch (1.b[drawerController.f8409p.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                if (!drawerController.f8402i.d.ld_()) {
                    drawerController.m12945a(true);
                    break;
                }
                break;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                if (!drawerController.f8403j.d.ld_()) {
                    drawerController.m12945a(true);
                    break;
                }
                break;
            default:
                z = false;
                break;
        }
        return z;
    }

    public final void kZ_() {
        if (!((DivebarControllerDelegate) this.f8371h.get()).b()) {
            ListenableFuture a;
            if (m12922e()) {
                a = this.f8389d.m12944a((BaseDrawerContentController) this, true);
            } else {
                a = Futures.m2452a(null);
            }
        }
    }

    public final void m12894g() {
        ListenableFuture a;
        if (m12922e()) {
            a = this.f8389d.m12945a(true);
        } else {
            a = Futures.m2452a(null);
        }
    }

    public final void m12895i() {
        if (m12922e() && this.f8375l != null) {
            this.f8389d.m12950b(this.f8375l);
            this.f8375l = null;
        }
    }

    public final DivebarType m12898l() {
        DivebarType divebarType;
        DivebarControllerDelegate divebarControllerDelegate = (DivebarControllerDelegate) this.f8371h.get();
        if (divebarControllerDelegate.e.b()) {
            divebarType = DivebarType.REDSPACE;
        } else if (divebarControllerDelegate.d.b()) {
            divebarType = DivebarType.NOW_SIDEBAR;
        } else if (divebarControllerDelegate.c.b()) {
            divebarType = DivebarType.NOW_SIDEBAR;
        } else {
            divebarType = DivebarType.DEFAULT_DIVEBAR;
        }
        return divebarType;
    }
}
