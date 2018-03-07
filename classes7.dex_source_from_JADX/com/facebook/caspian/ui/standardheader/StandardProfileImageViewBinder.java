package com.facebook.caspian.ui.standardheader;

import android.content.res.Resources;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: creativecam_source */
public class StandardProfileImageViewBinder {
    private final Resources f16592a;
    private final Provider<FbDraweeControllerBuilder> f16593b;

    public static StandardProfileImageViewBinder m20645b(InjectorLike injectorLike) {
        return new StandardProfileImageViewBinder(ResourcesMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 1117));
    }

    @Inject
    public StandardProfileImageViewBinder(Resources resources, Provider<FbDraweeControllerBuilder> provider) {
        this.f16592a = resources;
        this.f16593b = provider;
    }

    public static StandardProfileImageViewBinder m20643a(InjectorLike injectorLike) {
        return m20645b(injectorLike);
    }

    public final void m20646a(@Nullable ImageRequest imageRequest, @Nullable ImageRequest imageRequest2, boolean z, boolean z2, boolean z3, boolean z4, CallerContext callerContext, OnClickListener onClickListener, BaseControllerListener baseControllerListener, StandardProfileImageView standardProfileImageView) {
        standardProfileImageView.setEditAffordance(m20642a(z, z3, z4));
        if (!(imageRequest == null && imageRequest2 == null)) {
            standardProfileImageView.setController(m20644a(callerContext, baseControllerListener, imageRequest, imageRequest2, standardProfileImageView));
        }
        boolean z5 = z2 || z3;
        standardProfileImageView.setEnabled(z5);
        if (!z5) {
            onClickListener = null;
        }
        standardProfileImageView.setOnClickListener(onClickListener);
        standardProfileImageView.setContentDescription(z ? this.f16592a.getString(2131230849) : this.f16592a.getString(2131230842));
    }

    @Nullable
    private DraweeController m20644a(CallerContext callerContext, BaseControllerListener baseControllerListener, @Nullable ImageRequest imageRequest, @Nullable ImageRequest imageRequest2, StandardProfileImageView standardProfileImageView) {
        if (imageRequest == null && imageRequest2 == null) {
            return null;
        }
        return ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f16593b.get()).a(callerContext).b(standardProfileImageView.getController())).a(true)).d(imageRequest)).c(imageRequest2)).a(baseControllerListener)).s();
    }

    private static int m20642a(boolean z, boolean z2, boolean z3) {
        if (!z2 || !z) {
            return 0;
        }
        if (z3) {
            return 2;
        }
        return 1;
    }
}
