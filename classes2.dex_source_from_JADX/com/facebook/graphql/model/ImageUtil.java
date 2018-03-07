package com.facebook.graphql.model;

import android.net.Uri;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces$DefaultImageUriFields;
import javax.annotation.Nullable;

/* compiled from: is_active */
public class ImageUtil {
    private ImageUtil() {
    }

    public static Uri m26991a(CommonGraphQLInterfaces$DefaultImageUriFields commonGraphQLInterfaces$DefaultImageUriFields) {
        String b = commonGraphQLInterfaces$DefaultImageUriFields.mo2924b();
        if (b == null) {
            return null;
        }
        return Uri.parse(b);
    }

    @Nullable
    public static Uri m26990a(GraphQLImage graphQLImage) {
        Uri uri = PropertyHelper.m21261a((Object) graphQLImage).f14855d;
        if (uri != null) {
            return uri;
        }
        String b = graphQLImage.mo2924b();
        if (b == null) {
            return null;
        }
        uri = Uri.parse(b);
        PropertyHelper.m21261a((Object) graphQLImage).f14855d = uri;
        return uri;
    }
}
