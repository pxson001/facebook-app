package com.facebook.api.reportable_entity;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_broadcast_calculate_stats_key */
public @interface ReportableEntityNegativeActionsQueue {
}
