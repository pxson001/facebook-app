package com.facebook.notifications.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.widget.TextView;
import com.facebook.adsmanager.deeplinking.AdsManagerDeepLinkingUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.RangeConverter;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.events.common.EventsUriUtil;
import com.facebook.faceweb.FacewebUriUtil;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.linkutil.LinkExtractorConverter;
import com.facebook.graphql.model.GraphQLAggregatedEntitiesAtRange;
import com.facebook.graphql.model.GraphQLEntityAtRange;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.text.CustomFontUtil;
import com.facebook.ui.emoji.EmojiUtil;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: expires_at */
public class NotificationStoryHelper {
    private static final String f12569a = NotificationStoryHelper.class.getSimpleName();
    private static final GraphQLStoryAttachmentStyle f12570i = GraphQLStoryAttachmentStyle.NOTIFICATION_TARGET;
    private static final GraphQLStoryAttachmentStyle f12571j = GraphQLStoryAttachmentStyle.AVATAR;
    private static final Set<GraphQLStoryAttachmentStyle> f12572k = ImmutableSet.of(GraphQLStoryAttachmentStyle.PHOTO, GraphQLStoryAttachmentStyle.ALBUM, GraphQLStoryAttachmentStyle.SHARE_LARGE_IMAGE, GraphQLStoryAttachmentStyle.IMAGE_SHARE);
    private static volatile NotificationStoryHelper f12573l;
    private final GraphQLLinkExtractor f12574b;
    private final CustomFontUtil f12575c;
    private final EmojiUtil f12576d;
    private final AbstractFbErrorReporter f12577e;
    private final UriIntentMapper f12578f;
    private final Provider<Boolean> f12579g;
    private final AdsManagerDeepLinkingUtils f12580h;

    public static com.facebook.notifications.util.NotificationStoryHelper m13347a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12573l;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.notifications.util.NotificationStoryHelper.class;
        monitor-enter(r1);
        r0 = f12573l;	 Catch:{ all -> 0x003a }
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
        r0 = m13353b(r0);	 Catch:{ all -> 0x0035 }
        f12573l = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12573l;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationStoryHelper.a(com.facebook.inject.InjectorLike):com.facebook.notifications.util.NotificationStoryHelper");
    }

    private static NotificationStoryHelper m13353b(InjectorLike injectorLike) {
        return new NotificationStoryHelper(GraphQLLinkExtractor.a(injectorLike), CustomFontUtil.a(injectorLike), EmojiUtil.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4015), AdsManagerDeepLinkingUtils.m13362a(injectorLike));
    }

    @Inject
    public NotificationStoryHelper(GraphQLLinkExtractor graphQLLinkExtractor, CustomFontUtil customFontUtil, EmojiUtil emojiUtil, UriIntentMapper uriIntentMapper, FbErrorReporter fbErrorReporter, Provider<Boolean> provider, AdsManagerDeepLinkingUtils adsManagerDeepLinkingUtils) {
        this.f12574b = graphQLLinkExtractor;
        this.f12575c = customFontUtil;
        this.f12576d = emojiUtil;
        this.f12578f = uriIntentMapper;
        this.f12577e = fbErrorReporter;
        this.f12579g = provider;
        this.f12580h = adsManagerDeepLinkingUtils;
    }

    @Nullable
    public final Intent m13355a(Context context, GraphQLStory graphQLStory) {
        if (context == null || graphQLStory == null) {
            return null;
        }
        String a = m13348a(graphQLStory);
        if (Strings.isNullOrEmpty(a)) {
            a = m13359b(graphQLStory);
        }
        return Strings.isNullOrEmpty(a) ? null : this.f12578f.a(context, a);
    }

    @Nullable
    public static String m13348a(GraphQLStory graphQLStory) {
        if (graphQLStory == null) {
            return null;
        }
        String aO = graphQLStory.aO();
        if (aO == null || !FacebookUriUtil.d(Uri.parse(aO))) {
            return null;
        }
        return aO;
    }

    @Nullable
    public final String m13359b(@Nonnull GraphQLStory graphQLStory) {
        String str = null;
        Preconditions.checkNotNull(graphQLStory);
        GraphQLStoryAttachment e = m13354e(graphQLStory);
        if (e == null) {
            return null;
        }
        if (Strings.isNullOrEmpty(null)) {
            str = m13349a(graphQLStory, e);
        }
        if (!(!Strings.isNullOrEmpty(str) || e.z() == null || e.z().J() == null || e.z().J().isEmpty())) {
            str = (String) e.z().J().get(0);
            if (!Strings.isNullOrEmpty(str)) {
                str = m13350a(FacewebUriUtil.a(str, "notification"));
            }
        }
        if (Strings.isNullOrEmpty(str) && e.z() != null) {
            str = this.f12574b.a(LinkExtractorConverter.m14647a(e.z()));
            if (EventsUriUtil.a(str)) {
                str = m13350a(str);
            }
        }
        if (Strings.isNullOrEmpty(str)) {
            str = e.C();
        }
        if (Strings.isNullOrEmpty(str)) {
            return graphQLStory.aO();
        }
        return str;
    }

    @Nullable
    public final GraphQLObjectType m13360c(@Nonnull GraphQLStory graphQLStory) {
        GraphQLStoryAttachment e = m13354e(graphQLStory);
        if (e == null || e.z() == null) {
            return null;
        }
        return e.z().j();
    }

    @Nullable
    public static GraphQLStoryAttachment m13354e(@Nonnull GraphQLStory graphQLStory) {
        if (StoryAttachmentHelper.p(graphQLStory) != null) {
            return StoryAttachmentHelper.p(graphQLStory);
        }
        if (StoryAttachmentHelper.a(graphQLStory)) {
            for (GraphQLStoryAttachment graphQLStoryAttachment : graphQLStory.x()) {
                if (graphQLStoryAttachment.w().contains(f12570i)) {
                    return graphQLStoryAttachment;
                }
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m13349a(com.facebook.graphql.model.GraphQLStory r14, com.facebook.graphql.model.GraphQLStoryAttachment r15) {
        /*
        r13 = this;
        r4 = 1;
        r2 = 0;
        r3 = 0;
        r0 = r15.j();
        if (r0 == 0) goto L_0x0013;
    L_0x0009:
        r0 = r15.j();
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x0015;
    L_0x0013:
        r0 = r2;
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = r15.j();
        r0 = r0.get(r3);
        r0 = (com.facebook.graphql.model.GraphQLStoryActionLink) r0;
        r1 = r0.a();
        if (r1 != 0) goto L_0x0027;
    L_0x0025:
        r0 = r2;
        goto L_0x0014;
    L_0x0027:
        r1 = r0.a();
        r1 = r1.g();
        switch(r1) {
            case -1787941669: goto L_0x003b;
            case -983741576: goto L_0x0141;
            case -892837591: goto L_0x01fc;
            case -864712441: goto L_0x0034;
            case -543954045: goto L_0x01b2;
            case -301083314: goto L_0x0089;
            case -273761143: goto L_0x0092;
            case -89875450: goto L_0x0190;
            case 44201556: goto L_0x0174;
            case 69109412: goto L_0x0065;
            case 411361907: goto L_0x0264;
            case 453416464: goto L_0x0240;
            case 480241871: goto L_0x01da;
            case 823880548: goto L_0x011d;
            case 962708191: goto L_0x0052;
            case 1410677182: goto L_0x02a0;
            case 1486159872: goto L_0x0292;
            case 1511838959: goto L_0x026a;
            case 1688477735: goto L_0x0057;
            case 1791695039: goto L_0x00fa;
            case 1951852603: goto L_0x021e;
            case 2070503269: goto L_0x0062;
            case 2072481101: goto L_0x0065;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r2;
        goto L_0x0014;
    L_0x0034:
        r0 = com.facebook.common.fblinks.FBLinks.eK;
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r0);
        goto L_0x0014;
    L_0x003b:
        r0 = r0.aE();
        r1 = com.facebook.common.fblinks.FBLinks.fd;
        r2 = "article=";
        r2 = r0.indexOf(r2);
        r2 = r2 + 8;
        r0 = r0.substring(r2);
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r1, r0);
        goto L_0x0014;
    L_0x0052:
        r0 = r0.aE();
        goto L_0x0014;
    L_0x0057:
        r0 = com.facebook.common.fblinks.FBLinks.dF;
        r1 = com.facebook.graphql.enums.GraphQLSavedDashboardSectionType.ALL;
        r2 = "43";
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r0, r1, r2);
        goto L_0x0014;
    L_0x0062:
        r0 = com.facebook.common.fblinks.FBLinks.T;
        goto L_0x0014;
    L_0x0065:
        r0 = r0.a();
        r0 = r0.g();
        r8 = 0;
        r5 = com.facebook.common.fblinks.FBLinks.cQ;
        r6 = "notification";
        r6 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r5, r6);
        r5 = r15.x();
        if (r5 == 0) goto L_0x0086;
    L_0x007c:
        r5 = r15.x();
        r5 = r5.isEmpty();
        if (r5 == 0) goto L_0x02cb;
    L_0x0086:
        r5 = r6;
    L_0x0087:
        r0 = r5;
        goto L_0x0014;
    L_0x0089:
        r0 = com.facebook.common.fblinks.FBLinks.ej;
        r1 = "notification";
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r0, r1);
        goto L_0x0014;
    L_0x0092:
        r1 = com.facebook.common.fblinks.FBLinks.dV;
        r0 = r15.x();
        if (r0 == 0) goto L_0x02c8;
    L_0x009a:
        r0 = r15.x();
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x02c8;
    L_0x00a4:
        r0 = r15.x();
        r0 = r0.get(r3);
        if (r0 == 0) goto L_0x02c8;
    L_0x00ae:
        r0 = r15.x();
        r0 = r0.get(r3);
        r0 = (com.facebook.graphql.model.GraphQLStoryAttachment) r0;
        r0 = r0.z();
        if (r0 == 0) goto L_0x02c8;
    L_0x00be:
        r0 = r15.x();
        r0 = r0.get(r3);
        r0 = (com.facebook.graphql.model.GraphQLStoryAttachment) r0;
        r0 = r0.z();
        r0 = r0.dp();
        if (r0 == 0) goto L_0x02c8;
    L_0x00d2:
        r0 = r15.x();
        r0 = com.google.common.collect.Iterables.g(r0);
        r0 = (com.facebook.graphql.model.GraphQLStoryAttachment) r0;
        r0 = r0.z();
        r0 = r0.dp();
        r0 = r1.concat(r0);
    L_0x00e8:
        r0 = android.net.Uri.parse(r0);
        r1 = "source";
        r2 = "notification";
        r0 = com.facebook.common.util.FacebookUriUtil.a(r0, r1, r2);
        r0 = r0.toString();
        goto L_0x0014;
    L_0x00fa:
        r3 = r15.z();
        if (r3 == 0) goto L_0x011b;
    L_0x0100:
        r1 = r3.j();
    L_0x0104:
        if (r1 == 0) goto L_0x011d;
    L_0x0106:
        r1 = r1.g();
        r4 = 69076575; // 0x41e065f float:1.8575736E-36 double:3.41283626E-316;
        if (r1 != r4) goto L_0x011d;
    L_0x010f:
        r0 = com.facebook.common.fblinks.FBLinks.L;
        r1 = r3.dp();
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r0, r1);
        goto L_0x0014;
    L_0x011b:
        r1 = r2;
        goto L_0x0104;
    L_0x011d:
        r1 = r15.z();
        if (r1 == 0) goto L_0x0141;
    L_0x0123:
        r1 = r15.z();
        r1 = r1.dp();
        r1 = com.google.common.base.Strings.isNullOrEmpty(r1);
        if (r1 != 0) goto L_0x0141;
    L_0x0131:
        r0 = com.facebook.common.fblinks.FBLinks.dz;
        r1 = r15.z();
        r1 = r1.dp();
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r0, r1);
        goto L_0x0014;
    L_0x0141:
        r1 = r13.f12579g;
        r1 = r1.get();
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 == 0) goto L_0x0032;
    L_0x014f:
        r0 = r0.aE();
        r1 = com.google.common.base.Strings.isNullOrEmpty(r0);
        if (r1 != 0) goto L_0x0032;
    L_0x0159:
        r0 = android.net.Uri.parse(r0);
        r1 = "group_id";
        r0 = r0.getQueryParameter(r1);
        r1 = com.google.common.base.Strings.isNullOrEmpty(r0);
        if (r1 != 0) goto L_0x0171;
    L_0x0169:
        r1 = com.facebook.common.fblinks.FBLinks.u;
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r1, r0);
        goto L_0x0014;
    L_0x0171:
        r0 = r2;
        goto L_0x0014;
    L_0x0174:
        r0 = r15.z();
        if (r0 == 0) goto L_0x0032;
    L_0x017a:
        r1 = r0.dp();
        r1 = com.google.common.base.Strings.isNullOrEmpty(r1);
        if (r1 != 0) goto L_0x0032;
    L_0x0184:
        r1 = com.facebook.common.fblinks.FBLinks.u;
        r0 = r0.dp();
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r1, r0);
        goto L_0x0014;
    L_0x0190:
        r1 = r0.aA();
        if (r1 == 0) goto L_0x0032;
    L_0x0196:
        r0 = r0.aA();
        r0 = r0.j();
        if (r0 == 0) goto L_0x0032;
    L_0x01a0:
        if (r14 == 0) goto L_0x0032;
    L_0x01a2:
        r0 = com.facebook.common.fblinks.FBLinks.bE;
        r1 = new java.lang.Object[r4];
        r2 = r14.g();
        r1[r3] = r2;
        r0 = com.facebook.common.stringformat.StringFormatUtil.a(r0, r1);
        goto L_0x0014;
    L_0x01b2:
        r1 = r0.A();
        if (r1 == 0) goto L_0x0032;
    L_0x01b8:
        r1 = r0.A();
        r1 = r1.as();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x0032;
    L_0x01c6:
        r1 = com.facebook.common.fblinks.FBLinks.bN;
        r2 = new java.lang.Object[r4];
        r0 = r0.A();
        r0 = r0.as();
        r2[r3] = r0;
        r0 = com.facebook.common.stringformat.StringFormatUtil.a(r1, r2);
        goto L_0x0014;
    L_0x01da:
        r1 = r0.G();
        if (r1 == 0) goto L_0x01fc;
    L_0x01e0:
        r1 = r0.G();
        r1 = r1.I();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x01fc;
    L_0x01ee:
        r0 = r0.G();
        r0 = r0.I();
        r0 = com.facebook.groups.constants.GroupMsiteUrls.d(r0);
        goto L_0x0014;
    L_0x01fc:
        r1 = r0.G();
        if (r1 == 0) goto L_0x021e;
    L_0x0202:
        r1 = r0.G();
        r1 = r1.I();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x021e;
    L_0x0210:
        r0 = r0.G();
        r0 = r0.I();
        r0 = com.facebook.groups.constants.GroupMsiteUrls.e(r0);
        goto L_0x0014;
    L_0x021e:
        r1 = r0.G();
        if (r1 == 0) goto L_0x0240;
    L_0x0224:
        r1 = r0.G();
        r1 = r1.I();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x0240;
    L_0x0232:
        r0 = r0.G();
        r0 = r0.I();
        r0 = com.facebook.groups.constants.GroupMsiteUrls.c(r0);
        goto L_0x0014;
    L_0x0240:
        r0 = r15.z();
        if (r0 == 0) goto L_0x0032;
    L_0x0246:
        r0 = r15.z();
        r0 = r0.dp();
        r0 = com.google.common.base.Strings.isNullOrEmpty(r0);
        if (r0 != 0) goto L_0x0032;
    L_0x0254:
        r0 = com.facebook.common.fblinks.FBLinks.an;
        r1 = r15.z();
        r1 = r1.dp();
        r0 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r0, r1);
        goto L_0x0014;
    L_0x0264:
        r0 = r0.aE();
        goto L_0x0014;
    L_0x026a:
        r1 = r0.A();
        if (r1 == 0) goto L_0x0032;
    L_0x0270:
        r1 = r0.A();
        r1 = r1.as();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x0032;
    L_0x027e:
        r1 = com.facebook.common.fblinks.FBLinks.t;
        r2 = new java.lang.Object[r4];
        r0 = r0.A();
        r0 = r0.as();
        r2[r3] = r0;
        r0 = com.facebook.common.stringformat.StringFormatUtil.a(r1, r2);
        goto L_0x0014;
    L_0x0292:
        r1 = r13.f12580h;
        r1 = r1.m13365a();
        if (r1 == 0) goto L_0x0032;
    L_0x029a:
        r0 = r0.aE();
        goto L_0x0014;
    L_0x02a0:
        r1 = r0.aJ();
        if (r1 == 0) goto L_0x0032;
    L_0x02a6:
        r1 = r0.aJ();
        r1 = r1.c();
        r1 = com.facebook.common.util.StringUtil.a(r1);
        if (r1 != 0) goto L_0x0032;
    L_0x02b4:
        r1 = com.facebook.common.fblinks.FBLinks.ge;
        r2 = new java.lang.Object[r4];
        r0 = r0.aJ();
        r0 = r0.c();
        r2[r3] = r0;
        r0 = com.facebook.common.stringformat.StringFormatUtil.a(r1, r2);
        goto L_0x0014;
    L_0x02c8:
        r0 = r1;
        goto L_0x00e8;
    L_0x02cb:
        r9 = r15.x();
        if (r9 != 0) goto L_0x02d4;
    L_0x02d1:
        r5 = r6;
        goto L_0x0087;
    L_0x02d4:
        r10 = com.google.common.collect.ImmutableList.builder();
        r11 = r9.size();
        r7 = r8;
    L_0x02dd:
        if (r7 >= r11) goto L_0x02f8;
    L_0x02df:
        r5 = r9.get(r7);
        r5 = (com.facebook.graphql.model.GraphQLStoryAttachment) r5;
        r5 = r5.z();
        if (r5 == 0) goto L_0x02f4;
    L_0x02eb:
        r5 = r5.dp();
        if (r5 == 0) goto L_0x02f4;
    L_0x02f1:
        r10.c(r5);
    L_0x02f4:
        r5 = r7 + 1;
        r7 = r5;
        goto L_0x02dd;
    L_0x02f8:
        r5 = r10.b();
        r7 = r5.isEmpty();
        if (r7 != 0) goto L_0x033c;
    L_0x0302:
        r6 = 69109412; // 0x41e86a4 float:1.8634635E-36 double:3.41445863E-316;
        if (r0 != r6) goto L_0x032d;
    L_0x0307:
        r6 = com.facebook.common.fblinks.FBLinks.cT;
        r7 = new java.lang.StringBuilder;
        r9 = "notification:";
        r7.<init>(r9);
        r5 = r5.get(r8);
        r5 = (java.lang.String) r5;
        r5 = r7.append(r5);
        r5 = r5.toString();
        r7 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r8 = java.lang.Boolean.valueOf(r8);
        r5 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r6, r5, r7, r8);
        goto L_0x0087;
    L_0x032d:
        r6 = com.facebook.common.fblinks.FBLinks.cR;
        if (r5 != 0) goto L_0x033f;
    L_0x0331:
        r12 = "[]";
    L_0x0333:
        r5 = r12;
        r7 = "notification";
        r5 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r6, r5, r7);
        goto L_0x0087;
    L_0x033c:
        r5 = r6;
        goto L_0x0087;
    L_0x033f:
        r12 = r5.isEmpty();
        if (r12 == 0) goto L_0x0348;
    L_0x0345:
        r12 = "[]";
        goto L_0x0333;
    L_0x0348:
        r12 = 44;
        r12 = com.google.common.base.Joiner.on(r12);
        r12 = r12.skipNulls();
        r12 = r12.join(r5);
        goto L_0x0333;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.notifications.util.NotificationStoryHelper.a(com.facebook.graphql.model.GraphQLStory, com.facebook.graphql.model.GraphQLStoryAttachment):java.lang.String");
    }

    private static String m13350a(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme == null) {
            return str;
        }
        if (scheme.equals("fbrpc") || EventsUriUtil.a(str)) {
            return FacebookUriUtil.a(parse, "ref", "notifications_view".toString()).toString();
        }
        return str;
    }

    public final GraphQLTextWithEntities m13357a(GraphQLStory graphQLStory, NotificationLocation notificationLocation) {
        Preconditions.checkNotNull(graphQLStory);
        Preconditions.checkNotNull(notificationLocation);
        GraphQLTextWithEntities graphQLTextWithEntities = null;
        switch (1.a[notificationLocation.ordinal()]) {
            case 1:
            case 2:
                graphQLTextWithEntities = graphQLStory.aw();
                break;
            case 3:
            case 4:
            case 5:
                graphQLTextWithEntities = graphQLStory.aI();
                break;
            case 6:
                graphQLTextWithEntities = graphQLStory.aH();
                break;
            case 7:
                graphQLTextWithEntities = StoryHierarchyHelper.b(graphQLStory);
                break;
        }
        if (graphQLTextWithEntities == null) {
            graphQLTextWithEntities = graphQLStory.aI();
        }
        if (graphQLTextWithEntities != null) {
            return graphQLTextWithEntities;
        }
        if (StoryHierarchyHelper.e(graphQLStory)) {
            this.f12577e.a(f12569a, "Notification story text is null for notification ID: " + graphQLStory.c() + ", location: " + notificationLocation);
        }
        return GraphQLHelper.a("");
    }

    @Nullable
    public final Spannable m13358b(GraphQLStory graphQLStory, NotificationLocation notificationLocation) {
        return m13356a(graphQLStory, notificationLocation, null);
    }

    @Nullable
    public final Spannable m13356a(GraphQLStory graphQLStory, NotificationLocation notificationLocation, @Nullable TextView textView) {
        GraphQLTextWithEntities a = m13357a(graphQLStory, notificationLocation);
        if (a == null || a.a() == null) {
            this.f12577e.a("notification", "Could not format notification text since it was null");
            return new SpannableStringBuilder("");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a.a());
        if (textView != null) {
            this.f12576d.a(spannableStringBuilder, (int) textView.getTextSize());
        }
        GraphQLStorySeenState.SEEN_AND_READ.equals(graphQLStory.au());
        CharacterStyle a2 = CustomFontUtil.a();
        spannableStringBuilder.setSpan(CharacterStyle.wrap(CustomFontUtil.b()), 0, a.a().length(), 33);
        if (a.b() == null) {
            return spannableStringBuilder;
        }
        m13351a(spannableStringBuilder, a2, a);
        return spannableStringBuilder;
    }

    private void m13351a(SpannableStringBuilder spannableStringBuilder, CharacterStyle characterStyle, GraphQLTextWithEntities graphQLTextWithEntities) {
        int i = 0;
        if (graphQLTextWithEntities.b() != null && graphQLTextWithEntities.b().size() > 0) {
            ImmutableList b = graphQLTextWithEntities.b();
            int size = b.size();
            for (int i2 = 0; i2 < size; i2++) {
                m13352a(spannableStringBuilder, characterStyle, graphQLTextWithEntities.a(), GraphQLHelper.a((GraphQLEntityAtRange) b.get(i2)));
            }
        }
        if (graphQLTextWithEntities.c() != null && graphQLTextWithEntities.c().size() > 0) {
            ImmutableList c = graphQLTextWithEntities.c();
            int size2 = c.size();
            while (i < size2) {
                m13352a(spannableStringBuilder, characterStyle, graphQLTextWithEntities.a(), GraphQLHelper.a((GraphQLAggregatedEntitiesAtRange) c.get(i)));
                i++;
            }
        }
    }

    private static void m13352a(SpannableStringBuilder spannableStringBuilder, CharacterStyle characterStyle, String str, CodePointRange codePointRange) {
        UTF16Range a = RangeConverter.a(str, codePointRange);
        spannableStringBuilder.setSpan(CharacterStyle.wrap(characterStyle), a.a, a.c(), 17);
    }
}
