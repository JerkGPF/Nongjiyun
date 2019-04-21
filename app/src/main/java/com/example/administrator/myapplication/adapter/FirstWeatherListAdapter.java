//package com.example.administrator.myapplication.adapter;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import com.example.test.R;
//import com.example.test.entity.Weather;
//
//import java.util.List;
//
//public class FirstWeatherListAdapter extends BaseAdapter {
//
//    private List<Weather.ForecastBean> list;
//    private Context context;
//
//    public FirstWeatherListAdapter(List<Weather.ForecastBean> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }
//
//    @Override
//    public int getCount() {
//        return list.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @SuppressLint("InflateParams")
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_weather, null);
//            holder = new ViewHolder(convertView);
//            convertView.setTag(holder);
//        }else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        Weather.ForecastBean bean = list.get(position);
//        holder.tv_date.setText(bean.getDate());
//        holder.tv_tmp.setText(getTemp(bean.getHigh())+"/"+getTemp(bean.getLow()));
//        holder.tv_tq.setText(bean.getType());
//        return convertView;
//    }
//
//    private String getTemp(String high) {
//        int index1 = high.indexOf(" ");
//        int index2 = high.indexOf("℃");
//        return high.substring(index1, index2)+"°";
//    }
//
//    public static class ViewHolder {
//        public View rootView;
//        public TextView tv_date;
//        public TextView img1;
//        public TextView tv_tq;
//        public TextView tv_tmp;
//
//        public ViewHolder(View rootView) {
//            this.rootView = rootView;
//            this.tv_date = rootView.findViewById(R.id.tv_date);
//            this.img1 = rootView.findViewById(R.id.img1);
//            this.tv_tq = rootView.findViewById(R.id.tv_tq);
//            this.tv_tmp = rootView.findViewById(R.id.tv_tmp);
//        }
//
//    }
//}
