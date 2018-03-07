package com.facebook.messaging.bball;

import com.facebook.messaging.bball.BballView.C09212;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: openDiscoverTab() not supported yet */
public class BballScene {
    public final ChoreographerWrapper f8171a;
    public final Set<Listener> f8172b = new HashSet();
    public float f8173c;
    public float f8174d;
    private float f8175e;
    public float f8176f;
    public float f8177g;
    public float f8178h;
    public float f8179i;
    public float f8180j;
    public float f8181k;
    public float f8182l;
    public float f8183m = -1.1f;
    public float f8184n = 0.15f;
    private boolean f8185o;
    private double f8186p;
    private float f8187q;
    private boolean f8188r;
    public boolean f8189s;
    public C09212 f8190t;
    public final FrameCallbackWrapper f8191u = new C09191(this);

    /* compiled from: openDiscoverTab() not supported yet */
    public interface Listener {
        void mo301a();

        void mo302b();

        void mo303c();

        void mo304d();

        void mo305e();

        void mo306f();
    }

    /* compiled from: openDiscoverTab() not supported yet */
    class C09191 extends FrameCallbackWrapper {
        final /* synthetic */ BballScene f8170a;

        C09191(BballScene bballScene) {
            this.f8170a = bballScene;
        }

        public final void m8412a(long j) {
            BballScene.m8413a(this.f8170a, j);
        }
    }

    @Inject
    public BballScene(ChoreographerWrapper choreographerWrapper) {
        this.f8171a = choreographerWrapper;
    }

    public final void m8424a(Listener listener) {
        this.f8172b.add(listener);
    }

    public final void m8422a(float f) {
        this.f8180j = ((float) (this.f8180j < 0.0f ? -1 : 1)) * f;
    }

    public final void m8425b(float f) {
        this.f8181k = ((float) (this.f8181k < 0.0f ? -1 : 1)) * f;
    }

    public final void m8426h() {
        m8415d(0.0f);
    }

    final void m8427i() {
        m8415d(-0.35f + ((((float) Math.random()) * 0.35f) * 2.0f));
    }

    private void m8415d(float f) {
        this.f8173c = f;
        this.f8174d = -0.03f;
        this.f8177g = 1.0f;
        this.f8179i = 0.0f;
        this.f8178h = 0.0f;
        this.f8187q = 0.0f;
        this.f8188r = true;
        this.f8189s = false;
        m8414a(true);
        m8420k();
        for (Listener a : this.f8172b) {
            a.mo301a();
        }
    }

    public final void m8423a(float f, float f2) {
        if (this.f8188r) {
            this.f8175e = (f / ((float) Math.sqrt((double) ((f * f) + (f2 * f2))))) * 6.6f;
            this.f8176f = -6.6f;
            this.f8177g = 1.0f;
            this.f8178h = -0.7f;
            this.f8187q = 1.0f;
            this.f8188r = false;
            this.f8189s = false;
            m8414a(false);
            m8420k();
            for (Listener b : this.f8172b) {
                b.mo302b();
            }
        }
    }

    private void m8420k() {
        this.f8171a.b(this.f8191u);
        this.f8171a.a(this.f8191u);
        long nanoTime = System.nanoTime();
        this.f8186p = ((double) nanoTime) / 1.0E9d;
        m8413a(this, nanoTime);
    }

    public static void m8413a(BballScene bballScene, long j) {
        double d = ((double) j) / 1.0E9d;
        float f = (float) (d - bballScene.f8186p);
        bballScene.f8186p = d;
        float min = Math.min(f, 0.08f);
        int f2 = bballScene.m8417f(min) | (bballScene.m8416e(min) | 0);
        if (bballScene.f8190t != null) {
            bballScene.f8190t.m8428a();
        }
        if (f2 != 0) {
            bballScene.f8171a.a(bballScene.f8191u);
        } else if (bballScene.f8189s) {
            for (Listener f3 : bballScene.f8172b) {
                f3.mo306f();
            }
        }
    }

    private boolean m8416e(float f) {
        if (!this.f8188r) {
            return false;
        }
        this.f8187q = Math.min(this.f8187q + (3.0f * f), 1.0f);
        float f2 = 1.0f - this.f8187q;
        f2 = 1.0f - (f2 * f2);
        float sin = (float) Math.sin(((double) f2) * 3.141592653589793d);
        this.f8174d = ((-sin) * 0.15f) + (-0.03f * (f2 - sin));
        this.f8177g = 0.3f + (0.7f * f2);
        m8418g(f);
        if (this.f8185o && f2 >= 0.5f) {
            m8414a(false);
        }
        if (this.f8187q >= 1.0f && this.f8180j == 0.0f && this.f8181k == 0.0f) {
            return false;
        }
        return true;
    }

    private boolean m8417f(float f) {
        if (this.f8188r) {
            return false;
        }
        float f2 = f / 10.0f;
        for (int i = 0; i < 10; i++) {
            float f3 = this.f8177g * f2;
            this.f8173c += (0.3030303f * f3) * this.f8175e;
            this.f8174d = (f3 * this.f8176f) + this.f8174d;
            this.f8176f += 16.0f * f2;
            this.f8179i += (200.0f * f2) * this.f8175e;
            this.f8177g = Math.max(0.3f, this.f8177g + (this.f8178h * f2));
            m8418g(f2);
            m8421l();
            if (!this.f8189s && this.f8176f > 0.0f && this.f8174d - 0.15f > this.f8183m) {
                this.f8189s = true;
                if (Math.abs(this.f8173c - this.f8182l) < 0.13f) {
                    this.f8178h = 0.0f;
                    for (Listener e : this.f8172b) {
                        e.mo305e();
                    }
                } else {
                    for (Listener e2 : this.f8172b) {
                        e2.mo304d();
                    }
                }
            }
        }
        if (this.f8176f >= 0.0f && !this.f8185o) {
            m8414a(true);
        }
        if (this.f8174d - 0.3f < 0.90000004f) {
            return true;
        }
        return false;
    }

    private void m8418g(float f) {
        this.f8182l += this.f8180j * f;
        if (this.f8180j > 0.0f && this.f8182l > 0.37f) {
            this.f8182l -= this.f8182l - 0.37f;
            this.f8180j = -this.f8180j;
        } else if (this.f8180j < 0.0f && this.f8182l < -0.37f) {
            this.f8182l -= this.f8182l + 0.37f;
            this.f8180j = -this.f8180j;
        }
        this.f8183m += this.f8181k * f;
        if (this.f8181k > 0.0f && this.f8183m > this.f8184n - 3.8f) {
            this.f8183m -= (this.f8183m - -1.1f) - this.f8184n;
            this.f8181k = -this.f8181k;
        } else if (this.f8181k < 0.0f && this.f8183m < -1.1f) {
            this.f8183m -= this.f8183m - -1.1f;
            this.f8181k = -this.f8181k;
        }
    }

    private void m8414a(boolean z) {
        if (z != this.f8185o) {
            this.f8185o = z;
            if (this.f8190t != null) {
                this.f8190t.m8429a(this.f8185o);
            }
        }
    }

    private void m8421l() {
        if (this.f8176f >= 0.0f) {
            float f = this.f8182l;
            m8419h((f - 0.13f) + 0.0085f);
            m8419h((f + 0.13f) - 0.0085f);
        }
    }

    private void m8419h(float f) {
        float f2 = (this.f8174d - 0.15f) - this.f8183m;
        float f3 = this.f8173c - f;
        float f4 = (f3 * f3) + (f2 * f2);
        float f5 = (this.f8177g * 0.15f) + 0.0085f;
        if (f4 <= f5 * f5) {
            f4 = (float) Math.sqrt((double) f4);
            f3 /= f4;
            f2 /= f4;
            float f6 = (this.f8175e * f3) + (this.f8176f * f2);
            this.f8175e -= (2.0f * f6) * f3;
            this.f8176f -= (f6 * 2.0f) * f2;
            this.f8175e *= 0.85f;
            this.f8176f *= 0.85f;
            f5 = (f5 - f4) + 0.01f;
            this.f8173c = (f3 * f5) + this.f8173c;
            this.f8174d = (f5 * f2) + this.f8174d;
            this.f8178h = 0.0f;
            for (Listener c : this.f8172b) {
                c.mo303c();
            }
        }
    }
}
