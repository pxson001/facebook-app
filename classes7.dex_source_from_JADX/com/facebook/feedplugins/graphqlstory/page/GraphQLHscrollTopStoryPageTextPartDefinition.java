package com.facebook.feedplugins.graphqlstory.page;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FeedStoryPermalinkOnClickListenerProvider;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Searched too many bytes. */
public class GraphQLHscrollTopStoryPageTextPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, AnyEnvironment, TextView> {
    private static GraphQLHscrollTopStoryPageTextPartDefinition f23362d;
    private static final Object f23363e = new Object();
    private final FeedStoryPermalinkOnClickListenerProvider f23364a;
    private final TextPartDefinition f23365b;
    private final ClickListenerPartDefinition f23366c;

    private static GraphQLHscrollTopStoryPageTextPartDefinition m25691b(InjectorLike injectorLike) {
        return new GraphQLHscrollTopStoryPageTextPartDefinition((FeedStoryPermalinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedStoryPermalinkOnClickListenerProvider.class), TextPartDefinition.a(injectorLike), ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m25692a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f23365b, StoryTextHelper.a((GraphQLStory) feedProps.a));
        subParts.a(this.f23366c, this.f23364a.m24324a(feedProps));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m25693a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -547088792);
        ((TextView) view).setLines(2);
        Logger.a(8, EntryType.MARK_POP, -1261095635, a);
    }

    @Inject
    public GraphQLHscrollTopStoryPageTextPartDefinition(FeedStoryPermalinkOnClickListenerProvider feedStoryPermalinkOnClickListenerProvider, TextPartDefinition textPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f23364a = feedStoryPermalinkOnClickListenerProvider;
        this.f23365b = textPartDefinition;
        this.f23366c = clickListenerPartDefinition;
    }

    public static GraphQLHscrollTopStoryPageTextPartDefinition m25690a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLHscrollTopStoryPageTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23363e) {
                GraphQLHscrollTopStoryPageTextPartDefinition graphQLHscrollTopStoryPageTextPartDefinition;
                if (a2 != null) {
                    graphQLHscrollTopStoryPageTextPartDefinition = (GraphQLHscrollTopStoryPageTextPartDefinition) a2.a(f23363e);
                } else {
                    graphQLHscrollTopStoryPageTextPartDefinition = f23362d;
                }
                if (graphQLHscrollTopStoryPageTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25691b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23363e, b3);
                        } else {
                            f23362d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphQLHscrollTopStoryPageTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
