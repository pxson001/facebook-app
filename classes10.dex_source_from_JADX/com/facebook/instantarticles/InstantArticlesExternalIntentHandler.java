package com.facebook.instantarticles;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ExternalIntentHandler;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.Lazy;
import com.facebook.instantarticles.logging.InstantArticlesSequences;
import com.facebook.qe.api.QeAccessor;
import com.facebook.richdocument.abtest.ExperimentsForRichDocumentAbtestModule;
import com.facebook.richdocument.logging.RichDocumentLongClickTracker;
import com.facebook.richdocument.logging.RichDocumentSessionTracker;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.si.LinkshimExternalIntentHandler;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: view_link */
public class InstantArticlesExternalIntentHandler implements ExternalIntentHandler {
    private final SequenceLogger f474a;
    private final MonotonicClock f475b;
    private final RichDocumentLongClickTracker f476c;
    public final RichDocumentUriIntentBuilder f477d;
    public final Lazy<QeAccessor> f478e;
    private final LinkshimExternalIntentHandler f479f;
    public final Lazy<GatekeeperStore> f480g;
    private long f481h = 0;

    @Inject
    public InstantArticlesExternalIntentHandler(SequenceLogger sequenceLogger, MonotonicClock monotonicClock, RichDocumentLongClickTracker richDocumentLongClickTracker, RichDocumentUriIntentBuilder richDocumentUriIntentBuilder, Lazy<QeAccessor> lazy, LinkshimExternalIntentHandler linkshimExternalIntentHandler, Lazy<GatekeeperStore> lazy2) {
        this.f474a = sequenceLogger;
        this.f475b = monotonicClock;
        this.f476c = richDocumentLongClickTracker;
        this.f477d = richDocumentUriIntentBuilder;
        this.f478e = lazy;
        this.f479f = linkshimExternalIntentHandler;
        this.f480g = lazy2;
    }

    public final boolean m583a(Intent intent, Context context) {
        return m580c(intent, context);
    }

    public final boolean m581a(Intent intent, int i, Activity activity) {
        return m580c(intent, activity);
    }

    public final boolean m582a(Intent intent, int i, Fragment fragment) {
        return m580c(intent, fragment.getContext());
    }

    private boolean m580c(@Nullable Intent intent, Context context) {
        Object obj;
        if (intent == null || context == null) {
            obj = null;
        } else {
            CharSequence a = m579a(intent);
            if (StringUtil.c(a) && !StringUtil.c(intent.getDataString())) {
                a = m579a(this.f477d.a(context, intent.getDataString()));
            }
            obj = !StringUtil.a(a) ? 1 : null;
        }
        if (obj != null) {
            TracerDetour.a("RichDocumentIntentHandler#launchInstantArticle", -1386560367);
            if (this.f475b.now() - this.f481h < 1500) {
                return true;
            }
            Intent a2;
            intent.putExtra("external_click_time", this.f475b.now());
            this.f481h = this.f475b.now();
            this.f474a.a(InstantArticlesSequences.f482a);
            TracerDetour.a(-886231804);
            FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(context, FragmentManagerHost.class);
            if (fragmentManagerHost != null && fragmentManagerHost.kO_().c()) {
                boolean z;
                if (((GatekeeperStoreImpl) this.f480g.get()).a(686, false)) {
                    z = true;
                } else {
                    z = ((QeAccessor) this.f478e.get()).a(ExperimentsForRichDocumentAbtestModule.k, false);
                }
                if (z) {
                    Bundle bundle;
                    this.f479f.a(intent);
                    InstantArticlesFragment instantArticlesFragment = new InstantArticlesFragment();
                    if (StringUtil.c(m579a(intent)) && !StringUtil.c(intent.getDataString())) {
                        a2 = this.f477d.a(context, intent.getDataString());
                        if (StringUtil.c(m579a(a2))) {
                            bundle = null;
                        } else {
                            bundle = a2.getExtras();
                            bundle.putString("extra_instant_articles_click_url", bundle.getString("extra_instant_articles_canonical_url"));
                            Bundle extras = intent.getExtras();
                            if (extras != null) {
                                bundle.putAll(extras);
                            }
                        }
                    } else if (StringUtil.c(intent.getDataString())) {
                        bundle = intent.getExtras();
                        bundle.putString("extra_instant_articles_click_url", intent.getExtras().getString("extra_instant_articles_canonical_url"));
                    } else {
                        bundle = intent.getExtras();
                        bundle.putString("extra_instant_articles_click_url", intent.getDataString());
                    }
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        String uuid = SafeUUIDGenerator.a().toString();
                        bundle2.putString("richdocument_fragment_tag", uuid);
                        instantArticlesFragment.g(bundle2);
                        instantArticlesFragment.a(fragmentManagerHost.kO_(), uuid);
                        fragmentManagerHost.kO_().b();
                        return true;
                    }
                }
            }
            intent.setComponent(new ComponentName(context, InstantArticlesActivity.class));
            if (!(context instanceof InstantArticlesActivity)) {
                RichDocumentSessionTracker richDocumentSessionTracker = this.f476c.d;
                richDocumentSessionTracker.a = SafeUUIDGenerator.a().toString();
                richDocumentSessionTracker.b = 0.0d;
            }
            if (!(intent == null || context == null || StringUtil.c(intent.getDataString()))) {
                a2 = this.f477d.a(context, intent.getDataString());
                if (a2 != null) {
                    Object stringExtra = a2.getStringExtra("extra_instant_articles_canonical_url");
                    if (!StringUtil.c(stringExtra)) {
                        intent.putExtras(a2.getExtras());
                        intent.setData(Uri.parse(stringExtra));
                    }
                }
            }
        }
        return false;
    }

    public static String m579a(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("extra_instant_articles_id");
    }
}
