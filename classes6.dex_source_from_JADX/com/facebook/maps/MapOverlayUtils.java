package com.facebook.maps;

import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: weather_condition */
public class MapOverlayUtils {

    /* compiled from: weather_condition */
    public class MapProjectionInfo {
        public final int f278a;
        public final Location f279b;
        public final ImmutableList<Point> f280c;
        public final int f281d;
        public final int f282e;
        public final int f283f;

        public MapProjectionInfo(int i, Location location, ImmutableList<Point> immutableList, int i2, int i3, int i4) {
            this.f278a = i;
            this.f279b = location;
            this.f280c = immutableList;
            this.f281d = i2;
            this.f282e = i3;
            this.f283f = i4;
        }
    }

    /* compiled from: weather_condition */
    public class MapRequest {
        public final int f293a;
        public final int f294b;
        public final int f295c;
        public final int f296d;
        public final int f297e;
        public final int f298f;
        public final int f299g;
        @Nullable
        public final ImmutableList<Location> f300h;
        @Nullable
        public final List<MapOverlayMarker> f301i;

        /* compiled from: weather_condition */
        public class Builder {
            public int f284a;
            public int f285b;
            public int f286c;
            public int f287d;
            public int f288e;
            public int f289f;
            public int f290g;
            @Nullable
            public ImmutableList<Location> f291h;
            @Nullable
            public List<MapOverlayMarker> f292i;
        }

        public MapRequest(Builder builder) {
            this.f293a = builder.f284a;
            this.f294b = builder.f285b;
            this.f295c = builder.f286c;
            this.f296d = builder.f287d;
            this.f297e = builder.f288e;
            this.f298f = builder.f289f;
            this.f299g = builder.f290g;
            this.f300h = builder.f291h;
            this.f301i = builder.f292i;
        }
    }

    /* compiled from: weather_condition */
    class PathBoundingBox {
        final double f302a;
        final double f303b;
        final double f304c;
        final double f305d;
        final double f306e;
        final double f307f;
        final /* synthetic */ MapOverlayUtils f308g;

        PathBoundingBox(MapOverlayUtils mapOverlayUtils, double d, double d2, double d3, double d4, double d5, double d6) {
            this.f308g = mapOverlayUtils;
            this.f302a = d;
            this.f303b = d2;
            this.f304c = d3;
            this.f305d = d4;
            this.f306e = d5;
            this.f307f = d6;
        }
    }

    private PathBoundingBox m254a(ImmutableList<Location> immutableList) {
        double c = m261c(((Location) immutableList.get(0)).getLatitude());
        double b = m258b(((Location) immutableList.get(0)).getLongitude());
        double a = m248a(b);
        int i = 1;
        double d = b;
        double a2 = m248a(b);
        double d2 = a;
        double d3 = b;
        a = c;
        double d4 = c;
        c = b;
        while (i < immutableList.size()) {
            Location location = (Location) immutableList.get(i);
            double c2 = m261c(location.getLatitude());
            double b2 = m258b(location.getLongitude());
            double max = Math.max(c2, d4);
            c2 = Math.min(c2, a);
            c = Math.max(b2, c);
            d3 = Math.min(b2, d3);
            d4 = m248a(b2);
            if (d4 > d2) {
                d = b2;
                a = d4;
            } else {
                a = d2;
            }
            if (d4 < a2) {
                b = b2;
            } else {
                d4 = a2;
            }
            i++;
            a2 = d4;
            d2 = a;
            a = c2;
            d4 = max;
        }
        return new PathBoundingBox(this, d4, a, c, d3, d, b);
    }

    private static double m248a(double d) {
        if (d == 0.0d) {
            return 180.0d;
        }
        return d - (180.0d * Math.signum(d));
    }

    @Nullable
    public final MapProjectionInfo m264a(MapRequest mapRequest) {
        if (mapRequest.f300h == null || mapRequest.f300h.isEmpty()) {
            return null;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        PathBoundingBox a = m254a(mapRequest.f300h);
        Rect rect3 = new Rect(mapRequest.f296d / mapRequest.f295c, mapRequest.f297e / mapRequest.f295c, mapRequest.f298f / mapRequest.f295c, mapRequest.f299g / mapRequest.f295c);
        int i = 0;
        Location location = new Location("");
        int i2 = 21;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            Optional b = m260b(i4, mapRequest, a, rect3, rect, rect2);
            if (b.isPresent()) {
                i = i4;
                location = (Location) b.get();
                i3 = i4 + 1;
            } else {
                i2 = i4 - 1;
            }
        }
        return new MapProjectionInfo(i, location, m255a(mapRequest.f300h, location, i, mapRequest.f293a, mapRequest.f294b, mapRequest.f295c), mapRequest.f293a, mapRequest.f294b, mapRequest.f295c);
    }

    private void m256a(int i, MapRequest mapRequest, PathBoundingBox pathBoundingBox, Rect rect, Rect rect2, Rect rect3) {
        Point a = m250a(pathBoundingBox.f302a, pathBoundingBox.f304c, i, mapRequest.f295c);
        Point a2 = m250a(pathBoundingBox.f303b, pathBoundingBox.f305d, i, mapRequest.f295c);
        rect3.set(a2.x - rect.left, a2.y - rect.bottom, a.x + rect.right, a.y + rect.top);
        a = m250a(pathBoundingBox.f302a, pathBoundingBox.f306e, i, mapRequest.f295c);
        a2 = m250a(pathBoundingBox.f303b, pathBoundingBox.f307f, i, mapRequest.f295c);
        rect2.set(a.x - rect.left, a2.y - rect.bottom, a2.x + rect.right, a.y + rect.top);
    }

    private Optional<Location> m260b(int i, MapRequest mapRequest, PathBoundingBox pathBoundingBox, Rect rect, Rect rect2, Rect rect3) {
        int width;
        m256a(i, mapRequest, pathBoundingBox, rect, rect2, rect3);
        int c = m262c(i, mapRequest.f295c);
        Object obj = c - rect2.width() < rect3.width() ? 1 : null;
        if (obj == null) {
            m257a(rect3, i, mapRequest.f295c, mapRequest.f301i);
            width = rect3.width();
        } else {
            m257a(rect2, i, mapRequest.f295c, mapRequest.f301i);
            width = c - rect2.width();
            rect3 = rect2;
        }
        int height = rect3.height();
        if ((width > mapRequest.f293a * mapRequest.f295c || height > mapRequest.f294b * mapRequest.f295c) && i != 0) {
            return Absent.INSTANCE;
        }
        width = rect3.centerX();
        if (obj != null) {
            width -= c / 2;
        }
        return Optional.of(m253a(new Point(m249a(width, c), rect3.centerY()), i, mapRequest.f295c));
    }

    private void m257a(Rect rect, int i, int i2, @Nullable List<MapOverlayMarker> list) {
        if (list != null) {
            for (MapOverlayMarker mapOverlayMarker : list) {
                Point a = m251a(mapOverlayMarker.mo36a(), i, i2);
                rect.union(a.x - (mapOverlayMarker.mo38b() / 2), a.y, a.x + (mapOverlayMarker.mo38b() / 2), mapOverlayMarker.mo39c() + a.y);
            }
        }
    }

    private static int m249a(int i, int i2) {
        int i3 = i % i2;
        if (i3 < (-i2) / 2) {
            return i3 + i2;
        }
        return i3;
    }

    private static double m258b(double d) {
        double d2 = d % 360.0d;
        if (d2 > 180.0d) {
            return 360.0d - d2;
        }
        if (d2 < -180.0d) {
            return d2 + 360.0d;
        }
        return d2;
    }

    private static double m261c(double d) {
        double d2 = d % 180.0d;
        if (d2 > 90.0d) {
            d2 = 180.0d - d2;
        } else if (d2 < -90.0d) {
            d2 += 180.0d;
        }
        if (Math.abs(d2) == 90.0d) {
            return d2 - (Math.signum(d2) * 1.0E-5d);
        }
        return d2;
    }

    private ImmutableList<Point> m255a(List<Location> list, Location location, int i, int i2, int i3, int i4) {
        Point a = m251a(location, i, i4);
        Builder builder = ImmutableList.builder();
        for (Location a2 : list) {
            builder.c(m252a(a2, a, i, i2, i3, i4));
        }
        return builder.b();
    }

    public final Point m263a(Location location, Location location2, int i, int i2, int i3, int i4) {
        return m252a(location, m251a(location2, i, i4), i, i2, i3, i4);
    }

    private Point m252a(Location location, Point point, int i, int i2, int i3, int i4) {
        Point a = m251a(location, i, i4);
        Point point2 = new Point();
        point2.x = (a.x - point.x) + ((i2 * i4) / 2);
        point2.x = m249a(point2.x, m262c(i, i4));
        point2.y = (point.y - a.y) + ((i3 * i4) / 2);
        return point2;
    }

    private Point m250a(double d, double d2, int i, int i2) {
        double b = m258b(d2);
        double c = m261c(d);
        b = Math.toRadians(b);
        c = Math.toRadians(c);
        double b2 = m259b(i, i2);
        return new Point((int) (b * b2), (int) (Math.log(Math.tan((c / 2.0d) + 0.7853981633974483d)) * b2));
    }

    private Point m251a(Location location, int i, int i2) {
        return m250a(location.getLatitude(), location.getLongitude(), i, i2);
    }

    private Location m253a(Point point, int i, int i2) {
        double b = m259b(i, i2);
        double d = ((double) point.x) / b;
        b = (Math.atan(Math.exp(((double) point.y) / b)) * 2.0d) - 1.5707963267948966d;
        Location location = new Location("");
        location.setLongitude(m258b(Math.toDegrees(d)));
        location.setLatitude(m261c(Math.toDegrees(b)));
        return location;
    }

    private static double m259b(int i, int i2) {
        return ((double) i2) * (((double) (1 << (i + 7))) / 3.141592653589793d);
    }

    private int m262c(int i, int i2) {
        return (int) (m259b(i, i2) * 6.283185307179586d);
    }
}
