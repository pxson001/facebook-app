package com.facebook.backstage.consumption;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.widget.Toast;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.api.ShotApi;
import com.facebook.backstage.api.ShotApi.C03871;
import com.facebook.backstage.consumption.BackstageRetryHelper.C04471;
import com.facebook.backstage.consumption.reply.ReplyDataProvider;
import com.facebook.backstage.data.UploadShot;
import com.facebook.backstage.data.UploadShot.UploadType;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Timer;
import javax.inject.Inject;

/* compiled from: sample_content */
public class BackstageUploadService extends FbIntentService {
    public static final String f4590g = BackstageUploadService.class.getSimpleName();
    @Inject
    ShotApi f4591a;
    @Inject
    @ForUiThread
    ListeningExecutorService f4592b;
    @Inject
    ProfilesDataProvider f4593c;
    @Inject
    ReplyDataProvider f4594d;
    @Inject
    TempFileManager f4595e;
    @Inject
    BackstageRetryHelper f4596f;

    private static <T extends Context> void m4524a(Class<T> cls, T t) {
        m4525a((Object) t, (Context) t);
    }

    public static void m4525a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((BackstageUploadService) obj).m4521a(ShotApi.m4269a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ProfilesDataProvider.m4540a(injectorLike), ReplyDataProvider.m4801a(injectorLike), TempFileManager.a(injectorLike), new BackstageRetryHelper((Context) injectorLike.getInstance(Context.class), FbNetworkManager.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike)));
    }

    private void m4521a(ShotApi shotApi, ListeningExecutorService listeningExecutorService, ProfilesDataProvider profilesDataProvider, ReplyDataProvider replyDataProvider, TempFileManager tempFileManager, BackstageRetryHelper backstageRetryHelper) {
        this.f4591a = shotApi;
        this.f4592b = listeningExecutorService;
        this.f4593c = profilesDataProvider;
        this.f4594d = replyDataProvider;
        this.f4595e = tempFileManager;
        this.f4596f = backstageRetryHelper;
    }

    public BackstageUploadService() {
        super("backstage_save_shot");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 671480323);
        super.onCreate();
        Class cls = BackstageUploadService.class;
        m4525a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1045337503, a);
    }

    public static void m4523a(SecureContextHelper secureContextHelper, Context context, UploadShot... uploadShotArr) {
        Intent intent = new Intent(context, BackstageUploadService.class);
        intent.setAction("backstage_save_shot");
        intent.putExtra("shot", uploadShotArr);
        secureContextHelper.c(intent, context);
    }

    protected final void m4527a(Intent intent) {
        this.f4595e.a();
        for (Parcelable parcelable : intent.getParcelableArrayExtra("shot")) {
            m4522a((UploadShot) parcelable);
        }
    }

    private void m4522a(final UploadShot uploadShot) {
        switch (uploadShot.f5149e) {
            case STACK:
                this.f4593c.m4543a(uploadShot);
                break;
            case REPLY_FROM_THREAD:
                ReplyDataProvider replyDataProvider = this.f4594d;
                replyDataProvider.f4958d.m4794a(uploadShot.f5152h, uploadShot.f5147c, uploadShot);
                replyDataProvider.m4806a(false, uploadShot.f5152h);
                replyDataProvider.m4805a(false);
                break;
        }
        ShotApi shotApi = this.f4591a;
        UploadShot uploadShot2 = (UploadShot) Preconditions.checkNotNull(uploadShot);
        shotApi.f4282i.m4264a(Event.UPLOAD_STARTED);
        SettableFuture f = SettableFuture.f();
        ExecutorDetour.a(shotApi.f4275b, new C03871(shotApi, uploadShot2, f), -1128919186);
        Futures.a(f, new FutureCallback<String>(this) {
            final /* synthetic */ BackstageUploadService f4588b;

            public void onSuccess(Object obj) {
                String str = (String) obj;
                switch (uploadShot.f5149e) {
                    case STACK:
                        ProfilesDataProvider profilesDataProvider = this.f4588b.f4593c;
                        UploadShot uploadShot = uploadShot;
                        UploadingProfileOptimisticStore uploadingProfileOptimisticStore = profilesDataProvider.f4626b;
                        if (uploadShot.f5149e == UploadType.STACK) {
                            uploadingProfileOptimisticStore.f4654a.m4917a(str, uploadShot);
                            uploadingProfileOptimisticStore.f4655b.m4534a();
                        }
                        break;
                    case REPLY_FROM_THREAD:
                        this.f4588b.f4594d.f4958d.m4793a(uploadShot.f5147c, str);
                        break;
                }
                String str2 = BackstageUploadService.f4590g;
            }

            public void onFailure(Throwable th) {
                BLog.b(BackstageUploadService.f4590g, "Failed to save the shot", th);
                UploadShot uploadShot;
                if (uploadShot.f5154j > 5) {
                    uploadShot.f5154j = 0;
                    String str = BackstageUploadService.f4590g;
                    ProfilesDataProvider profilesDataProvider = this.f4588b.f4593c;
                    uploadShot = uploadShot;
                    UploadingProfileOptimisticStore uploadingProfileOptimisticStore = profilesDataProvider.f4626b;
                    if (uploadShot.f5149e == UploadType.STACK) {
                        uploadingProfileOptimisticStore.f4654a.m4914a(uploadShot);
                    }
                    Toast.makeText(this.f4588b.getBaseContext(), this.f4588b.getResources().getString(2131239902), 1).show();
                    return;
                }
                BackstageRetryHelper backstageRetryHelper = this.f4588b.f4596f;
                uploadShot = uploadShot;
                if (backstageRetryHelper.f4582b.d()) {
                    if (backstageRetryHelper.f4586f != null) {
                        backstageRetryHelper.f4586f.c();
                        backstageRetryHelper.f4586f = null;
                    }
                    uploadShot.f5154j++;
                    new Timer().schedule(new C04471(backstageRetryHelper, uploadShot), uploadShot.f5155k);
                    uploadShot.f5155k *= 2;
                } else {
                    if (backstageRetryHelper.f4586f == null) {
                        backstageRetryHelper.f4586f = backstageRetryHelper.f4585e.a().a("com.facebook.orca.ACTION_NETWORK_CONNECTIVITY_CHANGED", backstageRetryHelper.f4584d).a();
                        backstageRetryHelper.f4586f.b();
                    }
                    backstageRetryHelper.f4584d.m4520a(uploadShot);
                }
                str = BackstageUploadService.f4590g;
            }
        }, this.f4592b);
    }
}
