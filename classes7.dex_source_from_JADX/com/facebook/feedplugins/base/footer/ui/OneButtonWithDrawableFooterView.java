package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.widget.ImageView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: Sync connection events (i.e. get_diffs) */
public class OneButtonWithDrawableFooterView extends CustomLinearLayout {
    public final FbTextView f23032a = ((FbTextView) a(2131559974));
    public final ImageView f23033b = ((ImageView) a(2131564408));
    public final ImageView f23034c = ((ImageView) a(2131564407));

    public OneButtonWithDrawableFooterView(Context context) {
        super(context);
        setContentView(2130905550);
        setOrientation(1);
    }

    public void setFooterText(int i) {
        this.f23032a.setText(i);
    }

    public void setFooterText(CharSequence charSequence) {
        this.f23032a.setText(charSequence);
    }
}
