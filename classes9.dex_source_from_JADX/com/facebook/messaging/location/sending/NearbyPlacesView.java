package com.facebook.messaging.location.sending;

import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: mIsSender */
public class NearbyPlacesView extends CustomFrameLayout {
    @Nullable
    public NearbyPlaceClickListener f11480a;
    private View f11481b;
    private RecyclerView f11482c;
    private NearbyPlacesAdapter f11483d;
    private ViewStubHolder<TextView> f11484e;

    /* compiled from: mIsSender */
    class C12831 implements OnClickListener {
        final /* synthetic */ NearbyPlacesView f11479a;

        C12831(NearbyPlacesView nearbyPlacesView) {
            this.f11479a = nearbyPlacesView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -105470107);
            this.f11479a.m12077a(view);
            Logger.a(2, EntryType.UI_INPUT_END, 354213706, a);
        }
    }

    public NearbyPlacesView(Context context) {
        super(context);
        m12079b();
    }

    public NearbyPlacesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m12079b();
    }

    public NearbyPlacesView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m12079b();
    }

    private void m12079b() {
        setContentView(2130905406);
        this.f11481b = c(2131560407);
        this.f11482c = (RecyclerView) c(2131564156);
        this.f11484e = ViewStubHolder.a((ViewStubCompat) c(2131564155));
        m12080e();
    }

    private void m12080e() {
        getContext();
        this.f11482c.setLayoutManager(new LinearLayoutManager(1, false));
        m12081f();
        this.f11482c.setAdapter(this.f11483d);
    }

    private void m12081f() {
        this.f11483d = new NearbyPlacesAdapter(new C12831(this));
    }

    public void setNearbyPlaceClickListener(NearbyPlaceClickListener nearbyPlaceClickListener) {
        this.f11480a = nearbyPlaceClickListener;
    }

    public final void m12082a() {
        this.f11481b.setVisibility(0);
        this.f11482c.setVisibility(8);
        this.f11484e.e();
    }

    public final void m12083a(ImmutableList<NearbyPlace> immutableList) {
        NearbyPlacesAdapter nearbyPlacesAdapter = this.f11483d;
        nearbyPlacesAdapter.f11459a = immutableList;
        nearbyPlacesAdapter.notifyDataSetChanged();
        this.f11481b.setVisibility(8);
        this.f11482c.setVisibility(0);
        this.f11484e.e();
    }

    public final void m12084a(String str) {
        this.f11482c.setVisibility(8);
        this.f11481b.setVisibility(8);
        TextView textView = (TextView) this.f11484e.a();
        textView.setVisibility(0);
        textView.setText(str);
    }

    private void m12077a(View view) {
        NearbyPlace nearbyPlace = (NearbyPlace) this.f11483d.f11459a.get(RecyclerView.d(view));
        if (this.f11480a != null) {
            this.f11480a.mo435a(nearbyPlace);
        }
    }
}
