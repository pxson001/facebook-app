package com.facebook.greetingcards.render;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.fbui.draggable.Direction;
import com.facebook.greetingcards.render.FoldingPopoverFragment.BackPressAwareFragment;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.popover.BasePopoverDelegate;
import com.facebook.widget.popover.PopoverFragment;
import com.facebook.widget.popover.PopoverFragment.DefaultPopoverDelegate;

/* compiled from: youxswJohjohyyy */
public class GreetingCardPopoverFragment extends PopoverFragment implements SafelyDismissable {
    public BackPressAwareFragment am;
    private BasePopoverDelegate an;
    public AnalyticsLogger ao;
    private StatusBarVisibilityController ap;
    private boolean aq;

    /* compiled from: youxswJohjohyyy */
    class C00341 extends DefaultPopoverDelegate {
        final /* synthetic */ GreetingCardPopoverFragment f200b;

        C00341(GreetingCardPopoverFragment greetingCardPopoverFragment) {
            this.f200b = greetingCardPopoverFragment;
            super(greetingCardPopoverFragment);
        }

        public final boolean m220a(float f, float f2, Direction direction) {
            return false;
        }
    }

    public static void m222a(Object obj, Context context) {
        ((GreetingCardPopoverFragment) obj).ao = AnalyticsLoggerMethodAutoProvider.a(FbInjector.get(context));
    }

    public static GreetingCardPopoverFragment m221a(RenderCardFragment renderCardFragment, FragmentManager fragmentManager, Window window, View view) {
        GreetingCardPopoverFragment greetingCardPopoverFragment = new GreetingCardPopoverFragment();
        greetingCardPopoverFragment.am = renderCardFragment;
        PopoverFragment popoverFragment = greetingCardPopoverFragment;
        popoverFragment.a(fragmentManager, window, view);
        return popoverFragment;
    }

    public final void m227a(BackPressAwareFragment backPressAwareFragment) {
        this.am = backPressAwareFragment;
        s().a().b(2131560065, backPressAwareFragment).b();
    }

    public final void m226a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -473590108);
        super.a(bundle);
        Class cls = GreetingCardPopoverFragment.class;
        m222a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -676823982, a);
    }

    public final View m225a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1617623476);
        View a2 = super.a(layoutInflater, viewGroup, bundle);
        this.ap = new StatusBarVisibilityController(this.f.getWindow());
        this.ap.m266a();
        if (this.am != null) {
            m227a(this.am);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -702474974, a);
        return a2;
    }

    public final void m223G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 788216565);
        super.G();
        if (this.aq) {
            a();
            this.aq = false;
        }
        if (this.ap != null) {
            this.ap.m266a();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1053564685, a);
    }

    public final void aq() {
        this.aq = true;
    }

    public final boolean O_() {
        if (this.am == null || !this.am.mo6e()) {
            this.ap.m267b();
            super.O_();
        }
        return true;
    }

    protected final boolean aw() {
        return false;
    }

    public final void m224I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1303816055);
        super.I();
        HoneyClientEventFast a2 = this.ao.a("greeting_card_dismissed", false);
        if (a2.a()) {
            a2.b();
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -740440285, a);
    }

    protected final BasePopoverDelegate at() {
        if (this.an == null) {
            this.an = new C00341(this);
        }
        return this.an;
    }

    protected final int as() {
        return 2130904756;
    }
}
