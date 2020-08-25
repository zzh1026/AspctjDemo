package com.zzh.product;

import android.view.LayoutInflater;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zzh.aop.aspectannotation.NeedLogin;
import com.zzh.aop.aspectannotation.SingleClick;
import com.zzh.base._Login;
import com.zzh.base.base.BaseActivity;
import com.zzh.base.route.ConstantRouter;
import com.zzh.base.route.RouterJumpUtils;
import com.zzh.product.databinding.ActivityProductBinding;

@Route(path = ConstantRouter.PRODUCT.PRODUCT_HOME)
public class ProductActivity extends BaseActivity<ActivityProductBinding> {
    @Override
    protected ActivityProductBinding getBinding(LayoutInflater layoutInflater) {
        return ActivityProductBinding.inflate(layoutInflater);
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
    public void tryToBuy(View view) {
        RouterJumpUtils.navigation(ConstantRouter.MAIN.MAIN_HOME);
    }

    @SingleClick
    public void changeLoginState(View view) {
        _Login.isLogin = !_Login.isLogin;
        mBinding.loginStateTv.setText("当前的登录状态为: " + _Login.isLogin);
    }
}