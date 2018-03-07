package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: uncheck_deeplink_box */
public class GroupSelectorAdapter extends ProfileListDynamicAdapter implements Filterable {
    public String f1260g;
    public List<? extends FacebookProfile> f1261h;
    private GroupFilter f1262i = new GroupFilter(this);

    /* compiled from: uncheck_deeplink_box */
    class GroupFilter extends Filter {
        final /* synthetic */ GroupSelectorAdapter f1255a;

        public GroupFilter(GroupSelectorAdapter groupSelectorAdapter) {
            this.f1255a = groupSelectorAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.count = this.f1255a.f1261h.size();
                filterResults.values = this.f1255a.f1261h;
                this.f1255a.f1260g = null;
            } else {
                List a = Lists.a();
                CharSequence toLowerCase = charSequence.toString().trim().toLowerCase();
                for (FacebookProfile facebookProfile : this.f1255a.f1261h) {
                    if (facebookProfile.mDisplayName.toLowerCase().contains(toLowerCase)) {
                        a.add(facebookProfile);
                    }
                }
                filterResults.count = a.size();
                filterResults.values = a;
                this.f1255a.f1260g = charSequence.toString();
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.values != null) {
                this.f1255a.e = (List) filterResults.values;
                AdapterDetour.a(this.f1255a, -1083996065);
            }
        }
    }

    public Filter getFilter() {
        return this.f1262i;
    }

    public GroupSelectorAdapter(Context context) {
        super(context);
    }

    public final void mo62a(List<? extends FacebookProfile> list) {
        this.f1261h = list;
        this.f1262i.filter(this.f1260g);
        AdapterDetour.a(this, -1781078815);
    }

    public final View mo61a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        Uri uri = null;
        FacebookProfile facebookProfile = (FacebookProfile) m1499a(i, i2);
        if (view == null) {
            view = this.f1257d.inflate(2130906451, null);
        }
        ContentView contentView = (ContentView) view.findViewById(2131559680);
        String str = facebookProfile.mImageUrl;
        if (str != null) {
            uri = Uri.parse(str);
        }
        contentView.setThumbnailUri(uri);
        contentView.setTitleText(facebookProfile.mDisplayName);
        contentView.setContentDescription(facebookProfile.mDisplayName);
        return view;
    }
}
