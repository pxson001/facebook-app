package com.facebook.events.permalink.guestlist;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.events.graphql.EventsGraphQL.EventAllDeclinesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventAllMaybesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventAllMembersQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventEmailDeclinesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventEmailInviteesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventEmailMaybesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventEmailMembersQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventFriendDeclinesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventFriendInviteesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventFriendMaybesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventFriendMembersQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventFriendWatchersQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventOtherDeclinesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventOtherInviteesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventOtherMaybesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventOtherMembersQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventOtherWatchersQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSMSDeclinesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSMSInviteesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSMSMaybesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSMSMembersQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllDeclinesQueryModel.AllEventDeclinesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventAllGuestsFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailGuestFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailGuestFragmentModel.NodesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventEmailGuestFragmentModel.NodesModel.ProfilePictureModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventFriendGuestFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventNonFriendGuestFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSMSGuestFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.PublicEventGuestFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.PublicEventGuestFragmentModel.EdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.PublicEventGuestFragmentModel.PageInfoModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventUser;
import com.facebook.events.model.EventUser.EventUserType;
import com.facebook.events.permalink.guestlist.EventGuestListSection.Type;
import com.facebook.events.permalink.guestlist.common.EventGuestListType;
import com.facebook.events.permalink.guestlist.common.EventsGuestListInitializationModel;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLEventGuestStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.User;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: bot_composer_quick_replies */
public class EventGuestListPager implements FutureCallback<GraphQLResult> {
    protected String f18400a = null;
    private EventGuestListPageListener f18401b;
    public EventGuestListType f18402c;
    private ImmutableList<EventGuestListSection> f18403d;
    public PageState f18404e = PageState.INITIAL;
    private int f18405f;
    private int f18406g;
    private EventGuestListSection f18407h;
    private ListenableFuture<GraphQLResult> f18408i = null;
    private final GraphQLQueryExecutor f18409j;
    @ForUiThread
    private final ListeningScheduledExecutorService f18410k;
    private final GatekeeperStoreImpl f18411l;
    private String f18412m;
    private boolean f18413n;
    private Context f18414o;
    private User f18415p;
    private long f18416q;
    private boolean f18417r;

    /* compiled from: bot_composer_quick_replies */
    /* synthetic */ class C26121 {
        static final /* synthetic */ int[] f18398a = new int[EventGuestListType.values().length];

        static {
            f18399b = new int[Type.values().length];
            try {
                f18399b[Type.FRIENDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18399b[Type.NON_FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18399b[Type.EMAILS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18399b[Type.SMS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18399b[Type.TODAY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18399b[Type.YESTERDAY.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18399b[Type.EARLIER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f18398a[EventGuestListType.PRIVATE_GOING.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f18398a[EventGuestListType.PUBLIC_GOING.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f18398a[EventGuestListType.PRIVATE_MAYBE.ordinal()] = 3;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f18398a[EventGuestListType.PUBLIC_WATCHED.ordinal()] = 4;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f18398a[EventGuestListType.PRIVATE_INVITED.ordinal()] = 5;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f18398a[EventGuestListType.PUBLIC_INVITED.ordinal()] = 6;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f18398a[EventGuestListType.PRIVATE_NOT_GOING.ordinal()] = 7;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* compiled from: bot_composer_quick_replies */
    public enum PageState {
        INITIAL,
        PAGING,
        ERROR,
        COMPLETE
    }

    public static EventGuestListPager m18756b(InjectorLike injectorLike) {
        return new EventGuestListPager(IdBasedProvider.a(injectorLike, 3595), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public void onSuccess(Object obj) {
        this.f18400a = m18751a(((GraphQLResult) obj).e);
        this.f18404e = this.f18400a == null ? PageState.COMPLETE : PageState.PAGING;
        this.f18408i = null;
        if (this.f18404e == PageState.COMPLETE) {
            m18769c();
        } else {
            this.f18401b.mo839a(this.f18402c);
        }
    }

    @Inject
    public EventGuestListPager(Provider<User> provider, GatekeeperStore gatekeeperStore, GraphQLQueryExecutor graphQLQueryExecutor, ListeningScheduledExecutorService listeningScheduledExecutorService, Context context, Clock clock) {
        this.f18415p = (User) provider.get();
        this.f18411l = gatekeeperStore;
        this.f18409j = graphQLQueryExecutor;
        this.f18410k = listeningScheduledExecutorService;
        this.f18414o = context;
        this.f18416q = clock.a();
    }

    public final void m18765a(EventsGuestListInitializationModel eventsGuestListInitializationModel, EventGuestListType eventGuestListType, EventGuestListPageListener eventGuestListPageListener, Boolean bool) {
        boolean z;
        boolean z2 = false;
        this.f18412m = eventsGuestListInitializationModel.b;
        this.f18413n = eventsGuestListInitializationModel.g;
        this.f18402c = eventGuestListType;
        this.f18401b = eventGuestListPageListener;
        this.f18417r = bool.booleanValue();
        if (Event.a(eventsGuestListInitializationModel.e()) && Event.a(eventsGuestListInitializationModel.d())) {
            GraphQLEventGuestStatus graphQLEventGuestStatus;
            Object obj;
            if (eventsGuestListInitializationModel.f != null) {
                graphQLEventGuestStatus = eventsGuestListInitializationModel.f;
            } else {
                graphQLEventGuestStatus = GraphQLEventGuestStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
            }
            GraphQLEventGuestStatus graphQLEventGuestStatus2 = graphQLEventGuestStatus;
            if ((graphQLEventGuestStatus2 == GraphQLEventGuestStatus.GOING && this.f18402c == EventGuestListType.PRIVATE_GOING) || ((graphQLEventGuestStatus2 == GraphQLEventGuestStatus.INVITED && this.f18402c == EventGuestListType.PRIVATE_INVITED) || ((graphQLEventGuestStatus2 == GraphQLEventGuestStatus.MAYBE && this.f18402c == EventGuestListType.PRIVATE_MAYBE) || (graphQLEventGuestStatus2 == GraphQLEventGuestStatus.NOT_GOING && this.f18402c == EventGuestListType.PRIVATE_NOT_GOING)))) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                z = true;
                if (Event.a(eventsGuestListInitializationModel.e()) && this.f18413n && Event.a(eventsGuestListInitializationModel.d()) && this.f18402c != EventGuestListType.PRIVATE_INVITED) {
                    z2 = true;
                }
                m18755a(z, z2, this.f18411l.a(647, true), this.f18411l.a(648, true));
            }
        }
        z = false;
        z2 = true;
        m18755a(z, z2, this.f18411l.a(647, true), this.f18411l.a(648, true));
    }

    public final void m18766a(String str, Boolean bool, EventGuestListType eventGuestListType, EventGuestListPageListener eventGuestListPageListener) {
        this.f18412m = str;
        this.f18413n = bool.booleanValue();
        this.f18402c = eventGuestListType;
        this.f18401b = eventGuestListPageListener;
        this.f18417r = false;
        m18755a(false, false, false, false);
    }

    private void m18755a(boolean z, boolean z2, boolean z3, boolean z4) {
        Resources resources = this.f18414o.getResources();
        Builder builder = new Builder();
        if (z) {
            m18743a(builder, false, null, Collections.singletonList(Type.SELF));
        }
        if (z2) {
            this.f18407h = m18742a(builder, resources.getString(2131237091), Type.TODAY);
            m18742a(builder, resources.getString(2131237092), Type.YESTERDAY);
            m18742a(builder, resources.getString(2131237093), Type.EARLIER);
            m18753a(builder, z3, z4);
        } else {
            m18742a(builder, resources.getString(2131237088), Type.FRIENDS);
            m18742a(builder, resources.getString(2131237089), Type.NON_FRIENDS);
            m18753a(builder, z3, z4);
        }
        this.f18403d = builder.b();
    }

    private void m18753a(Builder<EventGuestListSection> builder, boolean z, boolean z2) {
        List arrayList = new ArrayList();
        if (z) {
            arrayList.add(Type.EMAILS);
        }
        if (z2) {
            arrayList.add(Type.SMS);
        }
        if (!arrayList.isEmpty()) {
            m18743a((Builder) builder, false, this.f18414o.getResources().getString(2131237090), arrayList);
        }
    }

    private static EventGuestListSection m18743a(Builder<EventGuestListSection> builder, boolean z, String str, List<Type> list) {
        EventGuestListSection eventMutableGuestListSection = z ? new EventMutableGuestListSection(str, list) : new EventImmutableGuestListSection(str, list);
        builder.c(eventMutableGuestListSection);
        return eventMutableGuestListSection;
    }

    private EventGuestListSection m18742a(Builder<EventGuestListSection> builder, String str, Type type) {
        return m18743a((Builder) builder, this.f18417r, str, Collections.singletonList(type));
    }

    public final void m18768b(List<EventUser> list) {
        if (this.f18404e != PageState.INITIAL && this.f18407h != null && (this.f18407h instanceof EventMutableGuestListSection)) {
            EventMutableGuestListSection.m18839a((List) list, this.f18403d);
            EventMutableGuestListSection eventMutableGuestListSection = (EventMutableGuestListSection) this.f18407h;
            for (EventUser addFirst : list) {
                ((LinkedList) eventMutableGuestListSection.f18465a).addFirst(addFirst);
            }
            m18764l();
        }
    }

    private EventGuestListSection m18757e() {
        return this.f18405f < this.f18403d.size() ? (EventGuestListSection) this.f18403d.get(this.f18405f) : null;
    }

    private Type m18758f() {
        EventGuestListSection e = m18757e();
        if (e == null) {
            return null;
        }
        int i = this.f18406g;
        return i < e.f18466b.size() ? (Type) e.f18466b.get(i) : null;
    }

    public final void m18769c() {
        if (this.f18408i == null) {
            if (this.f18404e == PageState.COMPLETE || this.f18404e == PageState.ERROR) {
                m18759g();
                if (m18758f() == null) {
                    this.f18401b.mo841a(false);
                    this.f18401b.mo839a(this.f18402c);
                    return;
                }
            }
            if (m18760h() != null) {
                this.f18401b.mo841a(true);
                this.f18408i = this.f18409j.a(GraphQLRequest.a(m18760h()).a(GraphQLCachePolicy.c).a(m18761i()));
                Futures.a(this.f18408i, this, this.f18410k);
                return;
            }
            if (m18758f() == Type.SELF) {
                m18763k();
            }
            this.f18404e = PageState.COMPLETE;
            m18769c();
        }
    }

    private void m18759g() {
        this.f18406g++;
        if (m18758f() == null) {
            this.f18406g = 0;
            this.f18405f++;
        }
    }

    private TypedGraphQlQueryString m18760h() {
        switch (m18758f()) {
            case FRIENDS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                    case 2:
                        return new EventFriendMembersQueryString();
                    case 3:
                        return new EventFriendMaybesQueryString();
                    case 4:
                        return new EventFriendWatchersQueryString();
                    case 5:
                    case 6:
                        return new EventFriendInviteesQueryString();
                    case 7:
                        return new EventFriendDeclinesQueryString();
                    default:
                        break;
                }
            case NON_FRIENDS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                    case 2:
                        return new EventOtherMembersQueryString();
                    case 3:
                        return new EventOtherMaybesQueryString();
                    case 4:
                        return new EventOtherWatchersQueryString();
                    case 5:
                    case 6:
                        return new EventOtherInviteesQueryString();
                    case 7:
                        return new EventOtherDeclinesQueryString();
                    default:
                        break;
                }
            case EMAILS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                        return new EventEmailMembersQueryString();
                    case 3:
                        return new EventEmailMaybesQueryString();
                    case 5:
                        return new EventEmailInviteesQueryString();
                    case 7:
                        return new EventEmailDeclinesQueryString();
                    default:
                        break;
                }
            case SMS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                        return new EventSMSMembersQueryString();
                    case 3:
                        return new EventSMSMaybesQueryString();
                    case 5:
                        return new EventSMSInviteesQueryString();
                    case 7:
                        return new EventSMSDeclinesQueryString();
                    default:
                        break;
                }
            case TODAY:
            case YESTERDAY:
            case EARLIER:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                        return new EventAllMembersQueryString();
                    case 3:
                        return new EventAllMaybesQueryString();
                    case 7:
                        return new EventAllDeclinesQueryString();
                    default:
                        break;
                }
        }
        return null;
    }

    private GraphQlQueryParamSet m18761i() {
        switch (m18758f()) {
            case FRIENDS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                    case 2:
                        EventFriendMembersQueryString eventFriendMembersQueryString = new EventFriendMembersQueryString();
                        eventFriendMembersQueryString.a("event_id", this.f18412m);
                        eventFriendMembersQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventFriendMembersQueryString.a("after_cursor", this.f18400a);
                        }
                        eventFriendMembersQueryString.a("first_count", "20");
                        return eventFriendMembersQueryString.a;
                    case 3:
                        EventFriendMaybesQueryString eventFriendMaybesQueryString = new EventFriendMaybesQueryString();
                        eventFriendMaybesQueryString.a("event_id", this.f18412m);
                        eventFriendMaybesQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventFriendMaybesQueryString.a("after_cursor", this.f18400a);
                        }
                        eventFriendMaybesQueryString.a("first_count", "20");
                        return eventFriendMaybesQueryString.a;
                    case 4:
                        EventFriendWatchersQueryString eventFriendWatchersQueryString = new EventFriendWatchersQueryString();
                        eventFriendWatchersQueryString.a("event_id", this.f18412m);
                        eventFriendWatchersQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventFriendWatchersQueryString.a("after_cursor", this.f18400a);
                        }
                        eventFriendWatchersQueryString.a("first_count", "20");
                        return eventFriendWatchersQueryString.a;
                    case 5:
                    case 6:
                        EventFriendInviteesQueryString eventFriendInviteesQueryString = new EventFriendInviteesQueryString();
                        eventFriendInviteesQueryString.a("event_id", this.f18412m);
                        eventFriendInviteesQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventFriendInviteesQueryString.a("after_cursor", this.f18400a);
                        }
                        eventFriendInviteesQueryString.a("first_count", "20");
                        return eventFriendInviteesQueryString.a;
                    case 7:
                        EventFriendDeclinesQueryString eventFriendDeclinesQueryString = new EventFriendDeclinesQueryString();
                        eventFriendDeclinesQueryString.a("event_id", this.f18412m);
                        eventFriendDeclinesQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventFriendDeclinesQueryString.a("after_cursor", this.f18400a);
                        }
                        eventFriendDeclinesQueryString.a("first_count", "20");
                        return eventFriendDeclinesQueryString.a;
                    default:
                        break;
                }
            case NON_FRIENDS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                    case 2:
                        EventOtherMembersQueryString eventOtherMembersQueryString = new EventOtherMembersQueryString();
                        eventOtherMembersQueryString.a("event_id", this.f18412m);
                        eventOtherMembersQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventOtherMembersQueryString.a("after_cursor", this.f18400a);
                        }
                        eventOtherMembersQueryString.a("first_count", "20");
                        return eventOtherMembersQueryString.a;
                    case 3:
                        EventOtherMaybesQueryString eventOtherMaybesQueryString = new EventOtherMaybesQueryString();
                        eventOtherMaybesQueryString.a("event_id", this.f18412m);
                        eventOtherMaybesQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventOtherMaybesQueryString.a("after_cursor", this.f18400a);
                        }
                        eventOtherMaybesQueryString.a("first_count", "20");
                        return eventOtherMaybesQueryString.a;
                    case 4:
                        EventOtherWatchersQueryString eventOtherWatchersQueryString = new EventOtherWatchersQueryString();
                        eventOtherWatchersQueryString.a("event_id", this.f18412m);
                        eventOtherWatchersQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventOtherWatchersQueryString.a("after_cursor", this.f18400a);
                        }
                        eventOtherWatchersQueryString.a("first_count", "20");
                        return eventOtherWatchersQueryString.a;
                    case 5:
                    case 6:
                        EventOtherInviteesQueryString eventOtherInviteesQueryString = new EventOtherInviteesQueryString();
                        eventOtherInviteesQueryString.a("event_id", this.f18412m);
                        eventOtherInviteesQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventOtherInviteesQueryString.a("after_cursor", this.f18400a);
                        }
                        eventOtherInviteesQueryString.a("first_count", "20");
                        return eventOtherInviteesQueryString.a;
                    case 7:
                        EventOtherDeclinesQueryString eventOtherDeclinesQueryString = new EventOtherDeclinesQueryString();
                        eventOtherDeclinesQueryString.a("event_id", this.f18412m);
                        eventOtherDeclinesQueryString.a("profile_image_size", m18762j());
                        if (this.f18400a != null) {
                            eventOtherDeclinesQueryString.a("after_cursor", this.f18400a);
                        }
                        eventOtherDeclinesQueryString.a("first_count", "20");
                        return eventOtherDeclinesQueryString.a;
                    default:
                        break;
                }
            case EMAILS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                        EventEmailMembersQueryString eventEmailMembersQueryString = new EventEmailMembersQueryString();
                        eventEmailMembersQueryString.a("event_id", this.f18412m);
                        eventEmailMembersQueryString.a("profile_pic_size", m18762j());
                        return eventEmailMembersQueryString.a;
                    case 3:
                        EventEmailMaybesQueryString eventEmailMaybesQueryString = new EventEmailMaybesQueryString();
                        eventEmailMaybesQueryString.a("event_id", this.f18412m);
                        eventEmailMaybesQueryString.a("profile_pic_size", m18762j());
                        return eventEmailMaybesQueryString.a;
                    case 5:
                        EventEmailInviteesQueryString eventEmailInviteesQueryString = new EventEmailInviteesQueryString();
                        eventEmailInviteesQueryString.a("event_id", this.f18412m);
                        eventEmailInviteesQueryString.a("profile_pic_size", m18762j());
                        return eventEmailInviteesQueryString.a;
                    case 7:
                        EventEmailDeclinesQueryString eventEmailDeclinesQueryString = new EventEmailDeclinesQueryString();
                        eventEmailDeclinesQueryString.a("event_id", this.f18412m);
                        eventEmailDeclinesQueryString.a("profile_pic_size", m18762j());
                        return eventEmailDeclinesQueryString.a;
                    default:
                        break;
                }
            case SMS:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                        EventSMSMembersQueryString eventSMSMembersQueryString = new EventSMSMembersQueryString();
                        eventSMSMembersQueryString.a("event_id", this.f18412m);
                        eventSMSMembersQueryString.a("profile_pic_size", m18762j());
                        return eventSMSMembersQueryString.a;
                    case 3:
                        EventSMSMaybesQueryString eventSMSMaybesQueryString = new EventSMSMaybesQueryString();
                        eventSMSMaybesQueryString.a("event_id", this.f18412m);
                        eventSMSMaybesQueryString.a("profile_pic_size", m18762j());
                        return eventSMSMaybesQueryString.a;
                    case 5:
                        EventSMSInviteesQueryString eventSMSInviteesQueryString = new EventSMSInviteesQueryString();
                        eventSMSInviteesQueryString.a("event_id", this.f18412m);
                        eventSMSInviteesQueryString.a("profile_pic_size", m18762j());
                        return eventSMSInviteesQueryString.a;
                    case 7:
                        EventSMSDeclinesQueryString eventSMSDeclinesQueryString = new EventSMSDeclinesQueryString();
                        eventSMSDeclinesQueryString.a("event_id", this.f18412m);
                        eventSMSDeclinesQueryString.a("profile_pic_size", m18762j());
                        return eventSMSDeclinesQueryString.a;
                    default:
                        break;
                }
            case TODAY:
            case YESTERDAY:
            case EARLIER:
                switch (C26121.f18398a[this.f18402c.ordinal()]) {
                    case 1:
                        EventAllMembersQueryString eventAllMembersQueryString = new EventAllMembersQueryString();
                        eventAllMembersQueryString.a("event_id", this.f18412m);
                        eventAllMembersQueryString.a("profile_image_size", m18762j());
                        return eventAllMembersQueryString.a;
                    case 3:
                        EventAllMaybesQueryString eventAllMaybesQueryString = new EventAllMaybesQueryString();
                        eventAllMaybesQueryString.a("event_id", this.f18412m);
                        eventAllMaybesQueryString.a("profile_image_size", m18762j());
                        return eventAllMaybesQueryString.a;
                    case 7:
                        EventAllDeclinesQueryString eventAllDeclinesQueryString = new EventAllDeclinesQueryString();
                        eventAllDeclinesQueryString.a("event_id", this.f18412m);
                        eventAllDeclinesQueryString.a("profile_image_size", m18762j());
                        return eventAllDeclinesQueryString.a;
                    default:
                        break;
                }
        }
        return null;
    }

    private String m18762j() {
        return Integer.toString(this.f18414o.getResources().getDimensionPixelSize(2131431132));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m18751a(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18399b;
        r2 = r4.m18758f();
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0014;
            case 2: goto L_0x005a;
            case 3: goto L_0x0068;
            case 4: goto L_0x0076;
            case 5: goto L_0x0084;
            case 6: goto L_0x0084;
            case 7: goto L_0x0084;
            default: goto L_0x0013;
        };
    L_0x0013:
        goto L_0x0003;
    L_0x0014:
        r1 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18398a;
        r3 = r4.f18402c;
        r2 = r3;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0023;
            case 2: goto L_0x0023;
            case 3: goto L_0x002e;
            case 4: goto L_0x0039;
            case 5: goto L_0x0044;
            case 6: goto L_0x0044;
            case 7: goto L_0x004f;
            default: goto L_0x0022;
        };
    L_0x0022:
        goto L_0x0003;
    L_0x0023:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventFriendMembersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18747a(r0);
        goto L_0x0003;
    L_0x002e:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventFriendMaybesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18747a(r0);
        goto L_0x0003;
    L_0x0039:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventFriendWatchersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18750a(r0);
        goto L_0x0003;
    L_0x0044:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventFriendInviteesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18747a(r0);
        goto L_0x0003;
    L_0x004f:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventFriendDeclinesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18747a(r0);
        goto L_0x0003;
    L_0x005a:
        r1 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18398a;
        r3 = r4.f18402c;
        r2 = r3;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x00a0;
            case 2: goto L_0x00a0;
            case 3: goto L_0x00ac;
            case 4: goto L_0x00b8;
            case 5: goto L_0x00c4;
            case 6: goto L_0x00c4;
            case 7: goto L_0x00d0;
            default: goto L_0x0068;
        };
    L_0x0068:
        r1 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18398a;
        r3 = r4.f18402c;
        r2 = r3;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x00dc;
            case 2: goto L_0x0076;
            case 3: goto L_0x00e8;
            case 4: goto L_0x0076;
            case 5: goto L_0x00f4;
            case 6: goto L_0x0076;
            case 7: goto L_0x0100;
            default: goto L_0x0076;
        };
    L_0x0076:
        r1 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18398a;
        r3 = r4.f18402c;
        r2 = r3;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x010c;
            case 2: goto L_0x0084;
            case 3: goto L_0x0118;
            case 4: goto L_0x0084;
            case 5: goto L_0x0124;
            case 6: goto L_0x0084;
            case 7: goto L_0x0130;
            default: goto L_0x0084;
        };
    L_0x0084:
        r1 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18398a;
        r3 = r4.f18402c;
        r2 = r3;
        r2 = r2.ordinal();
        r1 = r1[r2];
        switch(r1) {
            case 1: goto L_0x0094;
            case 3: goto L_0x013c;
            case 7: goto L_0x0148;
            default: goto L_0x0092;
        };
    L_0x0092:
        goto L_0x0003;
    L_0x0094:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventAllMembersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18745a(r0);
        goto L_0x0003;
    L_0x00a0:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventOtherMembersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18748a(r0);
        goto L_0x0003;
    L_0x00ac:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventOtherMaybesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18748a(r0);
        goto L_0x0003;
    L_0x00b8:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventOtherWatchersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18750a(r0);
        goto L_0x0003;
    L_0x00c4:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventOtherInviteesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18748a(r0);
        goto L_0x0003;
    L_0x00d0:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventOtherDeclinesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18748a(r0);
        goto L_0x0003;
    L_0x00dc:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventEmailMembersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18746a(r0);
        goto L_0x0003;
    L_0x00e8:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventEmailMaybesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18746a(r0);
        goto L_0x0003;
    L_0x00f4:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventEmailInviteesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18746a(r0);
        goto L_0x0003;
    L_0x0100:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventEmailDeclinesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18746a(r0);
        goto L_0x0003;
    L_0x010c:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventSMSMembersQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18749a(r0);
        goto L_0x0003;
    L_0x0118:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventSMSMaybesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18749a(r0);
        goto L_0x0003;
    L_0x0124:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventSMSInviteesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18749a(r0);
        goto L_0x0003;
    L_0x0130:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventSMSDeclinesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18749a(r0);
        goto L_0x0003;
    L_0x013c:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventAllMaybesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18745a(r0);
        goto L_0x0003;
    L_0x0148:
        r5 = (com.facebook.events.graphql.EventsGraphQLModels.EventAllDeclinesQueryModel) r5;
        r0 = r5.a();
        r0 = r4.m18744a(r0);
        goto L_0x0003;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.permalink.guestlist.EventGuestListPager.a(java.lang.Object):java.lang.String");
    }

    private void m18763k() {
        if (m18757e() != null) {
            EventUser.Builder builder = new EventUser.Builder();
            builder.a = EventUserType.USER;
            builder = builder;
            builder.c = this.f18415p.a;
            builder = builder;
            builder.b = this.f18415p.j();
            builder = builder;
            builder.d = this.f18415p.x();
            builder = builder;
            builder.h = null;
            m18757e().mo843a(builder.a());
            m18764l();
        }
    }

    private String m18750a(PublicEventGuestFragmentModel publicEventGuestFragmentModel) {
        if (publicEventGuestFragmentModel == null) {
            return null;
        }
        ImmutableList immutableList;
        if (publicEventGuestFragmentModel == null) {
            immutableList = RegularImmutableList.a;
        } else {
            Builder builder = new Builder();
            ImmutableList a = publicEventGuestFragmentModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                builder.c(EventGraphQLModelHelper.m19266a(((EdgesModel) a.get(i)).a(), null));
            }
            immutableList = builder.b();
        }
        List list = immutableList;
        if (m18757e() != null) {
            m18757e().mo845a(list);
            m18764l();
        }
        PageInfoModel j = publicEventGuestFragmentModel.j();
        if (j != null) {
            return j.a();
        }
        return null;
    }

    private String m18748a(EventNonFriendGuestFragmentModel eventNonFriendGuestFragmentModel) {
        if (eventNonFriendGuestFragmentModel == null) {
            return null;
        }
        ImmutableList immutableList;
        if (eventNonFriendGuestFragmentModel == null) {
            immutableList = RegularImmutableList.a;
        } else {
            Builder builder = new Builder();
            ImmutableList a = eventNonFriendGuestFragmentModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EventNonFriendGuestFragmentModel.EdgesModel edgesModel = (EventNonFriendGuestFragmentModel.EdgesModel) a.get(i);
                builder.c(EventGraphQLModelHelper.m19266a(edgesModel.a(), edgesModel.j()));
            }
            immutableList = builder.b();
        }
        List list = immutableList;
        if (m18757e() != null) {
            m18757e().mo845a(list);
            m18764l();
        }
        EventNonFriendGuestFragmentModel.PageInfoModel j = eventNonFriendGuestFragmentModel.j();
        if (j != null) {
            return j.a();
        }
        return null;
    }

    private String m18746a(EventEmailGuestFragmentModel eventEmailGuestFragmentModel) {
        if (!(eventEmailGuestFragmentModel == null || eventEmailGuestFragmentModel.a() == 0)) {
            ImmutableList immutableList;
            Resources resources = this.f18414o.getResources();
            int i = 0;
            if (eventEmailGuestFragmentModel == null) {
                immutableList = RegularImmutableList.a;
            } else {
                Builder builder = new Builder();
                if (eventEmailGuestFragmentModel.j().isEmpty()) {
                    while (i < eventEmailGuestFragmentModel.a()) {
                        builder.c(EventGraphQLModelHelper.m19267a("email_guest_" + i, EventUserType.EMAIL_SYNTHETIC, resources));
                        i++;
                    }
                } else {
                    ImmutableList j = eventEmailGuestFragmentModel.j();
                    int size = j.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        NodesModel nodesModel = (NodesModel) j.get(i2);
                        ProfilePictureModel d = nodesModel.d();
                        String c = nodesModel.c();
                        EventUser.Builder builder2 = new EventUser.Builder();
                        if (Strings.isNullOrEmpty(c)) {
                            c = nodesModel.b();
                        }
                        builder2.b = c;
                        EventUser.Builder builder3 = builder2;
                        builder3.c = nodesModel.b();
                        builder2 = builder3;
                        if (d == null) {
                            c = null;
                        } else {
                            c = d.a();
                        }
                        builder2.d = c;
                        builder3 = builder2;
                        builder3.e = nodesModel.b();
                        builder3 = builder3;
                        builder3.a = EventUserType.EMAIL_USER;
                        builder.c(builder3.a());
                    }
                }
                immutableList = builder.b();
            }
            List list = immutableList;
            if (m18757e() != null) {
                m18757e().mo845a(list);
                m18764l();
            }
        }
        return null;
    }

    private String m18749a(EventSMSGuestFragmentModel eventSMSGuestFragmentModel) {
        if (!(eventSMSGuestFragmentModel == null || eventSMSGuestFragmentModel.a() == 0)) {
            ImmutableList immutableList;
            Resources resources = this.f18414o.getResources();
            int i = 0;
            if (eventSMSGuestFragmentModel == null) {
                immutableList = RegularImmutableList.a;
            } else {
                Builder builder = new Builder();
                if (eventSMSGuestFragmentModel.j().isEmpty()) {
                    while (i < eventSMSGuestFragmentModel.a()) {
                        builder.c(EventGraphQLModelHelper.m19267a("sms_guest_" + i, EventUserType.SMS_SYNTHETIC, resources));
                        i++;
                    }
                } else {
                    ImmutableList j = eventSMSGuestFragmentModel.j();
                    int size = j.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        EventSMSGuestFragmentModel.NodesModel nodesModel = (EventSMSGuestFragmentModel.NodesModel) j.get(i2);
                        EventSMSGuestFragmentModel.NodesModel.ProfilePictureModel d = nodesModel.d();
                        String b = nodesModel.b();
                        String a = nodesModel.c() != null ? nodesModel.c().a() : "";
                        EventUser.Builder builder2 = new EventUser.Builder();
                        if (Strings.isNullOrEmpty(b)) {
                            b = a;
                        }
                        builder2.b = b;
                        EventUser.Builder builder3 = builder2;
                        builder3.c = a;
                        builder2 = builder3;
                        if (d == null) {
                            b = null;
                        } else {
                            b = d.a();
                        }
                        builder2.d = b;
                        builder3 = builder2;
                        builder3.f = a;
                        EventUser.Builder builder4 = builder3;
                        builder4.a = EventUserType.SMS_USER;
                        builder.c(builder4.a());
                    }
                }
                immutableList = builder.b();
            }
            List list = immutableList;
            if (m18757e() != null) {
                m18757e().mo845a(list);
                m18764l();
            }
        }
        return null;
    }

    private String m18745a(EventAllGuestsFragmentModel eventAllGuestsFragmentModel) {
        if (eventAllGuestsFragmentModel == null) {
            return null;
        }
        m18754a(EventGraphQLModelHelper.m19274a(eventAllGuestsFragmentModel.a(), this.f18415p.a, this.f18416q));
        EventAllGuestsFragmentModel.PageInfoModel j = eventAllGuestsFragmentModel.j();
        if (j != null) {
            return j.a();
        }
        return null;
    }

    private String m18744a(AllEventDeclinesModel allEventDeclinesModel) {
        if (allEventDeclinesModel == null) {
            return null;
        }
        m18754a(EventGraphQLModelHelper.m19280b(allEventDeclinesModel.a(), this.f18415p.a, this.f18416q));
        AllEventDeclinesModel.PageInfoModel j = allEventDeclinesModel.j();
        if (j != null) {
            return j.a();
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18754a(com.google.common.collect.ImmutableListMultimap<com.facebook.events.protocol.EventGraphQLModelHelper.DateBucket, com.facebook.events.model.EventUser> r3) {
        /*
        r2 = this;
        r0 = com.facebook.events.permalink.guestlist.EventGuestListPager.C26121.f18399b;
        r1 = r2.m18758f();
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 5: goto L_0x0013;
            case 6: goto L_0x001e;
            case 7: goto L_0x0029;
            default: goto L_0x000f;
        };
    L_0x000f:
        r2.m18764l();
        return;
    L_0x0013:
        r0 = com.facebook.events.permalink.guestlist.EventGuestListSection.Type.TODAY;
        r1 = com.facebook.events.protocol.EventGraphQLModelHelper.DateBucket.TODAY;
        r1 = r3.e(r1);
        r2.m18752a(r0, r1);
    L_0x001e:
        r0 = com.facebook.events.permalink.guestlist.EventGuestListSection.Type.YESTERDAY;
        r1 = com.facebook.events.protocol.EventGraphQLModelHelper.DateBucket.YESTERDAY;
        r1 = r3.e(r1);
        r2.m18752a(r0, r1);
    L_0x0029:
        r0 = com.facebook.events.permalink.guestlist.EventGuestListSection.Type.EARLIER;
        r1 = com.facebook.events.protocol.EventGraphQLModelHelper.DateBucket.EARLIER;
        r1 = r3.e(r1);
        r2.m18752a(r0, r1);
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.permalink.guestlist.EventGuestListPager.a(com.google.common.collect.ImmutableListMultimap):void");
    }

    private void m18752a(Type type, ImmutableList<EventUser> immutableList) {
        if (!immutableList.isEmpty()) {
            while (true) {
                Type f = m18758f();
                if (f == type) {
                    m18757e().mo845a((List) immutableList);
                    return;
                } else if (f == Type.TODAY || f == Type.YESTERDAY || f == Type.EARLIER) {
                    m18759g();
                } else {
                    return;
                }
            }
        }
    }

    private String m18747a(EventFriendGuestFragmentModel eventFriendGuestFragmentModel) {
        if (eventFriendGuestFragmentModel == null) {
            return null;
        }
        ImmutableList immutableList;
        if (eventFriendGuestFragmentModel == null) {
            immutableList = RegularImmutableList.a;
        } else {
            Builder builder = new Builder();
            ImmutableList a = eventFriendGuestFragmentModel.a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                EventFriendGuestFragmentModel.EdgesModel edgesModel = (EventFriendGuestFragmentModel.EdgesModel) a.get(i);
                builder.c(EventGraphQLModelHelper.m19266a(edgesModel.a(), edgesModel.j()));
            }
            immutableList = builder.b();
        }
        List list = immutableList;
        if (m18757e() != null) {
            m18757e().mo845a(list);
            m18764l();
        }
        EventFriendGuestFragmentModel.PageInfoModel j = eventFriendGuestFragmentModel.j();
        if (j != null) {
            return j.a();
        }
        return null;
    }

    public void onFailure(Throwable th) {
        BLog.b(this.f18401b.getClass().getName(), "Error while fetching event guest list ", th);
        this.f18401b.mo841a(false);
        this.f18404e = PageState.ERROR;
    }

    private void m18764l() {
        Builder builder = new Builder();
        int size = this.f18403d.size();
        for (int i = 0; i < size; i++) {
            EventGuestListSection eventGuestListSection = (EventGuestListSection) this.f18403d.get(i);
            if (!eventGuestListSection.e().isEmpty()) {
                builder.c(eventGuestListSection);
            }
        }
        this.f18401b.mo840a(builder.b());
        this.f18401b.mo842e();
    }

    public final void m18767a(List<EventUser> list) {
        EventMutableGuestListSection.m18839a((List) list, this.f18403d);
        m18764l();
    }

    public final void m18770d() {
        if (this.f18408i != null) {
            this.f18408i.cancel(false);
        }
    }
}
