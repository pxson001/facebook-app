package com.facebook.growth.friendfinder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import javax.inject.Inject;

/* compiled from: paymentItemType */
public class ContinuousContactsUploadPreference extends CheckBoxOrSwitchPreference {
    private final OnSharedPreferenceChangeListener f7135a = new C07541(this);
    private final FbUriIntentHandler f7136b;
    public final FriendFinderPreferenceSetter f7137c;
    public final GatekeeperStoreImpl f7138d;
    public final TasksManager f7139e;
    public final Toaster f7140f;

    /* compiled from: paymentItemType */
    class C07541 implements OnSharedPreferenceChangeListener {
        final /* synthetic */ ContinuousContactsUploadPreference f7131a;

        C07541(ContinuousContactsUploadPreference continuousContactsUploadPreference) {
            this.f7131a = continuousContactsUploadPreference;
        }

        public final void m7417a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
            this.f7131a.setChecked(fbSharedPreferences.a(prefKey, false));
        }
    }

    /* compiled from: paymentItemType */
    public class C07562 implements OnClickListener {
        final /* synthetic */ ContinuousContactsUploadPreference f7133a;

        /* compiled from: paymentItemType */
        class C07551 extends AbstractDisposableFutureCallback {
            final /* synthetic */ C07562 f7132a;

            C07551(C07562 c07562) {
                this.f7132a = c07562;
            }

            protected final void m7418a(Object obj) {
                if (!this.f7132a.f7133a.f7138d.a(386, false)) {
                    this.f7132a.f7133a.f7140f.b(new ToastBuilder(2131236417));
                }
                this.f7132a.f7133a.setEnabled(true);
            }

            protected final void m7419a(Throwable th) {
                if (!this.f7132a.f7133a.f7138d.a(386, false)) {
                    this.f7132a.f7133a.f7137c.m7546a(true);
                    this.f7132a.f7133a.f7140f.b(new ToastBuilder(2131236418));
                }
                this.f7132a.f7133a.setEnabled(true);
            }
        }

        public C07562(ContinuousContactsUploadPreference continuousContactsUploadPreference) {
            this.f7133a = continuousContactsUploadPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f7133a.setEnabled(false);
            this.f7133a.f7139e.a(null, this.f7133a.f7137c.m7546a(false), new C07551(this));
        }
    }

    /* compiled from: paymentItemType */
    public class C07573 implements OnClickListener {
        final /* synthetic */ ContinuousContactsUploadPreference f7134a;

        public C07573(ContinuousContactsUploadPreference continuousContactsUploadPreference) {
            this.f7134a = continuousContactsUploadPreference;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    }

    public static ContinuousContactsUploadPreference m7420a(InjectorLike injectorLike) {
        return new ContinuousContactsUploadPreference((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbUriIntentHandler.a(injectorLike), FriendFinderPreferenceSetter.m7544b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public ContinuousContactsUploadPreference(Context context, FbSharedPreferences fbSharedPreferences, FbUriIntentHandler fbUriIntentHandler, FriendFinderPreferenceSetter friendFinderPreferenceSetter, GatekeeperStoreImpl gatekeeperStoreImpl, TasksManager tasksManager, Toaster toaster) {
        super(context);
        this.f7136b = fbUriIntentHandler;
        this.f7137c = friendFinderPreferenceSetter;
        this.f7138d = gatekeeperStoreImpl;
        this.f7139e = tasksManager;
        this.f7140f = toaster;
        PrefKey prefKey = this.f7137c.f7275m;
        a(prefKey);
        setTitle(2131236409);
        setSummaryOff(2131236407);
        setSummaryOn(2131236408);
        setDefaultValue(Boolean.valueOf(false));
        fbSharedPreferences.a(prefKey, this.f7135a);
    }

    protected void onClick() {
        if (isChecked()) {
            new Builder(getContext(), 2131624483).a(2131236412).b(2131236413).b(2131230727, new C07573(this)).a(2131236416, new C07562(this)).a().show();
            return;
        }
        this.f7136b.a(getContext(), StringFormatUtil.a(FBLinks.dP, new Object[]{CIFlow.CONTINUOUS_SYNC.value}));
    }
}
