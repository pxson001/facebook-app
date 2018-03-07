package com.facebook.gametime.ui.components.partdefinition.fanfavorite;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.gametime.ui.components.persistentstate.GametimeFanFavoriteState;
import com.facebook.gametime.ui.components.persistentstate.GametimeFanFavoriteStateKey;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MatchModel;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TA */
public class GametimeFanFavoriteUnitComponentPartDefinition<E extends HasInvalidate & HasContext & HasPersistentState> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static GametimeFanFavoriteUnitComponentPartDefinition f25196c;
    private static final Object f25197d = new Object();
    private final GametimeFanFavoritePreVotePartDefinition f25198a;
    private final GametimeFanFavoritePostVotePartDefinition f25199b;

    private static GametimeFanFavoriteUnitComponentPartDefinition m27151b(InjectorLike injectorLike) {
        return new GametimeFanFavoriteUnitComponentPartDefinition(GametimeFanFavoritePreVotePartDefinition.m27143a(injectorLike), GametimeFanFavoritePostVotePartDefinition.m27138a(injectorLike));
    }

    public final Object m27152a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Object obj2;
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        GametimeFanFavoriteState gametimeFanFavoriteState = (GametimeFanFavoriteState) ((HasPersistentState) ((HasInvalidate) anyEnvironment)).a(new GametimeFanFavoriteStateKey(reactionUnitComponentNode), reactionUnitComponentNode);
        if (!reactionUnitComponentNode.b.bu().t() || gametimeFanFavoriteState.f25289a) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        if (obj2 != null) {
            baseMultiRowSubParts.a(this.f25198a, reactionUnitComponentNode);
        } else {
            baseMultiRowSubParts.a(this.f25199b, reactionUnitComponentNode);
        }
        return null;
    }

    public final boolean m27153a(Object obj) {
        return m27150a((ReactionUnitComponentNode) obj);
    }

    @Inject
    public GametimeFanFavoriteUnitComponentPartDefinition(GametimeFanFavoritePreVotePartDefinition gametimeFanFavoritePreVotePartDefinition, GametimeFanFavoritePostVotePartDefinition gametimeFanFavoritePostVotePartDefinition) {
        this.f25198a = gametimeFanFavoritePreVotePartDefinition;
        this.f25199b = gametimeFanFavoritePostVotePartDefinition;
    }

    public static boolean m27150a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields f = reactionUnitComponentNode.f();
        MatchModel bu = f.bu();
        if (bu == null || bu.c() == null || bu.c().a() == null || bu.c().a().a() == null || bu.g() == null || bu.g().a() == null || bu.g().a().a() == null) {
            return false;
        }
        try {
            Color.parseColor("#" + bu.d());
            Color.parseColor("#" + bu.eV_());
            Uri.parse(bu.c().a().a().a());
            Uri.parse(bu.g().a().a().a());
            if (Strings.isNullOrEmpty(bu.c().b()) || Strings.isNullOrEmpty(bu.g().b()) || f.F() == null || Strings.isNullOrEmpty(f.F().b()) || f.aM() == null || Strings.isNullOrEmpty(f.aM().b()) || f.bu().r() == null || Strings.isNullOrEmpty(bu.eW_().b()) || bu.b() < 0 || bu.eU_() < 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static GametimeFanFavoriteUnitComponentPartDefinition m27149a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeFanFavoriteUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25197d) {
                GametimeFanFavoriteUnitComponentPartDefinition gametimeFanFavoriteUnitComponentPartDefinition;
                if (a2 != null) {
                    gametimeFanFavoriteUnitComponentPartDefinition = (GametimeFanFavoriteUnitComponentPartDefinition) a2.a(f25197d);
                } else {
                    gametimeFanFavoriteUnitComponentPartDefinition = f25196c;
                }
                if (gametimeFanFavoriteUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27151b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25197d, b3);
                        } else {
                            f25196c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeFanFavoriteUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
