package com.facebook.messaging.media.upload.udp;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.udp.UDPConnectionMethod.UDPConnectionParams;
import com.facebook.messaging.media.upload.udp.UDPMetadataUploadMethod.UDPUploadParams;
import javax.inject.Inject;

/* compiled from: last_fetch_ranked_threads_time_ms */
public class UDPConnectionServiceHandler implements BlueServiceHandler {
    private final ApiMethodRunnerImpl f12172a;
    private final UDPMetadataUploadMethod f12173b;
    private final UDPConnectionMethod f12174c;
    private final ApiMethodRunnerParams f12175d = new ApiMethodRunnerParams();

    public static UDPConnectionServiceHandler m12681b(InjectorLike injectorLike) {
        return new UDPConnectionServiceHandler(ApiMethodRunnerImpl.a(injectorLike), new UDPMetadataUploadMethod(), UDPConnectionMethod.m12677a(injectorLike));
    }

    @Inject
    public UDPConnectionServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, UDPMetadataUploadMethod uDPMetadataUploadMethod, UDPConnectionMethod uDPConnectionMethod) {
        this.f12172a = apiMethodRunnerImpl;
        this.f12173b = uDPMetadataUploadMethod;
        this.f12174c = uDPConnectionMethod;
    }

    private OperationResult m12680b(OperationParams operationParams) {
        try {
            return OperationResult.a((UDPServerConfig) this.f12172a.a(this.f12174c, (UDPConnectionParams) operationParams.b().getParcelable("udp_parcel_key"), this.f12175d));
        } catch (Throwable e) {
            return OperationResult.a(e);
        }
    }

    public final OperationResult m12683a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("udp_connection_refresh_server_config")) {
            return m12680b(operationParams);
        }
        if (str.equals("udp_connection_upload_metadata")) {
            return m12682c(operationParams);
        }
        throw new IllegalArgumentException("Unhandled operation type: " + str);
    }

    private OperationResult m12682c(OperationParams operationParams) {
        try {
            return OperationResult.a((UDPServerConfig) this.f12172a.a(this.f12173b, (UDPUploadParams) operationParams.b().getParcelable("udp_parcel_key"), this.f12175d));
        } catch (Throwable e) {
            return OperationResult.a(e);
        }
    }
}
