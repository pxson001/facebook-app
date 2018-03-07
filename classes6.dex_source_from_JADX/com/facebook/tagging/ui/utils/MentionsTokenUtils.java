package com.facebook.tagging.ui.utils;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.graphql.utils.MentionsSpannableStringBuilder;
import com.facebook.user.model.Name;
import java.util.Locale;
import javax.inject.Inject;

/* compiled from: deltaNewGroupThread */
public class MentionsTokenUtils {
    private final Context f17595a;
    private final AbstractFbErrorReporter f17596b;
    private final QeAccessor f17597c;

    public static MentionsTokenUtils m25580b(InjectorLike injectorLike) {
        return new MentionsTokenUtils((Context) injectorLike.getInstance(Context.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public MentionsTokenUtils(Context context, AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor) {
        this.f17595a = context;
        this.f17596b = abstractFbErrorReporter;
        this.f17597c = qeAccessor;
    }

    public final int m25581a(MentionsSpannableStringBuilder mentionsSpannableStringBuilder, int i, Name name) {
        for (int i2 = i - 1; i2 >= 0; i2--) {
            switch (mentionsSpannableStringBuilder.charAt(i2)) {
                case '\n':
                    if (i2 + 1 >= i) {
                        break;
                    }
                    return i2 + 1;
                case ' ':
                    int i3 = i - 1;
                    int i4 = i3;
                    while (!Character.isWhitespace(mentionsSpannableStringBuilder.charAt(i4))) {
                        i4--;
                    }
                    if (name == null) {
                        i4++;
                    } else {
                        String i5 = name.i();
                        if (i5 == null) {
                            i4++;
                        } else {
                            int indexOf = i5.toLowerCase(Locale.getDefault()).indexOf(mentionsSpannableStringBuilder.subSequence(i4 + 1, i3 + 1).toString().toLowerCase(Locale.getDefault()));
                            if (indexOf <= 0) {
                                i4++;
                            } else {
                                int i6 = indexOf - 1;
                                indexOf = i4;
                                while (i6 >= 0) {
                                    if (Character.toLowerCase(mentionsSpannableStringBuilder.charAt(i4)) == Character.toLowerCase(i5.charAt(i6))) {
                                        if (Character.isWhitespace(mentionsSpannableStringBuilder.charAt(i4))) {
                                            if (mentionsSpannableStringBuilder.charAt(i4) == ' ') {
                                                indexOf = i4;
                                            } else if (i6 == 0) {
                                                i4++;
                                            } else if (Character.isLetter(i5.charAt(i6))) {
                                                i4 = indexOf + 1;
                                            } else {
                                                i4++;
                                            }
                                        }
                                        int i7 = i4 - 1;
                                        if (i7 >= 0) {
                                            i6--;
                                            i4 = i7;
                                        } else if (i6 == 0) {
                                            i4 = 0;
                                        } else if (Character.isLetterOrDigit(i5.charAt(i6 - 1))) {
                                            i4 = indexOf + 1;
                                        } else {
                                            i4 = 0;
                                        }
                                    } else if (Character.isLetter(mentionsSpannableStringBuilder.charAt(i4))) {
                                        i4 = indexOf + 1;
                                    } else if (i6 == 0) {
                                        i4 = indexOf + 1;
                                    } else if (Character.isLetter(i5.charAt(i6))) {
                                        i4 = indexOf + 1;
                                    } else {
                                        i4++;
                                    }
                                }
                                if (mentionsSpannableStringBuilder.charAt(i4) != '@') {
                                    if (Character.isLetterOrDigit(mentionsSpannableStringBuilder.charAt(i4))) {
                                        i4 = indexOf + 1;
                                    } else {
                                        i4++;
                                    }
                                }
                            }
                        }
                    }
                    i3 = i4;
                    if (mentionsSpannableStringBuilder.m25496a(i3)) {
                        return i2 + 1;
                    }
                    return i3;
                case '@':
                    return i2;
                default:
                    break;
            }
        }
        return 0;
    }

    public final CharSequence m25582a(MentionsSpannableStringBuilder mentionsSpannableStringBuilder, int i, int i2) {
        if (mentionsSpannableStringBuilder.length() <= i) {
            return "_";
        }
        if (i >= i2) {
            return "_";
        }
        if (mentionsSpannableStringBuilder.m25496a(i)) {
            return "_";
        }
        if (i > 0 && mentionsSpannableStringBuilder.m25496a(i - 1)) {
            return "_";
        }
        CharSequence subSequence;
        switch (mentionsSpannableStringBuilder.charAt(i)) {
            case '#':
            case '@':
                subSequence = mentionsSpannableStringBuilder.subSequence(i + 1, i2);
                if (subSequence.length() >= this.f17597c.a(ExperimentsForTaggingABTestModule.f17308g, 1)) {
                    return subSequence;
                }
                break;
        }
        subSequence = mentionsSpannableStringBuilder.subSequence(i, i2);
        return subSequence.length() < this.f17597c.a(ExperimentsForTaggingABTestModule.f17309h, 4) ? "_" : subSequence;
    }

    public final boolean m25583a(MentionsSpannableStringBuilder mentionsSpannableStringBuilder, int i, int i2, CharSequence charSequence) {
        return m25579a(mentionsSpannableStringBuilder, i, i2, charSequence, '@');
    }

    private boolean m25579a(MentionsSpannableStringBuilder mentionsSpannableStringBuilder, int i, int i2, CharSequence charSequence, char c) {
        CharSequence a = m25582a(mentionsSpannableStringBuilder, i2, i);
        if (a.toString().equals("_")) {
            this.f17596b.b("MentionsAutoCompleteTextView", "attempted to complete mention that isn't valid with start at : " + i2 + " in text: '" + mentionsSpannableStringBuilder + "' with '" + charSequence + "'.");
            return false;
        }
        if (((mentionsSpannableStringBuilder.length() - a.length()) - (mentionsSpannableStringBuilder.charAt(i2) == c ? 1 : 0)) + charSequence.length() <= this.f17595a.getResources().getInteger(2131492895)) {
            return true;
        }
        return false;
    }
}
