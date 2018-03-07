package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.SearchSpotlightCardUnit;
import com.facebook.search.typeahead.ui.HorizontalSearchSpotlightCardView;
import com.facebook.ultralight.Inject;

@ContextScoped
/* compiled from: video_channel_feed_ufi */
public class HScrollSearchSpotlightCardPagePartDefinition extends MultiRowSinglePartDefinition<SearchSpotlightCardUnit, Drawable, HasContext, HorizontalSearchSpotlightCardView> {
    public static ViewType<HorizontalSearchSpotlightCardView> f433a = new C00401();
    private static HScrollSearchSpotlightCardPagePartDefinition f434c;
    private static final Object f435d = new Object();
    private final GatekeeperStoreImpl f436b;

    /* compiled from: video_channel_feed_ufi */
    final class C00401 extends ViewType<HorizontalSearchSpotlightCardView> {
        C00401() {
        }

        public final View m537a(Context context) {
            return (HorizontalSearchSpotlightCardView) LayoutInflater.from(context).inflate(2130904794, null, false);
        }
    }

    private static HScrollSearchSpotlightCardPagePartDefinition m539b(InjectorLike injectorLike) {
        return new HScrollSearchSpotlightCardPagePartDefinition(GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return new ColorDrawable(((SearchSpotlightCardUnit) obj).b);
    }

    public final /* bridge */ /* synthetic */ void m542a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1584098083);
        SearchSpotlightCardUnit searchSpotlightCardUnit = (SearchSpotlightCardUnit) obj;
        HorizontalSearchSpotlightCardView horizontalSearchSpotlightCardView = (HorizontalSearchSpotlightCardView) view;
        horizontalSearchSpotlightCardView.setBackground((Drawable) obj2);
        horizontalSearchSpotlightCardView.setText(searchSpotlightCardUnit.a);
        Logger.a(8, EntryType.MARK_POP, 192116559, a);
    }

    @Inject
    private HScrollSearchSpotlightCardPagePartDefinition(GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f436b = gatekeeperStoreImpl;
    }

    public static HScrollSearchSpotlightCardPagePartDefinition m538a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollSearchSpotlightCardPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f435d) {
                HScrollSearchSpotlightCardPagePartDefinition hScrollSearchSpotlightCardPagePartDefinition;
                if (a2 != null) {
                    hScrollSearchSpotlightCardPagePartDefinition = (HScrollSearchSpotlightCardPagePartDefinition) a2.a(f435d);
                } else {
                    hScrollSearchSpotlightCardPagePartDefinition = f434c;
                }
                if (hScrollSearchSpotlightCardPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m539b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f435d, b3);
                        } else {
                            f434c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollSearchSpotlightCardPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<HorizontalSearchSpotlightCardView> m540a() {
        return f433a;
    }

    public final boolean m543a(Object obj) {
        return this.f436b.a(SearchAbTestGatekeepers.y, false);
    }
}
