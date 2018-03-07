package com.facebook.ui.drawers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomFrameLayout;
import javax.annotation.Nullable;

/* compiled from: enter_cropping */
public class BackStackFragment extends FbFragment {
    private DefaultAndroidThreadUtil f15250a;
    public DrawerFragmentContentController f15251b;
    public View f15252c = null;
    private boolean f15253d = false;

    /* compiled from: enter_cropping */
    class C11431 implements Runnable {
        final /* synthetic */ BackStackFragment f15249a;

        C11431(BackStackFragment backStackFragment) {
            this.f15249a = backStackFragment;
        }

        public void run() {
            if (this.f15249a.f15252c != null) {
                FrameLayout frameLayout = (FrameLayout) this.f15249a.f15252c.getParent();
                if (frameLayout != null) {
                    frameLayout.removeView(this.f15249a.f15252c);
                }
                this.f15249a.f15252c = null;
            }
        }
    }

    public final void m19239c(@Nullable Bundle bundle) {
        super.c(bundle);
        this.f15250a = DefaultAndroidThreadUtil.b(an());
    }

    public final View m19236a(LayoutInflater layoutInflater, ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1226430565);
        int b = m19233b();
        if (b == -1) {
            IllegalStateException illegalStateException = new IllegalStateException("Can't create a BackStackFragment without a viewId");
            Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -690048929, a);
            throw illegalStateException;
        }
        CustomFrameLayout customFrameLayout = new CustomFrameLayout(layoutInflater.getContext());
        customFrameLayout.setId(b);
        if (this.f15251b != null && s().a(m19233b()) == null) {
            this.f15252c = this.f15251b.b(this.f15251b.c);
            if (this.f15252c != null) {
                customFrameLayout.addView(this.f15252c);
            }
        }
        LogUtils.f(50510004, a);
        return customFrameLayout;
    }

    public final void m19237a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.f15251b != null) {
            this.f15251b.a(this, this.f15253d);
        }
    }

    public final void m19234G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2142400988);
        super.G();
        if (this.f15251b != null) {
            this.f15251b.o();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1216319715, a);
    }

    public final void m19235H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1046896505);
        if (this.f15251b != null) {
            this.f15251b.n();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1961595344, a);
    }

    public final void m19238b(Fragment fragment) {
        if (this.f15252c != null) {
            this.f15250a.b(new C11431(this));
        }
        s().a().a(m19233b(), fragment).b();
    }

    private int m19233b() {
        return this.s.getInt("argument_stack_container_id", -1);
    }
}
