package com.facebook.feed.rows.styling;

import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.graphql.model.GraphQLStoryAttachment;

/* compiled from: show_original_post_button */
public class BackgroundStyleUtil {
    public static PaddingStyle m4407a(FeedProps<GraphQLStoryAttachment> feedProps, PositionResolver positionResolver, HasPositionInformation hasPositionInformation) {
        if (BackgroundStyles.a(1, AttachmentProps.e(feedProps), null, positionResolver, hasPositionInformation.f(), hasPositionInformation.hK_(), hasPositionInformation.h(), hasPositionInformation.i(), hasPositionInformation.j()) == Position.BOTTOM) {
            return PaddingStyle.d;
        }
        return PaddingStyle.c;
    }
}
