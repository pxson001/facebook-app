package com.facebook.messaging.media.mediapicker;

import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: mBusinessCountry */
public class SelectionState implements Iterable<Long> {
    public final int f11735a;
    public List<SelectionListener> f11736b = Lists.b();
    public List<Long> f11737c = Lists.b();

    /* compiled from: mBusinessCountry */
    public interface SelectionListener {
        void mo455a(long j, boolean z);
    }

    public SelectionState(int i) {
        this.f11735a = i;
    }

    public final boolean m12382a(MediaResource mediaResource) {
        return m12379b(mediaResource.g);
    }

    private boolean m12379b(long j) {
        if (m12383b() >= this.f11735a || this.f11737c.contains(Long.valueOf(j))) {
            return false;
        }
        this.f11737c.add(Long.valueOf(j));
        m12378a(j, true);
        return true;
    }

    public final void m12384b(MediaResource mediaResource) {
        m12380a(mediaResource.g);
    }

    public final void m12380a(long j) {
        if (this.f11737c.remove(Long.valueOf(j))) {
            m12378a(j, false);
        }
    }

    public final boolean m12385c(MediaResource mediaResource) {
        return this.f11737c.contains(Long.valueOf(mediaResource.g));
    }

    public final int m12383b() {
        return this.f11737c.size();
    }

    public final void m12381a(SelectionListener selectionListener) {
        this.f11736b.add(selectionListener);
    }

    private void m12378a(long j, boolean z) {
        for (SelectionListener a : this.f11736b) {
            a.mo455a(j, z);
        }
    }

    public Iterator<Long> iterator() {
        return Collections.unmodifiableList(this.f11737c).iterator();
    }
}
