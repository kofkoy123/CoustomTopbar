package com.lzr.coustomtoolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/7/11.
 * 自定义标题
 */

public class Topbar extends RelativeLayout {

    private Button mLeftButtom, mRightButtom;
    private TextView mTitleView;

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;

    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;

    private float mTitleSize;
    private int mTitleTextColor;
    private String mTitleText;

    private LayoutParams mLeftParames, mRightParames, mTitleParames;

    private OnButtomClickListener listener;


    public Topbar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
        mLeftTextColor = ta.getColor(R.styleable.Topbar_leftTextColor, 0);
        mLeftBackground = ta.getDrawable(R.styleable.Topbar_leftBackground);
        mLeftText = ta.getString(R.styleable.Topbar_leftText);

        mRightTextColor = ta.getColor(R.styleable.Topbar_rightTextColor, 0);
        mRightBackground = ta.getDrawable(R.styleable.Topbar_rightBackground);
        mRightText = ta.getString(R.styleable.Topbar_rightText);

        mTitleSize = ta.getDimension(R.styleable.Topbar_titleTextsize, 0);
        mTitleTextColor = ta.getColor(R.styleable.Topbar_titleTextColor, 0);
        mTitleText = ta.getString(R.styleable.Topbar_title);
        //释放资源
        ta.recycle();
        mLeftButtom = new Button(context);
        mRightButtom = new Button(context);
        mTitleView = new TextView(context);
        //左边按钮
        mLeftButtom.setTextColor(mLeftTextColor);
        mLeftButtom.setBackground(mLeftBackground);
        mLeftButtom.setText(mLeftText);
        //右边按钮
        mRightButtom.setTextColor(mRightTextColor);
        mRightButtom.setBackground(mRightBackground);
        mRightButtom.setText(mRightText);
        //标题
        mTitleView.setText(mTitleText);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleSize);
        mTitleView.setGravity(Gravity.CENTER);
        //设置整个标题的背景颜色
        setBackgroundColor(Color.parseColor("#ff0000"));

        //设置控件在布局中的位置
        mLeftParames = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        //增加一个规则
        mLeftParames.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        //将控件添加到布局中
        addView(mLeftButtom, mLeftParames);


        mRightParames = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mRightParames.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButtom, mRightParames);
        //放置标题
        mTitleParames = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mTitleParames.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitleView, mTitleParames);

        mLeftButtom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onLeftClick(view);
                }
            }
        });
        mRightButtom.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onRightClick(view);
                }
            }
        });

    }

    //接口回掉
    public interface OnButtomClickListener {
        void onLeftClick(View v);

        void onRightClick(View v);
    }

    public void setOnButtomClickListener(OnButtomClickListener listener) {
        this.listener = listener;
    }

    //设置左按钮的显示或者隐藏
    public void setLeftVisibility(boolean flag) {
        if (flag) {
            mLeftButtom.setVisibility(VISIBLE);
        } else {
            mLeftButtom.setVisibility(INVISIBLE);
        }
    }

    //设置右按钮的显示或者隐藏
    public void setRightVisibility(boolean flag) {
        if (flag) {
            mRightButtom.setVisibility(VISIBLE);
        } else {
            mRightButtom.setVisibility(INVISIBLE);
        }
    }

}
