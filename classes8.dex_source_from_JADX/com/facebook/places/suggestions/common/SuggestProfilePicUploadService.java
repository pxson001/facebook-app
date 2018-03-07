package com.facebook.places.suggestions.common;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.IBinder;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.media.PhotoItem;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.HashMap;
import javax.inject.Provider;

/* compiled from: search_sid */
public class SuggestProfilePicUploadService extends FbIntentService {
    HashMap<Integer, UploadPictureView> f3808a = Maps.c();
    int f3809b = 0;
    public DefaultAndroidThreadUtil f3810c;
    private AbstractSingleMethodRunner f3811d;
    private Provider<SuggestProfilePicMethod> f3812e;
    private Provider<UploadPictureView> f3813f;

    public SuggestProfilePicUploadService() {
        super("SuggestedPicUploadService");
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    protected final void m3679a(Intent intent) {
        boolean z = true;
        int intExtra = intent.getIntExtra("start_id", -1);
        CrowdsourcingSource crowdsourcingSource = (CrowdsourcingSource) intent.getSerializableExtra("source");
        CrowdEntryPoint crowdEntryPoint = (CrowdEntryPoint) intent.getSerializableExtra("entry_point");
        CrowdEndpoint crowdEndpoint = (CrowdEndpoint) intent.getSerializableExtra("endpoint");
        Preconditions.checkArgument(intExtra != -1);
        final UploadPictureView uploadPictureView = (UploadPictureView) this.f3808a.remove(Integer.valueOf(intExtra));
        Preconditions.checkNotNull(uploadPictureView);
        long longExtra = intent.getLongExtra("page_id", -1);
        if (longExtra <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        PhotoItem photoItem = (PhotoItem) Preconditions.checkNotNull(intent.getParcelableExtra("photo_item"));
        SuggestProfilePicMethod suggestProfilePicMethod = (SuggestProfilePicMethod) this.f3812e.get();
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        apiMethodRunnerParams.a(new Object(this) {
            int f3803a;
            final /* synthetic */ SuggestProfilePicUploadService f3805c;

            public void run() {
                uploadPictureView.m3682a(this.f3803a);
            }

            public final void m3677a(long j, long j2) {
                int i = (int) ((100 * j) / j2);
                if (i != this.f3803a) {
                    this.f3803a = i;
                    this.f3805c.f3810c.a(this);
                }
            }
        });
        try {
            this.f3811d.a(suggestProfilePicMethod, new SuggestProfilePicParams(longExtra, photoItem, crowdsourcingSource, crowdEntryPoint, crowdEndpoint), apiMethodRunnerParams);
            this.f3810c.a(new Runnable(this) {
                final /* synthetic */ SuggestProfilePicUploadService f3802b;

                public void run() {
                    uploadPictureView.m3683b();
                }
            });
        } catch (Exception e) {
            this.f3810c.a(new Runnable(this) {
                final /* synthetic */ SuggestProfilePicUploadService f3807b;

                public void run() {
                    uploadPictureView.m3684c();
                }
            });
        }
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, 2092809597);
        super.onCreate();
        this.f3810c = DefaultAndroidThreadUtil.b(a());
        this.f3811d = (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(a());
        this.f3812e = IdBasedProvider.a(a(), 9579);
        this.f3813f = IdBasedProvider.a(a(), 9580);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1165265674, a);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -608851926);
        intent.putExtra("start_id", i2);
        UploadPictureView uploadPictureView = (UploadPictureView) this.f3813f.get();
        uploadPictureView.f3818e = PendingIntent.getService(this, i2, intent, 0);
        uploadPictureView.m3681a();
        this.f3808a.put(Integer.valueOf(i2), uploadPictureView);
        super.onStartCommand(intent, i, i2);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, 1276166964, a);
        return 2;
    }
}
