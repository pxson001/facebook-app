package com.facebook.facecast.protocol;

import com.facebook.facecast.protocol.AnswerCopyrightViolationMethod.Params;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiMethodRunner;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: badge_count */
public class FacecastServiceHandler implements BlueServiceHandler {
    public final ApiMethodRunnerImpl f18763a;
    public final Lazy<VideoBroadcastUpdateMethod> f18764b;
    public final Lazy<VideoBroadcastCalculateStatsMethod> f18765c;
    public final Lazy<VideoBroadcastSealMethod> f18766d;
    public final Lazy<DeleteLiveVideoMethod> f18767e;
    public final Lazy<AnswerCopyrightViolationMethod> f18768f;

    public static FacecastServiceHandler m22310b(InjectorLike injectorLike) {
        return new FacecastServiceHandler(ApiMethodRunnerImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 5734), IdBasedLazy.a(injectorLike, 5732), IdBasedLazy.a(injectorLike, 5733), IdBasedLazy.a(injectorLike, 5729), IdBasedLazy.a(injectorLike, 5728));
    }

    @Inject
    public FacecastServiceHandler(ApiMethodRunner apiMethodRunner, Lazy<VideoBroadcastUpdateMethod> lazy, Lazy<VideoBroadcastCalculateStatsMethod> lazy2, Lazy<VideoBroadcastSealMethod> lazy3, Lazy<DeleteLiveVideoMethod> lazy4, Lazy<AnswerCopyrightViolationMethod> lazy5) {
        this.f18763a = apiMethodRunner;
        this.f18764b = lazy;
        this.f18765c = lazy2;
        this.f18766d = lazy3;
        this.f18767e = lazy4;
        this.f18768f = lazy5;
    }

    public final OperationResult m22311a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("video_broadcast_update_type".equals(str)) {
            this.f18763a.a((ApiMethod) this.f18764b.get(), (VideoBroadcastUpdateRequest) operationParams.c.getParcelable("video_broadcast_update_key"));
            return OperationResult.a;
        } else if ("video_broadcast_calculate_stats_type".equals(str)) {
            this.f18763a.a((ApiMethod) this.f18765c.get(), (VideoBroadcastCalculateStatsRequest) operationParams.c.getParcelable("video_broadcast_calculate_stats_key"));
            return OperationResult.a;
        } else if ("video_broadcast_seal_type".equals(str)) {
            this.f18763a.a((ApiMethod) this.f18766d.get(), (VideoBroadcastSealRequest) operationParams.c.getParcelable("video_broadcast_seal_key"));
            return OperationResult.a;
        } else if ("delete_video_type".equals(str)) {
            this.f18763a.a((ApiMethod) this.f18767e.get(), operationParams.c.getString("delete_video_key"));
            return OperationResult.a;
        } else if ("answer_copyright_violation_type".equals(str)) {
            this.f18763a.a((ApiMethod) this.f18768f.get(), (Params) operationParams.c.getParcelable("answer_copyright_violation_key"));
            return OperationResult.a;
        } else {
            throw new ApiMethodNotFoundException(str);
        }
    }
}
