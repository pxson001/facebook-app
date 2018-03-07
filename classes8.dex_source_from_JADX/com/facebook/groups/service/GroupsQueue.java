package com.facebook.groups.service;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: video_skip_report_url */
public @interface GroupsQueue {
}
