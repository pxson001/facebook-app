package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.ui.ReactionSecondaryActionPopoverMenuProvider;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [\d]* */
public class ReactionChevronMenuPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> extends BaseSinglePartDefinition<ReactionUnitComponentNode, State, E, View> {
    private static ReactionChevronMenuPartDefinition f20556b;
    private static final Object f20557c = new Object();
    public final ReactionSecondaryActionPopoverMenuProvider f20558a;

    /* compiled from: [\d]* */
    public class State {
        @Nullable
        public final OnClickListener f20555a;

        public State(@Nullable OnClickListener onClickListener) {
            this.f20555a = onClickListener;
        }
    }

    private static ReactionChevronMenuPartDefinition m24298b(InjectorLike injectorLike) {
        return new ReactionChevronMenuPartDefinition((ReactionSecondaryActionPopoverMenuProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(ReactionSecondaryActionPopoverMenuProvider.class));
    }

    public final Object m24299a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        final List arrayList = new ArrayList();
        ImmutableList cu = reactionUnitComponentFields.cu();
        int size = cu.size();
        for (int i = 0; i < size; i++) {
            Object obj2;
            ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) cu.get(i);
            if (reactionStoryAttachmentActionFragmentModel.d() == null && ((reactionStoryAttachmentActionFragmentModel.fU_() == null || reactionStoryAttachmentActionFragmentModel.fU_().a() == null) && (reactionStoryAttachmentActionFragmentModel.g() == null || reactionStoryAttachmentActionFragmentModel.g().a() == null))) {
                obj2 = null;
            } else {
                obj2 = 1;
            }
            if (obj2 != null) {
                arrayList.add(reactionStoryAttachmentActionFragmentModel);
            }
        }
        return new State(arrayList.isEmpty() ? null : new OnClickListener(this) {
            final /* synthetic */ ReactionChevronMenuPartDefinition f20554d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1761105515);
                this.f20554d.f20558a.m23441a(canLaunchReactionIntent, arrayList, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, reactionUnitComponentNode.f18861a).f(view);
                Logger.a(2, EntryType.UI_INPUT_END, -1234460467, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m24300a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 136816175);
        State state = (State) obj2;
        if (state.f20555a != null) {
            view.setOnClickListener(state.f20555a);
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
        Logger.a(8, EntryType.MARK_POP, 1486687193, a);
    }

    @Inject
    public ReactionChevronMenuPartDefinition(ReactionSecondaryActionPopoverMenuProvider reactionSecondaryActionPopoverMenuProvider) {
        this.f20558a = reactionSecondaryActionPopoverMenuProvider;
    }

    public static ReactionChevronMenuPartDefinition m24297a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionChevronMenuPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20557c) {
                ReactionChevronMenuPartDefinition reactionChevronMenuPartDefinition;
                if (a2 != null) {
                    reactionChevronMenuPartDefinition = (ReactionChevronMenuPartDefinition) a2.a(f20557c);
                } else {
                    reactionChevronMenuPartDefinition = f20556b;
                }
                if (reactionChevronMenuPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24298b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20557c, b3);
                        } else {
                            f20556b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionChevronMenuPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m24301b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        view.setOnClickListener(null);
    }
}
