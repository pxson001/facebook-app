package com.facebook.timeline.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.NavigationLogger;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.friendlist.constants.FriendListSource;
import com.facebook.friendlist.constants.FriendListType;
import com.facebook.graphql.enums.GraphQLTimelineContextListTargetType;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.model.PhotoSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.timeline.services.data.ProfileContextItemNavigationData;
import com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: unexpected_exception */
public class ProfileContextItemNavigationHandler {
    private static volatile ProfileContextItemNavigationHandler f1114h;
    private final Provider<NavigationLogger> f1115a;
    private final ComposerLauncher f1116b;
    private final FbUriIntentHandler f1117c;
    private final IFeedIntentBuilder f1118d;
    private final SecureContextHelper f1119e;
    private final ProfileServicesIntentBuilder f1120f;
    private final QeAccessor f1121g;

    /* compiled from: unexpected_exception */
    /* synthetic */ class C01111 {
        static final /* synthetic */ int[] f1113a = new int[GraphQLTimelineContextListTargetType.values().length];

        static {
            try {
                f1113a[GraphQLTimelineContextListTargetType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1113a[GraphQLTimelineContextListTargetType.FRIENDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1113a[GraphQLTimelineContextListTargetType.RECENT_FRIENDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1113a[GraphQLTimelineContextListTargetType.MUTUAL_FRIENDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f1113a[GraphQLTimelineContextListTargetType.COMPOSER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static com.facebook.timeline.services.ProfileContextItemNavigationHandler m1189a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1114h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.services.ProfileContextItemNavigationHandler.class;
        monitor-enter(r1);
        r0 = f1114h;	 Catch:{ all -> 0x003a }
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
        r0 = m1193b(r0);	 Catch:{ all -> 0x0035 }
        f1114h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1114h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.services.ProfileContextItemNavigationHandler.a(com.facebook.inject.InjectorLike):com.facebook.timeline.services.ProfileContextItemNavigationHandler");
    }

    private static ProfileContextItemNavigationHandler m1193b(InjectorLike injectorLike) {
        return new ProfileContextItemNavigationHandler(IdBasedSingletonScopeProvider.a(injectorLike, 137), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), ProfileServicesIntentBuilder.m1205a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProfileContextItemNavigationHandler(Provider<NavigationLogger> provider, ComposerLauncher composerLauncher, FbUriIntentHandler fbUriIntentHandler, IFeedIntentBuilder iFeedIntentBuilder, ProfileServicesIntentBuilder profileServicesIntentBuilder, SecureContextHelper secureContextHelper, QeAccessor qeAccessor) {
        this.f1115a = provider;
        this.f1116b = composerLauncher;
        this.f1117c = fbUriIntentHandler;
        this.f1118d = iFeedIntentBuilder;
        this.f1120f = profileServicesIntentBuilder;
        this.f1119e = secureContextHelper;
        this.f1121g = qeAccessor;
    }

    public final void m1194a(Context context, ProfileContextItemNavigationData profileContextItemNavigationData) {
        if (!m1192a(context, profileContextItemNavigationData.f1148f, profileContextItemNavigationData.f1149g, profileContextItemNavigationData.f1150h, profileContextItemNavigationData.f1151i, profileContextItemNavigationData.f1152j, profileContextItemNavigationData.f1155m, profileContextItemNavigationData.f1156n, profileContextItemNavigationData.f1157o, profileContextItemNavigationData.f1153k)) {
            if (!m1191a(context, profileContextItemNavigationData.f1143a, profileContextItemNavigationData.f1144b, profileContextItemNavigationData.f1145c, profileContextItemNavigationData.f1146d, profileContextItemNavigationData.f1147e) && profileContextItemNavigationData.f1154l != null) {
                this.f1117c.a(context, profileContextItemNavigationData.f1154l);
            }
        }
    }

    private boolean m1191a(Context context, int i, String str, @Nullable String str2, @Nullable String str3, FullscreenGallerySource fullscreenGallerySource) {
        String str4 = null;
        switch (i) {
            case 2479791:
                str4 = StringFormatUtil.formatStrLocaleSafe(FBLinks.af, str);
                break;
            case 2645995:
                str4 = StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, str);
                break;
            case 67338874:
                str4 = StringFormatUtil.formatStrLocaleSafe(FBLinks.t, str);
                break;
            case 69076575:
                str4 = StringFormatUtil.formatStrLocaleSafe(FBLinks.u, str);
                break;
            case 77090322:
                IFeedIntentBuilder iFeedIntentBuilder = this.f1118d;
                long parseLong = Long.parseLong(str);
                if (str3 != null) {
                    str4 = PhotoSet.c(Long.parseLong(str3));
                }
                Intent a = iFeedIntentBuilder.a(parseLong, str4, fullscreenGallerySource);
                if (a != null) {
                    this.f1119e.a(a, context);
                }
                return true;
            case 80218325:
                str4 = StringFormatUtil.formatStrLocaleSafe(FBLinks.aS, str, null);
                break;
        }
        if (str4 == null) {
            return false;
        }
        this.f1117c.a(context, str4);
        return true;
    }

    private boolean m1192a(Context context, @Nullable GraphQLTimelineContextListTargetType graphQLTimelineContextListTargetType, String str, @Nullable String str2, @Nullable String str3, @Nullable ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields, @Nullable String str4, @Nullable String str5, @Nullable String str6, String str7) {
        String formatStrLocaleSafe;
        Bundle bundle = new Bundle();
        if (graphQLTimelineContextListTargetType != null) {
            switch (C01111.f1113a[graphQLTimelineContextListTargetType.ordinal()]) {
                case 1:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, str);
                    break;
                case 2:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bf, str, FriendListType.ALL_FRIENDS.name(), FriendListSource.TIMELINE_CONTEXT_ITEM.name());
                    m1190a(bundle, str2, str4, str5, str6);
                    break;
                case 3:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bf, str, FriendListType.RECENTLY_ADDED_FRIENDS.name(), FriendListSource.TIMELINE_CONTEXT_ITEM.name());
                    m1190a(bundle, str2, str4, str5, str6);
                    break;
                case 4:
                    formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.bf, str, FriendListType.MUTUAL_FRIENDS.name(), FriendListSource.TIMELINE_CONTEXT_ITEM.name());
                    m1190a(bundle, str2, str4, str5, str6);
                    break;
                case 5:
                    ((NavigationLogger) this.f1115a.get()).a(str7);
                    this.f1116b.a(null, this.f1120f.m1210a(String.valueOf(str), str2, str3, composerTargetDataPrivacyScopeFields).a(), 1756, (Activity) context);
                    return true;
                default:
                    formatStrLocaleSafe = null;
                    break;
            }
        }
        formatStrLocaleSafe = null;
        if (formatStrLocaleSafe == null) {
            return false;
        }
        this.f1117c.a(context, formatStrLocaleSafe, bundle);
        return true;
    }

    private static void m1190a(Bundle bundle, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        if (str != null) {
            bundle.putString("profile_name", str);
        }
        if (str4 != null) {
            bundle.putString("first_name", str4);
        }
        if (str2 != null) {
            bundle.putString("friendship_status", str2);
        }
        if (str3 != null) {
            bundle.putString("subscribe_status", str3);
        }
    }
}
