package com.facebook.messaging.send.service;

/* compiled from: recent_item_image_width */
public class SendViaMqttException extends Throwable {
    public final SendViaMqttResult mMqttResult;

    public SendViaMqttException(SendViaMqttResult sendViaMqttResult) {
        this.mMqttResult = sendViaMqttResult;
    }
}
