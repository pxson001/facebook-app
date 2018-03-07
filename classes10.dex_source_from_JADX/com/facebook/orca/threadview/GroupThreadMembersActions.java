package com.facebook.orca.threadview;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.threadview.util.ThreadViewOpenHelper;
import com.facebook.user.model.User;
import javax.inject.Inject;

/* compiled from: mil */
public class GroupThreadMembersActions {
    private final Context f6961a;
    private final SecureContextHelper f6962b;
    private final AnalyticsLogger f6963c;
    private final ThreadViewOpenHelper f6964d;

    public static GroupThreadMembersActions m6571b(InjectorLike injectorLike) {
        return new GroupThreadMembersActions((Context) injectorLike.getInstance(Context.class), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ThreadViewOpenHelper.b(injectorLike));
    }

    @Inject
    public GroupThreadMembersActions(Context context, SecureContextHelper secureContextHelper, AnalyticsLogger analyticsLogger, ThreadViewOpenHelper threadViewOpenHelper) {
        this.f6961a = context;
        this.f6962b = secureContextHelper;
        this.f6963c = analyticsLogger;
        this.f6964d = threadViewOpenHelper;
    }

    public final void m6572a(ThreadKey threadKey) {
        AnalyticsLogger analyticsLogger = this.f6963c;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("click");
        honeyClientEvent.d = "button";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.e = "add_person";
        honeyClientEvent = honeyClientEvent;
        honeyClientEvent.c = "GroupContactCard";
        analyticsLogger.a(honeyClientEvent.a("thread_key", threadKey));
        this.f6962b.a(AddMembersActivity.m6444a(this.f6961a, threadKey), this.f6961a);
    }

    public final void m6573a(User user) {
        Object obj;
        ThreadViewOpenHelper threadViewOpenHelper = this.f6964d;
        String str = "view_people";
        if (ContextUtils.a(threadViewOpenHelper.a, Service.class) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            threadViewOpenHelper.d.a(user.a, user.k(), str);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", threadViewOpenHelper.c.a(user.a));
        intent.putExtra("modify_backstack_override", false);
        Intent intent2 = intent;
        intent2.putExtra("prefer_chat_if_possible", false);
        threadViewOpenHelper.b.a(intent2, threadViewOpenHelper.a);
    }
}
