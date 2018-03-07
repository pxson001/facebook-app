package com.facebook.katana.activity.profilelist;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.common.util.StringLocaleUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.contacts.provider.ContactsConnectionsContract;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.katana.activity.profilelist.ProfileListCursorAdapter.Section;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.user.names.NameNormalizer;
import com.facebook.widget.tokenizedtypeahead.model.SimpleUserToken;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: unfinished_trackers */
public class ProfileListNaiveCursorAdapter extends ProfileListImageCacheAdapter {
    private final NameNormalizer f1211c;
    public final Filter f1212h;
    public ImmutableList<SimpleUserToken> f1213i;
    public ImmutableList<SimpleUserToken> f1214j;
    public QeAccessor f1215k;

    /* compiled from: unfinished_trackers */
    public interface FriendsQuery {
        public static final String[] f1275a = new String[]{"_id", "user_id", "display_name", "sort_name", "user_image_url"};
    }

    public ProfileListNaiveCursorAdapter(final Context context, @Nullable Cursor cursor, NameNormalizer nameNormalizer, QeAccessor qeAccessor) {
        super(context, cursor);
        this.f1211c = nameNormalizer;
        this.f1215k = qeAccessor;
        this.f1212h = new Filter(this) {
            final /* synthetic */ ProfileListNaiveCursorAdapter f1274b;

            /* compiled from: unfinished_trackers */
            class ValueHolder {
                @Nullable
                final Cursor f1270a;
                @Nullable
                final ImmutableList<SimpleUserToken> f1271b;
                final /* synthetic */ C01241 f1272c;

                public ValueHolder(C01241 c01241, @Nullable Cursor cursor, @Nullable ImmutableList<SimpleUserToken> immutableList) {
                    this.f1272c = c01241;
                    this.f1270a = cursor;
                    this.f1271b = immutableList;
                }
            }

            protected FilterResults performFiltering(CharSequence charSequence) {
                Cursor query;
                Builder builder;
                int count;
                ImmutableList immutableList = null;
                if (charSequence == null || charSequence.length() <= 0) {
                    query = context.getApplicationContext().getContentResolver().query(ContactsConnectionsContract.g, FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
                    if (this.f1274b.f1215k.a(ExperimentsForComposerAbTestModule.u, false)) {
                        builder = ImmutableList.builder();
                        builder.b(this.f1274b.f1213i);
                    } else {
                        builder = null;
                    }
                } else {
                    Builder builder2;
                    Cursor query2 = context.getApplicationContext().getContentResolver().query(Uri.withAppendedPath(ContactsConnectionsContract.i, charSequence.toString()), FriendsQuery.f1275a, "display_name IS NOT NULL AND LENGTH(display_name) > 0", null, null);
                    if (this.f1274b.f1215k.a(ExperimentsForComposerAbTestModule.u, false)) {
                        builder = ImmutableList.builder();
                        int size = this.f1274b.f1213i.size();
                        for (int i = 0; i < size; i++) {
                            SimpleUserToken simpleUserToken = (SimpleUserToken) this.f1274b.f1213i.get(i);
                            if (StringLocaleUtil.a(simpleUserToken.b()).contains(StringLocaleUtil.a(charSequence.toString()))) {
                                builder.c(simpleUserToken);
                            }
                        }
                        builder2 = builder;
                    } else {
                        builder2 = null;
                    }
                    builder = builder2;
                    query = query2;
                }
                FilterResults filterResults = new FilterResults();
                if (query != null) {
                    count = query.getCount();
                } else {
                    count = 0;
                }
                filterResults.count = count;
                if (builder != null) {
                    immutableList = builder.b();
                }
                filterResults.values = new ValueHolder(this, query, immutableList);
                return filterResults;
            }

            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                ValueHolder valueHolder = (ValueHolder) filterResults.values;
                if (!(valueHolder == null || valueHolder.f1270a == null)) {
                    if (valueHolder.f1271b != null) {
                        this.f1274b.f1214j = valueHolder.f1271b;
                    }
                    this.f1274b.mo57a(valueHolder.f1270a);
                }
                AdapterDetour.a(this.f1274b, 467340934);
            }
        };
    }

    private FacebookProfile m1459g(int i) {
        this.f1207d.moveToPosition(i);
        return new FacebookProfile(this.f1207d.getLong(this.f1207d.getColumnIndex("user_id")), this.f1207d.getString(this.f1207d.getColumnIndex("display_name")), this.f1207d.getString(this.f1207d.getColumnIndex("user_image_url")), 0);
    }

    public final Object m1460a(int i, int i2) {
        if (this.f1214j == null || i != 0 || !this.f1215k.a(ExperimentsForComposerAbTestModule.u, false)) {
            return m1459g(i2);
        }
        SimpleUserToken simpleUserToken = (SimpleUserToken) this.f1214j.get(i2);
        return new FacebookProfile(Long.parseLong(simpleUserToken.p()), simpleUserToken.b(), simpleUserToken.i(), 0);
    }

    public final void mo57a(Cursor cursor) {
        this.d = cursor;
        this.e = new ArrayList();
        Resources resources = this.f1209f.getResources();
        if (this.f1214j != null && this.f1215k.a(ExperimentsForComposerAbTestModule.u, false)) {
            this.f1208e.add(new Section(resources.getString(2131234773), 0, this.f1214j.size()));
        }
        if (cursor != null) {
            cursor.moveToFirst();
            this.f1208e.add(new Section(resources.getString(2131234772), 0, cursor.getCount()));
            AdapterDetour.a(this, 577448678);
        }
    }

    protected final String mo56a(Object obj) {
        return (String) obj;
    }

    protected final Object mo58b(Cursor cursor) {
        NameNormalizer nameNormalizer = this.f1211c;
        String string = cursor.getString(cursor.getColumnIndex("sort_name"));
        if (string.length() <= 0) {
            string = cursor.getString(cursor.getColumnIndex("display_name"));
        }
        return nameNormalizer.a(string.substring(0, string.offsetByCodePoints(0, 1)));
    }
}
