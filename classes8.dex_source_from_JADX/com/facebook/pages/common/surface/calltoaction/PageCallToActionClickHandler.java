package com.facebook.pages.common.surface.calltoaction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.IntentResolver;
import com.facebook.content.SecureContextHelper;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.pages.common.autofill_provider.PageCallToActionAutoFillProvider;
import com.facebook.pages.common.autofill_provider.PageCallToActionAutoFillProvider$AutoFillAuthTokenType;
import com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.hash.Hashing.Sha256Holder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: creation_create_failed */
public class PageCallToActionClickHandler {
    public final Context f16638a;
    public final SecureContextHelper f16639b;
    public final UriIntentMapper f16640c;
    private final Provider<User> f16641d;
    private final Lazy<PageCallToActionAutoFillProvider> f16642e;
    private final QuickPerformanceLogger f16643f;
    private final Lazy<FbErrorReporter> f16644g;

    /* compiled from: creation_create_failed */
    /* synthetic */ class C18011 {
        static final /* synthetic */ int[] f16637a = new int[GraphQLPageCallToActionType.values().length];

        static {
            try {
                f16637a[GraphQLPageCallToActionType.CALL_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16637a[GraphQLPageCallToActionType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16637a[GraphQLPageCallToActionType.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16637a[GraphQLPageCallToActionType.CONTACT_US.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static PageCallToActionClickHandler m19681b(InjectorLike injectorLike) {
        return new PageCallToActionClickHandler((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), IdBasedSingletonScopeProvider.b(injectorLike, 8990), IdBasedSingletonScopeProvider.b(injectorLike, 494), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PageCallToActionClickHandler(Context context, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper, Provider<User> provider, Lazy<PageCallToActionAutoFillProvider> lazy, Lazy<FbErrorReporter> lazy2, QuickPerformanceLogger quickPerformanceLogger) {
        this.f16638a = context;
        this.f16639b = secureContextHelper;
        this.f16640c = uriIntentMapper;
        this.f16641d = provider;
        this.f16642e = lazy;
        this.f16644g = lazy2;
        this.f16643f = quickPerformanceLogger;
    }

    public final void m19683a(long j, PageCallToActionModel pageCallToActionModel) {
        if (PageCallToActionUtil.m20166a(pageCallToActionModel.m21019g()) || PageCallToActionUtil.m20167a(pageCallToActionModel)) {
            m19680a(j, true, null);
        } else {
            m19682b(pageCallToActionModel, j);
        }
    }

    public final void m19685a(PageCallToActionModel pageCallToActionModel, long j) {
        m19682b(pageCallToActionModel, j);
    }

    public final void m19684a(long j, String str, PageCallToActionModel pageCallToActionModel) {
        switch (C18011.f16637a[pageCallToActionModel.m21019g().ordinal()]) {
            case 1:
                m19686a(pageCallToActionModel.m21024n() == null ? null : pageCallToActionModel.m21024n().m19907a(), pageCallToActionModel.m21021k());
                return;
            case 2:
                this.f16639b.b(this.f16640c.a(this.f16638a, StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(j))), this.f16638a);
                return;
            case 3:
                m19687a(str, pageCallToActionModel.m21021k(), pageCallToActionModel.kB_());
                return;
            case 4:
                if (PageCallToActionUtil.m20171b(pageCallToActionModel)) {
                    m19680a(j, false, pageCallToActionModel);
                    return;
                } else {
                    m19682b(pageCallToActionModel, j);
                    return;
                }
            default:
                m19682b(pageCallToActionModel, j);
                return;
        }
    }

    public final void m19686a(@Nullable String str, String str2) {
        if (str != null) {
            this.f16639b.b(new Intent("android.intent.action.DIAL").setData(Uri.parse("tel:" + str)), this.f16638a);
            return;
        }
        ((AbstractFbErrorReporter) this.f16644g.get()).a(PageCallToActionClickHandler.class.getSimpleName(), "No phone number for the CallNow type Call-to-Action: " + str2);
    }

    public final void m19687a(String str, String str2, String str3) {
        if (StringUtil.a(str3)) {
            ((AbstractFbErrorReporter) this.f16644g.get()).a(PageCallToActionClickHandler.class.getSimpleName(), "No email address for the EmailUs type Call-to-Action: " + str2);
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(268435456);
        intent.setType("vnd.android.cursor.item/email");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str3});
        intent.putExtra("android.intent.extra.SUBJECT", this.f16638a.getResources().getString(2131239594, new Object[]{((User) this.f16641d.get()).e, str}));
        this.f16639b.b(Intent.createChooser(intent, this.f16638a.getResources().getString(2131239561)), this.f16638a);
    }

    private void m19682b(PageCallToActionModel pageCallToActionModel, long j) {
        Intent data;
        String kC_;
        Intent a;
        PageCallToActionAutoFillProviderImpl pageCallToActionAutoFillProviderImpl;
        String hashCode;
        Object obj = 1;
        Object b = pageCallToActionModel.m21016b();
        if (!StringUtil.a(b)) {
            data = new Intent("android.intent.action.VIEW").setData(Uri.parse(b));
            if (IntentResolver.b(this.f16638a, data)) {
                this.f16639b.b(data, this.f16638a);
                if (obj != null) {
                    kC_ = pageCallToActionModel.kC_();
                    if (StringUtil.a(kC_)) {
                        ((AbstractFbErrorReporter) this.f16644g.get()).a(PageCallToActionClickHandler.class.getSimpleName(), "No valid actions for the Call-to-Action: " + pageCallToActionModel.m21021k());
                    }
                    a = m19679a(pageCallToActionModel, kC_);
                    if (a == null) {
                        a = new Intent("android.intent.action.VIEW");
                        a.setData(Uri.parse(kC_));
                        this.f16639b.b(a, this.f16638a);
                        return;
                    } else if (!FacebookUriUtil.a(Uri.parse(kC_)) || a.getBooleanExtra("force_external_activity", false)) {
                        if (pageCallToActionModel.m21018d()) {
                            ((PageCallToActionAutoFillProviderImpl) this.f16642e.get()).m19650a();
                            pageCallToActionAutoFillProviderImpl = (PageCallToActionAutoFillProviderImpl) this.f16642e.get();
                            PageCallToActionAutoFillProvider$AutoFillAuthTokenType pageCallToActionAutoFillProvider$AutoFillAuthTokenType = PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI;
                            String valueOf = String.valueOf(j);
                            Preconditions.checkArgument(pageCallToActionAutoFillProvider$AutoFillAuthTokenType == PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI);
                            hashCode = Sha256Holder.a.a(StringFormatUtil.formatStrLocaleSafe("{type:%s, id:%s}", pageCallToActionAutoFillProvider$AutoFillAuthTokenType.name(), valueOf), Charset.defaultCharset()).toString();
                            if (!pageCallToActionAutoFillProviderImpl.f16615d.contains(hashCode)) {
                                pageCallToActionAutoFillProviderImpl.f16615d.add(hashCode);
                            }
                        }
                        this.f16639b.b(a, this.f16638a);
                        return;
                    } else {
                        this.f16639b.a(a, this.f16638a);
                        return;
                    }
                }
            }
        }
        b = pageCallToActionModel.m21017c();
        if (!StringUtil.a(b)) {
            data = this.f16638a.getPackageManager().getLaunchIntentForPackage(b);
            if (data != null) {
                this.f16639b.b(data, this.f16638a);
                if (obj != null) {
                    kC_ = pageCallToActionModel.kC_();
                    if (StringUtil.a(kC_)) {
                        ((AbstractFbErrorReporter) this.f16644g.get()).a(PageCallToActionClickHandler.class.getSimpleName(), "No valid actions for the Call-to-Action: " + pageCallToActionModel.m21021k());
                    }
                    a = m19679a(pageCallToActionModel, kC_);
                    if (a == null) {
                        a = new Intent("android.intent.action.VIEW");
                        a.setData(Uri.parse(kC_));
                        this.f16639b.b(a, this.f16638a);
                        return;
                    }
                    if (FacebookUriUtil.a(Uri.parse(kC_))) {
                    }
                    if (pageCallToActionModel.m21018d()) {
                        ((PageCallToActionAutoFillProviderImpl) this.f16642e.get()).m19650a();
                        pageCallToActionAutoFillProviderImpl = (PageCallToActionAutoFillProviderImpl) this.f16642e.get();
                        PageCallToActionAutoFillProvider$AutoFillAuthTokenType pageCallToActionAutoFillProvider$AutoFillAuthTokenType2 = PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI;
                        String valueOf2 = String.valueOf(j);
                        if (pageCallToActionAutoFillProvider$AutoFillAuthTokenType2 == PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI) {
                        }
                        Preconditions.checkArgument(pageCallToActionAutoFillProvider$AutoFillAuthTokenType2 == PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI);
                        hashCode = Sha256Holder.a.a(StringFormatUtil.formatStrLocaleSafe("{type:%s, id:%s}", pageCallToActionAutoFillProvider$AutoFillAuthTokenType2.name(), valueOf2), Charset.defaultCharset()).toString();
                        if (pageCallToActionAutoFillProviderImpl.f16615d.contains(hashCode)) {
                            pageCallToActionAutoFillProviderImpl.f16615d.add(hashCode);
                        }
                    }
                    this.f16639b.b(a, this.f16638a);
                    return;
                }
            }
        }
        obj = null;
        if (obj != null) {
            kC_ = pageCallToActionModel.kC_();
            if (StringUtil.a(kC_)) {
                a = m19679a(pageCallToActionModel, kC_);
                if (a == null) {
                    if (FacebookUriUtil.a(Uri.parse(kC_))) {
                    }
                    if (pageCallToActionModel.m21018d()) {
                        ((PageCallToActionAutoFillProviderImpl) this.f16642e.get()).m19650a();
                        pageCallToActionAutoFillProviderImpl = (PageCallToActionAutoFillProviderImpl) this.f16642e.get();
                        PageCallToActionAutoFillProvider$AutoFillAuthTokenType pageCallToActionAutoFillProvider$AutoFillAuthTokenType22 = PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI;
                        String valueOf22 = String.valueOf(j);
                        if (pageCallToActionAutoFillProvider$AutoFillAuthTokenType22 == PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI) {
                        }
                        Preconditions.checkArgument(pageCallToActionAutoFillProvider$AutoFillAuthTokenType22 == PageCallToActionAutoFillProvider$AutoFillAuthTokenType.PAGE_CTA_FALLBACK_THIRD_PARTY_URI);
                        hashCode = Sha256Holder.a.a(StringFormatUtil.formatStrLocaleSafe("{type:%s, id:%s}", pageCallToActionAutoFillProvider$AutoFillAuthTokenType22.name(), valueOf22), Charset.defaultCharset()).toString();
                        if (pageCallToActionAutoFillProviderImpl.f16615d.contains(hashCode)) {
                            pageCallToActionAutoFillProviderImpl.f16615d.add(hashCode);
                        }
                    }
                    this.f16639b.b(a, this.f16638a);
                    return;
                }
                a = new Intent("android.intent.action.VIEW");
                a.setData(Uri.parse(kC_));
                this.f16639b.b(a, this.f16638a);
                return;
            }
            ((AbstractFbErrorReporter) this.f16644g.get()).a(PageCallToActionClickHandler.class.getSimpleName(), "No valid actions for the Call-to-Action: " + pageCallToActionModel.m21021k());
        }
    }

    private Intent m19679a(PageCallToActionModel pageCallToActionModel, String str) {
        Intent intent = null;
        if (pageCallToActionModel.m21022l()) {
            this.f16643f.b(10092545);
            intent = this.f16640c.a(this.f16638a, StringFormatUtil.formatStrLocaleSafe(FBLinks.bQ, "https://m.facebook.com/pages/platform/first-party-cta/", "require('MPagesPlatformNativeBridge').bootCTA(" + pageCallToActionModel.m21021k() + ");"));
        }
        if (intent == null) {
            return this.f16640c.a(this.f16638a, str);
        }
        return intent;
    }

    private void m19680a(long j, boolean z, @Nullable PageCallToActionModel pageCallToActionModel) {
        Intent a = this.f16640c.a(this.f16638a, StringFormatUtil.formatStrLocaleSafe(FBLinks.ax, Long.valueOf(j)));
        a.putExtra("com.facebook.katana.profile.id", String.valueOf(j));
        a.putExtra("page_call_to_action_isadmin_extra", z);
        if (z) {
            this.f16639b.a(a, 10113, (Activity) ContextUtils.a(this.f16638a, Activity.class));
            return;
        }
        if (PageCallToActionUtil.m20171b(pageCallToActionModel)) {
            FlatBufferModelHelper.a(a, "page_call_to_action_fields_extra", new ArrayList(pageCallToActionModel.m21020j().m21008a()));
            a.putExtra("page_call_to_action_label_extra", pageCallToActionModel.m21023m());
        }
        this.f16639b.a(a, (Context) ContextUtils.a(this.f16638a, Activity.class));
    }
}
