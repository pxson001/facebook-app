package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.backgroundlocation.privacypicker.BackgroundLocationPrivacyPickerOptionsAdapter;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLInterfaces.BackgroundLocationPrivacyPickerOptionEdge;
import com.facebook.backgroundlocation.privacypicker.graphql.BackgroundLocationPrivacyPickerGraphQLModels.BackgroundLocationPrivacyPickerOptionEdgeModel;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellFacepileUtil;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellText;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.fbui.popover.PopoverSpinner;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: XZ */
public class FriendsNearbyFeatureDisabledView extends CustomLinearLayout {
    @Inject
    public BackgroundLocationUpsellText f20830a;
    private TextView f20831b;
    private FacepileView f20832c;
    private ImageView f20833d;
    private TextView f20834e;
    public PopoverSpinner f20835f;
    private TextView f20836g;
    private Button f20837h;
    public BackgroundLocationPrivacyPickerOptionsAdapter f20838i;

    private static <T extends View> void m21734a(Class<T> cls, T t) {
        m21735a((Object) t, t.getContext());
    }

    private static void m21735a(Object obj, Context context) {
        ((FriendsNearbyFeatureDisabledView) obj).f20830a = BackgroundLocationUpsellText.m15563a(FbInjector.get(context));
    }

    private void m21733a(BackgroundLocationUpsellText backgroundLocationUpsellText) {
        this.f20830a = backgroundLocationUpsellText;
    }

    public FriendsNearbyFeatureDisabledView(Context context) {
        super(context);
        m21732a();
    }

    public FriendsNearbyFeatureDisabledView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m21732a();
    }

    public FriendsNearbyFeatureDisabledView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21732a();
    }

    private void m21732a() {
        setContentView(2130904526);
        m21734a(FriendsNearbyFeatureDisabledView.class, (View) this);
        setOrientation(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434235);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361980)));
        this.f20831b = (TextView) a(2131562369);
        this.f20832c = (FacepileView) a(2131562370);
        this.f20833d = (ImageView) a(2131562371);
        this.f20834e = (TextView) a(2131562372);
        this.f20835f = (PopoverSpinner) a(2131562373);
        this.f20836g = (TextView) a(2131562374);
        this.f20837h = (Button) a(2131562375);
    }

    public final void m21736a(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        if (i < 2) {
            this.f20831b.setVisibility(8);
            this.f20832c.setVisibility(8);
            this.f20833d.setVisibility(0);
            return;
        }
        this.f20831b.setVisibility(0);
        this.f20832c.setVisibility(0);
        this.f20833d.setVisibility(8);
        this.f20831b.setText(this.f20830a.m15569a(i, (ImmutableList) immutableList));
        BackgroundLocationUpsellFacepileUtil.m15556a(this.f20832c, immutableList);
    }

    public void setPrivacyPicker(@Nullable ImmutableList<? extends BackgroundLocationPrivacyPickerOptionEdge> immutableList) {
        int i = -1;
        int i2 = immutableList == null ? 8 : 0;
        this.f20834e.setVisibility(i2);
        this.f20835f.setVisibility(i2);
        if (immutableList == null) {
            this.f20838i = null;
            return;
        }
        this.f20838i = new BackgroundLocationPrivacyPickerOptionsAdapter();
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        while (i3 < size) {
            BackgroundLocationPrivacyPickerOptionEdgeModel backgroundLocationPrivacyPickerOptionEdgeModel = (BackgroundLocationPrivacyPickerOptionEdgeModel) immutableList.get(i3);
            String c = backgroundLocationPrivacyPickerOptionEdgeModel.m15308c().m15316c();
            if (c.equals("{\"value\":\"SELF\"}")) {
                i2 = i5;
                i5 = i;
            } else {
                builder.c(backgroundLocationPrivacyPickerOptionEdgeModel.m15308c());
                if (backgroundLocationPrivacyPickerOptionEdgeModel.m15307b()) {
                    i2 = i4;
                } else {
                    i2 = i5;
                }
                if (c.equals("{\"value\":\"ALL_FRIENDS\"}")) {
                    i5 = i4;
                } else {
                    i5 = i;
                }
                i4++;
            }
            i3++;
            i = i5;
            i5 = i2;
        }
        if (i5 < 0) {
            if (i >= 0) {
                i5 = i;
            } else {
                i5 = 0;
            }
        }
        this.f20838i.m15299a(builder.b());
        this.f20835f.setAdapter(this.f20838i);
        this.f20835f.setSelection(i5);
    }

    public final void m21737a(@Nullable CharSequence charSequence, OnClickListener onClickListener) {
        this.f20836g.setVisibility(charSequence == null ? 8 : 0);
        if (charSequence != null) {
            this.f20836g.setText(charSequence);
            this.f20836g.setOnClickListener(onClickListener);
        }
    }

    public final void m21738b(CharSequence charSequence, OnClickListener onClickListener) {
        this.f20837h.setText(charSequence);
        this.f20837h.setOnClickListener(onClickListener);
    }
}
