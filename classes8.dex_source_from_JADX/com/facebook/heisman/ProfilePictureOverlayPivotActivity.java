package com.facebook.heisman;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.heisman.SingleCategoryFragment.SingleCategoryFragmentDelegate;
import com.facebook.heisman.intent.ProfilePictureOverlayCameraIntentData;
import com.facebook.heisman.intent.ProfilePictureOverlayPivotIntentData;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.CameraTitleFieldsModel;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.CameraTitleFieldsModel.ProfileOverlayCategoryModel;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.CameraTitleFieldsModel.ProfileOverlayCategoryModel.PagesModel;
import com.facebook.heisman.protocol.FetchImageOverlayGraphQLModels.ImageOverlayCameraTitleFieldsModel.Builder;
import com.facebook.heisman.protocol.ProfileOverlayCategoryGraphQLModels.ProfileOverlayCategoryPageFieldsModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Provider;

@UriMatchPatterns
/* compiled from: user_reviews_see_more_places_to_review_tap */
public class ProfilePictureOverlayPivotActivity extends FbFragmentActivity {
    @Inject
    volatile Provider<ProfilePictureOverlayAnalyticsLogger> f744p = UltralightRuntime.a;
    private final SingleCategoryFragmentDelegate f745q = new C00931(this);
    @Inject
    public Provider<ProfilePictureOverlayActivityLauncher> f746r;
    public ProfilePictureOverlayPivotIntentData f747s;
    public FbTitleBar f748t;

    /* compiled from: user_reviews_see_more_places_to_review_tap */
    class C00931 implements SingleCategoryFragmentDelegate {
        final /* synthetic */ ProfilePictureOverlayPivotActivity f742a;

        C00931(ProfilePictureOverlayPivotActivity profilePictureOverlayPivotActivity) {
            this.f742a = profilePictureOverlayPivotActivity;
        }

        public final void mo17b(String str) {
            if (this.f742a.f748t != null) {
                this.f742a.f748t.setTitle(str);
            }
        }

        public final void mo16a(ProfileOverlayCategoryPageFieldsModel profileOverlayCategoryPageFieldsModel, int i) {
            ProfilePictureOverlayPivotActivity profilePictureOverlayPivotActivity = this.f742a;
            ProfilePictureOverlayActivityLauncher profilePictureOverlayActivityLauncher = (ProfilePictureOverlayActivityLauncher) this.f742a.f746r.get();
            ProfilePictureOverlayPivotIntentData profilePictureOverlayPivotIntentData = this.f742a.f747s;
            ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) profileOverlayCategoryPageFieldsModel.d().a().get(0);
            Builder builder = new Builder();
            CameraTitleFieldsModel.Builder builder2 = new CameraTitleFieldsModel.Builder();
            builder2.a = profileOverlayCategoryPageFieldsModel.b();
            builder2 = builder2;
            ProfileOverlayCategoryModel.Builder builder3 = new ProfileOverlayCategoryModel.Builder();
            PagesModel.Builder builder4 = new PagesModel.Builder();
            builder4.a = i;
            builder3.a = builder4.a();
            builder2.b = builder3.a();
            builder.b = ImmutableList.of(builder2.a());
            ProfilePictureOverlayCameraIntentData.Builder builder5 = (ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) new ProfilePictureOverlayCameraIntentData.Builder(imageOverlayFieldsModel, profilePictureOverlayPivotIntentData.a(), profilePictureOverlayPivotIntentData.f()).a(profilePictureOverlayPivotIntentData.a.d)).b(profilePictureOverlayPivotIntentData.a.e)).a(profilePictureOverlayPivotIntentData.a.c);
            builder5.b = builder.a();
            profilePictureOverlayActivityLauncher.m650a(profilePictureOverlayPivotActivity, 123, ((ProfilePictureOverlayCameraIntentData.Builder) ((ProfilePictureOverlayCameraIntentData.Builder) builder5.a(profilePictureOverlayPivotIntentData.a.g)).a(profilePictureOverlayPivotIntentData.a.f)).a());
        }
    }

    /* compiled from: user_reviews_see_more_places_to_review_tap */
    class C00942 implements OnClickListener {
        final /* synthetic */ ProfilePictureOverlayPivotActivity f743a;

        C00942(ProfilePictureOverlayPivotActivity profilePictureOverlayPivotActivity) {
            this.f743a = profilePictureOverlayPivotActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1372100545);
            this.f743a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, -1996960487, a);
        }
    }

    private static <T extends Context> void m792a(Class<T> cls, T t) {
        m793a((Object) t, (Context) t);
    }

    public static void m793a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfilePictureOverlayPivotActivity) obj).m794a(IdBasedSingletonScopeProvider.a(fbInjector, 7161), IdBasedSingletonScopeProvider.a(fbInjector, 7160));
    }

    public final void m799b(Bundle bundle) {
        ProfilePictureOverlayPivotIntentData profilePictureOverlayPivotIntentData;
        super.b(bundle);
        Class cls = ProfilePictureOverlayPivotActivity.class;
        m793a((Object) this, (Context) this);
        Intent intent = getIntent();
        if (intent.hasExtra("heisman_pivot_intent_data")) {
            profilePictureOverlayPivotIntentData = (ProfilePictureOverlayPivotIntentData) intent.getParcelableExtra("heisman_pivot_intent_data");
        } else {
            String str = (String) Preconditions.checkNotNull(intent.getStringExtra("heisman_category_id"));
            profilePictureOverlayPivotIntentData = new ProfilePictureOverlayPivotIntentData.Builder(SafeUUIDGenerator.a().toString(), (String) Preconditions.checkNotNull(intent.getStringExtra("entry_point"))).d(str).a();
        }
        this.f747s = profilePictureOverlayPivotIntentData;
        setContentView(2130906459);
        this.f748t = m797i();
        if (kO_().a("single_category_fragment") == null) {
            kO_().a().b(2131566380, SingleCategoryFragment.m810a(this.f747s), "single_category_fragment").b();
        }
    }

    public final void m798a(Fragment fragment) {
        if (fragment instanceof SingleCategoryFragment) {
            ((SingleCategoryFragment) fragment).f773c = this.f745q;
        }
    }

    private FbTitleBar m797i() {
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.a(new C00942(this));
        return fbTitleBar;
    }

    private void m794a(Provider<ProfilePictureOverlayAnalyticsLogger> provider, Provider<ProfilePictureOverlayActivityLauncher> provider2) {
        this.f744p = provider;
        this.f746r = provider2;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 123 && i2 == -1) {
            finish();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        ((ProfilePictureOverlayAnalyticsLogger) this.f744p.get()).m669c(this.f747s.a());
    }
}
