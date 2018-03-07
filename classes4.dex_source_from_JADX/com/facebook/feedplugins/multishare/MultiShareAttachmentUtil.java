package com.facebook.feedplugins.multishare;

import android.net.Uri;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.ImageUtil;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: deny */
public class MultiShareAttachmentUtil {
    @Nullable
    public static GraphQLStoryAttachment m14783b(GraphQLStory graphQLStory) {
        ImmutableList ak = graphQLStory.ak();
        return (ak == null || ak.isEmpty()) ? null : (GraphQLStoryAttachment) ak.get(0);
    }

    @Nullable
    public static Uri m14782a(@Nullable GraphQLStoryAttachment graphQLStoryAttachment) {
        if (graphQLStoryAttachment == null || graphQLStoryAttachment.r() == null || graphQLStoryAttachment.r().aB() == null) {
            return null;
        }
        return ImageUtil.a(graphQLStoryAttachment.r().aB());
    }
}
