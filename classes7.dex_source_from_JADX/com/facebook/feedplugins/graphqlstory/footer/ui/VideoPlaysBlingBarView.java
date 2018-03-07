package com.facebook.feedplugins.graphqlstory.footer.ui;

import android.content.Context;
import android.widget.TextView;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;

/* compiled from: SetLayoutParams */
public class VideoPlaysBlingBarView extends DefaultBlingBarView {
    private final TextView f23327b = ((TextView) c(2131562037));

    public VideoPlaysBlingBarView(Context context) {
        super(context, 2130907696);
    }

    public void setPlayCountText(int i) {
        if (i == 0) {
            this.f23327b.setVisibility(8);
            return;
        }
        boolean z = i > 0 || m25441a();
        setIsExpanded(z);
        this.f23327b.setVisibility(0);
        this.f23327b.setText(getResources().getQuantityString(2131689538, i, new Object[]{Integer.valueOf(i)}));
    }
}
