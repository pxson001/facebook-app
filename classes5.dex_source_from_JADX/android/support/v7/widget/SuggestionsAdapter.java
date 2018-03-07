package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.ResourceCursorAdapter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* compiled from: treehouse_ios_groups_tab_menu */
public class SuggestionsAdapter extends ResourceCursorAdapter implements OnClickListener {
    private final SearchManager f1520j = ((SearchManager) this.f426d.getSystemService("search"));
    private final SearchView f1521k;
    private final SearchableInfo f1522l;
    private final Context f1523m;
    private final WeakHashMap<String, ConstantState> f1524n;
    private final int f1525o;
    private boolean f1526p = false;
    public int f1527q = 1;
    private ColorStateList f1528r;
    private int f1529s = -1;
    private int f1530t = -1;
    private int f1531u = -1;
    private int f1532v = -1;
    private int f1533w = -1;
    private int f1534x = -1;

    /* compiled from: treehouse_ios_groups_tab_menu */
    final class ChildViewCache {
        public final TextView f1515a;
        public final TextView f1516b;
        public final ImageView f1517c;
        public final ImageView f1518d;
        public final ImageView f1519e;

        public ChildViewCache(View view) {
            this.f1515a = (TextView) view.findViewById(16908308);
            this.f1516b = (TextView) view.findViewById(16908309);
            this.f1517c = (ImageView) view.findViewById(16908295);
            this.f1518d = (ImageView) view.findViewById(16908296);
            this.f1519e = (ImageView) view.findViewById(2131559132);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.mSuggestionRowLayout, null, true);
        this.f1521k = searchView;
        this.f1522l = searchableInfo;
        this.f1525o = searchView.mSuggestionCommitIconResId;
        this.f1523m = context;
        this.f1524n = weakHashMap;
    }

    public boolean hasStableIds() {
        return false;
    }

    public final Cursor mo169a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1521k.getVisibility() != 0 || this.f1521k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m2083a(this.f1522l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m2097d(mo168a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m2097d(mo168a());
    }

    private static void m2097d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public final void mo170a(Cursor cursor) {
        if (this.f1526p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo170a(cursor);
            if (cursor != null) {
                this.f1529s = cursor.getColumnIndex("suggest_text_1");
                this.f1530t = cursor.getColumnIndex("suggest_text_2");
                this.f1531u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1532v = cursor.getColumnIndex("suggest_icon_1");
                this.f1533w = cursor.getColumnIndex("suggest_icon_2");
                this.f1534x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public final View mo193a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo193a(context, cursor, viewGroup);
        a.setTag(new ChildViewCache(a));
        ((ImageView) a.findViewById(2131559132)).setImageResource(this.f1525o);
        return a;
    }

    public final void mo450a(View view, Cursor cursor) {
        ChildViewCache childViewCache = (ChildViewCache) view.getTag();
        int i;
        if (this.f1534x != -1) {
            i = cursor.getInt(this.f1534x);
        } else {
            i = 0;
        }
        if (childViewCache.f1515a != null) {
            m2090a(childViewCache.f1515a, m2087a(cursor, this.f1529s));
        }
        if (childViewCache.f1516b != null) {
            CharSequence a = m2087a(cursor, this.f1531u);
            if (a != null) {
                a = m2095b(a);
            } else {
                a = m2087a(cursor, this.f1530t);
            }
            if (TextUtils.isEmpty(a)) {
                if (childViewCache.f1515a != null) {
                    childViewCache.f1515a.setSingleLine(false);
                    childViewCache.f1515a.setMaxLines(2);
                }
            } else if (childViewCache.f1515a != null) {
                childViewCache.f1515a.setSingleLine(true);
                childViewCache.f1515a.setMaxLines(1);
            }
            m2090a(childViewCache.f1516b, a);
        }
        if (childViewCache.f1517c != null) {
            m2089a(childViewCache.f1517c, m2098e(cursor), 4);
        }
        if (childViewCache.f1518d != null) {
            m2089a(childViewCache.f1518d, m2099f(cursor), 8);
        }
        if (this.f1527q == 2 || (this.f1527q == 1 && (r1 & 1) != 0)) {
            childViewCache.f1519e.setVisibility(0);
            childViewCache.f1519e.setTag(childViewCache.f1515a.getText());
            childViewCache.f1519e.setOnClickListener(this);
            return;
        }
        childViewCache.f1519e.setVisibility(8);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1198326435);
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1521k.onQueryRefine((CharSequence) tag);
        }
        Logger.a(2, EntryType.UI_INPUT_END, -1089224711, a);
    }

    private CharSequence m2095b(CharSequence charSequence) {
        if (this.f1528r == null) {
            TypedValue typedValue = new TypedValue();
            this.f426d.getTheme().resolveAttribute(2130772033, typedValue, true);
            this.f1528r = this.f426d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1528r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private static void m2090a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m2098e(Cursor cursor) {
        if (this.f1532v == -1) {
            return null;
        }
        Drawable a = m2086a(cursor.getString(this.f1532v));
        return a == null ? m2096c() : a;
    }

    private Drawable m2099f(Cursor cursor) {
        if (this.f1533w == -1) {
            return null;
        }
        return m2086a(cursor.getString(this.f1533w));
    }

    private static void m2089a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence mo171c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m2088a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f1522l.shouldRewriteQueryFromData()) {
            a = m2088a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f1522l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m2088a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo193a(this.f426d, this.f425c, viewGroup);
            if (a != null) {
                ((ChildViewCache) a.getTag()).f1515a.setText(e.toString());
            }
            return a;
        }
    }

    private Drawable m2086a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1523m.getPackageName() + "/" + parseInt;
            b = m2094b(str2);
            if (b != null) {
                return b;
            }
            b = ContextCompat.a(this.f1523m, parseInt);
            m2091a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m2094b(str);
            if (b != null) {
                return b;
            }
            b = m2085a(Uri.parse(str));
            m2091a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m2085a(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m2093b(uri);
                } catch (NotFoundException e) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream openInputStream = this.f1523m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                    return createFromStream;
                } catch (Throwable e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                    return createFromStream;
                }
            } catch (Throwable e22) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e22);
            } catch (Throwable th) {
                openInputStream.close();
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
    }

    private Drawable m2094b(String str) {
        ConstantState constantState = (ConstantState) this.f1524n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m2091a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1524n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m2096c() {
        Drawable a = m2084a(this.f1522l.getSearchActivity());
        return a != null ? a : this.f426d.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m2084a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f1524n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f1524n.get(flattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.f1523m.getResources());
        }
        Drawable b = m2092b(componentName);
        this.f1524n.put(flattenToShortString, b == null ? null : b.getConstantState());
        return b;
    }

    private Drawable m2092b(ComponentName componentName) {
        PackageManager packageManager = this.f426d.getPackageManager();
        try {
            ComponentInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m2088a(Cursor cursor, String str) {
        return m2087a(cursor, cursor.getColumnIndex(str));
    }

    private static String m2087a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    private Drawable m2093b(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f426d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    private Cursor m2083a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f426d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
