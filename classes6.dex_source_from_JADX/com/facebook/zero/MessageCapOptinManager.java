package com.facebook.zero;

import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.zero.capping.MessageCapOptinListener;
import com.facebook.zero.sdk.common.TokenRequestReason;
import com.facebook.zero.sdk.constants.ZeroTokenType;
import com.facebook.zero.sdk.request.FetchZeroInterstitialContentResult;
import com.facebook.zero.sdk.token.ZeroToken;
import com.facebook.zero.sdk.token.ZeroTokenFetchListener;
import com.facebook.zero.sdk.token.ZeroTokenFetcher;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetchListener;
import com.facebook.zero.sdk.util.ZeroOptinInterstitialContentFetcher;
import com.facebook.zero.service.FbZeroTokenFetcher;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.platform.extra.ACCESS_TOKEN */
public class MessageCapOptinManager {
    private static volatile MessageCapOptinManager f20241g;
    public final ZeroTokenFetcher f20242a;
    public final ZeroOptinInterstitialContentFetcher f20243b;
    public final Provider<MessageCapAccessor> f20244c;
    public final DefaultAndroidThreadUtil f20245d;
    public Set<MessageCapOptinListener> f20246e = new HashSet();
    public final ZeroOptinInterstitialContentFetchListener f20247f = new C15331(this);

    /* compiled from: com.facebook.platform.extra.ACCESS_TOKEN */
    class C15331 implements ZeroOptinInterstitialContentFetchListener {
        final /* synthetic */ MessageCapOptinManager f20240a;

        /* compiled from: com.facebook.platform.extra.ACCESS_TOKEN */
        class C15321 implements ZeroTokenFetchListener {
            final /* synthetic */ C15331 f20239a;

            /* compiled from: com.facebook.platform.extra.ACCESS_TOKEN */
            class C15311 implements Runnable {
                final /* synthetic */ C15321 f20238a;

                C15311(C15321 c15321) {
                    this.f20238a = c15321;
                }

                public void run() {
                    Iterator it = new HashSet(this.f20238a.f20239a.f20240a.f20246e).iterator();
                    while (it.hasNext()) {
                        ((MessageCapOptinListener) it.next()).mo1525a();
                    }
                }
            }

            C15321(C15331 c15331) {
                this.f20239a = c15331;
            }

            public final void m28850a(Throwable th, ZeroTokenType zeroTokenType) {
                this.f20239a.f20240a.f20242a.b(this);
            }

            public final void m28849a(ZeroToken zeroToken, ZeroTokenType zeroTokenType) {
                this.f20239a.f20240a.f20242a.b(this);
                this.f20239a.f20240a.f20244c.get();
                this.f20239a.f20240a.f20245d.a(new C15311(this));
            }
        }

        C15331(MessageCapOptinManager messageCapOptinManager) {
            this.f20240a = messageCapOptinManager;
        }

        public final void m28852a(Throwable th) {
            this.f20240a.f20243b.b(this);
        }

        public final void m28851a(@Nullable FetchZeroInterstitialContentResult fetchZeroInterstitialContentResult) {
            this.f20240a.f20243b.b(this);
            this.f20240a.f20242a.a(new C15321(this));
            this.f20240a.f20242a.a(ZeroTokenType.NORMAL, TokenRequestReason.MESSENGE_CAP_OPTIN);
        }
    }

    public static com.facebook.zero.MessageCapOptinManager m28853a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20241g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.zero.MessageCapOptinManager.class;
        monitor-enter(r1);
        r0 = f20241g;	 Catch:{ all -> 0x003a }
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
        r0 = m28854b(r0);	 Catch:{ all -> 0x0035 }
        f20241g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20241g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.MessageCapOptinManager.a(com.facebook.inject.InjectorLike):com.facebook.zero.MessageCapOptinManager");
    }

    private static MessageCapOptinManager m28854b(InjectorLike injectorLike) {
        return new MessageCapOptinManager((ZeroTokenFetcher) FbZeroTokenFetcher.a(injectorLike), ZeroOptinInterstitialContentFetcher.b(injectorLike), IdBasedProvider.a(injectorLike, 11785), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public MessageCapOptinManager(ZeroTokenFetcher zeroTokenFetcher, ZeroOptinInterstitialContentFetcher zeroOptinInterstitialContentFetcher, Provider<MessageCapAccessor> provider, AndroidThreadUtil androidThreadUtil) {
        this.f20242a = zeroTokenFetcher;
        this.f20243b = zeroOptinInterstitialContentFetcher;
        this.f20244c = provider;
        this.f20245d = androidThreadUtil;
    }

    public final void m28855a(MessageCapOptinListener messageCapOptinListener) {
        this.f20246e.add(messageCapOptinListener);
    }

    public final void m28856b(MessageCapOptinListener messageCapOptinListener) {
        this.f20246e.remove(messageCapOptinListener);
    }
}
