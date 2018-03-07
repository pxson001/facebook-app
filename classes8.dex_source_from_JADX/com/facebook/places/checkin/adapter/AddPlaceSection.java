package com.facebook.places.checkin.adapter;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.PlaceCreationAnalyticsLogger;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: clear */
public class AddPlaceSection extends AdapterSection {
    private final LayoutInflater f17998a;
    public final PlaceCreationAnalyticsLogger f17999b;
    public boolean f18000c = false;
    public String f18001d = null;
    public Context f18002e;

    /* compiled from: clear */
    class ViewHolder {
        public TextView f17997a;
    }

    public static AddPlaceSection m21970b(InjectorLike injectorLike) {
        return new AddPlaceSection(LayoutInflaterMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class), PlaceCreationAnalyticsLogger.a(injectorLike));
    }

    @Inject
    public AddPlaceSection(LayoutInflater layoutInflater, Context context, PlaceCreationAnalyticsLogger placeCreationAnalyticsLogger) {
        this.f17998a = layoutInflater;
        this.f18002e = context;
        this.f17999b = placeCreationAnalyticsLogger;
    }

    public final View mo1063a(View view, ViewGroup viewGroup, Object obj) {
        int i;
        if (view == null) {
            view = this.f17998a.inflate(2130903156, viewGroup, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.f17997a = (TextView) view.findViewById(2131559356);
            view.setTag(viewHolder);
        }
        TextView textView = ((ViewHolder) view.getTag()).f17997a;
        this.f17999b.a(CrowdEntryPoint.PLACE_PICKER_ADD_BUTTON);
        String string = this.f18002e.getResources().getString(2131235145);
        CharSequence[] charSequenceArr = new CharSequence[0];
        int i2 = 0;
        String[] strArr = new String[charSequenceArr.length];
        for (i = 0; i < charSequenceArr.length; i++) {
            strArr[i] = String.format("###magic%d###", new Object[]{Integer.valueOf(i)});
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(string, strArr));
        while (i2 < charSequenceArr.length) {
            i = spannableStringBuilder.toString().indexOf(strArr[i2]);
            spannableStringBuilder.replace(i, strArr[i2].length() + i, charSequenceArr[i2]);
            i2++;
        }
        textView.setText(spannableStringBuilder);
        return view;
    }

    public final boolean mo1066a(CheckinPlace checkinPlace, ArrayList<Pair<RowType, Object>> arrayList) {
        return false;
    }

    public final boolean mo1067a(Object obj) {
        return true;
    }

    public final RowType mo1064a() {
        return RowType.AddPlace;
    }

    public final void mo1068b(ArrayList<Pair<RowType, Object>> arrayList) {
        Object obj;
        if (this.f18001d == null || !this.f18000c) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            arrayList.add(new Pair(RowType.AddPlace, null));
        }
    }
}
