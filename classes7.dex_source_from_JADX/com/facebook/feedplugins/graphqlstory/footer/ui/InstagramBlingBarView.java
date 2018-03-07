package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.content.Context;
import android.widget.TextView;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;

/* compiled from: Setting native modules queue spec multiple times! */
public class InstagramBlingBarView extends DefaultBlingBarView {
    public final TextView f23325b = ((TextView) c(2131562039));

    public InstagramBlingBarView(Context context) {
        super(context, 2130904580);
    }

    public void setLinkText(int i) {
        this.f23325b.setText(i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f23325b.getRight() > getRight() - getPaddingRight()) {
            i5 = 1;
        } else {
            i5 = 0;
        }
        TextView textView = this.f23325b;
        if (i5 != 0) {
            i6 = 4;
        }
        textView.setVisibility(i6);
    }
}
