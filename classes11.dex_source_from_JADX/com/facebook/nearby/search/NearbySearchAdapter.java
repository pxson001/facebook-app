package com.facebook.nearby.search;

import android.content.Context;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.maps.Locations;
import com.facebook.nearby.common.SearchSuggestion;
import com.facebook.nearby.model.TypeaheadPlaceWithLayout;
import com.facebook.nearby.places.NearbyPlaceDetailsView;
import com.facebook.nearby.ui.InflatedLayoutLocationSetter;
import com.facebook.nearby.ui.InflatedLayoutLocationSetter.InflatedLayoutLocationSetterException;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.view.inflation.DynamicLayoutInflater;
import com.facebook.view.inflation.DynamicLayoutInflater.InflationException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: topSubmitEditing */
public class NearbySearchAdapter extends BaseAdapter {
    private static final Class<?> f723a = NearbySearchAdapter.class;
    private final AbstractFbErrorReporter f724b;
    private final Context f725c;
    private final LayoutInflater f726d = LayoutInflater.from(this.f725c);
    private final DynamicLayoutInflater f727e;
    private final InflatedLayoutLocationSetter f728f;
    private ImmutableList<SearchSuggestion> f729g = RegularImmutableList.a;
    private ImmutableList<TypeaheadPlaceWithLayout> f730h = RegularImmutableList.a;
    @Nullable
    private Location f731i;

    /* compiled from: topSubmitEditing */
    enum RowType {
        SEARCH_SUGGESTION,
        EXPERIMENTAL_PLACE_INFO,
        PLACE_INFO
    }

    public NearbySearchAdapter(InflatedLayoutLocationSetter inflatedLayoutLocationSetter, DynamicLayoutInflater dynamicLayoutInflater, AbstractFbErrorReporter abstractFbErrorReporter, Context context) {
        this.f724b = abstractFbErrorReporter;
        this.f725c = context;
        this.f727e = dynamicLayoutInflater;
        this.f728f = inflatedLayoutLocationSetter;
    }

    public final void m1025a(List<SearchSuggestion> list) {
        this.f729g = ImmutableList.copyOf(list);
        this.f730h = RegularImmutableList.a;
        AdapterDetour.a(this, 612795209);
    }

    public final void m1026a(List<SearchSuggestion> list, List<TypeaheadPlaceWithLayout> list2, Location location) {
        this.f729g = ImmutableList.copyOf(list);
        this.f730h = ImmutableList.copyOf(list2);
        this.f731i = location;
        AdapterDetour.a(this, -1901245422);
    }

    public int getItemViewType(int i) {
        return m1021a(i).ordinal();
    }

    public int getViewTypeCount() {
        return RowType.values().length;
    }

    public int getCount() {
        return this.f729g.size() + this.f730h.size();
    }

    public Object getItem(int i) {
        RowType a = m1021a(i);
        int a2 = m1017a(a);
        switch (a) {
            case SEARCH_SUGGESTION:
                return this.f729g.get(i - a2);
            case EXPERIMENTAL_PLACE_INFO:
            case PLACE_INFO:
                return this.f730h.get(i - a2);
            default:
                throw new IllegalStateException("Unexpected RowType type: " + a);
        }
    }

    public long getItemId(int i) {
        RowType a = m1021a(i);
        switch (a) {
            case SEARCH_SUGGESTION:
                return (long) i;
            case EXPERIMENTAL_PLACE_INFO:
            case PLACE_INFO:
                return Long.parseLong(((TypeaheadPlaceWithLayout) getItem(i)).typeaheadPlace.f396a) + ((long) m1017a(a));
            default:
                throw new IllegalArgumentException("Unknown row type");
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (m1021a(i)) {
            case SEARCH_SUGGESTION:
                NearbySearchSuggestionRowView a = m1022a(view);
                a.f765a.setText(((SearchSuggestion) getItem(i)).b);
                a.setBackgroundResource(m1023b(i));
                return a;
            case EXPERIMENTAL_PLACE_INFO:
                return m1018a(i, view, viewGroup);
            case PLACE_INFO:
                return m1024b(i, view, viewGroup);
            default:
                throw new IllegalStateException("Unexpected type");
        }
    }

    private View m1018a(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        TypeaheadPlaceWithLayout typeaheadPlaceWithLayout = (TypeaheadPlaceWithLayout) getItem(i);
        try {
            View a = this.f727e.a(typeaheadPlaceWithLayout.layout, viewGroup, this.f725c);
            a.setBackgroundResource(m1023b(i));
            return m1020a(view, viewGroup, i, a, typeaheadPlaceWithLayout);
        } catch (InflationException e) {
            return m1019a(view, viewGroup, i);
        }
    }

    private View m1024b(int i, View view, ViewGroup viewGroup) {
        if (view == null || !(view instanceof NearbyPlaceDetailsView)) {
            view = (NearbyPlaceDetailsView) this.f726d.inflate(2130905386, viewGroup, false);
        } else {
            view = (NearbyPlaceDetailsView) view;
        }
        view.m564a(((TypeaheadPlaceWithLayout) getItem(i)).typeaheadPlace, this.f731i);
        view.setBackgroundResource(m1023b(i));
        return view;
    }

    private View m1020a(View view, ViewGroup viewGroup, int i, View view2, TypeaheadPlaceWithLayout typeaheadPlaceWithLayout) {
        if (this.f731i == null) {
            return view2;
        }
        try {
            this.f728f.m1065a(this.f727e, view2, Locations.a(typeaheadPlaceWithLayout.typeaheadPlace.f400e.a(), typeaheadPlaceWithLayout.typeaheadPlace.f400e.b()), this.f731i);
            return view2;
        } catch (InflatedLayoutLocationSetterException e) {
            return m1019a(view, viewGroup, i);
        }
    }

    private View m1019a(View view, ViewGroup viewGroup, int i) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f724b;
        SoftErrorBuilder a = SoftError.a("EXPERIMENTAL_INFLATED_VIEWS", "inflation failed for item id = " + i);
        a.d = false;
        abstractFbErrorReporter.a(a.g());
        return m1024b(i, view, viewGroup);
    }

    private RowType m1021a(int i) {
        if (i < this.f729g.size()) {
            return RowType.SEARCH_SUGGESTION;
        }
        if (StringUtil.a(((TypeaheadPlaceWithLayout) this.f730h.get(i - this.f729g.size())).layout)) {
            return RowType.PLACE_INFO;
        }
        return RowType.EXPERIMENTAL_PLACE_INFO;
    }

    private int m1017a(RowType rowType) {
        switch (rowType) {
            case SEARCH_SUGGESTION:
                return 0;
            case EXPERIMENTAL_PLACE_INFO:
            case PLACE_INFO:
                return this.f729g.size();
            default:
                throw new IllegalArgumentException("Unexpected RowType type: " + rowType);
        }
    }

    private NearbySearchSuggestionRowView m1022a(View view) {
        if (view != null) {
            return (NearbySearchSuggestionRowView) view;
        }
        return new NearbySearchSuggestionRowView(this.f725c);
    }

    private int m1023b(int i) {
        if (i == 0) {
            return 2130841614;
        }
        if (i == getCount() - 1) {
            return 2130841613;
        }
        return 2130841612;
    }
}
