package com.facebook.timeline.refresher;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.launch.ComposerIntentLauncher;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.services.intentbuilder.ProfileServicesIntentBuilder;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: updated_email */
public class ProfileNuxComposerClickHandler {
    public OnClickListener f923a;
    public OnClickListener f924b;
    public OnClickListener f925c;
    @LoggedInUser
    public final Provider<User> f926d;
    public final Lazy<ComposerIntentLauncher> f927e;
    public final Provider<ComposerLauncher> f928f;
    public final Provider<ProfileServicesIntentBuilder> f929g;

    /* compiled from: updated_email */
    public class C00871 implements OnClickListener {
        final /* synthetic */ ComposerTargetDataPrivacyScopeFields f915a;
        final /* synthetic */ FragmentActivity f916b;
        final /* synthetic */ ProfileNuxComposerClickHandler f917c;

        public C00871(ProfileNuxComposerClickHandler profileNuxComposerClickHandler, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields, FragmentActivity fragmentActivity) {
            this.f917c = profileNuxComposerClickHandler;
            this.f915a = composerTargetDataPrivacyScopeFields;
            this.f916b = fragmentActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1620026874);
            ((ComposerLauncher) this.f917c.f928f.get()).a(null, ((ProfileServicesIntentBuilder) this.f917c.f929g.get()).m1210a(((User) this.f917c.f926d.get()).a, ((User) this.f917c.f926d.get()).e.toString(), ProfileNuxComposerClickHandler.m924a(this.f917c), this.f915a).a(), 1756, this.f916b);
            Logger.a(2, EntryType.UI_INPUT_END, -527336268, a);
        }
    }

    /* compiled from: updated_email */
    public class C00882 implements OnClickListener {
        final /* synthetic */ FragmentActivity f918a;
        final /* synthetic */ ComposerTargetDataPrivacyScopeFields f919b;
        final /* synthetic */ ProfileNuxComposerClickHandler f920c;

        public C00882(ProfileNuxComposerClickHandler profileNuxComposerClickHandler, FragmentActivity fragmentActivity, ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields) {
            this.f920c = profileNuxComposerClickHandler;
            this.f918a = fragmentActivity;
            this.f919b = composerTargetDataPrivacyScopeFields;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 511525544);
            ComposerIntentLauncher composerIntentLauncher = (ComposerIntentLauncher) this.f920c.f927e.get();
            ProfileNuxComposerClickHandler profileNuxComposerClickHandler = this.f920c;
            FragmentActivity fragmentActivity = this.f918a;
            Context context = fragmentActivity;
            composerIntentLauncher.a(((ProfileServicesIntentBuilder) profileNuxComposerClickHandler.f929g.get()).m1209a(context, String.valueOf(((User) profileNuxComposerClickHandler.f926d.get()).a), ((User) profileNuxComposerClickHandler.f926d.get()).e.toString(), ProfileNuxComposerClickHandler.m924a(profileNuxComposerClickHandler), this.f919b), 1756, this.f918a);
            Logger.a(2, EntryType.UI_INPUT_END, -2021393355, a);
        }
    }

    /* compiled from: updated_email */
    public class C00893 implements OnClickListener {
        final /* synthetic */ FragmentActivity f921a;
        final /* synthetic */ ProfileNuxComposerClickHandler f922b;

        public C00893(ProfileNuxComposerClickHandler profileNuxComposerClickHandler, FragmentActivity fragmentActivity) {
            this.f922b = profileNuxComposerClickHandler;
            this.f921a = fragmentActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 205821304);
            ((ComposerIntentLauncher) this.f922b.f927e.get()).a(((ProfileServicesIntentBuilder) this.f922b.f929g.get()).m1208a(this.f921a), 1760, this.f921a);
            Logger.a(2, EntryType.UI_INPUT_END, -1180515554, a);
        }
    }

    @Inject
    public ProfileNuxComposerClickHandler(Provider<User> provider, Lazy<ComposerIntentLauncher> lazy, Provider<ComposerLauncher> provider2, Provider<ProfileServicesIntentBuilder> provider3) {
        this.f926d = provider;
        this.f927e = lazy;
        this.f928f = provider2;
        this.f929g = provider3;
    }

    public static String m924a(ProfileNuxComposerClickHandler profileNuxComposerClickHandler) {
        return ((User) profileNuxComposerClickHandler.f926d.get()).x() == null ? null : ((User) profileNuxComposerClickHandler.f926d.get()).x().toString();
    }
}
