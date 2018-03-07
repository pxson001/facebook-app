package com.facebook.feedplugins.facebookvoice;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;

/* compiled from: Subscriber  */
public class FacebookVoiceHeaderView extends CustomRelativeLayout implements CanShowHeaderOptionsMenu {
    GraphQLImage f23081a;
    GraphQLImage f23082b;
    GraphQLImage f23083c;
    public final TextView f23084d = ((TextView) a(2131561593));
    private final TextView f23085e = ((TextView) a(2131559769));
    private final TextWithEntitiesView f23086f = ((TextWithEntitiesView) a(2131559627));
    private final FbDraweeView f23087g = ((FbDraweeView) a(2131560864));
    public final FbDraweeView f23088h = ((FbDraweeView) a(2131560271));
    private final ImageView f23089i = ((ImageView) a(2131560877));
    private boolean f23090j;
    private final FbDraweeView f23091k = ((FbDraweeView) a(2131560865));
    public final View f23092l = a(2131560593);
    private boolean f23093m;

    public FacebookVoiceHeaderView(Context context) {
        super(context);
        setContentView(2130904185);
    }

    public void setMenuButtonActive(boolean z) {
        this.f23089i.setVisibility(z ? 0 : 8);
    }

    private boolean m25526a() {
        return this.f23089i.getVisibility() == 0;
    }

    public final boolean hk_() {
        return m25526a();
    }

    public final void m25527a(Tooltip tooltip) {
        tooltip.f(this.f23089i);
    }

    public void setContentSummaryColor(int i) {
        this.f23084d.setTextColor(i);
    }

    public final void m25530a(CharSequence charSequence, CharSequence charSequence2, GraphQLTextWithEntities graphQLTextWithEntities) {
        if (TextUtils.isEmpty(charSequence)) {
            this.f23084d.setVisibility(8);
        } else {
            this.f23084d.setText(charSequence);
            this.f23084d.setVisibility(0);
        }
        if (TextUtils.isEmpty(charSequence2)) {
            this.f23085e.setVisibility(8);
        } else {
            this.f23085e.setText(charSequence2);
            this.f23085e.setVisibility(0);
        }
        if (graphQLTextWithEntities == null || graphQLTextWithEntities.a().isEmpty()) {
            this.f23086f.setVisibility(8);
            return;
        }
        this.f23086f.m20238a(graphQLTextWithEntities, this.f23086f.getTextSize(), 1);
        this.f23086f.setVisibility(0);
    }

    public final void m25529a(GraphQLImage graphQLImage, boolean z, CallerContext callerContext) {
        this.f23081a = graphQLImage;
        this.f23090j = z;
        this.f23087g.a(graphQLImage == null ? null : ImageUtil.a(graphQLImage), callerContext);
        if (graphQLImage == null && m25526a()) {
            this.f23084d.setPadding(this.f23084d.getPaddingLeft(), getResources().getDimensionPixelSize(2131432745), this.f23084d.getPaddingRight(), this.f23084d.getPaddingBottom());
        }
        requestLayout();
    }

    public final void m25528a(GraphQLImage graphQLImage, CallerContext callerContext) {
        this.f23082b = graphQLImage;
        m25525a(graphQLImage, this.f23091k, callerContext, getResources().getDimensionPixelSize(2131432744));
    }

    public final void m25531b(GraphQLImage graphQLImage, CallerContext callerContext) {
        this.f23083c = graphQLImage;
        m25525a(graphQLImage, this.f23088h, callerContext, 0);
    }

    private void m25525a(GraphQLImage graphQLImage, FbDraweeView fbDraweeView, CallerContext callerContext, int i) {
        if (graphQLImage != null) {
            fbDraweeView.a(ImageUtil.a(graphQLImage), callerContext);
            LayoutParams layoutParams = fbDraweeView.getLayoutParams();
            layoutParams.height = graphQLImage.a() + i;
            layoutParams.width = graphQLImage.c();
            fbDraweeView.setVisibility(0);
            requestLayout();
            return;
        }
        fbDraweeView.setVisibility(8);
    }

    public void setOverlapMode(boolean z) {
        if (this.f23087g != null) {
            this.f23093m = z;
            setContentSummaryMargin(this.f23087g.getHeight());
        }
    }

    private void setAccentImageMargin(int i) {
        ((MarginLayoutParams) this.f23087g.getLayoutParams()).setMargins(0, i, 0, 0);
    }

    private void setContentSummaryMargin(int i) {
        int i2;
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f23084d.getLayoutParams();
        if (this.f23093m) {
            i2 = (-i) / 3;
        } else {
            i2 = 0;
        }
        marginLayoutParams.setMargins(0, i2, 0, 0);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (this.f23081a != null) {
            LayoutParams layoutParams = this.f23087g.getLayoutParams();
            int a = this.f23081a.a();
            if (!this.f23090j || this.f23081a.c() <= 0) {
                layoutParams.width = this.f23081a.c();
                layoutParams.height = this.f23081a.a();
                i3 = getResources().getDimensionPixelSize(2131432746);
            } else {
                double size = ((double) MeasureSpec.getSize(i)) / ((double) this.f23081a.c());
                layoutParams.width = -1;
                layoutParams.height = (int) (((double) this.f23081a.a()) * size);
                a = layoutParams.height;
                setPadding(0, getPaddingTop(), 0, getPaddingBottom());
                if (this.f23083c != null) {
                    layoutParams = this.f23088h.getLayoutParams();
                    layoutParams.width = (int) (((double) this.f23083c.c()) * size);
                    layoutParams.height = (int) (size * ((double) this.f23083c.a()));
                }
            }
            setContentSummaryMargin(a);
            setAccentImageMargin(i3);
        } else {
            LayoutParams layoutParams2 = this.f23087g.getLayoutParams();
            layoutParams2.width = 0;
            layoutParams2.height = 0;
            setContentSummaryMargin(0);
            setAccentImageMargin(0);
        }
        super.onMeasure(i, i2);
    }
}
