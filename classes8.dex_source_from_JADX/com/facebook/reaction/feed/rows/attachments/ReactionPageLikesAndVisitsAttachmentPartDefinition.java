package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
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
import com.facebook.reaction.common.ReactionAttachmentNode;
import com.facebook.reaction.feed.rows.subparts.ReactionTitleAndLabelViewPartDefinition;
import com.facebook.reaction.feed.rows.subparts.ReactionTitleAndLabelViewPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: apply_button_tapped */
public class ReactionPageLikesAndVisitsAttachmentPartDefinition extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, AnyEnvironment, SegmentedLinearLayout> {
    private static ReactionPageLikesAndVisitsAttachmentPartDefinition f19352b;
    private static final Object f19353c = new Object();
    private final ReactionTitleAndLabelViewPartDefinition f19354a;

    private static ReactionPageLikesAndVisitsAttachmentPartDefinition m23354b(InjectorLike injectorLike) {
        return new ReactionPageLikesAndVisitsAttachmentPartDefinition(ReactionTitleAndLabelViewPartDefinition.m23428a(injectorLike));
    }

    public final Object m23356a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        subParts.a(2131566622, this.f19354a, new Props(m23353a(reactionAttachmentNode.f18832a.ab()), reactionAttachmentNode.f18832a.ac().a(), 2131625824, 2131625825));
        subParts.a(2131566623, this.f19354a, new Props(m23353a(reactionAttachmentNode.f18832a.ad()), reactionAttachmentNode.f18832a.ae().a(), 2131625824, 2131625825, reactionAttachmentNode.f18832a.ad() > 0));
        return null;
    }

    public final boolean m23357a(Object obj) {
        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = ((ReactionAttachmentNode) obj).f18832a;
        return (reactionStoryAttachmentFragmentModel.ac() == null || reactionStoryAttachmentFragmentModel.ae() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.ac().a()) || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.ae().a())) ? false : true;
    }

    @Inject
    public ReactionPageLikesAndVisitsAttachmentPartDefinition(ReactionTitleAndLabelViewPartDefinition reactionTitleAndLabelViewPartDefinition) {
        this.f19354a = reactionTitleAndLabelViewPartDefinition;
    }

    public static ReactionPageLikesAndVisitsAttachmentPartDefinition m23352a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPageLikesAndVisitsAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19353c) {
                ReactionPageLikesAndVisitsAttachmentPartDefinition reactionPageLikesAndVisitsAttachmentPartDefinition;
                if (a2 != null) {
                    reactionPageLikesAndVisitsAttachmentPartDefinition = (ReactionPageLikesAndVisitsAttachmentPartDefinition) a2.a(f19353c);
                } else {
                    reactionPageLikesAndVisitsAttachmentPartDefinition = f19352b;
                }
                if (reactionPageLikesAndVisitsAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23354b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19353c, b3);
                        } else {
                            f19352b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPageLikesAndVisitsAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<SegmentedLinearLayout> m23355a() {
        return ReactionSimpleLeftRightTextAttachmentPartDefinition.f19377a;
    }

    private static String m23353a(int i) {
        return StringLocaleUtil.a("%,d", new Object[]{Integer.valueOf(i)});
    }
}
