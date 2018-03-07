package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: wildcard bounds */
public abstract class FragmentStatePagerAdapter extends PagerAdapter {
    private final FragmentManager f94a;
    private FragmentTransaction f95b = null;
    private ArrayList<Fragment$SavedState> f96c = new ArrayList();
    private ArrayList<Fragment> f97d = new ArrayList();
    private Fragment f98e = null;

    public abstract Fragment m73a(int i);

    public FragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f94a = fragmentManager;
    }

    public final void m76a(ViewGroup viewGroup) {
    }

    public Object m74a(ViewGroup viewGroup, int i) {
        if (this.f97d.size() > i) {
            Fragment fragment = (Fragment) this.f97d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f95b == null) {
            this.f95b = this.f94a.a();
        }
        Fragment a = m73a(i);
        if (this.f96c.size() > i) {
            Fragment$SavedState fragment$SavedState = (Fragment$SavedState) this.f96c.get(i);
            if (fragment$SavedState != null) {
                a.a(fragment$SavedState);
            }
        }
        while (this.f97d.size() <= i) {
            this.f97d.add(null);
        }
        a.f(false);
        a.g(false);
        this.f97d.set(i, a);
        this.f95b.a(viewGroup.getId(), a);
        return a;
    }

    public void m77a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f95b == null) {
            this.f95b = this.f94a.a();
        }
        while (this.f96c.size() <= i) {
            this.f96c.add(null);
        }
        this.f96c.set(i, this.f94a.a(fragment));
        this.f97d.set(i, null);
        this.f95b.a(fragment);
    }

    public final void m80b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f98e) {
            if (this.f98e != null) {
                this.f98e.f(false);
                this.f98e.g(false);
            }
            if (fragment != null) {
                fragment.f(true);
                fragment.g(true);
            }
            this.f98e = fragment;
        }
    }

    public final void m79b(ViewGroup viewGroup) {
        if (this.f95b != null) {
            this.f95b.c();
            this.f95b = null;
            this.f94a.b();
        }
    }

    public final boolean m78a(View view, Object obj) {
        return ((Fragment) obj).T == view;
    }

    public Parcelable gG_() {
        Bundle bundle = null;
        if (this.f96c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new Fragment$SavedState[this.f96c.size()];
            this.f96c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f97d.size(); i++) {
            Fragment fragment = (Fragment) this.f97d.get(i);
            if (fragment != null) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f94a.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public void m75a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f96c.clear();
            this.f97d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f96c.add((Fragment$SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f94a.a(bundle, str);
                    if (a != null) {
                        while (this.f97d.size() <= parseInt) {
                            this.f97d.add(null);
                        }
                        a.f(false);
                        this.f97d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
