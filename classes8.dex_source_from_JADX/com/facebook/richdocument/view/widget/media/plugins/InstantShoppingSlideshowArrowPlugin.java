package com.facebook.richdocument.view.widget.media.plugins;

import android.support.v7.widget.LinearLayoutManager;
import com.facebook.richdocument.view.widget.media.MediaFrame;

/* compiled from: num_connected_friends */
public class InstantShoppingSlideshowArrowPlugin extends SlideshowArrowPlugin {
    public InstantShoppingSlideshowArrowPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
    }

    protected final void mo511a(int i) {
        int l = ((LinearLayoutManager) this.f7641b.getLayoutManager()).l();
        int n = ((LinearLayoutManager) this.f7641b.getLayoutManager()).n();
        int D = this.f7641b.getLayoutManager().D();
        if (i >= 0 && l < D - 1) {
            m7921b(this.f7641b.getChildAt(0).getLeft() * -1);
        } else if (i >= 0 || n >= D - 1) {
            m7918a();
        } else {
            m7921b(this.f7641b.getChildAt(this.f7641b.getLayoutManager().v() - 1).getLeft());
        }
    }
}
