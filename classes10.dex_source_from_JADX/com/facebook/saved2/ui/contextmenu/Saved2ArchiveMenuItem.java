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
import com.facebook.video.downloadmanager.DownloadManager;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: instant_articles_base_view_init */
public class Saved2ArchiveMenuItem implements Saved2ContextMenuItem {
    public final Lazy<DownloadManager> f9520a;
    public final Lazy<UpdateSavedStateUtils> f9521b;
    public final Lazy<Toaster> f9522c;
    private final Lazy<ExecutorService> f9523d;
    public final Lazy<Saved2DbMutator> f9524e;

    public static Saved2ArchiveMenuItem m9793b(InjectorLike injectorLike) {
        return new Saved2ArchiveMenuItem(IdBasedSingletonScopeProvider.b(injectorLike, 11622), IdBasedSingletonScopeProvider.b(injectorLike, 10402), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 10450));
    }

    @Inject
    public Saved2ArchiveMenuItem(Lazy<DownloadManager> lazy, Lazy<UpdateSavedStateUtils> lazy2, Lazy<Toaster> lazy3, Lazy<ExecutorService> lazy4, Lazy<Saved2DbMutator> lazy5) {
        this.f9520a = lazy;
        this.f9521b = lazy2;
        this.f9522c = lazy3;
        this.f9523d = lazy4;
        this.f9524e = lazy5;
    }

    public final int mo445a() {
        return 2131238178;
    }

    public final int mo446b() {
        return 2130839721;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        final long d = baseQueryDAO.d();
        final String w = baseQueryDAO.w();
        final String P = baseQueryDAO.P();
        final boolean t = baseQueryDAO.t();
        ExecutorDetour.a((ExecutorService) this.f9523d.get(), new Runnable(this) {
            final /* synthetic */ Saved2ArchiveMenuItem f9519e;

            /* compiled from: instant_articles_base_view_init */
            class C14211 implements Runnable {
                final /* synthetic */ C14221 f9514a;

                /* compiled from: instant_articles_base_view_init */
                class C14201 extends OperationResultFutureCallback {
                    final /* synthetic */ C14211 f9513a;

                    C14201(C14211 c14211) {
                        this.f9513a = c14211;
                    }

                    protected final void m9787a(ServiceException serviceException) {
                        ((Toaster) this.f9513a.f9514a.f9519e.f9522c.get()).b(new ToastBuilder(2131238160));
                        Saved2ArchiveMenuItem saved2ArchiveMenuItem = this.f9513a.f9514a.f9519e;
                        ((Saved2DbMutator) saved2ArchiveMenuItem.f9524e.get()).a(d, P);
                    }

                    protected final void m9788a(Object obj) {
                        if (t) {
                            ((DownloadManager) this.f9513a.f9514a.f9519e.f9520a.get()).b(w);
                        }
                    }
                }

                C14211(C14221 c14221) {
                    this.f9514a = c14221;
                }

                public void run() {
                    Saved2ArchiveMenuItem saved2ArchiveMenuItem = this.f9514a.f9519e;
                    ((UpdateSavedStateUtils) saved2ArchiveMenuItem.f9521b.get()).a(w, CurationSurface.NATIVE_SAVED_DASHBOARD, saved2ArchiveMenuItem.mo448c(), new C14201(this));
                }
            }

            public void run() {
                Saved2ArchiveMenuItem saved2ArchiveMenuItem = this.f9519e;
                ((Saved2DbMutator) saved2ArchiveMenuItem.f9524e.get()).d(d);
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new C14211(this), -706897328);
            }
        }, -844227630);
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.ARCHIVE_BUTTON;
    }
}
