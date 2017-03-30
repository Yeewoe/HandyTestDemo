package org.yeewoe.handytestdemo.view.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import org.yeewoe.handytestdemo.R;
import org.yeewoe.handytestdemo.view.holder.ToolbarHolder;

import butterknife.ButterKnife;

/**
 * 基础Activity，封裝了一些固定流程，Toolbar的生成等
 * <p>
 * Created by ivo on 2017/3/28.
 */

public abstract class HandyBaseActivity extends AppCompatActivity {

    private ToolbarHolder mToolbarHolder;

    /**
     * 获取布局文件
     */
    protected abstract int getContentViewLayoutId();

    /**
     * 初始化Intent数据
     */
    protected abstract void initIntent(Intent intent);

    /**
     * 绑定Intent数据
     */
    protected abstract void bindIntent();

    /**
     * 同步加载数据
     */
    protected abstract void loadSyncData();

    /**
     * 异步加载数据
     */
    protected abstract void loadAsyncData();

    /**
     * 保存临时数据，可以用于恢复
     */
    protected abstract void saveInstanceState(Bundle outState);

    /**
     * 恢复临时数据
     */
    protected abstract void restoreInstanceState(Bundle savedInstanceState);

    @Override final protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** 以下方法的顺序不能调换 **/
        setContentView(getContentViewLayoutId());
        /** 使用ButterKnife **/
        ButterKnife.bind(this);
        initToolbar();
        initIntent(getIntent());
        initView();
        bindViewListener();
        bindIntent();
        loadSyncData();
        loadAsyncData();
    }

    /**
     * 初始化View，也可以通过ButterKnife进行注解绑定控件
     */
    protected void initView() {

    }

    /**
     * 注解View事件,也可以通过ButterKnife进行注解註冊事件
     */
    protected void bindViewListener() {

    }

    /**
     * 强制子类进行实现，养成保存临时数据的习惯，优化界面体验
     */
    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveInstanceState(outState);
    }

    /**
     * 强制子类进行实现，养成保存临时数据的习惯，优化界面体验
     */
    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreInstanceState(savedInstanceState);
    }

    /**
     * 获取标题Holder类
     */
    protected ToolbarHolder getToolbarHolder() {
        return mToolbarHolder;
    }

    /**
     * 初始化公共Toolbar
     */
    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            /** 这里可以做一些对Toolbar的公共处理， 也可以提取一个Holder类进行单独处理 **/
            mToolbarHolder = new ToolbarHolder(toolbar);
        }
    }
}
