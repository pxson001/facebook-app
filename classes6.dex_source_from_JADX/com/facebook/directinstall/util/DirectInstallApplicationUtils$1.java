package com.facebook.directinstall.util;

import com.facebook.common.uri.NativeAppDetails.Screenshot;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsImageGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsImageGraphQLModel;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: og_action_type */
final class DirectInstallApplicationUtils$1 implements Function<GetNativeAppDetailsImageGraphQL, Screenshot> {
    DirectInstallApplicationUtils$1() {
    }

    @Nullable
    public final Object apply(@Nullable Object obj) {
        GetNativeAppDetailsImageGraphQLModel getNativeAppDetailsImageGraphQLModel = (GetNativeAppDetailsImageGraphQLModel) obj;
        Preconditions.checkNotNull(getNativeAppDetailsImageGraphQLModel);
        return new Screenshot(getNativeAppDetailsImageGraphQLModel.m12628b(), getNativeAppDetailsImageGraphQLModel.m12629c(), getNativeAppDetailsImageGraphQLModel.m12624a());
    }
}
