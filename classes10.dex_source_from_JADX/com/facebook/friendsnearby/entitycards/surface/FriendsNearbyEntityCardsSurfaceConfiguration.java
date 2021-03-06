package com.facebook.friendsnearby.entitycards.surface;

import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.loader.DefaultEntityCardsPageLoaderProvider;
import com.facebook.entitycards.model.EntityCardsCardSupportDeclaration;
import com.facebook.entitycards.model.STATICDI_MULTIBIND_PROVIDER.EntityCardsCardSupportDeclaration__com_facebook_friendsnearby_entitycards_annotations_FriendsNearbyEntityCards;
import com.facebook.entitycards.surface.EntityCardsSurfaceConfigurationHelper;
import com.facebook.entitycardsplugins.person.PersonCardActivityResultHandler;
import com.facebook.entitycardsplugins.person.loader.DefaultPersonCardsLoaderProvider;
import com.facebook.entitycardsplugins.person.surface.BasePersonCardsSurfaceConfiguration;
import com.facebook.entitycardsplugins.person.view.PersonCardViewHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderLazy;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: a79811a2b247f11f9c3f43a988588503 */
public class FriendsNearbyEntityCardsSurfaceConfiguration extends BasePersonCardsSurfaceConfiguration {
    private static volatile FriendsNearbyEntityCardsSurfaceConfiguration f20458e;
    private final Lazy<Set<EntityCardsCardSupportDeclaration>> f20459d;

    public static com.facebook.friendsnearby.entitycards.surface.FriendsNearbyEntityCardsSurfaceConfiguration m20817a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20458e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.entitycards.surface.FriendsNearbyEntityCardsSurfaceConfiguration.class;
        monitor-enter(r1);
        r0 = f20458e;	 Catch:{ all -> 0x003a }
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
        r0 = m20818b(r0);	 Catch:{ all -> 0x0035 }
        f20458e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20458e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.entitycards.surface.FriendsNearbyEntityCardsSurfaceConfiguration.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.entitycards.surface.FriendsNearbyEntityCardsSurfaceConfiguration");
    }

    private static FriendsNearbyEntityCardsSurfaceConfiguration m20818b(InjectorLike injectorLike) {
        return new FriendsNearbyEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper.b(injectorLike), EntityCardsIntentHelper.a(injectorLike), ProviderLazy.a(new EntityCardsCardSupportDeclaration__com_facebook_friendsnearby_entitycards_annotations_FriendsNearbyEntityCards(injectorLike.getScopeAwareInjector()), injectorLike.getScopeAwareInjector()), (DefaultPersonCardsLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultPersonCardsLoaderProvider.class), (DefaultEntityCardsPageLoaderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(DefaultEntityCardsPageLoaderProvider.class), IdBasedProvider.a(injectorLike, 5523), PersonCardViewHelper.a(injectorLike));
    }

    @Inject
    public FriendsNearbyEntityCardsSurfaceConfiguration(EntityCardsSurfaceConfigurationHelper entityCardsSurfaceConfigurationHelper, EntityCardsIntentHelper entityCardsIntentHelper, Lazy<Set<EntityCardsCardSupportDeclaration>> lazy, DefaultPersonCardsLoaderProvider defaultPersonCardsLoaderProvider, DefaultEntityCardsPageLoaderProvider defaultEntityCardsPageLoaderProvider, Provider<PersonCardActivityResultHandler> provider, PersonCardViewHelper personCardViewHelper) {
        super(entityCardsSurfaceConfigurationHelper, provider, personCardViewHelper, entityCardsIntentHelper, defaultPersonCardsLoaderProvider, defaultEntityCardsPageLoaderProvider);
        this.f20459d = lazy;
    }

    public final String m20819a() {
        return "friends_nearby";
    }

    public final Set<EntityCardsCardSupportDeclaration> m20820b() {
        return (Set) this.f20459d.get();
    }
}
