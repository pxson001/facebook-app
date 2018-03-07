package com.facebook.events.invite;

import android.util.Pair;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.contacts.data.FbContactsContract.QueryType;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.graphql.ContactLinkType;
import com.facebook.contacts.iterator.ContactCursors;
import com.facebook.contacts.iterator.ContactCursorsQuery;
import com.facebook.contacts.iterator.ContactCursorsQuery.SortKey;
import com.facebook.events.graphql.EventsGraphQL;
import com.facebook.events.graphql.EventsGraphQL.EventInvitableContactsQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventInvitableEntriesTokenQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSpecificSuggestedInviteCandidatesQueryString;
import com.facebook.events.graphql.EventsGraphQL.EventSpecificUninvitableFriendsAndInviteeLimitString;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableContactsQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableContactsQueryModel.EventInvitableContactsModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntriesTokenQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntriesTokenQueryModel.InvitableEntriesTokenQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventInvitableEntryFragmentModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificSuggestedInviteCandidatesQueryModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificSuggestedInviteCandidatesQueryModel.InviteeCandidatesModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificUninvitableFriendsAndInviteeLimitModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventSpecificUninvitableFriendsAndInviteeLimitModel.UninvitableFriendsModel.EdgesModel;
import com.facebook.events.invite.EventsExtendedInviteFragment.C24904;
import com.facebook.graphql.enums.GraphQLEventInviteeStatusType;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.user.model.Name;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: client_time_ms */
public class EventsExtendedInviteFriendsFetcher {
    public static final String f17577a = EventsExtendedInviteFriendsFetcher.class.getSimpleName();
    @Nullable
    public AbstractDisposableFutureCallback<EventInvitableEntriesTokenQueryModel> f17578b;
    @Nullable
    public ListenableFuture<EventInvitableEntriesTokenQueryModel> f17579c;
    private AbstractDisposableFutureCallback<List<?>> f17580d;
    private AbstractDisposableFutureCallback<List<?>> f17581e;
    public ListenableFuture<ImmutableMap<String, SimpleUserToken>> f17582f;
    public ListenableFuture<ImmutableList<String>> f17583g;
    public ListenableFuture<EventSpecificUninvitableFriendsAndInviteeLimitModel> f17584h;
    private ListenableFuture<List<Object>> f17585i;
    private ListenableFuture<List<Object>> f17586j;
    public boolean f17587k = true;
    public C24904 f17588l;
    private GraphQLBatchRequest f17589m;
    public String f17590n;
    public String f17591o;
    public final ContactCursors f17592p;
    public final ContactLinkType f17593q;
    private final ExecutorService f17594r;
    public final AbstractFbErrorReporter f17595s;
    public final GraphQLQueryExecutor f17596t;
    public final InviteeIteratorProvider f17597u;
    public final InvitePickerPerformanceLogger f17598v;
    public final ListeningExecutorService f17599w;
    public final TasksManager<String> f17600x;

    /* compiled from: client_time_ms */
    class C24972 implements Callable<ListenableFuture<EventInvitableContactsQueryModel>> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17570a;

        C24972(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17570a = eventsExtendedInviteFriendsFetcher;
        }

        public Object call() {
            return GraphQLQueryExecutor.a(this.f17570a.f17596t.a(EventsExtendedInviteFriendsFetcher.m17955g(this.f17570a)));
        }
    }

    /* compiled from: client_time_ms */
    public class C24983 extends AbstractDisposableFutureCallback<List<?>> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17571a;

        public C24983(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17571a = eventsExtendedInviteFriendsFetcher;
        }

        protected final void m17944a(Object obj) {
            Throwable e;
            Throwable e2;
            try {
                ImmutableList immutableList;
                ImmutableMap immutableMap = (ImmutableMap) FutureDetour.a(this.f17571a.f17582f, 384357847);
                ImmutableList of = ImmutableList.of();
                try {
                    immutableList = (ImmutableList) FutureDetour.a(this.f17571a.f17583g, 132191944);
                } catch (InterruptedException e3) {
                    e = e3;
                    this.f17571a.f17595s.a(SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch suggested facebook friends").a(e).g());
                    immutableList = of;
                    this.f17571a.f17588l.m17928a(immutableMap, immutableList);
                } catch (ExecutionException e4) {
                    e = e4;
                    this.f17571a.f17595s.a(SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch suggested facebook friends").a(e).g());
                    immutableList = of;
                    this.f17571a.f17588l.m17928a(immutableMap, immutableList);
                }
                this.f17571a.f17588l.m17928a(immutableMap, immutableList);
            } catch (InterruptedException e5) {
                e2 = e5;
                m17945a(e2);
            } catch (ExecutionException e6) {
                e2 = e6;
                m17945a(e2);
            }
        }

        protected final void m17945a(Throwable th) {
            EventsExtendedInviteFriendsFetcher.m17958k(this.f17571a);
            this.f17571a.f17588l.m17926a();
            this.f17571a.f17598v.m18044b();
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17571a.f17595s;
            SoftErrorBuilder a = SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch facebook friends");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: client_time_ms */
    public class C24994 extends AbstractDisposableFutureCallback<List<?>> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17572a;

        public C24994(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17572a = eventsExtendedInviteFriendsFetcher;
        }

        protected final void m17946a(Object obj) {
            Throwable th;
            try {
                ImmutableMap immutableMap = (ImmutableMap) FutureDetour.a(this.f17572a.f17582f, 1013075299);
                try {
                    EventSpecificUninvitableFriendsAndInviteeLimitModel eventSpecificUninvitableFriendsAndInviteeLimitModel = (EventSpecificUninvitableFriendsAndInviteeLimitModel) FutureDetour.a(this.f17572a.f17584h, 680498737);
                    if (eventSpecificUninvitableFriendsAndInviteeLimitModel == null) {
                        throw new Throwable("Restrictions model is null");
                    }
                    Builder builder = ImmutableSet.builder();
                    Builder builder2 = ImmutableSet.builder();
                    if (eventSpecificUninvitableFriendsAndInviteeLimitModel.j() != null) {
                        ImmutableList a = eventSpecificUninvitableFriendsAndInviteeLimitModel.j().a();
                        int size = a.size();
                        for (int i = 0; i < size; i++) {
                            EdgesModel edgesModel = (EdgesModel) a.get(i);
                            if (edgesModel.a() != null) {
                                if (EventsExtendedInviteFriendsFetcher.m17953c(edgesModel.j())) {
                                    builder2.c(edgesModel.a().j());
                                } else if (EventsExtendedInviteFriendsFetcher.m17954d(edgesModel.j())) {
                                    builder.c(edgesModel.a().j());
                                }
                            }
                        }
                    }
                    this.f17572a.f17588l.m17929a(immutableMap, builder.b(), builder2.b(), eventSpecificUninvitableFriendsAndInviteeLimitModel.a() != null ? eventSpecificUninvitableFriendsAndInviteeLimitModel.a().a() : Integer.MAX_VALUE);
                } catch (Throwable th2) {
                    this.f17572a.f17595s.a(SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch restrictions for facebook friends").a(th2).g());
                }
            } catch (InterruptedException e) {
                th2 = e;
                m17947a(th2);
            } catch (ExecutionException e2) {
                th2 = e2;
                m17947a(th2);
            }
        }

        protected final void m17947a(Throwable th) {
            EventsExtendedInviteFriendsFetcher.m17957j(this.f17572a);
            this.f17572a.f17588l.m17926a();
            this.f17572a.f17598v.m18044b();
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17572a.f17595s;
            SoftErrorBuilder a = SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch facebook friends");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: client_time_ms */
    public class C25005 implements Callable<ImmutableMap<String, SimpleUserToken>> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17573a;

        public C25005(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17573a = eventsExtendedInviteFriendsFetcher;
        }

        public Object call() {
            InviteeIterator a = this.f17573a.f17597u.m18061a(this.f17573a.f17592p.a(ContactCursorsQuery.a().d(ImmutableList.of(this.f17573a.f17593q)).a(SortKey.NAME), QueryType.CONTACT));
            ImmutableMap.Builder builder = new ImmutableMap.Builder();
            while (a.hasNext()) {
                try {
                    Pair b = a.m18060b();
                    if (!(b == null || b.second == null)) {
                        Contact contact = (Contact) b.second;
                        builder.b(contact.c(), new SimpleUserToken(contact.e(), contact.g(), UserKey.b(contact.c())));
                    }
                } finally {
                    a.close();
                }
            }
            return builder.b();
        }
    }

    /* compiled from: client_time_ms */
    public class C25016 implements Function<GraphQLResult<EventSpecificSuggestedInviteCandidatesQueryModel>, ImmutableList<String>> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17574a;

        public C25016(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17574a = eventsExtendedInviteFriendsFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((EventSpecificSuggestedInviteCandidatesQueryModel) graphQLResult.e).a() == null) {
                return RegularImmutableList.a;
            }
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList a = ((EventSpecificSuggestedInviteCandidatesQueryModel) graphQLResult.e).a().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                InviteeCandidatesModel.EdgesModel edgesModel = (InviteeCandidatesModel.EdgesModel) a.get(i);
                if (edgesModel.a() != null) {
                    builder.c(edgesModel.a().j());
                }
            }
            return builder.b();
        }
    }

    /* compiled from: client_time_ms */
    class C25027 extends AbstractDisposableFutureCallback<EventInvitableContactsQueryModel> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17575a;

        C25027(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17575a = eventsExtendedInviteFriendsFetcher;
        }

        protected final void m17948a(Object obj) {
            EventInvitableContactsQueryModel eventInvitableContactsQueryModel = (EventInvitableContactsQueryModel) obj;
            if (eventInvitableContactsQueryModel == null || eventInvitableContactsQueryModel.a() == null) {
                m17949a(new Throwable("Server returned null"));
                return;
            }
            String str;
            boolean z;
            EventInvitableContactsModel a = eventInvitableContactsQueryModel.a();
            EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher = this.f17575a;
            if (a.j() == null) {
                str = null;
            } else {
                str = a.j().a();
            }
            eventsExtendedInviteFriendsFetcher.f17590n = str;
            int a2 = eventInvitableContactsQueryModel.j() != null ? eventInvitableContactsQueryModel.j().a() : Integer.MAX_VALUE;
            EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher2 = this.f17575a;
            if (this.f17575a.f17590n == null || !a.j().j()) {
                z = false;
            } else {
                z = true;
            }
            eventsExtendedInviteFriendsFetcher2.f17587k = z;
            this.f17575a.f17588l.m17927a(EventsExtendedInviteFriendsFetcher.m17952b(a.a()), a2, this.f17575a.f17587k);
        }

        protected final void m17949a(Throwable th) {
            this.f17575a.f17587k = false;
            C24904 c24904 = this.f17575a.f17588l;
            c24904.f17551a.f17564f.m17997a(true, c24904.f17551a.aq, false);
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17575a.f17595s;
            SoftErrorBuilder a = SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch contacts");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    /* compiled from: client_time_ms */
    public class C25038 extends AbstractDisposableFutureCallback<EventInvitableEntriesTokenQueryModel> {
        final /* synthetic */ EventsExtendedInviteFriendsFetcher f17576a;

        public C25038(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
            this.f17576a = eventsExtendedInviteFriendsFetcher;
        }

        protected final void m17950a(Object obj) {
            EventInvitableEntriesTokenQueryModel eventInvitableEntriesTokenQueryModel = (EventInvitableEntriesTokenQueryModel) obj;
            if (eventInvitableEntriesTokenQueryModel == null || eventInvitableEntriesTokenQueryModel.a() == null) {
                m17951a(new Throwable("Server returned null"));
                return;
            }
            InvitableEntriesTokenQueryModel a = eventInvitableEntriesTokenQueryModel.a();
            C24904 c24904 = this.f17576a.f17588l;
            ImmutableList b = EventsExtendedInviteFriendsFetcher.m17952b(a.a());
            int size = b.size();
            for (int i = 0; i < size; i++) {
                EventsExtendedInviteFragment.m17933a(c24904.f17551a, (SimpleUserToken) b.get(i));
            }
        }

        protected final void m17951a(Throwable th) {
            C24904 c24904 = this.f17576a.f17588l;
            AbstractFbErrorReporter abstractFbErrorReporter = this.f17576a.f17595s;
            SoftErrorBuilder a = SoftError.a(EventsExtendedInviteFriendsFetcher.f17577a, "Failed to fetch Entries Tokens");
            a.c = th;
            abstractFbErrorReporter.a(a.g());
        }
    }

    @Inject
    public EventsExtendedInviteFriendsFetcher(ContactCursors contactCursors, ContactLinkType contactLinkType, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, InviteeIteratorProvider inviteeIteratorProvider, InvitePickerPerformanceLogger invitePickerPerformanceLogger, ListeningExecutorService listeningExecutorService, TasksManager tasksManager, @Assisted String str, @Assisted C24904 c24904) {
        this.f17592p = contactCursors;
        this.f17593q = contactLinkType;
        this.f17594r = executorService;
        this.f17595s = abstractFbErrorReporter;
        this.f17596t = graphQLQueryExecutor;
        this.f17597u = inviteeIteratorProvider;
        this.f17598v = invitePickerPerformanceLogger;
        this.f17599w = listeningExecutorService;
        this.f17600x = tasksManager;
        this.f17589m = new GraphQLBatchRequest("EventsExtendedInviteFriendsFetcher");
        this.f17591o = str;
        this.f17588l = c24904;
    }

    public final void m17959a() {
        if (this.f17587k) {
            this.f17600x.a("FETCH_CONTACTS_TASK", new C24972(this), m17956h());
        }
    }

    public final void m17960a(boolean z, @Nullable Set<String> set) {
        ListenableFuture a;
        this.f17582f = this.f17599w.a(new C25005(this));
        GraphQLBatchRequest graphQLBatchRequest = this.f17589m;
        EventSpecificSuggestedInviteCandidatesQueryString o = EventsGraphQL.o();
        o.a("event_id", this.f17591o).a("first_count", "7");
        this.f17583g = Futures.a(graphQLBatchRequest.b(GraphQLRequest.a(o).a(GraphQLCachePolicy.c)), new C25016(this), this.f17599w);
        graphQLBatchRequest = this.f17589m;
        EventSpecificUninvitableFriendsAndInviteeLimitString p = EventsGraphQL.p();
        p.a("event_id", this.f17591o);
        this.f17584h = GraphQLQueryExecutor.a(graphQLBatchRequest.b(GraphQLRequest.a(p).a(GraphQLCachePolicy.c)));
        if (z) {
            a = GraphQLQueryExecutor.a(this.f17589m.b(m17955g(this)));
        } else {
            a = null;
        }
        if (CollectionUtil.b(set)) {
            GraphQLBatchRequest graphQLBatchRequest2 = this.f17589m;
            GraphQlQueryString eventInvitableEntriesTokenQueryString = new EventInvitableEntriesTokenQueryString();
            eventInvitableEntriesTokenQueryString.a("event_id", this.f17591o);
            eventInvitableEntriesTokenQueryString.a("tokens", Lists.a(set));
            this.f17579c = GraphQLQueryExecutor.a(graphQLBatchRequest2.b(GraphQLRequest.a(eventInvitableEntriesTokenQueryString).a(GraphQLCachePolicy.c)));
        }
        this.f17596t.a(this.f17589m);
        this.f17585i = Futures.b(new ListenableFuture[]{this.f17582f, this.f17583g});
        this.f17580d = new C24983(this);
        Futures.a(this.f17585i, this.f17580d, this.f17594r);
        this.f17586j = Futures.b(ImmutableList.of(this.f17582f, this.f17584h));
        this.f17581e = new C24994(this);
        Futures.a(this.f17586j, this.f17581e, this.f17594r);
        if (z) {
            this.f17600x.a("FETCH_CONTACTS_TASK", new Callable<ListenableFuture<EventInvitableContactsQueryModel>>(this) {
                final /* synthetic */ EventsExtendedInviteFriendsFetcher f17569b;

                public Object call() {
                    return a;
                }
            }, m17956h());
        }
        if (CollectionUtil.b(set)) {
            this.f17578b = new C25038(this);
            Futures.a(this.f17579c, this.f17578b, this.f17594r);
        }
    }

    private AbstractDisposableFutureCallback<EventInvitableContactsQueryModel> m17956h() {
        return new C25027(this);
    }

    public static ImmutableList<SimpleUserToken> m17952b(ImmutableList<EventInvitableEntryFragmentModel> immutableList) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            EventInvitableEntryFragmentModel eventInvitableEntryFragmentModel = (EventInvitableEntryFragmentModel) immutableList.get(i);
            builder.c(new EventsExtendedInviteUserToken(UserKey.b(eventInvitableEntryFragmentModel.m()), new Name(eventInvitableEntryFragmentModel.l()), eventInvitableEntryFragmentModel.k(), eventInvitableEntryFragmentModel.j(), eventInvitableEntryFragmentModel.a()));
        }
        return builder.b();
    }

    public static boolean m17953c(GraphQLEventInviteeStatusType graphQLEventInviteeStatusType) {
        return graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.INVITED || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.GOING || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.NOT_GOING || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.REMOVED || graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.MAYBE;
    }

    public static boolean m17954d(GraphQLEventInviteeStatusType graphQLEventInviteeStatusType) {
        return graphQLEventInviteeStatusType == GraphQLEventInviteeStatusType.INELIGIBLE_FOR_EVENT;
    }

    public static void m17957j(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
        if (eventsExtendedInviteFriendsFetcher.f17580d != null) {
            eventsExtendedInviteFriendsFetcher.f17580d.jc_();
        }
        if (eventsExtendedInviteFriendsFetcher.f17585i != null) {
            eventsExtendedInviteFriendsFetcher.f17585i.cancel(true);
        }
    }

    public static void m17958k(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
        if (eventsExtendedInviteFriendsFetcher.f17581e != null) {
            eventsExtendedInviteFriendsFetcher.f17581e.jc_();
        }
        if (eventsExtendedInviteFriendsFetcher.f17586j != null) {
            eventsExtendedInviteFriendsFetcher.f17586j.cancel(true);
        }
    }

    public static GraphQLRequest m17955g(EventsExtendedInviteFriendsFetcher eventsExtendedInviteFriendsFetcher) {
        GraphQlQueryString eventInvitableContactsQueryString = new EventInvitableContactsQueryString();
        eventInvitableContactsQueryString.a("after_cursor", eventsExtendedInviteFriendsFetcher.f17590n);
        eventInvitableContactsQueryString.a("event_id", eventsExtendedInviteFriendsFetcher.f17591o);
        eventInvitableContactsQueryString.a("first_count", Integer.valueOf(14));
        return GraphQLRequest.a(eventInvitableContactsQueryString).a(GraphQLCachePolicy.c);
    }
}
