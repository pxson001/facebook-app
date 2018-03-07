package com.facebook.nearby.places;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.util.StringUtil;
import com.facebook.nearby.model.NearbyPlaceEdgeWrapper;
import com.facebook.nearby.ui.InflatedLayoutLocationSetter;
import com.facebook.nearby.ui.InflatedLayoutLocationSetter.InflatedLayoutLocationSetterException;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.view.inflation.DynamicLayoutInflater;
import com.facebook.view.inflation.DynamicLayoutInflater.InflationException;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: unknown group membership status */
public class NearbyPlacesAdapter extends BaseAdapter {
    private static final Class<?> f473a = NearbyPlacesAdapter.class;
    private final Context f474b;
    private final Resources f475c;
    private final LayoutInflater f476d;
    private final DynamicLayoutInflater f477e;
    private final AbstractFbErrorReporter f478f;
    private final InflatedLayoutLocationSetter f479g;
    private final Object f480h = new Object();
    private final Object f481i = new Object();
    private final Object f482j = new Object();
    private final Object f483k = new Object();
    private final Object f484l = new Object();
    private final Object f485m = new Object();
    public List<NearbyPlaceEdgeWrapper> f486n;
    public StateType f487o;
    @Nullable
    private Location f488p;

    /* compiled from: unknown group membership status */
    enum RowType {
        PLACE_INFO,
        NO_RESULTS,
        NO_NETWORK,
        PLACES_LOADING,
        DETECT_LOCATION,
        DETECT_LOCATION_FAILED,
        DEFAULT_SERVICE_ERROR,
        EXPERIMENTAL_LAYOUT_PLACE_INFO
    }

    /* compiled from: unknown group membership status */
    public enum StateType {
        DETECTING_LOCATION,
        DETECT_LOCATION_FAILED,
        LOADING_PLACES,
        DISPLAY_RESULTS,
        NO_NETWORK,
        DEFAULT_SERVICE_ERROR
    }

    public NearbyPlacesAdapter(InflatedLayoutLocationSetter inflatedLayoutLocationSetter, AbstractFbErrorReporter abstractFbErrorReporter, DynamicLayoutInflater dynamicLayoutInflater, Context context) {
        this.f478f = abstractFbErrorReporter;
        this.f474b = context;
        this.f475c = this.f474b.getResources();
        this.f476d = LayoutInflater.from(this.f474b);
        this.f486n = Lists.a();
        this.f487o = StateType.DISPLAY_RESULTS;
        this.f477e = dynamicLayoutInflater;
        this.f479g = inflatedLayoutLocationSetter;
    }

    public final void m580c() {
        this.f487o = StateType.NO_NETWORK;
        AdapterDetour.a(this, 561958896);
    }

    public final void m579a(List<NearbyPlaceEdgeWrapper> list, @Nullable Location location) {
        this.f486n = ImmutableList.copyOf(list);
        this.f488p = location;
        this.f487o = StateType.DISPLAY_RESULTS;
        AdapterDetour.a(this, -1242938701);
    }

    public int getCount() {
        if (this.f487o == StateType.DETECTING_LOCATION || this.f487o == StateType.LOADING_PLACES || this.f487o == StateType.DETECT_LOCATION_FAILED || this.f487o == StateType.NO_NETWORK || this.f487o == StateType.DEFAULT_SERVICE_ERROR) {
            return 1;
        }
        return Math.max(1, this.f486n.size());
    }

    public Object getItem(int i) {
        if (this.f487o == StateType.DETECTING_LOCATION) {
            return this.f480h;
        }
        if (this.f487o == StateType.DETECT_LOCATION_FAILED) {
            return this.f481i;
        }
        if (this.f487o == StateType.LOADING_PLACES) {
            return this.f482j;
        }
        if (this.f487o == StateType.NO_NETWORK) {
            return this.f484l;
        }
        if (this.f487o == StateType.DEFAULT_SERVICE_ERROR) {
            return this.f485m;
        }
        if (this.f486n.isEmpty()) {
            return this.f483k;
        }
        return this.f486n.get(i);
    }

    public boolean isEnabled(int i) {
        switch (m571a(i)) {
            case DETECT_LOCATION:
            case DETECT_LOCATION_FAILED:
            case PLACES_LOADING:
            case NO_NETWORK:
            case NO_RESULTS:
            case DEFAULT_SERVICE_ERROR:
                return false;
            case PLACE_INFO:
            case EXPERIMENTAL_LAYOUT_PLACE_INFO:
                return true;
            default:
                throw new IllegalArgumentException("Unknown row type");
        }
    }

    public long getItemId(int i) {
        switch (m571a(i)) {
            case DETECT_LOCATION:
                return 2;
            case DETECT_LOCATION_FAILED:
                return 3;
            case PLACES_LOADING:
                return 0;
            case NO_NETWORK:
                return 4;
            case NO_RESULTS:
                return 1;
            case DEFAULT_SERVICE_ERROR:
                return 5;
            case PLACE_INFO:
            case EXPERIMENTAL_LAYOUT_PLACE_INFO:
                return Long.parseLong(((NearbyPlaceEdgeWrapper) getItem(i)).m499c());
            default:
                throw new IllegalArgumentException("Unknown row type");
        }
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Object item = getItem(i);
        if (item == this.f480h) {
            return m568a(view, viewGroup);
        }
        if (item == this.f481i) {
            return m572b(view, viewGroup);
        }
        if (item == this.f482j) {
            return m574c(view, viewGroup);
        }
        if (item == this.f483k) {
            return m576d(view, viewGroup);
        }
        if (item == this.f484l) {
            return m577e(view, viewGroup);
        }
        if (item == this.f485m) {
            return m578f(view, viewGroup);
        }
        if (m571a(i) == RowType.EXPERIMENTAL_LAYOUT_PLACE_INFO) {
            return m573b(view, viewGroup, i);
        }
        return m569a(view, viewGroup, i);
    }

    public int getItemViewType(int i) {
        switch (m571a(i)) {
            case DETECT_LOCATION:
                return 2;
            case DETECT_LOCATION_FAILED:
                return 3;
            case PLACES_LOADING:
                return 0;
            case NO_NETWORK:
                return 4;
            case NO_RESULTS:
                return 1;
            case DEFAULT_SERVICE_ERROR:
                return 7;
            case PLACE_INFO:
                return 6;
            case EXPERIMENTAL_LAYOUT_PLACE_INFO:
                return Math.min(i + 8, 307);
            default:
                throw new IllegalArgumentException("Unknown row type");
        }
    }

    public int getViewTypeCount() {
        return 308;
    }

    private RowType m571a(int i) {
        if (this.f487o == StateType.DETECTING_LOCATION) {
            return RowType.DETECT_LOCATION;
        }
        if (this.f487o == StateType.DETECT_LOCATION_FAILED) {
            return RowType.DETECT_LOCATION_FAILED;
        }
        if (this.f487o == StateType.LOADING_PLACES) {
            return RowType.PLACES_LOADING;
        }
        if (this.f487o == StateType.NO_NETWORK) {
            return RowType.NO_NETWORK;
        }
        if (this.f487o == StateType.DEFAULT_SERVICE_ERROR) {
            return RowType.DEFAULT_SERVICE_ERROR;
        }
        if (this.f486n.isEmpty()) {
            return RowType.NO_RESULTS;
        }
        if (StringUtil.a(((NearbyPlaceEdgeWrapper) getItem(i)).m501e())) {
            return RowType.PLACE_INFO;
        }
        return RowType.EXPERIMENTAL_LAYOUT_PLACE_INFO;
    }

    private View m569a(View view, ViewGroup viewGroup, int i) {
        if (view == null || !(view instanceof NearbyPlaceDetailsView)) {
            view = (NearbyPlaceDetailsView) this.f476d.inflate(2130905386, viewGroup, false);
        } else {
            view = (NearbyPlaceDetailsView) view;
        }
        view.m563a((NearbyPlaceEdgeWrapper) getItem(i), this.f488p);
        return view;
    }

    private View m573b(View view, ViewGroup viewGroup, int i) {
        NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper = (NearbyPlaceEdgeWrapper) getItem(i);
        if (view != null) {
            return view;
        }
        try {
            return m570a(view, viewGroup, i, this.f477e.a(nearbyPlaceEdgeWrapper.m501e(), viewGroup, this.f474b), nearbyPlaceEdgeWrapper);
        } catch (InflationException e) {
            return m575c(view, viewGroup, i);
        }
    }

    private View m570a(View view, ViewGroup viewGroup, int i, View view2, NearbyPlaceEdgeWrapper nearbyPlaceEdgeWrapper) {
        view2.setBackgroundResource(2130841597);
        if (this.f488p == null) {
            return view2;
        }
        try {
            this.f479g.m1065a(this.f477e, view2, nearbyPlaceEdgeWrapper.m502f(), this.f488p);
            return view2;
        } catch (InflatedLayoutLocationSetterException e) {
            return m575c(view, viewGroup, i);
        }
    }

    private View m575c(View view, ViewGroup viewGroup, int i) {
        AbstractFbErrorReporter abstractFbErrorReporter = this.f478f;
        SoftErrorBuilder a = SoftError.a("EXPERIMENTAL_INFLATED_VIEWS", "inflation failed for item id = " + i);
        a.d = false;
        abstractFbErrorReporter.a(a.g());
        return m569a(view, viewGroup, i);
    }

    private View m568a(View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        view = this.f476d.inflate(2130905379, viewGroup, false);
        ((TextView) view.findViewById(2131564065)).setText(this.f475c.getString(2131236633));
        return view;
    }

    private View m572b(View view, ViewGroup viewGroup) {
        return view != null ? view : this.f476d.inflate(2130905377, viewGroup, false);
    }

    private View m574c(View view, ViewGroup viewGroup) {
        if (view != null) {
            return view;
        }
        view = this.f476d.inflate(2130905379, viewGroup, false);
        ((TextView) view.findViewById(2131564065)).setText(this.f475c.getString(2131236632));
        return view;
    }

    private View m576d(View view, ViewGroup viewGroup) {
        return view != null ? view : this.f476d.inflate(2130905461, viewGroup, false);
    }

    private View m577e(View view, ViewGroup viewGroup) {
        return view != null ? view : this.f476d.inflate(2130905458, viewGroup, false);
    }

    private View m578f(View view, ViewGroup viewGroup) {
        return view != null ? view : this.f476d.inflate(2130905388, viewGroup, false);
    }
}
