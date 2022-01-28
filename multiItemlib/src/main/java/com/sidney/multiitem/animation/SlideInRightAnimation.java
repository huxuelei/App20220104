package com.sidney.multiitem.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * 描 述：slide 动画
 * 作 者：hxl  2022/1/28 14:50
 * 修改描述：
 * 修 改 人：xxx  2022/1/28 14:50
 * 修改版本：
 */
public class SlideInRightAnimation implements BaseAnimation {

    @Override
    public Animator[] getAnimators(View view) {
        return new Animator[]{
                ObjectAnimator.ofFloat(view, "translationX", view.getRootView().getWidth(), 0)
        };
    }
}
