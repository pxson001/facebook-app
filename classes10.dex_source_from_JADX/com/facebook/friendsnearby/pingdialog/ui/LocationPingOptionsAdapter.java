package com.facebook.friendsnearby.pingdialog.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: [[birthday_help]] */
public class LocationPingOptionsAdapter extends FbBaseAdapter {
    private final Context f20664a;
    public ImmutableList<LocationPingOption> f20665b = RegularImmutableList.a;

    public /* synthetic */ Object getItem(int i) {
        return m21143a(i);
    }

    public LocationPingOptionsAdapter(Context context) {
        this.f20664a = context;
    }

    public int getCount() {
        return this.f20665b.size();
    }

    public final LocationPingOption m21143a(int i) {
        return (LocationPingOption) this.f20665b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m21142a(int i, ViewGroup viewGroup) {
        Object locationPingOptionView = new LocationPingOptionView(this.f20664a);
        locationPingOptionView.setBackgroundResource(2130841109);
        return locationPingOptionView;
    }

    public final void m21144a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((LocationPingOptionView) view).setPingOption((LocationPingOption) obj);
    }
}
