package com.facebook.fbservice.ops;

import android.os.Bundle;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: unshown_stories_in_feed_adapter_tail_before_prune */
public class DefaultBlueServiceOperationFactory {
    private final ViewerContextManager f1874a;
    private final DefaultBlueServiceOperationProvider f1875b;

    public static DefaultBlueServiceOperationFactory m3782b(InjectorLike injectorLike) {
        return new DefaultBlueServiceOperationFactory(ViewerContextManagerProvider.m2496b(injectorLike), (DefaultBlueServiceOperationProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultBlueServiceOperationProvider.class));
    }

    public final /* synthetic */ BlueServiceOperationFactory$Operation m3786a(String str, Bundle bundle, ErrorPropagation errorPropagation, @Nullable CallerContext callerContext) {
        return m3781b(str, bundle, errorPropagation, callerContext);
    }

    @Inject
    public DefaultBlueServiceOperationFactory(ViewerContextManager viewerContextManager, DefaultBlueServiceOperationProvider defaultBlueServiceOperationProvider) {
        this.f1874a = viewerContextManager;
        this.f1875b = defaultBlueServiceOperationProvider;
    }

    public final BlueServiceOperationFactory$Operation m3783a(String str, Bundle bundle) {
        return m3781b(str, bundle, ErrorPropagation.BY_ERROR_CODE, null);
    }

    public static DefaultBlueServiceOperationFactory m3780a(InjectorLike injectorLike) {
        return m3782b(injectorLike);
    }

    public final BlueServiceOperationFactory$Operation m3784a(String str, Bundle bundle, @Nullable CallerContext callerContext) {
        return m3781b(str, bundle, ErrorPropagation.BY_ERROR_CODE, callerContext);
    }

    public final BlueServiceOperationFactory$Operation m3785a(String str, Bundle bundle, ErrorPropagation errorPropagation) {
        return m3781b(str, bundle, errorPropagation, null);
    }

    private DefaultBlueServiceOperation m3781b(String str, Bundle bundle, ErrorPropagation errorPropagation, @Nullable CallerContext callerContext) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotNull(errorPropagation);
        return this.f1875b.m3808a(str, bundle, errorPropagation, callerContext, this.f1874a);
    }
}
