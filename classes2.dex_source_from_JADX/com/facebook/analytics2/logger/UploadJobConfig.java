package com.facebook.analytics2.logger;

import android.os.Bundle;
import java.io.File;
import javax.annotation.Nullable;

/* compiled from: t_stp */
public class UploadJobConfig {
    private final File f3432a;
    private final String f3433b;
    @Nullable
    private final String f3434c;
    private final String f3435d;
    private final UploadJob$Priority f3436e;
    private final String f3437f;

    /* compiled from: t_stp */
    public interface PrimitiveMapWriter<T> {
        T mo780a();

        void a_(String str, int i);

        void a_(String str, String str2);
    }

    public UploadJobConfig(File file, CommonUploadSchedulerParams commonUploadSchedulerParams) {
        if (commonUploadSchedulerParams.f3338a == null) {
            throw new IllegalArgumentException("uploader required");
        }
        this.f3433b = commonUploadSchedulerParams.f3338a.getName();
        this.f3434c = commonUploadSchedulerParams.f3339b != null ? commonUploadSchedulerParams.f3339b.getName() : null;
        this.f3435d = commonUploadSchedulerParams.f3340c.getName();
        if (file == null) {
            throw new IllegalArgumentException("priorityDir required");
        }
        this.f3432a = file;
        if (commonUploadSchedulerParams.f3341d == null) {
            throw new IllegalArgumentException("networkPriority required");
        }
        this.f3436e = commonUploadSchedulerParams.f3341d;
        if (commonUploadSchedulerParams.f3342e == null) {
            throw new IllegalArgumentException("marauderTier required");
        }
        this.f3437f = commonUploadSchedulerParams.f3342e;
    }

    public UploadJobConfig(Bundle bundle) {
        this(new BundlePrimitiveMapper(bundle));
    }

    public UploadJobConfig(PrimitiveMapReader primitiveMapReader) {
        String a = primitiveMapReader.a("uploader_class", null);
        if (a == null) {
            throw new IllegalRemoteArgumentException("uploader_class is null or empty");
        }
        String a2 = primitiveMapReader.a("flexible_sampling_updater", null);
        String a3 = primitiveMapReader.a("thread_handler_factory", null);
        String a4 = primitiveMapReader.a("priority_dir", null);
        if (a4 == null) {
            throw new IllegalRemoteArgumentException("priority_dir is null or empty");
        }
        int a5 = primitiveMapReader.a("network_priority", UploadJob$Priority.NORMAL.ordinal());
        String a6 = primitiveMapReader.a("marauder_tier", null);
        if (a6 == null) {
            throw new IllegalRemoteArgumentException("marauder_tier is null or empty");
        }
        this.f3433b = a;
        this.f3434c = a2;
        this.f3435d = a3;
        this.f3432a = new File(a4);
        this.f3436e = UploadJob$Priority.values()[a5];
        this.f3437f = a6;
    }

    public final String m5646a() {
        return this.f3433b;
    }

    @Nullable
    public final String m5647b() {
        return this.f3434c;
    }

    @Nullable
    public final String m5648c() {
        return this.f3435d;
    }

    public final File m5649d() {
        return this.f3432a;
    }

    public final UploadJob$Priority m5650e() {
        return this.f3436e;
    }

    public final String m5651f() {
        return this.f3437f;
    }

    public final <T> T m5645a(PrimitiveMapWriter<T> primitiveMapWriter) {
        primitiveMapWriter.a_("uploader_class", this.f3433b);
        primitiveMapWriter.a_("flexible_sampling_updater", this.f3434c);
        primitiveMapWriter.a_("thread_handler_factory", this.f3435d);
        primitiveMapWriter.a_("priority_dir", this.f3432a.getAbsolutePath());
        primitiveMapWriter.a_("network_priority", this.f3436e.ordinal());
        primitiveMapWriter.a_("marauder_tier", this.f3437f);
        return primitiveMapWriter.mo780a();
    }
}
