package com.facebook.feedplugins.graphqlstory.page;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
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
import javax.inject.Inject;

@ContextScoped
/* compiled from: SearchGifsTask */
public class GraphQLStoryPageTextPartDefinition extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, OnClickListener, AnyEnvironment, TextView> {
    private static GraphQLStoryPageTextPartDefinition f23367b;
    private static final Object f23368c = new Object();
    private final FeedStoryPermalinkOnClickListenerProvider f23369a;

    private static GraphQLStoryPageTextPartDefinition m25695b(InjectorLike injectorLike) {
        return new GraphQLStoryPageTextPartDefinition((FeedStoryPermalinkOnClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedStoryPermalinkOnClickListenerProvider.class));
    }

    public final Object m25696a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return this.f23369a.m24324a((FeedProps) obj);
    }

    public final /* bridge */ /* synthetic */ void m25697a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1586409746);
        FeedProps feedProps = (FeedProps) obj;
        OnClickListener onClickListener = (OnClickListener) obj2;
        TextView textView = (TextView) view;
        textView.setLines(3);
        textView.setText(StoryTextHelper.a((GraphQLStory) feedProps.a));
        textView.setOnClickListener(onClickListener);
        Logger.a(8, EntryType.MARK_POP, 2061109495, a);
    }

    public final void m25698b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TextView) view).setOnClickListener(null);
    }

    @Inject
    public GraphQLStoryPageTextPartDefinition(FeedStoryPermalinkOnClickListenerProvider feedStoryPermalinkOnClickListenerProvider) {
        this.f23369a = feedStoryPermalinkOnClickListenerProvider;
    }

    public static GraphQLStoryPageTextPartDefinition m25694a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GraphQLStoryPageTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23368c) {
                GraphQLStoryPageTextPartDefinition graphQLStoryPageTextPartDefinition;
                if (a2 != null) {
                    graphQLStoryPageTextPartDefinition = (GraphQLStoryPageTextPartDefinition) a2.a(f23368c);
                } else {
                    graphQLStoryPageTextPartDefinition = f23367b;
                }
                if (graphQLStoryPageTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25695b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23368c, b3);
                        } else {
                            f23367b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = graphQLStoryPageTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
