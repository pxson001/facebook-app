package com.facebook.friending.profileshare;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.inject.Assisted;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: addAdminsDialog */
public class ProfileShareAdapter extends Adapter<ViewHolder> {
    private final List<ProfileShareItem> f20246a = new ArrayList();
    @Nullable
    public OnClickListener f20247b;
    private final AllCapsTransformationMethod f20248c;
    private final Resources f20249d;
    private final boolean f20250e;

    /* compiled from: addAdminsDialog */
    public class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: addAdminsDialog */
    public class PopupViewHolder extends ViewHolder {
        public TextView f20244l;

        public PopupViewHolder(View view) {
            super(view);
            this.f20244l = (TextView) view.findViewById(2131566407);
        }

        public void mo901a(int i, Object obj) {
            this.a.setTag(i, obj);
        }
    }

    /* compiled from: addAdminsDialog */
    public class ImmersiveViewHolder extends PopupViewHolder {
        private Button f20245l;

        public ImmersiveViewHolder(View view) {
            super(view);
            this.f20245l = (Button) view.findViewById(2131566408);
        }

        public final void mo901a(int i, Object obj) {
            super.mo901a(i, obj);
            this.f20245l.setTag(i, obj);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: addAdminsDialog */
    public @interface ViewType {
    }

    @Inject
    public ProfileShareAdapter(AllCapsTransformationMethod allCapsTransformationMethod, Resources resources, @Assisted boolean z) {
        this.f20250e = z;
        this.f20248c = allCapsTransformationMethod;
        this.f20249d = resources;
    }

    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public final ViewHolder m20535a(ViewGroup viewGroup, int i) {
        View inflate;
        if (!this.f20250e) {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906480, viewGroup, false);
            inflate.setOnClickListener(this.f20247b);
            return new PopupViewHolder(inflate);
        } else if (i == 0) {
            return new HeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906478, viewGroup, false));
        } else {
            inflate = LayoutInflater.from(viewGroup.getContext()).inflate(2130906479, viewGroup, false);
            inflate.setOnClickListener(this.f20247b);
            Button button = (Button) inflate.findViewById(2131566408);
            button.setText(this.f20248c.getTransformation(this.f20249d.getString(2131241364), null));
            button.setOnClickListener(this.f20247b);
            return new ImmersiveViewHolder(inflate);
        }
    }

    public final void m20536a(ViewHolder viewHolder, int i) {
        if (i != 0) {
            ProfileShareItem profileShareItem = (ProfileShareItem) this.f20246a.get(i - 1);
            if (viewHolder instanceof PopupViewHolder) {
                PopupViewHolder popupViewHolder = (PopupViewHolder) viewHolder;
                popupViewHolder.f20244l.setText(profileShareItem.f20277a);
                popupViewHolder = (PopupViewHolder) viewHolder;
                ((ImageBlockLayout) popupViewHolder.a).setThumbnailDrawable(profileShareItem.f20278b);
                ((PopupViewHolder) viewHolder).mo901a(2131558805, profileShareItem);
            }
        }
    }

    public final int aZ_() {
        return this.f20246a.size() + 1;
    }

    public final void m20537a(List<ProfileShareItem> list) {
        this.f20246a.addAll(list);
        notifyDataSetChanged();
    }
}
