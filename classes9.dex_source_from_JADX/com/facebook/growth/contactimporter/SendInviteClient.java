package com.facebook.growth.contactimporter;

import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.api.growth.contactimporter.UsersInviteParams;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.inject.Assisted;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import java.util.List;
import javax.inject.Inject;

/* compiled from: paymentProtected */
public class SendInviteClient {
    private final DefaultBlueServiceOperationFactory f7111a;
    private final String f7112b;
    private final CIFlow f7113c;

    @Inject
    public SendInviteClient(@Assisted CIFlow cIFlow, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, String str) {
        this.f7113c = cIFlow;
        this.f7111a = defaultBlueServiceOperationFactory;
        this.f7112b = str;
    }

    public final void m7394a(List<String> list, boolean z, boolean z2, CallerContext callerContext) {
        if (!list.isEmpty()) {
            Parcelable usersInviteParams = new UsersInviteParams(list, this.f7112b, this.f7113c, z, z2);
            Bundle bundle = new Bundle();
            bundle.putParcelable("growthUsersInviteParamsKey", usersInviteParams);
            BlueServiceOperationFactoryDetour.a(this.f7111a, "growth_users_invite", bundle, ErrorPropagation.BY_EXCEPTION, callerContext, -1929701940).a();
        }
    }
}
