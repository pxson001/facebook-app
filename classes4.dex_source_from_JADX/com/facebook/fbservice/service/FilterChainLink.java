package com.facebook.fbservice.service;

/* compiled from: messenger_media_upload_phase_two_succeeded */
public class FilterChainLink implements BlueServiceHandler {
    private final BlueServiceHandler$Filter f7963a;
    private final BlueServiceHandler f7964b;

    public FilterChainLink(BlueServiceHandler$Filter blueServiceHandler$Filter, BlueServiceHandler blueServiceHandler) {
        this.f7963a = blueServiceHandler$Filter;
        this.f7964b = blueServiceHandler;
    }

    public final OperationResult m8291a(OperationParams operationParams) {
        return this.f7963a.mo57a(operationParams, this.f7964b);
    }
}
