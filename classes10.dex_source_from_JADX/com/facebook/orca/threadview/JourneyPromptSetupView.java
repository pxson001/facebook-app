package com.facebook.orca.threadview;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.facebook.auth.annotations.ViewerContextUser;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.user.cache.UserCache;
import com.facebook.user.model.User;
import com.facebook.user.tiles.UserTileView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: method_results */
public class JourneyPromptSetupView extends CustomLinearLayout {
    @Inject
    public DataCache f7000a;
    @Inject
    @ViewerContextUser
    public Provider<User> f7001b;
    @Inject
    public ThreadParticipantUtils f7002c;
    @Inject
    public UserTileViewParamsFactory f7003d;
    @Inject
    public UserCache f7004e;
    public final ThemeListener f7005f = new ThemeListener(this);
    public UserTileView f7006g;
    public UserTileView f7007h;
    public TextView f7008i;
    public TextView f7009j;
    @Nullable
    public DefaultThreadViewTheme f7010k;

    /* compiled from: method_results */
    class ThemeListener implements Listener {
        final /* synthetic */ JourneyPromptSetupView f6999a;

        public ThemeListener(JourneyPromptSetupView journeyPromptSetupView) {
            this.f6999a = journeyPromptSetupView;
        }

        public final void m6581a() {
            JourneyPromptSetupView.m6584b(this.f6999a);
        }
    }

    public static void m6583a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((JourneyPromptSetupView) obj).m6582a(DataCache.a(fbInjector), IdBasedProvider.a(fbInjector, 3596), ThreadParticipantUtils.a(fbInjector), UserTileViewParamsFactory.a(fbInjector), UserCache.a(fbInjector));
    }

    public JourneyPromptSetupView(Context context) {
        super(context);
        Class cls = JourneyPromptSetupView.class;
        m6583a(this, getContext());
        setContentView(2130904992);
        setOrientation(1);
        this.f7006g = (UserTileView) a(2131563333);
        this.f7007h = (UserTileView) a(2131563334);
        this.f7008i = (TextView) a(2131563335);
        this.f7009j = (TextView) a(2131563336);
    }

    private void m6582a(DataCache dataCache, Provider<User> provider, ThreadParticipantUtils threadParticipantUtils, UserTileViewParamsFactory userTileViewParamsFactory, UserCache userCache) {
        this.f7000a = dataCache;
        this.f7001b = provider;
        this.f7002c = threadParticipantUtils;
        this.f7003d = userTileViewParamsFactory;
        this.f7004e = userCache;
    }

    public static void m6584b(JourneyPromptSetupView journeyPromptSetupView) {
        Preconditions.checkNotNull(journeyPromptSetupView.f7010k);
        journeyPromptSetupView.f7008i.setTextColor(journeyPromptSetupView.f7010k.c());
        journeyPromptSetupView.f7009j.setTextColor(journeyPromptSetupView.f7010k.d());
        Drawable background = journeyPromptSetupView.f7007h.getBackground();
        Preconditions.checkNotNull(journeyPromptSetupView.f7010k);
        int i = journeyPromptSetupView.f7010k.h.b;
        if (i == 0) {
            i = -1;
        }
        background.setColorFilter(i, Mode.SRC_ATOP);
    }
}
