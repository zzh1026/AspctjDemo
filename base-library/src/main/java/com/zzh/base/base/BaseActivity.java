package com.zzh.base.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * 车主邦
 * ---------------------------
 * <p>
 * Created by zhaozh on 2020/8/11.
 */
public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {

    protected T mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getBinding(getLayoutInflater());
        if (mBinding == null) {
            throw new IllegalArgumentException("getBinding() must not back null");
        }
        setContentView(mBinding.getRoot());
        ARouter.getInstance().inject(this);
        initData();
    }

    protected abstract T getBinding(LayoutInflater layoutInflater);

    protected abstract void initData();
}
