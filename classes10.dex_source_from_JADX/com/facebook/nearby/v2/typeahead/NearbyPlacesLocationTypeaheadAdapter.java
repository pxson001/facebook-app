package com.facebook.nearby.v2.typeahead;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.events.eventsdiscovery.EventsDiscoveryLocationPickerFragment;
import com.facebook.events.eventsdiscovery.EventsDiscoveryLocationPickerFragment.C24374;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel.NodeModel;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesTypeaheadModel;
import com.facebook.resources.ui.FbButton;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import com.google.common.base.Preconditions;

/* compiled from: payment_flow_type */
public class NearbyPlacesLocationTypeaheadAdapter extends BaseAdapter {
    public static final int[] f5161g = new int[]{2131236713, 2131236714, 2131236715};
    private Boolean f5162a;
    public Context f5163b;
    public SearchRadius f5164c;
    private NearbyPlacesTypeaheadModel f5165d;
    public C24374 f5166e;
    public GlyphColorizer f5167f = new GlyphColorizer(this.f5163b.getResources());

    /* compiled from: payment_flow_type */
    public class C07181 implements OnClickListener {
        final /* synthetic */ NearbyPlacesLocationTypeaheadAdapter f5157a;

        public C07181(NearbyPlacesLocationTypeaheadAdapter nearbyPlacesLocationTypeaheadAdapter) {
            this.f5157a = nearbyPlacesLocationTypeaheadAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -32684255);
            NearbyPlacesLocationTypeaheadAdapter nearbyPlacesLocationTypeaheadAdapter = this.f5157a;
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(nearbyPlacesLocationTypeaheadAdapter.f5163b);
            BottomSheetAdapter bottomSheetAdapter = new BottomSheetAdapter(nearbyPlacesLocationTypeaheadAdapter.f5163b);
            bottomSheetAdapter.g = false;
            nearbyPlacesLocationTypeaheadAdapter.f5167f.a(2130839774, -10972929);
            for (int i = 0; i < NearbyPlacesLocationTypeaheadAdapter.f5161g.length; i++) {
                boolean z;
                SearchRadius searchRadius = SearchRadius.values()[i];
                MenuItem checkable = bottomSheetAdapter.e(NearbyPlacesLocationTypeaheadAdapter.f5161g[i]).setCheckable(true);
                if (searchRadius == nearbyPlacesLocationTypeaheadAdapter.f5164c) {
                    z = true;
                } else {
                    z = false;
                }
                checkable.setChecked(z).setOnMenuItemClickListener(new C07192(nearbyPlacesLocationTypeaheadAdapter, searchRadius));
            }
            bottomSheetDialog.a(bottomSheetAdapter);
            bottomSheetDialog.show();
            Logger.a(2, EntryType.UI_INPUT_END, 2021551630, a);
        }
    }

    /* compiled from: payment_flow_type */
    public class C07192 implements OnMenuItemClickListener {
        final /* synthetic */ SearchRadius f5158a;
        final /* synthetic */ NearbyPlacesLocationTypeaheadAdapter f5159b;

        public C07192(NearbyPlacesLocationTypeaheadAdapter nearbyPlacesLocationTypeaheadAdapter, SearchRadius searchRadius) {
            this.f5159b = nearbyPlacesLocationTypeaheadAdapter;
            this.f5158a = searchRadius;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            C24374 c24374 = this.f5159b.f5166e;
            SearchRadius searchRadius = this.f5158a;
            NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel = c24374.f17285a.am.f5217a;
            nearbyPlacesSearchDataModel.b = true;
            if (c24374.f17285a.al != null) {
                nearbyPlacesSearchDataModel.a(c24374.f17285a.al);
            }
            nearbyPlacesSearchDataModel.d = null;
            nearbyPlacesSearchDataModel.e = null;
            EventsDiscoveryLocationPickerFragment.m17582a(c24374.f17285a, c24374.f17285a.am.f5217a, searchRadius);
            EventEventLogger eventEventLogger = c24374.f17285a.f17290b;
            int value = searchRadius.getValue();
            String str = c24374.f17285a.an;
            HoneyClientEventFast a = eventEventLogger.f17787i.a("selected_location_filter_current_location", false);
            if (a.a()) {
                a.a("event_discovery").a("event_suggestion_token", str).a("range", value).b();
            }
            this.f5159b.f5164c = this.f5158a;
            return true;
        }
    }

    /* compiled from: payment_flow_type */
    public enum ItemViewType {
        CURRENT_LOCATION_CELL,
        LOCATION_CELL,
        COUNT
    }

    /* compiled from: payment_flow_type */
    public enum SearchRadius {
        SEARCH_RADIUS_1(1),
        SEARCH_RADIUS_5(5),
        SEARCH_RADIUS_10(10);
        
        private final int mRadius;

        private SearchRadius(int i) {
            this.mRadius = i;
        }

        public final int getValue() {
            return this.mRadius;
        }
    }

    public NearbyPlacesLocationTypeaheadAdapter(Context context, NearbyPlacesTypeaheadModel nearbyPlacesTypeaheadModel, boolean z) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(nearbyPlacesTypeaheadModel);
        this.f5165d = nearbyPlacesTypeaheadModel;
        this.f5163b = context;
        this.f5162a = Boolean.valueOf(z);
        if (this.f5162a.booleanValue()) {
            this.f5164c = SearchRadius.SEARCH_RADIUS_5;
        }
    }

    public Object getItem(int i) {
        switch (ItemViewType.values()[getItemViewType(i)]) {
            case CURRENT_LOCATION_CELL:
                return null;
            case LOCATION_CELL:
                if (this.f5165d.f5219c == null) {
                    return null;
                }
                int a = i - m4642a();
                if (this.f5165d.f5219c.f5211b.size() > a) {
                    return (NodeModel) this.f5165d.f5219c.f5211b.get(a);
                }
                return null;
            default:
                throw new IllegalArgumentException("there are no object associate with location");
        }
    }

    public int getCount() {
        if (this.f5165d.f5219c == null) {
            return 0;
        }
        if (this.f5165d.f5217a.f()) {
            return this.f5165d.f5219c.f5211b.size() + 1;
        }
        return this.f5165d.f5219c.f5211b.size();
    }

    public long getItemId(int i) {
        if (m4643b() && i == 0) {
            return 0;
        }
        NodeModel nodeModel = (NodeModel) getItem(i);
        return (nodeModel == null || TextUtils.isEmpty(nodeModel.j())) ? 0 : Long.parseLong(nodeModel.j());
    }

    public int getItemViewType(int i) {
        if (m4643b() && i == 0) {
            return ItemViewType.CURRENT_LOCATION_CELL.ordinal();
        }
        return ItemViewType.LOCATION_CELL.ordinal();
    }

    public int getViewTypeCount() {
        return ItemViewType.COUNT.ordinal();
    }

    public final int m4644a(int i) {
        if (i == 0) {
            return 0;
        }
        return i - m4642a();
    }

    private int m4642a() {
        return m4643b() ? 1 : 0;
    }

    private boolean m4643b() {
        return this.f5165d.f5217a.f();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewType itemViewType = ItemViewType.values()[getItemViewType(i)];
        if (view == null) {
            view = (ContentView) ((LayoutInflater) this.f5163b.getSystemService("layout_inflater")).inflate(2130907575, viewGroup, false);
        } else {
            ContentView contentView = (ContentView) view;
        }
        ImageView imageView = (ImageView) view.findViewById(2131568147);
        FbButton fbButton = (FbButton) view.findViewById(2131568148);
        switch (itemViewType) {
            case CURRENT_LOCATION_CELL:
                view.setTitleTextAppearance(2131625706);
                view.setTitleText(this.f5163b.getResources().getString(2131236708));
                imageView.setImageDrawable(this.f5163b.getResources().getDrawable(2130837813));
                if (!this.f5162a.booleanValue()) {
                    fbButton.setVisibility(8);
                    break;
                }
                fbButton.setVisibility(0);
                fbButton.setText(f5161g[this.f5164c.ordinal()]);
                fbButton.setCompoundDrawablesWithIntrinsicBounds(null, null, this.f5167f.a(2130840140, -10972929), null);
                fbButton.setOnClickListener(new C07181(this));
                break;
            case LOCATION_CELL:
                view.setTitleText(((NodeModel) getItem(i)).l());
                imageView.setBackgroundDrawable(this.f5163b.getResources().getDrawable(2130840905));
                fbButton.setVisibility(8);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return view;
    }
}
