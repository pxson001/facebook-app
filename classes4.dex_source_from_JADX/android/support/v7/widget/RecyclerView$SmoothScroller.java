package android.support.v7.widget;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.State;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;

/* compiled from: diferent_user */
public abstract class RecyclerView$SmoothScroller {
    public int f13833a = -1;
    private RecyclerView f13834b;
    public LayoutManager f13835c;
    private boolean f13836d;
    public boolean f13837e;
    private View f13838f;
    private final Action f13839g = new Action(0, 0);

    /* compiled from: diferent_user */
    public class Action {
        private int f13840a;
        private int f13841b;
        private int f13842c;
        public int f13843d;
        private Interpolator f13844e;
        private boolean f13845f;
        private int f13846g;

        public Action(int i, int i2) {
            this(i, i2, Integer.MIN_VALUE, null);
        }

        private Action(int i, int i2, int i3, Interpolator interpolator) {
            this.f13843d = -1;
            this.f13845f = false;
            this.f13846g = 0;
            this.f13840a = i;
            this.f13841b = i2;
            this.f13842c = i3;
            this.f13844e = interpolator;
        }

        public final void m14635a(int i) {
            this.f13843d = i;
        }

        final boolean m14637a() {
            return this.f13843d >= 0;
        }

        private void m14633a(RecyclerView recyclerView) {
            if (this.f13843d >= 0) {
                int i = this.f13843d;
                this.f13843d = -1;
                RecyclerView.c(recyclerView, i);
                this.f13845f = false;
            } else if (this.f13845f) {
                m14634b();
                if (this.f13844e != null) {
                    recyclerView.aa.a(this.f13840a, this.f13841b, this.f13842c, this.f13844e);
                } else if (this.f13842c == Integer.MIN_VALUE) {
                    recyclerView.aa.b(this.f13840a, this.f13841b);
                } else {
                    recyclerView.aa.a(this.f13840a, this.f13841b, this.f13842c);
                }
                this.f13846g++;
                if (this.f13846g > 10) {
                    Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                }
                this.f13845f = false;
            } else {
                this.f13846g = 0;
            }
        }

        private void m14634b() {
            if (this.f13844e != null && this.f13842c <= 0) {
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            } else if (this.f13842c <= 0) {
                throw new IllegalStateException("Scroll duration must be a positive number");
            }
        }

        public final void m14636a(int i, int i2, int i3, Interpolator interpolator) {
            this.f13840a = i;
            this.f13841b = i2;
            this.f13842c = i3;
            this.f13844e = interpolator;
            this.f13845f = true;
        }
    }

    protected abstract void mo996a();

    protected abstract void mo997a(int i, int i2, Action action);

    protected abstract void mo998a(View view, Action action);

    final void m14622a(RecyclerView recyclerView, LayoutManager layoutManager) {
        this.f13834b = recyclerView;
        this.f13835c = layoutManager;
        if (this.f13833a == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        this.f13834b.e.f = this.f13833a;
        this.f13837e = true;
        this.f13836d = true;
        this.f13838f = mo994a(this.f13833a);
        this.f13834b.aa.a();
    }

    public final void m14625c(int i) {
        this.f13833a = i;
    }

    @Nullable
    public final LayoutManager m14626d() {
        return this.f13835c;
    }

    public final void m14627e() {
        if (this.f13837e) {
            mo996a();
            this.f13834b.e.f = -1;
            this.f13838f = null;
            this.f13833a = -1;
            this.f13836d = false;
            this.f13837e = false;
            LayoutManager.b(this.f13835c, this);
            this.f13835c = null;
            this.f13834b = null;
        }
    }

    public final boolean m14628f() {
        return this.f13836d;
    }

    public final boolean m14629g() {
        return this.f13837e;
    }

    public final int m14630h() {
        return this.f13833a;
    }

    private void m14616a(int i, int i2) {
        RecyclerView recyclerView = this.f13834b;
        if (!this.f13837e || this.f13833a == -1 || recyclerView == null) {
            m14627e();
        }
        this.f13836d = false;
        if (this.f13838f != null) {
            if (m14619b(this.f13838f) == this.f13833a) {
                View view = this.f13838f;
                State state = recyclerView.e;
                mo998a(view, this.f13839g);
                this.f13839g.m14633a(recyclerView);
                m14627e();
            } else {
                Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                this.f13838f = null;
            }
        }
        if (this.f13837e) {
            State state2 = recyclerView.e;
            mo997a(i, i2, this.f13839g);
            boolean a = this.f13839g.m14637a();
            this.f13839g.m14633a(recyclerView);
            if (!a) {
                return;
            }
            if (this.f13837e) {
                this.f13836d = true;
                recyclerView.aa.a();
                return;
            }
            m14627e();
        }
    }

    private int m14619b(View view) {
        return RecyclerView.e(view);
    }

    public final int m14631i() {
        return this.f13834b.p.v();
    }

    private View mo994a(int i) {
        return this.f13834b.p.c(i);
    }

    protected final void m14623a(View view) {
        if (m14619b(view) == this.f13833a) {
            this.f13838f = view;
        }
    }

    public static void m14617a(PointF pointF) {
        double sqrt = Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
        pointF.x = (float) (((double) pointF.x) / sqrt);
        pointF.y = (float) (((double) pointF.y) / sqrt);
    }
}
