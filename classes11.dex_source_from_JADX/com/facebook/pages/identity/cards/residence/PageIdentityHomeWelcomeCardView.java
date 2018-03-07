package com.facebook.pages.identity.cards.residence;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.pages.common.surface.cards.interfaces.PageCards.PageSecondaryCardView;
import com.facebook.user.model.User;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: predictive_enabled */
public class PageIdentityHomeWelcomeCardView extends CustomFrameLayout implements PageSecondaryCardView {
    @Inject
    @LoggedInUser
    public Provider<User> f3650a;
    public TextView f3651b = ((TextView) c(2131565547));

    public static void m4682a(Object obj, Context context) {
        ((PageIdentityHomeWelcomeCardView) obj).f3650a = IdBasedProvider.a(FbInjector.get(context), 3595);
    }

    public PageIdentityHomeWelcomeCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = PageIdentityHomeWelcomeCardView.class;
        m4682a(this, getContext());
        setContentView(2130906041);
        this.f3651b.setText(getResources().getString(2131235508, new Object[]{((User) this.f3650a.get()).h()}));
    }
}
