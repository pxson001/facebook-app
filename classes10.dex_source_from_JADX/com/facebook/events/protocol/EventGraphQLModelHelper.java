package com.facebook.events.protocol;

import android.content.res.Resources;
import android.net.Uri;
import com.facebook.common.time.SystemClock;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventsDateUtil;
import com.facebook.events.graphql.EventsConverter;
import com.facebook.events.graphql.EventsGraphQLInterfaces.EventCommonFragment;
import com.facebook.events.graphql.EventsGraphQLInterfaces.FetchEventPermalinkFragment;
import com.facebook.events.graphql.EventsGraphQLInterfaces.UserInEventFragment;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllDeclinesQueryModel.AllEventDeclinesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllGuestsEdgeFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventArtistPageDetailsFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventArtistPageDetailsFragmentModel.PageInfoSectionsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventArtistPageDetailsFragmentModel.PageInfoSectionsModel.FieldsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventArtistPageDetailsFragmentModel.PageLikersModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCategoryEdgesFragmentModel.RoleAssociatedEdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCategoryInfoFragmentModel.EventCategoryInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.Builder;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.CreatedForGroupModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventCreatorModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventHostsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.EventHostsModel.EdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonFragmentModel.ParentGroupModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventHostModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel.AddressModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventPlaceModel.LocationModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMaybesFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventMembersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.EventSocialContextFieldsModel.FriendEventWatchersFirst5Model;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel.EventTicketInfoModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel.EventTicketInfoModel.EdgesModel.NodeModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel.EventTicketInfoModel.EdgesModel.NodeModel.MaxTicketPriceModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel.EventTicketInfoModel.EdgesModel.NodeModel.MinTicketPriceModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel.EventTicketInfoModel.EdgesModel.NodeModel.TicketProviderPageModel;
import com.facebook.events.graphql.EventsGraphQLModels.UserInEventWithMutualFriendsFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.UserInEventWithMutualFriendsFragmentModel.MutualFriendsModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventArtist;
import com.facebook.events.model.EventTicketInfo;
import com.facebook.events.model.EventTicketInfo.Price;
import com.facebook.events.model.EventType;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.model.PrivacyType;
import com.facebook.graphql.enums.GraphQLConnectionStyle;
import com.facebook.graphql.enums.GraphQLEventActionStyle;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.graphql.enums.GraphQLEventTicketProviderType;
import com.facebook.graphql.enums.GraphQLEventType;
import com.facebook.graphql.enums.GraphQLEventVisibility;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLEventHostsConnection;
import com.facebook.graphql.model.GraphQLEventHostsEdge;
import com.facebook.graphql.model.GraphQLEventMaybesConnection;
import com.facebook.graphql.model.GraphQLEventMaybesEdge;
import com.facebook.graphql.model.GraphQLEventMembersConnection;
import com.facebook.graphql.model.GraphQLEventMembersEdge;
import com.facebook.graphql.model.GraphQLEventWatchersConnection;
import com.facebook.graphql.model.GraphQLEventWatchersEdge;
import com.facebook.graphql.model.GraphQLGroup;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.RegularImmutableList;
import java.util.Date;
import java.util.TimeZone;
import javax.inject.Singleton;

@Singleton
/* compiled from: audio_is_state */
public class EventGraphQLModelHelper {
    private static volatile EventGraphQLModelHelper f19059a;

    /* compiled from: audio_is_state */
    /* synthetic */ class C26991 {
        static final /* synthetic */ int[] f19057a = new int[GraphQLEventVisibility.values().length];
        static final /* synthetic */ int[] f19058b = new int[GraphQLEventType.values().length];

        static {
            try {
                f19058b[GraphQLEventType.QUICK_INVITE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19057a[GraphQLEventVisibility.FRIENDS_OF_FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19057a[GraphQLEventVisibility.FRIENDS_OF_GUESTS.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19057a[GraphQLEventVisibility.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19057a[GraphQLEventVisibility.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19057a[GraphQLEventVisibility.USER_PUBLIC.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f19057a[GraphQLEventVisibility.INVITE_ONLY.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f19057a[GraphQLEventVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: audio_is_state */
    public enum DateBucket {
        TODAY,
        YESTERDAY,
        EARLIER
    }

    public static com.facebook.events.protocol.EventGraphQLModelHelper m19271a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19059a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.events.protocol.EventGraphQLModelHelper.class;
        monitor-enter(r1);
        r0 = f19059a;	 Catch:{ all -> 0x0039 }
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
        r0 = m19270a();	 Catch:{ all -> 0x0034 }
        f19059a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f19059a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.protocol.EventGraphQLModelHelper.a(com.facebook.inject.InjectorLike):com.facebook.events.protocol.EventGraphQLModelHelper");
    }

    private static EventGraphQLModelHelper m19270a() {
        return new EventGraphQLModelHelper();
    }

    public static Event m19277b(EventCommonFragment eventCommonFragment) {
        return m19281c(eventCommonFragment).b();
    }

    public static EventCommonFragmentModel m19259a(Event event) {
        Builder builder = new Builder();
        builder.B = event.a;
        builder = builder;
        builder.G = event.b;
        builder = builder;
        builder.P = event.G;
        builder = builder;
        builder.O = event.D();
        builder = builder;
        builder.S = event.C;
        builder = builder;
        builder.L = event.K() / 1000;
        if (event.L() != null) {
            builder.j = event.M() / 1000;
        }
        if (event.L != null) {
            builder.N = event.L.getID();
        }
        EventPlaceModel.Builder builder2 = new EventPlaceModel.Builder();
        if (event.P != null) {
            builder2.g = event.P;
        }
        if (event.Q != null) {
            AddressModel.Builder builder3 = new AddressModel.Builder();
            builder3.a = event.Q;
            builder2.b = builder3.a();
        }
        builder.s = builder2.a();
        return builder.a();
    }

    public static Event m19260a(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        Event.Builder c = m19281c((EventCommonFragment) fetchEventPermalinkFragmentModel);
        if (fetchEventPermalinkFragmentModel.aa() != null) {
            c.al = (ComposerTargetDataPrivacyScopeFieldsModel) fetchEventPermalinkFragmentModel.aa();
        }
        if (fetchEventPermalinkFragmentModel.L() != null) {
            c.s = fetchEventPermalinkFragmentModel.L().b();
        }
        if (!(fetchEventPermalinkFragmentModel.S() == null || StringUtil.a(fetchEventPermalinkFragmentModel.S().b()))) {
            c.X = fetchEventPermalinkFragmentModel.S().b();
        }
        c.Z = fetchEventPermalinkFragmentModel.ab();
        return c.b();
    }

    public static Event.Builder m19281c(EventCommonFragment eventCommonFragment) {
        GraphQLEventActionStyle r;
        boolean z;
        Event.Builder builder = new Event.Builder();
        builder.a = eventCommonFragment.dL_();
        builder = builder;
        builder.b = eventCommonFragment.dM_();
        Event.Builder builder2 = builder;
        if (eventCommonFragment.z() != null) {
            builder2.c = eventCommonFragment.z();
        }
        builder2.d = eventCommonFragment.B();
        builder2.g = m19268a(eventCommonFragment.F());
        if (eventCommonFragment.k() == null || eventCommonFragment.k() == GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            builder2.l = GraphQLConnectionStyle.RSVP;
        } else {
            builder2.l = eventCommonFragment.k();
        }
        if (eventCommonFragment.r() != null) {
            r = eventCommonFragment.r();
        } else {
            r = GraphQLEventActionStyle.DEFAULT_STYLE;
        }
        builder2.m = r;
        builder2.e = m19264a(eventCommonFragment.D());
        CreatedForGroupModel v = eventCommonFragment.v();
        if (v != null) {
            builder2.q = v.b();
            builder2.r = v.c();
        }
        ParentGroupModel L = eventCommonFragment.L();
        if (L != null) {
            builder2.s = L.b();
            builder2.t = L.c();
        }
        EventCreatorModel y = eventCommonFragment.y();
        Object obj;
        if (y != null) {
            String c = y.c();
            builder2.u = c;
            obj = c;
        } else {
            obj = null;
        }
        EventHostsModel A = eventCommonFragment.A();
        if (A != null) {
            ImmutableList.Builder builder3 = new ImmutableList.Builder();
            String str = null;
            EventHostModel eventHostModel = null;
            ImmutableList a = A.a();
            int size = a.size();
            int i = 0;
            while (i < size) {
                EventHostModel eventHostModel2;
                String str2;
                EdgesModel edgesModel = (EdgesModel) a.get(i);
                if (edgesModel == null || edgesModel.a() == null) {
                    eventHostModel2 = eventHostModel;
                    str2 = str;
                } else {
                    EventHostModel a2 = edgesModel.a();
                    String b = a2.b();
                    if (!(Strings.isNullOrEmpty(b) || b.equals(r1))) {
                        if (Strings.isNullOrEmpty(str)) {
                            str = edgesModel.a().c();
                        }
                        builder3.c(b);
                    }
                    c = str;
                    if (eventHostModel == null && a2.dS_()) {
                        EventHostModel eventHostModel3 = a2;
                        str2 = c;
                        eventHostModel2 = eventHostModel3;
                    } else {
                        str2 = c;
                        eventHostModel2 = eventHostModel;
                    }
                }
                i++;
                str = str2;
                eventHostModel = eventHostModel2;
            }
            ImmutableList b2 = builder3.b();
            builder2.p = b2;
            builder2.o = b2.size();
            builder2.n = str;
            if (eventHostModel != null) {
                builder2.v = eventHostModel.b();
                if (eventHostModel.d() == null) {
                    c = null;
                } else {
                    c = eventHostModel.d().b();
                }
                builder2.w = c;
            }
        }
        builder2.x = eventCommonFragment.J();
        builder2.y = eventCommonFragment.m();
        builder2.z = eventCommonFragment.O();
        builder2.h = eventCommonFragment.s();
        builder2.i = eventCommonFragment.t();
        builder2.j = eventCommonFragment.M();
        builder2.k = eventCommonFragment.K();
        builder2.A = eventCommonFragment.j();
        builder2.B = eventCommonFragment.o();
        builder2.C = eventCommonFragment.q();
        if (eventCommonFragment.R() == GraphQLSavedState.SAVED) {
            z = true;
        } else {
            z = false;
        }
        builder2.D = z;
        if (eventCommonFragment.N() != null) {
            builder2.E = eventCommonFragment.N().b();
            builder2.F = eventCommonFragment.N().d().c();
        }
        builder2.G = eventCommonFragment.p();
        z = eventCommonFragment.g();
        builder2.K = z;
        if (EventsDateUtil.a(eventCommonFragment.dN_())) {
            Date b3 = EventsDateUtil.b(eventCommonFragment.dN_());
            builder2.H = b3;
            if (z) {
                builder2.I = new Date(b3.getTime() + 86399999);
            } else {
                builder2.I = EventsDateUtil.c(eventCommonFragment.b());
            }
            if (eventCommonFragment.n() != null) {
                builder2.J = TimeZone.getTimeZone(eventCommonFragment.n());
            }
        }
        builder2.a();
        if (eventCommonFragment.d() != null) {
            EventPlaceModel d = eventCommonFragment.d();
            if (d.c() != null) {
                builder2.O = d.c().a();
            }
            if (d.dV_() != null) {
                LocationModel dV_ = d.dV_();
                builder2.a(dV_.a(), dV_.b());
                if (dV_.c() != null) {
                    builder2.P = TimeZone.getTimeZone(dV_.c());
                }
            }
            if (!StringUtil.a(new CharSequence[]{d.g()})) {
                builder2.M = Long.parseLong(d.g());
            }
            if (!StringUtil.a(new CharSequence[]{d.dU_()})) {
                builder2.N = d.dU_();
            }
            if (d.b() != null) {
                builder2.Q = d.b().g();
            }
            if (d.d() != null) {
                if (!StringUtil.a(new CharSequence[]{d.d().a()})) {
                    builder2.R = d.d().a();
                }
            }
        }
        Object x = eventCommonFragment.x();
        if (!StringUtil.a(x)) {
            builder2.S = Uri.parse(x);
        }
        if (eventCommonFragment.c() != null) {
            x = eventCommonFragment.c().b();
            if (!StringUtil.a(x)) {
                builder2.W = Uri.parse(x);
            }
        }
        if (!(eventCommonFragment.l() == null || eventCommonFragment.l().b() == null)) {
            x = eventCommonFragment.l().b().d();
            if (!StringUtil.a(x)) {
                builder2.T = x;
            }
            if (eventCommonFragment.l().b().dO_() != null) {
                x = eventCommonFragment.l().b().dO_().b();
                if (!StringUtil.a(x)) {
                    builder2.U = Uri.parse(x);
                }
            }
            if (eventCommonFragment.l().b().dQ_() != null) {
                x = eventCommonFragment.l().b().dQ_().b();
                if (!StringUtil.a(x)) {
                    builder2.V = Uri.parse(x);
                }
            }
        }
        builder2.a(EventViewerCapabilityModelHelper.m19284a(eventCommonFragment));
        FriendEventMembersFirst5Model H = eventCommonFragment.H();
        if (!(H == null || H.b() <= 0 || H.a() == null || H.a().isEmpty())) {
            builder2.aa = ((FriendEventMembersFirst5Model.EdgesModel) H.a().get(0)).a().c();
            builder2.ab = H.b();
        }
        FriendEventMaybesFirst5Model G = eventCommonFragment.G();
        if (!(G == null || G.b() <= 0 || G.a() == null || G.a().isEmpty())) {
            builder2.ac = ((FriendEventMaybesFirst5Model.EdgesModel) G.a().get(0)).a().c();
            builder2.ad = G.b();
        }
        FriendEventWatchersFirst5Model I = eventCommonFragment.I();
        if (!(I == null || I.b() <= 0 || I.a() == null || I.a().isEmpty())) {
            builder2.ae = ((FriendEventWatchersFirst5Model.EdgesModel) I.a().get(0)).a().c();
            builder2.af = I.b();
        }
        if (!eventCommonFragment.Q().isEmpty()) {
            builder2.ag = (EventUser) m19283d(eventCommonFragment).get(0);
        }
        if (!(eventCommonFragment.w() == null || StringUtil.a(eventCommonFragment.w().a()))) {
            builder2.ah = eventCommonFragment.w().a();
        }
        return builder2;
    }

    public static Event m19278b(GraphQLNode graphQLNode) {
        GraphQLEventActionStyle m;
        boolean z;
        Uri a;
        String str = null;
        Event.Builder builder = new Event.Builder();
        builder.a = graphQLNode.dp();
        builder = builder;
        builder.b = graphQLNode.eP();
        builder = builder;
        builder.C = graphQLNode.jq();
        builder = builder;
        builder.A = graphQLNode.aC();
        builder = builder;
        builder.G = graphQLNode.jf();
        Event.Builder builder2 = builder;
        if (graphQLNode.ch() != null) {
            builder2.c = EventsConverter.a(graphQLNode.ch());
        }
        builder2.g = m19268a(graphQLNode.cq());
        if (graphQLNode.bn() == null || graphQLNode.bn() == GraphQLConnectionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            builder2.l = GraphQLConnectionStyle.RSVP;
        } else {
            builder2.l = graphQLNode.bn();
        }
        if (graphQLNode.m() != null) {
            m = graphQLNode.m();
        } else {
            m = GraphQLEventActionStyle.DEFAULT_STYLE;
        }
        builder2.m = m;
        builder2.e = m19264a(graphQLNode.co());
        GraphQLGroup bt = graphQLNode.bt();
        if (bt != null) {
            builder2.q = bt.I();
            builder2.r = bt.P();
        }
        bt = graphQLNode.fg();
        if (bt != null) {
            builder2.s = bt.I();
            builder2.t = bt.P();
        }
        GraphQLActor cg = graphQLNode.cg();
        Object obj;
        if (cg != null) {
            String H = cg.H();
            builder2.u = H;
            obj = H;
        } else {
            obj = null;
        }
        GraphQLEventHostsConnection ci = graphQLNode.ci();
        if (ci != null) {
            ImmutableList.Builder builder3 = new ImmutableList.Builder();
            ImmutableList a2 = ci.a();
            int size = a2.size();
            int i = 0;
            String str2 = null;
            GraphQLActor graphQLActor = null;
            while (i < size) {
                GraphQLActor graphQLActor2;
                GraphQLEventHostsEdge graphQLEventHostsEdge = (GraphQLEventHostsEdge) a2.get(i);
                if (!(graphQLEventHostsEdge == null || graphQLEventHostsEdge.a() == null)) {
                    GraphQLActor a3 = graphQLEventHostsEdge.a();
                    String H2 = a3.H();
                    if (!(Strings.isNullOrEmpty(H2) || H2.equals(r1))) {
                        if (Strings.isNullOrEmpty(str2)) {
                            H = graphQLEventHostsEdge.a().aa();
                        } else {
                            H = str2;
                        }
                        builder3.c(H2);
                        if (graphQLActor == null && a3.aG()) {
                            graphQLActor2 = a3;
                            i++;
                            graphQLActor = graphQLActor2;
                            str2 = H;
                        } else {
                            graphQLActor2 = graphQLActor;
                            i++;
                            graphQLActor = graphQLActor2;
                            str2 = H;
                        }
                    }
                }
                H = str2;
                graphQLActor2 = graphQLActor;
                i++;
                graphQLActor = graphQLActor2;
                str2 = H;
            }
            ImmutableList b = builder3.b();
            builder2.p = b;
            builder2.o = b.size();
            builder2.n = str2;
            if (graphQLActor != null) {
                builder2.v = graphQLActor.H();
                if (graphQLActor.ai() != null) {
                    str = graphQLActor.ai().b();
                }
                builder2.w = str;
            }
        }
        builder2.x = graphQLNode.dH();
        builder2.y = graphQLNode.dL();
        builder2.a(graphQLNode.kp());
        builder2.h = graphQLNode.aw();
        builder2.i = graphQLNode.ax();
        builder2.j = graphQLNode.fI();
        builder2.k = graphQLNode.dT();
        builder2.B = graphQLNode.je();
        if (graphQLNode.jn() == GraphQLSavedState.SAVED) {
            z = true;
        } else {
            z = false;
        }
        builder2.D = z;
        if (graphQLNode.gK() != null) {
            builder2.E = graphQLNode.gK().b();
            builder2.F = graphQLNode.gK().q().c();
        }
        z = graphQLNode.dE();
        builder2.K = z;
        if (EventsDateUtil.a(graphQLNode.hK())) {
            Date b2 = EventsDateUtil.b(graphQLNode.hK());
            builder2.H = b2;
            if (z) {
                builder2.I = new Date(b2.getTime() + 86399999);
            } else {
                builder2.I = EventsDateUtil.c(graphQLNode.bW());
            }
            if (graphQLNode.ir() != null) {
                builder2.J = TimeZone.getTimeZone(graphQLNode.ir());
            }
        }
        builder2.a();
        if (graphQLNode.cl() != null) {
            GraphQLPlace cl = graphQLNode.cl();
            if (cl.k() != null) {
                builder2.O = cl.k().m();
            }
            if (cl.z() != null) {
                GraphQLLocation z2 = cl.z();
                builder2.a(z2.a(), z2.b());
                if (z2.j() != null) {
                    builder2.P = TimeZone.getTimeZone(z2.j());
                }
            }
            if (!StringUtil.a(new CharSequence[]{cl.x()})) {
                builder2.b(Long.parseLong(cl.x()));
            }
            if (!StringUtil.a(new CharSequence[]{cl.B()})) {
                builder2.N = cl.B();
            }
            if (cl.q() != null) {
                if (!StringUtil.a(new CharSequence[]{cl.q().L()})) {
                    builder2.R = cl.q().L();
                }
            }
        }
        Object cd = graphQLNode.cd();
        if (!StringUtil.a(cd)) {
            builder2.S = Uri.parse(cd);
        }
        if (graphQLNode.cc() != null) {
            a = ImageUtil.a(graphQLNode.cc());
            if (a != null) {
                builder2.W = a;
            }
        }
        if (!(graphQLNode.br() == null || graphQLNode.br().j() == null)) {
            cd = graphQLNode.br().j().K();
            if (!StringUtil.a(cd)) {
                builder2.T = cd;
            }
            if (graphQLNode.br().j().aa() != null) {
                a = ImageUtil.a(graphQLNode.br().j().aa());
                if (a != null) {
                    builder2.U = a;
                }
            }
            if (graphQLNode.br().j().Q() != null) {
                a = ImageUtil.a(graphQLNode.br().j().Q());
                if (a != null) {
                    builder2.V = a;
                }
            }
        }
        builder2.a(EventViewerCapabilityModelHelper.m19285a(graphQLNode));
        GraphQLEventMembersConnection cR = graphQLNode.cR();
        if (!(cR == null || cR.m() <= 0 || cR.j() == null || cR.j().isEmpty())) {
            builder2.aa = ((GraphQLEventMembersEdge) cR.j().get(0)).a().aa();
            builder2.ab = cR.m();
        }
        GraphQLEventMaybesConnection cQ = graphQLNode.cQ();
        if (!(cQ == null || cQ.l() <= 0 || cQ.j() == null || cQ.j().isEmpty())) {
            builder2.ac = ((GraphQLEventMaybesEdge) cQ.j().get(0)).a().aa();
            builder2.ad = cQ.l();
        }
        GraphQLEventWatchersConnection cS = graphQLNode.cS();
        if (!(cS == null || cS.m() <= 0 || cS.j() == null || cS.j().isEmpty())) {
            builder2.ae = ((GraphQLEventWatchersEdge) cS.j().get(0)).a().aa();
            builder2.af = cS.m();
        }
        if (!graphQLNode.jh().isEmpty()) {
            builder2.ag = (EventUser) m19282c(graphQLNode).get(0);
        }
        if (!(graphQLNode.cb() == null || StringUtil.a(graphQLNode.cb().j()))) {
            builder2.ah = graphQLNode.cb().j();
        }
        return builder2.b();
    }

    private static PrivacyType m19268a(GraphQLEventVisibility graphQLEventVisibility) {
        if (graphQLEventVisibility == null) {
            return null;
        }
        switch (C26991.f19057a[graphQLEventVisibility.ordinal()]) {
            case 1:
                return PrivacyType.FRIENDS_OF_FRIENDS;
            case 2:
                return PrivacyType.FRIENDS_OF_GUESTS;
            case 3:
                return PrivacyType.GROUP;
            case 4:
                return PrivacyType.PAGE;
            case 5:
                return PrivacyType.USER_PUBLIC;
            default:
                return PrivacyType.INVITE_ONLY;
        }
    }

    private static EventType m19264a(GraphQLEventType graphQLEventType) {
        if (graphQLEventType == null) {
            return null;
        }
        switch (C26991.f19058b[graphQLEventType.ordinal()]) {
            case 1:
                return EventType.QUICK_INVITE;
            default:
                return EventType.NORMAL;
        }
    }

    private static Uri m19276b(NodeModel nodeModel) {
        TicketProviderPageModel eh_ = nodeModel.eh_();
        return (eh_ == null || eh_.c() == null || Strings.isNullOrEmpty(eh_.c().b())) ? null : Uri.parse(eh_.c().b());
    }

    public static ImmutableList<EventTicketInfo> m19272a(FetchEventPermalinkFragment.EventTicketInfo eventTicketInfo) {
        if (eventTicketInfo == null) {
            return RegularImmutableList.a;
        }
        ImmutableList a = eventTicketInfo.a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodeModel a2 = ((EventTicketInfoModel.EdgesModel) a.get(i)).a();
            if (a2 != null) {
                boolean z;
                String b;
                Uri uri;
                Object obj;
                Price a3 = m19263a(a2.g());
                Price a4 = m19262a(a2.ei_());
                GraphQLEventTicketProviderType j = a2.j();
                boolean z2 = j == null || j == GraphQLEventTicketProviderType.RESALE;
                EventTicketInfo.Builder builder = new EventTicketInfo.Builder();
                builder.a = SystemClock.a;
                builder = builder;
                builder.m = a2.b();
                builder = builder;
                builder.b = a3;
                EventTicketInfo.Builder builder2 = builder;
                builder2.c = a4;
                builder2 = builder2;
                builder2.d = a2.c();
                builder2 = builder2;
                builder2.e = a2.d();
                builder2 = builder2;
                builder2.f = a2.l();
                EventTicketInfo.Builder builder3 = builder2;
                if (j == GraphQLEventTicketProviderType.PRIMARY) {
                    z = true;
                } else {
                    z = false;
                }
                builder3.g = z;
                builder3 = builder3;
                if (j == GraphQLEventTicketProviderType.OFFICIAL) {
                    z = true;
                } else {
                    z = false;
                }
                builder3.h = z;
                builder2 = builder3;
                builder2.i = z2;
                EventTicketInfo.Builder builder4 = builder2;
                TicketProviderPageModel eh_ = a2.eh_();
                if (eh_ != null && !Strings.isNullOrEmpty(eh_.b())) {
                    b = eh_.b();
                } else if (Strings.isNullOrEmpty(a2.eg_())) {
                    b = null;
                } else {
                    b = a2.eg_();
                }
                builder4.j = b;
                builder2 = builder4;
                if (Strings.isNullOrEmpty(a2.k())) {
                    uri = null;
                } else {
                    uri = Uri.parse(a2.k());
                }
                builder2.k = uri;
                builder4 = builder2;
                builder4.l = m19276b(a2);
                EventTicketInfo a5 = builder4.a();
                if ((a5.l != null && !Strings.isNullOrEmpty(a5.l.toString())) || a5.p() || a5.f()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return ImmutableList.of(a5);
                }
            }
        }
        return RegularImmutableList.a;
    }

    private static Price m19263a(MinTicketPriceModel minTicketPriceModel) {
        return (minTicketPriceModel == null || minTicketPriceModel.b() == null) ? null : new Price(minTicketPriceModel.a(), minTicketPriceModel.c(), minTicketPriceModel.b());
    }

    private static Price m19262a(MaxTicketPriceModel maxTicketPriceModel) {
        return (maxTicketPriceModel == null || maxTicketPriceModel.b() == null) ? null : new Price(maxTicketPriceModel.a(), maxTicketPriceModel.c(), maxTicketPriceModel.b());
    }

    public static ImmutableList<EventArtist> m19273a(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        EventCategoryInfoModel am = fetchEventPermalinkFragmentModel.am();
        if (am == null) {
            return RegularImmutableList.a;
        }
        ImmutableList j;
        ImmutableList j2 = am.j();
        int size = j2.size();
        for (int i = 0; i < size; i++) {
            RoleAssociatedEdgesModel roleAssociatedEdgesModel = (RoleAssociatedEdgesModel) j2.get(i);
            if ("Line Up".equalsIgnoreCase(roleAssociatedEdgesModel.a())) {
                j = roleAssociatedEdgesModel.j();
                break;
            }
        }
        j = null;
        if (j == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size2 = j.size();
        for (int i2 = 0; i2 < size2; i2++) {
            builder.c(m19261a((EventArtistPageDetailsFragmentModel) j.get(i2)));
        }
        return builder.b();
    }

    public static EventArtist m19261a(EventArtistPageDetailsFragmentModel eventArtistPageDetailsFragmentModel) {
        String str;
        String a;
        int a2;
        DefaultImageFieldsModel o = eventArtistPageDetailsFragmentModel.o();
        PageLikersModel n = eventArtistPageDetailsFragmentModel.n();
        EventArtist.Builder builder = new EventArtist.Builder();
        builder.b = eventArtistPageDetailsFragmentModel.k();
        builder = builder;
        builder.a = eventArtistPageDetailsFragmentModel.l();
        builder = builder;
        if (o == null) {
            str = null;
        } else {
            str = o.b();
        }
        builder.c = str;
        EventArtist.Builder builder2 = builder;
        builder2.d = eventArtistPageDetailsFragmentModel.j();
        builder2 = builder2;
        ImmutableList m = eventArtistPageDetailsFragmentModel.m();
        int size = m.size();
        loop0:
        for (int i = 0; i < size; i++) {
            ImmutableList a3 = ((PageInfoSectionsModel) m.get(i)).a();
            int size2 = a3.size();
            for (int i2 = 0; i2 < size2; i2++) {
                FieldsModel fieldsModel = (FieldsModel) a3.get(i2);
                if ("Genre".equals(fieldsModel.a()) && fieldsModel.j() != null && !Strings.isNullOrEmpty(fieldsModel.j().a())) {
                    a = fieldsModel.j().a();
                    break loop0;
                }
            }
        }
        a = null;
        builder2.f = a;
        builder = builder2;
        if (n != null) {
            a2 = n.a();
        } else {
            a2 = 0;
        }
        builder.e = a2;
        return new EventArtist(builder);
    }

    private static ImmutableList<EventUser> m19283d(EventCommonFragment eventCommonFragment) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList Q = eventCommonFragment.Q();
        int size = Q.size();
        for (int i = 0; i < size; i++) {
            builder.c(m19265a((UserInEventFragment) Q.get(i), EventUserType.USER));
        }
        return builder.b();
    }

    private static ImmutableList<EventUser> m19282c(GraphQLNode graphQLNode) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList jh = graphQLNode.jh();
        int size = jh.size();
        for (int i = 0; i < size; i++) {
            String str;
            GraphQLActor graphQLActor = (GraphQLActor) jh.get(i);
            EventUserType eventUserType = EventUserType.USER;
            GraphQLImage ai = graphQLActor.ai();
            EventUser.Builder builder2 = new EventUser.Builder();
            builder2.c = graphQLActor.H();
            builder2 = builder2;
            builder2.b = graphQLActor.aa();
            builder2 = builder2;
            if (ai == null) {
                str = null;
            } else {
                str = ai.b();
            }
            builder2.d = str;
            EventUser.Builder builder3 = builder2;
            builder3.h = graphQLActor.E();
            builder3 = builder3;
            builder3.a = eventUserType;
            builder.c(builder3.a());
        }
        return builder.b();
    }

    public static ImmutableList<EventUser> m19279b(FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        int i = 0;
        EventHostsModel au = fetchEventPermalinkFragmentModel.au();
        if (au == null) {
            return RegularImmutableList.a;
        }
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList a = au.a();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            UserInEventFragment j = ((EdgesModel) a.get(i2)).j();
            if (j != null && m19275a(j, 2479791)) {
                builder.c(m19265a(j, EventUserType.PAGE));
            }
        }
        ImmutableList<EventUser> b = builder.b();
        if (!b.isEmpty()) {
            return b;
        }
        ImmutableList.Builder builder2 = new ImmutableList.Builder();
        ImmutableList a2 = au.a();
        int size2 = a2.size();
        while (i < size2) {
            j = ((EdgesModel) a2.get(i)).j();
            if (j != null && m19275a(j, 2645995)) {
                builder2.c(m19265a(j, EventUserType.USER));
            }
            i++;
        }
        return builder2.b();
    }

    private static EventUser m19265a(UserInEventFragment userInEventFragment, EventUserType eventUserType) {
        String str;
        DefaultImageFields d = userInEventFragment.d();
        EventUser.Builder builder = new EventUser.Builder();
        builder.c = userInEventFragment.b();
        builder = builder;
        builder.b = userInEventFragment.c();
        builder = builder;
        if (d == null) {
            str = null;
        } else {
            str = d.b();
        }
        builder.d = str;
        EventUser.Builder builder2 = builder;
        builder2.h = userInEventFragment.dR_();
        builder2 = builder2;
        builder2.a = eventUserType;
        return builder2.a();
    }

    private static boolean m19275a(UserInEventFragment userInEventFragment, int i) {
        return (userInEventFragment == null || userInEventFragment.g() == null || userInEventFragment.g().g() != i) ? false : true;
    }

    public static ImmutableListMultimap<DateBucket, EventUser> m19274a(ImmutableList<EventAllGuestsEdgeFragmentModel> immutableList, String str, long j) {
        ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            EventAllGuestsEdgeFragmentModel eventAllGuestsEdgeFragmentModel = (EventAllGuestsEdgeFragmentModel) immutableList.get(i);
            EventUser a = m19266a(eventAllGuestsEdgeFragmentModel.a(), eventAllGuestsEdgeFragmentModel.k());
            if (!Objects.equal(a.b, str)) {
                builder.a(m19269a(eventAllGuestsEdgeFragmentModel.j(), j), a);
            }
        }
        return builder.a();
    }

    public static ImmutableListMultimap<DateBucket, EventUser> m19280b(ImmutableList<AllEventDeclinesModel.EdgesModel> immutableList, String str, long j) {
        ImmutableListMultimap.Builder builder = new ImmutableListMultimap.Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            AllEventDeclinesModel.EdgesModel edgesModel = (AllEventDeclinesModel.EdgesModel) immutableList.get(i);
            UserInEventWithMutualFriendsFragmentModel j2 = edgesModel.j();
            GraphQLEventSeenState l = edgesModel.l();
            boolean a = edgesModel.a();
            EventUser.Builder builder2 = new EventUser.Builder(m19266a(j2, l));
            builder2.j = a;
            EventUser a2 = builder2.a();
            if (!Objects.equal(a2.b, str)) {
                builder.a(m19269a(edgesModel.k(), j), a2);
            }
        }
        return builder.a();
    }

    @VisibleForTesting
    private static DateBucket m19269a(long j, long j2) {
        long j3 = j2 - (1000 * j);
        if (j3 <= 86399999) {
            return DateBucket.TODAY;
        }
        if (j3 <= 172799999) {
            return DateBucket.YESTERDAY;
        }
        return DateBucket.EARLIER;
    }

    public static EventUser m19266a(UserInEventWithMutualFriendsFragmentModel userInEventWithMutualFriendsFragmentModel, GraphQLEventSeenState graphQLEventSeenState) {
        int i;
        String str;
        DefaultImageFieldsModel k = userInEventWithMutualFriendsFragmentModel.k();
        MutualFriendsModel j = userInEventWithMutualFriendsFragmentModel.j();
        EventUser.Builder builder = new EventUser.Builder();
        builder.c = userInEventWithMutualFriendsFragmentModel.b();
        builder = builder;
        builder.b = userInEventWithMutualFriendsFragmentModel.c();
        builder = builder;
        if (j == null) {
            i = 0;
        } else {
            i = j.a();
        }
        builder.g = i;
        builder = builder;
        if (k == null) {
            str = null;
        } else {
            str = k.b();
        }
        builder.d = str;
        EventUser.Builder builder2 = builder;
        builder2.a = EventUserType.USER;
        builder2 = builder2;
        builder2.h = userInEventWithMutualFriendsFragmentModel.dR_();
        builder2 = builder2;
        if (graphQLEventSeenState != null) {
            builder2.i = graphQLEventSeenState;
        }
        return builder2.a();
    }

    public static EventUser m19267a(String str, EventUserType eventUserType, Resources resources) {
        EventUser.Builder builder = new EventUser.Builder();
        builder.b = resources.getString(2131241634);
        builder = builder;
        builder.c = str;
        builder = builder;
        builder.a = eventUserType;
        return builder.a();
    }
}
