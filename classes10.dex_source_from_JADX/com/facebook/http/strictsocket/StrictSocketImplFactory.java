package com.facebook.http.strictsocket;

import com.facebook.debug.log.BLog;
import java.net.SocketImpl;
import java.net.SocketImplFactory;

/* compiled from: view_video */
public class StrictSocketImplFactory implements SocketImplFactory {
    private static final Class<StrictSocketImplFactory> f402a = StrictSocketImplFactory.class;
    private final StrictSocketManager f403b;

    public StrictSocketImplFactory(StrictSocketManager strictSocketManager) {
        this.f403b = strictSocketManager;
    }

    public SocketImpl createSocketImpl() {
        try {
            return new StrictSocketImpl(PlainSocketImplFactory.m513a(), this.f403b);
        } catch (Throwable e) {
            BLog.b(f402a, "Failed to create StrictSocketImpl", e);
            return null;
        } catch (Throwable e2) {
            BLog.b(f402a, "Failed to create StrictSocketImpl", e2);
            return null;
        }
    }
}
