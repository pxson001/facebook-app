package com.facebook.pages.common.resulthandlers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.config.application.Product;
import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.pages.ProfilePermissions;
import com.facebook.ipc.pages.ProfilePermissions.Permission;
import com.facebook.pages.common.abtest.qe.PagesExperimentUtils;
import com.facebook.pages.common.eventbus.PageEventBus;
import com.facebook.pages.common.eventbus.PageEvents.PagesActivityDataChangeEvent;
import com.facebook.pages.common.resulthandlers.interfaces.ActivityResultHandler;
import com.facebook.pages.common.viewercontextutils.ViewerContextUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionSessionManager;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rthday_card */
public class StructuredComposerHandler implements ActivityResultHandler {
    public final Lazy<ComposerPublishServiceHelper> f2307a;
    private final Lazy<Toaster> f2308b;
    private final Lazy<ViewerContextUtil> f2309c;
    public final Lazy<ReactionSessionManager> f2310d;
    private final PagesExperimentUtils f2311e;
    private final PageEventBus f2312f;
    private final Product f2313g;
    private final Context f2314h;
    private final Resources f2315i;
    private boolean f2316j = false;
    private boolean f2317k = false;

    public static StructuredComposerHandler m3269b(InjectorLike injectorLike) {
        return new StructuredComposerHandler(IdBasedLazy.a(injectorLike, 5272), IdBasedLazy.a(injectorLike, 3588), IdBasedLazy.a(injectorLike, 9011), IdBasedSingletonScopeProvider.b(injectorLike, 9836), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), PageEventBus.m2423a(injectorLike), ProductMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), PagesExperimentUtils.a(injectorLike));
    }

    @Inject
    public StructuredComposerHandler(Lazy<ComposerPublishServiceHelper> lazy, Lazy<Toaster> lazy2, Lazy<ViewerContextUtil> lazy3, Lazy<ReactionSessionManager> lazy4, QeAccessor qeAccessor, PageEventBus pageEventBus, Product product, Context context, Resources resources, PagesExperimentUtils pagesExperimentUtils) {
        this.f2307a = lazy;
        this.f2308b = lazy2;
        this.f2309c = lazy3;
        this.f2310d = lazy4;
        this.f2311e = pagesExperimentUtils;
        this.f2312f = pageEventBus;
        this.f2313g = product;
        this.f2314h = context;
        this.f2315i = resources;
    }

    public final ListenableFuture<OperationResult> mo46a(long j, @Nullable ProfilePermissions profilePermissions, FbFragment fbFragment, final Intent intent, int i) {
        boolean z = false;
        if (intent.getBooleanExtra("is_uploading_media", false)) {
            ((ComposerPublishServiceHelper) this.f2307a.get()).c(intent);
            ((Toaster) this.f2308b.get()).b(new ToastBuilder(2131234552));
            return Futures.a(OperationResult.a);
        }
        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        if (publishPostParams.publishMode == PublishMode.SCHEDULE_POST || publishPostParams.publishMode == PublishMode.SAVE_DRAFT) {
            z = true;
        }
        this.f2316j = z;
        if (profilePermissions == null || !profilePermissions.a(Permission.CREATE_CONTENT)) {
            return ((ComposerPublishServiceHelper) this.f2307a.get()).c(intent);
        }
        if (!(publishPostParams == null || publishPostParams.publishMode != PublishMode.NORMAL || publishPostParams.composerType == ComposerType.SHARE)) {
            this.f2317k = true;
        }
        ((ReactionSessionManager) this.f2310d.get()).b(((PublishPostParams) intent.getParcelableExtra("publishPostParams")).composerSessionId, fbFragment);
        return Futures.b(((ViewerContextUtil) this.f2309c.get()).a(String.valueOf(j)), new AsyncFunction<ViewerContext, OperationResult>(this) {
            final /* synthetic */ StructuredComposerHandler f2306b;

            public final ListenableFuture m3268a(Object obj) {
                intent.putExtra("extra_actor_viewer_context", (ViewerContext) obj);
                return ((ComposerPublishServiceHelper) this.f2306b.f2307a.get()).c(intent);
            }
        }, MoreExecutors.a());
    }

    public final void mo47a(OperationResult operationResult) {
        if (this.f2316j) {
            this.f2312f.a(new PagesActivityDataChangeEvent());
        }
    }

    public final void mo48a(ServiceException serviceException) {
        ((Toaster) this.f2308b.get()).b(new ToastBuilder(2131234530));
    }

    public final boolean mo50c() {
        return true;
    }

    public final ImmutableList<Integer> mo51d() {
        return ImmutableList.of(Integer.valueOf(1756), Integer.valueOf(UnitInteractionType.WRITE_POST_TO_PAGE_TAP.ordinal()), Integer.valueOf(UnitInteractionType.SHARE_PHOTO_TO_PAGE_TAP.ordinal()));
    }

    public final DialogBasedProgressIndicator mo45a() {
        return new DialogBasedProgressIndicator(this.f2314h, this.f2315i.getString(2131234541));
    }

    public final boolean mo49b() {
        return this.f2317k && (this.f2313g.equals(Product.PAA) || this.f2311e.e());
    }
}
