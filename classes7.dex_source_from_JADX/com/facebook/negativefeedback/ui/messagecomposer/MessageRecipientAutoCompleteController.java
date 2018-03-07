package com.facebook.negativefeedback.ui.messagecomposer;

import android.text.Annotation;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.tagging.model.TaggingProfile;

/* compiled from: no_upgrade */
public class MessageRecipientAutoCompleteController {
    MessageRecipientAutoCompleteTextView f8112a;

    /* compiled from: no_upgrade */
    public class C06521 implements OnItemClickListener {
        final /* synthetic */ MessageRecipientAutoCompleteController f8110a;

        public C06521(MessageRecipientAutoCompleteController messageRecipientAutoCompleteController) {
            this.f8110a = messageRecipientAutoCompleteController;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            TaggingProfile taggingProfile = (TaggingProfile) adapterView.getAdapter().getItem(i);
            long j2 = taggingProfile.b;
            CharSequence i2 = taggingProfile.i();
            Annotation annotation = new Annotation(i2, Long.toString(j2));
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append(i2);
            spannableStringBuilder.setSpan(annotation, 0, spannableStringBuilder.length(), 0);
            this.f8110a.f8112a.setText(spannableStringBuilder);
        }
    }

    /* compiled from: no_upgrade */
    public class C06532 implements TextWatcher {
        final /* synthetic */ MessageRecipientAutoCompleteController f8111a;

        public C06532(MessageRecipientAutoCompleteController messageRecipientAutoCompleteController) {
            this.f8111a = messageRecipientAutoCompleteController;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int i4 = 0;
            Editable text = this.f8111a.f8112a.getText();
            Annotation[] annotationArr = (Annotation[]) text.getSpans(0, text.length(), Annotation.class);
            int length = annotationArr.length;
            while (i4 < length) {
                text.removeSpan(annotationArr[i4]);
                i4++;
            }
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public MessageRecipientAutoCompleteController(MessageRecipientAutoCompleteTextView messageRecipientAutoCompleteTextView) {
        this.f8112a = messageRecipientAutoCompleteTextView;
    }
}
