package com.facebook.maps.rows;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbStaticMapView;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: new_app_user_internal */
public class MapPartDefinition extends BaseSinglePartDefinition<Props, StaticMapOptions, AnyEnvironment, FbStaticMapView> {
    private static MapPartDefinition f7153b;
    private static final Object f7154c = new Object();
    public final Lazy<Resources> f7155a;

    /* compiled from: new_app_user_internal */
    public class Props {
        public final StaticMapOptions f13676a;
        public final boolean f13677b;
        public final int f13678c;
        public final int f13679d;

        public Props(StaticMapOptions staticMapOptions, boolean z, int i, int i2) {
            this.f13676a = staticMapOptions;
            this.f13677b = z;
            this.f13678c = i;
            this.f13679d = i2;
        }
    }

    private static MapPartDefinition m7477b(InjectorLike injectorLike) {
        return new MapPartDefinition(IdBasedSingletonScopeProvider.b(injectorLike, 30));
    }

    public final Object m7478a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return ((Props) obj).f13676a;
    }

    public final /* bridge */ /* synthetic */ void m7479a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -2117471729);
        Props props = (Props) obj;
        StaticMapOptions staticMapOptions = (StaticMapOptions) obj2;
        FbStaticMapView fbStaticMapView = (FbStaticMapView) view;
        LayoutParams layoutParams = fbStaticMapView.getLayoutParams();
        if (layoutParams == null) {
            fbStaticMapView.setLayoutParams(new LayoutParams(props.f13678c, props.f13679d));
        } else if (!(layoutParams.width == props.f13678c && layoutParams.height == props.f13679d)) {
            layoutParams.width = props.f13678c;
            layoutParams.height = props.f13679d;
            fbStaticMapView.setLayoutParams(layoutParams);
        }
        fbStaticMapView.setMapOptions(staticMapOptions);
        fbStaticMapView.setReportButtonVisibility(8);
        fbStaticMapView.setCenteredMapPinDrawable(props.f13677b ? ((Resources) this.f7155a.get()).getDrawable(2130841143) : null);
        fbStaticMapView.setVisibility(0);
        Logger.a(8, EntryType.MARK_POP, -426862138, a);
    }

    @Inject
    public MapPartDefinition(Lazy<Resources> lazy) {
        this.f7155a = lazy;
    }

    public static MapPartDefinition m7476a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MapPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7154c) {
                MapPartDefinition mapPartDefinition;
                if (a2 != null) {
                    mapPartDefinition = (MapPartDefinition) a2.a(f7154c);
                } else {
                    mapPartDefinition = f7153b;
                }
                if (mapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7477b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7154c, b3);
                        } else {
                            f7153b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = mapPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
