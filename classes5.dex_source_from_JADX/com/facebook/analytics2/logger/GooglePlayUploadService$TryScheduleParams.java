package com.facebook.analytics2.logger;

import android.os.Bundle;
import com.google.android.gms.gcm.OneoffTask;

/* compiled from: themeListImage */
class GooglePlayUploadService$TryScheduleParams {
    public final int f2010a;
    public final OneoffTask f2011b;

    public GooglePlayUploadService$TryScheduleParams(int i, OneoffTask oneoffTask) {
        this.f2010a = i;
        this.f2011b = oneoffTask;
    }

    public GooglePlayUploadService$TryScheduleParams(Bundle bundle) {
        int i = bundle.getInt("job_id", -1);
        if (i == -1) {
            throw new IllegalRemoteArgumentException("Invalid job_id: " + bundle.get("job_id"));
        }
        this.f2010a = i;
        OneoffTask oneoffTask = (OneoffTask) bundle.getParcelable("task");
        if (oneoffTask == null) {
            throw new IllegalRemoteArgumentException("Missing task");
        }
        this.f2011b = oneoffTask;
    }

    public final Bundle m2709a() {
        Bundle bundle = new Bundle();
        bundle.putInt("job_id", this.f2010a);
        bundle.putParcelable("task", this.f2011b);
        return bundle;
    }
}
