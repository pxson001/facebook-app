package com.facebook.platform.webdialogs;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import java.io.InputStream;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

/* compiled from: full */
public class PlatformWebDialogFetchOperation extends AbstractPlatformOperation implements ResponseHandler<HttpResponse> {
    private final PlatformWebDialogsCache f11327b;
    private final PlatformWebDialogsDownloader f11328c;
    private PlatformWebViewActionManifest f11329d;
    private ErrorCode f11330e;

    @Inject
    public PlatformWebDialogFetchOperation(PlatformWebDialogsDownloader platformWebDialogsDownloader, PlatformWebDialogsCache platformWebDialogsCache) {
        super("platform_webdialog_fetch");
        this.f11328c = platformWebDialogsDownloader;
        this.f11327b = platformWebDialogsCache;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        this.f11329d = (PlatformWebViewActionManifest) operationParams.c.getParcelable("platform_webview_actionmanifest");
        if (this.f11329d == null) {
            return OperationResult.a(ErrorCode.OTHER);
        }
        String c = this.f11329d.m12492c();
        InputStream a = this.f11327b.m9404a(c);
        if (a != null) {
            a.close();
            return OperationResult.a;
        }
        if (this.f11328c.m11781a(c, CallerContext.a(PlatformWebDialogFetchOperation.class), this) == null) {
            this.f11330e = ErrorCode.CONNECTION_FAILURE;
        }
        if (this.f11330e != ErrorCode.NO_ERROR) {
            return OperationResult.a(this.f11330e);
        }
        return OperationResult.a;
    }

    public Object handleResponse(HttpResponse httpResponse) {
        this.f11330e = PlatformWebDialogsDownloader.m11777a(httpResponse);
        if (this.f11330e == ErrorCode.NO_ERROR && !this.f11327b.m9406a(this.f11329d, httpResponse)) {
            this.f11330e = ErrorCode.CONNECTION_FAILURE;
        }
        return httpResponse;
    }
}
