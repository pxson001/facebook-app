package com.facebook.messaging.sms.migration.util;

import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contactsync.learn.ContactsLearnMoreLinkHelper;
import com.facebook.widget.text.NoUnderlineClickableSpan;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: purchased_tickets_failed_count */
public class SMSContactsMigrationTextUtil {
    public final ContactsLearnMoreLinkHelper f4240a;
    public final Resources f4241b;

    /* compiled from: purchased_tickets_failed_count */
    class C06391 extends NoUnderlineClickableSpan {
        final /* synthetic */ SMSContactsMigrationTextUtil f4239a;

        C06391(SMSContactsMigrationTextUtil sMSContactsMigrationTextUtil) {
            this.f4239a = sMSContactsMigrationTextUtil;
        }

        public void onClick(View view) {
            this.f4239a.f4240a.m1896a();
        }
    }

    public static SMSContactsMigrationTextUtil m3864b(InjectorLike injectorLike) {
        return new SMSContactsMigrationTextUtil(ContactsLearnMoreLinkHelper.m1895b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SMSContactsMigrationTextUtil(ContactsLearnMoreLinkHelper contactsLearnMoreLinkHelper, Resources resources) {
        this.f4240a = contactsLearnMoreLinkHelper;
        this.f4241b = resources;
    }

    public final SpannableString m3865a(String str, String str2, @Nullable String str3) {
        if (str3 == null) {
            str3 = this.f4241b.getString(2131240057);
        }
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f4241b);
        styledStringBuilder.a(str);
        styledStringBuilder.a(str2, str3, new C06391(this), 33);
        return styledStringBuilder.b();
    }
}
