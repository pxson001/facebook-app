package com.facebook.photos.mediagallery.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.commerce.publishing.ui.nux.FBAlertDialogBuilderWrapper;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLTextWithEntities.Builder;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.ui.MentionsAutoCompleteTextView;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialog;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;

/* compiled from: skip_attributes */
public class EditCaptionDialog extends FbDialog {
    @Inject
    public TaggingProfiles f2582a;
    @Inject
    public FBAlertDialogBuilderWrapper f2583b;
    public final MentionsAutoCompleteTextView f2584c = ((MentionsAutoCompleteTextView) findViewById(2131560867));
    public final Context f2585d;
    public String f2586e;
    public SettableFuture<DefaultTextWithEntitiesLongFields> f2587f;

    /* compiled from: skip_attributes */
    public class C03201 implements OnClickListener {
        final /* synthetic */ EditCaptionDialog f2579a;

        public C03201(EditCaptionDialog editCaptionDialog) {
            this.f2579a = editCaptionDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1132624677);
            this.f2579a.f2584c.setText("");
            Logger.a(2, EntryType.UI_INPUT_END, 1848422728, a);
        }
    }

    /* compiled from: skip_attributes */
    public class C03212 implements OnClickListener {
        final /* synthetic */ EditCaptionDialog f2580a;

        public C03212(EditCaptionDialog editCaptionDialog) {
            this.f2580a = editCaptionDialog;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 261466394);
            if (EditCaptionDialog.m2679c(this.f2580a)) {
                Builder builder = new Builder();
                builder.i = this.f2580a.f2584c.getUserText().toString();
                builder = builder;
                builder.h = ImmutableList.copyOf(this.f2580a.f2584c.getMentionsEntityRanges());
                FutureDetour.a(this.f2580a.f2587f, builder.a(), -101789822);
            }
            this.f2580a.dismiss();
            Logger.a(2, EntryType.UI_INPUT_END, -1487890857, a);
        }
    }

    /* compiled from: skip_attributes */
    public class C03223 implements DialogInterface.OnClickListener {
        final /* synthetic */ EditCaptionDialog f2581a;

        public C03223(EditCaptionDialog editCaptionDialog) {
            this.f2581a = editCaptionDialog;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f2581a.dismiss();
        }
    }

    /* compiled from: skip_attributes */
    public class Factory {
        public static Factory m2677a(InjectorLike injectorLike) {
            return new Factory();
        }
    }

    public static void m2678a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        EditCaptionDialog editCaptionDialog = (EditCaptionDialog) obj;
        TaggingProfiles b = TaggingProfiles.b(fbInjector);
        FBAlertDialogBuilderWrapper a = FBAlertDialogBuilderWrapper.a(fbInjector);
        editCaptionDialog.f2582a = b;
        editCaptionDialog.f2583b = a;
    }

    public EditCaptionDialog(Context context) {
        super(context);
        Class cls = EditCaptionDialog.class;
        m2678a(this, getContext());
        requestWindowFeature(1);
        setContentView(2130903934);
        setCancelable(false);
        this.f2585d = context;
        findViewById(2131561099).setOnClickListener(new C03201(this));
        findViewById(2131561098).setOnClickListener(new C03212(this));
    }

    public void onBackPressed() {
        if (m2679c(this)) {
            Preconditions.checkArgument(this.f2585d instanceof Activity);
            FbAlertDialogBuilder a = FBAlertDialogBuilderWrapper.a((Activity) this.f2585d);
            a.a(2131235609);
            a.b(2131235610);
            a.a(2131235611, new C03223(this));
            a.b(2131235612, null);
            a.a(true);
            a.a().show();
            return;
        }
        dismiss();
    }

    protected void onStop() {
        super.onStop();
        this.f2587f.a(new CancellationException());
    }

    public static boolean m2679c(EditCaptionDialog editCaptionDialog) {
        return !StringUtil.a(editCaptionDialog.f2584c.getEncodedText(), editCaptionDialog.f2586e);
    }
}
