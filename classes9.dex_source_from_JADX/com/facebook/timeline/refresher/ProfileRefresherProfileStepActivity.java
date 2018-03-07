package com.facebook.timeline.refresher;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.auth.module.User_LoggedInUserMethodAutoProvider;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.inject.FbInjector;
import com.facebook.timeline.refresher.ProfileRefresherHeaderFragment.HeaderFragmentListener;
import com.facebook.timeline.refresher.ui.ProfileRefresherAnimationHelper;
import com.facebook.user.model.User;
import com.facebook.widget.titlebar.TitleBarButtonSpecCacheProvider;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: unpublished_media */
public class ProfileRefresherProfileStepActivity extends FbFragmentActivity implements HeaderFragmentListener, EventListener {
    private static final Interpolator f1029s = PathInterpolatorCompat.a(0.25f, 0.1f, 0.25f, 1.0f);
    @Inject
    @LoggedInUser
    User f1030p;
    @Inject
    TitleBarButtonSpecCacheProvider f1031q;
    private ProfileRefresherAnimationHelper f1032r;
    @Nullable
    private ProfileRefresherView f1033t;
    private ProfileRefresherHeaderFragment f1034u;

    private static <T extends Context> void m1042a(Class<T> cls, T t) {
        m1043a((Object) t, (Context) t);
    }

    public static void m1043a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileRefresherProfileStepActivity) obj).m1041a(User_LoggedInUserMethodAutoProvider.b(fbInjector), (TitleBarButtonSpecCacheProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(TitleBarButtonSpecCacheProvider.class));
    }

    public final void m1044b(Bundle bundle) {
        super.b(bundle);
        Class cls = ProfileRefresherProfileStepActivity.class;
        m1043a((Object) this, (Context) this);
        this.f1032r = new ProfileRefresherAnimationHelper();
        this.f1032r.f1101a = f1029s;
        setContentView(2130906465);
        this.f1033t = (ProfileRefresherView) a(2131566384);
        this.f1033t.setListener(this);
        this.f1033t.setName(this.f1030p.e.toString());
        this.f1033t.f1046f.setText(getResources().getString(2131235052));
        this.f1033t.f1047g.setText(getResources().getString(2131235053));
        this.f1033t.setTitleBarButtonSpecs(this.f1031q.a(2131230751).a());
        this.f1033t.setTitleBarButtonListener(this.f1033t.f1059s);
        this.f1033t.f1045e.inflate().setVisibility(0);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("extra_is_from_qp", true);
        this.f1034u = ProfileRefresherHeaderFragment.m1007n(bundle2);
        kO_().a().a(2131566389, this.f1034u).b();
        this.f1032r.m1182a(null, this.f1033t, this.f1034u, true);
    }

    public final void mo51d() {
        super.finish();
    }

    public final void mo52e() {
        super.onBackPressed();
    }

    private void m1041a(User user, TitleBarButtonSpecCacheProvider titleBarButtonSpecCacheProvider) {
        this.f1030p = user;
        this.f1031q = titleBarButtonSpecCacheProvider;
    }

    public final void mo54i() {
        this.f1034u.au();
    }

    public final void mo55j() {
        this.f1034u.aw();
    }

    public final ProfileRefresherModel mo50m() {
        return null;
    }
}
