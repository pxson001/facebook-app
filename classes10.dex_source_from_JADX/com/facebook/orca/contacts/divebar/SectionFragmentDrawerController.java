package com.facebook.orca.contacts.divebar;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.fragment.FbFragment;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.ui.drawers.DrawerFragmentContentController;
import javax.annotation.Nullable;

/* compiled from: onMessageReceived */
public class SectionFragmentDrawerController<T extends FbFragment> {
    public Fragment f5902a;

    private FragmentManager m5557a() {
        Activity c = m5560c();
        if (c instanceof DivebarEnabledActivity) {
            DrawerBasedDivebarControllerImpl f = ((DivebarEnabledActivity) c).f();
            if (f instanceof DrawerFragmentContentController) {
                return ((DrawerFragmentContentController) f).j;
            }
        }
        return this.f5902a.D;
    }

    private int m5558b() {
        if (m5561d()) {
            return 2131558429;
        }
        Activity c = m5560c();
        if (c instanceof DivebarEnabledActivity) {
            DrawerBasedDivebarControllerImpl f = ((DivebarEnabledActivity) c).f();
            if (f instanceof DrawerFragmentContentController) {
                return ((DrawerFragmentContentController) f).j();
            }
        }
        return 2131564830;
    }

    private Activity m5560c() {
        Context context = this.f5902a.getContext();
        if (context instanceof FragmentActivity) {
            return (Activity) context;
        }
        return null;
    }

    private boolean m5561d() {
        Context context = this.f5902a.getContext();
        if (context != null) {
            return !(context instanceof Activity);
        } else {
            throw new IllegalStateException("Divebar is not hosted anywhere");
        }
    }

    @Nullable
    public final T m5563a(Class<T> cls, String str) {
        T b = m5559b(cls, str);
        if (b == null || !m5562e()) {
            return null;
        }
        FragmentManager a = m5557a();
        FragmentTransaction a2 = a.a();
        a2.a(2130968649, 2130968694, 2130968648, 2130968695);
        a2.b(m5558b(), b, str);
        a2.a(null);
        a2.b();
        a.b();
        return b;
    }

    private T m5559b(Class<T> cls, String str) {
        T a = m5564a(str);
        if (a != null) {
            return a;
        }
        if (!m5562e()) {
            return null;
        }
        try {
            return (FbFragment) cls.newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    public final T m5564a(String str) {
        FragmentManager a = m5557a();
        if (a == null) {
            return null;
        }
        return (FbFragment) a.a(str);
    }

    private boolean m5562e() {
        FragmentManager a = m5557a();
        return a != null && a.c();
    }
}
