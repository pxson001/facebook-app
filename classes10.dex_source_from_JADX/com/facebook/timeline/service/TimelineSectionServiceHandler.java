package com.facebook.timeline.service;

import android.os.Bundle;
import com.facebook.api.feed.DeleteStoryMethod;
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
import com.facebook.timeline.profileprotocol.HideTimelineStoryMethod;
import com.facebook.timeline.services.TimelineServiceHandler;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: extra_loader_type */
public class TimelineSectionServiceHandler extends TimelineServiceHandler {
    private final Provider<DeleteStoryMethod> f12727a;
    private final Provider<HideTimelineStoryMethod> f12728b;

    public static TimelineSectionServiceHandler m12679b(InjectorLike injectorLike) {
        return new TimelineSectionServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 4795), IdBasedProvider.a(injectorLike, 11310), IdBasedSingletonScopeProvider.a(injectorLike, 2289), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public TimelineSectionServiceHandler(Provider<DeleteStoryMethod> provider, Provider<HideTimelineStoryMethod> provider2, Provider<SingleMethodRunner> provider3, FbErrorReporter fbErrorReporter) {
        super(provider3, fbErrorReporter);
        this.f12727a = provider;
        this.f12728b = provider2;
    }

    public final OperationResult m12680a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        String str = operationParams.b;
        if ("timeline_delete_story".equals(str)) {
            return a(bundle, (ApiMethod) this.f12727a.get());
        }
        if ("timeline_hide_story".equals(str)) {
            return a(bundle, (ApiMethod) this.f12728b.get());
        }
        throw new ApiMethodNotFoundException(str);
    }
}
