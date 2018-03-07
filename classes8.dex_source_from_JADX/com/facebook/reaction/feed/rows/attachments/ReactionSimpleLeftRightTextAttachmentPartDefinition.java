package com.facebook.reaction.feed.rows.attachments;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
/* compiled from: app_invites_app_discovery_lite */
public class ReactionSimpleLeftRightTextAttachmentPartDefinition extends MultiRowSinglePartDefinition<ReactionAttachmentNode, Void, AnyEnvironment, SegmentedLinearLayout> {
    public static final ViewType<SegmentedLinearLayout> f19377a = ViewType.a(2130906686);
    private static ReactionSimpleLeftRightTextAttachmentPartDefinition f19378c;
    private static final Object f19379d = new Object();
    private final ReactionTitleAndLabelViewPartDefinition f19380b;

    private static ReactionSimpleLeftRightTextAttachmentPartDefinition m23378b(InjectorLike injectorLike) {
        return new ReactionSimpleLeftRightTextAttachmentPartDefinition(ReactionTitleAndLabelViewPartDefinition.m23428a(injectorLike));
    }

    public final Object m23380a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionAttachmentNode reactionAttachmentNode = (ReactionAttachmentNode) obj;
        subParts.a(2131566622, this.f19380b, new Props(reactionAttachmentNode.f18832a.x().a(), reactionAttachmentNode.f18832a.w().a(), 2131625822, 2131625823));
        subParts.a(2131566623, this.f19380b, new Props(reactionAttachmentNode.f18832a.T().a(), reactionAttachmentNode.f18832a.S().a(), 2131625822, 2131625823));
        return null;
    }

    public final boolean m23381a(Object obj) {
        ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel = ((ReactionAttachmentNode) obj).f18832a;
        return (reactionStoryAttachmentFragmentModel.x() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.x().a()) || reactionStoryAttachmentFragmentModel.w() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.w().a()) || reactionStoryAttachmentFragmentModel.T() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.T().a()) || reactionStoryAttachmentFragmentModel.S() == null || Strings.isNullOrEmpty(reactionStoryAttachmentFragmentModel.S().a())) ? false : true;
    }

    @Inject
    public ReactionSimpleLeftRightTextAttachmentPartDefinition(ReactionTitleAndLabelViewPartDefinition reactionTitleAndLabelViewPartDefinition) {
        this.f19380b = reactionTitleAndLabelViewPartDefinition;
    }

    public final ViewType<SegmentedLinearLayout> m23379a() {
        return f19377a;
    }

    public static ReactionSimpleLeftRightTextAttachmentPartDefinition m23377a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSimpleLeftRightTextAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19379d) {
                ReactionSimpleLeftRightTextAttachmentPartDefinition reactionSimpleLeftRightTextAttachmentPartDefinition;
                if (a2 != null) {
                    reactionSimpleLeftRightTextAttachmentPartDefinition = (ReactionSimpleLeftRightTextAttachmentPartDefinition) a2.a(f19379d);
                } else {
                    reactionSimpleLeftRightTextAttachmentPartDefinition = f19378c;
                }
                if (reactionSimpleLeftRightTextAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23378b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19379d, b3);
                        } else {
                            f19378c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSimpleLeftRightTextAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
