package com.facebook.spherical.photo;

import com.facebook.graphql.model.GraphQLPhotoEncoding;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: hi_IN */
public class CubemapsUtil {
    private final Photos360QEHelper f21104a;

    @Inject
    public CubemapsUtil(Photos360QEHelper photos360QEHelper) {
        this.f21104a = photos360QEHelper;
    }

    public final CubeMapUris m28852a(GraphQLStoryAttachment graphQLStoryAttachment, int i) {
        int d;
        int f;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        if (i <= 2013) {
            d = this.f21104a.m28839d();
            f = this.f21104a.m28841f();
        } else {
            d = this.f21104a.m28840e();
            f = this.f21104a.m28842g();
        }
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        Object obj = 1;
        ImmutableList aI = graphQLStoryAttachment.m23979r().aI();
        int size = aI.size();
        int i5 = 0;
        while (i5 < size) {
            Object obj2;
            String str6;
            int i6;
            String str7;
            GraphQLPhotoEncoding graphQLPhotoEncoding = (GraphQLPhotoEncoding) aI.get(i5);
            if ("equirectangular".equals(graphQLPhotoEncoding.m27593l()) || !graphQLPhotoEncoding.m27593l().equals("cubestrip")) {
                obj2 = obj;
                str6 = str;
                i6 = i4;
                i4 = i3;
                i3 = i2;
                str7 = str5;
                str5 = str4;
                str4 = str3;
                str3 = str2;
            } else {
                String str8;
                str6 = graphQLPhotoEncoding.m27591j();
                int o = graphQLPhotoEncoding.m27596o();
                if (obj != null) {
                    i2 = Math.abs(o - d);
                    i4 = Math.abs(o - f);
                    obj2 = null;
                    i3 = i2;
                    str5 = str6;
                    str4 = str6;
                    i6 = o;
                    str7 = str6;
                } else {
                    int abs;
                    String str9;
                    if (Math.abs(o - d) < i2) {
                        i2 = Math.abs(o - d);
                        str4 = str6;
                    }
                    if (Math.abs(o - f) < i3) {
                        abs = Math.abs(o - f);
                        str9 = str6;
                    } else {
                        abs = i3;
                        str9 = str5;
                    }
                    if (o > i4) {
                        i4 = abs;
                        str5 = str4;
                        obj2 = obj;
                        str4 = str6;
                        i6 = o;
                        str8 = str9;
                        i3 = i2;
                        str7 = str8;
                    } else {
                        str5 = str4;
                        str4 = str3;
                        int i7 = abs;
                        obj2 = obj;
                        i6 = i4;
                        i4 = i7;
                        String str10 = str9;
                        i3 = i2;
                        str7 = str10;
                    }
                }
                if (i <= 2013) {
                    if (o == this.f21104a.m28839d()) {
                        str3 = str6;
                    } else {
                        str3 = str;
                    }
                    if (o == this.f21104a.m28841f()) {
                        str8 = str6;
                        str6 = str3;
                        str3 = str8;
                    }
                } else {
                    if (o == this.f21104a.m28840e()) {
                        str3 = str6;
                    } else {
                        str3 = str;
                    }
                    if (o == this.f21104a.m28842g()) {
                        str8 = str6;
                        str6 = str3;
                        str3 = str8;
                    }
                }
                str6 = str3;
                str3 = str2;
            }
            i5++;
            str = str6;
            str2 = str3;
            str3 = str4;
            str4 = str5;
            str5 = str7;
            i2 = i3;
            i3 = i4;
            i4 = i6;
            obj = obj2;
        }
        if (str != null) {
            str4 = str;
        }
        if (str2 != null) {
            str5 = str2;
        }
        return new CubeMapUris(str4, str5, str3);
    }
}
