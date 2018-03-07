package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: graph_search */
public class GoodwillIconWithMenuHeaderView extends CustomRelativeLayout implements CanShowHeaderOptionsMenu {
    public static final ViewType f12309a = new C13041();
    private final FbDraweeView f12310b = ((FbDraweeView) a(2131562224));
    public final ImageView f12311c = ((ImageView) a(2131560877));

    /* compiled from: graph_search */
    final class C13041 extends ViewType {
        C13041() {
        }

        public final View m14261a(Context context) {
            return new GoodwillIconWithMenuHeaderView(context);
        }
    }

    public GoodwillIconWithMenuHeaderView(Context context) {
        super(context);
        setContentView(2130904618);
        LayoutParams layoutParams = (LayoutParams) this.f12311c.getLayoutParams();
        layoutParams.addRule(10);
        layoutParams.addRule(11);
    }

    public void setMenuButtonActive(boolean z) {
        this.f12311c.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f12311c.getVisibility() == 0;
    }

    public final void m14262a(Tooltip tooltip) {
        tooltip.f(this.f12311c);
    }
}
