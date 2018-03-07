package com.facebook.feed.ui.attachments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.server.QuestionUpdatePollOptionHelper;
import com.facebook.graphql.model.GraphQLQuestionOption;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.groups.composer.groupspollcomposer.GroupsPollOptionValidator;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Tried to increment non-existent cookie */
public class QuestionAddPollOptionDialogFragment extends FbDialogFragment {
    @Inject
    public QuestionUpdatePollOptionHelper am;
    public String an;
    public FeedProps<GraphQLStoryAttachment> ao;

    /* compiled from: Tried to increment non-existent cookie */
    class C18471 implements OnKeyListener {
        final /* synthetic */ QuestionAddPollOptionDialogFragment f21834a;

        C18471(QuestionAddPollOptionDialogFragment questionAddPollOptionDialogFragment) {
            this.f21834a = questionAddPollOptionDialogFragment;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 66) {
                return true;
            }
            return false;
        }
    }

    public static void m24422a(Object obj, Context context) {
        ((QuestionAddPollOptionDialogFragment) obj).am = QuestionUpdatePollOptionHelper.m24242a(FbInjector.get(context));
    }

    public final void m24423a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 826024378);
        super.a(bundle);
        Class cls = QuestionAddPollOptionDialogFragment.class;
        m24422a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 309198410, a);
    }

    public final Dialog m24424c(Bundle bundle) {
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.an = bundle2.getString("question_id");
            this.ao = (FeedProps) bundle2.getParcelable("story_attachment");
        }
        Builder builder = new Builder(getContext());
        builder.a(b(2131237735));
        final View editText = new EditText(getContext());
        editText.setLayoutParams(new LayoutParams(-1, -1));
        editText.setFilters(new InputFilter[]{new LengthFilter(140)});
        editText.setOnKeyListener(new C18471(this));
        builder.b(editText);
        builder.a(b(2131230756), new OnClickListener(this) {
            public final /* synthetic */ QuestionAddPollOptionDialogFragment f21839b;

            /* compiled from: Tried to increment non-existent cookie */
            class C18481 implements OnClickListener {
                final /* synthetic */ C18502 f21835a;

                C18481(C18502 c18502) {
                    this.f21835a = c18502;
                }

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }

            /* compiled from: Tried to increment non-existent cookie */
            public class C18492 {
                public ProgressDialog f21836a;
                public final /* synthetic */ C18502 f21837b;

                C18492(C18502 c18502) {
                    this.f21837b = c18502;
                }

                public final void m24420b() {
                    if (this.f21836a != null) {
                        this.f21836a.dismiss();
                    }
                }
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                List list;
                QuestionAddPollOptionDialogFragment.m24421a(this.f21839b, editText);
                String obj = editText.getText().toString();
                QuestionAddPollOptionDialogFragment questionAddPollOptionDialogFragment = this.f21839b;
                List arrayList = new ArrayList();
                GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) questionAddPollOptionDialogFragment.ao.a;
                if (graphQLStoryAttachment == null || graphQLStoryAttachment.z() == null || graphQLStoryAttachment.z().eV() == null) {
                    list = arrayList;
                } else {
                    ImmutableList a = graphQLStoryAttachment.z().eV().a();
                    int size = a.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(((GraphQLQuestionOption) a.get(i2)).k().a());
                    }
                    list = arrayList;
                }
                CharSequence a2 = GroupsPollOptionValidator.a(obj, list, this.f21839b.getContext());
                if (a2 != null) {
                    Builder builder = new Builder(this.f21839b.getContext());
                    builder.b(a2);
                    builder.a(this.f21839b.b(2131230756), new C18481(this));
                    builder.a().show();
                    return;
                }
                this.f21839b.am.m24246a(obj.trim(), this.f21839b.an, this.f21839b.ao, new C18492(this));
            }
        });
        builder.b(b(2131234757), new OnClickListener(this) {
            final /* synthetic */ QuestionAddPollOptionDialogFragment f21841b;

            public void onClick(DialogInterface dialogInterface, int i) {
                QuestionAddPollOptionDialogFragment.m24421a(this.f21841b, editText);
            }
        });
        AlertDialog a = builder.a();
        a.setCanceledOnTouchOutside(true);
        return a;
    }

    public static void m24421a(QuestionAddPollOptionDialogFragment questionAddPollOptionDialogFragment, EditText editText) {
        ((InputMethodManager) questionAddPollOptionDialogFragment.getContext().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }
}
