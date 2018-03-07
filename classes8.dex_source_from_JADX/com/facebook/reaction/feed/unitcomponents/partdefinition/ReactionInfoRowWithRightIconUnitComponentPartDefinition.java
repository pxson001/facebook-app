package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionUriIconPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: added_by */
public class ReactionInfoRowWithRightIconUnitComponentPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, AnyEnvironment, ImageBlockLayout> {
    public static final ViewType f19866a = ViewType.a(2130906644);
    private static ReactionInfoRowWithRightIconUnitComponentPartDefinition f19867e;
    private static final Object f19868f = new Object();
    private final BasicReactionActionPartDefinition f19869b;
    private final ReactionUriIconPartDefinition f19870c;
    private final TextOrHiddenPartDefinition f19871d;

    private static ReactionInfoRowWithRightIconUnitComponentPartDefinition m23773b(InjectorLike injectorLike) {
        return new ReactionInfoRowWithRightIconUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionUriIconPartDefinition.m24360a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike));
    }

    public final Object m23775a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            String a;
            BasicReactionActionPartDefinition basicReactionActionPartDefinition = this.f19869b;
            if (v.fU_() != null) {
                a = v.fU_().a();
            } else {
                a = null;
            }
            subParts.a(basicReactionActionPartDefinition, new Props(v, a, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, null, null));
        }
        subParts.a(2131566679, this.f19871d, reactionUnitComponentFields.cU().a());
        if (reactionUnitComponentFields.cL() != null) {
            subParts.a(2131566680, this.f19871d, reactionUnitComponentFields.cL().a());
        }
        if (reactionUnitComponentFields.cP() != null) {
            subParts.a(2131566681, this.f19871d, reactionUnitComponentFields.cP().a());
        }
        if (!(reactionUnitComponentFields.bY() == null || reactionUnitComponentFields.bY().a() == null)) {
            subParts.a(2131566682, this.f19870c, reactionUnitComponentFields.bY().a().b());
        }
        return null;
    }

    public final boolean m23776a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.cU() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.cU().a())) ? false : true;
    }

    public final ViewType m23774a() {
        return f19866a;
    }

    @Inject
    public ReactionInfoRowWithRightIconUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionUriIconPartDefinition reactionUriIconPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition) {
        this.f19869b = basicReactionActionPartDefinition;
        this.f19870c = reactionUriIconPartDefinition;
        this.f19871d = textOrHiddenPartDefinition;
    }

    public static ReactionInfoRowWithRightIconUnitComponentPartDefinition m23772a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionInfoRowWithRightIconUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19868f) {
                ReactionInfoRowWithRightIconUnitComponentPartDefinition reactionInfoRowWithRightIconUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionInfoRowWithRightIconUnitComponentPartDefinition = (ReactionInfoRowWithRightIconUnitComponentPartDefinition) a2.a(f19868f);
                } else {
                    reactionInfoRowWithRightIconUnitComponentPartDefinition = f19867e;
                }
                if (reactionInfoRowWithRightIconUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23773b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19868f, b3);
                        } else {
                            f19867e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionInfoRowWithRightIconUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
