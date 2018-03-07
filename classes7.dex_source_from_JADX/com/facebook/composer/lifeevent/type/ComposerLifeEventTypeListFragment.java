package com.facebook.composer.lifeevent.type;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.EditText;
import android.widget.Filter.FilterListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.FBLifeEventSuggestionsQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.FBLifeEventSuggestionsQueryModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.FBLifeEventSuggestionsQueryModel.LifeEventCategoriesModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventCategoriesFieldsModel;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.OnDrawListenerSet.OnDrawListener;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: copyright_monitor_fetching */
public class ComposerLifeEventTypeListFragment extends FbFragment {
    @Inject
    InputMethodManager f16785a;
    public ComposerLifeEventTypeSuggestionListModel al;
    public boolean am = false;
    public OnClickListener an;
    public OnClickListener ao;
    public ComposerLifeEventTypeListAdapter ap;
    public RetryTrigger aq;
    public final FilterListener ar = new C13497(this);
    private final TextWatcher as = new C13508(this);
    @Inject
    ComposerLifeEventTypeListAdapterProvider f16786b;
    @Inject
    GraphQLQueryExecutor f16787c;
    @Inject
    @ForUiThread
    ListeningScheduledExecutorService f16788d;
    @Inject
    QuickPerformanceLogger f16789e;
    public BetterListView f16790f;
    public EditText f16791g;
    public View f16792h;
    public LoadingIndicatorView f16793i;

    /* compiled from: copyright_monitor_fetching */
    class C13431 implements OnFocusChangeListener {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16776a;

        C13431(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16776a = composerLifeEventTypeListFragment;
        }

        public void onFocusChange(View view, boolean z) {
            this.f16776a.m20806b();
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13442 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16777a;

        C13442(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16777a = composerLifeEventTypeListFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1687477588);
            this.f16777a.f16791g.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, -1188121335, a);
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13453 implements OnScrollListener {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16778a;

        C13453(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16778a = composerLifeEventTypeListFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f16778a.m20806b();
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13464 implements OnDrawListener {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16779a;

        C13464(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16779a = composerLifeEventTypeListFragment;
        }

        public final boolean gD_() {
            if (!this.f16779a.am) {
                return false;
            }
            this.f16779a.f16789e.b(1703973, (short) 5);
            return true;
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13475 implements Function<GraphQLResult<FBLifeEventSuggestionsQueryModel>, ComposerLifeEventTypeSuggestionListModel> {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16780a;

        C13475(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16780a = composerLifeEventTypeListFragment;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((FBLifeEventSuggestionsQueryModel) graphQLResult.e).a() == null) {
                return null;
            }
            ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel = new ComposerLifeEventTypeSuggestionListModel();
            LifeEventCategoriesModel a = ((FBLifeEventSuggestionsQueryModel) graphQLResult.e).a();
            Builder builder = new Builder();
            Map hashMap = new HashMap();
            ImmutableList k = a.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                LifeEventCategoriesFieldsModel lifeEventCategoriesFieldsModel = (LifeEventCategoriesFieldsModel) k.get(i);
                builder.c(new ComposerLifeEventTypeSuggestionCategoryModel(lifeEventCategoriesFieldsModel));
                ImmutableList a2 = lifeEventCategoriesFieldsModel.a().a();
                int size2 = a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    LifeEventFieldsModel lifeEventFieldsModel = (LifeEventFieldsModel) a2.get(i2);
                    hashMap.put(lifeEventFieldsModel.a(), lifeEventFieldsModel);
                }
            }
            composerLifeEventTypeSuggestionListModel.f16801a = ImmutableList.copyOf(hashMap.values());
            composerLifeEventTypeSuggestionListModel.f16803c = builder.b();
            composerLifeEventTypeSuggestionListModel.f16802b = a.j();
            composerLifeEventTypeSuggestionListModel.f16804d = a.a();
            return composerLifeEventTypeSuggestionListModel;
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13486 implements FutureCallback<ComposerLifeEventTypeSuggestionListModel> {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16781a;

        C13486(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16781a = composerLifeEventTypeListFragment;
        }

        public void onSuccess(Object obj) {
            ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel = (ComposerLifeEventTypeSuggestionListModel) obj;
            if (this.f16781a.f16793i != null) {
                this.f16781a.f16793i.b();
            }
            if (composerLifeEventTypeSuggestionListModel == null) {
                this.f16781a.f16789e.b(1703973, (short) 2);
                return;
            }
            this.f16781a.am = true;
            ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel2 = this.f16781a.al;
            composerLifeEventTypeSuggestionListModel2.f16801a = composerLifeEventTypeSuggestionListModel.f16801a;
            composerLifeEventTypeSuggestionListModel2.f16802b = composerLifeEventTypeSuggestionListModel.f16802b;
            composerLifeEventTypeSuggestionListModel2.f16803c = composerLifeEventTypeSuggestionListModel.f16803c;
            composerLifeEventTypeSuggestionListModel2.f16804d = composerLifeEventTypeSuggestionListModel.f16804d;
            this.f16781a.al.getFilter().filter(this.f16781a.f16791g.getText(), this.f16781a.ar);
        }

        public void onFailure(Throwable th) {
            this.f16781a.f16789e.b(1703973, (short) 3);
            if (this.f16781a.f16793i != null && this.f16781a.E != null && this.f16781a.jW_() != null) {
                this.f16781a.f16793i.a(this.f16781a.b(2131230761), this.f16781a.aq);
            }
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13497 implements FilterListener {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16782a;

        C13497(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16782a = composerLifeEventTypeListFragment;
        }

        public void onFilterComplete(int i) {
            if (this.f16782a.ap != null) {
                AdapterDetour.a(this.f16782a.ap, -25644619);
            }
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class C13508 implements TextWatcher {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16783a;

        C13508(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16783a = composerLifeEventTypeListFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f16783a.f16792h.setVisibility(StringUtil.a(charSequence) ? 8 : 0);
            if (this.f16783a.al != null) {
                this.f16783a.al.getFilter().filter(charSequence, this.f16783a.ar);
                this.f16783a.f16790f.smoothScrollToPosition(0);
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    /* compiled from: copyright_monitor_fetching */
    class RetryTrigger implements RetryClickedListener {
        final /* synthetic */ ComposerLifeEventTypeListFragment f16784a;

        public RetryTrigger(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
            this.f16784a = composerLifeEventTypeListFragment;
        }

        public final void m20799a() {
            ComposerLifeEventTypeListFragment.m20802e(this.f16784a);
        }
    }

    public static void m20801a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ComposerLifeEventTypeListFragment) obj).m20800a(InputMethodManagerMethodAutoProvider.b(fbInjector), (ComposerLifeEventTypeListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ComposerLifeEventTypeListAdapterProvider.class), GraphQLQueryExecutor.a(fbInjector), ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), QuickPerformanceLoggerMethodAutoProvider.a(fbInjector));
    }

    private void m20800a(InputMethodManager inputMethodManager, ComposerLifeEventTypeListAdapterProvider composerLifeEventTypeListAdapterProvider, GraphQLQueryExecutor graphQLQueryExecutor, ListeningScheduledExecutorService listeningScheduledExecutorService, QuickPerformanceLogger quickPerformanceLogger) {
        this.f16785a = inputMethodManager;
        this.f16786b = composerLifeEventTypeListAdapterProvider;
        this.f16787c = graphQLQueryExecutor;
        this.f16788d = listeningScheduledExecutorService;
        this.f16789e = quickPerformanceLogger;
    }

    public final void m20807c(Bundle bundle) {
        super.c(bundle);
        Class cls = ComposerLifeEventTypeListFragment.class;
        m20801a((Object) this, getContext());
        this.aq = new RetryTrigger(this);
        this.f16789e.b(1703973);
    }

    public final View m20804a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -797382418);
        View inflate = layoutInflater.inflate(2130903690, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1820236683, a);
        return inflate;
    }

    public final void m20805a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f16793i = (LoadingIndicatorView) FindViewUtil.b(view, 2131560537);
        this.al = new ComposerLifeEventTypeSuggestionListModel();
        this.ap = this.f16786b.m20798a(getContext(), this.al, this.an, this.ao);
        this.f16790f = (BetterListView) view.findViewById(2131560547);
        this.f16790f.setAdapter(this.ap);
        this.f16791g = (EditText) view.findViewById(2131560545);
        this.f16791g.setOnFocusChangeListener(new C13431(this));
        this.f16792h = view.findViewById(2131560546);
        this.f16792h.setOnClickListener(new C13442(this));
        this.f16790f.a(new C13453(this));
        this.f16790f.setOnDrawListenerTo(new C13464(this));
        this.f16791g.addTextChangedListener(this.as);
        m20802e(this);
    }

    public final void m20803H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1292570183);
        super.H();
        this.f16789e.d(1703973);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 914755519, a);
    }

    public static void m20802e(ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment) {
        if (composerLifeEventTypeListFragment.f16793i != null) {
            composerLifeEventTypeListFragment.f16793i.a();
            GraphQlQueryString fBLifeEventSuggestionsQueryString = new FBLifeEventSuggestionsQueryString();
            fBLifeEventSuggestionsQueryString.a("scale", GraphQlQueryDefaults.a());
            Futures.a(Futures.a(composerLifeEventTypeListFragment.f16787c.a(GraphQLRequest.a(fBLifeEventSuggestionsQueryString).a(GraphQLCachePolicy.a).a(86400)), new C13475(composerLifeEventTypeListFragment), MoreExecutors.a()), new C13486(composerLifeEventTypeListFragment), composerLifeEventTypeListFragment.f16788d);
        }
    }

    public final void m20806b() {
        if (this.f16785a != null && this.f16791g != null) {
            this.f16785a.hideSoftInputFromWindow(this.f16791g.getWindowToken(), 0);
        }
    }
}
