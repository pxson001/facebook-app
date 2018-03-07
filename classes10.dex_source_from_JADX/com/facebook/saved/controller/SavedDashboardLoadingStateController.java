package com.facebook.saved.controller;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.fragment.SavedItemsListAdapter.ItemsFreshness;
import com.facebook.saved.perf.SavedDashboardStartPerfLogger;
import com.facebook.saved.views.SavedDashboardEmptyView.OnEmptyViewReadyListener;
import com.facebook.widget.refreshableview.RefreshableViewContainer;
import com.google.common.base.Optional;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@ContextScoped
@NotThreadSafe
/* compiled from: is_from_get_notified_notification */
public class SavedDashboardLoadingStateController {
    public static final String f9024a = SavedDashboardLoadingStateController.class.getSimpleName();
    private static SavedDashboardLoadingStateController f9025j;
    private static final Object f9026k = new Object();
    public RefreshableViewContainer f9027b;
    public int f9028c = 2;
    public int f9029d = 2;
    public boolean f9030e = false;
    public Optional<SavedDashboardSection> f9031f;
    public final SavedDashboardStartPerfLogger f9032g;
    public final AbstractFbErrorReporter f9033h;
    public SavedItemsEmptyListViewController f9034i;

    /* compiled from: is_from_get_notified_notification */
    class C13731 implements OnEmptyViewReadyListener {
        final /* synthetic */ SavedDashboardLoadingStateController f9022a;

        C13731(SavedDashboardLoadingStateController savedDashboardLoadingStateController) {
            this.f9022a = savedDashboardLoadingStateController;
        }

        public final void mo416a() {
            this.f9022a.f9032g.m9259a(0, ItemsFreshness.FROM_CACHE);
            this.f9022a.f9032g.m9258a(0);
            this.f9022a.f9032g.m9262a(true);
        }
    }

    /* compiled from: is_from_get_notified_notification */
    class C13742 implements OnEmptyViewReadyListener {
        final /* synthetic */ SavedDashboardLoadingStateController f9023a;

        C13742(SavedDashboardLoadingStateController savedDashboardLoadingStateController) {
            this.f9023a = savedDashboardLoadingStateController;
        }

        public final void mo416a() {
            this.f9023a.f9032g.m9259a(0, ItemsFreshness.FROM_SERVER);
            this.f9023a.f9032g.m9264b(0);
            this.f9023a.f9032g.m9262a(true);
        }
    }

    private static SavedDashboardLoadingStateController m9045b(InjectorLike injectorLike) {
        return new SavedDashboardLoadingStateController(SavedDashboardStartPerfLogger.m9242a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public SavedDashboardLoadingStateController(SavedDashboardStartPerfLogger savedDashboardStartPerfLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9032g = savedDashboardStartPerfLogger;
        this.f9033h = abstractFbErrorReporter;
    }

    public static SavedDashboardLoadingStateController m9044a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedDashboardLoadingStateController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9026k) {
                SavedDashboardLoadingStateController savedDashboardLoadingStateController;
                if (a2 != null) {
                    savedDashboardLoadingStateController = (SavedDashboardLoadingStateController) a2.a(f9026k);
                } else {
                    savedDashboardLoadingStateController = f9025j;
                }
                if (savedDashboardLoadingStateController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9045b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9026k, b3);
                        } else {
                            f9025j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedDashboardLoadingStateController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m9051d() {
        this.f9032g.m9268f();
        this.f9028c = 2;
    }

    public final void m9048a(boolean z, Long l) {
        this.f9032g.m9261a(l);
        m9047k();
        this.f9028c = 2;
        if (!z && this.f9034i.m9099a(new C13731(this), this.f9031f)) {
            this.f9032g.m9269g();
        }
    }

    public final void m9052f() {
        this.f9032g.m9267e();
        if (this.f9029d == 2) {
            m9046j();
        }
        this.f9028c = 2;
    }

    public final void m9049a(boolean z, boolean z2) {
        this.f9032g.m9271i();
        m9047k();
        this.f9029d = 2;
        if (z2) {
            this.f9032g.m9273k();
        } else if (!z && this.f9034i.m9099a(new C13742(this), this.f9031f)) {
            this.f9032g.m9273k();
        }
    }

    public final void m9050b(boolean z, boolean z2) {
        this.f9032g.m9272j();
        if (this.f9028c != 1) {
            if (!z || z2) {
                m9046j();
            } else {
                m9047k();
                this.f9032g.m9262a(true);
            }
        }
        this.f9029d = 2;
    }

    private void m9046j() {
        this.f9027b.b(2131238167);
        this.f9032g.m9262a(false);
    }

    private void m9047k() {
        this.f9027b.f();
    }
}
