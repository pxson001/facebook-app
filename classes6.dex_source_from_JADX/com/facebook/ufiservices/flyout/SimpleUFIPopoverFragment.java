package com.facebook.ufiservices.flyout;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.analytics.tagging.AnalyticsFragmentWithExtraData;
import com.facebook.debug.fps.FrameRateLogger;
import com.facebook.debug.fps.FrameRateLoggerProvider;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEvent;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEvent;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.popover.BasePopoverDelegate;
import com.facebook.widget.popover.SimplePopoverFragment;
import com.facebook.widget.popover.SimplePopoverFragment.DefaultPopoverDelegate;
import com.google.common.base.Absent;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: d3f70c95a1a677a551e21d11c31dd721 */
public class SimpleUFIPopoverFragment extends SimplePopoverFragment implements AnalyticsFragment, AnalyticsFragmentWithExtraData, PopoverFragmentContainer {
    public static final String ar = SimpleUFIPopoverFragment.class.getName();
    @Inject
    public FlyoutEventBus an;
    @Inject
    public FrameRateLoggerProvider ao;
    @Inject
    public UFIPopoverHelper ap;
    @Inject
    public FlyoutUtil aq;
    public UFIContentFragment as;
    public FrameRateLogger at;
    private BasePopoverDelegate au;

    /* compiled from: d3f70c95a1a677a551e21d11c31dd721 */
    class C13141 extends DefaultPopoverDelegate {
        final /* synthetic */ SimpleUFIPopoverFragment f18104b;

        C13141(SimpleUFIPopoverFragment simpleUFIPopoverFragment) {
            this.f18104b = simpleUFIPopoverFragment;
            super(simpleUFIPopoverFragment);
        }

        public final boolean mo1358a(float f, float f2, Direction direction) {
            UFIContentFragment as = this.f18104b.as();
            if (as != null) {
                return as.mo1348a(f, f2, direction);
            }
            return true;
        }

        public final void mo1357a() {
            if (this.f18104b.at != null) {
                this.f18104b.at.a();
            }
            super.mo1357a();
            UFIContentFragment as = this.f18104b.as();
            if (as != null) {
                as.mo1355e();
            }
        }

        public final void mo1359b() {
            if (this.f18104b.at != null) {
                this.f18104b.at.b();
            }
            UFIContentFragment as = this.f18104b.as();
            if (as != null) {
                as.aq();
            }
            super.mo1359b();
        }
    }

    public static void m26591a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SimpleUFIPopoverFragment simpleUFIPopoverFragment = (SimpleUFIPopoverFragment) obj;
        FlyoutEventBus a = FlyoutEventBus.a(fbInjector);
        FrameRateLoggerProvider frameRateLoggerProvider = (FrameRateLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(FrameRateLoggerProvider.class);
        UFIPopoverHelper b = UFIPopoverHelper.m26636b(fbInjector);
        FlyoutUtil a2 = FlyoutUtil.m26559a(fbInjector);
        simpleUFIPopoverFragment.an = a;
        simpleUFIPopoverFragment.ao = frameRateLoggerProvider;
        simpleUFIPopoverFragment.ap = b;
        simpleUFIPopoverFragment.aq = a2;
    }

    public final void mo1363a(UFIContentFragment uFIContentFragment) {
        m26590a(uFIContentFragment, true);
    }

    public final void dC_() {
        mo1366b(as().at());
    }

    public final void mo1366b(@Nullable View view) {
        if (view != null) {
            super.mo1366b(view);
        }
    }

    private void m26590a(UFIContentFragment uFIContentFragment, boolean z) {
        int i;
        int i2 = 0;
        this.as = uFIContentFragment;
        if (as() != null) {
            as().as();
            if (z) {
                as().mo1353b(mo1368f());
                m26592c(this.T);
            }
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

    public final View mo1368f() {
        ViewGroup viewGroup = (ViewGroup) e(2131562860);
        if (viewGroup.getChildCount() > 0) {
            return viewGroup.getChildAt(0);
        }
        return null;
    }

    protected final BasePopoverDelegate ar() {
        if (this.au == null) {
            this.au = new C13141(this);
        }
        return this.au;
    }

    public final UFIContentFragment as() {
        return (UFIContentFragment) s().a(2131560065);
    }

    private void m26592c(View view) {
        if (ap()) {
            KeyboardUtils.a(getContext(), view);
        }
    }

    protected final boolean aq() {
        if (this.ap == null) {
            return true;
        }
        return this.ap.m26638a();
    }

    protected final void mo1361a(Dialog dialog) {
        this.ap.m26637a(dialog);
    }

    public final String am_() {
        return "story_feedback_flyout";
    }

    public final Map<String, Object> m26599c() {
        return UFIPopoverHelper.m26635a(this.as, as());
    }

    public final boolean O_() {
        if (as() == null || !as().mo1354b()) {
            if (s().f() > 1) {
                s().d();
                as().mo1353b(mo1368f());
            } else {
                super.O_();
            }
        }
        return true;
    }

    public final void mo1362a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1601072511);
        super.mo1362a(bundle);
        Class cls = SimpleUFIPopoverFragment.class;
        m26591a((Object) this, getContext());
        if (this.as != null) {
            m26590a(this.as, false);
            this.at = this.ao.a(Boolean.valueOf(false), this.as.ar(), Absent.INSTANCE);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1850121771, a);
    }

    public final void m26600d(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 189873609);
        super.d(bundle);
        this.aq.f18076a = false;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -332927695, a);
    }

    public final void m26593G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1310231804);
        super.G();
        this.aq.f18076a = true;
        this.an.a(new FlyoutOnResumeEvent());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1838351361, a);
    }

    public final void m26594a() {
        m26592c(this.T);
        this.an.a(new FlyoutOnDismissEvent());
        super.a();
    }
}
