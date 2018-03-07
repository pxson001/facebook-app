package com.facebook.groups.groupsgrid.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import javax.annotation.Nullable;

/* compiled from: X-Cache */
public class ResizeValues {
    public final double f10356a;
    public final int f10357b;
    public final int f10358c;
    public final int f10359d;
    final Resources f10360e;

    private ResizeValues(double d, int i, int i2, int i3, Resources resources) {
        this.f10356a = d;
        this.f10357b = i;
        this.f10358c = i2;
        this.f10359d = i3;
        this.f10360e = resources;
    }

    public static ResizeValues m10770a(@Nullable Integer num, Context context, Resources resources) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int dimensionPixelSize = resources.getDimensionPixelSize(2131431995) + resources.getDimensionPixelSize(2131431980);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131431976);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(2131431974);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(2131431975);
        int i = displayMetrics.heightPixels;
        int intValue = num == null ? displayMetrics.widthPixels : num.intValue();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(2131431925);
        int i2 = intValue - (dimensionPixelOffset * 2);
        int dimensionPixelOffset2 = i - resources.getDimensionPixelOffset(2131434707);
        double d = 0.75d * ((double) dimensionPixelSize3);
        double d2 = 0.75d * ((double) dimensionPixelSize2);
        dimensionPixelSize2 = resources.getDimensionPixelOffset(2131431978);
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(2131431977);
        i = (int) Math.floor(((double) (i2 + dimensionPixelSize2)) / (d + ((double) dimensionPixelSize2)));
        return new ResizeValues(Math.min(1.0d, ((((double) i2) + ((double) dimensionPixelSize2)) / ((double) i)) / ((double) (dimensionPixelSize3 + dimensionPixelSize2))), i, (int) Math.ceil(((double) (dimensionPixelOffset2 + dimensionPixelOffset3)) / ((d2 + ((double) dimensionPixelOffset3)) + ((double) dimensionPixelSize))), ((((dimensionPixelOffset * 2) + dimensionPixelSize4) * i) - intValue) / ((i * 2) - 2), resources);
    }
}
