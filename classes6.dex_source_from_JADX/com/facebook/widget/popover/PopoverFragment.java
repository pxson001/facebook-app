package com.facebook.widget.popover;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.util.ContextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.draggable.Direction;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.dialogs.FbDialogFragment.FbDialog;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: d174e471f802bbe05ccded2e11f3c116 */
public abstract class PopoverFragment extends FbDialogFragment {
    private static final String am = PopoverFragment.class.getSimpleName();
    public PopoverView an;
    public PopoverAnimationState ao;
    public Window ap;
    private Drawable aq;
    public View ar;
    public Lazy<NavigationLogger> as;
    private final BackgroundSpringListener at = new BackgroundSpringListener(this);
    public boolean au;
    public boolean av = true;

    /* compiled from: d174e471f802bbe05ccded2e11f3c116 */
    public class DefaultPopoverDelegate extends BasePopoverDelegate {
        final /* synthetic */ PopoverFragment f18106a;

        protected DefaultPopoverDelegate(PopoverFragment popoverFragment) {
            this.f18106a = popoverFragment;
        }

        public void mo1357a() {
            this.f18106a.ar();
        }

        public final void mo1369c() {
            this.f18106a.au = true;
        }

        public final void mo1356d() {
            this.f18106a.mE_();
        }
    }

    /* compiled from: d174e471f802bbe05ccded2e11f3c116 */
    class BackgroundSpringListener extends SimpleSpringListener {
        final /* synthetic */ PopoverFragment f19790a;

        public BackgroundSpringListener(PopoverFragment popoverFragment) {
            this.f19790a = popoverFragment;
        }

        public final void m28513a(Spring spring) {
            if (this.f19790a.av() && this.f19790a.ar != null) {
                float min = Math.min((float) (((Math.abs(spring.d()) / ((double) (this.f19790a.az().isYAxis() ? this.f19790a.an.getHeight() : this.f19790a.an.getWidth()))) * 0.050000011920928955d) + 0.949999988079071d), 1.0f);
                this.f19790a.ar.setScaleX(min);
                this.f19790a.ar.setScaleY(min);
            }
        }
    }

    /* compiled from: d174e471f802bbe05ccded2e11f3c116 */
    class PopoverDialog extends FbDialog {
        final /* synthetic */ PopoverFragment f19791b;

        public PopoverDialog(PopoverFragment popoverFragment) {
            this.f19791b = popoverFragment;
            super(popoverFragment, popoverFragment.getContext(), popoverFragment.d());
        }

        public void onBackPressed() {
            this.f19791b.O_();
        }

        public void show() {
            if (ContextUtils.a(getContext(), Activity.class) == null) {
                this.f19791b.ao.c();
            } else {
                super.show();
            }
        }
    }

    public static void m26608a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PopoverFragment popoverFragment = (PopoverFragment) obj;
        PopoverAnimationState a = PopoverAnimationState.a(fbInjector);
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 137);
        popoverFragment.ao = a;
        popoverFragment.as = b;
    }

    public void mo1373a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1420229529);
        super.a(bundle);
        Class cls = PopoverFragment.class;
        m26608a(this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1068229132, a);
    }

    public View m26611a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1107579311);
        PopoverView popoverView = new PopoverView(getContext(), as());
        popoverView.f19808j = at();
        popoverView = popoverView;
        popoverView.f19820v = aw();
        popoverView = popoverView;
        popoverView.f19821w = av();
        popoverView = popoverView;
        boolean aB = aB();
        popoverView.f19822x = aB;
        if (aB) {
            popoverView.f19810l.setAlpha(popoverView.f19821w ? 0 : 178);
        }
        popoverView = popoverView;
        popoverView.f19823y = ax();
        popoverView.f19800b.p = popoverView.f19823y;
        this.an = popoverView;
        if (aw()) {
            popoverView = this.an;
            popoverView.f19824z = ay();
            popoverView = popoverView;
            popoverView.f19796A = az();
            popoverView = popoverView;
            popoverView.f19797B = aA();
            popoverView = popoverView;
            popoverView.f19798C = 0.5d;
            popoverView = popoverView;
            popoverView.f19799D = 0.25d;
            popoverView.f19809k = this.at;
        }
        if (null != null) {
            this.an.m28531a(null);
        }
        if (!this.av) {
            this.an.f19820v = aw();
            this.an.f19796A = az();
            if (null != null) {
                this.an.m28531a(null);
            }
            this.an.m28540d();
            this.ao.b();
        }
        popoverView = this.an;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 511099639, a);
        return popoverView;
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 599341505);
        super.mY_();
        this.an.f19809k = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1520076005, a);
    }

    public Dialog mo1378c(@Nullable Bundle bundle) {
        Dialog popoverDialog = new PopoverDialog(this);
        if (!aB()) {
            mo1372a(popoverDialog);
        }
        return popoverDialog;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Dialog dialog = this.f;
        if (!aB() && dialog != null && dialog.isShowing()) {
            mo1372a(dialog);
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        mE_();
    }

    public void mE_() {
        this.ao.c();
        if (mv_() != null) {
            try {
                b();
            } catch (Throwable e) {
                BLog.b(am, "Null pointer exception while trying to dismiss the popover", e);
            }
        }
        if (this.ar != null) {
            this.ar.setScaleX(1.0f);
            this.ar.setScaleY(1.0f);
        }
    }

    public final void ar() {
        aI();
    }

    public final void m26619e(Bundle bundle) {
        if (this.au) {
            mE_();
        }
        super.e(bundle);
    }

    public void mo1370G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1898826011);
        super.G();
        aI();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -152458553, a);
    }

    public void mo1371I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 859881384);
        super.I();
        if (this.ap != null) {
            CustomViewUtils.b(this.ap.getDecorView(), this.aq);
        }
        this.an.f19808j = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1481427449, a);
    }

    public final void m26614a(FragmentManager fragmentManager, Window window, View view) {
        m26615a(fragmentManager, window, view, true);
    }

    public final void m26615a(FragmentManager fragmentManager, Window window, View view, boolean z) {
        if (fragmentManager.c()) {
            this.av = z;
            if (fragmentManager.c()) {
                a(2, d());
                a(fragmentManager, "chromeless:content:fragment:tag");
                if (this.av) {
                    fragmentManager.b();
                    this.an.f19820v = aw();
                    this.an.f19796A = az();
                    if (null != null) {
                        this.an.m28531a(null);
                    }
                    this.an.m28540d();
                    this.ao.b();
                }
            } else {
                String str = "Unsafe to commit stateful transactions.";
                getClass();
            }
            this.ar = view;
            this.ap = window;
            if (this.ap != null) {
                this.aq = this.ap.getDecorView().getBackground();
                return;
            }
            return;
        }
        String str2 = "Unsafe to commit stateful transactions.";
        getClass();
    }

    public boolean O_() {
        ((NavigationLogger) this.as.get()).a("tap_back_button");
        this.au = true;
        this.an.m28539c();
        return true;
    }

    public final int m26618d() {
        return aB() ? 2131625656 : 2131625658;
    }

    protected int as() {
        return 2130906342;
    }

    protected void mo1377b(View view) {
        if (this.an != null) {
            PopoverView popoverView = this.an;
            Preconditions.checkState(popoverView.f19813o.isPresent(), "In order to set the footer, the footer needs to be in the layout.");
            if (popoverView.f19813o.isPresent()) {
                ((ViewGroup) popoverView.f19813o.get()).removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            ((ViewGroup) popoverView.f19813o.get()).addView(view);
        }
    }

    protected BasePopoverDelegate at() {
        return new DefaultPopoverDelegate(this);
    }

    protected boolean av() {
        return aB();
    }

    public boolean aw() {
        return true;
    }

    protected int ax() {
        return Direction.UP.flag() | Direction.DOWN.flag();
    }

    protected int ay() {
        return Direction.UP.flag() | Direction.DOWN.flag();
    }

    public Direction az() {
        return Direction.UP;
    }

    protected Direction aA() {
        return Direction.DOWN;
    }

    public boolean aB() {
        return true;
    }

    protected void mo1372a(Dialog dialog) {
        PopoverUtil.m28514a(dialog);
    }

    private void aI() {
        if (this.ap != null && av()) {
            this.ap.getDecorView().setBackgroundResource(2131361939);
        }
    }
}
