package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.FindViewUtil;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.badges.BadgesExperimentController;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.user.model.UserKey;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: name_length */
public class ThreadListTooltip {
    public final BadgesExperimentController f6738a;
    public final Context f6739b;
    public final FbSharedPreferences f6740c;
    private final Lazy<UserTileViewParamsFactory> f6741d;
    private final Resources f6742e;
    @Nullable
    public Tooltip f6743f;

    public static ThreadListTooltip m6424a(InjectorLike injectorLike) {
        return new ThreadListTooltip(BadgesExperimentController.b(injectorLike), (Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedLazy.a(injectorLike, 8294), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThreadListTooltip(BadgesExperimentController badgesExperimentController, Context context, FbSharedPreferences fbSharedPreferences, Lazy<UserTileViewParamsFactory> lazy, Resources resources) {
        this.f6738a = badgesExperimentController;
        this.f6739b = context;
        this.f6740c = fbSharedPreferences;
        this.f6741d = lazy;
        this.f6742e = resources;
    }

    private boolean m6425a(View view, int i, String str, int i2) {
        Optional a = FindViewUtil.a(view, i);
        if (a.isPresent()) {
            View view2 = (View) a.get();
            if (this.f6743f == null) {
                this.f6743f = new Tooltip(this.f6739b, 2131624619);
                this.f6743f.b(str);
                this.f6743f.t = i2;
                this.f6743f.a(view2);
            }
            return true;
        }
        if (this.f6743f != null) {
            this.f6743f.l();
            this.f6743f = null;
        }
        return false;
    }

    public final void m6426a(@Nullable ThreadKey threadKey, View view, int i) {
        if (threadKey != null) {
            TileBadge b = ((UserTileViewParamsFactory) this.f6741d.get()).b(UserKey.b(String.valueOf(threadKey.d)));
            if (b.equals(TileBadge.MESSENGER) && this.f6740c.a(MessagingPrefKeys.ag, true)) {
                if (m6425a(view, i, this.f6742e.getString(2131231826), -1)) {
                    this.f6740c.edit().putBoolean(MessagingPrefKeys.ag, false).commit();
                }
            } else if (b.equals(TileBadge.FACEBOOK) && !threadKey.b() && !threadKey.d() && this.f6740c.a(MessagingPrefKeys.ah, true) && m6425a(view, i, this.f6742e.getString(2131231827), -1)) {
                this.f6740c.edit().putBoolean(MessagingPrefKeys.ah, false).commit();
            }
        }
    }
}
