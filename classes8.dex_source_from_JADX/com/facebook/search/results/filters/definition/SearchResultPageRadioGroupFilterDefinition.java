package com.facebook.search.results.filters.definition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.FilterPillData;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.ViewSpec;
import com.facebook.search.results.filters.ui.SearchFilterRadioButton;
import com.facebook.search.results.filters.ui.SearchFilterRadioGroup;
import com.facebook.search.results.filters.ui.SearchResultFilterExpandableListAdapter.C24401;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.C24411;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel.EdgesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SMALL */
public class SearchResultPageRadioGroupFilterDefinition implements SearchResultPageFilterDefinition<ContentView, SearchFilterRadioGroup> {
    public static ViewSpec<ContentView> f22837a = new C24241();
    public static ViewSpec<SearchFilterRadioGroup> f22838b = new C24252();
    private static final ImmutableMap<String, Integer> f22839c = new Builder().b("rp_commerce_price_sort", Integer.valueOf(2130843413)).b("friends", Integer.valueOf(2130839884)).b("city", Integer.valueOf(2130840024)).b("employer", Integer.valueOf(2130839723)).b("school", Integer.valueOf(2130839844)).b("rp_commerce_location", Integer.valueOf(2130839969)).b("rp_commerce_source", Integer.valueOf(2130839978)).b();
    private static final ImmutableSet<String> f22840d = ImmutableSet.of("friends", "city", "employer", "school");
    private static SearchResultPageRadioGroupFilterDefinition f22841f;
    private static final Object f22842g = new Object();
    private final GlyphColorizer f22843e;

    /* compiled from: SMALL */
    final class C24241 implements ViewSpec<ContentView> {
        C24241() {
        }

        public final View mo1272a(Context context) {
            return (ContentView) LayoutInflater.from(context).inflate(2130906988, null);
        }
    }

    /* compiled from: SMALL */
    final class C24252 implements ViewSpec<SearchFilterRadioGroup> {
        C24252() {
        }

        public final View mo1272a(Context context) {
            return new SearchFilterRadioGroup(context);
        }
    }

    private static SearchResultPageRadioGroupFilterDefinition m26488b(InjectorLike injectorLike) {
        return new SearchResultPageRadioGroupFilterDefinition((Context) injectorLike.getInstance(Context.class), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final void mo1276a(MainFilterModel mainFilterModel, View view, FilterPersistentState filterPersistentState) {
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(mainFilterModel.m10189j());
        String jo_ = mainFilterModel.jo_();
        if (jo_ != null) {
            if (f22839c.containsKey(jo_)) {
                String str = (String) filterPersistentState.f22798c.b().get("value");
                int i = (str == null || str.equals("default")) ? -7235677 : -10972929;
                contentView.setThumbnailDrawable(this.f22843e.a(((Integer) f22839c.get(jo_)).intValue(), i));
                return;
            }
            throw new IllegalArgumentException("Unimplemented filter " + jo_);
        }
    }

    public final FilterPillData mo1274a(FilterPersistentState filterPersistentState) {
        String str = (String) filterPersistentState.f22798c.b().get("name");
        if (f22839c.containsKey(str)) {
            return new FilterPillData(filterPersistentState.f22797b, this.f22843e.a(((Integer) f22839c.get(str)).intValue(), -10972929), filterPersistentState.f22798c);
        }
        throw new IllegalArgumentException("Unimplemented filter " + str);
    }

    public static SearchResultPageRadioGroupFilterDefinition m26486a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultPageRadioGroupFilterDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22842g) {
                SearchResultPageRadioGroupFilterDefinition searchResultPageRadioGroupFilterDefinition;
                if (a2 != null) {
                    searchResultPageRadioGroupFilterDefinition = (SearchResultPageRadioGroupFilterDefinition) a2.a(f22842g);
                } else {
                    searchResultPageRadioGroupFilterDefinition = f22841f;
                }
                if (searchResultPageRadioGroupFilterDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26488b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22842g, b3);
                        } else {
                            f22841f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultPageRadioGroupFilterDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultPageRadioGroupFilterDefinition(Context context, QeAccessor qeAccessor, GlyphColorizer glyphColorizer) {
        this.f22843e = glyphColorizer;
    }

    public final ViewSpec<ContentView> mo1275a() {
        return f22837a;
    }

    public final ViewSpec<SearchFilterRadioGroup> mo1278b() {
        return f22838b;
    }

    private void m26487a(final MainFilterModel mainFilterModel, SearchFilterRadioGroup searchFilterRadioGroup, FilterPersistentState filterPersistentState, C24411 c24411, C24401 c24401) {
        final FilterValuesModel d = mainFilterModel.m10187d();
        ImmutableList.Builder builder = new ImmutableList.Builder();
        int i = 0;
        boolean z = true;
        ImmutableList a = d.m10165a();
        int size = a.size();
        int i2 = 0;
        while (i2 < size) {
            int i3;
            EdgesModel edgesModel = (EdgesModel) a.get(i2);
            if (edgesModel.m10160a() == null || edgesModel.m10160a().m10149c() == null) {
                i3 = i;
            } else {
                SearchFilterRadioButton searchFilterRadioButton = new SearchFilterRadioButton(searchFilterRadioGroup.getContext());
                if (edgesModel.m10160a().m10149c().equals(filterPersistentState.m26440c().b().get("value"))) {
                    z = false;
                    searchFilterRadioButton.setChecked(true);
                } else {
                    searchFilterRadioButton.setChecked(false);
                }
                searchFilterRadioButton.setTag(Integer.valueOf(i));
                searchFilterRadioButton.setTitle(edgesModel.m10160a().m10148b());
                builder.c(searchFilterRadioButton);
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        searchFilterRadioGroup.setRadioButtons(builder.b());
        if (!(!f22840d.contains(mainFilterModel.jo_()) || mainFilterModel.jp_() == null || mainFilterModel.jp_().isEmpty())) {
            String b;
            final C24411 c244112 = c24411;
            C24263 c24263 = new Object(this) {
                final /* synthetic */ SearchResultPageRadioGroupFilterDefinition f22832c;
            };
            if (z) {
                b = filterPersistentState.m26439b();
            } else {
                b = mainFilterModel.jp_();
            }
            searchFilterRadioGroup.m26535a(c24263, b, z);
        }
        final C24401 c244012 = c24401;
        final FilterPersistentState filterPersistentState2 = filterPersistentState;
        searchFilterRadioGroup.setOnRadioButtonSelectedListener(new Object(this) {
            final /* synthetic */ SearchResultPageRadioGroupFilterDefinition f22836d;

            public final void m26485a(int i) {
                EdgesModel edgesModel = (EdgesModel) d.m10165a().get(i);
                if (edgesModel.m10160a() != null) {
                    c244012.m26546a(new FilterPersistentState(filterPersistentState2.f22796a, edgesModel.m10160a().m10148b(), edgesModel.m10160a().m10149c()));
                }
            }
        });
    }

    public final FilterPersistentState mo1273a(String str, FilterValuesModel filterValuesModel) {
        String str2 = null;
        ImmutableList a = filterValuesModel.m10165a();
        int size = a.size();
        int i = 0;
        String str3 = null;
        while (i < size) {
            String c;
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (edgesModel.m10160a().m10147a()) {
                str2 = edgesModel.m10160a().m10148b();
                c = edgesModel.m10160a().m10149c();
            } else {
                c = str2;
                str2 = str3;
            }
            i++;
            str3 = str2;
            str2 = c;
        }
        return new FilterPersistentState(str, str3, str2);
    }
}
