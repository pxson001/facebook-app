package com.facebook.backgroundlocation.reporting;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.FacebookOnlyIntentActionFactory;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import javax.inject.Inject;

/* compiled from: dismiss_script */
public class BackgroundLocationReportingHandler implements BlueServiceHandler {
    public final Context f14884a;
    public final AbstractSingleMethodRunner f14885b;
    public final BackgroundLocationReportingUpdateMethod f14886c;
    public final FacebookOnlyIntentActionFactory f14887d;

    @Inject
    public BackgroundLocationReportingHandler(Context context, AbstractSingleMethodRunner abstractSingleMethodRunner, BackgroundLocationReportingUpdateMethod backgroundLocationReportingUpdateMethod, FacebookOnlyIntentActionFactory facebookOnlyIntentActionFactory) {
        this.f14884a = context;
        this.f14885b = abstractSingleMethodRunner;
        this.f14886c = backgroundLocationReportingUpdateMethod;
        this.f14887d = facebookOnlyIntentActionFactory;
    }

    public final OperationResult m15349a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("background_location_update")) {
            BackgroundLocationReportingUpdateResult backgroundLocationReportingUpdateResult = (BackgroundLocationReportingUpdateResult) this.f14885b.a(this.f14886c, (BackgroundLocationReportingUpdateParams) operationParams.c.getParcelable("BackgroundLocationReportingUpdateParams"), CallerContext.a(getClass()));
            if (!backgroundLocationReportingUpdateResult.f14903b) {
                Intent intent = new Intent(this.f14887d.a("BACKGROUND_LOCATION_REPORTING_SETTINGS_REQUEST_REFRESH_ACTION"));
                intent.putExtra("expected_location_history_setting", false);
                this.f14884a.sendBroadcast(intent);
            }
            return OperationResult.a(backgroundLocationReportingUpdateResult);
        }
        throw new IllegalArgumentException("Unknown operation type: " + str);
    }
}
