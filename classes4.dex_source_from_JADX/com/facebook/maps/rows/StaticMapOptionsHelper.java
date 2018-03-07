package com.facebook.maps.rows;

import android.graphics.RectF;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.inject.InjectorLike;
import javax.annotation.Nullable;

/* compiled from: download_image_info */
public final class StaticMapOptionsHelper {
    public static StaticMapOptionsHelper m14456a(InjectorLike injectorLike) {
        return new StaticMapOptionsHelper();
    }

    public static StaticMapOptions m14455a(@Nullable GraphQLGeoRectangle graphQLGeoRectangle, String str, GraphQLLocation graphQLLocation) {
        RectF rectF;
        if (graphQLGeoRectangle == null) {
            rectF = null;
        } else {
            rectF = new RectF((float) graphQLGeoRectangle.l(), (float) graphQLGeoRectangle.j(), (float) graphQLGeoRectangle.a(), (float) graphQLGeoRectangle.k());
        }
        RectF rectF2 = rectF;
        StaticMapOptions staticMapOptions = new StaticMapOptions(str);
        if (rectF2 != null) {
            return staticMapOptions.m14297a(rectF2);
        }
        return staticMapOptions.m14294a(graphQLLocation.a(), graphQLLocation.b()).m14296a(13);
    }
}
