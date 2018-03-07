package com.facebook.friendsnearby.model;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.friendsnearby.ExperimentsForFriendsNearbyModule;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery.FriendsNearbyContactsTabQueryString;
import com.facebook.friendsnearby.server.FriendsNearbyNewQuery.FriendsNearbyLocationSharingQueryString;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingQueryModel;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.ImmutableLocation;
import com.facebook.location.LocationAgeUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Optional;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: _time_spent */
public class FriendsNearbyQueryBuilder {
    private static volatile FriendsNearbyQueryBuilder f20529e;
    public final String f20530a;
    private final Clock f20531b;
    private final LocationAgeUtil f20532c;
    private final QeAccessor f20533d;

    public static com.facebook.friendsnearby.model.FriendsNearbyQueryBuilder m20943a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20529e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.model.FriendsNearbyQueryBuilder.class;
        monitor-enter(r1);
        r0 = f20529e;	 Catch:{ all -> 0x003a }
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
        r0 = m20945b(r0);	 Catch:{ all -> 0x0035 }
        f20529e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20529e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.model.FriendsNearbyQueryBuilder.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.model.FriendsNearbyQueryBuilder");
    }

    private static FriendsNearbyQueryBuilder m20945b(InjectorLike injectorLike) {
        return new FriendsNearbyQueryBuilder((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), LocationAgeUtil.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsNearbyQueryBuilder(Clock clock, Resources resources, LocationAgeUtil locationAgeUtil, QeAccessor qeAccessor) {
        this.f20531b = clock;
        this.f20530a = String.valueOf(resources.getDimensionPixelSize(2131434232));
        this.f20532c = locationAgeUtil;
        this.f20533d = qeAccessor;
    }

    public final GraphQLRequest<FriendsNearbyContactsTabModel> m20947a(Optional<ImmutableLocation> optional) {
        return m20944a(true, null, optional);
    }

    public final GraphQLRequest<FriendsNearbyContactsTabModel> m20948a(String str, Optional<ImmutableLocation> optional) {
        return m20944a(false, str, optional);
    }

    private GraphQLRequest<FriendsNearbyContactsTabModel> m20944a(boolean z, String str, Optional<ImmutableLocation> optional) {
        String str2 = this.f20533d.a(ExperimentsForFriendsNearbyModule.f20447a, false) ? "1000" : "3";
        GraphQlQueryString friendsNearbyContactsTabQueryString = new FriendsNearbyContactsTabQueryString();
        friendsNearbyContactsTabQueryString.a("pic_size", this.f20530a).a("is_preview", z ? "true" : "false").a("set_items_fetch_count", str2).a("sections_cursor", str);
        if (optional.isPresent()) {
            ImmutableLocation immutableLocation = (ImmutableLocation) optional.get();
            friendsNearbyContactsTabQueryString.a("latitude", Double.toString(immutableLocation.a()));
            friendsNearbyContactsTabQueryString.a("longitude", Double.toString(immutableLocation.b()));
            friendsNearbyContactsTabQueryString.a("accuracy_meters", Integer.toString(((Float) immutableLocation.c().get()).intValue()));
            friendsNearbyContactsTabQueryString.a("stale_time_seconds", Long.toString(this.f20532c.a(immutableLocation) / 1000));
        }
        return GraphQLRequest.a(friendsNearbyContactsTabQueryString);
    }

    public final GraphQLRequest<FriendsNearbyLocationSharingQueryModel> m20946a(State state, Optional<ImmutableLocation> optional) {
        boolean z;
        GraphQlQueryString friendsNearbyLocationSharingQueryString = new FriendsNearbyLocationSharingQueryString();
        String str = "get_friends_sharing_when_enabled";
        if (state != State.OKAY) {
            z = true;
        } else {
            z = false;
        }
        friendsNearbyLocationSharingQueryString.a(str, Boolean.valueOf(z)).a("pic_size", this.f20530a).a("max_friends_sharing_faces", "16").a("image_size", Integer.valueOf(64)).a("image_scale", GraphQlQueryDefaults.a());
        if (optional.isPresent()) {
            ImmutableLocation immutableLocation = (ImmutableLocation) optional.get();
            friendsNearbyLocationSharingQueryString.a("latitude", Double.toString(immutableLocation.a()));
            friendsNearbyLocationSharingQueryString.a("longitude", Double.toString(immutableLocation.b()));
            friendsNearbyLocationSharingQueryString.a("accuracy_meters", Integer.toString(((Float) immutableLocation.c().get()).intValue()));
            friendsNearbyLocationSharingQueryString.a("stale_time_seconds", Long.toString(this.f20532c.a(immutableLocation) / 1000));
        }
        return GraphQLRequest.a(friendsNearbyLocationSharingQueryString);
    }
}
