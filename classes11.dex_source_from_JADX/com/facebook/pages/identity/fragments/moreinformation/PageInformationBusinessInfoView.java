package com.facebook.pages.identity.fragments.moreinformation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLBusinessInfoType;
import com.facebook.graphql.enums.GraphQLPagePaymentOption;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.BusinessInfoModel;
import com.facebook.pages.identity.protocol.graphql.PageInformationDataGraphQLModels.PageInformationDataModel.BusinessInfoModel.ValueModel.RangesModel;
import com.facebook.pages.identity.ui.text.TwoStringTextView;
import com.facebook.widget.CustomFrameLayout;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* compiled from: pages_browser_landing_page_load_successful */
public class PageInformationBusinessInfoView extends CustomFrameLayout {
    private final TwoStringTextView f3971a;
    private final LinearLayout f3972b;
    private final LinearLayout f3973c;
    private final TextView f3974d;
    private final ImageView f3975e;
    private final ImageView f3976f;
    private final ImageView f3977g;
    private final ImageView f3978h;
    private final View f3979i;
    private final View f3980j;
    private final ColorStateList f3981k;
    private final LayoutInflater f3982l;
    private boolean f3983m;
    private boolean f3984n;
    private boolean f3985o;
    private BusinessInfoModel f3986p;
    private BusinessInfoModel f3987q;
    private BusinessInfoModel f3988r;

    public PageInformationBusinessInfoView(Context context) {
        this(context, null);
    }

    public PageInformationBusinessInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageInformationBusinessInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130906047);
        this.f3971a = (TwoStringTextView) c(2131565563);
        this.f3972b = (LinearLayout) c(2131565565);
        this.f3973c = (LinearLayout) c(2131565567);
        this.f3974d = (TextView) c(2131565568);
        this.f3977g = (ImageView) c(2131565569);
        this.f3978h = (ImageView) c(2131565572);
        this.f3976f = (ImageView) c(2131565571);
        this.f3975e = (ImageView) c(2131565570);
        this.f3979i = c(2131565564);
        this.f3980j = c(2131565566);
        this.f3981k = ColorStateList.valueOf(getResources().getColor(2131361972));
        this.f3982l = LayoutInflater.from(context);
    }

    public void setData(PageInformationDataModel pageInformationDataModel) {
        if (!(pageInformationDataModel.k() == null || pageInformationDataModel.k().isEmpty())) {
            ImmutableList k = pageInformationDataModel.k();
            int size = k.size();
            for (int i = 0; i < size; i++) {
                BusinessInfoModel businessInfoModel = (BusinessInfoModel) k.get(i);
                if (businessInfoModel.a() == GraphQLBusinessInfoType.SPECIALTY) {
                    this.f3986p = businessInfoModel;
                } else if (businessInfoModel.a() == GraphQLBusinessInfoType.PARKING) {
                    this.f3987q = businessInfoModel;
                } else if (businessInfoModel.a() == GraphQLBusinessInfoType.SERVICES) {
                    this.f3988r = businessInfoModel;
                    m4917e();
                }
            }
        }
        m4916b();
        if (pageInformationDataModel.u() != null) {
            setPaymentOptions(pageInformationDataModel.u());
        }
        m4914a();
    }

    private void m4914a() {
        if (this.f3983m && this.f3984n) {
            this.f3979i.setVisibility(0);
        }
        if (this.f3984n && this.f3985o) {
            this.f3980j.setVisibility(0);
        }
        if (this.f3983m && !this.f3984n && this.f3985o) {
            this.f3979i.setVisibility(0);
        }
    }

    private void m4916b() {
        CharSequence charSequence = null;
        if (m4915a(this.f3986p) || m4915a(this.f3987q)) {
            CharSequence a;
            this.f3971a.setVisibility(0);
            if (m4915a(this.f3986p)) {
                a = m4913a(this.f3986p.j().j(), this.f3986p.j().a());
            } else {
                a = null;
            }
            if (m4915a(this.f3987q) && this.f3987q.j() != null) {
                charSequence = m4913a(this.f3987q.j().j(), this.f3987q.j().a());
            }
            this.f3971a.m5238a(a, charSequence, " · ");
            this.f3983m = true;
        }
    }

    private void m4917e() {
        this.f3972b.removeAllViews();
        if (m4915a(this.f3988r) && this.f3988r.j() != null) {
            String[] split = this.f3988r.j().j().split("\n");
            if (split.length > 0) {
                this.f3984n = true;
                this.f3972b.setVisibility(0);
            }
            for (int i = 0; i < (split.length + 1) / 2; i++) {
                View inflate = this.f3982l.inflate(2130906059, null);
                if (split.length == 1) {
                    LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131565602);
                    LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams.addRule(13, 1);
                    linearLayout.setLayoutParams(layoutParams);
                }
                if (i * 2 < split.length) {
                    ((TextView) ((RelativeLayout) inflate.findViewById(2131565604)).findViewById(2131565603)).setText(split[i * 2]);
                }
                if ((i * 2) + 1 < split.length) {
                    ((TextView) ((RelativeLayout) inflate.findViewById(2131565605)).findViewById(2131565603)).setText(split[(i * 2) + 1]);
                } else {
                    inflate.findViewById(2131565605).setVisibility(8);
                }
                this.f3972b.addView(inflate);
            }
        }
    }

    private void setPaymentOptions(List<GraphQLPagePaymentOption> list) {
        for (GraphQLPagePaymentOption graphQLPagePaymentOption : list) {
            if (graphQLPagePaymentOption.equals(GraphQLPagePaymentOption.MASTERCARD)) {
                this.f3985o = true;
                this.f3975e.setVisibility(0);
            } else if (graphQLPagePaymentOption.equals(GraphQLPagePaymentOption.VISA)) {
                this.f3985o = true;
                this.f3976f.setVisibility(0);
            } else if (graphQLPagePaymentOption.equals(GraphQLPagePaymentOption.AMEX)) {
                this.f3985o = true;
                this.f3977g.setVisibility(0);
            } else if (graphQLPagePaymentOption.equals(GraphQLPagePaymentOption.DISCOVER)) {
                this.f3985o = true;
                this.f3978h.setVisibility(0);
            } else if (graphQLPagePaymentOption.equals(GraphQLPagePaymentOption.CASH_ONLY)) {
                this.f3985o = true;
                this.f3974d.setVisibility(0);
                if (list.size() > 1) {
                    this.f3974d.setText(getResources().getString(2131235457));
                }
            }
        }
        if (this.f3985o) {
            this.f3973c.setVisibility(0);
        }
    }

    private SpannableString m4913a(String str, List<RangesModel> list) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
        for (RangesModel rangesModel : list) {
            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, -1, this.f3981k, null);
            UTF16Range a = RangeConverter.a(str, new CodePointRange(rangesModel.j(), rangesModel.a()));
            spannableStringBuilder.setSpan(textAppearanceSpan, a.a, a.c(), 18);
        }
        return new SpannableString(spannableStringBuilder);
    }

    private static boolean m4915a(BusinessInfoModel businessInfoModel) {
        return (businessInfoModel == null || businessInfoModel.j() == null || StringUtil.a(businessInfoModel.j().j())) ? false : true;
    }
}
