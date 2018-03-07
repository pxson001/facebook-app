package com.facebook.platform.common.service;

import android.os.Message;
import javax.inject.Provider;

/* compiled from: story_menu_opened */
public abstract class AbstractPlatformServiceHandler<REQUEST extends PlatformServiceRequest> implements PlatformServiceHandler {
    Provider<REQUEST> f4077a;
    private int f4078b;

    protected abstract void mo295b(Message message, REQUEST request);

    public AbstractPlatformServiceHandler(Provider<REQUEST> provider, int i) {
        this.f4077a = provider;
        this.f4078b = i;
    }

    public final int mo292a() {
        return this.f4078b;
    }

    public final REQUEST mo294b() {
        return (PlatformServiceRequest) this.f4077a.get();
    }

    public final void mo293a(Message message, PlatformServiceRequest platformServiceRequest) {
        mo295b(message, platformServiceRequest);
    }
}
