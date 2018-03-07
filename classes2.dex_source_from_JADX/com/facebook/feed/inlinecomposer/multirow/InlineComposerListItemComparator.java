package com.facebook.feed.inlinecomposer.multirow;

import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.rows.core.ListItemComparator;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Objects;

/* compiled from: perf */
public class InlineComposerListItemComparator implements ListItemComparator<InlineComposerModel> {
    public final boolean mo1978a(Object obj, Object obj2) {
        InlineComposerModel inlineComposerModel = (InlineComposerModel) obj;
        InlineComposerModel inlineComposerModel2 = (InlineComposerModel) obj2;
        if (inlineComposerModel == null) {
            if (inlineComposerModel2 == null) {
                return true;
            }
            return false;
        } else if (inlineComposerModel == inlineComposerModel2) {
            return true;
        } else {
            Object obj3 = null;
            if (inlineComposerModel.f12906a.equals(inlineComposerModel2.f12906a) && inlineComposerModel.f12907b.equals(inlineComposerModel2.f12907b) && Objects.equal(inlineComposerModel.f12908c, inlineComposerModel2.f12908c) && inlineComposerModel.f12918m == inlineComposerModel2.f12918m && inlineComposerModel.f12914i.equals(inlineComposerModel2.f12914i) && inlineComposerModel.f12915j.equals(inlineComposerModel2.f12915j) && inlineComposerModel.f12916k.equals(inlineComposerModel2.f12916k) && inlineComposerModel.f12917l.equals(inlineComposerModel2.f12917l) && inlineComposerModel.f12909d == inlineComposerModel2.f12909d && inlineComposerModel.f12911f == inlineComposerModel2.f12911f && inlineComposerModel.f12910e == inlineComposerModel2.f12910e && inlineComposerModel.f12919n == inlineComposerModel2.f12919n && inlineComposerModel.f12920o == inlineComposerModel2.f12920o && (inlineComposerModel.f12912g == inlineComposerModel2.f12912g || inlineComposerModel.f12912g.n().equals(inlineComposerModel2.f12912g.n()))) {
                obj3 = 1;
            }
            if (obj3 == null) {
                return false;
            }
            return true;
        }
    }

    public static InlineComposerListItemComparator m15303a(InjectorLike injectorLike) {
        return new InlineComposerListItemComparator();
    }

    public final boolean mo1979a(Object obj, Object obj2, long j) {
        return true;
    }
}
