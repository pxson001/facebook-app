package com.facebook.search.results.model;

import android.net.Uri;

/* compiled from: RichDocumentNodeFeedback */
public class SportsTeam {
    private String f23392a;
    public Type f23393b;
    public String f23394c;
    public String f23395d;
    public String f23396e;
    public String f23397f;
    public int f23398g;
    public int f23399h;
    public Uri f23400i;
    public boolean f23401j;

    /* compiled from: RichDocumentNodeFeedback */
    public enum Type {
        HOME_TEAM,
        AWAY_TEAM
    }

    public SportsTeam(String str, Type type, String str2, String str3, String str4, String str5, int i, int i2, Uri uri, boolean z) {
        this.f23392a = str;
        this.f23393b = type;
        this.f23394c = str2;
        this.f23395d = str3;
        this.f23396e = str4;
        this.f23397f = str5;
        this.f23398g = i;
        this.f23399h = i2;
        this.f23400i = uri;
        this.f23401j = z;
    }

    private static SportsTeam m27111a(SportsTeam sportsTeam, int i, int i2, boolean z) {
        return new SportsTeam(sportsTeam.f23392a, sportsTeam.f23393b, sportsTeam.f23394c, sportsTeam.f23395d, sportsTeam.f23396e, sportsTeam.f23397f, i, i2, sportsTeam.f23400i, z);
    }

    public static SportsTeam m27110a(SportsTeam sportsTeam) {
        return m27111a(sportsTeam, sportsTeam.f23398g, sportsTeam.f23399h + 1, sportsTeam.f23401j);
    }

    public static SportsTeam m27112b(SportsTeam sportsTeam) {
        return m27111a(sportsTeam, sportsTeam.f23398g + 1, sportsTeam.f23399h + 1, true);
    }
}
