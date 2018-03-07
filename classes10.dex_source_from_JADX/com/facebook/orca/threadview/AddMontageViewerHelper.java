package com.facebook.orca.threadview;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.localfetch.FetchUserHandler;
import com.facebook.messaging.service.model.AddMontageViewerParams;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: multiway_call_thread_view_video_button */
public class AddMontageViewerHelper extends AbstractMontageViewerHelper {
    public static AddMontageViewerHelper m6458b(InjectorLike injectorLike) {
        return new AddMontageViewerHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), FetchUserHandler.a(injectorLike));
    }

    @Inject
    public AddMontageViewerHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, ListeningExecutorService listeningExecutorService, FetchUserHandler fetchUserHandler) {
        super(defaultBlueServiceOperationFactory, executorService, listeningExecutorService, fetchUserHandler);
    }

    final String mo239a() {
        return "add_montage_viewer";
    }

    final Bundle mo238a(String str, @Nullable User user) {
        AddMontageViewerParams addMontageViewerParams = new AddMontageViewerParams(str, user);
        Bundle bundle = new Bundle();
        bundle.putParcelable("addMontageViewerParams", addMontageViewerParams);
        return bundle;
    }

    final CallerContext mo240b() {
        return CallerContext.a(AddMontageViewerHelper.class);
    }

    @StringRes
    final int mo241c() {
        return 2131231837;
    }
}
