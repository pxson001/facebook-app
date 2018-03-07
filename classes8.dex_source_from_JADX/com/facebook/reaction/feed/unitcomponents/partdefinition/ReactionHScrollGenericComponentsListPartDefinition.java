package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollStateUtil;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.genericrecyclerview.HScrollGenericRecyclerViewAdapter;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ui.genericrecyclerview.SubComponentProps;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: al_applink_data */
public class ReactionHScrollGenericComponentsListPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, RecyclerView> {
    public static final ViewType f19751a = ViewType.a(2130906639);
    private static final String f19752b = ReactionHScrollGenericComponentsListPartDefinition.class.getSimpleName();
    private static ReactionHScrollGenericComponentsListPartDefinition f19753g;
    private static final Object f19754h = new Object();
    private final Lazy<FbErrorReporter> f19755c;
    private final Provider<HScrollLinearLayoutManager> f19756d;
    private final ReactionUnitComponentStyleMapper f19757e;
    private final ReactionUnitValidator f19758f;

    /* compiled from: al_applink_data */
    public class State {
        public final HScrollGenericRecyclerViewAdapter f19748a;
        public final LinearLayoutManager f19749b;
        public final ReactionHScrollComponentPersistentState f19750c;

        public State(HScrollGenericRecyclerViewAdapter hScrollGenericRecyclerViewAdapter, LinearLayoutManager linearLayoutManager, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState) {
            this.f19748a = hScrollGenericRecyclerViewAdapter;
            this.f19749b = linearLayoutManager;
            this.f19750c = reactionHScrollComponentPersistentState;
        }
    }

    private static ReactionHScrollGenericComponentsListPartDefinition m23663b(InjectorLike injectorLike) {
        return new ReactionHScrollGenericComponentsListPartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 494), IdBasedProvider.a(injectorLike, 3727), ReactionUnitComponentStyleMapper.m22890a(injectorLike), ReactionUnitValidator.m22908b(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m23666a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1477881573);
        m23662a((State) obj2, (CanLaunchReactionIntent) anyEnvironment, (RecyclerView) view);
        Logger.a(8, EntryType.MARK_POP, 603398246, a);
    }

    public final boolean m23667a(Object obj) {
        return "SUCCESS".equals(this.f19758f.m22915a((ReactionUnitComponentNode) obj));
    }

    public final void m23668b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        RecyclerView recyclerView = (RecyclerView) view;
        ReactionHScrollStateUtil.m23193a(state.f19749b, state.f19750c, recyclerView);
        recyclerView.setAdapter(null);
    }

    public static ReactionHScrollGenericComponentsListPartDefinition m23660a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionHScrollGenericComponentsListPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19754h) {
                ReactionHScrollGenericComponentsListPartDefinition reactionHScrollGenericComponentsListPartDefinition;
                if (a2 != null) {
                    reactionHScrollGenericComponentsListPartDefinition = (ReactionHScrollGenericComponentsListPartDefinition) a2.a(f19754h);
                } else {
                    reactionHScrollGenericComponentsListPartDefinition = f19753g;
                }
                if (reactionHScrollGenericComponentsListPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23663b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19754h, b3);
                        } else {
                            f19753g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionHScrollGenericComponentsListPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionHScrollGenericComponentsListPartDefinition(Lazy<FbErrorReporter> lazy, Provider<HScrollLinearLayoutManager> provider, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper, ReactionUnitValidator reactionUnitValidator) {
        this.f19755c = lazy;
        this.f19756d = provider;
        this.f19757e = reactionUnitComponentStyleMapper;
        this.f19758f = reactionUnitValidator;
    }

    public final ViewType<RecyclerView> m23664a() {
        return f19751a;
    }

    private State m23659a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ImmutableList b = ReactionUnitComponentUtil.m22902b(reactionUnitComponentNode);
        Map linkedHashMap = new LinkedHashMap();
        List arrayList = new ArrayList();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) b.get(i);
            GraphQLReactionUnitComponentStyle a = reactionUnitComponentFields.a();
            ReactionUnitComponentNode reactionUnitComponentNode2 = new ReactionUnitComponentNode(reactionUnitComponentFields, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.m22888l(), reactionUnitComponentNode.m22889m());
            SubComponentProps a2 = m23661a(this.f19757e.m22892a(a), (CanLaunchReactionIntent) e);
            if (a2 != null) {
                a2.f20191a.a(reactionUnitComponentNode2);
                ViewType viewType = a2.f20192b;
                if (!linkedHashMap.containsKey(viewType)) {
                    linkedHashMap.put(viewType, Integer.valueOf(linkedHashMap.size()));
                }
                arrayList.add(a2);
            }
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f19756d.get();
        linearLayoutManager.b(0);
        return new State(new HScrollGenericRecyclerViewAdapter(this.f19755c, arrayList, linkedHashMap), linearLayoutManager, (ReactionHScrollComponentPersistentState) ((HasPersistentState) e).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.m22887k()), reactionUnitComponentNode));
    }

    private static void m23662a(State state, E e, RecyclerView recyclerView) {
        CustomViewUtils.b(recyclerView, new ColorDrawable(((HasContext) e).getContext().getResources().getColor(2131361864)));
        recyclerView.setLayoutManager(state.f19749b);
        recyclerView.setAdapter(state.f19748a);
        ReactionHScrollStateUtil.m23192a(state.f19749b, state.f19750c);
    }

    @Nullable
    private SubComponentProps m23661a(MultiRowPartWithIsNeeded multiRowPartWithIsNeeded, E e) {
        if (multiRowPartWithIsNeeded instanceof MultiRowSinglePartDefinition) {
            MultiRowSinglePartDefinition multiRowSinglePartDefinition = (MultiRowSinglePartDefinition) multiRowPartWithIsNeeded;
            return new SubComponentProps(new SimpleRenderer(multiRowSinglePartDefinition, e), multiRowSinglePartDefinition.a());
        }
        ((AbstractFbErrorReporter) this.f19755c.get()).b(f19752b, "Tried to render GroupPartDefinition inside this part definition, only SinglePartDefinitions currently supported");
        return null;
    }
}
