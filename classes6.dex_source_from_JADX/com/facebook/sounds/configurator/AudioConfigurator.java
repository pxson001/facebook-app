package com.facebook.sounds.configurator;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.TextView;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.rebound.SimpleSpringListener;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringSystem;
import com.facebook.rebound.SpringUtil;
import com.facebook.rebound.ui.Util;
import com.facebook.sounds.configurator.AudioConfigRegistry.AudioConfig;
import com.facebook.sounds.configurator.AudioConfigRegistry.AudioConfigComparator;
import com.facebook.sounds.configurator.SoundUtil.C11311;
import com.facebook.sounds.configurator.SoundUtil.C11332;
import com.facebook.sounds.configurator.TextButton.TextButtonListener;
import com.facebook.sounds.configurator.prefs.AudioConfiguratorPrefKeys;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;

/* compiled from: event_reminder_members */
public class AudioConfigurator extends FrameLayout {
    public static final DecimalFormat f15991b = new DecimalFormat("#.###");
    @Inject
    public Lazy<AudioConfigRegistry> f15992a;
    private SpinnerAdapter f15993c;
    public final List<AudioConfig> f15994d;
    private Spring f15995e;
    public float f15996f;
    public float f15997g;
    public final int f15998h;
    private SeekBar f15999i;
    private Spinner f16000j;
    public AudioConfig f16001k;
    public EditText f16002l;
    private SeekBar f16003m;
    private TextView f16004n;
    public C11332 f16005o;
    public FbSharedPreferences f16006p;

    /* compiled from: event_reminder_members */
    class C11271 implements OnKeyListener {
        final /* synthetic */ AudioConfigurator f15979a;

        C11271(AudioConfigurator audioConfigurator) {
            this.f15979a = audioConfigurator;
        }

        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (this.f15979a.f16001k != null) {
                float parseFloat;
                try {
                    parseFloat = Float.parseFloat(this.f15979a.f16002l.getText().toString());
                } catch (NumberFormatException e) {
                    parseFloat = 1.0f;
                }
                parseFloat = Math.min(Math.max(0.0f, parseFloat), 1.0f);
                if (this.f15979a.f16002l.hasFocus() && parseFloat != this.f15979a.f16001k.m23609a()) {
                    this.f15979a.f16001k.m23610a(parseFloat);
                    this.f15979a.m23630a(this.f15979a.f16001k);
                    this.f15979a.f15994d;
                }
                if (keyEvent.getAction() == 0 && i == 66) {
                    this.f15979a.m23639c();
                }
            }
            return false;
        }
    }

    /* compiled from: event_reminder_members */
    class C11282 implements TextButtonListener {
        final /* synthetic */ AudioConfigurator f15980a;

        C11282(AudioConfigurator audioConfigurator) {
            this.f15980a = audioConfigurator;
        }

        public final void mo1233a() {
            this.f15980a.f16006p.edit().a(AudioConfiguratorPrefKeys.c, ((AudioConfigRegistry) this.f15980a.f15992a.get()).m23619c()).commit();
        }
    }

    /* compiled from: event_reminder_members */
    class C11293 implements TextButtonListener {
        final /* synthetic */ AudioConfigurator f15981a;

        C11293(AudioConfigurator audioConfigurator) {
            this.f15981a = audioConfigurator;
        }

        public final void mo1233a() {
            ((AudioConfigRegistry) this.f15981a.f15992a.get()).m23618b(this.f15981a.f16006p);
            this.f15981a.m23652a();
        }
    }

    /* compiled from: event_reminder_members */
    class C11304 implements TextButtonListener {
        final /* synthetic */ AudioConfigurator f15982a;

        C11304(AudioConfigurator audioConfigurator) {
            this.f15982a = audioConfigurator;
        }

        public final void mo1233a() {
            String c = ((AudioConfigRegistry) this.f15982a.f15992a.get()).m23619c();
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", c);
            intent.setType("text/plain");
            this.f15982a.getContext().startActivity(intent);
        }
    }

    /* compiled from: event_reminder_members */
    class AudioSelectedListener implements OnItemSelectedListener {
        final /* synthetic */ AudioConfigurator f15983a;

        public AudioSelectedListener(AudioConfigurator audioConfigurator) {
            this.f15983a = audioConfigurator;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            this.f15983a.f16001k = (AudioConfig) this.f15983a.f15994d.get(i);
            this.f15983a.m23630a(this.f15983a.f16001k);
            this.f15983a.f16002l.setText(AudioConfigurator.f15991b.format((double) this.f15983a.f16001k.f15974c));
            this.f15983a.f15994d;
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: event_reminder_members */
    class CurrentVolumeSeekBarListener implements OnSeekBarChangeListener {
        final /* synthetic */ AudioConfigurator f15984a;
        private boolean f15985b;

        public CurrentVolumeSeekBarListener(AudioConfigurator audioConfigurator) {
            this.f15984a = audioConfigurator;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            double a = SpringUtil.m23060a((double) i, 0.0d, 10000.0d, 0.0d, 1.0d);
            CharSequence format = AudioConfigurator.f15991b.format(a);
            if (this.f15985b && !this.f15984a.f16002l.getText().equals(format)) {
                this.f15984a.f16002l.setText(format);
            }
            this.f15984a.f16001k.f15974c = (float) a;
            this.f15984a.f16006p;
            if (this.f15984a.f16005o != null) {
                this.f15984a.f16005o.m23654a();
                this.f15984a.f16005o = null;
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            this.f15985b = true;
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f15985b = false;
            this.f15984a.m23639c();
        }
    }

    /* compiled from: event_reminder_members */
    class MasterVolumeSeekBarListener implements OnSeekBarChangeListener {
        final /* synthetic */ AudioConfigurator f15986a;

        public MasterVolumeSeekBarListener(AudioConfigurator audioConfigurator) {
            this.f15986a = audioConfigurator;
        }

        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            ((AudioConfigRegistry) this.f15986a.f15992a.get()).f15976a = (float) SpringUtil.m23060a((double) i, 0.0d, 10000.0d, 0.0d, 1.0d);
            this.f15986a.f15994d;
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            this.f15986a.m23639c();
        }
    }

    /* compiled from: event_reminder_members */
    class OnNubTouchListener implements OnTouchListener {
        final /* synthetic */ AudioConfigurator f15987a;

        public OnNubTouchListener(AudioConfigurator audioConfigurator) {
            this.f15987a = audioConfigurator;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.f15987a.m23645f();
            }
            return true;
        }
    }

    /* compiled from: event_reminder_members */
    class RevealerSpringListener extends SimpleSpringListener {
        final /* synthetic */ AudioConfigurator f15988a;

        public RevealerSpringListener(AudioConfigurator audioConfigurator) {
            this.f15988a = audioConfigurator;
        }

        public final void mo1220a(Spring spring) {
            float b = (float) spring.m23052b();
            float f = this.f15988a.f15997g;
            this.f15988a.setTranslationY((b * (this.f15988a.f15996f - f)) + f);
        }
    }

    /* compiled from: event_reminder_members */
    class SpinnerAdapter extends BaseAdapter {
        final /* synthetic */ AudioConfigurator f15989a;
        private final List<String> f15990b = new ArrayList();

        public SpinnerAdapter(AudioConfigurator audioConfigurator) {
            this.f15989a = audioConfigurator;
        }

        public int getCount() {
            return this.f15990b.size();
        }

        public Object getItem(int i) {
            return this.f15990b.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public final void m23626a(String str) {
            this.f15990b.add(str);
            Collections.sort(this.f15990b);
            AdapterDetour.a(this, -1537007948);
        }

        public final void m23625a() {
            this.f15990b.clear();
            AdapterDetour.a(this, 750612522);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new TextView(this.f15989a.getContext());
                view.setLayoutParams(new LayoutParams(-1, -1));
                int a = Util.m23061a(12.0f, this.f15989a.getResources());
                view.setPadding(a, a, a, a);
                view.setTextColor(this.f15989a.f15998h);
            } else {
                TextView textView = (TextView) view;
            }
            view.setText((CharSequence) this.f15990b.get(i));
            return view;
        }
    }

    private static <T extends View> void m23634a(Class<T> cls, T t) {
        m23635a((Object) t, t.getContext());
    }

    private static void m23635a(Object obj, Context context) {
        ((AudioConfigurator) obj).f15992a = IdBasedSingletonScopeProvider.b(FbInjector.get(context), 10993);
    }

    private void m23629a(Lazy<AudioConfigRegistry> lazy) {
        this.f15992a = lazy;
    }

    private void m23630a(AudioConfig audioConfig) {
        this.f15999i.setProgress(Math.round(((audioConfig.f15974c - 0.0f) * 10000.0f) / 1.0f));
        f15991b.format((double) audioConfig.f15974c);
    }

    private void m23631a(AudioConfigRegistry audioConfigRegistry) {
        this.f16003m.setProgress(Math.round(((audioConfigRegistry.f15976a - 0.0f) * 10000.0f) / 1.0f));
    }

    public AudioConfigurator(Context context) {
        this(context, null);
    }

    public AudioConfigurator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @TargetApi(16)
    public AudioConfigurator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f15994d = new ArrayList();
        this.f15998h = Color.argb(255, 225, 225, 225);
        m23634a(AudioConfigurator.class, (View) this);
        this.f15993c = new SpinnerAdapter(this);
        Resources resources = getResources();
        this.f15997g = (float) Util.m23061a(-30.0f, resources);
        this.f15996f = (float) Util.m23061a(-430.0f, resources);
        this.f15995e = SpringSystem.m23059b().m23035a();
        this.f15995e.m23049a(1.0d).m23053b(1.0d).m23051a(new RevealerSpringListener(this));
        addView(m23627a(context));
        OnSeekBarChangeListener currentVolumeSeekBarListener = new CurrentVolumeSeekBarListener(this);
        this.f15999i.setMax(10000);
        this.f15999i.setOnSeekBarChangeListener(currentVolumeSeekBarListener);
        OnSeekBarChangeListener masterVolumeSeekBarListener = new MasterVolumeSeekBarListener(this);
        this.f16003m.setMax(10000);
        this.f16003m.setProgress((int) Math.floor(SpringUtil.m23060a((double) ((AudioConfigRegistry) this.f15992a.get()).m23614a(), 0.0d, 1.0d, 0.0d, 10000.0d)));
        this.f16003m.setOnSeekBarChangeListener(masterVolumeSeekBarListener);
        this.f16000j.setAdapter(this.f15993c);
        this.f16000j.setOnItemSelectedListener(new AudioSelectedListener(this));
        m23652a();
        this.f16002l.setOnKeyListener(new C11271(this));
        setTranslationY(this.f15996f);
    }

    private void m23639c() {
        this.f16006p;
        if (this.f16001k.f15973b == 0) {
            new Builder(getContext()).b("Sound resource not found.").a("Error").b();
            return;
        }
        int i = this.f16001k.f15973b;
        Context context = getContext();
        AudioConfigRegistry audioConfigRegistry = (AudioConfigRegistry) this.f15992a.get();
        HandlerThread handlerThread = new HandlerThread(UUID.randomUUID().toString());
        handlerThread.start();
        this.f16005o = new C11332(new C11311(handlerThread.getLooper(), i, false, context, audioConfigRegistry), false, context);
        this.f16005o.m23655a(true);
    }

    public static void m23642d(AudioConfigurator audioConfigurator) {
        if (audioConfigurator.f16005o != null) {
            audioConfigurator.f16005o.m23654a();
            audioConfigurator.f16005o = null;
        }
    }

    @TargetApi(16)
    private View m23627a(Context context) {
        Resources resources = getResources();
        int a = Util.m23061a(5.0f, resources);
        int a2 = Util.m23061a(10.0f, resources);
        int a3 = Util.m23061a(20.0f, resources);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, Util.m23061a(460.0f, resources)));
        linearLayout.setGravity(81);
        View linearLayout2 = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, Util.m23061a(430.0f, resources));
        layoutParams.gravity = 48;
        layoutParams.setMargins(a2, 0, a2, 0);
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setPadding(a3, 0, a3, 0);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(Color.argb(200, 0, 0, 0));
        linearLayout2.setClipToPadding(false);
        linearLayout.addView(linearLayout2);
        this.f16000j = new Spinner(context, 1);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, Util.m23061a(40.0f, resources), 0, a2);
        this.f16000j.setLayoutParams(layoutParams);
        this.f16000j.setBackgroundResource(2130839575);
        this.f16000j.setPopupBackgroundResource(2130839575);
        linearLayout2.addView(this.f16000j);
        View textView = new TextView(context);
        textView.setText("Current Sound Volume:");
        textView.setTextColor(-3355444);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, a2, 0, 0);
        textView.setLayoutParams(layoutParams2);
        linearLayout2.addView(textView);
        this.f16002l = new EditText(context);
        this.f16002l.setInputType(8194);
        this.f16002l.setGravity(3);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, a, 0, a);
        this.f16002l.setLayoutParams(layoutParams);
        this.f16002l.setTextColor(-1);
        linearLayout2.addView(this.f16002l);
        this.f15999i = new SeekBar(context);
        layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(-a2, a2, -a2, a3);
        this.f15999i.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f15999i);
        View textView2 = new TextView(context);
        textView2.setText("Master Volume:");
        textView2.setTextColor(-3355444);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout2.addView(textView2);
        this.f16004n = new TextView(context);
        this.f16004n.setInputType(8194);
        this.f16004n.setBackground(this.f16002l.getBackground());
        this.f16004n.setTextColor(-1);
        this.f16004n.setTextSize(0, this.f16002l.getTextSize());
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(0, a, 0, a);
        this.f16004n.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.f16004n);
        this.f16003m = new SeekBar(context);
        ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(-a2, a2, -a2, a2);
        this.f16003m.setLayoutParams(layoutParams4);
        layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.setMargins(-a2, a2, -a2, a2);
        this.f16003m.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.f16003m);
        View linearLayout3 = new LinearLayout(context);
        layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setPadding(a2, a2, a2, 0);
        linearLayout3.setClipToPadding(false);
        linearLayout3.setLayoutParams(layoutParams3);
        linearLayout2.addView(linearLayout3);
        View frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        linearLayout3.addView(frameLayout);
        frameLayout = new TextButton(context);
        frameLayout.setText("Save");
        frameLayout.setTextColor(-1);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.f16043b = new C11282(this);
        linearLayout3.addView(frameLayout);
        frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        linearLayout3.addView(frameLayout);
        frameLayout = new TextButton(context);
        frameLayout.setText("Clear");
        frameLayout.setTextColor(-1);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.f16043b = new C11293(this);
        linearLayout3.addView(frameLayout);
        frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1, 1.0f));
        linearLayout3.addView(frameLayout);
        frameLayout = new TextButton(context);
        frameLayout.setText("Share");
        frameLayout.setTextColor(-1);
        layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.f16043b = new C11304(this);
        linearLayout3.addView(frameLayout);
        linearLayout3 = new TextView(context);
        ViewGroup.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(Util.m23061a(60.0f, resources), Util.m23061a(30.0f, resources));
        layoutParams5.gravity = 81;
        linearLayout3.setLayoutParams(layoutParams5);
        linearLayout3.setOnTouchListener(new OnNubTouchListener(this));
        linearLayout3.setBackgroundColor(Color.argb(255, 0, 164, 209));
        linearLayout3.setText("audio");
        linearLayout3.setGravity(17);
        linearLayout3.setTextColor(-1);
        linearLayout.addView(linearLayout3);
        return linearLayout;
    }

    public final void m23652a() {
        this.f15993c.m23625a();
        this.f15994d.clear();
        for (AudioConfig audioConfig : ((AudioConfigRegistry) this.f15992a.get()).m23617b()) {
            this.f15994d.add(audioConfig);
            this.f15993c.m23626a(audioConfig.f15972a);
        }
        Collections.sort(this.f15994d, new AudioConfigComparator());
        AdapterDetour.a(this.f15993c, 2053637496);
        if (this.f15994d.size() > 0) {
            this.f16000j.setSelection(0);
            this.f16001k = (AudioConfig) this.f15994d.get(0);
            m23630a(this.f16001k);
            this.f16002l.setText(f15991b.format((double) this.f16001k.f15974c));
            this.f15994d;
            m23631a((AudioConfigRegistry) this.f15992a.get());
        }
    }

    public void setFbSharedPreferences(FbSharedPreferences fbSharedPreferences) {
        this.f16006p = fbSharedPreferences;
    }

    public static void m23644e(AudioConfigurator audioConfigurator) {
        audioConfigurator.f16004n.setText(f15991b.format((double) Math.min(((AudioConfigRegistry) audioConfigurator.f15992a.get()).f15976a, 1.0f)));
    }

    private void m23645f() {
        double d = 1.0d;
        double d2 = this.f15995e.f15434i;
        Spring spring = this.f15995e;
        if (d2 == 1.0d) {
            d = 0.0d;
        }
        spring.m23053b(d);
    }
}
