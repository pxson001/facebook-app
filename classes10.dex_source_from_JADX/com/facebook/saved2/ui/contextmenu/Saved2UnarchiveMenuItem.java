package com.facebook.saved2.ui.contextmenu;

import android.os.Handler;
import android.os.Looper;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.saved2.ui.mutator.Saved2DbMutator;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: inline_buttons */
public class Saved2UnarchiveMenuItem implements Saved2ContextMenuItem {
    public final Lazy<UpdateSavedStateUtils> f9575a;
    public final Lazy<Toaster> f9576b;
    private final Lazy<ExecutorService> f9577c;
    public final Lazy<Saved2DbMutator> f9578d;

    public static Saved2UnarchiveMenuItem m9830b(InjectorLike injectorLike) {
        return new Saved2UnarchiveMenuItem(IdBasedSingletonScopeProvider.b(injectorLike, 10402), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 10450));
    }

    @Inject
    public Saved2UnarchiveMenuItem(Lazy<UpdateSavedStateUtils> lazy, Lazy<Toaster> lazy2, Lazy<ExecutorService> lazy3, Lazy<Saved2DbMutator> lazy4) {
        this.f9575a = lazy;
        this.f9576b = lazy2;
        this.f9577c = lazy3;
        this.f9578d = lazy4;
    }

    public final int mo445a() {
        return 2131238179;
    }

    public final int mo446b() {
        return 2130843247;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        final long d = baseQueryDAO.d();
        final String w = baseQueryDAO.w();
        final String P = baseQueryDAO.P();
        ExecutorDetour.a((ExecutorService) this.f9577c.get(), new Runnable(this) {
            final /* synthetic */ Saved2UnarchiveMenuItem f9574d;

            /* compiled from: inline_buttons */
            class C14301 implements Runnable {
                final /* synthetic */ C14311 f9570a;

                /* compiled from: inline_buttons */
                class C14291 extends OperationResultFutureCallback {
                    final /* synthetic */ C14301 f9569a;

                    C14291(C14301 c14301) {
                        this.f9569a = c14301;
                    }

                    protected final void m9828a(ServiceException serviceException) {
                        ((Toaster) this.f9569a.f9570a.f9574d.f9576b.get()).b(new ToastBuilder(2131238161));
                        Saved2UnarchiveMenuItem saved2UnarchiveMenuItem = this.f9569a.f9570a.f9574d;
                        long j = d;
                        if (P.equals("ARCHIVED")) {
                            ((Saved2DbMutator) saved2UnarchiveMenuItem.f9578d.get()).e(j);
                        } else {
                            ((Saved2DbMutator) saved2UnarchiveMenuItem.f9578d.get()).d(j);
                        }
                    }

                    protected final void m9829a(Object obj) {
                        Saved2UnarchiveMenuItem saved2UnarchiveMenuItem = this.f9569a.f9570a.f9574d;
                        long j = d;
                        if (P.equals("ARCHIVED")) {
                            ((Saved2DbMutator) saved2UnarchiveMenuItem.f9578d.get()).g(j);
                        }
                    }
                }

                C14301(C14311 c14311) {
                    this.f9570a = c14311;
                }

                public void run() {
                    Saved2UnarchiveMenuItem saved2UnarchiveMenuItem = this.f9570a.f9574d;
                    ((UpdateSavedStateUtils) saved2UnarchiveMenuItem.f9575a.get()).b(w, CurationSurface.NATIVE_SAVED_DASHBOARD, saved2UnarchiveMenuItem.mo448c(), new C14291(this));
                }
            }

            public void run() {
                Saved2UnarchiveMenuItem saved2UnarchiveMenuItem = this.f9574d;
                long j = d;
                String str = P;
                if (str.equals("ARCHIVED")) {
                    ((Saved2DbMutator) saved2UnarchiveMenuItem.f9578d.get()).f(j);
                } else {
                    ((Saved2DbMutator) saved2UnarchiveMenuItem.f9578d.get()).a(j, str);
                }
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new C14301(this), -48752422);
            }
        }, -2133809325);
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.UNARCHIVE_BUTTON;
    }
}
