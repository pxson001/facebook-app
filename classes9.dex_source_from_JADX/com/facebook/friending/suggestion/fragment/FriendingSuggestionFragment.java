package com.facebook.friending.suggestion.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.friending.common.list.FriendListItemView;
import com.facebook.friending.suggestion.model.FriendingSuggestionItemModel;
import com.facebook.friending.suggestion.model.FriendingSuggestionListLoader;
import com.facebook.friending.suggestion.model.FriendingSuggestionListLoader.C30041;
import com.facebook.friending.suggestion.model.FriendingSuggestionListLoaderResult;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQL.FetchFriendingSuggestionQueryString;
import com.facebook.friending.suggestion.ui.FriendingSuggestionAdapter;
import com.facebook.friending.suggestion.ui.FriendingSuggestionAdapterProvider;
import com.facebook.friending.suggestion.ui.FriendingSuggestionBinder;
import com.facebook.friends.FriendingClient;
import com.facebook.friends.events.FriendingEventBus;
import com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEvent;
import com.facebook.friends.protocol.FriendMutations.FriendSuggestionSendMutationString;
import com.facebook.graphql.calls.FriendSuggestionSendInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.LazyView;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Functions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: THEME_MESSENGER */
public class FriendingSuggestionFragment extends FbFragment {
    @Inject
    public Clock f24945a;
    public DefaultPageInfoFieldsModel al;
    public int am;
    public String an;
    public String ao;
    private String ap;
    private BetterListView aq;
    private FbTextView ar;
    public FriendingSuggestionAdapter as;
    public LazyView<View> at;
    private FriendshipStatusChangedEventSubscriber au;
    private final OnClickListener av = new C29981(this);
    @Inject
    FbUriIntentHandler f24946b;
    @Inject
    FriendingClient f24947c;
    @Inject
    FriendingEventBus f24948d;
    @Inject
    FriendingSuggestionAdapterProvider f24949e;
    @Inject
    FriendingSuggestionListLoader f24950f;
    @Inject
    TasksManager f24951g;
    @Inject
    @LoggedInUserId
    String f24952h;
    @Inject
    Toaster f24953i;

    /* compiled from: THEME_MESSENGER */
    class C29981 implements OnClickListener {
        final /* synthetic */ FriendingSuggestionFragment f24938a;

        C29981(FriendingSuggestionFragment friendingSuggestionFragment) {
            this.f24938a = friendingSuggestionFragment;
        }

        public void onClick(final View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1267657016);
            final FriendingSuggestionItemModel friendingSuggestionItemModel = (FriendingSuggestionItemModel) view.getTag(2131558806);
            this.f24938a.f24951g.a(Tasks.MUTATE_FRIENDING_SUGGESTION, new Callable<ListenableFuture<Void>>(this) {
                final /* synthetic */ C29981 f24934b;

                public Object call() {
                    FriendingClient friendingClient = this.f24934b.f24938a.f24947c;
                    String str = this.f24934b.f24938a.f24952h;
                    String str2 = this.f24934b.f24938a.ao;
                    String valueOf = String.valueOf(friendingSuggestionItemModel.m26713a());
                    String str3 = this.f24934b.f24938a.an;
                    GraphQlQueryString friendSuggestionSendMutationString = new FriendSuggestionSendMutationString();
                    FriendSuggestionSendInputData friendSuggestionSendInputData = new FriendSuggestionSendInputData();
                    friendSuggestionSendInputData.a("client_mutation_id", SafeUUIDGenerator.a().toString());
                    GraphQlCallInput graphQlCallInput = friendSuggestionSendInputData;
                    graphQlCallInput.a("actor_id", str);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("newcomer_id", str2);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("receiver_id", valueOf);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("attempt_id", str3);
                    friendSuggestionSendMutationString.a("input", graphQlCallInput);
                    return Futures.a(friendingClient.h.a(GraphQLRequest.a(friendSuggestionSendMutationString)), Functions.constant(null), friendingClient.l);
                }
            }, new AbstractDisposableFutureCallback<Void>(this) {
                final /* synthetic */ C29981 f24937c;

                protected final void m26699a(Object obj) {
                    friendingSuggestionItemModel.f24958e = true;
                    FriendListItemView friendListItemView = (FriendListItemView) view.getParent();
                    friendListItemView.setSubtitleText(2131241370);
                    friendListItemView.a.setVisibility(8);
                }

                protected final void m26700a(Throwable th) {
                    this.f24937c.f24938a.f24953i.a(new ToastBuilder(this.f24937c.f24938a.b(2131241371)));
                }
            });
            Logger.a(2, EntryType.UI_INPUT_END, -1160855354, a);
        }
    }

    /* compiled from: THEME_MESSENGER */
    class C29992 implements OnScrollListener {
        final /* synthetic */ FriendingSuggestionFragment f24939a;

        C29992(FriendingSuggestionFragment friendingSuggestionFragment) {
            this.f24939a = friendingSuggestionFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if ((i + i2) + 8 >= i3) {
                FriendingSuggestionFragment.m26706b(this.f24939a);
            }
        }
    }

    /* compiled from: THEME_MESSENGER */
    class C30003 implements OnItemClickListener {
        final /* synthetic */ FriendingSuggestionFragment f24940a;

        C30003(FriendingSuggestionFragment friendingSuggestionFragment) {
            this.f24940a = friendingSuggestionFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            FriendingSuggestionFragment.m26707g(this.f24940a, i);
        }
    }

    /* compiled from: THEME_MESSENGER */
    class C30014 implements Callable<ListenableFuture<FriendingSuggestionListLoaderResult>> {
        final /* synthetic */ FriendingSuggestionFragment f24941a;

        C30014(FriendingSuggestionFragment friendingSuggestionFragment) {
            this.f24941a = friendingSuggestionFragment;
        }

        public Object call() {
            FriendingSuggestionListLoader friendingSuggestionListLoader = this.f24941a.f24950f;
            String str = this.f24941a.ao;
            int i = this.f24941a.am;
            String a = this.f24941a.al.a();
            GraphQLQueryExecutor graphQLQueryExecutor = friendingSuggestionListLoader.f24961a;
            GraphQlQueryString fetchFriendingSuggestionQueryString = new FetchFriendingSuggestionQueryString();
            fetchFriendingSuggestionQueryString.a("order_param", friendingSuggestionListLoader.f24962b).a("first_param", Long.toString(20)).a("after_param", a).a("profile_id", str).a("size", Integer.toString(i)).a(true);
            GraphQLRequest a2 = GraphQLRequest.a(fetchFriendingSuggestionQueryString);
            GraphQLRequest a3 = a2.a(GraphQLCachePolicy.a);
            a3.f = CallerContext.a(friendingSuggestionListLoader.getClass());
            a3 = a3;
            a3.b = true;
            a3.a(3600);
            return Futures.a(graphQLQueryExecutor.a(a2), new C30041(friendingSuggestionListLoader), MoreExecutors.a());
        }
    }

    /* compiled from: THEME_MESSENGER */
    class C30035 extends AbstractDisposableFutureCallback<FriendingSuggestionListLoaderResult> {
        final /* synthetic */ FriendingSuggestionFragment f24943a;

        /* compiled from: THEME_MESSENGER */
        class C30021 implements OnClickListener {
            final /* synthetic */ C30035 f24942a;

            C30021(C30035 c30035) {
                this.f24942a = c30035;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -930161076);
                FriendingSuggestionFragment.m26706b(this.f24942a.f24943a);
                this.f24942a.f24943a.at.c();
                Logger.a(2, EntryType.UI_INPUT_END, -105532536, a);
            }
        }

        C30035(FriendingSuggestionFragment friendingSuggestionFragment) {
            this.f24943a = friendingSuggestionFragment;
        }

        protected final void m26701a(Object obj) {
            FriendingSuggestionListLoaderResult friendingSuggestionListLoaderResult = (FriendingSuggestionListLoaderResult) obj;
            FriendingSuggestionAdapter friendingSuggestionAdapter = this.f24943a.as;
            for (FriendingSuggestionItemModel friendingSuggestionItemModel : friendingSuggestionListLoaderResult.f24963a) {
                if (friendingSuggestionItemModel.m26717f() == GraphQLFriendshipStatus.ARE_FRIENDS) {
                    friendingSuggestionAdapter.f24976b.add(friendingSuggestionItemModel);
                }
            }
            AdapterDetour.a(friendingSuggestionAdapter, 479053373);
            this.f24943a.al = friendingSuggestionListLoaderResult.f24964b;
        }

        protected final void m26702a(Throwable th) {
            if (!this.f24943a.at.b()) {
                this.f24943a.at.a().setOnClickListener(new C30021(this));
            }
            this.f24943a.at.a().setVisibility(0);
        }
    }

    /* compiled from: THEME_MESSENGER */
    class FriendshipStatusChangedEventSubscriber extends com.facebook.friends.events.FriendingEvents.FriendshipStatusChangedEventSubscriber {
        final /* synthetic */ FriendingSuggestionFragment f24944a;

        public FriendshipStatusChangedEventSubscriber(FriendingSuggestionFragment friendingSuggestionFragment) {
            this.f24944a = friendingSuggestionFragment;
        }

        public final void m26703b(FbEvent fbEvent) {
            FriendshipStatusChangedEvent friendshipStatusChangedEvent = (FriendshipStatusChangedEvent) fbEvent;
            if (friendshipStatusChangedEvent != null) {
                FriendingSuggestionAdapter friendingSuggestionAdapter = this.f24944a.as;
                long j = friendshipStatusChangedEvent.a;
                for (FriendingSuggestionItemModel friendingSuggestionItemModel : friendingSuggestionAdapter.f24976b) {
                    if (friendingSuggestionItemModel.m26713a() == j) {
                        break;
                    }
                }
                FriendingSuggestionItemModel friendingSuggestionItemModel2 = null;
                FriendingSuggestionItemModel friendingSuggestionItemModel3 = friendingSuggestionItemModel2;
                if (friendingSuggestionItemModel3 != null && friendingSuggestionItemModel3.m26717f() == GraphQLFriendshipStatus.ARE_FRIENDS && friendshipStatusChangedEvent.b != friendingSuggestionItemModel3.m26717f()) {
                    friendingSuggestionItemModel3.f24959f = friendshipStatusChangedEvent.b;
                    FriendingSuggestionAdapter friendingSuggestionAdapter2 = this.f24944a.as;
                    friendingSuggestionAdapter2.f24976b.remove(friendingSuggestionItemModel3);
                    AdapterDetour.a(friendingSuggestionAdapter2, 2125754585);
                }
            }
        }
    }

    /* compiled from: THEME_MESSENGER */
    enum Tasks {
        FETCH_FRIENDING_SUGGESTIONS,
        MUTATE_FRIENDING_SUGGESTION
    }

    public static void m26705a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((FriendingSuggestionFragment) obj).m26704a((Clock) SystemClockMethodAutoProvider.a(fbInjector), FbUriIntentHandler.a(fbInjector), FriendingClient.b(fbInjector), FriendingEventBus.a(fbInjector), (FriendingSuggestionAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FriendingSuggestionAdapterProvider.class), new FriendingSuggestionListLoader(GraphQLQueryExecutor.a(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector)), TasksManager.b(fbInjector), String_LoggedInUserIdMethodAutoProvider.b(fbInjector), Toaster.b(fbInjector));
    }

    public final void m26712c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FriendingSuggestionFragment.class;
        m26705a((Object) this, getContext());
        Bundle bundle2 = this.s;
        this.ao = String.valueOf(bundle2.getLong("com.facebook.katana.profile.id"));
        this.ap = String.valueOf(bundle2.getString("profile_name"));
        this.an = "A" + SecureHashUtil.b(this.ao + String.valueOf(this.f24945a.a()));
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(2130772417, typedValue, true);
        this.am = jW_().getDimensionPixelSize(typedValue.resourceId);
        this.au = new FriendshipStatusChangedEventSubscriber(this);
        this.f24948d.a(this.au);
    }

    public final View m26710a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1165373954);
        View inflate = layoutInflater.inflate(2130904508, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1747292730, a);
        return inflate;
    }

    public final void m26708G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1653563551);
        super.G();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.c(true);
            hasTitleBar.a_(StringLocaleUtil.a(b(2131241365), new Object[]{this.ap}));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 228450707, a);
    }

    public final void m26711a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ar = (FbTextView) e(2131562313);
        this.ar.setText(StringLocaleUtil.a(b(2131241366), new Object[]{this.ap}));
        this.at = new LazyView((ViewStub) e(2131562311));
        this.aq = (BetterListView) e(2131562314);
        this.aq.setEmptyView(this.T.findViewById(16908292));
        FriendingSuggestionAdapterProvider friendingSuggestionAdapterProvider = this.f24949e;
        this.as = new FriendingSuggestionAdapter(new FriendingSuggestionBinder((Context) friendingSuggestionAdapterProvider.getInstance(Context.class)), this.av);
        this.aq.setAdapter(this.as);
        this.aq.a(new C29992(this));
        this.aq.setOnItemClickListener(new C30003(this));
        Builder builder = new Builder();
        builder.c = false;
        builder = builder;
        builder.b = true;
        this.al = builder.a();
        m26706b(this);
    }

    public final void m26709I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1210419883);
        super.I();
        this.f24951g.c();
        this.f24948d.b(this.au);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -710976150, a);
    }

    public static void m26706b(FriendingSuggestionFragment friendingSuggestionFragment) {
        if (friendingSuggestionFragment.al.b()) {
            friendingSuggestionFragment.f24951g.a(Tasks.FETCH_FRIENDING_SUGGESTIONS, new C30014(friendingSuggestionFragment), new C30035(friendingSuggestionFragment));
        }
    }

    public static void m26707g(FriendingSuggestionFragment friendingSuggestionFragment, int i) {
        FriendingSuggestionItemModel friendingSuggestionItemModel = (FriendingSuggestionItemModel) friendingSuggestionFragment.as.getItem(i);
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, Long.valueOf(friendingSuggestionItemModel.m26713a()));
        Bundle bundle = new Bundle();
        ModelBundle.a(bundle, String.valueOf(friendingSuggestionItemModel.m26713a()), friendingSuggestionItemModel.m26715d(), friendingSuggestionItemModel.m26714b(), null, null);
        friendingSuggestionFragment.f24946b.a(friendingSuggestionFragment.getContext(), formatStrLocaleSafe, bundle);
    }

    private void m26704a(Clock clock, FbUriIntentHandler fbUriIntentHandler, FriendingClient friendingClient, FriendingEventBus friendingEventBus, FriendingSuggestionAdapterProvider friendingSuggestionAdapterProvider, FriendingSuggestionListLoader friendingSuggestionListLoader, TasksManager tasksManager, String str, Toaster toaster) {
        this.f24945a = clock;
        this.f24946b = fbUriIntentHandler;
        this.f24947c = friendingClient;
        this.f24948d = friendingEventBus;
        this.f24949e = friendingSuggestionAdapterProvider;
        this.f24950f = friendingSuggestionListLoader;
        this.f24951g = tasksManager;
        this.f24952h = str;
        this.f24953i = toaster;
    }
}
