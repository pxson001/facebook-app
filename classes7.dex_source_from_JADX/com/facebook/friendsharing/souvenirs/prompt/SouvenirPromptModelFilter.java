package com.facebook.friendsharing.souvenirs.prompt;

import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem.Type;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel$Builder;
import com.facebook.friendsharing.souvenirs.models.SouvenirVideoItem;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: RESHARE_TOP */
public class SouvenirPromptModelFilter {
    private final QeAccessor f24096a;
    @Nullable
    private QeParams f24097b;

    /* compiled from: RESHARE_TOP */
    class QeParams {
        public final long f24093a;
        public final int f24094b;
        public final long f24095c;

        public QeParams(QeAccessor qeAccessor) {
            this.f24093a = TimeUnit.HOURS.toMillis((long) qeAccessor.a(ExperimentsForSouvenirAbtestModule.y, 24));
            this.f24094b = qeAccessor.a(ExperimentsForSouvenirAbtestModule.x, 5);
            this.f24095c = qeAccessor.a(ExperimentsForSouvenirAbtestModule.A, 0);
        }
    }

    @Inject
    public SouvenirPromptModelFilter(QeAccessor qeAccessor) {
        this.f24096a = qeAccessor;
    }

    @Nullable
    public final SouvenirModel m26222a(SouvenirModel souvenirModel, long j) {
        if (this.f24097b == null) {
            this.f24097b = new QeParams(this.f24096a);
        }
        if (j - souvenirModel.a().m26172d() > this.f24097b.f24093a) {
            return null;
        }
        int b = m26221b(souvenirModel);
        if (b == 0 || b < this.f24097b.f24094b) {
            return null;
        }
        return b != souvenirModel.b().size() ? m26219a(souvenirModel) : souvenirModel;
    }

    private SouvenirModel m26219a(SouvenirModel souvenirModel) {
        SouvenirModel$Builder souvenirModel$Builder = new SouvenirModel$Builder();
        souvenirModel$Builder.f24070b = souvenirModel.a();
        SouvenirModel$Builder souvenirModel$Builder2 = souvenirModel$Builder;
        ImmutableList b = souvenirModel.b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            SouvenirItem souvenirItem = (SouvenirItem) b.get(i);
            if (m26220a(souvenirItem)) {
                souvenirModel$Builder2.m26177a(souvenirItem);
            }
        }
        return souvenirModel$Builder2.m26179a();
    }

    private int m26221b(SouvenirModel souvenirModel) {
        ImmutableList b = souvenirModel.b();
        int size = b.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            if (m26220a((SouvenirItem) b.get(i))) {
                i3 = i2 + 1;
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return i2;
    }

    private boolean m26220a(SouvenirItem souvenirItem) {
        if (souvenirItem.hw_() != Type.Video) {
            return true;
        }
        long d = ((SouvenirVideoItem) souvenirItem).m26204d();
        if (d <= 0 || d >= this.f24097b.f24095c) {
            return false;
        }
        return true;
    }
}
