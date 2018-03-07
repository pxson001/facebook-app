package com.facebook.pages.common.resulthandlers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: saved_collection_ego_item_title_clicked */
public class CheckinHandler implements ActivityResultHandler {
    private final Context f2253a;
    private final Toaster f2254b;
    private final Resources f2255c;
    private final PagesAnalytics f2256d;
    private final ComposerPublishServiceHelper f2257e;
    private final ViewerContextManager f2258f;
    private long f2259g;

    @Inject
    public CheckinHandler(Context context, Toaster toaster, Resources resources, PagesAnalytics pagesAnalytics, ComposerPublishServiceHelper composerPublishServiceHelper, ViewerContextManager viewerContextManager) {
        this.f2253a = context;
        this.f2254b = toaster;
        this.f2255c = resources;
        this.f2256d = pagesAnalytics;
        this.f2257e = composerPublishServiceHelper;
        this.f2258f = viewerContextManager;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2259g = j;
        if (intent.getBooleanExtra("is_uploading_media", false)) {
            return Futures.a(OperationResult.a);
        }
        intent.putExtra("extra_actor_viewer_context", this.f2258f.a());
        return this.f2257e.c(intent);
    }

    public final void mo47a(OperationResult operationResult) {
        this.f2256d.a(NetworkSuccessEvent.EVENT_CHECKIN_SUCCESS, this.f2259g);
    }

    public final void mo48a(ServiceException serviceException) {
        this.f2256d.a(NetworkFailureEvent.EVENT_CHECKIN_ERROR, this.f2259g);
        this.f2254b.b(new ToastBuilder(2131235450));
    }

    public final DialogBasedProgressIndicator mo45a() {
        return new DialogBasedProgressIndicator(this.f2253a, this.f2255c.getString(2131235449));
    }

    public final boolean mo49b() {
        return true;
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(10100));
    }
}
