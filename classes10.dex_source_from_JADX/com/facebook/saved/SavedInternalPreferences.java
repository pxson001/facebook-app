package com.facebook.saved;

import android.content.Context;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.inject.FbInjector;
import com.facebook.saved.data.SavedDashboardPaginatedSavedItems;
import com.facebook.saved.loader.SavedDashboardItemLoader;
import com.facebook.saved.loader.SavedDashboardItemLoader.ItemLoadListener;
import com.google.common.base.Optional;

/* compiled from: java.net.PlainSocketImpl */
public class SavedInternalPreferences extends PreferenceCategory {
    public Context f8950a;

    public SavedInternalPreferences(Context context) {
        super(context);
        this.f8950a = context;
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        setTitle("Saved");
        Preference preference = new Preference(this.f8950a);
        preference.setTitle("Pre-cache Saved Dashboard");
        final SavedDashboardItemLoader b = SavedDashboardItemLoader.m9236b(FbInjector.get(this.f8950a));
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ SavedInternalPreferences f8949b;

            /* compiled from: java.net.PlainSocketImpl */
            class C13651 implements ItemLoadListener {
                final /* synthetic */ C13661 f8947a;

                C13651(C13661 c13661) {
                    this.f8947a = c13661;
                }

                public final void mo408a(SavedDashboardPaginatedSavedItems savedDashboardPaginatedSavedItems) {
                    Toast.makeText(this.f8947a.f8949b.f8950a, "Fetched saved items", 1).show();
                }

                public final void mo407a() {
                    Toast.makeText(this.f8947a.f8949b.f8950a, "Failed to fetch saved items", 1).show();
                }
            }

            public boolean onPreferenceClick(Preference preference) {
                b.m9240b(Optional.of(GraphQLSavedDashboardSectionType.ALL), new C13651(this));
                return true;
            }
        });
        addPreference(preference);
    }
}
