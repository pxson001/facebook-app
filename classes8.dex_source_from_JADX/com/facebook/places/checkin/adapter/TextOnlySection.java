package com.facebook.places.checkin.adapter;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.LayerDrawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.app.module.LocaleMethodAutoProvider;
import com.facebook.places.abtest.ExperimentsForPlacesAbTestModule;
import com.facebook.places.checkin.analytics.PlacePickerAnalytics;
import com.facebook.places.checkin.ipc.SearchType;
import com.facebook.places.checkin.models.RowType;
import com.facebook.places.checkin.models.SearchResults;
import com.facebook.places.checkin.utils.CheckinTextModifier;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.ArrayList;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: claimed_coupons */
public class TextOnlySection extends AdapterSection {
    public final QeAccessor f18034a;
    private final Context f18035b;
    private final CheckinTextModifier f18036c;
    private final Locale f18037d;
    private PlacePickerAnalytics f18038e;
    public SearchResults f18039f;
    public String f18040g;
    public SearchType f18041h;

    public static TextOnlySection m21995b(InjectorLike injectorLike) {
        return new TextOnlySection((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), CheckinTextModifier.m22087a(injectorLike), LocaleMethodAutoProvider.b(injectorLike), PlacePickerAnalytics.a(injectorLike));
    }

    @Inject
    public TextOnlySection(QeAccessor qeAccessor, Context context, CheckinTextModifier checkinTextModifier, Locale locale, PlacePickerAnalytics placePickerAnalytics) {
        this.f18034a = qeAccessor;
        this.f18035b = context;
        this.f18036c = checkinTextModifier;
        this.f18037d = locale;
        this.f18038e = placePickerAnalytics;
    }

    public final boolean mo1066a(CheckinPlace checkinPlace, ArrayList<Pair<RowType, Object>> arrayList) {
        return false;
    }

    public final void mo1068b(ArrayList<Pair<RowType, Object>> arrayList) {
    }

    public final String m22002e() {
        return this.f18034a.a(ExperimentsForPlacesAbTestModule.c, "") + this.f18034a.a(ExperimentsForPlacesAbTestModule.b, "");
    }

    public final boolean mo1067a(Object obj) {
        return true;
    }

    public final RowType mo1064a() {
        return RowType.TextOnlyRow;
    }

    public final View mo1063a(View view, ViewGroup viewGroup, Object obj) {
        view = (ContentView) view;
        if (view == null) {
            view = new ContentView(this.f18035b);
            LayerDrawable layerDrawable = (LayerDrawable) this.f18035b.getResources().getDrawable(2130843571);
            layerDrawable.getDrawable(1).setColorFilter(-1, Mode.SRC_ATOP);
            view.setThumbnailDrawable(layerDrawable);
        }
        view.setThumbnailSize(ThumbnailSize.SMALL);
        view.setMaxLinesFromThumbnailSize(false);
        view.setTitleText(this.f18035b.getResources().getString(2131235206));
        view.setSubtitleText(CheckinTextModifier.m22088a(this.f18037d, this.f18040g, this.f18040g));
        return view;
    }

    public final void mo1065a(ArrayList<Pair<RowType, Object>> arrayList) {
        Object obj;
        if (StringUtil.a(this.f18040g) || SearchType.EVENT.equals(this.f18041h) || SearchType.SOCIAL_SEARCH_COMMENT.equals(this.f18041h) || SearchType.SOCIAL_SEARCH_CONVERSION.equals(this.f18041h) || !this.f18034a.a(ExperimentsForPlacesAbTestModule.c, "").equals("top") || !this.f18039f.b.isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            this.f18038e.e(m22002e());
            arrayList.add(Pair.create(RowType.TextOnlyRow, this.f18040g));
        }
    }
}
