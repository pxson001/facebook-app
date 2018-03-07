package com.facebook.goodwill.publish;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.DefaultPhotoFlowLogger;
import com.facebook.photos.base.analytics.PhotoFlowLogger;
import com.facebook.photos.upload.manager.DefaultUploadNotificationConfiguration;
import com.facebook.photos.upload.manager.UploadNotificationConfiguration;
import com.facebook.photos.upload.module.ImmediateRetryPolicyMethodAutoProvider;
import com.facebook.photos.upload.module.UploadNotificationConfigurationMethodAutoProvider;
import com.facebook.photos.upload.operation.UploadRecord;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.photos.upload.protocol.UploadPhotoParams;
import com.facebook.photos.upload.protocol.UploadPhotoSource;
import com.facebook.photos.upload.retry.ImmediateRetryPolicy;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader;
import com.facebook.photos.upload.uploaders.DirectPhotoUploader.DirectUploadListener;
import com.facebook.photos.upload.uploaders.MediaUploadCancelHandler;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: {page_id} */
public class GoodwillPublishUploadHandler implements BlueServiceHandler {
    private final Provider<SingleMethodRunner> f167a;
    private final Lazy<PublishGoodwillVideoMethod> f168b;
    private final Lazy<PublishGoodwillLifeEventMethod> f169c;
    private final Lazy<PublishFriendversaryCollageMethod> f170d;
    private final DirectPhotoUploader f171e;
    private final DefaultBlueServiceOperationFactory f172f;
    private final DefaultPhotoFlowLogger f173g;
    private final ImmediateRetryPolicy f174h;
    private final NotificationManager f175i;
    private final DefaultUploadNotificationConfiguration f176j;
    public final AbstractFbErrorReporter f177k;
    private final ExecutorService f178l;
    public final Builder f179m;

    /* compiled from: {page_id} */
    public abstract class UploadStatusCallback implements Parcelable {
        public abstract void mo1a();

        public abstract void mo2b();

        protected UploadStatusCallback(Parcel parcel) {
            if (parcel != null) {
                parcel.readInt();
            }
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(1);
        }

        public int describeContents() {
            return 0;
        }
    }

    public static GoodwillPublishUploadHandler m167b(InjectorLike injectorLike) {
        return new GoodwillPublishUploadHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), IdBasedLazy.a(injectorLike, 6853), IdBasedLazy.a(injectorLike, 6852), IdBasedLazy.a(injectorLike, 6851), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DirectPhotoUploader.b(injectorLike), DefaultPhotoFlowLogger.b(injectorLike), NotificationManagerMethodAutoProvider.b(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), UploadNotificationConfigurationMethodAutoProvider.b(injectorLike), ImmediateRetryPolicyMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final OperationResult m168a(OperationParams operationParams) {
        String str = operationParams.b;
        Object obj = -1;
        switch (str.hashCode()) {
            case -688980690:
                if (str.equals("publish_goodwill_friendversary_collage")) {
                    obj = 2;
                    break;
                }
                break;
            case -644076677:
                if (str.equals("publish_goodwill_video")) {
                    obj = null;
                    break;
                }
                break;
            case 696754327:
                if (str.equals("publish_goodwill_life_event")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                return m162a(operationParams, (ApiMethod) this.f168b.get());
            case 1:
                return m162a(operationParams, (ApiMethod) this.f169c.get());
            case 2:
                return m162a(operationParams, (ApiMethod) this.f170d.get());
            default:
                throw new IllegalArgumentException("unknown operation type: " + str);
        }
    }

    private OperationResult m162a(OperationParams operationParams, ApiMethod apiMethod) {
        Bundle bundle = operationParams.c;
        if (bundle == null) {
            return OperationResult.a(ErrorCode.API_ERROR);
        }
        GoodwillPublishNotificationConfig goodwillPublishNotificationConfig = (GoodwillPublishNotificationConfig) bundle.getParcelable("request_notification");
        UploadStatusCallback uploadStatusCallback = (UploadStatusCallback) bundle.getParcelable("request_callback");
        Parcelable parcelable = bundle.getParcelable("request_params");
        List parcelableArrayList = bundle.getParcelableArrayList("request_photos");
        String string = bundle.getString("request_privacy");
        String string2 = bundle.getString("request_composer_session_id");
        if (!(parcelableArrayList == null || parcelableArrayList.isEmpty())) {
            m166a(parcelableArrayList, string, string2);
        }
        ((AbstractSingleMethodRunner) this.f167a.get()).a(apiMethod, parcelable, CallerContext.a(getClass()));
        m165a(this, this.f179m, goodwillPublishNotificationConfig, true);
        if (uploadStatusCallback != null) {
            uploadStatusCallback.mo1a();
        }
        return OperationResult.a;
    }

    @Inject
    public GoodwillPublishUploadHandler(Provider<SingleMethodRunner> provider, Lazy<PublishGoodwillVideoMethod> lazy, Lazy<PublishGoodwillLifeEventMethod> lazy2, Lazy<PublishFriendversaryCollageMethod> lazy3, ExecutorService executorService, DirectPhotoUploader directPhotoUploader, PhotoFlowLogger photoFlowLogger, NotificationManager notificationManager, BlueServiceOperationFactory blueServiceOperationFactory, UploadNotificationConfiguration uploadNotificationConfiguration, ImmediateRetryPolicy immediateRetryPolicy, FbErrorReporter fbErrorReporter, Context context) {
        this.f167a = provider;
        this.f168b = lazy;
        this.f169c = lazy2;
        this.f170d = lazy3;
        this.f178l = executorService;
        this.f171e = directPhotoUploader;
        this.f173g = photoFlowLogger;
        this.f175i = notificationManager;
        this.f172f = blueServiceOperationFactory;
        this.f176j = uploadNotificationConfiguration;
        this.f174h = immediateRetryPolicy;
        this.f177k = fbErrorReporter;
        this.f179m = new Builder(context);
    }

    public final void m171a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ImmutableList<Long> immutableList, ImmutableList<GoodwillPublishPhoto> immutableList2, String str9, GoodwillPublishNotificationConfig goodwillPublishNotificationConfig, UploadStatusCallback uploadStatusCallback) {
        Parcelable publishGoodwillVideoParams = new PublishGoodwillVideoParams(str, str2, str3, str4, str5, str6, str7, str8, immutableList, immutableList2, str9);
        Bundle bundle = new Bundle();
        bundle.putParcelable("request_params", publishGoodwillVideoParams);
        bundle.putString("request_privacy", str6);
        bundle.putString("request_composer_session_id", str8);
        if (immutableList2 != null) {
            bundle.putParcelableArrayList("request_photos", new ArrayList(immutableList2));
        }
        m164a(bundle, "publish_goodwill_video", goodwillPublishNotificationConfig, uploadStatusCallback);
    }

    public final void m169a(Context context, PublishPostParams publishPostParams, String str, ImmutableList<GoodwillPublishPhoto> immutableList, GoodwillPublishNotificationConfig goodwillPublishNotificationConfig, UploadStatusCallback uploadStatusCallback) {
        Bundle bundle = new Bundle();
        GoodwillPublishLifeEventParam.Builder builder = new GoodwillPublishLifeEventParam.Builder();
        builder.f143a = publishPostParams.tracking;
        builder = builder;
        builder.f147e = publishPostParams.rawMessage;
        builder = builder;
        builder.f144b = publishPostParams.privacy;
        builder = builder;
        builder.f145c = publishPostParams.composerSessionId;
        builder = builder;
        builder.f146d = immutableList;
        builder = builder;
        builder.f148f = str;
        bundle.putParcelable("request_params", new GoodwillPublishLifeEventParam(builder));
        bundle.putString("request_privacy", publishPostParams.privacy);
        bundle.putString("request_composer_session_id", publishPostParams.composerSessionId);
        bundle.putParcelableArrayList("request_photos", new ArrayList(immutableList));
        m164a(bundle, "publish_goodwill_life_event", goodwillPublishNotificationConfig, uploadStatusCallback);
    }

    public final void m170a(Context context, String str, String str2, PublishPostParams publishPostParams, ImmutableList<GoodwillPublishPhoto> immutableList, GoodwillPublishNotificationConfig goodwillPublishNotificationConfig, UploadStatusCallback uploadStatusCallback) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("request_params", new PublishFriendversaryCollageParams(str, str2, publishPostParams, immutableList));
        bundle.putString("request_privacy", publishPostParams.privacy);
        bundle.putString("request_composer_session_id", publishPostParams.composerSessionId);
        bundle.putParcelableArrayList("request_photos", new ArrayList(immutableList));
        m164a(bundle, "publish_goodwill_friendversary_collage", goodwillPublishNotificationConfig, uploadStatusCallback);
    }

    private void m164a(Bundle bundle, final String str, final GoodwillPublishNotificationConfig goodwillPublishNotificationConfig, final UploadStatusCallback uploadStatusCallback) {
        if (goodwillPublishNotificationConfig != null) {
            bundle.putParcelable("request_notification", goodwillPublishNotificationConfig);
            this.f179m.a(0, 0, true).a(goodwillPublishNotificationConfig.f155a).a(this.f176j.a()).a(true);
            this.f175i.notify(32642, this.f179m.c());
        }
        bundle.putParcelable("request_callback", uploadStatusCallback);
        Futures.a(BlueServiceOperationFactoryDetour.a(this.f172f, str, bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(GoodwillPublishUploadHandler.class), 852443734).a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ GoodwillPublishUploadHandler f164d;

            protected final void m159a(ServiceException serviceException) {
                ErrorCode errorCode = serviceException.errorCode;
                if (errorCode != ErrorCode.NO_ERROR && errorCode != ErrorCode.ORCA_SERVICE_IPC_FAILURE) {
                    GoodwillPublishUploadHandler.m165a(this.f164d, this.f164d.f179m, goodwillPublishNotificationConfig, false);
                    this.f164d.f177k.a("GoodwillPublishUpload", "Failed to publish goodwill event of type " + str, serviceException.getCause());
                    if (uploadStatusCallback != null) {
                        uploadStatusCallback.mo2b();
                    }
                }
            }
        }, this.f178l);
    }

    public static void m165a(GoodwillPublishUploadHandler goodwillPublishUploadHandler, Builder builder, GoodwillPublishNotificationConfig goodwillPublishNotificationConfig, boolean z) {
        if (goodwillPublishNotificationConfig != null && builder != null) {
            CharSequence charSequence;
            if (z) {
                charSequence = goodwillPublishNotificationConfig.f156b;
            } else {
                Object obj = goodwillPublishNotificationConfig.f157c;
            }
            builder.a(0, 0, false).a(goodwillPublishNotificationConfig.f155a).a(z ? goodwillPublishUploadHandler.f176j.c() : 17301624).a(false).b(charSequence);
            goodwillPublishUploadHandler.f175i.notify(32642, builder.c());
        }
    }

    private static String m163a(String str) {
        if (str.startsWith("file://")) {
            return str.substring(7);
        }
        return str;
    }

    private void m166a(List<GoodwillPublishPhoto> list, String str, String str2) {
        Collection hashSet = new HashSet();
        for (GoodwillPublishPhoto goodwillPublishPhoto : list) {
            if (goodwillPublishPhoto.f160c) {
                long j = 0;
                if (goodwillPublishPhoto.f158a != null) {
                    j = Long.parseLong(goodwillPublishPhoto.f158a);
                }
                UploadPhotoParams.Builder builder = new UploadPhotoParams.Builder(new UploadPhotoSource(m163a(goodwillPublishPhoto.f159b), j));
                builder.j = new PhotoUploadPrivacy(str);
                hashSet.add(builder.a());
            }
        }
        if (!hashSet.isEmpty()) {
            this.f173g.a(str2);
            final HashMap hashMap = new HashMap();
            this.f171e.a(hashSet, new DirectUploadListener(this) {
                final /* synthetic */ GoodwillPublishUploadHandler f166b;

                public final void m161a(UploadPhotoParams uploadPhotoParams, UploadRecord uploadRecord) {
                    hashMap.put("file://" + uploadPhotoParams.d(), String.valueOf(uploadRecord.fbid));
                }
            }, new MediaUploadCancelHandler(), this.f173g, this.f173g.j("2.0"), null, this.f174h);
            for (GoodwillPublishPhoto goodwillPublishPhoto2 : list) {
                if (goodwillPublishPhoto2.f160c) {
                    String str3 = (String) hashMap.get(goodwillPublishPhoto2.f159b);
                    if (str3 != null) {
                        goodwillPublishPhoto2.f158a = str3;
                        goodwillPublishPhoto2.f160c = false;
                    }
                }
            }
        }
    }
}
