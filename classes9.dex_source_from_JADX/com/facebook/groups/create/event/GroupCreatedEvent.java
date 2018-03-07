package com.facebook.groups.create.event;

import com.facebook.content.event.FbEvent;
import javax.annotation.Nullable;

/* compiled from: payments_state_error */
public class GroupCreatedEvent implements FbEvent {
    public final String f6788a;
    public final String f6789b;
    public final String f6790c;

    public GroupCreatedEvent(String str, @Nullable String str2, @Nullable String str3) {
        this.f6788a = str;
        this.f6789b = str2;
        this.f6790c = str3;
    }
}
