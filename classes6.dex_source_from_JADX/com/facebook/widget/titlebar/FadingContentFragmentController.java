package com.facebook.widget.titlebar;

import android.view.View;
import com.facebook.widget.listview.ScrollListenerHolder;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.facebook.widget.listview.ScrollingViewProxy.OnScrollListener;

/* compiled from: reacted */
public class FadingContentFragmentController {
    public FadingContentViewProvider f6233a;
    public FadingFbTitleBar f6234b;
    private FadingTitlebarContent f6235c;
    public boolean f6236d = true;
    private boolean f6237e = true;
    public boolean f6238f = false;

    /* compiled from: reacted */
    class C03751 implements OnScrollListener {
        final /* synthetic */ FadingContentFragmentController f6232a;

        C03751(FadingContentFragmentController fadingContentFragmentController) {
            this.f6232a = fadingContentFragmentController;
        }

        public final void m8778a(ScrollingViewProxy scrollingViewProxy, int i) {
        }

        public final void m8779a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
            boolean z = true;
            if (!this.f6232a.f6236d) {
                return;
            }
            if (this.f6232a.f6233a.mk_()) {
                FadingContentFragmentController fadingContentFragmentController = this.f6232a;
                View fadingView = fadingContentFragmentController.f6233a.m8784j().getFadingView();
                float ml_ = (float) fadingContentFragmentController.f6233a.ml_();
                if (fadingView.getVisibility() != 0) {
                    fadingView.setVisibility(0);
                }
                int height = fadingView.getHeight() - fadingContentFragmentController.f6234b.getHeight();
                float f = 1.0f;
                if (Math.abs(ml_) < ((float) height)) {
                    f = Math.abs(ml_) / ((float) height);
                }
                float f2 = f;
                FadingContentFragmentController fadingContentFragmentController2 = this.f6232a;
                if (f2 != 1.0f) {
                    z = false;
                }
                fadingContentFragmentController2.f6238f = z;
                FadingContentView j = this.f6232a.f6233a.m8784j();
                j.getFadingView().setAlpha(f2);
                this.f6232a.f6234b.m8786a(f2);
                j.m8782a(f2);
            } else if (!this.f6232a.f6238f) {
                this.f6232a.f6238f = true;
                this.f6232a.f6234b.m8786a(1.0f);
            }
        }
    }

    public final void m8781a(FadingContentViewProvider fadingContentViewProvider, FadingFbTitleBar fadingFbTitleBar, ScrollListenerHolder scrollListenerHolder, FadingTitlebarContent fadingTitlebarContent, boolean z, boolean z2) {
        this.f6233a = fadingContentViewProvider;
        this.f6234b = fadingFbTitleBar;
        this.f6235c = fadingTitlebarContent;
        this.f6237e = z2;
        this.f6236d = z;
        this.f6235c.e_(this.f6236d);
        this.f6235c.m8788b(this.f6237e);
        this.f6234b.setFadingModeEnabled(this.f6236d);
        scrollListenerHolder.b(new C03751(this));
    }

    public final void m8780a() {
        if (this.f6233a.m8784j() != null) {
            this.f6236d = this.f6233a.m8784j().m8783a();
        } else {
            this.f6236d = false;
        }
        this.f6235c.e_(this.f6236d);
        this.f6235c.m8788b(this.f6237e);
        this.f6234b.setFadingModeEnabled(this.f6236d);
        this.f6234b.m8786a(this.f6236d ? 0.0f : 1.0f);
    }
}
