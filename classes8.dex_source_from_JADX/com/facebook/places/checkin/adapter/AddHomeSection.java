package com.facebook.places.checkin.adapter;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLCheckinPromptType;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: clear_button */
public class AddHomeSection extends AdapterSection {
    private final LayoutInflater f17995a;
    public SearchResults f17996b;

    public static AddHomeSection m21964b(InjectorLike injectorLike) {
        return new AddHomeSection(LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public AddHomeSection(LayoutInflater layoutInflater) {
        this.f17995a = layoutInflater;
    }

    public final View mo1063a(View view, ViewGroup viewGroup, Object obj) {
        if (view == null) {
            return this.f17995a.inflate(2130903155, viewGroup, false);
        }
        return view;
    }

    public final boolean mo1066a(CheckinPlace checkinPlace, ArrayList<Pair<RowType, Object>> arrayList) {
        return false;
    }

    public final boolean mo1067a(Object obj) {
        return true;
    }

    public final RowType mo1064a() {
        return RowType.AddHome;
    }

    public final void mo1065a(ArrayList<Pair<RowType, Object>> arrayList) {
        Object obj;
        if (this.f17996b == null || this.f17996b.f != GraphQLCheckinPromptType.HOME_CREATION) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            arrayList.add(new Pair(RowType.AddHome, null));
        }
    }
}
