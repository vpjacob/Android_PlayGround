# Android_PlayGround

安卓练习的娱乐场

#安卓activity活动
```
Intent intent = new 
Intent(FirstActivity.this,secondActivity.class);
```


#安卓生命循环
```
onCreate
onStart
onResume
onPause
onStop
onDestroy
onRestart（返回上一个活动）

活动模式
standard基础活动
singleTop判断最顶层是否是这个活动，是不创建，不是创建
singleTask每次都要判断是否有这个活动
singleInstance

```
#安卓UI控件
```
TextView
Button
EditView
ImageView
ProgressBar
AlertDialog
ProgeressDialog

```
#安卓布局

##LinearLayout

```
button1
<!--android:layout_width="0dp"-->
<!--android:layout_weight="1"-->
button2
<!--android:layout_width="wrap_content"-->

```
可以达到button2自动调整。剩下button1全部占满
RelativeLayout

```
android:layout_width="wrap_content"
android:layout_height="wrap_content"
android:layout_alignParentRight="true"
android:layout_centerInParent="true"
android:layout_alignParentBottom="true"
```

##FrameLayout

```

```

##PercentFrameLayout

build.grandle

增加compile 'com.android.support:percent:24.+'

引入完整路径和命名空间

```
android.support.percent.PercentFrameLayout
xmlns:app="http://schemas.android.com/apk/res-auto"

<Button
android:id="@+id/button1"
android:text="Button1"
android:layout_gravity="left|top"
app:layout_heightPercent="50%"
app:layout_widthPercent="50%"
/>

<Button
android:id="@+id/button2"
android:text="Button 2"
android:layout_gravity="right|top"
app:layout_heightPercent="50%"
app:layout_widthPercent="50%"
/>

<Button
android:id="@+id/button3"
android:text="Button3"
android:layout_gravity="left|bottom"
app:layout_heightPercent="50%"
app:layout_widthPercent="50%"
/>

<Button
android:text="Btton4"
android:id="@+id/button4"
android:layout_gravity="right|bottom"
app:layout_heightPercent="50%"
app:layout_widthPercent="50%"
/>
```
不显示提示，大胆写

#安卓自定义控件

例如返回按钮

首先创建个button和一个textview  的xml文件layout

如果直接使用的可以直接在mainActivity中

1隐藏  2加载这个layout 3在main_layout中include

```
setContentView(R.layout.activity_main);
ActionBar actionBar = getSupportActionBar();
if (actionBar != null){
actionBar.hide();
}
<include layout="@layout/title"/>

```
如果添加动作时间，还需要新建一个activity，然后在main_layout中引用这个activity

```
1-------------------
public class TitleLayout_new extends LinearLayout {

public TitleLayout_new(Context context, AttributeSet attrs) {
super(context,attrs);
LayoutInflater.from(context).inflate(R.layout.title,this);
Button button = (Button)findViewById(R.id.title_back);
button.setOnClickListener(new OnClickListener() {
@Override
public void onClick(View view) {
Log.d("TitleLayout_new", "onClick: ");
}
});
}
2----------------
<com.example.liuyi.uicustomviews.TitleLayout_new
android:layout_height="wrap_content"
android:layout_width="match_parent"
/>

}

```
