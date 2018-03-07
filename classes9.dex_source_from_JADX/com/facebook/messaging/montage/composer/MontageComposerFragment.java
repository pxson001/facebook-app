package com.facebook.messaging.montage.composer;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbFragment;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout;
import com.facebook.fbui.draggable.widget.DismissibleFrameLayout.OnDismissListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.montage.composer.MontageComposerController.C13801;
import com.facebook.messaging.montage.composer.MontageComposerController.C13801.C13791;
import com.facebook.messaging.montage.composer.MontageComposerController.C13812;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.ImmutableList.Builder;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: is_pux */
public class MontageComposerFragment extends FbDialogFragment implements CanHandleBackPressed {
    public DismissibleFrameLayout am;
    public C13801 an;
    public boolean ao = true;

    /* compiled from: is_pux */
    class C13841 implements OnDismissListener {
        final /* synthetic */ MontageComposerFragment f12481a;

        C13841(MontageComposerFragment montageComposerFragment) {
            this.f12481a = montageComposerFragment;
        }

        public final void m12941b() {
        }

        public final void m12942c() {
            this.f12481a.a();
        }
    }

    /* compiled from: is_pux */
    class C13852 implements OnKeyListener {
        final /* synthetic */ MontageComposerFragment f12482a;

        C13852(MontageComposerFragment montageComposerFragment) {
            this.f12482a = montageComposerFragment;
        }

        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            boolean z = keyEvent.getAction() == 1 && i == 4;
            if (z && this.f12482a.an != null) {
                Object obj;
                MontageComposerController montageComposerController = this.f12482a.an.f12459a;
                FbFragment n = MontageComposerController.m12939n(montageComposerController);
                if (n != null && (n instanceof CanHandleBackPressed) && ((CanHandleBackPressed) n).O_()) {
                    obj = 1;
                } else if (montageComposerController.f12479n.f11566c.getVisibility() == 0 && montageComposerController.f12479n.m12224h()) {
                    r4 = 1;
                } else if (MontageComposerController.m12938l(montageComposerController)) {
                    MontageComposerController.m12937k(montageComposerController);
                    MontageComposerNavigationController montageComposerNavigationController = montageComposerController.f12477l;
                    if (montageComposerNavigationController.m12970g()) {
                        montageComposerNavigationController.f12501c.setPrimaryMode(null);
                        montageComposerNavigationController.m12966a(montageComposerNavigationController.f12503e);
                        montageComposerNavigationController.f12503e = null;
                    }
                    r4 = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    return true;
                }
            }
            return false;
        }
    }

    public final void m12944a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1913883261);
        super.a(bundle);
        a(2, 2131626421);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 994207081, a);
    }

    public final View m12943a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -303268821);
        View inflate = layoutInflater.inflate(2130905327, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1020766883, a);
        return inflate;
    }

    public final void m12945a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        if (this.an != null) {
            C13801 c13801 = this.an;
            MontageComposerController montageComposerController = c13801.f12459a;
            MontageComposerNavigationControllerProvider montageComposerNavigationControllerProvider = montageComposerController.f12470e;
            montageComposerController.f12477l = new MontageComposerNavigationController(SpringSystem.b(montageComposerNavigationControllerProvider), (MontageComposerNavigationView) montageComposerController.f12476k.e(2131563974), Arrays.asList(CanvasType.values()), Arrays.asList(EditType.values()));
            montageComposerController.f12477l.f12504f = new C13812(montageComposerController);
            montageComposerController = c13801.f12459a;
            montageComposerController.f12480o = (ViewGroup) montageComposerController.f12476k.e(2131558429);
            montageComposerController.f12475j = new MontageCanvasViewUtil(montageComposerController.f12477l, montageComposerController.f12480o);
            MontageComposerController.m12935h(c13801.f12459a);
            view.post(new C13791(c13801));
        }
        this.am = (DismissibleFrameLayout) e(2131563972);
        this.am.l = this.ao;
        this.am.e = new C13841(this);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.an != null) {
            C13801 c13801 = this.an;
            MontageComposerController montageComposerController = c13801.f12459a;
            MontageComposerFragmentFactory montageComposerFragmentFactory = montageComposerController.f12469d;
            Builder builder = new Builder();
            builder.b(montageComposerFragmentFactory.f12486b.values());
            for (WeakReference weakReference : montageComposerFragmentFactory.f12485a.values()) {
                FbFragment fbFragment = (FbFragment) weakReference.get();
                if (fbFragment != null) {
                    builder.c(fbFragment);
                }
            }
            Iterator it = builder.b().iterator();
            while (it.hasNext()) {
                it.next();
            }
            montageComposerFragmentFactory = montageComposerController.f12469d;
            montageComposerFragmentFactory.f12486b.clear();
            montageComposerFragmentFactory.f12485a.clear();
            c13801.f12459a.f12476k = null;
        }
    }

    public final Dialog m12946c(Bundle bundle) {
        Dialog c = super.c(bundle);
        c.setOnKeyListener(new C13852(this));
        return c;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1088550090);
        super.mi_();
        if (this.an != null) {
            C13801 c13801 = this.an;
            c13801.f12459a.f12477l.m12967c();
            c13801.f12459a.f12479n.m12220a(true);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -298058693, a);
    }
}
