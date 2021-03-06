package com.mufan.custompackage.service;

import com.mufan.custompackage.entity.ShoppingCar;
import com.mufan.custompackage.entity.Trolley;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 14:09 2019/1/16
 * @ Description：购物车的业务层
 * % @author YuXingZh
 */
public interface ShoppingCarService {

    /**
     * @Description: 加入购物车
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    public void insertShoppingCar(List<Integer> partsId, int num, int userId);


    /**
     * @Description: 移除购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    public void removeShoppingCar(int shoppingCarId);

    /**
     * @Description: 变更购物车数量
     * @Param: shoppingCarId, num
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    public void editShoppingCar(ShoppingCar shoppingCar);

    /**
     * @Description: 查询当前用户的所有购物车 默认购物车
     * @Param: userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    public List<Trolley> getAll(int userId);

    /**
     * @Description: 切换购物车选中状态
     * @Param: userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Transactional
    void switchShoppingCar(int shoppingCarId, Boolean checked);

    /**
     * @Description: 增加或减少商品数量
     * @Param:
     * @return:
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Transactional
    void inAndOut(int shoppingCarId, int num);
}