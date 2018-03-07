package com.facebook.orca.threadview;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.messaging.localfetch.FetchUserHandler;
import com.facebook.orca.threadview.MontageStatusItemViewController.C10943;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;

/* compiled from: multiway_join_thread_view_video_button */
public abstract class AbstractMontageViewerHelper {
    public C10943 f6759a;
    public final DefaultBlueServiceOperationFactory f6760b;
    public final ExecutorService f6761c;
    private final ListeningExecutorService f6762d;
    private final FetchUserHandler f6763e;

    /* compiled from: multiway_join_thread_view_video_button */
    public class C10133 extends OperationResultFutureCallback {
        final /* synthetic */ UserKey f6757a;
        final /* synthetic */ AbstractMontageViewerHelper f6758b;

        public C10133(AbstractMontageViewerHelper abstractMontageViewerHelper, UserKey userKey) {
            this.f6758b = abstractMontageViewerHelper;
            this.f6757a = userKey;
        }

        protected final void m6436a(Object obj) {
            if (this.f6758b.f6759a != null) {
                C10943 c10943 = this.f6758b.f6759a;
                MontageStatusItemViewController.m6948a(c10943.f7282b, this.f6757a);
            }
        }

        protected final void m6435a(ServiceException serviceException) {
            if (this.f6758b.f6759a != null) {
                ((Toaster) this.f6758b.f6759a.f7282b.f7289f.get()).a(new ToastBuilder(2131240928, new Object[]{this.f6758b.f6759a.f7281a.e.j()}));
            }
        }
    }

    public abstract Bundle mo238a(String str, @Nullable User user);

    public abstract String mo239a();

    public abstract CallerContext mo240b();

    @StringRes
    public abstract int mo241c();

    public AbstractMontageViewerHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, ListeningExecutorService listeningExecutorService, FetchUserHandler fetchUserHandler) {
        this.f6760b = defaultBlueServiceOperationFactory;
        this.f6761c = executorService;
        this.f6762d = listeningExecutorService;
        this.f6763e = fetchUserHandler;
    }
}
