package com.facebook.widget.listview;

/* compiled from: messenger_rain_hearts */
public abstract class HidingScrollListener implements ScrollListenerWithThrottlingSupport {
    private ScrollingViewProxy f13809a;
    public boolean f13810b = true;
    private ListScrollStateSnapshot f13811c = new ListScrollStateSnapshot();
    private ListScrollStateSnapshot f13812d = new ListScrollStateSnapshot();
    private int f13813e;
    private int f13814f;
    private int f13815g;

    public abstract void aY_();

    public abstract void mo2675b();

    public HidingScrollListener(ScrollingViewProxy scrollingViewProxy, boolean z) {
        this.f13809a = scrollingViewProxy;
        this.f13810b = z;
        this.f13809a.mo2354a(this.f13811c);
        this.f13809a.mo2354a(this.f13812d);
    }

    public final void mo1262a(ScrollingViewProxy scrollingViewProxy, int i) {
        this.f13813e = i;
    }

    public final void mo1263a(ScrollingViewProxy scrollingViewProxy, int i, int i2, int i3) {
        this.f13809a.mo2354a(this.f13811c);
        if (this.f13813e != 0) {
            int i4 = this.f13811c.f13816a - this.f13812d.f13816a;
            int i5 = this.f13811c.f13818c;
            if (this.f13811c.f13816a == 0 && i5 < 0) {
                i5 = 0;
            } else if (this.f13811c.f13819d == this.f13809a.mo2404s() - 1 && this.f13811c.f13820e < this.f13809a.mo2381e()) {
                i5 = this.f13811c.f13818c + (this.f13811c.f13820e - this.f13809a.mo2381e());
            }
            if (Math.abs(i4) < 2) {
                int i6 = this.f13812d.f13818c - i5;
                if (i4 == 1) {
                    i4 = i6 - this.f13812d.f13817b;
                } else if (i4 == -1) {
                    i4 = i6 + this.f13811c.f13817b;
                } else {
                    i4 = i6;
                }
                if (i4 < 0) {
                    this.f13814f += i4;
                    i6 = this.f13814f;
                    this.f13815g = 0;
                } else if (i4 > 0) {
                    this.f13814f = 0;
                    this.f13815g += i4;
                    i6 = this.f13815g;
                } else {
                    i6 = 0;
                }
                if (Math.abs(i6) > 100) {
                    if (i4 < 0 && this.f13810b) {
                        this.f13810b = false;
                        aY_();
                    } else if (i4 > 0 && !this.f13810b) {
                        this.f13810b = true;
                        mo2675b();
                    }
                }
            }
            this.f13812d.m20223a(this.f13811c.f13816a, this.f13811c.f13817b, i5, this.f13811c.f13819d, this.f13811c.f13820e);
        }
    }
}
