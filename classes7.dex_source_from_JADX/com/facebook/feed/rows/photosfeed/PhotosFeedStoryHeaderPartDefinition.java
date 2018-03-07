package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.sections.header.BaseHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.feed.rows.styling.PaddingStyle;
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
/* compiled from: _setBroadcastData */
public class PhotosFeedStoryHeaderPartDefinition<E extends HasFeedListType & HasMenuButtonProvider & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithTextLayout> {
    private static PhotosFeedStoryHeaderPartDefinition f20311c;
    private static final Object f20312d = new Object();
    private final BaseHeaderPartDefinition f20313a;
    private final PhotosFeedBackgroundPartDefinition f20314b;

    private static PhotosFeedStoryHeaderPartDefinition m23435b(InjectorLike injectorLike) {
        return new PhotosFeedStoryHeaderPartDefinition(BaseHeaderPartDefinition.a(injectorLike), PhotosFeedBackgroundPartDefinition.m23327a(injectorLike));
    }

    public final Object m23437a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f20313a, feedProps);
        subParts.a(this.f20314b, new StylingData(feedProps, PaddingStyle.i));
        return null;
    }

    @Inject
    public PhotosFeedStoryHeaderPartDefinition(BaseHeaderPartDefinition baseHeaderPartDefinition, PhotosFeedBackgroundPartDefinition photosFeedBackgroundPartDefinition) {
        this.f20313a = baseHeaderPartDefinition;
        this.f20314b = photosFeedBackgroundPartDefinition;
    }

    public final ViewType m23436a() {
        return this.f20313a.a();
    }

    public final boolean m23438a(FeedProps<GraphQLStory> feedProps) {
        return BaseHeaderPartDefinition.b(feedProps);
    }

    public static PhotosFeedStoryHeaderPartDefinition m23434a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20312d) {
                PhotosFeedStoryHeaderPartDefinition photosFeedStoryHeaderPartDefinition;
                if (a2 != null) {
                    photosFeedStoryHeaderPartDefinition = (PhotosFeedStoryHeaderPartDefinition) a2.a(f20312d);
                } else {
                    photosFeedStoryHeaderPartDefinition = f20311c;
                }
                if (photosFeedStoryHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23435b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20312d, b3);
                        } else {
                            f20311c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
