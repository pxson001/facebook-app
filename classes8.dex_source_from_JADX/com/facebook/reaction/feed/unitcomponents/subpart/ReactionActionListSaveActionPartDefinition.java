package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.graphql.enums.GraphQLSavedState;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionSavePlaceKey;
import com.facebook.reaction.feed.persistentstate.ReactionSavePlacePersistentState;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionProfileFields;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [badge] */
public class ReactionActionListSaveActionPartDefinition<E extends HasContext & HasPersistentState & HasReactionInteractionTracker & HasPrefetcher & HasRowKey> extends BaseSinglePartDefinition<Props, ReactionSavePlaceKey, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    @VisibleForTesting
    static final CallerContext f20526a = CallerContext.a(ReactionActionListSingleActionPartDefinition.class, "reaction_dialog");
    private static ReactionActionListSaveActionPartDefinition f20527f;
    private static final Object f20528g = new Object();
    private final ClickListenerPartDefinition f20529b;
    private final HighlightViewOnTouchListenerPartDefinition f20530c;
    private final FbDraweePartDefinition<E> f20531d;
    private final UpdateSavedStateUtils f20532e;

    private static ReactionActionListSaveActionPartDefinition m24279b(InjectorLike injectorLike) {
        return new ReactionActionListSaveActionPartDefinition(ClickListenerPartDefinition.a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), FbDraweePartDefinition.a(injectorLike), UpdateSavedStateUtils.a(injectorLike));
    }

    public final Object m24282a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        FbDraweePartDefinition fbDraweePartDefinition = this.f20531d;
        Builder a = FbDraweePartDefinition.a().a(props.f20670a.d().b());
        a.c = f20526a;
        subParts.a(2131566665, fbDraweePartDefinition, a.a());
        final ReactionSavePlaceKey reactionSavePlaceKey = new ReactionSavePlaceKey(props.f20670a.M());
        subParts.a(this.f20529b, new OnClickListener(this) {
            final /* synthetic */ ReactionActionListSaveActionPartDefinition f20519d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -923980185);
                TextView textView = (TextView) view.findViewById(2131566666);
                if (textView == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 447017420, a);
                    return;
                }
                this.f20519d.m24276a(hasContext, props.f20670a.M(), reactionSavePlaceKey, textView, props.f20671b);
                LogUtils.a(1407518726, a);
            }
        });
        subParts.a(this.f20530c, null);
        return reactionSavePlaceKey;
    }

    public final boolean m24284a(Object obj) {
        Props props = (Props) obj;
        if (!(props.f20670a.j() != GraphQLReactionStoryActionStyle.SAVE_PAGE || props.f20670a.d() == null || Strings.isNullOrEmpty(props.f20670a.d().b()))) {
            ProfileModel M = props.f20670a.M();
            Object obj2 = (M == null || Strings.isNullOrEmpty(M.eL_()) || !(M.m() == GraphQLSavedState.SAVED || M.m() == GraphQLSavedState.NOT_SAVED || M.m() == GraphQLSavedState.ARCHIVED)) ? null : 1;
            if (obj2 != null) {
                return true;
            }
        }
        return false;
    }

    public static ReactionActionListSaveActionPartDefinition m24275a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListSaveActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20528g) {
                ReactionActionListSaveActionPartDefinition reactionActionListSaveActionPartDefinition;
                if (a2 != null) {
                    reactionActionListSaveActionPartDefinition = (ReactionActionListSaveActionPartDefinition) a2.a(f20528g);
                } else {
                    reactionActionListSaveActionPartDefinition = f20527f;
                }
                if (reactionActionListSaveActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20528g, b3);
                        } else {
                            f20527f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListSaveActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionActionListSaveActionPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, FbDraweePartDefinition fbDraweePartDefinition, UpdateSavedStateUtils updateSavedStateUtils) {
        this.f20529b = clickListenerPartDefinition;
        this.f20530c = highlightViewOnTouchListenerPartDefinition;
        this.f20531d = fbDraweePartDefinition;
        this.f20532e = updateSavedStateUtils;
    }

    public static boolean m24278a(HasPersistentState hasPersistentState, ReactionProfileFields reactionProfileFields, ReactionSavePlaceKey reactionSavePlaceKey, ReactionUnitComponentNode reactionUnitComponentNode) {
        GraphQLSavedState m;
        ReactionSavePlacePersistentState reactionSavePlacePersistentState = (ReactionSavePlacePersistentState) hasPersistentState.a(reactionSavePlaceKey, reactionUnitComponentNode);
        if (reactionSavePlacePersistentState.f19180a == null) {
            m = reactionProfileFields.m();
        } else {
            m = reactionSavePlacePersistentState.f19180a;
        }
        return m == GraphQLSavedState.SAVED;
    }

    public static String m24280b(Context context, boolean z) {
        return context.getString(z ? 2131235378 : 2131235376);
    }

    private void m24276a(E e, ReactionProfileFields reactionProfileFields, ReactionSavePlaceKey reactionSavePlaceKey, TextView textView, ReactionUnitComponentNode reactionUnitComponentNode) {
        SavedAction savedAction;
        final boolean a = m24278a((HasPersistentState) e, reactionProfileFields, reactionSavePlaceKey, reactionUnitComponentNode);
        boolean z = !a;
        textView.setText(m24280b(e.getContext(), z));
        m24281b((HasPersistentState) e, z, reactionProfileFields, reactionUnitComponentNode);
        UpdateSavedStateUtils updateSavedStateUtils = this.f20532e;
        if (z) {
            savedAction = SavedAction.SAVE;
        } else {
            savedAction = SavedAction.UNSAVE;
        }
        final TextView textView2 = textView;
        final E e2 = e;
        final ReactionProfileFields reactionProfileFields2 = reactionProfileFields;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        updateSavedStateUtils.a(savedAction, reactionProfileFields.eL_(), CurationSurface.AFTER_PARTY, CurationMechanism.TOGGLE_BUTTON, new OperationResultFutureCallback(this) {
            final /* synthetic */ ReactionActionListSaveActionPartDefinition f20525f;

            protected final void m24273a(ServiceException serviceException) {
                textView2.setText(ReactionActionListSaveActionPartDefinition.m24280b(e2.getContext(), a));
                ReactionActionListSaveActionPartDefinition.m24281b((HasPersistentState) e2, a, reactionProfileFields2, reactionUnitComponentNode2);
            }
        });
        ((HasReactionInteractionTracker) e).kE_().mo981a(reactionUnitComponentNode.m22887k(), reactionUnitComponentNode.m22888l(), new ReactionAttachmentIntent(reactionProfileFields.eL_(), UnitInteractionType.SAVE_PAGE_TAP));
    }

    public static void m24281b(HasPersistentState hasPersistentState, boolean z, ReactionProfileFields reactionProfileFields, ReactionUnitComponentNode reactionUnitComponentNode) {
        GraphQLSavedState graphQLSavedState;
        ReactionSavePlacePersistentState reactionSavePlacePersistentState = (ReactionSavePlacePersistentState) hasPersistentState.a(new ReactionSavePlaceKey(reactionProfileFields), reactionUnitComponentNode);
        if (z) {
            graphQLSavedState = GraphQLSavedState.SAVED;
        } else {
            graphQLSavedState = GraphQLSavedState.NOT_SAVED;
        }
        reactionSavePlacePersistentState.f19180a = graphQLSavedState;
    }
}
