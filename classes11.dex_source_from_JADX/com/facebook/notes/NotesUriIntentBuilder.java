package com.facebook.notes;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriIntentBuilder.IUriTemplateIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.inject.InjectorLike;
import com.facebook.notes.gk.NotesGatekeepers;
import javax.inject.Inject;

@UriMapPattern
/* compiled from: Unable to serialize NumberFormatConfig from system values */
public class NotesUriIntentBuilder extends UriIntentBuilder {
    private final NotesGatekeepers f10478a;

    /* compiled from: Unable to serialize NumberFormatConfig from system values */
    class NotesIntentBuilder implements IUriTemplateIntentBuilder {
        public final Intent m10907a(Context context, Bundle bundle) {
            Intent intent = new Intent();
            String string = bundle.getString("note");
            intent.putExtra("extra_notes_id", string.substring(1, string.length() - 1));
            intent.setComponent(new ComponentName(context, NotesActivity.class));
            intent.putExtra("force_external_activity", true);
            return intent;
        }
    }

    public static NotesUriIntentBuilder m10908b(InjectorLike injectorLike) {
        return new NotesUriIntentBuilder(NotesGatekeepers.b(injectorLike));
    }

    @Inject
    public NotesUriIntentBuilder(NotesGatekeepers notesGatekeepers) {
        this.f10478a = notesGatekeepers;
        a(StringFormatUtil.a(FBLinks.aV, new Object[]{"note"}), new NotesIntentBuilder());
    }

    public final boolean m10909a() {
        return this.f10478a.a();
    }
}
