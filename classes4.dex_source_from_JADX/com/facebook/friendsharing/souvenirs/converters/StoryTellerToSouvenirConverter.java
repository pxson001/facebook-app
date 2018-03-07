package com.facebook.friendsharing.souvenirs.converters;

import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.friendsharing.souvenirs.mediaitems.SouvenirsMediaItemsHelper;
import com.facebook.friendsharing.souvenirs.models.SouvenirBurstItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirMetadata.Builder;
import com.facebook.friendsharing.souvenirs.models.SouvenirModel;
import com.facebook.friendsharing.souvenirs.models.SouvenirPhotoItem;
import com.facebook.friendsharing.souvenirs.models.SouvenirVideoItem;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.storyteller.models.Asset;
import com.facebook.storyteller.models.Burst;
import com.facebook.storyteller.models.Cluster;
import com.facebook.storyteller.models.StoryTellerItem;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.flatbuffers.Table;
import javax.inject.Inject;

/* compiled from: greeting */
public class StoryTellerToSouvenirConverter {
    private final Burst f10983a = new Burst();
    private final StoryTellerItem f10984b = new StoryTellerItem();
    private final Cluster f10985c = new Cluster();
    private final StoryTellerItem f10986d = new StoryTellerItem();
    private final QeAccessor f10987e;
    private final SouvenirsMediaItemsHelper f10988f;

    @Inject
    public StoryTellerToSouvenirConverter(QeAccessor qeAccessor, SouvenirsMediaItemsHelper souvenirsMediaItemsHelper) {
        this.f10987e = qeAccessor;
        this.f10988f = souvenirsMediaItemsHelper;
    }

    public final SouvenirModel m11433a(StoryTellerItem storyTellerItem) {
        boolean z = true;
        Preconditions.checkNotNull(storyTellerItem);
        Preconditions.checkArgument(storyTellerItem.m11458c() == (byte) 4, m11428a(SouvenirModel.class.getSimpleName(), storyTellerItem.m11458c()));
        Builder builder = new Builder();
        builder.a = storyTellerItem.m11456a();
        SouvenirModel.Builder builder2 = new SouvenirModel.Builder();
        storyTellerItem.m11455a(this.f10985c);
        Table table = this.f10985c;
        int a = table.m11443a(8);
        if (a != 0) {
            a = table.m11446d(a);
        } else {
            a = 0;
        }
        int i = a;
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        for (int i2 = 0; i2 < i; i2++) {
            SouvenirItem d;
            table = this.f10985c;
            StoryTellerItem storyTellerItem2 = this.f10986d;
            a = table.m11443a(8);
            if (a != 0) {
                StoryTellerItem a2 = storyTellerItem2.m11454a(table.m11444b(table.m11447e(a) + (i2 * 4)), table.f10991b);
            }
            switch (this.f10986d.m11458c()) {
                case (byte) 1:
                    d = m11431d(this.f10986d);
                    break;
                case (byte) 2:
                    d = m11432e(this.f10986d);
                    break;
                case (byte) 3:
                    if (!this.f10987e.a(ExperimentsForSouvenirAbtestModule.q, false)) {
                        d = m11430c(this.f10986d);
                        break;
                    }
                    d = m11429b(this.f10986d);
                    break;
                default:
                    throw new IllegalArgumentException(m11427a((byte) 4, this.f10986d.m11458c()));
            }
            if (i2 == 0) {
                builder.c = (long) (this.f10986d.m11457b() * 1000.0d);
            }
            builder2.a(d);
        }
        builder.d = (long) (this.f10986d.m11457b() * 1000.0d);
        builder2.b = builder.a();
        return builder2.a();
    }

    @VisibleForTesting
    private SouvenirBurstItem m11429b(StoryTellerItem storyTellerItem) {
        boolean z;
        Preconditions.checkNotNull(storyTellerItem);
        Preconditions.checkArgument(storyTellerItem.m11458c() == (byte) 3, m11428a(SouvenirBurstItem.class.getSimpleName(), storyTellerItem.m11458c()));
        storyTellerItem.m11455a(this.f10983a);
        int b = this.f10983a.m11442b();
        if (b > 1) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "No assets contained in burst " + storyTellerItem.m11456a());
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i = 0; i < b; i++) {
            this.f10983a.m11441a(this.f10984b, i);
            if (this.f10984b.m11458c() == (byte) 1) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, m11427a((byte) 3, this.f10984b.m11458c()));
            builder.c(m11431d(this.f10984b));
        }
        return new SouvenirBurstItem(builder.b(), this.f10983a.m11440a());
    }

    @VisibleForTesting
    private SouvenirPhotoItem m11430c(StoryTellerItem storyTellerItem) {
        boolean z = true;
        Preconditions.checkNotNull(storyTellerItem);
        Preconditions.checkArgument(storyTellerItem.m11458c() == (byte) 3, m11428a(SouvenirBurstItem.class.getSimpleName(), storyTellerItem.m11458c()));
        storyTellerItem.m11455a(this.f10983a);
        int b = this.f10983a.m11442b();
        if (b <= 1) {
            z = false;
        }
        Preconditions.checkArgument(z, "No assets contained in burst " + storyTellerItem.m11456a());
        Preconditions.checkElementIndex(this.f10983a.m11440a(), b);
        this.f10983a.m11441a(this.f10984b, this.f10983a.m11440a());
        return m11431d(this.f10984b);
    }

    @VisibleForTesting
    private SouvenirPhotoItem m11431d(StoryTellerItem storyTellerItem) {
        boolean z = true;
        Preconditions.checkNotNull(storyTellerItem);
        if (storyTellerItem.m11458c() != (byte) 1) {
            z = false;
        }
        Preconditions.checkArgument(z, m11428a(SouvenirPhotoItem.class.getSimpleName(), storyTellerItem.m11458c()));
        return (SouvenirPhotoItem) this.f10988f.m11438a(MediaIdKey.a(storyTellerItem.m11456a()).b);
    }

    @VisibleForTesting
    private SouvenirVideoItem m11432e(StoryTellerItem storyTellerItem) {
        Preconditions.checkNotNull(storyTellerItem);
        Preconditions.checkArgument(storyTellerItem.m11458c() == (byte) 2, m11428a(SouvenirVideoItem.class.getSimpleName(), storyTellerItem.m11458c()));
        return (SouvenirVideoItem) this.f10988f.m11438a(MediaIdKey.a(storyTellerItem.m11456a()).b);
    }

    private static String m11428a(String str, byte b) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempted to construct a ");
        stringBuffer.append(str);
        stringBuffer.append(" from a StoryTellerItem with a ");
        stringBuffer.append(Asset.a(b));
        stringBuffer.append(" asset");
        return stringBuffer.toString();
    }

    private static String m11427a(byte b, byte b2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Asset.a(b));
        stringBuffer.append(" should not contain a ");
        stringBuffer.append(Asset.a(b2));
        return stringBuffer.toString();
    }
}
