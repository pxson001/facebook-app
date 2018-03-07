package com.facebook.quicksilver;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbImageButton;
import com.facebook.resources.ui.FbTextView;

/* compiled from: SONG_ID */
public class QuicksilverEndgameView extends LinearLayout {
    private LinearLayout f11353a;
    private FbTextView f11354b;
    private FbImageButton f11355c;
    public QuicksilverEndgameDelegate f11356d;

    /* compiled from: SONG_ID */
    class C13731 implements OnClickListener {
        final /* synthetic */ QuicksilverEndgameView f11352a;

        C13731(QuicksilverEndgameView quicksilverEndgameView) {
            this.f11352a = quicksilverEndgameView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 958817192);
            this.f11352a.f11356d.mo304a();
            Logger.a(2, EntryType.UI_INPUT_END, 1745731606, a);
        }
    }

    /* compiled from: SONG_ID */
    public interface QuicksilverEndgameDelegate {
        void mo304a();
    }

    public QuicksilverEndgameView(Context context) {
        this(context, null);
    }

    public QuicksilverEndgameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuicksilverEndgameView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11679a();
    }

    private void m11679a() {
        View.inflate(getContext(), 2130906562, this);
        m11680b();
        this.f11353a = (LinearLayout) findViewById(2131566519);
        this.f11354b = (FbTextView) findViewById(2131566521);
        ((FbTextView) findViewById(2131566520)).setText("SCORE");
    }

    public void setCallbackDelegate(QuicksilverEndgameDelegate quicksilverEndgameDelegate) {
        this.f11356d = quicksilverEndgameDelegate;
    }

    private void m11680b() {
        this.f11355c = (FbImageButton) findViewById(2131566522);
        this.f11355c.setOnClickListener(new C13731(this));
    }

    public void setScoreVisibility(boolean z) {
        if (z) {
            this.f11353a.setVisibility(0);
        } else {
            this.f11353a.setVisibility(4);
        }
    }

    public void setScore(int i) {
        this.f11354b.setText(Integer.toString(i));
        setScoreVisibility(true);
    }
}
