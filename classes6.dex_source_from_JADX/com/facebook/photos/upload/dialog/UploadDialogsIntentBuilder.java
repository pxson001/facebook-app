package com.facebook.photos.upload.dialog;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.photos.upload.operation.UploadOperation;

/* compiled from: graph_search_v2_related_news_module */
public class UploadDialogsIntentBuilder {
    private Context f13604a;
    public String f13605b;
    public UploadOperation f13606c;
    public Intent f13607d;
    public Long f13608e;

    public UploadDialogsIntentBuilder(Context context) {
        this.f13604a = context;
    }

    public final Intent m21310a() {
        Intent intent = new Intent(this.f13604a, UploadDialogsActivity.class);
        intent.setAction(this.f13605b);
        intent.putExtra("upload_op", this.f13606c);
        if (this.f13607d != null) {
            intent.putExtra("retry_intent", this.f13607d);
        }
        if (this.f13608e != null) {
            intent.putExtra("eta", this.f13608e);
        }
        intent.setData(Uri.parse("content://upload/" + this.f13606c.f13793p));
        return intent;
    }
}
