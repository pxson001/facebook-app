package com.facebook.friendsnearby.model;

import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyContactsTab;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyLocationSharingFields;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyNewListSection;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.IncomingLocationPingWithSender;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.OutgoingLocationPingWithRecipient;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel.ContactsTabsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel.ContactsTabsModel.NodesModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.IncomingPingsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.OutgoingPingsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.UpsellModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListSectionModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListSectionModel.SetItemsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewSectionWrapperModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewSectionWrapperModel.ContactsSetsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbySectionsPageFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.IncomingLocationPingWithSenderModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.IncomingLocationPingWithSenderModel.AccuracyModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.location.ImmutableLocation;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Singleton;

@Singleton
/* compiled from: a6e00e8fca8a5735d7a0c4443dde4c93 */
public class FriendsNearbyDataUtil {
    private static volatile FriendsNearbyDataUtil f20465a;

    public static com.facebook.friendsnearby.model.FriendsNearbyDataUtil m20822a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f20465a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.friendsnearby.model.FriendsNearbyDataUtil.class;
        monitor-enter(r1);
        r0 = f20465a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m20821a();	 Catch:{ all -> 0x0034 }
        f20465a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f20465a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.model.FriendsNearbyDataUtil.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.model.FriendsNearbyDataUtil");
    }

    private static FriendsNearbyDataUtil m20821a() {
        return new FriendsNearbyDataUtil();
    }

    @Nullable
    public static ImmutableLocation m20823a(@Nullable IncomingLocationPingWithSenderModel incomingLocationPingWithSenderModel) {
        if (incomingLocationPingWithSenderModel == null) {
            return null;
        }
        DefaultLocationFields b = incomingLocationPingWithSenderModel.m21553b();
        if (b == null) {
            return null;
        }
        AccuracyModel a = incomingLocationPingWithSenderModel.m21550a();
        if (a != null) {
            return ImmutableLocation.a(b.a(), b.b()).b((float) a.m21526a()).c(incomingLocationPingWithSenderModel.m21554c() * 1000).a();
        }
        return null;
    }

    public static ImmutableList<FriendsNearbyNewListSection> m20824a(FriendsNearbyContactsTab friendsNearbyContactsTab) {
        ContactsTabsModel a = friendsNearbyContactsTab.m21186a();
        if (a == null) {
            return RegularImmutableList.a;
        }
        if (a.m21181a().isEmpty()) {
            return RegularImmutableList.a;
        }
        FriendsNearbySectionsPageFieldsModel a2 = ((NodesModel) a.m21181a().get(0)).m21176a();
        if (a2 == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a3 = a2.m21509a();
        int size = a3.size();
        for (int i = 0; i < size; i++) {
            ContactsSetsModel a4 = ((FriendsNearbyNewSectionWrapperModel) a3.get(i)).m21431a();
            if (a4 != null) {
                ImmutableList a5 = a4.m21426a();
                int size2 = a5.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    FriendsNearbyNewListSectionModel friendsNearbyNewListSectionModel = (FriendsNearbyNewListSectionModel) a5.get(i2);
                    if (friendsNearbyNewListSectionModel != null) {
                        SetItemsModel c = friendsNearbyNewListSectionModel.m21420c();
                        if (!(c == null || c.m21407a().isEmpty())) {
                            builder.c(friendsNearbyNewListSectionModel);
                        }
                    }
                }
            }
        }
        return builder.b();
    }

    public static ImmutableList<IncomingLocationPingWithSender> m20825a(FriendsNearbyLocationSharingFields friendsNearbyLocationSharingFields) {
        if (friendsNearbyLocationSharingFields == null) {
            return RegularImmutableList.a;
        }
        IncomingPingsModel b = friendsNearbyLocationSharingFields.m21320b();
        if (b == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        builder.b(b.m21267a());
        return builder.b();
    }

    public static ImmutableList<OutgoingLocationPingWithRecipient> m20826b(FriendsNearbyLocationSharingFields friendsNearbyLocationSharingFields) {
        if (friendsNearbyLocationSharingFields == null) {
            return RegularImmutableList.a;
        }
        OutgoingPingsModel np_ = friendsNearbyLocationSharingFields.np_();
        if (np_ == null) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        builder.b(np_.m21294a());
        return builder.b();
    }

    public final int m20828f(FriendsNearbyLocationSharingFieldsModel friendsNearbyLocationSharingFieldsModel) {
        UpsellModel n = m20827n(friendsNearbyLocationSharingFieldsModel);
        if (n == null) {
            return 0;
        }
        return n.m21306a();
    }

    @Nullable
    public static UpsellModel m20827n(@Nullable FriendsNearbyLocationSharingFieldsModel friendsNearbyLocationSharingFieldsModel) {
        if (friendsNearbyLocationSharingFieldsModel == null || friendsNearbyLocationSharingFieldsModel.m21324j() == null) {
            return null;
        }
        return friendsNearbyLocationSharingFieldsModel.m21324j();
    }
}
