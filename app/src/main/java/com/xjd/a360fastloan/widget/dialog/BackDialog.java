package com.xjd.a360fastloan.widget.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.DialogBackLayoutBinding;

/**
 * @author ：LiMing
 * @date ：2019-06-25
 * @desc ：
 */
public class BackDialog extends Dialog {
    private Context mContext;

    private BackDialogListener      mBackDialogListener;
    private DialogBackLayoutBinding mBinding;

    public BackDialog(@NonNull Context context, BackDialogListener backDialogListener) {
        super(context, R.style.DialogBaseStyle);
        mContext = context;
        mBackDialogListener = backDialogListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.dialog_back_layout, null, false);
        this.setContentView(mBinding.getRoot());

        WindowManager              m      = ((Activity) mContext).getWindowManager();
        Display                    d      = m.getDefaultDisplay(); // 为获取屏幕宽、高
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.width = (int) ((d.getWidth()) * 0.8);
        params.height = params.height;
        this.getWindow().setAttributes(params);
        initView();
    }

    private void initView() {
        mBinding.tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (mBackDialogListener != null) {
                    mBackDialogListener.onback();
                }
            }
        });
        mBinding.tvContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

            }
        });
    }

    public interface BackDialogListener {
        void onback();


    }
}
