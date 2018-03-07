package com.facebook.search.results.filters.definition;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.FilterPillData;
import com.facebook.search.results.filters.definition.SearchResultPageFilterDefinition.ViewSpec;
import com.facebook.search.results.filters.ui.SearchResultFilterExpandableListAdapter.C24401;
import com.facebook.search.results.filters.ui.SearchResultFilterPriceRangeSeekbar;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.C24411;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel.EdgesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.facebook.uicontrib.seekbar.OnRangeSeekBarChangeListener;
import com.facebook.uicontrib.seekbar.RangeSeekBar;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.HashMap;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SMS */
public class SearchResultPagePriceFilterDefinition implements SearchResultPageFilterDefinition<ContentView, SearchResultFilterPriceRangeSeekbar> {
    public static final ImmutableList<Pair<Integer, Integer>> f22819a;
    public static final float f22820b;
    public static final float f22821c = (10000.0f / f22820b);
    private static final ViewSpec<ContentView> f22822d = new C24211();
    private static final ViewSpec<SearchResultFilterPriceRangeSeekbar> f22823e = new C24222();
    private static SearchResultPagePriceFilterDefinition f22824j;
    private static final Object f22825k = new Object();
    private final FbObjectMapper f22826f;
    private final GlyphColorizer f22827g;
    private final Resources f22828h;
    private final NumberFormat f22829i = NumberFormat.getCurrencyInstance();

    /* compiled from: SMS */
    final class C24211 implements ViewSpec<ContentView> {
        C24211() {
        }

        public final View mo1272a(Context context) {
            return (ContentView) LayoutInflater.from(context).inflate(2130906988, null);
        }
    }

    /* compiled from: SMS */
    final class C24222 implements ViewSpec<SearchResultFilterPriceRangeSeekbar> {
        C24222() {
        }

        public final View mo1272a(Context context) {
            return (SearchResultFilterPriceRangeSeekbar) LayoutInflater.from(context).inflate(2130906973, null);
        }
    }

    private static SearchResultPagePriceFilterDefinition m26474b(InjectorLike injectorLike) {
        return new SearchResultPagePriceFilterDefinition(FbObjectMapperMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final void mo1276a(MainFilterModel mainFilterModel, View view, FilterPersistentState filterPersistentState) {
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(mainFilterModel.m10189j());
        String str = (String) filterPersistentState.f22798c.b().get("value");
        int i = (str == null || str.equals("default")) ? -7235677 : -10972929;
        contentView.setThumbnailDrawable(this.f22827g.a(2130839994, i));
    }

    public final void mo1277a(MainFilterModel mainFilterModel, View view, final FilterPersistentState filterPersistentState, C24411 c24411, final C24401 c24401) {
        final SearchResultFilterPriceRangeSeekbar searchResultFilterPriceRangeSeekbar = (SearchResultFilterPriceRangeSeekbar) view;
        float a = m26471a((String) filterPersistentState.f22798c.b().get("value"), "price_lower_bound", 0.0f);
        float a2 = m26471a((String) filterPersistentState.f22798c.b().get("value"), "price_upper_bound", 10000.0f);
        RangeSeekBar rangeSeekBar = (RangeSeekBar) searchResultFilterPriceRangeSeekbar.findViewById(2131567280);
        rangeSeekBar.e(0.0f, 10000.0f);
        rangeSeekBar.f(m26476c(a), m26476c(a2));
        rangeSeekBar.setRangeSeekBarChangeListener(new OnRangeSeekBarChangeListener(this) {
            final /* synthetic */ SearchResultPagePriceFilterDefinition f22818d;

            public final void mo1279a(float f, float f2) {
                searchResultFilterPriceRangeSeekbar.m26552a(SearchResultPagePriceFilterDefinition.m26473b(f), SearchResultPagePriceFilterDefinition.m26473b(f2));
            }

            public final void mo1280b(float f, float f2) {
                c24401.m26546a(new FilterPersistentState(filterPersistentState.f22796a, null, SearchResultPagePriceFilterDefinition.m26475b((float) SearchResultPagePriceFilterDefinition.m26473b(f), (float) SearchResultPagePriceFilterDefinition.m26473b(f2))));
            }
        });
    }

    static {
        ImmutableList b = new Builder().c(new Pair(Integer.valueOf(0), Integer.valueOf(5))).c(new Pair(Integer.valueOf(50), Integer.valueOf(10))).c(new Pair(Integer.valueOf(100), Integer.valueOf(25))).c(new Pair(Integer.valueOf(250), Integer.valueOf(50))).c(new Pair(Integer.valueOf(500), Integer.valueOf(100))).c(new Pair(Integer.valueOf(1000), Integer.valueOf(1000))).c(new Pair(Integer.valueOf(10000), Integer.valueOf(0))).b();
        f22819a = b;
        f22820b = (float) (b.size() - 1);
    }

    public static SearchResultPagePriceFilterDefinition m26472a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultPagePriceFilterDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22825k) {
                SearchResultPagePriceFilterDefinition searchResultPagePriceFilterDefinition;
                if (a2 != null) {
                    searchResultPagePriceFilterDefinition = (SearchResultPagePriceFilterDefinition) a2.a(f22825k);
                } else {
                    searchResultPagePriceFilterDefinition = f22824j;
                }
                if (searchResultPagePriceFilterDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26474b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22825k, b3);
                        } else {
                            f22824j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultPagePriceFilterDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultPagePriceFilterDefinition(FbObjectMapper fbObjectMapper, GlyphColorizer glyphColorizer, Resources resources) {
        this.f22826f = fbObjectMapper;
        this.f22827g = glyphColorizer;
        this.f22828h = resources;
        this.f22829i.setMinimumFractionDigits(0);
    }

    public final ViewSpec<ContentView> mo1275a() {
        return f22822d;
    }

    public final ViewSpec<SearchResultFilterPriceRangeSeekbar> mo1278b() {
        return f22823e;
    }

    public final FilterPillData mo1274a(FilterPersistentState filterPersistentState) {
        String string;
        float a = m26471a((String) filterPersistentState.f22798c.b().get("value"), "price_lower_bound", 0.0f);
        float a2 = m26471a((String) filterPersistentState.f22798c.b().get("value"), "price_upper_bound", 10000.0f);
        if (a == 0.0f && a2 <= 10000.0f) {
            string = this.f22828h.getString(2131237395, new Object[]{this.f22829i.format((long) Math.round(a2))});
        } else if (a < 0.0f || a2 != 10000.0f) {
            string = this.f22828h.getString(2131237397, new Object[]{this.f22829i.format((long) Math.round(a)), this.f22829i.format((long) Math.round(a2))});
        } else {
            string = this.f22828h.getString(2131237396, new Object[]{this.f22829i.format((long) Math.round(a))});
        }
        return new FilterPillData(string, this.f22827g.a(2130839994, -10972929), filterPersistentState.f22798c);
    }

    public final FilterPersistentState mo1273a(String str, FilterValuesModel filterValuesModel) {
        ImmutableList a = filterValuesModel.m10165a();
        int size = a.size();
        int i = 0;
        String str2 = null;
        while (i < size) {
            String str3;
            EdgesModel edgesModel = (EdgesModel) a.get(i);
            if (edgesModel.m10160a().m10149c().equals("default") || !edgesModel.m10160a().m10147a()) {
                str3 = str2;
            } else {
                str3 = edgesModel.m10160a().m10149c();
            }
            i++;
            str2 = str3;
        }
        return new FilterPersistentState(str, null, str2);
    }

    public static int m26473b(float f) {
        float f2 = f / f22821c;
        int floor = (int) Math.floor((double) f2);
        float f3 = f2 - ((float) ((int) f2));
        if (floor >= f22819a.size() - 1) {
            return 10000;
        }
        Pair pair = (Pair) f22819a.get(floor);
        int intValue = ((Integer) ((Pair) f22819a.get(floor + 1)).a).intValue() - ((Integer) pair.a).intValue();
        return (((Integer) pair.b).intValue() * Math.round((f3 * ((float) intValue)) / ((float) ((Integer) pair.b).intValue()))) + ((Integer) pair.a).intValue();
    }

    private static float m26476c(float f) {
        int i;
        int i2 = (int) f22820b;
        for (i = 0; i < f22819a.size(); i++) {
            if (f < ((float) ((Integer) ((Pair) f22819a.get(i)).a).intValue())) {
                i2 = i - 1;
                break;
            }
        }
        if (((float) i2) == f22820b) {
            return 10000.0f;
        }
        Pair pair = (Pair) f22819a.get(i2);
        i = ((Integer) ((Pair) f22819a.get(i2 + 1)).a).intValue() - ((Integer) pair.a).intValue();
        return (((f - ((float) ((Integer) pair.a).intValue())) / ((float) i)) + ((float) i2)) * f22821c;
    }

    private float m26471a(String str, String str2, float f) {
        if (str == null) {
            return f;
        }
        try {
            HashMap hashMap = (HashMap) this.f22826f.a(str, HashMap.class);
            if (hashMap.containsKey(str2)) {
                return Float.parseFloat((String) hashMap.get(str2)) / 100.0f;
            }
            return f;
        } catch (JsonParseException e) {
            return f;
        } catch (IOException e2) {
            return f;
        }
    }

    public static String m26475b(float f, float f2) {
        if (f == 0.0f && f2 == 10000.0f) {
            return "default";
        }
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            a.f();
            if (f > 0.0f) {
                a.a("price_lower_bound", String.valueOf(Math.round(f) * 100));
            }
            if (f2 < 10000.0f) {
                a.a("price_upper_bound", String.valueOf(Math.round(f2) * 100));
            }
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (IOException e) {
            return "default";
        }
    }
}
