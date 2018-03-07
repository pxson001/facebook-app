package com.facebook.saved2.ui.itemadapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.widget.recyclerview.interleaved.Interleavable;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: incomingPings */
public class Saved2HeadersAdapter extends Adapter implements Interleavable {
    private static final int f9638a = 2130906936;
    private final Context f9639b;
    @Nullable
    public ArrayList<Header> f9640c;

    /* compiled from: incomingPings */
    public class Header {
        public final CharSequence f9634a;
        public final int f9635b;
        public int f9636c;

        public Header(CharSequence charSequence, int i, int i2) {
            this.f9634a = charSequence;
            this.f9635b = i;
            this.f9636c = i2;
        }
    }

    /* compiled from: incomingPings */
    class Saved2HeaderViewHolder extends ViewHolder {
        public final TextView f9637l;

        public Saved2HeaderViewHolder(View view) {
            super(view);
            this.f9637l = (TextView) view.findViewById(2131567205);
        }
    }

    public Saved2HeadersAdapter(Context context) {
        this.f9639b = context;
        a(true);
    }

    public int getItemViewType(int i) {
        return f9638a;
    }

    public final long H_(int i) {
        m9876e();
        return (long) ((Header) this.f9640c.get(i)).f9635b;
    }

    public final ViewHolder m9877a(ViewGroup viewGroup, int i) {
        return new Saved2HeaderViewHolder(LayoutInflater.from(this.f9639b).inflate(i, viewGroup, false));
    }

    public final void m9878a(ViewHolder viewHolder, int i) {
        m9876e();
        ((Saved2HeaderViewHolder) viewHolder).f9637l.setText(((Header) this.f9640c.get(i)).f9634a);
    }

    public final int aZ_() {
        return this.f9640c == null ? 0 : this.f9640c.size();
    }

    public final boolean mo451b(int i) {
        return m9875e(i) != null;
    }

    @Nullable
    private Header m9875e(int i) {
        m9876e();
        int size = this.f9640c.size();
        for (int i2 = 0; i2 < size; i2++) {
            Header header = (Header) this.f9640c.get(i2);
            if (header.f9636c == i) {
                return header;
            }
        }
        return null;
    }

    private void m9876e() {
        if (this.f9640c == null) {
            throw new IllegalStateException("Non-zero count reported when no headers were defined");
        }
    }
}
