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
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: inline_terms_disagree_dialog */
public class Saved2PauseResumeDownloadVideoMenuItem implements Saved2ContextMenuItem {
    public final DownloadManager f9562a;
    public final Lazy<Toaster> f9563b;
    private final Lazy<ExecutorService> f9564c;
    public final QeAccessor f9565d;
    public DownloadStatus f9566e;

    public static Saved2PauseResumeDownloadVideoMenuItem m9818b(InjectorLike injectorLike) {
        return new Saved2PauseResumeDownloadVideoMenuItem(DownloadManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 3588), IdBasedSingletonScopeProvider.b(injectorLike, 3834));
    }

    @Inject
    public Saved2PauseResumeDownloadVideoMenuItem(DownloadManager downloadManager, QeAccessor qeAccessor, Lazy<Toaster> lazy, Lazy<ExecutorService> lazy2) {
        this.f9562a = downloadManager;
        this.f9565d = qeAccessor;
        this.f9563b = lazy;
        this.f9564c = lazy2;
    }

    public final int mo445a() {
        return this.f9566e == DownloadStatus.DOWNLOAD_PAUSED ? 2131238185 : 2131238184;
    }

    public final int mo446b() {
        return this.f9566e == DownloadStatus.DOWNLOAD_PAUSED ? 2130839834 : 2130840009;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        ListenableFuture a;
        int i;
        String w = baseQueryDAO.w();
        Uri parse = Uri.parse(baseQueryDAO.u());
        if (this.f9566e == DownloadStatus.DOWNLOAD_PAUSED) {
            a = this.f9562a.a(new VideoDownloadRequest(parse, w, "", "saved dashboard", baseQueryDAO.Q()));
            i = 2131238164;
        } else {
            i = 2131238165;
            a = this.f9562a.c(w);
        }
        Futures.a(a, new FutureCallback<Boolean>(this) {
            final /* synthetic */ Saved2PauseResumeDownloadVideoMenuItem f9561b;

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }

            public void onFailure(Throwable th) {
                ((Toaster) this.f9561b.f9563b.get()).b(new ToastBuilder(i));
            }
        }, (Executor) this.f9564c.get());
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.VIDEO_PAUSE_RESUME_DOWNLOAD_BUTTON;
    }
}
