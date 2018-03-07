package com.facebook.events.service;

import android.os.Bundle;
import com.facebook.events.protocol.CreateEventMethod;
import com.facebook.events.protocol.CreateEventParams;
import com.facebook.events.protocol.EditEventMethod;
import com.facebook.events.protocol.EditEventParams;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: audio_clips_playback_pause */
public class EventServiceHandler implements BlueServiceHandler {
    public final Provider<SingleMethodRunner> f19075a;
    public final CreateEventMethod f19076b;
    public final EditEventMethod f19077c;

    @Inject
    public EventServiceHandler(Provider<SingleMethodRunner> provider, CreateEventMethod createEventMethod, EditEventMethod editEventMethod) {
        this.f19075a = provider;
        this.f19076b = createEventMethod;
        this.f19077c = editEventMethod;
    }

    public final OperationResult m19300a(OperationParams operationParams) {
        String str = operationParams.b;
        Bundle bundle;
        if (str.equals("create_event")) {
            Long l = (Long) ((AbstractSingleMethodRunner) this.f19075a.get()).a(this.f19076b, (CreateEventParams) operationParams.c.getParcelable("createEventParams"));
            bundle = new Bundle();
            bundle.putLong("createEventResult", l.longValue());
            return OperationResult.a(bundle);
        } else if (str.equals("edit_event")) {
            Boolean bool = (Boolean) ((AbstractSingleMethodRunner) this.f19075a.get()).a(this.f19077c, (EditEventParams) operationParams.c.getParcelable("editEventParams"));
            bundle = new Bundle();
            bundle.putBoolean("editEventResult", bool.booleanValue());
            return OperationResult.a(bundle);
        } else {
            throw new IllegalArgumentException("Unexpected Operation Type");
        }
    }
}
