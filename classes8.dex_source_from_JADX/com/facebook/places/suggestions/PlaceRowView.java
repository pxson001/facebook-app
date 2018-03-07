package com.facebook.places.suggestions;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLPlaceType;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;

/* compiled from: secondary_actions_menu */
public class PlaceRowView extends CustomViewGroup {
    private static final CallerContext f3650a = CallerContext.a(PlaceRowView.class, "places_recommendations");
    private final FbDraweeView f3651b;
    private final TextView f3652c;
    private final TextView f3653d;
    private final TextView f3654e;
    private final ToggleButton f3655f;
    private final ImageView f3656g;
    public PlaceRow f3657h;

    public PlaceRowView(Context context) {
        this(context, null);
    }

    public PlaceRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlaceRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906263);
        this.f3651b = (FbDraweeView) getView(2131560323);
        this.f3652c = (TextView) getView(2131562901);
        this.f3653d = (TextView) getView(2131566013);
        this.f3654e = (TextView) getView(2131564066);
        this.f3655f = (ToggleButton) getView(2131560317);
        this.f3656g = (ImageView) getView(2131566011);
    }

    public void setInfo(PlaceRow placeRow) {
        this.f3657h = (PlaceRow) Preconditions.checkNotNull(placeRow);
        m3587b();
        m3585a(this.f3655f, this.f3657h.f3646b);
        m3586a(this.f3657h.f3647c);
        m3585a(this.f3654e, this.f3657h.f3648d);
        this.f3655f.setChecked(this.f3657h.f3649e);
    }

    public PlaceRow getInfo() {
        return this.f3657h;
    }

    public final void m3588a() {
        boolean z;
        PlaceRow placeRow = this.f3657h;
        if (placeRow.f3649e) {
            z = false;
        } else {
            z = true;
        }
        placeRow.m3584a(z);
        this.f3655f.setChecked(this.f3657h.f3649e);
    }

    private static void m3585a(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    private void m3586a(boolean z) {
        if (!z) {
            this.f3656g.setVisibility(8);
        } else if (this.f3657h.f3645a.m() != GraphQLPlaceType.EVENT) {
            this.f3656g.setVisibility(0);
        } else {
            this.f3656g.setVisibility(4);
        }
    }

    private void m3587b() {
        Uri uri;
        CheckinPlaceModel checkinPlaceModel = this.f3657h.f3645a;
        if (checkinPlaceModel.d().a() == null) {
            uri = null;
        } else {
            uri = Uri.parse(checkinPlaceModel.d().a());
        }
        this.f3651b.a(uri, f3650a);
        this.f3651b.setBackgroundDrawable(getContext().getResources().getDrawable(2130842670));
        this.f3652c.setText(checkinPlaceModel.j());
        CharSequence charSequence = checkinPlaceModel.c().b() + "\n" + checkinPlaceModel.c().a();
        if (StringUtil.c(charSequence)) {
            this.f3653d.setVisibility(8);
            return;
        }
        this.f3653d.setVisibility(0);
        this.f3653d.setText(charSequence);
    }
}
