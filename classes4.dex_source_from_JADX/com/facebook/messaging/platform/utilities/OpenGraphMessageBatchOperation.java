package com.facebook.messaging.platform.utilities;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunner$Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.platform.common.server.AbstractPlatformOperation;
import com.facebook.platform.opengraph.OpenGraphRequest;
import com.facebook.platform.opengraph.OpenGraphRequestFactory;
import com.facebook.platform.opengraph.model.OpenGraphActionRobotext;
import com.facebook.platform.opengraph.model.OpenGraphObject;
import com.facebook.platform.opengraph.server.GetRobotextPreviewMethod;
import com.facebook.platform.opengraph.server.PublishOpenGraphActionMethod;
import com.facebook.platform.server.protocol.GetAppNameMethod;
import com.facebook.platform.server.protocol.GetAppNameMethod.Params;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.share.model.LinksPreview;
import com.facebook.share.model.ShareItem;
import com.facebook.share.protocol.LinksPreviewMethod;
import com.facebook.share.protocol.LinksPreviewParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: gcm_reg_frequency_s_overrides */
public class OpenGraphMessageBatchOperation extends AbstractPlatformOperation {
    private final ApiMethodRunnerImpl f11300b;
    private final OpenGraphRequestFactory f11301c;
    private final PublishOpenGraphActionMethod f11302d;
    public final GetAppNameMethod f11303e;
    public final GetRobotextPreviewMethod f11304f;
    private final Provider<LinksPreviewMethod> f11305g;

    @Inject
    public OpenGraphMessageBatchOperation(ApiMethodRunner apiMethodRunner, OpenGraphRequestFactory openGraphRequestFactory, PublishOpenGraphActionMethod publishOpenGraphActionMethod, GetAppNameMethod getAppNameMethod, GetRobotextPreviewMethod getRobotextPreviewMethod, Provider<LinksPreviewMethod> provider) {
        super("platform_open_graph_share_upload");
        this.f11300b = apiMethodRunner;
        this.f11301c = openGraphRequestFactory;
        this.f11302d = publishOpenGraphActionMethod;
        this.f11303e = getAppNameMethod;
        this.f11304f = getRobotextPreviewMethod;
        this.f11305g = provider;
    }

    public final OperationResult mo836a(OperationParams operationParams) {
        Preconditions.checkArgument(this.f11251a.equals(operationParams.b));
        return m11701a((Params) operationParams.c.getParcelable("platform_open_graph_share_upload_params"));
    }

    private ApiMethodRunner$Batch m11702a(OpenGraphRequest openGraphRequest, ComposerAppAttribution composerAppAttribution, Bundle bundle, String str) {
        ApiMethodRunner$Batch a = this.f11300b.a();
        m11703a(a, openGraphRequest, composerAppAttribution, bundle);
        Builder a2 = BatchOperation.m12541a(this.f11303e, new Params(composerAppAttribution.a()));
        a2.f11927c = "get_app_name";
        a.mo888a(a2.m12549a());
        a2 = BatchOperation.m12541a(this.f11304f, new GetRobotextPreviewMethod.Params(openGraphRequest.a().toString(), openGraphRequest.d, composerAppAttribution.a(), composerAppAttribution.c()));
        a2.f11927c = "get_robotext_preview";
        a.mo888a(a2.m12549a());
        if (str != null) {
            m11704a(a, str);
        }
        return a;
    }

    private void m11703a(ApiMethodRunner$Batch apiMethodRunner$Batch, OpenGraphRequest openGraphRequest, ComposerAppAttribution composerAppAttribution, Bundle bundle) {
        ApiMethodRunner$Batch apiMethodRunner$Batch2 = apiMethodRunner$Batch;
        apiMethodRunner$Batch2.mo888a(BatchOperation.m12541a(this.f11302d, new PublishOpenGraphActionMethod.Params(openGraphRequest.b(), openGraphRequest.a(bundle), null, "message", Sets.a(), null, null, false, false, composerAppAttribution.a(), composerAppAttribution.b(), composerAppAttribution.c())).m12547a("og_action").m12549a());
    }

    private void m11704a(ApiMethodRunner$Batch apiMethodRunner$Batch, String str) {
        String str2 = null;
        if (!str.startsWith("http")) {
            str2 = str;
            str = null;
        }
        LinksPreviewParams.Builder builder = new LinksPreviewParams.Builder();
        builder.a = str2;
        LinksPreviewParams.Builder builder2 = builder;
        builder2.b = str;
        Builder a = BatchOperation.m12541a((ApiMethod) this.f11305g.get(), builder2.a());
        a.f11927c = "get_open_graph_url";
        apiMethodRunner$Batch.mo888a(a.m12549a());
    }

    private OperationResult m11701a(Params params) {
        Parcelable openGraphObject;
        ShareItem shareItem = params.a;
        OpenGraphRequest a = this.f11301c.m11710a(shareItem.j.a, shareItem.j.b, shareItem.j.c);
        a.h();
        ApiMethodRunner$Batch a2 = m11702a(a, shareItem.i, params.b, params.c);
        a2.mo889a("openGraphShareUpload", CallerContext.a(getClass()));
        Bundle bundle = new Bundle();
        bundle.putString("og_post_id", (String) a2.mo887a("og_action"));
        bundle.putString("app_name", (String) a2.mo887a("get_app_name"));
        bundle.putParcelable("robotext_preview_result", (OpenGraphActionRobotext) a2.mo887a("get_robotext_preview"));
        LinksPreview linksPreview = (LinksPreview) a2.mo887a("get_open_graph_url");
        if (linksPreview != null) {
            openGraphObject = new OpenGraphObject(linksPreview.name, linksPreview.description, linksPreview.b());
        } else {
            openGraphObject = null;
        }
        if (openGraphObject != null) {
            bundle.putParcelable("object_details", openGraphObject);
        }
        return OperationResult.a(bundle);
    }
}
