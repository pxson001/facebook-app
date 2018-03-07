package com.facebook.feed.collage;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentStyleInfo;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: odexSchemeName */
public class DefaultCollageLayoutProperties implements CollageLayoutProperties<StoryCollageItem> {
    private final FeedProps<GraphQLStoryAttachment> f6292a;
    private final PhotoGridProperties f6293b;
    private final ImmutableList<StoryCollageItem> f6294c;

    public final int mo556a(CollageItem collageItem) {
        return PhotoGridProperties.b((GraphQLStoryAttachment) ((StoryCollageItem) collageItem).f6295a.a);
    }

    public final int mo559b(CollageItem collageItem) {
        GraphQLStoryAttachmentStyleInfo a = GraphQLStoryAttachmentUtil.a((GraphQLStoryAttachment) ((StoryCollageItem) collageItem).f6295a.a);
        return a != null ? a.q() : 0;
    }

    public final int mo561c(CollageItem collageItem) {
        return PhotoGridProperties.d((GraphQLStoryAttachment) ((StoryCollageItem) collageItem).f6295a.a);
    }

    public final int mo562d(CollageItem collageItem) {
        return PhotoGridProperties.e((GraphQLStoryAttachment) ((StoryCollageItem) collageItem).f6295a.a);
    }

    @Inject
    public DefaultCollageLayoutProperties(PhotoGridProperties photoGridProperties, @Assisted FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f6292a = feedProps;
        this.f6293b = photoGridProperties;
        ImmutableList a = this.f6293b.a(feedProps);
        Builder builder = ImmutableList.builder();
        for (int i = 0; i < a.size(); i++) {
            builder.c(new StoryCollageItem((FeedProps) a.get(i)));
        }
        this.f6294c = builder.b();
    }

    public final ImmutableList<StoryCollageItem> mo557a() {
        return this.f6294c;
    }

    public final int mo558b() {
        Flattenable flattenable = this.f6292a.a;
        return 0;
    }

    public final int mo560c() {
        return this.f6293b.a((GraphQLStoryAttachment) this.f6292a.a);
    }
}
