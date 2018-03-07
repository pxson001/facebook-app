package com.facebook.feedplugins.graphqlstory.tombstoneview;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: ScaleAspectFill */
public class TombstoneView extends CustomFrameLayout {
    public TextView f23379a = ((TextView) c(2131568055));

    public TombstoneView(Context context) {
        super(context);
        setContentView(2130907517);
        this.f23379a.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setContentVisibility(int i) {
        this.f23379a.setVisibility(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f23379a.setText(charSequence);
    }
}
