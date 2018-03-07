package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ExpandableListView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.intent.SearchFilterTypeaheadIntentBuilder;
import com.facebook.search.results.filters.definition.FilterPersistentState;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinitionRegistry;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsInterfaces.SearchResultPageMainFilterFragment.MainFilter;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValueNodeFragmentModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel.EdgesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: SINGLE_MEDIA */
public class SearchResultPageFilterFragment extends FbDialogFragment {
    @Inject
    public SearchResultFilterExpandableListAdapterProvider am;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SearchFilterTypeaheadIntentBuilder> an = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<SecureContextHelper> ao = UltralightRuntime.b;
    public ImmutableList<? extends MainFilter> ap;
    public OnFilterValuesSelectedListener aq;
    public SearchResultFilterExpandableListAdapter ar;
    private ExpandableListView as;
    private CustomLinearLayout at;
    private BetterButton au;
    private BetterButton av;
    private BetterTextView aw;

    /* compiled from: SINGLE_MEDIA */
    public class C24411 {
        public final /* synthetic */ SearchResultPageFilterFragment f22930a;

        C24411(SearchResultPageFilterFragment searchResultPageFilterFragment) {
            this.f22930a = searchResultPageFilterFragment;
        }
    }

    /* compiled from: SINGLE_MEDIA */
    class C24422 implements OnClickListener {
        final /* synthetic */ SearchResultPageFilterFragment f22931a;

        C24422(SearchResultPageFilterFragment searchResultPageFilterFragment) {
            this.f22931a = searchResultPageFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1342130963);
            this.f22931a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 598278095, a);
        }
    }

    /* compiled from: SINGLE_MEDIA */
    class C24433 implements OnClickListener {
        final /* synthetic */ SearchResultPageFilterFragment f22932a;

        C24433(SearchResultPageFilterFragment searchResultPageFilterFragment) {
            this.f22932a = searchResultPageFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 332945123);
            this.f22932a.a();
            Logger.a(2, EntryType.UI_INPUT_END, 2032079657, a);
        }
    }

    /* compiled from: SINGLE_MEDIA */
    class C24444 implements OnClickListener {
        final /* synthetic */ SearchResultPageFilterFragment f22933a;

        C24444(SearchResultPageFilterFragment searchResultPageFilterFragment) {
            this.f22933a = searchResultPageFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -648357095);
            if (this.f22933a.aq != null) {
                OnFilterValuesSelectedListener onFilterValuesSelectedListener = this.f22933a.aq;
                SearchResultFilterExpandableListAdapter searchResultFilterExpandableListAdapter = this.f22933a.ar;
                Builder builder = new Builder();
                int size = searchResultFilterExpandableListAdapter.f22923c.size();
                for (int i = 0; i < size; i++) {
                    MainFilterModel mainFilterModel = (MainFilterModel) searchResultFilterExpandableListAdapter.f22923c.get(i);
                    FilterPersistentState filterPersistentState = (FilterPersistentState) searchResultFilterExpandableListAdapter.f22924d.get(mainFilterModel.jo_());
                    if (!(filterPersistentState == null || filterPersistentState.f22798c.b().get("value") == null || filterPersistentState.f22798c.b().get("value").equals("default"))) {
                        builder.c(searchResultFilterExpandableListAdapter.f22924d.get(mainFilterModel.jo_()));
                    }
                }
                onFilterValuesSelectedListener.mo1285a(builder.b());
            }
            this.f22933a.a();
            Logger.a(2, EntryType.UI_INPUT_END, -266410859, a);
        }
    }

    /* compiled from: SINGLE_MEDIA */
    class C24455 implements OnClickListener {
        final /* synthetic */ SearchResultPageFilterFragment f22934a;

        C24455(SearchResultPageFilterFragment searchResultPageFilterFragment) {
            this.f22934a = searchResultPageFilterFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1513383343);
            Builder builder = new Builder();
            int size = this.f22934a.ap.size();
            for (int i = 0; i < size; i++) {
                MainFilterModel mainFilterModel = (MainFilterModel) this.f22934a.ap.get(i);
                Builder builder2 = new Builder();
                ImmutableList a2 = mainFilterModel.m10187d().m10165a();
                int size2 = a2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    EdgesModel edgesModel = (EdgesModel) a2.get(i2);
                    SearchResultPageFilterValueNodeFragmentModel a3 = SearchResultPageFilterValueNodeFragmentModel.m10143a(edgesModel.m10160a());
                    SearchResultPageFilterValueNodeFragmentModel.Builder builder3 = new SearchResultPageFilterValueNodeFragmentModel.Builder();
                    builder3.f8695a = a3.m10147a();
                    builder3.f8696b = a3.m10148b();
                    builder3.f8697c = a3.m10149c();
                    SearchResultPageFilterValueNodeFragmentModel.Builder builder4 = builder3;
                    builder4.f8695a = edgesModel.m10160a().m10149c().equals("default");
                    EdgesModel.Builder builder5 = new EdgesModel.Builder();
                    builder5.f8702a = builder4.m10140a();
                    builder2.c(builder5.m10153a());
                }
                FilterValuesModel.Builder builder6 = new FilterValuesModel.Builder();
                builder6.f8701a = builder2.b();
                FilterValuesModel a4 = builder6.m10151a();
                MainFilterModel.Builder a5 = MainFilterModel.Builder.m10177a(MainFilterModel.m10181a(mainFilterModel));
                a5.f8710c = a4;
                builder.c(a5.m10178a());
            }
            this.f22934a.ap = builder.b();
            this.f22934a.ar.m26548a(this.f22934a.ap);
            LogUtils.a(966095895, a);
        }
    }

    /* compiled from: SINGLE_MEDIA */
    public interface OnFilterValuesSelectedListener {
        void mo1285a(ImmutableList<FilterPersistentState> immutableList);
    }

    public static void m26555a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SearchResultPageFilterFragment searchResultPageFilterFragment = (SearchResultPageFilterFragment) obj;
        SearchResultFilterExpandableListAdapterProvider searchResultFilterExpandableListAdapterProvider = (SearchResultFilterExpandableListAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(SearchResultFilterExpandableListAdapterProvider.class);
        com.facebook.inject.Lazy a = IdBasedLazy.a(fbInjector, 10488);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 968);
        searchResultPageFilterFragment.am = searchResultFilterExpandableListAdapterProvider;
        searchResultPageFilterFragment.an = a;
        searchResultPageFilterFragment.ao = b;
    }

    public static SearchResultPageFilterFragment m26554a(ImmutableList<? extends MainFilter> immutableList, OnFilterValuesSelectedListener onFilterValuesSelectedListener) {
        SearchResultPageFilterFragment searchResultPageFilterFragment = new SearchResultPageFilterFragment();
        searchResultPageFilterFragment.a(2, 2131625941);
        Bundle bundle = new Bundle();
        FlatBufferModelHelper.a(bundle, "main_filter_list", immutableList);
        searchResultPageFilterFragment.g(bundle);
        searchResultPageFilterFragment.aq = onFilterValuesSelectedListener;
        return searchResultPageFilterFragment;
    }

    public final void m26559a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 408520657);
        super.a(bundle);
        Class cls = SearchResultPageFilterFragment.class;
        m26555a((Object) this, getContext());
        this.ar = new SearchResultFilterExpandableListAdapter(new C24411(this), SearchResultPageFilterDefinitionRegistry.m26462b(this.am));
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.ap = ImmutableList.copyOf(FlatBufferModelHelper.b(bundle2, "main_filter_list"));
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -477977924, a);
    }

    public final View m26557a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1342847485);
        this.f.getWindow().requestFeature(1);
        View inflate = layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), 2131624473)).inflate(2130906987, viewGroup, true);
        this.as = (ExpandableListView) FindViewUtil.b(inflate, 2131567275);
        this.ar.m26548a(this.ap);
        this.as.setAdapter(this.ar);
        this.as.expandGroup(0);
        this.as.expandGroup(1);
        this.at = (CustomLinearLayout) FindViewUtil.b(inflate, 2131567276);
        this.au = (BetterButton) FindViewUtil.b(this.at, 2131560414);
        this.av = (BetterButton) FindViewUtil.b(this.at, 2131561534);
        this.aw = (BetterTextView) FindViewUtil.b(inflate, 2131559778);
        inflate.setOnClickListener(new C24422(this));
        this.au.setOnClickListener(new C24433(this));
        this.av.setOnClickListener(new C24444(this));
        this.aw.setOnClickListener(new C24455(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1756329680, a);
        return inflate;
    }

    public final void m26556G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 965906758);
        super.G();
        Window window = this.f.getWindow();
        window.setGravity(80);
        window.setLayout(-1, -2);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1354484688, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 252888312);
        super.mY_();
        this.au = null;
        this.av = null;
        this.aw = null;
        this.as.removeFooterView(this.at);
        this.at = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 766102758, a);
    }

    public final void m26558a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1 && i == 0) {
            String stringExtra = intent.getStringExtra("filter_value_group_name");
            String stringExtra2 = intent.getStringExtra("filter_value_selected_text");
            String stringExtra3 = intent.getStringExtra("filter_value_selected_value");
            SearchResultFilterExpandableListAdapter searchResultFilterExpandableListAdapter = this.ar;
            searchResultFilterExpandableListAdapter.f22925e.m26546a(new FilterPersistentState(stringExtra, stringExtra2, stringExtra3));
        }
    }
}
