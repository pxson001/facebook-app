package com.facebook.timeline.util;

import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import javax.annotation.Nullable;

/* compiled from: ui_switch */
public class ProfileMosaicUtil {
    @Nullable
    public static DefaultImageFields m1211a(SizeAwareMedia sizeAwareMedia, int i, int i2, int i3) {
        if (i == i2 && sizeAwareMedia.g() != null) {
            return sizeAwareMedia.g();
        }
        int round = Math.round((((float) i) / ((float) i2)) * ((float) i3));
        if (sizeAwareMedia.bd_() == null || sizeAwareMedia.bd_().c() < round) {
            return sizeAwareMedia.bc_() != null ? sizeAwareMedia.bc_() : sizeAwareMedia.g();
        } else {
            return sizeAwareMedia.bd_();
        }
    }
}
