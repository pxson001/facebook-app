package com.facebook.places.pickers;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.pickers.PlaceContentPickerFragment.C09572;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.EmptyListViewItem;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/* compiled from: firstDeltaSeqId */
public class PlaceContentPickerView<T> extends CustomLinearLayout {
    public EditText f14820a;
    public ImageButton f14821b;
    public Optional<? extends View> f14822c;
    private EmptyListViewItem f14823d;
    private PlaceContentPickerAdapter<T> f14824e;
    public BetterListView f14825f;
    public LinearLayout f14826g;
    public Optional<? extends OnContentClickListener<T>> f14827h;
    public Optional<? extends TextWatcher> f14828i;
    private CharSequence f14829j;
    private boolean f14830k;

    /* compiled from: firstDeltaSeqId */
    class C09591 implements OnItemClickListener {
        final /* synthetic */ PlaceContentPickerView f14817a;

        C09591(PlaceContentPickerView placeContentPickerView) {
            this.f14817a = placeContentPickerView;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f14817a.f14827h.isPresent()) {
                C09572 c09572 = (C09572) this.f14817a.f14827h.get();
                Object obj = ((PlaceContentPickerRow) this.f14817a.f14825f.getItemAtPosition(i)).f14811a;
                KeyboardUtils.a(c09572.f14799a.ao());
                c09572.f14799a.mo1166a(obj);
            }
        }
    }

    /* compiled from: firstDeltaSeqId */
    public class C09602 implements OnClickListener {
        final /* synthetic */ PlaceContentPickerView f14818a;

        public C09602(PlaceContentPickerView placeContentPickerView) {
            this.f14818a = placeContentPickerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1603514724);
            this.f14818a.f14820a.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, 425321149, a);
        }
    }

    /* compiled from: firstDeltaSeqId */
    public class C09613 implements TextWatcher {
        final /* synthetic */ PlaceContentPickerView f14819a;

        public C09613(PlaceContentPickerView placeContentPickerView) {
            this.f14819a = placeContentPickerView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f14819a.f14828i.isPresent()) {
                ((TextWatcher) this.f14819a.f14828i.get()).beforeTextChanged(charSequence, i, i2, i3);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (this.f14819a.f14828i.isPresent()) {
                ((TextWatcher) this.f14819a.f14828i.get()).onTextChanged(charSequence, i, i2, i3);
            }
        }

        public void afterTextChanged(Editable editable) {
            this.f14819a.f14821b.setVisibility(TextUtils.isEmpty(this.f14819a.f14820a.getText()) ? 4 : 0);
            if (this.f14819a.f14828i.isPresent()) {
                ((TextWatcher) this.f14819a.f14828i.get()).afterTextChanged(editable);
            }
        }
    }

    public PlaceContentPickerView(Context context) {
        super(context);
        m22456a();
    }

    public void setHeaderVisibility(int i) {
        if (this.f14822c.isPresent()) {
            ((View) this.f14822c.get()).setVisibility(i);
        }
    }

    public void setRows(ImmutableList<PlaceContentPickerRow<T>> immutableList) {
        PlaceContentPickerAdapter placeContentPickerAdapter = this.f14824e;
        placeContentPickerAdapter.f14797a = immutableList;
        AdapterDetour.a(placeContentPickerAdapter, 1579531703);
    }

    public final void m22460a(boolean z) {
        this.f14823d.m8598a(z);
        this.f14830k = z;
        m22459f();
    }

    public void setFooterMessage(CharSequence charSequence) {
        this.f14823d.setMessage(charSequence);
        this.f14829j = charSequence;
        m22459f();
    }

    private void m22456a() {
        setContentView(2130906242);
        this.f14820a = (EditText) a(2131560492);
        this.f14821b = (ImageButton) a(2131560324);
        this.f14825f = (BetterListView) a(2131565959);
        this.f14823d = (EmptyListViewItem) LayoutInflater.from(getContext()).inflate(2130906243, this, false);
        this.f14826g = m22458e();
        this.f14822c = Absent.INSTANCE;
        this.f14824e = new PlaceContentPickerAdapter();
        this.f14827h = Absent.INSTANCE;
        this.f14828i = Absent.INSTANCE;
        this.f14829j = "";
        this.f14830k = false;
        m22459f();
        m22457b();
        this.f14821b.setOnClickListener(new C09602(this));
        this.f14820a.addTextChangedListener(new C09613(this));
    }

    private void m22457b() {
        this.f14825f.setOnItemClickListener(new C09591(this));
        this.f14825f.addHeaderView(this.f14826g, null, false);
        View e = m22458e();
        e.addView(this.f14823d);
        this.f14825f.addFooterView(e, null, false);
        this.f14825f.setAdapter(this.f14824e);
    }

    private LinearLayout m22458e() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    private void m22459f() {
        boolean z;
        boolean z2 = true;
        if (this.f14830k || !TextUtils.isEmpty(this.f14829j)) {
            z = true;
        } else {
            z = false;
        }
        this.f14823d.setVisibility(z ? 0 : 8);
        BetterListView betterListView = this.f14825f;
        if (z) {
            z2 = false;
        }
        betterListView.setFooterDividersEnabled(z2);
    }
}
