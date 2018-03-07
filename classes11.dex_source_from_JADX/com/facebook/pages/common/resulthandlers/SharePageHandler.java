package com.facebook.pages.common.resulthandlers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.pages.common.logging.analytics.NetworkFailureEvent;
import com.facebook.pages.common.logging.analytics.NetworkSuccessEvent;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rtt_results */
public class SharePageHandler implements ActivityResultHandler {
    private final Context f2298a;
    private final Toaster f2299b;
    private final Resources f2300c;
    private final PagesAnalytics f2301d;
    private final ComposerPublishServiceHelper f2302e;
    private final AbstractFbErrorReporter f2303f;
    private long f2304g;

    public static SharePageHandler m3260b(InjectorLike injectorLike) {
        return new SharePageHandler((Context) injectorLike.getInstance(Context.class), Toaster.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), PagesAnalytics.a(injectorLike), ComposerPublishServiceHelper.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public SharePageHandler(Context context, Toaster toaster, Resources resources, PagesAnalytics pagesAnalytics, ComposerPublishServiceHelper composerPublishServiceHelper, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2298a = context;
        this.f2299b = toaster;
        this.f2300c = resources;
        this.f2301d = pagesAnalytics;
        this.f2302e = composerPublishServiceHelper;
        this.f2303f = abstractFbErrorReporter;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, Intent intent, int i) {
        this.f2304g = j;
        return this.f2302e.c(intent);
    }

    public final void mo47a(OperationResult operationResult) {
        this.f2299b.b(new ToastBuilder(2131235452));
        this.f2301d.a(NetworkSuccessEvent.EVENT_SHARE_PAGE_SUCCESS, this.f2304g);
    }

    public final void mo48a(ServiceException serviceException) {
        this.f2299b.b(new ToastBuilder(2131235453));
        this.f2301d.a(NetworkFailureEvent.EVENT_SHARE_PAGE_ERROR, this.f2304g);
        this.f2303f.a("page_identity_share_fail", serviceException);
    }

    public final DialogBasedProgressIndicator mo45a() {
        return new DialogBasedProgressIndicator(this.f2298a, this.f2300c.getString(2131235451));
    }

    public final boolean mo49b() {
        return false;
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(10101));
    }
}
