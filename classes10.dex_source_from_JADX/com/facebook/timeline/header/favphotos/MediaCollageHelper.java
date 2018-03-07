package com.facebook.timeline.header.favphotos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.CollageLayoutFields;
import com.facebook.widget.mosaic.MosaicGridLayout.LayoutParams;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: field_types */
public class MediaCollageHelper {
    public static final LayoutParams f11718a = new LayoutParams(0, 0, 6, 6);
    private final Provider<FbDraweeControllerBuilder> f11719b;
    private final FavoritePhotosUtil f11720c;

    public static MediaCollageHelper m11810b(InjectorLike injectorLike) {
        return new MediaCollageHelper(IdBasedProvider.a(injectorLike, 1117), FavoritePhotosUtil.m11786a(injectorLike));
    }

    @Inject
    public MediaCollageHelper(Provider<FbDraweeControllerBuilder> provider, FavoritePhotosUtil favoritePhotosUtil) {
        this.f11719b = provider;
        this.f11720c = favoritePhotosUtil;
    }

    public final FbDraweeView m11812a(Context context, CallerContext callerContext, SizeAwareMedia sizeAwareMedia, @Nullable String str, CollageLayoutFields collageLayoutFields) {
        Drawable colorDrawable;
        FbDraweeView fbDraweeView = new FbDraweeView(context);
        GenericDraweeHierarchyBuilder g = new GenericDraweeHierarchyBuilder(context.getResources()).g(new ColorDrawable(context.getResources().getColor(2131362998)));
        if (str == null) {
            colorDrawable = new ColorDrawable(context.getResources().getColor(2131362148));
        } else {
            colorDrawable = new ColorDrawable(Color.parseColor("#" + str));
        }
        g.f = colorDrawable;
        fbDraweeView.setHierarchy(g.u());
        fbDraweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f11719b.get()).a(callerContext).b(m11811a(sizeAwareMedia, collageLayoutFields)).r().b(fbDraweeView.getController())).s());
        ((GenericDraweeHierarchy) fbDraweeView.getHierarchy()).a(m11808a(sizeAwareMedia));
        fbDraweeView.setLayoutParams(m11809a(collageLayoutFields));
        return fbDraweeView;
    }

    @Nullable
    public final Uri m11811a(SizeAwareMedia sizeAwareMedia, CollageLayoutFields collageLayoutFields) {
        DefaultImageFields a = this.f11720c.m11793a(sizeAwareMedia, collageLayoutFields);
        return a != null ? UriUtil.a(a.b()) : null;
    }

    private static PointF m11808a(SizeAwareMedia sizeAwareMedia) {
        if (sizeAwareMedia != null || sizeAwareMedia.c() == null) {
            return new PointF(0.5f, 0.5f);
        }
        return new PointF((float) sizeAwareMedia.c().a(), (float) sizeAwareMedia.c().b());
    }

    public static LayoutParams m11809a(CollageLayoutFields collageLayoutFields) {
        if (collageLayoutFields == null) {
            return f11718a;
        }
        return new LayoutParams((int) collageLayoutFields.c(), (int) collageLayoutFields.d(), (int) collageLayoutFields.b(), (int) collageLayoutFields.a());
    }
}
