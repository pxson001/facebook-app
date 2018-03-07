package com.facebook.gametime.ui.components.partdefinition.match;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponent.Builder;
import com.facebook.gametime.ui.components.partdefinition.match.GametimeMatchComponent.State;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.MatchModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SubsequentPhotosQuery */
public class GametimeMatchUnitComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState> extends ComponentPartDefinition<ReactionUnitComponentNode, E> {
    private static GametimeMatchUnitComponentPartDefinition f25250d;
    private static final Object f25251e = new Object();
    private final GametimeMatchComponent f25252c;

    /* compiled from: SubsequentPhotosQuery */
    public class TeamInfo {
        public final String f25247a;
        public final String f25248b;
        public final String f25249c;

        public TeamInfo(String str, String str2, String str3) {
            this.f25247a = str;
            this.f25248b = str2;
            this.f25249c = str3;
        }
    }

    private static GametimeMatchUnitComponentPartDefinition m27186b(InjectorLike injectorLike) {
        return new GametimeMatchUnitComponentPartDefinition((Context) injectorLike.getInstance(Context.class), GametimeMatchComponent.m27157a(injectorLike));
    }

    private Component<?> m27184a(ComponentContext componentContext, ReactionUnitComponentNode reactionUnitComponentNode) {
        MatchModel bu = reactionUnitComponentNode.b.bu();
        TeamInfo teamInfo = new TeamInfo(bu.j().d().b().a(), bu.j().b(), bu.n() ? Integer.toString(bu.k()) : "");
        TeamInfo teamInfo2 = new TeamInfo(bu.o().d().b().a(), bu.o().b(), bu.n() ? Integer.toString(bu.p()) : "");
        State state = new State(this.f25252c);
        Builder builder = (Builder) GametimeMatchComponent.f25212b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m27154a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f25203a.f25207a = teamInfo;
        builder2.f25206d.set(0);
        builder2 = builder2;
        builder2.f25203a.f25208b = teamInfo2;
        builder2.f25206d.set(1);
        builder2 = builder2;
        builder2.f25203a.f25209c = ImmutableList.copyOf(m27187b(reactionUnitComponentNode));
        builder2.f25206d.set(2);
        builder2 = builder2;
        builder2.f25203a.f25210d = bu.r().b();
        builder2.f25206d.set(3);
        return builder2.d();
    }

    private static ImmutableList<String> m27187b(ReactionUnitComponentNode reactionUnitComponentNode) {
        ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
        Object arrayList = new ArrayList();
        arrayList.add(reactionUnitComponentFields.cC());
        if (!reactionUnitComponentFields.bu().n() || reactionUnitComponentFields.bF()) {
            arrayList.add(reactionUnitComponentFields.bu().l());
        } else {
            arrayList.add(reactionUnitComponentFields.bu().m());
        }
        arrayList.removeAll(Collections.singleton(null));
        return ImmutableList.copyOf(arrayList);
    }

    public final boolean m27190a(Object obj) {
        MatchModel bu = ((ReactionUnitComponentNode) obj).b.bu();
        return (bu == null || bu.j() == null || bu.j().d() == null || bu.j().d().b() == null || bu.o() == null || bu.o().d() == null || bu.o().d().b() == null || Strings.isNullOrEmpty(bu.j().d().b().a()) || Strings.isNullOrEmpty(bu.o().d().b().a()) || Strings.isNullOrEmpty(bu.j().b()) || Strings.isNullOrEmpty(bu.o().b())) ? false : true;
    }

    @Inject
    public GametimeMatchUnitComponentPartDefinition(Context context, GametimeMatchComponent gametimeMatchComponent) {
        super(context);
        this.f25252c = gametimeMatchComponent;
    }

    public static GametimeMatchUnitComponentPartDefinition m27185a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeMatchUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25251e) {
                GametimeMatchUnitComponentPartDefinition gametimeMatchUnitComponentPartDefinition;
                if (a2 != null) {
                    gametimeMatchUnitComponentPartDefinition = (GametimeMatchUnitComponentPartDefinition) a2.a(f25251e);
                } else {
                    gametimeMatchUnitComponentPartDefinition = f25250d;
                }
                if (gametimeMatchUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27186b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25251e, b3);
                        } else {
                            f25250d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeMatchUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final CacheableEntity m27191b(Object obj) {
        return null;
    }
}
