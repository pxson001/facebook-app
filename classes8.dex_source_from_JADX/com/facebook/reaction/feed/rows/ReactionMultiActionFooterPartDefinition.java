package com.facebook.reaction.feed.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition.Props;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLInterfaces.ReactionStoryAttachmentActionFragment;
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_page_admin_cta */
public class ReactionMultiActionFooterPartDefinition extends MultiRowSinglePartDefinition<ReactionCardNode, Void, AnyEnvironment, SegmentedLinearLayout> {
    public static final ViewType f19255a = new C20981();
    private static ReactionMultiActionFooterPartDefinition f19256d;
    private static final Object f19257e = new Object();
    private final BasicReactionActionPartDefinition f19258b;
    private final TextPartDefinition f19259c;

    /* compiled from: arg_page_admin_cta */
    final class C20981 extends ViewType {
        C20981() {
        }

        public final View m23267a(Context context) {
            return (SegmentedLinearLayout) LayoutInflater.from(context).inflate(2130906682, null);
        }
    }

    private static ReactionMultiActionFooterPartDefinition m23271b(InjectorLike injectorLike) {
        return new ReactionMultiActionFooterPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23273a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        m23269a((ReactionStoryAttachmentActionFragmentModel) reactionCardNode.mo1117k().fx_().a().get(0), 2131566739, subParts, reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n());
        m23269a((ReactionStoryAttachmentActionFragmentModel) reactionCardNode.mo1117k().fx_().a().get(1), 2131566740, subParts, reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n());
        return null;
    }

    public final boolean m23274a(Object obj) {
        ReactionAttachmentsModel fx_ = ((ReactionCardNode) obj).mo1117k().fx_();
        return fx_ != null && !CollectionUtil.a(fx_.a()) && fx_.a().size() > 1 && m23270a((ReactionStoryAttachmentActionFragmentModel) fx_.a().get(0)) && m23270a((ReactionStoryAttachmentActionFragmentModel) fx_.a().get(1));
    }

    public final ViewType m23272a() {
        return f19255a;
    }

    @Inject
    public ReactionMultiActionFooterPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, TextPartDefinition textPartDefinition) {
        this.f19258b = basicReactionActionPartDefinition;
        this.f19259c = textPartDefinition;
    }

    public static ReactionMultiActionFooterPartDefinition m23268a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionMultiActionFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19257e) {
                ReactionMultiActionFooterPartDefinition reactionMultiActionFooterPartDefinition;
                if (a2 != null) {
                    reactionMultiActionFooterPartDefinition = (ReactionMultiActionFooterPartDefinition) a2.a(f19257e);
                } else {
                    reactionMultiActionFooterPartDefinition = f19256d;
                }
                if (reactionMultiActionFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23271b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19257e, b3);
                        } else {
                            f19256d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionMultiActionFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private void m23269a(ReactionStoryAttachmentActionFragment reactionStoryAttachmentActionFragment, int i, SubParts<AnyEnvironment> subParts, String str, String str2) {
        subParts.a(i, this.f19259c, reactionStoryAttachmentActionFragment.fU_().a());
        subParts.a(i, this.f19258b, new Props(reactionStoryAttachmentActionFragment, str, str2));
    }

    @VisibleForTesting
    private static boolean m23270a(ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel) {
        return (reactionStoryAttachmentActionFragmentModel.fU_() == null || Strings.isNullOrEmpty(reactionStoryAttachmentActionFragmentModel.fU_().a())) ? false : true;
    }
}
