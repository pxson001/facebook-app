package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.FooterBackgroundPartDefinition.Props;
import com.facebook.feedplugins.graphqlstory.footer.FooterPartDefinition;
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
/* compiled from: a JSCHeapCapture registered more than once */
public class PhotosFeedStoryFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, AnyEnvironment, DefaultFooterView> {
    private static PhotosFeedStoryFooterPartDefinition f20286d;
    private static final Object f20287e = new Object();
    private final GraphQLStoryUtil f20288a;
    private final FooterBackgroundPartDefinition<DefaultFooterView> f20289b;
    private final FooterPartDefinition f20290c;

    private static PhotosFeedStoryFooterPartDefinition m23414b(InjectorLike injectorLike) {
        return new PhotosFeedStoryFooterPartDefinition(FooterPartDefinition.a(injectorLike), GraphQLStoryUtil.a(injectorLike), FooterBackgroundPartDefinition.a(injectorLike));
    }

    public final Object m23416a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20290c, feedProps);
        subParts.a(this.f20289b, new Props(feedProps, FooterLevel.PHOTOS_FEED));
        return null;
    }

    public final boolean m23417a(Object obj) {
        return m23413a((GraphQLStory) ((FeedProps) obj).a, this.f20288a);
    }

    @Inject
    public PhotosFeedStoryFooterPartDefinition(FooterPartDefinition footerPartDefinition, GraphQLStoryUtil graphQLStoryUtil, FooterBackgroundPartDefinition footerBackgroundPartDefinition) {
        this.f20288a = graphQLStoryUtil;
        this.f20289b = footerBackgroundPartDefinition;
        this.f20290c = footerPartDefinition;
    }

    public final ViewType<DefaultFooterView> m23415a() {
        return DefaultFooterView.a;
    }

    public static boolean m23413a(GraphQLStory graphQLStory, GraphQLStoryUtil graphQLStoryUtil) {
        return (graphQLStory == null || graphQLStory.l() == null || !GraphQLStoryUtil.f(graphQLStory)) ? false : true;
    }

    public static PhotosFeedStoryFooterPartDefinition m23412a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20287e) {
                PhotosFeedStoryFooterPartDefinition photosFeedStoryFooterPartDefinition;
                if (a2 != null) {
                    photosFeedStoryFooterPartDefinition = (PhotosFeedStoryFooterPartDefinition) a2.a(f20287e);
                } else {
                    photosFeedStoryFooterPartDefinition = f20286d;
                }
                if (photosFeedStoryFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23414b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20287e, b3);
                        } else {
                            f20286d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
