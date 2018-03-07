package com.facebook.feed.ufi;

import android.widget.LinearLayout.LayoutParams;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.feed.ufi.UFIFooterButtonWidthMeasurer.WidthWeights;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Preconditions;

/* compiled from: get_account_details */
public class UFIParams {
    private WidthWeights f22474a;

    /* compiled from: get_account_details */
    public enum I18nStyleType {
        ICONS_EQUAL_WIDTH,
        ICONS_VARIABLE_WIDTH,
        NO_ICONS_EQUAL_WIDTH,
        NO_ICONS_VARIABLE_WIDTH,
        ICONS_ONLY;

        public static boolean hasIcons(I18nStyleType i18nStyleType) {
            return i18nStyleType == ICONS_EQUAL_WIDTH || i18nStyleType == ICONS_VARIABLE_WIDTH || i18nStyleType == ICONS_ONLY;
        }
    }

    /* compiled from: get_account_details */
    /* synthetic */ class C09151 {
        static final /* synthetic */ int[] f22488a = new int[I18nStyleType.values().length];

        static {
            try {
                f22488a[I18nStyleType.ICONS_EQUAL_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22488a[I18nStyleType.ICONS_VARIABLE_WIDTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22488a[I18nStyleType.NO_ICONS_EQUAL_WIDTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22488a[I18nStyleType.ICONS_ONLY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public UFIParams(UFIFooterButtonWidthMeasurer uFIFooterButtonWidthMeasurer, int... iArr) {
        this.f22474a = uFIFooterButtonWidthMeasurer.m30352a(iArr);
    }

    public final I18nStyleType m30353a(int i) {
        if (this.f22474a.f22476b < i) {
            return I18nStyleType.ICONS_EQUAL_WIDTH;
        }
        if (this.f22474a.f22477c < i) {
            return I18nStyleType.ICONS_VARIABLE_WIDTH;
        }
        if (this.f22474a.f22478d < i) {
            return I18nStyleType.NO_ICONS_EQUAL_WIDTH;
        }
        return I18nStyleType.NO_ICONS_VARIABLE_WIDTH;
    }

    public final float[] m30355a(I18nStyleType i18nStyleType) {
        switch (C09151.f22488a[i18nStyleType.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return this.f22474a.f22482h;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return this.f22474a.f22481g;
            case 3:
                return this.f22474a.f22482h;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return this.f22474a.f22484j;
            default:
                return this.f22474a.f22483i;
        }
    }

    @Deprecated
    public final void m30354a(int i, FeedbackCustomPressStateButton[] feedbackCustomPressStateButtonArr) {
        boolean z;
        WidthWeights widthWeights = this.f22474a;
        boolean z2 = true;
        if (feedbackCustomPressStateButtonArr.length <= widthWeights.f22482h.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (feedbackCustomPressStateButtonArr.length <= widthWeights.f22483i.length) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (feedbackCustomPressStateButtonArr.length > widthWeights.f22484j.length) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        I18nStyleType a = m30353a(i);
        float[] a2 = m30355a(a);
        int length = feedbackCustomPressStateButtonArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            ImageWithTextView imageWithTextView = feedbackCustomPressStateButtonArr[i2];
            imageWithTextView.mo2813a(I18nStyleType.hasIcons(a));
            int i4 = i3 + 1;
            ((LayoutParams) imageWithTextView.getLayoutParams()).weight = a2[i3];
            i2++;
            i3 = i4;
        }
    }
}
