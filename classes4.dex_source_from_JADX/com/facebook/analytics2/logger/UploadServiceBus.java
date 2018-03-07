package com.facebook.analytics2.logger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.SimpleArrayMap;
import java.io.File;
import java.util.ArrayList;
import javax.annotation.Nullable;

/* compiled from: wifi_signal_level_threshold */
class UploadServiceBus {
    UploadServiceBus() {
    }

    public static void m95a(Context context, int i, @Nullable String str, boolean z, SimpleArrayMap<String, File> simpleArrayMap) {
        JobRanResult jobRanResult = new JobRanResult(i, str, z, simpleArrayMap);
        Intent intent = new Intent("com.facebook.analytics2.action.UPLOAD_JOB_RAN").setPackage(context.getPackageName());
        Bundle bundle = new Bundle();
        bundle.putInt("job_id", jobRanResult.a);
        bundle.putString("hack_action", jobRanResult.b);
        bundle.putBoolean("will_retry", jobRanResult.c);
        int size = jobRanResult.d.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            File file = (File) jobRanResult.d.c(i2);
            arrayList.add(jobRanResult.d.b(i2));
            arrayList2.add(file != null ? file.getAbsolutePath() : null);
        }
        bundle.putStringArrayList("successful_processes", arrayList);
        bundle.putStringArrayList("newest_files_uploaded", arrayList2);
        context.sendBroadcast(intent.putExtras(bundle));
    }
}
