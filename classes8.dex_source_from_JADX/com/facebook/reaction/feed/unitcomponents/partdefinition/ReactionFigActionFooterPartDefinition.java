package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionStoryActionStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionTextPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionOpenBottomActionSheetPartDefinition;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionOpenBottomActionSheetPartDefinition.Props;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionUriIconPartDefinition;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: aldrin_logged_out_status */
public class ReactionFigActionFooterPartDefinition<E extends CanLaunchReactionIntent & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, ImageBlockLayout> {
    public static final ViewType<ImageBlockLayout> f19690a = ViewType.a(2130906713);
    private static ReactionFigActionFooterPartDefinition f19691g;
    private static final Object f19692h = new Object();
    private final BasicReactionActionPartDefinition f19693b;
    private final ReactionOpenBottomActionSheetPartDefinition f19694c;
    private final Locales f19695d;
    private final BasicReactionTextPartDefinition f19696e;
    private final ReactionUriIconPartDefinition f19697f;

    private static ReactionFigActionFooterPartDefinition m23606b(InjectorLike injectorLike) {
        return new ReactionFigActionFooterPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionOpenBottomActionSheetPartDefinition.m24341a(injectorLike), Locales.a(injectorLike), BasicReactionTextPartDefinition.m22990a(injectorLike), ReactionUriIconPartDefinition.m24360a(injectorLike));
    }

    public final Object m23608a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(2131559674, this.f19696e, reactionUnitComponentFields.bv().a().toUpperCase(this.f19695d.a()));
        subParts.a(2131566781, this.f19697f, reactionUnitComponentFields.aO().b());
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            if (v.j() == GraphQLReactionStoryActionStyle.OPEN_VERTICAL_ACTION_SHEET) {
                subParts.a(this.f19694c, new Props(v, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
            } else {
                String str;
                ProfileModel M = v.M();
                BasicReactionActionPartDefinition basicReactionActionPartDefinition = this.f19693b;
                if (M == null) {
                    str = null;
                } else {
                    str = M.j();
                }
                subParts.a(basicReactionActionPartDefinition, new BasicReactionActionPartDefinition.Props(v, str, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, null, null));
            }
        }
        return null;
    }

    public final boolean m23609a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.bv().a()) || reactionUnitComponentFields.aO() == null || Strings.isNullOrEmpty(reactionUnitComponentFields.aO().b())) ? false : true;
    }

    @Inject
    public ReactionFigActionFooterPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionOpenBottomActionSheetPartDefinition reactionOpenBottomActionSheetPartDefinition, Locales locales, BasicReactionTextPartDefinition basicReactionTextPartDefinition, ReactionUriIconPartDefinition reactionUriIconPartDefinition) {
        this.f19693b = basicReactionActionPartDefinition;
        this.f19694c = reactionOpenBottomActionSheetPartDefinition;
        this.f19695d = locales;
        this.f19696e = basicReactionTextPartDefinition;
        this.f19697f = reactionUriIconPartDefinition;
    }

    public static ReactionFigActionFooterPartDefinition m23605a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFigActionFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19692h) {
                ReactionFigActionFooterPartDefinition reactionFigActionFooterPartDefinition;
                if (a2 != null) {
                    reactionFigActionFooterPartDefinition = (ReactionFigActionFooterPartDefinition) a2.a(f19692h);
                } else {
                    reactionFigActionFooterPartDefinition = f19691g;
                }
                if (reactionFigActionFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23606b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19692h, b3);
                        } else {
                            f19691g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFigActionFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23607a() {
        return f19690a;
    }
}
