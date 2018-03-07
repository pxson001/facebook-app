package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.LatLngBounds;
import com.facebook.android.maps.model.LatLngBounds.Builder;
import com.facebook.android.maps.model.MarkerOptions;
import com.facebook.common.util.CollectionUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultLocationFields;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.FbMapViewDelegate;
import com.facebook.maps.delegate.CameraUpdateDelegate;
import com.facebook.maps.delegate.CameraUpdateFactoryDelegate;
import com.facebook.maps.delegate.MapDelegate;
import com.facebook.maps.delegate.MapDelegate.OnMapClickListener;
import com.facebook.maps.delegate.MapViewDelegate;
import com.facebook.maps.delegate.OnMapReadyDelegateCallback;
import com.facebook.richdocument.event.RichDocumentEventBus;
import com.facebook.richdocument.event.RichDocumentEventSubscribers.RichDocumentFragmentLifeCycleSubscriber;
import com.facebook.richdocument.event.RichDocumentEvents.RichDocumentFragmentLifeCycleEvent;
import com.facebook.richdocument.model.block.LocationAnnotation;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentLocationAnnotation;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentLocationAnnotationModel;
import com.facebook.richdocument.view.transition.AbstractTransitionStrategy;
import com.facebook.richdocument.view.transition.MapState;
import com.facebook.richdocument.view.transition.MediaTransitionState;
import com.facebook.richdocument.view.transition.MediaTransitionState.PresentationMode;
import com.facebook.richdocument.view.transition.ViewAttributes;
import com.facebook.richdocument.view.transition.ViewLayout;
import com.facebook.richdocument.view.transition.ViewRect;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.AnnotationView;
import com.facebook.richdocument.view.widget.LocationAnnotationView;
import com.facebook.richdocument.view.widget.MediaStaticMap;
import com.facebook.richdocument.view.widget.TextAnnotationView;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

/* compiled from: num_cards_opened */
public class MapUnderlayPlugin extends BaseMediaFramePlugin<MapState> {
    private static final SpringConfig f7655c = SpringConfig.a(280.0d, 34.0d);
    @Inject
    public RichDocumentEventBus f7656a;
    @Inject
    public SpringSystem f7657b;
    private final Spring f7658d;
    public Bundle f7659e;
    private int f7660f = 1;
    public List<? extends RichDocumentLocationAnnotation> f7661g;
    public final View f7662h;
    public boolean f7663i = true;
    public MediaStaticMap f7664j;
    public SoftReference<FbMapViewDelegate> f7665k;
    private MediaTransitionState f7666l;
    public float f7667m = 0.0f;
    public MapState f7668n;
    private final RichDocumentFragmentLifeCycleSubscriber f7669o = new C08771(this);

    /* compiled from: num_cards_opened */
    class C08771 extends RichDocumentFragmentLifeCycleSubscriber {
        final /* synthetic */ MapUnderlayPlugin f7647a;

        C08771(MapUnderlayPlugin mapUnderlayPlugin) {
            this.f7647a = mapUnderlayPlugin;
        }

        public final void m7925b(FbEvent fbEvent) {
            RichDocumentFragmentLifeCycleEvent richDocumentFragmentLifeCycleEvent = (RichDocumentFragmentLifeCycleEvent) fbEvent;
            if (MapUnderlayPlugin.m7937u(this.f7647a)) {
                MapViewDelegate t = MapUnderlayPlugin.m7936t(this.f7647a);
                switch (richDocumentFragmentLifeCycleEvent.f5175a) {
                    case ON_CREATE:
                        t.a(this.f7647a.f7659e);
                        return;
                    case ON_RESUME:
                        t.d();
                        return;
                    case ON_PAUSE:
                        t.c();
                        return;
                    case ON_DESTROY:
                        t.a();
                        return;
                    case ON_SAVE_INSTANCE_STATE:
                        t.a(this.f7647a.f7659e);
                        return;
                    case ON_LOW_MEMORY:
                        t.b();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* compiled from: num_cards_opened */
    class C08782 extends SimpleSpringListener {
        final /* synthetic */ MapUnderlayPlugin f7648a;

        C08782(MapUnderlayPlugin mapUnderlayPlugin) {
            this.f7648a = mapUnderlayPlugin;
        }

        public final void m7926a(Spring spring) {
            super.a(spring);
            this.f7648a.f7667m = (float) spring.d();
            BaseMediaFramePlugin baseMediaFramePlugin = this.f7648a;
            ViewLayout currentLayout = this.f7648a.f7617a.getCurrentLayout();
            if (currentLayout != null) {
                ViewRect a = BaseMediaFramePlugin.m7881a(currentLayout, baseMediaFramePlugin.m7893g());
                ViewRect a2 = BaseMediaFramePlugin.m7881a(currentLayout, baseMediaFramePlugin.m7895i());
                int e = a.m7328e() / 2;
                int f = a2.m7329f() / 2;
                a2.mo413a(new ViewRect(e, f, e, f), baseMediaFramePlugin.f7667m);
            }
            this.f7648a.m7893g().requestLayout();
            this.f7648a.f7617a.getMediaView().getView().requestLayout();
        }

        public final void m7927b(Spring spring) {
            super.b(spring);
            this.f7648a.f7667m = (float) spring.d();
            if (this.f7648a.f7667m == 0.0f) {
                if (MapUnderlayPlugin.m7935s(this.f7648a) && MapUnderlayPlugin.m7938v(this.f7648a)) {
                    this.f7648a.f7664j.setVisibility(8);
                }
                if (MapUnderlayPlugin.m7937u(this.f7648a)) {
                    MapUnderlayPlugin.m7933k(this.f7648a);
                }
            }
        }
    }

    /* compiled from: num_cards_opened */
    class C08793 implements OnClickListener {
        final /* synthetic */ MapUnderlayPlugin f7649a;

        C08793(MapUnderlayPlugin mapUnderlayPlugin) {
            this.f7649a = mapUnderlayPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1359355197);
            this.f7649a.mo447a(Event.CLICK_MAP);
            Logger.a(2, EntryType.UI_INPUT_END, 726359978, a);
        }
    }

    public static void m7932a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        MapUnderlayPlugin mapUnderlayPlugin = (MapUnderlayPlugin) obj;
        RichDocumentEventBus a = RichDocumentEventBus.m5130a(fbInjector);
        SpringSystem b = SpringSystem.b(fbInjector);
        mapUnderlayPlugin.f7656a = a;
        mapUnderlayPlugin.f7657b = b;
    }

    public MapUnderlayPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = MapUnderlayPlugin.class;
        m7932a((Object) this, getContext());
        Spring c = this.f7657b.a().a(f7655c).c(1250.0d);
        c.c = true;
        this.f7658d = c.l();
        this.f7658d.a(new C08782(this));
        this.f7662h = new View(getContext());
    }

    public final boolean mo507b() {
        return CollectionUtil.b(this.f7661g);
    }

    public final void m7939a(int i, List<? extends RichDocumentLocationAnnotation> list) {
        this.f7660f = i;
        this.f7661g = list;
    }

    public final void mo508c() {
        if (m7935s(this)) {
            m7893g().removeView(this.f7664j);
            this.f7664j = null;
        }
        m7933k(this);
        this.f7660f = 1;
        this.f7661g = null;
        this.f7666l = null;
        this.f7667m = 0.0f;
        this.f7668n = MapState.HIDDEN;
    }

    public static void m7933k(MapUnderlayPlugin mapUnderlayPlugin) {
        if (m7937u(mapUnderlayPlugin)) {
            MapViewDelegate t = m7936t(mapUnderlayPlugin);
            mapUnderlayPlugin.m7893g().removeView(t);
            t.c();
            t.a();
            mapUnderlayPlugin.f7665k.clear();
            mapUnderlayPlugin.f7665k = null;
        }
    }

    public final void mo509d() {
        this.f7656a.a(this.f7669o);
        AbstractTransitionStrategy transitionStrategy = this.f7617a.getTransitionStrategy();
        transitionStrategy.m7200a(null);
        ViewLayout a = transitionStrategy.m7196a(MediaTransitionState.f6977a, false);
        if (a != null) {
            ViewRect a2 = BaseMediaFramePlugin.m7881a(a, m7895i());
            ViewAttributes viewAttributes = new ViewAttributes();
            viewAttributes.m7297a(a2.mo414c());
            a.mo431a(this.f7662h, viewAttributes);
        }
        a = transitionStrategy.m7196a(MediaTransitionState.f6978b, false);
        if (a != null) {
            ViewAttributes viewAttributes2 = new ViewAttributes();
            viewAttributes2.m7297a(new ViewRect(transitionStrategy.f6972b));
            a.mo431a(this.f7662h, viewAttributes2);
        }
        if (!m7938v(this)) {
            m7934p();
        }
    }

    public final void mo510e() {
        this.f7656a.b(this.f7669o);
    }

    private void m7931a(MapState mapState) {
        if (mapState == MapState.VISIBLE) {
            if (m7896j().f6981e != PresentationMode.EXPANDED) {
                m7934p();
            } else if (this.f7663i) {
                if (m7937u(this)) {
                    MapViewDelegate t = m7936t(this);
                    if (t.getVisibility() != 0) {
                        t.setVisibility(0);
                    }
                } else {
                    CameraUpdateDelegate cameraUpdateDelegate;
                    ViewGroup g = m7893g();
                    final FbMapViewDelegate fbMapViewDelegate = (FbMapViewDelegate) LayoutInflater.from(g.getContext()).inflate(2130906873, g, false);
                    fbMapViewDelegate.setVisibility(0);
                    fbMapViewDelegate.a(this.f7659e);
                    g.addView(fbMapViewDelegate, (m7935s(this) ? g.indexOfChild(this.f7664j) : -1) + 1);
                    if (!this.f7659e.isEmpty()) {
                        cameraUpdateDelegate = null;
                    } else if (this.f7661g.size() == 1) {
                        cameraUpdateDelegate = CameraUpdateFactoryDelegate.a(new LatLng(((RichDocumentLocationAnnotationModel) this.f7661g.get(0)).m6028a().a(), ((RichDocumentLocationAnnotationModel) this.f7661g.get(0)).m6028a().b()), 8.0f);
                    } else {
                        cameraUpdateDelegate = CameraUpdateFactoryDelegate.a(m7930a(this.f7661g), 0);
                    }
                    this.f7665k = new SoftReference(fbMapViewDelegate);
                    fbMapViewDelegate.a(new OnMapReadyDelegateCallback(this) {
                        final /* synthetic */ MapUnderlayPlugin f7653c;

                        /* compiled from: num_cards_opened */
                        class C08801 implements OnMapClickListener {
                            final /* synthetic */ C08814 f7650a;

                            C08801(C08814 c08814) {
                                this.f7650a = c08814;
                            }

                            public final void m7928a() {
                                this.f7650a.f7653c.mo447a(Event.CLICK_MAP);
                            }
                        }

                        public final void m7929a(MapDelegate mapDelegate) {
                            if (this.f7653c.f7665k == null || fbMapViewDelegate == this.f7653c.f7665k.get()) {
                                if (cameraUpdateDelegate != null) {
                                    mapDelegate.a(cameraUpdateDelegate);
                                }
                                for (RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel : this.f7653c.f7661g) {
                                    MarkerOptions markerOptions = new MarkerOptions();
                                    markerOptions.b = new LatLng(richDocumentLocationAnnotationModel.m6028a().a(), richDocumentLocationAnnotationModel.m6028a().b());
                                    markerOptions = markerOptions;
                                    markerOptions.i = richDocumentLocationAnnotationModel.m6032c();
                                    mapDelegate.a(markerOptions);
                                }
                                mapDelegate.a(new C08801(this));
                            }
                        }
                    });
                }
            }
            this.f7666l = ((MediaTransitionState) this.f7617a.getCurrentLayout().mo427a()).m7272e();
        }
        this.f7668n = mapState;
        this.f7658d.a((double) this.f7667m);
        this.f7658d.b((double) this.f7668n.getVisibility());
        m7886a((Object) mapState);
    }

    public final void mo503a(MediaTransitionState mediaTransitionState) {
        if (m7938v(this) && mediaTransitionState == MediaTransitionState.f6977a) {
            TextAnnotationView textAnnotationView;
            MapState mapState = MapState.HIDDEN;
            Iterator it = this.f7617a.getAnnotationViews().iterator();
            while (it.hasNext()) {
                AnnotationView annotationView = (AnnotationView) it.next();
                if (annotationView instanceof LocationAnnotationView) {
                    textAnnotationView = (LocationAnnotationView) annotationView;
                    break;
                }
            }
            textAnnotationView = null;
            TextAnnotationView textAnnotationView2 = textAnnotationView;
            if (textAnnotationView2 == null) {
                return;
            }
            if (mapState == MapState.VISIBLE) {
                textAnnotationView2.setText(2131237720);
                textAnnotationView2.m7402a(getContext().getResources().getDrawable(2130843052), 2131558709, 2131558710);
                return;
            }
            textAnnotationView2.setText(((LocationAnnotation) textAnnotationView2.getAnnotation()).f5609b);
            textAnnotationView2.m7402a(getContext().getResources().getDrawable(2130843053), 2131558711, 2131558712);
        }
    }

    public final void mo506b(ViewLayout viewLayout) {
        Object obj;
        MediaTransitionState mediaTransitionState = (MediaTransitionState) viewLayout.mo427a();
        if (mediaTransitionState.f6981e == PresentationMode.COLLAPSED) {
            Object obj2;
            if (mediaTransitionState.f6983g < 1.0f) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                obj = 1;
                if (obj != null && m7938v(this)) {
                    MapState mapState;
                    if (this.f7667m > 0.0f) {
                        mapState = MapState.VISIBLE;
                    } else {
                        mapState = MapState.HIDDEN;
                    }
                    if (mapState == MapState.VISIBLE && this.f7668n != MapState.HIDDEN) {
                        m7931a(MapState.HIDDEN);
                        return;
                    }
                    return;
                }
            }
        }
        obj = null;
        if (obj != null) {
        }
    }

    public final void mo504a(ViewLayout viewLayout) {
        if (m7935s(this) || m7937u(this)) {
            LayoutParams layoutParams;
            MediaFrame mediaFrame = this.f7617a;
            Rect rect = BaseMediaFramePlugin.m7881a(viewLayout, this.f7662h).f7004a;
            if (m7935s(this) && this.f7664j.getVisibility() == 0 && this.f7664j.getParent() != null) {
                layoutParams = (LayoutParams) this.f7664j.getLayoutParams();
                layoutParams.height = rect.height();
                this.f7664j.setLayoutParams(layoutParams);
                mediaFrame.m7802a(this.f7664j, rect);
            }
            if (m7937u(this) && this.f7663i) {
                MapViewDelegate t = m7936t(this);
                if (!(t == null || t.getVisibility() != 0 || t.getParent() == null)) {
                    layoutParams = (LayoutParams) t.getLayoutParams();
                    layoutParams.height = rect.height();
                    t.setLayoutParams(layoutParams);
                    mediaFrame.m7802a(t, rect);
                }
            }
            Iterator it = mediaFrame.getAnnotationViews().iterator();
            while (it.hasNext()) {
                AnnotationView annotationView = (AnnotationView) it.next();
                Rect a = mediaFrame.mo471a(annotationView.mo438b());
                annotationView.setIsOverlay(rect.contains(a.centerX(), a.centerY()));
            }
        }
    }

    public final boolean mo447a(Event event) {
        if (event == Event.CLICK_MAP) {
            return true;
        }
        return false;
    }

    private void m7934p() {
        if (!m7935s(this)) {
            ViewGroup body = this.f7617a.getBody();
            this.f7664j = (MediaStaticMap) LayoutInflater.from(body.getContext()).inflate(2130906877, body, false);
            this.f7664j.f7229d = this.f7662h;
            this.f7664j.setVisibility(0);
            this.f7664j.setOnClickListener(new C08793(this));
            body.addView(this.f7664j, 0);
            StaticMapOptions staticMapOptions = new StaticMapOptions("rich_document_map_block");
            if (this.f7661g.size() == 1) {
                staticMapOptions.a(((RichDocumentLocationAnnotationModel) this.f7661g.get(0)).m6028a().a(), ((RichDocumentLocationAnnotationModel) this.f7661g.get(0)).m6028a().b());
                staticMapOptions.a(8);
            } else {
                LatLngBounds a = m7930a(this.f7661g);
                staticMapOptions.a(new RectF((float) a.c.b, (float) a.b.a, (float) a.b.b, (float) a.c.a));
            }
            List arrayList = new ArrayList();
            for (RichDocumentLocationAnnotationModel richDocumentLocationAnnotationModel : this.f7661g) {
                arrayList.add(new LatLng(richDocumentLocationAnnotationModel.m6028a().a(), richDocumentLocationAnnotationModel.m6028a().b()));
            }
            staticMapOptions.a(arrayList, "red");
            this.f7664j.setMapOptions(staticMapOptions);
        } else if (this.f7664j.getVisibility() != 0) {
            this.f7664j.setVisibility(0);
        }
    }

    public static LatLngBounds m7930a(List<? extends RichDocumentLocationAnnotation> list) {
        Builder builder = new Builder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DefaultLocationFields a = ((RichDocumentLocationAnnotationModel) it.next()).m6028a();
            builder.a(new LatLng(a.a(), a.b()));
        }
        return builder.a();
    }

    public static boolean m7935s(MapUnderlayPlugin mapUnderlayPlugin) {
        return mapUnderlayPlugin.f7664j != null;
    }

    public static MapViewDelegate m7936t(MapUnderlayPlugin mapUnderlayPlugin) {
        if (mapUnderlayPlugin.f7665k == null || mapUnderlayPlugin.f7665k.get() == null) {
            return null;
        }
        return (MapViewDelegate) mapUnderlayPlugin.f7665k.get();
    }

    public static boolean m7937u(MapUnderlayPlugin mapUnderlayPlugin) {
        return m7936t(mapUnderlayPlugin) != null;
    }

    public static boolean m7938v(MapUnderlayPlugin mapUnderlayPlugin) {
        return mapUnderlayPlugin.m7895i().getVisibility() == 0;
    }
}
