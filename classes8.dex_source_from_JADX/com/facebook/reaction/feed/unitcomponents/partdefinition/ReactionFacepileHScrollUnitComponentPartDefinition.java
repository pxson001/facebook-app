package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentKey;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollComponentPersistentState;
import com.facebook.reaction.feed.persistentstate.ReactionHScrollStateUtil;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentFieldsModel.ProfilesModel;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: aldrin_status_last_fetch_fail_time */
public class ReactionFacepileHScrollUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, E, RecyclerView> {
    public static final ViewType f19680a = ViewType.a(2130906609);
    public static final CallerContext f19681b = CallerContext.a(ReactionFacepileHScrollUnitComponentPartDefinition.class, "today");
    private static ReactionFacepileHScrollUnitComponentPartDefinition f19682e;
    private static final Object f19683f = new Object();
    private final Provider<HScrollLinearLayoutManager> f19684c;
    public final ReactionIntentFactory f19685d;

    /* compiled from: aldrin_status_last_fetch_fail_time */
    class ReactionFacepileHscrollRecyclerAdapter extends Adapter<ReactionFacepileViewHolder> {
        private final Context f19673a;
        private final List<OnClickListener> f19674b;
        private final List<Uri> f19675c;

        public final void m23592a(ViewHolder viewHolder, int i) {
            ReactionFacepileViewHolder reactionFacepileViewHolder = (ReactionFacepileViewHolder) viewHolder;
            OnClickListener onClickListener = (OnClickListener) this.f19674b.get(i);
            reactionFacepileViewHolder.f19676l.a((Uri) this.f19675c.get(i), ReactionFacepileHScrollUnitComponentPartDefinition.f19681b);
            reactionFacepileViewHolder.f19676l.setOnClickListener(onClickListener);
        }

        public ReactionFacepileHscrollRecyclerAdapter(Context context, List<OnClickListener> list, List<Uri> list2) {
            this.f19673a = context;
            this.f19674b = list;
            this.f19675c = list2;
        }

        public final int aZ_() {
            return this.f19675c.size();
        }

        public final ViewHolder m23591a(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906665, viewGroup, false);
            inflate.getLayoutParams().height = m23590d();
            inflate.getLayoutParams().width = m23590d();
            FbDraweeView fbDraweeView = (FbDraweeView) inflate.findViewById(2131566713);
            fbDraweeView.setAspectRatio(1.0f);
            return new ReactionFacepileViewHolder(fbDraweeView);
        }

        private int m23590d() {
            return (int) this.f19673a.getResources().getDimension(2131431428);
        }
    }

    /* compiled from: aldrin_status_last_fetch_fail_time */
    public class ReactionFacepileViewHolder extends ViewHolder {
        public FbDraweeView f19676l;

        public ReactionFacepileViewHolder(FbDraweeView fbDraweeView) {
            super(fbDraweeView);
            this.f19676l = fbDraweeView;
        }
    }

    /* compiled from: aldrin_status_last_fetch_fail_time */
    public class State {
        public final ReactionFacepileHscrollRecyclerAdapter f19677a;
        public final LinearLayoutManager f19678b;
        public final ReactionHScrollComponentPersistentState f19679c;

        public State(ReactionFacepileHscrollRecyclerAdapter reactionFacepileHscrollRecyclerAdapter, LinearLayoutManager linearLayoutManager, ReactionHScrollComponentPersistentState reactionHScrollComponentPersistentState) {
            this.f19677a = reactionFacepileHscrollRecyclerAdapter;
            this.f19678b = linearLayoutManager;
            this.f19679c = reactionHScrollComponentPersistentState;
        }
    }

    private static ReactionFacepileHScrollUnitComponentPartDefinition m23595b(InjectorLike injectorLike) {
        return new ReactionFacepileHScrollUnitComponentPartDefinition(IdBasedProvider.a(injectorLike, 3727), ReactionIntentFactory.m22683a(injectorLike));
    }

    public final Object m23597a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        final CanLaunchReactionIntent canLaunchReactionIntent = (CanLaunchReactionIntent) anyEnvironment;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        ImmutableList ca = reactionUnitComponentNode.f18862b.ca();
        int size = ca.size();
        for (int i = 0; i < size; i++) {
            ProfilesModel profilesModel = (ProfilesModel) ca.get(i);
            if (!(profilesModel.gl_() == null || Strings.isNullOrEmpty(profilesModel.gl_().b()) || Strings.isNullOrEmpty(profilesModel.c()))) {
                final String c = profilesModel.c();
                arrayList.add(new OnClickListener(this) {
                    final /* synthetic */ ReactionFacepileHScrollUnitComponentPartDefinition f19672d;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1701305655);
                        canLaunchReactionIntent.mo695a(reactionUnitComponentNode.f18863c, reactionUnitComponentNode.f18864d, this.f19672d.f19685d.m22761b(c, UnitInteractionType.PROFILE_TAP));
                        Logger.a(2, EntryType.UI_INPUT_END, -2043087560, a);
                    }
                });
                arrayList2.add(Uri.parse(profilesModel.gl_().b()));
            }
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.f19684c.get();
        linearLayoutManager.b(0);
        return new State(new ReactionFacepileHscrollRecyclerAdapter(((HasContext) canLaunchReactionIntent).getContext(), arrayList, arrayList2), linearLayoutManager, (ReactionHScrollComponentPersistentState) ((HasPersistentState) canLaunchReactionIntent).a(new ReactionHScrollComponentKey(reactionUnitComponentNode.f18863c), reactionUnitComponentNode));
    }

    public final /* bridge */ /* synthetic */ void m23598a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -19935917);
        m23594a((State) obj2, (CanLaunchReactionIntent) anyEnvironment, (RecyclerView) view);
        Logger.a(8, EntryType.MARK_POP, -2019376203, a);
    }

    public final boolean m23599a(Object obj) {
        ImmutableList ca = ((ReactionUnitComponentNode) obj).f18862b.ca();
        if (ca.isEmpty()) {
            return false;
        }
        int size = ca.size();
        for (int i = 0; i < size; i++) {
            ProfilesModel profilesModel = (ProfilesModel) ca.get(i);
            if (profilesModel.gl_() != null && !Strings.isNullOrEmpty(profilesModel.gl_().b()) && !Strings.isNullOrEmpty(profilesModel.c())) {
                return true;
            }
        }
        return false;
    }

    public final void m23600b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        RecyclerView recyclerView = (RecyclerView) view;
        ReactionHScrollStateUtil.m23193a(state.f19678b, state.f19679c, recyclerView);
        recyclerView.setAdapter(null);
    }

    public static ReactionFacepileHScrollUnitComponentPartDefinition m23593a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionFacepileHScrollUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19683f) {
                ReactionFacepileHScrollUnitComponentPartDefinition reactionFacepileHScrollUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionFacepileHScrollUnitComponentPartDefinition = (ReactionFacepileHScrollUnitComponentPartDefinition) a2.a(f19683f);
                } else {
                    reactionFacepileHScrollUnitComponentPartDefinition = f19682e;
                }
                if (reactionFacepileHScrollUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23595b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19683f, b3);
                        } else {
                            f19682e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionFacepileHScrollUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ReactionFacepileHScrollUnitComponentPartDefinition(Provider<HScrollLinearLayoutManager> provider, ReactionIntentFactory reactionIntentFactory) {
        this.f19684c = provider;
        this.f19685d = reactionIntentFactory;
    }

    public final ViewType<RecyclerView> m23596a() {
        return f19680a;
    }

    private static void m23594a(State state, E e, RecyclerView recyclerView) {
        CustomViewUtils.b(recyclerView, new ColorDrawable(((HasContext) e).getContext().getResources().getColor(2131361864)));
        recyclerView.setLayoutManager(state.f19678b);
        recyclerView.setAdapter(state.f19677a);
        ReactionHScrollStateUtil.m23192a(state.f19678b, state.f19679c);
    }
}
