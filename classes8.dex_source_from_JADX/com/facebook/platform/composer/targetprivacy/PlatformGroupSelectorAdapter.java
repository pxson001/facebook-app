package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListDynamicAdapter;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: result_role */
public class PlatformGroupSelectorAdapter extends ProfileListDynamicAdapter implements Filterable {
    private static final CallerContext f4402g = CallerContext.a(PlatformGroupSelectorAdapter.class);
    public String f4403h;
    public List<? extends FacebookProfile> f4404i;
    private final GroupFilter f4405j = new GroupFilter(this);

    /* compiled from: result_role */
    class GroupFilter extends Filter {
        final /* synthetic */ PlatformGroupSelectorAdapter f4401a;

        public GroupFilter(PlatformGroupSelectorAdapter platformGroupSelectorAdapter) {
            this.f4401a = platformGroupSelectorAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                filterResults.count = this.f4401a.f4404i.size();
                filterResults.values = this.f4401a.f4404i;
                this.f4401a.f4403h = null;
            } else {
                List arrayList = new ArrayList();
                CharSequence toLowerCase = charSequence.toString().trim().toLowerCase(Locale.ROOT);
                for (FacebookProfile facebookProfile : this.f4401a.f4404i) {
                    if (facebookProfile.mDisplayName.toLowerCase(Locale.ROOT).contains(toLowerCase)) {
                        arrayList.add(facebookProfile);
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
                this.f4401a.f4403h = charSequence.toString();
            }
            return filterResults;
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.values != null) {
                this.f4401a.f1258e = (List) filterResults.values;
                AdapterDetour.a(this.f4401a, 1886571529);
            }
        }
    }

    public Filter getFilter() {
        return this.f4405j;
    }

    public PlatformGroupSelectorAdapter(Context context) {
        super(context);
    }

    public final void mo62a(List<? extends FacebookProfile> list) {
        this.f4404i = list;
        this.f4405j.filter(this.f4403h);
        AdapterDetour.a(this, 1179201665);
    }

    public final View mo61a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        FacebookProfile facebookProfile = (FacebookProfile) m1499a(i, i2);
        if (view == null) {
            view = this.f1257d.inflate(2130906313, null);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131561876);
        FbTextView fbTextView = (FbTextView) view.findViewById(2131566124);
        if (StringUtil.a(new CharSequence[]{facebookProfile.mImageUrl})) {
            fbDraweeView.a(null, f4402g);
        } else {
            fbDraweeView.a(Uri.parse(facebookProfile.mImageUrl), f4402g);
        }
        fbTextView.setText(facebookProfile.mDisplayName);
        return view;
    }
}
