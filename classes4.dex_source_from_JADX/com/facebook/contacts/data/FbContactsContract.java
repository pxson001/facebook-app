package com.facebook.contacts.data;

import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.users.username.gating.UsernameGatingUtil;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: getCanonicalProfileId */
public final class FbContactsContract {
    private static volatile FbContactsContract f11194i;
    public final String f11195a;
    public final Uri f11196b = Uri.parse("content://" + this.f11195a);
    public final ContactsTable f11197c = new ContactsTable(this);
    public final FavoritesTable f11198d = new FavoritesTable(this);
    public final SmsFavoritesTable f11199e = new SmsFavoritesTable(this);
    public final SearchTable f11200f = new SearchTable(this);
    public final DatabaseOperations f11201g = new DatabaseOperations(this);
    private final UsernameGatingUtil f11202h;

    /* compiled from: getCanonicalProfileId */
    public final class ContactsTable implements ContactColumns {
        public final Uri f11204c = Uri.withAppendedPath(this.f11205d.f11196b, "contacts_with_fbids");
        final /* synthetic */ FbContactsContract f11205d;

        public ContactsTable(FbContactsContract fbContactsContract) {
            this.f11205d = fbContactsContract;
        }
    }

    /* compiled from: getCanonicalProfileId */
    public interface ContactColumns extends BaseColumns {
        public static final ImmutableSet<String> f11206a = ImmutableSet.of("fbid", "first_name", "last_name", "display_name", "small_picture_url", "big_picture_url", new String[]{"huge_picture_url", "small_picture_size", "big_picture_size", "huge_picture_size", "communication_rank", "is_mobile_pushable", "is_messenger_user", "messenger_install_time_ms", "added_time_ms", "is_on_viewer_contact_list", "type", "link_type", "phonebook_section_key", "bday_month", "bday_day", "last_fetch_time_ms", "is_partial", "messenger_invite_priority"});
        public static final ImmutableSet<String> f11207b = ImmutableSet.of("_id", "communication_rank", "with_tagging_rank", "sort_name_key");
    }

    /* compiled from: getCanonicalProfileId */
    public final class FavoritesTable implements BaseColumns {
        public final Uri f11208a = Uri.withAppendedPath(this.f11209b.f11196b, "favorites");
        final /* synthetic */ FbContactsContract f11209b;

        public FavoritesTable(FbContactsContract fbContactsContract) {
            this.f11209b = fbContactsContract;
        }
    }

    /* compiled from: getCanonicalProfileId */
    public final class SmsFavoritesTable implements BaseColumns {
        public final Uri f11210a = Uri.withAppendedPath(this.f11211b.f11196b, "sms_favorites");
        final /* synthetic */ FbContactsContract f11211b;

        public SmsFavoritesTable(FbContactsContract fbContactsContract) {
            this.f11211b = fbContactsContract;
        }
    }

    /* compiled from: getCanonicalProfileId */
    public final class SearchTable implements ContactColumns {
        public final Uri f11212c = Uri.withAppendedPath(this.f11213d.f11196b, "search");
        final /* synthetic */ FbContactsContract f11213d;

        public SearchTable(FbContactsContract fbContactsContract) {
            this.f11213d = fbContactsContract;
        }

        public final SearchQuery m11629a(Uri uri) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() == 2 || pathSegments.size() == 3) {
                String[] split = ((String) pathSegments.get(1)).split(",");
                Builder builder = ImmutableSet.builder();
                for (String valueOf : split) {
                    builder.c(SearchType.valueOf(valueOf));
                }
                return new SearchQuery(this.f11213d, pathSegments.size() < 3 ? "" : (String) pathSegments.get(2), builder.b());
            }
            throw new IllegalArgumentException("Invalid uri");
        }
    }

    /* compiled from: getCanonicalProfileId */
    public final class DatabaseOperations {
        public final Uri f11214a = Uri.withAppendedPath(this.f11215b.f11196b, "clear_db");
        final /* synthetic */ FbContactsContract f11215b;

        public DatabaseOperations(FbContactsContract fbContactsContract) {
            this.f11215b = fbContactsContract;
        }
    }

    /* compiled from: getCanonicalProfileId */
    public enum QueryType {
        CONTACT("search"),
        USER("userSearch");
        
        public final String searchTableContentPath;

        private QueryType(String str) {
            this.searchTableContentPath = str;
        }
    }

    public static com.facebook.contacts.data.FbContactsContract m11624a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f11194i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.contacts.data.FbContactsContract.class;
        monitor-enter(r1);
        r0 = f11194i;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11625b(r0);	 Catch:{ all -> 0x0035 }
        f11194i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11194i;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.contacts.data.FbContactsContract.a(com.facebook.inject.InjectorLike):com.facebook.contacts.data.FbContactsContract");
    }

    private static FbContactsContract m11625b(InjectorLike injectorLike) {
        return new FbContactsContract((Context) injectorLike.getInstance(Context.class), UsernameGatingUtil.m11627b(injectorLike));
    }

    @Inject
    public FbContactsContract(Context context, UsernameGatingUtil usernameGatingUtil) {
        this.f11195a = context.getPackageName() + ".contacts";
        this.f11202h = usernameGatingUtil;
    }

    public final Set<SearchType> m11626a() {
        Set of = EnumSet.of(SearchType.NAME, SearchType.PHONE_E164, SearchType.PHONE_NATIONAL, SearchType.PHONE_LOCAL);
        if (this.f11202h.m11628a()) {
            of.add(SearchType.USERNAME);
        }
        return Collections.unmodifiableSet(of);
    }
}
