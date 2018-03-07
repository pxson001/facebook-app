package com.facebook.events.ui.themeselector;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.ViewGroup;
import com.facebook.controller.connectioncontroller.ConnectionControllerBuilderProvider;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionAdapter;
import com.facebook.controller.connectioncontroller.adapters.RecyclerViewConnectionListener;
import com.facebook.controller.connectioncontroller.common.ConnectionController;
import com.facebook.controller.connectioncontroller.common.ConnectionFetchOperation;
import com.facebook.controller.connectioncontroller.common.ConnectionLocation;
import com.facebook.controller.connectioncontroller.common.ConnectionOrder;
import com.facebook.controller.connectioncontroller.common.ConnectionPage;
import com.facebook.controller.connectioncontroller.common.SimpleConnectionConfiguration;
import com.facebook.device.ScreenUtil;
import com.facebook.events.ui.themeselector.abtest.ExperimentsForThemeSelectorModule;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQL;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQL.EventsThemeSuggestionsString;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel.EventThemesModel;
import com.facebook.events.ui.themeselector.protocol.EventsThemeSelectorGraphQLModels.EventsThemeSuggestionsModel.EventThemesModel.NodesModel;
import com.facebook.graphql.calls.EventThemeEventInfoInputData.EventInfo;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import javax.inject.Inject;

/* compiled from: app_scoped_ids */
public class EventsThemeSelectionRecyclerViewWrapper {
    public Context f19557a;
    public String f19558b;
    public String f19559c;
    public String f19560d;
    public RecyclerView f19561e;
    public ThemeSelectionRecyclerViewAdapter f19562f;
    public ConnectionController<NodesModel, Void> f19563g;
    public QeAccessor f19564h;
    public ScreenUtil f19565i;
    private ConnectionControllerBuilderProvider f19566j;
    private boolean f19567k;
    public int f19568l;
    public int f19569m = (this.f19568l * 3);

    /* compiled from: app_scoped_ids */
    class C27831 extends OnScrollListener {
        final /* synthetic */ EventsThemeSelectionRecyclerViewWrapper f19553a;

        C27831(EventsThemeSelectionRecyclerViewWrapper eventsThemeSelectionRecyclerViewWrapper) {
            this.f19553a = eventsThemeSelectionRecyclerViewWrapper;
        }

        public final void m19762a(RecyclerView recyclerView, int i, int i2) {
            super.a(recyclerView, i, i2);
            if (this.f19553a.f19563g.d().c().d) {
                if (this.f19553a.f19562f.aZ_() - ((GridLayoutManager) recyclerView.getLayoutManager()).o() < this.f19553a.f19569m) {
                    this.f19553a.f19563g.b(12, null);
                }
            }
        }
    }

    /* compiled from: app_scoped_ids */
    public class C27842 extends SpanSizeLookup {
        final /* synthetic */ EventsThemeSelectionRecyclerViewWrapper f19554b;

        public C27842(EventsThemeSelectionRecyclerViewWrapper eventsThemeSelectionRecyclerViewWrapper) {
            this.f19554b = eventsThemeSelectionRecyclerViewWrapper;
        }

        public final int m19763a(int i) {
            switch (this.f19554b.f19562f.getItemViewType(i)) {
                case 1:
                    return this.f19554b.f19568l;
                default:
                    return 1;
            }
        }
    }

    /* compiled from: app_scoped_ids */
    class EventsThemeSuggestionsModelConnectionListener extends RecyclerViewConnectionListener<NodesModel> {
        final /* synthetic */ EventsThemeSelectionRecyclerViewWrapper f19555a;

        public EventsThemeSuggestionsModelConnectionListener(EventsThemeSelectionRecyclerViewWrapper eventsThemeSelectionRecyclerViewWrapper) {
            this.f19555a = eventsThemeSelectionRecyclerViewWrapper;
        }

        public final void m19764a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f19555a.f19562f.m19781b(true);
        }

        public final void m19767b(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder) {
            this.f19555a.f19562f.m19781b(false);
        }

        public final void m19765a(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, Throwable th) {
            this.f19555a.f19562f.m19781b(false);
        }

        protected final RecyclerViewConnectionAdapter<NodesModel> m19766b() {
            return this.f19555a.f19562f;
        }

        protected final ConnectionController<NodesModel, ?> m19768c() {
            return this.f19555a.f19563g;
        }
    }

    /* compiled from: app_scoped_ids */
    class EventsThemeSuggestionsModelSimpleConnectionConfiguration implements SimpleConnectionConfiguration<NodesModel, Void, EventsThemeSuggestionsModel> {
        final /* synthetic */ EventsThemeSelectionRecyclerViewWrapper f19556a;

        public EventsThemeSuggestionsModelSimpleConnectionConfiguration(EventsThemeSelectionRecyclerViewWrapper eventsThemeSelectionRecyclerViewWrapper) {
            this.f19556a = eventsThemeSelectionRecyclerViewWrapper;
        }

        public final TypedGraphQlQueryString m19770a(ConnectionFetchOperation connectionFetchOperation, Object obj) {
            EventsThemeSuggestionsString a = EventsThemeSelectorGraphQL.m19804a();
            EventsThemeSelectionRecyclerViewWrapper eventsThemeSelectionRecyclerViewWrapper = this.f19556a;
            a.a("half_width", Integer.valueOf((eventsThemeSelectionRecyclerViewWrapper.f19565i.c() - (eventsThemeSelectionRecyclerViewWrapper.f19557a.getResources().getDimensionPixelSize(2131434029) * (eventsThemeSelectionRecyclerViewWrapper.f19568l - 1))) / eventsThemeSelectionRecyclerViewWrapper.f19568l));
            a.a("half_height", Integer.valueOf(1));
            a.a("full_width", Integer.valueOf(this.f19556a.f19565i.c()));
            a.a("full_height", Integer.valueOf(1));
            a.a("count", Integer.valueOf(connectionFetchOperation.e));
            a.a("end_cursor", connectionFetchOperation.d);
            if (this.f19556a.f19560d != null) {
                a.a("theme_category_id", this.f19556a.f19560d);
            }
            if (!(this.f19556a.f19558b == null && this.f19556a.f19559c == null) && this.f19556a.f19564h.a(ExperimentsForThemeSelectorModule.f19602a, false)) {
                EventInfo eventInfo = new EventInfo();
                eventInfo.a(this.f19556a.f19558b).b(this.f19556a.f19559c);
                a.a("event_info", eventInfo);
            }
            return a;
        }

        public final ConnectionPage<NodesModel> m19769a(GraphQLResult<EventsThemeSuggestionsModel> graphQLResult) {
            EventThemesModel a = ((EventsThemeSuggestionsModel) graphQLResult.e).m19864a();
            return new ConnectionPage(a.m19859a(), a.m19861j());
        }
    }

    @Inject
    public EventsThemeSelectionRecyclerViewWrapper(@Assisted String str, @Assisted String str2, @Assisted Integer num, @Assisted String str3, Context context, QeAccessor qeAccessor, ScreenUtil screenUtil, ConnectionControllerBuilderProvider connectionControllerBuilderProvider) {
        this.f19558b = str;
        this.f19559c = str2;
        this.f19568l = num.intValue();
        this.f19560d = str3;
        this.f19557a = context;
        this.f19564h = qeAccessor;
        this.f19565i = screenUtil;
        this.f19566j = connectionControllerBuilderProvider;
    }

    private RecyclerView m19771a() {
        if (this.f19561e != null) {
            return this.f19561e;
        }
        this.f19562f = new ThemeSelectionRecyclerViewAdapter();
        this.f19562f.f19580b = this.f19568l;
        this.f19561e = new RecyclerView(this.f19557a);
        RecyclerView recyclerView = this.f19561e;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.f19557a, this.f19568l);
        gridLayoutManager.h = new C27842(this);
        recyclerView.setLayoutManager(gridLayoutManager);
        this.f19561e.setAdapter(this.f19562f);
        this.f19561e.setOnScrollListener(new C27831(this));
        this.f19561e.a(new SpaceItemDecoration(this.f19557a.getResources().getDimensionPixelSize(2131434029), this.f19568l, this.f19557a.getResources().getDimensionPixelSize(2131434030)));
        this.f19563g = this.f19566j.a("/event/" + this.f19558b + "/theme/" + this.f19560d, new EventsThemeSuggestionsModelSimpleConnectionConfiguration(this)).a();
        this.f19563g.a(new EventsThemeSuggestionsModelConnectionListener(this));
        this.f19563g.a(12, null);
        return this.f19561e;
    }

    public final void m19772a(ViewGroup viewGroup) {
        if (!this.f19567k) {
            viewGroup.addView(m19771a());
            this.f19567k = true;
        }
    }

    public final void m19773b(ViewGroup viewGroup) {
        if (this.f19567k) {
            viewGroup.removeView(m19771a());
            this.f19567k = false;
        }
    }
}
