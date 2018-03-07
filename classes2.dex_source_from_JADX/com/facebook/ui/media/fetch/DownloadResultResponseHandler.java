package com.facebook.ui.media.fetch;

import com.facebook.cdn.handler.CdnHeaderResponse;
import java.io.InputStream;

/* compiled from: measurement.service_client.idle_disconnect_millis */
public interface DownloadResultResponseHandler<T> {
    T mo2824a(InputStream inputStream, long j, CdnHeaderResponse cdnHeaderResponse);
}
