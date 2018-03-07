package com.facebook.nearby.v2.intent.categorypicker.icons;

import android.content.Context;
import android.content.res.Resources;
import com.google.common.base.Preconditions;

/* compiled from: payments_pay_success */
public abstract class NearbyPlacesCategoryPickerIconViewFactory {
    public static NearbyPlacesCategoryPickerIconView m4641a(NearbyPlacesCategoryPickerIconType nearbyPlacesCategoryPickerIconType, Context context) {
        int i;
        int i2;
        int i3;
        switch (nearbyPlacesCategoryPickerIconType) {
            case ALL:
                i = 2131236641;
                i2 = 2131363246;
                i3 = 2130841587;
                break;
            case RESTAURANTS:
                i = 2131236642;
                i2 = 2131363247;
                i3 = 2130841593;
                break;
            case COFFEE:
                i = 2131236643;
                i2 = 2131363248;
                i3 = 2130841589;
                break;
            case NIGHTLIFE:
                i = 2131236644;
                i2 = 2131363249;
                i3 = 2130841591;
                break;
            case OUTDOORS:
                i = 2131236645;
                i2 = 2131363250;
                i3 = 2130841592;
                break;
            case ARTS:
                i = 2131236646;
                i2 = 2131363251;
                i3 = 2130841588;
                break;
            case HOTELS:
                i = 2131236647;
                i2 = 2131363252;
                i3 = 2130841590;
                break;
            case SHOPPING:
                i = 2131236648;
                i2 = 2131363253;
                i3 = 2130841594;
                break;
            default:
                throw new IllegalArgumentException("Invalid category picker Icon view type");
        }
        boolean z = (i2 == 0 || i == 0 || i3 == 0) ? false : true;
        Preconditions.checkArgument(z);
        Resources resources = context.getResources();
        return new NearbyPlacesCategoryPickerIconView(resources.getString(i), resources.getDrawable(i3), resources.getColor(i2), nearbyPlacesCategoryPickerIconType, context);
    }
}
