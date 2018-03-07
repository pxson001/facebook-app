package com.facebook.feed.environment;

import android.view.View;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: nf */
public interface CanShowVideoInFullScreen extends AnyEnvironment {
    void mo2432a(GraphQLStoryAttachment graphQLStoryAttachment);

    void mo2433a(GraphQLStoryAttachment graphQLStoryAttachment, View view);

    void mo2443b(GraphQLStoryAttachment graphQLStoryAttachment);

    boolean mo2447c(GraphQLStoryAttachment graphQLStoryAttachment);
}
