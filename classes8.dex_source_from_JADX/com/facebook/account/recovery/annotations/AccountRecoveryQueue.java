package com.facebook.account.recovery.annotations;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: local_serp_open */
public @interface AccountRecoveryQueue {
}
