package edu.cumt.bruce.dontforget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 主页面的pageradapter
 * Created by Bruce_ZZCOM on 2019/6/5.
 */

public class MainContentAdapter extends PagerAdapter {

    private List<View> views;

    public MainContentAdapter(List<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1){
        return arg0 == arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position){
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup concainer, int position, Object object) {
        concainer.removeView(views.get(position));
    }
}
