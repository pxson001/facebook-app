package com.facebook.timeline.profilepiccoverphotoupload;

import android.content.Context;
import android.widget.Toast;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.common.PendingStory.Builder;
import com.facebook.composer.publish.common.PendingStoryPersistentData;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.compost.publish.graphql.CompostGraphQLCreators;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.upload.compost.CompostPendingPost;
import com.facebook.photos.upload.compost.CompostPendingPostStore;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mSource */
public class ProfilePicUploadHandler {
    private final UploadOperationFactory f9215a;
    private final UploadManager f9216b;
    private final MediaItemFactory f9217c;
    private final Lazy<CompostPendingPostStore> f9218d;
    private final Context f9219e;
    private final QeAccessor f9220f;
    private final Clock f9221g;

    public static ProfilePicUploadHandler m11003b(InjectorLike injectorLike) {
        return new ProfilePicUploadHandler((Context) injectorLike.getInstance(Context.class), UploadOperationFactory.b(injectorLike), UploadManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9452), MediaItemFactory.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfilePicUploadHandler(Context context, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager, Lazy<CompostPendingPostStore> lazy, MediaItemFactory mediaItemFactory, QeAccessor qeAccessor, Clock clock) {
        this.f9219e = context;
        this.f9215a = uploadOperationFactory;
        this.f9216b = uploadManager;
        this.f9217c = mediaItemFactory;
        this.f9218d = lazy;
        this.f9220f = qeAccessor;
        this.f9221g = clock;
    }

    public final void m11004a(EditGalleryIpcBundle editGalleryIpcBundle, @Nullable String str, long j, @Nullable String str2, String str3, ViewerContext viewerContext) {
        Preconditions.checkNotNull(editGalleryIpcBundle);
        Preconditions.checkState(!Strings.isNullOrEmpty(editGalleryIpcBundle.c()));
        Toast.makeText(this.f9219e, 2131238432, 0).show();
        if (m11002a()) {
            ((CompostPendingPostStore) this.f9218d.get()).a(new CompostPendingPost(new Builder(new PendingStoryPersistentData(new GraphQLStory.Builder().f(ImmutableList.of(CompostGraphQLCreators.a(editGalleryIpcBundle.a(), this.f9217c))).b(editGalleryIpcBundle.c()).a(this.f9221g.a() / 1000).a(), new PostParamsWrapper(new PublishPostParams.Builder().q(editGalleryIpcBundle.c()).a()))).a(), StoryType.PROFILE_PIC));
        }
        this.f9216b.a(this.f9215a.a(viewerContext, editGalleryIpcBundle.a().getPath(), editGalleryIpcBundle.c(), str3, editGalleryIpcBundle.b(), str, j, editGalleryIpcBundle.g(), editGalleryIpcBundle.d(), str2));
    }

    private boolean m11002a() {
        return this.f9220f.a(ExperimentsForCompostAbTestModule.z, false);
    }
}
