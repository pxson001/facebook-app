package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.linkutil.GraphQLLinkExtractorGraphQLInterfaces.LinkableTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.rows.ui.ReactionCenterAlignedHeaderView;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: artist_name */
public class ReactionCenterAlignedHeaderPartDefinition extends MultiRowSinglePartDefinition<ReactionCardNode, State, AnyEnvironment, ReactionCenterAlignedHeaderView> {
    public static final ViewType f19186a = new C20931();
    private static ReactionCenterAlignedHeaderPartDefinition f19187b;
    private static final Object f19188c = new Object();

    /* compiled from: artist_name */
    final class C20931 extends ViewType {
        C20931() {
        }

        public final View m23198a(Context context) {
            return new ReactionCenterAlignedHeaderView(context);
        }
    }

    /* compiled from: artist_name */
    public class State {
        public final LinkableTextWithEntities f19184a;
        public final LinkableTextWithEntities f19185b;

        public State(LinkableTextWithEntities linkableTextWithEntities, LinkableTextWithEntities linkableTextWithEntities2) {
            this.f19184a = linkableTextWithEntities;
            this.f19185b = linkableTextWithEntities2;
        }
    }

    private static ReactionCenterAlignedHeaderPartDefinition m23200b() {
        return new ReactionCenterAlignedHeaderPartDefinition();
    }

    public final Object m23202a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return new State(fw_.fz_(), fw_.fA_());
    }

    public final /* bridge */ /* synthetic */ void m23203a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 14347519);
        State state = (State) obj2;
        ReactionCenterAlignedHeaderView reactionCenterAlignedHeaderView = (ReactionCenterAlignedHeaderView) view;
        LinkableTextWithEntities linkableTextWithEntities = state.f19185b;
        LinkableTextWithEntities linkableTextWithEntities2 = state.f19184a;
        reactionCenterAlignedHeaderView.f19456b.setLinkableTextWithEntities(linkableTextWithEntities);
        reactionCenterAlignedHeaderView.f19455a.setLinkableTextWithEntities(linkableTextWithEntities2);
        Logger.a(8, EntryType.MARK_POP, -1111969544, a);
    }

    public final boolean m23204a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()) || fw_.fz_() == null || Strings.isNullOrEmpty(fw_.fz_().a())) ? false : true;
    }

    public final ViewType m23201a() {
        return f19186a;
    }

    public static ReactionCenterAlignedHeaderPartDefinition m23199a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionCenterAlignedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19188c) {
                ReactionCenterAlignedHeaderPartDefinition reactionCenterAlignedHeaderPartDefinition;
                if (a2 != null) {
                    reactionCenterAlignedHeaderPartDefinition = (ReactionCenterAlignedHeaderPartDefinition) a2.a(f19188c);
                } else {
                    reactionCenterAlignedHeaderPartDefinition = f19187b;
                }
                if (reactionCenterAlignedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m23200b();
                        if (a2 != null) {
                            a2.a(f19188c, b3);
                        } else {
                            f19187b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionCenterAlignedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
