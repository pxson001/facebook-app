package com.facebook.messaging.seenheads;

import android.content.res.Resources;
import android.graphics.Typeface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.util.CircleOverflowRenderer.Builder;
import javax.inject.Inject;

/* compiled from: delete_payment_pins */
public class SeenHeadCircleOverflowRendererProvider {
    private final Resources f16628a;

    public static SeenHeadCircleOverflowRendererProvider m16634b(InjectorLike injectorLike) {
        return new SeenHeadCircleOverflowRendererProvider(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SeenHeadCircleOverflowRendererProvider(Resources resources) {
        this.f16628a = resources;
    }

    public final Builder m16635a() {
        Builder builder = new Builder(this.f16628a);
        builder.b = this.f16628a.getDimensionPixelSize(2131428631);
        builder = builder;
        builder.c = this.f16628a.getColor(2131362325);
        builder = builder;
        builder.d = -12303292;
        builder = builder;
        builder.e = this.f16628a.getDimensionPixelSize(2131428638);
        builder = builder;
        builder.f = Typeface.DEFAULT_BOLD;
        return builder;
    }
}
