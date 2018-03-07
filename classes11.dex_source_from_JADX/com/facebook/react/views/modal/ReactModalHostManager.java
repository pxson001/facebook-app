package com.facebook.react.views.modal;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.modal.ReactModalHostView.OnRequestCloseListener;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: Running in prod - should this be happening? */
public class ReactModalHostManager extends ViewGroupManager<ReactModalHostView> {
    private final ReactApplicationContext f11473a;

    public final void m11883a(View view) {
        ReactModalHostView reactModalHostView = (ReactModalHostView) view;
        super.a(reactModalHostView);
        reactModalHostView.m11896a();
    }

    protected final void m11884a(ThemedReactContext themedReactContext, View view) {
        final ReactModalHostView reactModalHostView = (ReactModalHostView) view;
        final EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.b(UIManagerModule.class)).a;
        reactModalHostView.f11482g = new OnRequestCloseListener(this) {
            final /* synthetic */ ReactModalHostManager f11469c;

            public final void mo307a() {
                eventDispatcher.a(new RequestCloseEvent(reactModalHostView.getId(), SystemClock.b()));
            }
        };
        reactModalHostView.f11481f = new OnShowListener(this) {
            final /* synthetic */ ReactModalHostManager f11472c;

            public void onShow(DialogInterface dialogInterface) {
                eventDispatcher.a(new ShowEvent(reactModalHostView.getId(), SystemClock.b()));
            }
        };
    }

    protected final void m11886b(View view) {
        ReactModalHostView reactModalHostView = (ReactModalHostView) view;
        super.b(reactModalHostView);
        reactModalHostView.m11897c();
    }

    public final /* synthetic */ ReactShadowNode m11887c() {
        return d();
    }

    public ReactModalHostManager(ReactApplicationContext reactApplicationContext) {
        this.f11473a = reactApplicationContext;
    }

    public final String m11882a() {
        return "RCTModalHostView";
    }

    protected final View m11881a(ThemedReactContext themedReactContext) {
        return new ReactModalHostView(themedReactContext);
    }

    public final LayoutShadowNode m11888d() {
        return new ModalHostShadowNode();
    }

    public final Class<? extends LayoutShadowNode> m11885b() {
        return ModalHostShadowNode.class;
    }

    @ReactProp(name = "animationType")
    public void setAnimationType(ReactModalHostView reactModalHostView, String str) {
        reactModalHostView.setAnimationType(str);
    }

    public final Map<String, Object> m11889h() {
        return MapBuilder.b().a("topRequestClose", MapBuilder.a("registrationName", "onRequestClose")).a("topShow", MapBuilder.a("registrationName", "onShow")).a();
    }

    @Nullable
    public final Map<String, Object> m11890i() {
        int identifier = this.f11473a.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return MapBuilder.a("StatusBarHeight", Float.valueOf(identifier > 0 ? PixelUtil.c((float) this.f11473a.getResources().getDimensionPixelSize(identifier)) : 0.0f));
    }

    @ReactProp(name = "transparent")
    public void setTransparent(ReactModalHostView reactModalHostView, boolean z) {
        reactModalHostView.f11478c = z;
    }
}
