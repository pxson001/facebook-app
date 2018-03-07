package com.facebook.events.permalinkintent;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.common.EventActionContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.perf.InteractionTTILogger;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: header_favicon */
public class EventPermalinkIntentBuilder {
    private static final String f11475a = EventPermalinkIntentBuilder.class.getName();
    private static volatile EventPermalinkIntentBuilder f11476e;
    public final Provider<ComponentName> f11477b;
    private final SecureContextHelper f11478c;
    private final InteractionTTILogger f11479d;

    public static com.facebook.events.permalinkintent.EventPermalinkIntentBuilder m13395a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11476e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.permalinkintent.EventPermalinkIntentBuilder.class;
        monitor-enter(r1);
        r0 = f11476e;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13396b(r0);	 Catch:{ all -> 0x0035 }
        f11476e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11476e;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.permalinkintent.EventPermalinkIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.events.permalinkintent.EventPermalinkIntentBuilder");
    }

    private static EventPermalinkIntentBuilder m13396b(InjectorLike injectorLike) {
        return new EventPermalinkIntentBuilder(IdBasedProvider.a(injectorLike, 12), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), InteractionTTILogger.a(injectorLike));
    }

    @Inject
    public EventPermalinkIntentBuilder(@FragmentChromeActivity Provider<ComponentName> provider, SecureContextHelper secureContextHelper, InteractionTTILogger interactionTTILogger) {
        this.f11477b = provider;
        this.f11478c = secureContextHelper;
        this.f11479d = interactionTTILogger;
    }

    public final void m13397a(Context context, String str, EventActionContext eventActionContext) {
        Preconditions.checkNotNull(str);
        this.f11479d.a(context, f11475a);
        Preconditions.checkNotNull(str);
        Bundle bundle = new Bundle();
        bundle.putString("event_id", str);
        if (eventActionContext != null) {
            bundle.putParcelable("extras_event_action_context", eventActionContext);
        }
        Intent component = new Intent().setComponent((ComponentName) this.f11477b.get());
        component.putExtras(bundle);
        component.putExtra("target_fragment", ContentFragmentType.EVENTS_PERMALINK_FRAGMENT.ordinal());
        this.f11478c.a(component, context);
    }
}
