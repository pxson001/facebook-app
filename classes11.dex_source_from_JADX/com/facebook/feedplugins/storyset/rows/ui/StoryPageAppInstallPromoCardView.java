package com.facebook.feedplugins.storyset.rows.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;

/* compiled from: app_section/{%s}/{%s} */
public class StoryPageAppInstallPromoCardView extends PagerItemWrapperLayout implements RecyclableView {
    private boolean f9846a;
    public final FbTextView f9847b = ((FbTextView) c(2131567711));
    public final FbTextView f9848c = ((FbTextView) c(2131567712));
    public final FbTextView f9849d = ((FbTextView) c(2131567714));
    public final ImageView f9850e = ((ImageView) c(2131567710));
    public final LinearLayout f9851f = ((LinearLayout) c(2131562633));

    public StoryPageAppInstallPromoCardView(Context context) {
        super(context);
        setContentView(2130907262);
    }

    public void setHasBeenAttached(boolean z) {
        this.f9846a = z;
    }

    public final boolean m10252a() {
        return this.f9846a;
    }
}
