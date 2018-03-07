package com.facebook.greetingcards.verve.render;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.util.SparseArrayCompat;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.debug.log.BLog;
import com.facebook.greetingcards.verve.VerveActionListener;
import com.facebook.greetingcards.verve.VerveViewSupplier.RecyclerType;
import com.facebook.greetingcards.verve.model.VMAction;
import com.facebook.greetingcards.verve.model.VMMediaType;
import com.facebook.greetingcards.verve.model.VMSlide;
import com.facebook.greetingcards.verve.model.VMView;
import com.facebook.greetingcards.verve.model.VMViewType;
import com.facebook.greetingcards.verve.mutablemodel.DeckInfo;
import com.facebook.greetingcards.verve.render.VerveViewRecycler.VerveViewRecyclerTypes;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* compiled from: view_photo_menu_tap */
public class VerveViewFactory {
    public static final Class<?> f433a = VerveViewFactory.class;

    /* compiled from: view_photo_menu_tap */
    final class C00501 implements OnClickListener {
        final /* synthetic */ VerveActionListener f428a;
        final /* synthetic */ VMAction f429b;
        final /* synthetic */ VMView f430c;

        C00501(VerveActionListener verveActionListener, VMAction vMAction, VMView vMView) {
            this.f428a = verveActionListener;
            this.f429b = vMAction;
            this.f430c = vMView;
        }

        public final void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1943835197);
            if (this.f428a != null) {
                this.f428a.a(this.f429b, view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1344806143, a);
        }
    }

    public static void m409a(ImmutableList<VMView> immutableList, int i, DeckInfo deckInfo, Context context, SparseArrayCompat<View> sparseArrayCompat) {
        int size = immutableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            VMView vMView = (VMView) immutableList.get(i2);
            if (sparseArrayCompat.a(vMView.f340a) == null) {
                sparseArrayCompat.a(vMView.f340a, m404a(vMView, i, deckInfo, context));
            }
        }
    }

    public static void m408a(DeckInfo deckInfo, ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            int intValue = ((Integer) childAt.getTag(2131558771)).intValue();
            VerveViewRecycler verveViewRecycler = deckInfo.f350e;
            Preconditions.checkNotNull(childAt);
            VerveViewRecycledPool verveViewRecycledPool = verveViewRecycler.f440c;
            ArrayList arrayList = (ArrayList) verveViewRecycledPool.f434a.get(intValue);
            if (arrayList == null) {
                arrayList = new ArrayList();
                verveViewRecycledPool.f434a.put(intValue, arrayList);
                if (verveViewRecycledPool.f435b.indexOfKey(intValue) < 0) {
                    verveViewRecycledPool.f435b.put(intValue, 5);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (verveViewRecycledPool.f435b.get(intValue) > arrayList2.size()) {
                arrayList2.add(childAt);
            }
        }
        viewGroup.removeAllViews();
    }

    private static void m406a(VMView vMView, int i, DeckInfo deckInfo, View view) {
        Preconditions.checkNotNull(view);
        switch (vMView.m308o()) {
            case MEDIA:
                m407a(vMView, (VMSlide) deckInfo.f346a.slides.get(i), deckInfo, view, (VMMediaType) view.getTag(2131558773));
                break;
            case RECT:
                view.setBackgroundDrawable(ColorParseUtil.m335a(vMView.m297d()));
                break;
            case LABEL:
                TextView textView = (TextView) view;
                textView.setText(vMView.text);
                textView.setTextColor(ColorParseUtil.m336b(vMView.m297d()));
                textView.setTextSize(0, vMView.m296c());
                if (vMView.shadowColor != null) {
                    textView.setShadowLayer((float) vMView.m298e(), ((Float) vMView.m299f().get(0)).floatValue(), ((Float) vMView.m299f().get(1)).floatValue(), ColorParseUtil.m336b(vMView.shadowColor));
                }
                textView.setGravity(m403a(vMView));
                if ("System-Italic".equals(vMView.font)) {
                    textView.setTypeface(null, 2);
                } else if ("System-Bold".equals(vMView.font)) {
                    textView.setTypeface(null, 1);
                } else if ("System-Light".equals(vMView.font) && VERSION.SDK_INT >= 16) {
                    textView.setTypeface(Typeface.create("sans-serif-light", 0));
                }
                String n = vMView.m307n();
                boolean z = true;
                switch (n.hashCode()) {
                    case 3056464:
                        if (n.equals("clip")) {
                            z = false;
                            break;
                        }
                        break;
                    case 1852984678:
                        if (n.equals("truncate")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        textView.setSingleLine(true);
                        textView.setEllipsize(null);
                        break;
                    case true:
                        textView.setSingleLine(true);
                        textView.setEllipsize(TruncateAt.END);
                        break;
                    default:
                        textView.setSingleLine(false);
                        textView.setEllipsize(null);
                        break;
                }
                textView.setHorizontallyScrolling(false);
                break;
            case BUTTON:
                VerveActionListener verveActionListener = deckInfo.f348c;
                if (!(vMView.actionsMap == null || !vMView.actionsMap.containsKey("button") || verveActionListener == null)) {
                    view.setOnClickListener(new C00501(verveActionListener, (VMAction) vMView.actionsMap.get("button"), vMView));
                    break;
                }
            case SEQUENCE:
                ((VerveSequenceView) view).m402a(vMView, i);
                break;
            case GROUP:
                ((VerveGroupView) view).m399a(vMView, i);
                break;
            default:
                BLog.a(f433a, "Unrecognized verve view type: %s. Display default view.", new Object[]{vMView.m308o()});
                break;
        }
        ViewPropertiesUtil.m413a(view, vMView);
        view.setTag(2131558772, vMView);
    }

    private static View m404a(VMView vMView, int i, DeckInfo deckInfo, Context context) {
        VMMediaType vMMediaType = VMMediaType.UNKNOWN;
        if (vMView.m308o() == VMViewType.MEDIA) {
            vMMediaType = deckInfo.f349d.a(vMView.src);
        }
        VerveViewRecycler verveViewRecycler = deckInfo.f350e;
        Object obj = (RecyclerType) verveViewRecycler.f439b.a(vMView);
        if (obj == null) {
            VerveViewRecyclerTypes verveViewRecyclerTypes;
            switch (vMView.m308o()) {
                case MEDIA:
                    switch (vMMediaType) {
                        case IMAGE:
                            verveViewRecyclerTypes = VerveViewRecyclerTypes.MEDIA_WITH_IMAGE;
                            break;
                        case VIDEO:
                            verveViewRecyclerTypes = VerveViewRecyclerTypes.MEDIA_WITH_VIDEO;
                            break;
                        default:
                            verveViewRecyclerTypes = VerveViewRecyclerTypes.RECT;
                            break;
                    }
                case LABEL:
                    verveViewRecyclerTypes = VerveViewRecyclerTypes.LABEL;
                    break;
                case BUTTON:
                    verveViewRecyclerTypes = VerveViewRecyclerTypes.BUTTON;
                    break;
                case SEQUENCE:
                    verveViewRecyclerTypes = VerveViewRecyclerTypes.SEQUENCE;
                    break;
                case GROUP:
                    verveViewRecyclerTypes = VerveViewRecyclerTypes.GROUP;
                    break;
                default:
                    verveViewRecyclerTypes = VerveViewRecyclerTypes.RECT;
                    break;
            }
            obj = verveViewRecyclerTypes;
        }
        int indexOf = verveViewRecycler.f438a.indexOf(obj);
        View a = verveViewRecycler.m410a(indexOf);
        if (a == null) {
            switch (vMView.m308o()) {
                case MEDIA:
                    a = m405a(vMView, deckInfo, context, vMMediaType);
                    break;
                case RECT:
                    a = new View(context);
                    break;
                case LABEL:
                    a = new TextView(context);
                    break;
                case BUTTON:
                    a = deckInfo.f347b.c(context, vMView);
                    break;
                case SEQUENCE:
                    a = new VerveSequenceView(context, deckInfo);
                    break;
                case GROUP:
                    a = new VerveGroupView(context, deckInfo);
                    break;
                default:
                    BLog.a(f433a, "Unrecognized verve view type: %s. Display default view.", new Object[]{vMView.m308o()});
                    a = new View(context);
                    break;
            }
            a.setTag(2131558771, Integer.valueOf(indexOf));
            a.setTag(2131558773, vMMediaType);
        }
        View view = a;
        m406a(vMView, i, deckInfo, view);
        return view;
    }

    private static int m403a(VMView vMView) {
        int i;
        if ("center".equals(vMView.alignment)) {
            i = 1;
        } else if ("right".equals(vMView.alignment)) {
            i = 5;
        } else {
            i = 3;
        }
        if ("bottom".equals(vMView.vAlignment)) {
            return i | 80;
        }
        if ("center".equals(vMView.vAlignment)) {
            return i | 16;
        }
        return i | 48;
    }

    public static View m405a(VMView vMView, DeckInfo deckInfo, Context context, VMMediaType vMMediaType) {
        View a;
        switch (vMMediaType) {
            case IMAGE:
                a = deckInfo.f347b.a(context, vMView);
                break;
            case VIDEO:
                a = deckInfo.f347b.b(context, vMView);
                break;
            default:
                a = new View(context);
                BLog.a(f433a, "Unrecognized verve media type: %s. Display default view.", new Object[]{vMMediaType});
                break;
        }
        if (a != null) {
            return a;
        }
        BLog.a(f433a, "Client does not return views for media type: %s. Display default view.", new Object[]{vMMediaType});
        return new View(context);
    }

    private static void m407a(VMView vMView, VMSlide vMSlide, DeckInfo deckInfo, View view, VMMediaType vMMediaType) {
        Preconditions.checkNotNull(view);
        switch (vMMediaType) {
            case IMAGE:
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    Drawable drawable = null;
                    if (vMView.placeholderColor != null) {
                        drawable = ColorParseUtil.m335a(vMView.placeholderColor);
                    }
                    deckInfo.f347b.a(vMView, vMSlide, deckInfo.f346a.resources, drawable, imageView);
                    if ("fit".equals(vMView.resize)) {
                        imageView.setScaleType(ScaleType.FIT_CENTER);
                        return;
                    } else {
                        imageView.setScaleType(ScaleType.CENTER_CROP);
                        return;
                    }
                }
                return;
            case VIDEO:
                if (view instanceof VerveVideoContainer) {
                    deckInfo.f347b.a(vMView, deckInfo.f346a.resources, (VerveVideoContainer) view);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
