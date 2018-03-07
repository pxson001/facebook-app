package com.facebook.feed.prefs;

import android.content.Context;
import com.facebook.feed.util.injection.FeedClientSideInjectionTool;
import com.facebook.feed.util.injection.FeedClientSideInjectionTool.Action;
import com.facebook.inject.FbInjector;
import com.facebook.widget.prefs.OrcaListPreference;

/* compiled from: admin_click_edit_boosted_pagelike_status */
public class ClientSideInjectHelperPreference extends OrcaListPreference {
    public FeedClientSideInjectionTool f19820a;

    public static void m23084a(Object obj, Context context) {
        ((ClientSideInjectHelperPreference) obj).f19820a = FeedClientSideInjectionTool.a(FbInjector.get(context));
    }

    public ClientSideInjectHelperPreference(Context context) {
        super(context);
        Class cls = ClientSideInjectHelperPreference.class;
        m23084a(this, context);
        setPersistent(false);
        setTitle("Client Side Injection Helper");
        setSummary("Some helper functions for story injection");
        setDialogTitle("Do things!");
        setEntries(new String[]{"Detect a new set of stories and clear cache", "Clear cached stories", "Remove feed-inject.json file"});
        setEntryValues(new String[]{Action.DETECT.toString(), Action.CLEAR.toString(), Action.REMOVE.toString()});
    }

    protected String getPersistedString(String str) {
        return "";
    }

    protected boolean persistString(String str) {
        if (str != null) {
            try {
                this.f19820a.a(Action.valueOf(str));
            } catch (IllegalArgumentException e) {
            }
        }
        return true;
    }
}
