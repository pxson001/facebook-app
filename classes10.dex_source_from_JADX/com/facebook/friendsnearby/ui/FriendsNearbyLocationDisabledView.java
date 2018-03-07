package com.facebook.friendsnearby.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellFacepileUtil;
import com.facebook.backgroundlocation.upsell.BackgroundLocationUpsellText;
import com.facebook.backgroundlocation.upsell.graphql.BackgroundLocationUpsellGraphQLInterfaces.BackgroundLocationUpsellProfile;
import com.facebook.fbui.facepile.FacepileView;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Website */
public class FriendsNearbyLocationDisabledView extends CustomLinearLayout {
    @Inject
    public BackgroundLocationUpsellText f20940a;
    private Button f20941b;
    private FacepileView f20942c;
    private TextView f20943d;
    private TextView f20944e;

    private static <T extends View> void m21923a(Class<T> cls, T t) {
        m21924a((Object) t, t.getContext());
    }

    private static void m21924a(Object obj, Context context) {
        ((FriendsNearbyLocationDisabledView) obj).f20940a = BackgroundLocationUpsellText.m15563a(FbInjector.get(context));
    }

    public FriendsNearbyLocationDisabledView(Context context) {
        super(context);
        m21921a();
    }

    private void m21922a(BackgroundLocationUpsellText backgroundLocationUpsellText) {
        this.f20940a = backgroundLocationUpsellText;
    }

    public FriendsNearbyLocationDisabledView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m21921a();
    }

    public FriendsNearbyLocationDisabledView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21921a();
    }

    private void m21921a() {
        setContentView(2130904530);
        m21923a(FriendsNearbyLocationDisabledView.class, (View) this);
        setOrientation(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131434235);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131361980)));
        this.f20941b = (Button) a(2131562377);
        this.f20942c = (FacepileView) a(2131562378);
        this.f20943d = (TextView) a(2131562379);
        this.f20944e = (TextView) a(2131562380);
    }

    public final void m21925a(int i, ImmutableList<? extends BackgroundLocationUpsellProfile> immutableList) {
        if (i < 2) {
            this.f20943d.setVisibility(8);
            this.f20942c.setVisibility(8);
            return;
        }
        this.f20943d.setVisibility(0);
        this.f20942c.setVisibility(0);
        this.f20943d.setText(this.f20940a.m15569a(i, (ImmutableList) immutableList));
        BackgroundLocationUpsellFacepileUtil.m15556a(this.f20942c, immutableList);
    }

    public final void m21926a(@Nullable CharSequence charSequence, OnClickListener onClickListener) {
        this.f20944e.setVisibility(charSequence == null ? 8 : 0);
        if (charSequence != null) {
            this.f20944e.setText(charSequence);
            this.f20944e.setOnClickListener(onClickListener);
        }
    }

    public final void m21927b(CharSequence charSequence, OnClickListener onClickListener) {
        this.f20941b.setText(charSequence);
        this.f20941b.setOnClickListener(onClickListener);
    }
}
