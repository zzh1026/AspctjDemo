package com.zzh.aopdemo;

import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zzh.aop.aspectannotation.AutoLog;
import com.zzh.aop.aspectannotation.NeedLogin;
import com.zzh.aopdemo.databinding.ActivityMainBinding;
import com.zzh.base._Login;
import com.zzh.base.base.BaseActivity;
import com.zzh.base.route.ConstantRouter;
import com.zzh.base.route.RouterJumpUtils;

@Route(path = ConstantRouter.MAIN.MAIN_HOME)
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    protected ActivityMainBinding getBinding(LayoutInflater layoutInflater) {
        return ActivityMainBinding.inflate(layoutInflater);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBinding.loginStateTv.setText("当前的登录状态为: " + _Login.isLogin);
    }

    @NeedLogin
    public void tryToDetail(View view) {
        RouterJumpUtils.navigation(ConstantRouter.PRODUCT.PRODUCT_HOME);
    }

    @AutoLog
    public void changeLoginState(View view) {
        _Login.isLogin = !_Login.isLogin;
        mBinding.loginStateTv.setText("当前的登录状态为: " + _Login.isLogin);
    }
}