package com.facebook.pages.identity.batching;

import com.facebook.inject.InjectorLike;
import com.facebook.pages.identity.cards.childlocations.PageIdentityChildLocationsSpecification;
import com.facebook.pages.identity.cards.commerce.PageIdentityCommerceCardSpecification;
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
import com.facebook.pages.identity.common.PageCardSpecifications.PageBatchFetchingCardSpecification;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: privacy_review_experiences */
public class FbAndroidBatchedCardsProvider {
    private static volatile FbAndroidBatchedCardsProvider f3145b;
    public final ImmutableList<PageBatchFetchingCardSpecification> f3146a;

    public static com.facebook.pages.identity.batching.FbAndroidBatchedCardsProvider m4234a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3145b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.identity.batching.FbAndroidBatchedCardsProvider.class;
        monitor-enter(r1);
        r0 = f3145b;	 Catch:{ all -> 0x003a }
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
        r0 = m4235b(r0);	 Catch:{ all -> 0x0035 }
        f3145b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3145b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.identity.batching.FbAndroidBatchedCardsProvider.a(com.facebook.inject.InjectorLike):com.facebook.pages.identity.batching.FbAndroidBatchedCardsProvider");
    }

    private static FbAndroidBatchedCardsProvider m4235b(InjectorLike injectorLike) {
        return new FbAndroidBatchedCardsProvider(PageIdentityContextItemsInfoCardSpecification.m4507b(injectorLike), PageIdentityNuxCardSpecification.m4568b(injectorLike), PageIdentityChildLocationsSpecification.m4461b(injectorLike), PageIdentityCriticReviewsCardSpecification.m4529b(injectorLike), PageIdentityReviewsCardSpecification.m4703b(injectorLike), PageIdentityReviewNeedyPlaceCardSpecification.m4692b(injectorLike), PageIdentityVideosCardSpecification.m4745b(injectorLike), PageIdentityPhotosCardSpecification.m4628b(injectorLike), PageIdentityCommerceCardSpecification.m4470b(injectorLike), PageIdentityServiceCardSpecification.m4713b(injectorLike), PageIdentityEventsCardSpecification.m4552b(injectorLike), PageIdentityHomeWelcomeCardSpecification.m4676a(injectorLike), PageIdentityPostsByOthersCardSpecification.m4657b(injectorLike), PageIdentityVertexAttributionCardSpecification.m4736b(injectorLike));
    }

    @Inject
    public FbAndroidBatchedCardsProvider(PageIdentityContextItemsInfoCardSpecification pageIdentityContextItemsInfoCardSpecification, PageIdentityNuxCardSpecification pageIdentityNuxCardSpecification, PageIdentityChildLocationsSpecification pageIdentityChildLocationsSpecification, PageIdentityCriticReviewsCardSpecification pageIdentityCriticReviewsCardSpecification, PageIdentityReviewsCardSpecification pageIdentityReviewsCardSpecification, PageIdentityReviewNeedyPlaceCardSpecification pageIdentityReviewNeedyPlaceCardSpecification, PageIdentityVideosCardSpecification pageIdentityVideosCardSpecification, PageIdentityPhotosCardSpecification pageIdentityPhotosCardSpecification, PageIdentityCommerceCardSpecification pageIdentityCommerceCardSpecification, PageIdentityServiceCardSpecification pageIdentityServiceCardSpecification, PageIdentityEventsCardSpecification pageIdentityEventsCardSpecification, PageIdentityHomeWelcomeCardSpecification pageIdentityHomeWelcomeCardSpecification, PageIdentityPostsByOthersCardSpecification pageIdentityPostsByOthersCardSpecification, PageIdentityVertexAttributionCardSpecification pageIdentityVertexAttributionCardSpecification) {
        this.f3146a = ImmutableList.builder().c(pageIdentityContextItemsInfoCardSpecification).c(pageIdentityNuxCardSpecification).c(pageIdentityChildLocationsSpecification).c(pageIdentityCriticReviewsCardSpecification).c(pageIdentityReviewsCardSpecification).c(pageIdentityReviewNeedyPlaceCardSpecification).c(pageIdentityVideosCardSpecification).c(pageIdentityPhotosCardSpecification).c(pageIdentityServiceCardSpecification).c(pageIdentityEventsCardSpecification).c(pageIdentityCommerceCardSpecification).c(pageIdentityHomeWelcomeCardSpecification).c(pageIdentityPostsByOthersCardSpecification).c(pageIdentityVertexAttributionCardSpecification).b();
    }
}
