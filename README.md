# navigationbar
安卓顶部导航条源代码
===========================
使用此代码能让你的安卓应用的顶部导航条做到统一
-------
使用步骤：

#1、引入依赖包
使用AS引入navigationbarlib这样的一个Module Library依赖包；<br>

#2、构建布局：
###（1）构建导航条View：
目前默认有三种风格,文字、图片和自定义，首先调用buildXXXView()方法，XXX可以是left、center或right，然后再调用特定视图的方法:<br>
buildSideText();侧边文字<br>
buildTitleText();标题文字<br>
buildSideImg();侧边图片<br>
buildCustomView();自定义布局<br>
具体示例如下所示：<br>
![image](https://raw.githubusercontent.com/LiuTaw/navigationbar/master/navi_sreenshot.jpg)<br>

示例：<br>
NaviBarBuilder naviBarBuilder1 = new NaviBarBuilder(context);<br>
naviBarBuilder1.buildLeftView().buildSideText("左文字").buildCenterView().buildTitleText("标题文字测试")<br>
.buildRightView().buildSideText("右文字");//按照buildXXXView().buildXXX()的形式构建<br>

###（2）设置监听器：
总共有3个监听器，分别对应左、中和右边的点击事件（如：setOnLeftViewOnClickListener）;<br>
如需获得更多监听事件可以通过getView获取具体的view对象再设置一些监听器。<br>

#3、添加导航条布局容器：
一般将以下代码放入至需要假如导航条的layout文件中，注意一般不要放入srollview中<br>
<FrameLayout<br>
        android:id="@+id/framelayout_fragment1"<br>
        android:layout_width="match_parent"<br>
        android:layout_height="@dimen/navi_bar_height"></FrameLayout><br>

navi_bar_height数值一般是50dp<br>

#4、将导航条布局加入到容器中：
找到布局容器FrameLayout（如framelayout_fragment1）并调用addView方法将导航条view加入到容器中。<br>
需要调用NaviBarBuilder类的build()方法得到之前构建的view;<br>
framelayout_fragment1.addView(naviBarBuilder1.build());<br>

