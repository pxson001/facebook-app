package com.facebook.contacts.server;

import com.facebook.contacts.graphql.Contact;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: page_messenger_bot */
public class FetchAllContactsResultBuilder {
    public DataFreshnessResult f8430a;
    public long f8431b;
    public ImmutableList<Contact> f8432c;
    public String f8433d;
    public boolean f8434e;
    public String f8435f;
    public String f8436g;

    public final FetchAllContactsResultBuilder m12287a(@Nullable String str) {
        this.f8436g = str;
        return this;
    }

    public final FetchAllContactsResultBuilder m12286a(FetchAllContactsResult fetchAllContactsResult) {
        this.f8430a = fetchAllContactsResult.freshness;
        this.f8431b = fetchAllContactsResult.clientTimeMs;
        this.f8432c = fetchAllContactsResult.a;
        this.f8433d = fetchAllContactsResult.b;
        this.f8434e = fetchAllContactsResult.c;
        this.f8435f = fetchAllContactsResult.d;
        this.f8436g = fetchAllContactsResult.e;
        return this;
    }

    public final FetchAllContactsResult m12288h() {
        return new FetchAllContactsResult(this);
    }
}
