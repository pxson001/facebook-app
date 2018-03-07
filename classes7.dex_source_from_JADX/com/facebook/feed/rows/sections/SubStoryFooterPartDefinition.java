package com.facebook.feed.rows.sections;

import android.view.View;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.Assisted;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

/* compiled from: [createTargetProfileFromComposerTargetData] Empty targetProfilePicUrl */
public class SubStoryFooterPartDefinition<V extends View & Footer> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanShowVideoInFullScreen, V> {
    private final FooterBackgroundPartDefinition<V> f20466a;
    private final MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanShowVideoInFullScreen, V> f20467b;
    private final FooterLevel f20468c;

    public final Object m23555a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20467b, feedProps);
        subParts.a(this.f20466a, new Props(feedProps, this.f20468c));
        return null;
    }

    public final boolean m23556a(Object obj) {
        return this.f20467b.a((FeedProps) obj);
    }

    @Inject
    public SubStoryFooterPartDefinition(FooterBackgroundPartDefinition footerBackgroundPartDefinition, @Assisted MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, CanShowVideoInFullScreen, V> multiRowSinglePartDefinition, @Assisted FooterLevel footerLevel) {
        this.f20467b = multiRowSinglePartDefinition;
        this.f20466a = footerBackgroundPartDefinition;
        this.f20468c = footerLevel;
    }

    public final ViewType<V> m23554a() {
        return this.f20467b.a();
    }
}
