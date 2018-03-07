package com.facebook.friending.jewel.model;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;

/* compiled from: filter_mode/ */
public class ContactsSectionModel {
    public final List<Uri> f13328a = new ArrayList();
    public final List<String> f13329b = new ArrayList();
    public int f13330c = 0;

    public final boolean m14978b() {
        return !this.f13328a.isEmpty() && this.f13329b.size() >= 2 && this.f13329b.size() <= this.f13330c;
    }

    public final void m14979c() {
        this.f13328a.clear();
        this.f13329b.clear();
        this.f13330c = 0;
    }
}
