package com.facebook.widget.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import com.facebook.common.util.SizeUtil;

/* compiled from: com.facebook.katana */
public class FakeCursorHook implements BetterTextViewHook, Runnable {
    public final BetterTextView f5858a;
    private final Paint f5859b = new Paint();
    public boolean f5860c;
    public boolean f5861d;
    public int f5862e;
    public int f5863f;
    public int f5864g;

    public FakeCursorHook(BetterTextView betterTextView) {
        this.f5858a = betterTextView;
        this.f5859b.setColor(-16777216);
        this.f5864g = SizeUtil.a(betterTextView.getContext(), 2.0f);
        if (this.f5864g <= 0) {
            this.f5864g = 1;
        }
        this.f5859b.setStrokeWidth((float) this.f5864g);
    }

    public final boolean mo633a(MotionEvent motionEvent) {
        return false;
    }

    public final void mo632a(Canvas canvas) {
        if (this.f5860c) {
            int width;
            this.f5862e = this.f5858a.getHeight();
            if (this.f5858a.g) {
                width = (this.f5858a.getWidth() - this.f5864g) + 1;
            } else {
                width = 0;
            }
            this.f5863f = width;
            canvas.drawLine((float) this.f5863f, 20.0f, (float) this.f5863f, (float) (this.f5862e - 20), this.f5859b);
        }
    }

    public void run() {
        this.f5860c = !this.f5860c;
        this.f5858a.invalidate(this.f5863f, 20, (this.f5863f + this.f5864g) - 1, this.f5862e - 20);
        this.f5858a.postDelayed(this, 500);
    }
}
