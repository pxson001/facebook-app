package com.facebook.contacts.service;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.inject.AbstractProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: p2p_incentives */
public class BlueServiceHandler_DynamicContactDataQueueMethodAutoProvider extends AbstractProvider<BlueServiceHandler> {
    public Object get() {
        return ContactsServiceModule.m12307a(DynamicContactDataLocalServiceHandler.m12308a(this), DynamicContactDataServiceHandler.m12311a((InjectorLike) this));
    }
}
