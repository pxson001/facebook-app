package com.facebook.search.results.filters.definition;

import android.content.Context;
import android.content.res.Resources;
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
import com.facebook.search.results.filters.ui.SearchResultFilterDistanceSeekbar;
import com.facebook.search.results.filters.ui.SearchResultFilterExpandableListAdapter.C24401;
import com.facebook.search.results.filters.ui.SearchResultPageFilterFragment.C24411;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageFilterValuesFragmentModel.FilterValuesModel.EdgesModel;
import com.facebook.search.results.protocol.filters.SearchResultPageFilterFragmentsModels.SearchResultPageMainFilterFragmentModel.MainFilterModel;
import com.facebook.uicontrib.seekbar.FbSeekBar;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SMS_TAKEOVER_DELAYED_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
public class SearchResultPageDistanceFilterDefinition implements SearchResultPageFilterDefinition<ContentView, SearchResultFilterDistanceSeekbar> {
    private static final ViewSpec<ContentView> f22803a = new C24181();
    private static final ViewSpec<SearchResultFilterDistanceSeekbar> f22804b = new C24192();
    private static SearchResultPageDistanceFilterDefinition f22805f;
    private static final Object f22806g = new Object();
    private final Resources f22807c;
    private final GlyphColorizer f22808d;
    private final FbObjectMapper f22809e;

    /* compiled from: SMS_TAKEOVER_DELAYED_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
    final class C24181 implements ViewSpec<ContentView> {
        C24181() {
        }

        public final View mo1272a(Context context) {
            return (ContentView) LayoutInflater.from(context).inflate(2130906988, null);
        }
    }

    /* compiled from: SMS_TAKEOVER_DELAYED_READ_ONLY_THREAD_VIEW_BANNER_ELIGIBLE */
    final class C24192 implements ViewSpec<SearchResultFilterDistanceSeekbar> {
        C24192() {
        }

        public final View mo1272a(Context context) {
            return (SearchResultFilterDistanceSeekbar) LayoutInflater.from(context).inflate(2130906972, null);
        }
    }

    private static SearchResultPageDistanceFilterDefinition m26452b(InjectorLike injectorLike) {
        return new SearchResultPageDistanceFilterDefinition(ResourcesMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), GlyphColorizer.a(injectorLike));
    }

    public final FilterPillData mo1274a(FilterPersistentState filterPersistentState) {
        float a = m26450a((String) filterPersistentState.f22798c.b().get("value"), 100.0f);
        return new FilterPillData(this.f22807c.getString(2131237398, new Object[]{String.valueOf(Math.round(a))}), this.f22808d.a(2130840024, -10972929), filterPersistentState.f22798c);
    }

    public final void mo1276a(MainFilterModel mainFilterModel, View view, FilterPersistentState filterPersistentState) {
        ContentView contentView = (ContentView) view;
        contentView.setTitleText(mainFilterModel.m10189j());
        String str = (String) filterPersistentState.f22798c.b().get("value");
        int i = (str == null || str.equals("default")) ? -7235677 : -10972929;
        contentView.setThumbnailDrawable(this.f22808d.a(2130840024, i));
    }

    public final void mo1277a(MainFilterModel mainFilterModel, View view, final FilterPersistentState filterPersistentState, C24411 c24411, final C24401 c24401) {
        final SearchResultFilterDistanceSeekbar searchResultFilterDistanceSeekbar = (SearchResultFilterDistanceSeekbar) view;
        float a = m26450a((String) filterPersistentState.f22798c.b().get("value"), 100.0f);
        FbSeekBar fbSeekBar = (FbSeekBar) searchResultFilterDistanceSeekbar.findViewById(2131567282);
        fbSeekBar.e(5.0f, 100.0f);
        fbSeekBar.setCurrentSelectedValue(a);
        fbSeekBar.setOnSeekBarChangeListener(new Object(this) {
            final /* synthetic */ SearchResultPageDistanceFilterDefinition f22802d;
        });
    }

    public static SearchResultPageDistanceFilterDefinition m26451a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultPageDistanceFilterDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22806g) {
                SearchResultPageDistanceFilterDefinition searchResultPageDistanceFilterDefinition;
                if (a2 != null) {
                    searchResultPageDistanceFilterDefinition = (SearchResultPageDistanceFilterDefinition) a2.a(f22806g);
                } else {
                    searchResultPageDistanceFilterDefinition = f22805f;
                }
                if (searchResultPageDistanceFilterDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26452b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22806g, b3);
                        } else {
                            f22805f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultPageDistanceFilterDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultPageDistanceFilterDefinition(Resources resources, FbObjectMapper fbObjectMapper, GlyphColorizer glyphColorizer) {
        this.f22807c = resources;
        this.f22809e = fbObjectMapper;
        this.f22808d = glyphColorizer;
    }

    public final ViewSpec<ContentView> mo1275a() {
        return f22803a;
    }

    public final ViewSpec<SearchResultFilterDistanceSeekbar> mo1278b() {
        return f22804b;
    }

    @Nullable
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

    public static int m26453c(float f) {
        return Math.round(f / 5.0f) * 5;
    }

    private float m26450a(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            HashMap hashMap = (HashMap) this.f22809e.a(str, HashMap.class);
            if (hashMap.containsKey("filter_radius_km")) {
                return Float.parseFloat((String) hashMap.get("filter_radius_km")) / 1.60934f;
            }
            return f;
        } catch (JsonParseException e) {
            return f;
        } catch (IOException e2) {
            return f;
        }
    }

    public static String m26454d(float f) {
        if (f == 100.0f) {
            return "default";
        }
        JsonFactory jsonFactory = new JsonFactory();
        Writer stringWriter = new StringWriter();
        try {
            JsonGenerator a = jsonFactory.a(stringWriter);
            a.f();
            a.a("filter_radius_km", String.valueOf(((float) Math.round(f)) * 1.60934f));
            a.g();
            a.close();
            return stringWriter.getBuffer().toString();
        } catch (IOException e) {
            return "default";
        }
    }
}
