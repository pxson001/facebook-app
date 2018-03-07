package com.facebook.feed.rows.sections.offline;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.footer.StoryEmptyFooterPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: UPSIDE_DOWN */
public class OfflineFooterSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static OfflineFooterSelector f21553c;
    private static final Object f21554d = new Object();
    private final StoryEmptyFooterPartDefinition f21555a;
    private final OfflineFooterPartDefinition<FeedEnvironment> f21556b;

    private static OfflineFooterSelector m24189b(InjectorLike injectorLike) {
        return new OfflineFooterSelector(OfflineFooterPartDefinition.m24182a(injectorLike), StoryEmptyFooterPartDefinition.m25638a(injectorLike));
    }

    public final Object m24190a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f21556b, feedProps).a(this.f21555a, feedProps);
        return null;
    }

    @Inject
    public OfflineFooterSelector(OfflineFooterPartDefinition offlineFooterPartDefinition, StoryEmptyFooterPartDefinition storyEmptyFooterPartDefinition) {
        this.f21555a = storyEmptyFooterPartDefinition;
        this.f21556b = offlineFooterPartDefinition;
    }

    public final boolean m24191a(Object obj) {
        return true;
    }

    public static OfflineFooterSelector m24188a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            OfflineFooterSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21554d) {
                OfflineFooterSelector offlineFooterSelector;
                if (a2 != null) {
                    offlineFooterSelector = (OfflineFooterSelector) a2.a(f21554d);
                } else {
                    offlineFooterSelector = f21553c;
                }
                if (offlineFooterSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24189b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21554d, b3);
                        } else {
                            f21553c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = offlineFooterSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
