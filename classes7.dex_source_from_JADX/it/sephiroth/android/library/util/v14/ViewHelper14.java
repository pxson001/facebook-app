package it.sephiroth.android.library.util.v14;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.util.ViewHelperFactory.ViewHelperDefault;

/* compiled from: viewer_group_marketplace_cross_post_intercept_seen */
public class ViewHelper14 extends ViewHelperDefault {
    public ViewHelper14(View view) {
        super(view);
    }

    @TargetApi(14)
    public final void mo3a(int i) {
        this.f368a.setScrollX(i);
    }

    @TargetApi(11)
    public final boolean mo5a() {
        return this.f368a.isHardwareAccelerated();
    }
}
