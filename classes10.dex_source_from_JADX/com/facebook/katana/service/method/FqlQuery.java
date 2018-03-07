package com.facebook.katana.service.method;

import android.content.Context;
import android.content.Intent;
import com.facebook.katana.constants.Constants.URL;
import javax.annotation.Nullable;

/* compiled from: to_id */
public class FqlQuery extends ApiMethod {
    public FqlQuery(Context context, @Nullable Intent intent, String str, String str2, @Nullable ServiceOperationListener serviceOperationListener) {
        super(context, intent, "GET", "fql.query", URL.d(context), serviceOperationListener);
        this.f1198c.put("call_id", System.currentTimeMillis());
        this.f1198c.put("query", str2);
        if (str != null) {
            this.f1198c.put("session_key", str);
        }
    }
}
