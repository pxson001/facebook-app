package com.facebook.goodwill.composer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.publish.GoodwillPublishNotificationConfig;
import com.facebook.goodwill.publish.GoodwillPublishUploadHandler;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.intent.SharePreview.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: {action} */
public class GoodwillVideoComposerLauncher extends FbFragmentActivity {
    private String f98A;
    private String f99B;
    private ImmutableList<ComposerTaggedUser> f100C;
    @Inject
    JsonPluginConfigSerializer f101p;
    @Inject
    ComposerLauncher f102q;
    @Inject
    GoodwillPublishUploadHandler f103r;
    @Inject
    GoodwillAnalyticsLogger f104s;
    @Inject
    @LoggedInUser
    Lazy<User> f105t;
    private String f106u;
    private String f107v;
    private String f108w;
    private String f109x;
    private String f110y;
    private String f111z;

    private static <T extends Context> void m138a(Class<T> cls, T t) {
        m139a((Object) t, (Context) t);
    }

    public static void m139a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GoodwillVideoComposerLauncher) obj).m137a(JsonPluginConfigSerializer.b(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), GoodwillPublishUploadHandler.m167b(fbInjector), GoodwillAnalyticsLogger.a(fbInjector), IdBasedLazy.a(fbInjector, 3595));
    }

    protected final void m142b(Bundle bundle) {
        super.b(bundle);
        Class cls = GoodwillVideoComposerLauncher.class;
        m139a((Object) this, (Context) this);
        this.f106u = getIntent().getStringExtra("campaign_id");
        this.f107v = getIntent().getStringExtra("campaign_type");
        this.f108w = Uri.decode(getIntent().getStringExtra("share_preview"));
        this.f109x = getIntent().getStringExtra("share_preview_title");
        this.f110y = m141c(getIntent().getStringExtra("default_share_message"));
        this.f111z = m141c(getIntent().getStringExtra("placeholder_text"));
        this.f100C = ImmutableList.copyOf((ArrayList) getIntent().getSerializableExtra("tagged_users"));
        this.f98A = getIntent().getStringExtra("source");
        this.f99B = getIntent().getStringExtra("direct_source");
        if (bundle == null) {
            m140b(this.f106u);
        }
    }

    public static ComposerConfiguration m136a(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, boolean z, @Nullable ImmutableList<ComposerTaggedUser> immutableList, @Nullable String str6, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
        Builder builder = new Builder();
        builder.a = str2;
        builder = builder;
        builder.d = str3;
        SharePreview a = builder.a();
        ComposerShareParams.Builder a2 = ComposerShareParams.Builder.a();
        a2.d = a;
        ComposerShareParams.Builder builder2 = a2;
        builder2.e = str;
        ComposerConfiguration.Builder initialShareParams = ComposerConfiguration.newBuilder().setComposerType(ComposerType.GOODWILL_CAMPAIGN).setSourceType(ComposerSourceType.ON_THIS_DAY_PROMO).setPluginConfig(jsonPluginConfigSerializer.a(GoodwillCampaignComposerPluginConfig.m51a(str5, str6))).setInitialTargetData(ComposerTargetData.a).setIsEditTagEnabled(z).setNectarModule("goodwill_composer").setInitialShareParams(builder2.b());
        if (!z) {
            initialShareParams.setDisableFriendTagging(true).setDisableMentions(true);
        }
        if (immutableList != null) {
            initialShareParams.setInitialTaggedUsers(immutableList);
        }
        if (!TextUtils.isEmpty(str4)) {
            GraphQLTextWithEntities.Builder builder3 = new GraphQLTextWithEntities.Builder();
            builder3.i = str4;
            initialShareParams.setInitialText(builder3.a());
        }
        return initialShareParams.a();
    }

    private void m140b(String str) {
        ComposerConfiguration a = m136a(this.f106u, this.f109x, this.f108w, this.f110y, this.f111z, true, this.f100C, null, this.f101p);
        this.f104s.b(str, this.f98A, this.f99B);
        this.f102q.a(null, a, 1, this);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && i == 1) {
            PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
            this.f103r.m171a(this, ((User) this.f105t.get()).d(), this.f107v, this.f106u, this.f98A, this.f99B, publishPostParams.privacy, publishPostParams.rawMessage, publishPostParams.composerSessionId, publishPostParams.taggedIds, null, null, new GoodwillPublishNotificationConfig(getString(2131239210), getString(2131239213), getString(2131239214)), null);
        }
        finish();
    }

    private static String m141c(String str) {
        if (str == null) {
            return null;
        }
        return str.replace('+', ' ');
    }

    private void m137a(JsonPluginConfigSerializer jsonPluginConfigSerializer, ComposerLauncher composerLauncher, GoodwillPublishUploadHandler goodwillPublishUploadHandler, GoodwillAnalyticsLogger goodwillAnalyticsLogger, Lazy<User> lazy) {
        this.f101p = jsonPluginConfigSerializer;
        this.f102q = composerLauncher;
        this.f103r = goodwillPublishUploadHandler;
        this.f104s = goodwillAnalyticsLogger;
        this.f105t = lazy;
    }
}
