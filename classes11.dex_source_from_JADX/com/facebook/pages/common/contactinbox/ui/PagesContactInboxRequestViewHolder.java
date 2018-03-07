package com.facebook.pages.common.contactinbox.ui;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: staging */
public class PagesContactInboxRequestViewHolder extends ViewHolder {
    private CustomRelativeLayout f1450l;
    private GlyphView f1451m;
    public FbTextView f1452n;
    public FbTextView f1453o;
    public FbTextView f1454p;
    public FbTextView f1455q;

    /* compiled from: staging */
    /* synthetic */ class C02001 {
        static final /* synthetic */ int[] f1449a = new int[GraphQLPageLeadGenInfoState.values().length];

        static {
            try {
                f1449a[GraphQLPageLeadGenInfoState.UNREAD.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1449a[GraphQLPageLeadGenInfoState.RESPONDED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1449a[GraphQLPageLeadGenInfoState.READ.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public PagesContactInboxRequestViewHolder(View view) {
        super(view);
        this.f1450l = (CustomRelativeLayout) view.findViewById(2131565705);
        this.f1451m = (GlyphView) view.findViewById(2131565699);
        this.f1452n = (FbTextView) view.findViewById(2131565702);
        this.f1453o = (FbTextView) view.findViewById(2131565706);
        this.f1454p = (FbTextView) view.findViewById(2131565704);
        this.f1455q = (FbTextView) view.findViewById(2131565703);
    }

    public final void m2128a(String str, int i) {
        this.f1453o.setText(str);
        this.f1453o.setTextColor(i);
        this.f1453o.setVisibility(0);
        this.f1454p.setPadding(this.f1454p.getPaddingLeft(), this.f1450l.getContext().getResources().getDimensionPixelSize(2131427418), this.f1454p.getPaddingRight(), this.f1454p.getPaddingBottom());
    }

    public final void m2127a(GraphQLPageLeadGenInfoState graphQLPageLeadGenInfoState) {
        switch (C02001.f1449a[graphQLPageLeadGenInfoState.ordinal()]) {
            case 1:
                this.f1451m.setVisibility(4);
                this.f1450l.setBackgroundResource(2130842494);
                return;
            case 2:
                this.f1451m.setVisibility(0);
                this.f1450l.setBackgroundResource(2130842493);
                return;
            default:
                this.f1451m.setVisibility(4);
                this.f1450l.setBackgroundResource(2130842493);
                return;
        }
    }
}
