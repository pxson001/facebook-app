package com.facebook.instantshopping.view.widget.media;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.widget.RichDocumentImageView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.richdocument.view.widget.media.plugins.BaseMediaFramePlugin;

/* compiled from: SERVER_ERROR */
public class TiltToPanPlugin extends BaseMediaFramePlugin<Void> {
    public MediaFrame f23945a;
    public RichDocumentImageView f23946b;
    public TiltToPanDraweeView f23947c;
    private final Display f23948d;
    public final Point f23949e;
    public boolean f23950f = false;

    /* compiled from: SERVER_ERROR */
    public class C34321 implements AnimatorListener {
        final /* synthetic */ TiltToPanPlugin f23944a;

        public C34321(TiltToPanPlugin tiltToPanPlugin) {
            this.f23944a = tiltToPanPlugin;
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            this.f23944a.f23950f = true;
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationRepeat(Animator animator) {
        }
    }

    public TiltToPanPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        this.f23945a = mediaFrame;
        this.f23946b = (RichDocumentImageView) this.f23945a.b().findViewById(2131563004);
        this.f23947c = (TiltToPanDraweeView) this.f23945a.b().findViewById(2131563257);
        this.f23948d = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        this.f23949e = new Point();
        this.f23948d.getSize(this.f23949e);
    }

    public final void m25218a() {
        if (this.f23947c != null) {
            Object obj;
            if (this.f23946b.getMediaAspectRatio() > ((float) this.f23949e.x) / ((float) this.f23949e.y)) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null && !this.f23950f) {
                this.f23947c.m25217b(Uri.parse("https://lookaside.facebook.com/assets/519288584920644/"), CallerContext.a(getClass()));
                if (this.f23947c != null) {
                    this.f23947c.setAlpha(1.0f);
                    this.f23947c.setVisibility(0);
                    this.f23947c.animate().alpha(0.0f).setDuration(3000);
                    this.f23947c.animate().setListener(new C34321(this));
                }
                this.f23947c.setVisibility(0);
            }
        }
    }

    public final void m25220k() {
        if (this.f23947c != null) {
            this.f23947c.setVisibility(8);
            this.f23950f = false;
        }
    }

    public final void m25219a(ViewLayout viewLayout) {
        if (this.f23947c != null) {
            this.f23945a.a(this.f23947c, new Rect((this.f23949e.x - this.f23947c.getMeasuredWidth()) / 2, (this.f23949e.y - this.f23947c.getMeasuredHeight()) / 2, (this.f23949e.x + this.f23947c.getMeasuredWidth()) / 2, (this.f23949e.y + this.f23947c.getMeasuredHeight()) / 2));
        }
    }
}
