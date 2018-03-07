package com.facebook.messaging.tincan.messenger;

import com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import javax.annotation.Nullable;

/* compiled from: clickable */
public class MessengerDbPreKeyStore {
    private final DbFetchTincanCryptoHandler f18020a;
    private final DbWriteTincanHandler f18021b;
    private final String f18022c;

    public MessengerDbPreKeyStore(DbFetchTincanCryptoHandler dbFetchTincanCryptoHandler, DbWriteTincanHandler dbWriteTincanHandler, String str) {
        this.f18020a = dbFetchTincanCryptoHandler;
        this.f18021b = dbWriteTincanHandler;
        this.f18022c = str;
    }

    @Nullable
    public final byte[] m18012a(int i) {
        return this.f18020a.m17905a(this.f18022c, i);
    }

    public final void m18013b(int i) {
        this.f18021b.a(this.f18022c, i);
    }
}
