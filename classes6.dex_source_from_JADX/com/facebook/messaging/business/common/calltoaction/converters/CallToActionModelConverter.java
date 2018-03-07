package com.facebook.messaging.business.common.calltoaction.converters;

import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel;
import com.facebook.messaging.business.common.calltoaction.graphql.PlatformCTAFragmentsModels.PlatformCallToActionModel.ActionTargetsModel;
import com.facebook.messaging.business.common.calltoaction.model.CallToAction;
import com.facebook.messaging.business.common.calltoaction.model.CallToActionBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: video_recording_success */
public class CallToActionModelConverter {
    public static CallToAction m714a(PlatformCallToActionModel platformCallToActionModel) {
        CallToActionBuilder callToActionBuilder = new CallToActionBuilder();
        callToActionBuilder.a = platformCallToActionModel.m740g();
        callToActionBuilder.b = platformCallToActionModel.m739d();
        callToActionBuilder.c(platformCallToActionModel.an_());
        callToActionBuilder.f = platformCallToActionModel.ao_();
        callToActionBuilder.d = CallToAction.a(platformCallToActionModel.m737b().name());
        Builder builder = ImmutableList.builder();
        ImmutableList c = platformCallToActionModel.m738c();
        int size = c.size();
        for (int i = 0; i < size; i++) {
            builder.c(((ActionTargetsModel) c.get(i)).m729c());
        }
        callToActionBuilder.e = builder.b();
        return callToActionBuilder.g();
    }
}
