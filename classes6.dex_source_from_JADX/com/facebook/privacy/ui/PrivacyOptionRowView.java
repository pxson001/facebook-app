package com.facebook.privacy.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.inject.FbInjector;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: fan_origin */
public class PrivacyOptionRowView extends CustomLinearLayout {
    private final PrivacyIcons f15329a;
    public final TextView f15330b;
    private final ImageView f15331c;
    private final ImageView f15332d;

    public PrivacyOptionRowView(Context context) {
        this(context, null);
    }

    public PrivacyOptionRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130903954);
        setGravity(16);
        setBackgroundResource(2130838469);
        this.f15330b = (TextView) findViewById(2131560883);
        this.f15331c = (ImageView) findViewById(2131559122);
        this.f15332d = (ImageView) findViewById(2131561137);
        this.f15329a = PrivacyIcons.m22956a(FbInjector.get(getContext()));
    }

    public final void m22960a(GraphQLPrivacyOption graphQLPrivacyOption, boolean z) {
        int i = 0;
        setClickable(!z);
        this.f15330b.setText(graphQLPrivacyOption.d());
        int a = this.f15329a.m22958a(graphQLPrivacyOption.l(), Size.LIST);
        if (a >= 0) {
            this.f15331c.setImageResource(a);
            this.f15331c.setVisibility(0);
        } else {
            this.f15331c.setVisibility(4);
        }
        ImageView imageView = this.f15332d;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }
}
