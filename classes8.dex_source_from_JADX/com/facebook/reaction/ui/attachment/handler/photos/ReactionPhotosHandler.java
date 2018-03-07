package com.facebook.reaction.ui.attachment.handler.photos;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.view.DraweeView;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosDefaultsGraphQLInterfaces.SizeAwareMedia;
import com.facebook.reaction.ReactionMediaGalleryUtil;
import com.facebook.reaction.action.ReactionIntentFactory;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionStoryAttachmentFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryAttachmentFragmentModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel.EdgesModel;
import com.facebook.widget.hscrollrecyclerview.HScrollLinearLayoutManager;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: VIEW_PYML_TAP */
public abstract class ReactionPhotosHandler<T, P extends SizeAwareMedia> extends AbstractReactionHscrollPhotosHandler {
    public static final CallerContext f20966c = CallerContext.a(ReactionPhotosHandler.class, "reaction_dialog_photos");
    private GraphQLReactionStoryAttachmentsStyle f20967d;
    public boolean f20968e;
    public int f20969f;
    public int f20970g;
    public String f20971h;
    private long[] f20972i;
    public ReactionPhotosRecyclerAdapter f20973j;
    private ReactionPhotosScrollListener f20974k;
    public String f20975l;
    public String f20976m;
    private AbstractDisposableFutureCallback<GraphQLResult<T>> f20977n;
    private final ReactionExperimentController f20978o;
    private final ReactionIntentFactory f20979p;
    private final ReactionMediaGalleryUtil f20980q;

    /* compiled from: VIEW_PYML_TAP */
    class C22242 extends AbstractDisposableFutureCallback<GraphQLResult<T>> {
        final /* synthetic */ ReactionPhotosHandler f20993a;

        C22242(ReactionPhotosHandler reactionPhotosHandler) {
            this.f20993a = reactionPhotosHandler;
        }

        protected final void m24644a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f20993a.f20968e = false;
            List a = this.f20993a.mo1141a(graphQLResult);
            if (a == null) {
                this.f20993a.f20971h = null;
                return;
            }
            this.f20993a.f20973j.m24641a(a);
            this.f20993a.m22850a(this.f20993a.f20975l, this.f20993a.f20976m, a.size(), this.f20993a.f20973j.aZ_());
        }

        protected final void m24645a(Throwable th) {
            this.f20993a.f20971h = null;
        }
    }

    /* compiled from: VIEW_PYML_TAP */
    class ReactionPhotosScrollListener extends OnScrollListener {
        final /* synthetic */ ReactionPhotosHandler f20994a;

        public ReactionPhotosScrollListener(ReactionPhotosHandler reactionPhotosHandler) {
            this.f20994a = reactionPhotosHandler;
        }

        public final void m24646a(RecyclerView recyclerView, int i, int i2) {
            int n = this.f20994a.f20850a.n();
            if (n > this.f20994a.f20973j.aZ_() - 3) {
                ReactionPhotosHandler reactionPhotosHandler = this.f20994a;
                if (!(reactionPhotosHandler.f20968e || reactionPhotosHandler.f20971h == null)) {
                    reactionPhotosHandler.f20968e = true;
                    reactionPhotosHandler.mo1142a(reactionPhotosHandler.f20971h, reactionPhotosHandler.f20975l, 5, ReactionPhotosHandler.f20966c);
                }
            }
            if (i > 0) {
                this.f20994a.m22849a(this.f20994a.f20975l, this.f20994a.f20976m);
            }
            this.f20994a.m22847a(this.f20994a.f20975l, n + 1);
            this.f20994a.f20970g = this.f20994a.f20850a.l();
            View c = this.f20994a.f20850a.c(this.f20994a.f20970g);
            this.f20994a.f20969f = c.getLeft() - this.f20994a.f20852c.getPaddingLeft();
        }
    }

    @Nullable
    abstract List<P> mo1141a(@Nullable GraphQLResult<T> graphQLResult);

    public abstract void mo1142a(String str, String str2, int i, CallerContext callerContext);

    abstract boolean mo1143a(@Nullable P p);

    abstract P mo1144c(ReactionStoryAttachmentFragment reactionStoryAttachmentFragment);

    abstract ReactionPhotosRecyclerAdapter mo1145c(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel);

    public ReactionPhotosHandler(ReactionExperimentController reactionExperimentController, Provider<HScrollLinearLayoutManager> provider, ReactionIntentFactory reactionIntentFactory, ReactionIntentLauncher reactionIntentLauncher, ReactionMediaGalleryUtil reactionMediaGalleryUtil, GraphQLReactionStoryAttachmentsStyle graphQLReactionStoryAttachmentsStyle) {
        super(provider, reactionIntentLauncher);
        this.f20978o = reactionExperimentController;
        this.f20979p = reactionIntentFactory;
        this.f20980q = reactionMediaGalleryUtil;
        this.f20967d = graphQLReactionStoryAttachmentsStyle;
    }

    protected final int mo1128b(String str, String str2, ReactionAttachmentsModel reactionAttachmentsModel) {
        if (this.f20973j == null) {
            this.f20973j = mo1145c(str, str2, reactionAttachmentsModel);
            this.f20975l = str;
            this.f20976m = str2;
            this.f20971h = reactionAttachmentsModel.c().a();
            this.f20974k = new ReactionPhotosScrollListener(this);
            m24619b(reactionAttachmentsModel);
        }
        this.f20968e = false;
        RecyclerView recyclerView = this.f20852c;
        recyclerView.setAdapter(this.f20973j);
        recyclerView.setOnScrollListener(this.f20974k);
        this.f20850a.d(this.f20970g, this.f20969f);
        return this.f20973j.aZ_();
    }

    public final boolean mo1140a(ReactionAttachmentsModel reactionAttachmentsModel) {
        return super.mo1140a(reactionAttachmentsModel) && reactionAttachmentsModel.c() != null;
    }

    protected final boolean mo1119b(ReactionStoryAttachmentFragmentModel reactionStoryAttachmentFragmentModel) {
        return mo1143a(mo1144c(reactionStoryAttachmentFragmentModel));
    }

    protected final void mo1138a(String str, ReactionAttachmentIntent reactionAttachmentIntent, View view) {
        if (reactionAttachmentIntent.f18831d != null) {
            DraweeView draweeView = view instanceof FbDraweeView ? (FbDraweeView) view : (FbDraweeView) view.findViewById(2131566610);
            ImageRequest a = ImageRequest.a(reactionAttachmentIntent.f18831d.getStringExtra("photo_url"));
            ReactionPhotosRecyclerAdapter reactionPhotosRecyclerAdapter = this.f20973j;
            this.f20980q.m22515a(this.f20975l, reactionPhotosRecyclerAdapter.f20984a.subList(Math.max(this.f20850a.l() - 2, 0), Math.min((this.f20850a.n() + 2) + 1, reactionPhotosRecyclerAdapter.f20984a.size())), reactionAttachmentIntent.f18829b, draweeView, a, this.f18821d);
        }
    }

    protected final OnClickListener m24620a(final String str, final String str2, final SizeAwareMedia sizeAwareMedia) {
        return new OnClickListener(this) {
            final /* synthetic */ ReactionPhotosHandler f20992d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -792003256);
                ReactionAttachmentIntent b = ReactionPhotosHandler.m24618b(this.f20992d, sizeAwareMedia);
                if (b != null) {
                    this.f20992d.m22851a(str, str2, b);
                    this.f20992d.mo1138a(str, b, view);
                }
                Logger.a(2, EntryType.UI_INPUT_END, 1429073101, a);
            }
        };
    }

    protected final AbstractDisposableFutureCallback<GraphQLResult<T>> m24630g() {
        if (this.f20977n == null) {
            this.f20977n = new C22242(this);
        }
        return this.f20977n;
    }

    protected final int m24631i() {
        return this.f20967d == GraphQLReactionStoryAttachmentsStyle.PHOTOS_LARGE ? (int) this.f18821d.getResources().getDimension(2131431424) : (int) this.f18821d.getResources().getDimension(2131431423);
    }

    public static ReactionAttachmentIntent m24618b(ReactionPhotosHandler reactionPhotosHandler, SizeAwareMedia sizeAwareMedia) {
        try {
            return ReactionIntentFactory.m22684a(reactionPhotosHandler.m22859d(), Long.parseLong(sizeAwareMedia.d()), reactionPhotosHandler.f20972i, sizeAwareMedia.bc_().b());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private void m24619b(ReactionAttachmentsModel reactionAttachmentsModel) {
        ImmutableList b = reactionAttachmentsModel.b();
        long[] jArr = new long[b.size()];
        int size = b.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            ReactionStoryAttachmentFragmentModel a = ((EdgesModel) b.get(i)).a();
            if (!(a == null || a.E() == null || Strings.isNullOrEmpty(a.E().d()))) {
                try {
                    jArr[i2] = Long.parseLong(a.E().d());
                    i3 = i2 + 1;
                } catch (NumberFormatException e) {
                }
                i++;
                i2 = i3;
            }
            i3 = i2;
            i++;
            i2 = i3;
        }
        if (i2 == b.size()) {
            this.f20972i = jArr;
        } else {
            this.f20972i = Arrays.copyOf(jArr, i2);
        }
    }
}
