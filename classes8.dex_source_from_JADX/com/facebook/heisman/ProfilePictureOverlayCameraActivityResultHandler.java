package com.facebook.heisman;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.heisman.ProfilePictureOverlayCameraModel.Builder;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.heisman.swipeable.FrameConversions;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.ipc.editgallery.EditGalleryIpcBundle;
import com.facebook.ipc.profile.profilevideo.ProfileVideoPreviewLauncher;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.productionprompts.common.PromptPublishIntentHelper;
import com.facebook.productionprompts.model.ProductionPromptObject;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.intent.TimelineIntentFactory;
import com.facebook.timeline.profilevideo.ProfileVideoPreviewLauncherImpl;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: var documentHead = document.getElementsByTagName('head')[0];var metas = documentHead.getElementsByTagName('meta');var hasViewportMetaTag = false;for (var i = 0; i < metas.length; i++) {var meta = metas[i];if (meta.getAttribute('name') === 'viewport') {hasViewportMetaTag = true;break;}}if (!hasViewportMetaTag) {var viewportTag = document.createElement('meta');viewportTag.name = 'viewport';viewportTag.content = 'width=device-width';documentHead.appendChild(viewportTag);} */
public class ProfilePictureOverlayCameraActivityResultHandler {
    private final ProfilePictureOverlayCameraModelStore f668a;
    private final ProfilePictureOverlayAnalyticsLogger f669b;
    private final ProfilePictureOverlayIntentFactory f670c;
    public final SecureContextHelper f671d;
    private final Lazy<FbErrorReporter> f672e;
    @ForUiThread
    private final Executor f673f;
    private final QeAccessor f674g;
    private final TimelineIntentFactory f675h;
    private final ProfileVideoPreviewLauncher f676i;
    private final ProfilePictureOverlayExpirationTimeConfig f677j;
    @Nullable
    private FutureAndCallbackHolder<Intent> f678k = null;

    public static ProfilePictureOverlayCameraActivityResultHandler m749b(InjectorLike injectorLike) {
        return new ProfilePictureOverlayCameraActivityResultHandler(ProfilePictureOverlayCameraModelStore.m761a(injectorLike), ProfilePictureOverlayAnalyticsLogger.m653a(injectorLike), ProfilePictureOverlayIntentFactory.m784a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 494), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), TimelineIntentFactory.b(injectorLike), ProfileVideoPreviewLauncherImpl.m11085b(injectorLike), ProfilePictureOverlayExpirationTimeConfig.m780a(injectorLike));
    }

    public static ProfilePictureOverlayCameraActivityResultHandler m745a(InjectorLike injectorLike) {
        return m749b(injectorLike);
    }

    @Inject
    public ProfilePictureOverlayCameraActivityResultHandler(ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore, ProfilePictureOverlayAnalyticsLogger profilePictureOverlayAnalyticsLogger, ProfilePictureOverlayIntentFactory profilePictureOverlayIntentFactory, SecureContextHelper secureContextHelper, Lazy<FbErrorReporter> lazy, Executor executor, QeAccessor qeAccessor, TimelineIntentFactory timelineIntentFactory, ProfileVideoPreviewLauncher profileVideoPreviewLauncher, ProfilePictureOverlayExpirationTimeConfig profilePictureOverlayExpirationTimeConfig) {
        this.f668a = profilePictureOverlayCameraModelStore;
        this.f669b = profilePictureOverlayAnalyticsLogger;
        this.f670c = profilePictureOverlayIntentFactory;
        this.f671d = secureContextHelper;
        this.f672e = lazy;
        this.f673f = executor;
        this.f674g = qeAccessor;
        this.f675h = timelineIntentFactory;
        this.f676i = profileVideoPreviewLauncher;
        this.f677j = profilePictureOverlayExpirationTimeConfig;
    }

    public final void m753a(int i, int i2, Intent intent, ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData, ProfilePictureOverlaySwipeableFramesLogController profilePictureOverlaySwipeableFramesLogController, ProfilePictureOverlayCameraActivity profilePictureOverlayCameraActivity) {
        if (!profilePictureOverlayCameraActivity.f628x) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        m748a(profilePictureOverlayCameraIntentData, intent, profilePictureOverlayCameraActivity, profilePictureOverlaySwipeableFramesLogController, "camera");
                        return;
                    }
                    this.f669b.m670c(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m757f());
                    return;
                case 2:
                    if (i2 == -1) {
                        m747a(profilePictureOverlayCameraIntentData, intent, profilePictureOverlayCameraActivity);
                        return;
                    } else {
                        this.f669b.m670c(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m757f());
                        return;
                    }
                case 3:
                    if (i2 == -1) {
                        m748a(profilePictureOverlayCameraIntentData, intent, profilePictureOverlayCameraActivity, profilePictureOverlaySwipeableFramesLogController, "existing");
                        return;
                    }
                    this.f669b.m670c(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m757f());
                    return;
                case 4:
                    if (i2 == -1) {
                        this.f669b.m664a(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m759i().c(), profilePictureOverlayCameraIntentData.e());
                        Intent a = this.f675h.a();
                        if (a != null) {
                            this.f671d.a(a, profilePictureOverlayCameraActivity);
                        }
                        profilePictureOverlayCameraActivity.setResult(-1);
                        profilePictureOverlayCameraActivity.finish();
                        return;
                    }
                    this.f669b.m670c(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m757f());
                    return;
                case 5:
                    if (i2 == -1) {
                        m750b(profilePictureOverlayCameraIntentData, intent, profilePictureOverlayCameraActivity);
                        return;
                    } else {
                        this.f669b.m670c(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m757f());
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private void m747a(ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData, Intent intent, Activity activity) {
        GraphQLPhoto graphQLPhoto = (GraphQLPhoto) FlatBufferModelHelper.a(intent.getExtras(), "photo");
        if (graphQLPhoto == null || graphQLPhoto.K() == null || graphQLPhoto.L() == null || graphQLPhoto.L().b() == null) {
            ((AbstractFbErrorReporter) this.f672e.get()).b("heisman_invalid_photo_picked", "null fields in the GraphQLPhoto from the photo tab picker: " + graphQLPhoto);
            return;
        }
        Intent a;
        ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f668a;
        Builder j = this.f668a.m763a().m760j();
        j.f686d = graphQLPhoto.K();
        profilePictureOverlayCameraModelStore.m764a(j.m754a());
        this.f669b.m666a(profilePictureOverlayCameraIntentData.c(), graphQLPhoto.K(), m751b(), this.f668a.m763a().m759i().c());
        if (this.f674g.a(ExperimentsForTimelineAbTestModule.p, false)) {
            a = this.f670c.m787a(graphQLPhoto.K(), Uri.parse(graphQLPhoto.L().b()), this.f668a.m763a().f693e, this.f668a.m763a().m759i(), profilePictureOverlayCameraIntentData.d());
        } else {
            a = this.f670c.m786a(graphQLPhoto.K(), Uri.parse(graphQLPhoto.L().b()), this.f668a.m763a().m759i(), profilePictureOverlayCameraIntentData.d());
        }
        this.f671d.a(a, 3, activity);
    }

    private void m750b(ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData, Intent intent, Activity activity) {
        this.f676i.mo53a(activity, profilePictureOverlayCameraIntentData.c(), intent.getData(), 4, 4, this.f668a.m763a().m759i(), null, this.f677j.m782a(profilePictureOverlayCameraIntentData.d()));
    }

    private void m748a(final ProfilePictureOverlayCameraIntentData profilePictureOverlayCameraIntentData, Intent intent, final Activity activity, ProfilePictureOverlaySwipeableFramesLogController profilePictureOverlaySwipeableFramesLogController, String str) {
        EditGalleryIpcBundle editGalleryIpcBundle;
        if (intent.hasExtra("staging_ground_selected_frame")) {
            String c = ((ImageOverlayFieldsModel) FlatBufferModelHelper.a(intent, "staging_ground_selected_frame")).c();
            ProfilePictureOverlayCameraModelStore profilePictureOverlayCameraModelStore = this.f668a;
            Builder j = this.f668a.m763a().m760j();
            j.f688f = c;
            profilePictureOverlayCameraModelStore.m764a(j.m754a());
            editGalleryIpcBundle = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
        } else {
            CreativeEditingData.Builder builder;
            EditGalleryIpcBundle editGalleryIpcBundle2 = (EditGalleryIpcBundle) intent.getParcelableExtra(EditGalleryIpcBundle.a);
            if (editGalleryIpcBundle2.e != null) {
                builder = new CreativeEditingData.Builder(editGalleryIpcBundle2.e);
            } else {
                builder = new CreativeEditingData.Builder();
            }
            ImageOverlayFieldsModel i = this.f668a.m763a().m759i();
            builder.j = ImmutableList.of(FrameConversions.a(i));
            CreativeEditingData a = builder.a();
            EditGalleryIpcBundle.Builder a2 = EditGalleryIpcBundle.Builder.a(editGalleryIpcBundle2);
            a2.d = a;
            a2 = a2;
            a2.g = i.c();
            editGalleryIpcBundle = a2.a();
        }
        this.f669b.m663a(profilePictureOverlayCameraIntentData.c(), this.f668a.m763a().m759i().c(), profilePictureOverlaySwipeableFramesLogController, profilePictureOverlayCameraIntentData.e(), m746a(str), profilePictureOverlayCameraIntentData.g());
        ListenableFuture a3 = this.f670c.m788a(editGalleryIpcBundle, profilePictureOverlayCameraIntentData.e(), intent.getLongExtra("extra_profile_pic_expiration", 0), intent.getStringExtra("staging_ground_photo_caption"), str);
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(activity.getResources().getString(2131230739));
        progressDialog.show();
        C00851 c00851 = new AbstractDisposableFutureCallback<Intent>(this) {
            final /* synthetic */ ProfilePictureOverlayCameraActivityResultHandler f667d;

            protected final void m742a(Object obj) {
                Intent intent = (Intent) obj;
                progressDialog.dismiss();
                if (intent != null) {
                    this.f667d.f671d.a(intent, activity);
                }
                activity.setResult(-1, new Intent().putExtras(PromptPublishIntentHelper.m4361a(profilePictureOverlayCameraIntentData.h(), ProductionPromptObject.class, Boolean.valueOf(true))));
                activity.finish();
            }

            protected final void m743a(Throwable th) {
                progressDialog.dismiss();
            }
        };
        Futures.a(a3, c00851, this.f673f);
        this.f678k = new FutureAndCallbackHolder(a3, c00851);
    }

    private String m746a(String str) {
        if (Objects.equal(str, "camera")) {
            return "photo_taken";
        }
        if (Objects.equal(str, "existing")) {
            return m751b() ? "current_profile_picture" : "existing_photo";
        } else {
            throw new IllegalArgumentException("Don't have a PhotoSource matching the profilePhotoMethod: " + str);
        }
    }

    private boolean m751b() {
        String str = this.f668a.m763a().f692d;
        ProfilePictureOverlayCameraModel a = this.f668a.m763a();
        String j = (a.f690b == null || a.f690b.a() == null) ? null : a.f690b.a().j();
        return Objects.equal(str, j);
    }

    public final void m752a() {
        if (this.f678k != null) {
            this.f678k.a(true);
        }
    }
}
