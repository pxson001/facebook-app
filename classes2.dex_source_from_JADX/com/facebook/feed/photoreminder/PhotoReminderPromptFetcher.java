package com.facebook.feed.photoreminder;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.C0055x2995691a;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.feed.photoreminder.abtest.PhotoReminderGatekeeperHelper;
import com.facebook.feed.photoreminder.model.MediaReminderModel;
import com.facebook.feed.photoreminder.model.PhotoReminderPromptObject;
import com.facebook.graphql.enums.GraphQLPromptType;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.fetcher.PromptFetcher;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.productionprompts.abtest.PromptsExperimentHelper;
import com.facebook.productionprompts.common.PromptsInternalSettingsController;
import com.facebook.productionprompts.model.PromptObject;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_inflight_req */
public class PhotoReminderPromptFetcher implements PromptFetcher {
    @Nullable
    PhotoReminderPromptObject f12589a;
    @Nullable
    PhotoReminderPromptObject f12590b;
    public final MediaReminderChecker f12591c;
    private final ListeningExecutorService f12592d;
    public final QuickPerformanceLogger f12593e;

    /* compiled from: network_info_inflight_req */
    class C05801 implements Callable<ImmutableList<PromptObject>> {
        final /* synthetic */ PhotoReminderPromptFetcher f13939a;

        C05801(PhotoReminderPromptFetcher photoReminderPromptFetcher) {
            this.f13939a = photoReminderPromptFetcher;
        }

        public Object call() {
            MediaReminderModel mediaReminderModel;
            MediaReminderModel mediaReminderModel2 = null;
            Builder builder = new Builder();
            MediaReminderChecker mediaReminderChecker = this.f13939a.f12591c;
            if (this.f13939a.f12589a == null) {
                mediaReminderModel = null;
            } else {
                mediaReminderModel = this.f13939a.f12589a.f12633a;
            }
            mediaReminderModel = mediaReminderChecker.m18697a(mediaReminderModel, null, GraphQLPromptType.PHOTO);
            mediaReminderChecker = this.f13939a.f12591c;
            if (this.f13939a.f12590b != null) {
                mediaReminderModel2 = this.f13939a.f12590b.f12633a;
            }
            mediaReminderModel2 = mediaReminderChecker.m18697a(mediaReminderModel2, mediaReminderModel.m25074a(), GraphQLPromptType.PHOTO_WEEKEND);
            if (mediaReminderModel.m25077d()) {
                if (this.f13939a.f12589a == null || !this.f13939a.f12589a.f12633a.equals(mediaReminderModel)) {
                    this.f13939a.f12589a = new PhotoReminderPromptObject(mediaReminderModel);
                }
                builder.m1069c(this.f13939a.f12589a);
            }
            if (mediaReminderModel2.m25077d()) {
                if (this.f13939a.f12590b == null || !this.f13939a.f12590b.f12633a.equals(mediaReminderModel2)) {
                    this.f13939a.f12590b = new PhotoReminderPromptObject(mediaReminderModel2);
                }
                builder.m1069c(this.f13939a.f12590b);
            }
            this.f13939a.f12593e.mo456a(9633793, (short) 13, "fetcher", PhotoReminderPromptFetcher.class.getSimpleName());
            return builder.m1068b();
        }
    }

    public static PhotoReminderPromptFetcher m18672b(InjectorLike injectorLike) {
        return new PhotoReminderPromptFetcher(new MediaReminderChecker(FbSharedPreferencesImpl.m1826a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), MediaReminderUtil.m18699a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.m4525a(injectorLike), PromptsExperimentHelper.m15312b(injectorLike), PhotoReminderGatekeeperHelper.m15318b(injectorLike), WeekendPhotoReminderLogger.m18716b(injectorLike), PromptsInternalSettingsController.m18718a(injectorLike), DefaultTimeFormatUtil.m11785a(injectorLike), ResourcesMethodAutoProvider.m6510a(injectorLike)), C0055x2995691a.m1881a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.m2859a(injectorLike));
    }

    @Inject
    public PhotoReminderPromptFetcher(MediaReminderChecker mediaReminderChecker, ListeningExecutorService listeningExecutorService, QuickPerformanceLogger quickPerformanceLogger) {
        this.f12591c = mediaReminderChecker;
        this.f12592d = listeningExecutorService;
        this.f12593e = quickPerformanceLogger;
    }

    public final boolean mo2490a() {
        return this.f12591c.m18698a();
    }

    public final Class<? extends PromptObject> mo2491b() {
        return PhotoReminderPromptObject.class;
    }

    public final ListenableFuture<ImmutableList<PromptObject>> mo2492c() {
        return this.f12592d.mo271a(new C05801(this));
    }

    public final void mo2488a(Class<? extends PromptObject> cls) {
        if (cls.equals(PhotoReminderPromptObject.class)) {
            this.f12589a = null;
            this.f12590b = null;
        }
    }

    public final void mo2489a(Class<? extends PromptObject> cls, String str, boolean z) {
        if (cls.equals(PhotoReminderPromptObject.class)) {
            this.f12589a = null;
            this.f12590b = null;
        }
    }
}
