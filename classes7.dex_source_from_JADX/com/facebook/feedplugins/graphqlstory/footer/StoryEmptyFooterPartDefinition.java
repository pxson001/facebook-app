package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
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
/* compiled from: Size of addChildTags != size of addAtIndices! */
public class StoryEmptyFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, HasPositionInformation, View> {
    public static final ViewType f23271a = new C20111();
    private static StoryEmptyFooterPartDefinition f23272c;
    private static final Object f23273d = new Object();
    private final BackgroundPartDefinition f23274b;

    /* compiled from: Size of addChildTags != size of addAtIndices! */
    final class C20111 extends ViewType {
        C20111() {
        }

        public final View m25637a(Context context) {
            return new View(context);
        }
    }

    private static StoryEmptyFooterPartDefinition m25639b(InjectorLike injectorLike) {
        return new StoryEmptyFooterPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m25641a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        GraphQLStory c = StoryProps.c(feedProps);
        BackgroundPartDefinition backgroundPartDefinition = this.f23274b;
        PaddingStyle paddingStyle = (PropertyHelper.b(graphQLStory) == null || c != null) ? PaddingStyle.a : PaddingStyle.o;
        subParts.a(backgroundPartDefinition, new StylingData(feedProps, paddingStyle));
        return null;
    }

    @Inject
    public StoryEmptyFooterPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f23274b = backgroundPartDefinition;
    }

    public final ViewType m25640a() {
        return f23271a;
    }

    public final boolean m25642a(Object obj) {
        return true;
    }

    public static StoryEmptyFooterPartDefinition m25638a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryEmptyFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23273d) {
                StoryEmptyFooterPartDefinition storyEmptyFooterPartDefinition;
                if (a2 != null) {
                    storyEmptyFooterPartDefinition = (StoryEmptyFooterPartDefinition) a2.a(f23273d);
                } else {
                    storyEmptyFooterPartDefinition = f23272c;
                }
                if (storyEmptyFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25639b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23273d, b3);
                        } else {
                            f23272c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyEmptyFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
