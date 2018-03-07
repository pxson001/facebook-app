package com.facebook.widget.compositeadapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.base.Preconditions;

/* compiled from: extra_taggable_gallery_photo_item_id */
public class CompositeAdapter<ITEM_ACTION_TYPES extends Enum> extends FbBaseAdapter {
    public final Context f14283a;
    public final Controller<ITEM_ACTION_TYPES> f14284b;
    private final Model f14285c;
    public final Renderer f14286d;
    private final OnClickListener f14287e = new 1(this);
    private final OnLongClickListener f14288f = new 2(this);
    private final ItemListener<ITEM_ACTION_TYPES> f14289g = new 3(this);

    /* compiled from: extra_taggable_gallery_photo_item_id */
    public interface Controller<ITEM_ACTION_TYPES extends Enum> {
        void mo860a(Context context, Object obj);

        boolean mo861a();

        boolean mo862b();
    }

    /* compiled from: extra_taggable_gallery_photo_item_id */
    public interface Renderer {
        View mo864a(int i, ViewGroup viewGroup);

        void mo865a(Object obj, View view, int i, ViewGroup viewGroup);
    }

    /* compiled from: extra_taggable_gallery_photo_item_id */
    public interface Model {
        int mo873a();

        Object mo874a(int i);

        int mo875b();

        int mo876b(int i);
    }

    public CompositeAdapter(Context context, Model model, Renderer renderer, Controller<ITEM_ACTION_TYPES> controller) {
        this.f14283a = (Context) Preconditions.checkNotNull(context);
        this.f14285c = (Model) Preconditions.checkNotNull(model);
        this.f14286d = (Renderer) Preconditions.checkNotNull(renderer);
        this.f14284b = (Controller) Preconditions.checkNotNull(controller);
    }

    public final View m15891a(int i, ViewGroup viewGroup) {
        View a = this.f14286d.mo864a(i, viewGroup);
        if (this.f14284b.mo861a()) {
            a.setOnClickListener(this.f14287e);
        }
        if (this.f14284b.mo862b()) {
            a.setOnLongClickListener(this.f14288f);
        }
        return a;
    }

    public final void m15892a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        this.f14286d.mo865a(obj, view, i2, viewGroup);
        if (this.f14284b.mo861a() || this.f14284b.mo862b() || (view instanceof ItemView)) {
            view.setTag(2131558779, obj);
        }
    }

    public int getCount() {
        return this.f14285c.mo873a();
    }

    public Object getItem(int i) {
        return this.f14285c.mo874a(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public int getItemViewType(int i) {
        return this.f14285c.mo876b(i);
    }

    public int getViewTypeCount() {
        return this.f14285c.mo875b();
    }
}
