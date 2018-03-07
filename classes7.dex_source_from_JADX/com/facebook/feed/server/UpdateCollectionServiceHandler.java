package com.facebook.feed.server;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.LazyAndNormalFilterAdapter;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.feed.protocol.UpdateTimelineAppCollectionMethod;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.saved.common.sync.SavedEventHandler;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Provider;

/* compiled from: Typing_Indicator_Pill_Shown */
public class UpdateCollectionServiceHandler extends LazyAndNormalFilterAdapter {
    private final Lazy<SavedEventHandler> f21666a;
    private final FbSharedPreferences f21667b;
    private final Provider<SingleMethodRunner> f21668c;
    private final Provider<UpdateTimelineAppCollectionMethod> f21669d;
    private final String f21670e;

    public UpdateCollectionServiceHandler(Lazy<SavedEventHandler> lazy, FbSharedPreferences fbSharedPreferences, Provider<SingleMethodRunner> provider, Provider<UpdateTimelineAppCollectionMethod> provider2, String str) {
        this.f21666a = lazy;
        this.f21667b = fbSharedPreferences;
        this.f21668c = provider;
        this.f21669d = provider2;
        this.f21670e = str;
    }

    public final OperationResult m24249a(OperationParams operationParams, BlueServiceHandler blueServiceHandler) {
        Optional a = m24248a(operationParams);
        if (a.isPresent()) {
            return (OperationResult) a.get();
        }
        return blueServiceHandler.a(operationParams);
    }

    private Optional<OperationResult> m24248a(OperationParams operationParams) {
        if (!this.f21670e.equals(operationParams.b)) {
            return Absent.INSTANCE;
        }
        UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams = (UpdateTimelineAppCollectionParams) operationParams.c.getParcelable("timelineAppCollectionParamsKey");
        Boolean bool = (Boolean) ((AbstractSingleMethodRunner) this.f21668c.get()).a((ApiMethod) this.f21669d.get(), updateTimelineAppCollectionParams);
        if (updateTimelineAppCollectionParams.j) {
            ((SavedEventHandler) this.f21666a.get()).a();
        }
        return Optional.of(OperationResult.a(Boolean.toString(bool.booleanValue())));
    }

    public final OperationResult m24250a(OperationParams operationParams, Lazy<? extends BlueServiceHandler> lazy) {
        Optional a = m24248a(operationParams);
        if (a.isPresent()) {
            return (OperationResult) a.get();
        }
        return ((BlueServiceHandler) lazy.get()).a(operationParams);
    }
}
