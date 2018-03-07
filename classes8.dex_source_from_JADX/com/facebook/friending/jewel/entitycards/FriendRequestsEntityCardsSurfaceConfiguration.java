package com.facebook.friending.jewel.entitycards;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.intent.EntityCardsIntentHelper.EntityRange;
import com.facebook.entitycards.loader.AvailableIdsLoader;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoaderProvider;
import com.facebook.entitycards.model.C1193x9f720faf;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.entitycards.surface.EntityCardsSurfaceConfigurationHelper;
import com.facebook.entitycardsplugins.person.PersonCardActivityResultHandler;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoaderProvider;
import com.facebook.entitycardsplugins.person.surface.BasePersonCardsSurfaceConfiguration;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.friending.jewel.entitycards.loader.FriendRequestsIdsPageLoader;
import com.facebook.friending.jewel.entitycards.loader.FriendRequestsIdsPageLoaderProvider;
import com.facebook.friends.FriendingQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: filter_value */
public class FriendRequestsEntityCardsSurfaceConfiguration extends BasePersonCardsSurfaceConfiguration {
    private static volatile FriendRequestsEntityCardsSurfaceConfiguration f13312f;
    private final Lazy<Set<EntityCardsCardSupportDeclaration>> f13313d;
    private final FriendRequestsIdsPageLoaderProvider f13314e;

    public static com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsSurfaceConfiguration m14960a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13312f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsSurfaceConfiguration.class;
        monitor-enter(r1);
        r0 = f13312f;	 Catch:{ all -> 0x003a }
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
        r0 = m14961b(r0);	 Catch:{ all -> 0x0035 }
        f13312f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13312f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsSurfaceConfiguration.a(com.facebook.inject.InjectorLike):com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsSurfaceConfiguration");
    }

    private static FriendRequestsEntityCardsSurfaceConfiguration m14961b(InjectorLike injectorLike) {
        return new FriendRequestsEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper.m13024b(injectorLike), EntityCardsIntentHelper.m12923a(injectorLike), ProviderLazy.a(new C1193x9f720faf(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), (FriendRequestsIdsPageLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendRequestsIdsPageLoaderProvider.class), (DefaultPersonCardsLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultPersonCardsLoaderProvider.class), (DefaultEntityCardsPageLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultEntityCardsPageLoaderProvider.class), IdBasedProvider.a(injectorLike, 5523), PersonCardViewHelper.m13239a(injectorLike));
    }

    @Inject
    public FriendRequestsEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper entityCardsSurfaceConfigurationHelper, EntityCardsIntentHelper entityCardsIntentHelper, Lazy<Set<EntityCardsCardSupportDeclaration>> lazy, FriendRequestsIdsPageLoaderProvider friendRequestsIdsPageLoaderProvider, DefaultPersonCardsLoaderProvider defaultPersonCardsLoaderProvider, DefaultEntityCardsPageLoaderProvider defaultEntityCardsPageLoaderProvider, Provider<PersonCardActivityResultHandler> provider, PersonCardViewHelper personCardViewHelper) {
        super(entityCardsSurfaceConfigurationHelper, provider, personCardViewHelper, entityCardsIntentHelper, defaultPersonCardsLoaderProvider, defaultEntityCardsPageLoaderProvider);
        this.f13313d = lazy;
        this.f13314e = friendRequestsIdsPageLoaderProvider;
    }

    public final String mo833a() {
        return "friending";
    }

    public final Set<EntityCardsCardSupportDeclaration> mo834b() {
        return (Set) this.f13313d.get();
    }

    protected final EntityCardsIdsForPageLoader mo832a(EntityRange entityRange, CallerContext callerContext, @Nullable Bundle bundle) {
        AvailableIdsLoader availableIdsLoader = new AvailableIdsLoader(entityRange.f10984a, entityRange.f10987d, entityRange.f10988e);
        FriendRequestsIdsPageLoaderProvider friendRequestsIdsPageLoaderProvider = this.f13314e;
        return new FriendRequestsIdsPageLoader(FriendingQueryExecutor.a(friendRequestsIdsPageLoaderProvider), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(friendRequestsIdsPageLoaderProvider), availableIdsLoader, callerContext, bundle);
    }
}
