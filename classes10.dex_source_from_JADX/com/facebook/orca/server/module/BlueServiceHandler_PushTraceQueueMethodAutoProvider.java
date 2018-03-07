package com.facebook.orca.server.module;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.orca.push.fbpushdata.PushTraceServiceHandler;

/* compiled from: nearby_places_search_typeahead_did_receive_results */
public class BlueServiceHandler_PushTraceQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    public Object get() {
        return PushTraceServiceHandler.m6015a((InjectorLike) this);
    }
}
