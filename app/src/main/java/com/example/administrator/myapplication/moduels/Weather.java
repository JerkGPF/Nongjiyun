package com.example.administrator.myapplication.moduels;

import java.util.List;

public class Weather {

    /**
     * yesterday : {"date":"11日星期五","high":"高温 24℃","fx":"东南风","low":"低温 18℃","fl":"<![CDATA[3-4级]]>","type":"雷阵雨"}
     * city : 南京
     * aqi : 75
     * forecast : [{"date":"12日星期六","high":"高温 22℃","fengli":"<![CDATA[3-4级]]>","low":"低温 18℃","fengxiang":"北风","type":"雷阵雨"},{"date":"13日星期天","high":"高温 31℃","fengli":"<![CDATA[3-4级]]>","low":"低温 21℃","fengxiang":"南风","type":"多云"},{"date":"14日星期一","high":"高温 33℃","fengli":"<![CDATA[3-4级]]>","low":"低温 24℃","fengxiang":"南风","type":"多云"},{"date":"15日星期二","high":"高温 33℃","fengli":"<![CDATA[3-4级]]>","low":"低温 25℃","fengxiang":"南风","type":"多云"},{"date":"16日星期三","high":"高温 34℃","fengli":"<![CDATA[3-4级]]>","low":"低温 25℃","fengxiang":"南风","type":"雷阵雨"}]
     * ganmao : 相对今天出现了较大幅度降温，较易发生感冒，体质较弱的朋友请注意适当防护。
     * wendu : 22
     */
    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private List<ForecastBean> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class ForecastBean {
        /**
         * date : 12日星期六
         * high : 高温 22℃
         * fengli : <![CDATA[3-4级]]>
         * low : 低温 18℃
         * fengxiang : 北风
         * type : 雷阵雨
         */

        private String date;
        private String high;
        private String fengli;
        private String low;
        private String fengxiang;
        private String type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getFengli() {
            return fengli;
        }

        public void setFengli(String fengli) {
            this.fengli = fengli;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getFengxiang() {
            return fengxiang;
        }

        public void setFengxiang(String fengxiang) {
            this.fengxiang = fengxiang;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "ForecastBean{" +
                    "date='" + date + '\'' +
                    ", high='" + high + '\'' +
                    ", fengli='" + fengli + '\'' +
                    ", low='" + low + '\'' +
                    ", fengxiang='" + fengxiang + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", aqi='" + aqi + '\'' +
                ", ganmao='" + ganmao + '\'' +
                ", wendu='" + wendu + '\'' +
                ", forecast=" + forecast +
                '}';
    }
}
