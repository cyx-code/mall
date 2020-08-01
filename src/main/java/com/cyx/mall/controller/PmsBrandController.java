package com.cyx.mall.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyx.mall.common.constants.CommonConstants;
import com.cyx.mall.common.utils.CommonPage;
import com.cyx.mall.common.utils.R;
import com.cyx.mall.entity.PmsBrand;
import com.cyx.mall.service.IPmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 品牌表 前端控制器
 * </p>
 *
 * @author cyx
 * @since 2020-07-30
 */
@Api(tags = "PmsBrandController", description = "品牌接口")
@RestController
@RequestMapping("/mall/brand")
public class PmsBrandController {
    @Autowired
    private IPmsBrandService brandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    /**
     * @Author: cyx
     * @Description: 查询品牌数据，分页可选
     * @Date: 2020-07-31
     * @param: page
     * @return: com.cyx.mall.common.utils.R
     */
    @ApiOperation(value = "品牌列表查询")
    @GetMapping("list")
    public R list(CommonPage page) {
        long current = page.getPageNum() == null ? CommonConstants.DEFAULT_PAGE_CURRENT : page.getPageNum();
        long size = page.getLimit() == null ? CommonConstants.DEFAULT_PAGE_SIZE : page.getLimit();
        IPage<PmsBrand> pageInfo = new Page<>(current, size);
        IPage<PmsBrand> pmsBrandIPage = brandService.page(pageInfo);
        return R.success(pmsBrandIPage);
    }

    /**
     * @Author: cyx
     * @Description: 查询单个品牌数据
     * @Date: 2020-07-31
     * @param: page
     * @return: com.cyx.mall.common.utils.R
     */
    @ApiOperation(value = "根据主键查询")
    @GetMapping("/{id}")
    public R getById(@PathVariable Long id) {
        LambdaQueryWrapper<PmsBrand> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(PmsBrand::getId, id);
        PmsBrand brand = brandService.getOne(wrapper);
        return R.success(brand);
    }

    /**
     * @Author: cyx
     * @Description: 创建一个新的品牌
     * @Date: 2020-07-31
     * @param: pmsBrand
     * @return: com.cyx.mall.common.utils.R
     */
    @ApiOperation("添加品牌")
    @PostMapping
    public R insert(@RequestBody PmsBrand pmsBrand) {
        boolean success = brandService.save(pmsBrand);
        if (success) {
            LOGGER.info("创建产品信息成功：{}", pmsBrand);
            return R.success();
        } else {
            LOGGER.info("创建产品信息失败：{}", pmsBrand);
            return R.error();
        }
    }

    /**
     * @Author: cyx
     * @Description: 修改品牌信息
     * @Date: 2020-07-31
     * @param: pmsBrand
     * @return: com.cyx.mall.common.utils.R
     */
    @ApiOperation("修改品牌信息")
    @PutMapping
    public R update(@RequestBody PmsBrand pmsBrand) {
        boolean success = brandService.updateById(pmsBrand);
        if (success) {
            LOGGER.info("修改产品信息成功：{}", pmsBrand);
            return R.success();
        } else {
            LOGGER.info("修改产品信息失败：{}", pmsBrand);
            return R.error();
        }
    }

    /**
     * @Author: cyx
     * @Description: 删除产品信息
     * @Date: 2020-07-31
     * @param: id
     * @return: com.cyx.mall.common.utils.R
     */
    @ApiOperation("删除一条产品信息")
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Long id) {
        boolean success = brandService.removeById(id);
        if (success) {
            LOGGER.info("删除产品信息成功，id={}", id);
            return R.success();
        } else {
            LOGGER.info("删除产品信息失败，id={}", id);
            return R.error();
        }
    }
}
