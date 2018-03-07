package com.facebook.pages.common.services;

import android.net.Uri;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel.OrderedImagesModel;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel.OrderedImagesModel.ImageModel;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: rootca_event */
public class PagesServiceUtils {
    @Nullable
    public static Uri m3305a(PageServiceItemModel pageServiceItemModel) {
        if (!pageServiceItemModel.g().isEmpty()) {
            ImageModel a = ((OrderedImagesModel) pageServiceItemModel.g().get(0)).a();
            if (!(a == null || Strings.isNullOrEmpty(a.a()))) {
                return Uri.parse(a.a());
            }
        }
        return null;
    }
}
