package com.facebook.transliteration.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.resources.ui.FbTextView;
import java.util.List;

/* compiled from: event_metadata */
public class CharacterMappingGridAdapter extends BaseAdapter {
    private final List<CharacterMapItem> f15187a;
    private final Context f15188b;

    /* compiled from: event_metadata */
    class CharacterGridViewHolder {
        FbTextView f15184a;
        FbTextView f15185b;
        int f15186c;
    }

    public /* synthetic */ Object getItem(int i) {
        return m19192a(i);
    }

    public CharacterMappingGridAdapter(Context context, List<CharacterMapItem> list) {
        this.f15187a = list;
        this.f15188b = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        CharacterGridViewHolder characterGridViewHolder;
        if (view == null) {
            view = ((LayoutInflater) this.f15188b.getSystemService("layout_inflater")).inflate(2130903551, viewGroup, false);
            CharacterGridViewHolder characterGridViewHolder2 = new CharacterGridViewHolder();
            characterGridViewHolder2.f15186c = i;
            characterGridViewHolder2.f15184a = (FbTextView) view.findViewById(2131560292);
            characterGridViewHolder2.f15185b = (FbTextView) view.findViewById(2131560293);
            view.setTag(characterGridViewHolder2);
            characterGridViewHolder = characterGridViewHolder2;
        } else {
            characterGridViewHolder = (CharacterGridViewHolder) view.getTag();
        }
        CharacterMapItem a = m19192a(i);
        characterGridViewHolder.f15184a.setText(a.f15182a);
        characterGridViewHolder.f15185b.setText(a.f15183b);
        return view;
    }

    public int getCount() {
        return this.f15187a.size();
    }

    private CharacterMapItem m19192a(int i) {
        return (CharacterMapItem) this.f15187a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return true;
    }
}
