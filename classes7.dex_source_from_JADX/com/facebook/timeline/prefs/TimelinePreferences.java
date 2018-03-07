package com.facebook.timeline.prefs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.FbInjector;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.widget.prefs.CheckBoxOrSwitchPreference;
import com.google.common.collect.ImmutableSet;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: fav_photos_edit_click */
public class TimelinePreferences extends PreferenceCategory {
    public FbUriIntentHandler f14689a;
    public GraphQLCacheManager f14690b;
    public Executor f14691c;
    private Toast f14692d = null;

    /* compiled from: fav_photos_edit_click */
    class C10692 implements OnPreferenceClickListener {
        final /* synthetic */ TimelinePreferences f14688a;

        /* compiled from: fav_photos_edit_click */
        class C10661 implements OnClickListener {
            final /* synthetic */ C10692 f14683a;

            C10661(C10692 c10692) {
                this.f14683a = c10692;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C10692(TimelinePreferences timelinePreferences) {
            this.f14688a = timelinePreferences;
        }

        public boolean onPreferenceClick(Preference preference) {
            final View editText = new EditText(this.f14688a.getContext());
            editText.setInputType(2);
            final AlertDialog a = new FbAlertDialogBuilder(this.f14688a.getContext()).b(editText).a("UID").a("OK", new OnClickListener(this) {
                final /* synthetic */ C10692 f14685b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    Editable text = editText.getText();
                    if (text != null && !StringUtil.c(text.toString())) {
                        this.f14685b.f14688a.f14689a.a(this.f14685b.f14688a.getContext(), StringFormatUtil.a(FBLinks.aX, new Object[]{text.toString()}));
                    }
                }
            }).b("Cancel", new C10661(this)).a();
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ C10692 f14687b;

                public void onFocusChange(View view, boolean z) {
                    if (z) {
                        a.getWindow().setSoftInputMode(5);
                    }
                }
            });
            a.show();
            return true;
        }
    }

    public static void m18639a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        TimelinePreferences timelinePreferences = (TimelinePreferences) obj;
        GraphQLCacheManager a = GraphQLCacheManager.a(fbInjector);
        FbUriIntentHandler a2 = FbUriIntentHandler.a(fbInjector);
        Executor executor = (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector);
        timelinePreferences.f14690b = a;
        timelinePreferences.f14689a = a2;
        timelinePreferences.f14691c = executor;
    }

    public TimelinePreferences(Context context) {
        super(context);
        Class cls = TimelinePreferences.class;
        m18639a(this, getContext());
    }

    public static void m18638a(TimelinePreferences timelinePreferences, Context context, String str) {
        if (timelinePreferences.f14692d != null) {
            timelinePreferences.f14692d.cancel();
        }
        timelinePreferences.f14692d = Toast.makeText(context, str, 0);
        timelinePreferences.f14692d.show();
    }

    protected void onAttachedToHierarchy(PreferenceManager preferenceManager) {
        super.onAttachedToHierarchy(preferenceManager);
        final Context context = getContext();
        setTitle("Timeline - internal");
        Preference preference = new Preference(context);
        preference.setTitle("Clear Feed Cache");
        preference.setSummary("Clear cache across newsfeed and my timeline");
        preference.setOnPreferenceClickListener(new OnPreferenceClickListener(this) {
            final /* synthetic */ TimelinePreferences f14682b;

            /* compiled from: fav_photos_edit_click */
            class C10641 implements FutureCallback<Void> {
                final /* synthetic */ C10651 f14680a;

                C10641(C10651 c10651) {
                    this.f14680a = c10651;
                }

                public void onSuccess(Object obj) {
                    TimelinePreferences.m18638a(this.f14680a.f14682b, context, "Cache cleared");
                }

                public void onFailure(Throwable th) {
                    TimelinePreferences.m18638a(this.f14680a.f14682b, context, "Cache clearing failed");
                }
            }

            public boolean onPreferenceClick(Preference preference) {
                ListenableFuture a = this.f14682b.f14690b.a(ImmutableSet.of("timeline_fetch_info_review", "timeline_fetch_header", "timeline_fetch_first_units_classic", "timeline_fetch_first_units_plutonium", "timeline_fetch_section"));
                TimelinePreferences.m18638a(this.f14682b, context, "Clearing cache");
                Futures.a(a, new C10641(this), this.f14682b.f14691c);
                return true;
            }
        });
        addPreference(preference);
        CheckBoxOrSwitchPreference checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(context);
        checkBoxOrSwitchPreference.a(TimelinePreferencesKeys.f14693a);
        checkBoxOrSwitchPreference.setTitle("Pause Updates");
        checkBoxOrSwitchPreference.setSummary("Disables fetch of new Timeline units (for scroll perf integration test)");
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        addPreference(checkBoxOrSwitchPreference);
        preference = new Preference(getContext());
        preference.setTitle("Go to timeline");
        preference.setSummary("Opens user timeline by uid");
        preference.setOnPreferenceClickListener(new C10692(this));
        addPreference(preference);
        checkBoxOrSwitchPreference = new CheckBoxOrSwitchPreference(context);
        checkBoxOrSwitchPreference.a(TimelinePreferencesKeys.f14695c);
        checkBoxOrSwitchPreference.setTitle("Show debug overlay");
        checkBoxOrSwitchPreference.setDefaultValue(Boolean.valueOf(false));
        addPreference(checkBoxOrSwitchPreference);
    }
}
