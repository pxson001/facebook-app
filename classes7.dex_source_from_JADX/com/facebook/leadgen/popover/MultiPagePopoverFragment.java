package com.facebook.leadgen.popover;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEvent;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEvent;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.popover.BasePopoverDelegate;
import com.facebook.widget.popover.PopoverFragment;
import com.facebook.widget.popover.PopoverFragment.DefaultPopoverDelegate;
import com.google.common.annotations.VisibleForTesting;
import java.util.List;
import javax.inject.Inject;

/* compiled from: photo_remix */
public class MultiPagePopoverFragment extends PopoverFragment implements AnalyticsFragment {
    @Inject
    public FlyoutEventBus am;
    public View an;
    public MultiPageBaseContentFragment ao;
    private BasePopoverDelegate ap;
    public List<OnDismissListener> aq;

    /* compiled from: photo_remix */
    public class C05951 implements OnFocusChangeListener {
        final /* synthetic */ MultiPagePopoverFragment f6550a;

        public C05951(MultiPagePopoverFragment multiPagePopoverFragment) {
            this.f6550a = multiPagePopoverFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                MultiPagePopoverFragment.aE(this.f6550a);
            }
        }
    }

    /* compiled from: photo_remix */
    public class C05962 implements OnClickListener {
        final /* synthetic */ MultiPagePopoverFragment f6551a;

        public C05962(MultiPagePopoverFragment multiPagePopoverFragment) {
            this.f6551a = multiPagePopoverFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1509610662);
            view.requestFocus();
            Logger.a(2, EntryType.UI_INPUT_END, 1376077286, a);
        }
    }

    /* compiled from: photo_remix */
    class C05973 extends DefaultPopoverDelegate {
        final /* synthetic */ MultiPagePopoverFragment f6552b;

        C05973(MultiPagePopoverFragment multiPagePopoverFragment) {
            this.f6552b = multiPagePopoverFragment;
            super(multiPagePopoverFragment);
        }

        public final boolean m8491a(float f, float f2, Direction direction) {
            return false;
        }
    }

    public static void m8492a(Object obj, Context context) {
        ((MultiPagePopoverFragment) obj).am = FlyoutEventBus.a(FbInjector.get(context));
    }

    public final void m8495a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -893127174);
        super.a(bundle);
        Class cls = MultiPagePopoverFragment.class;
        m8492a(this, getContext());
        if (this.ao != null) {
            m8496a(this.ao);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1049520317, a);
    }

    public final View m8494a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1123306348);
        View a2 = super.a(layoutInflater, viewGroup, bundle);
        this.an = FindViewUtil.b(a2, 2131560065);
        this.an.setOnFocusChangeListener(new C05951(this));
        this.an.setOnClickListener(new C05962(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 875299896, a);
        return a2;
    }

    public final void m8493G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -390037795);
        super.G();
        this.am.a(new FlyoutOnResumeEvent());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -864510894, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 707108428);
        super.mY_();
        if (this.an != null) {
            this.an.setOnFocusChangeListener(null);
            this.an.setOnClickListener(null);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2020719341, a);
    }

    public final Dialog m8497c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.getWindow().setSoftInputMode(32);
        return c;
    }

    public final boolean O_() {
        if (aF() == null || !aF().mo342b()) {
            if (s().f() > 1) {
                s().d();
            } else {
                super.O_();
            }
        }
        return true;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.aq != null) {
            for (OnDismissListener onDismiss : this.aq) {
                onDismiss.onDismiss(dialogInterface);
            }
            this.aq.clear();
        }
    }

    public final void mE_() {
        aE(this);
        super.mE_();
        aF().mo343e();
        aF().aq();
        this.am.a(new FlyoutOnDismissEvent());
    }

    public final void m8496a(MultiPageBaseContentFragment multiPageBaseContentFragment) {
        this.ao = multiPageBaseContentFragment;
        aE(this);
        s().a().b(2131560065, (Fragment) multiPageBaseContentFragment).a(null).b();
    }

    public static void aE(MultiPagePopoverFragment multiPagePopoverFragment) {
        if (multiPagePopoverFragment.ap()) {
            KeyboardUtils.a(multiPagePopoverFragment.getContext(), multiPagePopoverFragment.T);
        }
    }

    protected final int as() {
        return 2130905350;
    }

    @VisibleForTesting
    private MultiPageBaseContentFragment aF() {
        return (MultiPageBaseContentFragment) s().a(2131560065);
    }

    public final String am_() {
        return "lead_gen";
    }

    protected final BasePopoverDelegate at() {
        if (this.ap == null) {
            this.ap = new C05973(this);
        }
        return this.ap;
    }
}
