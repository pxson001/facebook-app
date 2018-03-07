package com.facebook.zero.carrier.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.iorg.common.upsell.server.UpsellPromo;
import com.facebook.iorg.common.upsell.server.UpsellPromo.PromoType;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Iterator;

/* compiled from: music_cta_click */
public class CarrierManagerUiHelper {

    /* compiled from: music_cta_click */
    /* synthetic */ class C06981 {
        static final /* synthetic */ int[] f5327a = new int[PromoType.values().length];

        static {
            try {
                f5327a[PromoType.DATA.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5327a[PromoType.DATA_MB.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5327a[PromoType.DATA_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5327a[PromoType.DATA_UNLIMITED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5327a[PromoType.SMS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5327a[PromoType.VOICE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static View m6573a(Context context) {
        Resources resources = context.getResources();
        View view = new View(context);
        view.setLayoutParams(new LayoutParams(-1, resources.getDimensionPixelSize(2131427380)));
        view.setBackgroundDrawable(new ColorDrawable(resources.getColor(2131363902)));
        return view;
    }

    public static int m6572a(UpsellPromo upsellPromo, boolean z) {
        Builder builder = new Builder();
        int size = upsellPromo.a.size();
        for (int i = 0; i < size; i++) {
            builder.c(PromoType.fromString((String) upsellPromo.a.get(i)));
        }
        Iterator it = builder.b().iterator();
        Object obj = null;
        Object obj2 = null;
        while (it.hasNext()) {
            Object obj3;
            switch (C06981.f5327a[((PromoType) it.next()).ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    obj2 = 1;
                    continue;
                case 5:
                case 6:
                    int i2 = 1;
                    break;
                default:
                    obj3 = obj;
                    break;
            }
            obj = obj3;
        }
        if (z) {
            if (obj2 != null && obj != null) {
                return 2130838139;
            }
            if (obj != null) {
                return 2130842594;
            }
            return 2130838374;
        } else if (obj2 != null && obj != null) {
            return 2130838140;
        } else {
            if (obj != null) {
                return 2130842595;
            }
            return 2130838375;
        }
    }
}
