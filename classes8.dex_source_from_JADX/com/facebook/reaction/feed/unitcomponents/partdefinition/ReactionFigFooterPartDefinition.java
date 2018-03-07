package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionOpenBottomActionSheetPartDefinition;
import com.facebook.reaction.feed.unitcomponents.subpart.ReactionOpenBottomActionSheetPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: album_tap */
public class ReactionFigFooterPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, TextView> {
    public static final ViewType<BetterTextView> f19702a = ViewType.a(2130906714);
    private static ReactionFigFooterPartDefinition f19703f;
    private static final Object f19704g = new Object();
    private final BasicReactionActionPartDefinition f19705b;
    private final BasicReactionTextPartDefinition f19706c;
    private final ReactionOpenBottomActionSheetPartDefinition f19707d;
    private final Locales f19708e;

    private static ReactionFigFooterPartDefinition m23615b(InjectorLike injectorLike) {
        return new ReactionFigFooterPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), BasicReactionTextPartDefinition.m22990a(injectorLike), ReactionOpenBottomActionSheetPartDefinition.m24341a(injectorLike), Locales.a(injectorLike));
    }

    public final Object m23617a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        subParts.a(this.f19706c, reactionUnitComponentFields.bv().a().toUpperCase(this.f19708e.a()));
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            if (v.j() == GraphQLReactionStoryActionStyle.OPEN_VERTICAL_ACTION_SHEET) {
                subParts.a(this.f19707d, new Props(v, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
            } else {
                String str;
                ProfileModel M = v.M();
                BasicReactionActionPartDefinition basicReactionActionPartDefinition = this.f19705b;
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

    public static ReactionFigFooterPartDefinition m23614a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFigFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19704g) {
                ReactionFigFooterPartDefinition reactionFigFooterPartDefinition;
                if (a2 != null) {
                    reactionFigFooterPartDefinition = (ReactionFigFooterPartDefinition) a2.a(f19704g);
                } else {
                    reactionFigFooterPartDefinition = f19703f;
                }
                if (reactionFigFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23615b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19704g, b3);
                        } else {
                            f19703f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFigFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionFigFooterPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, BasicReactionTextPartDefinition basicReactionTextPartDefinition, ReactionOpenBottomActionSheetPartDefinition reactionOpenBottomActionSheetPartDefinition, Locales locales) {
        this.f19705b = basicReactionActionPartDefinition;
        this.f19706c = basicReactionTextPartDefinition;
        this.f19707d = reactionOpenBottomActionSheetPartDefinition;
        this.f19708e = locales;
    }

    public final ViewType m23616a() {
        return f19702a;
    }

    public final boolean m23618a(Object obj) {
        return true;
    }
}
