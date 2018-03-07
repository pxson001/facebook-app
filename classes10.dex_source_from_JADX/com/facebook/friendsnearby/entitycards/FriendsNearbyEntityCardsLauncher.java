package com.facebook.friendsnearby.entitycards;

import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.intent.EntityCardsLauncher;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel.Builder;
import com.facebook.friendsnearby.entitycards.model.SimpleUser;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: accelerometer_ */
public class FriendsNearbyEntityCardsLauncher {
    private static volatile FriendsNearbyEntityCardsLauncher f20451c;
    public final EntityCardsLauncher f20452a;
    private final EntityCardsIntentHelper f20453b;

    public static com.facebook.friendsnearby.entitycards.FriendsNearbyEntityCardsLauncher m20814a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20451c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.entitycards.FriendsNearbyEntityCardsLauncher.class;
        monitor-enter(r1);
        r0 = f20451c;	 Catch:{ all -> 0x003a }
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
        r0 = m20816b(r0);	 Catch:{ all -> 0x0035 }
        f20451c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20451c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.entitycards.FriendsNearbyEntityCardsLauncher.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.entitycards.FriendsNearbyEntityCardsLauncher");
    }

    private static FriendsNearbyEntityCardsLauncher m20816b(InjectorLike injectorLike) {
        return new FriendsNearbyEntityCardsLauncher(EntityCardsLauncher.a(injectorLike), EntityCardsIntentHelper.a(injectorLike));
    }

    @Inject
    public FriendsNearbyEntityCardsLauncher(EntityCardsLauncher entityCardsLauncher, EntityCardsIntentHelper entityCardsIntentHelper) {
        this.f20452a = entityCardsLauncher;
        this.f20453b = entityCardsIntentHelper;
    }

    public static PersonCardModel m20813a(SimpleUser simpleUser) {
        Builder builder = new Builder();
        builder.k = String.valueOf(simpleUser.f20455a);
        builder = builder;
        builder.o = simpleUser.f20456b;
        builder = builder;
        DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
        builder2.b = simpleUser.f20457c;
        builder.q = builder2.a();
        return builder.a();
    }

    public static ImmutableList<String> m20815a(ImmutableList<SimpleUser> immutableList) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(((SimpleUser) immutableList.get(i)).f20455a);
        }
        return builder.b();
    }
}
