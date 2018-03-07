package com.facebook.friendsnearby.model.sections;

import com.facebook.friendsnearby.model.FriendsNearbyDataUtil;
import com.facebook.friendsnearby.model.FriendsNearbyNewListRow;
import com.facebook.friendsnearby.model.FriendsNearbyNewListRowProvider;
import com.facebook.friendsnearby.model.FriendsNearbyNewMapRow;
import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.friendsnearby.model.pings.FriendsNearbyPingsDataHolder;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyNewListSection;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListItemModel;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: ______________ */
public class FriendsNearbySectionsUtil {
    private static volatile FriendsNearbySectionsUtil f20608d;
    private final FriendsNearbyDataUtil f20609a;
    public final FriendsNearbyNewListRowProvider f20610b;
    public final QeAccessor f20611c;

    public static com.facebook.friendsnearby.model.sections.FriendsNearbySectionsUtil m21016a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20608d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.model.sections.FriendsNearbySectionsUtil.class;
        monitor-enter(r1);
        r0 = f20608d;	 Catch:{ all -> 0x003a }
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
        r0 = m21021b(r0);	 Catch:{ all -> 0x0035 }
        f20608d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20608d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.model.sections.FriendsNearbySectionsUtil.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.model.sections.FriendsNearbySectionsUtil");
    }

    private static FriendsNearbySectionsUtil m21021b(InjectorLike injectorLike) {
        return new FriendsNearbySectionsUtil(FriendsNearbyDataUtil.m20822a(injectorLike), (FriendsNearbyNewListRowProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbyNewListRowProvider.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsNearbySectionsUtil(FriendsNearbyDataUtil friendsNearbyDataUtil, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider, QeAccessor qeAccessor) {
        this.f20609a = friendsNearbyDataUtil;
        this.f20610b = friendsNearbyNewListRowProvider;
        this.f20611c = qeAccessor;
    }

    public static void m21019a(FriendsNearbySection friendsNearbySection, String str, boolean z) {
        if (friendsNearbySection != FriendsNearbySection.f20519c) {
            for (FriendsNearbyRow friendsNearbyRow : friendsNearbySection.e()) {
                if (friendsNearbyRow.mo908a().equals(str)) {
                    ((FriendsNearbyNewListRow) friendsNearbyRow).f20509a = z;
                }
            }
        }
    }

    public static void m21018a(FriendsNearbySection friendsNearbySection, FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder) {
        if (friendsNearbySection != FriendsNearbySection.f20519c) {
            for (FriendsNearbyRow friendsNearbyRow : friendsNearbySection.e()) {
                FriendsNearbyNewListRow friendsNearbyNewListRow = (FriendsNearbyNewListRow) friendsNearbyRow;
                friendsNearbyNewListRow.f20509a = friendsNearbyPingsDataHolder.m20996b(friendsNearbyNewListRow.mo908a());
            }
        }
    }

    @Nullable
    public static FriendsNearbyRow m21015a(FriendsNearbySection friendsNearbySection, String str) {
        if (friendsNearbySection == FriendsNearbySection.f20519c) {
            return null;
        }
        for (FriendsNearbyRow friendsNearbyRow : friendsNearbySection.e()) {
            if (friendsNearbyRow.mo908a().equals(str)) {
                return friendsNearbyRow;
            }
        }
        return null;
    }

    public static Map<String, User> m21017a(FriendsNearbyNewListSection friendsNearbyNewListSection) {
        Map<String, User> c = Maps.c();
        ImmutableList a = friendsNearbyNewListSection.m21420c().m21407a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FriendsNearbyNewListItemModel friendsNearbyNewListItemModel = (FriendsNearbyNewListItemModel) a.get(i);
            String b = friendsNearbyNewListItemModel.m21398c().m21375a().m21369b();
            UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, b);
            a2.h = friendsNearbyNewListItemModel.m21398c().m21375a().m21370c();
            c.put(b, a2.aa());
        }
        return c;
    }

    public final Map<String, User> m21022a(FriendsNearbySection friendsNearbySection) {
        Map<String, User> c = Maps.c();
        for (FriendsNearbyRow friendsNearbyRow : friendsNearbySection.e()) {
            if (friendsNearbyRow instanceof FriendsNearbyNewListRow) {
                String a = friendsNearbyRow.mo908a();
                String c2 = friendsNearbyRow.mo913c();
                UserBuilder a2 = new UserBuilder().a(Type.FACEBOOK, a);
                a2.h = c2;
                User aa = a2.aa();
                c.put(aa.a, aa);
            }
        }
        return c;
    }

    public final void m21024a(FriendsNearbySectionsDataHolder friendsNearbySectionsDataHolder, String str, String str2, String str3, ImmutableLocation immutableLocation) {
        m21020a(friendsNearbySectionsDataHolder.m21014b(str), str, str2, str3, immutableLocation);
    }

    public final void m21023a(FriendsNearbySection friendsNearbySection, String str, String str2, String str3, ImmutableLocation immutableLocation) {
        if (friendsNearbySection != FriendsNearbySection.f20519c) {
            m21020a(friendsNearbySection.e(), str, str2, str3, immutableLocation);
        }
    }

    private static void m21020a(Iterable<FriendsNearbyRow> iterable, String str, String str2, String str3, ImmutableLocation immutableLocation) {
        if (iterable != null) {
            for (FriendsNearbyRow friendsNearbyRow : iterable) {
                if (friendsNearbyRow.mo908a().equals(str) && (friendsNearbyRow instanceof FriendsNearbyNewListRow)) {
                    ((FriendsNearbyNewListRow) friendsNearbyRow).f20514f = str2;
                    ((FriendsNearbyNewListRow) friendsNearbyRow).f20515g = str3;
                    if (friendsNearbyRow instanceof FriendsNearbyNewMapRow) {
                        ((FriendsNearbyNewMapRow) friendsNearbyRow).f20518a = immutableLocation;
                    }
                }
            }
        }
    }
}
