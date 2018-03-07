package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.feed.common.BasicReactionTextPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionActionFatFieldsModel.ProfileModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: account_secret_id */
public class ReactionSimpleTextUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, TextView> {
    public static final ViewType<BetterTextView> f20060a = new C21451();
    private static ReactionSimpleTextUnitComponentPartDefinition f20061d;
    private static final Object f20062e = new Object();
    private final BasicReactionActionPartDefinition f20063b;
    private final BasicReactionTextPartDefinition f20064c;

    /* compiled from: account_secret_id */
    final class C21451 extends ViewType<BetterTextView> {
        C21451() {
        }

        public final View m23949a(Context context) {
            return (BetterTextView) LayoutInflater.from(context).inflate(2130906649, null);
        }
    }

    private static ReactionSimpleTextUnitComponentPartDefinition m23951b(InjectorLike injectorLike) {
        return new ReactionSimpleTextUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), BasicReactionTextPartDefinition.m22990a(injectorLike));
    }

    public final Object m23953a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.f18862b;
        ReactionStoryAttachmentActionFragmentModel v = reactionUnitComponentFields.v();
        subParts.a(this.f20064c, reactionUnitComponentFields.bv().a());
        if (v != null) {
            String str;
            ProfileModel M = v.M();
            BasicReactionActionPartDefinition basicReactionActionPartDefinition = this.f20063b;
            if (M == null) {
                str = null;
            } else {
                str = M.j();
            }
            subParts.a(basicReactionActionPartDefinition, new Props(v, str, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d));
        }
        return null;
    }

    public final boolean m23954a(Object obj) {
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).f18862b;
        return (reactionUnitComponentFields.bv() == null || StringUtil.a(reactionUnitComponentFields.bv().a())) ? false : true;
    }

    @Inject
    public ReactionSimpleTextUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, BasicReactionTextPartDefinition basicReactionTextPartDefinition) {
        this.f20063b = basicReactionActionPartDefinition;
        this.f20064c = basicReactionTextPartDefinition;
    }

    public static ReactionSimpleTextUnitComponentPartDefinition m23950a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSimpleTextUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20062e) {
                ReactionSimpleTextUnitComponentPartDefinition reactionSimpleTextUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionSimpleTextUnitComponentPartDefinition = (ReactionSimpleTextUnitComponentPartDefinition) a2.a(f20062e);
                } else {
                    reactionSimpleTextUnitComponentPartDefinition = f20061d;
                }
                if (reactionSimpleTextUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23951b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20062e, b3);
                        } else {
                            f20061d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSimpleTextUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m23952a() {
        return f20060a;
    }
}
