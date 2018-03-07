package com.facebook.feed.rows.sections.header.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.feed.rows.sections.header.ui.CanShowHeaderTitle.Sponsored;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: is_draft */
public class TextWithMenuButtonView extends CustomLinearLayout implements CanShowHeaderOptionsMenu, CanShowHeaderTitle, StyleableTextHeader {
    public static final ViewType f19211b = new C07631();
    private final ContentTextView f19212a;
    public final ImageView f19213c;
    private final int f19214d;

    /* compiled from: is_draft */
    final class C07631 extends ViewType {
        C07631() {
        }

        public final View mo1995a(Context context) {
            return new TextWithMenuButtonView(context);
        }
    }

    public TextWithMenuButtonView(Context context) {
        this(context, 2130907381);
    }

    public TextWithMenuButtonView(Context context, int i) {
        super(context);
        setContentView(i);
        this.f19212a = (ContentTextView) m8506a(2131562876);
        this.f19213c = (ImageView) m8506a(2131560877);
        this.f19214d = getResources().getDimensionPixelSize(2131427602);
    }

    public void setMenuButtonActive(boolean z) {
        int i = 0;
        this.f19213c.setVisibility(z ? 0 : 8);
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f19212a.getLayoutParams();
        if (!z) {
            i = this.f19214d;
        }
        marginLayoutParams.rightMargin = i;
        this.f19212a.setLayoutParams(marginLayoutParams);
    }

    public final boolean hk_() {
        return this.f19213c.getVisibility() == 0;
    }

    public final void m26918a(CharSequence charSequence, Sponsored sponsored) {
        this.f19212a.setText(charSequence);
        this.f19212a.setTag(2131558541, Boolean.valueOf(sponsored == Sponsored.SPONSORED));
    }

    public final void mo3090a(Tooltip tooltip) {
        tooltip.f(this.f19213c);
    }

    public void setStyle(TextHeaderStyle textHeaderStyle) {
        this.f19212a.setTextColor(textHeaderStyle.getColor(getResources()));
        this.f19212a.setTypeface(null, textHeaderStyle.getFontStyle());
        this.f19212a.setTextSize((float) textHeaderStyle.getFontSize(getResources()));
    }
}
