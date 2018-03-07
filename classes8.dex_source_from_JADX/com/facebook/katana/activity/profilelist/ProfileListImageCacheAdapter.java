package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListCursorAdapter.Section;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: unfollow_time */
public abstract class ProfileListImageCacheAdapter extends ProfileListCursorAdapter {
    protected final Context f1209f;
    protected final LayoutInflater f1210g;

    protected abstract String mo56a(Object obj);

    protected abstract Object mo58b(Cursor cursor);

    public ProfileListImageCacheAdapter(Context context, @Nullable Cursor cursor) {
        this.f1209f = context;
        this.f1210g = LayoutInflater.from(context);
        mo57a(cursor);
    }

    public View mo201a(int i, View view, ViewGroup viewGroup) {
        View inflate;
        if (view == null) {
            inflate = this.f1210g.inflate(2130904588, null);
        } else {
            inflate = view;
        }
        ((TextView) inflate).setText(((Section) this.f1208e.get(i)).f1265a);
        return inflate;
    }

    public View mo59a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        FacebookProfile facebookProfile = (FacebookProfile) a(i, i2);
        if (view == null) {
            view = mo60a(facebookProfile);
        }
        ContentView contentView = (ContentView) view.findViewById(2131559680);
        String str = facebookProfile.mImageUrl;
        contentView.setThumbnailUri(str == null ? null : Uri.parse(str));
        contentView.setTitleText(facebookProfile.mDisplayName);
        contentView.setContentDescription(facebookProfile.mDisplayName);
        return view;
    }

    protected View mo60a(FacebookProfile facebookProfile) {
        return this.f1210g.inflate(2130906451, null);
    }

    public void mo57a(@Nullable Cursor cursor) {
        this.d = cursor;
        this.e = new ArrayList();
        if (cursor != null) {
            Object obj = null;
            int i = -1;
            int count = cursor.getCount();
            cursor.moveToFirst();
            int i2 = 0;
            int i3 = 0;
            while (i2 < count) {
                Object b = mo58b(cursor);
                if (b.equals(obj)) {
                    b = obj;
                } else {
                    if (i3 > 0) {
                        this.f1208e.add(new Section(mo56a(obj), i, i3));
                    }
                    i3 = 0;
                    i = i2;
                }
                i2++;
                i3++;
                cursor.moveToNext();
                obj = b;
            }
            if (i3 > 0) {
                this.f1208e.add(new Section(mo56a(obj), i, i3));
            }
            AdapterDetour.a(this, -1047645084);
        }
    }
}
