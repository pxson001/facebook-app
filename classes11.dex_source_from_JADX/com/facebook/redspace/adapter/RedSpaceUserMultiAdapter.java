package com.facebook.redspace.adapter;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.redspace.pagerindicator.SwipeImagePagerAdapter;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.titlebar.RedSpaceTitleAdapter;
import java.lang.ref.WeakReference;

/* compiled from: Public Content / Hashtags / Topics */
public class RedSpaceUserMultiAdapter extends FragmentStatePagerAdapter implements SwipeImagePagerAdapter, RedSpaceTitleAdapter {
    public final AdapterCursor f11747a;
    public final SparseArray<WeakReference<Fragment>> f11748b = new SparseArray();

    /* compiled from: Public Content / Hashtags / Topics */
    public class AdapterCursor {
        public final RedSpaceUserCollectionAdapter[] f11743a;
        public int f11744b;
        public int f11745c;
        public int f11746d;

        public AdapterCursor(RedSpaceUserCollectionAdapter[] redSpaceUserCollectionAdapterArr) {
            this.f11743a = redSpaceUserCollectionAdapterArr;
        }

        public final void m12176a(int i) {
            int i2 = 0;
            if (this.f11744b != i) {
                if (i < 0) {
                    throw new IndexOutOfBoundsException("Requested position is " + i);
                }
                int i3 = 0;
                while (i2 < this.f11743a.length) {
                    if (i < this.f11743a[i2].b() + i3) {
                        this.f11744b = i;
                        this.f11745c = i3;
                        this.f11746d = i2;
                        return;
                    }
                    i3 += this.f11743a[i2].b();
                    i2++;
                }
                throw new IndexOutOfBoundsException("Could not find position " + i + " from totalCount " + i3 + "\n" + toString());
            }
        }

        public final RedSpaceUserCollectionAdapter m12175a() {
            return this.f11743a[this.f11746d];
        }
    }

    public RedSpaceUserMultiAdapter(FragmentManager fragmentManager, RedSpaceUserCollectionAdapter... redSpaceUserCollectionAdapterArr) {
        super(fragmentManager);
        this.f11747a = new AdapterCursor(redSpaceUserCollectionAdapterArr);
    }

    public final Object m12180a(ViewGroup viewGroup, int i) {
        Fragment fragment = (Fragment) super.a(viewGroup, i);
        this.f11748b.put(i, new WeakReference(fragment));
        return fragment;
    }

    public final void m12181a(ViewGroup viewGroup, int i, Object obj) {
        this.f11748b.remove(i);
        super.a(viewGroup, i, obj);
    }

    public final Fragment m12179a(int i) {
        this.f11747a.m12176a(i);
        return this.f11747a.m12175a().a(m12177i(i));
    }

    public final int m12178a(String str) {
        int i = 0;
        RedSpaceUserCollectionAdapter[] redSpaceUserCollectionAdapterArr = this.f11747a.f11743a;
        int length = redSpaceUserCollectionAdapterArr.length;
        int i2 = 0;
        while (i < length) {
            PagerAdapter pagerAdapter = redSpaceUserCollectionAdapterArr[i];
            int i3 = 0;
            while (i3 < pagerAdapter.b()) {
                if (StringUtil.a(pagerAdapter.f11736a.m12213a(i3).k(), str)) {
                    break;
                }
                i3++;
            }
            i3 = -1;
            int i4 = i3;
            if (i4 >= 0) {
                i = i4 + i2;
                break;
            }
            i2 += pagerAdapter.b();
            i++;
        }
        i = -1;
        return i;
    }

    public final RedSpaceFeedProfileFragmentModel m12186g(int i) {
        this.f11747a.m12176a(i);
        RedSpaceUserCollectionAdapter a = this.f11747a.m12175a();
        return a.f11736a.m12213a(m12177i(i));
    }

    public final String mo331e(int i) {
        this.f11747a.m12176a(i);
        return this.f11747a.m12175a().mo331e(m12177i(i));
    }

    public final Uri mo329b(int i) {
        this.f11747a.m12176a(i);
        return this.f11747a.m12175a().mo329b(m12177i(i));
    }

    public final Uri mo330c(int i) {
        this.f11747a.m12176a(i);
        return this.f11747a.m12175a().mo330c(m12177i(i));
    }

    public final int I_(int i) {
        this.f11747a.m12176a(i);
        return this.f11747a.m12175a().I_(m12177i(i));
    }

    public final int mo328b() {
        int i = 0;
        RedSpaceUserCollectionAdapter[] redSpaceUserCollectionAdapterArr = this.f11747a.f11743a;
        int i2 = 0;
        while (i < redSpaceUserCollectionAdapterArr.length) {
            i2 += redSpaceUserCollectionAdapterArr[i].b();
            i++;
        }
        return i2;
    }

    public final void kR_() {
        super.kR_();
        AdapterCursor adapterCursor = this.f11747a;
        for (PagerAdapter kR_ : adapterCursor.f11743a) {
            kR_.kR_();
        }
        adapterCursor.f11745c = 0;
        adapterCursor.f11744b = 0;
        adapterCursor.f11746d = 0;
    }

    private int m12177i(int i) {
        this.f11747a.m12176a(i);
        return i - this.f11747a.f11745c;
    }
}
