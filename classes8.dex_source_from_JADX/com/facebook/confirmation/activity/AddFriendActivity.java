package com.facebook.confirmation.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.confirmation.abtest.ExperimentsForConfirmationExperimentsModule;
import com.facebook.friending.jewel.FriendRequestsFragment;
import com.facebook.friending.newuserpromotion.NewUserFriendingFragment;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.inject.FbInjector;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: invalidated_suggestion */
public class AddFriendActivity extends FbFragmentActivity {
    @Inject
    public QeAccessor f10697p;

    /* compiled from: invalidated_suggestion */
    class C11391 extends OnToolbarButtonListener {
        final /* synthetic */ AddFriendActivity f10696a;

        C11391(AddFriendActivity addFriendActivity) {
            this.f10696a = addFriendActivity;
        }

        public final void m12622a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f10696a.finish();
        }
    }

    private static <T extends Context> void m12624a(Class<T> cls, T t) {
        m12625a((Object) t, (Context) t);
    }

    public static void m12625a(Object obj, Context context) {
        ((AddFriendActivity) obj).f10697p = (QeAccessor) QeInternalImplMethodAutoProvider.a(FbInjector.get(context));
    }

    public final void m12626b(Bundle bundle) {
        Fragment fragment;
        super.b(bundle);
        Class cls = AddFriendActivity.class;
        m12625a((Object) this, (Context) this);
        setContentView(2130903162);
        if (this.f10697p.a(ExperimentsForConfirmationExperimentsModule.f10695a, false)) {
            FriendingLocation friendingLocation = FriendingLocation.NUX;
            NewUserFriendingFragment newUserFriendingFragment = new NewUserFriendingFragment();
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable("FRIENDING_LOCATION", friendingLocation);
            newUserFriendingFragment.g(bundle2);
            fragment = newUserFriendingFragment;
        } else {
            fragment = new FriendRequestsFragment();
            ((FriendRequestsFragment) fragment).bu = FriendingLocation.NUX;
        }
        kO_().a().a(2131559365, fragment).b();
        Resources resources = getResources();
        FbTitleBarUtil.b(this);
        FbTitleBar fbTitleBar = (FbTitleBar) a(2131558563);
        fbTitleBar.setTitle(resources.getString(2131233212));
        fbTitleBar.setHasFbLogo(true);
        String string = resources.getString(2131230751);
        Builder a = TitleBarButtonSpec.a();
        a.g = string;
        a = a;
        a.j = string;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        fbTitleBar.setOnToolbarButtonListener(new C11391(this));
    }

    private void m12623a(QeAccessor qeAccessor) {
        this.f10697p = qeAccessor;
    }
}
