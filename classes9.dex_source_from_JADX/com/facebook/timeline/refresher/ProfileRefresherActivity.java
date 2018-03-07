package com.facebook.timeline.refresher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.refresher.ProfileNuxComposerFragment.ComposerFragmentListener;
import com.facebook.timeline.refresher.ProfileRefresherController.ActivityListener;
import com.facebook.timeline.refresher.ProfileRefresherFinishedFragment.FinishedFragmentListener;
import com.facebook.timeline.refresher.ProfileRefresherHeaderFragment.HeaderFragmentListener;
import com.facebook.timeline.refresher.ProfileRefresherInfoFragment.InfoFragmentListener;
import com.facebook.timeline.refresher.ProfileRefresherModel.Builder;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: updateLastRead */
public final class ProfileRefresherActivity extends FbFragmentActivity implements ComposerFragmentListener, ActivityListener, FinishedFragmentListener, HeaderFragmentListener, InfoFragmentListener {
    @Inject
    ProfileRefresherControllerProvider f938p;
    @Inject
    ProfileRefresherBinder f939q;
    private String f940r;
    private String f941s;
    private String f942t;
    private String f943u;
    private boolean f944v;
    private ProfileRefresherModel f945w;
    @Nullable
    private ProfileRefresherView f946x;
    private ProfileRefresherController f947y;
    @Nullable
    private Bundle f948z;

    private static <T extends Context> void m938a(Class<T> cls, T t) {
        m939a((Object) t, (Context) t);
    }

    public static void m939a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileRefresherActivity) obj).m937a((ProfileRefresherControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ProfileRefresherControllerProvider.class), new ProfileRefresherBinder((TitleBarButtonSpecCacheProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class)));
    }

    private void m937a(ProfileRefresherControllerProvider profileRefresherControllerProvider, ProfileRefresherBinder profileRefresherBinder) {
        this.f938p = profileRefresherControllerProvider;
        this.f939q = profileRefresherBinder;
    }

    public final void m941b(Bundle bundle) {
        super.b(bundle);
        Class cls = ProfileRefresherActivity.class;
        m939a((Object) this, (Context) this);
        this.f948z = bundle;
        this.f940r = getIntent().getStringExtra("name");
        this.f941s = getIntent().getStringExtra("profile_id");
        this.f942t = getIntent().getStringExtra("profile_pic_uri");
        this.f943u = getIntent().getStringExtra("cover_photo_high_res_uri");
        this.f944v = getIntent().getBooleanExtra("is_refresher", true);
        ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields = (ComposerTargetDataPrivacyScopeFields) FlatBufferModelHelper.a(getIntent(), "post_item_privacy");
        if (StringUtil.a(this.f941s)) {
            BLog.b(ProfileRefresherActivity.class, "Profile id must be set");
            setResult(0);
            finish();
            return;
        }
        Builder builder = new Builder();
        builder.f1007a = this.f940r;
        builder = builder;
        builder.f1008b = this.f941s;
        builder = builder;
        builder.f1009c = this.f942t;
        builder = builder;
        builder.f1010d = this.f943u;
        builder = builder;
        builder.f1011e = this.f944v;
        builder = builder;
        builder.f1012f = composerTargetDataPrivacyScopeFields;
        Builder builder2 = builder;
        this.f945w = new ProfileRefresherModel(builder2.f1007a, builder2.f1008b, builder2.f1009c, builder2.f1010d, builder2.f1011e, builder2.f1012f);
        setContentView(2130906465);
        this.f946x = (ProfileRefresherView) a(2131566384);
        this.f947y = this.f938p.m996a(this, this.f939q, this.f945w, this.f946x);
        this.f947y.m986a(bundle);
    }

    public final void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -409098029);
        super.onStop();
        ProfileRefresherController profileRefresherController = this.f947y;
        if (profileRefresherController.f968b.m1034q()) {
            profileRefresherController.f967a.m969c(profileRefresherController.f968b);
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -587724446, a);
    }

    public final void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -250913516);
        super.onResume();
        ProfileRefresherController profileRefresherController = this.f947y;
        profileRefresherController.f967a.m968b(profileRefresherController.f968b);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1891579413, a);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ProfileRefresherController profileRefresherController = this.f947y;
        BaseModel baseModel = profileRefresherController.f968b.f1024l;
        if (baseModel != null) {
            FlatBufferModelHelper.a(bundle, "profile_nux_refresher_model", baseModel);
        }
        if (profileRefresherController.f970d.f1052l != null) {
            ProfileRefresherPagerAdapter profileRefresherPagerAdapter = profileRefresherController.f970d.f1052l;
            for (Fragment fragment : profileRefresherPagerAdapter.f1026b) {
                if (fragment.mx_()) {
                    if (fragment instanceof ProfileRefresherHeaderFragment) {
                        profileRefresherPagerAdapter.f1025a.a(bundle, "nux_refresher_header_fragment", fragment);
                    } else if (fragment instanceof ProfileRefresherInfoFragment) {
                        profileRefresherPagerAdapter.f1025a.a(bundle, "nux_refresher_info_fragment", fragment);
                    } else if (fragment instanceof ProfileNuxComposerFragment) {
                        profileRefresherPagerAdapter.f1025a.a(bundle, "nux_refresher_composer_fragment", fragment);
                    } else if (fragment instanceof ProfileRefresherFinishedFragment) {
                        profileRefresherPagerAdapter.f1025a.a(bundle, "nux_refresher_finished_fragment", fragment);
                    }
                }
            }
        }
    }

    public final void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 787826943);
        super.onDestroy();
        if (this.f947y != null) {
            ProfileRefresherController profileRefresherController = this.f947y;
            for (FutureAndCallbackHolder a2 : profileRefresherController.f974h) {
                a2.a(false);
            }
            profileRefresherController.f974h.clear();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1360073493, a);
    }

    public final void mo46i() {
        setResult(-1);
        finish();
    }

    public final void mo47j() {
        this.f947y.m993h();
    }

    public final void mo45a() {
        this.f947y.m992g();
    }

    public final void mo48k() {
        Toast.makeText(getApplicationContext(), getString(2131235019), 0).show();
    }

    public final void mo49l() {
        Preconditions.checkArgument(this.f946x != null);
        this.f946x.m1061a(kO_(), this.f945w, this.f948z);
    }

    public final ProfileRefresherModel mo50m() {
        return this.f945w;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ProfileRefresherController profileRefresherController = this.f947y;
        profileRefresherController.f970d.f1052l.m1038b(profileRefresherController.f968b.m1031e()).a(i, i2, intent);
    }
}
