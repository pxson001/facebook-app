package com.facebook.platform.composer.composer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.platform.composer.targetprivacy.PlatformComposerFriendSearchFragment;
import com.facebook.platform.composer.targetprivacy.PlatformComposerGroupSearchFragment;
import com.facebook.platform.composer.targetprivacy.PlatformComposerPrivacySearchFragment;
import com.facebook.platform.composer.targetprivacy.PlatformComposerProfileSearchFragment;
import com.facebook.platform.composer.targetprivacy.PlatformComposerTargetPrivacySelectorFragment;
import com.facebook.privacy.model.SelectablePrivacyData;
import java.util.Stack;
import javax.annotation.Nullable;

/* compiled from: rich_document_startup_tasks_complete */
public class PlatformComposerControllerFragment extends FbFragment {
    private Stack<FbFragment> f4007a;
    public PlatformComposerFragment f4008b;
    public C05094 f4009c;
    public PlatformComposerTargetPrivacySelectorFragment f4010d;
    public final C05061 f4011e = new C05061(this);
    public final C05072 f4012f = new C05072(this);
    public final C05083 f4013g = new C05083(this);

    /* compiled from: rich_document_startup_tasks_complete */
    public class C05061 {
        final /* synthetic */ PlatformComposerControllerFragment f4003a;

        C05061(PlatformComposerControllerFragment platformComposerControllerFragment) {
            this.f4003a = platformComposerControllerFragment;
        }

        public final void m3966a(ComposerTargetData composerTargetData) {
            this.f4003a.f4012f.m3967a(composerTargetData);
        }
    }

    /* compiled from: rich_document_startup_tasks_complete */
    public class C05072 {
        final /* synthetic */ PlatformComposerControllerFragment f4004a;

        C05072(PlatformComposerControllerFragment platformComposerControllerFragment) {
            this.f4004a = platformComposerControllerFragment;
        }

        public final void m3967a(ComposerTargetData composerTargetData) {
            FragmentTransaction a = this.f4004a.D.a();
            a.a((Fragment) PlatformComposerControllerFragment.m3971e(this.f4004a).peek());
            while (!PlatformComposerControllerFragment.m3971e(this.f4004a).isEmpty() && !(PlatformComposerControllerFragment.m3971e(this.f4004a).peek() instanceof PlatformComposerFragment)) {
                PlatformComposerControllerFragment.m3971e(this.f4004a).pop();
            }
            if (!PlatformComposerControllerFragment.m3971e(this.f4004a).isEmpty() && (PlatformComposerControllerFragment.m3971e(this.f4004a).peek() instanceof PlatformComposerFragment)) {
                a.a(2131566100, (Fragment) PlatformComposerControllerFragment.m3971e(this.f4004a).peek());
            }
            a.b();
            this.f4004a.f4008b.m4079a(composerTargetData, null);
        }
    }

    /* compiled from: rich_document_startup_tasks_complete */
    public class C05083 {
        final /* synthetic */ PlatformComposerControllerFragment f4005a;

        C05083(PlatformComposerControllerFragment platformComposerControllerFragment) {
            this.f4005a = platformComposerControllerFragment;
        }

        public final void m3968a(SelectablePrivacyData selectablePrivacyData) {
            if ((PlatformComposerControllerFragment.m3971e(this.f4005a).peek() instanceof PlatformComposerFragment) && this.f4005a.f4008b != null) {
                this.f4005a.f4008b.bC.a(selectablePrivacyData);
            }
        }
    }

    /* compiled from: rich_document_startup_tasks_complete */
    public class C05094 {
        final /* synthetic */ PlatformComposerControllerFragment f4006a;

        public C05094(PlatformComposerControllerFragment platformComposerControllerFragment) {
            this.f4006a = platformComposerControllerFragment;
        }

        public final void m3969a(int i) {
            switch (i) {
                case 20:
                    PlatformComposerControllerFragment platformComposerControllerFragment = this.f4006a;
                    return;
                case 70:
                    PlatformComposerControllerFragment.aw(this.f4006a);
                    return;
                case 80:
                    PlatformComposerControllerFragment.ay(this.f4006a);
                    return;
                case 90:
                    PlatformComposerControllerFragment.ax(this.f4006a);
                    return;
                case 100:
                    PlatformComposerControllerFragment.az(this.f4006a);
                    return;
                default:
                    return;
            }
        }
    }

    public final View m3972a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 783766155);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906301, viewGroup, false);
        FragmentTransaction a2 = this.D.a();
        Bundle bundle2 = this.s;
        PlatformComposerFragment platformComposerFragment = new PlatformComposerFragment();
        platformComposerFragment.g(bundle2);
        this.f4008b = platformComposerFragment;
        PlatformComposerFragment platformComposerFragment2 = this.f4008b;
        if (this.f4009c == null) {
            this.f4009c = new C05094(this);
        }
        platformComposerFragment2.bB = this.f4009c;
        a2.a(2131566100, this.f4008b);
        a2.b();
        m3971e(this).clear();
        m3971e(this).push(this.f4008b);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -911994690, a);
        return viewGroup2;
    }

    public static Stack m3971e(PlatformComposerControllerFragment platformComposerControllerFragment) {
        if (platformComposerControllerFragment.f4007a == null) {
            platformComposerControllerFragment.f4007a = new Stack();
        }
        return platformComposerControllerFragment.f4007a;
    }

    public final void m3973b() {
        if (!m3971e(this).isEmpty()) {
            FbFragment fbFragment = (FbFragment) m3971e(this).peek();
            if (fbFragment instanceof PlatformComposerFragment) {
                ((PlatformComposerFragment) fbFragment).ar();
            } else if (!(fbFragment instanceof PlatformComposerTargetPrivacySelectorFragment) || !((PlatformComposerTargetPrivacySelectorFragment) fbFragment).m4285b()) {
                FragmentManager fragmentManager = this.D;
                fragmentManager.b(null, 1);
                FragmentTransaction a = fragmentManager.a();
                a.a(fbFragment);
                m3971e(this).pop();
                if (!m3971e(this).isEmpty()) {
                    a.a(2131566100, (Fragment) m3971e(this).peek());
                }
                a.b();
                if (m3971e(this).peek() instanceof PlatformComposerTargetPrivacySelectorFragment) {
                    av();
                }
            }
        }
    }

    private void av() {
        View currentFocus = o().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) o().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    public static void aw(PlatformComposerControllerFragment platformComposerControllerFragment) {
        platformComposerControllerFragment.av();
        if (platformComposerControllerFragment.f4010d == null) {
            platformComposerControllerFragment.f4010d = new PlatformComposerTargetPrivacySelectorFragment();
            platformComposerControllerFragment.f4010d.av = platformComposerControllerFragment.f4011e;
            platformComposerControllerFragment.f4010d.ap = platformComposerControllerFragment.f4012f;
            platformComposerControllerFragment.f4010d.aq = platformComposerControllerFragment.f4013g;
            platformComposerControllerFragment.f4010d.as = platformComposerControllerFragment.f4008b.bA;
            platformComposerControllerFragment.f4010d.ar = platformComposerControllerFragment.f4008b.bD;
            platformComposerControllerFragment.f4010d.f4396e = platformComposerControllerFragment.f4009c;
        }
        PlatformComposerTargetPrivacySelectorFragment platformComposerTargetPrivacySelectorFragment = platformComposerControllerFragment.f4010d;
        platformComposerTargetPrivacySelectorFragment.aw = false;
        platformComposerControllerFragment.m3970a(platformComposerTargetPrivacySelectorFragment);
    }

    private void m3970a(FbFragment fbFragment) {
        FbFragment fbFragment2 = (FbFragment) m3971e(this).peek();
        FragmentTransaction a = this.D.a();
        if (fbFragment2 != null) {
            a.a(fbFragment2);
        }
        if (fbFragment2 instanceof PlatformComposerTargetPrivacySelectorFragment) {
            ((PlatformComposerTargetPrivacySelectorFragment) fbFragment2).aw = true;
        }
        if (!fbFragment.mx_()) {
            a.a(2131566100, fbFragment);
        }
        a.b();
        m3971e(this).push(fbFragment);
    }

    public static void ax(PlatformComposerControllerFragment platformComposerControllerFragment) {
        Bundle bundle = platformComposerControllerFragment.s;
        PlatformComposerProfileSearchFragment platformComposerGroupSearchFragment = new PlatformComposerGroupSearchFragment();
        platformComposerGroupSearchFragment.g(bundle);
        PlatformComposerProfileSearchFragment platformComposerProfileSearchFragment = platformComposerGroupSearchFragment;
        platformComposerProfileSearchFragment.f4300a = platformComposerControllerFragment.f4011e;
        platformComposerControllerFragment.m3970a(platformComposerProfileSearchFragment);
    }

    public static void ay(PlatformComposerControllerFragment platformComposerControllerFragment) {
        Bundle bundle = platformComposerControllerFragment.s;
        PlatformComposerProfileSearchFragment platformComposerFriendSearchFragment = new PlatformComposerFriendSearchFragment();
        platformComposerFriendSearchFragment.g(bundle);
        PlatformComposerProfileSearchFragment platformComposerProfileSearchFragment = platformComposerFriendSearchFragment;
        platformComposerProfileSearchFragment.f4300a = platformComposerControllerFragment.f4011e;
        platformComposerControllerFragment.m3970a(platformComposerProfileSearchFragment);
    }

    public static void az(PlatformComposerControllerFragment platformComposerControllerFragment) {
        Bundle bundle = platformComposerControllerFragment.s;
        PlatformComposerPrivacySearchFragment platformComposerPrivacySearchFragment = new PlatformComposerPrivacySearchFragment();
        platformComposerPrivacySearchFragment.g(bundle);
        PlatformComposerPrivacySearchFragment platformComposerPrivacySearchFragment2 = platformComposerPrivacySearchFragment;
        platformComposerPrivacySearchFragment2.f4379e = platformComposerControllerFragment.f4012f;
        platformComposerPrivacySearchFragment2.f4378d = platformComposerControllerFragment.f4013g;
        platformComposerPrivacySearchFragment2.f4377c = platformComposerControllerFragment.f4008b.bA;
        platformComposerControllerFragment.m3970a(platformComposerPrivacySearchFragment2);
    }
}
