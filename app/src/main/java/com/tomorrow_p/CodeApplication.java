package com.tomorrow_p;

import android.app.Application;

import com.tomorrow_p.common.ToastUtils;

/**
 * Created by Ansen on 2016/9/23 11:32.
 *
 * @E-mail: tomorrow_p@163.com
 * @Blog: http://blog.csdn.net/qq_25804863
 * @Github: https://github.com/1031307403/
 * @PROJECT_NAME: CodeRepository
 * @PACKAGE_NAME: com.tomorrow_p
 * @Description: TODO
 */
public class CodeApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ToastUtils.init(this);

    }
}
