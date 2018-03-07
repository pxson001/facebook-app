package com.facebook.friendsnearby.model.pings;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.friendsnearby.ExperimentsForFriendsNearbyModule;
import com.facebook.friendsnearby.model.FriendsNearbyDataUtil;
import com.facebook.friendsnearby.model.FriendsNearbyNewDataHolder;
import com.facebook.friendsnearby.model.FriendsNearbyNewMapRow;
import com.facebook.friendsnearby.model.FriendsNearbyNewMapRowProvider;
import com.facebook.friendsnearby.model.FriendsNearbyNewRowSection;
import com.facebook.friendsnearby.model.FriendsNearbyOutgoingPingRow;
import com.facebook.friendsnearby.model.FriendsNearbyRow;
import com.facebook.friendsnearby.model.FriendsNearbySection;
import com.facebook.friendsnearby.model.FriendsNearbyUserCache;
import com.facebook.friendsnearby.pingdialog.LocationPingDeleteParams;
import com.facebook.friendsnearby.pingdialog.LocationPingParams;
import com.facebook.friendsnearby.pingdialog.LocationPingTime.Type;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.IncomingLocationPingWithSenderModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.OutgoingLocationPingWithRecipientModel;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.User;
import com.facebook.user.model.UserBuilder;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: __debug__ */
public class FriendsNearbyPingsUtil {
    private static final CallerContext f20594a = CallerContext.a(FriendsNearbyPingsUtil.class);
    private static volatile FriendsNearbyPingsUtil f20595l;
    private final Clock f20596b;
    private final Resources f20597c;
    private final TimeFormatUtil f20598d;
    private final FriendsNearbyDataUtil f20599e;
    private final QeAccessor f20600f;
    private final FriendsNearbyNewMapRowProvider f20601g;
    private final GatekeeperStoreImpl f20602h;
    private final TasksManager<String> f20603i;
    private final DefaultBlueServiceOperationFactory f20604j;
    public final AbstractFbErrorReporter f20605k;

    /* compiled from: __debug__ */
    class C29341 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ FriendsNearbyPingsUtil f20593a;

        C29341(FriendsNearbyPingsUtil friendsNearbyPingsUtil) {
            this.f20593a = friendsNearbyPingsUtil;
        }

        protected final void m20999a(Throwable th) {
            this.f20593a.f20605k.a("friends_nearby_replace_precise_location_sharing_delete_outgoing_ping_failure", th);
        }
    }

    public static com.facebook.friendsnearby.model.pings.FriendsNearbyPingsUtil m21000a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20595l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.friendsnearby.model.pings.FriendsNearbyPingsUtil.class;
        monitor-enter(r1);
        r0 = f20595l;	 Catch:{ all -> 0x003a }
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
        r0 = m21006b(r0);	 Catch:{ all -> 0x0035 }
        f20595l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20595l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.friendsnearby.model.pings.FriendsNearbyPingsUtil.a(com.facebook.inject.InjectorLike):com.facebook.friendsnearby.model.pings.FriendsNearbyPingsUtil");
    }

    private static FriendsNearbyPingsUtil m21006b(InjectorLike injectorLike) {
        return new FriendsNearbyPingsUtil((Clock) SystemClockMethodAutoProvider.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), (TimeFormatUtil) DefaultTimeFormatUtil.a(injectorLike), FriendsNearbyDataUtil.m20822a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FriendsNearbyNewMapRowProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbyNewMapRowProvider.class), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final FriendsNearbySection m21007a(FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder) {
        Object obj;
        if (friendsNearbyPingsDataHolder.f20589a.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return FriendsNearbyNewDataHolder.f20484b;
        }
        String string = this.f20597c.getString(2131242006);
        Collection copyOf = ImmutableList.copyOf(friendsNearbyPingsDataHolder.f20589a);
        return new FriendsNearbyNewRowSection(string, "Outgoing_Pings", ImmutableList.copyOf(copyOf), m21005a());
    }

    public final FriendsNearbySection m21010b(FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder) {
        Object obj;
        if (friendsNearbyPingsDataHolder.f20591c.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return FriendsNearbyNewDataHolder.f20483a;
        }
        String c = m21011c(friendsNearbyPingsDataHolder);
        Collection copyOf = ImmutableList.copyOf(friendsNearbyPingsDataHolder.f20591c);
        return new FriendsNearbyNewRowSection(c, "Pings", ImmutableList.copyOf(copyOf), m21005a());
    }

    @Inject
    public FriendsNearbyPingsUtil(Clock clock, Resources resources, TimeFormatUtil timeFormatUtil, FriendsNearbyDataUtil friendsNearbyDataUtil, QeAccessor qeAccessor, FriendsNearbyNewMapRowProvider friendsNearbyNewMapRowProvider, GatekeeperStoreImpl gatekeeperStoreImpl, TasksManager tasksManager, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f20596b = clock;
        this.f20597c = resources;
        this.f20598d = timeFormatUtil;
        this.f20599e = friendsNearbyDataUtil;
        this.f20600f = qeAccessor;
        this.f20601g = friendsNearbyNewMapRowProvider;
        this.f20602h = gatekeeperStoreImpl;
        this.f20603i = tasksManager;
        this.f20604j = defaultBlueServiceOperationFactory;
        this.f20605k = abstractFbErrorReporter;
    }

    public final String m21011c(FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder) {
        int size = friendsNearbyPingsDataHolder.f20591c.size();
        return this.f20597c.getQuantityString(2131689812, size, new Object[]{Integer.valueOf(size)});
    }

    public final FriendsNearbyPingsDataHolder m21008a(FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder, FriendsNearbyUserCache friendsNearbyUserCache, FriendsNearbyLocationSharingFieldsModel friendsNearbyLocationSharingFieldsModel) {
        long a = this.f20596b.a();
        for (OutgoingLocationPingWithRecipientModel outgoingLocationPingWithRecipientModel : FriendsNearbyDataUtil.m20826b(friendsNearbyLocationSharingFieldsModel)) {
            if (this.f20602h.a(999, false)) {
                m21004a(outgoingLocationPingWithRecipientModel.m21578c().m21568b());
            } else {
                LocationPingParams a2 = LocationPingParams.m21038a(outgoingLocationPingWithRecipientModel.m21575a(), outgoingLocationPingWithRecipientModel.m21577b(), ((long) outgoingLocationPingWithRecipientModel.m21579d()) * 1000, outgoingLocationPingWithRecipientModel.m21578c().m21568b(), a);
                FriendsNearbyOutgoingPingRow a3 = FriendsNearbyOutgoingPingRow.m20928a(a2, Uri.parse(outgoingLocationPingWithRecipientModel.m21578c().m21570d().b()), outgoingLocationPingWithRecipientModel.m21578c().m21569c(), m21003a(a2), "Outgoing_Pings");
                String b = outgoingLocationPingWithRecipientModel.m21578c().m21568b();
                friendsNearbyPingsDataHolder.m20995a(b, a3);
                friendsNearbyUserCache.m20990a(b, m21002a(outgoingLocationPingWithRecipientModel));
            }
        }
        for (IncomingLocationPingWithSenderModel incomingLocationPingWithSenderModel : FriendsNearbyDataUtil.m20825a(friendsNearbyLocationSharingFieldsModel)) {
            String b2 = incomingLocationPingWithSenderModel.nr_().m21542b();
            friendsNearbyPingsDataHolder.m20994a(b2, FriendsNearbyNewMapRow.m20916a(incomingLocationPingWithSenderModel, this.f20599e, this.f20598d.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, incomingLocationPingWithSenderModel.m21554c() * 1000), "Pings", friendsNearbyPingsDataHolder.m20996b(b2), this.f20601g));
            friendsNearbyUserCache.m20990a(b2, m21001a(incomingLocationPingWithSenderModel));
        }
        return friendsNearbyPingsDataHolder;
    }

    public final void m21009a(FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder, String str, LocationPingParams locationPingParams, @Nullable FriendsNearbyRow friendsNearbyRow) {
        if (friendsNearbyPingsDataHolder.m20996b(str)) {
            FriendsNearbyOutgoingPingRow friendsNearbyOutgoingPingRow = (FriendsNearbyOutgoingPingRow) friendsNearbyPingsDataHolder.f20590b.get(str);
            friendsNearbyOutgoingPingRow.f20527d = locationPingParams;
            friendsNearbyOutgoingPingRow.f20528e = m21003a(locationPingParams);
        } else if (friendsNearbyRow != null) {
            friendsNearbyPingsDataHolder.m20995a(str, FriendsNearbyOutgoingPingRow.m20928a(locationPingParams, friendsNearbyRow.mo911b(), friendsNearbyRow.mo913c(), m21003a(locationPingParams), "Outgoing_Pings"));
        }
    }

    private boolean m21005a() {
        return this.f20600f.a(ExperimentsForFriendsNearbyModule.f20447a, false);
    }

    private void m21004a(String str) {
        Parcelable locationPingDeleteParams = new LocationPingDeleteParams(str);
        Bundle bundle = new Bundle();
        bundle.putParcelable("locationPingDeleteParams", locationPingDeleteParams);
        this.f20603i.a("delete_outgoing_ping" + str, BlueServiceOperationFactoryDetour.a(this.f20604j, "delete_ping", bundle, ErrorPropagation.BY_ERROR_CODE, f20594a, 175118110).a(), new C29341(this));
    }

    private String m21003a(LocationPingParams locationPingParams) {
        if (locationPingParams.f20621b.f20625a == Type.FOREVER) {
            return this.f20597c.getString(2131242005);
        }
        if (locationPingParams.f20621b.f20626b.isPresent()) {
            return this.f20598d.a(TimeFormatStyle.EVENTS_RELATIVE_STYLE, ((Long) locationPingParams.f20621b.f20626b.get()).longValue());
        }
        return "";
    }

    private static User m21001a(IncomingLocationPingWithSenderModel incomingLocationPingWithSenderModel) {
        UserBuilder a = new UserBuilder().a(User.Type.FACEBOOK, incomingLocationPingWithSenderModel.nr_().m21542b());
        a.h = incomingLocationPingWithSenderModel.nr_().m21543c();
        return a.aa();
    }

    private static User m21002a(OutgoingLocationPingWithRecipientModel outgoingLocationPingWithRecipientModel) {
        UserBuilder a = new UserBuilder().a(User.Type.FACEBOOK, outgoingLocationPingWithRecipientModel.m21578c().m21568b());
        a.h = outgoingLocationPingWithRecipientModel.m21578c().m21569c();
        return a.aa();
    }
}
