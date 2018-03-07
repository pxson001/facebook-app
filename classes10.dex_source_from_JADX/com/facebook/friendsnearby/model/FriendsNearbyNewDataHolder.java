package com.facebook.friendsnearby.model;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.friendsnearby.ExperimentsForFriendsNearbyModule;
import com.facebook.friendsnearby.model.pings.FriendsNearbyPingsDataHolder;
import com.facebook.friendsnearby.model.pings.FriendsNearbyPingsUtil;
import com.facebook.friendsnearby.model.sections.FriendsNearbySectionsDataHolder;
import com.facebook.friendsnearby.model.sections.FriendsNearbySectionsUtil;
import com.facebook.friendsnearby.pingdialog.LocationPingParams;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryInterfaces.FriendsNearbyHighlightQuery;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyContactsTabModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyHighlightQueryModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyLocationSharingFieldsModel.NearbyFriendsRegionModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyNewListSectionModel;
import com.facebook.friendsnearby.server.FriendsNearbyNewQueryModels.FriendsNearbyViewerInfoModel;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.inject.InjectorLike;
import com.facebook.location.ImmutableLocation;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: a2267e68774b3b55746895d2932566c2 */
public class FriendsNearbyNewDataHolder {
    public static final FriendsNearbySection f20483a = FriendsNearbySection.m20919b("Pings");
    public static final FriendsNearbySection f20484b = FriendsNearbySection.m20919b("Outgoing_Pings");
    private static final Class<?> f20485c = FriendsNearbyNewDataHolder.class;
    public final DefaultAndroidThreadUtil f20486d;
    private final Resources f20487e;
    public final FriendsNearbyPingsUtil f20488f;
    public final FriendsNearbySectionsUtil f20489g;
    private final GatekeeperStoreImpl f20490h;
    private final FriendsNearbySelfRow f20491i;
    private final QeAccessor f20492j;
    private final FriendsNearbyNewListRowProvider f20493k;
    public FriendsNearbyPingsDataHolder f20494l = new FriendsNearbyPingsDataHolder();
    public FriendsNearbySectionsDataHolder f20495m = new FriendsNearbySectionsDataHolder();
    public FriendsNearbyUserCache f20496n = new FriendsNearbyUserCache();
    public ImmutableList<String> f20497o = RegularImmutableList.a;
    public FriendsNearbySection f20498p = f20483a;
    public FriendsNearbySection f20499q = f20484b;
    public FriendsNearbySection f20500r = FriendsNearbySection.f20519c;
    public FriendsNearbySection f20501s = FriendsNearbySection.f20519c;
    public FriendsNearbySection f20502t = FriendsNearbySection.f20519c;
    public ImmutableList<FriendsNearbySection> f20503u = RegularImmutableList.a;
    public ImmutableList<FriendsNearbySection> f20504v = RegularImmutableList.a;
    public final Set<Listener> f20505w = Sets.a();
    public boolean f20506x = false;
    private boolean f20507y = false;
    private boolean f20508z = false;

    /* compiled from: a2267e68774b3b55746895d2932566c2 */
    public interface Listener {
        void mo924a();

        void mo925a(String str);

        void mo926b();
    }

    public static FriendsNearbyNewDataHolder m20866b(InjectorLike injectorLike) {
        return new FriendsNearbyNewDataHolder(DefaultAndroidThreadUtil.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), FriendsNearbyPingsUtil.m21000a(injectorLike), FriendsNearbySectionsUtil.m21016a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), new FriendsNearbySelfRow(GatekeeperStoreImplMethodAutoProvider.a(injectorLike)), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (FriendsNearbyNewListRowProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FriendsNearbyNewListRowProvider.class));
    }

    @Inject
    public FriendsNearbyNewDataHolder(DefaultAndroidThreadUtil defaultAndroidThreadUtil, Resources resources, FriendsNearbyPingsUtil friendsNearbyPingsUtil, FriendsNearbySectionsUtil friendsNearbySectionsUtil, GatekeeperStoreImpl gatekeeperStoreImpl, FriendsNearbySelfRow friendsNearbySelfRow, QeAccessor qeAccessor, FriendsNearbyNewListRowProvider friendsNearbyNewListRowProvider) {
        this.f20486d = defaultAndroidThreadUtil;
        this.f20487e = resources;
        this.f20488f = friendsNearbyPingsUtil;
        this.f20489g = friendsNearbySectionsUtil;
        this.f20490h = gatekeeperStoreImpl;
        this.f20491i = friendsNearbySelfRow;
        this.f20492j = qeAccessor;
        this.f20493k = friendsNearbyNewListRowProvider;
    }

    public final void m20877a(DashboardModel dashboardModel) {
        this.f20486d.a();
        m20874p();
        m20868c(dashboardModel);
        m20872m();
        m20875r();
    }

    public final void m20886b(DashboardModel dashboardModel) {
        this.f20486d.a();
        m20868c(dashboardModel);
        m20872m();
        m20875r();
    }

    private void m20868c(DashboardModel dashboardModel) {
        FriendsNearbySelfRow friendsNearbySelfRow;
        Object obj;
        if (dashboardModel.f20461b.isPresent()) {
            this.f20488f.m21008a(this.f20494l, this.f20496n, (FriendsNearbyLocationSharingFieldsModel) dashboardModel.f20461b.get());
            this.f20499q = this.f20488f.m21007a(this.f20494l);
            this.f20498p = this.f20488f.m21010b(this.f20494l);
            FriendsNearbySectionsUtil friendsNearbySectionsUtil = this.f20489g;
            FriendsNearbySectionsDataHolder friendsNearbySectionsDataHolder = this.f20495m;
            FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder = this.f20494l;
            ImmutableList a = friendsNearbySectionsDataHolder.m21012a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                FriendsNearbySectionsUtil.m21018a((FriendsNearbySection) a.get(i), friendsNearbyPingsDataHolder);
            }
            FriendsNearbySectionsUtil.m21018a(this.f20500r, this.f20494l);
            FriendsNearbySectionsUtil.m21018a(this.f20501s, this.f20494l);
            friendsNearbySelfRow = this.f20491i;
            NearbyFriendsRegionModel g = ((FriendsNearbyLocationSharingFieldsModel) dashboardModel.f20461b.get()).m21323g();
            if (!(g == null || g.m21286a() == null || g.m21288b() == null)) {
                friendsNearbySelfRow.f20569e = g.m21286a().m21273a();
            }
            this.f20506x = true;
        }
        if (dashboardModel.f20463d.isPresent()) {
            m20867b((FriendsNearbyContactsTabModel) dashboardModel.f20463d.get());
        }
        if (dashboardModel.f20460a.isPresent()) {
            friendsNearbySelfRow = this.f20491i;
            FriendsNearbyViewerInfoModel friendsNearbyViewerInfoModel = (FriendsNearbyViewerInfoModel) dashboardModel.f20460a.get();
            friendsNearbySelfRow.f20566b = friendsNearbyViewerInfoModel.m21520b();
            if (!(friendsNearbyViewerInfoModel.m21522d() == null || friendsNearbyViewerInfoModel.m21522d().b() == null)) {
                friendsNearbySelfRow.f20567c = Uri.parse(friendsNearbyViewerInfoModel.m21522d().b());
            }
            friendsNearbySelfRow.f20568d = friendsNearbyViewerInfoModel.m21521c();
        }
        if (dashboardModel.f20464e.isPresent()) {
            m20864a((ImmutableList) dashboardModel.f20464e.get());
        }
        FriendsNearbySelfRow friendsNearbySelfRow2 = this.f20491i;
        if (friendsNearbySelfRow2.f20566b == null || friendsNearbySelfRow2.f20567c == null || friendsNearbySelfRow2.f20568d == null || friendsNearbySelfRow2.f20569e == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            m20870k();
        }
    }

    public final void m20880a(FriendsNearbyContactsTabModel friendsNearbyContactsTabModel) {
        m20867b(friendsNearbyContactsTabModel);
        this.f20507y = true;
        m20872m();
        m20875r();
    }

    public final void m20883a(String str, String str2, String str3, ImmutableLocation immutableLocation) {
        this.f20486d.a();
        this.f20489g.m21024a(this.f20495m, str, str2, str3, immutableLocation);
        this.f20489g.m21023a(this.f20498p, str, str2, str3, immutableLocation);
        this.f20489g.m21023a(this.f20499q, str, str2, str3, immutableLocation);
        this.f20489g.m21023a(this.f20500r, str, str2, str3, immutableLocation);
        this.f20489g.m21023a(this.f20501s, str, str2, str3, immutableLocation);
        m20869f(str);
    }

    public final void m20878a(Listener listener) {
        this.f20486d.a();
        this.f20505w.add(listener);
        if (m20873o()) {
            listener.mo926b();
        }
    }

    public final void m20884a(boolean z) {
        this.f20508z = z;
        m20872m();
    }

    public final void m20876a() {
        this.f20486d.a();
        boolean o = m20873o();
        m20874p();
        if (o) {
            for (Listener a : this.f20505w) {
                a.mo924a();
            }
        }
    }

    public final ImmutableList<FriendsNearbySection> m20885b() {
        this.f20486d.a();
        if (this.f20500r != FriendsNearbySection.f20519c) {
            return this.f20504v;
        }
        return this.f20503u;
    }

    public final void m20882a(String str, LocationPingParams locationPingParams) {
        FriendsNearbyRow friendsNearbyRow;
        this.f20486d.a();
        List a = this.f20495m.f20607b.m20992a(str);
        if (a == null || a.isEmpty()) {
            friendsNearbyRow = null;
        } else {
            friendsNearbyRow = (FriendsNearbyRow) a.get(0);
        }
        FriendsNearbyRow friendsNearbyRow2 = friendsNearbyRow;
        if (friendsNearbyRow2 == null) {
            friendsNearbyRow2 = FriendsNearbySectionsUtil.m21015a(this.f20500r, str);
        }
        if (friendsNearbyRow2 == null) {
            friendsNearbyRow2 = FriendsNearbySectionsUtil.m21015a(this.f20501s, str);
        }
        if (friendsNearbyRow2 == null) {
            friendsNearbyRow2 = FriendsNearbySectionsUtil.m21015a(this.f20498p, str);
        }
        if (friendsNearbyRow2 == null) {
            friendsNearbyRow2 = FriendsNearbySectionsUtil.m21015a(this.f20499q, str);
        }
        this.f20488f.m21009a(this.f20494l, str, locationPingParams, friendsNearbyRow2);
        m20865a(str, true);
        m20872m();
        m20869f(str);
    }

    public final ImmutableSet<String> m20890d() {
        return this.f20494l.m20997c();
    }

    public final void m20887b(String str) {
        this.f20486d.a();
        FriendsNearbyPingsDataHolder friendsNearbyPingsDataHolder = this.f20494l;
        FriendsNearbyOutgoingPingRow friendsNearbyOutgoingPingRow = (FriendsNearbyOutgoingPingRow) friendsNearbyPingsDataHolder.f20590b.get(str);
        if (friendsNearbyOutgoingPingRow != null) {
            friendsNearbyPingsDataHolder.f20589a.remove(friendsNearbyOutgoingPingRow);
            friendsNearbyPingsDataHolder.f20590b.remove(str);
        }
        m20865a(str, false);
        m20872m();
        m20869f(str);
    }

    public final FriendsNearbySection m20892e() {
        this.f20486d.a();
        return this.f20498p;
    }

    public final User m20888c(String str) {
        this.f20486d.a();
        return (User) this.f20496n.f20581a.get(str);
    }

    public final ImmutableList<String> m20893f() {
        this.f20486d.a();
        return this.f20497o;
    }

    public final void m20894g() {
        this.f20486d.a();
        this.f20497o = RegularImmutableList.a;
    }

    public final void m20879a(FriendsNearbySection friendsNearbySection) {
        this.f20486d.a();
        this.f20500r = friendsNearbySection;
        this.f20504v = ImmutableList.of(this.f20500r);
        if (friendsNearbySection != FriendsNearbySection.f20519c) {
            this.f20496n.m20991a(this.f20489g.m21022a(friendsNearbySection));
        }
        m20875r();
    }

    public final void m20881a(String str, FriendsNearbySection friendsNearbySection) {
        this.f20486d.a();
        FriendsNearbySectionsUtil friendsNearbySectionsUtil = this.f20489g;
        FriendsNearbySectionsDataHolder friendsNearbySectionsDataHolder = this.f20495m;
        FriendsNearbyUserCache friendsNearbyUserCache = this.f20496n;
        friendsNearbySectionsDataHolder.m21013a(str, friendsNearbySection);
        friendsNearbyUserCache.m20991a(friendsNearbySectionsUtil.m21022a(friendsNearbySection));
        m20872m();
        m20875r();
    }

    public final FriendsNearbySection m20889d(String str) {
        this.f20486d.a();
        if ("Pings".equals(str)) {
            return this.f20498p;
        }
        if ("Outgoing_Pings".equals(str)) {
            return this.f20499q;
        }
        if ("friends_nearby_search_section".equals(str)) {
            return this.f20500r;
        }
        if ("friends_nearby_highlight_section".equals(str)) {
            return this.f20501s;
        }
        if ("friends_nearby_self_view_section".equals(str)) {
            return this.f20502t;
        }
        return (FriendsNearbySection) this.f20495m.f20606a.get(str);
    }

    @Nullable
    public final FriendsNearbyNewMapRow m20891e(String str) {
        this.f20486d.a();
        for (FriendsNearbyRow friendsNearbyRow : this.f20498p.e()) {
            if (str.equals(friendsNearbyRow.mo908a())) {
                return (FriendsNearbyNewMapRow) friendsNearbyRow;
            }
        }
        return null;
    }

    public final boolean m20895i() {
        return this.f20500r != FriendsNearbySection.f20519c;
    }

    public final boolean m20896j() {
        return this.f20503u.size() > 1 || !(this.f20490h.a(1002, false) || this.f20503u.isEmpty());
    }

    private void m20865a(String str, boolean z) {
        this.f20499q = this.f20488f.m21007a(this.f20494l);
        ImmutableSet<FriendsNearbyRow> b = this.f20495m.m21014b(str);
        if (b != null) {
            for (FriendsNearbyRow friendsNearbyRow : b) {
                ((FriendsNearbyNewListRow) friendsNearbyRow).f20509a = z;
            }
        }
        FriendsNearbySectionsUtil.m21019a(this.f20498p, str, z);
        FriendsNearbySectionsUtil.m21019a(this.f20500r, str, z);
        FriendsNearbySectionsUtil.m21019a(this.f20501s, str, z);
    }

    private void m20867b(FriendsNearbyContactsTabModel friendsNearbyContactsTabModel) {
        FriendsNearbySectionsUtil friendsNearbySectionsUtil = this.f20489g;
        FriendsNearbySectionsDataHolder friendsNearbySectionsDataHolder = this.f20495m;
        ImmutableSet c = this.f20494l.m20997c();
        FriendsNearbyUserCache friendsNearbyUserCache = this.f20496n;
        for (FriendsNearbyNewListSectionModel friendsNearbyNewListSectionModel : FriendsNearbyDataUtil.m20824a(friendsNearbyContactsTabModel)) {
            String b = friendsNearbyNewListSectionModel.m21419b();
            FriendsNearbySection a = FriendsNearbyNewRowSection.m20922a(friendsNearbyNewListSectionModel, c, friendsNearbySectionsUtil.f20611c.a(ExperimentsForFriendsNearbyModule.f20447a, false), friendsNearbySectionsUtil.f20610b);
            DefaultPageInfoFields b2 = friendsNearbyNewListSectionModel.m21420c().m21408b();
            if (b2 != null) {
                a.f20520b = b2.a();
            }
            friendsNearbySectionsDataHolder.m21013a(b, a);
            friendsNearbyUserCache.m20991a(FriendsNearbySectionsUtil.m21017a(friendsNearbyNewListSectionModel));
        }
    }

    private void m20870k() {
        FriendsNearbySelfRow friendsNearbySelfRow = this.f20491i;
        boolean l = m20871l();
        Builder builder = ImmutableList.builder();
        builder.c(friendsNearbySelfRow);
        this.f20502t = new FriendsNearbyNewRowSection(this.f20487e.getString(2131242008), "friends_nearby_self_view_section", builder.b(), l);
    }

    private void m20864a(ImmutableList<FriendsNearbyHighlightQuery> immutableList) {
        if (immutableList.isEmpty()) {
            this.f20501s = FriendsNearbySection.f20519c;
            return;
        }
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(((FriendsNearbyHighlightQueryModel) immutableList.get(i)).m21217b());
        }
        this.f20497o = builder.b();
        this.f20501s = FriendsNearbyNewRowSection.m20923a(immutableList, this.f20487e.getString(2131242007), "friends_nearby_highlight_section", m20890d(), m20871l(), this.f20493k);
    }

    private boolean m20871l() {
        return this.f20492j.a(ExperimentsForFriendsNearbyModule.f20447a, false);
    }

    private void m20872m() {
        Builder builder = ImmutableList.builder();
        if (!(this.f20501s == FriendsNearbySection.f20519c || this.f20501s.e().isEmpty())) {
            builder.c(this.f20501s);
        }
        if (this.f20490h.a(1002, false) && this.f20502t != FriendsNearbySection.f20519c) {
            builder.c(this.f20502t);
        }
        ImmutableList a = this.f20495m.m21012a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            FriendsNearbySection friendsNearbySection = (FriendsNearbySection) a.get(i);
            if (!friendsNearbySection.e().isEmpty()) {
                builder.c(friendsNearbySection);
            }
        }
        if (this.f20508z && !this.f20498p.e().isEmpty()) {
            builder.c(this.f20498p);
        }
        if (!this.f20499q.e().isEmpty() && this.f20507y) {
            builder.c(this.f20499q);
        }
        this.f20503u = builder.b();
        this.f20504v = ImmutableList.of(this.f20500r);
    }

    private boolean m20873o() {
        return !this.f20503u.isEmpty();
    }

    private void m20874p() {
        this.f20506x = false;
        this.f20507y = false;
        FriendsNearbySelfRow friendsNearbySelfRow = this.f20491i;
        friendsNearbySelfRow.f20566b = null;
        friendsNearbySelfRow.f20567c = null;
        friendsNearbySelfRow.f20568d = null;
        friendsNearbySelfRow.f20569e = null;
        this.f20494l = new FriendsNearbyPingsDataHolder();
        this.f20495m = new FriendsNearbySectionsDataHolder();
        this.f20496n = new FriendsNearbyUserCache();
        this.f20503u = RegularImmutableList.a;
        this.f20499q = f20484b;
        this.f20498p = f20483a;
        this.f20500r = FriendsNearbySection.f20519c;
        this.f20504v = RegularImmutableList.a;
        this.f20501s = FriendsNearbySection.f20519c;
        this.f20497o = RegularImmutableList.a;
        this.f20502t = FriendsNearbySection.f20519c;
    }

    private void m20875r() {
        for (Listener b : this.f20505w) {
            b.mo926b();
        }
    }

    private void m20869f(String str) {
        for (Listener a : this.f20505w) {
            a.mo925a(str);
        }
    }
}
