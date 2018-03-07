package com.facebook.gametime.ui.components.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.HScrollRecyclerViewRowType;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyle;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageStyleFactory;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PageSubParts;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition;
import com.facebook.feed.rows.sections.hscrollrecyclerview.PersistentRecyclerPartDefinition.Callbacks;
import com.facebook.feed.rows.sections.hscrollrecyclerview.SimpleCallbacks;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Props;
import com.facebook.gametime.ui.components.partdefinition.GametimeSportsPlayUnitComponentPartDefinition.Style;
import com.facebook.gametime.ui.reaction.GametimeEnvironment;
import com.facebook.gametime.ui.reaction.HasGametimePlays;
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
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.GametimeDataFactFragment;
import com.facebook.widget.hscrollrecyclerview.HScrollRecyclerView;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TASK_REVERSE_GEOCODE */
public class GametimeRecentPlaysComponentPartDefinition<E extends CanLaunchReactionIntent & HasGametimePlays & HasContext & HasPersistentState & HasPositionInformation & HasReactionInteractionTracker> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, Void, E, HScrollRecyclerView> {
    private static GametimeRecentPlaysComponentPartDefinition f25106e;
    private static final Object f25107f = new Object();
    private final BackgroundPartDefinition f25108a;
    private final PageStyleFactory f25109b;
    private final PersistentRecyclerPartDefinition<Object, E> f25110c;
    public final GametimeSportsPlayUnitComponentPartDefinition f25111d;

    private static GametimeRecentPlaysComponentPartDefinition m27095b(InjectorLike injectorLike) {
        return new GametimeRecentPlaysComponentPartDefinition(BackgroundPartDefinition.a(injectorLike), PageStyleFactory.b(injectorLike), PersistentRecyclerPartDefinition.a(injectorLike), GametimeSportsPlayUnitComponentPartDefinition.m27111a(injectorLike));
    }

    private Callbacks<Object, E> m27093a(ReactionUnitComponentNode reactionUnitComponentNode, ReactionHScrollComponentKey reactionHScrollComponentKey, E e) {
        final ImmutableList bW = reactionUnitComponentNode.b.bW();
        final E e2 = e;
        final ReactionHScrollComponentKey reactionHScrollComponentKey2 = reactionHScrollComponentKey;
        final ReactionUnitComponentNode reactionUnitComponentNode2 = reactionUnitComponentNode;
        return new SimpleCallbacks<E>(this) {
            final /* synthetic */ GametimeRecentPlaysComponentPartDefinition f25105e;

            public final void m27091a(PageSubParts<E> pageSubParts) {
                int size = bW.size();
                for (int i = 0; i < size; i++) {
                    pageSubParts.a(this.f25105e.f25111d, new Props((GametimeDataFactFragment) bW.get(i), Style.WITH_BORDER));
                }
            }

            public final void m27092c(int i) {
                ((ReactionHScrollComponentPersistentState) ((HasPersistentState) e2).a(reactionHScrollComponentKey2, reactionUnitComponentNode2)).f = i;
                ((HasReactionInteractionTracker) e2).kE_().a(reactionUnitComponentNode2.c, reactionUnitComponentNode2.d);
            }
        };
    }

    public final Object m27097a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        GametimeEnvironment gametimeEnvironment = (GametimeEnvironment) canLaunchReactionIntent;
        gametimeEnvironment.m.a(reactionUnitComponentNode.c, reactionUnitComponentNode.b.U());
        ReactionHScrollComponentKey reactionHScrollComponentKey = new ReactionHScrollComponentKey(reactionUnitComponentNode.c);
        int c = SizeUtil.c(((HasContext) canLaunchReactionIntent).getContext(), (float) ((HasContext) canLaunchReactionIntent).getContext().getResources().getDimensionPixelSize(2131431398));
        subParts.a(this.f25108a, new StylingData(PageStyle.a));
        subParts.a(this.f25110c, new PersistentRecyclerPartDefinition.Props(this.f25109b.a(((float) c) + 8.0f, PageStyle.a, true), ((ReactionHScrollComponentPersistentState) ((HasPersistentState) canLaunchReactionIntent).a(reactionHScrollComponentKey, reactionUnitComponentNode)).f, m27093a(reactionUnitComponentNode, reactionHScrollComponentKey, canLaunchReactionIntent), reactionUnitComponentNode.g(), reactionUnitComponentNode));
        return null;
    }

    public final boolean m27098a(Object obj) {
        return CollectionUtil.b(((ReactionUnitComponentNode) obj).b.bW());
    }

    public static GametimeRecentPlaysComponentPartDefinition m27094a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeRecentPlaysComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25107f) {
                GametimeRecentPlaysComponentPartDefinition gametimeRecentPlaysComponentPartDefinition;
                if (a2 != null) {
                    gametimeRecentPlaysComponentPartDefinition = (GametimeRecentPlaysComponentPartDefinition) a2.a(f25107f);
                } else {
                    gametimeRecentPlaysComponentPartDefinition = f25106e;
                }
                if (gametimeRecentPlaysComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27095b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25107f, b3);
                        } else {
                            f25106e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeRecentPlaysComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public GametimeRecentPlaysComponentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PageStyleFactory pageStyleFactory, PersistentRecyclerPartDefinition persistentRecyclerPartDefinition, GametimeSportsPlayUnitComponentPartDefinition gametimeSportsPlayUnitComponentPartDefinition) {
        this.f25108a = backgroundPartDefinition;
        this.f25109b = pageStyleFactory;
        this.f25110c = persistentRecyclerPartDefinition;
        this.f25111d = gametimeSportsPlayUnitComponentPartDefinition;
    }

    public final ViewType m27096a() {
        return HScrollRecyclerViewRowType.a;
    }
}
