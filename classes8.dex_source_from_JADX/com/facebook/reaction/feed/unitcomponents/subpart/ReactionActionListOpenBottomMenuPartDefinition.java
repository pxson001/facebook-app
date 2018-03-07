package com.facebook.reaction.feed.unitcomponents.subpart;

import android.content.Context;
import android.widget.LinearLayout;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.parts.HighlightViewOnTouchListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.action.ReactionActionIconMapper;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionSingleActionSelectorPartDefinition.Props;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: [phonetic] */
public class ReactionActionListOpenBottomMenuPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionInteractionTracker & HasReactionSession> extends BaseSinglePartDefinition<Props, Void, E, LinearLayout> implements MultiRowPartWithIsNeeded<Props, E> {
    private static ReactionActionListOpenBottomMenuPartDefinition f20508g;
    private static final Object f20509h = new Object();
    private final ReactionDrawableIconPartDefinition f20510a;
    private final HighlightViewOnTouchListenerPartDefinition f20511b;
    private final ReactionActionIconMapper f20512c;
    private final TextPartDefinition f20513d;
    private final ReactionUriIconPartDefinition f20514e;
    private final ReactionOpenBottomActionSheetPartDefinition f20515f;

    private static ReactionActionListOpenBottomMenuPartDefinition m24270b(InjectorLike injectorLike) {
        return new ReactionActionListOpenBottomMenuPartDefinition(ReactionDrawableIconPartDefinition.m24306a(injectorLike), HighlightViewOnTouchListenerPartDefinition.a(injectorLike), ReactionActionIconMapper.m22679a(injectorLike), TextPartDefinition.a(injectorLike), ReactionUriIconPartDefinition.m24360a(injectorLike), ReactionOpenBottomActionSheetPartDefinition.m24341a(injectorLike));
    }

    public final Object m24271a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        Props props = (Props) obj;
        if (props.f20670a.d() == null || Strings.isNullOrEmpty(props.f20670a.d().b())) {
            obj2 = null;
        } else {
            obj2 = props.f20670a.d().b();
        }
        if (obj2 != null) {
            subParts.a(2131566665, this.f20514e, obj2);
        } else {
            subParts.a(2131566665, this.f20510a, new ReactionDrawableIconPartDefinition.Props(this.f20512c.m22681a(props.f20670a.j())));
        }
        subParts.a(2131566666, this.f20513d, props.f20670a.fU_().a());
        subParts.a(this.f20515f, new ReactionOpenBottomActionSheetPartDefinition.Props(props.f20670a, props.f20671b.f18863c, props.f20671b.f18864d));
        subParts.a(this.f20511b, null);
        return null;
    }

    public final boolean m24272a(Object obj) {
        Props props = (Props) obj;
        return (props.f20670a.j() != GraphQLReactionStoryActionStyle.OPEN_VERTICAL_ACTION_SHEET || props.f20670a.fU_() == null || Strings.isNullOrEmpty(props.f20670a.fU_().a()) || props.f20670a.ae().isEmpty()) ? false : true;
    }

    @Inject
    public ReactionActionListOpenBottomMenuPartDefinition(ReactionDrawableIconPartDefinition reactionDrawableIconPartDefinition, HighlightViewOnTouchListenerPartDefinition highlightViewOnTouchListenerPartDefinition, ReactionActionIconMapper reactionActionIconMapper, TextPartDefinition textPartDefinition, ReactionUriIconPartDefinition reactionUriIconPartDefinition, ReactionOpenBottomActionSheetPartDefinition reactionOpenBottomActionSheetPartDefinition) {
        this.f20510a = reactionDrawableIconPartDefinition;
        this.f20511b = highlightViewOnTouchListenerPartDefinition;
        this.f20512c = reactionActionIconMapper;
        this.f20513d = textPartDefinition;
        this.f20514e = reactionUriIconPartDefinition;
        this.f20515f = reactionOpenBottomActionSheetPartDefinition;
    }

    public static ReactionActionListOpenBottomMenuPartDefinition m24269a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionActionListOpenBottomMenuPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20509h) {
                ReactionActionListOpenBottomMenuPartDefinition reactionActionListOpenBottomMenuPartDefinition;
                if (a2 != null) {
                    reactionActionListOpenBottomMenuPartDefinition = (ReactionActionListOpenBottomMenuPartDefinition) a2.a(f20509h);
                } else {
                    reactionActionListOpenBottomMenuPartDefinition = f20508g;
                }
                if (reactionActionListOpenBottomMenuPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24270b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20509h, b3);
                        } else {
                            f20508g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionActionListOpenBottomMenuPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
