package com.facebook.spherical.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;
import javax.inject.Inject;
import org.json.JSONObject;

@TargetApi(18)
/* compiled from: errorMessage */
public class PhotoVRCastPlugin extends FrameLayout {
    private static final String f16242d = PhotoVRCastPlugin.class.getSimpleName();
    @Inject
    public SecureContextHelper f16243a;
    @Inject
    public Photos360QEHelper f16244b;
    @Inject
    public SphericalPhotoAnalyticsLogger f16245c;
    public FbButton f16246e;
    public PhotoVRCastParams f16247f;
    public TriState f16248g;
    public final Runnable f16249h;

    /* compiled from: errorMessage */
    class C11411 implements Runnable {
        final /* synthetic */ PhotoVRCastPlugin f16240a;

        C11411(PhotoVRCastPlugin photoVRCastPlugin) {
            this.f16240a = photoVRCastPlugin;
        }

        public void run() {
            this.f16240a.f16246e.setVisibility(8);
        }
    }

    /* compiled from: errorMessage */
    public class C11422 implements OnClickListener {
        final /* synthetic */ PhotoVRCastPlugin f16241a;

        public C11422(PhotoVRCastPlugin photoVRCastPlugin) {
            this.f16241a = photoVRCastPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -475329546);
            PhotoVRCastPlugin.m23789d(this.f16241a);
            Logger.a(2, EntryType.UI_INPUT_END, 1762286194, a);
        }
    }

    public static void m23788a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PhotoVRCastPlugin photoVRCastPlugin = (PhotoVRCastPlugin) obj;
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        Photos360QEHelper a = Photos360QEHelper.a(fbInjector);
        SphericalPhotoAnalyticsLogger b = SphericalPhotoAnalyticsLogger.b(fbInjector);
        photoVRCastPlugin.f16243a = secureContextHelper;
        photoVRCastPlugin.f16244b = a;
        photoVRCastPlugin.f16245c = b;
    }

    public PhotoVRCastPlugin(Context context) {
        this(context, null);
    }

    private PhotoVRCastPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private PhotoVRCastPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16248g = TriState.UNSET;
        this.f16249h = new C11411(this);
        Class cls = PhotoVRCastPlugin.class;
        m23788a(this, getContext());
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(2130907759, this, true);
        this.f16246e = (FbButton) findViewById(2131568496);
        this.f16246e.setText(getResources().getString(2131232751));
    }

    public static void m23789d(PhotoVRCastPlugin photoVRCastPlugin) {
        photoVRCastPlugin.f16245c.a();
        photoVRCastPlugin.f16243a.b(photoVRCastPlugin.m23790e(), photoVRCastPlugin.getContext());
    }

    private Intent m23790e() {
        Intent intent = new Intent("com.oculus.oculus360photos.action.CAST");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("photo_uri", this.f16247f.m23785a());
            jSONObject.put("author", this.f16247f.m23786b());
            jSONObject.put("title", this.f16247f.m23787c());
        } catch (Throwable e) {
            BLog.b(f16242d, "Exception when applying json encoding", e);
        }
        intent.putExtra("intent_cmd", jSONObject.toString());
        return intent;
    }
}
