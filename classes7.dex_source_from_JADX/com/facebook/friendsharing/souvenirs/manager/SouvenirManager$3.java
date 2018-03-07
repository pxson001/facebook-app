package com.facebook.friendsharing.souvenirs.manager;

import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: RUN_JS_BUNDLE_START */
class SouvenirManager$3 implements Function<SouvenirModel, String> {
    final /* synthetic */ SouvenirManager f24053a;

    SouvenirManager$3(SouvenirManager souvenirManager) {
        this.f24053a = souvenirManager;
    }

    public Object apply(@Nullable Object obj) {
        SouvenirModel souvenirModel = (SouvenirModel) obj;
        Preconditions.checkNotNull(souvenirModel);
        return souvenirModel.a().m26169a();
    }
}
