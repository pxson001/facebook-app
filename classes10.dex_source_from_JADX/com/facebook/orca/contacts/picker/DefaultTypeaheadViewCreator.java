package com.facebook.orca.contacts.picker;

import android.support.v7.internal.widget.ViewStubCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.orca.contacts.picker.ContactPickerFragment.TypeaheadViewCreator;
import com.facebook.widget.ViewStubHolder;

/* compiled from: num_threads_fetched */
public class DefaultTypeaheadViewCreator implements TypeaheadViewCreator {
    public TextView f6086a;
    public ViewStubHolder<GlyphView> f6087b;

    public final View mo226a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(2130907522, viewGroup, false);
        this.f6086a = (TextView) inflate.findViewById(2131568065);
        this.f6087b = ViewStubHolder.a((ViewStubCompat) inflate.findViewById(2131568064));
        return inflate;
    }
}
