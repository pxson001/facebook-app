package com.facebook.dialtone;

import android.os.SystemClock;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: sms */
public class DialtoneWhitelistRegexes {
    public static String f4588a = DialtoneWhitelistRegexes.class.getName();
    public static final List<String> f4589g = Arrays.asList(new String[]{"thumbnail", "map", "about", "privacy", "small_photo", "search", "search_typeahead", "bookmarks", "event_dashboard", "event_suggestions", "event_subscriptions", "page_events_list", "event_profile_pic", "composer", "inline_composer", "notifications_view", "dbl", "reaction_dialog", "attachment_icon", "iorg_common", "qr_code", "bookmark_item_icon", "app_icon_image", "notification_image", "life_event_icon", "preview", "iorg_image_view", "attachment_profile_image", ".*megaphone_.*", "fbui_content_view_thumbnail", "map_url_image", "new_place_creation", "group_admin_cog_icon", "landing", "messenger_image", "qp_image", "fresco_impl", "zero_optin_interstitial", "dialtone_optin_interstitial", "lightswitch_optin_interstitial"});
    public static final List<String> f4590h = Arrays.asList(new String[]{"video_cover_image", "inline_video_cover_image", "page_identity_video", "reaction_dialog_videos"});
    public static final List<String> f4591i = Arrays.asList(new String[]{"^/follow/feedsources.*", "^/ads/preference.*", "^/settings.*", "^/help/android-app.*", "^/\\d.*/allactivity.*", "^/privacy.*", "^/about/privacy.*", "^/policies.*", "^/about/basics/.*", "https://m.facebook.com/help/contact/.*", "^/terms.*", "^/policy.*", "^/communitystandards.*", "^/ad_guidelines.*", "^/page_guidelines.*", "^/payments_terms.*", "^/help.*", "^/pages/create.*", "https://m.facebook.com/groups/create/.*", "^/invite/history.*", "https://(www|m).facebook.com/safetycheck.*", "^(https://m.facebook.com)?/zero/toggle/settings($|\\?.*$|/.*$)", "https://(www|m).facebook.com/events/birthdays.*", "^/legal/thirdpartynotices"});
    public static final List<String> f4592j = Arrays.asList(new String[]{"^(https?)://(m-|z-m-|z-1-|z-n-|)static\\.(ak|xx)\\.fbcdn\\.net/rsrc\\.php($|\\?.*$|/.*$)", "^file://.*"});
    private static volatile DialtoneWhitelistRegexes f4593k;
    @VisibleForTesting
    public long f4594b = 0;
    private final Map<WhitelistSetType, ImmutableSet<Pattern>> f4595c = new HashMap();
    private ObjectMapper f4596d;
    private XConfigReader f4597e;
    private final Lazy<FbErrorReporter> f4598f;

    public static com.facebook.dialtone.DialtoneWhitelistRegexes m8350a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4593k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.dialtone.DialtoneWhitelistRegexes.class;
        monitor-enter(r1);
        r0 = f4593k;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m8353b(r0);	 Catch:{ all -> 0x0035 }
        f4593k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4593k;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.dialtone.DialtoneWhitelistRegexes.a(com.facebook.inject.InjectorLike):com.facebook.dialtone.DialtoneWhitelistRegexes");
    }

    private static DialtoneWhitelistRegexes m8353b(InjectorLike injectorLike) {
        return new DialtoneWhitelistRegexes(IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), FbObjectMapperMethodAutoProvider.m6609a(injectorLike), XConfigReader.m2681a(injectorLike));
    }

    @Inject
    public DialtoneWhitelistRegexes(Lazy<FbErrorReporter> lazy, ObjectMapper objectMapper, XConfigReader xConfigReader) {
        this.f4598f = lazy;
        this.f4596d = objectMapper;
        this.f4597e = xConfigReader;
    }

    public final ImmutableSet<Pattern> m8356a(WhitelistSetType whitelistSetType) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f4594b == 0 || uptimeMillis - this.f4594b > 7200000) {
            m8355e();
        }
        return (ImmutableSet) this.f4595c.get(whitelistSetType);
    }

    @VisibleForTesting
    private static ImmutableSet<Pattern> m8354b(WhitelistSetType whitelistSetType) {
        return ImmutableSet.copyOf(m8352a(whitelistSetType.getWhitePatternList()));
    }

    @Nullable
    private ImmutableSet<Pattern> m8351a(String str) {
        if (!"XCONFIG_FETCH_DID_NOT_RETURN_RESULTS".equals(str)) {
            try {
                return ImmutableSet.copyOf(m8352a((List) this.f4596d.m6655a(str, new 1(this))));
            } catch (Throwable e) {
                Throwable th = e;
                ((AbstractFbErrorReporter) this.f4598f.get()).m2343a("getWhitelistedTagRegexes", th.getMessage(), th);
            }
        }
        return null;
    }

    private void m8355e() {
        for (WhitelistSetType whitelistSetType : WhitelistSetType.values()) {
            ImmutableSet a = m8351a(this.f4597e.m2685a(whitelistSetType.getXConfigSetting(), "XCONFIG_FETCH_DID_NOT_RETURN_RESULTS"));
            if (a != null) {
                this.f4595c.put(whitelistSetType, a);
            } else if (((ImmutableSet) this.f4595c.get(whitelistSetType)) == null) {
                this.f4595c.put(whitelistSetType, m8354b(whitelistSetType));
            }
        }
        this.f4594b = SystemClock.uptimeMillis();
    }

    @VisibleForTesting
    private static List<Pattern> m8352a(Collection<String> collection) {
        List arrayList = new ArrayList(collection.size());
        for (String compile : collection) {
            arrayList.add(Pattern.compile(compile, 2));
        }
        return arrayList;
    }
}
