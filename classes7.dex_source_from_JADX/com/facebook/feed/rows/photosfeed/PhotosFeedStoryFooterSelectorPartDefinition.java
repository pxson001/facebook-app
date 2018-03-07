package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: _updatePrivacySelector */
public class PhotosFeedStoryFooterSelectorPartDefinition<E extends CanFeedback & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static PhotosFeedStoryFooterSelectorPartDefinition f20291d;
    private static final Object f20292e = new Object();
    private final PhotosFeedStoryFooterPartDefinition f20293a;
    private final PhotosFeedStoryReactionsFooterPartDefinition f20294b;
    private final GraphQLStoryUtil f20295c;

    private static PhotosFeedStoryFooterSelectorPartDefinition m23419b(InjectorLike injectorLike) {
        return new PhotosFeedStoryFooterSelectorPartDefinition(PhotosFeedStoryFooterPartDefinition.m23412a(injectorLike), PhotosFeedStoryReactionsFooterPartDefinition.m23445a(injectorLike), GraphQLStoryUtil.a(injectorLike));
    }

    public final Object m23420a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20294b, feedProps).a(this.f20293a, feedProps);
        return null;
    }

    public final boolean m23421a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return (graphQLStory == null || graphQLStory.l() == null || !GraphQLStoryUtil.f(graphQLStory)) ? false : true;
    }

    @Inject
    public PhotosFeedStoryFooterSelectorPartDefinition(PhotosFeedStoryFooterPartDefinition photosFeedStoryFooterPartDefinition, PhotosFeedStoryReactionsFooterPartDefinition photosFeedStoryReactionsFooterPartDefinition, GraphQLStoryUtil graphQLStoryUtil) {
        this.f20293a = photosFeedStoryFooterPartDefinition;
        this.f20294b = photosFeedStoryReactionsFooterPartDefinition;
        this.f20295c = graphQLStoryUtil;
    }

    public static PhotosFeedStoryFooterSelectorPartDefinition m23418a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryFooterSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20292e) {
                PhotosFeedStoryFooterSelectorPartDefinition photosFeedStoryFooterSelectorPartDefinition;
                if (a2 != null) {
                    photosFeedStoryFooterSelectorPartDefinition = (PhotosFeedStoryFooterSelectorPartDefinition) a2.a(f20292e);
                } else {
                    photosFeedStoryFooterSelectorPartDefinition = f20291d;
                }
                if (photosFeedStoryFooterSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23419b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20292e, b3);
                        } else {
                            f20291d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryFooterSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
