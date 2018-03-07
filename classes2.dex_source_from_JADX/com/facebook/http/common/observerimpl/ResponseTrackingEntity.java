package com.facebook.http.common.observerimpl;

import com.facebook.http.engine.ReportingInputStream;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import java.io.InputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* compiled from: mId= */
public class ResponseTrackingEntity extends HttpEntityWrapper {
    public final HttpFlowState f15546a;
    private ReportingInputStream f15547b;

    /* compiled from: mId= */
    public class ResponseEofTracker {
        public final /* synthetic */ ResponseTrackingEntity f15565a;

        public ResponseEofTracker(ResponseTrackingEntity responseTrackingEntity) {
            this.f15565a = responseTrackingEntity;
        }
    }

    public ResponseTrackingEntity(HttpFlowState httpFlowState, HttpEntity httpEntity) {
        super(httpEntity);
        this.f15546a = httpFlowState;
    }

    public boolean isRepeatable() {
        Preconditions.checkState(!super.isRepeatable(), "Expected underlying entity to also not be repeatable");
        return false;
    }

    public InputStream getContent() {
        if (this.f15547b == null) {
            this.f15547b = new ReportingInputStream(new EofTrackingInputStream(this.f15546a.m17710a(super.getContent()), new ResponseEofTracker(this)), this.f15546a.f12016c.bytesReadByApp);
        }
        return this.f15547b;
    }

    public void consumeContent() {
        try {
            if (!this.f15546a.m17713a()) {
                m22185a();
            }
            super.consumeContent();
        } catch (Throwable th) {
            super.consumeContent();
        }
    }

    private void m22185a() {
        InputStream content = getContent();
        try {
            ByteStreams.a(content, ByteStreams.a());
        } finally {
            content.close();
        }
    }
}
