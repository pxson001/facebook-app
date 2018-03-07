package com.facebook.entitycards.contextitems.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.entitycards.contextitems.analytics.ContextItemsAnalyticsLogger;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQuery.ContextItemsQueryString;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemFieldsModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionFragmentModel.EdgesModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsConnectionWithPageInfoFragmentModel;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.ContextItemsQueryModel;
import com.facebook.entitycards.contextitems.handler.ContextItemsOnClickListener;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: impression_time */
public class ContextItemsContainer extends SegmentedLinearLayout {
    @Inject
    ContextItemsAnalyticsLogger f10929a;
    @Inject
    GraphQLQueryExecutor f10930b;
    @Inject
    Resources f10931c;
    @Inject
    TasksManager f10932d;
    private final OnClickListener f10933e = new ItemClickListener(this);
    private final OnClickListener f10934f = new LoadMoreClickListener(this);
    @Nullable
    public ContextItemsOnClickListener f10935g;
    public ContextItemsAdapter f10936h;
    public String f10937i;
    public String f10938j;

    /* compiled from: impression_time */
    class C11711 extends DataSetObserver {
        final /* synthetic */ ContextItemsContainer f10922a;

        C11711(ContextItemsContainer contextItemsContainer) {
            this.f10922a = contextItemsContainer;
        }

        public void onChanged() {
            this.f10922a.f10936h;
        }
    }

    /* compiled from: impression_time */
    class ItemClickListener implements OnClickListener {
        final /* synthetic */ ContextItemsContainer f10923a;

        public ItemClickListener(ContextItemsContainer contextItemsContainer) {
            this.f10923a = contextItemsContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1804427208);
            if (this.f10923a.f10935g != null) {
                EdgesModel edgesModel = (EdgesModel) view.getTag(2131558586);
                ContextItemFieldsModel a2 = edgesModel.a();
                this.f10923a.f10929a.m12851a(this.f10923a.f10936h.f10917f, a2.d().name(), this.f10923a.f10936h.m12861c(), ((Integer) view.getTag(2131558587)).intValue(), Optional.fromNullable(a2.bA_()));
                this.f10923a.f10935g.mo1157a(view, edgesModel.a());
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1635667459, a);
        }
    }

    /* compiled from: impression_time */
    class LoadMoreClickListener implements OnClickListener {
        final /* synthetic */ ContextItemsContainer f10928a;

        public LoadMoreClickListener(ContextItemsContainer contextItemsContainer) {
            this.f10928a = contextItemsContainer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2081052188);
            final ContextItemsLoadMoreView contextItemsLoadMoreView = (ContextItemsLoadMoreView) view;
            contextItemsLoadMoreView.m12876a(true);
            GraphQlQueryString contextItemsQueryString = new ContextItemsQueryString();
            contextItemsQueryString.a("node_id", this.f10928a.f10936h.m12861c()).a("context_items_source", this.f10928a.f10937i).a("context_items_source_id", this.f10928a.f10938j).a("context_items_surface", this.f10928a.f10936h.f10917f.name).a("context_item_icon_size", String.valueOf(this.f10928a.f10931c.getDimensionPixelSize(2131429771))).a("scale", GraphQlQueryDefaults.a()).a("after_cursor", this.f10928a.f10936h.f10920i).a("first_count", String.valueOf(this.f10928a.f10931c.getInteger(2131492897)));
            final GraphQLQueryFuture a2 = this.f10928a.f10930b.a(GraphQLRequest.a(contextItemsQueryString).a(GraphQLCachePolicy.c));
            this.f10928a.f10932d.a(TASK.LOAD_MORE_CONTEXT_ITEMS, new Callable<ListenableFuture<GraphQLResult<ContextItemsQueryModel>>>(this) {
                final /* synthetic */ LoadMoreClickListener f10925b;

                public Object call() {
                    return a2;
                }
            }, new AbstractDisposableFutureCallback<GraphQLResult<ContextItemsQueryModel>>(this) {
                final /* synthetic */ LoadMoreClickListener f10927b;

                protected final void m12862a(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    if (this.f10927b.f10928a.f10936h != null && graphQLResult != null && graphQLResult.e != null && ((ContextItemsQueryModel) graphQLResult.e).a() != null) {
                        ContextItemsAdapter contextItemsAdapter = this.f10927b.f10928a.f10936h;
                        ContextItemsConnectionWithPageInfoFragmentModel a = ((ContextItemsQueryModel) graphQLResult.e).a();
                        if (a != null) {
                            contextItemsAdapter.f10916e = ImmutableList.builder().b(contextItemsAdapter.f10916e).b(a.a()).b();
                            if (a.b() != null) {
                                contextItemsAdapter.f10919h = a.b().b();
                                contextItemsAdapter.f10920i = a.b().a();
                            }
                            AdapterDetour.a(contextItemsAdapter, 2141038848);
                        }
                    }
                }

                protected final void m12863a(Throwable th) {
                    contextItemsLoadMoreView.m12876a(false);
                }
            });
            this.f10928a.f10929a.m12854b(this.f10928a.f10936h.m12861c(), ((Integer) view.getTag(2131558587)).intValue());
            Logger.a(2, EntryType.UI_INPUT_END, 353745586, a);
        }
    }

    /* compiled from: impression_time */
    enum TASK {
        LOAD_MORE_CONTEXT_ITEMS
    }

    private static <T extends View> void m12866a(Class<T> cls, T t) {
        m12867a((Object) t, t.getContext());
    }

    private static void m12867a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ContextItemsContainer) obj).m12864a(ContextItemsAnalyticsLogger.m12848a(fbInjector), GraphQLQueryExecutor.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector), TasksManager.b(fbInjector));
    }

    private void m12864a(ContextItemsAnalyticsLogger contextItemsAnalyticsLogger, GraphQLQueryExecutor graphQLQueryExecutor, Resources resources, TasksManager tasksManager) {
        this.f10929a = contextItemsAnalyticsLogger;
        this.f10930b = graphQLQueryExecutor;
        this.f10931c = resources;
        this.f10932d = tasksManager;
    }

    public ContextItemsContainer(Context context) {
        super(context);
        m12869b();
    }

    public ContextItemsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12869b();
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1431378347);
        super.onDetachedFromWindow();
        if (this.f10932d != null) {
            this.f10932d.c();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1213141236, a);
    }

    public void setOnItemClickListener(ContextItemsOnClickListener contextItemsOnClickListener) {
        this.f10935g = contextItemsOnClickListener;
    }

    public void setAdapter(ContextItemsAdapter contextItemsAdapter) {
        this.f10936h = contextItemsAdapter;
        this.f10936h.registerDataSetObserver(new C11711(this));
    }

    public final void m12875a(String str, String str2) {
        this.f10937i = str;
        this.f10938j = str2;
    }

    public final void m12874a() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setOnClickListener(null);
        }
    }

    private void m12869b() {
        m12866a(ContextItemsContainer.class, (View) this);
        setSegmentedDivider(getResources().getDrawable(2130838280));
        setShowSegmentedDividers(2);
        setSegmentedDividerThickness(1);
    }

    public static void m12871c(ContextItemsContainer contextItemsContainer) {
        contextItemsContainer.removeAllViews();
        int count = contextItemsContainer.f10936h.getCount();
        for (int i = 0; i < count; i++) {
            View view = contextItemsContainer.f10936h.getView(i, null, contextItemsContainer);
            if (view instanceof ContextItemsLoadMoreView) {
                contextItemsContainer.f10929a.m12852a(contextItemsContainer.f10936h.m12861c(), i);
                view.setTag(2131558587, Integer.valueOf(i));
                view.setOnClickListener(contextItemsContainer.f10934f);
            } else {
                EdgesModel edgesModel = (EdgesModel) contextItemsContainer.f10936h.getItem(i);
                ContextItemFieldsModel a = edgesModel.a();
                view.setTag(2131558586, edgesModel);
                view.setTag(2131558587, Integer.valueOf(i));
                view.setOnClickListener(contextItemsContainer.f10933e);
                contextItemsContainer.f10929a.m12853b(contextItemsContainer.f10936h.f10917f, a.d().name(), contextItemsContainer.f10936h.m12861c(), i, Optional.fromNullable(a.bA_()));
            }
            contextItemsContainer.addView(view);
        }
    }
}
