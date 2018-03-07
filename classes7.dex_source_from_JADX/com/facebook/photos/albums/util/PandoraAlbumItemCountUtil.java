package com.facebook.photos.albums.util;

import android.content.Context;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.graphql.model.GraphQLAlbum;

/* compiled from: magic_stories_kit_add_assets */
public class PandoraAlbumItemCountUtil {
    public static String m11419a(GraphQLAlbum graphQLAlbum, Context context) {
        if (graphQLAlbum.w() == null) {
            return null;
        }
        if (graphQLAlbum.w().a() == 0) {
            return context.getResources().getString(2131234347);
        }
        int a;
        if (graphQLAlbum.C() != null) {
            a = graphQLAlbum.C().a();
        } else {
            a = 0;
        }
        int a2 = graphQLAlbum.w().a() - a;
        String quantityString = context.getResources().getQuantityString(2131689584, a, new Object[]{Integer.valueOf(a)});
        String quantityString2 = context.getResources().getQuantityString(2131689586, a2, new Object[]{Integer.valueOf(a2)});
        if (a == 0) {
            return quantityString2;
        }
        if (a2 == 0) {
            return quantityString;
        }
        return StringFormatUtil.a("%s, %s", new Object[]{quantityString, quantityString2});
    }
}
