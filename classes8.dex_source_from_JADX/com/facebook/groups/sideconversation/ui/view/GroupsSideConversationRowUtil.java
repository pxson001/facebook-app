package com.facebook.groups.sideconversation.ui.view;

import android.content.res.Resources;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.i18n.BasicDateTimeFormat;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: emotional_icon_size */
public class GroupsSideConversationRowUtil {
    private static final String f14875a = GroupsSideConversationRowUtil.class.getName();
    private BasicDateTimeFormat f14876b;
    private Clock f14877c;
    private AbstractFbErrorReporter f14878d;
    private Resources f14879e;
    private String f14880f;

    private static GroupsSideConversationRowUtil m17340b(InjectorLike injectorLike) {
        return new GroupsSideConversationRowUtil(BasicDateTimeFormat.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public GroupsSideConversationRowUtil(BasicDateTimeFormat basicDateTimeFormat, Clock clock, AbstractFbErrorReporter abstractFbErrorReporter, Resources resources, String str) {
        this.f14876b = basicDateTimeFormat;
        this.f14877c = clock;
        this.f14878d = abstractFbErrorReporter;
        this.f14879e = resources;
        this.f14880f = str;
    }
}
