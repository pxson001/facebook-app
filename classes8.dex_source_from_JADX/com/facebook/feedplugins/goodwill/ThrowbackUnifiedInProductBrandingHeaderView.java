package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: gms_upsell_result_succeeded */
public class ThrowbackUnifiedInProductBrandingHeaderView extends CustomRelativeLayout implements CanShowHeaderOptionsMenu {
    public GraphQLImage f12570a;
    public final TextView f12571b = ((TextView) a(2131561593));
    public final TextView f12572c = ((TextView) a(2131559769));
    public final FbDraweeView f12573d = ((FbDraweeView) a(2131560864));
    public final FbDraweeView f12574e = ((FbDraweeView) a(2131560271));
    public final FbDraweeView f12575f = ((FbDraweeView) a(2131562601));
    public GraphQLImage f12576g;
    public final GlyphView f12577h = ((GlyphView) a(2131560877));
    public final FbDraweeView f12578i = ((FbDraweeView) a(2131560865));
    public boolean f12579j;

    public ThrowbackUnifiedInProductBrandingHeaderView(Context context) {
        super(context);
        setContentView(2130904621);
    }

    public void setMenuButtonActive(boolean z) {
        this.f12577h.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f12577h.getVisibility() == 0;
    }

    public final void m14440a(Tooltip tooltip) {
        tooltip.f(this.f12577h);
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        if (this.f12570a != null && this.f12570a.c() > 0) {
            LayoutParams layoutParams = this.f12573d.getLayoutParams();
            double c = ((double) size) / ((double) this.f12570a.c());
            layoutParams.width = -1;
            layoutParams.height = (int) (c * ((double) this.f12570a.a()));
            setPadding(0, getPaddingTop(), 0, getPaddingBottom());
            if (this.f12576g != null) {
                float f = (this.f12579j ? 0.37777779f : 0.42857143f) * ((float) size);
                LayoutParams layoutParams2 = this.f12574e.getLayoutParams();
                layoutParams2.width = (int) f;
                layoutParams2.height = (int) f;
                if (this.f12579j) {
                    layoutParams2 = this.f12575f.getLayoutParams();
                    layoutParams2.width = (int) f;
                    layoutParams2.height = (int) f;
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f12571b.getLayoutParams();
                layoutParams3.addRule(3, 2131560271);
                this.f12571b.setLayoutParams(layoutParams3);
            }
        }
        this.f12572c.getLayoutParams().width = (int) (((double) size) * 0.8d);
        this.f12571b.getLayoutParams().width = (int) (((double) size) * 0.8d);
        super.onMeasure(i, i2);
    }
}
