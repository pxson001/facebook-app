package com.facebook.contacts.provider;

import android.net.Uri;
import com.facebook.common.build.BuildConstants;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: zero_update_status */
public class ContactsConnectionsContract {
    public static final String f298a = (BuildConstants.n() + ".provider.ContactsConnectionsProvider");
    public static final String[] f299b = new String[]{"_id", "_count", "user_id", "display_name", "sort_name", "user_image_url", "contact_type", "first_name", "last_name", "cell", "other", "search_token"};
    public static final Map<String, Integer> f300c = ImmutableMap.builder().m609b("_id", Integer.valueOf(1)).m609b("_count", Integer.valueOf(1)).m609b("user_id", Integer.valueOf(1)).m609b("display_name", Integer.valueOf(3)).m609b("sort_name", Integer.valueOf(3)).m609b("user_image_url", Integer.valueOf(3)).m609b("contact_type", Integer.valueOf(3)).m609b("first_name", Integer.valueOf(3)).m609b("last_name", Integer.valueOf(3)).m609b("cell", Integer.valueOf(3)).m609b("other", Integer.valueOf(3)).m609b("search_token", Integer.valueOf(3)).m610b();
    public static final Map<String, Integer> f301d = new HashMap();
    public static final Uri f302e = Selectors.CONTACTS_CONTENT.getFullUri();
    public static final Uri f303f = Selectors.CONTACT_ID.getFullUri();
    public static final Uri f304g = Selectors.FRIENDS_CONTENT.getFullUri();
    public static final Uri f305h = Selectors.FRIEND_UID.getFullUri();
    public static final Uri f306i = Selectors.FRIENDS_PREFIX_SEARCH.getFullUri();
    public static final Uri f307j = Selectors.PAGES_CONTENT.getFullUri();
    public static final Uri f308k = Selectors.PAGE_ID.getFullUri();
    public static final Uri f309l = Selectors.PAGES_SEARCH.getFullUri();
    public static final String f310m = ("content://" + f298a + "/");

    /* compiled from: zero_update_status */
    public enum Selectors {
        CONTACTS_CONTENT("all_contacts", "", ""),
        CONTACT_ID("all_contacts", "/id", "/#"),
        FRIENDS_CONTENT("friends", "", ""),
        FRIEND_UID("friends", "/uid", "/#"),
        FRIENDS_PREFIX_SEARCH("friends", "/search", "/*"),
        FRIENDS_BIRTHDAYS("friends", "/birthdays", ""),
        PAGES_CONTENT("pages", "", ""),
        PAGE_ID("pages", "/id", "/#"),
        PAGES_SEARCH("pages", "/search", "/*");
        
        public final String category;
        public final String uriMatcherSuffix;
        public final String uriSuffix;

        private Selectors(String str, String str2, String str3) {
            this.category = str;
            this.uriSuffix = str2;
            this.uriMatcherSuffix = str3;
        }

        public final String getMatcherPartialUri() {
            return this.category + this.uriSuffix + this.uriMatcherSuffix;
        }

        public final Uri getFullUri() {
            return Uri.parse(ContactsConnectionsContract.f310m + this.category + this.uriSuffix);
        }

        public final int uriMatcherIndex() {
            return ordinal() + 1;
        }
    }

    static {
        int i = 0;
        while (i < f299b.length) {
            f301d.put(f299b[i], Integer.valueOf(i));
            i++;
        }
    }
}
