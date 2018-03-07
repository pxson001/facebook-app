package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.executors.FbAsyncTask;
import com.facebook.debug.asserts.Assert;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListActivity.ProfileListAdapter;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: ufi_see_more */
public class ProfileListDynamicAdapter extends ProfileListAdapter {
    protected final Context f1256c;
    public final LayoutInflater f1257d;
    public List<? extends FacebookProfile> f1258e;
    protected FbAsyncTask<List<? extends FacebookProfile>, Integer, List<? extends FacebookProfile>> f1259f;

    /* compiled from: ufi_see_more */
    class SortProfilesTask extends FbAsyncTask<List<? extends FacebookProfile>, Integer, List<? extends FacebookProfile>> {
        final /* synthetic */ ProfileListDynamicAdapter f1269a;

        /* compiled from: ufi_see_more */
        class C01231 implements Comparator<FacebookProfile> {
            final /* synthetic */ SortProfilesTask f1268a;

            C01231(SortProfilesTask sortProfilesTask) {
                this.f1268a = sortProfilesTask;
            }

            public int compare(Object obj, Object obj2) {
                return ((FacebookProfile) obj).mDisplayName.compareTo(((FacebookProfile) obj2).mDisplayName);
            }
        }

        public SortProfilesTask(ProfileListDynamicAdapter profileListDynamicAdapter) {
            this.f1269a = profileListDynamicAdapter;
        }

        protected final Object m1509a(Object[] objArr) {
            List[] listArr = (List[]) objArr;
            Assert.a(1, listArr.length);
            Comparator c01231 = new C01231(this);
            List arrayList = new ArrayList(listArr[0]);
            Collections.sort(arrayList, c01231);
            return arrayList;
        }

        protected void onPostExecute(Object obj) {
            this.f1269a.f1258e = (List) obj;
            AdapterDetour.a(this.f1269a, 1852198178);
        }
    }

    public ProfileListDynamicAdapter(Context context) {
        this.f1256c = context;
        this.f1257d = LayoutInflater.from(context);
    }

    public void mo62a(List<? extends FacebookProfile> list) {
        this.f1259f = new SortProfilesTask(this);
        this.f1259f.a(this.f1256c, new List[]{list});
    }

    public final int m1504c() {
        return 1;
    }

    public final int m1505c(int i) {
        Assert.a(0, i);
        return this.f1258e.size();
    }

    public final Object m1501b(int i) {
        return null;
    }

    public final Object m1499a(int i, int i2) {
        Assert.a(0, i);
        return this.f1258e.get(i2);
    }

    public final View m1498a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return new View(this.f1256c);
        }
        return view;
    }

    public View mo61a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        FacebookProfile facebookProfile = (FacebookProfile) m1499a(i, i2);
        if (view == null) {
            view = this.f1257d.inflate(2130906451, null);
        }
        ContentView contentView = (ContentView) view.findViewById(2131559680);
        String str = facebookProfile.mImageUrl;
        contentView.setThumbnailUri(str == null ? null : Uri.parse(str));
        contentView.setTitleText(facebookProfile.mDisplayName);
        return view;
    }

    public final boolean m1503b(int i, int i2) {
        return true;
    }

    public final boolean m1502b() {
        return this.f1258e == null || this.f1258e.size() == 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public final int m1496a(int i) {
        return 0;
    }

    public final int m1506c(int i, int i2) {
        return 1;
    }
}
