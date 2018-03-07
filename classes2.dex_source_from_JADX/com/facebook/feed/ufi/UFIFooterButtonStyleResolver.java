package com.facebook.feed.ufi;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.Maps;
import java.util.EnumMap;

/* compiled from: get_brazilian_address_details */
public class UFIFooterButtonStyleResolver {
    public Resources f22462a;
    public EnumMap<FooterLayoutType, UFIFooterButtonStyleDefinition> f22463b;

    /* compiled from: get_brazilian_address_details */
    public enum ButtonWidthStyle {
        TEXT_AND_ICON_EQUAL_WIDTH,
        TEXT_AND_ICON_VARIABLE_WIDTH,
        ICON_ONLY_EQUAL_WIDTH,
        TEXT_ONLY_EQUAL_WIDTH,
        TEXT_ONLY_VARIABLE_WIDTH
    }

    /* compiled from: get_brazilian_address_details */
    /* synthetic */ class C09141 {
        static final /* synthetic */ int[] f22485a = new int[ButtonWidthStyle.values().length];

        static {
            try {
                f22485a[ButtonWidthStyle.TEXT_AND_ICON_EQUAL_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22485a[ButtonWidthStyle.TEXT_AND_ICON_VARIABLE_WIDTH.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22485a[ButtonWidthStyle.TEXT_ONLY_EQUAL_WIDTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22485a[ButtonWidthStyle.TEXT_ONLY_VARIABLE_WIDTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22485a[ButtonWidthStyle.ICON_ONLY_EQUAL_WIDTH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public UFIFooterButtonStyleResolver(Resources resources) {
        this.f22462a = resources;
        EnumMap a = Maps.m811a(FooterLayoutType.class);
        a.put(FooterLayoutType.INLINE, new UFIFooterButtonStyleDefinition(this.f22462a.getDimensionPixelSize(2131427475), this.f22462a.getDimension(2131427476), this.f22462a.getDrawable(2130843790).getIntrinsicWidth(), 3, true));
        this.f22463b = a;
    }

    public final int m30349a(UFIFooterButtonStyleDefinition uFIFooterButtonStyleDefinition, int i) {
        Paint paint = new Paint(1);
        paint.setTextSize(uFIFooterButtonStyleDefinition.f22466c);
        if (uFIFooterButtonStyleDefinition.f22468e) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return (int) Math.ceil((double) paint.measureText(this.f22462a.getString(i)));
    }

    public static int m30348a(ButtonWidthStyle buttonWidthStyle, UFIFooterButtonStyleDefinition uFIFooterButtonStyleDefinition, int i, int i2) {
        switch (C09141.f22485a[buttonWidthStyle.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return (uFIFooterButtonStyleDefinition.f22465b + (uFIFooterButtonStyleDefinition.f22464a * 3)) + i;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return (uFIFooterButtonStyleDefinition.f22465b + (uFIFooterButtonStyleDefinition.f22464a * 3)) + i2;
            case 3:
                return (uFIFooterButtonStyleDefinition.f22464a * 2) + i;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return (uFIFooterButtonStyleDefinition.f22464a * 2) + i2;
            case 5:
                return uFIFooterButtonStyleDefinition.f22465b + (uFIFooterButtonStyleDefinition.f22464a * 2);
            default:
                throw new IllegalArgumentException("Unknown ButtonWidth Style: " + buttonWidthStyle.toString());
        }
    }
}
