package com.facebook.video.creativeediting.trimmer;

import android.view.View;
import com.facebook.video.creativeediting.ui.fresco.ZoomableDraweeStripView;

/* compiled from: dropVideoBuffer */
public class StripHandleController {
    private final int f15537a;
    private final int f15538b;
    public ZoomableDraweeStripView f15539c;
    public View f15540d;
    public View f15541e;
    public View f15542f;
    public View f15543g;
    public View f15544h;

    /* compiled from: dropVideoBuffer */
    public enum HandlePosition {
        LEFT,
        RIGHT
    }

    public StripHandleController(int i, int i2) {
        this.f15537a = i;
        this.f15538b = i2;
    }

    public final void m19556a(int i, boolean z) {
        this.f15540d.offsetLeftAndRight(i - m19553a());
        this.f15542f.setRight(this.f15540d.getLeft() + (this.f15540d.getWidth() / 2));
        this.f15544h.setLeft(this.f15540d.getLeft() + this.f15537a);
        if (z) {
            this.f15542f.setLeft(this.f15539c.getZoomedInLeftOffset());
        } else {
            this.f15542f.setLeft(this.f15538b);
        }
    }

    public final void m19559b(int i, boolean z) {
        this.f15541e.offsetLeftAndRight(i - m19557b());
        this.f15543g.setLeft(this.f15541e.getRight() - (this.f15541e.getWidth() / 2));
        this.f15544h.setRight(this.f15541e.getRight() - this.f15537a);
        if (z) {
            this.f15543g.setRight(this.f15539c.getZoomedInWidth());
        } else {
            this.f15543g.setRight(this.f15539c.getZoomedOutWidth() - this.f15538b);
        }
    }

    public final void m19555a(int i) {
        m19556a(m19553a() + i, true);
    }

    public final void m19558b(int i) {
        m19559b(m19557b() + i, true);
    }

    public final int m19553a() {
        return this.f15540d.getRight() - this.f15537a;
    }

    public final int m19557b() {
        return this.f15541e.getLeft() + this.f15537a;
    }

    public final int m19554a(HandlePosition handlePosition) {
        if (handlePosition == HandlePosition.LEFT) {
            return m19553a();
        }
        return m19557b();
    }
}
