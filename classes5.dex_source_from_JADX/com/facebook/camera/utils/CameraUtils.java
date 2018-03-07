package com.facebook.camera.utils;

import android.app.Activity;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera.Size;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Display;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.camera.views.CornerControl;
import com.facebook.debug.log.BLog;
import java.util.List;

/* compiled from: all_processes */
public class CameraUtils {
    private static final String f11058a = CameraUtils.class.getSimpleName();

    /* compiled from: all_processes */
    /* synthetic */ class C10701 {
        static final /* synthetic */ int[] f11057a = new int[Orientation.values().length];

        static {
            try {
                f11057a[Orientation.PORTRAIT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f11057a[Orientation.LANDSCAPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f11057a[Orientation.REVERSE_LANDSCAPE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f11057a[Orientation.REVERSE_PORTRAIT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* compiled from: all_processes */
    public enum Corner {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT
    }

    /* compiled from: all_processes */
    public enum OptimizeMode {
        NO_CONSTRAINTS,
        SMALLER_THAN_OR_EQUAL_TO
    }

    private CameraUtils() {
    }

    public static int m19051a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    public static void m19056a(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static Size m19054a(List<Size> list, Point point) {
        return m19052a((List) list, point.x, point.y);
    }

    public static Size m19052a(List<Size> list, int i, int i2) {
        return m19053a((List) list, i, i2, OptimizeMode.NO_CONSTRAINTS);
    }

    public static Size m19053a(List<Size> list, int i, int i2, OptimizeMode optimizeMode) {
        int i3 = 0;
        if (list == null) {
            return null;
        }
        float f = ((float) i2) / ((float) i);
        Size size = null;
        Size size2 = null;
        int i4 = 0;
        for (Size size3 : list) {
            Size size32;
            float f2 = ((float) size32.height) / ((float) size32.width);
            int i5 = size32.width * size32.height;
            if (optimizeMode != OptimizeMode.SMALLER_THAN_OR_EQUAL_TO || (size32.width <= i && size32.height <= i2)) {
                int i6;
                if (i5 > i4 && Math.abs(f2 - f) <= 0.01f) {
                    size2 = size32;
                    i4 = i5;
                }
                if (i5 > i3) {
                    i6 = i5;
                } else {
                    size32 = size;
                    i6 = i3;
                }
                i3 = i6;
                size = size32;
            }
        }
        if (size2 != null) {
            return size2;
        }
        if (size == null) {
            return null;
        }
        BLog.a(f11058a, "Can not find a size that respects the desired proportions");
        return size;
    }

    public static void m19055a(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate((float) i);
        matrix.postScale(((float) i2) / 2000.0f, ((float) i3) / 2000.0f);
        matrix.postTranslate(((float) i2) / 2.0f, ((float) i3) / 2.0f);
    }

    public static float m19050a(float f, float f2) {
        if (f2 - f >= 270.0f) {
            return f2 - 360.0f;
        }
        if (f2 - f <= -270.0f) {
            return f2 + 360.0f;
        }
        return f2;
    }

    public static void m19057a(Orientation orientation, Orientation orientation2, CornerControl cornerControl, CornerControl cornerControl2) {
        switch (C10701.f11057a[orientation.ordinal()]) {
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                if (orientation2 != Orientation.LANDSCAPE) {
                    if (orientation2 == Orientation.PORTRAIT) {
                        cornerControl2.f11077c = Corner.BOTTOM_LEFT;
                        cornerControl.f11077c = Corner.TOP_LEFT;
                        return;
                    } else if (orientation2 == Orientation.REVERSE_LANDSCAPE) {
                        cornerControl2.f11077c = Corner.BOTTOM_RIGHT;
                        cornerControl.f11077c = Corner.BOTTOM_LEFT;
                        return;
                    } else {
                        cornerControl2.f11077c = Corner.TOP_LEFT;
                        cornerControl.f11077c = Corner.BOTTOM_LEFT;
                        return;
                    }
                }
                break;
            case 3:
                if (orientation2 == Orientation.LANDSCAPE) {
                    cornerControl2.f11077c = Corner.BOTTOM_RIGHT;
                    cornerControl.f11077c = Corner.BOTTOM_LEFT;
                    return;
                } else if (orientation2 == Orientation.PORTRAIT) {
                    cornerControl2.f11077c = Corner.TOP_RIGHT;
                    cornerControl.f11077c = Corner.BOTTOM_RIGHT;
                    return;
                } else if (orientation2 != Orientation.REVERSE_LANDSCAPE) {
                    cornerControl2.f11077c = Corner.BOTTOM_RIGHT;
                    cornerControl.f11077c = Corner.TOP_RIGHT;
                    return;
                }
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_END /*4*/:
                if (orientation2 == Orientation.LANDSCAPE) {
                    cornerControl2.f11077c = Corner.BOTTOM_LEFT;
                    cornerControl.f11077c = Corner.TOP_LEFT;
                    return;
                } else if (orientation2 == Orientation.PORTRAIT) {
                    cornerControl2.f11077c = Corner.TOP_RIGHT;
                    cornerControl.f11077c = Corner.TOP_LEFT;
                    return;
                } else if (orientation2 == Orientation.REVERSE_LANDSCAPE) {
                    cornerControl2.f11077c = Corner.TOP_RIGHT;
                    cornerControl.f11077c = Corner.BOTTOM_RIGHT;
                    return;
                }
                break;
            default:
                if (orientation2 == Orientation.LANDSCAPE) {
                    cornerControl2.f11077c = Corner.TOP_RIGHT;
                    cornerControl.f11077c = Corner.BOTTOM_RIGHT;
                    return;
                } else if (orientation2 != Orientation.PORTRAIT) {
                    if (orientation2 == Orientation.REVERSE_LANDSCAPE) {
                        cornerControl2.f11077c = Corner.BOTTOM_LEFT;
                        cornerControl.f11077c = Corner.TOP_LEFT;
                        return;
                    }
                    cornerControl2.f11077c = Corner.TOP_RIGHT;
                    cornerControl.f11077c = Corner.TOP_LEFT;
                    return;
                }
                break;
        }
        cornerControl2.f11077c = Corner.TOP_LEFT;
        cornerControl.f11077c = Corner.TOP_RIGHT;
    }

    public static boolean m19058a(Activity activity, View view, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, Point point, Rect rect, int i, int i2, int i3) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        LayoutParams layoutParams = (LayoutParams) relativeLayout2.getLayoutParams();
        int i4;
        int i5;
        int i6;
        int max;
        int i7;
        if (layoutParams.height > 0) {
            if (height < width) {
                BLog.a("CameraActivity", "resizePreview: vertical layout, wide screen. Aborting resize.");
                return false;
            }
            i4 = height - ((point.x * width) / point.y);
            i5 = layoutParams.height;
            i6 = ((100 - i) * i5) / 100;
            if (i4 < i6) {
                layoutParams.height = i6;
                i5 = ((height - i6) * point.y) / point.x;
                layoutParams = (LayoutParams) view.findViewById(2131560157).getLayoutParams();
                layoutParams.width = (width - i5) / 2;
                ((LayoutParams) view.findViewById(2131560158).getLayoutParams()).width = (width - i5) - layoutParams.width;
            } else {
                max = Math.max(i4, i6);
                i6 = ((i3 + 100) * i5) / 100;
                if (max > i6) {
                    max = height - i6;
                    i4 = ((point.x * width) * (i2 + 100)) / (point.y * 100);
                    if (i4 > max) {
                        i7 = i6;
                        i6 = max;
                        max = height - max;
                        i5 = i7;
                    } else {
                        max = height - i4;
                        if (max > i5 * 2) {
                            i5 = max / 2;
                            i6 = i4;
                        } else {
                            i6 = i4;
                        }
                    }
                    i4 = (i6 * point.y) / point.x;
                    height = (i4 - width) / 2;
                    i4 = (i4 - width) - height;
                    ((LayoutParams) relativeLayout.getLayoutParams()).setMargins(-height, 0, -i4, 0);
                    rect.left += height;
                    rect.right += i4;
                } else {
                    i5 = max;
                    max = i4;
                }
                layoutParams.height = i5;
                if (i5 < max) {
                    ((LayoutParams) view.findViewById(2131560156).getLayoutParams()).height = max - i5;
                }
            }
        } else if (layoutParams.width > 0) {
            if (height > width) {
                BLog.a("CameraActivity", "resizePreview: horizontal layout, tall screen. Aborting resize.");
                return false;
            }
            i4 = width - ((point.x * height) / point.y);
            i5 = layoutParams.width;
            i6 = ((100 - i) * i5) / 100;
            if (i4 < i6) {
                layoutParams.width = i6;
                i5 = ((width - i6) * point.y) / point.x;
                layoutParams = (LayoutParams) view.findViewById(2131560157).getLayoutParams();
                layoutParams.height = (height - i5) / 2;
                ((LayoutParams) view.findViewById(2131560158).getLayoutParams()).height = (height - i5) - layoutParams.height;
            } else {
                max = Math.max(i4, i6);
                i6 = ((i3 + 100) * i5) / 100;
                if (max > i6) {
                    max = width - i6;
                    i4 = ((point.x * height) * (i2 + 100)) / (point.y * 100);
                    if (i4 > max) {
                        i7 = i6;
                        i6 = max;
                        max = width - max;
                        i5 = i7;
                    } else {
                        max = width - i4;
                        if (max > i5 * 2) {
                            i5 = max / 2;
                            i6 = i4;
                        } else {
                            i6 = i4;
                        }
                    }
                    i4 = (i6 * point.y) / point.x;
                    width = (i4 - height) / 2;
                    i4 = (i4 - height) - width;
                    ((LayoutParams) relativeLayout.getLayoutParams()).setMargins(0, -width, 0, -i4);
                    rect.top += width;
                    rect.bottom += i4;
                } else {
                    i5 = max;
                    max = i4;
                }
                layoutParams.width = i5;
                if (i5 < max) {
                    ((LayoutParams) view.findViewById(2131560156).getLayoutParams()).width = max - i5;
                }
            }
        }
        view.requestLayout();
        return true;
    }
}
