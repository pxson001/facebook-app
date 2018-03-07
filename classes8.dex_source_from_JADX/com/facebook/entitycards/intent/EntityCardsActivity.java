package com.facebook.entitycards.intent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.facebook.analytics.tagging.AnalyticsActivityWithExtraData;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.FbRootViewUtil;
import com.facebook.base.fragment.FragmentManagerHost.Util;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.entitycards.analytics.EntityCardsAnalytics.DismissalReason;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger;
import com.facebook.entitycards.analytics.EntityCardsInitialCardsSequenceLogger.Span;
import com.facebook.entitycardsplugins.person.PersonCardActivityResultHandler;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: image_portrait_height */
public class EntityCardsActivity extends FbFragmentActivity implements AnalyticsActivityWithExtraData {
    @Inject
    public EntityCardsFragmentFactory f10959p;
    @Inject
    public EntityCardsIntentReader f10960q;
    @Inject
    public EntityCardsInitialCardsSequenceLogger f10961r;
    @Inject
    public AbstractFbErrorReporter f10962s;

    private static <T extends Context> void m12893a(Class<T> cls, T t) {
        m12894a((Object) t, (Context) t);
    }

    public static void m12894a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        EntityCardsActivity entityCardsActivity = (EntityCardsActivity) obj;
        EntityCardsFragmentFactory a = EntityCardsFragmentFactory.m12920a(injectorLike);
        EntityCardsIntentReader a2 = EntityCardsIntentReader.m12924a(injectorLike);
        EntityCardsInitialCardsSequenceLogger a3 = EntityCardsInitialCardsSequenceLogger.m12807a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        entityCardsActivity.f10959p = a;
        entityCardsActivity.f10960q = a2;
        entityCardsActivity.f10961r = a3;
        entityCardsActivity.f10962s = abstractFbErrorReporter;
    }

    public final void m12896b(Bundle bundle) {
        super.b(bundle);
        Class cls = EntityCardsActivity.class;
        m12894a((Object) this, (Context) this);
        Intent intent = getIntent();
        m12895i();
        if (bundle == null) {
            EntityCardsIntentReader.m12925a(intent.getExtras());
            this.f10961r.m12817a(Span.ACTIVITY_CREATE);
            FragmentTransaction a = Util.a(this).kO_().a();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(intent.getExtras());
            EntityCardsFragment entityCardsFragment = new EntityCardsFragment();
            entityCardsFragment.g(bundle2);
            a.b(FbRootViewUtil.b(this), entityCardsFragment, "chromeless:content:fragment:tag");
            a.a(null);
            a.b();
        }
    }

    private void m12895i() {
        try {
            requestWindowFeature(1);
        } catch (Throwable e) {
            this.f10962s.a("entity_cards_remove_title_bar", e);
        }
    }

    protected void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1508811200);
        super.onResume();
        this.f10961r.m12819b(Span.ACTIVITY_CREATE);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -292230104, a);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        if (this.f10959p != null) {
            EntityCardsFragment entityCardsFragment = (EntityCardsFragment) Util.a(this).kO_().a("chromeless:content:fragment:tag");
            if (entityCardsFragment != null) {
                entityCardsFragment.m12915a(true, DismissalReason.BACK_BUTTON_TAP);
                return;
            }
        }
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.f10960q != null) {
            PersonCardActivityResultHandler personCardActivityResultHandler = (PersonCardActivityResultHandler) this.f10960q.m12932a(EntityCardsIntentReader.m12925a(getIntent().getExtras()).f11005a).f11251f.get();
            switch (i) {
                case 1756:
                    if (i2 == -1) {
                        ((ComposerPublishServiceHelper) personCardActivityResultHandler.f11132a.get()).c(intent);
                        break;
                    }
                    break;
            }
        }
    }

    public final String am_() {
        return "entity_cards";
    }

    public final Map<String, Object> m12897c() {
        String c = EntityCardsIntentReader.m12929c(getIntent().getExtras(), null);
        Map hashMap = new HashMap();
        hashMap.put("profile_id", c);
        return hashMap;
    }
}
