package com.facebook.analytics2.logger;

import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import java.io.File;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: terms_and_policy_text */
public class UploadServiceBus$JobRanResult {
    public final int f2078a;
    @Nullable
    public final String f2079b;
    public final boolean f2080c;
    public final SimpleArrayMap<String, File> f2081d;

    public UploadServiceBus$JobRanResult(int i, @Nullable String str, boolean z, SimpleArrayMap<String, File> simpleArrayMap) {
        if (i == -1) {
            throw new IllegalArgumentException("jobId = -1");
        }
        this.f2078a = i;
        this.f2079b = str;
        this.f2080c = z;
        this.f2081d = simpleArrayMap;
    }

    public UploadServiceBus$JobRanResult(Bundle bundle) {
        this(bundle.getInt("job_id", -1), bundle.getString("hack_action"), bundle.getBoolean("will_retry"), m2782a(bundle.getStringArrayList("successful_processes"), bundle.getStringArrayList("newest_files_uploaded")));
    }

    private static SimpleArrayMap<String, File> m2782a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        int size = arrayList.size();
        if (size != arrayList2.size()) {
            throw new IllegalArgumentException("processes has " + size + "; newestFilesUploaded has " + arrayList2.size());
        }
        SimpleArrayMap<String, File> simpleArrayMap = new SimpleArrayMap(size);
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList2.get(i);
            simpleArrayMap.put(arrayList.get(i), str != null ? new File(str) : null);
        }
        return simpleArrayMap;
    }
}
