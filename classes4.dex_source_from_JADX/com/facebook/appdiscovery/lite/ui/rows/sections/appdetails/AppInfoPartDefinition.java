package com.facebook.appdiscovery.lite.ui.rows.sections.appdetails;

import android.content.Context;
import android.view.View;
import com.facebook.appdiscovery.lite.analytics.LiteInstallLogger;
import com.facebook.appdiscovery.lite.common.util.AppInstallClickListenerFactory;
import com.facebook.appdiscovery.lite.common.util.AppInstallClickListenerFactoryProvider;
import com.facebook.appdiscovery.lite.model.unit.AppDetailsFeedUnit;
import com.facebook.appdiscovery.lite.ui.rows.sections.baseparts.ThumbnailClickListenerPartDefinition;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextOrHiddenPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import javax.inject.Inject;

@ContextScoped
/* compiled from: nux_eligibility_start */
public class AppInfoPartDefinition extends MultiRowSinglePartDefinition<AppDetailsFeedUnit, Void, AnyEnvironment, ImageBlockLayout> {
    public static final ViewType f6509a = ViewType.a(2130905060);
    private static AppInfoPartDefinition f6510g;
    private static final Object f6511h = new Object();
    private final ClickListenerPartDefinition f6512b;
    private final TextPartDefinition f6513c;
    private final ThumbnailClickListenerPartDefinition f6514d;
    private final TextOrHiddenPartDefinition f6515e;
    private final AppInstallClickListenerFactory f6516f;

    private static AppInfoPartDefinition m6928b(InjectorLike injectorLike) {
        return new AppInfoPartDefinition(ClickListenerPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), ThumbnailClickListenerPartDefinition.a(injectorLike), TextOrHiddenPartDefinition.a(injectorLike), (AppInstallClickListenerFactoryProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AppInstallClickListenerFactoryProvider.class), (Context) injectorLike.getInstance(Context.class), LiteInstallLogger.a(injectorLike));
    }

    public final Object m6930a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        AppDetailsFeedUnit appDetailsFeedUnit = (AppDetailsFeedUnit) obj;
        subParts.a(2131559622, this.f6512b, this.f6516f.a(appDetailsFeedUnit));
        subParts.a(2131559622, this.f6513c, appDetailsFeedUnit.f());
        subParts.a(this.f6514d, this.f6516f.a(appDetailsFeedUnit));
        TextPartDefinition textPartDefinition = this.f6513c;
        String str = null;
        if (!(appDetailsFeedUnit.c == null || StringUtil.a(appDetailsFeedUnit.c.b()))) {
            str = appDetailsFeedUnit.c.b();
        }
        subParts.a(2131563453, textPartDefinition, str);
        TextOrHiddenPartDefinition textOrHiddenPartDefinition = this.f6515e;
        Joiner on = Joiner.on(" · ");
        ImmutableList immutableList = null;
        if (!(appDetailsFeedUnit.c == null || appDetailsFeedUnit.c.kU_() == null || appDetailsFeedUnit.c.kU_().c() == null)) {
            immutableList = ImmutableList.copyOf(Iterables.c(appDetailsFeedUnit.c.kU_().c(), Predicates.notNull()));
        }
        subParts.a(2131563454, textOrHiddenPartDefinition, on.join(immutableList));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m6931a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        String str;
        int a = Logger.a(8, EntryType.MARK_PUSH, -1406675353);
        AppDetailsFeedUnit appDetailsFeedUnit = (AppDetailsFeedUnit) obj;
        ImageBlockLayout imageBlockLayout = (ImageBlockLayout) view;
        if (appDetailsFeedUnit.c == null || StringUtil.a(appDetailsFeedUnit.c.d())) {
            str = null;
        } else {
            str = appDetailsFeedUnit.c.d();
        }
        imageBlockLayout.setThumbnailUri(str);
        Logger.a(8, EntryType.MARK_POP, -1281813149, a);
    }

    public final boolean m6932a(Object obj) {
        return ((AppDetailsFeedUnit) obj).f() != null;
    }

    @Inject
    public AppInfoPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, TextPartDefinition textPartDefinition, ThumbnailClickListenerPartDefinition thumbnailClickListenerPartDefinition, TextOrHiddenPartDefinition textOrHiddenPartDefinition, AppInstallClickListenerFactoryProvider appInstallClickListenerFactoryProvider, Context context, LiteInstallLogger liteInstallLogger) {
        this.f6512b = clickListenerPartDefinition;
        this.f6513c = textPartDefinition;
        this.f6516f = appInstallClickListenerFactoryProvider.a(context, liteInstallLogger);
        this.f6514d = thumbnailClickListenerPartDefinition;
        this.f6515e = textOrHiddenPartDefinition;
    }

    public static AppInfoPartDefinition m6927a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AppInfoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f6511h) {
                AppInfoPartDefinition appInfoPartDefinition;
                if (a2 != null) {
                    appInfoPartDefinition = (AppInfoPartDefinition) a2.a(f6511h);
                } else {
                    appInfoPartDefinition = f6510g;
                }
                if (appInfoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m6928b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f6511h, b3);
                        } else {
                            f6510g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = appInfoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m6929a() {
        return f6509a;
    }
}
