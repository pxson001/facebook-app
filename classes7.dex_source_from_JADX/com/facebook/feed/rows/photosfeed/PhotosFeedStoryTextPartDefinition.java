package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.sections.text.BaseTextPartDefinition;
import com.facebook.feed.rows.sections.text.BaseTextPartDefinitionProvider;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.ContentTextView;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: _id DESC LIMIT 1 */
public class PhotosFeedStoryTextPartDefinition<E extends HasContext & HasFeedListType & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, ContentTextView> {
    private static PhotosFeedStoryTextPartDefinition f20332d;
    private static final Object f20333e = new Object();
    private final BaseTextPartDefinition<E> f20334a;
    private final PhotosFeedBackgroundPartDefinition f20335b;
    private final FeedStoryUtil f20336c;

    private static PhotosFeedStoryTextPartDefinition m23460b(InjectorLike injectorLike) {
        return new PhotosFeedStoryTextPartDefinition(FeedStoryUtil.a(injectorLike), (BaseTextPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(BaseTextPartDefinitionProvider.class), PhotosFeedBackgroundPartDefinition.m23327a(injectorLike));
    }

    public final Object m23462a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20335b, new StylingData(feedProps, PaddingStyle.e));
        subParts.a(this.f20334a, feedProps);
        return null;
    }

    @Inject
    public PhotosFeedStoryTextPartDefinition(FeedStoryUtil feedStoryUtil, BaseTextPartDefinitionProvider baseTextPartDefinitionProvider, PhotosFeedBackgroundPartDefinition photosFeedBackgroundPartDefinition) {
        this.f20336c = feedStoryUtil;
        this.f20334a = baseTextPartDefinitionProvider.a(Boolean.valueOf(false));
        this.f20335b = photosFeedBackgroundPartDefinition;
    }

    public final ViewType m23461a() {
        return BaseTextPartDefinition.a;
    }

    public static PhotosFeedStoryTextPartDefinition m23459a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20333e) {
                PhotosFeedStoryTextPartDefinition photosFeedStoryTextPartDefinition;
                if (a2 != null) {
                    photosFeedStoryTextPartDefinition = (PhotosFeedStoryTextPartDefinition) a2.a(f20333e);
                } else {
                    photosFeedStoryTextPartDefinition = f20332d;
                }
                if (photosFeedStoryTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23460b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20333e, b3);
                        } else {
                            f20332d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23463a(FeedProps<GraphQLStory> feedProps) {
        return FeedStoryUtil.b((GraphQLStory) feedProps.a);
    }
}
