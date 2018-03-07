package com.facebook.video.videohome.data;

import android.text.TextUtils;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.common.ReactionCardNode;
import com.facebook.reaction.common.ReactionItem;
import com.facebook.reaction.common.ReactionUnitComponentUtil;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.reaction.feed.ReactionItemCollection;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionUnitFragmentModel.Builder;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponent;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionPaginatedComponentFragmentModel.PaginatedComponentsModel.ReactionPaginatedComponentsModel.EdgesModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitSubComponentModel;
import com.facebook.video.videohome.abtest.ExperimentsForVideoHomeAbTestModule;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: status_update_action */
public class VideoHomeReactionItemCollection extends ReactionItemCollection {
    private static final String f2823a = VideoHomeReactionItemCollection.class.getSimpleName();
    public final HashMap<String, GraphQLStory> f2824b = new HashMap();
    public final Lazy<ReactionUnitValidator> f2825c;
    public final QeAccessor f2826d;
    public final VideoHomeLoggingUtils f2827e;
    private final VideoHomeItemCollection f2828f;
    public final List<OnCollectionChangeListener> f2829g = new ArrayList();

    /* compiled from: status_update_action */
    public interface OnCollectionChangeListener {
        void mo82a(GraphQLStory graphQLStory);

        void mo83b(GraphQLStory graphQLStory);

        void mo84c(GraphQLStory graphQLStory);
    }

    public static VideoHomeReactionItemCollection m2722c(InjectorLike injectorLike) {
        return new VideoHomeReactionItemCollection(IdBasedLazy.a(injectorLike, 9851), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), VideoHomeLoggingUtils.a(injectorLike), new VideoHomeItemCollection());
    }

    @Inject
    public VideoHomeReactionItemCollection(Lazy<ReactionUnitValidator> lazy, QeAccessor qeAccessor, VideoHomeLoggingUtils videoHomeLoggingUtils, VideoHomeItemCollection videoHomeItemCollection) {
        this.f2825c = lazy;
        this.f2826d = qeAccessor;
        this.f2827e = videoHomeLoggingUtils;
        this.f2828f = videoHomeItemCollection;
    }

    public final void m2727a(ReactionItem reactionItem) {
        a(a(), reactionItem);
    }

    public final void m2725a(int i, ReactionItem reactionItem) {
        ReactionItem b = m2717b(reactionItem);
        List<GraphQLStory> c = m2723c(b.k());
        Collection a = VideoHomeReactionFragmentToNodeConverter.m2710a(b.k());
        if (i >= a()) {
            boolean addAll = this.f2828f.f2821a.addAll(a);
        } else {
            this.f2828f.m2706a(b.k().d(), a);
        }
        super.a(i, b);
        for (GraphQLStory b2 : c) {
            m2721b(b2);
        }
    }

    public final void m2728a(ReactionUnitFragment reactionUnitFragment) {
        ReactionItem c = c(reactionUnitFragment.d());
        ReactionUnitFragment k = c.k();
        if (c instanceof ReactionCardNode) {
            reactionUnitFragment = m2713a(reactionUnitFragment, c.k());
            this.f2828f.m2707a(reactionUnitFragment.d(), VideoHomeReactionFragmentToNodeConverter.m2710a(reactionUnitFragment));
            super.a(reactionUnitFragment);
        }
        for (GraphQLStory c2 : m2723c(k)) {
            m2724c(c2);
        }
        for (GraphQLStory c22 : m2723c(r5)) {
            m2721b(c22);
        }
    }

    public final void m2732c(int i) {
        ReactionUnitFragment k = b(i).k();
        List<String> b = m2720b(k);
        this.f2828f.m2704a(k.d());
        super.c(i);
        for (String str : b) {
            GraphQLStory graphQLStory = (GraphQLStory) this.f2824b.get(str);
            if (graphQLStory != null) {
                m2724c(graphQLStory);
            }
            this.f2824b.remove(str);
        }
    }

    public final void m2731c() {
        this.f2828f.f2821a.clear();
        super.c();
        if (!this.f2829g.isEmpty()) {
            for (GraphQLStory c : this.f2824b.values()) {
                m2724c(c);
            }
        }
        this.f2824b.clear();
    }

    public final void m2729a(OnCollectionChangeListener onCollectionChangeListener) {
        if (!this.f2829g.contains(onCollectionChangeListener)) {
            this.f2829g.add(onCollectionChangeListener);
        }
    }

    public final void m2730b(OnCollectionChangeListener onCollectionChangeListener) {
        this.f2829g.remove(onCollectionChangeListener);
    }

    public final void m2726a(GraphQLStory graphQLStory) {
        if (!Strings.isNullOrEmpty(graphQLStory.g()) && this.f2824b.get(graphQLStory.g()) != null) {
            Object obj = null;
            for (int i = 0; i < a(); i++) {
                ReactionItem b = b(i);
                if (b instanceof ReactionCardNode) {
                    ReactionUnitFragment k = ((ReactionCardNode) b).k();
                    if (m2720b(k).contains(graphQLStory.g())) {
                        k = m2712a(k, graphQLStory);
                        this.f2828f.m2707a(k.d(), VideoHomeReactionFragmentToNodeConverter.m2710a(k));
                        super.a(k);
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                for (OnCollectionChangeListener c : this.f2829g) {
                    c.mo84c(graphQLStory);
                }
            }
        }
    }

    private ReactionUnitFragment m2712a(ReactionUnitFragment reactionUnitFragment, GraphQLStory graphQLStory) {
        Builder a = Builder.a(ReactionUnitFragmentModel.a(reactionUnitFragment));
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < reactionUnitFragment.s().size(); i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitFragment.s().get(i);
            ReactionUnitComponentModel.Builder a2 = ReactionUnitComponentModel.Builder.a(ReactionUnitComponentModel.a(reactionUnitComponentModel));
            ImmutableList.Builder builder2 = new ImmutableList.Builder();
            for (int i2 = 0; i2 < reactionUnitComponentModel.cF().size(); i2++) {
                ReactionUnitSubComponentModel reactionUnitSubComponentModel = (ReactionUnitSubComponentModel) reactionUnitComponentModel.cF().get(i2);
                if (reactionUnitSubComponentModel.ax() == null || !graphQLStory.g().equals(reactionUnitSubComponentModel.ax().g())) {
                    builder2.c(ReactionUnitSubComponentModel.a(reactionUnitSubComponentModel));
                } else {
                    ReactionUnitSubComponentModel.Builder a3 = ReactionUnitSubComponentModel.Builder.a(ReactionUnitSubComponentModel.a(reactionUnitSubComponentModel));
                    a3.ag = graphQLStory;
                    builder2.c(a3.a());
                    this.f2824b.put(graphQLStory.g(), graphQLStory);
                }
            }
            a2.cA = builder2.b();
            a2.bw = m2718b(reactionUnitComponentModel, graphQLStory);
            builder.c(a2.a());
        }
        a.i = builder.b();
        return a.a();
    }

    @Nullable
    private PaginatedComponentsModel m2718b(ReactionUnitComponentModel reactionUnitComponentModel, GraphQLStory graphQLStory) {
        if (reactionUnitComponentModel.dk() == null) {
            return null;
        }
        PaginatedComponentsModel dk = reactionUnitComponentModel.dk();
        PaginatedComponentsModel.Builder a = PaginatedComponentsModel.Builder.a(PaginatedComponentsModel.a(reactionUnitComponentModel.dk()));
        if (dk.c() != null) {
            ReactionPaginatedComponentsModel c = dk.c();
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i = 0; i < c.a().size(); i++) {
                EdgesModel edgesModel = (EdgesModel) c.a().get(i);
                if (edgesModel.a() == null || edgesModel.a().ax() == null || !graphQLStory.g().equals(edgesModel.a().ax().g())) {
                    builder.c(EdgesModel.a(edgesModel));
                } else {
                    ReactionUnitSubComponentModel.Builder a2 = ReactionUnitSubComponentModel.Builder.a(ReactionUnitSubComponentModel.a(edgesModel.a()));
                    a2.ag = graphQLStory;
                    ReactionUnitSubComponentModel a3 = a2.a();
                    edgesModel = EdgesModel.a(edgesModel);
                    EdgesModel.Builder builder2 = new EdgesModel.Builder();
                    builder2.a = edgesModel.j();
                    EdgesModel.Builder builder3 = builder2;
                    builder3.a = a3;
                    builder.c(builder3.a());
                    this.f2824b.put(graphQLStory.g(), graphQLStory);
                }
            }
            ReactionPaginatedComponentsModel.Builder a4 = ReactionPaginatedComponentsModel.Builder.a(ReactionPaginatedComponentsModel.a(c));
            a4.a = builder.b();
            a.b = a4.a();
        }
        return a.a();
    }

    private static List<String> m2720b(ReactionUnitFragment reactionUnitFragment) {
        List<String> linkedList = new LinkedList();
        for (GraphQLStory graphQLStory : m2723c(reactionUnitFragment)) {
            if (!TextUtils.isEmpty(graphQLStory.g())) {
                linkedList.add(graphQLStory.g());
            }
        }
        return linkedList;
    }

    private static List<GraphQLStory> m2723c(ReactionUnitFragment reactionUnitFragment) {
        List<GraphQLStory> linkedList = new LinkedList();
        ImmutableList s = reactionUnitFragment.s();
        int size = s.size();
        for (int i = 0; i < size; i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) s.get(i);
            ImmutableList cF = reactionUnitComponentModel.cF();
            int size2 = cF.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ReactionUnitSubComponentModel reactionUnitSubComponentModel = (ReactionUnitSubComponentModel) cF.get(i2);
                if (reactionUnitSubComponentModel.ax() != null) {
                    linkedList.add(reactionUnitSubComponentModel.ax());
                }
            }
            ImmutableList a = ReactionUnitComponentUtil.a(reactionUnitComponentModel);
            if (a != null) {
                int size3 = a.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitComponentFields) a.get(i3);
                    if (reactionUnitComponentFields.ax() != null) {
                        linkedList.add(reactionUnitComponentFields.ax());
                    }
                }
            }
        }
        return linkedList;
    }

    private ReactionItem m2717b(ReactionItem reactionItem) {
        if (reactionItem instanceof ReactionCardNode) {
            ((ReactionCardNode) reactionItem).a = m2713a(reactionItem.k(), null);
            return reactionItem;
        } else if (reactionItem instanceof VideoHomeComposerItem) {
            return reactionItem;
        } else {
            ReactionUnitFragment a = m2713a(reactionItem.k(), null);
            return new ReactionCardNode(a, ((ReactionUnitValidator) this.f2825c.get()).a(a));
        }
    }

    private ReactionUnitFragment m2713a(ReactionUnitFragment reactionUnitFragment, @Nullable ReactionUnitFragment reactionUnitFragment2) {
        Builder a = Builder.a(ReactionUnitFragmentModel.a(reactionUnitFragment));
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < reactionUnitFragment.s().size(); i++) {
            ReactionUnitComponentModel reactionUnitComponentModel = (ReactionUnitComponentModel) reactionUnitFragment.s().get(i);
            ReactionUnitComponentModel.Builder a2 = ReactionUnitComponentModel.Builder.a(ReactionUnitComponentModel.a(reactionUnitComponentModel));
            a2.cA = m2714a(reactionUnitComponentModel, reactionUnitFragment2);
            a2.bw = m2719b(reactionUnitComponentModel, reactionUnitFragment2);
            builder.c(a2.a());
        }
        a.i = builder.b();
        return a.a();
    }

    private ImmutableList<ReactionUnitSubComponentModel> m2714a(ReactionUnitComponent reactionUnitComponent, @Nullable ReactionUnitFragment reactionUnitFragment) {
        List b;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (reactionUnitFragment != null) {
            b = m2720b(reactionUnitFragment);
        } else {
            b = null;
        }
        for (int i = 0; i < reactionUnitComponent.cF().size(); i++) {
            ReactionUnitComponentFields reactionUnitComponentFields = (ReactionUnitSubComponentModel) reactionUnitComponent.cF().get(i);
            if (reactionUnitComponentFields.ax() == null) {
                builder.c(ReactionUnitSubComponentModel.a(reactionUnitComponentFields));
            } else if (m2715a(reactionUnitComponentFields.ax(), b) || m2716a(reactionUnitComponentFields)) {
                builder.c(ReactionUnitSubComponentModel.a(reactionUnitComponentFields));
            }
        }
        return builder.b();
    }

    @Nullable
    private PaginatedComponentsModel m2719b(ReactionUnitComponentModel reactionUnitComponentModel, @Nullable ReactionUnitFragment reactionUnitFragment) {
        if (reactionUnitComponentModel.dk() == null) {
            return null;
        }
        PaginatedComponentsModel dk = reactionUnitComponentModel.dk();
        PaginatedComponentsModel.Builder a = PaginatedComponentsModel.Builder.a(PaginatedComponentsModel.a(reactionUnitComponentModel.dk()));
        List b = reactionUnitFragment != null ? m2720b(reactionUnitFragment) : null;
        if (dk.c() != null) {
            ReactionPaginatedComponentsModel c = dk.c();
            ImmutableList.Builder builder = new ImmutableList.Builder();
            for (int i = 0; i < c.a().size(); i++) {
                EdgesModel edgesModel = (EdgesModel) c.a().get(i);
                if (edgesModel.a() != null) {
                    ReactionUnitComponentFields a2 = edgesModel.a();
                    GraphQLStory ax = a2.ax();
                    if (ax == null) {
                        builder.c(EdgesModel.a(edgesModel));
                    } else if (m2715a(ax, b) || m2716a(a2)) {
                        builder.c(EdgesModel.a(edgesModel));
                    }
                }
            }
            ReactionPaginatedComponentsModel.Builder a3 = ReactionPaginatedComponentsModel.Builder.a(ReactionPaginatedComponentsModel.a(c));
            a3.a = builder.b();
            a.b = a3.a();
        }
        return a.a();
    }

    private boolean m2716a(ReactionUnitComponentFields reactionUnitComponentFields) {
        GraphQLStory ax = reactionUnitComponentFields.ax();
        if (TextUtils.isEmpty(ax.g()) || this.f2824b.containsKey(ax.g())) {
            reactionUnitComponentFields.ax().g();
            GraphQLStory ax2 = reactionUnitComponentFields.ax();
            GraphQLStoryAttachment o = StoryAttachmentHelper.o(ax2);
            if (!(o == null || o.r() == null)) {
                GraphQLVideo b = GraphQLMediaConversionHelper.b(o.r());
                if (b != null) {
                    this.f2827e.a(b.J(), ax2.c(), reactionUnitComponentFields.U());
                }
            }
            if (this.f2826d.a(ExperimentsForVideoHomeAbTestModule.f, true)) {
                return false;
            }
        }
        this.f2824b.put(ax.g(), ax);
        return true;
    }

    private static boolean m2715a(GraphQLStory graphQLStory, @Nullable List<String> list) {
        if (TextUtils.isEmpty(graphQLStory.g()) || list == null) {
            return false;
        }
        return list.contains(graphQLStory.g());
    }

    private void m2721b(GraphQLStory graphQLStory) {
        for (OnCollectionChangeListener a : this.f2829g) {
            a.mo82a(graphQLStory);
        }
    }

    private void m2724c(GraphQLStory graphQLStory) {
        for (OnCollectionChangeListener b : this.f2829g) {
            b.mo83b(graphQLStory);
        }
    }
}
