package com.heidian.backstage.service;

/**
 * @author ：SunWen
 * @date ：Created in 2019/12/24 15:12
 * @description：城市数据
 * @modified By：
 * @version: 1.0.0$
 */
public class CityService {

    private String cityJSON="[{\"district\":\"北京\"},\n" +
            "{\"district\":\"天津\"},\n" +
            "{\"district\":\"石家庄\"},\n" +
            "{\"district\":\"唐山\"},\n" +
            "{\"district\":\"秦皇岛\"},\n" +
            "{\"district\":\"邯郸\"},\n" +
            "{\"district\":\"邢台\"},\n" +
            "{\"district\":\"保定\"},\n" +
            "{\"district\":\"张家口\"},\n" +
            "{\"district\":\"承德\"},\n" +
            "{\"district\":\"沧州\"},\n" +
            "{\"district\":\"廊坊\"},\n" +
            "{\"district\":\"衡水\"},\n" +
            "{\"district\":\"太原\"},\n" +
            "{\"district\":\"大同\"},\n" +
            "{\"district\":\"阳泉\"},\n" +
            "{\"district\":\"长治\"},\n" +
            "{\"district\":\"晋城\"},\n" +
            "{\"district\":\"朔州\"},\n" +
            "{\"district\":\"晋中\"},\n" +
            "{\"district\":\"运城\"},\n" +
            "{\"district\":\"忻州\"},\n" +
            "{\"district\":\"临汾\"},\n" +
            "{\"district\":\"吕梁\"},\n" +
            "{\"district\":\"呼和浩特\"},\n" +
            "{\"district\":\"包头\"},\n" +
            "{\"district\":\"乌海\"},\n" +
            "{\"district\":\"赤峰\"},\n" +
            "{\"district\":\"通辽\"},\n" +
            "{\"district\":\"鄂尔多斯\"},\n" +
            "{\"district\":\"呼伦贝尔\"},\n" +
            "{\"district\":\"巴彦淖尔\"},\n" +
            "{\"district\":\"乌兰察布\"},\n" +
            "{\"district\":\"兴安盟\"},\n" +
            "{\"district\":\"锡林郭勒盟\"},\n" +
            "{\"district\":\"阿拉善盟\"},\n" +
            "{\"district\":\"沈阳\"},\n" +
            "{\"district\":\"大连\"},\n" +
            "{\"district\":\"鞍山\"},\n" +
            "{\"district\":\"抚顺\"},\n" +
            "{\"district\":\"本溪\"},\n" +
            "{\"district\":\"丹东\"},\n" +
            "{\"district\":\"锦州\"},\n" +
            "{\"district\":\"营口\"},\n" +
            "{\"district\":\"阜新\"},\n" +
            "{\"district\":\"辽阳\"},\n" +
            "{\"district\":\"盘锦\"},\n" +
            "{\"district\":\"铁岭\"},\n" +
            "{\"district\":\"朝阳\"},\n" +
            "{\"district\":\"葫芦岛\"},\n" +
            "{\"district\":\"金普新区\"},\n" +
            "{\"district\":\"长春\"},\n" +
            "{\"district\":\"吉林\"},\n" +
            "{\"district\":\"四平\"},\n" +
            "{\"district\":\"辽源\"},\n" +
            "{\"district\":\"通化\"},\n" +
            "{\"district\":\"白山\"},\n" +
            "{\"district\":\"松原\"},\n" +
            "{\"district\":\"白城\"},\n" +
            "{\"district\":\"延边\"},\n" +
            "{\"district\":\"哈尔滨\"},\n" +
            "{\"district\":\"齐齐哈尔\"},\n" +
            "{\"district\":\"鸡西\"},\n" +
            "{\"district\":\"鹤岗\"},\n" +
            "{\"district\":\"双鸭山\"},\n" +
            "{\"district\":\"大庆\"},\n" +
            "{\"district\":\"伊春\"},\n" +
            "{\"district\":\"佳木斯\"},\n" +
            "{\"district\":\"七台河\"},\n" +
            "{\"district\":\"牡丹江\"},\n" +
            "{\"district\":\"黑河\"},\n" +
            "{\"district\":\"绥化\"},\n" +
            "{\"district\":\"大兴安岭\"},\n" +
            "{\"district\":\"上海\"},\n" +
            "{\"district\":\"南京\"},\n" +
            "{\"district\":\"无锡\"},\n" +
            "{\"district\":\"徐州\"},\n" +
            "{\"district\":\"常州\"},\n" +
            "{\"district\":\"苏州\"},\n" +
            "{\"district\":\"南通\"},\n" +
            "{\"district\":\"连云港\"},\n" +
            "{\"district\":\"淮安\"},\n" +
            "{\"district\":\"盐城\"},\n" +
            "{\"district\":\"扬州\"},\n" +
            "{\"district\":\"镇江\"},\n" +
            "{\"district\":\"泰州\"},\n" +
            "{\"district\":\"宿迁\"},\n" +
            "{\"district\":\"杭州\"},\n" +
            "{\"district\":\"宁波\"},\n" +
            "{\"district\":\"温州\"},\n" +
            "{\"district\":\"嘉兴\"},\n" +
            "{\"district\":\"湖州\"},\n" +
            "{\"district\":\"绍兴\"},\n" +
            "{\"district\":\"金华\"},\n" +
            "{\"district\":\"衢州\"},\n" +
            "{\"district\":\"舟山\"},\n" +
            "{\"district\":\"台州\"},\n" +
            "{\"district\":\"丽水\"},\n" +
            "{\"district\":\"舟山新区\"},\n" +
            "{\"district\":\"合肥\"},\n" +
            "{\"district\":\"芜湖\"},\n" +
            "{\"district\":\"蚌埠\"},\n" +
            "{\"district\":\"淮南\"},\n" +
            "{\"district\":\"马鞍山\"},\n" +
            "{\"district\":\"淮北\"},\n" +
            "{\"district\":\"铜陵\"},\n" +
            "{\"district\":\"安庆\"},\n" +
            "{\"district\":\"黄山\"},\n" +
            "{\"district\":\"滁州\"},\n" +
            "{\"district\":\"阜阳\"},\n" +
            "{\"district\":\"宿州\"},\n" +
            "{\"district\":\"六安\"},\n" +
            "{\"district\":\"亳州\"},\n" +
            "{\"district\":\"池州\"},\n" +
            "{\"district\":\"宣城\"},\n" +
            "{\"district\":\"福州\"},\n" +
            "{\"district\":\"厦门\"},\n" +
            "{\"district\":\"莆田\"},\n" +
            "{\"district\":\"三明\"},\n" +
            "{\"district\":\"泉州\"},\n" +
            "{\"district\":\"漳州\"},\n" +
            "{\"district\":\"南平\"},\n" +
            "{\"district\":\"龙岩\"},\n" +
            "{\"district\":\"宁德\"},\n" +
            "{\"district\":\"南昌\"},\n" +
            "{\"district\":\"景德镇\"},\n" +
            "{\"district\":\"萍乡\"},\n" +
            "{\"district\":\"九江\"},\n" +
            "{\"district\":\"新余\"},\n" +
            "{\"district\":\"鹰潭\"},\n" +
            "{\"district\":\"赣州\"},\n" +
            "{\"district\":\"吉安\"},\n" +
            "{\"district\":\"宜春\"},\n" +
            "{\"district\":\"抚州\"},\n" +
            "{\"district\":\"上饶\"},\n" +
            "{\"district\":\"济南\"},\n" +
            "{\"district\":\"青岛\"},\n" +
            "{\"district\":\"淄博\"},\n" +
            "{\"district\":\"枣庄\"},\n" +
            "{\"district\":\"东营\"},\n" +
            "{\"district\":\"烟台\"},\n" +
            "{\"district\":\"潍坊\"},\n" +
            "{\"district\":\"济宁\"},\n" +
            "{\"district\":\"泰安\"},\n" +
            "{\"district\":\"威海\"},\n" +
            "{\"district\":\"日照\"},\n" +
            "{\"district\":\"莱芜\"},\n" +
            "{\"district\":\"临沂\"},\n" +
            "{\"district\":\"德州\"},\n" +
            "{\"district\":\"聊城\"},\n" +
            "{\"district\":\"滨州\"},\n" +
            "{\"district\":\"菏泽\"},\n" +
            "{\"district\":\"郑州\"},\n" +
            "{\"district\":\"开封\"},\n" +
            "{\"district\":\"洛阳\"},\n" +
            "{\"district\":\"平顶山\"},\n" +
            "{\"district\":\"安阳\"},\n" +
            "{\"district\":\"鹤壁\"},\n" +
            "{\"district\":\"新乡\"},\n" +
            "{\"district\":\"焦作\"},\n" +
            "{\"district\":\"濮阳\"},\n" +
            "{\"district\":\"许昌\"},\n" +
            "{\"district\":\"漯河\"},\n" +
            "{\"district\":\"三门峡\"},\n" +
            "{\"district\":\"南阳\"},\n" +
            "{\"district\":\"商丘\"},\n" +
            "{\"district\":\"信阳\"},\n" +
            "{\"district\":\"周口\"},\n" +
            "{\"district\":\"驻马店\"},\n" +
            "{\"district\":\" \"},\n" +
            "{\"district\":\"武汉\"},\n" +
            "{\"district\":\"黄石\"},\n" +
            "{\"district\":\"十堰\"},\n" +
            "{\"district\":\"宜昌\"},\n" +
            "{\"district\":\"襄阳\"},\n" +
            "{\"district\":\"鄂州\"},\n" +
            "{\"district\":\"荆门\"},\n" +
            "{\"district\":\"孝感\"},\n" +
            "{\"district\":\"荆州\"},\n" +
            "{\"district\":\"黄冈\"},\n" +
            "{\"district\":\"咸宁\"},\n" +
            "{\"district\":\"随州\"},\n" +
            "{\"district\":\"恩施\"},\n" +
            "{\"district\":\" \"},\n" +
            "{\"district\":\"长沙\"},\n" +
            "{\"district\":\"株洲\"},\n" +
            "{\"district\":\"湘潭\"},\n" +
            "{\"district\":\"衡阳\"},\n" +
            "{\"district\":\"邵阳\"},\n" +
            "{\"district\":\"岳阳\"},\n" +
            "{\"district\":\"常德\"},\n" +
            "{\"district\":\"张家界\"},\n" +
            "{\"district\":\"益阳\"},\n" +
            "{\"district\":\"郴州\"},\n" +
            "{\"district\":\"永州\"},\n" +
            "{\"district\":\"怀化\"},\n" +
            "{\"district\":\"娄底\"},\n" +
            "{\"district\":\"湘西\"},\n" +
            "{\"district\":\"广州\"},\n" +
            "{\"district\":\"韶关\"},\n" +
            "{\"district\":\"深圳\"},\n" +
            "{\"district\":\"珠海\"},\n" +
            "{\"district\":\"汕头\"},\n" +
            "{\"district\":\"佛山\"},\n" +
            "{\"district\":\"江门\"},\n" +
            "{\"district\":\"湛江\"},\n" +
            "{\"district\":\"茂名\"},\n" +
            "{\"district\":\"肇庆\"},\n" +
            "{\"district\":\"惠州\"},\n" +
            "{\"district\":\"梅州\"},\n" +
            "{\"district\":\"汕尾\"},\n" +
            "{\"district\":\"河源\"},\n" +
            "{\"district\":\"阳江\"},\n" +
            "{\"district\":\"清远\"},\n" +
            "{\"district\":\"东莞\"},\n" +
            "{\"district\":\"中山\"},\n" +
            "{\"district\":\"潮州\"},\n" +
            "{\"district\":\"揭阳\"},\n" +
            "{\"district\":\"云浮\"},\n" +
            "{\"district\":\"南宁\"},\n" +
            "{\"district\":\"柳州\"},\n" +
            "{\"district\":\"桂林\"},\n" +
            "{\"district\":\"梧州\"},\n" +
            "{\"district\":\"北海\"},\n" +
            "{\"district\":\"防城港\"},\n" +
            "{\"district\":\"钦州\"},\n" +
            "{\"district\":\"贵港\"},\n" +
            "{\"district\":\"玉林\"},\n" +
            "{\"district\":\"百色\"},\n" +
            "{\"district\":\"贺州\"},\n" +
            "{\"district\":\"河池\"},\n" +
            "{\"district\":\"来宾\"},\n" +
            "{\"district\":\"崇左\"},\n" +
            "{\"district\":\"海口\"},\n" +
            "{\"district\":\"三亚\"},\n" +
            "{\"district\":\"三沙\"},\n" +
            "{\"district\":\" \"},\n" +
            "{\"district\":\"重庆\"},\n" +
            "{\"district\":\"两江新区\"},\n" +
            "{\"district\":\"成都\"},\n" +
            "{\"district\":\"自贡\"},\n" +
            "{\"district\":\"攀枝花\"},\n" +
            "{\"district\":\"泸州\"},\n" +
            "{\"district\":\"德阳\"},\n" +
            "{\"district\":\"绵阳\"},\n" +
            "{\"district\":\"广元\"},\n" +
            "{\"district\":\"遂宁\"},\n" +
            "{\"district\":\"内江\"},\n" +
            "{\"district\":\"乐山\"},\n" +
            "{\"district\":\"南充\"},\n" +
            "{\"district\":\"眉山\"},\n" +
            "{\"district\":\"宜宾\"},\n" +
            "{\"district\":\"广安\"},\n" +
            "{\"district\":\"达州\"},\n" +
            "{\"district\":\"雅安\"},\n" +
            "{\"district\":\"巴中\"},\n" +
            "{\"district\":\"资阳\"},\n" +
            "{\"district\":\"阿坝\"},\n" +
            "{\"district\":\"甘孜\"},\n" +
            "{\"district\":\"凉山\"},\n" +
            "{\"district\":\"贵阳\"},\n" +
            "{\"district\":\"六盘水\"},\n" +
            "{\"district\":\"遵义\"},\n" +
            "{\"district\":\"安顺\"},\n" +
            "{\"district\":\"毕节\"},\n" +
            "{\"district\":\"铜仁\"},\n" +
            "{\"district\":\"黔西南\"},\n" +
            "{\"district\":\"黔东南\"},\n" +
            "{\"district\":\"黔南\"},\n" +
            "{\"district\":\"昆明\"},\n" +
            "{\"district\":\"曲靖\"},\n" +
            "{\"district\":\"玉溪\"},\n" +
            "{\"district\":\"保山\"},\n" +
            "{\"district\":\"昭通\"},\n" +
            "{\"district\":\"丽江\"},\n" +
            "{\"district\":\"普洱\"},\n" +
            "{\"district\":\"临沧\"},\n" +
            "{\"district\":\"楚雄\"},\n" +
            "{\"district\":\"红河\"},\n" +
            "{\"district\":\"文山\"},\n" +
            "{\"district\":\"西双版纳\"},\n" +
            "{\"district\":\"大理\"},\n" +
            "{\"district\":\"德宏\"},\n" +
            "{\"district\":\"怒江\"},\n" +
            "{\"district\":\"迪庆\"},\n" +
            "{\"district\":\"拉萨\"},\n" +
            "{\"district\":\"日喀则\"},\n" +
            "{\"district\":\"昌都\"},\n" +
            "{\"district\":\"山南\"},\n" +
            "{\"district\":\"那曲\"},\n" +
            "{\"district\":\"阿里\"},\n" +
            "{\"district\":\"林芝\"},\n" +
            "{\"district\":\"西安\"},\n" +
            "{\"district\":\"铜川\"},\n" +
            "{\"district\":\"宝鸡\"},\n" +
            "{\"district\":\"咸阳\"},\n" +
            "{\"district\":\"渭南\"},\n" +
            "{\"district\":\"延安\"},\n" +
            "{\"district\":\"汉中\"},\n" +
            "{\"district\":\"榆林\"},\n" +
            "{\"district\":\"安康\"},\n" +
            "{\"district\":\"商洛\"},\n" +
            "{\"district\":\"西咸\"},\n" +
            "{\"district\":\"兰州\"},\n" +
            "{\"district\":\"嘉峪关\"},\n" +
            "{\"district\":\"金昌\"},\n" +
            "{\"district\":\"白银\"},\n" +
            "{\"district\":\"天水\"},\n" +
            "{\"district\":\"武威\"},\n" +
            "{\"district\":\"张掖\"},\n" +
            "{\"district\":\"平凉\"},\n" +
            "{\"district\":\"酒泉\"},\n" +
            "{\"district\":\"庆阳\"},\n" +
            "{\"district\":\"定西\"},\n" +
            "{\"district\":\"陇南\"},\n" +
            "{\"district\":\"临夏\"},\n" +
            "{\"district\":\"甘南\"},\n" +
            "{\"district\":\"西宁\"},\n" +
            "{\"district\":\"海东\"},\n" +
            "{\"district\":\"海北\"},\n" +
            "{\"district\":\"黄南\"},\n" +
            "{\"district\":\"海南\"},\n" +
            "{\"district\":\"果洛\"},\n" +
            "{\"district\":\"玉树\"},\n" +
            "{\"district\":\"海西\"},\n" +
            "{\"district\":\"银川\"},\n" +
            "{\"district\":\"石嘴山\"},\n" +
            "{\"district\":\"吴忠\"},\n" +
            "{\"district\":\"固原\"},\n" +
            "{\"district\":\"中卫\"},\n" +
            "{\"district\":\"乌鲁木齐\"},\n" +
            "{\"district\":\"克拉玛依\"},\n" +
            "{\"district\":\"吐鲁番\"},\n" +
            "{\"district\":\"哈密\"},\n" +
            "{\"district\":\"昌吉\"},\n" +
            "{\"district\":\"博尔塔拉\"},\n" +
            "{\"district\":\"巴音郭楞\"},\n" +
            "{\"district\":\"阿克苏\"},\n" +
            "{\"district\":\"克孜勒苏\"},\n" +
            "{\"district\":\"喀什\"},\n" +
            "{\"district\":\"和田\"},\n" +
            "{\"district\":\"伊犁\"},\n" +
            "{\"district\":\"塔城\"},\n" +
            "{\"district\":\"阿勒泰\"},\n" +
            "{\"district\":\" \"},\n" +
            "{\"district\":\"台北\"},\n" +
            "{\"district\":\"高雄\"},\n" +
            "{\"district\":\"基隆\"},\n" +
            "{\"district\":\"台中\"},\n" +
            "{\"district\":\"台南\"},\n" +
            "{\"district\":\"新竹\"},\n" +
            "{\"district\":\"嘉义\"},\n" +
            "{\"district\":\"新北\"},\n" +
            "{\"district\":\"宜兰\"},\n" +
            "{\"district\":\"桃园\"},\n" +
            "{\"district\":\"新竹\"},\n" +
            "{\"district\":\"苗栗\"},\n" +
            "{\"district\":\"彰化\"},\n" +
            "{\"district\":\"南投\"},\n" +
            "{\"district\":\"云林\"},\n" +
            "{\"district\":\"嘉义\"},\n" +
            "{\"district\":\"屏东\"},\n" +
            "{\"district\":\"台东\"},\n" +
            "{\"district\":\"花莲\"},\n" +
            "{\"district\":\"澎湖\"},\n" +
            "{\"district\":\"金门\"},\n" +
            "{\"district\":\"连江\"},\n" +
            "{\"district\":\"香港岛\"},\n" +
            "{\"district\":\"九龙\"},\n" +
            "{\"district\":\"新界\"},\n" +
            "{\"district\":\"澳门半岛\"},\n" +
            "{\"district\":\"氹仔岛\"},\n" +
            "{\"district\":\"路环岛\"}\n" +
            "]";


}
