package com.facebook.widget.popover;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import com.facebook.widget.popover.SimplePopoverLayout.C14891;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: d48636a37c4bb0ea53bfc9dd2066e9cf */
public class SimplePopoverFragment extends FbDialogFragment {
    @Inject
    @ForUiThread
    public Handler am;
    public boolean an = true;
    public BasePopoverDelegate ao;
    public SimplePopoverLayout ap;
    public Runnable aq;

    /* compiled from: d48636a37c4bb0ea53bfc9dd2066e9cf */
    public class DefaultPopoverDelegate extends BasePopoverDelegate {
        final /* synthetic */ SimplePopoverFragment f18103a;

        protected DefaultPopoverDelegate(SimplePopoverFragment simplePopoverFragment) {
            this.f18103a = simplePopoverFragment;
        }

        public final void mo1356d() {
            this.f18103a.a();
        }
    }

    /* compiled from: d48636a37c4bb0ea53bfc9dd2066e9cf */
    class C14881 implements Runnable {
        final /* synthetic */ SimplePopoverFragment f19825a;

        C14881(SimplePopoverFragment simplePopoverFragment) {
            this.f19825a = simplePopoverFragment;
        }

        public void run() {
            this.f19825a.ao.mo1359b();
            this.f19825a.aq = null;
        }
    }

    /* compiled from: d48636a37c4bb0ea53bfc9dd2066e9cf */
    public class PopoverDialog extends FbDialog {
        final /* synthetic */ SimplePopoverFragment f19826b;

        public PopoverDialog(SimplePopoverFragment simplePopoverFragment) {
            this.f19826b = simplePopoverFragment;
            super(simplePopoverFragment, simplePopoverFragment.getContext(), simplePopoverFragment.d());
        }

        public void onBackPressed() {
            this.f19826b.O_();
        }
    }

    public static void m26582a(Object obj, Context context) {
        ((SimplePopoverFragment) obj).am = Handler_ForUiThreadMethodAutoProvider.b(FbInjector.get(context));
    }

    public void mo1362a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 82750325);
        super.a(bundle);
        Class cls = SimplePopoverFragment.class;
        m26582a(this, getContext());
        this.ao = ar();
        if (!this.an) {
            this.aq = new C14881(this);
            HandlerDetour.b(this.am, this.aq, 550, -969650559);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1972277104, a);
    }

    public final void m26583I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -79876858);
        super.I();
        if (this.aq != null) {
            HandlerDetour.a(this.am, this.aq);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -156282667, a);
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 21963309);
        super.mi_();
        if (!(this.f == null || this.f.getWindow() == null)) {
            this.f.getWindow().addFlags(2);
            this.f.getWindow().setDimAmount(0.7f);
        }
        if (this.an) {
            SimplePopoverLayout simplePopoverLayout = this.ap;
            Animation loadAnimation = AnimationUtils.loadAnimation(simplePopoverLayout.getContext(), 2130968770);
            loadAnimation.setAnimationListener(new C14891(simplePopoverLayout));
            simplePopoverLayout.f19836g.startAnimation(loadAnimation);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -619545821, a);
    }

    protected void mo1366b(View view) {
        if (this.ap != null) {
            SimplePopoverLayout simplePopoverLayout = this.ap;
            Preconditions.checkState(simplePopoverLayout.f19835f.isPresent(), "In order to set the footer, the footer needs to be in the layout.");
            if (simplePopoverLayout.f19835f.isPresent()) {
                ((ViewGroup) simplePopoverLayout.f19835f.get()).removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ((ViewGroup) simplePopoverLayout.f19835f.get()).addView(view);
        }
    }

    public boolean O_() {
        if (this.an) {
            this.ap.m28552f();
        } else {
            a();
        }
        return true;
    }

    public final Dialog m26588c(@Nullable Bundle bundle) {
        Dialog popoverDialog = new PopoverDialog(this);
        if (!aq()) {
            mo1361a(popoverDialog);
        }
        return popoverDialog;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f;
        if (!aq() && dialog != null && dialog.isShowing()) {
            mo1361a(dialog);
        }
    }

    protected void mo1361a(Dialog dialog) {
        PopoverUtil.m28514a(dialog);
    }

    protected boolean aq() {
        return true;
    }

    protected BasePopoverDelegate ar() {
        return new DefaultPopoverDelegate(this);
    }

    public final int m26589d() {
        return this.an ? aq() ? 2131625656 : 2131625658 : aq() ? 2131625659 : 2131625660;
    }

    public final View m26584a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -528415122);
        SimplePopoverLayout simplePopoverLayout = new SimplePopoverLayout(getContext(), 2130906342);
        simplePopoverLayout.f19833d = this.ao;
        this.ap = simplePopoverLayout;
        simplePopoverLayout = this.ap;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1688313139, a);
        return simplePopoverLayout;
    }
}
