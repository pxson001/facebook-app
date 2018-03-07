package com.facebook.timeline.entitycards;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.intent.EntityCardsIntentHelper.EntityRange;
import com.facebook.entitycards.loader.AvailableIdsLoader;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoaderProvider;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.STATICDI_MULTIBIND_PROVIDER.EntityCardsCardSupportDeclaration__com_facebook_timeline_entitycards_TimelineEntityCards;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.entitycards.surface.EntityCardsSurfaceConfigurationHelper;
import com.facebook.entitycardsplugins.person.PersonCardActivityResultHandler;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoaderProvider;
import com.facebook.entitycardsplugins.person.surface.BasePersonCardsSurfaceConfiguration;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: geofence_api_request_failed */
public class TimelineEntityCardsSurfaceConfiguration extends BasePersonCardsSurfaceConfiguration {
    private static volatile TimelineEntityCardsSurfaceConfiguration f10981f;
    private final Lazy<Set<EntityCardsCardSupportDeclaration>> f10982d;
    private final TimelineIdsForPageLoaderProvider f10983e;

    public static com.facebook.timeline.entitycards.TimelineEntityCardsSurfaceConfiguration m11095a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f10981f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.entitycards.TimelineEntityCardsSurfaceConfiguration.class;
        monitor-enter(r1);
        r0 = f10981f;	 Catch:{ all -> 0x003a }
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
        r0 = m11096b(r0);	 Catch:{ all -> 0x0035 }
        f10981f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10981f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.entitycards.TimelineEntityCardsSurfaceConfiguration.a(com.facebook.inject.InjectorLike):com.facebook.timeline.entitycards.TimelineEntityCardsSurfaceConfiguration");
    }

    private static TimelineEntityCardsSurfaceConfiguration m11096b(InjectorLike injectorLike) {
        return new TimelineEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper.b(injectorLike), ProviderLazy.a(new EntityCardsCardSupportDeclaration__com_facebook_timeline_entitycards_TimelineEntityCards(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), IdBasedProvider.a(injectorLike, 5523), PersonCardViewHelper.a(injectorLike), EntityCardsIntentHelper.a(injectorLike), (DefaultPersonCardsLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultPersonCardsLoaderProvider.class), (DefaultEntityCardsPageLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultEntityCardsPageLoaderProvider.class), (TimelineIdsForPageLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TimelineIdsForPageLoaderProvider.class));
    }

    @Inject
    protected TimelineEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper entityCardsSurfaceConfigurationHelper, Lazy<Set<EntityCardsCardSupportDeclaration>> lazy, Provider<PersonCardActivityResultHandler> provider, PersonCardViewHelper personCardViewHelper, EntityCardsIntentHelper entityCardsIntentHelper, DefaultPersonCardsLoaderProvider defaultPersonCardsLoaderProvider, DefaultEntityCardsPageLoaderProvider defaultEntityCardsPageLoaderProvider, TimelineIdsForPageLoaderProvider timelineIdsForPageLoaderProvider) {
        super(entityCardsSurfaceConfigurationHelper, provider, personCardViewHelper, entityCardsIntentHelper, defaultPersonCardsLoaderProvider, defaultEntityCardsPageLoaderProvider);
        this.f10982d = lazy;
        this.f10983e = timelineIdsForPageLoaderProvider;
    }

    public final String m11098a() {
        return "timeline";
    }

    public final Set<EntityCardsCardSupportDeclaration> m11099b() {
        return (Set) this.f10982d.get();
    }

    protected final EntityCardsIdsForPageLoader m11097a(EntityRange entityRange, CallerContext callerContext, @Nullable Bundle bundle) {
        AvailableIdsLoader availableIdsLoader = new AvailableIdsLoader(entityRange);
        if (bundle == null) {
            return availableIdsLoader;
        }
        return new TimelineIdsForPageLoader(availableIdsLoader, callerContext, bundle, IdBasedSingletonScopeProvider.a(this.f10983e, 3834));
    }
}
