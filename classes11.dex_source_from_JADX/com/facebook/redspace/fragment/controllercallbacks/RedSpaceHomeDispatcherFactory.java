package com.facebook.redspace.fragment.controllercallbacks;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.redspace.badge.RedSpaceTabUnseenCountFetcher;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceBadgeController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceHomeViewMutatorController;
import com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceSelfProfileDataController;
import com.facebook.ultralight.Inject;

/* compiled from: PandoraAlbumPermalinkDetailsView is not integrated */
public class RedSpaceHomeDispatcherFactory {
    @Inject
    public RedSpaceBadgeController f12010a;
    @Inject
    public RedSpaceSelfProfileDataController f12011b;
    @Inject
    public RedSpaceHomeViewMutatorController f12012c;

    public static RedSpaceHomeDispatcherFactory m12467a(InjectorLike injectorLike) {
        RedSpaceHomeDispatcherFactory redSpaceHomeDispatcherFactory = new RedSpaceHomeDispatcherFactory();
        RedSpaceBadgeController redSpaceBadgeController = new RedSpaceBadgeController();
        RedSpaceTabUnseenCountFetcher a = RedSpaceTabUnseenCountFetcher.a(injectorLike);
        Lazy a2 = IdBasedLazy.a(injectorLike, 10167);
        Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 10162);
        redSpaceBadgeController.f12031a = a;
        redSpaceBadgeController.f12032b = a2;
        redSpaceBadgeController.f12033c = b;
        RedSpaceBadgeController redSpaceBadgeController2 = redSpaceBadgeController;
        RedSpaceSelfProfileDataController b2 = RedSpaceSelfProfileDataController.m12545b(injectorLike);
        RedSpaceHomeViewMutatorController redSpaceHomeViewMutatorController = new RedSpaceHomeViewMutatorController();
        Clock clock = (Clock) SystemClockMethodAutoProvider.a(injectorLike);
        String b3 = String_LoggedInUserIdMethodAutoProvider.b(injectorLike);
        redSpaceHomeViewMutatorController.f12076a = GraphQLQueryExecutor.a(injectorLike);
        redSpaceHomeViewMutatorController.f12077b = clock;
        redSpaceHomeViewMutatorController.f12078c = b3;
        RedSpaceHomeViewMutatorController redSpaceHomeViewMutatorController2 = redSpaceHomeViewMutatorController;
        redSpaceHomeDispatcherFactory.f12010a = redSpaceBadgeController2;
        redSpaceHomeDispatcherFactory.f12011b = b2;
        redSpaceHomeDispatcherFactory.f12012c = redSpaceHomeViewMutatorController2;
        return redSpaceHomeDispatcherFactory;
    }
}
