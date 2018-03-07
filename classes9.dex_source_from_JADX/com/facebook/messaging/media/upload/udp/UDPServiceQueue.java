package com.facebook.messaging.media.upload.udp;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: last_call_time = (SELECT max(last_call_time) FROM person_summary WHERE thread_id = ?) AND thread_id = ? */
public @interface UDPServiceQueue {
}
