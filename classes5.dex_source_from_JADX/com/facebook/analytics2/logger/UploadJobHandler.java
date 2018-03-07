package com.facebook.analytics2.logger;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.analytics.NewAnalyticsSamplingPolicyConfig;
import com.facebook.analytics2.uploader.fbhttp.FbHttpUploader;
import com.facebook.common.filelite.DeleteUtils;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.debug.log.BLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: text/vnd.android.intent */
public class UploadJobHandler extends Handler {
    private static final ParamsCollectionPool f2046a = ParamsCollectionPool.a();
    private final UploadJobHandlerCallback f2047b;
    private final Context f2048c;
    public final InvocationParams f2049d;
    public final SimpleArrayMap<String, File> f2050e = new SimpleArrayMap(2);
    private boolean f2051f;
    @Nullable
    private UploadProcessor f2052g;
    @Nullable
    private FileBatchPayloadIterator f2053h;
    public boolean f2054i;
    private final C01341 f2055j = new C01341(this);

    /* compiled from: text/vnd.android.intent */
    public class C01341 {
        final /* synthetic */ UploadJobHandler f2040a;

        C01341(UploadJobHandler uploadJobHandler) {
            this.f2040a = uploadJobHandler;
        }

        public final void m2743a(File file, @Nullable File file2) {
            this.f2040a.f2050e.put(file.getName(), file2);
        }
    }

    /* compiled from: text/vnd.android.intent */
    class FileUploadProcessorCallback implements UploadProcessorCallback {
        final /* synthetic */ UploadJobHandler f2041a;

        public FileUploadProcessorCallback(UploadJobHandler uploadJobHandler) {
            this.f2041a = uploadJobHandler;
        }

        public final void mo501a() {
            this.f2041a.m2759b();
        }

        public final void mo502a(IOException iOException) {
            UploadJobHandler uploadJobHandler = this.f2041a;
            uploadJobHandler.sendMessage(uploadJobHandler.obtainMessage(5, iOException));
        }
    }

    /* compiled from: text/vnd.android.intent */
    public class InvocationParams {
        public final int f2042a;
        public final UploadJobConfig f2043b;
        @Nullable
        public final String f2044c;
        @Nullable
        public final String f2045d;

        public static InvocationParams m2746a(int i, UploadJobConfig uploadJobConfig, String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("startServiceHackAction cannot be null for logout");
            } else if (str2 != null) {
                return new InvocationParams(i, uploadJobConfig, str, str2);
            } else {
                throw new IllegalArgumentException("userIdToDeleteOnExit cannot be null for logout");
            }
        }

        public InvocationParams(int i, UploadJobConfig uploadJobConfig, @Nullable String str, @Nullable String str2) {
            this.f2042a = i;
            this.f2043b = uploadJobConfig;
            this.f2044c = str;
            this.f2045d = str2;
        }
    }

    /* compiled from: text/vnd.android.intent */
    public interface UploadJobHandlerCallback {
        void mo503a();

        void mo504a(boolean z);
    }

    UploadJobHandler(Context context, Looper looper, InvocationParams invocationParams, UploadJobHandlerCallback uploadJobHandlerCallback) {
        super(looper);
        this.f2048c = context;
        this.f2049d = invocationParams;
        this.f2047b = uploadJobHandlerCallback;
    }

    public void handleMessage(Message message) {
        if (!this.f2054i) {
            switch (message.what) {
                case 1:
                    m2753d();
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                    m2754e();
                    return;
                case 3:
                    Integer.valueOf(this.f2049d.f2042a);
                    this.f2054i = true;
                    m2756h();
                    return;
                case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                    m2755g();
                    m2756h();
                    return;
                case 5:
                    m2752b((IOException) message.obj);
                    m2756h();
                    return;
                default:
                    throw new IllegalArgumentException("Unknown what=" + message.what);
            }
        }
    }

    private void m2753d() {
        TraceCompatDetour.a("doInit", 1123023390);
        try {
            UploadJobConfig uploadJobConfig = this.f2049d.f2043b;
            Integer.valueOf(this.f2049d.f2042a);
            FbHttpUploader c = ContextConstructorHelper.a(this.f2048c).c(this.f2049d.f2043b.a());
            if (c != null) {
                NewAnalyticsSamplingPolicyConfig a = m2749a(uploadJobConfig.b(), this.f2048c);
                this.f2053h = FileBatchPayloadIteratorFactory.m2703a(uploadJobConfig.d(), new BatchDynamicMetadataHelper(this.f2048c, f2046a, uploadJobConfig.f(), a), this.f2055j);
                this.f2052g = new UploadProcessor(c, uploadJobConfig.e(), this.f2053h, new FileUploadProcessorCallback(this), a);
                this.f2053h.hasNext();
                m2759b();
                TraceCompatDetour.a(-1642902002);
            }
        } finally {
            TraceCompatDetour.a(-1159978796);
        }
    }

    @Nullable
    private static NewAnalyticsSamplingPolicyConfig m2749a(@Nullable String str, Context context) {
        if (str != null) {
            return ContextConstructorHelper.a(context).a(str);
        }
        return null;
    }

    private void m2754e() {
        TraceCompatDetour.a("doMaybeUploadNext", -701265174);
        try {
            UploadProcessor uploadProcessor = (UploadProcessor) Assertions.a(this.f2052g);
            if (uploadProcessor.m2777a()) {
                uploadProcessor.m2778b();
            } else {
                m2757i();
            }
            TraceCompatDetour.a(-916903955);
        } catch (Throwable th) {
            TraceCompatDetour.a(635839430);
        }
    }

    private void m2755g() {
        TraceCompatDetour.a("doNoMoreInput", 626505273);
        try {
            Integer.valueOf(this.f2049d.f2042a);
            Integer.valueOf(((FileBatchPayloadIterator) Assertions.a(this.f2053h)).m2702a());
            m2751a(false);
        } finally {
            TraceCompatDetour.a(1604469250);
        }
    }

    private void m2752b(IOException iOException) {
        TraceCompatDetour.a("doUploadFailure", -1137491638);
        try {
            if (BLog.b(3)) {
                Integer.valueOf(this.f2049d.f2042a);
                Integer.valueOf(((FileBatchPayloadIterator) Assertions.a(this.f2053h)).m2702a());
                iOException.toString();
            }
            m2751a(this.f2049d.f2045d == null);
        } finally {
            TraceCompatDetour.a(1550439022);
        }
    }

    private void m2751a(boolean z) {
        if (z) {
            this.f2051f = true;
        }
        this.f2047b.mo504a(z);
    }

    private void m2756h() {
        TraceCompatDetour.a("exitStateMachine", 1059327494);
        try {
            if (this.f2049d.f2045d != null) {
                m2750a(this.f2049d.f2043b.d(), this.f2049d.f2045d);
            }
            UploadServiceBus.a(this.f2048c, this.f2049d.f2042a, this.f2049d.f2044c, this.f2051f, this.f2050e);
            this.f2047b.mo503a();
            getLooper().quit();
        } finally {
            TraceCompatDetour.a(1247028944);
        }
    }

    public final void m2758a() {
        sendMessage(obtainMessage(1));
    }

    public final void m2759b() {
        sendMessage(obtainMessage(2));
    }

    public final void m2760c() {
        sendMessageAtFrontOfQueue(obtainMessage(3));
    }

    private void m2757i() {
        sendMessage(obtainMessage(4));
    }

    private static void m2750a(File file, String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    File[] listFiles2 = file2.listFiles();
                    if (listFiles2 != null) {
                        for (File file3 : listFiles2) {
                            if (file3.getName().equals(str)) {
                                arrayList.add(file3);
                            }
                        }
                    }
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            DeleteUtils.m3693a((File) it.next());
        }
    }
}
