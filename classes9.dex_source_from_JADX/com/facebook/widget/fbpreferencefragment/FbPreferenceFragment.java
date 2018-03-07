package com.facebook.widget.fbpreferencefragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: group_user */
public abstract class FbPreferenceFragment extends FbFragment {
    private PreferenceManager f13758a;
    public ListView f13759b;
    private boolean f13760c;
    private boolean f13761d;
    private Handler f13762e;
    private final Runnable f13763f = new C24141(this);

    /* compiled from: group_user */
    class C24141 implements Runnable {
        final /* synthetic */ FbPreferenceFragment f20529a;

        C24141(FbPreferenceFragment fbPreferenceFragment) {
            this.f20529a = fbPreferenceFragment;
        }

        public void run() {
            this.f20529a.f13759b.focusableViewAvailable(this.f20529a.f13759b);
        }
    }

    /* compiled from: group_user */
    class C24152 extends Handler {
        final /* synthetic */ FbPreferenceFragment f20530a;

        C24152(FbPreferenceFragment fbPreferenceFragment) {
            this.f20530a = fbPreferenceFragment;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f20530a.m14323e();
                    return;
                default:
                    return;
            }
        }
    }

    public void mo542c(Bundle bundle) {
        super.c(bundle);
        this.f13762e = new C24152(this);
        this.f13758a = PreferenceManagerCompat.m20075a(getContext());
    }

    public final View m14325a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 906525091, Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -899127106));
        return null;
    }

    public final void m14328d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 937828973);
        super.d(bundle);
        if (this.f13760c) {
            m14323e();
        }
        this.f13761d = true;
        if (bundle != null) {
            Bundle bundle2 = bundle.getBundle("android:preferences");
            if (bundle2 != null) {
                PreferenceScreen b = mo541b();
                if (b != null) {
                    b.restoreHierarchyState(bundle2);
                }
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2027702677, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1335437561);
        super.mj_();
        PreferenceManagerCompat.m20078b(this.f13758a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 357159160, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -734800337);
        this.f13759b = null;
        HandlerDetour.a(this.f13762e, this.f13763f);
        this.f13762e.removeMessages(1);
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 247736955, a);
    }

    public void mo543I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -537788257);
        super.I();
        PreferenceManagerCompat.m20079c(this.f13758a);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1167204991, a);
    }

    public final void m14329e(Bundle bundle) {
        super.e(bundle);
        PreferenceScreen b = mo541b();
        if (b != null) {
            Bundle bundle2 = new Bundle();
            b.saveHierarchyState(bundle2);
            bundle.putBundle("android:preferences", bundle2);
        }
    }

    public void mo548a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        PreferenceManagerCompat.m20077a(this.f13758a, i, i2, intent);
    }

    private PreferenceScreen mo541b() {
        return PreferenceManagerCompat.m20076a(this.f13758a);
    }

    private void m14323e() {
        PreferenceScreen b = mo541b();
        if (b != null) {
            b.bind(aq());
        }
    }

    private ListView aq() {
        ar();
        return this.f13759b;
    }

    private void ar() {
        if (this.f13759b == null) {
            View view = this.T;
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            view = view.findViewById(16908298);
            if (view instanceof ListView) {
                this.f13759b = (ListView) view;
                if (this.f13759b == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                }
                HandlerDetour.a(this.f13762e, this.f13763f, 1765350303);
                return;
            }
            throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
        }
    }
}
