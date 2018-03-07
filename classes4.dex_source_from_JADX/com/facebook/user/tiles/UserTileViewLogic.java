package com.facebook.user.tiles;

import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Contacts;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.PicSquare;
import com.facebook.user.model.PicSquareUrlWithSize;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewParams.Type;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: setVolume */
public class UserTileViewLogic {
    private static final Class<?> f2398c = UserTileViewLogic.class;
    private static volatile UserTileViewLogic f2399g;
    @Inject
    volatile Provider<LoggedInUserSessionManager> f2400a = UltralightRuntime.a;
    @Inject
    volatile Provider<PlatformAppHttpConfig> f2401b = UltralightRuntime.a;
    private final Provider<UserCache> f2402d;
    private final AbstractFbErrorReporter f2403e;
    private final boolean f2404f;

    public static com.facebook.user.tiles.UserTileViewLogic m2670a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2399g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.user.tiles.UserTileViewLogic.class;
        monitor-enter(r1);
        r0 = f2399g;	 Catch:{ all -> 0x003a }
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
        r0 = m2672b(r0);	 Catch:{ all -> 0x0035 }
        f2399g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2399g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.tiles.UserTileViewLogic.a(com.facebook.inject.InjectorLike):com.facebook.user.tiles.UserTileViewLogic");
    }

    private static UserTileViewLogic m2672b(InjectorLike injectorLike) {
        UserTileViewLogic userTileViewLogic = new UserTileViewLogic(IdBasedProvider.a(injectorLike, 3593), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike));
        userTileViewLogic.m2671a(IdBasedSingletonScopeProvider.a(injectorLike, 339), IdBasedProvider.a(injectorLike, 2243));
        return userTileViewLogic;
    }

    @Inject
    private UserTileViewLogic(Provider<UserCache> provider, FbErrorReporter fbErrorReporter, Boolean bool) {
        this.f2402d = provider;
        this.f2403e = fbErrorReporter;
        this.f2404f = bool.booleanValue();
    }

    private void m2671a(Provider<LoggedInUserSessionManager> provider, Provider<PlatformAppHttpConfig> provider2) {
        this.f2400a = provider;
        this.f2401b = provider2;
    }

    public final ImageRequest m2674a(UserTileViewParams userTileViewParams, int i, int i2) {
        if (userTileViewParams == null) {
            return null;
        }
        Integer.valueOf(i);
        Integer.valueOf(i2);
        switch (userTileViewParams.f5726b) {
            case PIC_SQUARE:
                return m2662a(userTileViewParams.f5728d, i, i2, userTileViewParams.f5727c);
            case USER_KEY:
                return m2665a(userTileViewParams.f5727c, i, i2);
            case USER_KEY_WITH_FALLBACK_PIC_SQUARE:
                return m2666a(userTileViewParams.f5727c, i, i2, userTileViewParams.f5728d);
            case ADDRESS_BOOK_CONTACT:
                ImageRequest a = m2668a(userTileViewParams.f5730f);
                if (a == null) {
                    return m2660a(i);
                }
                return a;
            default:
                throw new IllegalStateException("not reached");
        }
    }

    public static ImageRequest m2667a(UserTileViewParams userTileViewParams, int i) {
        if (userTileViewParams == null || userTileViewParams.f5726b != Type.ADDRESS_BOOK_CONTACT) {
            return null;
        }
        return m2660a(i);
    }

    public static ImageRequest m2664a(UserKey userKey, int i) {
        if (userKey == null || !userKey.e()) {
            return null;
        }
        return m2660a(i);
    }

    private ImageRequest m2665a(UserKey userKey, int i, int i2) {
        return m2663a(((UserCache) this.f2402d.get()).m10373a(userKey), userKey, i, i2);
    }

    private ImageRequest m2666a(UserKey userKey, int i, int i2, PicSquare picSquare) {
        User a = ((UserCache) this.f2402d.get()).m10373a(userKey);
        if (a != null) {
            return m2663a(a, userKey, i, i2);
        }
        return m2662a(picSquare, i, i2, userKey);
    }

    private static PicSquareUrlWithSize m2669a(PicSquare picSquare, int i) {
        PicSquareUrlWithSize a = picSquare.m2096a(i);
        PicSquareUrlWithSize a2 = picSquare.m2096a(i - ((i * 25) / 100));
        if (Math.abs(i - a2.size) >= Math.abs(i - a.size)) {
            return a;
        }
        Integer.valueOf(i);
        Integer.valueOf(a.size);
        Integer.valueOf(a2.size);
        String str = a2.url;
        return a2;
    }

    private ImageRequest m2662a(PicSquare picSquare, int i, int i2, UserKey userKey) {
        PicSquareUrlWithSize a = m2669a(picSquare, i2);
        if (userKey != null) {
            userKey.b();
        }
        Integer.valueOf(i2);
        Integer.valueOf(a.size);
        String str = a.url;
        Uri parse = Uri.parse(a.url);
        if (parse.isAbsolute()) {
            return ImageRequest.a(parse);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid PicSquareUri:").append(a.url);
        if (userKey != null) {
            stringBuilder.append("|user=").append(userKey.toString());
        }
        stringBuilder.append("|tw=").append(i);
        stringBuilder.append("|th=").append(i2);
        ImmutableList a2 = picSquare.m2097a();
        int size = a2.size();
        for (int i3 = 0; i3 < size; i3++) {
            a = (PicSquareUrlWithSize) a2.get(i3);
            stringBuilder.append("|url_").append(a.size).append(":").append(a.url);
        }
        this.f2403e.a(f2398c.toString(), stringBuilder.toString());
        return null;
    }

    private ImageRequest m2663a(@Nullable User user, UserKey userKey, int i, int i2) {
        ImageRequest imageRequest;
        if (user == null || user.z() == null) {
            imageRequest = null;
        } else {
            imageRequest = m2662a(user.z(), i, i2, userKey);
        }
        if (imageRequest != null) {
            return imageRequest;
        }
        if (userKey != null && userKey.a() == User.Type.FACEBOOK && !Objects.equal(userKey.b(), "0")) {
            Uri a = m2673a(userKey.b(), i, i2);
            if (this.f2404f) {
                Integer.valueOf(i);
                Integer.valueOf(i2);
            }
            return ImageRequest.a(a);
        } else if (userKey == null || !userKey.e()) {
            return null;
        } else {
            imageRequest = m2668a(userKey.f());
            if (imageRequest == null) {
                return m2660a(i);
            }
            return imageRequest;
        }
    }

    private static ImageRequest m2668a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        return ImageRequest.a(Uri.withAppendedPath(Contacts.CONTENT_URI, String.valueOf(str)));
    }

    private static ImageRequest m2660a(int i) {
        return ImageRequest.a(Uri.parse("res:///" + 2130843401));
    }

    public static ImageRequest m2661a(Uri uri) {
        return ImageRequest.a(uri);
    }

    public final Uri m2673a(String str, int i, int i2) {
        Builder appendQueryParameter = ((PlatformAppHttpConfig) this.f2401b.get()).b().appendEncodedPath(str).appendEncodedPath("picture").appendQueryParameter("type", "square").appendQueryParameter("width", String.valueOf(i)).appendQueryParameter("height", String.valueOf(i2));
        if (this.f2404f) {
            LoggedInUserSessionManager loggedInUserSessionManager = (LoggedInUserSessionManager) this.f2400a.get();
            if (loggedInUserSessionManager.a() != null) {
                appendQueryParameter.appendQueryParameter("access_token", loggedInUserSessionManager.a().mAuthToken);
            }
        }
        return appendQueryParameter.build();
    }
}
