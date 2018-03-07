package com.facebook.photos.creativecam.ui;

import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.local.LocalMediaCursorImp;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: started_loading_raw_time */
public class CreativeCamPickerPreviewControllerImpl implements CreativeCamPickerPreviewController {
    public static final Class<?> f2212a = CreativeCamPickerPreviewControllerImpl.class;
    public static final CallerContext f2213b = CallerContext.b(CreativeCamPickerPreviewControllerImpl.class, CreativeCamPickerPreviewControllerImpl.class.getSimpleName());
    private final TasksManager f2214c;
    public final LocalMediaCursorImp f2215d;
    @DefaultExecutorService
    public final ListeningExecutorService f2216e;

    /* compiled from: started_loading_raw_time */
    class C02611 implements Callable<ListenableFuture> {
        final /* synthetic */ CreativeCamPickerPreviewControllerImpl f2208a;

        C02611(CreativeCamPickerPreviewControllerImpl creativeCamPickerPreviewControllerImpl) {
            this.f2208a = creativeCamPickerPreviewControllerImpl;
        }

        public Object call() {
            CreativeCamPickerPreviewControllerImpl creativeCamPickerPreviewControllerImpl = this.f2208a;
            return creativeCamPickerPreviewControllerImpl.f2216e.a(new C02633(creativeCamPickerPreviewControllerImpl));
        }
    }

    /* compiled from: started_loading_raw_time */
    public class C02633 implements Callable<Uri> {
        final /* synthetic */ CreativeCamPickerPreviewControllerImpl f2211a;

        public C02633(CreativeCamPickerPreviewControllerImpl creativeCamPickerPreviewControllerImpl) {
            this.f2211a = creativeCamPickerPreviewControllerImpl;
        }

        public Object call() {
            List a = this.f2211a.f2215d.a(this.f2211a.f2215d.a(SupportedMediaType.PHOTO_ONLY, null), 1);
            if (a.isEmpty()) {
                return null;
            }
            return ((MediaItem) a.get(0)).f();
        }
    }

    @Inject
    public CreativeCamPickerPreviewControllerImpl(TasksManager tasksManager, LocalMediaCursorImp localMediaCursorImp, ListeningExecutorService listeningExecutorService) {
        this.f2214c = tasksManager;
        this.f2215d = localMediaCursorImp;
        this.f2216e = listeningExecutorService;
    }

    public final void m2379a(final FbDraweeView fbDraweeView, int i) {
        this.f2214c.a("picker_task_key", new C02611(this), new AbstractDisposableFutureCallback<Uri>(this) {
            final /* synthetic */ CreativeCamPickerPreviewControllerImpl f2210b;

            protected final void m2377a(Object obj) {
                Uri uri = (Uri) obj;
                if (uri == null) {
                    fbDraweeView.setVisibility(8);
                    Class cls = CreativeCamPickerPreviewControllerImpl.f2212a;
                }
                fbDraweeView.a(uri, CreativeCamPickerPreviewControllerImpl.f2213b);
            }

            protected final void m2378a(Throwable th) {
                BLog.b(CreativeCamPickerPreviewControllerImpl.f2212a, "failure getting picker button photo preview");
            }
        });
    }

    public final boolean m2380a(String str, int i) {
        return false;
    }
}
