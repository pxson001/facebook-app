package com.facebook.backgroundlocation.settings.write;

import android.content.Context;
import android.content.Intent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.CrossProcessFbBroadcastManager;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: crowdsourcing_edit */
public class BackgroundLocationSettingsWriteHandler implements BlueServiceHandler {
    private static BackgroundLocationSettingsWriteHandler f16519f;
    private static final Object f16520g = new Object();
    public final Context f16521a;
    public final AbstractSingleMethodRunner f16522b;
    public final BackgroundLocationUpdateSettingsMethod f16523c;
    public final BaseFbBroadcastManager f16524d;
    public final FacebookOnlyIntentActionFactory f16525e;

    private static BackgroundLocationSettingsWriteHandler m20590b(InjectorLike injectorLike) {
        return new BackgroundLocationSettingsWriteHandler((Context) injectorLike.getInstance(Context.class), (AbstractSingleMethodRunner) SingleMethodRunnerImpl.a(injectorLike), new BackgroundLocationUpdateSettingsMethod(), (BaseFbBroadcastManager) CrossProcessFbBroadcastManager.a(injectorLike), FacebookOnlyIntentActionFactory.a(injectorLike));
    }

    @Inject
    public BackgroundLocationSettingsWriteHandler(Context context, AbstractSingleMethodRunner abstractSingleMethodRunner, BackgroundLocationUpdateSettingsMethod backgroundLocationUpdateSettingsMethod, BaseFbBroadcastManager baseFbBroadcastManager, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory) {
        this.f16521a = context;
        this.f16522b = abstractSingleMethodRunner;
        this.f16523c = backgroundLocationUpdateSettingsMethod;
        this.f16524d = baseFbBroadcastManager;
        this.f16525e = facebookOnlyIntentActionFactory;
    }

    public final OperationResult m20591a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("background_location_update_settings".equals(str)) {
            OperationResult operationResult;
            BackgroundLocationUpdateSettingsParams backgroundLocationUpdateSettingsParams = (BackgroundLocationUpdateSettingsParams) operationParams.c.getParcelable("BackgroundLocationUpdateSettingsParams");
            if (((Boolean) this.f16522b.a(this.f16523c, backgroundLocationUpdateSettingsParams, operationParams.e)).booleanValue()) {
                if (backgroundLocationUpdateSettingsParams.f16527b.isPresent() || backgroundLocationUpdateSettingsParams.f16526a.isPresent()) {
                    this.f16521a.sendBroadcast(new Intent(this.f16525e.a("NEARBY_FRIENDS_SETTINGS_CHANGED_ACTION")));
                }
                if (backgroundLocationUpdateSettingsParams.f16526a.isPresent()) {
                    boolean booleanValue = ((Boolean) backgroundLocationUpdateSettingsParams.f16526a.get()).booleanValue();
                    Intent intent = new Intent("com.facebook.backgroundlocation.reporting.OLD_SETTINGS_CHANGED_ACTION");
                    intent.putExtra("expected_location_history_setting", booleanValue);
                    this.f16524d.a(intent);
                    intent = new Intent(this.f16525e.a("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION"));
                    intent.putExtra("expected_location_history_setting", booleanValue);
                    this.f16521a.sendBroadcast(intent);
                }
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.API_ERROR);
            }
            return operationResult;
        }
        throw new IllegalArgumentException("Unexpected operation type " + str);
    }

    public static BackgroundLocationSettingsWriteHandler m20589a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BackgroundLocationSettingsWriteHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16520g) {
                BackgroundLocationSettingsWriteHandler backgroundLocationSettingsWriteHandler;
                if (a2 != null) {
                    backgroundLocationSettingsWriteHandler = (BackgroundLocationSettingsWriteHandler) a2.a(f16520g);
                } else {
                    backgroundLocationSettingsWriteHandler = f16519f;
                }
                if (backgroundLocationSettingsWriteHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m20590b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16520g, b3);
                        } else {
                            f16519f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = backgroundLocationSettingsWriteHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
