package com.facebook.tagging.model;

import android.content.res.Resources;
import android.text.Editable;
import android.text.style.BackgroundColorSpan;
import com.facebook.tagging.model.TaggingProfile.Type;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: deltaRtcCallData */
public class MentionSpan extends BackgroundColorSpan implements HighlightableSpan {
    public final TaggingProfile f17527a;
    public ArrayList<PartialMentionSpan> f17528b;

    /* compiled from: deltaRtcCallData */
    public /* synthetic */ class C12781 {
        public static final /* synthetic */ int[] f17523a = new int[Type.values().length];

        static {
            try {
                f17523a[Type.PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* compiled from: deltaRtcCallData */
    public class PartialMentionSpan {
        final /* synthetic */ MentionSpan f17524a;
        public final String f17525b;
        private final MentionSpan f17526c;

        public PartialMentionSpan(MentionSpan mentionSpan, String str, MentionSpan mentionSpan2) {
            this.f17524a = mentionSpan;
            this.f17525b = str;
            this.f17526c = mentionSpan2;
        }

        public final boolean m25515a(Editable editable) {
            int spanStart = editable.getSpanStart(this);
            int spanEnd = editable.getSpanEnd(this);
            if (spanStart == -1 || spanEnd == -1 || !this.f17525b.equals(editable.subSequence(spanStart, spanEnd).toString())) {
                return false;
            }
            if (spanStart > this.f17526c.mo1323a(editable) && editable.charAt(spanStart - 1) != ' ') {
                return false;
            }
            if (spanEnd >= this.f17526c.mo1324b(editable) || editable.charAt(spanEnd) == ' ') {
                return true;
            }
            return false;
        }
    }

    public MentionSpan(Resources resources, TaggingProfile taggingProfile) {
        super(resources.getColor(2131362915));
        this.f17527a = taggingProfile;
    }

    public final long m25523b() {
        return this.f17527a.f17539b;
    }

    public final int mo1323a(Editable editable) {
        return editable.getSpanStart(this.f17528b.get(0));
    }

    public final int mo1324b(Editable editable) {
        return editable.getSpanEnd(this.f17528b.get(this.f17528b.size() - 1));
    }

    public final void m25520a(Editable editable, int i) {
        int i2 = 0;
        this.f17528b = new ArrayList();
        String[] split = this.f17527a.f17538a.i().split(" ");
        int length = split.length;
        int i3 = 0;
        while (i2 < length) {
            String str = split[i2];
            PartialMentionSpan partialMentionSpan = new PartialMentionSpan(this, str, this);
            editable.setSpan(partialMentionSpan, i + i3, (i + i3) + str.length(), m25516a(this.f17528b.size()));
            this.f17528b.add(partialMentionSpan);
            i3 += str.length() + 1;
            i2++;
        }
    }

    public final int m25524d() {
        return this.f17528b.size();
    }

    public final void m25521a(Editable editable, boolean z) {
        PartialMentionSpan partialMentionSpan;
        int i = 0;
        int i2;
        int i3;
        int i4;
        int i5;
        if ((this.f17527a.m25531d() == Type.USER || this.f17527a.m25531d() == Type.SELF) && z) {
            Iterator it = this.f17528b.iterator();
            i2 = 0;
            i3 = 0;
            i4 = -1;
            int i6 = -1;
            while (it.hasNext()) {
                int i7;
                partialMentionSpan = (PartialMentionSpan) it.next();
                int spanStart = editable.getSpanStart(partialMentionSpan);
                int spanEnd = editable.getSpanEnd(partialMentionSpan);
                if (spanStart < 0 || spanEnd < 0) {
                    i7 = 0;
                } else {
                    i7 = 1;
                }
                if (i7 == 0) {
                    it.remove();
                } else if (partialMentionSpan.m25515a(editable)) {
                    if (i2 == 0 || r3 == 0 || spanStart <= 0 || editable.charAt(spanStart - 1) != ' ') {
                        i5 = i4;
                    } else {
                        i5 = i4 + 1;
                    }
                    i3 = 0;
                    i4 = i5;
                } else {
                    if (i6 != -1) {
                        i3 = i6;
                    } else if (partialMentionSpan == this.f17528b.get(0) || spanStart <= 0) {
                        i2 = 1;
                        i3 = spanStart;
                    } else {
                        i3 = editable.charAt(spanStart + -1) == ' ' ? spanStart - 1 : spanStart;
                    }
                    it.remove();
                    editable.removeSpan(partialMentionSpan);
                    i4 = spanEnd;
                    i6 = i3;
                    i3 = 1;
                }
            }
            if (i6 >= 0) {
                editable.delete(i6, i4);
            }
        } else {
            if (m25518c(editable)) {
                i5 = 0;
            } else {
                i5 = 1;
            }
            i4 = this.f17528b.size();
            i3 = 0;
            i2 = i5;
            while (i3 < i4) {
                if (((PartialMentionSpan) this.f17528b.get(i3)).m25515a(editable)) {
                    i5 = i2;
                } else {
                    i5 = 1;
                }
                i3++;
                i2 = i5;
            }
            if (i2 != 0) {
                i3 = mo1323a(editable);
                int b = mo1324b(editable);
                i4 = this.f17528b.size();
                for (i2 = 0; i2 < i4; i2++) {
                    editable.removeSpan((PartialMentionSpan) this.f17528b.get(i2));
                }
                editable.removeSpan(this);
                if (z && i3 >= 0 && b >= 0) {
                    editable.delete(i3, b);
                }
                this.f17528b.clear();
            }
        }
        while (i < this.f17528b.size()) {
            partialMentionSpan = (PartialMentionSpan) this.f17528b.get(i);
            editable.setSpan(partialMentionSpan, editable.getSpanStart(partialMentionSpan), editable.getSpanEnd(partialMentionSpan), m25516a(i));
            i++;
        }
    }

    private boolean m25518c(Editable editable) {
        if (this.f17528b.size() < 2) {
            return true;
        }
        int spanEnd = editable.getSpanEnd(this.f17528b.get(0));
        for (int i = 1; i < this.f17528b.size(); i++) {
            int spanStart = editable.getSpanStart(this.f17528b.get(i));
            if (!m25517b(editable, spanStart) || !m25517b(editable, r2) || editable.charAt(r2) != ' ' || spanStart - r2 != 1) {
                return false;
            }
            spanEnd = editable.getSpanEnd(this.f17528b.get(i));
        }
        return true;
    }

    private static boolean m25517b(Editable editable, int i) {
        return i >= 0 && i < editable.length();
    }

    private static int m25516a(int i) {
        if (i == 0) {
            return 33;
        }
        return 17;
    }
}
