package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.feedbackreactions.ReactionsFooterPartDefinition;
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: _onBroadcastCompleted */
public class PhotosFeedStoryReactionsFooterPartDefinition<E extends CanFeedback & CanShowVideoInFullScreen & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ReactionsFooterView> {
    private static PhotosFeedStoryReactionsFooterPartDefinition f20319d;
    private static final Object f20320e = new Object();
    private final ReactionsFooterPartDefinition f20321a;
    private final FooterBackgroundPartDefinition<ReactionsFooterView> f20322b;
    private final GraphQLStoryUtil f20323c;

    private static PhotosFeedStoryReactionsFooterPartDefinition m23446b(InjectorLike injectorLike) {
        return new PhotosFeedStoryReactionsFooterPartDefinition(ReactionsFooterPartDefinition.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike), GraphQLStoryUtil.a(injectorLike));
    }

    public final Object m23448a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20321a, feedProps);
        subParts.a(this.f20322b, new Props(feedProps, FooterLevel.TOP));
        return null;
    }

    public final boolean m23449a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return PhotosFeedStoryFooterPartDefinition.m23413a(graphQLStory, this.f20323c) && graphQLStory.l() != null && graphQLStory.l().n();
    }

    @Inject
    public PhotosFeedStoryReactionsFooterPartDefinition(ReactionsFooterPartDefinition reactionsFooterPartDefinition, FooterBackgroundPartDefinition footerBackgroundPartDefinition, GraphQLStoryUtil graphQLStoryUtil) {
        this.f20321a = reactionsFooterPartDefinition;
        this.f20322b = footerBackgroundPartDefinition;
        this.f20323c = graphQLStoryUtil;
    }

    public final ViewType<ReactionsFooterView> m23447a() {
        return ReactionsFooterView.h;
    }

    public static PhotosFeedStoryReactionsFooterPartDefinition m23445a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20320e) {
                PhotosFeedStoryReactionsFooterPartDefinition photosFeedStoryReactionsFooterPartDefinition;
                if (a2 != null) {
                    photosFeedStoryReactionsFooterPartDefinition = (PhotosFeedStoryReactionsFooterPartDefinition) a2.a(f20320e);
                } else {
                    photosFeedStoryReactionsFooterPartDefinition = f20319d;
                }
                if (photosFeedStoryReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23446b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20320e, b3);
                        } else {
                            f20319d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
