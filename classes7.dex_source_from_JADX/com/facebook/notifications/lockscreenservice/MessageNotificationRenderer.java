package com.facebook.notifications.lockscreenservice;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.android.String_PackageNameMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.debug.log.BLog;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.http.config.PlatformAppHttpConfig;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.messages.ipc.FrozenGroupMessageInfo;
import com.facebook.messages.ipc.FrozenNewMessageNotification;
import com.facebook.messages.ipc.FrozenParticipant;
import com.facebook.text.CustomFontUtil;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: network_recovered */
public class MessageNotificationRenderer {
    private static final Class f8349a = MessageNotificationRenderer.class;
    private static final CallerContext f8350b = CallerContext.a(MessageNotificationRenderer.class, "lockscreen_notifications");
    private static MessageNotificationRenderer f8351j;
    private static final Object f8352k = new Object();
    private final Resources f8353c;
    private final String f8354d;
    private final CustomFontUtil f8355e;
    private final Provider<PlatformAppHttpConfig> f8356f;
    private final Provider<ViewerContext> f8357g;
    private final Drawable f8358h = this.f8353c.getDrawable(2130841720);
    private final Drawable f8359i = this.f8353c.getDrawable(2130841725);

    private static MessageNotificationRenderer m9963b(InjectorLike injectorLike) {
        return new MessageNotificationRenderer(ResourcesMethodAutoProvider.a(injectorLike), String_PackageNameMethodAutoProvider.a(injectorLike), CustomFontUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 2243), IdBasedProvider.a(injectorLike, 372));
    }

    public static MessageNotificationRenderer m9959a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MessageNotificationRenderer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8352k) {
                MessageNotificationRenderer messageNotificationRenderer;
                if (a2 != null) {
                    messageNotificationRenderer = (MessageNotificationRenderer) a2.a(f8352k);
                } else {
                    messageNotificationRenderer = f8351j;
                }
                if (messageNotificationRenderer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9963b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8352k, b3);
                        } else {
                            f8351j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = messageNotificationRenderer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public MessageNotificationRenderer(Resources resources, String str, CustomFontUtil customFontUtil, Provider<PlatformAppHttpConfig> provider, Provider<ViewerContext> provider2) {
        this.f8353c = resources;
        this.f8354d = str;
        this.f8355e = customFontUtil;
        this.f8356f = provider;
        this.f8357g = provider2;
    }

    public final void m9964a(View view, MessageNotification messageNotification) {
        Drawable drawable;
        TextView textView = (TextView) view.findViewById(2131563623);
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131563626);
        TextView textView2 = (TextView) view.findViewById(2131563622);
        ViewAnimator viewAnimator = (ViewAnimator) view.findViewById(2131563625);
        FrozenNewMessageNotification frozenNewMessageNotification = messageNotification.f8348c;
        FrozenGroupMessageInfo frozenGroupMessageInfo = frozenNewMessageNotification.l;
        if (frozenGroupMessageInfo == null) {
            viewAnimator.setDisplayedChild(0);
            fbDraweeView.a(Uri.parse(m9961a(frozenNewMessageNotification.c)), f8350b);
        } else if (TextUtils.isEmpty(frozenGroupMessageInfo.d)) {
            ImmutableList immutableList = frozenGroupMessageInfo.b;
            FbDraweeView fbDraweeView2;
            if (immutableList.size() == 2) {
                viewAnimator.setDisplayedChild(1);
                fbDraweeView2 = (FbDraweeView) view.findViewById(2131563629);
                ((FbDraweeView) view.findViewById(2131563628)).a(Uri.parse(m9961a(((FrozenParticipant) immutableList.get(0)).a)), f8350b);
                fbDraweeView2.a(Uri.parse(m9961a(((FrozenParticipant) immutableList.get(1)).a)), f8350b);
            } else {
                viewAnimator.setDisplayedChild(2);
                fbDraweeView2 = (FbDraweeView) view.findViewById(2131563632);
                FbDraweeView fbDraweeView3 = (FbDraweeView) view.findViewById(2131563633);
                ((FbDraweeView) view.findViewById(2131563631)).a(Uri.parse(m9961a(((FrozenParticipant) immutableList.get(immutableList.size() - 1)).a)), f8350b);
                fbDraweeView2.a(Uri.parse(m9961a(((FrozenParticipant) immutableList.get(immutableList.size() - 2)).a)), f8350b);
                fbDraweeView3.a(Uri.parse(m9961a(((FrozenParticipant) immutableList.get(immutableList.size() - 3)).a)), f8350b);
            }
        } else {
            viewAnimator.setDisplayedChild(0);
            fbDraweeView.a(Uri.parse(m9962a(frozenNewMessageNotification.e, frozenGroupMessageInfo.d)), f8350b);
        }
        CharSequence charSequence = null;
        if (!(frozenGroupMessageInfo == null || Strings.isNullOrEmpty(frozenGroupMessageInfo.c))) {
            charSequence = frozenGroupMessageInfo.c;
        }
        String str = frozenNewMessageNotification.d;
        String str2 = frozenNewMessageNotification.f;
        String str3 = frozenNewMessageNotification.d;
        Object obj;
        if (TextUtils.isEmpty(charSequence)) {
            obj = str2;
            str2 = str;
        } else if (TextUtils.isEmpty(str3)) {
            String str4 = str2;
            CharSequence charSequence2 = charSequence;
            obj = str4;
        } else {
            Object obj2 = charSequence;
            charSequence = StringFormatUtil.a("%s: %s", new Object[]{str3, frozenNewMessageNotification.f});
        }
        if (TextUtils.isEmpty(obj2)) {
            textView.setText(charSequence);
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(obj2);
            spannableStringBuilder.setSpan(CustomFontUtil.a(), 0, obj2.length(), 33);
            spannableStringBuilder.append("\n");
            spannableStringBuilder.append(charSequence);
            textView.setText(spannableStringBuilder);
        }
        if (TextUtils.equals(m9960a(frozenNewMessageNotification.g), this.f8354d)) {
            drawable = this.f8358h;
        } else {
            drawable = this.f8359i;
        }
        textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, drawable, null);
        textView2.setText(Integer.toString(messageNotification.f8347b));
    }

    public static HoneyClientEvent m9958a(MessageNotification messageNotification) {
        HoneyClientEvent b = new HoneyClientEvent("lockscreen_notification_click").g("notifications").b("notification_type_clicked", "message");
        try {
            messageNotification.f8348c.f().send();
        } catch (Throwable e) {
            BLog.b(f8349a, "Error launching message notification", e);
        }
        return b;
    }

    private static String m9961a(String str) {
        return StringFormatUtil.a("https://graph.facebook.com/%s/picture?type=large", new Object[]{str});
    }

    private String m9962a(String str, String str2) {
        Builder a = ((PlatformAppHttpConfig) this.f8356f.get()).a();
        a.appendEncodedPath("method/messaging.getAttachment");
        a.appendQueryParameter("tid", str);
        a.appendQueryParameter("hash", str2);
        ViewerContext viewerContext = (ViewerContext) this.f8357g.get();
        if (viewerContext != null) {
            a.appendQueryParameter("access_token", viewerContext.mAuthToken);
        }
        a.appendQueryParameter("format", "binary");
        return a.build().toString();
    }

    private static String m9960a(PendingIntent pendingIntent) {
        if (VERSION.SDK_INT >= 17) {
            return pendingIntent.getCreatorPackage();
        }
        return pendingIntent.getTargetPackage();
    }
}
