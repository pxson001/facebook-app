package com.facebook.analytics2.uploader.fbhttp;

import android.content.Context;
import com.facebook.analytics.webmethod.SendAnalyticLogsParams;
import com.facebook.analytics2.logger.BatchPayload;
import com.facebook.analytics2.logger.UploadJob;
import com.facebook.analytics2.logger.UploadJob$Priority;
import com.facebook.analytics2.logger.UploadJob.Tier;
import com.facebook.analytics2.logger.UploadProcessor.UploadProcessorUploaderCallback;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.ApiMethodRunnerParams.HttpConfig;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.InjectorLike;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.base.Throwables;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.inject.Provider;

/* compiled from: tap_share */
public class FbHttpUploader implements InjectableComponentWithoutContext {
    public AbstractSingleMethodRunner f3193a;
    public Provider<Boolean> f3194b;

    public static void m5362a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        FbHttpUploader fbHttpUploader = (FbHttpUploader) obj;
        AbstractSingleMethodRunner a = SingleMethodRunnerImpl.m11724a(injectorLike);
        Provider a2 = IdBasedProvider.m1811a(injectorLike, 3887);
        fbHttpUploader.f3193a = a;
        fbHttpUploader.f3194b = a2;
    }

    public FbHttpUploader(Context context) {
        Class cls = FbHttpUploader.class;
        m5362a((Object) this, context);
    }

    public final void m5363a(UploadJob uploadJob, UploadProcessorUploaderCallback uploadProcessorUploaderCallback) {
        ApiMethodRunnerParams apiMethodRunnerParams = new ApiMethodRunnerParams();
        if (uploadJob.b() == Tier.BOOTSTRAP) {
            apiMethodRunnerParams.m12149a(HttpConfig.BOOTSTRAP);
        }
        apiMethodRunnerParams.m12147a(m5360a(uploadJob.a()));
        BatchPayload c = uploadJob.c();
        try {
            ResponseForwardingSendAnalyticLogsMethod responseForwardingSendAnalyticLogsMethod = new ResponseForwardingSendAnalyticLogsMethod(uploadProcessorUploaderCallback);
            if (!((Boolean) this.f3194b.get()).booleanValue()) {
                m5361a(this.f3193a, responseForwardingSendAnalyticLogsMethod, m5359a(c), apiMethodRunnerParams);
            }
        } catch (IOException e) {
            uploadProcessorUploaderCallback.a(e);
        }
    }

    private static <REQUEST, RESPONSE> void m5361a(SingleMethodRunner singleMethodRunner, ApiMethod<REQUEST, RESPONSE> apiMethod, REQUEST request, ApiMethodRunnerParams apiMethodRunnerParams) {
        try {
            singleMethodRunner.m11745a((ApiMethod) apiMethod, (Object) request, apiMethodRunnerParams);
        } catch (IOException e) {
            throw e;
        } catch (Throwable e2) {
            Throwables.propagateIfPossible(e2);
            IOException iOException = new IOException();
            iOException.initCause(e2);
            throw iOException;
        }
    }

    private static SendAnalyticLogsParams m5359a(BatchPayload batchPayload) {
        Writer stringWriter = new StringWriter(batchPayload.a());
        try {
            batchPayload.a(stringWriter);
            SendAnalyticLogsParams sendAnalyticLogsParams = new SendAnalyticLogsParams(stringWriter.toString(), batchPayload.b());
            return sendAnalyticLogsParams;
        } finally {
            stringWriter.close();
        }
    }

    private static RequestPriority m5360a(UploadJob$Priority uploadJob$Priority) {
        switch (1.a[uploadJob$Priority.ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return RequestPriority.NON_INTERACTIVE;
            default:
                return RequestPriority.CAN_WAIT;
        }
    }
}
