package com.facebook.android.maps.internal;

import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.Tile;

/* compiled from: autofill_enabled_on_fallback */
public class TileTree {
    Tile f8484a;
    Tile f8485b;
    private Tile f8486c;
    public int f8487d = -1;
    public int f8488e = -1;
    public int f8489f = 0;
    private int f8490g;

    public TileTree() {
        m14522d();
    }

    private void m14522d() {
        this.f8486c = Tile.m14609a();
        this.f8486c.m14614a(0, 0, 0);
        this.f8485b = this.f8486c;
        this.f8484a = this.f8486c;
        this.f8490g = 0;
    }

    public final TileTree m14523a(int i) {
        this.f8488e = i;
        return this;
    }

    public final TileTree m14526b(int i) {
        this.f8489f = i;
        return this;
    }

    public final void m14525a(Tile tile) {
        if (tile.f8667r != null) {
            this.f8490g++;
        }
        Tile tile2 = this.f8486c;
        int a = m14518a(tile.f8660f, tile.f8661g, tile.f8659e, tile2.f8659e);
        while (tile2.f8663i[a] != null) {
            Tile tile3 = tile2.f8663i[a];
            Object obj = null;
            if (tile.f8659e > tile3.f8659e) {
                int i = tile.f8659e - tile3.f8659e;
                if ((tile.f8660f >> i) == tile3.f8660f && (tile.f8661g >> i) == tile3.f8661g) {
                    obj = 1;
                }
            }
            if (obj == null) {
                break;
            }
            tile2 = tile2.f8663i[a];
            a = m14518a(tile.f8660f, tile.f8661g, tile.f8659e, tile2.f8659e);
        }
        Tile tile4 = tile2.f8663i[a];
        if (tile4 == null) {
            tile2.f8663i[a] = tile;
        } else if (tile.f8659e < tile4.f8659e) {
            tile2.f8663i[a] = tile;
            tile.f8663i[m14518a(tile4.f8660f, tile4.f8661g, tile4.f8659e, tile.f8659e)] = tile4;
        } else if (tile4.f8659e == tile.f8659e && tile4.f8660f == tile.f8660f && tile4.f8661g == tile.f8661g) {
            m14521c(tile4);
            System.arraycopy(tile4.f8663i, 0, tile.f8663i, 0, 4);
            tile2.f8663i[a] = tile;
            if (tile4.f8667r != null) {
                this.f8490g--;
            }
            tile4.m14617c();
        } else {
            int i2 = tile.f8659e - tile4.f8659e;
            int i3 = tile.f8660f >> i2;
            int i4 = tile.f8661g >> i2;
            int i5 = tile4.f8660f;
            int i6 = tile4.f8661g;
            i2 = tile4.f8659e;
            while (true) {
                if (i3 == i5 && i4 == i6) {
                    break;
                }
                i3 >>= 1;
                i4 >>= 1;
                i5 >>= 1;
                i6 >>= 1;
                i2--;
            }
            Tile a2 = Tile.m14609a();
            a2.m14614a(i3, i4, i2);
            tile2.f8663i[a] = a2;
            a2.f8663i[m14518a(tile4.f8660f, tile4.f8661g, tile4.f8659e, i2)] = tile4;
            a2.f8663i[m14518a(tile.f8660f, tile.f8661g, tile.f8659e, i2)] = tile;
            m14520b(a2);
        }
        m14520b(tile);
        m14527b();
    }

    public final void m14524a(int i, int i2, int i3, FacadeTile facadeTile) {
        int i4 = 0;
        int i5 = 0;
        facadeTile.f8396h = 0;
        facadeTile.f8389a = null;
        facadeTile.f8390b = null;
        while (i5 < 4) {
            facadeTile.f8391c[i5] = null;
            i5++;
        }
        facadeTile.f8393e = i;
        facadeTile.f8394f = i2;
        facadeTile.f8395g = i3;
        Tile tile = this.f8486c;
        while (tile.f8659e < i3) {
            if (tile.f8667r != null) {
                facadeTile.f8390b = tile;
            }
            int a = m14518a(i, i2, i3, tile.f8659e);
            if (tile.f8663i[a] == null) {
                break;
            }
            tile = tile.f8663i[a];
        }
        if (tile.f8659e == i3 && tile.f8660f == i && tile.f8661g == i2) {
            if (tile.f8667r != null) {
                facadeTile.f8389a = tile;
            } else {
                facadeTile.f8396h = tile.f8666l;
                System.arraycopy(tile.f8663i, 0, facadeTile.f8391c, 0, 4);
                while (i4 < 4) {
                    m14520b(tile.f8663i[i4]);
                    i4++;
                }
            }
        }
        if (facadeTile.f8389a != null) {
            m14520b(facadeTile.f8389a);
        } else if (facadeTile.f8390b != null) {
            m14520b(facadeTile.f8390b);
        }
    }

    public final void m14527b() {
        long a = AnalyticsEvent.a();
        try {
            if (this.f8488e != -1) {
                int i = (this.f8488e - this.f8489f) + (this.f8487d != -1 ? 1 << (this.f8487d << 1) : 0);
                if (this.f8490g <= i) {
                    AnalyticsEvent.f.a(AnalyticsEvent.a() - a);
                    return;
                }
                Tile tile = this.f8485b;
                while (this.f8490g > i && tile != null) {
                    if (!(tile.m14616b() == null || tile.f8659e == this.f8487d || tile.f8666l != 0)) {
                        tile.m14615a(null);
                        this.f8490g--;
                    }
                    tile = tile.f8664j;
                }
                while (true) {
                    int i2 = 0;
                    for (Tile tile2 = this.f8485b; tile2 != null; tile2 = tile2.f8664j) {
                        int i3 = 0;
                        while (i3 < 4) {
                            int i4;
                            Tile tile3 = tile2.f8663i[i3];
                            if (tile3 != null && tile3.f8666l == 0 && tile3.m14616b() == null) {
                                i4 = -1;
                                int i5 = 0;
                                for (i = 0; i < 4; i++) {
                                    if (tile3.f8663i[i] != null) {
                                        i5++;
                                        i4 = i;
                                    }
                                }
                                if (i5 == 1) {
                                    tile2.f8663i[i3] = tile3.f8663i[i4];
                                    m14521c(tile3);
                                    tile3.m14617c();
                                    i4 = 1;
                                } else if (i5 == 0) {
                                    tile2.f8663i[i3] = null;
                                    m14521c(tile3);
                                    tile3.m14617c();
                                    i4 = 1;
                                }
                                i3++;
                                i2 = i4;
                            }
                            i4 = i2;
                            i3++;
                            i2 = i4;
                        }
                    }
                    if (i2 == 0) {
                        AnalyticsEvent.f.a(AnalyticsEvent.a() - a);
                        return;
                    }
                }
            }
        } finally {
            AnalyticsEvent.f.a(AnalyticsEvent.a() - a);
        }
    }

    private static int m14518a(int i, int i2, int i3, int i4) {
        int i5 = (i3 - i4) - 1;
        return ((i2 >> i5) & 1) + (((i >> i5) & 1) << 1);
    }

    public final void m14528c() {
        Tile tile = this.f8485b;
        while (tile != null) {
            Tile tile2 = tile.f8664j;
            tile.m14617c();
            tile = tile2;
        }
        m14522d();
    }

    private void m14520b(Tile tile) {
        if (tile != null) {
            m14521c(tile);
            this.f8484a.f8664j = tile;
            tile.f8665k = this.f8484a;
            this.f8484a = tile;
        }
    }

    private void m14521c(Tile tile) {
        if (tile == this.f8485b) {
            this.f8485b = tile.f8664j;
        }
        if (tile == this.f8484a) {
            this.f8484a = tile.f8665k;
        }
        if (tile.f8664j != null) {
            tile.f8664j.f8665k = tile.f8665k;
        }
        if (tile.f8665k != null) {
            tile.f8665k.f8664j = tile.f8664j;
        }
        tile.f8664j = null;
        tile.f8665k = null;
    }

    public String toString() {
        return m14519a(this.f8486c, 10) + "\n";
    }

    private String m14519a(Tile tile, int i) {
        if (i < 0) {
            return "<snip>";
        }
        if (tile == null) {
            return "\n{x}";
        }
        String str = "\n" + tile.toString();
        Tile[] tileArr = tile.f8663i;
        int length = tileArr.length;
        String str2 = str;
        int i2 = 0;
        while (i2 < length) {
            i2++;
            str2 = str2 + m14519a(tileArr[i2], i - 1).replace("\n", "\n-");
        }
        return str2;
    }
}
