package com.facebook.video.util;

import com.facebook.common.util.StringLocaleUtil;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: location_services */
public class VideoPlayerUtils {
    public static String m11486a(int i) {
        if (i <= 0) {
            return null;
        }
        int i2 = (i % 3600) / 60;
        int i3 = i % 60;
        if (i / 3600 > 0) {
            return StringLocaleUtil.a("%d:%02d:%02d", new Object[]{Integer.valueOf(i / 3600), Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        return StringLocaleUtil.a("%d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    @Nullable
    public static String m11487a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null) {
            return null;
        }
        String A = graphQLStoryAttachment.A();
        if (!Strings.isNullOrEmpty(A)) {
            return A;
        }
        if (graphQLStoryAttachment.n() != null) {
            A = Objects.toStringHelper(GraphQLTextWithEntities.class).add("text", graphQLStoryAttachment.n().a()).toString();
        } else {
            A = null;
        }
        if (!Strings.isNullOrEmpty(A)) {
            return A;
        }
        A = (graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().eD() == null) ? null : graphQLStoryAttachment.z().eD().a();
        if (Strings.isNullOrEmpty(A)) {
            return null;
        }
        return A;
    }
}
