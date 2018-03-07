package com.facebook.timeline;

import android.app.Activity;
import android.content.Intent;
import com.facebook.content.SecureContextHelper;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.profilenux.ProfileNuxModalActivity;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration;
import com.facebook.timeline.refresher.launcher.ProfileRefresherConfiguration.Builder;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groups_you_should_join */
public class ProfileNuxModalRunnableHelper {
    public final Provider<SecureContextHelper> f10183a;

    /* compiled from: groups_you_should_join */
    public class C14991 implements Runnable {
        final /* synthetic */ Activity f10179a;
        final /* synthetic */ TimelineHeaderUserData f10180b;
        final /* synthetic */ String f10181c;
        final /* synthetic */ ProfileNuxModalRunnableHelper f10182d;

        public C14991(ProfileNuxModalRunnableHelper profileNuxModalRunnableHelper, Activity activity, TimelineHeaderUserData timelineHeaderUserData, String str) {
            this.f10182d = profileNuxModalRunnableHelper;
            this.f10179a = activity;
            this.f10180b = timelineHeaderUserData;
            this.f10181c = str;
        }

        public void run() {
            String str;
            String str2 = null;
            Intent intent = new Intent(this.f10179a, ProfileNuxModalActivity.class);
            Builder builder = new Builder();
            builder.a = this.f10180b.N();
            builder = builder;
            builder.b = this.f10181c;
            builder = builder;
            builder.c = this.f10180b.L();
            builder = builder;
            builder.d = this.f10180b.R();
            builder = builder;
            builder.e = false;
            builder = builder;
            builder.f = this.f10180b.U();
            ProfileRefresherConfiguration a = builder.a();
            if (this.f10180b.l == null || this.f10180b.l.c() == null) {
                str = null;
            } else {
                str = this.f10180b.l.c().a();
            }
            if (!(this.f10180b.l == null || this.f10180b.l.a() == null)) {
                str2 = this.f10180b.l.a().a();
            }
            intent.putExtra("nux_modal_title", str);
            intent.putExtra("nux_modal_text", str2);
            intent.putExtra("refresher_configuration", a);
            intent.putExtra("profile_id", this.f10181c);
            ((SecureContextHelper) this.f10182d.f10183a.get()).a(intent, this.f10179a);
        }
    }

    @Inject
    public ProfileNuxModalRunnableHelper(Provider<SecureContextHelper> provider) {
        this.f10183a = provider;
    }
}
