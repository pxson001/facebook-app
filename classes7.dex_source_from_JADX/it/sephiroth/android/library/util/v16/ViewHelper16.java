package it.sephiroth.android.library.util.v16;

import android.annotation.TargetApi;
import android.view.View;
import it.sephiroth.android.library.util.v14.ViewHelper14;

/* compiled from: viewer_claims */
public class ViewHelper16 extends ViewHelper14 {
    public ViewHelper16(View view) {
        super(view);
    }

    @TargetApi(16)
    public final void mo4a(Runnable runnable) {
        this.f368a.postOnAnimation(runnable);
    }
}
