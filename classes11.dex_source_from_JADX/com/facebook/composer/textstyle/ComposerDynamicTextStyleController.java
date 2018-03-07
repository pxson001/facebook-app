package com.facebook.composer.textstyle;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.EditText;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.ui.text.HasUserText;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper;
import com.facebook.friendsharing.text.abtest.FeedTextSizeExperimentHelper.Configuration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.qe.api.QeAccessor;
import com.google.common.annotations.VisibleForTesting;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: feee54e6c08852e304ab500d4e479f97 */
public class ComposerDynamicTextStyleController<EditTextWithStyle extends EditText & HasUserText, DataProvider extends ProvidesContentType & ProvidesConfiguration> implements ComposerEventHandler {
    private static final Typeface f6984g = Typeface.create("sans-serif-light", 0);
    public final Context f6985a;
    public final FeedTextSizeExperimentHelper f6986b;
    public final QeAccessor f6987c;
    public WeakReference<EditTextWithStyle> f6988d;
    public DataProvider f6989e;
    public float f6990f = 0.0f;

    @Inject
    public ComposerDynamicTextStyleController(Context context, FeedTextSizeExperimentHelper feedTextSizeExperimentHelper, QeAccessor qeAccessor) {
        this.f6985a = context;
        this.f6986b = feedTextSizeExperimentHelper;
        this.f6987c = qeAccessor;
    }

    public final void m8287a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE || composerEvent == ComposerEvent.ON_FIRST_DRAW || composerEvent == ComposerEvent.ON_STATUS_TEXT_CHANGED) {
            m8285a();
        }
    }

    private void m8285a() {
        if (this.f6989e != null && this.f6988d != null) {
            Object obj;
            if (this.f6989e.c() != ComposerContentType.NO_ATTACHMENTS) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                m8286c();
                return;
            }
            Configuration a = this.f6986b.a(((HasUserText) ((EditText) this.f6988d.get())).getUserText().toString());
            if (a != null) {
                ((EditText) this.f6988d.get()).setTextSize((float) a.b);
                if ("light".equals(a.e)) {
                    ((EditText) this.f6988d.get()).setTypeface(f6984g);
                }
            }
        }
    }

    @VisibleForTesting
    private void m8286c() {
        if (this.f6990f > 0.0f) {
            ((EditText) this.f6988d.get()).setTextSize(0, this.f6990f);
        }
    }
}
