package com.facebook.links;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.NativeUri;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLMessengerContentSubscriptionOption;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryHierarchyHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.messaging.business.subscription.common.abtest.ExperimentsForBusinessSubscriptionAbtestModule;
import com.facebook.notes.gk.NotesGatekeepers;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: fetch_sticker_tags */
public class AttachmentLinkLauncher {
    private static final String f23913a = AttachmentLinkLauncher.class.getSimpleName();
    private static AttachmentLinkLauncher f23914j;
    private static final Object f23915k = new Object();
    private final IFeedIntentBuilder f23916b;
    private final PackageManager f23917c;
    private final SecureContextHelper f23918d;
    private final AnalyticsLogger f23919e;
    private final AbstractFbErrorReporter f23920f;
    public final GatekeeperStoreImpl f23921g;
    private final NotesGatekeepers f23922h;
    private final QeAccessor f23923i;

    private static AttachmentLinkLauncher m32300b(InjectorLike injectorLike) {
        return new AttachmentLinkLauncher(DefaultFeedIntentBuilder.m26214a(injectorLike), PackageManagerMethodAutoProvider.m2633a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike), NotesGatekeepers.m26566b(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    public static AttachmentLinkLauncher m32296a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AttachmentLinkLauncher b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f23915k) {
                AttachmentLinkLauncher attachmentLinkLauncher;
                if (a2 != null) {
                    attachmentLinkLauncher = (AttachmentLinkLauncher) a2.mo818a(f23915k);
                } else {
                    attachmentLinkLauncher = f23914j;
                }
                if (attachmentLinkLauncher == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32300b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f23915k, b3);
                        } else {
                            f23914j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = attachmentLinkLauncher;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public AttachmentLinkLauncher(IFeedIntentBuilder iFeedIntentBuilder, PackageManager packageManager, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, AbstractFbErrorReporter abstractFbErrorReporter, GatekeeperStoreImpl gatekeeperStoreImpl, NotesGatekeepers notesGatekeepers, QeAccessor qeAccessor) {
        this.f23916b = iFeedIntentBuilder;
        this.f23917c = packageManager;
        this.f23918d = secureContextHelper;
        this.f23919e = analyticsLogger;
        this.f23920f = abstractFbErrorReporter;
        this.f23921g = gatekeeperStoreImpl;
        this.f23922h = notesGatekeepers;
        this.f23923i = qeAccessor;
    }

    public final void m32304a(Context context, NativeUri nativeUri) {
        try {
            if (this.f23916b.mo3015a(context, nativeUri)) {
                return;
            }
        } catch (Throwable e) {
            this.f23920f.mo336a(SoftError.a(f23913a + "_openUrl", "Error calling IFeedIntentBuilder.handleNativeUrl").a(e).g());
        }
        m32305a(context, nativeUri.a(), nativeUri.b(), nativeUri.c());
    }

    public final void m32305a(Context context, String str, Bundle bundle, @Nullable Map<String, Object> map) {
        try {
            if (this.f23916b.mo3017a(context, str, bundle, map)) {
                return;
            }
        } catch (Throwable e) {
            this.f23920f.mo336a(SoftError.a(f23913a + "_openUrl", "Error calling IFeedIntentBuilder.handleUrl").a(e).g());
        }
        Uri parse = Uri.parse(str);
        Intent data = new Intent("android.intent.action.VIEW").setData(parse);
        if (bundle != null && bundle.getBoolean("com.facebook.intent.extra.SKIP_IN_APP_BROWSER")) {
            data.putExtra("com.facebook.intent.extra.SKIP_IN_APP_BROWSER", true);
        }
        if (bundle != null) {
            data.putExtras(bundle);
            if (bundle.getBoolean("lead_gen_require_continued_flow")) {
                data.putExtra("lead_gen_continued_flow_text", bundle.getString("lead_gen_continued_flow_text"));
                data.putExtra("lead_gen_continued_flow_title", bundle.getString("lead_gen_continued_flow_title"));
                String string = bundle.getString("lead_gen_continued_flow_user_info_value");
                if (!Strings.isNullOrEmpty(string)) {
                    data.putExtra("post_url_data", string);
                }
            }
            if (bundle.getBoolean("lead_gen_seamless_continued_flow")) {
                data.putExtra("extra_js_to_execute", bundle.getString("extra_js_to_execute"));
            }
        }
        if (this.f23917c.resolveActivity(data, 65536) != null) {
            try {
                this.f23918d.mo665b(data, context);
                return;
            } catch (Throwable e2) {
                this.f23920f.mo336a(SoftError.a(f23913a + "_openUrl", "Error launching external Activity").a(e2).g());
            }
        }
        HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("external_activity_launch_failure");
        if (!TextUtils.isEmpty(str)) {
            honeyClientEvent = honeyClientEvent.m5090b("url", str);
        }
        this.f23919e.mo526a(honeyClientEvent);
        data = NativeThirdPartyUriHelper.m29580e(context, parse);
        if (data != null) {
            this.f23918d.mo665b(data, context);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle m32303a(com.fasterxml.jackson.databind.node.ArrayNode r10, com.facebook.feed.rows.core.props.FeedProps<com.facebook.graphql.model.GraphQLStoryAttachment> r11, java.lang.String r12, @javax.annotation.Nullable java.lang.String r13) {
        /*
        r9 = this;
        r5 = 1;
        r6 = r11.f13444a;
        r0 = r6;
        r0 = (com.facebook.graphql.model.GraphQLStoryAttachment) r0;
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = com.facebook.graphql.enums.GraphQLStoryAttachmentStyle.GAMETIME;
        r2 = com.google.common.collect.ImmutableList.of(r2);
        r2 = com.facebook.graphql.model.GraphQLStoryAttachmentUtil.m28051a(r0, r2);
        if (r2 == 0) goto L_0x012c;
    L_0x0017:
        r2 = "gametime_ref";
        r3 = com.facebook.gametime.constants.GametimeRef.NEWSFEED;
        r1.putSerializable(r2, r3);
    L_0x001e:
        r2 = com.facebook.feed.rows.core.props.AttachmentProps.m28714c(r11);
        if (r2 == 0) goto L_0x0068;
    L_0x0024:
        r3 = r2.m22350c();
        if (r3 == 0) goto L_0x002f;
    L_0x002a:
        r4 = "parent_story_id";
        r1.putString(r4, r3);
    L_0x002f:
        r3 = r9.f23922h;
        r3 = r3.m26567a();
        if (r3 == 0) goto L_0x0068;
    L_0x0037:
        r2 = r2.av();
        if (r2 == 0) goto L_0x0068;
    L_0x003d:
        r3 = r2.mo2904b();
        if (r3 == 0) goto L_0x0068;
    L_0x0043:
        r3 = r2.mo2904b();
        r3 = r3.m22301g();
        r4 = 2434066; // 0x252412 float:3.410853E-39 double:1.2025884E-317;
        if (r3 != r4) goto L_0x0068;
    L_0x0050:
        r3 = r2.mo2906d();
        r3 = com.facebook.common.util.StringUtil.m3599c(r3);
        if (r3 != 0) goto L_0x0068;
    L_0x005a:
        r3 = "extra_notes_id";
        r2 = r2.mo2906d();
        r1.putString(r3, r2);
        r2 = "force_external_activity";
        r1.putBoolean(r2, r5);
    L_0x0068:
        r2 = r0.m23987z();
        if (r2 == 0) goto L_0x00eb;
    L_0x006e:
        r2 = r0.m23987z();
        r2 = r2.dB();
        if (r2 == 0) goto L_0x00be;
    L_0x0078:
        r2 = r2.m23349m();
        r3 = com.facebook.common.util.StringUtil.m3589a(r2);
        if (r3 != 0) goto L_0x0087;
    L_0x0082:
        r3 = "extra_instant_articles_id";
        r1.putString(r3, r2);
    L_0x0087:
        r2 = com.facebook.graphql.model.ActionLinkHelper.m22935a(r0);
        if (r2 == 0) goto L_0x00b3;
    L_0x008d:
        r3 = r2.m22901a();
        r3 = r3.m22301g();
        r4 = -1787941669; // 0xffffffff956e2cdb float:-4.8099102E-26 double:NaN;
        if (r3 != r4) goto L_0x00b3;
    L_0x009a:
        r2 = r2.aP();
        if (r2 == 0) goto L_0x00b3;
    L_0x00a0:
        r3 = r2.m23203w();
        r3 = com.facebook.common.util.StringUtil.m3589a(r3);
        if (r3 != 0) goto L_0x00b3;
    L_0x00aa:
        r3 = "extra_instant_articles_featured_element_id";
        r2 = r2.m23203w();
        r1.putString(r3, r2);
    L_0x00b3:
        r2 = com.google.common.base.Strings.isNullOrEmpty(r13);
        if (r2 != 0) goto L_0x00be;
    L_0x00b9:
        r2 = "extra_instant_articles_referrer";
        r1.putString(r2, r13);
    L_0x00be:
        r2 = r9.m32302b(r0);
        if (r2 == 0) goto L_0x00eb;
    L_0x00c4:
        r2 = r0.m23987z();
        r2 = r2.jX();
        r3 = "content_subscription_page_id";
        r4 = r2.m24540j();
        r4 = r4.ae();
        r1.putString(r3, r4);
        r3 = "content_subscription_title";
        r4 = r2.m24541k();
        r1.putString(r3, r4);
        r3 = "content_subscription_content";
        r2 = r2.m24539a();
        r1.putString(r3, r2);
    L_0x00eb:
        r6 = 0;
        if (r0 != 0) goto L_0x019c;
    L_0x00ee:
        r2 = r6;
        if (r2 == 0) goto L_0x00fa;
    L_0x00f1:
        r3 = "show_beeper";
        r2 = r2.m23446k();
        r1.putBoolean(r3, r2);
    L_0x00fa:
        r2 = com.facebook.graphql.model.ActionLinkHelper.m22935a(r0);
        if (r2 == 0) goto L_0x0111;
    L_0x0100:
        r2 = com.facebook.graphql.model.ActionLinkHelper.m22935a(r0);
        r2 = r2.m22896W();
        r3 = com.facebook.graphql.enums.GraphQLCallToActionType.GET_DIRECTIONS;
        if (r2 != r3) goto L_0x0111;
    L_0x010c:
        r2 = "com.facebook.intent.extra.SKIP_IN_APP_BROWSER";
        r1.putBoolean(r2, r5);
    L_0x0111:
        r2 = com.facebook.common.util.StringUtil.m3589a(r13);
        if (r2 != 0) goto L_0x011c;
    L_0x0117:
        r2 = "iab_click_source";
        r1.putString(r2, r13);
    L_0x011c:
        m32297a(r1, r11);
        r6 = r0.m23987z();
        if (r6 == 0) goto L_0x012b;
    L_0x0125:
        r6 = com.facebook.graphql.model.GraphQLStoryAttachmentUtil.m28060k(r0);
        if (r6 != 0) goto L_0x01ab;
    L_0x012b:
        return r1;
    L_0x012c:
        r2 = com.facebook.graphql.enums.GraphQLStoryAttachmentStyle.AVATAR;
        r2 = com.google.common.collect.ImmutableList.of(r2);
        r2 = com.facebook.graphql.model.GraphQLStoryAttachmentUtil.m28051a(r0, r2);
        if (r2 == 0) goto L_0x014b;
    L_0x0138:
        r2 = android.net.Uri.parse(r12);
        r2 = com.facebook.common.util.FacebookUriUtil.m20922g(r2);
        if (r2 == 0) goto L_0x014b;
    L_0x0142:
        r2 = "timeline_friend_request_ref";
        r3 = com.facebook.friends.constants.FriendRequestMakeRef.NEWSFEED;
        r1.putSerializable(r2, r3);
        goto L_0x001e;
    L_0x014b:
        r2 = com.facebook.graphql.enums.GraphQLStoryAttachmentStyle.EVENT;
        r2 = com.google.common.collect.ImmutableList.of(r2);
        r2 = com.facebook.graphql.model.GraphQLStoryAttachmentUtil.m28051a(r0, r2);
        if (r2 == 0) goto L_0x016b;
    L_0x0157:
        r2 = "action_ref";
        r3 = com.facebook.events.common.ActionSource.NEWSFEED;
        r1.putParcelable(r2, r3);
        if (r10 == 0) goto L_0x001e;
    L_0x0160:
        r2 = "tracking_codes";
        r3 = r10.toString();
        r1.putString(r2, r3);
        goto L_0x001e;
    L_0x016b:
        r2 = com.google.common.base.Strings.isNullOrEmpty(r12);
        if (r2 != 0) goto L_0x001e;
    L_0x0171:
        r2 = android.net.Uri.parse(r12);
        r2 = com.facebook.common.util.FacebookUriUtil.m20916a(r2);
        if (r2 != 0) goto L_0x018f;
    L_0x017b:
        r2 = android.net.Uri.parse(r12);
        r6 = m32301b(r2);
        if (r6 != 0) goto L_0x018b;
    L_0x0185:
        r6 = m32299a(r2);
        if (r6 == 0) goto L_0x01d8;
    L_0x018b:
        r6 = 1;
    L_0x018c:
        r2 = r6;
        if (r2 == 0) goto L_0x001e;
    L_0x018f:
        if (r10 == 0) goto L_0x001e;
    L_0x0191:
        r2 = "tracking_codes";
        r3 = r10.toString();
        r1.putString(r2, r3);
        goto L_0x001e;
    L_0x019c:
        r7 = -508788748; // 0xffffffffe1ac7ff4 float:-3.977575E20 double:NaN;
        r7 = com.facebook.graphql.model.ActionLinkHelper.m22936a(r0, r7);
        if (r7 == 0) goto L_0x00ee;
    L_0x01a5:
        r6 = r7.m22894U();
        goto L_0x00ee;
    L_0x01ab:
        r6 = r0.m23987z();
        r6 = r6.gi();
        if (r6 == 0) goto L_0x01d6;
    L_0x01b5:
        r6 = r0.m23987z();
        r6 = r6.gi();
        r6 = r6.mo2924b();
    L_0x01c1:
        r7 = r0.m23987z();
        r7 = r7.dp();
        r8 = r0.m23987z();
        r8 = r8.eP();
        com.facebook.timeline.intent.ModelBundle.b(r1, r7, r8, r6);
        goto L_0x012b;
    L_0x01d6:
        r6 = 0;
        goto L_0x01c1;
    L_0x01d8:
        r6 = 0;
        goto L_0x018c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.links.AttachmentLinkLauncher.a(com.fasterxml.jackson.databind.node.ArrayNode, com.facebook.feed.rows.core.props.FeedProps, java.lang.String, java.lang.String):android.os.Bundle");
    }

    private static void m32297a(Bundle bundle, FeedProps<GraphQLStoryAttachment> feedProps) {
        m32298a(bundle, "og_title", ((GraphQLStoryAttachment) feedProps.f13444a).m23964A());
        GraphQLStory c = AttachmentProps.m28714c(feedProps);
        if (c != null) {
            String z_ = StoryHierarchyHelper.m27437d(c) ? (StoryHierarchyHelper.m27434a(c) == null || StoryHierarchyHelper.m27434a(c).m22608j() == null || StoryHierarchyHelper.m27434a(c).m22608j().get(0) == null || ((GraphQLStory) StoryHierarchyHelper.m27434a(c).m22608j().get(0)).mo2890l() == null) ? null : ((GraphQLStory) StoryHierarchyHelper.m27434a(c).m22608j().get(0)).mo2890l().z_() : c.mo2890l() != null ? c.mo2890l().z_() : null;
            m32298a(bundle, "conversations_feedback_id", z_);
        }
    }

    private static void m32298a(Bundle bundle, String str, @Nullable String str2) {
        if (!Strings.isNullOrEmpty(str2)) {
            bundle.putString(str, str2);
        }
    }

    private boolean m32302b(GraphQLStoryAttachment graphQLStoryAttachment) {
        if (!this.f23921g.m2189a(345, false)) {
            return false;
        }
        GraphQLMessengerContentSubscriptionOption jX = graphQLStoryAttachment.m23987z().jX();
        Object obj = (jX == null || jX.m24540j() == null || jX.m24540j().cK() || StringUtil.m3589a(jX.m24540j().ae()) || StringUtil.m3589a(jX.m24541k()) || StringUtil.m3589a(jX.m24539a())) ? null : 1;
        if (obj == null || !this.f23923i.mo596a(ExperimentsForBusinessSubscriptionAbtestModule.a, false)) {
            return false;
        }
        return true;
    }

    public static boolean m32299a(Uri uri) {
        return (uri == null || uri.getScheme() == null || !uri.getScheme().equals("fb") || uri.getAuthority() == null || !uri.getAuthority().equals("native_document")) ? false : true;
    }

    public static boolean m32301b(Uri uri) {
        return (uri == null || uri.getScheme() == null || !uri.getScheme().equals("fb") || uri.getAuthority() == null || !uri.getAuthority().equals("instant_shopping_catalog")) ? false : true;
    }
}
