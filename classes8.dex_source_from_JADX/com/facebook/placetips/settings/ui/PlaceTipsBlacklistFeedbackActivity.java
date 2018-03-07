package com.facebook.placetips.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.fragmentfactory.FragmentFactoryMap;
import com.facebook.common.fragmentfactory.FragmentFactoryMapImpl;
import com.facebook.graphql.calls.ViewerUnblacklistPageFromGravityInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.placetips.settings.graphql.GravitySettingsMutation.GravityUnblacklistFeedbackMutationString;
import com.facebook.placetips.settings.ui.PlaceTipsBlacklistPromptFragment.OnUndoItemClickedListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: captcha_solved */
public class PlaceTipsBlacklistFeedbackActivity extends FbFragmentActivity implements OnUndoItemClickedListener {
    @Inject
    FragmentFactoryMap f18415p;
    @Inject
    Lazy<PlaceTipsSettingsHelper> f18416q;
    private FbTitleBar f18417r;

    /* compiled from: captcha_solved */
    class C20181 extends OnToolbarButtonListener {
        final /* synthetic */ PlaceTipsBlacklistFeedbackActivity f18414a;

        C20181(PlaceTipsBlacklistFeedbackActivity placeTipsBlacklistFeedbackActivity) {
            this.f18414a = placeTipsBlacklistFeedbackActivity;
        }

        public final void m22351a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f18414a.finish();
        }
    }

    private static <T extends Context> void m22354a(Class<T> cls, T t) {
        m22355a((Object) t, (Context) t);
    }

    public static void m22355a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PlaceTipsBlacklistFeedbackActivity) obj).m22353a((FragmentFactoryMap) FragmentFactoryMapImpl.a(fbInjector), IdBasedSingletonScopeProvider.b(fbInjector, 9611));
    }

    private void m22353a(FragmentFactoryMap fragmentFactoryMap, Lazy<PlaceTipsSettingsHelper> lazy) {
        this.f18415p = fragmentFactoryMap;
        this.f18416q = lazy;
    }

    protected final void m22358b(Bundle bundle) {
        super.b(bundle);
        Class cls = PlaceTipsBlacklistFeedbackActivity.class;
        m22355a((Object) this, (Context) this);
        setContentView(2130906278);
        FbTitleBarUtil.b(this);
        this.f18417r = (FbTitleBar) a(2131558563);
        m22357k();
        if (kO_().a(2131558429) == null) {
            kO_().a().a(2131558429, this.f18415p.a(ContentFragmentType.PLACE_TIPS_BLACKLIST_PROMPT_FRAGMENT.ordinal()).a(new Intent())).b();
        }
    }

    public final void mo1098i() {
        String j = m22356j();
        if (!Strings.isNullOrEmpty(j)) {
            PlaceTipsSettingsHelper placeTipsSettingsHelper = (PlaceTipsSettingsHelper) this.f18416q.get();
            ViewerUnblacklistPageFromGravityInputData viewerUnblacklistPageFromGravityInputData = new ViewerUnblacklistPageFromGravityInputData();
            viewerUnblacklistPageFromGravityInputData.a("page_id", j);
            ((GraphQLQueryExecutor) placeTipsSettingsHelper.f3917b.get()).a(GraphQLRequest.a((GravityUnblacklistFeedbackMutationString) new GravityUnblacklistFeedbackMutationString().a("input", viewerUnblacklistPageFromGravityInputData)));
        }
        setResult(-1, new Intent().putExtra("gravity_undo_hide_place_tips", true));
        finish();
    }

    @Nullable
    private String m22356j() {
        return getIntent() != null ? getIntent().getStringExtra("place_id") : null;
    }

    private void m22357k() {
        if (this.f18417r != null) {
            this.f18417r.setTitle(2131239382);
            Builder a = TitleBarButtonSpec.a();
            a.g = getString(2131230752);
            a = a;
            a.d = true;
            this.f18417r.setButtonSpecs(ImmutableList.of(a.a()));
            this.f18417r.setOnToolbarButtonListener(new C20181(this));
        }
    }
}
