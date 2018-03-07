package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.common.endoffeed.EndOfFeedPartDefinition;
import com.facebook.feed.rows.sections.common.loadingmore.LoadingMorePartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.groups.feed.rows.partdefinitions.GenericGroupsFeedRootPartDefinition;
import com.facebook.groups.feed.rows.partdefinitions.GenericGroupsFeedRootPartDefinitionProvider;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ThreadViewLoader FETCH_MORE_MESSAGES  */
public class FB4AGroupsFeedRootPartDefinitionFactory {
    private static FB4AGroupsFeedRootPartDefinitionFactory f22426d;
    private static final Object f22427e = new Object();
    public final Lazy<LoadingMorePartDefinition> f22428a;
    public final Lazy<EndOfFeedPartDefinition> f22429b;
    public final GenericGroupsFeedRootPartDefinitionProvider f22430c;

    private static FB4AGroupsFeedRootPartDefinitionFactory m23507b(InjectorLike injectorLike) {
        return new FB4AGroupsFeedRootPartDefinitionFactory(IdBasedLazy.a(injectorLike, 6021), IdBasedLazy.a(injectorLike, 6020), (GenericGroupsFeedRootPartDefinitionProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(GenericGroupsFeedRootPartDefinitionProvider.class));
    }

    @Inject
    public FB4AGroupsFeedRootPartDefinitionFactory(Lazy<LoadingMorePartDefinition> lazy, Lazy<EndOfFeedPartDefinition> lazy2, GenericGroupsFeedRootPartDefinitionProvider genericGroupsFeedRootPartDefinitionProvider) {
        this.f22428a = lazy;
        this.f22429b = lazy2;
        this.f22430c = genericGroupsFeedRootPartDefinitionProvider;
    }

    public final Lazy<GenericGroupsFeedRootPartDefinition<FeedEnvironment>> m23508a(final Lazy<? extends MultiRowGroupPartDefinition<FeedProps<GraphQLStory>, ?, ? super FeedEnvironment>> lazy, @Nullable final Lazy<? extends MultiRowGroupPartDefinition<FeedProps<GraphQLStory>, ?, ? super FeedEnvironment>> lazy2) {
        return new Lazy<GenericGroupsFeedRootPartDefinition<FeedEnvironment>>(this) {
            final /* synthetic */ FB4AGroupsFeedRootPartDefinitionFactory f22425c;

            public Object get() {
                GenericGroupsFeedRootPartDefinitionProvider genericGroupsFeedRootPartDefinitionProvider = this.f22425c.f22430c;
                Lazy lazy = lazy;
                Lazy lazy2 = lazy2;
                Lazy lazy3 = this.f22425c.f22428a;
                return new GenericGroupsFeedRootPartDefinition(lazy, lazy2, lazy3, this.f22425c.f22429b, IdBasedLazy.a(genericGroupsFeedRootPartDefinitionProvider, 1666), IdBasedLazy.a(genericGroupsFeedRootPartDefinitionProvider, 6207), IdBasedLazy.a(genericGroupsFeedRootPartDefinitionProvider, 6348), IdBasedLazy.a(genericGroupsFeedRootPartDefinitionProvider, 6023));
            }
        };
    }

    public static FB4AGroupsFeedRootPartDefinitionFactory m23506a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FB4AGroupsFeedRootPartDefinitionFactory b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22427e) {
                FB4AGroupsFeedRootPartDefinitionFactory fB4AGroupsFeedRootPartDefinitionFactory;
                if (a2 != null) {
                    fB4AGroupsFeedRootPartDefinitionFactory = (FB4AGroupsFeedRootPartDefinitionFactory) a2.a(f22427e);
                } else {
                    fB4AGroupsFeedRootPartDefinitionFactory = f22426d;
                }
                if (fB4AGroupsFeedRootPartDefinitionFactory == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23507b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22427e, b3);
                        } else {
                            f22426d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = fB4AGroupsFeedRootPartDefinitionFactory;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
