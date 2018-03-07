package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_can_edit_cta */
public class ReactionStoryHeaderGroupPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPositionInformation & HasReactionAnalyticsParams & HasReactionInteractionTracker & HasReactionSession> extends BaseMultiRowGroupPartDefinition<ReactionCardNode, Void, E> {
    private static ReactionStoryHeaderGroupPartDefinition f19294g;
    private static final Object f19295h = new Object();
    private final Lazy<ReactionCenterAlignedHeaderPartDefinition> f19296a;
    private final Lazy<ReactionDescriptiveHeaderPartDefinition> f19297b;
    private final Lazy<ReactionFacepileHeaderSelectorPartDefinition<E>> f19298c;
    private final Lazy<ReactionIconHeaderSelectorPartDefinition<E>> f19299d;
    private final Lazy<ReactionIconInlineActionHeaderSelectorPartDefinition<E>> f19300e;
    private final Lazy<ReactionIconPivotHeaderPartDefinition<E>> f19301f;

    /* compiled from: arg_can_edit_cta */
    /* synthetic */ class C21021 {
        static final /* synthetic */ int[] f19293a = new int[GraphQLReactionUnitHeaderStyle.values().length];

        static {
            try {
                f19293a[GraphQLReactionUnitHeaderStyle.CENTER_ALIGNED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f19293a[GraphQLReactionUnitHeaderStyle.DESCRIPTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f19293a[GraphQLReactionUnitHeaderStyle.ICON.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f19293a[GraphQLReactionUnitHeaderStyle.ICON_INLINE_ACTION.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f19293a[GraphQLReactionUnitHeaderStyle.ICON_PIVOT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f19293a[GraphQLReactionUnitHeaderStyle.THIN_FACEPILE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    private static ReactionStoryHeaderGroupPartDefinition m23301b(InjectorLike injectorLike) {
        return new ReactionStoryHeaderGroupPartDefinition(IdBasedLazy.a(injectorLike, 9886), IdBasedLazy.a(injectorLike, 9889), IdBasedLazy.a(injectorLike, 9891), IdBasedLazy.a(injectorLike, 9893), IdBasedLazy.a(injectorLike, 9896), IdBasedLazy.a(injectorLike, 9898));
    }

    public final Object m23302a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        if (!(fw_ == null || fw_.c() == null)) {
            switch (C21021.f19293a[fw_.c().ordinal()]) {
                case 1:
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19296a.get(), reactionCardNode);
                    break;
                case 2:
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19297b.get(), reactionCardNode);
                    break;
                case 3:
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19299d.get(), reactionCardNode);
                    break;
                case 4:
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19300e.get(), reactionCardNode);
                    break;
                case 5:
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19301f.get(), reactionCardNode);
                    break;
                case 6:
                    baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f19298c.get(), reactionCardNode);
                    break;
                default:
                    break;
            }
        }
        return null;
    }

    @Inject
    public ReactionStoryHeaderGroupPartDefinition(Lazy<ReactionCenterAlignedHeaderPartDefinition> lazy, Lazy<ReactionDescriptiveHeaderPartDefinition> lazy2, Lazy<ReactionFacepileHeaderSelectorPartDefinition> lazy3, Lazy<ReactionIconHeaderSelectorPartDefinition> lazy4, Lazy<ReactionIconInlineActionHeaderSelectorPartDefinition> lazy5, Lazy<ReactionIconPivotHeaderPartDefinition> lazy6) {
        this.f19296a = lazy;
        this.f19297b = lazy2;
        this.f19298c = lazy3;
        this.f19299d = lazy4;
        this.f19300e = lazy5;
        this.f19301f = lazy6;
    }

    public static ReactionStoryHeaderGroupPartDefinition m23300a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionStoryHeaderGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19295h) {
                ReactionStoryHeaderGroupPartDefinition reactionStoryHeaderGroupPartDefinition;
                if (a2 != null) {
                    reactionStoryHeaderGroupPartDefinition = (ReactionStoryHeaderGroupPartDefinition) a2.a(f19295h);
                } else {
                    reactionStoryHeaderGroupPartDefinition = f19294g;
                }
                if (reactionStoryHeaderGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23301b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19295h, b3);
                        } else {
                            f19294g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionStoryHeaderGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m23303a(Object obj) {
        return true;
    }
}
