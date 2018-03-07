package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: goodwill_throwback_promotion_ufi */
public class ThrowbackFeedUnitHeaderView extends CustomRelativeLayout implements CanShowHeaderOptionsMenu {
    public static final ViewType f12383a = new C13071();
    private final int f12384b;
    private final int f12385c;
    private final int f12386d;
    private final TextView f12387e = ((TextView) a(2131562593));
    private final TextView f12388f = ((TextView) a(2131567870));
    private final TextView f12389g = ((TextView) a(2131567871));
    private final FbDraweeView f12390h = ((FbDraweeView) a(2131560864));
    public final ImageView f12391i = ((ImageView) a(2131560877));

    /* compiled from: goodwill_throwback_promotion_ufi */
    final class C13071 extends ViewType {
        C13071() {
        }

        public final View m14311a(Context context) {
            return new ThrowbackFeedUnitHeaderView(context);
        }
    }

    public ThrowbackFeedUnitHeaderView(Context context) {
        super(context);
        setContentView(2130907405);
        Resources resources = context.getResources();
        this.f12384b = SizeUtil.c(resources, 2131427404);
        this.f12385c = SizeUtil.c(resources, 2131427402);
        this.f12386d = SizeUtil.c(resources, 2131427400);
    }

    public void setHeader(String str) {
        this.f12387e.setText(str);
        if (str == null) {
            this.f12387e.setVisibility(8);
            this.f12388f.setTextColor(getResources().getColor(2131361972));
        } else {
            this.f12387e.setVisibility(0);
            this.f12388f.setTextColor(getResources().getColor(2131361973));
        }
        this.f12387e.setTextSize((float) this.f12384b);
    }

    public void setTitle(String str) {
        this.f12388f.setText(str);
        this.f12388f.setTextSize((float) this.f12385c);
    }

    public void setCallToAction(CharSequence charSequence) {
        this.f12389g.setText(charSequence);
        this.f12389g.setTextSize((float) this.f12386d);
    }

    public void setMenuButtonActive(boolean z) {
        this.f12391i.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f12391i.getVisibility() == 0;
    }

    public final void m14312a(Tooltip tooltip) {
        tooltip.f(this.f12391i);
    }
}
