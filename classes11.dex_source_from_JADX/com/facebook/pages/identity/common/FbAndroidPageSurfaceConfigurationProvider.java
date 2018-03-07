package com.facebook.pages.identity.common;

import com.facebook.inject.InjectorLike;
import com.facebook.pages.identity.cards.actionbar.PagesActionBarSpecification;
import com.facebook.pages.identity.cards.childlocations.PageIdentityChildLocationsSpecification;
import com.facebook.pages.identity.cards.commerce.PageIdentityCommerceCardSpecification;
import com.facebook.pages.identity.cards.contextitems.PageIdentityContextItemsHeaderCardSpecification;
import com.facebook.pages.identity.cards.contextitems.PageIdentityContextItemsInfoCardSpecification;
import com.facebook.pages.identity.cards.criticreviews.PageIdentityCriticReviewsCardSpecification;
import com.facebook.pages.identity.cards.events.PageIdentityEventsCardSpecification;
import com.facebook.pages.identity.cards.nux.PageIdentityNuxCardSpecification;
import com.facebook.pages.identity.cards.photos.PageIdentityPhotosCardSpecification;
import com.facebook.pages.identity.cards.postsbyothers.PageIdentityPostsByOthersCardSpecification;
import com.facebook.pages.identity.cards.residence.PageIdentityHomeWelcomeCardSpecification;
import com.facebook.pages.identity.cards.reviews.PageIdentityReviewNeedyPlaceCardSpecification;
import com.facebook.pages.identity.cards.reviews.PageIdentityReviewsCardSpecification;
import com.facebook.pages.identity.cards.service.PageIdentityServiceCardSpecification;
import com.facebook.pages.identity.cards.vertexattribution.PageIdentityVertexAttributionCardSpecification;
import com.facebook.pages.identity.cards.videos.PageIdentityVideosCardSpecification;
import com.facebook.pages.identity.common.PageCardSpecifications.PageIdentityCardSpecification;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: places-with-fb-wifi() */
public class FbAndroidPageSurfaceConfigurationProvider {
    private static volatile FbAndroidPageSurfaceConfigurationProvider f3786b;
    public final ImmutableSet<PageIdentityCardSpecification> f3787a;

    public static com.facebook.pages.identity.common.FbAndroidPageSurfaceConfigurationProvider m4754a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f3786b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.identity.common.FbAndroidPageSurfaceConfigurationProvider.class;
        monitor-enter(r1);
        r0 = f3786b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m4755b(r0);	 Catch:{ all -> 0x0035 }
        f3786b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3786b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.identity.common.FbAndroidPageSurfaceConfigurationProvider.a(com.facebook.inject.InjectorLike):com.facebook.pages.identity.common.FbAndroidPageSurfaceConfigurationProvider");
    }

    private static FbAndroidPageSurfaceConfigurationProvider m4755b(InjectorLike injectorLike) {
        return new FbAndroidPageSurfaceConfigurationProvider(PagesActionBarSpecification.m4437a(injectorLike), PageIdentityNuxCardSpecification.m4567a(injectorLike), PageIdentityChildLocationsSpecification.m4460a(injectorLike), PageIdentityCriticReviewsCardSpecification.m4528a(injectorLike), PageIdentityReviewsCardSpecification.m4702a(injectorLike), PageIdentityReviewNeedyPlaceCardSpecification.m4691a(injectorLike), PageIdentityPhotosCardSpecification.m4627a(injectorLike), PageIdentityVideosCardSpecification.m4744a(injectorLike), PageIdentityEventsCardSpecification.m4549a(injectorLike), PageIdentityCommerceCardSpecification.m4469a(injectorLike), PageIdentityServiceCardSpecification.m4712a(injectorLike), PageIdentityPostsByOthersCardSpecification.m4656a(injectorLike), PageIdentityVertexAttributionCardSpecification.m4734a(injectorLike), PageIdentityContextItemsHeaderCardSpecification.m4497a(injectorLike), PageIdentityContextItemsInfoCardSpecification.m4506a(injectorLike), PageIdentityHomeWelcomeCardSpecification.m4676a(injectorLike));
    }

    @Inject
    public FbAndroidPageSurfaceConfigurationProvider(PagesActionBarSpecification pagesActionBarSpecification, PageIdentityNuxCardSpecification pageIdentityNuxCardSpecification, PageIdentityChildLocationsSpecification pageIdentityChildLocationsSpecification, PageIdentityCriticReviewsCardSpecification pageIdentityCriticReviewsCardSpecification, PageIdentityReviewsCardSpecification pageIdentityReviewsCardSpecification, PageIdentityReviewNeedyPlaceCardSpecification pageIdentityReviewNeedyPlaceCardSpecification, PageIdentityPhotosCardSpecification pageIdentityPhotosCardSpecification, PageIdentityVideosCardSpecification pageIdentityVideosCardSpecification, PageIdentityEventsCardSpecification pageIdentityEventsCardSpecification, PageIdentityCommerceCardSpecification pageIdentityCommerceCardSpecification, PageIdentityServiceCardSpecification pageIdentityServiceCardSpecification, PageIdentityPostsByOthersCardSpecification pageIdentityPostsByOthersCardSpecification, PageIdentityVertexAttributionCardSpecification pageIdentityVertexAttributionCardSpecification, PageIdentityContextItemsHeaderCardSpecification pageIdentityContextItemsHeaderCardSpecification, PageIdentityContextItemsInfoCardSpecification pageIdentityContextItemsInfoCardSpecification, PageIdentityHomeWelcomeCardSpecification pageIdentityHomeWelcomeCardSpecification) {
        this.f3787a = ImmutableSet.builder().c(pagesActionBarSpecification).c(pageIdentityNuxCardSpecification).c(pageIdentityChildLocationsSpecification).c(pageIdentityCriticReviewsCardSpecification).c(pageIdentityReviewsCardSpecification).c(pageIdentityReviewNeedyPlaceCardSpecification).c(pageIdentityPhotosCardSpecification).c(pageIdentityVideosCardSpecification).c(pageIdentityEventsCardSpecification).c(pageIdentityCommerceCardSpecification).c(pageIdentityServiceCardSpecification).c(pageIdentityPostsByOthersCardSpecification).c(pageIdentityVertexAttributionCardSpecification).c(pageIdentityContextItemsHeaderCardSpecification).c(pageIdentityContextItemsInfoCardSpecification).c(pageIdentityHomeWelcomeCardSpecification).b();
    }
}
