package com.example.a12579.citiclub.workspace;

import com.example.a12579.citiclub.R;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by 12579 on 2018/8/14.
 */

public class InitData {
    private List<String> typeList = new LinkedList<>();
    private List<Map<String,Object>> disignWorkList = new LinkedList<>();
    private List<Map<String,Object>> disignWorkEndList = new LinkedList<>();
    private List<Map<String,Object>> disignWorkRunList = new LinkedList<>();
    private List<Map<String,Object>> disignWorkCarList = new LinkedList<>();
    private List<Map<String,Object>> disignWorkFoodList = new LinkedList<>();
    private List<Map<String,Object>> disignWorkHomeList = new LinkedList<>();
    public List<Map<String, Object>> getDisignWorkList() {
        return disignWorkList;
    }

    public void setDisignWorkList(List<Map<String, Object>> disignWorkList) {
        this.disignWorkList = disignWorkList;
    }

    public InitData(){
        initDesignWork();
        initType();
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public List<Map<String, Object>> getDisignWorkEndList() {
        return disignWorkEndList;
    }

    public List<Map<String, Object>> getDisignWorkRunList() {
        return disignWorkRunList;
    }

    public List<Map<String, Object>> getDisignWorkCarList() {
        return disignWorkCarList;
    }

    public List<Map<String, Object>> getDisignWorkFoodList() {
        return disignWorkFoodList;
    }

    public List<Map<String, Object>> getDisignWorkHomeList() {
        return disignWorkHomeList;
    }

    private void initType() {
        typeList.add("全部");
        typeList.add("食品");
        typeList.add("汽车");
        typeList.add("家居");
    }

    private void initDesignWork(){
        Map<String,Object> map1 = new HashMap<>();
        map1.put("company","可口可乐公司");
        map1.put("title","可口可乐世界杯主题广告设计");
        map1.put("salary","30000");
        map1.put("stageNum","1");
        map1.put("stage","安全");
        map1.put("type","食品");
        map1.put("follow","9");
        map1.put("see","677");
        map1.put("time","5");
        map1.put("img", R.drawable.workspace_1);

        disignWorkList.add(map1);
        disignWorkHomeList.add(map1);
        disignWorkRunList.add(map1);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("company","东莞市邦泽电子有限公司");
        map2.put("title","真空封口机广告设计");
        map2.put("salary","35000");
        map2.put("stageNum","1");
        map2.put("stage","安全");
        map2.put("type","汽车");
        map2.put("follow","44");
        map2.put("see","2247");
        map2.put("time","14");
        map2.put("img", R.drawable.workspace_2);
        disignWorkList.add(map2);
        disignWorkRunList.add(map2);
        disignWorkCarList.add(map2);

        Map<String,Object> map3 = new HashMap<>();
        map3.put("company","学诚归来");
        map3.put("title","考研学习效率设计");
        map3.put("salary","10000");
        map3.put("stageNum","0");
        map3.put("bid","1");
        map3.put("stage","安全");
        map3.put("type","家居");
        map3.put("follow","39");
        map3.put("see","567");
        map3.put("time","0");
        map3.put("img", R.drawable.workspace_3);
        disignWorkList.add(map3);
        disignWorkEndList.add(map3);
        disignWorkHomeList.add(map3);

        Map<String,Object> map4 = new HashMap<>();
        map4.put("company","广东式家乐有限公司");
        map4.put("title","北京现代SUV广告");
        map4.put("salary","65000");
        map4.put("stageNum","0");
        map4.put("bid","1");
        map4.put("stage","安全");
        map4.put("type","汽车");
        map4.put("follow","26");
        map4.put("see","12247");
        map4.put("time","0");
        map4.put("img", R.drawable.workspace_2);

        disignWorkList.add(map4);
        disignWorkEndList.add(map4);
        disignWorkCarList.add(map4);

        Map<String,Object> map5 = new HashMap<>();
        map5.put("company","酒家乐有限公司");
        map5.put("title","虹猫药酒广告设计");
        map5.put("salary","8000");
        map5.put("stageNum","2");
        map5.put("stage","警告");
        map5.put("type","食品");
        map5.put("follow","69");
        map5.put("see","16877");
        map5.put("time","3");
        map5.put("img", R.drawable.workspace_5);

        disignWorkList.add(map5);
        disignWorkFoodList.add(map5);
        disignWorkRunList.add(map5);

        Map<String,Object> map6 = new HashMap<>();
        map6.put("company","粑家乐有限公司");
        map6.put("title","糟糠批发商宣传广告");
        map6.put("salary","35000");
        map6.put("stageNum","0");
        map6.put("bid","0");
        map6.put("stage","安全");
        map6.put("type","食品");
        map6.put("follow","14");
        map6.put("see","3247");
        map6.put("time","0");
        map6.put("img", R.drawable.workspace_4);

        disignWorkList.add(map6);
        disignWorkEndList.add(map6);
        disignWorkFoodList.add(map6);

        Map<String,Object> map7 = new HashMap<>();
        map7.put("company","鳍家乐有限公司");
        map7.put("title","海鲜饭店广告设计");
        map7.put("salary","8000");
        map7.put("stageNum","1");
        map7.put("stage","安全");
        map7.put("type","食品");
        map7.put("follow","9");
        map7.put("see","467");
        map7.put("time","25");
        map7.put("img", R.drawable.workspace_5);

        disignWorkList.add(map7);
        disignWorkFoodList.add(map7);
        disignWorkRunList.add(map7);

        Map<String,Object> map8 = new HashMap<>();
        map8.put("company","溜家乐有限公司");
        map8.put("title","一汽大众广告设计");
        map8.put("salary","65000");
        map8.put("stageNum","1");
        map8.put("stage","安全");
        map8.put("type","汽车");
        map8.put("follow","35");
        map8.put("see","22247");
        map8.put("time","15");
        map8.put("img", R.drawable.workspace_2);

        disignWorkList.add(map8);
        disignWorkRunList.add(map8);
        disignWorkCarList.add(map8);

        disignWorkEndList.add(map6);
        disignWorkEndList.add(map6);
        disignWorkEndList.add(map6);
        disignWorkEndList.add(map6);
        disignWorkEndList.add(map6);
    }

    public void orderByTuijian(List<Map<String,Object>>list){
        Collections.shuffle(list);
    }

    public void orderByFollow(List<Map<String,Object>>list){
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> stringObjectMap, Map<String, Object> t1) {
                int follow1 = Integer.parseInt(stringObjectMap.get("follow").toString());
                int follow2 = Integer.parseInt(t1.get("follow").toString());
                return follow2 - follow1;
            }
        });
    }

    public void orderBySee(List<Map<String,Object>>list){
        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> stringObjectMap, Map<String, Object> t1) {
                int see1 = Integer.parseInt(stringObjectMap.get("see").toString());
                int see2 = Integer.parseInt(t1.get("see").toString());
                return see2 - see1;
            }
        });
    }
}
