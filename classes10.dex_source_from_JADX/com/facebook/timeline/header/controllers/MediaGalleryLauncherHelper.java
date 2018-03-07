package com.facebook.timeline.header.controllers;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.DraweeView;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.MediaMetadataModel.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;

/* compiled from: forSalePostSellComposerActivity */
public class MediaGalleryLauncherHelper {

    /* compiled from: forSalePostSellComposerActivity */
    final class C16681 implements AnimationParamProvider {
        final /* synthetic */ String f11627a;
        final /* synthetic */ DraweeView f11628b;
        final /* synthetic */ ImageRequest f11629c;

        C16681(String str, DraweeView draweeView, ImageRequest imageRequest) {
            this.f11627a = str;
            this.f11628b = draweeView;
            this.f11629c = imageRequest;
        }

        public final AnimationParams m11669a(String str) {
            if (this.f11627a.equals(str)) {
                return new AnimationParams(DrawingRule.a(this.f11628b), this.f11629c);
            }
            return null;
        }
    }

    public static AnimationParamProvider m11671a(String str, DraweeView<GenericDraweeHierarchy> draweeView, ImageRequest imageRequest) {
        return new C16681(str, draweeView, imageRequest);
    }

    public static MediaMetadataModel m11670a(String str, DefaultImageFields defaultImageFields) {
        Builder builder = new Builder();
        builder.y = str;
        builder = builder;
        builder.A = DefaultImageFieldsModel.a(defaultImageFields);
        return builder.a();
    }
}
