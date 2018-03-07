package com.facebook.backgroundlocation.settings.write;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: crowdsourcing_current_value_vote */
public @interface BackgroundLocationSettingsWriteQueue {
}
