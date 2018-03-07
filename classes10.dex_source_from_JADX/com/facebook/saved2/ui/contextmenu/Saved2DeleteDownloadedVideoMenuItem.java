package com.facebook.saved2.ui.contextmenu;

import com.facebook.analytics.CurationMechanism;
import com.facebook.inject.Lazy;
import com.facebook.saved2.model.Saved2ItemTable_Queries.BaseQueryDAO;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.downloadmanager.DownloadManager;
import com.facebook.video.events.VideoDownloadStatus.DownloadStatus;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: instant_article_improved_scroll_perf */
public class Saved2DeleteDownloadedVideoMenuItem implements Saved2ContextMenuItem {
    public final DownloadManager f9539a;
    public final Lazy<Toaster> f9540b;
    private final Lazy<ExecutorService> f9541c;
    public DownloadStatus f9542d;

    /* compiled from: instant_article_improved_scroll_perf */
    class C14231 implements FutureCallback<Boolean> {
        final /* synthetic */ Saved2DeleteDownloadedVideoMenuItem f9538a;

        C14231(Saved2DeleteDownloadedVideoMenuItem saved2DeleteDownloadedVideoMenuItem) {
            this.f9538a = saved2DeleteDownloadedVideoMenuItem;
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        }

        public void onFailure(Throwable th) {
            ((Toaster) this.f9538a.f9540b.get()).b(new ToastBuilder(2131238163));
        }
    }

    @Inject
    public Saved2DeleteDownloadedVideoMenuItem(DownloadManager downloadManager, Lazy<Toaster> lazy, Lazy<ExecutorService> lazy2) {
        this.f9539a = downloadManager;
        this.f9540b = lazy;
        this.f9541c = lazy2;
    }

    public final int mo445a() {
        if (this.f9542d == DownloadStatus.DOWNLOAD_COMPLETED) {
            return 2131238182;
        }
        return 2131238186;
    }

    public final int mo446b() {
        return 2130839815;
    }

    public final boolean mo447b(BaseQueryDAO baseQueryDAO) {
        Futures.a(this.f9539a.b(baseQueryDAO.w()), new C14231(this), (Executor) this.f9541c.get());
        return true;
    }

    public final CurationMechanism mo448c() {
        return CurationMechanism.DELETE_BUTTON;
    }
}
