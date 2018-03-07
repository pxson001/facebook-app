package com.facebook.widget.tokenizedtypeahead.ui.listview;

import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ToggleButton;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.widget.listview.SectionedListSection;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadAdapter.ViewFactory;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadItemRow.C15161;
import com.facebook.widget.tokenizedtypeahead.ui.listview.TypeaheadItemRow.C15172;

/* compiled from: fb_creativeediting */
public class DefaultViewFactory implements ViewFactory {
    private final boolean f15184a;

    public DefaultViewFactory(boolean z) {
        this.f15184a = z;
    }

    public View mo1201a(ViewGroup viewGroup) {
        return this.f15184a ? new TypeaheadItemRow(viewGroup.getContext()).m28795a() : new TypeaheadItemRow(viewGroup.getContext());
    }

    public View mo1206b(ViewGroup viewGroup) {
        return new TypeaheadSubtitledItemRow(viewGroup.getContext());
    }

    public View mo1208c(ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        return this.f15184a ? from.inflate(2130907582, viewGroup, false) : from.inflate(2130907581, viewGroup, false);
    }

    public View mo1209d(ViewGroup viewGroup) {
        if (!this.f15184a) {
            return new TypeaheadHeaderRow(viewGroup.getContext());
        }
        TypeaheadHeaderRow typeaheadHeaderRow = new TypeaheadHeaderRow(viewGroup.getContext());
        typeaheadHeaderRow.findViewById(2131560055).setVisibility(8);
        typeaheadHeaderRow.findViewById(2131560955).setVisibility(0);
        return typeaheadHeaderRow;
    }

    public final View mo1210e(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130907580, viewGroup, false);
    }

    public void mo1204a(View view, SectionedListSection sectionedListSection) {
        TypeaheadHeaderRow typeaheadHeaderRow = (TypeaheadHeaderRow) view;
        typeaheadHeaderRow.f20137b.setText(sectionedListSection.mo432a());
        typeaheadHeaderRow.setVisibility(sectionedListSection.mo432a() != null ? 0 : 8);
    }

    public void mo1205a(View view, BaseToken baseToken, boolean z) {
        TypeaheadItemRow typeaheadItemRow = (TypeaheadItemRow) view;
        boolean z2 = true;
        if (baseToken.mo1195a()) {
            typeaheadItemRow.f20149h.setVisibility(8);
            typeaheadItemRow.setEnabled(true);
        } else {
            typeaheadItemRow.f20149h.setVisibility(0);
            typeaheadItemRow.setEnabled(false);
        }
        typeaheadItemRow.f20143b.setText(baseToken.mo1185b());
        if (baseToken.mo1524k()) {
            ToggleButton toggleButton = typeaheadItemRow.f20146e;
            if (!z && baseToken.mo1195a()) {
                z2 = false;
            }
            toggleButton.setChecked(z2);
        } else {
            typeaheadItemRow.f20146e.setVisibility(8);
        }
        if (baseToken.m22639q()) {
            typeaheadItemRow.f20147f.setVisibility(0);
            typeaheadItemRow.f20147f.setOnClickListener(new C15161(typeaheadItemRow, baseToken));
        }
        typeaheadItemRow.f20148g.setOnClickListener(new C15172(typeaheadItemRow, baseToken));
        if (StringUtil.a(baseToken.mo1185b())) {
            typeaheadItemRow.f20148g.setVisibility(0);
            typeaheadItemRow.f20147f.setVisibility(8);
        } else {
            typeaheadItemRow.f20148g.setVisibility(8);
            if (baseToken.m22639q()) {
                typeaheadItemRow.f20147f.setVisibility(0);
            }
        }
        if (baseToken.mo1188f() > 0) {
            typeaheadItemRow.f20144c.setImageDrawable(typeaheadItemRow.getResources().getDrawable(baseToken.mo1188f()));
            typeaheadItemRow.f20144c.setVisibility(0);
            typeaheadItemRow.f20145d.setVisibility(8);
        } else if (baseToken.mo1190h() > 0 || baseToken.mo1191i() == null) {
            if (baseToken.mo1190h() > 0) {
                typeaheadItemRow.f20144c.setImageResource(baseToken.mo1190h());
            } else {
                typeaheadItemRow.f20144c.setBackgroundDrawable(new BitmapDrawable(typeaheadItemRow.getResources(), baseToken.m22648j()));
            }
            typeaheadItemRow.f20145d.setVisibility(8);
            typeaheadItemRow.f20144c.setVisibility(0);
        } else {
            typeaheadItemRow.f20145d.a(Uri.parse(baseToken.mo1191i()), TypeaheadItemRow.f20142a);
            typeaheadItemRow.f20145d.setVisibility(0);
            typeaheadItemRow.f20144c.setVisibility(8);
        }
        if (baseToken.mo1189g() > 0 && typeaheadItemRow.f20144c.getVisibility() == 0) {
            typeaheadItemRow.f20144c.setGlyphColor(typeaheadItemRow.getResources().getColor(baseToken.mo1189g()));
        }
        if (baseToken.f15080a == Type.TAG_EXPANSION) {
            typeaheadItemRow.setTag("TAG_EXPANSION_VIEW");
        } else {
            typeaheadItemRow.setTag("");
        }
    }

    public void mo1207b(View view, BaseToken baseToken, boolean z) {
        TypeaheadSubtitledItemRow typeaheadSubtitledItemRow = (TypeaheadSubtitledItemRow) view;
        typeaheadSubtitledItemRow.f20151b.setText(baseToken.mo1185b());
        typeaheadSubtitledItemRow.f20152c.setText(baseToken.mo1192l());
        if (baseToken.mo1524k()) {
            ToggleButton toggleButton = typeaheadSubtitledItemRow.f20154e;
            boolean z2 = z || !baseToken.mo1195a();
            toggleButton.setChecked(z2);
        } else {
            typeaheadSubtitledItemRow.f20154e.setVisibility(8);
        }
        if (baseToken.mo1188f() > 0) {
            typeaheadSubtitledItemRow.f20153d.setImageDrawable(typeaheadSubtitledItemRow.getResources().getDrawable(baseToken.mo1188f()));
            typeaheadSubtitledItemRow.f20153d.setVisibility(0);
            typeaheadSubtitledItemRow.f20155f.setVisibility(8);
        } else if (baseToken.mo1190h() > 0 || baseToken.mo1191i() == null) {
            if (baseToken.mo1190h() > 0) {
                typeaheadSubtitledItemRow.f20153d.setImageResource(baseToken.mo1190h());
            } else {
                typeaheadSubtitledItemRow.f20153d.setBackgroundDrawable(new BitmapDrawable(typeaheadSubtitledItemRow.getResources(), baseToken.m22648j()));
            }
            typeaheadSubtitledItemRow.f20153d.setVisibility(0);
            typeaheadSubtitledItemRow.f20155f.setVisibility(8);
        } else {
            typeaheadSubtitledItemRow.f20155f.a(Uri.parse(baseToken.mo1191i()), TypeaheadSubtitledItemRow.f20150a);
            typeaheadSubtitledItemRow.f20155f.setVisibility(0);
            typeaheadSubtitledItemRow.f20153d.setVisibility(8);
        }
        if (baseToken.mo1189g() > 0 && typeaheadSubtitledItemRow.f20153d.getVisibility() == 0) {
            typeaheadSubtitledItemRow.f20153d.setGlyphColor(typeaheadSubtitledItemRow.getResources().getColor(baseToken.mo1189g()));
        }
    }

    public final void mo1203a(View view, OnClickListener onClickListener) {
        if ((view instanceof TypeaheadItemRow) || (view instanceof TypeaheadHeaderRow)) {
            throw new ClassCastException("Cannot convert an item row to a view more row");
        }
        view.setOnClickListener(onClickListener);
    }

    public final TriState mo1202a() {
        return TriState.UNSET;
    }
}
