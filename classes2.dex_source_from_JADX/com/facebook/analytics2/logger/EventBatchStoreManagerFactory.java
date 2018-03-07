package com.facebook.analytics2.logger;

import android.content.Context;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02003;
import com.facebook.crudolib.params.ParamsCollectionPool;
import java.io.File;

/* compiled from: tab_root_intent */
public class EventBatchStoreManagerFactory {
    public final Context f3354a;
    private final int f3355b;
    private final String f3356c;
    public final MaxEventsPerBatchProvider f3357d;
    public final MaxEventsPerBatchProvider f3358e;
    public final BatchFixedMetadataHelper f3359f;
    public final ParamsCollectionPool f3360g;
    public final CommonUploadSchedulerParams f3361h;
    private final C02003 f3362i;
    private final Class<? extends HandlerThreadFactory> f3363j;
    private final UploadSchedulerParamsProvider f3364k;

    public EventBatchStoreManagerFactory(Context context, int i, String str, MaxEventsPerBatchProvider maxEventsPerBatchProvider, MaxEventsPerBatchProvider maxEventsPerBatchProvider2, BatchFixedMetadataHelper batchFixedMetadataHelper, ParamsCollectionPool paramsCollectionPool, CommonUploadSchedulerParams commonUploadSchedulerParams, AppBackgroundedProvider appBackgroundedProvider, Class<? extends HandlerThreadFactory> cls, UploadSchedulerParamsProvider uploadSchedulerParamsProvider) {
        this.f3354a = context;
        this.f3357d = maxEventsPerBatchProvider;
        this.f3358e = maxEventsPerBatchProvider2;
        this.f3359f = batchFixedMetadataHelper;
        this.f3360g = paramsCollectionPool;
        this.f3362i = appBackgroundedProvider;
        this.f3363j = cls;
        this.f3361h = commonUploadSchedulerParams;
        this.f3355b = i;
        this.f3356c = str;
        this.f3364k = uploadSchedulerParamsProvider;
    }

    public final EventBatchStoreManager m5565a() {
        BatchLockState a = BatchLockState.m5595a(!UploadServiceProcessUtil.m5586a(this.f3354a).m5590a());
        File file = new File(this.f3354a.getDir("analytics", 0), this.f3356c);
        return new EventBatchStoreManager(new EventBatchFileStore(this.f3357d.mo737a(), this.f3358e.mo737a(), this.f3359f, this.f3360g, BatchDirectoryStructure.m5617a(file), a), new UploadManager(this.f3354a, this.f3355b, new UploadJobConfig(file, this.f3361h), this.f3362i, this.f3363j, this.f3364k.mo738a(), this.f3364k.mo739b()));
    }
}
