package com.facebook.friendsharing.gif.util;

import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.google.common.collect.ImmutableList;
import java.util.Locale;
import javax.annotation.Nullable;

/* compiled from: remixable_uri */
public class GifUtil {
    public static boolean m5793a(@Nullable ComposerShareParams composerShareParams) {
        return (composerShareParams == null || composerShareParams.linkForShare == null || !composerShareParams.linkForShare.toLowerCase(Locale.US).endsWith(".gif")) ? false : true;
    }

    public static GraphQLStoryAttachment m5794b(@Nullable ComposerShareParams composerShareParams) {
        if (!m5793a(composerShareParams)) {
            return null;
        }
        Uri build = new Builder().appendPath("https://www.facebook.com/safe_image.php?").appendQueryParameter("url", composerShareParams.linkForShare.toString()).build();
        GraphQLImage.Builder builder = new GraphQLImage.Builder();
        builder.g = build.toString();
        GraphQLImage a = builder.a();
        GraphQLMedia.Builder builder2 = new GraphQLMedia.Builder();
        builder2.N = a;
        GraphQLMedia a2 = builder2.a();
        GraphQLStoryAttachment.Builder builder3 = new GraphQLStoryAttachment.Builder();
        builder3.w = composerShareParams.linkForShare.toString();
        builder3 = builder3;
        builder3.q = ImmutableList.of(GraphQLStoryAttachmentStyle.IMAGE_SHARE, GraphQLStoryAttachmentStyle.SHARE);
        builder3 = builder3;
        builder3.l = a2;
        return builder3.a();
    }
}
