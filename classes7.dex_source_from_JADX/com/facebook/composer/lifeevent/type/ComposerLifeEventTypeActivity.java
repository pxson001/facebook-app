package com.facebook.composer.lifeevent.type;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.composer.lifeevent.fetchbirthday.UserBirthdayFetcher;
import com.facebook.composer.lifeevent.fetchbirthday.UserBirthdayFetcher.C13211;
import com.facebook.composer.lifeevent.interstitial.ComposerLifeEventIconsActivity;
import com.facebook.composer.lifeevent.interstitial.ComposerLifeEventInterstitialActivity;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel.Builder;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQL.BirthdayQueryString;
import com.facebook.composer.lifeevent.protocol.FetchLifeEventComposerDataGraphQLModels.LifeEventFieldsModel;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.graphql.enums.GraphQLLifeEventAPIIdentifier;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.DefaultPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.lifeevent.config.LifeEventComposerPluginConfig;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: copyright_monitor_state */
public final class ComposerLifeEventTypeActivity extends FbFragmentActivity {
    private final OnToolbarButtonListener f16758A = new C13423(this);
    @Inject
    SecureContextHelper f16759p;
    @Inject
    ComposerLauncher f16760q;
    @Inject
    UserBirthdayFetcher f16761r;
    private FbTitleBar f16762s;
    private ComposerLifeEventTypeListFragment f16763t;
    private ComposerLifeEventTypeSubcategoryFragment f16764u;
    private int f16765v = -1;
    private ImmutableList f16766w;
    private ImmutableList f16767x;
    private final OnClickListener f16768y = new C13401(this);
    private final OnClickListener f16769z = new C13412(this);

    /* compiled from: copyright_monitor_state */
    class C13401 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventTypeActivity f16755a;

        C13401(ComposerLifeEventTypeActivity composerLifeEventTypeActivity) {
            this.f16755a = composerLifeEventTypeActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 834507150);
            Object tag = view.getTag(2131558565);
            if (tag instanceof ComposerLifeEventTypeSuggestionCategoryModel) {
                this.f16755a.m20787a((ComposerLifeEventTypeSuggestionCategoryModel) tag);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1506899075, a);
        }
    }

    /* compiled from: copyright_monitor_state */
    class C13412 implements OnClickListener {
        final /* synthetic */ ComposerLifeEventTypeActivity f16756a;

        C13412(ComposerLifeEventTypeActivity composerLifeEventTypeActivity) {
            this.f16756a = composerLifeEventTypeActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 746458347);
            Object tag = view.getTag(2131558565);
            if (tag instanceof LifeEventFieldsModel) {
                Object obj;
                LifeEventFieldsModel lifeEventFieldsModel = (LifeEventFieldsModel) tag;
                ComposerLifeEventModel a2 = new Builder(lifeEventFieldsModel).a();
                ComposerLifeEventTypeActivity composerLifeEventTypeActivity = this.f16756a;
                ComposerConfiguration.Builder b = ComposerConfigurationFactory.b(ComposerSourceType.TIMELINE);
                b.setInitialDateInfo(new ComposerDateInfo.Builder().a()).setPluginConfig(new DefaultPluginConfigSerializer().a(LifeEventComposerPluginConfig.c()));
                GraphQLLifeEventAPIIdentifier m = lifeEventFieldsModel.m();
                if (m == GraphQLLifeEventAPIIdentifier.ENGAGED || m == GraphQLLifeEventAPIIdentifier.MARRIED || m == GraphQLLifeEventAPIIdentifier.STARTED_JOB || m == GraphQLLifeEventAPIIdentifier.GRADUATED) {
                    obj = 1;
                } else {
                    obj = null;
                }
                Intent intent;
                if (obj != null) {
                    intent = new Intent(composerLifeEventTypeActivity.getIntent());
                    intent.setComponent(new ComponentName(composerLifeEventTypeActivity, ComposerLifeEventInterstitialActivity.class));
                    intent.putExtra("life_event_model", a2);
                    intent.putExtra("extra_composer_configuration", b.a());
                    intent.addFlags(33554432);
                    this.f16756a.f16759p.a(intent, composerLifeEventTypeActivity);
                    composerLifeEventTypeActivity.finish();
                } else if (((Boolean) view.getTag(2131558564)).booleanValue()) {
                    intent = ComposerLifeEventIconsActivity.m20761a(composerLifeEventTypeActivity);
                    intent.putExtra("extra_composer_life_event_model", a2);
                    intent.putExtra("extra_composer_life_event_custom", true);
                    this.f16756a.f16759p.a(intent, 0, composerLifeEventTypeActivity);
                } else {
                    this.f16756a.f16760q.a(null, b.a(a2).a(), 1756, composerLifeEventTypeActivity);
                }
            }
            LogUtils.a(-32675086, a);
        }
    }

    /* compiled from: copyright_monitor_state */
    class C13423 extends OnToolbarButtonListener {
        final /* synthetic */ ComposerLifeEventTypeActivity f16757a;

        C13423(ComposerLifeEventTypeActivity composerLifeEventTypeActivity) {
            this.f16757a = composerLifeEventTypeActivity;
        }

        public final void m20785a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f16757a.onBackPressed();
        }
    }

    private static <T extends Context> void m20789a(Class<T> cls, T t) {
        m20790a((Object) t, (Context) t);
    }

    public static void m20790a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ComposerLifeEventTypeActivity) obj).m20788a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), (ComposerLauncher) ComposerLauncherImpl.a(fbInjector), new UserBirthdayFetcher(GraphQLQueryExecutor.a(fbInjector), LoggedInUserSessionManager.a(fbInjector), IdBasedProvider.a(fbInjector, 3595)));
    }

    private void m20787a(ComposerLifeEventTypeSuggestionCategoryModel composerLifeEventTypeSuggestionCategoryModel) {
        String str = composerLifeEventTypeSuggestionCategoryModel.f16797a;
        FbTitleBar fbTitleBar = this.f16762s;
        if (str == null) {
            str = getString(2131234173);
        }
        fbTitleBar.setTitle(str);
        this.f16762s.setButtonSpecs(this.f16767x);
        ComposerLifeEventTypeSubcategoryFragment composerLifeEventTypeSubcategoryFragment = this.f16764u;
        boolean z = true;
        Preconditions.checkState(composerLifeEventTypeSuggestionCategoryModel != null);
        if (composerLifeEventTypeSuggestionCategoryModel.f16798b == null) {
            z = false;
        }
        Preconditions.checkState(z);
        composerLifeEventTypeSubcategoryFragment.f16796c = composerLifeEventTypeSuggestionCategoryModel.f16798b;
        kO_().a().b(2131560543, this.f16764u).b();
        this.f16765v = 2;
    }

    private void m20788a(SecureContextHelper secureContextHelper, ComposerLauncher composerLauncher, UserBirthdayFetcher userBirthdayFetcher) {
        this.f16759p = secureContextHelper;
        this.f16760q = composerLauncher;
        this.f16761r = userBirthdayFetcher;
    }

    public final void m20792b(Bundle bundle) {
        super.b(bundle);
        Class cls = ComposerLifeEventTypeActivity.class;
        m20790a((Object) this, (Context) this);
        UserBirthdayFetcher userBirthdayFetcher = this.f16761r;
        GraphQlQueryString birthdayQueryString = new BirthdayQueryString();
        birthdayQueryString.a("userId", ((User) userBirthdayFetcher.f16709c.get()).a);
        Futures.a(userBirthdayFetcher.f16707a.a(GraphQLRequest.a(birthdayQueryString).a(GraphQLCachePolicy.c)), new C13211(userBirthdayFetcher), MoreExecutors.a());
        setContentView(2130903688);
        this.f16763t = (ComposerLifeEventTypeListFragment) kO_().a(2131560544);
        if (this.f16763t == null) {
            this.f16763t = new ComposerLifeEventTypeListFragment();
            ComposerLifeEventTypeListFragment composerLifeEventTypeListFragment = this.f16763t;
            OnClickListener onClickListener = this.f16768y;
            OnClickListener onClickListener2 = this.f16769z;
            composerLifeEventTypeListFragment.an = onClickListener;
            composerLifeEventTypeListFragment.ao = onClickListener2;
        }
        this.f16764u = (ComposerLifeEventTypeSubcategoryFragment) kO_().a(2131560547);
        if (this.f16764u == null) {
            this.f16764u = new ComposerLifeEventTypeSubcategoryFragment();
            this.f16764u.f16795b = this.f16769z;
        }
        TitleBarButtonSpec.Builder a = TitleBarButtonSpec.a();
        a.a = 1;
        a = a;
        a.g = getString(2131230727);
        a = a;
        a.h = -2;
        this.f16766w = ImmutableList.of(a.a());
        a = TitleBarButtonSpec.a();
        a.a = 2;
        a = a;
        a.g = getString(2131230742);
        a = a;
        a.h = -2;
        this.f16767x = ImmutableList.of(a.a());
    }

    public final void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -327169879);
        super.onStart();
        View findViewById = findViewById(2131558562);
        if (findViewById != null) {
            FbTitleBarUtil.a(findViewById);
            this.f16762s = (FbTitleBar) a(2131558563);
            this.f16762s.setOnToolbarButtonListener(this.f16758A);
            m20791i();
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 644201546, a);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i != 0) {
            setResult(i2, intent);
            finish();
        } else if (i2 != 0) {
            ComposerConfiguration.Builder b = ComposerConfigurationFactory.b(ComposerSourceType.TIMELINE);
            b.setInitialDateInfo(new ComposerDateInfo.Builder().a()).setPluginConfig(new DefaultPluginConfigSerializer().a(LifeEventComposerPluginConfig.c()));
            this.f16760q.a(null, b.a((ComposerLifeEventModel) intent.getParcelableExtra("extra_composer_life_event_icon_model")).a(), 1756, this);
        }
    }

    public final void onBackPressed() {
        switch (this.f16765v) {
            case 1:
                this.f16763t.m20806b();
                setResult(0);
                finish();
                return;
            case 2:
                m20791i();
                return;
            default:
                throw new IllegalStateException("Unrecognized Fragment ID");
        }
    }

    private void m20791i() {
        this.f16762s.setTitle(2131234169);
        this.f16762s.setButtonSpecs(this.f16766w);
        kO_().a().b(2131560543, this.f16763t).b();
        this.f16765v = 1;
    }
}
