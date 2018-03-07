package com.facebook.messaging.location.sending;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: mMailingAddresses */
public class NearbyPlacesAdapter extends Adapter<NearbyPlaceViewHolder> {
    public ImmutableList<NearbyPlace> f11459a = RegularImmutableList.a;
    private final OnClickListener f11460b;

    /* compiled from: mMailingAddresses */
    public class NearbyPlaceViewHolder extends ViewHolder {
        public final NearbyPlaceListItemView f11458l;

        public NearbyPlaceViewHolder(NearbyPlaceListItemView nearbyPlaceListItemView) {
            super(nearbyPlaceListItemView);
            this.f11458l = nearbyPlaceListItemView;
        }
    }

    public final void m12054a(ViewHolder viewHolder, int i) {
        NearbyPlace nearbyPlace = (NearbyPlace) this.f11459a.get(i);
        NearbyPlaceListItemView nearbyPlaceListItemView = ((NearbyPlaceViewHolder) viewHolder).f11458l;
        nearbyPlaceListItemView.f11454b.a(nearbyPlace.f11446c, NearbyPlaceListItemView.f11453a);
        nearbyPlaceListItemView.f11455c.setText(nearbyPlace.f11445b);
        nearbyPlaceListItemView.f11456d.setText(nearbyPlace.f11449f);
        nearbyPlaceListItemView.f11457e.setText(nearbyPlace.f11448e);
    }

    public NearbyPlacesAdapter(OnClickListener onClickListener) {
        this.f11460b = onClickListener;
    }

    public final ViewHolder m12053a(ViewGroup viewGroup, int i) {
        NearbyPlaceListItemView nearbyPlaceListItemView = new NearbyPlaceListItemView(viewGroup.getContext());
        nearbyPlaceListItemView.setOnClickListener(this.f11460b);
        return new NearbyPlaceViewHolder(nearbyPlaceListItemView);
    }

    public final int aZ_() {
        return this.f11459a.size();
    }
}
