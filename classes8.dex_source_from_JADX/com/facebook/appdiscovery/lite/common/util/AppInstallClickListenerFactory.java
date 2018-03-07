package com.facebook.appdiscovery.lite.common.util;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.appdiscovery.lite.analytics.LiteInstallLogger;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.common.market.GooglePlayIntentHelper;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: is_page_liked */
public class AppInstallClickListenerFactory {
    public final GooglePlayIntentHelper f10567a;
    public final SecureContextHelper f10568b;
    public final Context f10569c;
    public final LiteInstallLogger f10570d;
    public final FbUriIntentHandler f10571e;

    @Inject
    public AppInstallClickListenerFactory(@Assisted Context context, @Assisted LiteInstallLogger liteInstallLogger, GooglePlayIntentHelper googlePlayIntentHelper, SecureContextHelper secureContextHelper, FbUriIntentHandler fbUriIntentHandler) {
        this.f10569c = context;
        this.f10570d = liteInstallLogger;
        this.f10567a = googlePlayIntentHelper;
        this.f10568b = secureContextHelper;
        this.f10571e = fbUriIntentHandler;
    }

    @Nullable
    public final OnClickListener m12463a(AppDetailsFeedUnit appDetailsFeedUnit) {
        String str;
        if (appDetailsFeedUnit.f10581c == null || appDetailsFeedUnit.f10581c.kU_() == null || appDetailsFeedUnit.f10581c.kU_().m12553b().isEmpty() || StringUtil.a((CharSequence) appDetailsFeedUnit.f10581c.kU_().m12553b().get(0))) {
            str = null;
        } else {
            str = (String) appDetailsFeedUnit.f10581c.kU_().m12553b().get(0);
        }
        return m12462a(str, null, appDetailsFeedUnit.m12489k());
    }

    @Nullable
    private OnClickListener m12460a(@Nullable final String str) {
        if (str == null) {
            return null;
        }
        return new OnClickListener(this) {
            final /* synthetic */ AppInstallClickListenerFactory f10560b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 765253554);
                this.f10560b.f10570d.m12459a(str);
                this.f10560b.f10568b.b(this.f10560b.f10567a.b(str), this.f10560b.f10569c);
                Logger.a(2, EntryType.UI_INPUT_END, -898164270, a);
            }
        };
    }

    @Nullable
    private OnClickListener m12461a(@Nullable final String str, @Nullable final String str2) {
        if (str == null) {
            return m12460a(str2);
        }
        return new OnClickListener(this) {
            final /* synthetic */ AppInstallClickListenerFactory f10563c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 837155692);
                this.f10563c.f10570d.m12459a(str2);
                this.f10563c.f10568b.b(this.f10563c.f10567a.a(str), this.f10563c.f10569c);
                Logger.a(2, EntryType.UI_INPUT_END, -264707666, a);
            }
        };
    }

    @Nullable
    private OnClickListener m12462a(@Nullable final String str, @Nullable String str2, @Nullable final String str3) {
        if (str != null) {
            C11263 c11263;
            if (str == null) {
                c11263 = null;
            } else {
                c11263 = new OnClickListener(this) {
                    final /* synthetic */ AppInstallClickListenerFactory f10566c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1037715958);
                        this.f10566c.f10570d.m12459a(str3);
                        FbUriIntentHandler fbUriIntentHandler = this.f10566c.f10571e;
                        Context context = this.f10566c.f10569c;
                        String str = str;
                        LiteInstallLogger liteInstallLogger = this.f10566c.f10570d;
                        Builder builder = ImmutableMap.builder();
                        builder.b("organic_product", "AppInvites");
                        builder.b("organic_surface", "app_invites_app_discovery_lite");
                        fbUriIntentHandler.a(context, str, null, builder.b());
                        Logger.a(2, EntryType.UI_INPUT_END, -578486709, a);
                    }
                };
            }
            return c11263;
        } else if (str2 != null) {
            return m12461a(str2, str3);
        } else {
            return m12460a(str3);
        }
    }
}
