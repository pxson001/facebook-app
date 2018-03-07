package com.facebook.orca.threadlist;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.cache.ThreadUnreadCountUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.modifiers.SlashMeAdminMessageFeature;
import com.facebook.orca.notify.NotificationSettingsUtil;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.ui.emoji.Emojis;
import com.facebook.user.model.UserKey;
import com.google.common.base.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: n_upsell_results */
public class ThreadSnippetDisplayUtil {
    private static final Pattern f6744a = Pattern.compile("\\n+");
    private static final Object f6745i = new Object();
    private final Resources f6746b;
    private final DataCache f6747c;
    private final EmojiUtil f6748d;
    private final ThreadUnreadCountUtil f6749e;
    private final NotificationSettingsUtil f6750f;
    private final SlashMeAdminMessageFeature f6751g;
    private final Provider<UserKey> f6752h;

    private static ThreadSnippetDisplayUtil m6429b(InjectorLike injectorLike) {
        return new ThreadSnippetDisplayUtil(ResourcesMethodAutoProvider.a(injectorLike), DataCache.a(injectorLike), EmojiUtil.a(injectorLike), ThreadUnreadCountUtil.a(injectorLike), NotificationSettingsUtil.b(injectorLike), SlashMeAdminMessageFeature.m3203b(injectorLike), IdBasedProvider.a(injectorLike, 3597));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.orca.threadlist.ThreadSnippetDisplayUtil m6427a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f6745i;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m6429b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f6745i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.orca.threadlist.ThreadSnippetDisplayUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.orca.threadlist.ThreadSnippetDisplayUtil) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f6745i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.orca.threadlist.ThreadSnippetDisplayUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.orca.threadlist.ThreadSnippetDisplayUtil.a(com.facebook.inject.InjectorLike):com.facebook.orca.threadlist.ThreadSnippetDisplayUtil");
    }

    @Inject
    public ThreadSnippetDisplayUtil(Resources resources, DataCache dataCache, EmojiUtil emojiUtil, ThreadUnreadCountUtil threadUnreadCountUtil, NotificationSettingsUtil notificationSettingsUtil, SlashMeAdminMessageFeature slashMeAdminMessageFeature, Provider<UserKey> provider) {
        this.f6746b = resources;
        this.f6747c = dataCache;
        this.f6748d = emojiUtil;
        this.f6749e = threadUnreadCountUtil;
        this.f6750f = notificationSettingsUtil;
        this.f6751g = slashMeAdminMessageFeature;
        this.f6752h = provider;
    }

    @Nullable
    public final Drawable m6430a(Context context, ThreadSummary threadSummary) {
        if (m6432a(threadSummary)) {
            return context.getResources().getDrawable(2130842124);
        }
        if (threadSummary.r == null || !Objects.equal(threadSummary.r.b, this.f6752h.get())) {
            return null;
        }
        if (this.f6749e.b(threadSummary)) {
            return ContextUtils.f(context, 2130773163, 2130842255);
        }
        return ContextUtils.f(context, 2130773164, 2130842284);
    }

    public final boolean m6432a(ThreadSummary threadSummary) {
        return !this.f6750f.a(threadSummary.a).b();
    }

    public final CharSequence m6431a(ThreadSummary threadSummary, int i) {
        TracerDetour.a("GetSnippetSpan", 1747025158);
        try {
            boolean z;
            CharSequence charSequence;
            CharSequence charSequence2 = threadSummary.q;
            if (StringUtil.a(charSequence2)) {
                z = false;
                charSequence = threadSummary.p;
            } else {
                charSequence = charSequence2;
                z = true;
            }
            ParticipantInfo participantInfo = threadSummary.r;
            StyledStringBuilder styledStringBuilder = new StyledStringBuilder(this.f6746b);
            boolean d = ThreadKey.d(threadSummary.a);
            if (charSequence == null || !(z || participantInfo != null || d)) {
                charSequence = "";
                return charSequence;
            }
            String replaceAll;
            Matcher matcher = f6744a.matcher(charSequence);
            if (matcher.find()) {
                replaceAll = matcher.replaceAll(" ");
            } else {
                CharSequence charSequence3 = charSequence;
            }
            if (this.f6751g.m3206a(replaceAll)) {
                styledStringBuilder.a(this.f6751g.m3204a(replaceAll, threadSummary.a, participantInfo));
            } else if (m6428a(threadSummary, participantInfo, replaceAll, z)) {
                String string = participantInfo.b.equals(this.f6752h.get()) ? this.f6746b.getString(2131231031) : this.f6747c.b(threadSummary.a, participantInfo);
                styledStringBuilder.a(this.f6746b.getString(2131231030, new Object[]{string, replaceAll}));
            } else {
                styledStringBuilder.a(replaceAll);
            }
            charSequence = new SpannableStringBuilder(Factory.getInstance().newSpannable(styledStringBuilder.b()));
            this.f6748d.a(charSequence, i);
            TracerDetour.a(1534210944);
            return charSequence;
        } finally {
            TracerDetour.a(676045584);
        }
    }

    private boolean m6428a(ThreadSummary threadSummary, ParticipantInfo participantInfo, String str, boolean z) {
        if (participantInfo == null) {
            return false;
        }
        Object obj;
        ThreadKey threadKey = threadSummary.a;
        if ((threadKey == null || threadKey.a != Type.ONE_TO_ONE) && (!ThreadKey.d(threadKey) || threadSummary.h.size() > 2)) {
            obj = null;
        } else {
            obj = 1;
        }
        boolean z2 = (obj == null || participantInfo.b.equals(this.f6752h.get())) ? false : true;
        if (z2) {
            return false;
        }
        if (!z || Emojis.b.equals(str)) {
            return true;
        }
        return false;
    }
}
