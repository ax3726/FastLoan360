package com.lm.lib_common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @Function: 自定义高度，以适应嵌套滚动控件
 * @Author sqq
 * @Date: 2015-10-21 下午7:31:31
 */
public class NoScrollListView extends ListView {

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public NoScrollListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public NoScrollListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * 重写该方法，达到使ListView适应ScrollView的效果
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
