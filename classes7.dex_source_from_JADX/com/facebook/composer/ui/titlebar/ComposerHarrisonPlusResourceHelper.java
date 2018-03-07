package com.facebook.composer.ui.titlebar;

import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.widget.LazyView;

/* compiled from: tapped_manage_ads */
public class ComposerHarrisonPlusResourceHelper {
    private static final CallerContext f2084a = CallerContext.a(ComposerHarrisonPlusResourceHelper.class);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2061a(com.facebook.composer.ui.titlebar.HarrisonPlusIconType r6, com.facebook.widget.LazyView<com.facebook.drawee.fbpipeline.FbDraweeView> r7, com.facebook.widget.LazyView<android.widget.ImageView> r8) {
        /*
        r1 = 0;
        r2 = 1;
        r0 = com.facebook.composer.ui.titlebar.ComposerHarrisonPlusResourceHelper.C02161.f2083a;
        r5 = r6.f2108a;
        r3 = r5;
        r3 = r3.ordinal();
        r0 = r0[r3];
        switch(r0) {
            case 1: goto L_0x0026;
            case 2: goto L_0x0034;
            case 3: goto L_0x0042;
            case 4: goto L_0x0056;
            default: goto L_0x0010;
        };
    L_0x0010:
        r0 = r8.a();
        r0 = (android.widget.ImageView) r0;
        r3 = 2130839571; // 0x7f020813 float:1.7284156E38 double:1.052774629E-314;
        r0.setImageResource(r3);
        r0 = r1;
    L_0x001d:
        m2062a(r7, r0);
        if (r0 != 0) goto L_0x0073;
    L_0x0022:
        m2062a(r8, r2);
        return;
    L_0x0026:
        r0 = r8.a();
        r0 = (android.widget.ImageView) r0;
        r3 = 2130837619; // 0x7f020073 float:1.7280197E38 double:1.0527736644E-314;
        r0.setImageResource(r3);
        r0 = r1;
        goto L_0x001d;
    L_0x0034:
        r0 = r8.a();
        r0 = (android.widget.ImageView) r0;
        r3 = 2130840624; // 0x7f020c30 float:1.7286292E38 double:1.052775149E-314;
        r0.setImageResource(r3);
        r0 = r1;
        goto L_0x001d;
    L_0x0042:
        r0 = r7.a();
        r0 = (com.facebook.drawee.fbpipeline.FbDraweeView) r0;
        r5 = r6.f2109b;
        r3 = r5;
        r3 = android.net.Uri.parse(r3);
        r4 = f2084a;
        r0.a(r3, r4);
        r0 = r2;
        goto L_0x001d;
    L_0x0056:
        r5 = r6.f2109b;
        r0 = r5;
        r0 = com.google.common.base.Strings.isNullOrEmpty(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x005f:
        r0 = r7.a();
        r0 = (com.facebook.drawee.fbpipeline.FbDraweeView) r0;
        r5 = r6.f2109b;
        r3 = r5;
        r3 = android.net.Uri.parse(r3);
        r4 = f2084a;
        r0.a(r3, r4);
        r0 = r2;
        goto L_0x001d;
    L_0x0073:
        r2 = r1;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.ui.titlebar.ComposerHarrisonPlusResourceHelper.a(com.facebook.composer.ui.titlebar.HarrisonPlusIconType, com.facebook.widget.LazyView, com.facebook.widget.LazyView):void");
    }

    private static void m2062a(LazyView<? extends View> lazyView, boolean z) {
        if (z) {
            lazyView.a().setVisibility(0);
        } else if (lazyView.b()) {
            lazyView.a().setVisibility(8);
        }
    }
}
