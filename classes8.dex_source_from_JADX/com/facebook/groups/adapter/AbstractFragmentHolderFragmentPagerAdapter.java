package com.facebook.groups.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: fallback_article_style */
public abstract class AbstractFragmentHolderFragmentPagerAdapter extends FragmentPagerAdapter {
    private final SparseArray<WeakReference<Fragment>> f13819a = new SparseArray();

    public AbstractFragmentHolderFragmentPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public final Object m15466a(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.a(viewGroup, i);
        this.f13819a.put(i, new WeakReference(fragment));
        return fragment;
    }

    @Nullable
    public final Fragment m15468e(int i) {
        WeakReference weakReference = (WeakReference) this.f13819a.get(i);
        return weakReference != null ? (Fragment) weakReference.get() : null;
    }

    public final void m15467a(ViewGroup viewGroup, int i, Object obj) {
        this.f13819a.remove(i);
        super.a(viewGroup, i, obj);
    }
}
