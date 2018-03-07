package com.facebook.places.create.citypicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: see_more_source */
public class CityPickerAdapter extends BaseAdapter {
    private static final CallerContext f3556a = CallerContext.a(CityPickerAdapter.class, "place_home");
    private LayoutInflater f3557b;
    private List<CheckinPlace> f3558c = Lists.a();

    public /* synthetic */ Object getItem(int i) {
        return m3479a(i);
    }

    @Inject
    public CityPickerAdapter(LayoutInflater layoutInflater) {
        this.f3557b = layoutInflater;
    }

    public int getCount() {
        return this.f3558c.size();
    }

    private CheckinPlaceModel m3479a(int i) {
        return (CheckinPlaceModel) this.f3558c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = this.f3557b.inflate(2130903572, viewGroup, false);
        ContentView contentView = (ContentView) inflate.findViewById(2131560321);
        contentView.setTitleText(m3479a(i).j());
        contentView.setShowThumbnail(true);
        ((FbDraweeView) inflate.findViewById(2131560323)).a(null, f3556a);
        return inflate;
    }

    public final void m3480a(List<CheckinPlace> list) {
        this.f3558c = ImmutableList.copyOf(list);
        AdapterDetour.a(this, 1310662948);
    }
}
