package com.facebook.reaction.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;
import com.facebook.common.time.Clock;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow.OnMenuItemClickListener;
import com.facebook.fig.menu.FigPopoverMenuWindow;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData.FeedbackType;
import com.facebook.graphql.calls.ViewerBlacklistPageFromGravityInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.placetips.settings.PlaceTipsLocationData;
import com.facebook.placetips.settings.PlaceTipsSettingsHelper;
import com.facebook.placetips.settings.graphql.GravitySettingsMutation.GravityBlacklistFeedbackMutationString;
import com.facebook.placetips.settings.ui.PlaceTipsBlacklistFeedbackActivity;
import com.facebook.reaction.ReactionSession;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: XHDPI */
public class GravityActionMenuHelper {
    private final Context f20754a;
    private final ReactionExperimentController f20755b;
    private final FbUriIntentHandler f20756c;
    private final PlaceTipsSettingsHelper f20757d;
    private final SecureContextHelper f20758e;
    private final Lazy<Toaster> f20759f;
    private final Clock f20760g;
    private final Fragment f20761h;
    public final ReactionSession f20762i;

    /* compiled from: XHDPI */
    class C21961 implements OnMenuItemClickListener {
        final /* synthetic */ GravityActionMenuHelper f20753a;

        C21961(GravityActionMenuHelper gravityActionMenuHelper) {
            this.f20753a = gravityActionMenuHelper;
        }

        public final boolean m24393a(MenuItem menuItem) {
            GravityActionMenuHelper.m24394a(this.f20753a, menuItem);
            return true;
        }
    }

    @Inject
    public GravityActionMenuHelper(@Assisted Fragment fragment, @Assisted ReactionSession reactionSession, @Assisted Context context, ReactionExperimentController reactionExperimentController, FbUriIntentHandler fbUriIntentHandler, PlaceTipsSettingsHelper placeTipsSettingsHelper, SecureContextHelper secureContextHelper, Lazy<Toaster> lazy, Clock clock) {
        this.f20754a = context;
        this.f20755b = reactionExperimentController;
        this.f20756c = fbUriIntentHandler;
        this.f20757d = placeTipsSettingsHelper;
        this.f20758e = secureContextHelper;
        this.f20759f = lazy;
        this.f20760g = clock;
        this.f20762i = reactionSession;
        this.f20761h = fragment;
    }

    public final boolean m24398a() {
        if (!this.f20755b.a.a(863, false) || !ReactionSurfaceUtil.m4781h(this.f20762i.f18660c)) {
            return false;
        }
        if (Strings.isNullOrEmpty(m24397e()) && (Strings.isNullOrEmpty(m24395c()) || Strings.isNullOrEmpty(m24396d()))) {
            return false;
        }
        return true;
    }

    public final boolean m24399a(View view) {
        boolean z = false;
        if (!m24398a()) {
            return false;
        }
        FigPopoverMenuWindow figPopoverMenuWindow = new FigPopoverMenuWindow(this.f20754a);
        figPopoverMenuWindow.b(2131820547);
        figPopoverMenuWindow.c(view);
        PopoverMenu c = figPopoverMenuWindow.c();
        MenuItemImpl menuItemImpl = (MenuItemImpl) c.findItem(2131568607);
        MenuItem findItem = c.findItem(2131568608);
        MenuItem findItem2 = c.findItem(2131568609);
        String c2 = m24395c();
        String d = m24396d();
        if (Strings.isNullOrEmpty(c2) || Strings.isNullOrEmpty(d)) {
            menuItemImpl.setVisible(false);
            findItem.setVisible(false);
        } else {
            boolean z2;
            menuItemImpl.setTitle(this.f20754a.getResources().getString(2131237279, new Object[]{d}));
            menuItemImpl.a(2131237280);
            menuItemImpl.setVisible(true);
            findItem.setTitle(this.f20754a.getResources().getString(2131237281, new Object[]{d}));
            if (ReactionSurfaceUtil.m4777c(this.f20762i.f18660c)) {
                z2 = false;
            } else {
                z2 = true;
            }
            findItem.setVisible(z2);
        }
        if (m24397e() != null) {
            z = true;
        }
        findItem2.setVisible(z);
        Preconditions.checkArgument(c.hasVisibleItems());
        figPopoverMenuWindow.p = new C21961(this);
        figPopoverMenuWindow.d();
        return true;
    }

    public static void m24394a(GravityActionMenuHelper gravityActionMenuHelper, MenuItem menuItem) {
        PlaceTipsLocationData placeTipsLocationData;
        int itemId = menuItem.getItemId();
        String c = gravityActionMenuHelper.m24395c();
        String d = gravityActionMenuHelper.m24396d();
        if (gravityActionMenuHelper.f20762i.f18681x != null) {
            placeTipsLocationData = (PlaceTipsLocationData) gravityActionMenuHelper.f20762i.f18681x.getParcelable("gravity_location_data");
        } else {
            placeTipsLocationData = null;
        }
        PlaceTipsLocationData placeTipsLocationData2 = placeTipsLocationData;
        if (itemId == 2131568607) {
            PlaceTipsSettingsHelper placeTipsSettingsHelper = gravityActionMenuHelper.f20757d;
            ViewerBlacklistPageFromGravityInputData viewerBlacklistPageFromGravityInputData = new ViewerBlacklistPageFromGravityInputData();
            viewerBlacklistPageFromGravityInputData.a("page_id", c);
            ((GraphQLQueryExecutor) placeTipsSettingsHelper.f3917b.get()).a(GraphQLRequest.a((GravityBlacklistFeedbackMutationString) new GravityBlacklistFeedbackMutationString().a("input", viewerBlacklistPageFromGravityInputData)));
            Intent intent = new Intent(gravityActionMenuHelper.f20754a, PlaceTipsBlacklistFeedbackActivity.class);
            if (placeTipsLocationData2 != null) {
                intent.putExtra("gravity_location_data", placeTipsLocationData2);
            }
            intent.putExtra("place_id", c);
            intent.putExtra("place_name", d);
            gravityActionMenuHelper.f20758e.a(intent, UnitInteractionType.PLACE_TIPS_HIDE_TAP.ordinal(), gravityActionMenuHelper.f20761h);
        } else if (itemId == 2131568608) {
            ((Toaster) gravityActionMenuHelper.f20759f.get()).b(new ToastBuilder(gravityActionMenuHelper.f20754a.getResources().getString(2131239390, new Object[]{d})));
            gravityActionMenuHelper.f20757d.m3891a(FeedbackType.INCORRECT_LOCATION, placeTipsLocationData2, c, gravityActionMenuHelper.f20760g.a());
        } else if (itemId == 2131568609) {
            gravityActionMenuHelper.f20756c.a(gravityActionMenuHelper.f20754a, gravityActionMenuHelper.m24397e());
        }
    }

    @Nullable
    private String m24395c() {
        return this.f20762i.f18681x != null ? this.f20762i.f18681x.getString("place_id") : null;
    }

    @Nullable
    private String m24396d() {
        return this.f20762i.f18681x != null ? this.f20762i.f18681x.getString("place_name") : null;
    }

    @Nullable
    private String m24397e() {
        return this.f20757d.m3890a();
    }
}
