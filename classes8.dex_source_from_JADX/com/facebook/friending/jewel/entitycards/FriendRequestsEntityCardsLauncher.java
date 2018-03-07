package com.facebook.friending.jewel.entitycards;

import android.app.Activity;
import android.os.Bundle;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.intent.EntityCardsIntentHelper;
import com.facebook.entitycards.intent.EntityCardsIntentHelper.EntityRange;
import com.facebook.entitycards.intent.EntityCardsLauncher;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel;
import com.facebook.entitycardsplugins.person.protocol.PersonCardGraphQLModels.PersonCardModel.Builder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.friending.jewel.FriendingPossibilitiesList;
import com.facebook.friending.jewel.entitycards.loader.FriendRequestsIdsPageLoader;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.FriendRequestState;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: filter_value_group_name */
public class FriendRequestsEntityCardsLauncher {
    private static volatile FriendRequestsEntityCardsLauncher f13309c;
    private final EntityCardsLauncher f13310a;
    private final EntityCardsIntentHelper f13311b;

    /* compiled from: filter_value_group_name */
    /* synthetic */ class C14081 {
        static final /* synthetic */ int[] f13308a = new int[FriendRequestState.values().length];

        static {
            try {
                f13308a[FriendRequestState.NEEDS_RESPONSE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f13308a[FriendRequestState.ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f13308a[FriendRequestState.REJECTED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsLauncher m14954a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f13309c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsLauncher.class;
        monitor-enter(r1);
        r0 = f13309c;	 Catch:{ all -> 0x003a }
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
        r0 = m14956b(r0);	 Catch:{ all -> 0x0035 }
        f13309c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f13309c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsLauncher.a(com.facebook.inject.InjectorLike):com.facebook.friending.jewel.entitycards.FriendRequestsEntityCardsLauncher");
    }

    private static FriendRequestsEntityCardsLauncher m14956b(InjectorLike injectorLike) {
        return new FriendRequestsEntityCardsLauncher(EntityCardsLauncher.m12933a(injectorLike), EntityCardsIntentHelper.m12923a(injectorLike));
    }

    @Inject
    public FriendRequestsEntityCardsLauncher(EntityCardsLauncher entityCardsLauncher, EntityCardsIntentHelper entityCardsIntentHelper) {
        this.f13310a = entityCardsLauncher;
        this.f13311b = entityCardsIntentHelper;
    }

    public final boolean m14959a() {
        return this.f13310a.m12938a("friending");
    }

    public final void m14957a(Activity activity, FriendingPossibilitiesList friendingPossibilitiesList, String str, Optional<String> optional, FriendingLocation friendingLocation, String str2) {
        EntityRange a = EntityCardsIntentHelper.m12921a(friendingPossibilitiesList.mo827a(), str);
        List a2 = Lists.a();
        for (int i = a.f10987d; i <= a.f10988e; i++) {
            a2.add(m14952a(friendingPossibilitiesList.mo826a(i)));
        }
        m14955a(activity, a.f10984a, str, "friend_requests", optional, a2, friendingLocation, FriendRequestMakeRef.JEWEL, str2, null);
    }

    public final void m14958a(Activity activity, FriendingPossibilitiesList friendingPossibilitiesList, String str, Optional<String> optional, FriendingLocation friendingLocation, String str2, int i) {
        EntityRange a = EntityCardsIntentHelper.m12921a(friendingPossibilitiesList.mo831b(), str);
        List a2 = Lists.a();
        for (int i2 = a.f10987d; i2 <= a.f10988e; i2++) {
            a2.add(m14953a(friendingPossibilitiesList.mo830b(i2)));
        }
        m14955a(activity, a.f10984a, str, "pymk", optional, a2, friendingLocation, FriendRequestMakeRef.PYMK_JEWEL, str2, Integer.valueOf(i));
    }

    private void m14955a(Activity activity, ImmutableList<String> immutableList, String str, @Nullable String str2, Optional<String> optional, List<PersonCardModel> list, FriendingLocation friendingLocation, @Nullable FriendRequestMakeRef friendRequestMakeRef, String str3, @Nullable Integer num) {
        Bundle a = FriendRequestsIdsPageLoader.m14965a(str2, (String) optional.orNull(), friendingLocation);
        FlatBufferModelHelper.a(a, "preliminary_entities", Lists.a(list));
        a.putString("extra_friending_location_name", friendingLocation.name());
        a.putString("extra_friend_request_make_ref", friendRequestMakeRef != null ? friendRequestMakeRef.name() : null);
        this.f13310a.m12937a(activity, "friending", StringUtil.a(str2) ? Absent.withType() : Optional.of(str2), immutableList, str, str3, a, num);
    }

    private static PersonCardModel m14952a(FriendRequest friendRequest) {
        GraphQLFriendshipStatus graphQLFriendshipStatus;
        boolean l = friendRequest.l();
        switch (C14081.f13308a[friendRequest.j.ordinal()]) {
            case 1:
                if (!l) {
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.INCOMING_REQUEST;
                    break;
                }
                graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
                break;
            case 2:
                if (!l) {
                    graphQLFriendshipStatus = GraphQLFriendshipStatus.ARE_FRIENDS;
                    break;
                }
                graphQLFriendshipStatus = GraphQLFriendshipStatus.OUTGOING_REQUEST;
                break;
            case 3:
                graphQLFriendshipStatus = GraphQLFriendshipStatus.CAN_REQUEST;
                break;
            default:
                throw new IllegalStateException("Unexpected friend request state: " + friendRequest.j);
        }
        Builder builder = new Builder();
        builder.f11210k = friendRequest.b;
        builder = builder;
        builder.f11209j = graphQLFriendshipStatus;
        Builder builder2 = builder;
        builder2.f11214o = friendRequest.b();
        builder2 = builder2;
        DefaultImageFieldsModel.Builder builder3 = new DefaultImageFieldsModel.Builder();
        builder3.b = friendRequest.d();
        builder2.f11217r = builder3.a();
        return builder2.m13176a();
    }

    private static PersonCardModel m14953a(PersonYouMayKnow personYouMayKnow) {
        Builder builder = new Builder();
        builder.f11209j = personYouMayKnow.f();
        builder = builder;
        builder.f11210k = String.valueOf(personYouMayKnow.a());
        builder = builder;
        builder.f11214o = personYouMayKnow.b();
        builder = builder;
        DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
        builder2.b = personYouMayKnow.d();
        builder.f11216q = builder2.a();
        return builder.m13176a();
    }
}
