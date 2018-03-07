package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: gravity_gps_foreground_check_failed */
public class DailyDialogueBrandedBannerView extends CustomFrameLayout implements CanShowHeaderOptionsMenu {
    public final FbDraweeView f12166a = ((FbDraweeView) c(2131560864));
    public final GlyphView f12167b = ((GlyphView) c(2131560877));
    public final FbDraweeView f12168c = ((FbDraweeView) c(2131560865));
    public boolean f12169d;
    public GraphQLImage f12170e;

    public DailyDialogueBrandedBannerView(Context context) {
        super(context);
        setContentView(2130903837);
    }

    public void setMenuButtonActive(boolean z) {
        this.f12167b.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f12167b.getVisibility() == 0;
    }

    public final void m14165a(Tooltip tooltip) {
        tooltip.f(this.f12167b);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f12170e != null) {
            LayoutParams layoutParams = this.f12166a.getLayoutParams();
            if (!this.f12169d || this.f12170e.c() <= 0) {
                layoutParams.width = this.f12170e.c();
                layoutParams.height = this.f12170e.a();
            } else {
                int size = MeasureSpec.getSize(i);
                layoutParams.width = -1;
                layoutParams.height = (size * this.f12170e.a()) / this.f12170e.c();
                setPadding(0, getPaddingTop(), 0, getPaddingBottom());
            }
        }
        super.onMeasure(i, i2);
    }
}
