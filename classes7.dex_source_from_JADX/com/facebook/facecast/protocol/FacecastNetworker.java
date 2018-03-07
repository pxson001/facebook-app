package com.facebook.facecast.protocol;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: badge_type */
public class FacecastNetworker {
    public final DefaultBlueServiceOperationFactory f18762a;

    public static FacecastNetworker m22307b(InjectorLike injectorLike) {
        return new FacecastNetworker(DefaultBlueServiceOperationFactory.b(injectorLike));
    }

    @Inject
    public FacecastNetworker(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f18762a = defaultBlueServiceOperationFactory;
    }

    public static FacecastNetworker m22306a(InjectorLike injectorLike) {
        return m22307b(injectorLike);
    }

    public final void m22308a(String str, int i, long j) {
        Parcelable videoBroadcastCalculateStatsRequest = new VideoBroadcastCalculateStatsRequest(str, i, j);
        Bundle bundle = new Bundle();
        bundle.putParcelable("video_broadcast_calculate_stats_key", videoBroadcastCalculateStatsRequest);
        BlueServiceOperationFactoryDetour.a(this.f18762a, "video_broadcast_calculate_stats_type", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacecastNetworker.class), -550097999).a();
    }

    public final void m22309b(@Nullable String str) {
        if (str != null) {
            Bundle bundle = new Bundle();
            bundle.putString("delete_video_key", str);
            BlueServiceOperationFactoryDetour.a(this.f18762a, "delete_video_type", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(FacecastNetworker.class), -658352166).a();
        }
    }
}
