package com.facebook.messaging.montage.composer;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.facebook.base.fragment.FbFragment;
import javax.annotation.Nullable;

/* compiled from: is_web_share */
public abstract class AbstractMontageCanvasFragment extends FbFragment implements MontageComposerCanvas {
    public Rect f12436a;

    protected abstract void mo475a(View view, int i, int i2, int i3, int i4);

    AbstractMontageCanvasFragment() {
    }

    public void mo476a(final View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.f12436a != null) {
            view.post(new Runnable(this) {
                final /* synthetic */ AbstractMontageCanvasFragment f12435b;

                public void run() {
                    this.f12435b.mo475a(view, this.f12435b.f12436a.left, this.f12435b.f12436a.top, this.f12435b.f12436a.right, this.f12435b.f12436a.bottom);
                    this.f12435b.f12436a = null;
                }
            });
        }
    }

    public final void mo474a(int i, int i2, int i3, int i4) {
        View view = this.T;
        if (view == null) {
            this.f12436a = new Rect(i, i2, i3, i4);
            return;
        }
        this.f12436a = null;
        mo475a(view, i, i2, i3, i4);
    }
}
