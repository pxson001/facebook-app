package com.facebook.messaging.business.ride.view;

import com.facebook.messaging.business.common.calltoaction.CallToActionContainerView.C09981.C09971;
import com.facebook.messaging.business.common.calltoaction.CallToActionTypeHandler;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction.Type;
import com.facebook.messaging.business.ride.helper.RideMutationHelper;
import com.facebook.messaging.business.ride.helper.RideMutationHelper.AnonymousClass10;
import com.facebook.messaging.business.ride.helper.RideMutationHelper.C10599;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mn_platform_msg_thread_imp */
public class RideCallToActionHandler implements CallToActionTypeHandler {
    private RideMutationHelper f9322a;

    @Inject
    public RideCallToActionHandler(RideMutationHelper rideMutationHelper) {
        this.f9322a = rideMutationHelper;
    }

    public final boolean mo319a(CallToAction callToAction, ThreadKey threadKey, @Nullable C09971 c09971) {
        if (callToAction.b == null || callToAction.b != Type.OPEN_CANCEL_RIDE_MUTATION || Strings.isNullOrEmpty(callToAction.a())) {
            return false;
        }
        RideMutationHelper rideMutationHelper = this.f9322a;
        new FbAlertDialogBuilder(rideMutationHelper.f9195b).a(rideMutationHelper.f9195b.getString(2131240742)).b(rideMutationHelper.f9195b.getString(2131240743)).a(rideMutationHelper.f9195b.getResources().getString(2131230735), new AnonymousClass10(rideMutationHelper, callToAction.a())).b(rideMutationHelper.f9195b.getResources().getString(2131230736), new C10599(rideMutationHelper)).b();
        return true;
    }
}
