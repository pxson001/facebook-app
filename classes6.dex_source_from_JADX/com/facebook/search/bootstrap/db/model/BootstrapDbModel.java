package com.facebook.search.bootstrap.db.model;

/* compiled from: expireAt */
public abstract class BootstrapDbModel {
    public final String f15706a;
    public final String f15707b;
    public final String f15708c;
    public final String f15709d;
    private final String f15710e;

    protected BootstrapDbModel(String str, String str2, String str3, String str4, String str5) {
        this.f15706a = str;
        this.f15707b = str2;
        this.f15708c = str3;
        this.f15709d = str4;
        this.f15710e = str5;
    }

    public final String m23423b() {
        return this.f15707b;
    }

    public String toString() {
        return getClass().getName() + "{, mName='" + this.f15707b + '\'' + ", mCost='" + this.f15710e + '\'' + '}';
    }

    public boolean equals(Object obj) {
        if (obj instanceof BootstrapDbModel) {
            return this.f15706a.equals(((BootstrapDbModel) obj).f15706a);
        }
        return false;
    }

    public int hashCode() {
        return this.f15706a.hashCode();
    }
}
