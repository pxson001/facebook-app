package com.facebook.notes;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.util.StringUtil;
import com.facebook.content.ExternalIntentHandler;
import com.facebook.notes.gk.NotesGatekeepers;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Unauthorized */
public class NotesIntentHandler implements ExternalIntentHandler {
    private final NotesGatekeepers f10475a;
    public final NotesUriIntentBuilder f10476b;

    @Inject
    public NotesIntentHandler(NotesGatekeepers notesGatekeepers, NotesUriIntentBuilder notesUriIntentBuilder) {
        this.f10475a = notesGatekeepers;
        this.f10476b = notesUriIntentBuilder;
    }

    public final boolean m10906a(Intent intent, Context context) {
        return m10903c(intent, context);
    }

    public final boolean m10904a(Intent intent, int i, Activity activity) {
        return m10903c(intent, activity);
    }

    public final boolean m10905a(Intent intent, int i, Fragment fragment) {
        return m10903c(intent, fragment.getContext());
    }

    public static String m10902a(@Nullable Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("extra_notes_id");
    }

    private boolean m10903c(@Nullable Intent intent, @Nullable Context context) {
        if (this.f10475a.a()) {
            CharSequence charSequence;
            if (intent == null || context == null) {
                charSequence = null;
            } else {
                charSequence = m10902a(intent);
                if (StringUtil.c(charSequence) && !StringUtil.c(intent.getDataString())) {
                    charSequence = m10902a(this.f10476b.a(context, intent.getDataString()));
                }
                if (StringUtil.a(charSequence)) {
                    charSequence = null;
                }
            }
            CharSequence charSequence2 = charSequence;
            if (!StringUtil.c(charSequence2)) {
                intent.putExtra("extra_notes_id", charSequence2);
                intent.setComponent(new ComponentName(context, NotesActivity.class));
            }
        }
        return false;
    }
}
