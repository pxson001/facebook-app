package com.facebook.messaging.photos.tiles;

import android.net.Uri;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.attachments.AttachmentUriHelper;
import com.facebook.messaging.cache.ThreadDisplayCache;
import com.facebook.messaging.cache.ThreadParticipantUtils;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadParticipant;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.photos.tiles.model.MessengerThreadTileViewData.Builder;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileViewLogic;
import com.facebook.widget.tiles.ThreadTileViewData;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: dialog/share?href={share_link}&app_id={#app_id 0}&in_app={in_app false}&quote={quote null} */
public class MessengerThreadTileViewDataFactory {
    private static final Object f16303g = new Object();
    private final ThreadDisplayCache f16304a;
    public final UserTileViewLogic f16305b;
    private final ThreadParticipantUtils f16306c;
    private final AttachmentUriHelper f16307d;
    public final UserTileViewParamsFactory f16308e;
    private final Provider<UserKey> f16309f;

    private static MessengerThreadTileViewDataFactory m16374b(InjectorLike injectorLike) {
        return new MessengerThreadTileViewDataFactory(ThreadDisplayCache.m10136a(injectorLike), UserTileViewLogic.a(injectorLike), ThreadParticipantUtils.m10155a(injectorLike), AttachmentUriHelper.b(injectorLike), UserTileViewParamsFactory.m16379a(injectorLike), IdBasedProvider.a(injectorLike, 3597));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory m16373a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16303g;	 Catch:{ all -> 0x006c }
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
        r1 = m16374b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16303g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory) r0;	 Catch:{  }
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
        r0 = f16303g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.photos.tiles.MessengerThreadTileViewDataFactory");
    }

    @Inject
    public MessengerThreadTileViewDataFactory(ThreadDisplayCache threadDisplayCache, UserTileViewLogic userTileViewLogic, ThreadParticipantUtils threadParticipantUtils, AttachmentUriHelper attachmentUriHelper, UserTileViewParamsFactory userTileViewParamsFactory, Provider<UserKey> provider) {
        this.f16304a = threadDisplayCache;
        this.f16305b = userTileViewLogic;
        this.f16306c = threadParticipantUtils;
        this.f16307d = attachmentUriHelper;
        this.f16308e = userTileViewParamsFactory;
        this.f16309f = provider;
    }

    public final ThreadTileViewData m16377a(User user) {
        Builder builder = new Builder();
        builder.a = this.f16305b;
        builder = builder;
        builder.b = user.T.c();
        builder = builder;
        builder.f = this.f16308e.m16385b(user);
        builder = builder;
        builder.e = ImmutableList.of(user.T);
        builder = builder;
        builder.h = user.k();
        Builder builder2 = builder;
        builder2.f = this.f16308e.m16385b(user);
        return builder2.a();
    }

    public final int m16378b(ThreadSummary threadSummary) {
        if (((threadSummary.b() || threadSummary.c()) && m16375c(threadSummary).isAbsolute()) || ThreadDisplayCache.m10138c(threadSummary) <= 2) {
            return 1;
        }
        return Math.max(1, Math.min(this.f16304a.m10144b(threadSummary).size(), 3));
    }

    private Uri m16375c(ThreadSummary threadSummary) {
        if (threadSummary.c()) {
            return threadSummary.t;
        }
        Uri.Builder a = this.f16307d.a();
        a.appendQueryParameter("tid", "t_" + threadSummary.a.i());
        a.appendQueryParameter("hash", threadSummary.s);
        a.appendQueryParameter("format", "binary");
        return a.build();
    }

    public final ThreadTileViewData m16376a(ThreadSummary threadSummary) {
        Builder builder = new Builder();
        builder.a = this.f16305b;
        builder = builder;
        builder.b = threadSummary.a.toString();
        builder = builder;
        if (threadSummary.b() || threadSummary.c()) {
            if (m16375c(threadSummary).isAbsolute()) {
                builder.c = m16375c(threadSummary);
                return builder.a();
            }
            BLog.c("MessengerThreadTileViewDataFactory", "Uri is not absolute - Uri: %s TK: %s", new Object[]{Strings.nullToEmpty(m16375c(threadSummary).getPath()), threadSummary.a});
        }
        List b = this.f16304a.m10144b(threadSummary);
        int c = ThreadDisplayCache.m10138c(threadSummary);
        if (c == 1) {
            ParticipantInfo a = m16372a(b, 0);
            builder = builder.a(a.b);
            builder.h = a.c;
            return builder.a();
        } else if (c == 2) {
            ThreadParticipant a2 = this.f16306c.m10158a(threadSummary);
            builder.a(a2.b()).h = a2.e();
            ThreadKey threadKey = threadSummary.a;
            if (threadKey.a != Type.GROUP) {
                if (ThreadKey.g(threadKey)) {
                    builder.f = TileBadge.TINCAN;
                } else if (ThreadKey.e(threadKey)) {
                    builder.f = TileBadge.NONE;
                    builder.c = Uri.parse("res:///" + String.valueOf(2130843399));
                } else {
                    builder.f = this.f16308e.m16386b(a2.b());
                }
            }
            return builder.a();
        } else if (b.size() < 2) {
            builder.d = true;
            return builder.a();
        } else {
            if (threadSummary.a.a == Type.SMS) {
                builder.f = TileBadge.SMS;
                builder.c = Uri.parse("res:///" + String.valueOf(2130843400));
            }
            builder.e = ImmutableList.of(m16372a(b, 0).b, m16372a(b, 1).b, m16372a(b, 2).b);
            return builder.a();
        }
    }

    private ParticipantInfo m16372a(List<ParticipantInfo> list, int i) {
        if (list == null || list.size() == 0 || i >= list.size()) {
            return new ParticipantInfo((UserKey) this.f16309f.get(), null);
        }
        return (ParticipantInfo) list.get(i);
    }
}
