package com.facebook.pages.common.resulthandlers;

import android.content.Intent;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rt */
public class SuggestEditsHandler implements ActivityResultHandler {
    private final Toaster f2318a;
    private final PagesAnalytics f2319b;

    @Inject
    public SuggestEditsHandler(Toaster toaster, PagesAnalytics pagesAnalytics) {
        this.f2318a = toaster;
        this.f2319b = pagesAnalytics;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2318a.b(new ToastBuilder(2131235448));
        this.f2319b.a(NetworkSuccessEvent.EVENT_SUGGEST_EDIT_SUCCESS, j);
        return null;
    }

    public final void mo47a(OperationResult operationResult) {
    }

    public final void mo48a(ServiceException serviceException) {
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(10102));
    }

    public final DialogBasedProgressIndicator mo45a() {
        return null;
    }

    public final boolean mo49b() {
        return false;
    }
}
