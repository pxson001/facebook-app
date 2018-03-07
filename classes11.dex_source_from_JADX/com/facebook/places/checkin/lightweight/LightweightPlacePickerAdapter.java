package com.facebook.places.checkin.lightweight;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.location.LocationLightweightPickerSproutItem;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.ViewProvider.C08471;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.resources.ui.FbTextView;
import java.util.Collections;
import java.util.List;

/* compiled from: TopicFeedOptionSelectMutation */
public class LightweightPlacePickerAdapter extends Adapter<LightweightPlaceViewHolder> {
    public final C08471 f10580a;
    private List<CheckinPlace> f10581b = Collections.emptyList();

    /* compiled from: TopicFeedOptionSelectMutation */
    class C12451 implements OnClickListener {
        final /* synthetic */ LightweightPlacePickerAdapter f10579a;

        C12451(LightweightPlacePickerAdapter lightweightPlacePickerAdapter) {
            this.f10579a = lightweightPlacePickerAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1427524584);
            C08471 c08471 = this.f10579a.f10580a;
            ComposerFragment.bN(c08471.f6683a.f6685a.f6690d.f6114a);
            LocationLightweightPickerSproutItem.m8107a(c08471.f6683a.f6685a, "lightweight_place_picker_more_places");
            Logger.a(2, EntryType.UI_INPUT_END, -746537945, a);
        }
    }

    public final void m11082a(ViewHolder viewHolder, int i) {
        LightweightPlaceViewHolder lightweightPlaceViewHolder = (LightweightPlaceViewHolder) viewHolder;
        if (getItemViewType(i) == 2130905039) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) this.f10581b.get(i);
            lightweightPlaceViewHolder.f10585m = checkinPlaceModel;
            lightweightPlaceViewHolder.f10586n = i;
            if (lightweightPlaceViewHolder.f10584l != null) {
                lightweightPlaceViewHolder.f10584l.setText(checkinPlaceModel.j());
            }
        }
    }

    public LightweightPlacePickerAdapter(C08471 c08471) {
        this.f10580a = c08471;
    }

    public final void m11083a(List<CheckinPlace> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f10581b = list;
        notifyDataSetChanged();
    }

    public final ViewHolder m11081a(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        if (i == 2130905039) {
            return new LightweightPlaceViewHolder((FbTextView) inflate, this.f10580a);
        }
        if (i == 2130905038) {
            inflate.setOnClickListener(new C12451(this));
        }
        return new LightweightPlaceViewHolder(inflate);
    }

    public final int aZ_() {
        return this.f10581b.size() + 1;
    }

    public int getItemViewType(int i) {
        if (i == this.f10581b.size()) {
            return 2130905038;
        }
        return 2130905039;
    }
}
