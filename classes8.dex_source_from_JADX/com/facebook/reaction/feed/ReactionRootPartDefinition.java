package com.facebook.reaction.feed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.NewsFeedRootGroupPartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.environment.HasReactionCardContainer;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.nodes.ReactionPagesFeedStoryNode;
import com.facebook.reaction.feed.pages.ReactionPagesPinnedPostGroupPartDefinition;
import com.facebook.reaction.feed.rows.ReactionStoryUnitSelectorPartDefinition;
import com.facebook.reaction.feed.rows.ReactionUnitStackPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionPlaceholderPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionVerticalComponentsNoBottomGapGroupPartDefinition;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionVerticalComponentsSelectorPartDefinition;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.google.common.base.Preconditions;
import java.util.EnumMap;
import java.util.Map;
import javax.inject.Inject;

@ContextScoped
/* compiled from: below */
public class ReactionRootPartDefinition<E extends FeedEnvironment & HasReactionCardContainer & HasReactionInteractionTracker> extends BaseMultiRowGroupPartDefinition<Object, Void, E> {
    private static ReactionRootPartDefinition f18946g;
    private static final Object f18947h = new Object();
    public final Map<GraphQLReactionUnitStyle, Lazy<? extends MultiRowPartWithIsNeeded>> f18948a;
    private final Map<GraphQLReactionUnitStyle, Lazy<? extends MultiRowPartWithIsNeeded>> f18949b = new EnumMap(GraphQLReactionUnitStyle.class);
    private final Lazy<NewsFeedRootGroupPartDefinition> f18950c;
    private final Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> f18951d;
    private final Lazy<ReactionPagesPinnedPostGroupPartDefinition> f18952e;
    public final Lazy<ReactionUnitValidator> f18953f;

    private static ReactionRootPartDefinition m22981b(InjectorLike injectorLike) {
        return new ReactionRootPartDefinition(IdBasedLazy.a(injectorLike, 1480), IdBasedLazy.a(injectorLike, 9885), IdBasedLazy.a(injectorLike, 10002), IdBasedLazy.a(injectorLike, 9908), IdBasedLazy.a(injectorLike, 9909), IdBasedLazy.a(injectorLike, 9851), IdBasedLazy.a(injectorLike, 10023), IdBasedLazy.a(injectorLike, 10024), IdBasedLazy.a(injectorLike, 6023));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m22982a(com.facebook.multirow.api.BaseMultiRowSubParts r8, java.lang.Object r9, com.facebook.multirow.api.AnyEnvironment r10) {
        /*
        r7 = this;
        r1 = 0;
        r0 = r9 instanceof com.facebook.feed.rows.core.props.FeedProps;
        if (r0 == 0) goto L_0x0012;
    L_0x0005:
        r9 = (com.facebook.feed.rows.core.props.FeedProps) r9;
        r6 = r9.a;
        r2 = r6;
        r3 = r2 instanceof com.facebook.search.results.model.unit.SearchResultsReactionUnit;
        if (r3 != 0) goto L_0x001a;
    L_0x000e:
        r9 = r2;
        if (r9 != 0) goto L_0x0012;
    L_0x0011:
        return r1;
    L_0x0012:
        r0 = r7.m22980b(r9);
        r8.a(r0, r9);
        goto L_0x0011;
    L_0x001a:
        r2 = (com.facebook.search.results.model.unit.SearchResultsReactionUnit) r2;
        r6 = r2.f23506a;
        r3 = r6;
        r2 = r7.f18948a;
        r4 = r3.m();
        r2 = r2.containsKey(r4);
        if (r2 == 0) goto L_0x002d;
    L_0x002b:
        r2 = r3;
        goto L_0x000e;
    L_0x002d:
        r2 = r7.f18953f;
        r2 = r2.get();
        r2 = (com.facebook.reaction.common.ReactionUnitValidator) r2;
        r4 = r2.m22914a(r3);
        r2 = "SUCCESS";
        r6 = r4.f18877d;
        r5 = r6;
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x004a;
    L_0x0044:
        r2 = new com.facebook.reaction.common.ReactionCardNode;
        r2.<init>(r3, r4);
        goto L_0x000e;
    L_0x004a:
        r2 = 0;
        goto L_0x000e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.ReactionRootPartDefinition.a(com.facebook.multirow.api.BaseMultiRowSubParts, java.lang.Object, com.facebook.multirow.api.AnyEnvironment):java.lang.Object");
    }

    public static ReactionRootPartDefinition m22979a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18947h) {
                ReactionRootPartDefinition reactionRootPartDefinition;
                if (a2 != null) {
                    reactionRootPartDefinition = (ReactionRootPartDefinition) a2.a(f18947h);
                } else {
                    reactionRootPartDefinition = f18946g;
                }
                if (reactionRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22981b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18947h, b3);
                        } else {
                            f18946g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionRootPartDefinition(Lazy<NewsFeedRootGroupPartDefinition> lazy, Lazy<ReactionPagesPinnedPostGroupPartDefinition> lazy2, Lazy<ReactionPlaceholderPartDefinition> lazy3, Lazy<ReactionStoryUnitSelectorPartDefinition> lazy4, Lazy<ReactionUnitStackPartDefinition> lazy5, Lazy<ReactionUnitValidator> lazy6, Lazy<ReactionVerticalComponentsNoBottomGapGroupPartDefinition> lazy7, Lazy<ReactionVerticalComponentsSelectorPartDefinition> lazy8, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy9) {
        this.f18950c = lazy;
        this.f18952e = lazy2;
        this.f18951d = lazy9;
        this.f18953f = lazy6;
        this.f18949b.put(GraphQLReactionUnitStyle.PLACEHOLDER, lazy3);
        this.f18949b.put(GraphQLReactionUnitStyle.STORY, lazy4);
        this.f18949b.put(GraphQLReactionUnitStyle.UNIT_STACK, lazy5);
        this.f18948a = new EnumMap(GraphQLReactionUnitStyle.class);
        this.f18948a.put(GraphQLReactionUnitStyle.FLUSH_TO_BOTTOM, lazy7);
        this.f18948a.put(GraphQLReactionUnitStyle.VERTICAL_COMPONENTS, lazy8);
        this.f18948a.put(GraphQLReactionUnitStyle.VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND, lazy8);
    }

    public final boolean m22983a(Object obj) {
        return true;
    }

    private MultiRowPartWithIsNeeded m22980b(Object obj) {
        if (obj instanceof GraphQLStory) {
            MultiRowGroupPartDefinition multiRowGroupPartDefinition = (MultiRowGroupPartDefinition) this.f18950c.get();
            if (multiRowGroupPartDefinition.a(obj)) {
                return multiRowGroupPartDefinition;
            }
        } else if (obj instanceof ReactionUnitFragment) {
            ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
            r0 = (Lazy) this.f18948a.get(reactionUnitFragment.m());
            if (r0 != null) {
                r0 = (MultiRowPartWithIsNeeded) r0.get();
                if (r0.a(reactionUnitFragment)) {
                    return r0;
                }
            }
        } else if (obj instanceof ReactionCardNode) {
            ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
            r0 = (Lazy) this.f18949b.get(reactionCardNode.mo1117k().m());
            if (r0 != null) {
                r0 = (MultiRowPartWithIsNeeded) r0.get();
                if (r0.a(reactionCardNode)) {
                    return r0;
                }
            }
        } else if (obj instanceof ReactionPagesFeedStoryNode) {
            Preconditions.checkState(((ReactionPagesFeedStoryNode) obj).f19133a);
            BaseMultiRowGroupPartDefinition baseMultiRowGroupPartDefinition = (BaseMultiRowGroupPartDefinition) this.f18952e.get();
            if (baseMultiRowGroupPartDefinition.a(obj)) {
                return baseMultiRowGroupPartDefinition;
            }
            return (BaseMultiRowGroupPartDefinition) this.f18951d.get();
        }
        return (MultiRowPartWithIsNeeded) this.f18951d.get();
    }
}
