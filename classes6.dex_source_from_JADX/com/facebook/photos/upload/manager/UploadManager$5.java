package com.facebook.photos.upload.manager;

import android.os.Bundle;
import com.facebook.common.executors.NamedRunnable;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.upload.disk.UploadTempFileManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.io.File;

/* compiled from: graph_search_results_page_app */
class UploadManager$5 extends NamedRunnable {
    final /* synthetic */ String f13642c;
    final /* synthetic */ UploadOperation f13643d;
    final /* synthetic */ UploadManager f13644e;

    UploadManager$5(UploadManager uploadManager, String str, String str2, String str3, UploadOperation uploadOperation) {
        this.f13644e = uploadManager;
        this.f13642c = str3;
        this.f13643d = uploadOperation;
        super(str, str2);
    }

    public void run() {
        ((UploadTempFileManager) this.f13644e.j.get()).m21338a(this.f13642c);
        this.f13644e.e.get();
        UploadOperation uploadOperation = this.f13643d;
        Preconditions.checkNotNull(uploadOperation);
        ImmutableList immutableList = uploadOperation.f13779b;
        if (immutableList != null && !immutableList.isEmpty()) {
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                Bundle bundle = (Bundle) immutableList.get(i);
                bundle.setClassLoader(CreativeEditingData.class.getClassLoader());
                String string = bundle.getString("temp_file_to_clean_up");
                if (!Strings.isNullOrEmpty(string)) {
                    new File(string).delete();
                }
            }
        }
    }
}
