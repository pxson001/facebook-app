package com.facebook.attachments;

import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.ufiservices.ui.UfiAttachmentStyleSupportDeclaration;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: profile_photo_method_extra */
public class AttachmentStyleUtil {
    public Set<GraphQLStoryAttachmentStyle> f7346a = Sets.a();

    public AttachmentStyleUtil(Set<AttachmentStyleSupportDeclaration> set) {
        Iterator it = set.iterator();
        while (it.hasNext()) {
            UfiAttachmentStyleSupportDeclaration ufiAttachmentStyleSupportDeclaration = (UfiAttachmentStyleSupportDeclaration) it.next();
            for (GraphQLStoryAttachmentStyle add : ImmutableList.of(GraphQLStoryAttachmentStyle.SHARE, GraphQLStoryAttachmentStyle.PHOTO, GraphQLStoryAttachmentStyle.VIDEO, GraphQLStoryAttachmentStyle.STICKER)) {
                this.f7346a.add(add);
            }
        }
        Preconditions.checkArgument(!this.f7346a.isEmpty(), "AttachmentStyleUtil has an empty supported style list.");
    }

    @VisibleForTesting
    private boolean m10450a(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        return graphQLStoryAttachmentStyle != GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE && this.f7346a.contains(graphQLStoryAttachmentStyle);
    }

    public final GraphQLStoryAttachmentStyle m10451a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return m10448a((FeedProps) feedProps, null);
    }

    private GraphQLStoryAttachmentStyle m10448a(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachmentStyle == GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        for (int indexOf = graphQLStoryAttachment.w().indexOf(graphQLStoryAttachmentStyle) + 1; indexOf < graphQLStoryAttachment.w().size(); indexOf++) {
            GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle2 = (GraphQLStoryAttachmentStyle) graphQLStoryAttachment.w().get(indexOf);
            if (graphQLStoryAttachmentStyle2 != null && m10450a(graphQLStoryAttachmentStyle2)) {
                return m10449a(graphQLStoryAttachmentStyle2, (FeedProps) feedProps);
            }
        }
        return GraphQLStoryAttachmentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    @Nullable
    private static GraphQLStoryAttachmentStyle m10449a(@Nullable GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle, FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        if (graphQLStoryAttachmentStyle != GraphQLStoryAttachmentStyle.SHARE_LARGE_IMAGE) {
            return graphQLStoryAttachmentStyle;
        }
        if (c.W() == null && c.aG() == null) {
            return graphQLStoryAttachmentStyle;
        }
        return GraphQLStoryAttachmentStyle.SHARE;
    }
}
