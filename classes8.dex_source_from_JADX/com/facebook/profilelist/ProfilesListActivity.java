package com.facebook.profilelist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import javax.inject.Inject;

/* compiled from: removed_prefilled_tag_idx */
public final class ProfilesListActivity extends FbFragmentActivity {
    public ProfilesListFragment f4567p;
    public FbTitleBarUtil f4568q;

    /* compiled from: removed_prefilled_tag_idx */
    class C06001 extends OnToolbarButtonListener {
        final /* synthetic */ ProfilesListActivity f4566a;

        C06001(ProfilesListActivity profilesListActivity) {
            this.f4566a = profilesListActivity;
        }

        public final void m4425a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f4566a.f4567p.m4463b();
        }
    }

    private static <T extends Context> void m4429a(Class<T> cls, T t) {
        m4430a((Object) t, (Context) t);
    }

    public static void m4430a(Object obj, Context context) {
        ((ProfilesListActivity) obj).f4568q = FbTitleBarUtil.a(FbInjector.get(context));
    }

    public static Intent m4426a(Context context, long j, ImmutableList<FacebookProfile> immutableList, String str) {
        Intent intent = new Intent(context, ProfilesListActivity.class);
        intent.putParcelableArrayListExtra("full_profiles", Lists.a(immutableList));
        intent.putExtra("config", new ProfilesListActivityConfig(2131234716, 2131234719, 2131234718, false, j));
        intent.putExtra("extra_composer_session_id", str);
        return intent;
    }

    public final void m4431b(Bundle bundle) {
        super.b(bundle);
        Class cls = ProfilesListActivity.class;
        m4430a((Object) this, (Context) this);
        setContentView(2130906442);
        FbTitleBarUtil.b(this);
        Intent intent = getIntent();
        ProfilesListActivityConfig profilesListActivityConfig = (ProfilesListActivityConfig) intent.getParcelableExtra("config");
        Optional c = c(2131558563);
        if (c.isPresent()) {
            FbTitleBar fbTitleBar = (FbTitleBar) c.get();
            fbTitleBar.setTitle(profilesListActivityConfig.f4569a);
            Builder a = TitleBarButtonSpec.a();
            a.a = 1;
            a = a;
            a.g = getString(2131234445);
            a = a;
            a.h = -2;
            fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
            fbTitleBar.setOnToolbarButtonListener(new C06001(this));
        }
        this.f4567p = (ProfilesListFragment) kO_().a(2131566357);
        Iterable parcelableArrayListExtra = intent.getParcelableArrayListExtra("full_profiles");
        this.f4567p.m4459a(profilesListActivityConfig);
        this.f4567p.m4461a(Sets.b(parcelableArrayListExtra));
        this.f4567p.al = intent.getStringExtra("extra_composer_internal_session_id");
    }

    @Inject
    private void m4428a(FbTitleBarUtil fbTitleBarUtil) {
        this.f4568q = fbTitleBarUtil;
    }
}
