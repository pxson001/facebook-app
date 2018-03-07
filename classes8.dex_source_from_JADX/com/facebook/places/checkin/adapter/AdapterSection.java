package com.facebook.places.checkin.adapter;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import java.util.ArrayList;

/* compiled from: cleared_filter */
public abstract class AdapterSection {
    public abstract View mo1063a(View view, ViewGroup viewGroup, Object obj);

    public abstract RowType mo1064a();

    public abstract boolean mo1066a(CheckinPlace checkinPlace, ArrayList<Pair<RowType, Object>> arrayList);

    public abstract boolean mo1067a(Object obj);

    public RowType mo1069b() {
        return RowType.Undefined;
    }

    public boolean mo1070c() {
        return false;
    }

    public void mo1065a(ArrayList<Pair<RowType, Object>> arrayList) {
    }

    public void mo1068b(ArrayList<Pair<RowType, Object>> arrayList) {
    }

    public void mo1071d() {
    }
}
