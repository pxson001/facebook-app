package com.facebook.saved2.ui.contextmenu;

import android.os.Handler;
import android.os.Looper;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLSavedState;
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

/* compiled from: installer_package */
public class Saved2DeleteMenuItem implements Saved2ContextMenuItem {
    public final Lazy<DownloadManager> f9550a;
    public final Lazy<UpdateSavedStateUtils> f9551b;
    public final Lazy<Toaster> f9552c;
    private final Lazy<ExecutorService> f9553d;
    public final Lazy<Saved2DbMutator> f9554e;

    public static Saved2DeleteMenuItem m9808b(InjectorLike injectorLike) {
        return new Saved2DeleteMenuItem(IdBasedSingletonScopeProvider.b(injectorLike, 11622), IdBasedSingletonScopeProvider.b(injectorLike, 10402), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedLazy.a(injectorLike, 10450));
    }

    @Inject
    public Saved2DeleteMenuItem(Lazy<DownloadManager> lazy, Lazy<UpdateSavedStateUtils> lazy2, Lazy<Toaster> lazy3, Lazy<ExecutorService> lazy4, Lazy<Saved2DbMutator> lazy5) {
        this.f9550a = lazy;
        this.f9551b = lazy2;
        this.f9552c = lazy3;
        this.f9553d = lazy4;
        this.f9554e = lazy5;
    }

    public final int mo445a() {
        return 2131238190;
    }

    public final int mo446b() {
        return 2130839815;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        final long d = baseQueryDAO.d();
        final String m = baseQueryDAO.m();
        final String w = baseQueryDAO.w();
        final boolean t = baseQueryDAO.t();
        ExecutorDetour.a((ExecutorService) this.f9553d.get(), new Runnable(this) {
            final /* synthetic */ Saved2DeleteMenuItem f9549e;

            /* compiled from: installer_package */
            class C14251 implements Runnable {
                final /* synthetic */ C14261 f9544a;

                /* compiled from: installer_package */
                class C14241 extends OperationResultFutureCallback {
                    final /* synthetic */ C14251 f9543a;

                    C14241(C14251 c14251) {
                        this.f9543a = c14251;
                    }

                    protected final void m9806a(ServiceException serviceException) {
                        ((Toaster) this.f9543a.f9544a.f9549e.f9552c.get()).b(new ToastBuilder(2131238162));
                        Saved2DeleteMenuItem saved2DeleteMenuItem = this.f9543a.f9544a.f9549e;
                        ((Saved2DbMutator) saved2DeleteMenuItem.f9554e.get()).c(d);
                    }

                    protected final void m9807a(Object obj) {
                        Saved2DeleteMenuItem saved2DeleteMenuItem = this.f9543a.f9544a.f9549e;
                        ((Saved2DbMutator) saved2DeleteMenuItem.f9554e.get()).b(d);
                        if (t) {
                            ((DownloadManager) this.f9543a.f9544a.f9549e.f9550a.get()).b(w);
                        }
                    }
                }

                C14251(C14261 c14261) {
                    this.f9544a = c14261;
                }

                public void run() {
                    Saved2DeleteMenuItem saved2DeleteMenuItem = this.f9544a.f9549e;
                    String str = m;
                    String str2 = w;
                    C14241 c14241 = new C14241(this);
                    if (GraphQLSavedState.ARCHIVED.toString().equals(str)) {
                        ((UpdateSavedStateUtils) saved2DeleteMenuItem.f9551b.get()).d(str2, CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.DELETE_BUTTON, c14241);
                    } else {
                        ((UpdateSavedStateUtils) saved2DeleteMenuItem.f9551b.get()).c(str2, CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.DELETE_BUTTON, c14241);
                    }
                }
            }

            public void run() {
                Saved2DeleteMenuItem saved2DeleteMenuItem = this.f9549e;
                ((Saved2DbMutator) saved2DeleteMenuItem.f9554e.get()).a(d);
                HandlerDetour.a(new Handler(Looper.getMainLooper()), new C14251(this), 832069873);
            }
        }, -1250194274);
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.DELETE_BUTTON;
    }
}
