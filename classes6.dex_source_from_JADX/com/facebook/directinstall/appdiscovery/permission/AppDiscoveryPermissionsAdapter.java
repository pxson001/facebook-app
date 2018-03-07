package com.facebook.directinstall.appdiscovery.permission;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PermissionGroupInfo;
import android.content.pm.PermissionInfo;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.android.PackageManagerMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onCreateView not allowed on MapViewDelegate */
public class AppDiscoveryPermissionsAdapter extends BaseExpandableListAdapter {
    private static final Class<?> f8734a = AppDiscoveryPermissionsAdapter.class;
    private static final float[] f8735b = new float[]{0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final ColorMatrixColorFilter f8736c = new ColorMatrixColorFilter(f8735b);
    private static final boolean f8737d = (VERSION.SDK_INT >= 17);
    private final PackageManager f8738e;
    private final List<PermissionGroupData> f8739f = new ArrayList();
    private final List<PermissionExtra> f8740g = new ArrayList();

    /* compiled from: onCreateView not allowed on MapViewDelegate */
    class PermissionGroupData {
        @Nullable
        final PermissionGroupInfo f8732a;
        final List<PermissionInfo> f8733b;
    }

    private static AppDiscoveryPermissionsAdapter m12516b(InjectorLike injectorLike) {
        return new AppDiscoveryPermissionsAdapter(PackageManagerMethodAutoProvider.a(injectorLike));
    }

    @Nonnull
    public /* synthetic */ Object getChild(int i, int i2) {
        return m12512a(i, i2);
    }

    @Nonnull
    public /* synthetic */ Object getGroup(int i) {
        return m12513a(i);
    }

    @Inject
    public AppDiscoveryPermissionsAdapter(PackageManager packageManager) {
        this.f8738e = packageManager;
    }

    public int getGroupCount() {
        return this.f8739f.size() + this.f8740g.size();
    }

    public int getChildrenCount(int i) {
        if (m12517c(i)) {
            return ((PermissionGroupData) this.f8739f.get(i)).f8733b.size();
        }
        return 1;
    }

    @Nonnull
    private PermissionGroupData m12513a(int i) {
        return (PermissionGroupData) this.f8739f.get(i);
    }

    @Nonnull
    private PermissionInfo m12512a(int i, int i2) {
        return (PermissionInfo) ((PermissionGroupData) this.f8739f.get(i)).f8733b.get(i2);
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public boolean hasStableIds() {
        return false;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        CharSequence loadLabel;
        Drawable loadIcon;
        Context context = viewGroup.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(2130903273, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(2131559645);
        ImageView imageView = (ImageView) view.findViewById(2131559644);
        if (m12517c(i)) {
            PermissionGroupData a = m12513a(i);
            if (a.f8732a != null) {
                loadLabel = a.f8732a.loadLabel(this.f8738e);
                loadIcon = a.f8732a.loadIcon(this.f8738e);
            } else {
                loadLabel = context.getString(2131236006);
                loadIcon = context.getResources().getDrawable(2130843813);
            }
        } else {
            PermissionExtra permissionExtra = (PermissionExtra) this.f8740g.get(m12515b(i));
            loadLabel = permissionExtra.m12518a();
            try {
                loadIcon = context.getResources().getDrawable(permissionExtra.m12519c());
            } catch (Exception e) {
                loadIcon = context.getResources().getDrawable(2130843813);
            }
        }
        if (loadIcon != null) {
            loadIcon.mutate();
            loadIcon.setColorFilter(f8736c);
        }
        m12514a(textView, z);
        textView.setText(loadLabel);
        imageView.setImageDrawable(loadIcon);
        return view;
    }

    private int m12515b(int i) {
        Preconditions.checkArgument(i >= this.f8739f.size());
        return i - this.f8739f.size();
    }

    private boolean m12517c(int i) {
        return i < this.f8739f.size();
    }

    @TargetApi(17)
    private static void m12514a(TextView textView, boolean z) {
        Drawable[] compoundDrawablesRelative;
        int i;
        if (f8737d) {
            compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        } else {
            compoundDrawablesRelative = textView.getCompoundDrawables();
        }
        Drawable drawable = compoundDrawablesRelative[2];
        if (z) {
            i = 1;
        } else {
            i = 0;
        }
        drawable.setLevel(i);
        if (f8737d) {
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
        }
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        CharSequence charSequence;
        Context context = viewGroup.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(2130903274, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(2131559646);
        textView.setOnClickListener(null);
        if (m12517c(i)) {
            charSequence = m12512a(i, i2).loadLabel(this.f8738e).toString();
        } else {
            PermissionExtra permissionExtra = (PermissionExtra) this.f8740g.get(m12515b(i));
            String str = permissionExtra.f8742b;
            textView.setOnClickListener(permissionExtra.f8744d);
            Object obj = str;
        }
        textView.setText(charSequence);
        return textView;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
