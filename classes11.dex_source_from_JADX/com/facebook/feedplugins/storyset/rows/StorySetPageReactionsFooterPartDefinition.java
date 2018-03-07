package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.pillsblingbar.ui.PillsBlingBarWithoutBackgroundPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: auth_fail */
public class StorySetPageReactionsFooterPartDefinition<E extends AnyEnvironment, V extends View> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static StorySetPageReactionsFooterPartDefinition f9737c;
    private static final Object f9738d = new Object();
    private final PillsBlingBarWithoutBackgroundPartDefinition f9739a;
    private final StorySetPageReactionsUFIPartDefinition f9740b;

    private static StorySetPageReactionsFooterPartDefinition m10183b(InjectorLike injectorLike) {
        return new StorySetPageReactionsFooterPartDefinition(PillsBlingBarWithoutBackgroundPartDefinition.b(injectorLike), StorySetPageReactionsUFIPartDefinition.m10185a(injectorLike));
    }

    public final Object m10184a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131567718, this.f9739a, feedProps);
        subParts.a(this.f9740b, feedProps);
        return null;
    }

    @Inject
    public StorySetPageReactionsFooterPartDefinition(PillsBlingBarWithoutBackgroundPartDefinition pillsBlingBarWithoutBackgroundPartDefinition, StorySetPageReactionsUFIPartDefinition storySetPageReactionsUFIPartDefinition) {
        this.f9739a = pillsBlingBarWithoutBackgroundPartDefinition;
        this.f9740b = storySetPageReactionsUFIPartDefinition;
    }

    public static StorySetPageReactionsFooterPartDefinition m10182a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageReactionsFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9738d) {
                StorySetPageReactionsFooterPartDefinition storySetPageReactionsFooterPartDefinition;
                if (a2 != null) {
                    storySetPageReactionsFooterPartDefinition = (StorySetPageReactionsFooterPartDefinition) a2.a(f9738d);
                } else {
                    storySetPageReactionsFooterPartDefinition = f9737c;
                }
                if (storySetPageReactionsFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10183b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9738d, b3);
                        } else {
                            f9737c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageReactionsFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
