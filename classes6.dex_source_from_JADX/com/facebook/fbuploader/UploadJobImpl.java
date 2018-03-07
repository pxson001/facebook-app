package com.facebook.fbuploader;

import com.facebook.fbuploader.fbcommon.DefaultHttpRequestExecutor;
import com.instagram.common.json.annotation.JsonType;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: network_not_connected */
public final class UploadJobImpl {
    public final Content f10072a;
    private final Config f10073b;
    public final DefaultHttpRequestExecutor f10074c;
    private final String f10075d = this.f10072a.m15743e();
    private final String f10076e = ("https://rupload.facebook.com/" + this.f10073b.m15736c() + "/" + this.f10075d);
    public Listener f10077f;
    public int f10078g;
    public HttpRequestExecutor$HttpRequestHandle f10079h;
    private URI f10080i;

    /* compiled from: network_not_connected */
    class C06071 extends HttpRequestExecutor$HttpRequestResponseHandler {
        final /* synthetic */ UploadJobImpl f10066a;

        C06071(UploadJobImpl uploadJobImpl) {
            this.f10066a = uploadJobImpl;
        }

        public final void mo1033a(String str) {
            UploadJobImpl.m15771a(this.f10066a, str);
        }

        public final void mo1032a(Exception exception, boolean z) {
            UploadJobImpl.m15772a(this.f10066a, "Failed GET request for fetching offset", exception, z);
        }

        public final void mo1031a() {
            UploadJobImpl.m15777e(this.f10066a);
        }
    }

    /* compiled from: network_not_connected */
    class C06082 extends HttpRequestExecutor$HttpRequestResponseHandler {
        final /* synthetic */ UploadJobImpl f10067a;

        C06082(UploadJobImpl uploadJobImpl) {
            this.f10067a = uploadJobImpl;
        }

        public final void mo1033a(String str) {
            UploadJobImpl.m15773b(this.f10067a, str);
        }

        public final void mo1032a(Exception exception, boolean z) {
            UploadJobImpl.m15772a(this.f10067a, "Failed to complete POST request", exception, z);
        }

        public final void mo1031a() {
            UploadJobImpl.m15777e(this.f10067a);
        }

        public final void mo1034a(int i) {
            UploadJobImpl uploadJobImpl = this.f10067a;
            uploadJobImpl.f10078g += i;
            uploadJobImpl.f10077f.mo1027a(((float) uploadJobImpl.f10078g) / ((float) uploadJobImpl.f10072a.f10050d));
        }
    }

    @JsonType
    /* compiled from: network_not_connected */
    public class OffsetResponse {
        public int f10069a = -1;
    }

    @JsonType
    /* compiled from: network_not_connected */
    public class UploadResponse {
        public String f10070a = null;
        public String f10071b = null;
    }

    public UploadJobImpl(Content content, Config config, Listener listener, DefaultHttpRequestExecutor defaultHttpRequestExecutor) {
        this.f10072a = content;
        this.f10073b = config;
        this.f10077f = listener;
        this.f10074c = defaultHttpRequestExecutor;
        try {
            this.f10080i = new URI(this.f10076e);
        } catch (URISyntaxException e) {
            this.f10080i = null;
        }
        this.f10079h = null;
        this.f10078g = 0;
    }

    public final void m15778a() {
        this.f10073b.f10046d.m15761c();
        m15776d();
        this.f10077f.mo1026a();
    }

    private void m15776d() {
        this.f10079h = this.f10074c.m15785a(HttpRequestExecutor$Method.GET, new HashMap(), this.f10080i, null, new C06071(this));
    }

    private void m15770a(int i) {
        this.f10078g = i;
        this.f10079h = this.f10074c.m15785a(HttpRequestExecutor$Method.POST, m15769a((long) i), this.f10080i, new HttpRequestExecutor$RequestBody(this.f10072a, (long) i), new C06082(this));
    }

    public static void m15771a(UploadJobImpl uploadJobImpl, String str) {
        try {
            uploadJobImpl.m15770a(m15774c(str));
        } catch (Exception e) {
            m15772a(uploadJobImpl, "Failed to parse offset from GET request response", e, true);
        }
    }

    public static void m15772a(UploadJobImpl uploadJobImpl, String str, Exception exception, boolean z) {
        if (z && uploadJobImpl.f10073b.m15734a()) {
            try {
                Thread.sleep((long) uploadJobImpl.f10073b.m15735b());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            uploadJobImpl.m15776d();
            return;
        }
        uploadJobImpl.f10077f.mo1028a(new UploadFailureException(str, (long) uploadJobImpl.f10078g, false, exception));
    }

    public static void m15773b(UploadJobImpl uploadJobImpl, String str) {
        try {
            uploadJobImpl.f10077f.mo1029a(uploadJobImpl.m15775d(str));
        } catch (Exception e) {
            m15772a(uploadJobImpl, "Failed to parse result from POST request response", e, true);
        }
    }

    public static void m15777e(UploadJobImpl uploadJobImpl) {
        uploadJobImpl.f10079h = null;
        uploadJobImpl.f10077f.mo1030b();
    }

    private Map<String, String> m15769a(long j) {
        Map<String, String> hashMap = new HashMap(this.f10073b.f10044b);
        hashMap.put("X-Entity-Length", Long.toString(this.f10072a.f10050d));
        hashMap.put("Offset", Long.toString(j));
        hashMap.put("X-Entity-Type", this.f10072a.f10051e);
        hashMap.put("X-Entity-Name", this.f10072a.f10052f);
        return hashMap;
    }

    private static int m15774c(String str) {
        try {
            OffsetResponse a = UploadJobImpl_OffsetResponse__JsonHelper.m15779a(str);
            if (a != null && a.f10069a >= 0) {
                return a.f10069a;
            }
            throw new JsonParsingException(str);
        } catch (IOException e) {
            throw new JsonParsingException();
        }
    }

    private UploadResult m15775d(String str) {
        try {
            UploadResponse a = UploadJobImpl_UploadResponse__JsonHelper.m15780a(str);
            if (a == null) {
                throw new JsonParsingException(str);
            }
            String str2 = null;
            switch (this.f10073b.m15737d()) {
                case MEDIA_ID:
                    str2 = a.f10071b;
                    break;
                case HANDLE:
                    str2 = a.f10070a;
                    break;
            }
            if (str2 == null) {
                str2 = "";
            }
            return new UploadResult(str2, str);
        } catch (IOException e) {
            throw new JsonParsingException();
        }
    }
}
