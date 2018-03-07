package com.facebook.timeline.service;

import android.os.Bundle;
import com.facebook.analytics.cache.CacheTracker.Factory;
import com.facebook.api.growth.profile.SetProfilePhotoMethod;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.profilepiccoverphotoupload.SetCoverPhotoMethod;
import com.facebook.timeline.services.TimelineServiceHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_message_text */
public class TimelineHeaderServiceHandler extends TimelineServiceHandler {
    private final Provider<SetCoverPhotoMethod> f12712a;
    private final Provider<SetProfilePhotoMethod> f12713b;

    public static TimelineHeaderServiceHandler m12663b(InjectorLike injectorLike) {
        return new TimelineHeaderServiceHandler(IdBasedProvider.a(injectorLike, 11307), IdBasedSingletonScopeProvider.a(injectorLike, 4815), IdBasedSingletonScopeProvider.a(injectorLike, 2289), Factory.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public TimelineHeaderServiceHandler(Provider<SetCoverPhotoMethod> provider, Provider<SetProfilePhotoMethod> provider2, Provider<SingleMethodRunner> provider3, Factory factory, FbErrorReporter fbErrorReporter) {
        super(provider3, fbErrorReporter);
        this.f12712a = provider;
        this.f12713b = provider2;
    }

    public final OperationResult m12664a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        String str = operationParams.b;
        if ("timeline_set_cover_photo".equals(str)) {
            return a(bundle, (ApiMethod) this.f12712a.get(), "operationParams");
        }
        if ("timeline_set_profile_photo".equals(str)) {
            return a(bundle, (ApiMethod) this.f12713b.get(), "operationParams");
        }
        throw new ApiMethodNotFoundException(str);
    }
}
