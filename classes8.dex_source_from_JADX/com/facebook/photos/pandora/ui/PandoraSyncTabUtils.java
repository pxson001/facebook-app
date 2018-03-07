package com.facebook.photos.pandora.ui;

import android.os.Build.VERSION;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.vault.momentsupsell.model.MomentsAppInfo;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: com.facebook.intent.action.ACTION_REFRESH_TIMELINE */
public class PandoraSyncTabUtils {
    public final Boolean f17673a;

    public static PandoraSyncTabUtils m21656b(InjectorLike injectorLike) {
        return new PandoraSyncTabUtils(Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PandoraSyncTabUtils(Boolean bool) {
        this.f17673a = bool;
    }

    public final PandoraSyncTabState m21657a(@Nullable MomentsAppInfo momentsAppInfo) {
        if (momentsAppInfo == null) {
            return PandoraSyncTabState.LOADING;
        }
        if (momentsAppInfo.e) {
            return PandoraSyncTabState.NONE;
        }
        if (momentsAppInfo.b && momentsAppInfo.c.j) {
            return PandoraSyncTabState.MOMENTS_PROMOTION;
        }
        if (momentsAppInfo.d) {
            return PandoraSyncTabState.MOMENTS_SEGUE;
        }
        if (VERSION.SDK_INT > 22) {
            return PandoraSyncTabState.SYNC_UNSUPPORTED;
        }
        Object obj = (this.f17673a.booleanValue() || VERSION.SDK_INT > 22) ? null : 1;
        return obj != null ? PandoraSyncTabState.SYNC : PandoraSyncTabState.NONE;
    }
}
