package com.facebook.languages.switcher.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.common.util.StringUtil;
import com.facebook.crudolib.urimap.UriMatchPatterns;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switcher.LanguageSwitcher;
import com.facebook.languages.switcher.LanguageSwitcherList;
import com.facebook.languages.switcher.LanguageSwitcherListHelper;
import com.facebook.languages.switcher.logging.LanguageSwitcherLogger;
import com.facebook.languages.switchercommonex.LanguageSwitcherCommonExPrefKeys;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import javax.inject.Inject;

@UriMatchPatterns
/* compiled from: timelineFetch */
public class LanguageSwitcherBookmarksActivity extends FbFragmentActivity {
    @Inject
    FbSharedPreferences f1376p;
    @Inject
    LanguageSwitcher f1377q;
    @Inject
    LanguageSwitcherLogger f1378r;
    @Inject
    LanguageSwitcherListHelper f1379s;
    private BetterListView f1380t;
    private FbTitleBar f1381u;

    /* compiled from: timelineFetch */
    class C02321 implements OnClickListener {
        final /* synthetic */ LanguageSwitcherBookmarksActivity f1373a;

        C02321(LanguageSwitcherBookmarksActivity languageSwitcherBookmarksActivity) {
            this.f1373a = languageSwitcherBookmarksActivity;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -975263366);
            this.f1373a.onBackPressed();
            Logger.a(2, EntryType.UI_INPUT_END, 1798432116, a);
        }
    }

    private static <T extends Context> void m1385a(Class<T> cls, T t) {
        m1386a((Object) t, (Context) t);
    }

    public static void m1386a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((LanguageSwitcherBookmarksActivity) obj).m1384a((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), LanguageSwitcher.a(injectorLike), LanguageSwitcherLogger.m1415b(injectorLike), LanguageSwitcherListHelper.b(injectorLike));
    }

    public final void m1390b(Bundle bundle) {
        super.b(bundle);
        Class cls = LanguageSwitcherBookmarksActivity.class;
        m1386a((Object) this, (Context) this);
        setContentView(2130905000);
        m1388j();
        m1389k();
    }

    public static String m1387i(LanguageSwitcherBookmarksActivity languageSwitcherBookmarksActivity) {
        return languageSwitcherBookmarksActivity.f1376p.a(LanguageSwitcherCommonExPrefKeys.b, "device");
    }

    private void m1388j() {
        FbTitleBarUtil.b(this);
        this.f1381u = (FbTitleBar) findViewById(2131558563);
        this.f1381u.a(new C02321(this));
        this.f1381u.setTitle(getResources().getString(2131240202));
    }

    private void m1389k() {
        this.f1380t = (BetterListView) findViewById(2131560128);
        this.f1380t.setChoiceMode(1);
        LanguageSwitcherList a = this.f1379s.a();
        final String[] a2 = a.a();
        String[] b = a.b();
        int i = a.b;
        this.f1380t.setAdapter(new ArrayAdapter(this.f1380t.getContext(), 2130905118, b));
        this.f1380t.setItemChecked(i, true);
        this.f1380t.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LanguageSwitcherBookmarksActivity f1375b;

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = a2[i];
                String i2 = LanguageSwitcherBookmarksActivity.m1387i(this.f1375b);
                if (!(StringUtil.a(str) || str.equals(i2))) {
                    this.f1375b.f1378r.m1417a(i2, str);
                    this.f1375b.f1377q.a(str);
                }
                this.f1375b.finish();
            }
        });
    }

    private void m1384a(FbSharedPreferences fbSharedPreferences, LanguageSwitcher languageSwitcher, LanguageSwitcherLogger languageSwitcherLogger, LanguageSwitcherListHelper languageSwitcherListHelper) {
        this.f1376p = fbSharedPreferences;
        this.f1377q = languageSwitcher;
        this.f1378r = languageSwitcherLogger;
        this.f1379s = languageSwitcherListHelper;
    }
}
