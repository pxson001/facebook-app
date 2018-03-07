package com.facebook.photos.mediagallery.util;

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
import com.facebook.debug.log.BLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: is_landscape */
public abstract class ModifiableFragmentStatePagerAdapter extends PagerAdapter {
    private static final String f10792a = ModifiableFragmentStatePagerAdapter.class.getSimpleName();
    private final FragmentManager f10793b;
    private FragmentTransaction f10794c = null;
    public Map<String, Integer> f10795d = new HashMap();
    public ArrayList<SavedState> f10796e = new ArrayList();
    public ArrayList<Fragment> f10797f = new ArrayList();
    private Fragment f10798g = null;

    public abstract Fragment m12813a(int i);

    public abstract boolean m12819a(Object obj, int i);

    public abstract String m12820b(int i);

    public ModifiableFragmentStatePagerAdapter(FragmentManager fragmentManager) {
        this.f10793b = fragmentManager;
    }

    public final void m12816a(ViewGroup viewGroup) {
    }

    public final void kR_() {
        int i;
        int i2 = 0;
        int b = b();
        Map hashMap = new HashMap(b);
        if (b != this.f10795d.size()) {
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 0;
        while (i3 < b) {
            Integer num;
            String b2 = m12820b(i3);
            hashMap.put(b2, Integer.valueOf(i3));
            if (i == 0) {
                num = (Integer) this.f10795d.get(b2);
                if (num == null || num.intValue() != i3) {
                    i = 1;
                } else {
                    i = 0;
                }
            }
            i3++;
        }
        if (i != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            while (i2 < b) {
                num = (Integer) this.f10795d.get(m12820b(i2));
                if (num == null) {
                    arrayList.add(null);
                    arrayList2.add(null);
                } else {
                    Object obj;
                    Object obj2;
                    if (num.intValue() < this.f10796e.size()) {
                        obj = (SavedState) this.f10796e.get(num.intValue());
                    } else {
                        obj = null;
                    }
                    arrayList.add(obj);
                    if (num.intValue() < this.f10797f.size()) {
                        obj2 = (Fragment) this.f10797f.get(num.intValue());
                    } else {
                        obj2 = null;
                    }
                    arrayList2.add(obj2);
                }
                i2++;
            }
            this.f10795d = hashMap;
            this.f10796e = arrayList;
            this.f10797f = arrayList2;
        }
        super.kR_();
    }

    public final Object m12814a(ViewGroup viewGroup, int i) {
        if (this.f10797f.size() > i) {
            Fragment fragment = (Fragment) this.f10797f.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f10794c == null) {
            this.f10794c = this.f10793b.a();
        }
        Fragment a = m12813a(i);
        if (this.f10796e.size() > i) {
            SavedState savedState = (SavedState) this.f10796e.get(i);
            if (savedState != null) {
                a.a(savedState);
            }
        }
        while (this.f10797f.size() <= i) {
            this.f10797f.add(null);
        }
        a.f(false);
        a.g(false);
        this.f10797f.set(i, a);
        this.f10794c.a(viewGroup.getId(), a);
        return a;
    }

    public final void m12817a(ViewGroup viewGroup, int i, Object obj) {
        Object a;
        Fragment fragment = (Fragment) obj;
        if (this.f10794c == null) {
            this.f10794c = this.f10793b.a();
        }
        while (this.f10796e.size() <= i) {
            this.f10796e.add(null);
        }
        if (m12819a(obj, i)) {
            try {
                a = this.f10793b.a(fragment);
            } catch (Throwable e) {
                BLog.c(f10792a, e, "destroyItem fragment state not valid at position=%d and size=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.f10797f.size())});
            }
            this.f10796e.set(i, a);
            if (i < this.f10797f.size()) {
                this.f10797f.set(i, null);
            }
            this.f10794c.a(fragment);
        }
        a = null;
        this.f10796e.set(i, a);
        if (i < this.f10797f.size()) {
            this.f10797f.set(i, null);
        }
        this.f10794c.a(fragment);
    }

    public final void m12822b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f10798g) {
            if (this.f10798g != null) {
                this.f10798g.f(false);
                this.f10798g.g(false);
            }
            if (fragment != null) {
                fragment.f(true);
                fragment.g(true);
            }
            this.f10798g = fragment;
        }
    }

    public final void m12821b(ViewGroup viewGroup) {
        if (this.f10794c != null) {
            this.f10794c.c();
            this.f10794c = null;
            this.f10793b.b();
        }
    }

    public final boolean m12818a(View view, Object obj) {
        return ((Fragment) obj).T == view;
    }

    public final Parcelable gG_() {
        Bundle bundle = null;
        if (this.f10796e.size() > 0) {
            bundle = new Bundle();
            SavedState[] savedStateArr = new SavedState[this.f10796e.size()];
            this.f10796e.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f10797f.size(); i++) {
            Fragment fragment = (Fragment) this.f10797f.get(i);
            if (fragment != null) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                try {
                    this.f10793b.a(parcelable, "f" + i, fragment);
                } catch (Throwable e) {
                    BLog.c(f10792a, "Attempt to save state for inactive fragment", e);
                }
            }
        }
        if (this.f10795d.size() > 0) {
            if (parcelable == null) {
                parcelable = new Bundle();
            }
            parcelable.putSerializable("idxmap", (Serializable) this.f10795d);
        }
        return parcelable;
    }

    public final void m12815a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f10795d.clear();
            this.f10796e.clear();
            this.f10797f.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f10796e.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f10793b.a(bundle, str);
                    if (a != null) {
                        while (this.f10797f.size() <= parseInt) {
                            this.f10797f.add(null);
                        }
                        a.f(false);
                        this.f10797f.set(parseInt, a);
                    } else {
                        Log.w(f10792a, "Bad fragment at key " + str);
                    }
                }
            }
            Serializable serializable = bundle.getSerializable("idxmap");
            if (serializable != null) {
                this.f10795d = (Map) serializable;
            }
        }
    }
}
