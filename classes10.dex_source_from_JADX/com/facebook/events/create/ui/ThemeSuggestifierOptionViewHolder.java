package com.facebook.events.create.ui;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.FbImageView;
import javax.annotation.Nullable;

/* compiled from: contact_picker */
public class ThemeSuggestifierOptionViewHolder extends ViewHolder {
    private FbDraweeView f16424l;
    private FbTextView f16425m;
    private FbImageView f16426n;
    private OnClickListener f16427o = new C22901(this);
    public OnOptionSelectedListener f16428p;
    public int f16429q;

    /* compiled from: contact_picker */
    public interface OnOptionSelectedListener {
        void mo777a(int i);
    }

    /* compiled from: contact_picker */
    class C22901 implements OnClickListener {
        final /* synthetic */ ThemeSuggestifierOptionViewHolder f16423a;

        C22901(ThemeSuggestifierOptionViewHolder themeSuggestifierOptionViewHolder) {
            this.f16423a = themeSuggestifierOptionViewHolder;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1926785065);
            if (this.f16423a.f16428p != null) {
                this.f16423a.f16428p.mo777a(this.f16423a.f16429q);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -393125660, a);
        }
    }

    public ThemeSuggestifierOptionViewHolder(View view) {
        super(view);
        this.f16424l = (FbDraweeView) view.findViewById(2131560816);
        this.f16425m = (FbTextView) view.findViewById(2131560818);
        this.f16426n = (FbImageView) view.findViewById(2131560819);
    }

    public final void m16877a(String str, @Nullable Drawable drawable, Drawable drawable2, OnOptionSelectedListener onOptionSelectedListener, int i) {
        this.f16425m.setText(str);
        if (drawable != null) {
            this.f16424l.setImageDrawable(drawable);
        }
        this.f16424l.setOnClickListener(this.f16427o);
        this.f16426n.setImageDrawable(drawable2);
        this.f16428p = onOptionSelectedListener;
        this.f16429q = i;
    }
}
