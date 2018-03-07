package com.facebook.ui.recyclableviewpool;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.common.appchoreographer.AppChoreographer;
import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.diagnostics.VMMemoryInfo;
import com.facebook.common.diagnostics.VMMemoryInfoMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.widget.FbCustomViewGroup;
import com.google.common.base.Preconditions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import javax.inject.Inject;

@ContextScoped
/* compiled from: nux_key */
public class RecyclableViewPoolManager {
    public static final ViewPoolLimit f6446a = new ViewPoolLimit(3, 1);
    public static final ViewPoolLimit f6447b = new ViewPoolLimit(1, 1);
    public static final ViewPoolPrefillAmount f6448c;
    public static final ViewPoolPrefillAmount f6449d;
    public static final ViewPoolPrefillAmount f6450e = new ViewPoolPrefillAmount(3, 1);
    private static RecyclableViewPoolManager f6451m;
    private static final Object f6452n = new Object();
    private final DefaultAppChoreographer f6453f;
    private final Map<Class<?>, ViewPoolConfig> f6454g;
    private final ArrayListMultimap<Class<?>, View> f6455h = ArrayListMultimap.t();
    public final List<Future> f6456i = Lists.a();
    private Lazy<Set<RecyclableViewsDeclaration>> f6457j;
    public final boolean f6458k;
    private boolean f6459l;

    /* compiled from: nux_key */
    public class ViewPoolLimit {
        public final int f6460a;
        public final int f6461b;

        public ViewPoolLimit(int i, int i2) {
            this.f6460a = i;
            this.f6461b = i2;
        }
    }

    /* compiled from: nux_key */
    public class ViewPoolPrefillAmount {
        public final int f6462a;
        public final int f6463b;

        public ViewPoolPrefillAmount(int i, int i2) {
            this.f6462a = i;
            this.f6463b = i2;
        }
    }

    /* compiled from: nux_key */
    class ViewPoolConfig {
        final /* synthetic */ RecyclableViewPoolManager f6538a;
        public final int f6539b;
        public final int f6540c;

        public ViewPoolConfig(RecyclableViewPoolManager recyclableViewPoolManager, ViewPoolLimit viewPoolLimit, ViewPoolPrefillAmount viewPoolPrefillAmount) {
            this.f6538a = recyclableViewPoolManager;
            this.f6539b = recyclableViewPoolManager.f6458k ? viewPoolLimit.f6461b : viewPoolLimit.f6460a;
            this.f6540c = recyclableViewPoolManager.f6458k ? viewPoolPrefillAmount.f6463b : viewPoolPrefillAmount.f6462a;
        }
    }

    private static RecyclableViewPoolManager m6893b(InjectorLike injectorLike) {
        return new RecyclableViewPoolManager(DefaultAppChoreographer.a(injectorLike), VMMemoryInfoMethodAutoProvider.a(injectorLike), ProviderLazy.a(new STATICDI_MULTIBIND_PROVIDER$RecyclableViewsDeclaration(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()));
    }

    static {
        ViewPoolPrefillAmount viewPoolPrefillAmount = new ViewPoolPrefillAmount(0, 0);
        f6448c = viewPoolPrefillAmount;
        f6449d = viewPoolPrefillAmount;
    }

    @Inject
    public RecyclableViewPoolManager(AppChoreographer appChoreographer, VMMemoryInfo vMMemoryInfo, Lazy<Set<RecyclableViewsDeclaration>> lazy) {
        this.f6453f = appChoreographer;
        this.f6457j = lazy;
        this.f6458k = vMMemoryInfo.a();
        this.f6454g = Maps.c();
    }

    public static RecyclableViewPoolManager m6891a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RecyclableViewPoolManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6452n) {
                RecyclableViewPoolManager recyclableViewPoolManager;
                if (a2 != null) {
                    recyclableViewPoolManager = (RecyclableViewPoolManager) a2.a(f6452n);
                } else {
                    recyclableViewPoolManager = f6451m;
                }
                if (recyclableViewPoolManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6893b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6452n, b3);
                        } else {
                            f6451m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = recyclableViewPoolManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m6901a(Class<?> cls, ViewPoolLimit viewPoolLimit, ViewPoolPrefillAmount viewPoolPrefillAmount) {
        this.f6454g.put(cls, new ViewPoolConfig(this, viewPoolLimit, viewPoolPrefillAmount));
    }

    public static boolean m6892a(RecyclableViewPoolManager recyclableViewPoolManager, Class cls, View view) {
        if (!m6894b(recyclableViewPoolManager, cls)) {
            return false;
        }
        recyclableViewPoolManager.f6455h.a(cls).add(view);
        return true;
    }

    public static boolean m6894b(RecyclableViewPoolManager recyclableViewPoolManager, Class cls) {
        recyclableViewPoolManager.m6895c();
        if (recyclableViewPoolManager.f6454g.containsKey(cls)) {
            return recyclableViewPoolManager.f6455h.a(cls).size() < ((ViewPoolConfig) recyclableViewPoolManager.f6454g.get(cls)).f6539b;
        } else {
            m6896c(cls);
            return false;
        }
    }

    public final void m6899a(Class<?> cls, View view, FbCustomViewGroup fbCustomViewGroup) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkArgument(cls != null);
        if (view != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (fbCustomViewGroup == null) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        fbCustomViewGroup.detachRecyclableViewFromParent(view);
        if (!m6892a(this, (Class) cls, view)) {
            fbCustomViewGroup.removeRecyclableViewFromParent(view, false);
        }
    }

    public final <T extends View> T m6897a(Class<?> cls) {
        Preconditions.checkArgument(cls != null);
        if (this.f6455h.f(cls)) {
            List a = this.f6455h.a(cls);
            if (!a.isEmpty()) {
                View view = (View) a.remove(a.size() - 1);
                view.setVisibility(0);
                return view;
            }
        }
        return null;
    }

    public final <T extends View> void m6900a(final Class<?> cls, final IRecyclableViewFactory<?> iRecyclableViewFactory, Activity activity) {
        boolean z = true;
        int i = 0;
        Preconditions.checkArgument(cls != null);
        if (iRecyclableViewFactory == null) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (activity != null && !activity.isFinishing()) {
            m6895c();
            ViewPoolConfig viewPoolConfig = (ViewPoolConfig) this.f6454g.get(cls);
            if (viewPoolConfig == null) {
                m6896c(cls);
                return;
            }
            List a = this.f6455h.a(cls);
            if (a.size() < viewPoolConfig.f6540c) {
                final WeakReference weakReference = new WeakReference(activity);
                Runnable c03281 = new Runnable(this) {
                    final /* synthetic */ RecyclableViewPoolManager f6943d;

                    public void run() {
                        Activity activity = (Activity) weakReference.get();
                        if (activity != null && RecyclableViewPoolManager.m6894b(this.f6943d, cls)) {
                            RecyclableViewPoolManager.m6892a(this.f6943d, cls, iRecyclableViewFactory.mo999a(activity));
                        }
                    }
                };
                while (i < viewPoolConfig.f6540c && a.size() < viewPoolConfig.f6540c) {
                    this.f6456i.add(this.f6453f.a("FeedRecyclableViewPoolManager-preInflate", c03281, Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI));
                    i++;
                }
            }
        }
    }

    public final void m6898a() {
        for (Future future : this.f6456i) {
            if (!future.isDone()) {
                future.cancel(true);
            }
        }
        this.f6456i.clear();
        this.f6455h.g();
    }

    private static void m6896c(Class<?> cls) {
        throw new IllegalStateException(cls.getSimpleName() + " isn't configured for recycling");
    }

    private void m6895c() {
        if (!this.f6459l) {
            for (RecyclableViewsDeclaration a : (Set) this.f6457j.get()) {
                a.a(this);
            }
            this.f6459l = true;
        }
    }
}
