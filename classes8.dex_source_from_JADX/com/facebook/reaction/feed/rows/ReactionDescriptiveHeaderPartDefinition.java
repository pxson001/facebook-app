package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTextWithEntitiesPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitHeaderFieldsModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: article_depth_level */
public class ReactionDescriptiveHeaderPartDefinition extends MultiRowSinglePartDefinition<ReactionCardNode, Void, CanLaunchReactionIntent, FrameLayout> {
    public static final ViewType f19205a = new C20961();
    private static ReactionDescriptiveHeaderPartDefinition f19206c;
    private static final Object f19207d = new Object();
    private final ReactionTextWithEntitiesPartDefinition f19208b;

    /* compiled from: article_depth_level */
    final class C20961 extends ViewType {
        C20961() {
        }

        public final View m23217a(Context context) {
            return LayoutInflater.from(context).inflate(2130906623, null);
        }
    }

    private static ReactionDescriptiveHeaderPartDefinition m23219b(InjectorLike injectorLike) {
        return new ReactionDescriptiveHeaderPartDefinition(ReactionTextWithEntitiesPartDefinition.m23423a(injectorLike));
    }

    public final Object m23221a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        subParts.a(2131566648, this.f19208b, new Props(reactionCardNode.mo1117k().fw_().fA_(), reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
        return null;
    }

    public final boolean m23222a(Object obj) {
        ReactionUnitHeaderFieldsModel fw_ = ((ReactionCardNode) obj).mo1117k().fw_();
        return (fw_ == null || fw_.fA_() == null || Strings.isNullOrEmpty(fw_.fA_().a())) ? false : true;
    }

    @Inject
    public ReactionDescriptiveHeaderPartDefinition(ReactionTextWithEntitiesPartDefinition reactionTextWithEntitiesPartDefinition) {
        this.f19208b = reactionTextWithEntitiesPartDefinition;
    }

    public final ViewType m23220a() {
        return f19205a;
    }

    public static ReactionDescriptiveHeaderPartDefinition m23218a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionDescriptiveHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19207d) {
                ReactionDescriptiveHeaderPartDefinition reactionDescriptiveHeaderPartDefinition;
                if (a2 != null) {
                    reactionDescriptiveHeaderPartDefinition = (ReactionDescriptiveHeaderPartDefinition) a2.a(f19207d);
                } else {
                    reactionDescriptiveHeaderPartDefinition = f19206c;
                }
                if (reactionDescriptiveHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23219b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19207d, b3);
                        } else {
                            f19206c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionDescriptiveHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
