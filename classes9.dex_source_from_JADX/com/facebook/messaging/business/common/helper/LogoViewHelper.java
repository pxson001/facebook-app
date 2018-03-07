package com.facebook.messaging.business.common.helper;

import android.content.res.Resources;
import android.net.Uri;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.CommerceThreadFragmentsInterfaces.LogoImage;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_request_success */
public class LogoViewHelper {
    private int f8756a;
    private int f8757b;
    private int f8758c;
    private boolean f8759d = false;
    private int f8760e;

    public static LogoViewHelper m9022b(InjectorLike injectorLike) {
        return new LogoViewHelper(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public LogoViewHelper(Resources resources) {
        this.f8757b = resources.getDimensionPixelSize(2131430966);
        this.f8756a = resources.getDimensionPixelSize(2131430967);
        this.f8758c = resources.getColor(2131361871);
    }

    public final void m9023a(@Nullable LogoImage logoImage, FbDraweeView fbDraweeView, CallerContext callerContext) {
        if (logoImage == null || logoImage.b() == null) {
            fbDraweeView.setVisibility(8);
            return;
        }
        fbDraweeView.a(Uri.parse(logoImage.b()), callerContext);
        fbDraweeView.setBackgroundResource(this.f8758c);
        fbDraweeView.setVisibility(0);
        if (logoImage.c() > 0 && logoImage.a() > 0) {
            LayoutParams layoutParams = fbDraweeView.getLayoutParams();
            layoutParams.width = Math.min(logoImage.c(), this.f8756a);
            layoutParams.height = Math.min(logoImage.a(), this.f8757b);
            fbDraweeView.setLayoutParams(layoutParams);
        }
        if (this.f8759d) {
            fbDraweeView.setColorFilter(this.f8760e);
        }
    }
}
