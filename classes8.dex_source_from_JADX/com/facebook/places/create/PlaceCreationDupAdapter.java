package com.facebook.places.create;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.places.graphql.PlacesGraphQLHelper;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.google.common.collect.Lists;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: cbb6962062b4148f6830f60ebf6fbd73 */
public class PlaceCreationDupAdapter extends BaseAdapter {
    private final Context f18202a;
    private LayoutInflater f18203b;
    private Locale f18204c;
    public List<CheckinPlace> f18205d = Lists.a();

    public /* synthetic */ Object getItem(int i) {
        return m22169a(i);
    }

    @Inject
    public PlaceCreationDupAdapter(Context context, LayoutInflater layoutInflater, Locale locale) {
        this.f18202a = context;
        this.f18203b = layoutInflater;
        this.f18204c = locale;
    }

    public int getCount() {
        return this.f18205d.size();
    }

    private CheckinPlaceModel m22169a(int i) {
        return (CheckinPlaceModel) this.f18205d.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        getItemViewType(i);
        View inflate = this.f18203b.inflate(2130903822, viewGroup, false);
        CheckinPlaceModel a = m22169a(i);
        ContentView contentView = (ContentView) inflate.findViewById(2131560840);
        CharSequence j = a.j();
        int a2 = StringLengthHelper.a(j);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(j);
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, a2, 17);
        contentView.setTitleText(spannableStringBuilder);
        CharSequence a3 = PlacesGraphQLHelper.a(a);
        if (StringUtil.c(a3)) {
            a3 = "";
        }
        contentView.setSubtitleText(a3);
        contentView.setMetaText(m22170b(a));
        contentView.setShowThumbnail(false);
        return inflate;
    }

    private String m22170b(CheckinPlaceModel checkinPlaceModel) {
        NumberFormat instance = NumberFormat.getInstance(this.f18204c);
        return this.f18202a.getResources().getQuantityString(2131689608, checkinPlaceModel.k() == null ? 0 : checkinPlaceModel.k().a(), new Object[]{instance.format((long) (checkinPlaceModel.k() == null ? 0 : checkinPlaceModel.k().a()))});
    }
}
