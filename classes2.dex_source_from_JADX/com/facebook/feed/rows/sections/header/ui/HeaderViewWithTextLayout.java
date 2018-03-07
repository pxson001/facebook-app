package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: group_immersive */
public class HeaderViewWithTextLayout extends BaseHeaderViewWithTextLayout implements CanShowHeaderOptionsMenu {
    public static final ViewType f21710k = new C08661();
    private final ImageView f21711j;

    /* compiled from: group_immersive */
    final class C08661 extends ViewType {
        C08661() {
        }

        public final View mo1995a(Context context) {
            return new HeaderViewWithTextLayout(context);
        }
    }

    public HeaderViewWithTextLayout(Context context) {
        this(context, null, 2130904770);
    }

    public HeaderViewWithTextLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 2130904770);
    }

    public HeaderViewWithTextLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21711j = (ImageView) getView(2131560877);
    }

    public void setMenuButtonActive(boolean z) {
        this.f21711j.setVisibility(z ? 0 : 8);
    }

    private boolean m29420a() {
        return this.f21711j.getVisibility() == 0;
    }

    public final boolean hk_() {
        return m29420a();
    }

    public final void mo3090a(Tooltip tooltip) {
        tooltip.f(this.f21711j);
    }
}
