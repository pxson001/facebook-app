package com.facebook.feedplugins.profile.ui;

import android.content.Context;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: SMS_SYNTHETIC */
public class CenteredButtonView extends CustomFrameLayout {
    public static final ViewType<CenteredButtonView> f23760a = new C20501();
    public BetterTextView f23761b = ((BetterTextView) c(2131560272));

    /* compiled from: SMS_SYNTHETIC */
    final class C20501 extends ViewType<CenteredButtonView> {
        C20501() {
        }

        public final View m25914a(Context context) {
            return new CenteredButtonView(context);
        }
    }

    public CenteredButtonView(Context context) {
        super(context);
        setContentView(2130903530);
    }
}
