package com.facebook.events.tickets.modal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.events.graphql.EventsGraphQL.EventTicketOrderQueryString;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrderModel;
import com.facebook.events.graphql.EventsGraphQLModels.EventTicketOrdersQueryModel.PurchasedTicketOrdersModel.EdgesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.tickets.modal.EventTicketOrdersAdapter.TicketOrderViewHolder;
import com.facebook.events.tickets.modal.protocol.EventTicketOrdersFetcher;
import com.facebook.events.tickets.modal.protocol.EventTicketOrdersFetcher.C27381;
import com.facebook.events.tickets.modal.protocol.EventTicketOrdersFetcher.Callback;
import com.facebook.events.tickets.modal.protocol.EventTicketOrdersFetcherProvider;
import com.facebook.events.tickets.modal.util.EventBuyTicketCommonViewBinder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLModels.LinkableTextWithEntitiesModel;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.recyclerview.RecyclerViewAdapterWithHeadersAndFooters;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.BetterTextViewBorderDrawHook;
import com.facebook.widget.text.BetterTextViewBorderDrawHook.Side;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: arg_is_blocking_checkpoint */
public class EventTicketsOrdersActivity extends FbFragmentActivity implements Callback {
    @Inject
    EventTicketOrdersFetcherProvider f19271p;
    @Inject
    EventBuyTicketCommonViewBinder f19272q;
    public LinearLayoutManager f19273r;
    private FetchEventPermalinkFragmentModel f19274s;
    private RecyclerView f19275t;
    private View f19276u;
    private FbTitleBar f19277v;
    public EventTicketOrdersFetcher f19278w;
    private EventTicketOrdersAdapter f19279x;
    private RecyclerViewAdapterWithHeadersAndFooters<TicketOrderViewHolder> f19280y;

    /* compiled from: arg_is_blocking_checkpoint */
    class C27241 extends OnScrollListener {
        final /* synthetic */ EventTicketsOrdersActivity f19269a;

        C27241(EventTicketsOrdersActivity eventTicketsOrdersActivity) {
            this.f19269a = eventTicketsOrdersActivity;
        }

        public final void m19428a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (!this.f19269a.f19278w.f19331f && this.f19269a.f19273r.n() >= this.f19269a.f19273r.D() - i2) {
                this.f19269a.f19278w.m19485a();
            }
        }
    }

    /* compiled from: arg_is_blocking_checkpoint */
    class C27252 implements OnClickListener {
        final /* synthetic */ EventTicketsOrdersActivity f19270a;

        C27252(EventTicketsOrdersActivity eventTicketsOrdersActivity) {
            this.f19270a = eventTicketsOrdersActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 839250079);
            this.f19270a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1164111635, a);
        }
    }

    private static <T extends Context> void m19436a(Class<T> cls, T t) {
        m19437a((Object) t, (Context) t);
    }

    public static void m19437a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((EventTicketsOrdersActivity) obj).m19434a((EventTicketOrdersFetcherProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EventTicketOrdersFetcherProvider.class), EventBuyTicketCommonViewBinder.m19491b(fbInjector));
    }

    public static Intent m19432a(Context context, FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel, String str) {
        Intent intent = new Intent(context, EventTicketsOrdersActivity.class);
        FlatBufferModelHelper.a(intent, "extra_event_model", fetchEventPermalinkFragmentModel);
        if (str != null) {
            intent.putExtra("extra_order_id", str);
        }
        return intent;
    }

    protected final void m19443b(@Nullable Bundle bundle) {
        super.b(bundle);
        Class cls = EventTicketsOrdersActivity.class;
        m19437a((Object) this, (Context) this);
        overridePendingTransition(2130968589, 2130968588);
        setContentView(2130904107);
        this.f19275t = (RecyclerView) a(2131561445);
        this.f19276u = a(2131561446);
        this.f19276u.setVisibility(0);
        this.f19275t.setVisibility(8);
        FbTitleBarUtil.b(this);
        this.f19277v = (FbTitleBar) a(2131558563);
        String stringExtra = getIntent().getStringExtra("extra_order_id");
        this.f19274s = (FetchEventPermalinkFragmentModel) FlatBufferModelHelper.a(getIntent(), "extra_event_model");
        Preconditions.checkNotNull(this.f19274s);
        String dL_ = this.f19274s.dL_();
        EventTicketOrdersFetcherProvider eventTicketOrdersFetcherProvider = this.f19271p;
        this.f19278w = new EventTicketOrdersFetcher(dL_, this, GraphQLQueryExecutor.a(eventTicketOrdersFetcherProvider), TasksManager.b(eventTicketOrdersFetcherProvider));
        if (stringExtra == null) {
            this.f19277v.setTitle(2131241946);
            this.f19278w.m19485a();
        } else {
            this.f19277v.setTitle(2131241945);
            EventTicketOrdersFetcher eventTicketOrdersFetcher = this.f19278w;
            GraphQlQueryString eventTicketOrderQueryString = new EventTicketOrderQueryString();
            eventTicketOrderQueryString.a("order_id", stringExtra);
            eventTicketOrdersFetcher.f19329d.a("initial_fetch", eventTicketOrdersFetcher.f19328c.a(GraphQLRequest.a(eventTicketOrderQueryString)), new C27381(eventTicketOrdersFetcher));
        }
        this.f19273r = new LinearLayoutManager(this);
        this.f19275t.setLayoutManager(this.f19273r);
        this.f19279x = new EventTicketOrdersAdapter(this.f19274s);
        this.f19280y = new RecyclerViewAdapterWithHeadersAndFooters(this.f19279x);
        this.f19275t.setAdapter(this.f19280y);
        if (stringExtra == null) {
            this.f19275t.a(new C27241(this));
        }
    }

    private void m19439b(String str) {
        if (!Strings.isNullOrEmpty(str)) {
            BetterTextView betterTextView = (BetterTextView) LayoutInflater.from(this).inflate(2130904104, this.f19275t, false);
            betterTextView.a(new BetterTextViewBorderDrawHook(betterTextView, 1, getResources().getColor(2131363144), Side.BOTTOM));
            betterTextView.setText(str);
            this.f19280y.a(Lists.a(new View[]{betterTextView}));
        }
    }

    private void m19435a(LinkableTextWithEntitiesModel linkableTextWithEntitiesModel) {
        if (linkableTextWithEntitiesModel != null) {
            this.f19272q.m19492a(LayoutInflater.from(this).inflate(2130904105, this.f19275t, false), linkableTextWithEntitiesModel);
            this.f19280y.b(Lists.a(new View[]{r0}));
        }
    }

    public void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 195277788);
        super.onStart();
        this.f19277v.setTitlebarAsModal(new C27252(this));
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -213382856, a);
    }

    private void m19434a(EventTicketOrdersFetcherProvider eventTicketOrdersFetcherProvider, EventBuyTicketCommonViewBinder eventBuyTicketCommonViewBinder) {
        this.f19271p = eventTicketOrdersFetcherProvider;
        this.f19272q = eventBuyTicketCommonViewBinder;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968588, 2130968590);
    }

    public final void mo875a(EventTicketOrderModel eventTicketOrderModel) {
        this.f19276u.setVisibility(8);
        this.f19275t.setVisibility(0);
        EventTicketOrdersAdapter eventTicketOrdersAdapter = this.f19279x;
        if (eventTicketOrderModel != null) {
            int size = eventTicketOrdersAdapter.f19268c.size();
            eventTicketOrdersAdapter.f19268c = ImmutableList.builder().b(eventTicketOrdersAdapter.f19268c).c(eventTicketOrderModel).b();
            eventTicketOrdersAdapter.c(size, 1);
        }
    }

    public final void mo877a(ImmutableList<EdgesModel> immutableList) {
        if (!immutableList.isEmpty()) {
            this.f19276u.setVisibility(8);
            this.f19275t.setVisibility(0);
            EventTicketOrdersAdapter eventTicketOrdersAdapter = this.f19279x;
            if (!immutableList.isEmpty()) {
                int size = eventTicketOrdersAdapter.f19268c.size();
                eventTicketOrdersAdapter.f19268c = ImmutableList.builder().b(eventTicketOrdersAdapter.f19268c).b(Iterables.a(immutableList, EventTicketOrdersAdapter.f19266a)).b();
                eventTicketOrdersAdapter.c(size, immutableList.size());
            }
        }
    }

    public final void mo876a(LinkableTextWithEntitiesModel linkableTextWithEntitiesModel, String str) {
        m19439b(str);
        m19435a(linkableTextWithEntitiesModel);
    }
}
