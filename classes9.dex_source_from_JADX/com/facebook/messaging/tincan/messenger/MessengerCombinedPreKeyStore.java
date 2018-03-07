package com.facebook.messaging.tincan.messenger;

import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.tincan.database.DbFetchTincanCryptoHandler;
import com.facebook.messaging.tincan.database.DbWriteTincanHandler;
import javax.inject.Inject;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.PreKeyStore;
import org.whispersystems.libsignal.state.SignedPreKeyRecord;
import org.whispersystems.libsignal.state.SignedPreKeyStore;

/* compiled from: clientTags */
public class MessengerCombinedPreKeyStore implements PreKeyStore, SignedPreKeyStore {
    private static final Class<?> f18010a = MessengerCombinedPreKeyStore.class;
    private final SystemClock f18011b;
    private final MessengerDbPreKeyStore f18012c;
    private final MessengerDbPreKeyStore f18013d;

    private static MessengerCombinedPreKeyStore m17999b(InjectorLike injectorLike) {
        return new MessengerCombinedPreKeyStore(DbFetchTincanCryptoHandler.m17899a(injectorLike), DbWriteTincanHandler.a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MessengerCombinedPreKeyStore(DbFetchTincanCryptoHandler dbFetchTincanCryptoHandler, DbWriteTincanHandler dbWriteTincanHandler, SystemClock systemClock) {
        this.f18011b = systemClock;
        this.f18012c = new MessengerDbPreKeyStore(dbFetchTincanCryptoHandler, dbWriteTincanHandler, "pre_keys");
        this.f18013d = new MessengerDbPreKeyStore(dbFetchTincanCryptoHandler, dbWriteTincanHandler, "signed_pre_keys");
    }

    public final synchronized PreKeyRecord mo703a(int i) {
        byte[] a;
        a = this.f18012c.m18012a(i);
        if (a == null) {
            throw new InvalidKeyIdException("Pre-key not found in store");
        }
        try {
        } catch (Throwable e) {
            BLog.b(f18010a, "Error retrieving pre-key from store", e);
            throw new RuntimeException(e);
        }
        return new PreKeyRecord(a);
    }

    public final synchronized void mo708b(int i) {
        this.f18012c.m18013b(i);
    }

    public final synchronized SignedPreKeyRecord mo711c(int i) {
        byte[] a;
        a = this.f18013d.m18012a(i);
        if (a == null) {
            throw new InvalidKeyIdException("Signed pre-key not found in store");
        }
        try {
        } catch (Throwable e) {
            BLog.b(f18010a, "Error retrieving signed pre-key from store", e);
            throw new RuntimeException(e);
        }
        return new SignedPreKeyRecord(a);
    }
}
