package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: event_buy_tickets_button_tapped */
public class GraphRequestBatch extends AbstractList<GraphRequest> {
    private static AtomicInteger f13817a = new AtomicInteger();
    public Handler f13818b;
    private List<GraphRequest> f13819c;
    private int f13820d;
    public final String f13821e;
    public List<Callback> f13822f;
    public String f13823g;

    /* compiled from: event_buy_tickets_button_tapped */
    public interface Callback {
        void mo694a();
    }

    /* compiled from: event_buy_tickets_button_tapped */
    public interface OnProgressCallback extends Callback {
    }

    public void add(int i, Object obj) {
        this.f13819c.add(i, (GraphRequest) obj);
    }

    public boolean add(Object obj) {
        return this.f13819c.add((GraphRequest) obj);
    }

    public /* synthetic */ Object get(int i) {
        return m14111a(i);
    }

    public Object set(int i, Object obj) {
        return (GraphRequest) this.f13819c.set(i, (GraphRequest) obj);
    }

    public GraphRequestBatch() {
        this.f13819c = new ArrayList();
        this.f13820d = 0;
        this.f13821e = Integer.valueOf(f13817a.incrementAndGet()).toString();
        this.f13822f = new ArrayList();
        this.f13819c = new ArrayList();
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        this.f13819c = new ArrayList();
        this.f13820d = 0;
        this.f13821e = Integer.valueOf(f13817a.incrementAndGet()).toString();
        this.f13822f = new ArrayList();
        this.f13819c = new ArrayList(collection);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        this.f13819c = new ArrayList();
        this.f13820d = 0;
        this.f13821e = Integer.valueOf(f13817a.incrementAndGet()).toString();
        this.f13822f = new ArrayList();
        this.f13819c = Arrays.asList(graphRequestArr);
    }

    public final int m14110a() {
        return this.f13820d;
    }

    public final void clear() {
        this.f13819c.clear();
    }

    public final GraphRequest m14111a(int i) {
        return (GraphRequest) this.f13819c.get(i);
    }

    public Object remove(int i) {
        return (GraphRequest) this.f13819c.remove(i);
    }

    public final int size() {
        return this.f13819c.size();
    }

    final String m14112b() {
        return this.f13821e;
    }

    final Handler m14113c() {
        return this.f13818b;
    }

    final List<GraphRequest> m14114d() {
        return this.f13819c;
    }

    public final List<GraphResponse> m14115g() {
        return GraphRequest.m14075a(this);
    }
}
