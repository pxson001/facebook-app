package com.facebook.backstage.consumption.reply;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Preconditions;
import java.util.ArrayList;

/* compiled from: ride_request_create */
public class BackstagePopupReplyWindowAdapter extends BaseAdapter implements ListAdapter {
    ArrayList<RowItem> f4864a = new ArrayList();

    /* compiled from: ride_request_create */
    class RowItem {
        final /* synthetic */ BackstagePopupReplyWindowAdapter f4860a;
        public final OnClickListener f4861b;
        public final int f4862c;
        public final int f4863d;

        public RowItem(BackstagePopupReplyWindowAdapter backstagePopupReplyWindowAdapter, int i, int i2, OnClickListener onClickListener) {
            this.f4860a = backstagePopupReplyWindowAdapter;
            this.f4862c = i;
            this.f4863d = i2;
            this.f4861b = onClickListener;
        }
    }

    public BackstagePopupReplyWindowAdapter(OnClickListener onClickListener, OnClickListener onClickListener2) {
        this.f4864a.add(new RowItem(this, 2131239890, 2130840127, onClickListener));
        this.f4864a.add(new RowItem(this, 2131239891, 2130839749, onClickListener2));
    }

    public int getCount() {
        return 2;
    }

    public Object getItem(int i) {
        return this.f4864a.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view != null) {
            m4743a(view, (RowItem) this.f4864a.get(i));
            return view;
        }
        view = LayoutInflater.from(viewGroup.getContext()).inflate(2130906819, viewGroup, false);
        m4743a(view, (RowItem) this.f4864a.get(i));
        return view;
    }

    private static void m4743a(View view, RowItem rowItem) {
        FbTextView fbTextView = (FbTextView) view.findViewById(2131566939);
        Drawable drawable = fbTextView.getResources().getDrawable(rowItem.f4863d);
        Preconditions.checkArgument(drawable != null);
        drawable.setColorFilter(fbTextView.getResources().getColor(17170443), Mode.SRC_ATOP);
        drawable.setBounds(0, 0, fbTextView.getHeight(), fbTextView.getHeight());
        fbTextView.setCompoundDrawablePadding(fbTextView.getResources().getDimensionPixelSize(2131433233));
        fbTextView.setCompoundDrawables(drawable, null, null, null);
        fbTextView.setText(fbTextView.getResources().getString(rowItem.f4862c));
        fbTextView.setOnClickListener(rowItem.f4861b);
    }
}
