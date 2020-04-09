package org.academiadecodigo.hackaton.View;

import java.util.ArrayList;
import java.util.List;

public class ColorPallete {

   private List<Integer> list;

   ColorPallete(){
      list = new ArrayList<>();
      list.add(0xAA3939);
      list.add(0x9B344E);
      list.add(0x933157);
      list.add(0x8E2F5C);
      list.add(0x852C64);
      list.add(0x7E2A69);
      list.add(0x72266E);
      list.add(0x612871);
      list.add(0x5B2972);
      list.add(0x532B73);
      list.add(0x4C2D74);
      list.add(0x4A2E74);
      list.add(0x442F75);
      list.add(0x3F3176);
      list.add(0x393277);
      list.add(0x333677);
      list.add(0x303D75);
      list.add(0x2E4373);
      list.add(0x2B4B70);
      list.add(0x29526D);
      list.add(0x255F69);
      list.add(0x256E5E);
      list.add(0x287751);
      list.add(0x2A7D46);
      list.add(0x338B2E);
      list.add(0x519431);
      list.add(0x5E9832);
      list.add(0x6D9C34);
      list.add(0x769E34);
      list.add(0x82A136);
      list.add(0x88A336);
      list.add(0x95A637);
      list.add(0xA0A938);
      list.add(0xA6AA38);
      list.add(0xABA939);
      list.add(0xABA439);
      list.add(0xABA039);
      list.add(0xAB9A39);
      list.add(0xAB9539);
      list.add(0xAB9339);
      list.add(0xAB8D39);
      list.add(0xAB8A39);
      list.add(0xAB8339);
      list.add(0xAB7A39);
      list.add(0xAB7239);
      list.add(0xAB6C39);
      list.add(0xAB6139);
      list.add(0xAB5339);
      list.add(0xAB4639);
   }

   public Integer getRandomColor(){
      int random = (int) (Math.random()*list.size());
      return list.get(random);
    }
}
