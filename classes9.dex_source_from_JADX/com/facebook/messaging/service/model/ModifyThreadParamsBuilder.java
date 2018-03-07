package com.facebook.messaging.service.model;

import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadCustomization;
import com.facebook.messaging.service.model.ModifyThreadParams.NicknamePair;
import com.facebook.ui.media.attachments.MediaResource;
import javax.annotation.Nullable;

/* compiled from: content_height */
public class ModifyThreadParamsBuilder {
    public ThreadKey f17237a;
    public String f17238b;
    public boolean f17239c;
    public String f17240d;
    public boolean f17241e;
    public MediaResource f17242f;
    public boolean f17243g;
    public NotificationSetting f17244h;
    public boolean f17245i;
    public boolean f17246j;
    public NicknamePair f17247k;
    public ThreadCustomization f17248l;
    @Nullable
    public String f17249m;
    public boolean f17250n;
    public int f17251o;
    public int f17252p;

    public final ModifyThreadParamsBuilder m17157a(ThreadKey threadKey) {
        this.f17237a = threadKey;
        return this;
    }

    public final ModifyThreadParamsBuilder m17160b(String str) {
        this.f17239c = true;
        this.f17240d = str;
        return this;
    }

    public final ModifyThreadParamsBuilder m17159a(MediaResource mediaResource) {
        this.f17241e = true;
        this.f17242f = mediaResource;
        return this;
    }

    public final ModifyThreadParamsBuilder m17158a(NotificationSetting notificationSetting) {
        this.f17243g = true;
        this.f17244h = notificationSetting;
        return this;
    }

    public final ModifyThreadParams m17161q() {
        return new ModifyThreadParams(this);
    }
}
