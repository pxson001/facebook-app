package com.facebook.platform.webdialogs;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;

/* compiled from: from_set_video_resolution */
public class PlatformWebDialogsManifestFetchOperation extends AbstractPlatformOperation implements ResponseHandler<HttpResponse> {
    private final PlatformWebDialogsDownloader f11340b;
    private String f11341c;
    private ErrorCode f11342d;
    private String f11343e;

    @Inject
    public PlatformWebDialogsManifestFetchOperation(PlatformWebDialogsDownloader platformWebDialogsDownloader) {
        super("platform_webdialogs_manifest_fetch");
        this.f11340b = platformWebDialogsDownloader;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        this.f11341c = operationParams.c.getString("platform_webdialogs_manifest_fetch_URL");
        if (this.f11340b.m11781a(this.f11341c, CallerContext.a(PlatformWebDialogsManifestFetchOperation.class), this) == null || this.f11343e == null) {
            this.f11342d = ErrorCode.CONNECTION_FAILURE;
        }
        if (this.f11342d != ErrorCode.NO_ERROR) {
            return OperationResult.a(this.f11342d);
        }
        return OperationResult.a(this.f11343e);
    }

    public Object handleResponse(HttpResponse httpResponse) {
        this.f11342d = PlatformWebDialogsDownloader.m11777a(httpResponse);
        if (this.f11342d == ErrorCode.NO_ERROR) {
            this.f11343e = EntityUtils.toString(httpResponse.getEntity());
        }
        return httpResponse;
    }
}
