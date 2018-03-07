package com.facebook.quickpromotion.debug;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceScreen;
import android.widget.Toast;
import com.facebook.base.activity.FbPreferenceActivity;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.quickpromotion.filter.ContextualFiltersPreferenceGenerator;
import com.facebook.quickpromotion.filter.ContextualFiltersPreferenceGeneratorImpl;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$ContextualFilter$Type;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys;
import com.facebook.quickpromotion.prefs.QuickPromotionPrefKeys.FilterState;
import javax.inject.Inject;

/* compiled from: refetchAlbumDetails_%s */
public class QuickPromotionFiltersActivity extends FbPreferenceActivity {
    @Inject
    FbSharedPreferences f4628a;
    @Inject
    ContextualFiltersPreferenceGenerator f4629b;
    private FilterState[] f4630c = FilterState.values();

    /* compiled from: refetchAlbumDetails_%s */
    class C06101 implements OnPreferenceClickListener {
        final /* synthetic */ QuickPromotionFiltersActivity f4624a;

        C06101(QuickPromotionFiltersActivity quickPromotionFiltersActivity) {
            this.f4624a = quickPromotionFiltersActivity;
        }

        public boolean onPreferenceClick(Preference preference) {
            this.f4624a.f4628a.edit().b(QuickPromotionPrefKeys.f4764h).commit();
            Toast.makeText(this.f4624a, "Filters Reset", 1).show();
            this.f4624a.m4486a();
            return true;
        }
    }

    private static <T extends Context> void m4489a(Class<T> cls, T t) {
        m4490a((Object) t, (Context) t);
    }

    public static void m4490a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((QuickPromotionFiltersActivity) obj).m4487a((FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector), (ContextualFiltersPreferenceGenerator) ContextualFiltersPreferenceGeneratorImpl.a(fbInjector));
    }

    public final void m4492c(Bundle bundle) {
        super.c(bundle);
        Class cls = QuickPromotionFiltersActivity.class;
        m4490a((Object) this, (Context) this);
        m4486a();
    }

    private void m4486a() {
        PreferenceScreen createPreferenceScreen = getPreferenceManager().createPreferenceScreen(this);
        Preference preference = new Preference(this);
        preference.setTitle("Reset All Overrides to Default");
        preference.setOnPreferenceClickListener(new C06101(this));
        createPreferenceScreen.addPreference(preference);
        preference = new PreferenceCategory(this);
        createPreferenceScreen.addPreference(preference);
        preference.setTitle("Filters");
        this.f4629b.mo221a(this, createPreferenceScreen);
        setPreferenceScreen(createPreferenceScreen);
    }

    private void m4487a(FbSharedPreferences fbSharedPreferences, ContextualFiltersPreferenceGenerator contextualFiltersPreferenceGenerator) {
        this.f4628a = fbSharedPreferences;
        this.f4629b = contextualFiltersPreferenceGenerator;
    }

    public final void m4491a(final QuickPromotionDefinition$ContextualFilter$Type quickPromotionDefinition$ContextualFilter$Type) {
        int i = 0;
        Builder builder = new Builder(this);
        builder.a(quickPromotionDefinition$ContextualFilter$Type.name());
        final CharSequence[] charSequenceArr = new CharSequence[this.f4630c.length];
        FilterState[] filterStateArr = this.f4630c;
        int length = filterStateArr.length;
        int i2 = 0;
        while (i < length) {
            charSequenceArr[i2] = filterStateArr[i].getFilterStateCaption();
            i2++;
            i++;
        }
        builder.a(charSequenceArr, this.f4628a.a(QuickPromotionPrefKeys.m4648a(quickPromotionDefinition$ContextualFilter$Type), FilterState.DEFAULT.ordinal()), new OnClickListener(this) {
            final /* synthetic */ QuickPromotionFiltersActivity f4627c;

            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(this.f4627c.getApplicationContext(), charSequenceArr[i], 0).show();
                this.f4627c.f4628a.edit().a(QuickPromotionPrefKeys.m4648a(quickPromotionDefinition$ContextualFilter$Type), i).commit();
                this.f4627c.m4486a();
            }
        });
        builder.a().show();
    }
}
