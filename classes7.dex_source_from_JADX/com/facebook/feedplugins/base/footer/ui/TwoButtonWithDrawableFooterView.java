package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: Sync */
public class TwoButtonWithDrawableFooterView extends CustomLinearLayout {
    public static final ViewType f23040a = new C19921();
    private final FbRelativeLayout f23041b = ((FbRelativeLayout) a(2131568143));
    private final FbTextView f23042c = ((FbTextView) a(2131568145));
    private final FbRelativeLayout f23043d = ((FbRelativeLayout) a(2131568144));
    private final FbTextView f23044e = ((FbTextView) a(2131568146));

    /* compiled from: Sync */
    final class C19921 extends ViewType {
        C19921() {
        }

        public final View m25506a(Context context) {
            return new TwoButtonWithDrawableFooterView(context);
        }
    }

    /* compiled from: Sync */
    public enum Button {
        LEFT,
        RIGHT
    }

    public TwoButtonWithDrawableFooterView(Context context) {
        super(context);
        setContentView(2130907570);
        setOrientation(1);
    }

    private FbTextView m25507a(Button button) {
        switch (button) {
            case LEFT:
                return this.f23042c;
            case RIGHT:
                return this.f23044e;
            default:
                throw new IllegalArgumentException("Invalid button location");
        }
    }

    public final void m25509a(Button button, Drawable drawable) {
        m25507a(button).setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
    }

    public final void m25511b(Button button, Drawable drawable) {
        m25507a(button).setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    public final void m25510a(Button button, CharSequence charSequence) {
        m25507a(button).setText(charSequence);
    }

    public final void m25508a(Button button, int i) {
        m25507a(button).setTextColor(getResources().getColor(i));
    }
}
