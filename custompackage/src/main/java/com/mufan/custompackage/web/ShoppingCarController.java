package com.mufan.custompackage.web;

import com.mufan.custompackage.entity.ShoppingCar;
import com.mufan.custompackage.entity.Trolley;
import com.mufan.custompackage.service.ShoppingCarService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 19:49 2019/1/14
 * @ Description：购物车接口
 * % @author YuXingZh
 */
@RestController
@RequestMapping("shoppingCar")
public class ShoppingCarController {

    private static Logger logger = Logger.getLogger(ShoppingCarController.class);

    @Autowired
    private ShoppingCarService shoppingCarService;

    /**
     * @Description: 插入购物车
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("insert")
    public void insertShoppingCar(@RequestParam("partsId") List<Integer> partsId,
                                  @RequestParam("num") int num, @RequestParam("userId") int userId) {
        logger.info("加入购物车中");
        shoppingCarService.insertShoppingCar(partsId, num, userId);
        logger.info("加入购物车成功");
    }

    /**
     * @Description: 删除购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("remove")
    public void removeShoppingCar(@RequestParam("shoppingCarId") int shoppingCarId) {
        logger.info("从购物车移除id为 " + shoppingCarId + "的商品");
        shoppingCarService.removeShoppingCar(shoppingCarId);
        logger.info("从购物车移除" + shoppingCarId + "成功");
    }

    /**
     * @Description: 编辑购物车物品数量
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("edit")
    public void editShoppingCar(@RequestBody ShoppingCar shoppingCar) {
        logger.info("购物车中编辑 " + shoppingCar + "的商品");
        shoppingCarService.editShoppingCar(shoppingCar);
        logger.info("购物车中编辑 " + shoppingCar + "成功");
    }

    /**
     * @Description: 查询用户所有购物车 默认购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @RequestMapping("shoppingCars")
    public List<Trolley> getAll(@RequestParam("userId") int userId) {
        logger.info("取出所有购物车里的商品");
        List<Trolley> list = shoppingCarService.getAll(userId);
        logger.info("取出成功");
        return list;
    }

    /**
     * @Description: 选中购物车
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @RequestMapping("switch")
    public void switchShoppingCar(@RequestParam("shoppingCarId") int shoppingCarId,
                                  @RequestParam("checked") Boolean checked) {
        logger.info("切换购物车选中状态");
        shoppingCarService.switchShoppingCar(shoppingCarId, checked);
        logger.info("切换购物车选中状态成功");
    }

    /**
     * @Description: 增加或减少商品数量
     * @Param: shoppingCarId
     * @return: num
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @RequestMapping("inandout")
    public void inAndOut(@RequestParam("shoppingCarId") int shoppingCarId,
                                  @RequestParam("num") int num) {
        logger.info("增加或减少商品数量");
        shoppingCarService.inAndOut(shoppingCarId, num);
        logger.info("增加或减少商品数量成功");
    }
}
