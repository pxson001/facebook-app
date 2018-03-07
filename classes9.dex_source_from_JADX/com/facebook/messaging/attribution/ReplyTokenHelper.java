package com.facebook.messaging.attribution;

import android.util.Base64;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.random.SecureRandom_FixedSecureRandomMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: otp?id={%s}&pass={%s} */
public class ReplyTokenHelper implements IHaveUserData {
    private static final String f7915a = ReplyTokenHelper.class.getName();
    private static volatile ReplyTokenHelper f7916h;
    private final DefaultAndroidThreadUtil f7917b;
    private final Clock f7918c;
    private final FbSharedPreferences f7919d;
    private final SecureRandom f7920e;
    @Nullable
    private volatile SecretKey f7921f;
    @Nullable
    private volatile IvParameterSpec f7922g;

    /* compiled from: otp?id={%s}&pass={%s} */
    public final class ReplyTokenData {
        @Nullable
        public final ThreadKey f7912a;
        public final String f7913b;
        public final String f7914c;

        public ReplyTokenData(ThreadKey threadKey, String str, String str2) {
            this.f7912a = threadKey;
            this.f7913b = str;
            this.f7914c = str2;
        }
    }

    public static com.facebook.messaging.attribution.ReplyTokenHelper m8124a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7916h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.attribution.ReplyTokenHelper.class;
        monitor-enter(r1);
        r0 = f7916h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8127b(r0);	 Catch:{ all -> 0x0035 }
        f7916h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7916h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.attribution.ReplyTokenHelper.a(com.facebook.inject.InjectorLike):com.facebook.messaging.attribution.ReplyTokenHelper");
    }

    private static ReplyTokenHelper m8127b(InjectorLike injectorLike) {
        return new ReplyTokenHelper(DefaultAndroidThreadUtil.b(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SecureRandom_FixedSecureRandomMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public ReplyTokenHelper(DefaultAndroidThreadUtil defaultAndroidThreadUtil, Clock clock, FbSharedPreferences fbSharedPreferences, SecureRandom secureRandom) {
        this.f7917b = defaultAndroidThreadUtil;
        this.f7918c = clock;
        this.f7919d = fbSharedPreferences;
        this.f7920e = secureRandom;
    }

    @Nullable
    public final String m8130a(@Nullable ThreadKey threadKey, String str, String str2) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        try {
            return Base64.encodeToString(m8125a(1).doFinal((threadKey + "," + str + "," + str2 + "," + this.f7918c.a() + ",1").getBytes(Charset.forName("UTF-8"))), 0);
        } catch (Throwable e) {
            throw Throwables.propagate(e);
        } catch (Throwable e2) {
            throw Throwables.propagate(e2);
        }
    }

    @Nullable
    public final ReplyTokenData m8129a(@Nullable String str, @Nullable String str2, @Nullable ThreadKey threadKey) {
        if (str == null || str2 == null) {
            return null;
        }
        try {
            String[] split = new String(m8125a(2).doFinal(Base64.decode(str, 0)), Charset.forName("UTF-8")).split(",");
            if (split.length != 5) {
                return null;
            }
            ReplyTokenData replyTokenData = new ReplyTokenData(ThreadKey.a(split[0]), split[1], split[2]);
            if (Objects.equal(threadKey, replyTokenData.f7912a) && str2.equals(replyTokenData.f7913b) && 1 == Integer.parseInt(split[4])) {
                return replyTokenData;
            }
            return null;
        } catch (IllegalBlockSizeException e) {
            return null;
        } catch (BadPaddingException e2) {
            return null;
        } catch (Throwable th) {
            BLog.c(f7915a, "Unexpected throwable decrypting reply token", th);
            return null;
        }
    }

    private Cipher m8125a(int i) {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            m8128b(instance.getBlockSize());
            m8126a();
            try {
                instance.init(i, this.f7921f, this.f7922g);
                return instance;
            } catch (Throwable e) {
                throw Throwables.propagate(e);
            } catch (Throwable e2) {
                throw Throwables.propagate(e2);
            }
        } catch (Throwable e22) {
            throw Throwables.propagate(e22);
        } catch (Throwable e222) {
            throw Throwables.propagate(e222);
        }
    }

    private void m8126a() {
        this.f7917b.a();
        if (this.f7921f == null) {
            String a = this.f7919d.a(MessagingPrefKeys.y, "");
            if (Strings.isNullOrEmpty(a)) {
                try {
                    KeyGenerator instance = KeyGenerator.getInstance("AES");
                    instance.init(256, this.f7920e);
                    SecretKey generateKey = instance.generateKey();
                    this.f7919d.edit().a(MessagingPrefKeys.y, Base64.encodeToString(generateKey.getEncoded(), 0)).commit();
                    this.f7921f = generateKey;
                    return;
                } catch (Throwable e) {
                    throw Throwables.propagate(e);
                }
            }
            byte[] decode = Base64.decode(a, 0);
            this.f7921f = new SecretKeySpec(decode, 0, decode.length, "AES");
        }
    }

    private void m8128b(int i) {
        this.f7917b.a();
        if (this.f7922g == null) {
            byte[] bArr;
            String a = this.f7919d.a(MessagingPrefKeys.z, "");
            if (Strings.isNullOrEmpty(a)) {
                bArr = new byte[i];
                this.f7920e.nextBytes(bArr);
                this.f7919d.edit().a(MessagingPrefKeys.z, Base64.encodeToString(bArr, 0)).commit();
            } else {
                bArr = Base64.decode(a, 0);
            }
            this.f7922g = new IvParameterSpec(bArr);
        }
    }

    public void clearUserData() {
        this.f7921f = null;
        this.f7922g = null;
    }
}
