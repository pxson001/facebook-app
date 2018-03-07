package com.facebook.places.pickers;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.keyboard.KeyboardUtils;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: folders */
public abstract class PlaceContentPickerFragment<T> extends FbFragment {
    public PlaceContentPickerView<T> f14747a;

    /* compiled from: folders */
    public class C09561 implements TextWatcher {
        final /* synthetic */ PlaceContentPickerFragment f14798a;

        public C09561(PlaceContentPickerFragment placeContentPickerFragment) {
            this.f14798a = placeContentPickerFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (this.f14798a.hn_()) {
                this.f14798a.at();
            }
        }
    }

    /* compiled from: folders */
    public class C09572 {
        public final /* synthetic */ PlaceContentPickerFragment f14799a;

        public C09572(PlaceContentPickerFragment placeContentPickerFragment) {
            this.f14799a = placeContentPickerFragment;
        }
    }

    /* compiled from: folders */
    public class C09583 implements OnScrollListener {
        final /* synthetic */ PlaceContentPickerFragment f14800a;

        public C09583(PlaceContentPickerFragment placeContentPickerFragment) {
            this.f14800a = placeContentPickerFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 2 || i == 1) {
                KeyboardUtils.a(this.f14800a.ao());
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    protected abstract ImmutableList<PlaceContentPickerRow<T>> mo1165a(String str);

    public abstract void mo1166a(T t);

    protected abstract Optional<? extends View> aq();

    protected abstract boolean ar();

    protected abstract boolean as();

    protected abstract ImmutableList<PlaceContentPickerRow<T>> mo1170b();

    protected abstract CharSequence mo1171b(String str);

    public abstract String mo1172e();

    public final void at() {
        int i = 0;
        String au = au();
        if (TextUtils.isEmpty(au)) {
            PlaceContentPickerView placeContentPickerView = this.f14747a;
            if (!this.s.getBoolean("extra_show_null_state_header", false)) {
                i = 8;
            }
            placeContentPickerView.setHeaderVisibility(i);
            this.f14747a.m22460a(ar());
            this.f14747a.setFooterMessage(null);
            this.f14747a.setRows(mo1170b());
            return;
        }
        this.f14747a.setHeaderVisibility(8);
        ImmutableList a = mo1165a(au);
        this.f14747a.m22460a(as());
        PlaceContentPickerView placeContentPickerView2 = this.f14747a;
        CharSequence b = (!a.isEmpty() || as()) ? "" : mo1171b(au);
        placeContentPickerView2.setFooterMessage(b);
        this.f14747a.setRows(a);
    }

    protected final String au() {
        return this.f14747a.f14820a.getText().toString();
    }

    public final View m22310a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1159244239);
        this.f14747a = new PlaceContentPickerView(getContext());
        PlaceContentPickerView placeContentPickerView = this.f14747a;
        Optional aq = aq();
        if (placeContentPickerView.f14822c.isPresent()) {
            placeContentPickerView.f14826g.removeAllViews();
        }
        placeContentPickerView.f14822c = aq;
        if (placeContentPickerView.f14822c.isPresent()) {
            placeContentPickerView.f14826g.addView((View) placeContentPickerView.f14822c.get());
        }
        placeContentPickerView = this.f14747a;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1101696518, a);
        return placeContentPickerView;
    }

    public final void m22312a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        PlaceContentPickerView placeContentPickerView = this.f14747a;
        placeContentPickerView.f14820a.setHint(mo1172e());
        this.f14747a.f14828i = Optional.of(new C09561(this));
        this.f14747a.f14827h = Optional.of(new C09572(this));
        this.f14747a.f14825f.setOnScrollListener((OnScrollListener) Optional.of(new C09583(this)).orNull());
    }

    public void mo1163G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1375061364);
        super.G();
        at();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 914898156, a);
    }

    public void mo1164H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1771478760);
        super.H();
        KeyboardUtils.a(ao());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2031878343, a);
    }
}
