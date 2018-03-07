package com.facebook.feed.rows.adapter;

import android.content.res.Configuration;
import com.facebook.debug.dumpsys.DumpsysContext;
import com.facebook.feed.rows.adapter.api.HasMarkers.Marker;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.core.RowIdentifier;

/* compiled from: min */
public class DelegatingHasMultiRow implements HasMultiRow {
    private final HasMultiRow f13524a;

    public DelegatingHasMultiRow(HasMultiRow hasMultiRow) {
        this.f13524a = hasMultiRow;
    }

    public void mo2508a(Configuration configuration) {
        this.f13524a.mo2508a(configuration);
    }

    public void jc_() {
        this.f13524a.jc_();
    }

    public final boolean ba_() {
        return this.f13524a.ba_();
    }

    public final int s_(int i) {
        return this.f13524a.s_(i);
    }

    public final int t_(int i) {
        return this.f13524a.t_(i);
    }

    public final int mo2514g(int i) {
        return this.f13524a.mo2514g(i);
    }

    public final int mo2512e() {
        return this.f13524a.mo2512e();
    }

    public final int mo2515h(int i) {
        return this.f13524a.mo2515h(i);
    }

    public final int mo2510c(int i) {
        return this.f13524a.mo2510c(i);
    }

    public final int mo2511d(int i) {
        return this.f13524a.mo2511d(i);
    }

    public final RowIdentifier mo2513f() {
        return this.f13524a.mo2513f();
    }

    public void mo1888a(DumpsysContext dumpsysContext) {
        this.f13524a.mo1888a(dumpsysContext);
    }

    public final Marker mo2509b(int i) {
        return this.f13524a.mo2509b(i);
    }
}
