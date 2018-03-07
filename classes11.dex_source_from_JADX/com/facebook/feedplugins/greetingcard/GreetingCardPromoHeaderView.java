package com.facebook.feedplugins.greetingcard;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderOptionsMenu;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: decimalSeparator */
public class GreetingCardPromoHeaderView extends CustomRelativeLayout implements CanShowHeaderOptionsMenu {
    public final ImageView f7737a = ((ImageView) a(2131562614));
    public final ContentTextView f7738b = ((ContentTextView) a(2131562615));
    public final BetterTextView f7739c = ((BetterTextView) a(2131562616));
    public final BetterTextView f7740d = ((BetterTextView) a(2131562617));

    public GreetingCardPromoHeaderView(Context context) {
        super(context);
        setContentView(2130904635);
    }

    public void setMenuButtonActive(boolean z) {
        this.f7737a.setVisibility(z ? 0 : 8);
    }

    public final boolean hk_() {
        return this.f7737a.getVisibility() == 0;
    }

    public final void m8919a(Tooltip tooltip) {
        tooltip.f(this.f7737a);
    }
}
