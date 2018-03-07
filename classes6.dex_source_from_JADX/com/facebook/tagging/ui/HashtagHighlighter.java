package com.facebook.tagging.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.hashtag.parser.HashtagParser;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.tagging.model.HashtagSpan;
import com.facebook.tagging.model.HighlightableSpan;
import com.facebook.tagging.model.MentionSpan;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: deltaNoOp */
public class HashtagHighlighter implements TextWatcher {
    public MentionsAutoCompleteTextView f17574a;

    public HashtagHighlighter(MentionsAutoCompleteTextView mentionsAutoCompleteTextView) {
        this.f17574a = mentionsAutoCompleteTextView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void afterTextChanged(Editable editable) {
        int i = 0;
        MentionsSpannableStringBuilder mentionsSpannableStringBuilder = (MentionsSpannableStringBuilder) this.f17574a.getEditableText();
        HashtagSpan[] hashtagSpanArr = (HashtagSpan[]) mentionsSpannableStringBuilder.getSpans(0, mentionsSpannableStringBuilder.length(), HashtagSpan.class);
        int length = hashtagSpanArr.length;
        while (i < length) {
            mentionsSpannableStringBuilder.removeSpan(hashtagSpanArr[i]);
            i++;
        }
        int i2 = 0;
        HighlightableSpan[] highlightableSpanArr = (HighlightableSpan[]) mentionsSpannableStringBuilder.getSpans(0, mentionsSpannableStringBuilder.length(), MentionSpan.class);
        List a = Lists.a(highlightableSpanArr.length);
        int length2 = highlightableSpanArr.length;
        while (i2 < length2) {
            HighlightableSpan highlightableSpan = highlightableSpanArr[i2];
            int a2 = highlightableSpan.mo1323a(mentionsSpannableStringBuilder);
            a.add(new UTF16Range(a2, highlightableSpan.mo1324b(mentionsSpannableStringBuilder) - a2));
            i2++;
        }
        for (UTF16Range a3 : new HashtagParser(this.f17574a.getUserText()).m17646a(a)) {
            mentionsSpannableStringBuilder.m25495a(a3, this.f17574a.getResources());
        }
    }
}
