package com.facebook.feedplugins.attachments.multimedia;

import com.facebook.feed.collage.PhotoGridProperties;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: groups/files/<p$1> */
public class MultimediaAttachmentUtil {
    private final PhotoGridProperties f21593a;

    public static MultimediaAttachmentUtil m29294b(InjectorLike injectorLike) {
        return new MultimediaAttachmentUtil(PhotoGridProperties.m28823b(injectorLike));
    }

    @Inject
    public MultimediaAttachmentUtil(PhotoGridProperties photoGridProperties) {
        this.f21593a = photoGridProperties;
    }

    public final int m29295a(FeedProps<GraphQLStoryAttachment> feedProps) {
        int a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.f13444a;
        ImmutableList a2 = this.f21593a.m28829a((FeedProps) feedProps);
        int size = a2.size();
        if (graphQLStoryAttachment.m23987z() != null && graphQLStoryAttachment.m23987z().ew() != null) {
            a = graphQLStoryAttachment.m23987z().ew().m24477a() - a2.size();
        } else if (graphQLStoryAttachment.m23985x() == null) {
            return -1;
        } else {
            a = graphQLStoryAttachment.m23985x().size() - a2.size();
        }
        if (a > 0) {
            size--;
        }
        for (int i = 0; i < size; i++) {
            if (GraphQLStoryAttachmentUtil.m28055d((GraphQLStoryAttachment) ((FeedProps) a2.get(i)).f13444a)) {
                return i;
            }
        }
        return -1;
    }
}
