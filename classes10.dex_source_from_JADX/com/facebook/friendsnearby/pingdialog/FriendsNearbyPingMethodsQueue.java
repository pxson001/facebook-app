package com.facebook.friendsnearby.pingdialog;

import com.facebook.fbservice.service.BlueServiceQueueAnnotation;
import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@BlueServiceQueueAnnotation
@BindingAnnotation
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: ^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$ */
public @interface FriendsNearbyPingMethodsQueue {
}
