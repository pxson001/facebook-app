package com.facebook.heisman;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.executors.ForegroundExecutorService;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.editgallery.CropMode;
import com.facebook.ipc.editgallery.EditFeature;
import com.facebook.ipc.editgallery.EditGalleryIntentCreator;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle.Builder;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryZoomCropParams;
import com.facebook.ipc.editgallery.EntryPoint;
import com.facebook.photos.creativeediting.utilities.CreativeEditingImageHelper;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.intent.TimelineIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundIntentFactory;
import com.facebook.timeline.stagingground.StagingGroundLaunchConfig;
import com.facebook.timeline.tempprofilepic.model.ExpirationState;
import com.google.common.base.Function;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: user_wait_time_seconds */
public class ProfilePictureOverlayIntentFactory {
    private static volatile ProfilePictureOverlayIntentFactory f734h;
    public final Context f735a;
    public final CreativeEditingImageHelper f736b;
    @ForegroundExecutorService
    private final ListeningExecutorService f737c;
    private final QeAccessor f738d;
    public final TimelineIntentFactory f739e;
    private final AllCapsTransformationMethod f740f;
    private final ProfilePictureOverlayExpirationTimeConfig f741g;

    public static com.facebook.heisman.ProfilePictureOverlayIntentFactory m784a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f734h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.heisman.ProfilePictureOverlayIntentFactory.class;
        monitor-enter(r1);
        r0 = f734h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m785b(r0);	 Catch:{ all -> 0x0035 }
        f734h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f734h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.heisman.ProfilePictureOverlayIntentFactory.a(com.facebook.inject.InjectorLike):com.facebook.heisman.ProfilePictureOverlayIntentFactory");
    }

    private static ProfilePictureOverlayIntentFactory m785b(InjectorLike injectorLike) {
        return new ProfilePictureOverlayIntentFactory((Context) injectorLike.getInstance(Context.class), CreativeEditingImageHelper.b(injectorLike), ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TimelineIntentFactory.b(injectorLike), AllCapsTransformationMethod.b(injectorLike), ProfilePictureOverlayExpirationTimeConfig.m780a(injectorLike));
    }

    @Inject
    public ProfilePictureOverlayIntentFactory(Context context, CreativeEditingImageHelper creativeEditingImageHelper, ListeningExecutorService listeningExecutorService, QeAccessor qeAccessor, TimelineIntentFactory timelineIntentFactory, AllCapsTransformationMethod allCapsTransformationMethod, ProfilePictureOverlayExpirationTimeConfig profilePictureOverlayExpirationTimeConfig) {
        this.f735a = context;
        this.f736b = creativeEditingImageHelper;
        this.f737c = listeningExecutorService;
        this.f738d = qeAccessor;
        this.f739e = timelineIntentFactory;
        this.f740f = allCapsTransformationMethod;
        this.f741g = profilePictureOverlayExpirationTimeConfig;
    }

    public final ListenableFuture<Intent> m788a(final EditGalleryIpcBundle editGalleryIpcBundle, @Nullable String str, long j, @Nullable String str2, String str3) {
        final EditGalleryIpcBundle editGalleryIpcBundle2 = editGalleryIpcBundle;
        final String str4 = str;
        final long j2 = j;
        final String str5 = str2;
        final String str6 = str3;
        return Futures.b(this.f737c.a(new Callable<ListenableFuture<Uri>>(this) {
            final /* synthetic */ ProfilePictureOverlayIntentFactory f726b;

            public Object call() {
                return this.f726b.f736b.a(1.0f, editGalleryIpcBundle.e, editGalleryIpcBundle.b, false);
            }
        }), new AsyncFunction<ListenableFuture<Uri>, Intent>(this) {
            final /* synthetic */ ProfilePictureOverlayIntentFactory f733f;

            /* compiled from: user_wait_time_seconds */
            class C00911 implements Function<Uri, Intent> {
                final /* synthetic */ C00922 f727a;

                C00911(C00922 c00922) {
                    this.f727a = c00922;
                }

                public Object apply(Object obj) {
                    Uri uri = (Uri) obj;
                    TimelineIntentFactory timelineIntentFactory = this.f727a.f733f.f739e;
                    Builder a = Builder.a(editGalleryIpcBundle2);
                    a.a = uri;
                    return timelineIntentFactory.a(a.a(), str4, j2, str5, str6);
                }
            }

            public final ListenableFuture m783a(Object obj) {
                return Futures.a((ListenableFuture) obj, new C00911(this), MoreExecutors.a());
            }
        }, MoreExecutors.a());
    }

    public final Intent m786a(String str, Uri uri, ImageOverlayFieldsModel imageOverlayFieldsModel, long j) {
        ExpirationState expirationState = new ExpirationState(true, this.f741g.m782a(j));
        EditGalleryLaunchConfiguration.Builder b = new EditGalleryLaunchConfiguration.Builder().a(uri, str).b(EditFeature.STICKER).b(EditFeature.TEXT).b(EditFeature.DOODLE).b(EditFeature.FILTER);
        b.h = false;
        b = b.a(CropMode.ZOOM_CROP);
        b.f = true;
        b = b;
        EditGalleryZoomCropParams.Builder builder = new EditGalleryZoomCropParams.Builder();
        builder.b = FrameConversions.a(imageOverlayFieldsModel);
        builder = builder;
        builder.e = EditGalleryZoomCropParams.a;
        b.m = builder.a();
        b = b;
        b.k = expirationState;
        EditGalleryLaunchConfiguration.Builder builder2 = b;
        builder2.i = this.f740f.getTransformation(this.f735a.getString(2131234496), null).toString();
        return EditGalleryIntentCreator.a(this.f735a, EntryPoint.PROFILE.name(), builder2.a());
    }

    public final Intent m787a(String str, Uri uri, @Nullable ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel, ImageOverlayFieldsModel imageOverlayFieldsModel, long j) {
        StagingGroundLaunchConfig.Builder a = new StagingGroundLaunchConfig.Builder().a(uri, str);
        a.m = imageOverlayFieldsModel;
        a = a;
        a.l = imageOverlayWithSwipeableOverlaysModel;
        a = a;
        a.d = EntryPoint.PROFILE.name();
        a = a;
        a.f = this.f741g.m782a(j);
        a = a;
        a.p = this.f738d.a(ExperimentsForTimelineAbTestModule.m, false);
        a = a;
        a.r = this.f738d.a(ExperimentsForTimelineAbTestModule.k, false);
        a = a;
        a.s = this.f738d.a(ExperimentsForTimelineAbTestModule.l, false);
        a = a;
        a.k = "profile_picture_overlay";
        return StagingGroundIntentFactory.a(this.f735a, a.a(), new EditGalleryLaunchConfiguration.Builder().b(EditFeature.STICKER).b(EditFeature.TEXT).b(EditFeature.DOODLE).b(EditFeature.FILTER).a(CropMode.ZOOM_CROP).a());
    }
}
