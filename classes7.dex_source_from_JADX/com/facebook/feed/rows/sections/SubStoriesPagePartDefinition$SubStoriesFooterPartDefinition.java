package com.facebook.feed.rows.sections;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.BasicFooterPartDefinition$Props;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;

/* compiled from: \b */
class SubStoriesPagePartDefinition$SubStoriesFooterPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultFooterView> {
    final /* synthetic */ SubStoriesPagePartDefinition f20461a;

    public SubStoriesPagePartDefinition$SubStoriesFooterPartDefinition(SubStoriesPagePartDefinition subStoriesPagePartDefinition) {
        this.f20461a = subStoriesPagePartDefinition;
    }

    public final Object m23543a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20461a.c, new Props(feedProps, FooterLevel.PAGE));
        subParts.a(this.f20461a.b, new BasicFooterPartDefinition$Props(feedProps, true));
        return null;
    }
}
