package com.facebook.places.create.privacypicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ToggleButton;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.ui.PrivacyIcons;
import com.facebook.privacy.ui.PrivacyIcons.Size;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: caption_description_small_style */
public class PrivacyPickerAdapter extends BaseAdapter {
    private LayoutInflater f18407a;
    private PrivacyIcons f18408b;
    private List<PrivacyPickerRowData> f18409c = Lists.a();

    public /* synthetic */ Object getItem(int i) {
        return m22344a(i);
    }

    @Inject
    public PrivacyPickerAdapter(LayoutInflater layoutInflater, PrivacyIcons privacyIcons) {
        this.f18407a = layoutInflater;
        this.f18408b = privacyIcons;
    }

    public int getCount() {
        return this.f18409c.size();
    }

    private PrivacyPickerRowData m22344a(int i) {
        return (PrivacyPickerRowData) this.f18409c.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f18407a.inflate(2130906399, viewGroup, false);
        }
        PrivacyPickerRowData a = m22344a(i);
        ContentView contentView = (ContentView) view.findViewById(2131566277);
        contentView.setTitleText(a.f18410a.d());
        contentView.setThumbnailSize(ThumbnailSize.MEDIUM);
        contentView.setThumbnailResource(this.f18408b.a(PrivacyOptionHelper.a(a.f18410a), Size.LIST));
        if (a.f18410a.j() != null) {
            contentView.setSubtitleText(a.f18410a.j());
        }
        ((ToggleButton) view.findViewById(2131560317)).setChecked(a.f18411b);
        return view;
    }

    public final void m22345a(List<PrivacyPickerRowData> list) {
        this.f18409c = ImmutableList.copyOf(list);
        AdapterDetour.a(this, 1072490143);
    }
}
