package com.facebook.gametime.ui.components.partdefinition.fanfavorite;

import android.content.Context;
import android.graphics.Color;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gametime.ui.components.partdefinition.TwoColorBarPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.FbDraweePartDefinition;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props;
import com.facebook.multirow.parts.FbDraweePartDefinition.Props.Builder;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MatchModel;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TAB_INCOMING */
public class GametimeFanFavoritePostVotePartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, HasContext, CustomLinearLayout> {
    public static final ViewType f25171a = ViewType.a(2130904572);
    private static final CallerContext f25172b = CallerContext.a(GametimeFanFavoritePostVotePartDefinition.class, "gametime");
    private static GametimeFanFavoritePostVotePartDefinition f25173f;
    private static final Object f25174g = new Object();
    private final FbDraweePartDefinition f25175c;
    private final TextPartDefinition f25176d;
    private final TwoColorBarPartDefinition f25177e;

    private static GametimeFanFavoritePostVotePartDefinition m27139b(InjectorLike injectorLike) {
        return new GametimeFanFavoritePostVotePartDefinition(FbDraweePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TwoColorBarPartDefinition.m27133a(injectorLike));
    }

    public final Object m27141a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        HasContext hasContext = (HasContext) anyEnvironment;
        ReactionUnitComponentFields reactionUnitComponentFields = ((ReactionUnitComponentNode) obj).b;
        MatchModel bu = reactionUnitComponentFields.bu();
        Builder a = FbDraweePartDefinition.a().a(bu.j().d().b().a());
        a.c = f25172b;
        Props a2 = a.a();
        Builder a3 = FbDraweePartDefinition.a().a(bu.o().d().b().a());
        a3.c = f25172b;
        Props a4 = a3.a();
        int b = bu.b();
        b = (b * 100) / (b + bu.eU_());
        int i = 100 - b;
        subParts.a(2131562481, this.f25175c, a2);
        subParts.a(2131562485, this.f25175c, a4);
        subParts.a(2131562482, this.f25176d, b + " %");
        subParts.a(2131562484, this.f25176d, i + " %");
        if (reactionUnitComponentFields.cV() > 0) {
            subParts.a(2131562483, this.f25176d, hasContext.getContext().getResources().getString(2131241430, new Object[]{Integer.valueOf(reactionUnitComponentFields.cV())}));
        }
        subParts.a(2131562486, this.f25177e, new TwoColorBarPartDefinition.Props(Color.parseColor("#" + bu.d()), Color.parseColor("#" + bu.eV_()), (float) bu.b(), (float) bu.eU_(), 2131434003));
        return null;
    }

    public final boolean m27142a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        MatchModel bu = reactionUnitComponentNode.b.bu();
        if (bu != null) {
            if (bu.eU_() + bu.b() > 0 && GametimeFanFavoriteUnitComponentPartDefinition.m27150a(reactionUnitComponentNode)) {
                return true;
            }
        }
        return false;
    }

    @Inject
    public GametimeFanFavoritePostVotePartDefinition(FbDraweePartDefinition fbDraweePartDefinition, TextPartDefinition textPartDefinition, TwoColorBarPartDefinition twoColorBarPartDefinition) {
        this.f25175c = fbDraweePartDefinition;
        this.f25176d = textPartDefinition;
        this.f25177e = twoColorBarPartDefinition;
    }

    public final ViewType m27140a() {
        return f25171a;
    }

    public static GametimeFanFavoritePostVotePartDefinition m27138a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoritePostVotePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25174g) {
                GametimeFanFavoritePostVotePartDefinition gametimeFanFavoritePostVotePartDefinition;
                if (a2 != null) {
                    gametimeFanFavoritePostVotePartDefinition = (GametimeFanFavoritePostVotePartDefinition) a2.a(f25174g);
                } else {
                    gametimeFanFavoritePostVotePartDefinition = f25173f;
                }
                if (gametimeFanFavoritePostVotePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27139b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25174g, b3);
                        } else {
                            f25173f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeFanFavoritePostVotePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
