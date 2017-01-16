package com.sheena.idesigin.component;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.sheena.idesigin.base.MainApplication;

/**
 * 支持iconfont文字textview
 */
public class IconTextView extends TextView{


    public IconTextView(Context context) {
        super(context);
        initView();
    }

    public IconTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        setIncludeFontPadding(false);
        if (isInEditMode()) {
            Typeface iconFont = Typeface.createFromAsset(getContext().getAssets(), "iconfont/iconfont.ttf");
            setTypeface(iconFont);
        } else {
            setTypeface(MainApplication.getInstance().getIconFont());
        }
        setGravity(Gravity.CENTER_VERTICAL);
    }

}
