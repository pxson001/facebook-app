package com.facebook.feedplugins.attachments.video;

import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoDisplayedInfo;
import com.facebook.video.analytics.VideoDisplayedInfo.AutoPlayFailureReason;
import com.facebook.video.engine.VideoPlayerParams;
import java.util.HashSet;
import java.util.Set;

/* compiled from: TEXT_FIELD_ERROR */
public final class Inline360VideoPartDefinition$State {
    private final FeedProps<GraphQLStoryAttachment> f22738a;
    private final GraphQLStory f22739b;
    public final VideoAttachmentDelegate f22740c;
    private final GraphQLVideo f22741d;
    public final VideoPlayerParams f22742e;
    public final VideoDisplayedInfo f22743f;
    public final AutoplayStateManager f22744g;
    public final InlineVideoPersistentState f22745h;
    public final Set<AutoPlayFailureReason> f22746i = new HashSet();
    public boolean f22747j;
    public boolean f22748k;
    public Inline360VideoPartDefinition$Inline360AutoplayVisibilityRunnable f22749l;
    public PlayerOrigin f22750m;

    public Inline360VideoPartDefinition$State(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStory graphQLStory, GraphQLVideo graphQLVideo, VideoAttachmentDelegate videoAttachmentDelegate, VideoPlayerParams videoPlayerParams, VideoDisplayedInfo videoDisplayedInfo, AutoplayStateManager autoplayStateManager, InlineVideoPersistentState inlineVideoPersistentState) {
        this.f22738a = feedProps;
        this.f22739b = graphQLStory;
        this.f22741d = graphQLVideo;
        this.f22740c = videoAttachmentDelegate;
        this.f22742e = videoPlayerParams;
        this.f22743f = videoDisplayedInfo;
        this.f22744g = autoplayStateManager;
        this.f22745h = inlineVideoPersistentState;
        this.f22750m = PlayerOrigin.UNKNOWN;
    }
}
