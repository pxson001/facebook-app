package com.facebook.saved.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: ipb_v1 */
public class SavedDashboardChildFragmentInstanceManager {
    public final FragmentManager f9131a;
    public final int f9132b;
    @Nullable
    private SavedDashboardFragmentInfo f9133c;

    @Inject
    public SavedDashboardChildFragmentInstanceManager(@Assisted FragmentManager fragmentManager, @Assisted Integer num) {
        this.f9131a = fragmentManager;
        this.f9132b = num.intValue();
        m9124b();
    }

    private FbFragment m9123b(SavedDashboardFragmentInfo savedDashboardFragmentInfo) {
        FbFragment c = m9125c(savedDashboardFragmentInfo);
        if (c != null) {
            return c;
        }
        SavedItemsListFragmentFactory savedItemsListFragmentFactory = savedDashboardFragmentInfo.fragmentFactory;
        FbFragment fbFragment = (FbFragment) new SavedItemsListFragment();
        this.f9131a.a().a(this.f9132b, fbFragment, savedDashboardFragmentInfo.getTag()).b(fbFragment).c();
        this.f9131a.b();
        return fbFragment;
    }

    public final void m9127a(SavedDashboardFragmentInfo savedDashboardFragmentInfo) {
        FbFragment b = m9123b(savedDashboardFragmentInfo);
        Fragment a = m9126a();
        if (b != a) {
            FragmentTransaction c = this.f9131a.a().c(b);
            if (a != null) {
                c.b(a);
            }
            c.c();
            this.f9131a.b();
            this.f9133c = savedDashboardFragmentInfo;
        }
    }

    @Nullable
    public final Fragment m9126a() {
        if (this.f9133c == null) {
            return null;
        }
        return this.f9131a.a(this.f9133c.getTag());
    }

    private FbFragment m9125c(SavedDashboardFragmentInfo savedDashboardFragmentInfo) {
        return (FbFragment) this.f9131a.a(savedDashboardFragmentInfo.getTag());
    }

    private void m9124b() {
        FragmentTransaction a = this.f9131a.a();
        for (SavedDashboardFragmentInfo c : SavedDashboardFragmentInfo.values()) {
            FbFragment c2 = m9125c(c);
            if (c2 != null) {
                a.b(c2);
            }
        }
        a.c();
        this.f9131a.b();
    }
}
