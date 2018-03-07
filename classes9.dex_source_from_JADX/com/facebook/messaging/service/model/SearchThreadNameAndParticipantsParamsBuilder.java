package com.facebook.messaging.service.model;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: contact_logs_upload_started */
public class SearchThreadNameAndParticipantsParamsBuilder {
    public int f17291a = 20;
    public String f17292b = "";
    public boolean f17293c = false;

    SearchThreadNameAndParticipantsParamsBuilder() {
    }

    public final SearchThreadNameAndParticipantsParamsBuilder m17168a(int i) {
        this.f17291a = i;
        return this;
    }

    public final SearchThreadNameAndParticipantsParamsBuilder m17169a(String str) {
        this.f17292b = str;
        return this;
    }

    public final SearchThreadNameAndParticipantsParamsBuilder m17170a(boolean z) {
        this.f17293c = z;
        return this;
    }

    public final SearchThreadNameAndParticipantsParams m17171d() {
        return new SearchThreadNameAndParticipantsParams(this);
    }
}
