package com.facebook.feed.ufi;

import android.content.res.Resources;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.inject.Assisted;
import com.facebook.languages.switchercommonex.LocaleChangeController;
import com.facebook.languages.switchercommonex.LocaleChangeListener;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: get_csc_token */
public class UFIStyle {
    private final UFIFooterButtonStyleResolver f22452a;
    private final UFIFooterButtonStyleDefinition f22453b;
    private final Resources f22454c;
    private UFIParams f22455d;
    private UFIParams f22456e;
    private UFIParams f22457f;
    private UFIParams f22458g;
    private UFIParams f22459h;
    private UFIParams f22460i;
    private UFIParams f22461j;

    /* compiled from: get_csc_token */
    public class C09131 implements LocaleChangeListener {
        final /* synthetic */ UFIStyle f22469a;

        public C09131(UFIStyle uFIStyle) {
            this.f22469a = uFIStyle;
        }

        public final ListenableFuture mo3162a(Locale locale) {
            UFIStyle.m30346a(this.f22469a);
            return null;
        }
    }

    @Inject
    public UFIStyle(@Assisted FooterLayoutType footerLayoutType, Resources resources, LocaleChangeController localeChangeController) {
        this.f22452a = new UFIFooterButtonStyleResolver(resources);
        this.f22453b = (UFIFooterButtonStyleDefinition) this.f22452a.f22463b.get(footerLayoutType);
        this.f22454c = resources;
        localeChangeController.m29101a(new C09131(this));
        m30346a(this);
    }

    public static void m30346a(UFIStyle uFIStyle) {
        UFIFooterButtonWidthMeasurer uFIFooterButtonWidthMeasurer = new UFIFooterButtonWidthMeasurer(uFIStyle.f22454c, uFIStyle.f22453b);
        int i = uFIFooterButtonWidthMeasurer.f22470a;
        int i2 = uFIFooterButtonWidthMeasurer.f22471b;
        int i3 = uFIFooterButtonWidthMeasurer.f22472c;
        uFIStyle.f22455d = new UFIParams(uFIFooterButtonWidthMeasurer, i, i2, i3);
        uFIStyle.f22456e = new UFIParams(uFIFooterButtonWidthMeasurer, i, i2, 0);
        uFIStyle.f22457f = new UFIParams(uFIFooterButtonWidthMeasurer, 0, i2, i3);
        uFIStyle.f22458g = new UFIParams(uFIFooterButtonWidthMeasurer, i, 0, i3);
        uFIStyle.f22459h = new UFIParams(uFIFooterButtonWidthMeasurer, i, 0, 0);
        uFIStyle.f22460i = new UFIParams(uFIFooterButtonWidthMeasurer, 0, i2, 0);
        uFIStyle.f22461j = new UFIParams(uFIFooterButtonWidthMeasurer, 0, 0, i3);
    }

    public final UFIParams m30347a(boolean z, boolean z2, boolean z3) {
        if (z && z2 && z3) {
            return this.f22455d;
        }
        if (z && z2) {
            return this.f22456e;
        }
        if (z2 && z3) {
            return this.f22457f;
        }
        if (z && z3) {
            return this.f22458g;
        }
        if (z) {
            return this.f22459h;
        }
        if (z2) {
            return this.f22460i;
        }
        if (z3) {
            return this.f22461j;
        }
        return this.f22455d;
    }
}
