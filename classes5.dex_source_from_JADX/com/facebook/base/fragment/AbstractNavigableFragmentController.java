package com.facebook.base.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.NavigableFragment.Listener;
import com.facebook.base.fragment.NavigableFragmentControllerBackStackHandler.ShadowBackstackEntry;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/* compiled from: suggest_edits_website_duplicate_dialog */
public abstract class AbstractNavigableFragmentController extends FbFragment {
    private static final Class<?> f2437a = AbstractNavigableFragmentController.class;
    private Fragment f2438b;
    private final Listener f2439c = new C01611(this);
    public NavigableFragmentController$Listener f2440d;
    private NavigableFragmentControllerBackStackHandler f2441e = new NavigableFragmentControllerBackStackHandler();
    private int f2442f = 0;

    /* compiled from: suggest_edits_website_duplicate_dialog */
    class C01611 implements Listener {
        final /* synthetic */ AbstractNavigableFragmentController f2436a;

        C01611(AbstractNavigableFragmentController abstractNavigableFragmentController) {
            this.f2436a = abstractNavigableFragmentController;
        }

        public final void mo564a(NavigableFragment navigableFragment, Intent intent) {
            AbstractNavigableFragmentController.m3531a(this.f2436a, navigableFragment, intent);
        }
    }

    public void m3537c(Bundle bundle) {
        super.c(bundle);
        if (bundle != null) {
            this.f2438b = s().a(2131563642);
            this.f2442f = bundle.getInt("tag_counter");
            this.f2441e = new NavigableFragmentControllerBackStackHandler(bundle.getParcelableArrayList("shadow_backstack"));
        }
    }

    public void m3538e(Bundle bundle) {
        super.e(bundle);
        bundle.putInt("tag_counter", this.f2442f);
        bundle.putParcelableArrayList("shadow_backstack", Lists.a(this.f2441e.f2447b));
    }

    public final View m3533a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 481440285);
        View inflate = layoutInflater.inflate(2130905142, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1031564264, a);
        return inflate;
    }

    public void m3534a(Fragment fragment) {
        super.a(fragment);
        if (fragment instanceof NavigableFragment) {
            ((NavigableFragment) fragment).mo563a(this.f2439c);
        }
    }

    public void m3535b(Intent intent) {
        m3531a(this, null, intent);
    }

    public final boolean hn_() {
        return this.f2438b != null;
    }

    public final boolean m3536b() {
        NavigableFragmentControllerBackStackHandler navigableFragmentControllerBackStackHandler = this.f2441e;
        boolean z = false;
        for (int i = 0; i < navigableFragmentControllerBackStackHandler.f2447b.size(); i++) {
            if (((ShadowBackstackEntry) navigableFragmentControllerBackStackHandler.f2447b.get(i)).f2445b) {
                break;
            }
        }
        z = true;
        return z;
    }

    public final boolean m3539e() {
        ar();
        return s().e();
    }

    private void aq() {
        ar();
        s().d();
    }

    private void ar() {
        NavigableFragmentControllerBackStackHandler navigableFragmentControllerBackStackHandler = this.f2441e;
        String str = null;
        int size = navigableFragmentControllerBackStackHandler.f2447b.size() - 1;
        int i = 0;
        while (size >= 0 && !((ShadowBackstackEntry) navigableFragmentControllerBackStackHandler.f2447b.get(size)).f2445b) {
            String str2;
            int i2 = size - 1;
            ShadowBackstackEntry shadowBackstackEntry = (ShadowBackstackEntry) navigableFragmentControllerBackStackHandler.f2447b.remove(size);
            if (str == null) {
                str = shadowBackstackEntry.f2444a;
                str2 = shadowBackstackEntry.f2444a;
                str2 = str;
            } else {
                str2 = shadowBackstackEntry.f2444a;
                str2 = str;
            }
            i++;
            size = i2;
            str = str2;
        }
        Integer.valueOf(i);
        if (size >= 0) {
            Preconditions.checkState(((ShadowBackstackEntry) navigableFragmentControllerBackStackHandler.f2447b.remove(size)).f2445b);
        }
        String str3 = str;
        if (str3 != null) {
            Fragment a = s().a(str3);
            if (a != null) {
                s().a().a(a).b();
                a.getClass();
            }
        }
    }

    public static void m3531a(AbstractNavigableFragmentController abstractNavigableFragmentController, NavigableFragment navigableFragment, Intent intent) {
        int i = 0;
        if (navigableFragment != null) {
            navigableFragment.getClass().getName();
        }
        if (!abstractNavigableFragmentController.s().c()) {
            return;
        }
        if ("com.facebook.fragment.FRAGMENT_ACTION".equals(intent.getAction())) {
            String className = intent.getComponent().getClassName();
            new StringBuilder("Navigating to ").append(className);
            if (className != null) {
                boolean z;
                boolean z2;
                int i2;
                int i3;
                int i4;
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    z = extras.getBoolean("com.facebook.fragment.PUSH_BACK_STACK", false);
                    z2 = extras.getBoolean("com.facebook.fragment.CLEAR_BACK_STACK", false);
                    i2 = extras.getInt("com.facebook.fragment.ENTER_ANIM", 0);
                    i3 = extras.getInt("com.facebook.fragment.EXIT_ANIM", 0);
                    i4 = extras.getInt("com.facebook.fragment.POP_ENTER_ANIM", 0);
                    i = extras.getInt("com.facebook.fragment.POP_EXIT_ANIM", 0);
                } else {
                    i4 = 0;
                    i3 = 0;
                    i2 = 0;
                    z2 = false;
                    z = false;
                }
                intent.removeExtra("com.facebook.fragment.PUSH_BACK_STACK");
                intent.removeExtra("com.facebook.fragment.CLEAR_BACK_STACK");
                abstractNavigableFragmentController.m3532a(className, intent.getExtras(), z, z2, i2, i3, i4, i);
            }
        } else if ("com.facebook.fragment.BACK_ACTION".equals(intent.getAction())) {
            abstractNavigableFragmentController.aq();
        } else {
            abstractNavigableFragmentController.f2440d.m3545a(navigableFragment, intent);
        }
    }

    private void m3532a(String str, Bundle bundle, boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int i5 = this.f2442f;
        this.f2442f = i5 + 1;
        String valueOf = String.valueOf(i5);
        this.f2438b = Fragment.a(getContext(), str, bundle);
        ((NavigableFragment) this.f2438b).mo563a(this.f2439c);
        if (z2) {
            s().a(null, 1);
        }
        ImmutableList a = this.f2441e.m3546a(valueOf, z, z2);
        if (!a.isEmpty()) {
            FragmentTransaction a2 = s().a();
            int size = a.size();
            for (int i6 = 0; i6 < size; i6++) {
                Fragment a3 = s().a((String) a.get(i6));
                if (a3 != null) {
                    a2.a(a3);
                }
            }
            a2.b();
        }
        FragmentTransaction b = s().a().a(i, i2, i3, i4).b(2131563642, this.f2438b, valueOf);
        if (z) {
            b.a(null);
        }
        b.b();
    }
}
