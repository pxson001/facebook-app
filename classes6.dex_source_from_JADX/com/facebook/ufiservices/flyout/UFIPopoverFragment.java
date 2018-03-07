package com.facebook.ufiservices.flyout;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.eventlisteners.AnalyticsNavigationListenerDispatcher;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.device.yearclass.YearClass;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEvent;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEvent;
import com.facebook.ufiservices.qe.UfiFlyoutQuickExperimentController;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.popover.BasePopoverDelegate;
import com.facebook.widget.popover.PopoverFragment;
import com.facebook.widget.popover.PopoverFragment.DefaultPopoverDelegate;
import com.google.common.base.Absent;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: d06e726fe380e7b53c20c2d19d7f5a52 */
public class UFIPopoverFragment extends PopoverFragment implements AnalyticsFragment, AnalyticsFragmentWithExtraData, PopoverFragmentContainer {
    private BasePopoverDelegate am;
    private FlyoutEventBus an;
    private FlyoutUtil ao;
    public UFIContentFragment ap;
    private UfiFlyoutQuickExperimentController aq;
    private AnalyticsNavigationListenerDispatcher ar;
    public FrameRateLogger as;
    private FrameRateLoggerProvider at;
    private UFIPopoverHelper au;

    /* compiled from: d06e726fe380e7b53c20c2d19d7f5a52 */
    class C13151 extends DefaultPopoverDelegate {
        final /* synthetic */ UFIPopoverFragment f18107b;

        C13151(UFIPopoverFragment uFIPopoverFragment) {
            this.f18107b = uFIPopoverFragment;
            super(uFIPopoverFragment);
        }

        public final boolean mo1358a(float f, float f2, Direction direction) {
            UFIContentFragment aD = this.f18107b.aD();
            if (aD != null) {
                return aD.mo1348a(f, f2, direction);
            }
            return true;
        }

        public final void mo1357a() {
            this.f18107b.as.a();
            super.mo1357a();
            UFIContentFragment aD = this.f18107b.aD();
            if (aD != null) {
                PopoverFragment popoverFragment = this.f18107b;
                if (!(popoverFragment.ap == null || popoverFragment.ar == null)) {
                    popoverFragment.ar.setScaleX(1.0f);
                    popoverFragment.ar.setScaleY(1.0f);
                }
                aD.mo1355e();
            }
        }

        public final void mo1359b() {
            this.f18107b.as.b();
            UFIContentFragment aD = this.f18107b.aD();
            if (aD != null) {
                aD.aq();
            }
            super.mo1359b();
        }
    }

    public static void m26622a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((UFIPopoverFragment) obj).m26620a(AnalyticsNavigationListenerDispatcher.a(fbInjector), FlyoutEventBus.a(fbInjector), FlyoutUtil.m26559a(fbInjector), UfiFlyoutQuickExperimentController.m26781b(fbInjector), (FrameRateLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class), UFIPopoverHelper.m26636b(fbInjector));
    }

    @Inject
    private void m26620a(AnalyticsNavigationListenerDispatcher analyticsNavigationListenerDispatcher, FlyoutEventBus flyoutEventBus, FlyoutUtil flyoutUtil, UfiFlyoutQuickExperimentController ufiFlyoutQuickExperimentController, FrameRateLoggerProvider frameRateLoggerProvider, UFIPopoverHelper uFIPopoverHelper) {
        this.ar = analyticsNavigationListenerDispatcher;
        this.an = flyoutEventBus;
        this.ao = flyoutUtil;
        this.aq = ufiFlyoutQuickExperimentController;
        this.at = frameRateLoggerProvider;
        this.au = uFIPopoverHelper;
    }

    public final void mo1373a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -618335560);
        super.mo1373a(bundle);
        Class cls = UFIPopoverFragment.class;
        m26622a((Object) this, getContext());
        if (this.ap != null) {
            m26621a(this.ap, false);
            this.as = this.at.a(Boolean.valueOf(false), this.ap.ar(), Absent.INSTANCE);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -822963159, a);
    }

    public final Dialog mo1378c(Bundle bundle) {
        Dialog c = super.mo1378c(bundle);
        c.getWindow().setSoftInputMode(16);
        return c;
    }

    public final void m26633d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1070258686);
        super.d(bundle);
        this.ao.f18076a = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 892310585, a);
    }

    public final void mo1370G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 624141091);
        super.mo1370G();
        this.ao.f18076a = true;
        this.an.a(new FlyoutOnResumeEvent());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2084954176, a);
    }

    public final void m26625H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1874190094);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 771893087, a);
    }

    public final void mo1371I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -491105419);
        this.ap = null;
        super.mo1371I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1212734607, a);
    }

    public final boolean O_() {
        if (aD() == null || !aD().mo1354b()) {
            if (s().f() > 1) {
                s().d();
                aD().mo1353b(mo1368f());
            } else {
                super.O_();
            }
        }
        return true;
    }

    protected final void mo1372a(Dialog dialog) {
        this.au.m26637a(dialog);
    }

    protected final BasePopoverDelegate at() {
        if (this.am == null) {
            this.am = new C13151(this);
        }
        return this.am;
    }

    public final void dC_() {
        mo1377b(aD().at());
    }

    public final void mo1363a(UFIContentFragment uFIContentFragment) {
        m26621a(uFIContentFragment, true);
    }

    private void m26621a(UFIContentFragment uFIContentFragment, boolean z) {
        int i;
        int i2 = 0;
        this.ap = uFIContentFragment;
        if (aD() != null) {
            aD().as();
        }
        if (z) {
            aD().mo1353b(mo1368f());
            m26623c(this.T);
        }
        FragmentTransaction a = s().a();
        if (z) {
            i = 2130968649;
        } else {
            i = 0;
        }
        if (z) {
            i2 = 2130968695;
        }
        a.a(i, 2130968694, 2130968648, i2).b(2131560065, (Fragment) uFIContentFragment, "ufi:popover:content:fragment:tag").a(null).b();
    }

    protected final boolean aB() {
        if (this.au == null) {
            return true;
        }
        return this.au.m26638a();
    }

    public final void mo1377b(@Nullable View view) {
        if (view != null) {
            super.mo1377b(view);
        }
    }

    public final View mo1368f() {
        ViewGroup viewGroup = (ViewGroup) e(2131562860);
        if (viewGroup.getChildCount() > 0) {
            return viewGroup.getChildAt(0);
        }
        return null;
    }

    private void m26623c(View view) {
        if (ap()) {
            KeyboardUtils.a(getContext(), view);
        }
    }

    public final String am_() {
        return "story_feedback_flyout";
    }

    public final Map<String, Object> m26632c() {
        return UFIPopoverHelper.m26635a(this.ap, aD());
    }

    protected final boolean av() {
        if (super.av()) {
            if ((YearClass.a(this.aq.f18249a) >= 2011 ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final UFIContentFragment aD() {
        return (UFIContentFragment) s().a(2131560065);
    }

    public void mE_() {
        m26623c(this.T);
        super.mE_();
        this.an.a(new FlyoutOnDismissEvent());
    }
}
