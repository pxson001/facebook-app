package com.facebook.reaction.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
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
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.rows.subparts.BasicReactionHeaderPartDefinition;
import com.facebook.reaction.feed.rows.subparts.BasicReactionHeaderPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article */
public class ReactionIconInlineActionHeaderPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionCardNode, Void, E, ImageBlockLayout> {
    public static final ViewType f19233a = ViewType.a(2130906629);
    private static ReactionIconInlineActionHeaderPartDefinition f19234f;
    private static final Object f19235g = new Object();
    private final BasicReactionActionPartDefinition f19236b;
    private final BasicReactionHeaderPartDefinition f19237c;
    private final TextAppearancePartDefinition f19238d;
    private final TextPartDefinition f19239e;

    private static ReactionIconInlineActionHeaderPartDefinition m23247b(InjectorLike injectorLike) {
        return new ReactionIconInlineActionHeaderPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), BasicReactionHeaderPartDefinition.m23394a(injectorLike), TextAppearancePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23249a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionUnitHeaderFieldsModel fw_ = reactionCardNode.mo1117k().fw_();
        String d = reactionCardNode.mo1117k().d();
        String n = reactionCardNode.mo1117k().n();
        subParts.a(this.f19237c, new Props(fw_, d, n));
        ReactionStoryAttachmentActionFragmentModel b = fw_.b();
        String a = b.fU_().a();
        subParts.a(2131566654, this.f19236b, new BasicReactionActionPartDefinition.Props(b, a, d, n));
        subParts.a(2131566654, this.f19239e, a);
        subParts.a(2131566654, this.f19238d, Integer.valueOf(b.fS_() ? 2131625819 : 2131625820));
        return null;
    }

    public final boolean m23250a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a()) || fw_.b() == null || fw_.b().j() == null || fw_.b().j() == GraphQLReactionStoryActionStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || fw_.b().fU_() == null || Strings.isNullOrEmpty(fw_.b().fU_().a())) ? false : true;
    }

    @Inject
    public ReactionIconInlineActionHeaderPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, BasicReactionHeaderPartDefinition basicReactionHeaderPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition, TextPartDefinition textPartDefinition) {
        this.f19236b = basicReactionActionPartDefinition;
        this.f19237c = basicReactionHeaderPartDefinition;
        this.f19238d = textAppearancePartDefinition;
        this.f19239e = textPartDefinition;
    }

    public static ReactionIconInlineActionHeaderPartDefinition m23246a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionIconInlineActionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19235g) {
                ReactionIconInlineActionHeaderPartDefinition reactionIconInlineActionHeaderPartDefinition;
                if (a2 != null) {
                    reactionIconInlineActionHeaderPartDefinition = (ReactionIconInlineActionHeaderPartDefinition) a2.a(f19235g);
                } else {
                    reactionIconInlineActionHeaderPartDefinition = f19234f;
                }
                if (reactionIconInlineActionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23247b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19235g, b3);
                        } else {
                            f19234f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionIconInlineActionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23248a() {
        return f19233a;
    }
}
