package com.facebook.places.checkin.adapter;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: claim_deleted */
public class UseAsTextSection extends AdapterSection {
    private final LayoutInflater f18043a;
    public String f18044b;

    /* compiled from: claim_deleted */
    class ViewHolder {
        public TextView f18042a;
    }

    public static UseAsTextSection m22003b(InjectorLike injectorLike) {
        return new UseAsTextSection(LayoutInflaterMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public UseAsTextSection(LayoutInflater layoutInflater) {
        this.f18043a = layoutInflater;
    }

    public final View mo1063a(View view, ViewGroup viewGroup, Object obj) {
        if (view == null) {
            view = this.f18043a.inflate(2130904993, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.f18042a = (TextView) view.findViewById(2131563338);
            view.setTag(viewHolder);
        }
        ((ViewHolder) view.getTag()).f18042a.setText(this.f18044b);
        return view;
    }

    public final void mo1068b(ArrayList<Pair<RowType, Object>> arrayList) {
        if (!StringUtil.a(this.f18044b)) {
            arrayList.add(new Pair(RowType.UseAsText, null));
        }
    }

    public final boolean mo1066a(CheckinPlace checkinPlace, ArrayList<Pair<RowType, Object>> arrayList) {
        return false;
    }

    public final boolean mo1067a(Object obj) {
        return true;
    }

    public final RowType mo1064a() {
        return RowType.UseAsText;
    }
}
