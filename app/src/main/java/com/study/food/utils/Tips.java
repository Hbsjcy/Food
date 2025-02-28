package com.study.food.utils;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Tips {

    /**
     * 显示Toast
     *
     * @param message 显示的文本消息
     */
    public static void show(String message) {
        show(message, Toast.LENGTH_SHORT);
    }

    /**
     * 显示Toast
     *
     * @param message  显示的文本消息
     * @param duration 显示时间长度
     */
    public static void show(String message, int duration) {
        Toast toast = new Toast(Utils.getContext());
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(createToastView(message));
        toast.show();
    }

    /**
     * 创建Toast自定义View
     *
     * @param message 显示的文本消息
     * @return 自定义View
     */
    private static View createToastView(String message) {
        // 构建圆角矩形背景
        float radius = dp2px(6);
        RoundRectShape shape = new RoundRectShape(new float[]{radius, radius, radius, radius, radius, radius, radius, radius}, null, null);
        ShapeDrawable drawable = new ShapeDrawable(shape);
        drawable.getPaint().setColor(Color.argb(225, 240, 240, 240));
        drawable.getPaint().setStyle(Paint.Style.FILL);
        drawable.getPaint().setAntiAlias(true);
        drawable.getPaint().setFlags(Paint.ANTI_ALIAS_FLAG);

        // 创建View
        FrameLayout layout = new FrameLayout(Utils.getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout.setLayoutParams(layoutParams);
        layout.setPadding(dp2px(16), dp2px(12), dp2px(16), dp2px(12));
        layout.setBackground(drawable);

        TextView textView = new TextView(Utils.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));
        textView.setTextSize(15);
        textView.setText(message);
        textView.setLineSpacing(dp2px(4), 1f);
        textView.setTextColor(Color.BLACK);

        layout.addView(textView);

        return layout;
    }

    /**
     * dp转px
     *
     * @param dp dp的值
     * @return 转换后的px
     */
    private static int dp2px(float dp) {
        final float scale = Utils.getContext().getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
