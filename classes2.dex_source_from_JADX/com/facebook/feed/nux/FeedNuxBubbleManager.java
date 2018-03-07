package com.facebook.feed.nux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.userinteraction.DefaultUserInteractionController;
import com.facebook.common.userinteraction.UserInteractionListener;
import com.facebook.common.util.SizeUtil;
import com.facebook.device.ScreenUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.nux.NuxBubbleManager.Nux;
import com.facebook.nux.ui.NuxBubbleView;
import com.google.common.collect.Sets;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: placelist_map */
public class FeedNuxBubbleManager {
    private static FeedNuxBubbleManager f9753r;
    private static final Object f9754s = new Object();
    public int f9755a = 0;
    public int f9756b = 0;
    public NuxBubbleView f9757c = null;
    private WeakReference<ViewGroup> f9758d = null;
    private final Context f9759e;
    private final LayoutInflater f9760f;
    private final ScreenUtil f9761g;
    public final DefaultUserInteractionController f9762h;
    private final AbstractFbErrorReporter f9763i;
    private final DefaultAndroidThreadUtil f9764j;
    public UserInteractionListener f9765k;
    private InterstitialTrigger f9766l;
    private WeakHashMap<View, Nux> f9767m = new WeakHashMap();
    private WeakHashMap<ViewGroup, Set<WeakReference<View>>> f9768n = new WeakHashMap();
    public Nux f9769o;
    public final EnumSet<BlockingCause> f9770p = EnumSet.noneOf(BlockingCause.class);
    public Runnable f9771q;

    /* compiled from: placelist_map */
    public enum BlockingCause {
        IS_SCROLLING,
        IS_LOADING,
        IS_POSTING
    }

    /* compiled from: placelist_map */
    public class C05121 implements UserInteractionListener {
        final /* synthetic */ FeedNuxBubbleManager f12252a;

        public C05121(FeedNuxBubbleManager feedNuxBubbleManager) {
            this.f12252a = feedNuxBubbleManager;
        }

        public final void mo353a(boolean z) {
            this.f12252a.m14785b(z);
        }
    }

    /* compiled from: placelist_map */
    class C05132 implements Runnable {
        final /* synthetic */ FeedNuxBubbleManager f12253a;

        C05132(FeedNuxBubbleManager feedNuxBubbleManager) {
            this.f12253a = feedNuxBubbleManager;
        }

        public void run() {
            if (this.f12253a.f9771q == this && this.f12253a.f9770p.isEmpty()) {
                Nux d = FeedNuxBubbleManager.m14772d(this.f12253a);
                if (d != null) {
                    View view = (View) d.c.get();
                    if (view != null && view.isShown()) {
                        if (this.f12253a.f9757c == null) {
                            this.f12253a.f9757c = FeedNuxBubbleManager.m14769c(this.f12253a, d);
                        } else if (this.f12253a.f9769o == d) {
                            this.f12253a.f9757c.setVisibility(0);
                            this.f12253a.f9757c.e();
                        } else {
                            FeedNuxBubbleManager.m14770c(this.f12253a);
                            this.f12253a.f9757c = FeedNuxBubbleManager.m14769c(this.f12253a, d);
                        }
                        FeedNuxBubbleManager.m14773d(this.f12253a, d);
                        this.f12253a.f9769o = d;
                    }
                }
            }
        }
    }

    private static FeedNuxBubbleManager m14767b(InjectorLike injectorLike) {
        return new FeedNuxBubbleManager((Context) injectorLike.getInstance(Context.class), DefaultUserInteractionController.m1747a(injectorLike), LayoutInflaterMethodAutoProvider.m14787b(injectorLike), ScreenUtil.m8695a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike));
    }

    public static FeedNuxBubbleManager m14765a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedNuxBubbleManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f9754s) {
                FeedNuxBubbleManager feedNuxBubbleManager;
                if (a2 != null) {
                    feedNuxBubbleManager = (FeedNuxBubbleManager) a2.mo818a(f9754s);
                } else {
                    feedNuxBubbleManager = f9753r;
                }
                if (feedNuxBubbleManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m14767b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f9754s, b3);
                        } else {
                            f9753r = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedNuxBubbleManager;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FeedNuxBubbleManager(Context context, DefaultUserInteractionController defaultUserInteractionController, LayoutInflater layoutInflater, ScreenUtil screenUtil, AbstractFbErrorReporter abstractFbErrorReporter, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f9762h = defaultUserInteractionController;
        this.f9760f = layoutInflater;
        this.f9761g = screenUtil;
        this.f9759e = context;
        this.f9763i = abstractFbErrorReporter;
        this.f9764j = defaultAndroidThreadUtil;
        this.f9766l = new InterstitialTrigger(Action.UNKNOWN);
    }

    public final void m14779a(@Nullable ViewGroup viewGroup, InterstitialTrigger interstitialTrigger) {
        this.f9766l = interstitialTrigger;
        if (!(this.f9758d == null || this.f9758d.get() == null || this.f9758d.get() == viewGroup)) {
            m14770c(this);
        }
        if (this.f9765k == null) {
            this.f9765k = new C05121(this);
            this.f9762h.m1754a(this.f9765k);
        }
        this.f9758d = new WeakReference(viewGroup);
    }

    public final void m14778a(@Nullable ViewGroup viewGroup) {
        this.f9766l = new InterstitialTrigger(Action.UNKNOWN);
        if (viewGroup != null) {
            Set<WeakReference> set = (Set) this.f9768n.get(viewGroup);
            if (set != null) {
                for (WeakReference weakReference : set) {
                    View view = (View) weakReference.get();
                    if (view != null) {
                        Nux nux = (Nux) this.f9767m.get(view);
                        this.f9767m.remove(view);
                        if (this.f9769o == nux) {
                            m14771c(this, false);
                            m14770c(this);
                        }
                    }
                }
                this.f9768n.remove(viewGroup);
            }
        }
    }

    public final void m14781a(@Nullable Nux nux) {
        if (nux != null && this.f9758d != null && this.f9758d.get() != null && nux.d.a(this.f9766l)) {
            View view = (View) nux.c.get();
            if (view != null) {
                this.f9767m.put(view, nux);
                Set set = (Set) this.f9768n.get(this.f9758d.get());
                if (set == null) {
                    set = Sets.m1313a();
                    this.f9768n.put(this.f9758d.get(), set);
                }
                set.add(new WeakReference(view));
                if (!m14775g()) {
                    m14774f();
                }
            }
        }
    }

    public final void m14777a(View view) {
        if (this.f9769o != null && this.f9769o.c.get() == view && m14775g()) {
            m14771c(this, false);
            m14770c(this);
        }
        this.f9767m.remove(view);
        for (Set<WeakReference> set : this.f9768n.values()) {
            if (!(set == null || set.isEmpty())) {
                for (WeakReference weakReference : set) {
                    if (weakReference != null && weakReference.get() != null && weakReference.get() == view) {
                        set.remove(weakReference);
                        return;
                    }
                }
                continue;
            }
        }
    }

    public final void m14776a() {
        if (m14775g()) {
            m14771c(this, true);
            this.f9769o.d.b();
        }
    }

    public final void m14782a(boolean z) {
        if (m14775g()) {
            m14771c(this, z);
            this.f9769o.d.c();
        }
    }

    public final void m14780a(BlockingCause blockingCause) {
        this.f9770p.add(blockingCause);
        m14782a(true);
    }

    public final void m14784b(BlockingCause blockingCause) {
        this.f9770p.remove(blockingCause);
    }

    public final void m14783b() {
        if (!m14775g()) {
            return;
        }
        if (m14768b(this.f9769o)) {
            m14773d(this, this.f9769o);
        } else {
            m14771c(this, true);
        }
    }

    public static void m14770c(FeedNuxBubbleManager feedNuxBubbleManager) {
        if (feedNuxBubbleManager.f9757c != null) {
            feedNuxBubbleManager.f9757c.p = null;
            feedNuxBubbleManager.f9757c.setOnClickListener(null);
            if (feedNuxBubbleManager.f9758d != null) {
                ViewGroup viewGroup = (ViewGroup) feedNuxBubbleManager.f9758d.get();
                if (viewGroup != null) {
                    viewGroup.removeView(feedNuxBubbleManager.f9757c);
                }
            }
            feedNuxBubbleManager.f9757c = null;
            feedNuxBubbleManager.f9769o = null;
        }
    }

    @Nullable
    public static Nux m14772d(FeedNuxBubbleManager feedNuxBubbleManager) {
        View view = null;
        if (feedNuxBubbleManager.f9767m.isEmpty() || feedNuxBubbleManager.f9758d == null || feedNuxBubbleManager.f9758d.get() == null) {
            return null;
        }
        Set<WeakReference> set = (Set) feedNuxBubbleManager.f9768n.get(feedNuxBubbleManager.f9758d.get());
        if (set == null || set.isEmpty()) {
            return null;
        }
        View view2 = null;
        for (WeakReference weakReference : set) {
            View view3 = (View) weakReference.get();
            if (view3 != null) {
                Nux nux = (Nux) feedNuxBubbleManager.f9767m.get(view3);
                if (!(view3.isShown() && feedNuxBubbleManager.m14768b(nux) && nux.d.a(feedNuxBubbleManager.f9766l) && (view2 == null || m14766b(view3) < m14766b(view)))) {
                    view3 = view;
                    nux = view2;
                }
                view = view3;
                view2 = nux;
            }
        }
        return view2;
    }

    private static int m14766b(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return iArr[1];
    }

    public static void m14771c(FeedNuxBubbleManager feedNuxBubbleManager, boolean z) {
        feedNuxBubbleManager.f9771q = null;
        if (feedNuxBubbleManager.f9757c != null) {
            if (!z) {
                feedNuxBubbleManager.f9757c.setVisibility(8);
            }
            feedNuxBubbleManager.f9757c.f();
        }
    }

    public final void m14785b(boolean z) {
        if (z || m14775g()) {
            if (z && m14775g() && this.f9769o != null) {
                this.f9769o.d.a();
            }
            m14771c(this, true);
            return;
        }
        m14774f();
    }

    private boolean m14768b(Nux nux) {
        if (nux == null || nux.c == null || nux.c.get() == null || this.f9758d == null || this.f9758d.get() == null) {
            return false;
        }
        View view = (View) nux.c.get();
        View view2 = (View) this.f9758d.get();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        try {
            view.getLocationInWindow(iArr);
            view2.getLocationInWindow(iArr2);
            int a = SizeUtil.m19191a(this.f9759e, 65.0f);
            int d = this.f9761g.m8703d();
            if (nux.e) {
                if ((view.getHeight() / 3) + iArr[1] > d - this.f9756b) {
                    return false;
                }
                if ((iArr[1] - this.f9755a) - iArr2[1] < a) {
                    return false;
                }
            } else if (iArr[1] + (view.getHeight() / 3) < iArr2[1] + this.f9755a) {
                return false;
            } else {
                if ((view.getHeight() + iArr[1]) + a > d - this.f9756b) {
                    return false;
                }
            }
            if (iArr[0] > this.f9761g.m8702c() || iArr[0] < 0) {
                return false;
            }
            return true;
        } catch (Throwable e) {
            this.f9763i.m2343a(getClass().getSimpleName(), "NPE happens inside the getLocationInWindow()", e);
            return false;
        }
    }

    private void m14774f() {
        this.f9771q = new C05132(this);
        this.f9764j.m1653a(this.f9771q, 400);
    }

    private boolean m14775g() {
        return (this.f9757c == null || !this.f9757c.isShown() || this.f9757c.g()) ? false : true;
    }

    @Nullable
    public static NuxBubbleView m14769c(@Nullable FeedNuxBubbleManager feedNuxBubbleManager, Nux nux) {
        if (nux == null || feedNuxBubbleManager.f9758d == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) feedNuxBubbleManager.f9758d.get();
        if (viewGroup == null) {
            return null;
        }
        NuxBubbleView nuxBubbleView = (NuxBubbleView) feedNuxBubbleManager.f9760f.inflate(nux.a, viewGroup, false);
        nuxBubbleView.setBubbleBody(nux.b);
        nuxBubbleView.setContentDescription(nux.b);
        nuxBubbleView.setOnClickListener(new 3(feedNuxBubbleManager, nux));
        nuxBubbleView.p = new 4(feedNuxBubbleManager, nux);
        viewGroup.addView(nuxBubbleView);
        return nuxBubbleView;
    }

    public static void m14773d(FeedNuxBubbleManager feedNuxBubbleManager, Nux nux) {
        View view = (View) nux.c.get();
        if (view != null && feedNuxBubbleManager.f9758d != null) {
            ViewGroup viewGroup = (ViewGroup) feedNuxBubbleManager.f9758d.get();
            if (viewGroup != null) {
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr);
                viewGroup.getLocationInWindow(iArr2);
                int i = iArr[1] - iArr2[1];
                if (nux.e) {
                    i -= feedNuxBubbleManager.f9757c.getHeight();
                }
                feedNuxBubbleManager.f9757c.setTranslationY((float) (i + SizeUtil.m19191a(feedNuxBubbleManager.f9759e, (float) nux.f)));
                feedNuxBubbleManager.f9757c.setTranslationX((float) ((view.getWidth() / 2) + (((iArr[0] - iArr2[0]) - feedNuxBubbleManager.f9757c.getWidth()) + (feedNuxBubbleManager.f9757c.getNubRightMargin() + (feedNuxBubbleManager.f9757c.getPointerWidth() / 2)))));
            }
        }
    }
}
