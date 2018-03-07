package com.facebook.analytics2.logger;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.analytics.NewAnalyticsSamplingPolicyConfig;
import com.facebook.analytics2.logger.UploadJob.Priority;
import com.facebook.analytics2.uploader.fbhttp.FbHttpUploader;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.debug.log.BLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: the padding cannot be < 0 */
public class InProcessUploadBatchNotifier implements UploadBatchNotifier<ByteArrayOutputStream> {
    private static final long f2013a = TimeUnit.SECONDS.toMillis(60);
    private final Context f2014b;
    public final CommonUploadSchedulerParams f2015c;
    @Nullable
    public final NewAnalyticsSamplingPolicyConfig f2016d;
    private final HandlerThreadFactory f2017e;
    public final BatchDynamicMetadataHelper f2018f;
    @Nullable
    private UploadHandler f2019g;
    @Nullable
    private ByteArrayOutputStream f2020h;
    public final FbHttpUploader f2021i = ContextConstructorHelper.a(this.f2014b).c(this.f2015c.a.getName());
    private boolean f2022j;

    /* compiled from: the padding cannot be < 0 */
    public class InProcessUploadProcesserCallback implements UploadProcessorCallback {
        public final void mo501a() {
        }

        public final void mo502a(IOException iOException) {
            BLog.b("InProcessUploadScheduler", iOException, "Failed to upload batch, it will not be retried", new Object[0]);
        }
    }

    /* compiled from: the padding cannot be < 0 */
    public class UploadHandler extends Handler {
        public final /* synthetic */ InProcessUploadBatchNotifier f2012a;

        public UploadHandler(InProcessUploadBatchNotifier inProcessUploadBatchNotifier, Looper looper) {
            this.f2012a = inProcessUploadBatchNotifier;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    UploadProcessor uploadProcessor = new UploadProcessor(this.f2012a.f2021i, this.f2012a.f2015c.d, Collections.singletonList(new MemoryBatchPayload((ByteArrayOutputStream) message.obj, this.f2012a.f2018f)).iterator(), new InProcessUploadProcesserCallback(), this.f2012a.f2016d);
                    while (uploadProcessor.m2777a()) {
                        uploadProcessor.m2778b();
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown what=" + message.what);
            }
        }

        public final void m2714a(ByteArrayOutputStream byteArrayOutputStream) {
            removeMessages(1, byteArrayOutputStream);
            sendMessage(obtainMessage(1, byteArrayOutputStream));
        }
    }

    public final void m2718a(@Nullable Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) obj;
        if (this.f2020h != byteArrayOutputStream) {
            this.f2020h = byteArrayOutputStream;
            this.f2022j = false;
        }
    }

    public InProcessUploadBatchNotifier(Context context, ParamsCollectionPool paramsCollectionPool, CommonUploadSchedulerParams commonUploadSchedulerParams) {
        this.f2014b = context;
        this.f2015c = commonUploadSchedulerParams;
        this.f2016d = this.f2015c.b == null ? null : ContextConstructorHelper.a(this.f2014b).a(this.f2015c.b.getName());
        this.f2017e = ContextConstructorHelper.a(this.f2014b).b(this.f2015c.c.getName());
        this.f2018f = new BatchDynamicMetadataHelper(this.f2014b, paramsCollectionPool, this.f2015c.e, this.f2016d);
    }

    public final void m2717a() {
        m2715c();
        if (!this.f2022j) {
            this.f2022j = true;
            UploadHandler d = m2716d();
            ByteArrayOutputStream byteArrayOutputStream = this.f2020h;
            d.sendMessageDelayed(d.obtainMessage(1, byteArrayOutputStream), f2013a);
        }
    }

    public final void m2720b() {
        m2715c();
        m2716d().m2714a(this.f2020h);
    }

    private void m2715c() {
        if (this.f2020h == null) {
            throw new IllegalStateException("mByteArrayOutputStream is null");
        }
    }

    public final void m2719a(@Nullable String str) {
        if (this.f2020h != null) {
            m2716d().m2714a(this.f2020h);
        }
    }

    private UploadHandler m2716d() {
        if (this.f2019g == null) {
            int i;
            String str;
            if (this.f2015c.d == Priority.HIGH) {
                i = 0;
                str = "Analytics-HighPri-InMemory-Scheduler";
            } else {
                i = 10;
                str = "Analytics-NormalPri-InMemory-Scheduler";
            }
            HandlerThread a = this.f2017e.a(str, i);
            a.start();
            this.f2019g = new UploadHandler(this, a.getLooper());
        }
        return this.f2019g;
    }
}
