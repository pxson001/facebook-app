package com.facebook.intent.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.common.uri.NativeUri;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLComment;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTopic;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Map;
import javax.annotation.Nullable;

@DoNotStrip
/* compiled from: java.io.ObjectOutputStream */
public interface IFeedIntentBuilder {
    Intent mo3004a();

    Intent mo3005a(long j, String str, FullscreenGallerySource fullscreenGallerySource);

    Intent mo3006a(GraphQLFeedback graphQLFeedback, String str);

    Intent mo3007a(GraphQLStory graphQLStory);

    Intent mo3008a(GraphQLStory graphQLStory, FeedListName feedListName);

    Intent mo3009a(GraphQLStory graphQLStory, String str);

    Intent mo3010a(GraphQLTopic graphQLTopic);

    Intent mo3011a(String str);

    Intent mo3012a(String str, @Nullable GraphQLComment graphQLComment, String str2, String str3, boolean z, FeedbackLoggingParams feedbackLoggingParams);

    Builder mo3013a(FeedProps<GraphQLStory> feedProps, ComposerSourceType composerSourceType);

    Builder mo3014a(String str, ComposerSourceType composerSourceType);

    boolean mo3015a(Context context, NativeUri nativeUri);

    boolean mo3016a(Context context, String str);

    boolean mo3017a(Context context, String str, Bundle bundle, Map<String, Object> map);

    Intent mo3018b();

    Intent mo3019b(Context context, String str);

    Intent mo3020b(String str);

    Builder mo3021b(GraphQLStory graphQLStory);
}
