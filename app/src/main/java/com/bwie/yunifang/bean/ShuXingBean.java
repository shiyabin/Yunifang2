package com.bwie.yunifang.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author Administrator
 * 3. @date 2017/3/27 14:44
 */


public class ShuXingBean {

    /**
     * code : 200
     * msg : success
     * data : [{"id":"121","goods_name":"镇店之宝丨美白嫩肤面膜7片","shop_price":49.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg","sales_volume":122290,"efficacy":"镇店之宝 美白爆款","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"389","goods_name":"清爽平衡矿物蚕丝面膜黑面膜21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/389/goods_img/16081909368531961221339216.jpg","sales_volume":101790,"efficacy":"以黑吸黑 净透亮肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"85","goods_name":"果味鲜饮|水果鲜润亮肤补水面膜套装17片","shop_price":59.9,"market_price":240,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/85/goods_img/160819085747012099748482408.jpg","sales_volume":92092,"efficacy":"水嫩舒爽 鲜活亮颜","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"684","goods_name":"解救肌渴丨花粹水润面膜套装10片","shop_price":29.9,"market_price":139,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/684/goods_img/160819095063413908186337181.jpg","sales_volume":84106,"efficacy":"水润充盈 鲜嫩少女肌","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"6","goods_name":"好用不贵丨亮颜水润蚕丝面膜（寂地定制版）","shop_price":59.9,"market_price":239.9,"is_coupon_allowed":false,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/6/goods_img/160819084594721181484473699.jpg","sales_volume":69269,"efficacy":"深层补水 提亮肤色","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"772","goods_name":"清爽亮颜黑面膜套装21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/772/goods_img/1608191429278479187604212.jpg","sales_volume":51548,"efficacy":"热销黑膜 净透亮肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"83","goods_name":"黑玫瑰矿物蚕丝面膜7片","shop_price":119,"market_price":139,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/83/goods_img/16081908576425344499831215.jpg","sales_volume":26511,"efficacy":"深度保养 补水提亮","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"428","goods_name":"多彩水润亮颜蚕丝面膜套装21片","shop_price":79.9,"market_price":270.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/428/goods_img/160819094034113421009937866.jpg","sales_volume":22774,"efficacy":"吸黑焕彩 补水保湿","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"257","goods_name":"薰衣草蚕丝面膜7片","shop_price":89,"market_price":109,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/257/goods_img/16081909269443843637779188.jpg","sales_volume":21334,"efficacy":"补水保湿 舒缓修护","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"593","goods_name":"热销黑膜丨葡萄籽琉璃亮颜黑面膜21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/593/goods_img/1608190945359698973439364.jpg","sales_volume":18204,"efficacy":"葡萄鲜饮 净透亮肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"20","goods_name":"清润紧致蚕丝面膜套装21片","shop_price":109.9,"market_price":307,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/20/goods_img/160819084923710469247382812.jpg","sales_volume":15522,"efficacy":"清透滋养 弹嫩紧致","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"400","goods_name":"缤纷鲜润矿物蚕丝面膜套装20片","shop_price":79.9,"market_price":279.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/400/goods_img/16081909375548938767322654.jpg","sales_volume":13168,"efficacy":"补水亮肤 缤纷水嫩","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"745","goods_name":"红石榴矿物蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/745/goods_img/160819095890910677609745693.jpg","sales_volume":11591,"efficacy":"补水保湿 提亮肤色","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"325","goods_name":"竹萃清爽蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/325/goods_img/160819142666914591033736475.jpg","sales_volume":9389,"efficacy":"平衡水油 清爽净透","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"1249","goods_name":"口碑推荐|盈透柔肤黑膜组合装42片","shop_price":149.9,"market_price":594,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1249/goods_img/170104100411616941119547437.jpg","sales_volume":8638,"efficacy":"清洁补水 保湿提亮","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"161","goods_name":"男士补水活力矿物蚕丝7片 今日送7片共14片","shop_price":59.9,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/161/goods_img/16081909077546170320476224.jpg","sales_volume":8123,"efficacy":"补水保湿 清爽控油","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"708","goods_name":"水果护肤力量丨鲜果缤纷黑白面膜套装42片","shop_price":209.9,"market_price":594,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/708/goods_img/16082615049413682815961884.jpg","sales_volume":7144,"efficacy":"新品组合 鲜果养肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"319","goods_name":"男士补水活力矿物蚕丝21片","shop_price":79.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/319/goods_img/16081909273161845841818485.jpg","sales_volume":6230,"efficacy":"补水保湿 清爽控油","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"622","goods_name":"葡萄籽琉璃亮颜黑面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/622/goods_img/160819094698413173347474163.jpg","sales_volume":6195,"efficacy":"葡萄鲜饮 净透亮肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"921","goods_name":"甜橙晶透亮颜矿物面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/921/goods_img/161018083525512130589201446.jpg","sales_volume":5430,"efficacy":"提亮肤色 修护肌肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"557","goods_name":"水润清透养肤面膜套装42片","shop_price":179.9,"market_price":634,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/557/goods_img/160819094421515862876125825.jpg","sales_volume":5224,"efficacy":"清透补水 滋润修护","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"1189","goods_name":"参与满减丨清透水嫩亮颜黑面膜套装21片","shop_price":99.9,"market_price":297,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1189/goods_img/161128144382319687354892538.jpg","sales_volume":5185,"efficacy":"净透补水 润泽提亮","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"163","goods_name":"清爽平衡矿物蚕丝面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/163/goods_img/160819090788311035481315778.jpg","sales_volume":4752,"efficacy":"补水控油 清爽保湿","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"728","goods_name":"竹之清爽3重补水控油面膜套装16片","shop_price":69.9,"market_price":218,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/728/goods_img/16081909518826045996375797.jpg","sales_volume":4213,"efficacy":"补水控油 清透提亮","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"868","goods_name":"男士黑茶清爽矿物面膜  今日买5片送5片","shop_price":49.9,"market_price":150,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/868/goods_img/1608191430564693145258305.jpg","sales_volume":4052,"efficacy":"洁净控油 强劲清爽","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"358","goods_name":"黑玫瑰光感丝羽矿物泥浆面膜5片 可以贴的泥浆面膜","shop_price":89.9,"market_price":99.9,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/358/goods_img/160819142722517851125069766.jpg","sales_volume":3904,"efficacy":"可以贴的泥浆面膜","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"534","goods_name":"净透美白矿物蚕丝面膜套装28片","shop_price":139.9,"market_price":396,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/534/goods_img/160819094245115265661305031.jpg","sales_volume":3896,"efficacy":"清洁净透 以白养白","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"81","goods_name":"人参矿物蚕丝面膜7片","shop_price":89,"market_price":109,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/81/goods_img/160819085711519851862212059.jpg","sales_volume":3793,"efficacy":"提拉紧致 补水保湿","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"334","goods_name":"清爽平衡矿物蚕丝面膜黑面膜7片","shop_price":79,"market_price":99,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/334/goods_img/160819092848420294792181143.jpg","sales_volume":3775,"efficacy":"清洁焕彩 净透亮肤","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0},{"id":"1251","goods_name":"下单立减20元|水果缤纷面膜超值装35片","shop_price":169.9,"market_price":495,"is_coupon_allowed":true,"is_allow_credit":false,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1251/goods_img/170104095895513706519167911.jpg","sales_volume":3618,"efficacy":"清洁控油 补水提亮","watermarkUrl":"https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png","sort":0}]
     */

    private int code;
    private String msg;
    /**
     * id : 121
     * goods_name : 镇店之宝丨美白嫩肤面膜7片
     * shop_price : 49.9
     * market_price : 99.0
     * is_coupon_allowed : true
     * is_allow_credit : false
     * goods_img : https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg
     * sales_volume : 122290
     * efficacy : 镇店之宝 美白爆款
     * watermarkUrl : https://image.yunifang.com/yunifang/images/goods/temp/17032317036337704930007983.png
     * sort : 0
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String goods_name;
        private double shop_price;
        private double market_price;
        private boolean is_coupon_allowed;
        private boolean is_allow_credit;
        private String goods_img;
        private int sales_volume;
        private String efficacy;
        private String watermarkUrl;
        private int sort;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public double getShop_price() {
            return shop_price;
        }

        public void setShop_price(double shop_price) {
            this.shop_price = shop_price;
        }

        public double getMarket_price() {
            return market_price;
        }

        public void setMarket_price(double market_price) {
            this.market_price = market_price;
        }

        public boolean isIs_coupon_allowed() {
            return is_coupon_allowed;
        }

        public void setIs_coupon_allowed(boolean is_coupon_allowed) {
            this.is_coupon_allowed = is_coupon_allowed;
        }

        public boolean isIs_allow_credit() {
            return is_allow_credit;
        }

        public void setIs_allow_credit(boolean is_allow_credit) {
            this.is_allow_credit = is_allow_credit;
        }

        public String getGoods_img() {
            return goods_img;
        }

        public void setGoods_img(String goods_img) {
            this.goods_img = goods_img;
        }

        public int getSales_volume() {
            return sales_volume;
        }

        public void setSales_volume(int sales_volume) {
            this.sales_volume = sales_volume;
        }

        public String getEfficacy() {
            return efficacy;
        }

        public void setEfficacy(String efficacy) {
            this.efficacy = efficacy;
        }

        public String getWatermarkUrl() {
            return watermarkUrl;
        }

        public void setWatermarkUrl(String watermarkUrl) {
            this.watermarkUrl = watermarkUrl;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
