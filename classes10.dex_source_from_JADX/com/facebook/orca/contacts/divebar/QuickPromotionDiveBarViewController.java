package com.facebook.orca.contacts.divebar;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.contacts.picker.ContactPickerHeaderViewManager;
import com.facebook.contacts.picker.ContactPickerHeaderViewManager.1;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quickpromotion.ui.QuickPromotionDiveBarController;
import com.facebook.quickpromotion.ui.QuickPromotionDivebarViewFactory;
import javax.inject.Inject;

/* compiled from: onNotificationReceived */
public class QuickPromotionDiveBarViewController {
    public static final InterstitialTrigger f5895a = QuickPromotionDiveBarController.a;
    public final InterstitialManager f5896b;
    public final QuickPromotionDivebarViewFactory f5897c;
    public OnClickListener f5898d = new C08711(this);
    public View f5899e;
    public ViewGroup f5900f;
    public 1 f5901g;

    /* compiled from: onNotificationReceived */
    class C08711 implements OnClickListener {
        final /* synthetic */ QuickPromotionDiveBarViewController f5894a;

        C08711(QuickPromotionDiveBarViewController quickPromotionDiveBarViewController) {
            this.f5894a = quickPromotionDiveBarViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1591764572);
            this.f5894a.m5556b();
            Logger.a(2, EntryType.UI_INPUT_END, 2120339456, a);
        }
    }

    @Inject
    public QuickPromotionDiveBarViewController(InterstitialManager interstitialManager, QuickPromotionDivebarViewFactory quickPromotionDivebarViewFactory) {
        this.f5896b = interstitialManager;
        this.f5897c = quickPromotionDivebarViewFactory;
    }

    public final void m5556b() {
        if (this.f5899e != null) {
            this.f5899e.setVisibility(8);
            if (this.f5900f != null) {
                this.f5900f.removeView(this.f5899e);
            }
            this.f5899e = null;
        }
        if (this.f5901g != null) {
            ContactPickerHeaderViewManager.b(this.f5901g.a);
        }
    }
}
