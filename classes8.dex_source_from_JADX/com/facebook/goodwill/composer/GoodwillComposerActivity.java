package com.facebook.goodwill.composer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.app.FragmentTransaction;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger$Events;
import com.facebook.goodwill.composer.GoodwillComposerEvent.GoodwillPhoto;
import com.facebook.goodwill.composer.photofragment.PhotoFromFbOrCameraFragment;
import com.facebook.goodwill.publish.GoodwillPublishNotificationConfig;
import com.facebook.goodwill.publish.GoodwillPublishPhoto;
import com.facebook.goodwill.publish.GoodwillPublishUploadHandler;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.intent.SharePreview;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerType;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

/* compiled from: {place_id} */
public class GoodwillComposerActivity extends FbFragmentActivity {
    GoodwillAnalyticsLogger f57p;
    JsonPluginConfigSerializer f58q;
    private HashMap<String, GoodwillComposerFragment> f59r;
    private String[] f60s;
    private GoodwillPublishUploadHandler f61t;
    public GoodwillComposerEvent f62u;
    public List<StepState> f63v = new ArrayList();
    public int f64w = -1;
    public boolean f65x = true;
    private String f66y;
    private ComposerLauncher f67z;

    /* compiled from: {place_id} */
    public class ComposerFlowCallback {
        final /* synthetic */ GoodwillComposerActivity f49a;
        private int f50b;

        public ComposerFlowCallback(GoodwillComposerActivity goodwillComposerActivity, int i) {
            this.f49a = goodwillComposerActivity;
            this.f50b = i;
        }

        public final void m60a() {
            ((StepState) this.f49a.f63v.get(this.f50b)).f52b = true;
            if (this.f49a.f65x && this.f50b == this.f49a.f64w + 1) {
                this.f49a.f65x = false;
                GoodwillComposerActivity.m83l(this.f49a);
            }
        }

        public final void m61a(GoodwillComposerFragmentCallback$NavigationResult goodwillComposerFragmentCallback$NavigationResult) {
            if (goodwillComposerFragmentCallback$NavigationResult == GoodwillComposerFragmentCallback$NavigationResult.NAVIGATION_NEXT) {
                GoodwillComposerActivity.m83l(this.f49a);
            } else if (goodwillComposerFragmentCallback$NavigationResult == GoodwillComposerFragmentCallback$NavigationResult.NAVIGATION_BACK) {
                GoodwillComposerActivity.m84m(this.f49a);
            } else {
                GoodwillComposerActivity.m87p(this.f49a);
            }
        }
    }

    /* compiled from: {place_id} */
    class StepState {
        public GoodwillComposerFragment f51a;
        public boolean f52b = false;
        public String f53c;

        public StepState(GoodwillComposerFragment goodwillComposerFragment, String str) {
            this.f51a = goodwillComposerFragment;
            this.f53c = str;
        }
    }

    /* compiled from: {place_id} */
    class UploadStatusCallback extends com.facebook.goodwill.publish.GoodwillPublishUploadHandler.UploadStatusCallback {
        public final Creator<UploadStatusCallback> f55a;
        final /* synthetic */ GoodwillComposerActivity f56b;

        /* compiled from: {place_id} */
        class C00071 implements Creator<UploadStatusCallback> {
            final /* synthetic */ UploadStatusCallback f54a;

            C00071(UploadStatusCallback uploadStatusCallback) {
                this.f54a = uploadStatusCallback;
            }

            public Object createFromParcel(Parcel parcel) {
                return new UploadStatusCallback(this.f54a.f56b, parcel);
            }

            public Object[] newArray(int i) {
                return new UploadStatusCallback[i];
            }
        }

        public final void mo1a() {
            this.f56b.f57p.a(this.f56b.f62u.f71a, this.f56b.f62u.f79i, GoodwillAnalyticsLogger$Events.GOODWILL_COMPOSER_POST_SUBMITTED);
        }

        public final void mo2b() {
            this.f56b.f57p.a(this.f56b.f62u.f71a, this.f56b.f62u.f79i, GoodwillAnalyticsLogger$Events.GOODWILL_COMPOSER_POST_FAILED);
        }

        public UploadStatusCallback(GoodwillComposerActivity goodwillComposerActivity) {
            this.f56b = goodwillComposerActivity;
            super(null);
            this.f55a = new C00071(this);
        }

        public UploadStatusCallback(GoodwillComposerActivity goodwillComposerActivity, Parcel parcel) {
            this.f56b = goodwillComposerActivity;
            super(parcel);
            this.f55a = new C00071(this);
        }

        public void writeToParcel(Parcel parcel, int i) {
        }

        public int describeContents() {
            return 0;
        }
    }

    private static <T extends Context> void m70a(Class<T> cls, T t) {
        m71a((Object) t, (Context) t);
    }

    public static void m71a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((GoodwillComposerActivity) obj).m69a(GoodwillAnalyticsLogger.a(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), GoodwillPublishUploadHandler.m167b(fbInjector), JsonPluginConfigSerializer.b(fbInjector));
    }

    @Inject
    private void m69a(GoodwillAnalyticsLogger goodwillAnalyticsLogger, ComposerLauncher composerLauncher, GoodwillPublishUploadHandler goodwillPublishUploadHandler, JsonPluginConfigSerializer jsonPluginConfigSerializer) {
        this.f67z = composerLauncher;
        this.f61t = goodwillPublishUploadHandler;
        this.f57p = goodwillAnalyticsLogger;
        this.f58q = jsonPluginConfigSerializer;
    }

    private void m80i() {
        this.f59r = new HashMap();
        this.f59r.put("photos", new PhotoFromFbOrCameraFragment());
    }

    public final void m88b(Bundle bundle) {
        super.b(bundle);
        Class cls = GoodwillComposerActivity.class;
        m71a((Object) this, (Context) this);
        m80i();
        setContentView(2130905150);
        this.f60s = getIntent().getStringArrayExtra("STEPS");
        this.f62u = (GoodwillComposerEvent) getIntent().getParcelableExtra("INPUT");
        if (this.f62u == null) {
            this.f62u = new GoodwillComposerEvent();
        }
        m82k();
        if (bundle != null) {
            this.f64w = bundle.getInt("CURSTEP");
            this.f62u = (GoodwillComposerEvent) bundle.getParcelable("INPUT");
        }
        this.f57p.a(this.f62u.f71a, this.f62u.f79i, GoodwillAnalyticsLogger$Events.GOODWILL_COMPOSER_LAUNCH);
        this.f66y = getIntent().getStringExtra("OUTPUT");
        if (Strings.isNullOrEmpty(this.f66y)) {
            this.f66y = "mle";
        }
        m81j();
    }

    private void m81j() {
        int i = 0;
        for (StepState stepState : this.f63v) {
            stepState.f51a.mo7a(this.f62u, new ComposerFlowCallback(this, i));
            i++;
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        if (this.f64w >= 0 && this.f64w < this.f63v.size()) {
            ((StepState) this.f63v.get(this.f64w)).f51a.e(bundle);
        }
        if (this.f64w >= this.f63v.size()) {
            bundle.putInt("CURSTEP", this.f63v.size() - 2);
        } else {
            bundle.putInt("CURSTEP", this.f64w - 1);
        }
        bundle.putParcelable("INPUT", this.f62u);
        bundle.putStringArray("STEPS", this.f60s);
        bundle.putString("OUTPUT", this.f66y);
    }

    private void m82k() {
        for (int i = 0; i < this.f60s.length; i++) {
            GoodwillComposerFragment goodwillComposerFragment = (GoodwillComposerFragment) this.f59r.get(this.f60s[i]);
            if (goodwillComposerFragment != null) {
                this.f63v.add(new StepState(goodwillComposerFragment, this.f60s[i]));
            }
        }
    }

    public static boolean m83l(GoodwillComposerActivity goodwillComposerActivity) {
        if (goodwillComposerActivity.f64w >= goodwillComposerActivity.f63v.size() - 1) {
            goodwillComposerActivity.f64w = goodwillComposerActivity.f63v.size();
            goodwillComposerActivity.m85n();
            return false;
        } else if (((StepState) goodwillComposerActivity.f63v.get(goodwillComposerActivity.f64w + 1)).f52b) {
            goodwillComposerActivity.f64w++;
            StepState stepState = (StepState) goodwillComposerActivity.f63v.get(goodwillComposerActivity.f64w);
            FragmentTransaction a = goodwillComposerActivity.kO_().a();
            a.b(2131558429, stepState.f51a);
            if (goodwillComposerActivity.f64w != -1) {
                a.a(null);
            }
            a.b();
            return true;
        } else {
            goodwillComposerActivity.f65x = true;
            return false;
        }
    }

    public static boolean m84m(GoodwillComposerActivity goodwillComposerActivity) {
        if (goodwillComposerActivity.f64w == 0) {
            m87p(goodwillComposerActivity);
            return false;
        }
        goodwillComposerActivity.kO_().e();
        goodwillComposerActivity.f64w--;
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.f63v.get(this.f64w);
        this.f64w--;
        if (this.f64w < 0) {
            m87p(this);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (this.f64w >= 0 && this.f64w < this.f63v.size()) {
            ((StepState) this.f63v.get(this.f64w)).f51a.a(i, i2, intent);
        } else if (i2 == -1 && i == 15151) {
            m73b(intent);
            finish();
        } else {
            this.f64w--;
        }
    }

    private void m73b(Intent intent) {
        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        GoodwillPublishNotificationConfig goodwillPublishNotificationConfig = new GoodwillPublishNotificationConfig(this.f62u.m93d(), this.f62u.m94e(), this.f62u.m95f());
        com.facebook.goodwill.publish.GoodwillPublishUploadHandler.UploadStatusCallback uploadStatusCallback = new UploadStatusCallback(this);
        String str = this.f66y;
        Object obj = -1;
        switch (str.hashCode()) {
            case 108198:
                if (str.equals("mle")) {
                    obj = null;
                    break;
                }
                break;
            case 420537902:
                if (str.equals("friendversary_collage")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                this.f61t.m169a(this, publishPostParams, this.f62u.m97i(), m67a(this.f62u.m96g()), goodwillPublishNotificationConfig, uploadStatusCallback);
                return;
            case 1:
                this.f61t.m170a(this, this.f62u.m90a(), this.f62u.m97i(), publishPostParams, m67a(this.f62u.m96g()), goodwillPublishNotificationConfig, uploadStatusCallback);
                return;
            default:
                return;
        }
    }

    private static ImmutableList<GoodwillPublishPhoto> m67a(List<GoodwillPhoto> list) {
        Builder builder = ImmutableList.builder();
        for (GoodwillPhoto goodwillPhoto : list) {
            String str = goodwillPhoto.f68a;
            if (str == null) {
                str = String.valueOf(goodwillPhoto.f69b.e);
            }
            builder.c(new GoodwillPublishPhoto(str, goodwillPhoto.m89d().toString()));
        }
        return builder.b();
    }

    private void m85n() {
        Uri uri;
        String str;
        ImmutableList g = this.f62u.m96g();
        Bundle bundle = new Bundle();
        if (g == null || g.isEmpty()) {
            uri = null;
        } else {
            uri = ((GoodwillPhoto) g.get(0)).m89d();
        }
        SharePreview.Builder builder = new SharePreview.Builder();
        builder.a = this.f62u.f73c;
        builder = builder;
        if (uri == null) {
            str = null;
        } else {
            str = uri.toString();
        }
        builder.d = str;
        SharePreview a = builder.a();
        ComposerConfiguration.Builder disableMentions = ComposerConfiguration.newBuilder().setComposerType(ComposerType.GOODWILL_CAMPAIGN).setSourceType(ComposerSourceType.FEED).setPluginConfig(this.f58q.a(GoodwillCampaignComposerPluginConfig.m51a(this.f62u.f72b, m86o()))).setIsEditTagEnabled(false).setNectarModule("goodwill_composer").setDisableFriendTagging(true).setDisableMentions(true);
        ComposerShareParams.Builder a2 = ComposerShareParams.Builder.a(GraphQLHelper.a(this.f62u.f71a, this.f62u.f78h));
        a2.d = a;
        ComposerShareParams.Builder builder2 = a2;
        builder2.e = this.f62u.f71a;
        ComposerConfiguration a3 = disableMentions.setInitialShareParams(builder2.b()).a();
        bundle.putParcelable("extra_composer_configuration", a3);
        this.f57p.a(this.f62u.f71a, this.f62u.f79i, GoodwillAnalyticsLogger$Events.GOODWILL_COMPOSER_FINAL_STEP);
        this.f67z.a(null, a3, 15151, this);
    }

    private String m86o() {
        if (Objects.equal("mle", this.f66y)) {
            return getResources().getString(2131239215);
        }
        return null;
    }

    public static void m87p(GoodwillComposerActivity goodwillComposerActivity) {
        goodwillComposerActivity.f57p.a(goodwillComposerActivity.f62u.f71a, goodwillComposerActivity.f62u.f79i, GoodwillAnalyticsLogger$Events.GOODWILL_COMPOSER_CANCEL);
        goodwillComposerActivity.finish();
    }

    public static Intent m66a(Context context, GoodwillComposerEvent goodwillComposerEvent, String[] strArr, String str) {
        Intent intent = new Intent(context, GoodwillComposerActivity.class);
        intent.putExtra("STEPS", strArr);
        intent.putExtra("INPUT", goodwillComposerEvent);
        intent.putExtra("OUTPUT", str);
        return intent;
    }
}
