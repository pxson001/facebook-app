package com.facebook.maps;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.android.maps.MapActivity;

/* compiled from: with_nested_story_length */
public class GoogleEmbeddableMapActivity extends MapActivity {
    private FrameLayout f196a;
    public FacebookMapView f197b;
    private Activity f198c;

    protected void onCreate(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 419805907);
        super.onCreate(bundle);
        this.f198c = getParent();
        String string = getIntent().getExtras().getString("API_KEY");
        setContentView(2130903965);
        this.f196a = (FrameLayout) findViewById(2131561165);
        this.f197b = new FacebookMapView(this, string);
        this.f197b.setLayoutParams(new LayoutParams(-1, -1));
        this.f196a.addView(this.f197b);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 776717124, a);
    }

    public boolean isRouteDisplayed() {
        return false;
    }

    public void onBackPressed() {
        this.f198c.onBackPressed();
    }

    public final FacebookMapView m167a() {
        return this.f197b;
    }
}
