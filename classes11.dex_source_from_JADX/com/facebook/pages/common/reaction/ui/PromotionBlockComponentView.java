package com.facebook.pages.common.reaction.ui;

import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.CustomViewUtils;

/* compiled from: search_area */
public class PromotionBlockComponentView extends CustomLinearLayout {
    private static final CallerContext f2225k = CallerContext.a(PromotionBlockComponentView.class, "page_reaction_fragment");
    private final FbTextView f2226a = ((FbTextView) a(2131560281));
    private final FbDraweeView f2227b = ((FbDraweeView) a(2131566422));
    private final FbTextView f2228c = ((FbTextView) a(2131566423));
    private final FbTextView f2229d = ((FbTextView) a(2131563416));
    private final FbTextView f2230e = ((FbTextView) a(2131559294));
    private final FbTextView f2231f = ((FbTextView) a(2131559295));
    private final FbTextView f2232g = ((FbTextView) a(2131559296));
    private final FbTextView f2233h = ((FbTextView) a(2131559297));
    public final FbTextView f2234i = ((FbTextView) a(2131566425));
    private final View f2235j = a(2131566424);

    /* compiled from: search_area */
    /* synthetic */ class C02811 {
        static final /* synthetic */ int[] f2224a = new int[GraphQLBoostedComponentStatus.values().length];

        static {
            try {
                f2224a[GraphQLBoostedComponentStatus.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2224a[GraphQLBoostedComponentStatus.PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2224a[GraphQLBoostedComponentStatus.PENDING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2224a[GraphQLBoostedComponentStatus.REJECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2224a[GraphQLBoostedComponentStatus.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2224a[GraphQLBoostedComponentStatus.EXTENDABLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public PromotionBlockComponentView(Context context) {
        super(context);
        setContentView(2130906492);
        setOrientation(1);
        CustomViewUtils.b(this, ContextCompat.a(context, 2130842491));
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(2131429798);
        int dimensionPixelSize2 = getContext().getResources().getDimensionPixelSize(2131429797);
        setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
    }

    public final void m3185a(GraphQLBoostedComponentStatus graphQLBoostedComponentStatus, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f2226a.setText(str2);
        this.f2228c.setText(str3);
        this.f2227b.a(Uri.parse(str), f2225k);
        this.f2229d.setText(str4);
        this.f2230e.setText(str5);
        this.f2231f.setText(str6);
        this.f2232g.setText(str7);
        this.f2233h.setText(str8);
        setStatus(graphQLBoostedComponentStatus);
        if (StringUtil.a(str9)) {
            this.f2234i.setVisibility(8);
            return;
        }
        this.f2234i.setText(str9);
        this.f2234i.setVisibility(0);
    }

    private void setStatus(GraphQLBoostedComponentStatus graphQLBoostedComponentStatus) {
        switch (C02811.f2224a[graphQLBoostedComponentStatus.ordinal()]) {
            case 1:
                this.f2229d.setTextColor(getResources().getColor(2131363879));
                this.f2235j.setVisibility(0);
                this.f2229d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840615), null, null, null);
                return;
            case 2:
                this.f2229d.setTextColor(getResources().getColor(2131363878));
                this.f2235j.setVisibility(0);
                this.f2229d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842975), null, null, null);
                return;
            case 3:
                this.f2229d.setTextColor(getResources().getColor(2131363879));
                this.f2229d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130840615), null, null, null);
                return;
            case 4:
                this.f2229d.setTextColor(getResources().getColor(2131363878));
                this.f2234i.setTextColor(getResources().getColor(2131363880));
                this.f2229d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130842975), null, null, null);
                return;
            case 5:
            case 6:
                this.f2229d.setTextColor(getResources().getColor(2131363881));
                this.f2235j.setVisibility(0);
                this.f2229d.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(2130838076), null, null, null);
                return;
            default:
                return;
        }
    }
}
