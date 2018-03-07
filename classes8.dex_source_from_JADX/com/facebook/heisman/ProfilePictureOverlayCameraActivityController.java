package com.facebook.heisman;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.hardware.Camera;
import android.net.Uri;
import android.provider.MediaStore.Files;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Toast;
import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.heisman.ProfilePictureOverlayCameraModel.Builder;
import com.facebook.heisman.ProfilePictureOverlayCameraToolbarBinder.C00881;
import com.facebook.heisman.ProfilePictureOverlayCameraToolbarBinder.C00892;
import com.facebook.heisman.abtest.ExperimentsForProfilePictureOverlayAbTestModule;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.CameraTitleFieldsModel;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel;
import com.facebook.heisman.protocol.HeismanSelfProfilePictureGraphQLModels.SelfProfilePictureFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.protocol.swipeable.SwipeableOverlaysGraphQLModels.ImageOverlayWithSwipeableOverlaysModel;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.heisman.swipeable.ImageOverlayValidator;
import com.facebook.inject.Assisted;
import com.facebook.ipc.creativecam.CreativeCamCaptureInfo;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.ipc.media.MediaCursorHelper;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.ipc.profile.profilevideo.ProfileVideoPreviewLauncher;
import com.facebook.ipc.profile.profilevideo.VideoFileSource;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.creativecam.activity.CreativeEditingCameraFragment.1;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.facebook.productionprompts.common.PromptPublishIntentHelper;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors.DirectExecutor;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Provider;

/* compiled from: version_response */
public class ProfilePictureOverlayCameraActivityController implements CreativeCamPickerPreviewController, CreativeCamTopBarController {
    private static final CallerContext f638b = CallerContext.a(ProfilePictureOverlayCameraActivityController.class, "timeline");
    @Inject
    volatile Provider<UriIntentMapper> f639a = UltralightRuntime.a;
    public final Activity f640c;
    @Nullable
    public Toolbar f641d;
    public final ProfilePictureOverlayCameraIntentData f642e;
    @Inject
    public ProfilePictureOverlayCameraModelStore f643f;
    @Inject
    public ProfilePictureOverlayActivityLauncher f644g;
    @Inject
    public ProfilePictureOverlayCameraToolbarBinder f645h;
    @Inject
    public ProfilePictureOverlayCameraQueryExecutor f646i;
    @Inject
    private ProfilePictureOverlayIntentFactory f647j;
    @Inject
    public ProfilePictureOverlayAnalyticsLogger f648k;
    @Inject
    private SecureContextHelper f649l;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<FbErrorReporter> f650m = UltralightRuntime.b;
    @DefaultExecutorService
    @Inject
    private ListeningExecutorService f651n;
    @Inject
    @ForUiThread
    private Executor f652o;
    @Inject
    private MediaItemFactory f653p;
    @Inject
    private QeAccessor f654q;
    @Inject
    private ProfileVideoPreviewLauncher f655r;
    @Inject
    private ProfilePictureOverlayExpirationTimeConfig f656s;
    public ProfilePictureOverlayCameraFetchFutures f657t;
    @Nullable
    public FutureAndCallbackHolder<GraphQLResult<SelfProfilePictureFieldsModel>> f658u;
    @Nullable
    public FutureAndCallbackHolder<ImageOverlayFieldsModel> f659v;
    @Nullable
    public FutureAndCallbackHolder<GraphQLResult<ImageOverlayCameraTitleFieldsModel>> f660w;
    @Nullable
    public FutureAndCallbackHolder<Uri> f661x;
    @Nullable
    private FbDraweeView f662y = null;
    private int f663z = 0;

    /* compiled from: version_response */
    class C00792 extends AbstractDisposableFutureCallback<GraphQLResult<SelfProfilePictureFieldsModel>> {
        final /* synthetic */ ProfilePictureOverlayCameraActivityController f632a;

        C00792(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
            this.f632a = profilePictureOverlayCameraActivityController;
        }

        protected final void m696a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f632a.f658u = null;
            if (!(graphQLResult.e == null || ((SelfProfilePictureFieldsModel) graphQLResult.e).j() == null || ((SelfProfilePictureFieldsModel) graphQLResult.e).j().a() == null)) {
                ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f632a.f643f;
                Builder j = this.f632a.f643f.m763a().m760j();
                j.f684b = (SelfProfilePictureFieldsModel) graphQLResult.e;
                profilePictureOverlayCameraModelStore.m764a(j.m754a());
            }
            this.f632a.m716f();
        }

        protected final void m697a(Throwable th) {
            this.f632a.f658u = null;
            if (!(th instanceof IOException)) {
                ((AbstractFbErrorReporter) this.f632a.f650m.get()).a("heisman_fetch_self_profile_picture_failed", th);
            }
            ProfilePictureOverlayCameraActivityController.m728l(this.f632a);
        }
    }

    /* compiled from: version_response */
    class C00803 implements Callable<Uri> {
        final /* synthetic */ ProfilePictureOverlayCameraActivityController f633a;

        C00803(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
            this.f633a = profilePictureOverlayCameraActivityController;
        }

        public Object call() {
            String b = ProfilePictureOverlayCameraActivityController.m709b(this.f633a.f640c.getContentResolver());
            return b == null ? null : Uri.fromFile(new File(b));
        }
    }

    /* compiled from: version_response */
    class C00814 extends AbstractDisposableFutureCallback<Uri> {
        final /* synthetic */ ProfilePictureOverlayCameraActivityController f634a;

        C00814(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
            this.f634a = profilePictureOverlayCameraActivityController;
        }

        protected final void m698a(Object obj) {
            Uri uri = (Uri) obj;
            this.f634a.f661x = null;
            if (uri != null) {
                ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f634a.f643f;
                Builder j = this.f634a.f643f.m763a().m760j();
                j.f685c = uri.toString();
                profilePictureOverlayCameraModelStore.m764a(j.m754a());
            }
            this.f634a.f641d;
        }

        protected final void m699a(Throwable th) {
            this.f634a.f661x = null;
            if (!(th instanceof IOException)) {
                ((AbstractFbErrorReporter) this.f634a.f650m.get()).a("heisman_fetch_recent_video_thumbnail_failed", th);
            }
            ProfilePictureOverlayCameraActivityController.m728l(this.f634a);
        }
    }

    /* compiled from: version_response */
    class C00835 extends AbstractDisposableFutureCallback<GraphQLResult<ImageOverlayCameraTitleFieldsModel>> {
        final /* synthetic */ ProfilePictureOverlayCameraActivityController f636a;

        /* compiled from: version_response */
        class C00821 implements OnClickListener {
            final /* synthetic */ C00835 f635a;

            C00821(C00835 c00835) {
                this.f635a = c00835;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -387511493);
                this.f635a.f636a.f648k.m661a(this.f635a.f636a.f642e.c());
                this.f635a.f636a.f644g.m652a(this.f635a.f636a.f640c, ((ProfilePictureOverlayPivotIntentData.Builder) ((ProfilePictureOverlayPivotIntentData.Builder) ((ProfilePictureOverlayPivotIntentData.Builder) ((ProfilePictureOverlayPivotIntentData.Builder) new ProfilePictureOverlayPivotIntentData.Builder(this.f635a.f636a.f642e.c(), this.f635a.f636a.f642e.g()).c(this.f635a.f636a.f643f.m763a().f689a.c()).a(this.f635a.f636a.f642e.e())).b(this.f635a.f636a.f642e.f())).a(this.f635a.f636a.f642e.d())).a(this.f635a.f636a.f642e.i())).a());
                this.f635a.f636a.f640c.finish();
                Logger.a(2, EntryType.UI_INPUT_END, -1548765333, a);
            }
        }

        C00835(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
            this.f636a = profilePictureOverlayCameraActivityController;
        }

        protected final void m700a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult.e == null) {
                m701a(new IllegalArgumentException("null camera title result"));
                return;
            }
            this.f636a.f660w = null;
            ProfilePictureOverlayCameraToolbarBinder profilePictureOverlayCameraToolbarBinder = this.f636a.f645h;
            ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel = (ImageOverlayCameraTitleFieldsModel) graphQLResult.e;
            Toolbar toolbar = this.f636a.f641d;
            OnClickListener c00821 = new C00821(this);
            if (!(imageOverlayCameraTitleFieldsModel == null || imageOverlayCameraTitleFieldsModel.b().isEmpty() || ((CameraTitleFieldsModel) imageOverlayCameraTitleFieldsModel.b().get(0)).a() == null)) {
                if (((QeAccessor) profilePictureOverlayCameraToolbarBinder.f713a.get()).a(ExperimentsForProfilePictureOverlayAbTestModule.d, false)) {
                    ((ViewStub) toolbar.findViewById(2131566377)).inflate().setOnClickListener(c00821);
                }
                CameraTitleFieldsModel cameraTitleFieldsModel = (CameraTitleFieldsModel) imageOverlayCameraTitleFieldsModel.b().get(0);
                toolbar.setTitle(cameraTitleFieldsModel.a());
                if (!(cameraTitleFieldsModel.b() == null || cameraTitleFieldsModel.b().a() == null || cameraTitleFieldsModel.b().a().a() <= 1)) {
                    toolbar.setSubtitle(profilePictureOverlayCameraToolbarBinder.f715c.getTransformation(profilePictureOverlayCameraToolbarBinder.f716d.getString(2131238436), toolbar));
                    toolbar.setOnClickListener(c00821);
                }
            }
        }

        protected final void m701a(Throwable th) {
            this.f636a.f660w = null;
            if (!(th instanceof IOException)) {
                ((AbstractFbErrorReporter) this.f636a.f650m.get()).a("heisman_fetch_title_failed", th);
            }
        }
    }

    /* compiled from: version_response */
    class C00846 implements Function<GraphQLResult<ImageOverlayWithSwipeableOverlaysModel>, ImmutableList<Frame>> {
        final /* synthetic */ ProfilePictureOverlayCameraActivityController f637a;

        C00846(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
            this.f637a = profilePictureOverlayCameraActivityController;
        }

        public Object apply(Object obj) {
            ImageOverlayWithSwipeableOverlaysModel imageOverlayWithSwipeableOverlaysModel = (ImageOverlayWithSwipeableOverlaysModel) ((GraphQLResult) obj).e;
            if (ImageOverlayValidator.a(imageOverlayWithSwipeableOverlaysModel)) {
                ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f637a.f643f;
                Builder j = this.f637a.f643f.m763a().m760j();
                j.f687e = imageOverlayWithSwipeableOverlaysModel;
                profilePictureOverlayCameraModelStore.m764a(j.m754a());
                return FrameConversions.a(imageOverlayWithSwipeableOverlaysModel, this.f637a.f643f.m763a().f689a);
            }
            throw new IllegalArgumentException("Invalid swipeable overlays list from server");
        }
    }

    final void m736a(Provider<UriIntentMapper> provider, ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore, ProfilePictureOverlayActivityLauncher profilePictureOverlayActivityLauncher, ProfilePictureOverlayCameraToolbarBinder profilePictureOverlayCameraToolbarBinder, ProfilePictureOverlayCameraQueryExecutor profilePictureOverlayCameraQueryExecutor, ProfilePictureOverlayIntentFactory profilePictureOverlayIntentFactory, ProfilePictureOverlayAnalyticsLogger profilePictureOverlayAnalyticsLogger, SecureContextHelper secureContextHelper, com.facebook.inject.Lazy<FbErrorReporter> lazy, ListeningExecutorService listeningExecutorService, Executor executor, MediaItemFactory mediaItemFactory, QeAccessor qeAccessor, ProfileVideoPreviewLauncher profileVideoPreviewLauncher, ProfilePictureOverlayExpirationTimeConfig profilePictureOverlayExpirationTimeConfig) {
        this.f639a = provider;
        this.f643f = profilePictureOverlayCameraModelStore;
        this.f644g = profilePictureOverlayActivityLauncher;
        this.f645h = profilePictureOverlayCameraToolbarBinder;
        this.f646i = profilePictureOverlayCameraQueryExecutor;
        this.f647j = profilePictureOverlayIntentFactory;
        this.f648k = profilePictureOverlayAnalyticsLogger;
        this.f649l = secureContextHelper;
        this.f650m = lazy;
        this.f651n = listeningExecutorService;
        this.f652o = executor;
        this.f653p = mediaItemFactory;
        this.f654q = qeAccessor;
        this.f655r = profileVideoPreviewLauncher;
        this.f656s = profilePictureOverlayExpirationTimeConfig;
    }

    @Inject
    public ProfilePictureOverlayCameraActivityController(@Assisted Activity activity, @Assisted ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData) {
        this.f640c = activity;
        this.f642e = profilePictureOverlayCameraIntentData;
    }

    public final void m735a(@Nullable ImageOverlayCameraTitleFieldsModel imageOverlayCameraTitleFieldsModel, Runnable runnable) {
        this.f657t = this.f646i.m772a(imageOverlayCameraTitleFieldsModel, this.f643f.m763a().f689a);
        m706a(runnable);
        m715e();
        m721h();
        this.f648k.m665a(this.f642e.c(), this.f642e.f(), this.f642e.g(), this.f643f.m763a().m757f());
    }

    private void m706a(final Runnable runnable) {
        C00781 c00781 = new AbstractDisposableFutureCallback<ImageOverlayFieldsModel>(this) {
            final /* synthetic */ ProfilePictureOverlayCameraActivityController f631b;

            protected final void m694a(Object obj) {
                ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) obj;
                this.f631b.f659v = null;
                ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f631b.f643f;
                Builder j = this.f631b.f643f.m763a().m760j();
                j.f683a = imageOverlayFieldsModel;
                profilePictureOverlayCameraModelStore.m764a(j.m754a());
                runnable.run();
            }

            protected final void m695a(Throwable th) {
                this.f631b.f659v = null;
                if (!(th instanceof IOException)) {
                    ((AbstractFbErrorReporter) this.f631b.f650m.get()).a("heisman_fetch_image_overlay_failed", th);
                }
            }
        };
        Futures.a(this.f657t.f680b, c00781, this.f652o);
        this.f659v = new FutureAndCallbackHolder(this.f657t.f680b, c00781);
    }

    private void m715e() {
        C00792 c00792 = new C00792(this);
        Futures.a(this.f657t.f679a, c00792, this.f652o);
        this.f658u = new FutureAndCallbackHolder(this.f657t.f679a, c00792);
    }

    public final void m734a(FbDraweeView fbDraweeView, int i) {
        this.f662y = fbDraweeView;
        this.f663z = i;
        if (i == 0) {
            m716f();
        } else {
            this.f641d;
        }
    }

    private void m716f() {
        if (this.f662y != null && this.f663z == 0) {
            if (this.f643f.m763a().m756c() == null) {
                this.f662y.setVisibility(8);
                return;
            }
            this.f662y.setVisibility(0);
            this.f662y.a(Uri.parse(this.f643f.m763a().m756c()), f638b);
        }
    }

    public static void m719g(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
        if (profilePictureOverlayCameraActivityController.f662y != null && profilePictureOverlayCameraActivityController.f663z == 1) {
            if (profilePictureOverlayCameraActivityController.f643f.m763a().f691c == null) {
                profilePictureOverlayCameraActivityController.f662y.setVisibility(8);
                return;
            }
            profilePictureOverlayCameraActivityController.f662y.setVisibility(0);
            profilePictureOverlayCameraActivityController.f662y.a(Uri.parse(profilePictureOverlayCameraActivityController.f643f.m763a().f691c), f638b);
        }
    }

    private void m721h() {
        ListenableFuture a = this.f651n.a(new C00803(this));
        C00814 c00814 = new C00814(this);
        Futures.a(a, c00814, this.f652o);
        this.f661x = new FutureAndCallbackHolder(a, c00814);
    }

    @Nullable
    public static String m709b(ContentResolver contentResolver) {
        String string;
        Throwable th;
        Throwable th2 = null;
        Preconditions.checkNotNull(contentResolver);
        ContentResolver contentResolver2 = contentResolver;
        Cursor query = contentResolver2.query(Files.getContentUri("external"), new String[]{"_id", "_data", "datetaken"}, MediaCursorHelper.a(SupportedMediaType.VIDEO_ONLY), null, "date_modified DESC LIMIT 1");
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    string = query.getString(1);
                    if (query != null) {
                        query.close();
                    }
                } else if (query != null) {
                    query.close();
                }
            } catch (Throwable th3) {
                th2 = th;
                th = th3;
            }
        } else if (query != null) {
            query.close();
        }
        return string;
        throw th;
        if (query != null) {
            if (th2 != null) {
                try {
                    query.close();
                } catch (Throwable th32) {
                    AndroidCompat.addSuppressed(th2, th32);
                }
            } else {
                query.close();
            }
        }
        throw th;
    }

    public final boolean m737a(String str, int i) {
        ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f643f;
        Builder j = this.f643f.m763a().m760j();
        j.f688f = m705a(str);
        profilePictureOverlayCameraModelStore.m764a(j.m754a());
        if (i == 0) {
            m725j();
        } else {
            m727k();
        }
        return true;
    }

    private String m705a(String str) {
        return Strings.isNullOrEmpty(str) ? this.f643f.m763a().f689a.c() : str;
    }

    private void m723i() {
        C00835 c00835 = new C00835(this);
        Futures.a(this.f657t.f682d, c00835, this.f652o);
        this.f660w = new FutureAndCallbackHolder(this.f657t.f682d, c00835);
    }

    public final void m732a(Uri uri, String str) {
        Intent a;
        ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f643f;
        Builder j = this.f643f.m763a().m760j();
        j.f688f = m705a(str);
        profilePictureOverlayCameraModelStore.m764a(j.m754a());
        ImageOverlayFieldsModel i = this.f643f.m763a().m759i();
        this.f648k.m671d(this.f642e.c(), i.c());
        MediaItem a2 = this.f653p.a(uri, FallbackMediaId.SINGLE_SHOT_CAMERA);
        if (this.f654q.a(ExperimentsForTimelineAbTestModule.p, false)) {
            a = this.f647j.m787a(a2.d().toString(), uri, this.f643f.m763a().f693e, i, this.f642e.d());
        } else {
            a = this.f647j.m786a(a2.d().toString(), uri, i, this.f642e.d());
        }
        this.f649l.a(a, 1, this.f640c);
    }

    public final void m731a(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
        ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f643f;
        Builder j = this.f643f.m763a().m760j();
        j.f688f = m705a(creativeCamCaptureInfo.c);
        profilePictureOverlayCameraModelStore.m764a(j.m754a());
        ImageOverlayFieldsModel i = this.f643f.m763a().m759i();
        this.f655r.mo53a(this.f640c, this.f642e.c(), uri, VideoFileSource.m1393a(creativeCamCaptureInfo.a), 4, i, null, this.f656s.m782a(this.f642e.d()));
    }

    private void m725j() {
        Intent a = ((UriIntentMapper) this.f639a.get()).a(this.f640c, FBLinks.bo);
        a.putExtra("pick_pic_lite", true);
        a.putExtra("disable_camera_roll", true);
        a.putExtra("extra_photo_title_text", this.f640c.getString(2131238435));
        a.putExtra("disable_adding_photos_to_albums", true);
        this.f649l.a(a, 2, this.f640c);
    }

    private void m727k() {
        Intent intent = new Intent(this.f647j.f735a, SimplePickerLauncherActivity.class);
        intent.putExtra("extra_simple_picker_launcher_settings", new SimplePickerLauncherConfiguration.Builder(SimplePickerSource.PROFILEPIC).j().h().a(Action.NONE).r());
        this.f649l.a(intent, 5, this.f640c);
    }

    public static void m728l(ProfilePictureOverlayCameraActivityController profilePictureOverlayCameraActivityController) {
        Toast.makeText(profilePictureOverlayCameraActivityController.f640c, profilePictureOverlayCameraActivityController.f640c.getResources().getString(2131230758), 1).show();
    }

    public final void m738b() {
        this.f648k.m668b(this.f642e.c(), this.f643f.m763a().m757f());
        this.f640c.setResult(0, new Intent().putExtras(PromptPublishIntentHelper.m4361a(this.f642e.h(), ProductionPromptObject.class, null)));
    }

    public final void m739c() {
        if (this.f658u != null) {
            this.f658u.a(true);
            this.f658u = null;
        }
        if (this.f659v != null) {
            this.f659v.a(true);
            this.f659v = null;
        }
        if (this.f660w != null) {
            this.f660w.a(true);
            this.f660w = null;
        }
        if (this.f661x != null) {
            this.f661x.a(true);
            this.f661x = null;
        }
        this.f662y = null;
    }

    public final ListenableFuture<ImmutableList<Frame>> m740d() {
        if (this.f657t.f681c == null) {
            return null;
        }
        return Futures.a(this.f657t.f681c, new C00846(this), DirectExecutor.INSTANCE);
    }

    public final ViewGroup m730a(ViewStub viewStub, 1 1) {
        viewStub.setLayoutResource(2130906454);
        this.f641d = (Toolbar) viewStub.inflate();
        ProfilePictureOverlayCameraToolbarBinder profilePictureOverlayCameraToolbarBinder = this.f645h;
        Toolbar toolbar = this.f641d;
        toolbar.setNavigationIcon(profilePictureOverlayCameraToolbarBinder.f714b.a(2130839697, -1));
        toolbar.setNavigationOnClickListener(new C00881(profilePictureOverlayCameraToolbarBinder, 1));
        profilePictureOverlayCameraToolbarBinder = this.f645h;
        toolbar = this.f641d;
        Menu menu = toolbar.getMenu();
        if (menu.findItem(2) == null) {
            MenuItem add = menu.add(0, 2, 0, 2131238437);
            add.setShowAsAction(1);
            add.setActionView(2130903484);
        }
        if (menu.findItem(1) == null && Camera.getNumberOfCameras() > 1) {
            MenuItem add2 = menu.add(0, 1, 0, 2131238439);
            add2.setShowAsAction(1);
            add2.setIcon(profilePictureOverlayCameraToolbarBinder.f714b.a(2130840086, -1));
        }
        toolbar.D = new C00892(profilePictureOverlayCameraToolbarBinder, 1);
        m723i();
        return this.f641d;
    }

    public final void m733a(ViewGroup viewGroup, ImmutableList<?> immutableList) {
    }

    @Nullable
    public final View m729a() {
        return null;
    }
}
