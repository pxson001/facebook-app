package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
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
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.facebook.saved.common.protocol.UpdateSavedStateParams.SavedAction;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [^a-zA-Z] */
public class ReactionActionListSaveOgObjectActionPartDefinition<E extends HasInvalidate & HasPersistentState & HasReactionInteractionTracker> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionActionListSaveOgObjectActionPartDefinition f20538d;
    private static final Object f20539e = new Object();
    private final ReactionActionListActivatableActionPartDefinition f20540a;
    private final ClickListenerPartDefinition f20541b;
    public final UpdateSavedStateUtils f20542c;

    private static ReactionActionListSaveOgObjectActionPartDefinition m24288b(InjectorLike injectorLike) {
        return new ReactionActionListSaveOgObjectActionPartDefinition(ReactionActionListActivatableActionPartDefinition.m24261a(injectorLike), ClickListenerPartDefinition.a(injectorLike), UpdateSavedStateUtils.a(injectorLike));
    }

    public final Object m24289a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        C21781 c21781 = new OnClickListener(this) {
            final /* synthetic */ ReactionActionListSaveOgObjectActionPartDefinition f20537c;

            public void onClick(View view) {
                SavedAction savedAction;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 552920056);
                final boolean a2 = ReactionActionListActivatableActionPartDefinition.m24262a(props.f20671b, (HasPersistentState) hasInvalidate, props.f20670a.fT_().c());
                boolean z = !a2;
                ReactionActionListActivatableActionPartDefinition.m24264b(props.f20671b, (HasPersistentState) hasInvalidate, z);
                UpdateSavedStateUtils updateSavedStateUtils = this.f20537c.f20542c;
                if (z) {
                    savedAction = SavedAction.SAVE;
                } else {
                    savedAction = SavedAction.UNSAVE;
                }
                updateSavedStateUtils.a(savedAction, props.f20670a.fT_().d(), CurationSurface.NATIVE_REACTION, CurationMechanism.TOGGLE_BUTTON, new OperationResultFutureCallback(this) {
                    final /* synthetic */ C21781 f20534b;

                    protected final void m24285a(ServiceException serviceException) {
                        ReactionActionListActivatableActionPartDefinition.m24264b(props.f20671b, (HasPersistentState) hasInvalidate, a2);
                        hasInvalidate.hL_();
                    }
                });
                ((HasReactionInteractionTracker) hasInvalidate).kE_().mo984a(props.f20671b.f18863c, props.f20671b.f18864d, null, UnitInteractionType.SAVE_OG_OBJECT);
                hasInvalidate.hL_();
                LogUtils.a(-245990346, a);
            }
        };
        subParts.a(this.f20540a, new ReactionActionListActivatableActionPartDefinition.Props(props.f20670a, props.f20671b, props.f20670a.fT_().c()));
        subParts.a(this.f20541b, c21781);
        return null;
    }

    public final boolean m24290a(Object obj) {
        Props props = (Props) obj;
        return (props.f20670a.j() != GraphQLReactionStoryActionStyle.SAVE_OG_OBJECT || Strings.isNullOrEmpty(props.f20671b.f18862b.U()) || props.f20670a.fU_() == null || Strings.isNullOrEmpty(props.f20670a.fU_().a()) || props.f20670a.b() == null || Strings.isNullOrEmpty(props.f20670a.b().a())) ? false : true;
    }

    @Inject
    public ReactionActionListSaveOgObjectActionPartDefinition(ReactionActionListActivatableActionPartDefinition reactionActionListActivatableActionPartDefinition, ClickListenerPartDefinition clickListenerPartDefinition, UpdateSavedStateUtils updateSavedStateUtils) {
        this.f20540a = reactionActionListActivatableActionPartDefinition;
        this.f20541b = clickListenerPartDefinition;
        this.f20542c = updateSavedStateUtils;
    }

    public static ReactionActionListSaveOgObjectActionPartDefinition m24287a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListSaveOgObjectActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20539e) {
                ReactionActionListSaveOgObjectActionPartDefinition reactionActionListSaveOgObjectActionPartDefinition;
                if (a2 != null) {
                    reactionActionListSaveOgObjectActionPartDefinition = (ReactionActionListSaveOgObjectActionPartDefinition) a2.a(f20539e);
                } else {
                    reactionActionListSaveOgObjectActionPartDefinition = f20538d;
                }
                if (reactionActionListSaveOgObjectActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24288b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20539e, b3);
                        } else {
                            f20538d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListSaveOgObjectActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
