package com.facebook.feed.ufi;

import android.content.res.Resources;
import com.facebook.feed.ufi.UFIFooterButtonStyleResolver.ButtonWidthStyle;
import com.google.common.base.Preconditions;

/* compiled from: get_authenticated_attachment_url */
public class UFIFooterButtonWidthMeasurer {
    public int f22470a;
    public int f22471b;
    public int f22472c;
    public UFIFooterButtonStyleDefinition f22473d;

    /* compiled from: get_authenticated_attachment_url */
    public class WidthWeights {
        final /* synthetic */ UFIFooterButtonWidthMeasurer f22475a;
        public int f22476b;
        public int f22477c;
        public int f22478d;
        public int f22479e;
        public int f22480f;
        public float[] f22481g;
        public float[] f22482h;
        public float[] f22483i;
        public float[] f22484j;

        public WidthWeights(UFIFooterButtonWidthMeasurer uFIFooterButtonWidthMeasurer, int i) {
            this.f22475a = uFIFooterButtonWidthMeasurer;
            this.f22481g = new float[i];
            this.f22482h = new float[i];
            this.f22483i = new float[i];
            this.f22484j = new float[i];
        }
    }

    public UFIFooterButtonWidthMeasurer(Resources resources, UFIFooterButtonStyleDefinition uFIFooterButtonStyleDefinition) {
        UFIFooterButtonStyleResolver uFIFooterButtonStyleResolver = new UFIFooterButtonStyleResolver(resources);
        this.f22473d = uFIFooterButtonStyleDefinition;
        this.f22470a = uFIFooterButtonStyleResolver.m30349a(this.f22473d, 2131233267);
        this.f22471b = uFIFooterButtonStyleResolver.m30349a(this.f22473d, 2131233269);
        this.f22472c = uFIFooterButtonStyleResolver.m30349a(this.f22473d, 2131233280);
    }

    public final WidthWeights m30352a(int... iArr) {
        boolean z;
        int i;
        if (this.f22473d.f22467d <= iArr.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        int i2 = this.f22473d.f22467d;
        WidthWeights widthWeights = new WidthWeights(this, i2);
        int i3 = iArr[0];
        for (i = 1; i < i2; i++) {
            if (iArr[i] > i3) {
                i3 = iArr[i];
            }
        }
        int i4 = i3;
        m30351a(widthWeights, i4, i2, iArr);
        for (i3 = 0; i3 < i2; i3++) {
            i = iArr[i3];
            widthWeights.f22482h[i3] = 1.0f;
            if (i > 0) {
                widthWeights.f22481g[i3] = ((float) UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.TEXT_AND_ICON_VARIABLE_WIDTH, this.f22473d, i4, i)) / ((float) widthWeights.f22477c);
                widthWeights.f22484j[i3] = ((float) UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.ICON_ONLY_EQUAL_WIDTH, this.f22473d, i4, i)) / ((float) widthWeights.f22480f);
                widthWeights.f22483i[i3] = ((float) UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.TEXT_ONLY_VARIABLE_WIDTH, this.f22473d, i4, i)) / ((float) widthWeights.f22479e);
            } else {
                widthWeights.f22481g[i3] = 1.0f;
                widthWeights.f22483i[i3] = 1.0f;
                widthWeights.f22484j[i3] = 1.0f;
            }
        }
        return widthWeights;
    }

    private void m30351a(WidthWeights widthWeights, int i, int i2, int... iArr) {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = iArr[i8];
            if (i9 > 0) {
                i7 += UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.TEXT_AND_ICON_EQUAL_WIDTH, this.f22473d, i, i9);
                i6 += UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.TEXT_AND_ICON_VARIABLE_WIDTH, this.f22473d, i, i9);
                i5 += UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.ICON_ONLY_EQUAL_WIDTH, this.f22473d, i, i9);
                i4 += UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.TEXT_ONLY_EQUAL_WIDTH, this.f22473d, i, i9);
                i3 += UFIFooterButtonStyleResolver.m30348a(ButtonWidthStyle.TEXT_ONLY_VARIABLE_WIDTH, this.f22473d, i, i9);
            }
        }
        i6 = Math.max(1, i6);
        i3 = Math.max(1, i3);
        widthWeights.f22476b = i7;
        widthWeights.f22477c = i6;
        widthWeights.f22480f = i5;
        widthWeights.f22478d = i4;
        widthWeights.f22479e = i3;
    }
}
