package com.facebook.orca.contacts.divebar;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.ContextUtils;
import com.facebook.contacts.picker.ContactPickerGroupRow;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.messaging.analytics.search.FilterSessionManager;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: onPause */
public class DivebarViewListener {
    private static final Class<?> f5885a = DivebarViewListener.class;
    public final UriIntentMapper f5886b;
    public final SecureContextHelper f5887c;
    public final FilterSessionManager f5888d;
    public final FragmentActivity f5889e;

    public static DivebarViewListener m5542a(InjectorLike injectorLike) {
        return new DivebarViewListener((UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FragmentActivityMethodAutoProvider.b(injectorLike), FilterSessionManager.b(injectorLike));
    }

    @Inject
    public DivebarViewListener(UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, FragmentActivity fragmentActivity, FilterSessionManager filterSessionManager) {
        this.f5886b = uriIntentMapper;
        this.f5887c = secureContextHelper;
        this.f5889e = fragmentActivity;
        this.f5888d = filterSessionManager;
    }

    public final boolean m5547a(User user, boolean z, ContactPickerRow contactPickerRow, String str, int i) {
        if (z && user != null) {
            this.f5888d.a("fbid", i, user.a, "divebarUser");
        }
        m5544a(user, m5543a(str, contactPickerRow), contactPickerRow);
        return true;
    }

    public final boolean m5546a(ThreadSummary threadSummary, ContactPickerRow contactPickerRow, String str) {
        String formatStrLocaleSafe;
        String a = m5543a(str, contactPickerRow);
        ThreadKey threadKey = threadSummary.a;
        if (threadSummary.a.a == Type.ONE_TO_ONE) {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, Long.valueOf(threadKey.d));
        } else {
            formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.X, Long.valueOf(threadKey.b));
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(formatStrLocaleSafe));
        intent.putExtra("trigger", a);
        this.f5887c.a(intent, this.f5889e);
        return true;
    }

    private String m5543a(String str, ContactPickerRow contactPickerRow) {
        String str2;
        Preconditions.checkNotNull(contactPickerRow);
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null) {
            stringBuilder.append(str);
        }
        String str3 = null;
        if (contactPickerRow instanceof ContactPickerUserRow) {
            str3 = ((ContactPickerUserRow) contactPickerRow).m.toString();
        } else if (contactPickerRow instanceof ContactPickerGroupRow) {
            str3 = "groups";
        }
        if (str3 != null) {
            stringBuilder.append("_").append(str3);
        }
        AnalyticsActivity analyticsActivity = (AnalyticsActivity) ContextUtils.a(this.f5889e, AnalyticsActivity.class);
        if (analyticsActivity != null) {
            str2 = analyticsActivity.am_().toString();
        } else {
            str2 = "unknown".toString();
        }
        str3 = str2;
        if (str3 != null) {
            stringBuilder.append("_").append(str3);
        }
        return stringBuilder.toString();
    }

    private void m5544a(User user, String str, ContactPickerRow contactPickerRow) {
        if (m5545a(contactPickerRow)) {
            this.f5887c.a(this.f5886b.a(this.f5889e, StringFormatUtil.formatStrLocaleSafe(FBLinks.aX, user.a)), this.f5889e);
            return;
        }
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.R, user.a);
        Intent intent = new Intent();
        intent.setData(Uri.parse(formatStrLocaleSafe));
        intent.putExtra("trigger", str);
        this.f5887c.a(intent, this.f5889e);
    }

    private static boolean m5545a(ContactPickerRow contactPickerRow) {
        if ((contactPickerRow instanceof ContactPickerUserRow) && ((ContactPickerUserRow) contactPickerRow).m == ContactRowSectionType.SELF_PROFILE) {
            return true;
        }
        return false;
    }
}
