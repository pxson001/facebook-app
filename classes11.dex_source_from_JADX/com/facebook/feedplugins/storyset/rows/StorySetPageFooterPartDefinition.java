package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
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
/* compiled from: authorization_pending */
public class StorySetPageFooterPartDefinition<E extends AnyEnvironment, V extends View> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static StorySetPageFooterPartDefinition f9720c;
    private static final Object f9721d = new Object();
    private final BlingBarPartDefinition f9722a;
    private final StorySetPageUFIPartDefinition f9723b;

    private static StorySetPageFooterPartDefinition m10177b(InjectorLike injectorLike) {
        return new StorySetPageFooterPartDefinition(BlingBarPartDefinition.a(injectorLike), StorySetPageUFIPartDefinition.m10193a(injectorLike));
    }

    public final Object m10178a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(2131562638, this.f9722a, new Props(feedProps, true));
        subParts.a(this.f9723b, feedProps);
        return null;
    }

    @Inject
    public StorySetPageFooterPartDefinition(BlingBarPartDefinition blingBarPartDefinition, StorySetPageUFIPartDefinition storySetPageUFIPartDefinition) {
        this.f9722a = blingBarPartDefinition;
        this.f9723b = storySetPageUFIPartDefinition;
    }

    public static StorySetPageFooterPartDefinition m10176a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetPageFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9721d) {
                StorySetPageFooterPartDefinition storySetPageFooterPartDefinition;
                if (a2 != null) {
                    storySetPageFooterPartDefinition = (StorySetPageFooterPartDefinition) a2.a(f9721d);
                } else {
                    storySetPageFooterPartDefinition = f9720c;
                }
                if (storySetPageFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10177b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9721d, b3);
                        } else {
                            f9720c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetPageFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
