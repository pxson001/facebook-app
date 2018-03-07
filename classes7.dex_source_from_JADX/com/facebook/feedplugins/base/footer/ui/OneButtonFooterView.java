package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.view.View;
import com.facebook.multirow.api.ViewType;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: Sync exception in cache on %s queue - %s */
public class OneButtonFooterView extends CustomLinearLayout {
    public static final ViewType f23030a = new C19891();
    public final FbTextView f23031b = ((FbTextView) a(2131559974));

    /* compiled from: Sync exception in cache on %s queue - %s */
    final class C19891 extends ViewType {
        C19891() {
        }

        public final View m25498a(Context context) {
            return new OneButtonFooterView(context);
        }
    }

    public OneButtonFooterView(Context context) {
        super(context);
        setContentView(2130905549);
        setOrientation(1);
    }

    public void setFooterText(CharSequence charSequence) {
        this.f23031b.setText(charSequence);
    }
}
