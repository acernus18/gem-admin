package org.maples.gem.admin.utility;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ConstUtils {
    public static String[] get(String key) {
        Map<String, String[]> configuration = new HashMap<>();
        configuration.put("红宝石", new String[]{"A红宝石", "A红色"});
        configuration.put("蓝宝石", new String[]{"C蓝宝石", "B蓝色"});
        configuration.put("无烧鸽血", new String[]{"d无烧鸽血红", "AA鸽血红"});
        configuration.put("无烧鸽血主证", new String[]{"d无烧鸽血红", "AA鸽血红"});
        configuration.put("无烧主证鸽血", new String[]{"d无烧鸽血红", "AA鸽血红"});
        configuration.put("斯里兰卡蓝宝石", new String[]{"B斯里兰卡蓝宝石", "B蓝色"});
        configuration.put("皇家蓝", new String[]{"EE有烧皇家蓝", "bb皇家蓝"});
        configuration.put("无烧皇家蓝", new String[]{"E无烧皇家蓝", "bb皇家蓝"});
        configuration.put("矢车菊", new String[]{"FF有烧矢车菊", "b矢车菊"});
        configuration.put("无烧矢车菊", new String[]{"F无烧矢车菊", "b矢车菊"});
        configuration.put("无烧蓝宝", new String[]{"G无烧蓝宝石", "B蓝色"});
        configuration.put("无烧粉蓝", new String[]{"H无烧粉红蓝宝石", "E粉色"});
        configuration.put("无烧艳粉", new String[]{"H无烧粉红蓝宝石", "EE艳粉色"});
        configuration.put("无烧热粉", new String[]{"H无烧粉红蓝宝石", "E热粉色"});
        configuration.put("无烧紫色", new String[]{"II无烧紫色蓝宝石", "F紫色"});
        configuration.put("无烧紫罗兰", new String[]{"II无烧紫色蓝宝石", "F紫色"});
        configuration.put("无烧薰衣草", new String[]{"II无烧紫色蓝宝石", "F紫色"});
        configuration.put("无烧艳紫", new String[]{"II无烧紫色蓝宝石", "FF艳紫色"});
        configuration.put("无烧黄色", new String[]{"I无烧黄色蓝宝石", "H黄色"});
        configuration.put("无烧金黄", new String[]{"I无烧黄色蓝宝石", "H黄色"});
        configuration.put("无烧艳黄", new String[]{"I无烧黄色蓝宝石", "HH艳黄色"});
        configuration.put("无烧帕帕", new String[]{"J无烧帕帕拉恰蓝宝石", "G帕帕拉恰"});
        configuration.put("无烧红宝", new String[]{"k无烧红宝石", "A红色"});
        configuration.put("鸽血红", new String[]{"l有烧鸽血红", "AA鸽血红"});
        configuration.put("祖母绿", new String[]{"M祖母绿", "C绿色"});
        configuration.put("无油祖母绿", new String[]{"N无油祖母绿", "C绿色"});
        configuration.put("哥伦比亚祖母绿", new String[]{"O哥伦比亚祖母绿", "C绿色"});
        configuration.put("帕帕拉恰", new String[]{"P帕帕拉恰蓝宝石", "G帕帕拉恰"});
        configuration.put("紫色蓝宝石", new String[]{"QQ紫色蓝宝石", "F紫色"});
        configuration.put("艳紫蓝宝石", new String[]{"QQ紫色蓝宝石", "FF艳紫色"});
        configuration.put("粉蓝", new String[]{"Q粉红蓝宝石", "E粉色"});
        configuration.put("艳粉", new String[]{"Q粉红蓝宝石", "EE艳粉色"});
        configuration.put("热粉", new String[]{"Q粉红蓝宝石", "E热粉色"});
        configuration.put("山东蓝宝", new String[]{"T山东蓝宝石", "B蓝色"});
        configuration.put("泰国蓝宝", new String[]{"U泰国蓝宝石", "B蓝色"});
        configuration.put("金绿猫眼", new String[]{"V猫眼", "D黄绿色"});
        configuration.put("金绿宝石", new String[]{"XX金绿宝石", "D黄绿色"});
        configuration.put("亚历山大变石", new String[]{"X亚历山大变石", "D黄绿色"});
        configuration.put("星光红宝石", new String[]{"Y星光红宝石", "A红色"});
        configuration.put("星光蓝宝石", new String[]{"Z星光蓝宝石", "B蓝色"});
        configuration.put("无烧橙色", new String[]{"Z无烧橙色蓝宝石", "n橙色"});
        configuration.put("无烧变色蓝宝石", new String[]{"无烧变色蓝宝石", "B蓝色"});
        configuration.put("成品镶嵌", new String[]{"C成品镶嵌", "k白色"});
        configuration.put("代销裸石", new String[]{"D代销裸石", "k白色"});
        configuration.put("代镶嵌加工费", new String[]{"J代镶嵌加工费", "k白色"});

        String[] result = new String[] {"", ""};
        configuration.forEach((k, v) -> {
            // if (key.contains(k)) {
            if (key.equals(k)) {
                result[0] = v[0];
                result[1] = v[1];
            }
        });

        return result;
    }
}
