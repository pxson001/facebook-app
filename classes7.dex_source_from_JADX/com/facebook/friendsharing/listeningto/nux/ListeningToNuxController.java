package com.facebook.friendsharing.listeningto.nux;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutNuxProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: SAVED */
public class ListeningToNuxController implements SproutNuxProvider {
    private final QeAccessor f23926a;
    public final Context f23927b;
    public final FbSharedPreferences f23928c;
    private final Resources f23929d;
    public boolean f23930e = false;

    public static ListeningToNuxController m26059b(InjectorLike injectorLike) {
        return new ListeningToNuxController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ListeningToNuxController(QeAccessor qeAccessor, Context context, FbSharedPreferences fbSharedPreferences, Resources resources) {
        this.f23926a = qeAccessor;
        this.f23927b = context;
        this.f23928c = fbSharedPreferences;
        this.f23929d = resources;
    }

    public final int mo1592a() {
        return 2130907205;
    }

    public final boolean mo1593b() {
        return (this.f23930e || this.f23928c.a(ComposerPrefKeys.q, false)) ? false : true;
    }

    public final Runnable mo1594c() {
        final String a = this.f23926a.a(ExperimentsForFeedUtilComposerAbtestModule.S, 2131234828, this.f23929d);
        return new Runnable(this) {
            final /* synthetic */ ListeningToNuxController f23925b;

            /* compiled from: SAVED */
            class C20731 implements OnClickListener {
                final /* synthetic */ C20741 f23923a;

                C20731(C20741 c20741) {
                    this.f23923a = c20741;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }

            public void run() {
                this.f23925b.f23930e = true;
                new Builder(this.f23925b.f23927b).a(false).b(a).a(2131230726, new C20731(this)).b();
                this.f23925b.f23928c.edit().putBoolean(ComposerPrefKeys.q, true).commit();
            }
        };
    }
}
