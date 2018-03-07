package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* compiled from: wilde_group_profile_more */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    private final FragmentManager f78a;
    private FragmentTransaction f79b = null;
    private Fragment f80c = null;
    private List<Fragment> f81d;

    public abstract Fragment m64a(int i);

    public FragmentPagerAdapter(FragmentManager fragmentManager) {
        this.f78a = fragmentManager;
    }

    public final void m67a(ViewGroup viewGroup) {
        this.f81d = new ArrayList();
    }

    public Object m65a(ViewGroup viewGroup, int i) {
        boolean z;
        if (this.f79b == null) {
            this.f79b = this.f78a.a();
        }
        long b = m70b(i);
        Fragment a = this.f78a.a(m63a(viewGroup.getId(), b));
        if (a != null) {
            this.f79b.e(a);
        } else {
            a = m64a(i);
            this.f79b.a(viewGroup.getId(), a, m63a(viewGroup.getId(), b));
        }
        if (this.f81d != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f81d.add(a);
        }
        if (a != this.f80c) {
            a.g(false);
            if (!z) {
                a.f(false);
            }
        }
        return a;
    }

    public void m68a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f79b == null) {
            this.f79b = this.f78a.a();
        }
        this.f79b.d((Fragment) obj);
    }

    public void m72b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f80c) {
            if (this.f80c != null) {
                this.f80c.f(false);
                this.f80c.g(false);
            }
            if (fragment != null) {
                fragment.f(true);
                fragment.g(true);
            }
            this.f80c = fragment;
        }
    }

    public void m71b(ViewGroup viewGroup) {
        if (this.f81d != null) {
            for (Fragment fragment : this.f81d) {
                if (fragment != this.f80c) {
                    fragment.f(false);
                }
            }
            this.f81d = null;
        }
        if (this.f79b != null) {
            this.f79b.c();
            this.f79b = null;
            this.f78a.b();
        }
    }

    public final boolean m69a(View view, Object obj) {
        return ((Fragment) obj).T == view;
    }

    public final Parcelable gG_() {
        return null;
    }

    public final void m66a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public long m70b(int i) {
        return (long) i;
    }

    private static String m63a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
