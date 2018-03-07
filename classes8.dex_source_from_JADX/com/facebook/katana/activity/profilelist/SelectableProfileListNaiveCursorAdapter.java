package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.qe.api.QeAccessor;
import com.facebook.user.names.Normalizer;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.Set;
import javax.annotation.Nonnull;

/* compiled from: unfinished_tracker_info */
public class SelectableProfileListNaiveCursorAdapter extends ProfileListNaiveCursorAdapter {
    public CheckBoxViewAdapter<Long> f1216c;
    @Nonnull
    public ImmutableSet<Long> f1217k = RegularImmutableSet.a;

    public SelectableProfileListNaiveCursorAdapter(Context context, Cursor cursor, Set<Long> set, Normalizer normalizer, QeAccessor qeAccessor, @Nonnull ImmutableSet<Long> immutableSet) {
        super(context, cursor, normalizer, qeAccessor);
        this.f1216c = new CheckBoxViewAdapter(set);
        this.f1217k = immutableSet;
    }

    public View mo59a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View a = super.mo59a(i, i2, z, view, viewGroup);
        FacebookProfile facebookProfile = (FacebookProfile) m1460a(i, i2);
        CheckBoxViewAdapter checkBoxViewAdapter = this.f1216c;
        ((CheckBox) a.findViewById(2131560310)).setChecked(checkBoxViewAdapter.f1187a.contains(Long.valueOf(facebookProfile.mId)));
        if (this.f1217k.contains(Long.valueOf(facebookProfile.mId))) {
            a.setAlpha(0.5f);
        } else {
            a.setAlpha(1.0f);
        }
        return a;
    }

    protected final View mo60a(FacebookProfile facebookProfile) {
        View a = super.mo60a(facebookProfile);
        ((ViewStub) a.findViewById(2131566374)).inflate();
        return a;
    }
}
