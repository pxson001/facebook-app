package com.facebook.platform.composer.targetprivacy;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.provider.ContactsConnectionsContract;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter;
import com.facebook.katana.activity.profilelist.ProfileListNaiveCursorAdapter.FriendsQuery;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.names.NameNormalizer;
import javax.annotation.Nullable;

/* compiled from: results_module_index */
public class PlatformComposerFriendsSelectorAdapter extends ProfileListNaiveCursorAdapter {
    private static final CallerContext f4319k = CallerContext.a(PlatformGroupSelectorAdapter.class);
    public final Filter f4320c;

    public PlatformComposerFriendsSelectorAdapter(final Context context, @Nullable Cursor cursor, NameNormalizer nameNormalizer, QeAccessor qeAccessor) {
        super(context, cursor, nameNormalizer, qeAccessor);
        this.f4320c = new Filter(this) {
            final /* synthetic */ PlatformComposerFriendsSelectorAdapter f4318b;

            protected FilterResults performFiltering(CharSequence charSequence) {
                if (charSequence == null) {
                    return null;
                }
                Cursor query;
                if (charSequence.length() > 0) {
                    query = context.getApplicationContext().getContentResolver().query(Uri.withAppendedPath(ContactsConnectionsContract.i, charSequence.toString()), FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
                } else {
                    query = context.getApplicationContext().getContentResolver().query(ContactsConnectionsContract.g, FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
                }
                if (query == null) {
                    return null;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.count = query.getCount();
                filterResults.values = query;
                return filterResults;
            }

            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (!(filterResults == null || filterResults.values == null)) {
                    this.f4318b.mo57a((Cursor) filterResults.values);
                }
                AdapterDetour.a(this.f4318b, -328103105);
            }
        };
    }

    public final View mo201a(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            return new View(this.f1209f);
        }
        return view;
    }

    public final View mo59a(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        FacebookProfile facebookProfile = (FacebookProfile) m1460a(i, i2);
        if (view == null) {
            view = this.f1210g.inflate(2130906313, null);
        }
        FbDraweeView fbDraweeView = (FbDraweeView) view.findViewById(2131561876);
        FbTextView fbTextView = (FbTextView) view.findViewById(2131566124);
        if (StringUtil.a(new CharSequence[]{facebookProfile.mImageUrl})) {
            fbDraweeView.a(null, f4319k);
        } else {
            fbDraweeView.a(Uri.parse(facebookProfile.mImageUrl), f4319k);
        }
        fbTextView.setText(facebookProfile.mDisplayName);
        return view;
    }
}
