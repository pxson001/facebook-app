package com.facebook.backstage.consumption;

import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: rtv */
public class GradientHelper {
    private final int f4598a;
    private final Paint f4599b = new Paint(0);
    private GradientDrawable f4600c;

    private static GradientHelper m4531b(InjectorLike injectorLike) {
        return new GradientHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GradientHelper(Resources resources) {
        this.f4598a = (int) resources.getDimension(2131433220);
        this.f4599b.setColor(resources.getColor(17170444));
        this.f4600c = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]{resources.getColor(17170444), 0});
    }
}
