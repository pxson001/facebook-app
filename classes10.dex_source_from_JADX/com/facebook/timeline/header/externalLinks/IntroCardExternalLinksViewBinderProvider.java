package com.facebook.timeline.header.externalLinks;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.delegate.ProfileControllerDelegate;

/* compiled from: file_attachment_urls[] */
public class IntroCardExternalLinksViewBinderProvider extends AbstractAssistedProvider<IntroCardExternalLinksViewBinder> {
    public final IntroCardExternalLinksViewBinder m11784a(TimelineContext timelineContext) {
        return new IntroCardExternalLinksViewBinder(IdBasedProvider.a(this, 11268), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), ProfileControllerDelegate.m10751a((InjectorLike) this), IdBasedSingletonScopeProvider.a(this, 616), IdBasedProvider.a(this, 11293), timelineContext);
    }
}
