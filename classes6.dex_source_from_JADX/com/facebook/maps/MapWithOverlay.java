package com.facebook.maps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Point;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.android.maps.StaticMapView;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.inject.FbInjector;
import com.facebook.maps.MapOverlayUtils.MapProjectionInfo;
import com.facebook.maps.MapOverlayUtils.MapRequest;
import com.facebook.maps.MapOverlayUtils.MapRequest.Builder;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: watermarkTimestampMs */
public class MapWithOverlay extends FbStaticMapView {
    @Inject
    public MapOverlayUtils f309d;
    private Paint f310e;
    private int f311f = 0;
    private int f312g = 0;
    private int f313h = 0;
    private int f314i = 0;
    private Optional<ImmutableList<Location>> f315j = Absent.INSTANCE;
    private int f316k;
    private int f317l;
    private int f318m;
    private int f319n;
    private final StaticMapOptions f320o = new StaticMapOptions("map_with_overlay");
    private Optional<MapProjectionInfo> f321p = Absent.INSTANCE;
    private List<MapOverlayMarker> f322q = Lists.a();

    private static <T extends View> void m266a(Class<T> cls, T t) {
        m267a((Object) t, t.getContext());
    }

    private static void m267a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MapWithOverlay) obj).f309d = new MapOverlayUtils();
    }

    public MapWithOverlay(Context context) {
        super(context);
        m269c();
    }

    public MapWithOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m269c();
    }

    public MapWithOverlay(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m269c();
    }

    private void m269c() {
        m266a(MapWithOverlay.class, (View) this);
        this.f310e = new Paint();
        this.f310e.setAntiAlias(true);
        this.f310e.setStrokeJoin(Join.ROUND);
        this.f310e.setStrokeCap(Cap.ROUND);
    }

    public void setMapSurface(String str) {
        this.f320o.a = str;
    }

    public final void m272a(ImmutableList<Location> immutableList, int i, int i2, int i3, int i4) {
        if (immutableList == null || immutableList.size() < 2) {
            this.f315j = Absent.INSTANCE;
            return;
        }
        this.f315j = Optional.of(immutableList);
        this.f316k = i;
        this.f317l = i2;
        this.f318m = i3;
        this.f319n = i4;
    }

    public final void m270a(int i, int i2, int i3, int i4) {
        this.f311f = i;
        this.f312g = i2;
        this.f313h = i3;
        this.f314i = i4;
    }

    public final void m273b() {
        this.f322q.clear();
    }

    public final void m271a(ImmutableList<MapOverlayMarker> immutableList) {
        this.f322q.addAll(immutableList);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            int a = StaticMapView.a(getResources());
            int i5 = this.b / a;
            int i6 = this.c / a;
            if (this.f315j.isPresent()) {
                Builder builder = new Builder();
                builder.f284a = i5;
                builder.f285b = i6;
                Builder builder2 = builder;
                builder2.f286c = a;
                Builder builder3 = builder2;
                i5 = this.f311f;
                i6 = this.f312g;
                int i7 = this.f313h;
                int i8 = this.f314i;
                builder3.f287d = i5;
                builder3.f288e = i6;
                builder3.f289f = i7;
                builder3.f290g = i8;
                builder2 = builder3;
                builder2.f291h = (ImmutableList) this.f315j.get();
                builder3 = builder2;
                builder3.f292i = this.f322q;
                this.f321p = Optional.of(this.f309d.m264a(new MapRequest(builder3)));
                setMapOptions(this.f320o.a().a(((MapProjectionInfo) this.f321p.get()).f279b).a(((MapProjectionInfo) this.f321p.get()).f278a));
            }
        }
    }

    private void m265a(MapOverlayUtils mapOverlayUtils) {
        this.f309d = mapOverlayUtils;
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f321p.isPresent()) {
            MapProjectionInfo mapProjectionInfo = (MapProjectionInfo) this.f321p.get();
            Optional b = m268b(mapProjectionInfo.f280c);
            if (b.isPresent()) {
                this.f310e.setStyle(Style.STROKE);
                this.f310e.setColor(this.f318m);
                this.f310e.setStrokeWidth((float) this.f319n);
                canvas.drawPath((Path) b.get(), this.f310e);
                this.f310e.setColor(this.f316k);
                this.f310e.setStrokeWidth((float) this.f317l);
                canvas.drawPath((Path) b.get(), this.f310e);
            }
            for (MapOverlayMarker mapOverlayMarker : this.f322q) {
                mapOverlayMarker.mo37a(canvas, this.f309d.m263a(mapOverlayMarker.mo36a(), mapProjectionInfo.f279b, mapProjectionInfo.f278a, mapProjectionInfo.f281d, mapProjectionInfo.f282e, mapProjectionInfo.f283f));
            }
        }
    }

    private static Optional<Path> m268b(@Nullable ImmutableList<Point> immutableList) {
        if (immutableList == null || immutableList.size() < 2) {
            return Absent.INSTANCE;
        }
        Path path = new Path();
        path.moveTo((float) ((Point) immutableList.get(0)).x, (float) ((Point) immutableList.get(0)).y);
        for (int i = 1; i < immutableList.size(); i++) {
            path.lineTo((float) ((Point) immutableList.get(i)).x, (float) ((Point) immutableList.get(i)).y);
        }
        return Optional.of(path);
    }
}
