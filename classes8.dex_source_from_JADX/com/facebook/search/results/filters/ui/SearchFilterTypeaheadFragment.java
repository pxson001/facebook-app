package com.facebook.search.results.filters.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.model.NeedleFilter;
import com.facebook.search.results.filters.controller.FilterValueSearchController;
import com.facebook.search.results.filters.controller.FilterValueSearchControllerProvider;
import com.facebook.search.results.filters.loader.OnFilterValuesFetchedListener;
import com.facebook.search.results.protocol.filters.FilterValue;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.search.SearchEditText;
import com.facebook.ui.search.SearchEditText.OnSubmitListener;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.ui.titlebar.Fb4aTitleBarSupplier;
import com.facebook.ui.typeahead.SearchResponse;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.BetterListView.OnTouchDownListener;
import com.facebook.widget.titlebar.FbTitleBarSupplier;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
public class SearchFilterTypeaheadFragment extends FbFragment {
    @Inject
    public FilterValueSearchControllerProvider f22909a;
    @Inject
    public FilterTypeaheadAdapterProvider f22910b;
    @Inject
    public FbTitleBarSupplier f22911c;
    public FilterValueSearchController f22912d;
    public NeedleFilter f22913e;
    public BetterListView f22914f;
    public SearchEditText f22915g;
    public GlyphView f22916h;
    public FilterTypeaheadAdapter f22917i;

    /* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
    class C24361 implements OnItemClickListener {
        final /* synthetic */ SearchFilterTypeaheadFragment f22903a;

        C24361(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment) {
            this.f22903a = searchFilterTypeaheadFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (i < 0 || i > this.f22903a.f22917i.getCount()) {
                this.f22903a.o().finish();
            } else {
                SearchFilterTypeaheadFragment.m26541a(this.f22903a, this.f22903a.f22917i.m26519a(i));
            }
        }
    }

    /* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
    class C24372 implements OnClickListener {
        final /* synthetic */ SearchFilterTypeaheadFragment f22904a;

        C24372(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment) {
            this.f22904a = searchFilterTypeaheadFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 188827700);
            this.f22904a.f22915g.a();
            Logger.a(2, EntryType.UI_INPUT_END, -1758905428, a);
        }
    }

    /* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
    class C24383 implements OnTouchDownListener {
        final /* synthetic */ SearchFilterTypeaheadFragment f22905a;

        C24383(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment) {
            this.f22905a = searchFilterTypeaheadFragment;
        }

        public final void m26536a() {
            this.f22905a.f22915g.c();
        }
    }

    /* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
    class C24394 implements OnSubmitListener {
        final /* synthetic */ SearchFilterTypeaheadFragment f22906a;

        C24394(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment) {
            this.f22906a = searchFilterTypeaheadFragment;
        }

        public final void m26537a() {
            if (this.f22906a.f22917i != null && this.f22906a.f22917i.f22867f != null) {
                SearchFilterTypeaheadFragment.m26541a(this.f22906a, this.f22906a.f22917i.f22867f);
            }
        }
    }

    /* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
    class FilterValueListener implements OnFilterValuesFetchedListener {
        final /* synthetic */ SearchFilterTypeaheadFragment f22907a;

        public final void mo1270a(String str, String str2, String str3, SearchResponse<FilterValue> searchResponse) {
            if (searchResponse.b != null && this.f22907a.f22917i != null) {
                FilterTypeaheadAdapter filterTypeaheadAdapter = this.f22907a.f22917i;
                Iterable iterable = searchResponse.b;
                Builder builder = ImmutableList.builder();
                if (filterTypeaheadAdapter.f22864c && filterTypeaheadAdapter.f22867f != null) {
                    builder.c(filterTypeaheadAdapter.f22867f);
                }
                filterTypeaheadAdapter.f22869h = builder.b(iterable).b();
                AdapterDetour.a(filterTypeaheadAdapter, -408676034);
            }
        }

        public FilterValueListener(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment) {
            this.f22907a = searchFilterTypeaheadFragment;
        }

        public final void mo1269a(String str) {
        }

        public final void mo1271b(String str) {
        }
    }

    /* compiled from: SLIDESHOW_ATTACHMENT_EDIT */
    class TextListener implements TextWatcher {
        final /* synthetic */ SearchFilterTypeaheadFragment f22908a;

        public TextListener(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment) {
            this.f22908a = searchFilterTypeaheadFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            String str;
            if (editable == null || editable.length() <= 0) {
                this.f22908a.f22916h.setVisibility(8);
            } else {
                this.f22908a.f22916h.setVisibility(0);
            }
            FilterTypeaheadAdapter filterTypeaheadAdapter = this.f22908a.f22917i;
            if (editable == null) {
                str = "";
            } else {
                str = editable.toString();
            }
            if (filterTypeaheadAdapter.f22864c) {
                FilterValue filterValue;
                filterTypeaheadAdapter.f22868g = new SpannableString(Html.fromHtml(filterTypeaheadAdapter.f22863b.getResources().getString(2131237399, new Object[]{filterTypeaheadAdapter.f22866e, str})));
                if (Strings.isNullOrEmpty(str)) {
                    filterValue = null;
                } else {
                    FilterValue.Builder g = FilterValue.m10136g();
                    g.f8683a = str;
                    g = g;
                    g.f8684b = str;
                    g = g;
                    g.f8685c = str;
                    filterValue = g.m10135f();
                }
                filterTypeaheadAdapter.f22867f = filterValue;
            }
            this.f22908a.f22912d.m26420a(editable.toString());
        }
    }

    public static void m26542a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SearchFilterTypeaheadFragment searchFilterTypeaheadFragment = (SearchFilterTypeaheadFragment) obj;
        FilterValueSearchControllerProvider filterValueSearchControllerProvider = (FilterValueSearchControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FilterValueSearchControllerProvider.class);
        FilterTypeaheadAdapterProvider filterTypeaheadAdapterProvider = (FilterTypeaheadAdapterProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FilterTypeaheadAdapterProvider.class);
        FbTitleBarSupplier fbTitleBarSupplier = (FbTitleBarSupplier) Fb4aTitleBarSupplier.a(fbInjector);
        searchFilterTypeaheadFragment.f22909a = filterValueSearchControllerProvider;
        searchFilterTypeaheadFragment.f22910b = filterTypeaheadAdapterProvider;
        searchFilterTypeaheadFragment.f22911c = fbTitleBarSupplier;
    }

    public final void m26544c(Bundle bundle) {
        super.c(bundle);
        Class cls = SearchFilterTypeaheadFragment.class;
        m26542a((Object) this, getContext());
        this.f22912d = this.f22909a.m26421a(new FilterValueListener(this));
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            String string = bundle2.getString("search_filter_id");
            String string2 = bundle2.getString("search_filter_name");
            String string3 = bundle2.getString("search_filter_text");
            NeedleFilter.Builder builder = new NeedleFilter.Builder();
            builder.f22167a = string;
            NeedleFilter.Builder builder2 = builder;
            builder2.f22168b = string2;
            builder2 = builder2;
            builder2.f22169c = string3;
            this.f22913e = builder2.m25678a();
        }
    }

    public final View m26543a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1696619216);
        View inflate = layoutInflater.inflate(2130906974, viewGroup, false);
        this.f22914f = (BetterListView) FindViewUtil.b(inflate, 2131567266);
        this.f22914f.setOnItemClickListener(new C24361(this));
        this.f22916h = (GlyphView) FindViewUtil.b(inflate, 2131562544);
        this.f22916h.setOnClickListener(new C24372(this));
        this.f22914f.y = new C24383(this);
        this.f22915g = (SearchEditText) FindViewUtil.b(inflate, 2131562543);
        this.f22915g.setHint(getContext().getString(2131237384));
        this.f22915g.addTextChangedListener(new TextListener(this));
        this.f22915g.f = new C24394(this);
        FilterTypeaheadAdapterProvider filterTypeaheadAdapterProvider = this.f22910b;
        this.f22917i = new FilterTypeaheadAdapter(this.f22913e.f22172b, this.f22913e.f22173c, (Context) filterTypeaheadAdapterProvider.getInstance(Context.class), GlyphColorizer.a(filterTypeaheadAdapterProvider));
        this.f22914f.setAdapter(this.f22917i);
        this.f22912d.f22779h = this.f22913e;
        this.f22915g.a();
        this.f22914f.smoothScrollToPosition(0);
        this.f22912d.m26420a(this.f22915g.getText().toString());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1242945644, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1775781761);
        super.mi_();
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) this.f22911c.get();
        if (fb4aTitleBar != null) {
            fb4aTitleBar.setSearchButtonVisible(false);
            fb4aTitleBar.setTitle(this.f22913e.f22173c);
        }
        this.f22915g.b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1037180159, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 780085789);
        super.mY_();
        this.f22914f = null;
        this.f22915g = null;
        this.f22917i = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1173684032, a);
    }

    public static void m26541a(SearchFilterTypeaheadFragment searchFilterTypeaheadFragment, FilterValue filterValue) {
        Intent intent = new Intent();
        intent.putExtra("filter_value_group_name", searchFilterTypeaheadFragment.f22913e.f22172b);
        intent.putExtra("filter_value_selected_text", filterValue.f8691c);
        intent.putExtra("filter_value_selected_value", filterValue.f8690b);
        searchFilterTypeaheadFragment.o().setResult(-1, intent);
        searchFilterTypeaheadFragment.o().finish();
    }
}
