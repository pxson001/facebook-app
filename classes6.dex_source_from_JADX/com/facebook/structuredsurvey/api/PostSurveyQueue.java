package com.facebook.structuredsurvey.api;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: download_preview_tab_viewed */
public @interface PostSurveyQueue {
}
