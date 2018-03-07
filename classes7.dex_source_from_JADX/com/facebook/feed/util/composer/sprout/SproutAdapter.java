package com.facebook.feed.util.composer.sprout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.ViewProvider;
import com.facebook.inject.Assisted;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

/* compiled from: TURN_OFF_NOTIFICATION */
public class SproutAdapter extends BaseAdapter {
    private final Context f22422a;
    private final int f22423b;
    private final SproutListItemBinder f22424c;
    public ImmutableList<SproutSpec> f22425d = RegularImmutableList.a;

    @Inject
    public SproutAdapter(@Assisted Context context, SproutListItemBinder sproutListItemBinder) {
        this.f22422a = context;
        this.f22424c = sproutListItemBinder;
        this.f22423b = SproutItemViewType.values().length;
    }

    public int getCount() {
        return this.f22425d.size();
    }

    public Object getItem(int i) {
        return this.f22425d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        SproutSpec sproutSpec = (SproutSpec) getItem(i);
        if (sproutSpec.f22473k != null) {
            return sproutSpec.f22473k.a(view, viewGroup);
        }
        SproutListItem a = view != null ? (SproutListItem) view : SproutListItem.m25035a(this.f22422a, viewGroup);
        this.f22424c.m25056a(sproutSpec, a);
        return a;
    }

    public final void m25022a(ImmutableList<SproutSpec> immutableList) {
        this.f22425d = immutableList;
        AdapterDetour.a(this, -1064243799);
    }

    public int getItemViewType(int i) {
        SproutSpec sproutSpec = (SproutSpec) getItem(i);
        if (sproutSpec.f22473k == null) {
            return SproutItemViewType.DEFAULT.ordinal();
        }
        ViewProvider viewProvider = sproutSpec.f22473k;
        return SproutItemViewType.LOCATION_LIGHTWEIGHT_PICKER.ordinal();
    }

    public int getViewTypeCount() {
        return this.f22423b;
    }
}
