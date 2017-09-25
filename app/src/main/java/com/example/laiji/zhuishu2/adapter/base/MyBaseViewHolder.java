package com.example.laiji.zhuishu2.adapter.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/25 0025.
 */

public class MyBaseViewHolder extends RecyclerView.ViewHolder {
//    private final HashMap<Integer, View> mHashMap;
    private final SparseArray<View> mSparseArray;

//    private TextView tv_item;



    public MyBaseViewHolder(View itemView) {
        super(itemView);
//        mHashMap = new HashMap<>();
        //SparseArray 的key内部限定了就是Integer
        mSparseArray = new SparseArray<>();
//        tv_item = itemView.findViewById(R.id.tv_item);
    }

    //做一些快速的设置数据的代码逻辑 setText
    /**
     * @param viewId 代表你要设置文本的哪个控件的id
     * @param text
     */
    public void setText(int viewId, String text) {
        //为了避免每次都要去findViewById,准备一个集合来做一个缓存
//        View view = itemView.findViewById(R.id.tv_item);
        View view = getView(viewId);
        if (view instanceof TextView) {
            ((TextView) view).setText(text);
        }
    }

    //设置图片展示
    public void setImageRes(int viewId, int imgId) {
        //为了避免每次都要去findViewById,准备一个集合来做一个缓存
//        View view = itemView.findViewById(R.id.tv_item);
        View view = getView(viewId);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(imgId);
        }
    }

    public View getView(int viewId) {
        View view = mSparseArray.get(viewId);
        if(view==null){
            //如果map中没有的话,就去findViewById,并且将这个view存到map里面去
            view = itemView.findViewById(viewId);
            mSparseArray.put(viewId,view);
        }
        //有的话,就直接返回
        return view;
    }


//    public void setTags(int viewId, ArrayList<String> tags) {
//        View view = getView(viewId);
//        if(view instanceof LinearLayout){
//            //先移除掉以前复用之前所添加的一些view
//            ((LinearLayout)view).removeAllViews();
//            Log.e(getClass().getSimpleName()+" xmg", "setTags: "+tags.size());
//            //添加TextView到容器中
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(-2, WindowManager.LayoutParams.WRAP_CONTENT);
//            params.setMargins(0,0,UIUtil.dp2px(8),0);
//            for (int i = 0; i < tags.size(); i++) {
//                String s = tags.get(i);
//                TextView textView = new TextView(view.getContext());
//                textView.setText(s);
//                textView.setTextSize(10);
//                textView.setTextColor(view.getContext().getResources().getColor(R.color.top_gray));
//                textView.setBackgroundResource(R.drawable.bg_tag);
//                //给textView设置内部的padding,将背景图撑大
//                textView.setPadding(UIUtil.dp2px(10),UIUtil.dp2px(5),UIUtil.dp2px(10),UIUtil.dp2px(5));
//                textView.setGravity(Gravity.CENTER);
//                ((LinearLayout)view).addView(textView,params);
//            }
//        }
//    }

//    public void loadImage(int viewId, String url) {
//        View view = getView(viewId);
//        ImageUtil.getSingleton().loadImage(view,url);
//    }



    public void setBackground(int viewId, int resId) {
        View view = getView(viewId);
        view.setBackgroundResource(resId);
    }
}
