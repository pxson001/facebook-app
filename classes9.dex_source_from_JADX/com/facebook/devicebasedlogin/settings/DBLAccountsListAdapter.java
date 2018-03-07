package com.facebook.devicebasedlogin.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.auth.credentials.DBLFacebookCredentials;
import com.facebook.devicebasedlogin.ui.DBLProfilePhotoView;
import com.facebook.inject.InjectorLike;
import com.facebook.katana.dbl.DBLStorageAndRetrievalHelper;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: The program has been released */
public class DBLAccountsListAdapter extends BaseAdapter {
    private Context f24173a;
    private List<DBLFacebookCredentials> f24174b = Lists.a();
    private DBLStorageAndRetrievalHelper f24175c;
    public int f24176d;

    public static DBLAccountsListAdapter m26138b(InjectorLike injectorLike) {
        return new DBLAccountsListAdapter((Context) injectorLike.getInstance(Context.class), DBLStorageAndRetrievalHelper.b(injectorLike));
    }

    @Inject
    public DBLAccountsListAdapter(Context context, DBLStorageAndRetrievalHelper dBLStorageAndRetrievalHelper) {
        this.f24173a = context;
        this.f24175c = dBLStorageAndRetrievalHelper;
    }

    public int getCount() {
        return this.f24174b.size();
    }

    public Object getItem(int i) {
        return this.f24174b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f24173a).inflate(this.f24176d, null);
        }
        DBLFacebookCredentials dBLFacebookCredentials = (DBLFacebookCredentials) getItem(i);
        ((DBLProfilePhotoView) view.findViewById(2131560910)).setImage(dBLFacebookCredentials.mPicUrl);
        ((TextView) view.findViewById(2131560890)).setText(dBLFacebookCredentials.mName);
        return view;
    }

    public final boolean m26139a() {
        this.f24174b.clear();
        if (!this.f24175c.c().booleanValue()) {
            return false;
        }
        this.f24174b.addAll(this.f24175c.a());
        AdapterDetour.a(this, 1928306768);
        return true;
    }
}
