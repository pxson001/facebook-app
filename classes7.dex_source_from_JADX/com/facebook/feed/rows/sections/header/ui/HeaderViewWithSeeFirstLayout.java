package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feedplugins.graphqlstory.header.CanShowSeeFirstIndicator;
import com.facebook.multirow.api.ViewType;
import javax.annotation.Nullable;

/* compiled from: Under Subtitle */
public class HeaderViewWithSeeFirstLayout extends HeaderViewWithTextLayout implements CanShowSeeFirstIndicator {
    public static final ViewType f21416j = new C18021();
    private final ImageView f21417l;
    private final ImageView f21418m;

    /* compiled from: Under Subtitle */
    final class C18021 extends ViewType {
        C18021() {
        }

        public final View m24130a(Context context) {
            return new HeaderViewWithSeeFirstLayout(context);
        }
    }

    public HeaderViewWithSeeFirstLayout(Context context) {
        this(context, null);
    }

    private HeaderViewWithSeeFirstLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 2130904766);
        this.f21417l = (ImageView) getView(2131560877);
        this.f21418m = (ImageView) getView(2131562875);
    }

    public final void a_(Tooltip tooltip) {
        tooltip.f(this.f21418m);
    }
}
