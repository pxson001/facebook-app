package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feedplugins.graphqlstory.header.CanShowSeeFirstIndicator;
import com.facebook.multirow.api.ViewType;

/* compiled from: Unable to serialize JavaScript module declaration */
public class TextWithSeeFirstAndMenuButtonView extends TextWithMenuButtonView implements CanShowSeeFirstIndicator {
    public static final ViewType f21425a = new C18051();
    private final ImageView f21426c = ((ImageView) a(2131560877));
    private final ImageView f21427d = ((ImageView) a(2131562875));

    /* compiled from: Unable to serialize JavaScript module declaration */
    final class C18051 extends ViewType {
        C18051() {
        }

        public final View m24135a(Context context) {
            return new TextWithSeeFirstAndMenuButtonView(context);
        }
    }

    public TextWithSeeFirstAndMenuButtonView(Context context) {
        super(context, 2130907382);
    }

    public void setMenuButtonActive(boolean z) {
        this.f21426c.setVisibility(z ? 0 : 8);
    }

    public final void a_(Tooltip tooltip) {
        tooltip.f(this.f21427d);
    }
}
