package com.facebook.widget.viewpager;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* compiled from: share_image */
public abstract class CustomFragmentStatePagerAdapter extends PagerAdapter {
    private final ArrayList<String> f3568a = new ArrayList();
    private final FragmentManager f3569b;
    private ArrayList<SavedState> f3570c = new ArrayList();
    private FragmentTransaction f3571d = null;
    private SparseArrayCompat<Fragment> f3572e = new SparseArrayCompat();
    private Fragment f3573f = null;

    public abstract Fragment mo1156a(int i);

    public CustomFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f3569b = fragmentManager;
    }

    public final void m3365a(ViewGroup viewGroup) {
    }

    public final Object m3363a(ViewGroup viewGroup, int i) {
        if (this.f3572e.a() > i) {
            Fragment fragment = (Fragment) this.f3572e.a(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f3571d == null) {
            this.f3571d = this.f3569b.a();
        }
        Fragment a = mo1156a(i);
        CharSequence b = mo1157b(i);
        m3361a(this.f3568a, i + 1);
        if (this.f3570c.size() > i && TextUtils.equals(b, (String) this.f3568a.get(i))) {
            SavedState savedState = (SavedState) this.f3570c.get(i);
            if (savedState != null) {
                a.a(savedState);
            }
        }
        if (a != this.f3573f) {
            m3360a(a, false);
        }
        this.f3572e.a(i, a);
        this.f3571d.a(viewGroup.getId(), a, mo1157b(i));
        return a;
    }

    public final void m3366a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f3571d == null) {
            this.f3571d = this.f3569b.a();
        }
        if (a(obj) >= 0) {
            i = a(obj);
        }
        m3361a(this.f3570c, i + 1);
        m3361a(this.f3568a, i + 1);
        this.f3570c.set(i, this.f3569b.a(fragment));
        this.f3568a.set(i, fragment.J);
        this.f3572e.b(i);
        this.f3571d.a(fragment);
    }

    public final void m3370b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f3573f) {
            if (this.f3573f != null) {
                m3360a(this.f3573f, false);
            }
            if (fragment != null) {
                m3360a(fragment, true);
            }
            this.f3573f = fragment;
        }
    }

    public final void m3369b(ViewGroup viewGroup) {
        if (this.f3571d != null) {
            this.f3571d.c();
            this.f3571d = null;
            this.f3569b.b();
        }
    }

    public final boolean m3367a(View view, Object obj) {
        return ((Fragment) obj).T == view;
    }

    public final Parcelable gG_() {
        Bundle bundle = null;
        if (this.f3570c.size() > 0) {
            bundle = new Bundle();
            SavedState[] savedStateArr = new SavedState[this.f3570c.size()];
            this.f3570c.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f3572e.a(); i++) {
            Fragment fragment = (Fragment) this.f3572e.a(i);
            if (fragment != null) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f3569b.a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public final void m3364a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            this.f3572e.b();
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f3570c.clear();
            if (parcelableArray != null) {
                m3361a(this.f3570c, parcelableArray.length);
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f3570c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f3569b.a(bundle, str);
                    if (a != null) {
                        m3360a(a, false);
                        this.f3572e.a(parseInt, a);
                    } else {
                        Log.w("FSPA", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public final void kR_() {
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat(b());
        ArrayList arrayList = new ArrayList();
        m3361a(arrayList, b());
        m3361a(this.f3570c, b());
        for (int i = 0; i < this.f3572e.a(); i++) {
            int e = this.f3572e.e(i);
            Fragment fragment = (Fragment) this.f3572e.f(i);
            int a = a(fragment);
            SavedState savedState = (SavedState) this.f3570c.get(i);
            if (a != -2) {
                if (a < 0) {
                    a = e;
                }
                sparseArrayCompat.a(a, fragment);
                arrayList.set(a, savedState);
            } else {
                arrayList.set(i, null);
            }
        }
        this.f3572e = sparseArrayCompat;
        this.f3570c = arrayList;
        super.kR_();
    }

    public String mo1157b(int i) {
        return null;
    }

    public final Fragment m3371e(int i) {
        return (Fragment) this.f3572e.a(i);
    }

    private static void m3360a(Fragment fragment, boolean z) {
        fragment.f(z);
        fragment.g(z);
    }

    private static void m3361a(ArrayList arrayList, int i) {
        while (arrayList.size() <= i) {
            arrayList.add(null);
        }
    }
}
