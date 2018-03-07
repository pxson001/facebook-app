package com.facebook.ui.images.fetch;

import android.net.Uri;
import com.facebook.performancelogger.MarkerConfig;
import com.facebook.performancelogger.SequenceTrackingLoggerHelper;
import java.util.List;

/* compiled from: secondary_fields */
public class FetchImagePerfLogger$AllUrlsForImage {
    final /* synthetic */ FetchImagePerfLogger f5111a;
    public Uri f5112b;
    public List<Uri> f5113c;
    public MarkerConfig f5114d;
    public MarkerConfig f5115e;
    public SequenceTrackingLoggerHelper f5116f;

    public FetchImagePerfLogger$AllUrlsForImage(FetchImagePerfLogger fetchImagePerfLogger, Uri uri, List<Uri> list) {
        this.f5111a = fetchImagePerfLogger;
        this.f5112b = uri;
        this.f5113c = list;
        this.f5116f = new SequenceTrackingLoggerHelper(fetchImagePerfLogger.b, fetchImagePerfLogger.a);
    }

    public final MarkerConfig m7870a(int i, String str, String str2) {
        MarkerConfig a = this.f5116f.m4422a(i, str);
        a.l.put("uri_key", str2);
        return a;
    }
}
