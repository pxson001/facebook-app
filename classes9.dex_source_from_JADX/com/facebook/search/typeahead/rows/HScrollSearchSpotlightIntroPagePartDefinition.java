package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.SearchSpotlightIntroUnit;
import com.facebook.search.typeahead.ui.HorizontalSearchSpotlightIntroView;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: video_attachment_type */
public class HScrollSearchSpotlightIntroPagePartDefinition extends MultiRowSinglePartDefinition<SearchSpotlightIntroUnit, Void, HasContext, HorizontalSearchSpotlightIntroView> {
    public static ViewType<HorizontalSearchSpotlightIntroView> f437a = new C00411();
    private static HScrollSearchSpotlightIntroPagePartDefinition f438c;
    private static final Object f439d = new Object();
    private final GatekeeperStoreImpl f440b;

    /* compiled from: video_attachment_type */
    final class C00411 extends ViewType<HorizontalSearchSpotlightIntroView> {
        C00411() {
        }

        public final View m544a(Context context) {
            return (HorizontalSearchSpotlightIntroView) LayoutInflater.from(context).inflate(2130904796, null, false);
        }
    }

    private static HScrollSearchSpotlightIntroPagePartDefinition m546b(InjectorLike injectorLike) {
        return new HScrollSearchSpotlightIntroPagePartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m548a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1983255184);
        ((HorizontalSearchSpotlightIntroView) view).setText(((SearchSpotlightIntroUnit) obj).a);
        Logger.a(8, EntryType.MARK_POP, 1207594123, a);
    }

    @Inject
    private HScrollSearchSpotlightIntroPagePartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f440b = gatekeeperStoreImpl;
    }

    public final boolean m549a(Object obj) {
        return this.f440b.a(SearchAbTestGatekeepers.y, false);
    }

    public final ViewType<HorizontalSearchSpotlightIntroView> m547a() {
        return f437a;
    }

    public static HScrollSearchSpotlightIntroPagePartDefinition m545a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollSearchSpotlightIntroPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f439d) {
                HScrollSearchSpotlightIntroPagePartDefinition hScrollSearchSpotlightIntroPagePartDefinition;
                if (a2 != null) {
                    hScrollSearchSpotlightIntroPagePartDefinition = (HScrollSearchSpotlightIntroPagePartDefinition) a2.a(f439d);
                } else {
                    hScrollSearchSpotlightIntroPagePartDefinition = f438c;
                }
                if (hScrollSearchSpotlightIntroPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m546b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f439d, b3);
                        } else {
                            f438c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollSearchSpotlightIntroPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
