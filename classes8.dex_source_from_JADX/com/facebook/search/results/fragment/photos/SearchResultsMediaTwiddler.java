package com.facebook.search.results.fragment.photos;

import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModelType;
import com.facebook.photos.pandora.common.data.model.PandoraSingleMediaModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.LinkedList;
import java.util.List;

/* compiled from: SENT_CODE_EMAIL */
public class SearchResultsMediaTwiddler {
    private List<PandoraDataModel> f23071a = new LinkedList();
    private int f23072b;

    public final ImmutableList<PandoraDataModel> m26732a(ImmutableList<PandoraDataModel> immutableList, boolean z) {
        Builder builder = ImmutableList.builder();
        int i = 0;
        while (i < immutableList.size()) {
            if (((PandoraDataModel) immutableList.get(i)).mo1041a() != PandoraDataModelType.SINGLE_MEDIA || !((PandoraSingleMediaModel) immutableList.get(i)).f17370a.p()) {
                builder.c(immutableList.get(i));
                this.f23072b--;
                if (this.f23071a.size() > 0 && this.f23072b <= 0) {
                    builder.c(this.f23071a.remove(0));
                    this.f23072b = 6;
                }
            } else if (this.f23072b > 0) {
                this.f23071a.add(immutableList.get(i));
            } else {
                builder.c(immutableList.get(i));
                this.f23072b = 6;
            }
            i++;
        }
        if (!z) {
            builder.b(this.f23071a);
            this.f23071a.clear();
        }
        return builder.b();
    }
}
