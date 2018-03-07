package com.facebook.feedback.reactions.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.debug.log.BLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* compiled from: growth_users_invite */
public class FeedbackReactionDiskStaticAsset implements FeedbackReactionAsset {
    private static final Drawable f21486a = new ColorDrawable(0);
    private static final Class<?> f21487b = FeedbackReactionDiskStaticAsset.class;
    private final Context f21488c;
    private final File f21489d;
    private Drawable f21490e;

    public FeedbackReactionDiskStaticAsset(Context context, File file) {
        this.f21488c = context;
        this.f21489d = file;
    }

    public final Drawable mo3166a() {
        if (this.f21490e == null) {
            this.f21490e = m29194c();
        }
        return this.f21490e;
    }

    private Drawable m29194c() {
        try {
            if (!this.f21489d.exists()) {
                return f21486a.getConstantState().newDrawable();
            }
            InputStream fileInputStream = new FileInputStream(this.f21489d);
            Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            if (decodeStream != null) {
                return new BitmapDrawable(this.f21488c.getResources(), decodeStream);
            }
            return f21486a.getConstantState().newDrawable();
        } catch (Throwable e) {
            BLog.b(f21487b, "Failed to load image - ", e);
        } catch (Throwable e2) {
            BLog.b(f21487b, "Failed to load image - ", e2);
        }
    }

    public final boolean mo3167b() {
        return this.f21489d.exists();
    }
}
