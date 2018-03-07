package com.facebook.composer.feedattachment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass33;
import com.facebook.composer.activity.ComposerMutatorImpl;
import com.facebook.composer.gating.ComposerGatekeepers;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.friendsharing.gif.util.GifUtil;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachment.Builder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesRemovedUrls;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicSetters.SetsRemovedURLs;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.SetsShareParams;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gravity_query_data */
public class GifComposerAttachmentController<DataProvider extends ProvidesRemovedUrls & ProvidesShareParams, Transaction extends ComposerTransaction & SetsRemovedURLs<Transaction> & SetsShareParams<Transaction>> implements ComposerFeedAttachmentController {
    public static final ImmutableList<GraphQLStoryAttachmentStyle> f6457a = ImmutableList.of(GraphQLStoryAttachmentStyle.FALLBACK);
    private static final CallerContext f6458b = CallerContext.a(GifComposerAttachmentController.class);
    private final WeakReference<Callback> f6459c;
    private final WeakReference<DataProvider> f6460d;
    private final WeakReference<ComposerMutator<Transaction>> f6461e;
    private final FbDraweeControllerBuilder f6462f;
    private final GatekeeperStoreImpl f6463g;
    private final Resources f6464h;

    public final Optional<GraphQLStoryAttachment> mo193a(Throwable th) {
        return Absent.INSTANCE;
    }

    @Inject
    public GifComposerAttachmentController(Resources resources, FbDraweeControllerBuilder fbDraweeControllerBuilder, GatekeeperStore gatekeeperStore, @Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator, @Assisted Callback callback) {
        this.f6464h = resources;
        this.f6462f = fbDraweeControllerBuilder;
        this.f6463g = gatekeeperStore;
        this.f6460d = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6461e = new WeakReference(Preconditions.checkNotNull(composerMutator));
        this.f6459c = new WeakReference(Preconditions.checkNotNull(callback));
    }

    public final List<GraphQLStoryAttachmentStyle> mo194c() {
        return f6457a;
    }

    public final View mo192a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        final FbDraweeView fbDraweeView = (FbDraweeView) LayoutInflater.from(viewGroup.getContext()).inflate(2130903676, viewGroup, false);
        FbPipelineDraweeController s = ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f6462f.a(f6458b).b(Uri.parse(((ProvidesShareParams) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6460d.get()))).q().linkForShare)).b(fbDraweeView.getController())).a(new BaseControllerListener(this) {
            final /* synthetic */ GifComposerAttachmentController f6456b;

            public final void m7879a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
                CloseableImage closeableImage = (CloseableImage) obj;
                if (closeableImage != null) {
                    if (animatable != null) {
                        animatable.start();
                    }
                    if (closeableImage.g() != 0) {
                        fbDraweeView.setAspectRatio(((float) closeableImage.f()) / (((float) closeableImage.g()) * 1.0f));
                    }
                }
            }
        })).s();
        AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(this.f6464h.getDrawable(2130843434), 1000);
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(this.f6464h);
        genericDraweeHierarchyBuilder.f = autoRotateDrawable;
        GenericDraweeHierarchy u = genericDraweeHierarchyBuilder.u();
        fbDraweeView.setController(s);
        fbDraweeView.setHierarchy(u);
        return fbDraweeView;
    }

    public final ListenableFuture<GraphQLStoryAttachment> mo195d() {
        GraphQLStoryAttachment graphQLStoryAttachment;
        if (((ProvidesShareParams) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6460d.get()))).q().linkForShare == null) {
            graphQLStoryAttachment = (GraphQLStoryAttachment) mo193a(new IllegalArgumentException("gifUrl is null")).get();
        } else {
            Builder builder = new Builder();
            builder.q = f6457a;
            graphQLStoryAttachment = builder.a();
        }
        return Futures.a(graphQLStoryAttachment);
    }

    public final boolean mo196e() {
        if (!this.f6463g.a(ComposerGatekeepers.b, false)) {
            return false;
        }
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6460d.get());
        if (((ProvidesShareParams) composerDataProviderImpl).q() == null || StringUtil.a(((ProvidesShareParams) composerDataProviderImpl).q().linkForShare)) {
            return false;
        }
        return GifUtil.a(((ProvidesShareParams) composerDataProviderImpl).q());
    }

    public final boolean mo197f() {
        return false;
    }

    public final View mo191a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(2130905288, viewGroup, false);
    }

    public final String mo198g() {
        return String.valueOf(((ProvidesShareParams) ((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6460d.get()))).q());
    }

    public final void mo199h() {
        RemoveShareAttachmentHelper.m7923a((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f6460d.get()), (ComposerMutatorImpl) Preconditions.checkNotNull(this.f6461e.get()));
        ((AnonymousClass33) Preconditions.checkNotNull(this.f6459c.get())).m7464a();
    }

    public final void mo200i() {
    }

    public final View mo201j() {
        return null;
    }

    public final boolean mo202k() {
        return false;
    }
}
