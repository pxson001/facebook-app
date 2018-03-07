package com.facebook.productionprompts.composer;

import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.productionprompts.model.ProductionPrompt;
import com.google.common.base.Strings;

/* compiled from: request_client_time */
public class ProductionPromptComposerUtil {
    private ProductionPromptComposerUtil() {
    }

    public static void m4382a(Builder builder, ProductionPrompt productionPrompt) {
        MinutiaeObject d;
        ComposerShareParams composerShareParams;
        CheckinPlaceModel checkinPlaceModel;
        if (productionPrompt.d() != null) {
            d = productionPrompt.d();
        } else {
            d = null;
        }
        MinutiaeObject minutiaeObject = d;
        if (Strings.isNullOrEmpty(productionPrompt.f())) {
            composerShareParams = null;
        } else {
            composerShareParams = ComposerShareParams.Builder.a(productionPrompt.f()).b();
        }
        ComposerShareParams composerShareParams2 = composerShareParams;
        if (productionPrompt.g() == null || productionPrompt.h() == null) {
            checkinPlaceModel = null;
        } else {
            CheckinPlaceModel.Builder builder2 = new CheckinPlaceModel.Builder();
            builder2.f = productionPrompt.g();
            builder2 = builder2;
            builder2.h = productionPrompt.h();
            checkinPlaceModel = builder2.a();
        }
        CheckinPlaceModel checkinPlaceModel2 = checkinPlaceModel;
        if (minutiaeObject != null) {
            builder.setMinutiaeObjectTag(minutiaeObject);
        }
        if (composerShareParams2 != null) {
            builder.setInitialShareParams(composerShareParams2);
        }
        if (checkinPlaceModel2 != null) {
            builder.setInitialLocationInfo(ComposerLocationInfo.newBuilder().b(checkinPlaceModel2).b());
        }
    }
}
