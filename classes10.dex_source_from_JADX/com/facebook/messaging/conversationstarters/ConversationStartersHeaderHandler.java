package com.facebook.messaging.conversationstarters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.chatheads.ipc.ChatHeadsIntent;
import com.facebook.messaging.conversationstarters.graphql.ConversationStartersQueryInterfaces.ConversationStartersFields;
import javax.inject.Inject;

/* compiled from: start_month */
public class ConversationStartersHeaderHandler {
    private final SecureContextHelper f2260a;
    private final Context f2261b;
    private final AbstractFbErrorReporter f2262c;

    public static ConversationStartersHeaderHandler m2124a(InjectorLike injectorLike) {
        return new ConversationStartersHeaderHandler((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public ConversationStartersHeaderHandler(SecureContextHelper secureContextHelper, Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2260a = secureContextHelper;
        this.f2261b = context;
        this.f2262c = abstractFbErrorReporter;
    }

    public final void m2125a(ConversationStartersFields conversationStartersFields) {
        if (conversationStartersFields != null) {
            Object b = conversationStartersFields.b();
            if (!StringUtil.a(b)) {
                Uri parse = Uri.parse(b);
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.putExtra("trigger", "conversation_starter");
                intent.putExtra("use_thread_transition", true);
                intent.putExtra(ChatHeadsIntent.y, true);
                try {
                    if (FacebookUriUtil.g(parse)) {
                        intent.putExtra("modify_backstack_override", false);
                        this.f2260a.a(intent, this.f2261b);
                        return;
                    }
                    this.f2260a.b(intent, this.f2261b);
                } catch (Throwable e) {
                    this.f2262c.a("ConversationStartersHeaderController_ActivityNotFound", "ActivityNotFoundException when trying to start activity from uri " + parse.toString(), e);
                }
            }
        }
    }
}
