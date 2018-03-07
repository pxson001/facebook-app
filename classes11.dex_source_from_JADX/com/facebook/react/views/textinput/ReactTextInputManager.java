package com.facebook.react.views.textinput;

import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.SystemClock;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import java.util.LinkedList;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: list_item_groups */
public class ReactTextInputManager extends BaseViewManager<ReactEditText, LayoutShadowNode> {
    private static final InputFilter[] f5804a = new InputFilter[0];

    /* compiled from: list_item_groups */
    class ReactSelectionWatcher implements SelectionWatcher {
        final /* synthetic */ ReactTextInputManager f11602a;
        private ReactEditText f11603b;
        private EventDispatcher f11604c;
        private int f11605d;
        private int f11606e;

        public ReactSelectionWatcher(ReactTextInputManager reactTextInputManager, ReactEditText reactEditText) {
            this.f11602a = reactTextInputManager;
            this.f11603b = reactEditText;
            this.f11604c = ((UIManagerModule) ((ReactContext) reactEditText.getContext()).b(UIManagerModule.class)).a;
        }

        public final void mo323a(int i, int i2) {
            if (this.f11605d != i || this.f11606e != i2) {
                this.f11604c.a(new ReactTextInputSelectionEvent(this.f11603b.getId(), SystemClock.b(), i, i2));
                this.f11605d = i;
                this.f11606e = i2;
            }
        }
    }

    /* compiled from: list_item_groups */
    class ReactTextInputTextWatcher implements TextWatcher {
        final /* synthetic */ ReactTextInputManager f11607a;
        private EventDispatcher f11608b;
        private ReactEditText f11609c;
        private String f11610d = null;

        public ReactTextInputTextWatcher(ReactTextInputManager reactTextInputManager, ReactContext reactContext, ReactEditText reactEditText) {
            this.f11607a = reactTextInputManager;
            this.f11608b = ((UIManagerModule) reactContext.b(UIManagerModule.class)).a;
            this.f11609c = reactEditText;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.f11610d = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (i3 != 0 || i2 != 0) {
                Assertions.b(this.f11610d);
                String substring = charSequence.toString().substring(i, i + i3);
                String substring2 = this.f11610d.substring(i, i + i2);
                if (i3 != i2 || !substring.equals(substring2)) {
                    int compoundPaddingTop;
                    int compoundPaddingRight;
                    int width = this.f11609c.getWidth();
                    int height = this.f11609c.getHeight();
                    if (this.f11609c.getLayout() != null) {
                        compoundPaddingTop = (this.f11609c.getCompoundPaddingTop() + this.f11609c.getLayout().getHeight()) + this.f11609c.getCompoundPaddingTop();
                        compoundPaddingRight = this.f11609c.getCompoundPaddingRight() + (this.f11609c.getCompoundPaddingLeft() + this.f11609c.getLayout().getWidth());
                    } else {
                        compoundPaddingTop = height;
                        compoundPaddingRight = width;
                    }
                    this.f11608b.a(new ReactTextChangedEvent(this.f11609c.getId(), SystemClock.b(), charSequence.toString(), (int) PixelUtil.c((float) compoundPaddingRight), (int) PixelUtil.c((float) compoundPaddingTop), this.f11609c.m12060d()));
                    this.f11608b.a(new ReactTextInputEvent(this.f11609c.getId(), SystemClock.b(), substring, substring2, i, i + i2));
                }
            }
        }

        public void afterTextChanged(Editable editable) {
        }
    }

    public final void m7183a(View view, int i, @Nullable ReadableArray readableArray) {
        ReactEditText reactEditText = (ReactEditText) view;
        switch (i) {
            case 1:
                reactEditText.m12058b();
                return;
            case 2:
                reactEditText.clearFocus();
                return;
            default:
                return;
        }
    }

    public final void m7184a(View view, Object obj) {
        ReactEditText reactEditText = (ReactEditText) view;
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            reactEditText.setPadding((int) Math.ceil((double) fArr[0]), (int) Math.ceil((double) fArr[1]), (int) Math.ceil((double) fArr[2]), (int) Math.ceil((double) fArr[3]));
        } else if (obj instanceof ReactTextUpdate) {
            ReactTextUpdate reactTextUpdate = (ReactTextUpdate) obj;
            if (reactTextUpdate.f11548c) {
                TextInlineImageSpan.m12020a(reactTextUpdate.f11546a, reactEditText);
            }
            reactEditText.m12057a(reactTextUpdate);
        }
    }

    protected final void m7185a(final ThemedReactContext themedReactContext, View view) {
        final ReactEditText reactEditText = (ReactEditText) view;
        reactEditText.addTextChangedListener(new ReactTextInputTextWatcher(this, themedReactContext, reactEditText));
        reactEditText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ ReactTextInputManager f11598c;

            public void onFocusChange(View view, boolean z) {
                EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.b(UIManagerModule.class)).a;
                if (z) {
                    eventDispatcher.a(new ReactTextInputFocusEvent(reactEditText.getId(), SystemClock.b()));
                    return;
                }
                eventDispatcher.a(new ReactTextInputBlurEvent(reactEditText.getId(), SystemClock.b()));
                eventDispatcher.a(new ReactTextInputEndEditingEvent(reactEditText.getId(), SystemClock.b(), reactEditText.getText().toString()));
            }
        });
        reactEditText.setOnEditorActionListener(new OnEditorActionListener(this) {
            final /* synthetic */ ReactTextInputManager f11601c;

            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if ((i & 255) > 0 || i == 0) {
                    ((UIManagerModule) themedReactContext.b(UIManagerModule.class)).a.a(new ReactTextInputSubmitEditingEvent(reactEditText.getId(), SystemClock.b(), reactEditText.getText().toString()));
                }
                if (i != 5 && i != 7) {
                    return !reactEditText.f11584l;
                } else {
                    if (reactEditText.f11584l) {
                        reactEditText.clearFocus();
                    }
                    return true;
                }
            }
        });
    }

    protected final void m7187b(View view) {
        ReactEditText reactEditText = (ReactEditText) view;
        super.b(reactEditText);
        reactEditText.m12056a();
    }

    public /* synthetic */ ReactShadowNode mo176c() {
        return mo177d();
    }

    public final String m7182a() {
        return "AndroidTextInput";
    }

    public final View m7181a(ThemedReactContext themedReactContext) {
        View reactEditText = new ReactEditText(themedReactContext);
        reactEditText.setInputType(reactEditText.getInputType() & -131073);
        reactEditText.setImeOptions(6);
        reactEditText.setTextSize(0, (float) ((int) Math.ceil((double) PixelUtil.b(14.0f))));
        return reactEditText;
    }

    public LayoutShadowNode mo177d() {
        return new ReactTextInputShadowNode();
    }

    public Class<? extends LayoutShadowNode> mo175b() {
        return ReactTextInputShadowNode.class;
    }

    @Nullable
    public final Map<String, Object> m7191g() {
        return MapBuilder.b().a("topSubmitEditing", MapBuilder.a("phasedRegistrationNames", MapBuilder.a("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).a("topEndEditing", MapBuilder.a("phasedRegistrationNames", MapBuilder.a("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).a("topTextInput", MapBuilder.a("phasedRegistrationNames", MapBuilder.a("bubbled", "onTextInput", "captured", "onTextInputCapture"))).a("topFocus", MapBuilder.a("phasedRegistrationNames", MapBuilder.a("bubbled", "onFocus", "captured", "onFocusCapture"))).a("topBlur", MapBuilder.a("phasedRegistrationNames", MapBuilder.a("bubbled", "onBlur", "captured", "onBlurCapture"))).a();
    }

    @Nullable
    public final Map<String, Integer> m7190f() {
        return MapBuilder.a("focusTextInput", Integer.valueOf(1), "blurTextInput", Integer.valueOf(2));
    }

    @ReactProp(b = 14.0f, name = "fontSize")
    public void setFontSize(ReactEditText reactEditText, float f) {
        reactEditText.setTextSize(0, (float) ((int) Math.ceil((double) PixelUtil.b(f))));
    }

    @ReactProp(name = "fontFamily")
    public void setFontFamily(ReactEditText reactEditText, String str) {
        int i = 0;
        if (reactEditText.getTypeface() != null) {
            i = reactEditText.getTypeface().getStyle();
        }
        reactEditText.setTypeface(Typeface.create(str, i));
    }

    @ReactProp(d = true, name = "blurOnSubmit")
    public void setBlurOnSubmit(ReactEditText reactEditText, boolean z) {
        reactEditText.f11584l = z;
    }

    @ReactProp(name = "fontWeight")
    public void setFontWeight(ReactEditText reactEditText, @Nullable String str) {
        int i = -1;
        int a = str != null ? m7178a(str) : -1;
        if (a >= 500 || "bold".equals(str)) {
            i = 1;
        } else if ("normal".equals(str) || (a != -1 && a < 500)) {
            i = 0;
        }
        Typeface typeface = reactEditText.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (i != typeface.getStyle()) {
            reactEditText.setTypeface(typeface, i);
        }
    }

    private static void m7179a(ReactEditText reactEditText, int i, int i2) {
        reactEditText.f11581i = (reactEditText.f11581i & (i ^ -1)) | i2;
    }

    private static void m7180b(ReactEditText reactEditText) {
        if ((reactEditText.f11581i & 12290) != 0 && (reactEditText.f11581i & 128) != 0) {
            m7179a(reactEditText, 128, 16);
        }
    }

    @ReactProp(name = "fontStyle")
    public void setFontStyle(ReactEditText reactEditText, @Nullable String str) {
        int i = -1;
        if ("italic".equals(str)) {
            i = 2;
        } else if ("normal".equals(str)) {
            i = 0;
        }
        Typeface typeface = reactEditText.getTypeface();
        if (typeface == null) {
            typeface = Typeface.DEFAULT;
        }
        if (i != typeface.getStyle()) {
            reactEditText.setTypeface(typeface, i);
        }
    }

    @ReactProp(d = false, name = "onSelectionChange")
    public void setOnSelectionChange(ReactEditText reactEditText, boolean z) {
        if (z) {
            reactEditText.f11585m = new ReactSelectionWatcher(this, reactEditText);
        } else {
            reactEditText.f11585m = null;
        }
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(ReactEditText reactEditText, @Nullable String str) {
        reactEditText.setHint(str);
    }

    @ReactProp(customType = "Color", name = "placeholderTextColor")
    public void setPlaceholderTextColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHintTextColor(DefaultStyleValuesUtil.m11967a(reactEditText.getContext()));
        } else {
            reactEditText.setHintTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "selectionColor")
    public void setSelectionColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setHighlightColor(DefaultStyleValuesUtil.m11970c(reactEditText.getContext()));
        } else {
            reactEditText.setHighlightColor(num.intValue());
        }
    }

    @ReactProp(d = false, name = "selectTextOnFocus")
    public void setSelectTextOnFocus(ReactEditText reactEditText, boolean z) {
        reactEditText.setSelectAllOnFocus(z);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.setTextColor(DefaultStyleValuesUtil.m11969b(reactEditText.getContext()));
        } else {
            reactEditText.setTextColor(num.intValue());
        }
    }

    @ReactProp(customType = "Color", name = "underlineColorAndroid")
    public void setUnderlineColor(ReactEditText reactEditText, @Nullable Integer num) {
        if (num == null) {
            reactEditText.getBackground().clearColorFilter();
        } else {
            reactEditText.getBackground().setColorFilter(num.intValue(), Mode.SRC_IN);
        }
    }

    @ReactProp(name = "textAlign")
    public void setTextAlign(ReactEditText reactEditText, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityHorizontal(0);
        } else if ("left".equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else if ("right".equals(str)) {
            reactEditText.setGravityHorizontal(5);
        } else if ("center".equals(str)) {
            reactEditText.setGravityHorizontal(1);
        } else if ("justify".equals(str)) {
            reactEditText.setGravityHorizontal(3);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
        }
    }

    @ReactProp(name = "textAlignVertical")
    public void setTextAlignVertical(ReactEditText reactEditText, @Nullable String str) {
        if (str == null || "auto".equals(str)) {
            reactEditText.setGravityVertical(0);
        } else if ("top".equals(str)) {
            reactEditText.setGravityVertical(48);
        } else if ("bottom".equals(str)) {
            reactEditText.setGravityVertical(80);
        } else if ("center".equals(str)) {
            reactEditText.setGravityVertical(16);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textAlignVertical: " + str);
        }
    }

    @ReactProp(d = true, name = "editable")
    public void setEditable(ReactEditText reactEditText, boolean z) {
        reactEditText.setEnabled(z);
    }

    @ReactProp(c = 1, name = "numberOfLines")
    public void setNumLines(ReactEditText reactEditText, int i) {
        reactEditText.setLines(i);
    }

    @ReactProp(name = "maxLength")
    public void setMaxLength(ReactEditText reactEditText, @Nullable Integer num) {
        InputFilter[] inputFilterArr;
        int i = 0;
        Object filters = reactEditText.getFilters();
        InputFilter[] inputFilterArr2 = f5804a;
        if (num == null) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                while (i < filters.length) {
                    if (!(filters[i] instanceof LengthFilter)) {
                        linkedList.add(filters[i]);
                    }
                    i++;
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
            inputFilterArr = inputFilterArr2;
        } else {
            if (filters.length > 0) {
                int i2 = 0;
                for (int i3 = 0; i3 < filters.length; i3++) {
                    if (filters[i3] instanceof LengthFilter) {
                        filters[i3] = new LengthFilter(num.intValue());
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    inputFilterArr2 = new InputFilter[(filters.length + 1)];
                    System.arraycopy(filters, 0, inputFilterArr2, 0, filters.length);
                    filters[filters.length] = new LengthFilter(num.intValue());
                } else {
                    Object obj = filters;
                }
            } else {
                inputFilterArr2 = new InputFilter[]{new LengthFilter(num.intValue())};
            }
            inputFilterArr = inputFilterArr2;
        }
        reactEditText.setFilters(inputFilterArr);
    }

    @ReactProp(name = "autoCorrect")
    public void setAutoCorrect(ReactEditText reactEditText, @Nullable Boolean bool) {
        int i = bool != null ? bool.booleanValue() ? 32768 : 524288 : 0;
        m7179a(reactEditText, 557056, i);
    }

    @ReactProp(d = false, name = "multiline")
    public void setMultiline(ReactEditText reactEditText, boolean z) {
        int i;
        int i2 = 131072;
        if (z) {
            i = 0;
        } else {
            i = 131072;
        }
        if (!z) {
            i2 = 0;
        }
        m7179a(reactEditText, i, i2);
    }

    @ReactProp(d = false, name = "password")
    public void setPassword(ReactEditText reactEditText, boolean z) {
        int i = 0;
        int i2 = z ? 0 : 144;
        if (z) {
            i = 128;
        }
        m7179a(reactEditText, i2, i);
        m7180b(reactEditText);
    }

    @ReactProp(name = "autoCapitalize")
    public void setAutoCapitalize(ReactEditText reactEditText, int i) {
        m7179a(reactEditText, 28672, i);
    }

    @ReactProp(name = "keyboardType")
    public void setKeyboardType(ReactEditText reactEditText, @Nullable String str) {
        int i = 1;
        if ("numeric".equalsIgnoreCase(str)) {
            i = 12290;
        } else if ("email-address".equalsIgnoreCase(str)) {
            i = 33;
        } else if ("phone-pad".equalsIgnoreCase(str)) {
            i = 3;
        }
        m7179a(reactEditText, 12323, i);
        m7180b(reactEditText);
    }

    @ReactProp(name = "returnKeyType")
    public void setReturnKeyType(ReactEditText reactEditText, String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1273775369:
                if (str.equals("previous")) {
                    i = 4;
                    break;
                }
                break;
            case -906336856:
                if (str.equals("search")) {
                    i = 5;
                    break;
                }
                break;
            case 3304:
                if (str.equals("go")) {
                    i = 1;
                    break;
                }
                break;
            case 3089282:
                if (str.equals("done")) {
                    i = 0;
                    break;
                }
                break;
            case 3377907:
                if (str.equals("next")) {
                    i = 2;
                    break;
                }
                break;
            case 3387192:
                if (str.equals("none")) {
                    i = 3;
                    break;
                }
                break;
            case 3526536:
                if (str.equals("send")) {
                    i = 6;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                reactEditText.setImeOptions(6);
                return;
            case 1:
                reactEditText.setImeOptions(2);
                return;
            case 2:
                reactEditText.setImeOptions(5);
                return;
            case 3:
                reactEditText.setImeOptions(1);
                return;
            case 4:
                reactEditText.setImeOptions(7);
                return;
            case 5:
                reactEditText.setImeOptions(3);
                return;
            case 6:
                reactEditText.setImeOptions(4);
                return;
            default:
                return;
        }
    }

    @ReactProp(name = "returnKeyLabel")
    public void setReturnKeyLabel(ReactEditText reactEditText, String str) {
        reactEditText.setImeActionLabel(str, 1648);
    }

    private static int m7178a(String str) {
        return (str.length() != 3 || !str.endsWith("00") || str.charAt(0) > '9' || str.charAt(0) < '1') ? -1 : (str.charAt(0) - 48) * 100;
    }

    @Nullable
    public final Map m7192i() {
        return MapBuilder.a("AutoCapitalizationType", MapBuilder.a("none", Integer.valueOf(0), "characters", Integer.valueOf(4096), "words", Integer.valueOf(8192), "sentences", Integer.valueOf(16384)));
    }
}
