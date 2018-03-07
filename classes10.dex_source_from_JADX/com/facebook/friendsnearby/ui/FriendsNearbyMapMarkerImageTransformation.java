package com.facebook.friendsnearby.ui;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.SizeUtil;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.RoundedDrawHelper;
import com.facebook.widget.RoundedDrawParams;
import com.facebook.widget.RoundedDrawSizeParams;
import com.facebook.widget.RoundedDrawSizeParams.ScaleType;
import javax.inject.Inject;

/* compiled from: WebServiceHandler */
public class FriendsNearbyMapMarkerImageTransformation {
    public final Drawable f20980a;
    public final RoundedDrawHelper f20981b;
    public final int f20982c;
    public final PlatformBitmapFactory f20983d;

    public static FriendsNearbyMapMarkerImageTransformation m21963b(InjectorLike injectorLike) {
        return new FriendsNearbyMapMarkerImageTransformation(ResourcesMethodAutoProvider.a(injectorLike), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FriendsNearbyMapMarkerImageTransformation(Resources resources, PlatformBitmapFactory platformBitmapFactory) {
        this.f20983d = platformBitmapFactory;
        this.f20980a = resources.getDrawable(2130840474);
        this.f20982c = SizeUtil.a(resources, 4.0f);
        int intrinsicWidth = this.f20980a.getIntrinsicWidth();
        int intrinsicHeight = this.f20980a.getIntrinsicHeight();
        this.f20980a.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        this.f20981b = new RoundedDrawHelper(RoundedDrawParams.a(), new RoundedDrawSizeParams(intrinsicWidth - (this.f20982c * 2), intrinsicHeight - (this.f20982c * 2), 0, 0, 0, 0, ScaleType.CENTER_CROP));
    }
}
