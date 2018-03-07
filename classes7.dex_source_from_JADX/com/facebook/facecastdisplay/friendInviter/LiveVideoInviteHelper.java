package com.facebook.facecastdisplay.friendInviter;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.facecastdisplay.protocol.LiveVideoInviteFriendsParams;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: at least 15 */
public class LiveVideoInviteHelper {
    DefaultBlueServiceOperationFactory f19059a;
    Toaster f19060b;
    DefaultAndroidThreadUtil f19061c;

    /* compiled from: at least 15 */
    class C16601 implements FutureCallback<OperationResult> {
        final /* synthetic */ LiveVideoInviteHelper f19058a;

        C16601(LiveVideoInviteHelper liveVideoInviteHelper) {
            this.f19058a = liveVideoInviteHelper;
        }

        public void onSuccess(@Nullable Object obj) {
            this.f19058a.f19060b.b(new ToastBuilder(2131232701));
        }

        public void onFailure(Throwable th) {
            this.f19058a.f19060b.b(new ToastBuilder(2131230758));
        }
    }

    public static LiveVideoInviteHelper m22630b(InjectorLike injectorLike) {
        return new LiveVideoInviteHelper(DefaultBlueServiceOperationFactory.b(injectorLike), Toaster.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public LiveVideoInviteHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Toaster toaster, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f19059a = defaultBlueServiceOperationFactory;
        this.f19060b = toaster;
        this.f19061c = defaultAndroidThreadUtil;
    }

    public final void m22631a(String str, ImmutableList<String> immutableList) {
        if (str != null) {
            Parcelable liveVideoInviteFriendsParams = new LiveVideoInviteFriendsParams(str, immutableList);
            Bundle bundle = new Bundle();
            bundle.putParcelable("liveVideoInviteFriendsParamKey", liveVideoInviteFriendsParams);
            this.f19061c.a(BlueServiceOperationFactoryDetour.a(this.f19059a, "live_video_invite_friends", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(LiveVideoFriendInviterFragment.class), 1523355455).a(), new C16601(this));
        }
    }
}
