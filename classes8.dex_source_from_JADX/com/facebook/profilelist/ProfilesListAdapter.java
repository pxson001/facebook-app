package com.facebook.profilelist;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.user.names.NameNormalizer;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: reload_unit_tap */
public class ProfilesListAdapter extends BaseAdapter {
    public final NameNormalizer f4578a;
    public final LayoutInflater f4579b;
    public final List<Item> f4580c = Lists.a();
    public final Context f4581d;
    public Set<FacebookProfile> f4582e;
    public boolean f4583f;

    /* compiled from: reload_unit_tap */
    interface Item {
        View mo215a();

        void mo216a(View view);
    }

    /* compiled from: reload_unit_tap */
    public class Header implements Item {
        final /* synthetic */ ProfilesListAdapter f4574a;
        private final String f4575b;

        public Header(ProfilesListAdapter profilesListAdapter, String str) {
            this.f4574a = profilesListAdapter;
            this.f4575b = str;
        }

        public final void mo216a(View view) {
            ((TextView) view).setText(this.f4575b);
        }

        public final View mo215a() {
            return this.f4574a.f4579b.inflate(2130906444, null);
        }
    }

    /* compiled from: reload_unit_tap */
    public class Profile implements Item {
        final /* synthetic */ ProfilesListAdapter f4576a;
        public final FacebookProfile f4577b;

        public Profile(ProfilesListAdapter profilesListAdapter, FacebookProfile facebookProfile) {
            this.f4576a = profilesListAdapter;
            this.f4577b = facebookProfile;
        }

        public final void mo216a(View view) {
            ProfileView profileView = (ProfileView) view;
            profileView.f4564c.a(Uri.parse(this.f4577b.mImageUrl), ProfileView.f4562a);
            profileView.f4563b.setText(this.f4577b.mDisplayName);
            profileView.setIsSelected(this.f4576a.f4582e.contains(this.f4577b));
        }

        public final View mo215a() {
            return new ProfileView(this.f4576a.f4581d);
        }
    }

    @Inject
    public ProfilesListAdapter(LayoutInflater layoutInflater, NameNormalizer nameNormalizer, Context context) {
        this.f4579b = layoutInflater;
        this.f4578a = nameNormalizer;
        this.f4581d = context;
    }

    public int getCount() {
        return this.f4580c.size();
    }

    public Object getItem(int i) {
        return this.f4580c.get(i);
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Item item = (Item) this.f4580c.get(i);
        if (view == null) {
            view = item.mo215a();
        }
        item.mo216a(view);
        return view;
    }

    public int getItemViewType(int i) {
        return this.f4580c.get(i) instanceof Header ? 1 : 0;
    }

    public int getViewTypeCount() {
        return 2;
    }

    public final void m4439a(View view, int i) {
        if (view instanceof ProfileView) {
            boolean z;
            FacebookProfile facebookProfile = ((Profile) getItem(i)).f4577b;
            ProfileView profileView = (ProfileView) view;
            if (profileView.f4565d.isChecked()) {
                z = false;
            } else {
                z = true;
            }
            profileView.setIsSelected(z);
            if (z) {
                this.f4582e.add(facebookProfile);
            } else {
                this.f4582e.remove(facebookProfile);
            }
        }
    }

    public static String m4438b(FacebookProfile facebookProfile) {
        String str = facebookProfile.mDisplayName;
        return str.substring(0, str.offsetByCodePoints(0, 1));
    }
}
