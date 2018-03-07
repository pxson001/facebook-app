package com.facebook.fbservice.ops;

import android.content.Context;
import android.os.Bundle;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.base.service.DefaultContextServiceBinder;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.process.DefaultProcessUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: unregisterPush */
public class DefaultBlueServiceOperationProvider extends AbstractAssistedProvider<DefaultBlueServiceOperation> {
    public final DefaultBlueServiceOperation m3808a(String str, Bundle bundle, ErrorPropagation errorPropagation, CallerContext callerContext, ViewerContextManager viewerContextManager) {
        return new DefaultBlueServiceOperation((Context) getInstance(Context.class), PackageManagerMethodAutoProvider.m2633a(this), IdBasedSingletonScopeProvider.m1810b(this, 1267), C0055x2995691a.m1881a(this), DefaultProcessUtil.m2387a(this), DefaultContextServiceBinder.m22161b(this), FbErrorReporterImpl.m2317a((InjectorLike) this), str, bundle, errorPropagation, callerContext, viewerContextManager, CriticalServiceExceptionChecker.m6535a((InjectorLike) this), CrossProcessFbBroadcastManager.m3644a((InjectorLike) this));
    }
}
