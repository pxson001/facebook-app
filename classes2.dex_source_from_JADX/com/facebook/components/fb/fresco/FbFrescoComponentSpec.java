package com.facebook.components.fb.fresco;

import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import com.facebook.components.ComponentContext;
import com.facebook.components.Size;
import com.facebook.components.annotations.MountSpec;
import com.facebook.components.fresco.GenericReferenceDraweeHierarchy;
import com.facebook.components.reference.Reference;
import com.facebook.components.utils.MeasureUtils;
import com.facebook.components.utils.MeasureUtils.MeasureException;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;

@MountSpec
/* compiled from: frozen */
public class FbFrescoComponentSpec {
    protected static void m30989a(int i, int i2, Size size, float f) {
        try {
            MeasureUtils.m31106a(i, i2, f, size);
        } catch (MeasureException e) {
            throw new RuntimeException(e);
        }
    }

    protected static FbDraweeDrawable<GenericReferenceDraweeHierarchy> m30988a(ComponentContext componentContext, FbDraweeDrawable<GenericReferenceDraweeHierarchy> fbDraweeDrawable, Reference<Drawable> reference, ScalingUtils$ScaleType scalingUtils$ScaleType, RoundingParams roundingParams, ScalingUtils$ScaleType scalingUtils$ScaleType2, PointF pointF) {
        if (fbDraweeDrawable == null) {
            fbDraweeDrawable = new FbDraweeDrawable(componentContext, new GenericReferenceDraweeHierarchy(GenericDraweeHierarchyBuilder.m20552a(componentContext.getResources()).m20571u()));
        }
        GenericReferenceDraweeHierarchy genericReferenceDraweeHierarchy = (GenericReferenceDraweeHierarchy) fbDraweeDrawable.m31157d();
        genericReferenceDraweeHierarchy.f23015a = componentContext;
        if (reference != null) {
            genericReferenceDraweeHierarchy.f23017c = reference;
            genericReferenceDraweeHierarchy.f23021g = (Drawable) Reference.m30531a(genericReferenceDraweeHierarchy.f23015a, (Reference) reference);
            Drawable newDrawable = genericReferenceDraweeHierarchy.f23021g.getConstantState().newDrawable();
            if (scalingUtils$ScaleType != null) {
                genericReferenceDraweeHierarchy.f23016b.m20601a(newDrawable, scalingUtils$ScaleType);
            } else {
                genericReferenceDraweeHierarchy.f23016b.m20608b(newDrawable);
            }
        } else {
            genericReferenceDraweeHierarchy.f23016b.m20608b(null);
        }
        genericReferenceDraweeHierarchy.f23016b.m20603a(roundingParams);
        if (pointF != null) {
            genericReferenceDraweeHierarchy.m31152a(ScalingUtils$ScaleType.f14221h);
            genericReferenceDraweeHierarchy.f23016b.m20597a(pointF);
        } else if (scalingUtils$ScaleType2 != null) {
            genericReferenceDraweeHierarchy.m31152a(scalingUtils$ScaleType2);
        }
        fbDraweeDrawable.mo2740a(fbDraweeDrawable.f23026c.m20526h());
        fbDraweeDrawable.f23026c.m20522b();
        return fbDraweeDrawable;
    }
}
