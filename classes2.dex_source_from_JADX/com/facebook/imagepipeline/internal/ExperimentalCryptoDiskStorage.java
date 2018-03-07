package com.facebook.imagepipeline.internal;

import android.util.SparseIntArray;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.disk.DefaultDiskStorage.EntryImpl;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorage.Entry;
import com.facebook.cache.disk.DiskStorage.Inserter;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.internal.ByteStreams;
import com.facebook.common.iolite.Closeables;
import com.facebook.common.memory.NoOpMemoryTrimmableRegistry;
import com.facebook.crypto.Crypto;
import com.facebook.crypto.Entity;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.module.FixedKeyChain;
import com.facebook.crypto.module.LoggedInUserCrypto;
import com.facebook.crypto.module.UserCryptoNotAvailableException;
import com.facebook.imagepipeline.memory.GenericByteArrayPool;
import com.facebook.imagepipeline.memory.NoOpPoolStatsTracker;
import com.facebook.imagepipeline.memory.PoolParams;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import javax.inject.Provider;

/* compiled from: op should be remove or update. */
public class ExperimentalCryptoDiskStorage implements DiskStorage {
    static final Entity f10992a = new Entity("some-fixed-value-for-now");
    public static final byte[] f10993j = new byte[]{(byte) 1};
    public static final byte[] f10994k = FixedKeyChain.m16242a("CRPT1");
    public static final byte[] f10995l = FixedKeyChain.m16242a("CRPT2");
    public static final byte[] f10996m = FixedKeyChain.m16242a("CRPT3");
    public static final int f10997n = f10994k.length;
    private final DiskStorage f10998b;
    public final Crypto f10999c;
    public final Crypto f11000d;
    public final Crypto f11001e;
    public final LoggedInUserCrypto f11002f;
    public final GenericByteArrayPool f11003g;
    private final AbstractFbErrorReporter f11004h;
    private volatile Provider<ExperimentalCryptoConfig> f11005i;

    /* compiled from: op should be remove or update. */
    class C07811 implements Runnable {
        final /* synthetic */ ExperimentalCryptoDiskStorage f19792a;

        C07811(ExperimentalCryptoDiskStorage experimentalCryptoDiskStorage) {
            this.f19792a = experimentalCryptoDiskStorage;
        }

        public void run() {
        }
    }

    /* compiled from: op should be remove or update. */
    public class ExperimentalCryptoBinaryResource implements BinaryResource {
        public final BinaryResource f19793a;
        final /* synthetic */ ExperimentalCryptoDiskStorage f19794b;
        private final Runnable f19795c;

        public ExperimentalCryptoBinaryResource(ExperimentalCryptoDiskStorage experimentalCryptoDiskStorage, BinaryResource binaryResource, Runnable runnable) {
            this.f19794b = experimentalCryptoDiskStorage;
            this.f19793a = binaryResource;
            this.f19795c = runnable;
        }

        public final InputStream mo2976a() {
            Throwable e;
            InputStream bufferedInputStream = new BufferedInputStream(this.f19793a.mo2976a());
            try {
                bufferedInputStream.mark(ExperimentalCryptoDiskStorage.f10997n);
                byte[] bArr = new byte[ExperimentalCryptoDiskStorage.f10997n];
                ByteStreams.m3911b(bufferedInputStream, bArr, 0, bArr.length);
                if (ExperimentalCryptoDiskStorage.m16310b(bArr, ExperimentalCryptoDiskStorage.f10993j)) {
                    bufferedInputStream.reset();
                    bufferedInputStream.read();
                    return new RunOnErrorInputStream(this.f19794b.f10999c.m16229a(bufferedInputStream, ExperimentalCryptoDiskStorage.f10992a), this.f19795c);
                } else if (ExperimentalCryptoDiskStorage.m16310b(bArr, ExperimentalCryptoDiskStorage.f10994k)) {
                    return new RunOnErrorInputStream(this.f19794b.f11000d.m16229a(bufferedInputStream, ExperimentalCryptoDiskStorage.f10992a), this.f19795c);
                } else {
                    if (ExperimentalCryptoDiskStorage.m16310b(bArr, ExperimentalCryptoDiskStorage.f10996m)) {
                        return this.f19794b.f11001e.m16229a(bufferedInputStream, ExperimentalCryptoDiskStorage.f10992a);
                    }
                    if (ExperimentalCryptoDiskStorage.m16310b(bArr, ExperimentalCryptoDiskStorage.f10995l)) {
                        return this.f19794b.f11002f.m16307a(bufferedInputStream, ExperimentalCryptoDiskStorage.f10992a);
                    }
                    bufferedInputStream.reset();
                    return bufferedInputStream;
                }
            } catch (CryptoInitializationException e2) {
                e = e2;
                Closeables.m2790a(bufferedInputStream);
                throw new IOException("Error decrypting", e);
            } catch (KeyChainException e3) {
                e = e3;
                Closeables.m2790a(bufferedInputStream);
                throw new IOException("Error decrypting", e);
            } catch (UserCryptoNotAvailableException e4) {
                e = e4;
                Closeables.m2790a(bufferedInputStream);
                throw new IOException("Error decrypting", e);
            } catch (IOException e5) {
                Closeables.m2790a(bufferedInputStream);
                throw e5;
            }
        }

        public final byte[] mo2977b() {
            InputStream bufferedInputStream = new BufferedInputStream(mo2976a());
            try {
                byte[] a = ByteStreams.m3910a(bufferedInputStream, (int) mo2978c());
                return a;
            } finally {
                bufferedInputStream.close();
            }
        }

        public final long mo2978c() {
            return this.f19793a.mo2978c();
        }
    }

    public ExperimentalCryptoDiskStorage(DiskStorage diskStorage, Crypto crypto, Crypto crypto2, Crypto crypto3, LoggedInUserCrypto loggedInUserCrypto, Provider<ExperimentalCryptoConfig> provider, FbErrorReporter fbErrorReporter) {
        this.f10998b = diskStorage;
        this.f10999c = crypto;
        this.f11000d = crypto2;
        this.f11001e = crypto3;
        this.f11002f = loggedInUserCrypto;
        this.f11005i = provider;
        this.f11004h = fbErrorReporter;
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.append(8192, 2);
        this.f11003g = new GenericByteArrayPool(NoOpMemoryTrimmableRegistry.m16319a(), new PoolParams(16384, Integer.MAX_VALUE, sparseIntArray), NoOpPoolStatsTracker.m15750a());
    }

    public final BinaryResource mo2080b(String str, Object obj) {
        BinaryResource b = this.f10998b.mo2080b(str, obj);
        if (b == null) {
            return null;
        }
        return new ExperimentalCryptoBinaryResource(this, b, new C07811(this));
    }

    public final boolean mo2083c(String str, Object obj) {
        return this.f10998b.mo2083c(str, obj);
    }

    public final boolean mo2084d(String str, Object obj) {
        return this.f10998b.mo2084d(str, obj);
    }

    public final void mo2079a() {
        this.f10998b.mo2079a();
    }

    public final Inserter mo2078a(String str, Object obj) {
        return new ExperimentalCryptoInserter(this, (ExperimentalCryptoConfig) this.f11005i.get(), this.f10998b.mo2078a(str, obj));
    }

    public final Collection<Entry> mo2082c() {
        return this.f10998b.mo2082c();
    }

    public final long mo2077a(EntryImpl entryImpl) {
        return this.f10998b.mo2077a(entryImpl);
    }

    public final void mo2081b() {
        this.f10998b.mo2081b();
    }

    public static boolean m16310b(byte[] bArr, byte[] bArr2) {
        if (bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }
}
