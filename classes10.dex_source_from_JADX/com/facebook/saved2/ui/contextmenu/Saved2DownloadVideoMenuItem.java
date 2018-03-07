package com.facebook.saved2.ui.contextmenu;

import android.net.Uri;
import com.facebook.analytics.CurationMechanism;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.downloadmanager.VideoDownloadRequest;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: install/?file={%s}&notes={%s}&appName={%s} */
public class Saved2DownloadVideoMenuItem implements Saved2ContextMenuItem {
    public final DownloadManager f9556a;
    public final Lazy<Toaster> f9557b;
    private final Lazy<ExecutorService> f9558c;
    public final QeAccessor f9559d;

    /* compiled from: install/?file={%s}&notes={%s}&appName={%s} */
    class C14271 implements FutureCallback<Boolean> {
        final /* synthetic */ Saved2DownloadVideoMenuItem f9555a;

        C14271(Saved2DownloadVideoMenuItem saved2DownloadVideoMenuItem) {
            this.f9555a = saved2DownloadVideoMenuItem;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            ((Toaster) this.f9555a.f9557b.get()).b(new ToastBuilder(2131238164));
        }
    }

    public static Saved2DownloadVideoMenuItem m9813b(InjectorLike injectorLike) {
        return new Saved2DownloadVideoMenuItem(DownloadManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3834));
    }

    @Inject
    public Saved2DownloadVideoMenuItem(DownloadManager downloadManager, QeAccessor qeAccessor, Lazy<Toaster> lazy, Lazy<ExecutorService> lazy2) {
        this.f9556a = downloadManager;
        this.f9559d = qeAccessor;
        this.f9557b = lazy;
        this.f9558c = lazy2;
    }

    public final int mo445a() {
        return 2131238183;
    }

    public final int mo446b() {
        return 2130839834;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        Futures.a(this.f9556a.a(new VideoDownloadRequest(Uri.parse(baseQueryDAO.u()), baseQueryDAO.w(), "", "saved dashboard", baseQueryDAO.Q())), new C14271(this), (Executor) this.f9558c.get());
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.VIDEO_DOWNLOAD_BUTTON;
    }
}
