package com.facebook.orca.threadview;

import android.os.Bundle;
import android.support.annotation.StringRes;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.localfetch.FetchUserHandler;
import com.facebook.messaging.service.model.RemoveMontageViewerParams;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: messages  */
public class RemoveMontageViewerHelper extends AbstractMontageViewerHelper {
    private static RemoveMontageViewerHelper m6998b(InjectorLike injectorLike) {
        return new RemoveMontageViewerHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), FetchUserHandler.a(injectorLike));
    }

    @Inject
    public RemoveMontageViewerHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService, ListeningExecutorService listeningExecutorService, FetchUserHandler fetchUserHandler) {
        super(defaultBlueServiceOperationFactory, executorService, listeningExecutorService, fetchUserHandler);
    }

    final String mo239a() {
        return "remove_montage_viewer";
    }

    final Bundle mo238a(String str, @Nullable User user) {
        RemoveMontageViewerParams removeMontageViewerParams = new RemoveMontageViewerParams(str, user);
        Bundle bundle = new Bundle();
        bundle.putParcelable("removeMontageViewerParams", removeMontageViewerParams);
        return bundle;
    }

    final CallerContext mo240b() {
        return CallerContext.a(RemoveMontageViewerHelper.class);
    }

    @StringRes
    final int mo241c() {
        return 2131231836;
    }
}
