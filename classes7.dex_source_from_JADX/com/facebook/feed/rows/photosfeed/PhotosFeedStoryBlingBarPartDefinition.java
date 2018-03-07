package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedBackgroundPartDefinition.StylingData;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.base.blingbar.ui.DefaultBlingBarView;
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
/* compiled from: a1e5f074e6742242890e9a015eb74f46 */
public class PhotosFeedStoryBlingBarPartDefinition<E extends HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, DefaultBlingBarView> {
    private static PhotosFeedStoryBlingBarPartDefinition f20278c;
    private static final Object f20279d = new Object();
    private final PhotosFeedBackgroundPartDefinition f20280a;
    private final BlingBarPartDefinition f20281b;

    private static PhotosFeedStoryBlingBarPartDefinition m23404b(InjectorLike injectorLike) {
        return new PhotosFeedStoryBlingBarPartDefinition(PhotosFeedBackgroundPartDefinition.m23327a(injectorLike), BlingBarPartDefinition.m25426a(injectorLike));
    }

    public final Object m23406a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f20280a, new StylingData(feedProps, BlingBarRootPartDefinition.f22896a));
        subParts.a(this.f20281b, new Props(feedProps, BlingBarAnimationsPartDefinition.m25423a(graphQLStory)));
        return null;
    }

    @Inject
    public PhotosFeedStoryBlingBarPartDefinition(PhotosFeedBackgroundPartDefinition photosFeedBackgroundPartDefinition, BlingBarPartDefinition blingBarPartDefinition) {
        this.f20280a = photosFeedBackgroundPartDefinition;
        this.f20281b = blingBarPartDefinition;
    }

    public final ViewType m23405a() {
        return DefaultBlingBarView.f22918a;
    }

    public final boolean m23407a(Object obj) {
        return true;
    }

    public static PhotosFeedStoryBlingBarPartDefinition m23403a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotosFeedStoryBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20279d) {
                PhotosFeedStoryBlingBarPartDefinition photosFeedStoryBlingBarPartDefinition;
                if (a2 != null) {
                    photosFeedStoryBlingBarPartDefinition = (PhotosFeedStoryBlingBarPartDefinition) a2.a(f20279d);
                } else {
                    photosFeedStoryBlingBarPartDefinition = f20278c;
                }
                if (photosFeedStoryBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23404b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20279d, b3);
                        } else {
                            f20278c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photosFeedStoryBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
