package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.common.ReactionUnitComponentStyleMapper;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollStateUtil;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionPaginatedComponentFragment.PaginatedComponents.ReactionPaginatedComponents.Edges;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.widget.recyclerview.HScrollDividerDecorator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ad_choices_icon */
public class ReactionPhotosUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, RecyclerView> {
    public static final ViewType f19973a = new C21381();
    public static final CallerContext f19974b = CallerContext.a(ReactionPhotosUnitComponentPartDefinition.class, "reaction_photos");
    private static ReactionPhotosUnitComponentPartDefinition f19975e;
    private static final Object f19976f = new Object();
    private final ReactionIntentFactory f19977c;
    private final ReactionUnitComponentStyleMapper f19978d;

    /* compiled from: ad_choices_icon */
    final class C21381 extends ViewType {
        C21381() {
        }

        public final View m23846a(Context context) {
            RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(2130906646, null);
            Resources resources = context.getResources();
            recyclerView.a(new HScrollDividerDecorator(resources.getColor(2131361920), resources.getDimensionPixelSize(2131431422)));
            return recyclerView;
        }
    }

    /* compiled from: ad_choices_icon */
    public class ReactionPhotoViewHolder extends ViewHolder {
        final /* synthetic */ ReactionPhotosUnitComponentPartDefinition f19958l;
        public FbDraweeView f19959m;

        public ReactionPhotoViewHolder(ReactionPhotosUnitComponentPartDefinition reactionPhotosUnitComponentPartDefinition, FbDraweeView fbDraweeView) {
            this.f19958l = reactionPhotosUnitComponentPartDefinition;
            super(fbDraweeView);
            this.f19959m = fbDraweeView;
        }
    }

    /* compiled from: ad_choices_icon */
    public class ReactionPhotosAdapter extends Adapter<ViewHolder> {
        final /* synthetic */ ReactionPhotosUnitComponentPartDefinition f19960a;
        private final E f19961b;
        private final Context f19962c;
        private final ReactionIntentFactory f19963d;
        private int f19964e;
        private ImmutableList<ReactionImageFields> f19965f;
        @Nullable
        private final MultiRowSinglePartDefinition<ReactionUnitComponentNode, ?, E, ?> f19966g;
        private final ReactionUnitComponentNode f19967h;

        public ReactionPhotosAdapter(ReactionPhotosUnitComponentPartDefinition reactionPhotosUnitComponentPartDefinition, Context context, ImmutableList<ReactionImageFields> immutableList, ReactionIntentFactory reactionIntentFactory, E e, double d, ReactionUnitComponentFields reactionUnitComponentFields, @Nullable MultiRowSinglePartDefinition<ReactionUnitComponentNode, ?, E, ?> multiRowSinglePartDefinition, ReactionUnitComponentNode reactionUnitComponentNode) {
            this.f19960a = reactionPhotosUnitComponentPartDefinition;
            this.f19962c = context;
            this.f19964e = (int) (((double) this.f19962c.getResources().getDisplayMetrics().widthPixels) * d);
            this.f19963d = reactionIntentFactory;
            this.f19961b = e;
            this.f19965f = immutableList;
            this.f19967h = new ReactionUnitComponentNode(reactionUnitComponentFields, reactionUnitComponentNode.f18863c, reactionUnitComponentNode.m22888l(), reactionUnitComponentNode.m22889m());
            this.f19966g = multiRowSinglePartDefinition;
        }

        public final int aZ_() {
            return (m23847d() ? 1 : 0) + this.f19965f.size();
        }

        public int getItemViewType(int i) {
            if (i == 0 && m23847d()) {
                return 0;
            }
            return 1;
        }

        public final ViewHolder m23849a(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new ReactionSimpleRendererViewHolder(this.f19960a, this.f19967h, this.f19966g, this.f19961b);
            }
            return new ReactionPhotoViewHolder(this.f19960a, new FbDraweeView(this.f19962c));
        }

        public final void m23850a(ViewHolder viewHolder, int i) {
            if (viewHolder instanceof ReactionPhotoViewHolder) {
                ReactionImageFields reactionImageFields = (ReactionImageFields) this.f19965f.get(m23848e(i));
                ReactionPhotoViewHolder reactionPhotoViewHolder = (ReactionPhotoViewHolder) viewHolder;
                int i2 = this.f19964e;
                reactionPhotoViewHolder.f19959m.a(Uri.parse(reactionImageFields.b()), ReactionPhotosUnitComponentPartDefinition.f19974b);
                reactionPhotoViewHolder.f19959m.setLayoutParams(new LayoutParams(i2, i2));
                return;
            }
            ReactionSimpleRendererViewHolder reactionSimpleRendererViewHolder = (ReactionSimpleRendererViewHolder) viewHolder;
            int i3 = this.f19964e;
            reactionSimpleRendererViewHolder.f19969m.a(reactionSimpleRendererViewHolder.a);
            reactionSimpleRendererViewHolder.a.setLayoutParams(new LayoutParams(i3, i3));
        }

        private int m23848e(int i) {
            return i - (m23847d() ? 1 : 0);
        }

        private boolean m23847d() {
            return this.f19966g != null;
        }
    }

    /* compiled from: ad_choices_icon */
    public class ReactionSimpleRendererViewHolder extends ViewHolder {
        final /* synthetic */ ReactionPhotosUnitComponentPartDefinition f19968l;
        public SimpleRenderer f19969m;

        public ReactionSimpleRendererViewHolder(ReactionPhotosUnitComponentPartDefinition reactionPhotosUnitComponentPartDefinition, ReactionUnitComponentNode reactionUnitComponentNode, MultiRowSinglePartDefinition<ReactionUnitComponentNode, ?, E, ?> multiRowSinglePartDefinition, E e) {
            this.f19968l = reactionPhotosUnitComponentPartDefinition;
            super(multiRowSinglePartDefinition.a().a(((HasContext) e).getContext()));
            this.f19969m = new SimpleRenderer(multiRowSinglePartDefinition, e);
            this.f19969m.a(reactionUnitComponentNode);
        }
    }

    /* compiled from: ad_choices_icon */
    public class State {
        public final Adapter f19970a;
        public final LinearLayoutManager f19971b;
        public final ReactionHScrollComponentPersistentState f19972c;

        public State(Adapter adapter, LinearLayoutManager linearLayoutManager, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState) {
            this.f19970a = adapter;
            this.f19971b = linearLayoutManager;
            this.f19972c = reactionHScrollComponentPersistentState;
        }
    }

    private static ReactionPhotosUnitComponentPartDefinition m23854b(InjectorLike injectorLike) {
        return new ReactionPhotosUnitComponentPartDefinition(ReactionIntentFactory.m22683a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m23856a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m23851a((ReactionUnitComponentNode) obj, (CanLaunchReactionIntent) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m23857a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1425321441);
        State state = (State) obj2;
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(state.f19971b);
        recyclerView.setAdapter(state.f19970a);
        ReactionHScrollStateUtil.m23192a(state.f19971b, state.f19972c);
        Logger.a(8, EntryType.MARK_POP, 1886271256, a);
    }

    public final boolean m23858a(Object obj) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        return reactionUnitComponentNode.f18862b.cE() > 0.0d && reactionUnitComponentNode.f18862b.cE() < 1.0d && CollectionUtil.b(m23853a(((ReactionPaginatedComponentFragment) reactionUnitComponentNode.f18862b).dk().c().a()));
    }

    public final void m23859b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        RecyclerView recyclerView = (RecyclerView) view;
        ReactionHScrollStateUtil.m23193a(state.f19971b, state.f19972c, recyclerView);
        recyclerView.setAdapter(null);
    }

    public static ReactionPhotosUnitComponentPartDefinition m23852a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPhotosUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19976f) {
                ReactionPhotosUnitComponentPartDefinition reactionPhotosUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPhotosUnitComponentPartDefinition = (ReactionPhotosUnitComponentPartDefinition) a2.a(f19976f);
                } else {
                    reactionPhotosUnitComponentPartDefinition = f19975e;
                }
                if (reactionPhotosUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23854b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19976f, b3);
                        } else {
                            f19975e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPhotosUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionPhotosUnitComponentPartDefinition(ReactionIntentFactory reactionIntentFactory, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f19977c = reactionIntentFactory;
        this.f19978d = reactionUnitComponentStyleMapper;
    }

    public final ViewType<RecyclerView> m23855a() {
        return f19973a;
    }

    private State m23851a(ReactionUnitComponentNode reactionUnitComponentNode, E e) {
        ImmutableList a = ((ReactionPaginatedComponentFragment) reactionUnitComponentNode.f18862b).dk().c().a();
        ImmutableList a2 = m23853a(a);
        ReactionUnitSubComponentModel a3 = ((EdgesModel) a.get(0)).a();
        GraphQLReactionUnitComponentStyle a4 = a3.a();
        MultiRowSinglePartDefinition multiRowSinglePartDefinition = null;
        MultiRowPartWithIsNeeded a5 = this.f19978d.m22892a(a4);
        if ((a5 instanceof MultiRowSinglePartDefinition) && !a4.equals(GraphQLReactionUnitComponentStyle.CORE_IMAGE)) {
            multiRowSinglePartDefinition = (MultiRowSinglePartDefinition) a5;
        }
        ReactionPhotosAdapter reactionPhotosAdapter = new ReactionPhotosAdapter(this, ((HasContext) e).getContext(), a2, this.f19977c, e, reactionUnitComponentNode.m22885f().cE(), a3, multiRowSinglePartDefinition, reactionUnitComponentNode);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(((HasContext) e).getContext());
        linearLayoutManager.b(0);
        return new State(reactionPhotosAdapter, linearLayoutManager, (ReactionHScrollComponentPersistentState) ((HasPersistentState) e).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.m22887k()), reactionUnitComponentNode));
    }

    private static ImmutableList<ReactionImageFields> m23853a(ImmutableList<? extends Edges> immutableList) {
        Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitSubComponentModel a = ((EdgesModel) immutableList.get(i)).a();
            if (!(a.af() == null || TextUtils.isEmpty(a.af().b()))) {
                builder.c(a.af());
            }
        }
        return builder.b();
    }
}
