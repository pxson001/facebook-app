package com.facebook.timeline.profilepiccoverphotoupload;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.common.PendingStoryPersistentData;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.compost.publish.graphql.CompostGraphQLCreators;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.media.MediaItemFactory.PhotoItemBuilder;
import com.facebook.photos.base.media.PhotoItem;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.editgallery.utils.CropImageUtils.CropCallback;
import com.facebook.photos.editgallery.utils.CropImageUtilsProvider;
import com.facebook.photos.upload.compost.CompostPendingPost;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.profilemedia.ProfileMediaChangeBroadcaster;
import com.facebook.timeline.profilemedia.ProfileMediaOptimisticPostingController;
import com.facebook.timeline.profilemedia.upload.ProfileMediaUploadReceiver;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: mShareParams */
public class SetCoverPhotoHandler {
    public static final CallerContext f9230a = CallerContext.a(SetCoverPhotoHandler.class);
    private final UploadOperationFactory f9231b;
    private final UploadManager f9232c;
    public final Context f9233d;
    public final Provider<SingleMethodRunner> f9234e;
    public final SetCoverPhotoMethod f9235f;
    public final Lazy<ProfileMediaOptimisticPostingController> f9236g;
    public final Lazy<ProfileMediaChangeBroadcaster> f9237h;
    private final Lazy<ProfileMediaUploadReceiver> f9238i;
    public final CropImageUtilsProvider f9239j;
    public final ListeningExecutorService f9240k;
    public final ListeningExecutorService f9241l;
    private final Clock f9242m;
    private final Lazy<CompostPendingPostStore> f9243n;
    private final QeAccessor f9244o;

    /* compiled from: mShareParams */
    public class C09561 implements CropCallback {
        final /* synthetic */ SetCoverPhotoParams f9222a;
        final /* synthetic */ String f9223b;
        final /* synthetic */ ViewerContext f9224c;
        final /* synthetic */ SetCoverPhotoHandler f9225d;

        public C09561(SetCoverPhotoHandler setCoverPhotoHandler, SetCoverPhotoParams setCoverPhotoParams, String str, ViewerContext viewerContext) {
            this.f9225d = setCoverPhotoHandler;
            this.f9222a = setCoverPhotoParams;
            this.f9223b = str;
            this.f9224c = viewerContext;
        }

        public final void m11005a(CreativeEditingData creativeEditingData) {
            SetCoverPhotoHandler.m11007a(this.f9225d, this.f9222a, creativeEditingData.o(), this.f9223b, this.f9224c);
        }

        public final void m11006a(Throwable th, CreativeEditingData creativeEditingData) {
            BLog.b(SetCoverPhotoHandler.class, "Failed to crop cover photo for optimistic preview: %s", th);
            SetCoverPhotoHandler.m11007a(this.f9225d, this.f9222a, null, this.f9223b, this.f9224c);
        }
    }

    public static SetCoverPhotoHandler m11008b(InjectorLike injectorLike) {
        return new SetCoverPhotoHandler((Context) injectorLike.getInstance(Context.class), UploadOperationFactory.b(injectorLike), UploadManager.a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 2289), SetCoverPhotoMethod.m11011a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9452), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 11300), IdBasedLazy.a(injectorLike, 11299), IdBasedLazy.a(injectorLike, 11303), (CropImageUtilsProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(CropImageUtilsProvider.class), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SetCoverPhotoHandler(Context context, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager, Provider<SingleMethodRunner> provider, SetCoverPhotoMethod setCoverPhotoMethod, Clock clock, Lazy<CompostPendingPostStore> lazy, QeAccessor qeAccessor, Lazy<ProfileMediaOptimisticPostingController> lazy2, Lazy<ProfileMediaChangeBroadcaster> lazy3, Lazy<ProfileMediaUploadReceiver> lazy4, CropImageUtilsProvider cropImageUtilsProvider, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2) {
        this.f9233d = context;
        this.f9231b = uploadOperationFactory;
        this.f9232c = uploadManager;
        this.f9234e = provider;
        this.f9235f = setCoverPhotoMethod;
        this.f9242m = clock;
        this.f9243n = lazy;
        this.f9244o = qeAccessor;
        this.f9236g = lazy2;
        this.f9237h = lazy3;
        this.f9238i = lazy4;
        this.f9239j = cropImageUtilsProvider;
        this.f9241l = listeningExecutorService;
        this.f9240k = listeningExecutorService2;
    }

    public static void m11007a(SetCoverPhotoHandler setCoverPhotoHandler, @Nullable final SetCoverPhotoParams setCoverPhotoParams, Uri uri, final String str, ViewerContext viewerContext) {
        if (setCoverPhotoParams.m11016h()) {
            ((ProfileMediaOptimisticPostingController) setCoverPhotoHandler.f9236g.get()).m10953b(uri, str);
            Futures.a(setCoverPhotoHandler.f9240k.a(new Callable<Void>(setCoverPhotoHandler) {
                final /* synthetic */ SetCoverPhotoHandler f9227b;

                public Object call() {
                    ((AbstractSingleMethodRunner) this.f9227b.f9234e.get()).a(this.f9227b.f9235f, setCoverPhotoParams, SetCoverPhotoHandler.f9230a);
                    return null;
                }
            }), new FutureCallback<Void>(setCoverPhotoHandler) {
                final /* synthetic */ SetCoverPhotoHandler f9229b;

                public void onSuccess(@Nullable Object obj) {
                    ((ProfileMediaOptimisticPostingController) this.f9229b.f9236g.get()).m10954b(str);
                    ((ProfileMediaChangeBroadcaster) this.f9229b.f9237h.get()).m10947d();
                }

                public void onFailure(Throwable th) {
                    ((ProfileMediaOptimisticPostingController) this.f9229b.f9236g.get()).m10954b(str);
                    Toast.makeText(this.f9229b.f9233d, 2131234968, 0).show();
                }
            }, setCoverPhotoHandler.f9241l);
            return;
        }
        setCoverPhotoHandler.m11009b(setCoverPhotoParams, uri, str, viewerContext);
    }

    private void m11009b(SetCoverPhotoParams setCoverPhotoParams, @Nullable Uri uri, String str, ViewerContext viewerContext) {
        Toast.makeText(this.f9233d, 2131238432, 0).show();
        PhotoItem a = new PhotoItemBuilder().b(setCoverPhotoParams.f9248d).d("image/jpeg").a();
        if (m11010b()) {
            Builder builder = new Builder();
            builder.m = ImmutableList.of(CompostGraphQLCreators.a(ComposerAttachment.a(ImmutableList.of(a))));
            builder = builder;
            builder.v = str;
            builder = builder;
            builder.x = this.f9242m.a() / 1000;
            GraphQLStory a2 = builder.a();
            PublishPostParams.Builder builder2 = new PublishPostParams.Builder();
            builder2.G = str;
            ((CompostPendingPostStore) this.f9243n.get()).a(new CompostPendingPost(new PendingStory.Builder(new PendingStoryPersistentData(a2, new PostParamsWrapper(builder2.a()))).a(), StoryType.COVER_PHOTO));
        }
        UploadOperation a3 = this.f9231b.a(viewerContext, a, setCoverPhotoParams.m11014d(), setCoverPhotoParams.m11015e(), str);
        ((ProfileMediaUploadReceiver) this.f9238i.get()).m10993b(uri, str);
        this.f9232c.a(a3);
    }

    private boolean m11010b() {
        return this.f9244o.a(ExperimentsForCompostAbTestModule.z, false);
    }
}
