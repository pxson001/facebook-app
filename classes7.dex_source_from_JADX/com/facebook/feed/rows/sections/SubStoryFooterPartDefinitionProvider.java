package com.facebook.feed.rows.sections;

import android.view.View;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: [createTargetProfileFromComposerTargetData] Empty targetName */
public class SubStoryFooterPartDefinitionProvider extends AbstractAssistedProvider<SubStoryFooterPartDefinition> {
    public final <V extends View & Footer> SubStoryFooterPartDefinition<V> m23557a(MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanShowVideoInFullScreen, V> multiRowSinglePartDefinition, FooterLevel footerLevel) {
        return new SubStoryFooterPartDefinition(FooterBackgroundPartDefinition.a(this), multiRowSinglePartDefinition, footerLevel);
    }
}
