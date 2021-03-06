package com.mufan.custompackage.service.impl;

import com.mufan.custompackage.dao.ShoppingCarMapper;
import com.mufan.custompackage.entity.ShoppingCar;
import com.mufan.custompackage.entity.Trolley;
import com.mufan.custompackage.service.ShoppingCarService;
import com.mufan.custompackage.util.EntityConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：zyx.
 * @ Date       ：Created in 16:45 2019/1/14
 * @ Description：购物车类service
 * % @author YuXingZh
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private ShoppingCarMapper shoppingCarMapper;


    /**
     * @Description: 加入购物车
     * @Param: shoppingCar
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void insertShoppingCar(List<Integer> partsId, int num, int userId) {
        ShoppingCar shoppingCar = new ShoppingCar();
        int goodId =
                shoppingCarMapper.getGoodId(EntityConversion.getGoodId(partsId));
        shoppingCar.setGoodsId(goodId);
        shoppingCar.setUserId(userId);
        shoppingCar.setNum(num);
        shoppingCar.setChecked(false);
        shoppingCarMapper.insertSelective(shoppingCar);
    }

    /**
     * @Description: 移除购物车
     * @Param: shoppingCarId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void removeShoppingCar(int shoppingCarId) {
        shoppingCarMapper.deleteByPrimaryKey(shoppingCarId);
    }

    /**
     * @Description: 变更购物车数量
     * @Param: shoppingCarId, num
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void editShoppingCar(ShoppingCar shoppingCar) {
        shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);
    }

    /**
     * @Description: 查询当前用户的所有购物车 默认购物车
     * @Param: userId
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public List<Trolley> getAll(int userId) {
        return shoppingCarMapper.getAll(userId);
    }

    /**
     * @Description: 切换购物车选中状态
     * @param: shoppingCarId, checked
     * @return: null
     * @Author: YuXingZh
     * @Date: 2019/1/14
     */
    @Override
    public void switchShoppingCar(int shoppingCarId, Boolean checked) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setChecked(checked);
        shoppingCar.setId(shoppingCarId);
        shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);
    }

    /**
     * @Description: 增加或减少商品数量
     * @param shoppingCarId
     * @param num
     * @Author: YuXingZh
     * @Date: 2019/1/18
     */
    @Override
    public void inAndOut(int shoppingCarId, int num) {
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setNum(num);
        shoppingCar.setId(shoppingCarId);
        shoppingCarMapper.updateByPrimaryKeySelective(shoppingCar);
    }
}
