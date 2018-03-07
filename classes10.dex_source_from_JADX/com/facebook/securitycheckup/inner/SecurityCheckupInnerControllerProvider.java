package com.facebook.securitycheckup.inner;

import android.content.Context;
import android.view.View;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.securitycheckup.SecurityCheckupLogger;
import com.facebook.securitycheckup.SecurityCheckupState;
import com.facebook.securitycheckup.api.SecurityCheckupQueryModels.SecurityCheckupQueryModel.SecurityCheckupModel;
import com.facebook.securitycheckup.items.SecurityCheckupItem.ItemType;
import com.facebook.securitycheckup.utils.HelpPageUtil;

/* compiled from: image_retry */
public class SecurityCheckupInnerControllerProvider extends AbstractAssistedProvider<SecurityCheckupInnerController> {
    public final SecurityCheckupInnerController m10010a(View view, Context context, ItemType itemType, SecurityCheckupModel securityCheckupModel, Runnable runnable) {
        return new SecurityCheckupInnerController(view, context, itemType, securityCheckupModel, runnable, IdBasedLazy.a(this, 2164), HelpPageUtil.m10066b(this), SecurityCheckupState.m9932a(this), SecurityCheckupLogger.m9901a((InjectorLike) this));
    }
}
