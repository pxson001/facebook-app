package com.facebook.nearby.v2.typeahead;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadPlaceFragmentModel;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesTypeaheadModel;
import com.facebook.resources.ui.FbButton;

/* compiled from: payment success */
public class NearbyPlacesPlacesAndTopicsAdapter extends BaseAdapter {
    private Context f5174a;
    private NearbyPlacesTypeaheadModel f5175b;

    /* compiled from: payment success */
    public enum ItemViewType {
        QUERY_SUGGESTION_CELL,
        PLACE_CELL,
        COUNT
    }

    public NearbyPlacesPlacesAndTopicsAdapter(Context context, NearbyPlacesTypeaheadModel nearbyPlacesTypeaheadModel) {
        this.f5174a = context;
        this.f5175b = nearbyPlacesTypeaheadModel;
    }

    public Object getItem(int i) {
        switch (ItemViewType.values()[getItemViewType(i)]) {
            case QUERY_SUGGESTION_CELL:
                if (this.f5175b.f5218b.f5215c.size() > i) {
                    return (String) this.f5175b.f5218b.f5215c.get(i);
                }
                return null;
            case PLACE_CELL:
                int a = i - m4648a();
                if (this.f5175b.f5218b.f5214b.size() > a) {
                    return (FBNearbyPlacesTypeaheadPlaceFragmentModel) this.f5175b.f5218b.f5214b.get(a);
                }
                return null;
            default:
                throw new IllegalArgumentException("there are no object associate with location");
        }
    }

    public int getCount() {
        return this.f5175b.f5218b == null ? 0 : this.f5175b.f5218b.f5215c.size() + this.f5175b.f5218b.f5214b.size();
    }

    public long getItemId(int i) {
        if (i < this.f5175b.f5218b.f5215c.size()) {
            return 0;
        }
        FBNearbyPlacesTypeaheadPlaceFragmentModel fBNearbyPlacesTypeaheadPlaceFragmentModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) getItem(i);
        return (fBNearbyPlacesTypeaheadPlaceFragmentModel == null || TextUtils.isEmpty(fBNearbyPlacesTypeaheadPlaceFragmentModel.k())) ? 0 : Long.parseLong(fBNearbyPlacesTypeaheadPlaceFragmentModel.k());
    }

    public int getItemViewType(int i) {
        if (i < this.f5175b.f5218b.f5215c.size()) {
            return ItemViewType.QUERY_SUGGESTION_CELL.ordinal();
        }
        return ItemViewType.PLACE_CELL.ordinal();
    }

    public int getViewTypeCount() {
        return ItemViewType.COUNT.ordinal();
    }

    public final int m4649a(int i) {
        switch (ItemViewType.values()[getItemViewType(i)]) {
            case QUERY_SUGGESTION_CELL:
                return i;
            case PLACE_CELL:
                return i - m4648a();
            default:
                throw new IllegalArgumentException("there are no object associate with location");
        }
    }

    private int m4648a() {
        return this.f5175b.f5218b.f5215c.size();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ContentView contentView;
        switch (ItemViewType.values()[getItemViewType(i)]) {
            case QUERY_SUGGESTION_CELL:
                String str = (String) getItem(i);
                if (view == null) {
                    view = (ContentView) ((LayoutInflater) this.f5174a.getSystemService("layout_inflater")).inflate(2130907575, viewGroup, false);
                } else {
                    contentView = (ContentView) view;
                }
                ImageView imageView = (ImageView) view.findViewById(2131568147);
                imageView.setImageDrawable(this.f5174a.getResources().getDrawable(2130843283));
                imageView.setBackgroundDrawable(this.f5174a.getResources().getDrawable(2130840905));
                ((FbButton) view.findViewById(2131568148)).setVisibility(8);
                if (str != null) {
                    view.setTitleText(str);
                    break;
                }
                break;
            case PLACE_CELL:
                FBNearbyPlacesTypeaheadPlaceFragmentModel fBNearbyPlacesTypeaheadPlaceFragmentModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) getItem(i);
                if (view == null) {
                    view = (ContentView) ((LayoutInflater) this.f5174a.getSystemService("layout_inflater")).inflate(2130907577, viewGroup, false);
                } else {
                    contentView = (ContentView) view;
                }
                if (fBNearbyPlacesTypeaheadPlaceFragmentModel != null) {
                    view.setThumbnailUri(fBNearbyPlacesTypeaheadPlaceFragmentModel.m().d());
                    view.setTitleText(fBNearbyPlacesTypeaheadPlaceFragmentModel.l());
                    view.setSubtitleText(fBNearbyPlacesTypeaheadPlaceFragmentModel.j().a());
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException();
        }
        return view;
    }
}
