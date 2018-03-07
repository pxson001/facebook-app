package com.facebook.socialgood.ui;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.ActivityMethodAutoProvider;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.widget.inlineactionbar.InlineActionBar.InlineActionBarMenuHandler;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.negativefeedback.ui.NegativeFeedbackDialogFragment;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: NumberFormatConfig */
public class FundraiserPageActionBarMenuHandler implements InlineActionBarMenuHandler {
    @Inject
    private Activity f12834a;
    @Inject
    private AnalyticsLogger f12835b;
    @Inject
    private Context f12836c;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerConfigurationFactory> f12837d = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<ComposerLauncher> f12838e = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<IFeedIntentBuilder> f12839f = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<SecureContextHelper> f12840g = UltralightRuntime.b;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<UriIntentMapper> f12841h = UltralightRuntime.b;
    @Inject
    private FragmentActivity f12842i;
    private String f12843j;
    private String f12844k;
    private String f12845l;
    private String f12846m;
    private String f12847n;
    private String f12848o;
    private int f12849p;

    public static FundraiserPageActionBarMenuHandler m13500b(InjectorLike injectorLike) {
        FundraiserPageActionBarMenuHandler fundraiserPageActionBarMenuHandler = new FundraiserPageActionBarMenuHandler();
        fundraiserPageActionBarMenuHandler.m13499a(ActivityMethodAutoProvider.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedLazy.a(injectorLike, 2369), IdBasedSingletonScopeProvider.b(injectorLike, 849), IdBasedSingletonScopeProvider.b(injectorLike, 2347), IdBasedSingletonScopeProvider.b(injectorLike, 968), IdBasedSingletonScopeProvider.b(injectorLike, 2436), FragmentActivityMethodAutoProvider.b(injectorLike));
        return fundraiserPageActionBarMenuHandler;
    }

    public static FundraiserPageActionBarMenuHandler m13498a(InjectorLike injectorLike) {
        return m13500b(injectorLike);
    }

    public final boolean m13502a(MenuItem menuItem) {
        FundraiserPageActionBarButtonType fromOrdinal = FundraiserPageActionBarButtonType.fromOrdinal(menuItem.getItemId());
        if (fromOrdinal != null) {
            AnalyticsLogger analyticsLogger;
            String str;
            String str2;
            HoneyClientEvent honeyClientEvent;
            switch (fromOrdinal) {
                case SHARE:
                    if (!(TextUtils.isEmpty(this.f12843j) || TextUtils.isEmpty(this.f12844k))) {
                        Object obj;
                        analyticsLogger = this.f12835b;
                        str = this.f12843j;
                        str2 = this.f12846m;
                        honeyClientEvent = new HoneyClientEvent("fundraiser_page_tapped_share");
                        honeyClientEvent.c = "social_good";
                        analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).b("source", str2));
                        if (this.f12849p == 98695003) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        ComposerLauncher composerLauncher;
                        if (obj == null) {
                            if (this.f12849p == -1315407331) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                composerLauncher = (ComposerLauncher) this.f12838e.get();
                                this.f12837d.get();
                                composerLauncher.a(null, ComposerConfigurationFactory.c(ComposerSourceType.FUNDRAISER_PAGE, Builder.a(GraphQLHelper.a(this.f12844k, -1315407331)).b()).setIsFireAndForget(true).a(), this.f12836c);
                                break;
                            }
                        }
                        composerLauncher = (ComposerLauncher) this.f12838e.get();
                        this.f12837d.get();
                        composerLauncher.a(null, ComposerConfigurationFactory.c(ComposerSourceType.FUNDRAISER_PAGE, Builder.a(GraphQLHelper.a(this.f12844k, 1147287130)).b()).setIsFireAndForget(true).a(), this.f12836c);
                        break;
                    }
                    break;
                case INVITE:
                    if (!TextUtils.isEmpty(this.f12843j)) {
                        analyticsLogger = this.f12835b;
                        str = this.f12843j;
                        str2 = this.f12846m;
                        honeyClientEvent = new HoneyClientEvent("fundraiser_page_tapped_invite");
                        honeyClientEvent.c = "social_good";
                        analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).b("source", str2));
                        Intent a = ((UriIntentMapper) this.f12841h.get()).a(this.f12836c, StringFormatUtil.formatStrLocaleSafe(FBLinks.eX, this.f12843j));
                        a.putExtra("source", this.f12846m);
                        ((SecureContextHelper) this.f12840g.get()).a(a, this.f12834a);
                        break;
                    }
                    break;
                case GO_TO_PAGE:
                    if (!(TextUtils.isEmpty(this.f12843j) || TextUtils.isEmpty(this.f12845l))) {
                        analyticsLogger = this.f12835b;
                        str = this.f12843j;
                        str2 = this.f12846m;
                        honeyClientEvent = new HoneyClientEvent("fundraiser_page_tapped_go_to_page");
                        honeyClientEvent.c = "social_good";
                        analyticsLogger.a(honeyClientEvent.b("fundraiser_campaign_id", str).b("source", str2));
                        ((SecureContextHelper) this.f12840g.get()).a(((IFeedIntentBuilder) this.f12839f.get()).b(this.f12836c, StringFormatUtil.formatStrLocaleSafe(FBLinks.af, this.f12845l)), this.f12836c);
                        break;
                    }
                case REPORT_FUNDRAISER:
                    NegativeFeedbackDialogFragment.a(this.f12843j, NegativeFeedbackExperienceLocation.FUNDRAISER_PERSON_TO_CHARITY.stringValueOf()).a(this.f12842i.kO_(), "fundraiser_person_to_charity");
                    break;
                case COPY_LINK:
                    if (!TextUtils.isEmpty(this.f12848o)) {
                        ((ClipboardManager) this.f12836c.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(this.f12847n, this.f12848o));
                        Toast.makeText(this.f12836c, this.f12836c.getResources().getString(2131236853), 0).show();
                        break;
                    }
                    break;
            }
        }
        return false;
    }

    public final void m13501a(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f12843j = str;
        this.f12844k = str3;
        this.f12845l = str2;
        this.f12846m = str4;
        this.f12847n = str5;
        this.f12848o = str6;
        this.f12849p = i;
    }

    private void m13499a(Activity activity, AnalyticsLogger analyticsLogger, Context context, com.facebook.inject.Lazy<ComposerConfigurationFactory> lazy, com.facebook.inject.Lazy<ComposerLauncher> lazy2, com.facebook.inject.Lazy<IFeedIntentBuilder> lazy3, com.facebook.inject.Lazy<SecureContextHelper> lazy4, com.facebook.inject.Lazy<UriIntentMapper> lazy5, FragmentActivity fragmentActivity) {
        this.f12834a = activity;
        this.f12835b = analyticsLogger;
        this.f12836c = context;
        this.f12837d = lazy;
        this.f12838e = lazy2;
        this.f12839f = lazy3;
        this.f12840g = lazy4;
        this.f12841h = lazy5;
        this.f12842i = fragmentActivity;
    }
}
