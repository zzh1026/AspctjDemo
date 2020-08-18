package com.zzh.login.ui;

import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zzh.base._Login;
import com.zzh.base.base.BaseActivity;
import com.zzh.base.route.ConstantRouter;
import com.zzh.login.databinding.ActivityLoginBinding;

@Route(path = ConstantRouter.LOGIN.LOGIN_HOME)
public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    @Override
    protected ActivityLoginBinding getBinding(LayoutInflater layoutInflater) {
        return ActivityLoginBinding.inflate(layoutInflater);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        mBinding.loginStateTv.setText("当前的登录状态为: " + _Login.isLogin);
    }

    public void changeLoginState(View view) {
        _Login.isLogin = !_Login.isLogin;
        mBinding.loginStateTv.setText("当前的登录状态为: " + _Login.isLogin);
    }
}