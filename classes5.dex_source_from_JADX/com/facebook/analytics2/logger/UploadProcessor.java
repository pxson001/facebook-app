package com.facebook.analytics2.logger;

import com.facebook.analytics.NewAnalyticsSamplingPolicyConfig;
import com.facebook.analytics2.logger.UploadJob.Priority;
import com.facebook.analytics2.logger.UploadJob.Tier;
import com.facebook.analytics2.uploader.fbhttp.FbHttpUploader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.apache.http.client.HttpResponseException;

/* compiled from: terrain */
public class UploadProcessor {
    private final FbHttpUploader f2069a;
    private final Priority f2070b;
    private final Iterator<BatchPayloadInternal> f2071c;
    private final UploadProcessorCallback f2072d;
    @Nullable
    private final NewAnalyticsSamplingPolicyConfig f2073e;

    /* compiled from: terrain */
    public class UploadProcessorUploaderCallback {
        private final BatchPayloadInternal f2066a;
        @Nullable
        private final NewAnalyticsSamplingPolicyConfig f2067b;
        private final UploadProcessorCallback f2068c;

        public UploadProcessorUploaderCallback(BatchPayloadInternal batchPayloadInternal, @Nullable NewAnalyticsSamplingPolicyConfig newAnalyticsSamplingPolicyConfig, UploadProcessorCallback uploadProcessorCallback) {
            this.f2066a = batchPayloadInternal;
            this.f2067b = newAnalyticsSamplingPolicyConfig;
            this.f2068c = uploadProcessorCallback;
        }

        public final void m2776a(IOException iOException) {
            if (this.f2066a.mo492d()) {
                this.f2066a.mo491c();
            }
            this.f2068c.mo502a(iOException);
        }

        public final void m2775a(int i, InputStream inputStream) {
            if (i != 200) {
                try {
                    throw new HttpResponseException(i, "Unexpected HTTP code " + i);
                } catch (IOException e) {
                    this.f2068c.mo502a(e);
                } finally {
                    this.f2066a.mo491c();
                    inputStream.close();
                }
            } else {
                if (this.f2067b != null) {
                    this.f2067b.a(inputStream);
                }
                this.f2066a.mo493e();
                this.f2068c.mo501a();
                this.f2066a.mo491c();
                inputStream.close();
            }
        }
    }

    public UploadProcessor(Uploader uploader, Priority priority, Iterator<BatchPayloadInternal> it, UploadProcessorCallback uploadProcessorCallback, @Nullable SamplingPolicyConfig samplingPolicyConfig) {
        this.f2069a = uploader;
        this.f2070b = priority;
        this.f2071c = it;
        this.f2072d = uploadProcessorCallback;
        this.f2073e = samplingPolicyConfig;
        if (this.f2071c == null) {
            throw new IllegalArgumentException("mBatchPayloadIterator is null");
        }
    }

    public final boolean m2777a() {
        return this.f2071c.hasNext();
    }

    public final void m2778b() {
        if (m2777a()) {
            BatchPayloadInternal batchPayloadInternal = (BatchPayloadInternal) this.f2071c.next();
            this.f2069a.a(new UploadJob(this.f2070b, Tier.DEFAULT, batchPayloadInternal), new UploadProcessorUploaderCallback(batchPayloadInternal, this.f2073e, this.f2072d));
            return;
        }
        throw new IllegalStateException("No more batches to upload");
    }
}
