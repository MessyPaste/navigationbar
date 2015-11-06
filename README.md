# navigationbar
安卓顶部导航条源代码
使用此代码能让你的安卓应用的顶部导航条做到统一

使用方法如下：
1、使用AS引入一个Module Library依赖；

2、在需要添加导航条的Layout文件中添加：
<FrameLayout
        android:id="@+id/framelayout_fragment1"
        android:layout_width="match_parent"
        android:layout_height="@dimen/navi_bar_height"></FrameLayout>
navi_bar_height数值一般是50dp

3、在代码中找到该framelayout，然后构建自己的导航条

《未完待续》
