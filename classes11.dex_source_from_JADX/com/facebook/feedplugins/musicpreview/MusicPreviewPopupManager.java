package com.facebook.feedplugins.musicpreview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.platform.common.util.PlatformPackageUtilities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.List;
import javax.inject.Inject;

/* compiled from: composer_session_save_failed */
public class MusicPreviewPopupManager {
    private final PlatformPackageUtilities f8088a;
    private final MusicPreviewLogger f8089b;
    public final SecureContextHelper f8090c;
    private final GooglePlayIntentHelper f8091d;

    @JsonIgnoreProperties(b = true)
    /* compiled from: composer_session_save_failed */
    class AppSiteData {
        @JsonProperty("app_name")
        String appName;
        @JsonProperty("appsite")
        String appSite;
        @JsonProperty("appsite_url")
        String appSiteUrl;
        @JsonProperty("fallback_url")
        String fallbackUrl;
        @JsonProperty("is_app_link")
        String isAppLink;
        @JsonProperty("key_hashes")
        List<String> keyHashes;
        @JsonProperty("market_uri")
        String marketUri;
        @JsonProperty("package")
        String packageName;

        private AppSiteData() {
        }
    }

    @JsonIgnoreProperties(b = true)
    /* compiled from: composer_session_save_failed */
    class AppSites {
        @JsonProperty("android")
        List<AppSiteData> appSites;

        private AppSites() {
        }
    }

    @Inject
    public MusicPreviewPopupManager(PlatformPackageUtilities platformPackageUtilities, MusicPreviewLogger musicPreviewLogger, SecureContextHelper secureContextHelper, GooglePlayIntentHelper googlePlayIntentHelper) {
        this.f8088a = platformPackageUtilities;
        this.f8089b = musicPreviewLogger;
        this.f8090c = secureContextHelper;
        this.f8091d = googlePlayIntentHelper;
    }

    private boolean m9120a(String str) {
        return this.f8088a.b(str) != null;
    }

    public final void m9122a(Context context, String str, String str2, String str3, String str4, String str5, ArrayNode arrayNode) {
        String string;
        Resources resources = context.getResources();
        Builder builder = new Builder(context);
        final boolean a = m9120a(str);
        final Uri b = m9121b(str2);
        if (a) {
            string = resources.getString(2131235570);
        } else if (b != null) {
            string = resources.getString(2131235572);
        } else {
            string = resources.getString(2131235571);
        }
        Object[] objArr = new Object[]{str3};
        final Context context2 = context;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final String str9 = str5;
        final ArrayNode arrayNode2 = arrayNode;
        final String str10 = str;
        builder.a(new String[]{StringFormatUtil.a(string, objArr)}, new OnClickListener(this) {
            final /* synthetic */ MusicPreviewPopupManager f8087j;

            public void onClick(DialogInterface dialogInterface, int i) {
                if (a) {
                    this.f8087j.m9117a(context2, str6, str7, str8, str9, arrayNode2);
                } else if (b != null) {
                    Intent a = NativeThirdPartyUriHelper.a(context2, b, null, null, null);
                    if (a != null) {
                        this.f8087j.f8090c.b(a, context2);
                    }
                } else {
                    this.f8087j.m9116a(context2, str10, str7, str8, arrayNode2, str9);
                }
            }
        });
        builder.a().show();
    }

    private void m9117a(Context context, String str, String str2, String str3, String str4, ArrayNode arrayNode) {
        Intent a = NativeThirdPartyUriHelper.a(context, Uri.parse(str));
        if (a != null) {
            this.f8089b.f8057a.a(new HoneyClientEvent("music_preview_open_native").b("og_song_id", str3).b("og_object_id", str4).a("tracking_codes", arrayNode).b("provider_name", str2));
            this.f8090c.b(a, context);
        }
    }

    private void m9116a(Context context, String str, String str2, String str3, ArrayNode arrayNode, String str4) {
        if (this.f8091d.a()) {
            this.f8089b.f8057a.a(new HoneyClientEvent("music_preview_install_native").b("og_song_id", str3).b("og_object_id", str4).a("tracking_codes", arrayNode).b("provider_name", str2));
            this.f8091d.a(context, str);
            return;
        }
        Intent a = NativeThirdPartyUriHelper.a(context, Uri.parse(StringFormatUtil.a("https://play.google.com/store/apps/details?id=%s", new Object[]{str})), null, null, null);
        if (a != null) {
            this.f8090c.b(a, context);
        }
    }

    private static Uri m9121b(String str) {
        Uri parse = Uri.parse(str);
        if (parse == null) {
            return null;
        }
        Object queryParameter = parse.getQueryParameter("appsite_data");
        String queryParameter2 = parse.getQueryParameter("app_id");
        if (queryParameter2 == null || (!queryParameter2.equals("799889663393876") && !queryParameter2.equals("823778694338306"))) {
            return null;
        }
        AppSites appSites;
        if (TextUtils.isEmpty(queryParameter)) {
            appSites = null;
        } else {
            try {
                appSites = (AppSites) FbObjectMapper.i().a(queryParameter, AppSites.class);
            } catch (Exception e) {
                return null;
            }
        }
        if (!(appSites == null || appSites.appSites == null || appSites.appSites.isEmpty())) {
            for (AppSiteData appSiteData : appSites.appSites) {
                if (!TextUtils.isEmpty(appSiteData.appSiteUrl)) {
                    queryParameter2 = appSiteData.appSiteUrl;
                    break;
                }
            }
        }
        queryParameter2 = null;
        if (queryParameter2 == null) {
            return null;
        }
        queryParameter2 = Uri.parse(queryParameter2).getQueryParameter("url");
        if (queryParameter2 == null) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https");
        builder.authority("music.dmkt-sp.jp");
        queryParameter2 = Uri.parse(queryParameter2).getQueryParameter("fb_music");
        if (queryParameter2 != null) {
            builder.path("/song/S" + queryParameter2 + "/");
        }
        return builder.build();
    }
}
