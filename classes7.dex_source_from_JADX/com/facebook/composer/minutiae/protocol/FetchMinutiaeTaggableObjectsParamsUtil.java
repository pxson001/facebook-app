package com.facebook.composer.minutiae.protocol;

import android.location.Location;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.protocol.FetchMinutiaeTaggableObjectsParams.Builder;
import javax.annotation.Nullable;

/* compiled from: timeline_staging_ground */
public class FetchMinutiaeTaggableObjectsParamsUtil {
    public static FetchMinutiaeTaggableObjectsParams m1668a(MinutiaeTaggableActivity minutiaeTaggableActivity, String str, @Nullable String str2, int i, String str3, String str4, String str5, boolean z, @Nullable Location location) {
        boolean z2 = minutiaeTaggableActivity.v() == null;
        Builder builder = new Builder();
        builder.f1630g = minutiaeTaggableActivity.j();
        builder = builder;
        builder.f1634k = minutiaeTaggableActivity.r();
        builder = builder;
        builder.f1633j = 10;
        builder = builder;
        builder.f1631h = str;
        builder = builder;
        builder.f1632i = str2;
        builder = builder;
        builder.f1624a = i;
        builder = builder;
        builder.f1626c = str3;
        builder = builder;
        builder.f1625b = str4;
        builder = builder;
        builder.f1635l = z2;
        Builder builder2 = builder;
        builder2.f1627d = str5;
        builder2 = builder2;
        builder2.f1628e = z;
        builder2 = builder2;
        builder2.f1629f = location;
        return builder2.m1666a();
    }

    private static FetchMinutiaeTaggableObjectsParams m1669a(MinutiaeTaggableActivity minutiaeTaggableActivity, String str, @Nullable String str2, int i, String str3, String str4, boolean z, @Nullable Location location) {
        return m1668a(minutiaeTaggableActivity, str, str2, i, str3, SafeUUIDGenerator.a().toString(), str4, z, location);
    }

    public static FetchMinutiaeTaggableObjectsParams m1667a(MinutiaeTaggableActivity minutiaeTaggableActivity, int i, @Nullable String str, boolean z, @Nullable Location location) {
        return m1669a(minutiaeTaggableActivity, null, null, i, str, "composer", z, location);
    }
}
