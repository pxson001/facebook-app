package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.TriState;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionActionIconMapper;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionActivatableActionPlaceKey;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: \d{2}\/\d{2} */
public class ReactionActionListActivatableActionPartDefinition extends BaseSinglePartDefinition<Props, Void, HasPersistentState, LinearLayout> {
    private static ReactionActionListActivatableActionPartDefinition f20498f;
    private static final Object f20499g = new Object();
    private final ReactionActionIconMapper f20500a;
    private final ReactionDrawableIconPartDefinition f20501b;
    private final HighlightViewOnTouchListenerPartDefinition f20502c;
    private final TextAppearancePartDefinition f20503d;
    private final TextPartDefinition f20504e;

    /* compiled from: \d{2}\/\d{2} */
    public class Props {
        public final ReactionStoryAttachmentActionFragmentModel f20495a;
        public final ReactionUnitComponentNode f20496b;
        public final boolean f20497c;

        public Props(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel, ReactionUnitComponentNode reactionUnitComponentNode, boolean z) {
            this.f20495a = reactionStoryAttachmentActionFragmentModel;
            this.f20496b = reactionUnitComponentNode;
            this.f20497c = z;
        }
    }

    private static ReactionActionListActivatableActionPartDefinition m24263b(InjectorLike injectorLike) {
        return new ReactionActionListActivatableActionPartDefinition(ReactionActionIconMapper.m22679a(injectorLike), ReactionDrawableIconPartDefinition.m24306a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), TextAppearancePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m24265a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        boolean a = m24262a(props.f20496b, (HasPersistentState) anyEnvironment, props.f20497c);
        subParts.a(2131566665, this.f20501b, new com.facebook.reaction.feed.unitcomponents.subpart.ReactionDrawableIconPartDefinition.Props(this.f20500a.m22682a(props.f20495a.j(), a ? -10972929 : -7235677)));
        subParts.a(2131566666, this.f20503d, Integer.valueOf(a ? 2131625817 : 2131625818));
        subParts.a(2131566666, this.f20504e, a ? props.f20495a.b().a() : props.f20495a.fU_().a());
        subParts.a(this.f20502c, null);
        return null;
    }

    @Inject
    public ReactionActionListActivatableActionPartDefinition(ReactionActionIconMapper reactionActionIconMapper, ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition, TextPartDefinition textPartDefinition) {
        this.f20500a = reactionActionIconMapper;
        this.f20501b = reactionDrawableIconPartDefinition;
        this.f20502c = highlightViewOnTouchListenerPartDefinition;
        this.f20503d = textAppearancePartDefinition;
        this.f20504e = textPartDefinition;
    }

    public static ReactionActionListActivatableActionPartDefinition m24261a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListActivatableActionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20499g) {
                ReactionActionListActivatableActionPartDefinition reactionActionListActivatableActionPartDefinition;
                if (a2 != null) {
                    reactionActionListActivatableActionPartDefinition = (ReactionActionListActivatableActionPartDefinition) a2.a(f20499g);
                } else {
                    reactionActionListActivatableActionPartDefinition = f20498f;
                }
                if (reactionActionListActivatableActionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24263b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20499g, b3);
                        } else {
                            f20498f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListActivatableActionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static boolean m24262a(ReactionUnitComponentNode reactionUnitComponentNode, HasPersistentState hasPersistentState, boolean z) {
        TriState triState;
        ReactionActivatableActionPersistentState reactionActivatableActionPersistentState = (ReactionActivatableActionPersistentState) hasPersistentState.a(new ReactionActivatableActionPlaceKey(reactionUnitComponentNode.f18862b.U()), reactionUnitComponentNode);
        if (reactionActivatableActionPersistentState.f19155a.isSet()) {
            triState = reactionActivatableActionPersistentState.f19155a;
        } else {
            triState = TriState.valueOf(z);
        }
        reactionActivatableActionPersistentState.f19155a = triState;
        return triState == TriState.YES;
    }

    public static void m24264b(ReactionUnitComponentNode reactionUnitComponentNode, HasPersistentState hasPersistentState, boolean z) {
        ((ReactionActivatableActionPersistentState) hasPersistentState.a(new ReactionActivatableActionPlaceKey(reactionUnitComponentNode.f18862b.U()), reactionUnitComponentNode)).f19155a = TriState.valueOf(z);
    }
}
