package com.facebook.messaging.business.airline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.messaging.business.airline.enums.AirlineBubbleType;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: thread_group_settings */
public class AirlineHeaderView extends CustomRelativeLayout {
    private final ImmutableList<BetterTextView> f1583a;
    private final ImmutableList<BetterTextView> f1584b;
    private final FbDraweeView f1585c;
    private final AirlineBubbleType f1586d;

    public AirlineHeaderView(Context context) {
        this(context, null, 0);
    }

    public AirlineHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AirlineHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903214);
        BetterTextView betterTextView = (BetterTextView) a(2131559510);
        BetterTextView betterTextView2 = (BetterTextView) a(2131559508);
        this.f1583a = ImmutableList.of((BetterTextView) a(2131559509), (BetterTextView) a(2131559507));
        this.f1584b = ImmutableList.of(betterTextView, betterTextView2);
        this.f1585c = (FbDraweeView) a(2131559504);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AirlineView);
            this.f1586d = AirlineBubbleType.values()[obtainStyledAttributes.getInt(2, 0)];
            obtainStyledAttributes.recycle();
        } else {
            this.f1586d = AirlineBubbleType.RECEIPT;
        }
        m1573a();
    }

    private void m1573a() {
        int i;
        int i2;
        int i3;
        switch (this.f1586d) {
            case RECEIPT:
            case CHECKIN:
            case BOARDING:
                this.f1585c.setColorFilter(-1);
                i = 2131626471;
                i2 = 2131626472;
                break;
            case DELAYED:
                i = 2131626470;
                i2 = 2131626473;
                break;
            default:
                throw new UnsupportedOperationException("Unsupported bubble type: " + this.f1586d);
        }
        int size = this.f1583a.size();
        for (i3 = 0; i3 < size; i3++) {
            ((BetterTextView) this.f1583a.get(i3)).setTextAppearance(getContext(), i);
        }
        i3 = this.f1584b.size();
        for (i = 0; i < i3; i++) {
            ((BetterTextView) this.f1584b.get(i)).setTextAppearance(getContext(), i2);
        }
    }

    private void m1574a(int i, String str) {
        BetterTextView betterTextView = (BetterTextView) this.f1583a.get(i);
        if (betterTextView.getVisibility() == 8) {
            betterTextView.setVisibility(0);
        }
        betterTextView.setText(str);
    }

    private void m1575b(int i, String str) {
        BetterTextView betterTextView = (BetterTextView) this.f1584b.get(i);
        if (betterTextView.getVisibility() == 8) {
            betterTextView.setVisibility(0);
        }
        betterTextView.setText(str);
    }

    public void setTitles(List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m1574a(i, (String) list.get(i));
        }
    }

    public void setTexts(List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m1575b(i, (String) list.get(i));
        }
    }

    public void setLogoImage(@Nullable LogoImage logoImage) {
        if (logoImage != null && !Strings.isNullOrEmpty(logoImage.b())) {
            this.f1585c.a(Uri.parse(logoImage.b()), CallerContext.a(getClass()));
        }
    }
}
