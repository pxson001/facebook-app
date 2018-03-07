package com.facebook.events.uri;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.events.activity.EventCreationActivity;
import com.facebook.events.common.EventActionContext;
import com.facebook.events.create.EventCreationNikumanActivity;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.base.Strings;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
@UriMapPattern
/* compiled from: api_key */
public class EventsUriIntentBuilder extends UriIntentBuilder {
    private static volatile EventsUriIntentBuilder f19631a;

    /* compiled from: api_key */
    class EventCreatePrefillUriIntentBuilder implements IUriTemplateIntentBuilder {
        public final Intent m19912a(Context context, Bundle bundle) {
            String str = null;
            Intent intent = new Intent(context, EventCreationNikumanActivity.class);
            if (bundle.containsKey("events_creation_prefill_extras")) {
                String string = bundle.getString("events_creation_prefill_extras");
                if (!Strings.isNullOrEmpty(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(Uri.decode(string));
                        String string2 = jSONObject.has("title") ? jSONObject.getString("title") : null;
                        long j = jSONObject.has("start_time") ? jSONObject.getLong("start_time") : -1;
                        if (jSONObject.has("theme_id")) {
                            str = jSONObject.getString("theme_id");
                        }
                        if (!Strings.isNullOrEmpty(string2)) {
                            intent.putExtra("events_creation_prefill_title", string2);
                        }
                        if (j >= 0) {
                            intent.putExtra("events_creation_prefill_start_time", j);
                        }
                        if (!Strings.isNullOrEmpty(str)) {
                            intent.putExtra("events_creation_prefill_theme_id", str);
                        }
                    } catch (JSONException e) {
                    }
                }
            }
            return intent;
        }
    }

    public static com.facebook.events.uri.EventsUriIntentBuilder m19913a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f19631a;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.uri.EventsUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f19631a;	 Catch:{ all -> 0x003a }
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
        r0 = m19914b(r0);	 Catch:{ all -> 0x0035 }
        f19631a = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19631a;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.uri.EventsUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.events.uri.EventsUriIntentBuilder");
    }

    private static EventsUriIntentBuilder m19914b(InjectorLike injectorLike) {
        return new EventsUriIntentBuilder(IdBasedProvider.a(injectorLike, 3964), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public EventsUriIntentBuilder(Provider<Boolean> provider, QeAccessor qeAccessor) {
        Bundle bundle = new Bundle();
        bundle.putString("target_tab_name", TabTag.Bookmark.name());
        a(FBLinks.by, qeAccessor.a(Liveness.Live, ExperimentsForEventsGatingModule.N, false) ? ReactFragmentActivity.class : FragmentChromeActivity.class, ContentFragmentType.EVENTS_DASHBOARD_FRAGMENT.ordinal(), bundle);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bA, "section_name"), FragmentChromeActivity.class, ContentFragmentType.EVENTS_DASHBOARD_FRAGMENT.ordinal(), bundle);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bF, "{events_creation_prefill_extras}"), new EventCreatePrefillUriIntentBuilder());
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bE, "{events_creation_story_cache_id}"), EventCreationNikumanActivity.class);
        a(FBLinks.bD, EventCreationNikumanActivity.class);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bH, "com.facebook.katana.profile.id"), ((Boolean) provider.get()).booleanValue() ? EventCreationNikumanActivity.class : EventCreationActivity.class);
        a(FBLinks.bI, FragmentChromeActivity.class, ContentFragmentType.EVENTS_DISCOVERY_FRAGMENT.ordinal());
        bundle.putParcelable("extras_event_action_context", EventActionContext.b);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.bJ, "events_suggestions_cut_type"), FragmentChromeActivity.class, ContentFragmentType.EVENTS_SUGGESTIONS_FRAGMENT.ordinal(), bundle);
    }
}
