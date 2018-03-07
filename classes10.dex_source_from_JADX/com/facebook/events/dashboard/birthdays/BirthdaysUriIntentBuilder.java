package com.facebook.events.dashboard.birthdays;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.events.dashboard.DashboardFilterType;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Provider;

@UriMapPattern
/* compiled from: com.facebook.timeline.header.intro.protocol.favPhotosQueryTag */
public class BirthdaysUriIntentBuilder extends UriIntentBuilder {
    private GatekeeperStoreImpl f16973a;
    public Provider<ComponentName> f16974b;

    /* compiled from: com.facebook.timeline.header.intro.protocol.favPhotosQueryTag */
    class BirthdayIntentBuilder implements IUriTemplateIntentBuilder {
        final /* synthetic */ BirthdaysUriIntentBuilder f16972a;

        public BirthdayIntentBuilder(BirthdaysUriIntentBuilder birthdaysUriIntentBuilder) {
            this.f16972a = birthdaysUriIntentBuilder;
        }

        public final Intent m17297a(Context context, Bundle bundle) {
            String format;
            String string = bundle.getString("birthday_view_start_date");
            if (string == null || string.equals("unset")) {
                format = new SimpleDateFormat("yyyy/MM/dd", Locale.US).format(GregorianCalendar.getInstance().getTime());
            } else {
                format = string;
            }
            Intent intent = new Intent();
            intent.setComponent((ComponentName) this.f16972a.f16974b.get());
            intent.putExtra("force_tabbed_dashboard", true);
            intent.putExtra("birthday_view_start_date", format);
            intent.putExtra("birthday_view_referrer_param", "notification");
            intent.putExtra("target_fragment", ContentFragmentType.EVENTS_DASHBOARD_FRAGMENT.ordinal());
            intent.putExtra("section_name", DashboardFilterType.BIRTHDAYS.name());
            return intent;
        }
    }

    public static BirthdaysUriIntentBuilder m17298b(InjectorLike injectorLike) {
        return new BirthdaysUriIntentBuilder(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 12));
    }

    @Inject
    public BirthdaysUriIntentBuilder(GatekeeperStore gatekeeperStore, @FragmentChromeActivity Provider<ComponentName> provider) {
        this.f16973a = gatekeeperStore;
        this.f16974b = provider;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("upcoming_birthdays?start_date=%s"), "{birthday_view_start_date unset}"), new BirthdayIntentBuilder(this));
    }
}
