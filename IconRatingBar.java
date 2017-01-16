package com.sheena.idesigin.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import com.sheena.idesigin.R;
import com.sheena.idesigin.util.DisplayUtil;
import com.sheena.idesigin.util.UiUtils;
import com.sheena.idesigin.util.Util;

/**
 * Created by sheena on 17/1/16.
 */

public class IconRatingBar extends LinearLayout {
    private int mStarCount;//星星个数
    private float mStarSize=16;//星星大小
    private int mStarSpace;//星星间距
    private int mStarEmptyColor;//空星星颜色；
    private int mStarFullColor;//实星星颜色
    private boolean mClickable = true;
    private OnRatingBarChangeListener onRatingBarChangeListener;
    private Object bindObject;
    public IconRatingBar(Context context) {
        this(context,null);
    }

    public IconRatingBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public IconRatingBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public IconRatingBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.IconRatingBar, defStyleAttr, defStyleRes);
        mStarCount = a.getInt(R.styleable.IconRatingBar_starCount, 5);
        mStarSize = a.getDimension(R.styleable.IconRatingBar_starSize, 16);
        mStarSpace = a.getInt(R.styleable.IconRatingBar_starSpace, 6);
        mStarEmptyColor = a.getColor(R.styleable.IconRatingBar_starEmptyColor, Color.WHITE);
        mStarFullColor=a.getColor(R.styleable.IconRatingBar_starFullColor,Color.YELLOW);
        a.recycle();


        for (int i = 0; i < mStarCount; ++i) {
            IconTextView iconTextView = getStarIcon(context, attrs,mStarSpace);
            iconTextView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickable) {
                        int starCount = indexOfChild(v) + 1;
                        setStar(starCount, true);
                        if (onRatingBarChangeListener != null) {
                            onRatingBarChangeListener.onRatingChanged(bindObject, mStarCount);
                        }
                    }
                }
            });
            addView(iconTextView);
        }
    }

    public interface OnRatingBarChangeListener {
        void onRatingChanged(Object bindObject, int RatingScore);
    }

    public void setStar(int starCount, boolean animation) {
        starCount = starCount > this.mStarCount ? this.mStarCount : starCount;
        starCount = starCount < 0 ? 0 : starCount;
        for (int i = 0; i < starCount; ++i) {
            ((IconTextView)getChildAt(i)).setTextColor(mStarFullColor);
            if (animation) {
                ScaleAnimation sa = new ScaleAnimation(0, 0, 1, 1);
                getChildAt(i).startAnimation(sa);
            }
        }
        for (int i = this.mStarCount - 1; i >= starCount; --i) {
            ((IconTextView)getChildAt(i)).setTextColor(mStarEmptyColor);
        }
    }
    private IconTextView getStarIcon(Context context, AttributeSet attrs,int starSpace) {
        IconTextView iconTextView=new IconTextView(context);
        iconTextView.setText(context.getString(R.string.star_icon));
        iconTextView.setTextSize(mStarSize);
//        ViewGroup.LayoutParams para = new ViewGroup.LayoutParams(Math.round(mStarSize), Math.round(mStarSize));
//        iconTextView.setLayoutParams(para);
        // TODO:you can change gap between two stars use the padding
        iconTextView.setPadding(0,0, DisplayUtil.dip2px(starSpace),0);
        return iconTextView;
    }

    public void setClickable(boolean clickable) {
        this.mClickable = clickable;
    }


    public int getStarCount() {
        return mStarCount;
    }

    public void setStarFullColor(int starFillColor) {
        this.mStarFullColor = starFillColor;
    }

    public void setStarEmptyColor(int starEmptyColor) {
        this.mStarEmptyColor = starEmptyColor;
    }

    public void setStarCount(int starCount) {
        this.mStarCount = starCount;
    }

    public void setStarSize(float starSize) {
        this.mStarSize = starSize;
    }

    public void setBindObject(Object bindObject) {
        this.bindObject = bindObject;
    }

    public void setOnRatingChangeListener(OnRatingBarChangeListener onRatingBarChangeListener) {
        this.onRatingBarChangeListener = onRatingBarChangeListener;
    }


}
