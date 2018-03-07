package com.facebook.photos.photoset.ui;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

/* compiled from: code_entry_viewed */
public abstract class SmoothedScrollAdapter implements OnScrollListener {
    protected final int f17802a;
    public int f17803b;
    public int f17804c;
    public int f17805d;
    private long f17806e;
    private int f17807f;
    public boolean f17808g;
    private boolean f17809h;
    private final Handler f17810i;

    /* compiled from: code_entry_viewed */
    class C19081 extends Handler {
        final /* synthetic */ SmoothedScrollAdapter f17801a;

        C19081(SmoothedScrollAdapter smoothedScrollAdapter) {
            this.f17801a = smoothedScrollAdapter;
        }

        public void handleMessage(Message message) {
            this.f17801a.f17808g = false;
            this.f17801a.mo1062a(this.f17801a.f17803b, this.f17801a.f17804c, this.f17801a.f17805d);
        }
    }

    protected abstract void mo1062a(int i, int i2, int i3);

    public SmoothedScrollAdapter() {
        this(200);
    }

    private SmoothedScrollAdapter(int i) {
        this.f17803b = -1;
        this.f17804c = -1;
        this.f17805d = -1;
        this.f17808g = false;
        this.f17809h = false;
        this.f17810i = new C19081(this);
        this.f17802a = i;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.f17803b = i;
        this.f17804c = i2;
        this.f17805d = i3;
        if (!this.f17809h) {
            mo1062a(this.f17803b, this.f17804c, this.f17805d);
        } else if (this.f17802a > 0 && this.f17807f != 2) {
            if (SystemClock.uptimeMillis() - this.f17806e > ((long) this.f17802a)) {
                mo1062a(this.f17803b, this.f17804c, this.f17805d);
            } else if (!this.f17808g) {
                this.f17808g = true;
                this.f17810i.sendMessageDelayed(Message.obtain(), (long) this.f17802a);
            }
        }
        this.f17806e = SystemClock.uptimeMillis();
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (!this.f17809h) {
            this.f17809h = true;
        }
        this.f17807f = i;
        if (i == 0) {
            mo1062a(this.f17803b, this.f17804c, this.f17805d);
        }
    }
}
