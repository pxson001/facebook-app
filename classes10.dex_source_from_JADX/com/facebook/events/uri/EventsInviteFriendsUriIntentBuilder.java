package com.facebook.events.uri;

import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.events.invite.EventsExtendedInviteActivity;
import com.facebook.events.invite.EventsInviteFriendsSelectorActivity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: app_indexing */
public class EventsInviteFriendsUriIntentBuilder extends UriIntentBuilder {
    private static volatile EventsInviteFriendsUriIntentBuilder f19624a;

    public static com.facebook.events.uri.EventsInviteFriendsUriIntentBuilder m19902a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19624a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.events.uri.EventsInviteFriendsUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f19624a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m19903b();	 Catch:{ all -> 0x0034 }
        f19624a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f19624a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.uri.EventsInviteFriendsUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.events.uri.EventsInviteFriendsUriIntentBuilder");
    }

    private static EventsInviteFriendsUriIntentBuilder m19903b() {
        return new EventsInviteFriendsUriIntentBuilder();
    }

    @Inject
    public EventsInviteFriendsUriIntentBuilder() {
        Bundle bundle = new Bundle();
        bundle.putLongArray("profiles", new long[0]);
        bundle.putInt("target_fragment", ContentFragmentType.EVENTS_INVITE_FRAGMENT.ordinal());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("event/{%s}/extendedinvite"), "event_id"), EventsExtendedInviteActivity.class, bundle);
        Class cls = EventsInviteFriendsSelectorActivity.class;
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("event/{%s}/invite"), "event_id"), cls, bundle);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("event/{%s}/invitegroup/{%s}"), "event_id", "group_id"), cls, bundle);
    }
}
