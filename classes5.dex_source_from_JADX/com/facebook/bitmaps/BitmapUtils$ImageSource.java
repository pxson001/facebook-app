package com.facebook.bitmaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import java.io.InputStream;

/* compiled from: android_app_config */
class BitmapUtils$ImageSource {
    private final byte[] f10359a = null;
    private final Uri f10360b;

    BitmapUtils$ImageSource(Uri uri) {
        this.f10360b = uri;
    }

    final Options m18441a(Context context) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if (this.f10359a != null) {
            BitmapFactory.decodeByteArray(this.f10359a, 0, this.f10359a.length, options);
        } else if (this.f10360b != null) {
            InputStream openInputStream = context.getContentResolver().openInputStream(this.f10360b);
            BitmapFactory.decodeStream(openInputStream, null, options);
            openInputStream.close();
        } else {
            throw new IllegalStateException("neither mData nor mUri are set");
        }
        return options;
    }

    final Bitmap m18440a(Context context, Options options) {
        if (this.f10359a != null) {
            return FbBitmapFactory.a(this.f10359a, 0, this.f10359a.length, options);
        }
        if (this.f10360b != null) {
            InputStream openInputStream = context.getContentResolver().openInputStream(this.f10360b);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, null, options);
                return decodeStream;
            } finally {
                openInputStream.close();
            }
        } else {
            throw new IllegalStateException("neither mData nor mUri are set");
        }
    }
}
