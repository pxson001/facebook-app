package com.facebook.platform.auth.service;

import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.platform.auth.server.AuthorizeAppMethod$Params;
import com.facebook.platform.auth.server.AuthorizeAppMethod$Params.Builder;
import com.facebook.platform.auth.server.AuthorizeAppMethod$Result;
import com.facebook.platform.common.PlatformAppResults;
import com.facebook.platform.common.service.AbstractPlatformServiceHandler;
import com.facebook.platform.common.service.PlatformServiceRequest;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.Futures;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: location_package */
public class RefreshTokenServiceHandler extends AbstractPlatformServiceHandler<GetAccessTokenPlatformServiceRequest> {
    public static final Class<?> f8473b = RefreshTokenServiceHandler.class;
    private DefaultBlueServiceOperationFactory f8474c;

    protected final void m8383b(Message message, PlatformServiceRequest platformServiceRequest) {
        GetAccessTokenPlatformServiceRequest getAccessTokenPlatformServiceRequest = (GetAccessTokenPlatformServiceRequest) platformServiceRequest;
        Builder builder = new Builder(getAccessTokenPlatformServiceRequest.a, getAccessTokenPlatformServiceRequest.b);
        builder.f8454e = Optional.of(Boolean.valueOf(true));
        Builder builder2 = builder;
        AuthorizeAppMethod$Params authorizeAppMethod$Params = new AuthorizeAppMethod$Params(builder2.f8450a, builder2.f8451b, builder2.f8452c, builder2.f8453d, builder2.f8454e);
        Bundle bundle = new Bundle();
        bundle.putParcelable("app_info", authorizeAppMethod$Params);
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f8474c, "platform_authorize_app", bundle, 1650903864).a();
        if (message.replyTo != null) {
            Message obtain = Message.obtain(message);
            obtain.arg1 = message.arg1;
            obtain.arg2 = message.arg2;
            obtain.what = 65537;
            final Message message2 = obtain;
            final Messenger messenger = message.replyTo;
            Futures.a(a, new OperationResultFutureCallback(this) {
                final /* synthetic */ RefreshTokenServiceHandler f8472c;

                public final void m8382a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    Parcelable parcelable = operationResult.b() ? operationResult.g().getParcelable("result") : null;
                    if (parcelable != null) {
                        AuthorizeAppMethod$Result authorizeAppMethod$Result = (AuthorizeAppMethod$Result) parcelable;
                        message2.setData(PlatformAppResults.a(null, authorizeAppMethod$Result.m8374a(), authorizeAppMethod$Result.m8376c(), authorizeAppMethod$Result.m8375b()));
                    } else {
                        message2.setData(PlatformAppResults.a(null, new ServiceException(operationResult)));
                    }
                    try {
                        messenger.send(message2);
                    } catch (Throwable e) {
                        BLog.a(RefreshTokenServiceHandler.f8473b, "Unable to respond to token refresh request", e);
                    }
                }

                protected final void m8381a(ServiceException serviceException) {
                    message2.setData(PlatformAppResults.a(null, serviceException));
                    try {
                        messenger.send(message2);
                    } catch (Throwable e) {
                        BLog.a(RefreshTokenServiceHandler.f8473b, "Unable to respond to token refresh request", e);
                    }
                }
            });
        }
    }

    @Inject
    public RefreshTokenServiceHandler(Provider<GetAccessTokenPlatformServiceRequest> provider, BlueServiceOperationFactory blueServiceOperationFactory) {
        super(provider, 65536);
        this.f8474c = blueServiceOperationFactory;
    }
}
