package com.facebook.zero.iptest.prefs;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.zero.iptest.ZeroIPTestManager;
import javax.inject.Inject;

/* compiled from: events_creation_prompt_id */
public class ZeroIPTestPreference extends Preference {
    public final ZeroIPTestManager f13102a;
    public final Toaster f13103b;
    private final OnPreferenceClickListener f13104c = new C18271(this);

    /* compiled from: events_creation_prompt_id */
    class C18271 implements OnPreferenceClickListener {
        final /* synthetic */ ZeroIPTestPreference f13101a;

        C18271(ZeroIPTestPreference zeroIPTestPreference) {
            this.f13101a = zeroIPTestPreference;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f13101a.f13103b.a(new ToastBuilder("Running tests..."));
            this.f13101a.f13102a.m13139b();
            return true;
        }
    }

    public static ZeroIPTestPreference m13202a(InjectorLike injectorLike) {
        return new ZeroIPTestPreference((Context) injectorLike.getInstance(Context.class), ZeroIPTestManager.m13137a(injectorLike), Toaster.b(injectorLike));
    }

    @Inject
    public ZeroIPTestPreference(Context context, ZeroIPTestManager zeroIPTestManager, Toaster toaster) {
        super(context);
        this.f13102a = zeroIPTestManager;
        this.f13103b = toaster;
        setTitle(2131241627);
        setOnPreferenceClickListener(this.f13104c);
    }
}
