package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* compiled from: num_media_question_options */
public class ChildHelper {
    public final Callback f11958a;
    public final Bucket f11959b = new Bucket();
    public final List<View> f11960c = new ArrayList();

    /* compiled from: num_media_question_options */
    public interface Callback {
        int mo2270a();

        int mo2271a(View view);

        void mo2272a(int i);

        void mo2273a(View view, int i);

        void mo2274a(View view, int i, LayoutParams layoutParams);

        ViewHolder mo2275b(View view);

        View mo2276b(int i);

        void mo2277b();

        void mo2278c(int i);

        void mo2279c(View view);

        void mo2280d(View view);
    }

    /* compiled from: num_media_question_options */
    public class Bucket {
        long f11962a = 0;
        Bucket f11963b;

        Bucket() {
        }

        final void m17645a(int i) {
            if (i >= 64) {
                m17642b();
                this.f11963b.m17645a(i - 64);
                return;
            }
            this.f11962a |= 1 << i;
        }

        private void m17642b() {
            if (this.f11963b == null) {
                this.f11963b = new Bucket();
            }
        }

        private void m17643e(int i) {
            if (i < 64) {
                this.f11962a &= (1 << i) ^ -1;
            } else if (this.f11963b != null) {
                this.f11963b.m17643e(i - 64);
            }
        }

        final boolean m17647b(int i) {
            if (i < 64) {
                return (this.f11962a & (1 << i)) != 0;
            } else {
                m17642b();
                return this.f11963b.m17647b(i - 64);
            }
        }

        public final void m17644a() {
            this.f11962a = 0;
            if (this.f11963b != null) {
                this.f11963b.m17644a();
            }
        }

        final void m17646a(int i, boolean z) {
            if (i >= 64) {
                m17642b();
                this.f11963b.m17646a(i - 64, z);
                return;
            }
            boolean z2 = (this.f11962a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f11962a = (((j ^ -1) & this.f11962a) << 1) | (this.f11962a & j);
            if (z) {
                m17645a(i);
            } else {
                m17643e(i);
            }
            if (z2 || this.f11963b != null) {
                m17642b();
                this.f11963b.m17646a(0, z2);
            }
        }

        final boolean m17648c(int i) {
            if (i >= 64) {
                m17642b();
                return this.f11963b.m17648c(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f11962a & j) != 0;
            this.f11962a &= j ^ -1;
            j--;
            this.f11962a = Long.rotateRight((j ^ -1) & this.f11962a, 1) | (this.f11962a & j);
            if (this.f11963b == null) {
                return z;
            }
            if (this.f11963b.m17647b(0)) {
                m17645a(63);
            }
            this.f11963b.m17648c(0);
            return z;
        }

        final int m17649d(int i) {
            if (this.f11963b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f11962a);
                }
                return Long.bitCount(this.f11962a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f11962a & ((1 << i) - 1));
            } else {
                return this.f11963b.m17649d(i - 64) + Long.bitCount(this.f11962a);
            }
        }

        public String toString() {
            return this.f11963b == null ? Long.toBinaryString(this.f11962a) : this.f11963b.toString() + "xx" + Long.toBinaryString(this.f11962a);
        }
    }

    ChildHelper(Callback callback) {
        this.f11958a = callback;
    }

    private void m17605f(View view) {
        this.f11960c.add(view);
        this.f11958a.mo2279c(view);
    }

    private boolean m17606g(View view) {
        if (!this.f11960c.remove(view)) {
            return false;
        }
        this.f11958a.mo2280d(view);
        return true;
    }

    public final void m17610a(View view, int i, boolean z) {
        int a;
        if (i < 0) {
            a = this.f11958a.mo2270a();
        } else {
            a = m17604e(i);
        }
        this.f11959b.m17646a(a, z);
        if (z) {
            m17605f(view);
        }
        this.f11958a.mo2273a(view, a);
    }

    private int m17604e(int i) {
        if (i < 0) {
            return -1;
        }
        int a = this.f11958a.mo2270a();
        int i2 = i;
        while (i2 < a) {
            int d = i - (i2 - this.f11959b.m17649d(i2));
            if (d == 0) {
                while (this.f11959b.m17647b(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += d;
        }
        return -1;
    }

    final void m17608a(View view) {
        int a = this.f11958a.mo2271a(view);
        if (a >= 0) {
            if (this.f11959b.m17648c(a)) {
                m17606g(view);
            }
            this.f11958a.mo2272a(a);
        }
    }

    final void m17607a(int i) {
        int e = m17604e(i);
        View b = this.f11958a.mo2276b(e);
        if (b != null) {
            if (this.f11959b.m17648c(e)) {
                m17606g(b);
            }
            this.f11958a.mo2272a(e);
        }
    }

    final View m17613b(int i) {
        return this.f11958a.mo2276b(m17604e(i));
    }

    final void m17609a(View view, int i, LayoutParams layoutParams, boolean z) {
        int a;
        if (i < 0) {
            a = this.f11958a.mo2270a();
        } else {
            a = m17604e(i);
        }
        this.f11959b.m17646a(a, z);
        if (z) {
            m17605f(view);
        }
        this.f11958a.mo2274a(view, a, layoutParams);
    }

    final int m17611b() {
        return this.f11958a.mo2270a() - this.f11960c.size();
    }

    final int m17614c() {
        return this.f11958a.mo2270a();
    }

    final View m17615c(int i) {
        return this.f11958a.mo2276b(i);
    }

    final void m17617d(int i) {
        int e = m17604e(i);
        this.f11959b.m17648c(e);
        this.f11958a.mo2278c(e);
    }

    final int m17612b(View view) {
        int a = this.f11958a.mo2271a(view);
        if (a == -1 || this.f11959b.m17647b(a)) {
            return -1;
        }
        return a - this.f11959b.m17649d(a);
    }

    final boolean m17616c(View view) {
        return this.f11960c.contains(view);
    }

    final void m17618d(View view) {
        int a = this.f11958a.mo2271a(view);
        if (a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f11959b.m17645a(a);
        m17605f(view);
    }

    public String toString() {
        return this.f11959b.toString() + ", hidden list:" + this.f11960c.size();
    }

    final boolean m17619e(View view) {
        int a = this.f11958a.mo2271a(view);
        if (a == -1) {
            m17606g(view);
            return true;
        } else if (!this.f11959b.m17647b(a)) {
            return false;
        } else {
            this.f11959b.m17648c(a);
            m17606g(view);
            this.f11958a.mo2272a(a);
            return true;
        }
    }
}
