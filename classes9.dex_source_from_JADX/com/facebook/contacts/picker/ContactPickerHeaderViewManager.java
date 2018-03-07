package com.facebook.contacts.picker;

import android.view.ViewGroup;
import com.facebook.orca.contacts.divebar.QuickPromotionDiveBarViewController;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.ui.QuickPromotionDiveBarController;
import com.google.common.collect.Lists;
import java.util.Queue;

/* compiled from: prefetchVideoHomeData finished succesfully */
public class ContactPickerHeaderViewManager {
    private final ViewGroup f6329a;
    public final Queue<ContactPickerHeaderViewController> f6330b = Lists.b();
    private C06511 f6331c = new C06511(this);
    public QuickPromotionDiveBarViewController f6332d;

    /* compiled from: prefetchVideoHomeData finished succesfully */
    public class C06511 {
        public final /* synthetic */ ContactPickerHeaderViewManager f6328a;

        C06511(ContactPickerHeaderViewManager contactPickerHeaderViewManager) {
            this.f6328a = contactPickerHeaderViewManager;
        }
    }

    public ContactPickerHeaderViewManager(ViewGroup viewGroup) {
        this.f6329a = viewGroup;
    }

    public final void m6748a() {
        m6747c();
    }

    public static void m6746b(ContactPickerHeaderViewManager contactPickerHeaderViewManager) {
        contactPickerHeaderViewManager.m6747c();
        while (!contactPickerHeaderViewManager.f6330b.isEmpty()) {
            boolean z;
            QuickPromotionDiveBarViewController quickPromotionDiveBarViewController = (QuickPromotionDiveBarViewController) contactPickerHeaderViewManager.f6330b.remove();
            if (quickPromotionDiveBarViewController.e != null) {
                z = true;
            } else {
                z = quickPromotionDiveBarViewController.b.b(QuickPromotionDiveBarViewController.a, QuickPromotionDiveBarController.class);
                if (!z) {
                    quickPromotionDiveBarViewController.b();
                }
            }
            if (z) {
                ViewGroup viewGroup = contactPickerHeaderViewManager.f6329a;
                C06511 c06511 = contactPickerHeaderViewManager.f6331c;
                QuickPromotionDiveBarController quickPromotionDiveBarController = (QuickPromotionDiveBarController) quickPromotionDiveBarViewController.b.a(QuickPromotionDiveBarViewController.a, QuickPromotionDiveBarController.class);
                if (quickPromotionDiveBarController != null) {
                    quickPromotionDiveBarViewController.f = viewGroup;
                    quickPromotionDiveBarViewController.g = c06511;
                    quickPromotionDiveBarViewController.e = quickPromotionDiveBarViewController.c.a(viewGroup, (QuickPromotionDefinition) quickPromotionDiveBarController.a(viewGroup.getContext()).getExtras().get("qp_definition"), quickPromotionDiveBarController.b(), quickPromotionDiveBarViewController.d);
                    quickPromotionDiveBarViewController.f.addView(quickPromotionDiveBarViewController.e);
                }
                contactPickerHeaderViewManager.f6332d = quickPromotionDiveBarViewController;
                return;
            }
        }
    }

    private void m6747c() {
        if (this.f6332d != null) {
            this.f6332d = null;
        }
    }
}
