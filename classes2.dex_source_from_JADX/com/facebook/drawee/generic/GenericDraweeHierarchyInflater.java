package com.facebook.drawee.generic;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.facebook.drawee.R$styleable;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.proxygen.HTTPTransportCallback;
import javax.annotation.Nullable;

/* compiled from: messenger_android_clock_skew_banner */
public class GenericDraweeHierarchyInflater {
    public static GenericDraweeHierarchyBuilder m20549a(Context context, @Nullable AttributeSet attributeSet) {
        return m20550a(new GenericDraweeHierarchyBuilder(context.getResources()), context, attributeSet);
    }

    public static GenericDraweeHierarchyBuilder m20550a(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context, @Nullable AttributeSet attributeSet) {
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        boolean z4 = true;
        int i2 = 0;
        if (attributeSet != null) {
            z = R$styleable.GenericDraweeHierarchy;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z);
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                z = true;
                z2 = true;
                z3 = true;
                i = 0;
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == 11) {
                        genericDraweeHierarchyBuilder.m20567e(m20548a(obtainStyledAttributes, index));
                    } else if (index == 2) {
                        genericDraweeHierarchyBuilder.m20557a(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 14) {
                        genericDraweeHierarchyBuilder.m20569g(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 8) {
                        genericDraweeHierarchyBuilder.m20564d(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 0) {
                        genericDraweeHierarchyBuilder.m20556a(obtainStyledAttributes.getInt(index, 0));
                    } else if (index == 1) {
                        genericDraweeHierarchyBuilder.m20555a(obtainStyledAttributes.getFloat(index, 0.0f));
                    } else if (index == 3) {
                        genericDraweeHierarchyBuilder.m20559a(m20548a(obtainStyledAttributes, index));
                    } else if (index == 4) {
                        genericDraweeHierarchyBuilder.m20560b(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 5) {
                        genericDraweeHierarchyBuilder.m20561b(m20548a(obtainStyledAttributes, index));
                    } else if (index == 6) {
                        genericDraweeHierarchyBuilder.m20562c(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 7) {
                        genericDraweeHierarchyBuilder.m20563c(m20548a(obtainStyledAttributes, index));
                    } else if (index == 9) {
                        genericDraweeHierarchyBuilder.m20565d(m20548a(obtainStyledAttributes, index));
                    } else if (index == 10) {
                        i = obtainStyledAttributes.getInteger(index, i);
                    } else if (index == 12) {
                        genericDraweeHierarchyBuilder.m20566e(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 13) {
                        genericDraweeHierarchyBuilder.m20568f(m20547a(context, obtainStyledAttributes, index));
                    } else if (index == 15) {
                        m20551a(genericDraweeHierarchyBuilder).a(obtainStyledAttributes.getBoolean(index, false));
                    } else if (index == 16) {
                        i2 = obtainStyledAttributes.getDimensionPixelSize(index, i2);
                    } else if (index == 17) {
                        z3 = obtainStyledAttributes.getBoolean(index, z3);
                    } else if (index == 18) {
                        z2 = obtainStyledAttributes.getBoolean(index, z2);
                    } else if (index == 20) {
                        z = obtainStyledAttributes.getBoolean(index, z);
                    } else if (index == 19) {
                        z4 = obtainStyledAttributes.getBoolean(index, z4);
                    } else if (index == 21) {
                        m20551a(genericDraweeHierarchyBuilder).a(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == 22) {
                        m20551a(genericDraweeHierarchyBuilder).c((float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    } else if (index == 23) {
                        m20551a(genericDraweeHierarchyBuilder).b(obtainStyledAttributes.getColor(index, 0));
                    } else if (index == 24) {
                        m20551a(genericDraweeHierarchyBuilder).d((float) obtainStyledAttributes.getDimensionPixelSize(index, 0));
                    }
                }
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            z = true;
            z2 = true;
            z3 = true;
            i = 0;
        }
        if (genericDraweeHierarchyBuilder.m20570k() != null && i > 0) {
            genericDraweeHierarchyBuilder.m20564d(new AutoRotateDrawable(genericDraweeHierarchyBuilder.m20570k(), i));
        }
        if (i2 > 0) {
            m20551a(genericDraweeHierarchyBuilder).a(z3 ? (float) i2 : 0.0f, z2 ? (float) i2 : 0.0f, z4 ? (float) i2 : 0.0f, z ? (float) i2 : 0.0f);
        }
        return genericDraweeHierarchyBuilder;
    }

    @Nullable
    private static Drawable m20547a(Context context, TypedArray typedArray, int i) {
        int resourceId = typedArray.getResourceId(i, 0);
        return resourceId == 0 ? null : context.getResources().getDrawable(resourceId);
    }

    @Nullable
    private static ScalingUtils$ScaleType m20548a(TypedArray typedArray, int i) {
        switch (typedArray.getInt(i, -2)) {
            case -1:
                return null;
            case 0:
                return ScalingUtils$ScaleType.f14214a;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ScalingUtils$ScaleType.f14215b;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return ScalingUtils$ScaleType.f14216c;
            case 3:
                return ScalingUtils$ScaleType.f14217d;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return ScalingUtils$ScaleType.f14218e;
            case 5:
                return ScalingUtils$ScaleType.f14219f;
            case 6:
                return ScalingUtils$ScaleType.f14220g;
            case 7:
                return ScalingUtils$ScaleType.f14221h;
            default:
                throw new RuntimeException("XML attribute not specified!");
        }
    }

    private static RoundingParams m20551a(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (genericDraweeHierarchyBuilder.f14213u == null) {
            genericDraweeHierarchyBuilder.f14213u = new RoundingParams();
        }
        return genericDraweeHierarchyBuilder.f14213u;
    }
}
