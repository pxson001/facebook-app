package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.facepile.Face;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.ReactionFacepilePartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitPostPivotComponentFragmentModel.FacepileModel;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: activeTrackIds */
public class ReactionPostPivotUnitComponentDefinition<E extends CanLaunchReactionIntent & HasReactionAnalyticsParams> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, CustomLinearLayout> {
    public static final ViewType f19994a = ViewType.a(2130906707);
    private static ReactionPostPivotUnitComponentDefinition f19995e;
    private static final Object f19996f = new Object();
    private final BasicReactionActionPartDefinition f19997b;
    private final ReactionFacepilePartDefinition f19998c;
    private final TextPartDefinition f19999d;

    private static ReactionPostPivotUnitComponentDefinition m23889b(InjectorLike injectorLike) {
        return new ReactionPostPivotUnitComponentDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), ReactionFacepilePartDefinition.m23002a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23891a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        if (v != null) {
            subParts.a(this.f19997b, new Props(v, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        ReactionFacepilePartDefinition reactionFacepilePartDefinition = this.f19998c;
        ImmutableList aw = reactionUnitComponentFields.aw();
        Builder builder = new Builder();
        int min = Math.min(12, aw.size());
        for (int i = 0; i < min; i++) {
            builder.c(new Face(Uri.parse(((FacepileModel) aw.get(i)).b().d().b())));
        }
        subParts.a(2131566769, reactionFacepilePartDefinition, builder.b());
        subParts.a(2131566770, this.f19999d, reactionUnitComponentFields.bv().a());
        return null;
    }

    public final boolean m23892a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        ImmutableList aw = reactionUnitComponentFields.aw();
        Object obj2 = null;
        if (!aw.isEmpty()) {
            for (int i = 0; i < Math.min(12, aw.size()); i++) {
                ReactionFacepileProfile b = ((FacepileModel) aw.get(i)).b();
                if (b == null || b.d() == null || Strings.isNullOrEmpty(b.d().b())) {
                    break;
                }
            }
            obj2 = 1;
        }
        return (obj2 == null || reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    public static ReactionPostPivotUnitComponentDefinition m23888a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPostPivotUnitComponentDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19996f) {
                ReactionPostPivotUnitComponentDefinition reactionPostPivotUnitComponentDefinition;
                if (a2 != null) {
                    reactionPostPivotUnitComponentDefinition = (ReactionPostPivotUnitComponentDefinition) a2.a(f19996f);
                } else {
                    reactionPostPivotUnitComponentDefinition = f19995e;
                }
                if (reactionPostPivotUnitComponentDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23889b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19996f, b3);
                        } else {
                            f19995e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPostPivotUnitComponentDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionPostPivotUnitComponentDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, ReactionFacepilePartDefinition reactionFacepilePartDefinition, TextPartDefinition textPartDefinition) {
        this.f19997b = basicReactionActionPartDefinition;
        this.f19998c = reactionFacepilePartDefinition;
        this.f19999d = textPartDefinition;
    }

    public final ViewType<CustomLinearLayout> m23890a() {
        return f19994a;
    }
}
