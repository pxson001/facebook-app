package com.facebook.messaging.platform.utilities;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.DeviceApiContext;
import com.facebook.http.protocol.DeviceApiResult;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.model.ShareItem;
import com.facebook.share.protocol.LinksPreviewMethod;
import com.facebook.share.protocol.LinksPreviewParams.Builder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: gender/ */
public class LinkShareMessageBatchOperation extends AbstractPlatformOperation {
    public final ApiMethodRunnerImpl f11296b;
    private final ObjectMapper f11297c;
    public final LinksPreviewMethod f11298d;

    @Inject
    public LinkShareMessageBatchOperation(ApiMethodRunnerImpl apiMethodRunnerImpl, ObjectMapper objectMapper, LinksPreviewMethod linksPreviewMethod) {
        super("platform_link_share_upload");
        this.f11296b = apiMethodRunnerImpl;
        this.f11297c = objectMapper;
        this.f11298d = linksPreviewMethod;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Preconditions.checkArgument(this.f11251a.equals(operationParams.b));
        return m11696a((Params) operationParams.c.getParcelable("platform_link_share_upload_params"));
    }

    private OperationResult m11696a(Params params) {
        ShareItem shareItem = params.a;
        ApiMethodRunner$Batch a = this.f11296b.a();
        Map c = Maps.c();
        c.put("third_party_id", shareItem.i.a());
        Map c2 = Maps.c();
        c2.put("version", "1");
        Map c3 = Maps.c();
        c3.put("type", "link");
        if (shareItem.a != null) {
            c3.put("name", shareItem.a);
        }
        if (shareItem.c != null) {
            c3.put("description", shareItem.c);
        }
        if (shareItem.b != null) {
            c3.put("caption", shareItem.b);
        }
        if (shareItem.d != null) {
            c3.put("image", shareItem.d);
        }
        a.mo886a(new DeviceApiContext("message_preview", c, c2, c3));
        Builder builder = new Builder();
        builder.b = shareItem.e;
        BatchOperation.Builder a2 = BatchOperation.m12541a(this.f11298d, builder.a());
        a2.f11927c = "preview";
        a.mo888a(a2.m12549a());
        ApiMethodRunner$Batch apiMethodRunner$Batch = a;
        apiMethodRunner$Batch.mo889a("messagePreview", CallerContext.a(getClass()));
        Bundle bundle = new Bundle();
        Parcelable parcelable = (LinksPreview) apiMethodRunner$Batch.mo887a("preview");
        DeviceApiResult e = apiMethodRunner$Batch.mo891e();
        if (e != null) {
            Object obj;
            if (e.a != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                JsonParser c4 = e.c.c();
                c4.a(this.f11297c);
                parcelable = (LinksPreview) c4.a(LinksPreview.class);
            }
        }
        bundle.putParcelable("links_preview_result", parcelable);
        return OperationResult.a(bundle);
    }
}
