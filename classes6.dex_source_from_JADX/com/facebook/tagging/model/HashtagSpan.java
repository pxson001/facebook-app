package com.facebook.tagging.model;

import android.text.Editable;
import android.text.style.BackgroundColorSpan;

/* compiled from: deltaSentMessage */
public class HashtagSpan extends BackgroundColorSpan implements HighlightableSpan {
    public HashtagSpan(int i) {
        super(i);
    }

    public final int mo1323a(Editable editable) {
        return editable.getSpanStart(this);
    }

    public final int mo1324b(Editable editable) {
        return editable.getSpanEnd(this);
    }
}
