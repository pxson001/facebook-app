package com.facebook.katana.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: reaction_ready_time_key_%d */
public abstract class FragmentStatePagerAdapterThatAllowsAccessToFragments extends PagerAdapter {
    private final FragmentManager f8051a;
    private FragmentTransaction f8052b = null;
    private ArrayList<SavedState> f8053c = new ArrayList();
    private ArrayList<Fragment> f8054d = new ArrayList();
    private Fragment f8055e = null;

    public abstract Fragment mo1708a(int i);

    public FragmentStatePagerAdapterThatAllowsAccessToFragments(FragmentManager fragmentManager) {
        this.f8051a = fragmentManager;
    }

    public final void mo1715a(ViewGroup viewGroup) {
    }

    public final Object mo1714a(ViewGroup viewGroup, int i) {
        if (this.f8054d.size() > i) {
            Fragment fragment = (Fragment) this.f8054d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f8052b == null) {
            this.f8052b = this.f8051a.mo842a();
        }
        Fragment a = mo1708a(i);
        Log.v("FragmentStatePagerAdapter", "Adding item #" + i + ": f=" + a);
        if (this.f8053c.size() > i) {
            SavedState savedState = (SavedState) this.f8053c.get(i);
            if (savedState != null) {
                a.m250a(savedState);
            }
        }
        while (this.f8054d.size() <= i) {
            this.f8054d.add(null);
        }
        a.m270f(false);
        a.mo1860g(false);
        this.f8054d.set(i, a);
        this.f8052b.mo1842a(viewGroup.getId(), a);
        return a;
    }

    public void mo1710a(ViewGroup viewGroup, int i, Object obj) {
        m12638a(i, obj, true);
    }

    protected final void m12638a(int i, Object obj, boolean z) {
        Fragment fragment = (Fragment) obj;
        if (this.f8052b == null) {
            this.f8052b = this.f8051a.mo842a();
        }
        Log.v("FragmentStatePagerAdapter", "Removing item #" + i + ": f=" + obj + " v=" + ((Fragment) obj).f116T);
        while (this.f8053c.size() <= i) {
            this.f8053c.add(null);
        }
        this.f8053c.set(i, z ? this.f8051a.mo838a(fragment) : null);
        this.f8054d.set(i, null);
        this.f8052b.mo1844a(fragment);
    }

    public final void mo1717b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f8055e) {
            if (this.f8055e != null) {
                this.f8055e.m270f(false);
                this.f8055e.mo1860g(false);
            }
            if (fragment != null) {
                fragment.m270f(true);
                fragment.mo1860g(true);
            }
            this.f8055e = fragment;
        }
    }

    public void mo1712b(ViewGroup viewGroup) {
        if (this.f8052b != null) {
            this.f8052b.mo1851c();
            this.f8052b = null;
            this.f8051a.mo849b();
        }
    }

    public final boolean mo1716a(View view, Object obj) {
        return ((Fragment) obj).f116T == view;
    }

    public Parcelable gG_() {
        Bundle bundle = null;
        if (this.f8053c.size() > 0) {
            bundle = new Bundle();
            SavedState[] savedStateArr = new SavedState[this.f8053c.size()];
            this.f8053c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f8054d.size(); i++) {
            Fragment fragment = (Fragment) this.f8054d.get(i);
            if (fragment != null) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f8051a.mo844a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public void mo1709a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f8053c.clear();
            this.f8054d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f8053c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f8051a.mo840a(bundle, str);
                    if (a != null) {
                        while (this.f8054d.size() <= parseInt) {
                            this.f8054d.add(null);
                        }
                        a.m270f(false);
                        this.f8054d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    @Nullable
    public final Fragment m12643b(int i) {
        if (i < 0 || i >= this.f8054d.size()) {
            return null;
        }
        return (Fragment) this.f8054d.get(i);
    }
}
