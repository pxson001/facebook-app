package com.facebook.storyteller;

import com.facebook.common.references.CloseableReference;
import com.facebook.compactdisk.PersistentKeyValueStore;
import com.facebook.compactdisk.StoreManagerFactory;
import com.facebook.compactdiskmodule.StoreManagerFactoryMethodAutoProvider;
import com.facebook.friendsharing.souvenirs.abtest.ExperimentsForSouvenirAbtestModule;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.media.MediaItem;
import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;
import com.facebook.storyteller.models.CheckPoints;
import com.facebook.storyteller.models.Cluster;
import com.facebook.storyteller.models.Config;
import com.facebook.storyteller.models.StoryTellerItem;
import com.facebook.xanalytics.XAnalyticsNative;
import com.facebook.xanalytics.provider.DefaultXAnalyticsProvider;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.Table;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.List;
import javax.inject.Inject;

/* compiled from: media is null */
public class StoryTeller implements Closeable {
    public final CloseableReference<AssetProvider4a> f9024a;
    public final ImageSimilarity4a f9025b;
    private final StoreManagerFactory f9026c;
    private final DefaultXAnalyticsProvider f9027d;
    public final StoryTellerConfig f9028e;
    private final OneTimeStoryGenerator f9029f = new OneTimeStoryGenerator(this);
    private StorytellerHybrid f9030g;

    /* compiled from: media is null */
    class OneTimeStoryGenerator {
        byte[][] f9021a;
        int f9022b = -1;
        final /* synthetic */ StoryTeller f9023c;

        public OneTimeStoryGenerator(StoryTeller storyTeller) {
            this.f9023c = storyTeller;
        }

        final StoryTellerItem m10747a() {
            byte[][] bArr;
            int i;
            if (this.f9022b < 0) {
                List a = ((AssetProvider4a) this.f9023c.f9024a.a()).m10740a();
                if (a == null) {
                    return StoryTeller.m10750d();
                }
                StorytellerHybrid c = StoryTeller.m10749c(this.f9023c);
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int size = a.size();
                int[] iArr = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr[i2] = AssetProviderUtil.m10742a(flatBufferBuilder, (MediaItem) a.get(i2));
                }
                flatBufferBuilder.a(4, iArr.length, 4);
                for (int length = iArr.length - 1; length >= 0; length--) {
                    flatBufferBuilder.a(iArr[length]);
                }
                int a2 = Cluster.a(flatBufferBuilder, 0, 0, flatBufferBuilder.b());
                StoryTellerItem.a(flatBufferBuilder);
                StoryTellerItem.a(flatBufferBuilder, (byte) 4);
                StoryTellerItem.c(flatBufferBuilder, a2);
                flatBufferBuilder.c(StoryTellerItem.b(flatBufferBuilder));
                this.f9021a = c.allClustersFromAssets(flatBufferBuilder.e(), this.f9023c.f9025b, this.f9023c.f9028e.m10756a());
                if (this.f9021a == null || this.f9021a.length == 0) {
                    return StoryTeller.m10750d();
                }
                this.f9022b = 0;
                bArr = this.f9021a;
                i = this.f9022b;
                this.f9022b = i + 1;
                return StoryTellerItem.a(ByteBuffer.wrap(bArr[i]));
            } else if (this.f9022b >= this.f9021a.length) {
                return StoryTeller.m10750d();
            } else {
                bArr = this.f9021a;
                i = this.f9022b;
                this.f9022b = i + 1;
                return StoryTellerItem.a(ByteBuffer.wrap(bArr[i]));
            }
        }
    }

    /* compiled from: media is null */
    class StorytellerHybrid {
        private final HybridData mHybridData;

        private static native HybridData initHybrid(PersistentKeyValueStore persistentKeyValueStore, XAnalyticsNative xAnalyticsNative);

        public native byte[][] allClustersFromAssets(byte[] bArr, ImageSimilarity4a imageSimilarity4a, byte[] bArr2);

        public native byte[] nextCluster(AssetProvider4a assetProvider4a, ImageSimilarity4a imageSimilarity4a, byte[] bArr);

        static {
            SoLoader.a("storyteller4a");
        }

        StorytellerHybrid(PersistentKeyValueStore persistentKeyValueStore, XAnalyticsNative xAnalyticsNative) {
            this.mHybridData = initHybrid(persistentKeyValueStore, xAnalyticsNative);
        }
    }

    public static StoryTeller m10748b(InjectorLike injectorLike) {
        return new StoryTeller(AssetProvider4a.m10738b(injectorLike), ImageSimilarity4a.m10746b(injectorLike), StoreManagerFactoryMethodAutoProvider.a(injectorLike), DefaultXAnalyticsProvider.a(injectorLike), StoryTellerConfig.m10752a(injectorLike));
    }

    @Inject
    public StoryTeller(AssetProvider4a assetProvider4a, ImageSimilarity4a imageSimilarity4a, StoreManagerFactory storeManagerFactory, DefaultXAnalyticsProvider defaultXAnalyticsProvider, StoryTellerConfig storyTellerConfig) {
        this.f9024a = CloseableReference.a(assetProvider4a);
        this.f9025b = imageSimilarity4a;
        this.f9026c = storeManagerFactory;
        this.f9027d = defaultXAnalyticsProvider;
        this.f9028e = storyTellerConfig;
    }

    public final StoryTellerItem m10751a() {
        if (this.f9028e.f9034c.a(ExperimentsForSouvenirAbtestModule.E, false)) {
            return this.f9029f.m10747a();
        }
        byte[] a = this.f9028e.m10756a();
        Config a2 = Config.m10765a(ByteBuffer.wrap(a));
        StorytellerHybrid c = m10749c(this);
        Object obj = null;
        int a3 = a2.a(12);
        if (!(a3 == 0 || a2.b.get(a3 + a2.a) == (byte) 0)) {
            obj = 1;
        }
        if (obj != null) {
            CheckPoints checkPoints;
            CheckPoints checkPoints2 = new CheckPoints();
            a3 = a2.a(14);
            if (a3 != 0) {
                a3 = a2.b(a3 + a2.a);
                ByteBuffer byteBuffer = a2.b;
                checkPoints2.a = a3;
                checkPoints2.b = byteBuffer;
                checkPoints = checkPoints2;
            } else {
                checkPoints = null;
            }
            Table table = checkPoints;
            obj = null;
            a3 = table.a(4);
            if (!(a3 == 0 || table.b.get(a3 + table.a) == (byte) 0)) {
                obj = 1;
            }
            if (obj != null) {
                return m10750d();
            }
        }
        byte[] nextCluster = c.nextCluster((AssetProvider4a) this.f9024a.a(), this.f9025b, a);
        if (nextCluster == null) {
            return m10750d();
        }
        return StoryTellerItem.a(ByteBuffer.wrap(nextCluster));
    }

    public void close() {
        this.f9024a.close();
    }

    public static synchronized StorytellerHybrid m10749c(StoryTeller storyTeller) {
        StorytellerHybrid storytellerHybrid;
        XAnalyticsNative xAnalyticsNative = null;
        synchronized (storyTeller) {
            if (storyTeller.f9030g == null) {
                PersistentKeyValueStore a;
                if (storyTeller.f9028e.m10758c()) {
                    a = storyTeller.f9026c.a("diskstoremanager_fb4a").a("storyteller-pkvs");
                } else {
                    a = null;
                }
                if (storyTeller.f9028e.m10759d()) {
                    xAnalyticsNative = storyTeller.f9027d.r_();
                }
                storytellerHybrid = new StorytellerHybrid(a, xAnalyticsNative);
            } else {
                storytellerHybrid = storyTeller.f9030g;
            }
        }
        return storytellerHybrid;
    }

    public static StoryTellerItem m10750d() {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(256);
        StoryTellerItem.a(flatBufferBuilder);
        StoryTellerItem.a(flatBufferBuilder, (byte) 0);
        flatBufferBuilder.c(StoryTellerItem.b(flatBufferBuilder));
        return StoryTellerItem.a(flatBufferBuilder.a);
    }
}
