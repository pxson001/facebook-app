package com.facebook.platform.common.service;

import android.os.Bundle;
import android.os.Message;
import com.facebook.debug.log.BLog;
import com.facebook.platform.common.config.DefaultPlatformConfig;
import com.facebook.platform.common.config.PlatformConfig;
import com.google.common.collect.Lists;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: stories-live(stories-keyword(%s)) */
public class GetProtocolVersionsServiceHandler extends AbstractPlatformServiceHandler<GetProtocolVersionsRequest> {
    private static final Class<?> f4085b = GetProtocolVersionsServiceHandler.class;
    private final DefaultPlatformConfig f4086c;

    @Inject
    public GetProtocolVersionsServiceHandler(Provider<GetProtocolVersionsRequest> provider, PlatformConfig platformConfig) {
        super(provider, 65538);
        this.f4086c = platformConfig;
    }

    protected final void mo295b(Message message, PlatformServiceRequest platformServiceRequest) {
        Message b = GetProtocolVersionsRequest.m5993b(message);
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("com.facebook.platform.extra.PROTOCOL_VERSIONS", Lists.a(this.f4086c.m5967a()));
        b.setData(bundle);
        try {
            message.replyTo.send(b);
        } catch (Throwable e) {
            BLog.a(f4085b, "Unable to respond to protocol version request", e);
        }
    }
}
