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
import com.facebook.reaction.protocol.graphql.ReactionActionsGraphQLModels.ReactionStoryAttachmentActionFragmentModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: arg_is_edit_mode */
public class ReactionSingleActionFooterPartDefinition extends MultiRowSinglePartDefinition<ReactionCardNode, Void, AnyEnvironment, SegmentedLinearLayout> {
    public static final ViewType f19268a = new C20991();
    private static ReactionSingleActionFooterPartDefinition f19269d;
    private static final Object f19270e = new Object();
    private final BasicReactionActionPartDefinition f19271b;
    private final TextPartDefinition f19272c;

    /* compiled from: arg_is_edit_mode */
    final class C20991 extends ViewType {
        C20991() {
        }

        public final View m23280a(Context context) {
            return (SegmentedLinearLayout) LayoutInflater.from(context).inflate(2130906715, null);
        }
    }

    private static ReactionSingleActionFooterPartDefinition m23282b(InjectorLike injectorLike) {
        return new ReactionSingleActionFooterPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m23284a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionCardNode reactionCardNode = (ReactionCardNode) obj;
        ReactionStoryAttachmentActionFragmentModel reactionStoryAttachmentActionFragmentModel = (ReactionStoryAttachmentActionFragmentModel) reactionCardNode.mo1117k().fx_().a().get(0);
        subParts.a(2131566657, this.f19272c, reactionStoryAttachmentActionFragmentModel.fU_().a());
        subParts.a(this.f19271b, new Props(reactionStoryAttachmentActionFragmentModel, reactionCardNode.mo1117k().d(), reactionCardNode.mo1117k().n()));
        return null;
    }

    public final boolean m23285a(Object obj) {
        ReactionAttachmentsModel fx_ = ((ReactionCardNode) obj).mo1117k().fx_();
        return (fx_ == null || CollectionUtil.a(fx_.a()) || fx_.a().size() != 1 || ((ReactionStoryAttachmentActionFragmentModel) fx_.a().get(0)).fU_() == null || Strings.isNullOrEmpty(((ReactionStoryAttachmentActionFragmentModel) fx_.a().get(0)).fU_().a())) ? false : true;
    }

    @Inject
    public ReactionSingleActionFooterPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition, TextPartDefinition textPartDefinition) {
        this.f19271b = basicReactionActionPartDefinition;
        this.f19272c = textPartDefinition;
    }

    public final ViewType m23283a() {
        return f19268a;
    }

    public static ReactionSingleActionFooterPartDefinition m23281a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionSingleActionFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19270e) {
                ReactionSingleActionFooterPartDefinition reactionSingleActionFooterPartDefinition;
                if (a2 != null) {
                    reactionSingleActionFooterPartDefinition = (ReactionSingleActionFooterPartDefinition) a2.a(f19270e);
                } else {
                    reactionSingleActionFooterPartDefinition = f19269d;
                }
                if (reactionSingleActionFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23282b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19270e, b3);
                        } else {
                            f19269d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionSingleActionFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
